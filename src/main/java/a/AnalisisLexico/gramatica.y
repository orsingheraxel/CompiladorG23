%{
package a.AnalisisLexico;
import a.AnalisisLexico.ParserVal;
import b.GeneracionCodigoIntermedio.*;
import a.AnalisisLexico.AccionesSemanticas.AccionSemantica;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
%}

%token IF ELSE END_IF PRINT CLASS VOID DO UNTIL IMPL INT USHORT DOUBLE ID IGUAL DIST MENORIGUAL MAYORIGUAL ASIG RETURN TOD CADENA ENTERO ENTEROCORTO PUNTOFLOTANTE FOR CTE

%start Programa

%%
Programa: '{' ListSentencias  '}' { for (String c : clases_forward_declaration){
                                        if (!(clases_declaradas.contains(c))){
                                            agregarErrorSemantico("La clase "+c+" fue declarada, pero no fue implementada");
                                        }
                                    }
                                    raiz = new NodoControl("PROGRAMA", (Nodo)$2.obj);
                                    AnalizadorLexico.agregarEstructura("Reconoce programa ");}
        //| '{'ListSentencias error {AnalizadorLexico.agregarErrorSintactico("Se espera '}' ");}
	    | error ListSentencias '}' {AnalizadorLexico.agregarErrorSintactico("Se espera '{' ");}
        ;

ListSentencias:  ListSentencias Sentencia ',' {$$.obj = new NodoComun("SENTENCIA", (Nodo) $1.obj, (Nodo) $2.obj);}
        | Sentencia ',' {$$.obj=$1.obj;}
	| Sentencia error {AnalizadorLexico.agregarErrorSintactico("Se esperaba una ',' ");}
        ;

Sentencia: SentenciaDeclarativa
        | SentenciaEjecutable {$$.obj=$1.obj;}
        | RETURN ',' {AnalizadorLexico.agregarErrorSintactico("RETURN definido fuera de funcion ");}
        ;

ReferenciaObjeto: ID '.' ID {TablaSimbolos.removeToken($1.sval);
                            TablaSimbolos.removeToken($3.sval);

                            String nombreClase = null;
                            String lexemaAtributoHijo = null;

                            Token clase = obtenerClase($1.sval + ":" + ambitoAct);
                            if (clase!=null){
                                if (clase.getUso().equals("Variable"))
                                    nombreClase = clase.getLexema().substring(clase.getLexema().lastIndexOf(":")+1);
                                else
                                    nombreClase = clase.getLexema().substring(0,clase.getLexema().indexOf(":"));
                                lexemaAtributoHijo = $3.sval + ":" + ambitoAct + ":"+ nombreClase;
                            }

                            Token atributoPadre = null;

                            if (padreTieneAtributo(nombreClase,lexemaAtributoHijo)){
                                 String clasePadre =  clase_hijo_padre.get(nombreClase);
                                String lexemaAtributoPadre = $3.sval + ":" + ambitoAct + ":"+ clasePadre;
                                atributoPadre = TablaSimbolos.getToken(lexemaAtributoPadre);
                            }

                            Token atributo = TablaSimbolos.getToken(lexemaAtributoHijo);
                            if (clase == null) {
                                agregarErrorSemantico("El objeto " + $1.sval + " no existe");
                            }
                            else {
                                if ((atributo == null) && (atributoPadre == null)){
                                    agregarErrorSemantico("Atributo de clase no existe");
                                }
                            }
                            Nodo a = new NodoHoja($3.sval);
                            if (atributo != null)
                                a.setTipo(atributo.getTipo());
                            if (atributoPadre != null)
                                a.setTipo(atributoPadre.getTipo());
                            $$.obj = new NodoComun("REFERENCIA ATRIBUTO OBJETO",new NodoHoja($1.sval), a);
                            AnalizadorLexico.agregarEstructura("Reconoce llamado a atributo");
                            }
                ;

ReferenciaObjetoFuncion: ID '.' LlamadoFuncion { Nodo n = ((Nodo)$3.obj).getDer();
                                                String nombreFuncion = n.getLexema();

                                                String nombreClase = null;
                                                String clasePadre = null;

                                                Token clase = obtenerClase($1.sval + ":" + ambitoAct);
                                                if (clase!=null){
                                                    if (clase.getUso().equals("Variable"))
                                                        nombreClase = clase.getLexema().substring(clase.getLexema().lastIndexOf(":")+1);
                                                    else
                                                        nombreClase = clase.getLexema().substring(0,clase.getLexema().indexOf(":"));
                                                    clasePadre = clase_hijo_padre.get(nombreClase);
                                                }

                                                if ((tieneFuncion(nombreClase,nombreFuncion))||(tieneFuncion(clasePadre,nombreFuncion))){

                                                    if ((TablaSimbolos.getToken($1.sval +":"+ambitoAct))==null)
                                                        agregarErrorSemantico("Atributo de clase " + $1.sval + " no existe ");
                                                    else{
                                                        String m = (String)$1.sval;
                                                        Nodo a = new NodoHoja(m);
                                                        $$.obj = new NodoComun("REFERENCIA FUNCION OBJETO",a,(Nodo)$3.obj);
                                                        AnalizadorLexico.agregarEstructura("Reconoce llamado a funcion de clase ");
                                                    }
                                                }else{agregarErrorSemantico("La funcion no esta al alcance ");}
                                                TablaSimbolos.removeToken($1.sval);
                                                }
                       ;

SentenciaEjecutable: Asignacion {$$.obj=$1.obj;}
                  | LlamadoFuncion {$$.obj=$1.obj;}
                  | BloqueIF   {$$.obj=$1.obj;}
		          | SalidaMensaje {$$.obj=$1.obj;}
                  | ReferenciaObjetoFuncion {$$.obj=$1.obj;}
                  | SentenciaControl {$$.obj=$1.obj;}
                  ;

ListSentenciasClase : ListSentenciasClase SentenciaDeclarativa ','
                   | SentenciaDeclarativa ','
                   | RETURN ',' {AnalizadorLexico.agregarErrorSintactico("RETURN definido fuera de funcion ");}
                   | ListSentenciasClase  RETURN ',' {AnalizadorLexico.agregarErrorSintactico("RETURN definido fuera de funcion ");}
                    ;

SentenciaDeclarativa: Tipo ListVariables {
						for (String var : variables_declaradas) {
							Token t = TablaSimbolos.getToken(var);
							if (!(TablaSimbolos.existeSimbolo(var+ ":" + ambitoAct))){
							    t.setLexema(var + ":" + ambitoAct);
							    t.setAmbito(ambitoAct);
							    t.setUso("Variable");
							    t.setTipo(tipoActual);
							    TablaSimbolos.removeToken(var);
							    TablaSimbolos.addSimbolo(t.getLexema(),t);
							    comprobacion_uso_variables.put(t.getLexema(),false);
							    if (claseAct != null){
							        listaAtributos.add(var);
                                    atributosClases.put(claseAct, listaAtributos);
							    }
                            }
							else {
							    TablaSimbolos.removeToken(var);
							   agregarErrorSemantico("Ya existe una variable " + var +" definida en este ambito");
                                                	}
                                            	}
                                            	variables_declaradas.clear();
                        }
			| ListFuncion
			| error ListVariables{AnalizadorLexico.agregarErrorSintactico("Se espera el tipo de la variable ");}
			| Tipo error {AnalizadorLexico.agregarErrorSintactico("Se espera identificador de la variable ");}
			| Clase
			| Objeto_clase
			| FuncionIMPL
			| EncabezadoClase{deshacerAmbito();}
            ;

	ListVariables : ID {variables_declaradas.add($1.sval);}
		      | ListVariables ';' ID   {variables_declaradas.add($3.sval);}
		      ;

Objeto_clase: ID ListVariablesObj {TablaSimbolos.removeToken($1.sval);
                                   if (clases_declaradas.contains($1.sval + ":" + ambitoAct)){
                                        for (String var : variables_declaradas) {
                                        Token t = TablaSimbolos.getToken(var);
                                        if (!(TablaSimbolos.existeSimbolo(var+ ":" + ambitoAct))){
                                            t.setLexema(var + ":" + ambitoAct);
                                            t.setAmbito(ambitoAct);
                                            t.setUso("Objeto");
                                            t.setTipo($1.sval);
                                            TablaSimbolos.removeToken(var);
                                            TablaSimbolos.addSimbolo(t.getLexema(),t);
                                        }
                                        else {
                                            agregarErrorSemantico("Ya existe un objeto + var + definido en este ambito ");
                                        }
                                        }
                                        variables_declaradas.clear();
                                   }else{agregarErrorSemantico("La clase "+ $1.sval +" no esta definida ");}
                                   }
    ;

ListVariablesObj: ID {variables_declaradas.add($1.sval);}
                | ListVariablesObj ';' ID {variables_declaradas.add($3.sval);}

Tipo : USHORT {tipoActual = $1.sval;}
     | INT {tipoActual = $1.sval;}
     | DOUBLE {tipoActual = $1.sval;}
     ;

Constante: ENTERO  {
                    chequearEnteroPositivo($1.sval);
                    NodoHoja aux = new NodoHoja($1.sval);
                    aux.setTipo("INT");
                    aux.setUso("Constante");
                    aux.setAmbito(ambitoAct);
                    $$.obj = aux;
                    Token t = TablaSimbolos.getToken($1.sval);
                    if (!(t==null)){
                        t.setTipo("INT");
                        t.setUso("Constante");
                        t.setAmbito(ambitoAct);
                        TablaSimbolos.removeToken($1.sval);
                        TablaSimbolos.addSimbolo($1.sval,t);
                    }
                   }

	| ENTEROCORTO {NodoHoja aux = new NodoHoja($1.sval);
	               chequearEnteroCorto($1.sval);
	               aux.setTipo("USHORT");
                   aux.setUso("Constante");
                   aux.setAmbito(ambitoAct);
                   $$.obj = aux;
                   Token t = TablaSimbolos.getToken($1.sval);
                   if (t!=null) {
                    t.setTipo("USHORT");
                    t.setUso("Constante");
                    t.setAmbito(ambitoAct);
                    TablaSimbolos.removeToken($1.sval);
                    TablaSimbolos.addSimbolo($1.sval,t);
                   }
                   }
	| '-' ENTEROCORTO {AnalizadorLexico.agregarErrorLexico("Un entero corto no puede ser negativo ");}
	| PUNTOFLOTANTE{
	                chequearDouble($1.sval);
	                NodoHoja aux = new NodoHoja($1.sval);
                    aux.setTipo("DOUBLE");
                    aux.setUso("Constante");
                    aux.setAmbito(ambitoAct);
                    $$.obj = aux;
                    Token t = TablaSimbolos.getToken($1.sval);
                    if (!(t==null)){
                        t.setTipo("DOUBLE");
                        t.setUso("Constante");
                        t.setAmbito(ambitoAct);
                        TablaSimbolos.removeToken($1.sval);
                        TablaSimbolos.addSimbolo($1.sval,t);
                    }
                    }

	| '-' ENTERO    {
                    chequearEnteroNegativo($2.sval);
                    NodoHoja aux = new NodoHoja($2.sval);
                    aux.setTipo("INT");
                    aux.setUso("Constante");
                    aux.setAmbito(ambitoAct);
                    $$.obj = aux;
                    Token t = TablaSimbolos.getToken($2.sval);
                    if (!(t==null)){
                        t.setTipo("INT");
                        t.setUso("Constante");
                        t.setAmbito(ambitoAct);
                        TablaSimbolos.removeToken($2.sval);
                        TablaSimbolos.addSimbolo($2.sval,t);
                    }
	                }
	| '-' PUNTOFLOTANTE {chequearDouble($2.sval);
                         NodoHoja aux = new NodoHoja($2.sval);
                         aux.setTipo("DOUBLE");
                         aux.setUso("Constante");
                         aux.setAmbito(ambitoAct);
                         $$.obj = aux;
                         Token t = TablaSimbolos.getToken($2.sval);
                         if (!(t==null)){
                             t.setTipo("DOUBLE");
                             t.setUso("Constante");
                             t.setAmbito(ambitoAct);
                             TablaSimbolos.removeToken($2.sval);
                             TablaSimbolos.addSimbolo($2.sval,t);
                         }
                        }
	;

Expresion: Expresion'+'Termino {$$.obj = controlarTipos((Nodo)$1.obj,$2.sval,(Nodo)$3.obj);}
| Expresion'-'Termino {$$.obj = controlarTipos((Nodo)$1.obj,$2.sval,(Nodo)$3.obj);}
| Termino {$$.obj=$1.obj;}
| ConversionExplicita {$$.obj=$1.obj;} //PASAR A DOUBLE Y ASIGNAR EL VALUE
        ;


Termino: Termino '*' Factor   {$$.obj = controlarTipos((Nodo)$1.obj,$2.sval,(Nodo)$3.obj);}

| Termino'/'Factor {$$.obj = controlarTipos((Nodo)$1.obj,$2.sval,(Nodo)$3.obj);}
| Factor {$$.obj = $1.obj;}
| Termino'*' Factor_RefObjeto {$$.obj = controlarTipos((Nodo)$1.obj,$2.sval,(Nodo)$3.obj);}
| Termino'/' Factor_RefObjeto {$$.obj = controlarTipos((Nodo)$1.obj,$2.sval,(Nodo)$3.obj);}
| Factor_RefObjeto {$$.obj=$1.obj;}
;

Factor: ID {Nodo aux = new NodoHoja ((String)$1.sval);
            TablaSimbolos.removeToken($1.sval);
            String var = $1.sval + ":" + ambitoAct;
            var = getLexemaAlcance(var);
            if (var.equals($1.sval)){
                agregarErrorSemantico("Variable no declarada en este ambito ");
            }
            else {
                if((!TablaSimbolos.getUso(var).equals("Variable")) && (!TablaSimbolos.getUso(var).equals("Parametro"))){
                    agregarErrorSemantico("El ID en uso no es una variable ");
                }
                else {
                    aux.setTipo(TablaSimbolos.getTipo(var));
                    aux.setUso(TablaSimbolos.getUso(var));
                    aux.setAmbito(TablaSimbolos.getAmbito(var));
                }
            }
            $$.obj = aux;
          }
	| Constante {$$.obj=$1.obj;}
	;


Factor_RefObjeto: ReferenciaObjeto {$$.obj=$1.obj;}
                ;

Condicion : '(' Expresion Comparador Expresion ')' {$$.obj = controlarTipos((Nodo)$2.obj,$3.sval,(Nodo)$4.obj);}
            | '(' Expresion Comparador Expresion error {AnalizadorLexico.agregarErrorSintactico("Se esperaba una ')' ");}
            | error Expresion Comparador Expresion ')' {AnalizadorLexico.agregarErrorSintactico("Se esperaba una '(' ");}
	  ;

BloqueIF: IF Condicion CuerpoIF ELSE CuerpoIF END_IF {  $$.obj = new NodoComun("CUERPO",(Nodo)$3.obj,(Nodo)$5.obj);
                                                        Nodo aux = (Nodo)$$.obj;
                                                        $$.obj = new NodoComun("IF",(Nodo)$2.obj,aux);
                                                        AnalizadorLexico.agregarEstructura("Reconoce IF ELSE");}
	    | IF Condicion CuerpoIF END_IF {$$.obj = new NodoComun("IF",(Nodo)$2.obj,(Nodo)$3.obj);
	                                    AnalizadorLexico.agregarEstructura("Reconoce IF");}
	    |IF Condicion SentenciaEjecutable ',' END_IF {  $$.obj = new NodoComun("IF",(Nodo)$2.obj,(Nodo)$3.obj);
         	                                            AnalizadorLexico.agregarEstructura("Reconoce IF");}
        | IF Condicion SentenciaEjecutable ',' ELSE CuerpoIF END_IF {   $$.obj = new NodoComun("CUERPO",(Nodo)$3.obj,(Nodo)$6.obj);
                                                                        Nodo aux = (Nodo)$$.obj;
                                                                        $$.obj = new NodoComun("IF",(Nodo)$2.obj,aux);
                                                                        AnalizadorLexico.agregarEstructura("Reconoce IF ELSE");}
        | IF Condicion SentenciaEjecutable ',' ELSE SentenciaEjecutable ',' END_IF {$$.obj = new NodoComun("CUERPO",(Nodo)$3.obj,(Nodo)$6.obj);
                                                                                    Nodo aux = (Nodo)$$.obj;
                                                                                    $$.obj = new NodoComun("IF",(Nodo)$2.obj,aux);
                                                                                    AnalizadorLexico.agregarEstructura("Reconoce IF ELSE");}
        | IF Condicion CuerpoIF ELSE SentenciaEjecutable ',' END_IF {   $$.obj = new NodoComun("CUERPO",(Nodo)$3.obj,(Nodo)$5.obj);
                                                                        Nodo aux = (Nodo)$$.obj;
                                                                        $$.obj = new NodoComun("IF",(Nodo)$2.obj,aux);
                                                                        AnalizadorLexico.agregarEstructura("Reconoce IF ELSE");}



	    | IF Condicion CuerpoIF error {AnalizadorLexico.agregarErrorSintactico("IF mal definido ");}
	    | IF Condicion CuerpoIF ELSE CuerpoIF error   {AnalizadorLexico.agregarErrorSintactico("Se esperaba un END_IF ");}
        | IF Condicion SentenciaEjecutable ',' ELSE CuerpoIF error {AnalizadorLexico.agregarErrorSintactico("Se esperaba un END_IF ");}
        | IF Condicion SentenciaEjecutable ',' ELSE SentenciaEjecutable error {AnalizadorLexico.agregarErrorSintactico("Se esperaba un END_IF ");}
        | IF Condicion CuerpoIF ELSE SentenciaEjecutable ',' error {AnalizadorLexico.agregarErrorSintactico("Se esperaba un END_IF ");}
        | IF Condicion SentenciaEjecutable ',' error CuerpoIF END_IF {AnalizadorLexico.agregarErrorSintactico("Se esperaba un ELSE ");}
        | IF Condicion SentenciaEjecutable ',' error SentenciaEjecutable END_IF {AnalizadorLexico.agregarErrorSintactico("Se esperaba un ELSE");}
        | IF Condicion SentenciaEjecutable error ELSE  CuerpoIF END_IF {AnalizadorLexico.agregarErrorSintactico("Se esperaba una ',' ");}
        | IF Condicion CuerpoIF ELSE SentenciaEjecutable error END_IF {AnalizadorLexico.agregarErrorSintactico("Se esperaba una ',' " );}
        | IF Condicion SentenciaEjecutable error END_IF {AnalizadorLexico.agregarErrorSintactico("Se esperaba una ',' ");}
        ;

CuerpoIF: '{' SentenciasIF '}' {$$.obj = $2.obj;}
        | '{' SentenciasIF RETURN ',' '}' {$$.obj = $2.obj;}
        //| '{' RETURN SentenciasIF ',' '}' {AnalizadorLexico.addWarning("Las sentencias declaradas luego del RETURN no seran ejecutadas "); }
        | '{' SentenciasIF RETURN error '}' {AnalizadorLexico.agregarErrorSintactico("Falta una ',' "); }
        | error SentenciasIF '}' {AnalizadorLexico.agregarErrorSintactico("Falta un '{'"); }
		|'{' SentenciasIF error {AnalizadorLexico.agregarErrorSintactico("Falta un '}'"); }
        | '{' '}' {AnalizadorLexico.agregarErrorSintactico("No hay sentencias dentro de las llaves."); }
        ;

SentenciasIF: ListaSentenciasIF {$$.obj=$1.obj;}
                ;

ListaSentenciasIF: error {AnalizadorLexico.agregarErrorSintactico("Solo se aceptan sentencias ejecutables "); }
               | SentenciaEjecutable ',' {$$.obj=$1.obj;}
               | SentenciaEjecutable error {AnalizadorLexico.agregarErrorSintactico("Falta una ',' "); }
               | ListaSentenciasIF SentenciaEjecutable ',' {$$.obj = new NodoComun("SENTENCIA", (Nodo) $1.obj, (Nodo) $2.obj);}
               ;

Comparador: '<' {$$.sval=$1.sval;}
          | '>' {$$.sval=$1.sval;}
          | MAYORIGUAL {$$.sval=$1.sval;}
          | MENORIGUAL {$$.sval=$1.sval;}
          | IGUAL {$$.sval=$1.sval;}
          | DIST {$$.sval=$1.sval;}
          ;

ListFuncion: Funcion
	| FuncionSinCuerpo
	;

Funcion:  EncabezadoFuncion Parametro '{' ListSentenciasFuncion '}' RETURN ',' {agregarErrorSemantico("RETURN fuera de funcion");}
      | EncabezadoFuncion Parametro '{' ListSentenciasFuncion RETURN ',' '}' {  $$.obj = (Nodo)$1.obj;
                                                                                String nombreFuncion=((Nodo)$1.obj).getLexema();
                                                                                if (claseAct!=null)
                                                                                    listaFunciones.add(nombreFuncion);
                                                                                deshacerAmbito();
                                                                                Nodo aux = new NodoComun("Funcion",(Nodo)$1.obj,(Nodo)$4.obj);
                                                                                funciones.add(aux);
                                                                                AnalizadorLexico.agregarEstructura("Reconoce declaracion de funcion ");}
      | EncabezadoFuncion Parametro '{' ListSentenciasFuncion '}' { $$.obj = (Nodo)$1.obj;
                                                                    String nombreFuncion=((Nodo)$1.obj).getLexema();
                                                                    if (claseAct!=null)
                                                                        listaFunciones.add(nombreFuncion);
                                                                    deshacerAmbito();
                                                                    Nodo aux = new NodoComun("Funcion",(Nodo)$1.obj,(Nodo)$4.obj);
                                                                    funciones.add(aux);
                                                                    AnalizadorLexico.agregarEstructura("Reconoce declaracion de funcion ");}
      | VOID error Parametro '{' ListSentenciasFuncion '}' {AnalizadorLexico.agregarErrorSintactico("Se esperaba un nombre para la funcion ");}
      ;

EncabezadoFuncion : VOID ID  {
			      Token t = TablaSimbolos.getToken($2.sval);
                              if (t != null){
                                    t.setLexema($2.sval + ":" + ambitoAct);
                                    t.setAmbito(ambitoAct);
                                    t.setUso("Funcion");
                                    t.setTipo("VOID");
                                    TablaSimbolos.removeToken($2.sval);
                                    TablaSimbolos.addSimbolo(t.getLexema(),t);
                              }
			      Funcion f = new Funcion($2.sval + ":" + ambitoAct, null);
			      funciones_declaradas.add(f);
			      actualizarAmbito($2.sval);
                  $$.obj = new NodoHoja($2.sval);
                  }
                  ;


Parametro: '(' Tipo ID ')' {    Token t = TablaSimbolos.getToken($3.sval);
                                if (t != null){
                                	t.setLexema($3.sval + ":" + ambitoAct);
                                	t.setAmbito(ambitoAct);
                                	t.setUso("Parametro");
                                	t.setTipo(tipoActual);
                                	TablaSimbolos.removeToken($3.sval);
                                	TablaSimbolos.addSimbolo(t.getLexema(),t);
                                }
                                funciones_declaradas.get(funciones_declaradas.size() - 1).setParametro(t);
                                NodoHoja aux = new NodoHoja($3.sval);
                                aux.setAmbito(ambitoAct);
                                aux.setTipo(tipoActual);
                                aux.setUso("Parametro");
                                parametros.add(aux);
                                $$.obj = aux;
                           }
        | '(' Tipo ID error {AnalizadorLexico.agregarErrorSintactico("Se esperaba un ')' ");}
        |  error Tipo ID ')' {AnalizadorLexico.agregarErrorSintactico("Se esperaba un '(' ");}
        | '(' ')' {$$.obj = null;}
        | '(' error {AnalizadorLexico.agregarErrorSintactico("Se esperaba un ')' ");}
        | error ')' {AnalizadorLexico.agregarErrorSintactico("Se esperaba un '(' ");}
        ;




ListSentenciasFuncion:ListSentenciasFuncion Sentencia ',' {$$.obj = new NodoComun("SENTENCIA",(Nodo)$1.obj,(Nodo)$2.obj);}
		  | Sentencia ',' {$$.obj=$1.obj;}
		  | SentenciaEjecutable error {AnalizadorLexico.agregarErrorSintactico("Se esperaba una ',' al final de la linea ");}
          	  | SentenciaDeclarativa error {AnalizadorLexico.agregarErrorSintactico("Se esperaba una ',' al final de la linea ");}
          	  | RETURN error {AnalizadorLexico.agregarErrorSintactico("Se esperaba una ',' al final de la linea ");}
          ;

LlamadoFuncion: ID '(' ')' {$$.obj=new NodoControl("LLAMADO FUNCION", new NodoHoja($1.sval));
                            Token tokenFuncion = TablaSimbolos.buscarPorAmbito($1.sval + ":" + ambitoAct);

                            String aux = $1.sval+":"+ambitoAct;

                            int lastIndex = aux.lastIndexOf(":");
                            if (lastIndex != -1) {
                                aux = aux.substring(0, lastIndex);   //recorto del lexema la parte de la funcion
                            }                                        //ya que sino no habra coincidencia en caso de autoinvocacion.
                                                                     //Ejemplo: f:main:f no daria coincidencia.

                            Funcion a = new Funcion(aux, null);
                            if(funciones_declaradas.contains(a)){
                                funcion_autoInvocada = true;
                            }

                            if (tokenFuncion == null){
                                agregarErrorSemantico("La funcion " + $1.sval + " nunca fue declarada");
                            } else {
                                Funcion funcion = new Funcion(tokenFuncion.getLexema(), null);
                                if (funciones_declaradas.contains(funcion)) {
                                    int indice = funciones_declaradas.indexOf(funcion);
                                    Funcion f = funciones_declaradas.get(indice);
                                    if (f.getParametro() != null){
                                        agregarErrorSemantico("Se esperaba un parametro en la función ");
                                    }
                                }
                            }
				            AnalizadorLexico.agregarEstructura("Reconoce llamado funcion ");
				            TablaSimbolos.removeToken($1.sval);
				            }
            | ID error ')' {AnalizadorLexico.agregarErrorSintactico("Se esperaba un '(' ");}
            | ID '(' error {AnalizadorLexico.agregarErrorSintactico("Se esperaba un ')' ");}
            | ID '(' Expresion ')' {
            			            NodoHoja nodo1 = new NodoHoja($1.sval);
            			            Nodo n3 = (Nodo)$3.obj;
                                    Token tokenFuncion = TablaSimbolos.buscarPorAmbito($1.sval + ":" + ambitoAct);

                                    String aux = $1.sval+":"+ambitoAct;

                                    int lastIndex = aux.lastIndexOf(":");
                                    if (lastIndex != -1) {
                                        aux = aux.substring(0, lastIndex);   //recorto del lexema la parte de la funcion
                                    }                                        //ya que sino no habra coincidencia en caso de autoinvocacion.
                                                                             //Ejemplo: f:main:f no daria coincidencia.

                                    Funcion a = new Funcion(aux, null);
                                    if(funciones_declaradas.contains(a)){
                                        funcion_autoInvocada = true;
                                    }


                                    if (tokenFuncion == null){
                                    	agregarErrorSemantico("La funcion " + $1.sval + " nunca fue declarada");
                                    } else {
                                        Token tokenParametro = TablaSimbolos.getToken(n3.getLexema());
                                        Funcion funcion = new Funcion(tokenFuncion.getLexema(), null);
                                    	if (funciones_declaradas.contains(funcion)) {
                                            int indice = funciones_declaradas.indexOf(funcion);
                                            Funcion f = funciones_declaradas.get(indice);
                                            if (!(f.getParametro() == null)) {
                                                if (!(f.getParametro().getTipo().equals(n3.getTipo())) && (n3.getTipo() != null)){
                                                    agregarErrorSemantico("No coinciden los tipos del parametro real y el formal. Se esperaba un " + f.getParametro().getTipo() + ", se obtuvo un " + n3.getTipo());
                                                }else{n3.setAmbito(f.getParametro().getAmbito());
                                                      n3.setUso(f.getParametro().getUso());
                                                      //f.setParametro(tokenParametro);  cambiamos parametro formal por el real
                                                      }
                                            }else{agregarErrorSemantico("La funcion invocada no lleva parametros ");}
                                        }
                                    }

                                    $$.obj=new NodoControl("LLAMADO FUNCION", new NodoComun($1.sval,null,n3));
                                    AnalizadorLexico.agregarEstructura("Reconoce llamado funcion ");
                                    TablaSimbolos.removeToken($1.sval);
                                    }
                        ;

SalidaMensaje: PRINT CADENA {$$.obj = new NodoControl("PRINT", new NodoHoja($2.sval));
                             AnalizadorLexico.agregarEstructura("Reconoce salida de mensaje por pantalla ");}
            | PRINT Factor {$$.obj = new NodoControl("PRINT", new NodoHoja($2.sval));
                            AnalizadorLexico.agregarEstructura("Reconoce salida de mensaje por pantalla ");}
            | PRINT error {AnalizadorLexico.agregarErrorSintactico("La funcion PRINT no acepta esa declaracion ");}
            ;

OperadorAsignacion: '=' {$$.obj=$1.obj;}
                  | ASIG {$$.obj=$1.obj;}
                  ;

Asignacion: Factor OperadorAsignacion Expresion {AnalizadorLexico.agregarEstructura("Reconoce asignacion ");
                                                if ($2.sval.equals("="))
						                            $$.obj = controlarTiposAsignacion((Nodo)$1.obj, "=", (Nodo)$3.obj);
						                        else
						                            $$.obj = controlarTiposAsignacion((Nodo)$1.obj, "+=", (Nodo)$3.obj);


						                        }

	| ReferenciaObjeto OperadorAsignacion ReferenciaObjeto {AnalizadorLexico.agregarEstructura("Reconoce asignacion ");
	                                                        Nodo a = ((Nodo)$1.obj).getDer();
	                                                        Nodo b = ((Nodo)$3.obj).getDer();
	                                                        if ($2.sval.equals("="))
	                                                            $$.obj = controlarTiposAsignacion(a, "=", b);
	                                                        else
	                                                            $$.obj = controlarTiposAsignacion(a, "+=", b);}

	| ReferenciaObjeto OperadorAsignacion Factor {AnalizadorLexico.agregarEstructura("Reconoce asignacion ");
	                                                Nodo a = ((Nodo)$1.obj).getDer();
	                                                if ($2.sval.equals("="))
	                                                    $$.obj = controlarTiposAsignacion(a, "=", (Nodo)$3.obj);
                                                 	else
                                                 	    $$.obj = controlarTiposAsignacion(a, "+=", (Nodo)$3.obj);

                                                    }
	| ReferenciaObjeto OperadorAsignacion error {AnalizadorLexico.agregarErrorSintactico("Se esperaba un valor seguido del operador ");}
	| Factor OperadorAsignacion error {AnalizadorLexico.agregarErrorSintactico("Se esperaba un valor seguido del operador ");}
	| OperadorAsignacion Factor {AnalizadorLexico.agregarErrorSintactico("Se esperaba un operando del lado izquierdo ");}
	;

SentenciaControl:   DO CuerpoIF UNTIL Condicion {$$.obj=new NodoComun("DO UNTIL", (Nodo)$2.obj ,(Nodo)$4.obj);
                                                        AnalizadorLexico.agregarEstructura("Reconoce funcion DO UNTIL");}
                  | DO CuerpoIF UNTIL error {AnalizadorLexico.agregarErrorSintactico("Se esperaba una condicion ");}
                  | DO SentenciaEjecutable ',' UNTIL Condicion {$$.obj = new NodoComun("DO UNTIL", (Nodo)$2.obj ,(Nodo)$4.obj);
                                                               AnalizadorLexico.agregarEstructura("Reconoce funcion DO UNTIL");}
                  | DO SentenciaEjecutable ',' UNTIL error {AnalizadorLexico.agregarErrorSintactico("Se esperaba una condicion ");}
                  | DO error UNTIL Condicion {AnalizadorLexico.agregarErrorSintactico("Se esperaba una sentencia ejecutable ");}
                  | DO SentenciaEjecutable UNTIL Condicion {AnalizadorLexico.agregarErrorSintactico("Se esperaba una ',' ");}
                  ;

//TEMA 29 --------------------------------------------------


ParametroTOD:'(' Expresion ')' {$$.obj = $2.obj;}
		| error Expresion ')' {AnalizadorLexico.agregarErrorSintactico("Se esperaba un '(' ");}
		| '(' Expresion error {AnalizadorLexico.agregarErrorSintactico("Se esperaba un ')' ");}
		;

ConversionExplicita: TOD ParametroTOD {((Nodo)$2.obj).setTipo("DOUBLE");
                                            $$.obj = (Nodo)$2.obj;
                                            AnalizadorLexico.agregarEstructura("Reconoce funcion TOD ");
                                            }

                  | TOD '(' ')' {AnalizadorLexico.agregarErrorSintactico("Se esperaba una Expresion ");}
                  ;

    EncabezadoClase : CLASS ID {  if (!(clases_forward_declaration.contains($2.sval + ":" + ambitoAct)))  {
                                        clases_forward_declaration.add($2.sval + ":" + ambitoAct);

                                        Token var = TablaSimbolos.getToken($2.sval + ":" + ambitoAct);
                                        if (var != null) {
                                            if (var.getUso().equals("Clase")) {
                                                agregarErrorSemantico("Clase " + $2.sval + " ya definida en el ambito actual");
                                                break;
                                            }
                                            agregarErrorSemantico("Este identificador ya fue utilizado en este ambito");
                                            $$.sval= " ";
                                            break;
                                        }else{$$.sval = $2.sval;}
                                        Token t = TablaSimbolos.getToken($2.sval);
                                        if (t != null){
                                            t.setLexema(t.getLexema() + ":" + ambitoAct);
                                            t.setAmbito(ambitoAct);
                                            t.setUso("Clase");

                                            TablaSimbolos.addSimbolo(t.getLexema(),t);
                                        }
                                        tipoActual = $2.sval;
                                        claseAct = $2.sval;
                                        atributosClases.put($2.sval,null);
                                        actualizarAmbito($2.sval);}
                                     TablaSimbolos.removeToken($2.sval);


                            };

Clase: EncabezadoClase '{'ListSentenciasClase ID ',' '}'{
                                                deshacerAmbito();
                                                clases_declaradas.add(claseAct+":"+ambitoAct);
                                                if ($1.sval != " "){
                                                    if (clases_declaradas.contains($4.sval+":"+ambitoAct)){
                                                        chequearAtributosRepetidos ($1.sval,$4.sval);

                                                    }
                                                }
                                                clase_hijo_padre.put($1.sval,$4.sval);
                                                ArrayList<String> atributosCopia = new ArrayList<>(listaAtributos);
                                                ArrayList<String> funcionesCopia = new ArrayList<>(listaFunciones);

                                                String clase = new String(claseAct);

                                                funcionesClases.put(clase, funcionesCopia);
                                                atributosClases.put(clase, atributosCopia);
                                                listaAtributos.clear();
                                                claseAct=null; //lo vuelvo null para que no genere conflicto cuabdo guardo atributos de clase
                                              }

      |EncabezadoClase '{' ListSentenciasClase '}' {deshacerAmbito();
                                          clases_declaradas.add(claseAct+":"+ambitoAct);
                                          ArrayList<String> atributosCopia = new ArrayList<>(listaAtributos);
                                          ArrayList<String> funcionesCopia = new ArrayList<>(listaFunciones);

                                          String clase = claseAct;

                                          funcionesClases.put(clase, funcionesCopia);
                                          atributosClases.put(clase, atributosCopia);
                                          listaAtributos.clear();
                                          claseAct=null;
                                          }
                         ;

FuncionSinCuerpo: EncabezadoFuncion Parametro { deshacerAmbito();
                                                AnalizadorLexico.agregarEstructura("Reconoce Funcion sin cuerpo");
                                               }
                  //si hay un parentesis mal escrito lo reconoce Funcion.
                  ;

EncabezadoIMPL : IMPL FOR ID ':' {  if (!(clases_declaradas.contains($3.sval+":"+ambitoAct))){
                                        agregarErrorSemantico("La clase no esta definida ");
                                    }
                                    actualizarAmbito($3.sval);
                                 }
               ;

FuncionIMPL: EncabezadoIMPL '{'Funcion'}'      {
                                                 Nodo n = (Nodo)$3.obj;
                                                 Funcion f = new Funcion(n.getLexema()+":"+ambitoAct ,null);
                                                 if (!(funciones_declaradas.contains(f)))
                                                        agregarErrorSemantico("La funcion declarada no fue definida ");
                                                 AnalizadorLexico.agregarEstructura("Reconoce funcion IMPL");

                                                 deshacerAmbito();
                                               }
            | error Funcion '}' {AnalizadorLexico.agregarErrorSintactico("Se esperaba un '{' ");}
            |'{' Funcion error {AnalizadorLexico.agregarErrorSintactico("Se esperaba un '}' ");}
		;

%%
  public NodoControl raiz;
  private String ambitoAct = "main";
  private String claseAct;
  private static boolean funcion_autoInvocada;
  static List<Error> erroresSemanticos = new ArrayList<Error>();
  static List<String> variables_declaradas = new ArrayList<String>();
  static String tipoActual;
  static List<Nodo> parametros = new ArrayList<Nodo>();
  static List<String> clases_forward_declaration = new ArrayList<String>(); //utiliada para asegurarnos que una clase delcarada tambien este implementada
  static List<String> clases_declaradas = new ArrayList<String>(); //usada para chequear que las clases declaradas esten implementadas al final del programa
  static List<Funcion> funciones_declaradas = new ArrayList<Funcion>();  //utilizada para chequear que no haya autoinvocaciones y demas
  static List<Nodo> funciones = new ArrayList<Nodo>(); //utilizada para almacenar las funciones que luego se imprimiran en main
  static Map<String,Boolean> comprobacion_uso_variables = new HashMap<String,Boolean>(); //cada vez q se declara variable se guarda lexema, si se usa del lado derecho en el ambito boolean=true.

  static Map<String, String> clase_hijo_padre = new HashMap<String, String>(); //utilizada para guardar el padre de una clase
  static ArrayList<String> listaFunciones = new ArrayList<String>(); //funciones que declara una clase
  static Map<String, ArrayList<String>> funcionesClases = new HashMap<String, ArrayList<String>>();  //guardamos como key el nombre de la clase y como value las funciones
  static ArrayList<String> listaAtributos = new ArrayList<String>(); //atributos que declara una clase
  static Map<String, ArrayList<String>> atributosClases = new HashMap<String, ArrayList<String>>(); //utilizado para chequear que una clase que hereda no sobreescriba atributos de la clase padre

  public NodoControl getRaiz(){
  	return this.raiz;
  }

  public static boolean getFuncionAutoInvocada(){
    return funcion_autoInvocada;
  }

  public List<Nodo> getFunciones(){
        return funciones;
  }

  public void agregarErrorSemantico(String error){
      Error e = new Error(error,AnalizadorLexico.getLineaAct());
      erroresSemanticos.add(e);
    }

   public void chequearEnteroNegativo(String m){
             try {
                   Integer numero = Integer.parseInt(m);
                   if (numero <= 32768){
                       if (TablaSimbolos.existeSimbolo(m)) {
                         TablaSimbolos.addAtributo(m, AccionSemantica.ENTERO, AnalizadorLexico.getLineaAct());
                       } else {
                         TablaSimbolos.addNuevoSimbolo(m);
                         TablaSimbolos.addAtributo(m, AccionSemantica.ENTERO, AnalizadorLexico.getLineaAct());
                       }
                 } else {
                   AnalizadorLexico.agregarErrorLexico("Entero negativo fuera de rango");
                 }
             } catch (Exception e) {
                   AnalizadorLexico.agregarErrorLexico("Entero negativo fuera de rango");
             }
   }

   public void chequearEnteroPositivo(String m){
                try {
                     Integer numero = Integer.parseInt(m);
                    if (numero <= 32767){
                      if (TablaSimbolos.existeSimbolo(m)) {
                        TablaSimbolos.addAtributo(m, AccionSemantica.ENTERO, AnalizadorLexico.getLineaAct());
                      } else {
                        TablaSimbolos.addNuevoSimbolo(m);
                        TablaSimbolos.addAtributo(m, AccionSemantica.ENTERO, AnalizadorLexico.getLineaAct());
                      }
                    } else {
                      AnalizadorLexico.agregarErrorLexico("Entero positivo fuera de rango");
                    }
                } catch (Exception e) {
                     AnalizadorLexico.agregarErrorLexico("Entero positivo fuera de rango");
                }
   }

   public void chequearEnteroCorto(String m){
                try {
                     Integer numero = Integer.parseInt(m);
                     if (numero <= 255){
                                          if (TablaSimbolos.existeSimbolo(m)) {
                                                TablaSimbolos.addAtributo(m, AccionSemantica.ENTEROCORTO, AnalizadorLexico.getLineaAct());
                                          } else {
                                                TablaSimbolos.addNuevoSimbolo(m);
                                                TablaSimbolos.addAtributo(m, AccionSemantica.ENTEROCORTO, AnalizadorLexico.getLineaAct());
                                          }
                                     } else {
                                          AnalizadorLexico.agregarErrorLexico("Entero corto fuera de rango");
                                     }
                } catch (Exception e) {
                     AnalizadorLexico.agregarErrorLexico("Entero positivo fuera de rango");
                }

         }

   public void chequearDouble(String m){
           String n = m.replace('D', 'e').replace('d','e');
           try {
                Double numero = Double.parseDouble(n);
                if (((numero >= 2.2250738585072014E-308) && (numero <= 1.7976931348623157E308)) || numero == 0.0){
                    if (TablaSimbolos.existeSimbolo(m)) {
                         TablaSimbolos.addAtributo(m, AccionSemantica.PUNTOFLOTANTE, AnalizadorLexico.getLineaAct());
                     } else {
                         TablaSimbolos.addNuevoSimbolo(m);
                         TablaSimbolos.addAtributo(m, AccionSemantica.PUNTOFLOTANTE, AnalizadorLexico.getLineaAct());
                    }
                } else {
                     AnalizadorLexico.agregarErrorLexico("Double fuera de rango");
                }
           } catch (Exception e) {
                AnalizadorLexico.agregarErrorLexico("Double fuera de rango");
           }
      }

      public void chequearAtributosRepetidos(String a, String b){
           ArrayList<String> hijo = atributosClases.get(a);
           ArrayList<String> padre = atributosClases.get(b);
            if ((hijo != null)&&(padre!=null)) {
               for (String atributo : hijo)
                    if (padre.contains(atributo)) {
                               agregarErrorSemantico ("Una clase que hereda no puede sobreescribir atributos del padre ");
                               hijo.remove(atributo);
                               TablaSimbolos.removeToken(atributo+":"+ambitoAct+":"+a);
                               break;
                    }
            }
      }

     NodoComun controlarTipos(Nodo n1, String op, Nodo n3 ){
         NodoComun aux = null;
         if ((n1 == null) || (n3==null)) {
             agregarErrorSemantico("Incompatibilidad de tipos ");
             return null;
         }
         if (n1.getTipo().equals(n3.getTipo())){
                 aux = new NodoComun(op,n1,n3);
                 aux.setTipo(n1.getTipo());

         }else {
                 if ((n1.getTipo().equals("USHORT") || n1.getTipo().equals("INT")) && (n3.getTipo().equals("USHORT")|| n3.getTipo().equals("INT")))
                 {
                         agregarErrorSemantico("Incompatibilidad de tipos ");
                         aux = new NodoComun(op,n1,n3);
                         aux.setTipo(n1.getTipo());
                 }else{
                   aux = new NodoComun(op,n1,n3);
                   aux.setTipo(n1.getTipo());
                   agregarErrorSemantico("Incompatibilidad de tipos, es necesario un casteo ");}
         }
         return aux;
 }

public Nodo getNodoParametro(String m){
    for (Nodo n : parametros){
        if (n.getLexema().contains(m)){
            return n;
        }
    }
    return null;
}

public boolean padreTieneAtributo (String clase,String atributo){
    String clasePadre = clase_hijo_padre.get(clase);
    ArrayList<String> atributosPadre = atributosClases.get(clasePadre);

    atributo = atributo.substring(0, atributo.indexOf(":"));

    if ((atributosPadre!=null)&&(atributosPadre.contains(atributo)))
        return true;
    return false;
}

NodoComun controlarTiposAsignacion(Nodo n1, String asig, Nodo n3)
{ 
        NodoComun aux = null;
                if ((n1 == null) || (n3==null)) {
                          return null;
                }
                if (n1.getTipo()==null){
                    n1 = getNodoParametro(n1.getLexema());
                }

                if (!((n1==null)||(n3==null))) {
                  if (n1.getTipo().equals(n3.getTipo())) {
                    aux = new NodoComun(asig, n1, n3);
                    aux.setTipo(n1.getTipo());

                  } else {
                    if (n1.getTipo().equals("USHORT") || n1.getTipo().equals("INT")) {
                      agregarErrorSemantico("Incompatibilidad de tipos ");
                      aux = new NodoComun(asig, n1, n3);
                      aux.setTipo(n1.getTipo());
                    }
                  }
                }else{agregarErrorSemantico("Incompatibilidad de tipos, es necesario un casteo ");
                      aux = new NodoComun(asig, n1, n3);
                      aux.setTipo(n1.getTipo());}
                  return aux;
}

   public void actualizarAmbito(String a){
        ambitoAct += ":"+a;
   }

   public void deshacerAmbito(){
           String aux = ambitoAct;
           char [] a = aux.toCharArray();
           int i = a.length;
           while ((i>0) && (!(a[i-1] == ':'))){
                i --;
           }
           if (i>0)
            aux = aux.substring(0,i-1);
           ambitoAct = aux;
   }

   public Token obtenerClase(String lexema) {
           Token t = TablaSimbolos.buscarPorAmbito(lexema);
           while (t == null) {
               int index = lexema.lastIndexOf(":");
               if (index != -1){
                    lexema = lexema.substring(0, lexema.lastIndexOf(":"));
               }
               t = TablaSimbolos.buscarPorAmbito(lexema);
           }
            String nombreClase;
            if (t!=null){
                if (t.getUso().equals("Variable")) {
                    nombreClase = t.getLexema();
                }else{
                    nombreClase = t.getTipo();}
                return TablaSimbolos.buscarPorAmbito(nombreClase+":"+ambitoAct);
            } else { return null; }
   }

   public String getLexemaAlcance(String lexema){ //EN CASO DE QUE ESTE AL ALCANCE DEVUELVE EL LEXEMA CORRECTO, CASO CONTRARIO DEVUELVE EL NOMBRE DE LA VARIABLE SOLA
              if (!TablaSimbolos.existeSimbolo(lexema)){
                   char [] a = lexema.toCharArray();
                   for (int i = a.length;i>0;i--){
                      if(a[i-1] == ':'){
                          lexema = lexema.substring(0,i-1);
                      }
                      if (TablaSimbolos.existeSimbolo(lexema))
                        return lexema;
                   }
              }
              return lexema;
   }

   public boolean estaAlAlcance(String lexema){
        return getLexemaAlcance(lexema).contains("main");
   }

   public String tipoPredominante(String a, String b){
            if ((a.equals("DOUBLE"))|| (b.equals("DOUBLE"))){
                  return "DOUBLE";
            } else { if ((a.equals("INT"))|| (b.equals("INT"))) {
                        return "INT";
                    }
            }
            return "USHORT";
   }

   public boolean tieneFuncion(String clase, String funcion){

        if (clase != null){
            ArrayList<String> funcionesClase = funcionesClases.get(clase);
            if (!(funcionesClase.isEmpty()))
                for (String f : funcionesClase)
                    if (f.equals(funcion))
                        return true;
        }
        return false;
   }

  public int yylex() throws IOException{
    Token t = AnalizadorLexico.obtenerToken();
    this.yylval = new ParserVal(t.getLexema());
    return t.getId();
  }

  public static void yyerror(String error){
    System.out.println(error);
  }