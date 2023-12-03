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
Programa: '{' ListSentencias  '}' {   raiz = new NodoControl("PROGRAMA", (Nodo)$2.obj);
                                    AnalizadorLexico.agregarEstructura("Reconoce programa ");}
        //| '{'ListSentencias error {AnalizadorLexico.agregarErrorSintactico("Se espera '}' ");}
	    | error ListSentencias '}' {AnalizadorLexico.agregarErrorSintactico("Se espera '{' ");}
        ;

ListSentencias:  ListSentencias Sentencia ',' {$$.obj = new NodoComun("SENTENCIA", (Nodo) $1.obj, (Nodo) $2.obj);}
        | Sentencia ',' {$$.obj=$1.obj;}
	    | Sentencia error {AnalizadorLexico.agregarErrorSintactico("Se esperaba una ',' ");}
        ;

Sentencia: SentenciaControl {$$.obj=$1.obj;}
        | SentenciaDeclarativa {$$.obj=$1.obj;}
        | SentenciaEjecutable {$$.obj=$1.obj;}
        | RETURN ',' {AnalizadorLexico.agregarErrorSintactico("RETURN definido fuera de funcion ");}
        ;

ReferenciaObjeto: ID '.' ID {TablaSimbolos.removeToken($1.sval);
                            TablaSimbolos.removeToken($3.sval);
                            $$ = new NodoComun("ReferenciaObjeto",new NodoHoja($1.sval), new NodoHoja($3.sval));
                            Token clase = obtenerClase($1.sval + ":" + ambitoAct);
                            if (clase == null) {
                                agregarErrorSemantico("El objeto " + $1.sval + " no existe");
                            }
                            else {
                                String nombreClase = clase.getLexema().substring(0, clase.getLexema().indexOf(":"));
                                String lexemaObjeto = $3.sval + ":" + ambitoAct + ":"+ nombreClase;
                                Token atributo = TablaSimbolos.getToken(lexemaObjeto);
                                if (atributo == null){
                                    agregarErrorSemantico("Atributo de clase no existe");
                                }
                            }
                            AnalizadorLexico.agregarEstructura("Reconoce llamado a atributo");
                            }
                ;

ReferenciaObjetoFuncion: ID '.' LlamadoFuncion { //chequear q exista y bla bla
                                                $$ = new NodoComun("ReferenciaFuncionObjeto",(Nodo)$1,(Nodo)$3);
                                                AnalizadorLexico.agregarEstructura("Reconoce llamado a funcion de clase ");}
                       ;

SentenciaEjecutable: Asignacion {$$.obj=$1.obj;}
                  | LlamadoFuncion {$$.obj=$1.obj;}
                  | BloqueIF   {$$.obj=$1.obj;}
		  | SalidaMensaje {$$.obj=$1.obj;}
                  | ReferenciaObjetoFuncion {$$.obj=$1.obj;}
                  ;

ListSentenciasClase : ListSentenciasClase SentenciaDeclarativa ','
                   | SentenciaDeclarativa ','
                   | RETURN ',' {AnalizadorLexico.agregarErrorSintactico("RETURN definido fuera de funcion ");}
                   | ListSentenciasClase  RETURN ',' {AnalizadorLexico.agregarErrorSintactico("RETURN definido fuera de funcion ");}
                    ;

SentenciaDeclarativa: Tipo ListVariables {
						//CHEQUAER SI UNA VARIABLE CON ESE LEXEMA YA TIENE SETEADO EL USO, SI LO TIENE SETEADO ES PORQ YA EXITE
						for (String var : variables_declaradas) {
							Token t = TablaSimbolos.getToken(var);
							if (t != null){
							    t.setLexema(var + ":" + ambitoAct);
							    t.setAmbito(ambitoAct);
							    t.setUso("Variable");
							    t.setTipo(tipoActual);
							    TablaSimbolos.removeToken(var);
							    TablaSimbolos.addSimbolo(t.getLexema(),t);
                                                	}
							else {
							   agregarErrorSemantico("Ya existe una variable + var + definida en este ambito");
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
            ;

ListVariables : ID {variables_declaradas.add($1.sval);}
              | ListVariables ';' ID   {variables_declaradas.add($3.sval);}
              ;

Objeto_clase: ID ListVariablesObj {TablaSimbolos.removeToken($1.sval);
                                    for (String var : variables_declaradas) {
                                    Token t = TablaSimbolos.getToken(var);
                                    if (t != null){
                                        t.setLexema(var + ":" + ambitoAct);
                                        t.setAmbito(ambitoAct);
                                        t.setUso("Objeto");
                                        t.setTipo($1.sval);
                                        TablaSimbolos.removeToken(var);
                                        TablaSimbolos.addSimbolo(t.getLexema(),t);
                                    }
                                    else {
                                        agregarErrorSemantico("Ya existe un objeto + var + definido en este ambito");
                                    }
                                    }
                                    variables_declaradas.clear();}
    ;

ListVariablesObj: ID {variables_declaradas.add($1.sval);}
                | ListVariablesObj ';' ID {variables_declaradas.add($3.sval);}

Tipo : USHORT {tipoActual = $1.sval;} //{(Nodo)$$.obj.setTipo("USHORT");} {((Nodo)yyval).setTipo("USHORT"); System.out.println("TIPO NODO: "+((Nodo)yyval).getTipo());}
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
                    t.setTipo("INT");
                    t.setUso("Constante");
                    t.setAmbito(ambitoAct);
                    TablaSimbolos.removeToken($1.sval);
                    TablaSimbolos.addSimbolo($1.sval,t);
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
                    t.setTipo("DOUBLE");
                    t.setUso("Constante");
                    t.setAmbito(ambitoAct);
                    TablaSimbolos.removeToken($1.sval);
                    TablaSimbolos.addSimbolo($1.sval,t);
                    }

	| '-' ENTERO    {
                    chequearEnteroNegativo($2.sval);
                    NodoHoja aux = new NodoHoja($1.sval);
                    aux.setTipo("INT");
                    aux.setUso("Constante");
                    aux.setAmbito(ambitoAct);
                    $$.obj = aux;
                    Token t = TablaSimbolos.getToken($1.sval);
                    t.setTipo("INT");
                    t.setUso("Constante");
                    t.setAmbito(ambitoAct);
                    TablaSimbolos.removeToken($1.sval);
                    TablaSimbolos.addSimbolo($1.sval,t);
	                }
	| '-' PUNTOFLOTANTE {chequearDouble($1.sval);
                         NodoHoja aux = new NodoHoja($1.sval);
                         aux.setTipo("DOUBLE");
                         aux.setUso("Constante");
                         aux.setAmbito(ambitoAct);
                         $$.obj = aux;
                         Token t = TablaSimbolos.getToken($1.sval);
                         t.setTipo("DOUBLE");
                         t.setUso("Constante");
                         t.setAmbito(ambitoAct);
                         TablaSimbolos.removeToken($1.sval);
                         TablaSimbolos.addSimbolo($1.sval,t);
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
                if(!TablaSimbolos.getUso(var).equals("Variable")){
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

Comparador: '<' {$$.obj=$1.obj;}
          | '>' {$$.obj=$1.obj;}
          | MAYORIGUAL {$$.obj=$1.obj;}
          | MENORIGUAL {$$.obj=$1.obj;}
          | IGUAL {$$.obj=$1.obj;}
          | DIST {$$.obj=$1.obj;}
          ;

ListFuncion: Funcion
	| FuncionSinCuerpo
	;

Funcion:  EncabezadoFuncion Parametro '{' ListSentenciasFuncion '}' RETURN ',' {agregarErrorSemantico("RETURN fuera de funcion");}
      | EncabezadoFuncion Parametro '{' ListSentenciasFuncion RETURN ',' '}' {  ((Nodo)$1.obj).setIzq((Nodo)$2.obj);
                                                                                ((Nodo)$1.obj).setDer((Nodo)$4.obj);
                                                                                deshacerAmbito();
                                                                                funciones.add((Nodo)$1);
                                                                                AnalizadorLexico.agregarEstructura("Reconoce declaracion de funcion ");}
      | EncabezadoFuncion Parametro '{' ListSentenciasFuncion '}' { ((Nodo)$1.obj).setIzq((Nodo)$2.obj);
                                                                    ((Nodo)$1.obj).setDer((Nodo)$4.obj);
                                                                    deshacerAmbito();
                                                                    AnalizadorLexico.agregarEstructura("Reconoce declaracion de funcion ");}
      | VOID error Parametro '{' ListSentenciasFuncion '}' {AnalizadorLexico.agregarErrorSintactico("Se esperaba un nombre para la funcion ");}
      | EncabezadoFuncion Parametro '{' '}' {AnalizadorLexico.addWarning("Función sin cuerpo ");
                                            deshacerAmbito();
                                            AnalizadorLexico.agregarEstructura("Reconoce declaracion de funcion ");}
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
                  $$.obj = new NodoComun($2.sval,null,null);
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
                                funciones_declaradas.get(funciones_declaradas.size() - 1).setTipoParametro($2.sval);
                                $$.obj = new NodoHoja($3.sval);
                           }
        | '(' Tipo ID error {AnalizadorLexico.agregarErrorSintactico("Se esperaba un ')' ");}
        |  error Tipo ID ')' {AnalizadorLexico.agregarErrorSintactico("Se esperaba un '(' ");}
        | '(' ')' {$$.obj = null;}
        | '(' error {AnalizadorLexico.agregarErrorSintactico("Se esperaba un ')' ");}
        | error ')' {AnalizadorLexico.agregarErrorSintactico("Se esperaba un '(' ");}
        ;




ListSentenciasFuncion:ListSentenciasFuncion Sentencia ',' {$$.obj = new NodoComun("Sentencia",(Nodo)$1.obj,(Nodo)$2.obj);}
		  | Sentencia ',' {$$.obj=$1.obj;}
		  | SentenciaEjecutable error {AnalizadorLexico.agregarErrorSintactico("Se esperaba una ',' al final de la linea ");}
          	  | SentenciaDeclarativa error {AnalizadorLexico.agregarErrorSintactico("Se esperaba una ',' al final de la linea ");}
          	  | RETURN error {AnalizadorLexico.agregarErrorSintactico("Se esperaba una ',' al final de la linea ");}
          ;

LlamadoFuncion: ID '(' ')' {$$.obj=new NodoHoja($1.sval);
                            Token tokenFuncion = TablaSimbolos.buscarPorAmbito($1.sval + ":" + ambitoAct);
                            Funcion funcion = new Funcion(tokenFuncion.getLexema(), null);
                            if (tokenFuncion == null){
                                agregarErrorSemantico("La funcion " + val_peek(3).sval + " nunca fue declarada");
                            } else {
                                if (funciones_declaradas.contains(funcion)) {
                                    int indice = funciones_declaradas.indexOf(funcion);
                                    Funcion f = funciones_declaradas.get(indice);
                                    if (f.getTipoParametro() != null){
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
            			    $$.obj=new NodoComun("Llamado Funcion", nodo1, (Nodo)$3.obj);
            			    Nodo n3 = (Nodo)$3.obj;
                                    Token tokenFuncion = TablaSimbolos.buscarPorAmbito($1.sval + ":" + ambitoAct);

                                    Funcion funcion = new Funcion(tokenFuncion.getLexema(), null);
                                    if (tokenFuncion == null){
                                    	agregarErrorSemantico("La funcion " + val_peek(3).sval + " nunca fue declarada");
                                    } else {
                                    	if (funciones_declaradas.contains(funcion)) {
                                            int indice = funciones_declaradas.indexOf(funcion);
                                            Funcion f = funciones_declaradas.get(indice);
                                            if (!f.getTipoParametro().equals(n3.getTipo()) && (n3.getTipo() != null)){
                                                agregarErrorSemantico("No coinciden los tipos del parametro real y el formal. Se esperaba un " + f.getTipoParametro() + ", se obtuvo un " + ((Nodo)$3).getTipo());
                                            }
                                        }
                                    }
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
						                            $$.obj = controlarTiposAsignacion((Nodo)$1.obj, "+=", (Nodo)$3.obj);}

	| ReferenciaObjeto OperadorAsignacion ReferenciaObjeto {AnalizadorLexico.agregarEstructura("Reconoce asignacion ");
	                                                        if ($2.sval.equals("="))
	                                                            $$.obj = controlarTiposAsignacion((Nodo)$1.obj, "=", (Nodo)$3.obj);
	                                                        else
	                                                            $$.obj = controlarTiposAsignacion((Nodo)$1.obj, "+=", (Nodo)$3.obj);}

	| ReferenciaObjeto OperadorAsignacion Factor {AnalizadorLexico.agregarEstructura("Reconoce asignacion ");
	                                                if ($2.sval.equals("="))
	                                                    $$.obj = controlarTiposAsignacion((Nodo)$1.obj, "=", (Nodo)$3.obj);
                                                 	else
                                                 	    $$.obj = controlarTiposAsignacion((Nodo)$1.obj, "+=", (Nodo)$3.obj);}
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

ListClase:'{' ListSentenciasClase '}'
		//| SentenciaListHerencia '}' {AnalizadorLexico.agregarErrorSintactico("Se esperaba un '}' ");}
		;

EncabezadoClase : CLASS ID {Token var = TablaSimbolos.getToken($2.sval + ":" + ambitoAct);
                            if (var != null) {
                                if (var.getUso().equals("Clase")) {
                                    agregarErrorSemantico("Clase " + $2.sval + " ya definida en el ambito actual");
                                    break;
                                }
                                agregarErrorSemantico("Este identificador ya fue utilizado en este ambito");
                                break;
                            }
                            Token t = TablaSimbolos.getToken($2.sval);
                            if (t != null){
                                t.setLexema(t.getLexema() + ":" + ambitoAct);
                                t.setAmbito(ambitoAct);
                                t.setUso("Clase");
                                TablaSimbolos.removeToken($2.sval);
                                TablaSimbolos.addSimbolo(t.getLexema(),t);
                            }
                            actualizarAmbito($2.sval);
                            tipoActual = ambitoAct;
                            };

Clase: EncabezadoClase ListClase {deshacerAmbito();}
                         ;

FuncionSinCuerpo: EncabezadoFuncion Parametro {AnalizadorLexico.agregarEstructura("Reconoce Funcion sin cuerpo");}
                  //si hay un parentesis mal escrito lo reconoce Funcion.
                  ;

FuncionIMPL: IMPL FOR ID ':' '{' Funcion '}' {AnalizadorLexico.agregarEstructura("Reconoce funcion IMPL"); TablaSimbolos.removeToken($3.sval);}
            | IMPL FOR ID ':' error Funcion '}' {AnalizadorLexico.agregarErrorSintactico("Se esperaba un '{' ");}
            | IMPL FOR ID ':' '{' Funcion error {AnalizadorLexico.agregarErrorSintactico("Se esperaba un '}' ");}
		;

//TEMA 21 ----------------------------------------------------

/*  Forward declaration => Es simplemente utilizar la regla de sentencias declarativas;
  			   ya que en esta etapa solo controlamos sintaxis
*/

%%
  public NodoControl raiz;
  private String ambitoAct = "main";
  private String ambitoNuevo= "";
  static ArrayList<Error> erroresSemanticos = new ArrayList<Error>();
  static ArrayList<String> variables_declaradas = new ArrayList<String>();
  static String tipoActual;
  static ArrayList<Funcion> funciones_declaradas = new ArrayList<Funcion>();
  static ArrayList<Nodo> funciones = new ArrayList<Nodo>();

  public NodoControl getRaiz(){
  	return this.raiz;
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

    NodoComun controlarTipos(Nodo n1, String op, Nodo n3 ){ 
        NodoComun aux = null;
        while ((n1 == null) || (n3==null))
            break;
        if(n1.getTipo().equals(n3.getTipo()))
        {
                aux = new NodoComun(op,n1,n3);
                aux.setTipo(n1.getTipo());

        }
        else 
        {
                if ((n1.getTipo().equals("USHORT") || n1.getTipo().equals("INT")) && (n3.getTipo().equals("USHORT")|| n3.getTipo().equals("INT")))
                {
                        agregarErrorSemantico("Incompatibilidad de tipos ");
                        return null;
                }
        }
        return aux;        
}

NodoComun controlarTiposAsignacion(Nodo n1, String asig, Nodo n3)
{ 
        NodoComun aux = null;
        if(n1.getTipo().equals(n3.getTipo()))
        {
                aux= new NodoComun(asig,n1,n3);
                aux.setTipo(n1.getTipo());

        }
        else 
        {   
                if (n1.getTipo().equals("USHORT")||n1.getTipo().equals("INT"))
                {
                        {agregarErrorSemantico("Incompatibilidad de tipos ");}
                        return null;
                }
        }
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
           String nombreClase = t.getTipo();
           return TablaSimbolos.buscarPorAmbito(nombreClase + ":" + ambitoAct);
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


  public int yylex() throws IOException{
    Token t = AnalizadorLexico.obtenerToken();
    this.yylval = new ParserVal(t.getLexema());
    return t.getId();
  }

  public static void yyerror(String error){
    System.out.println(error);
  }