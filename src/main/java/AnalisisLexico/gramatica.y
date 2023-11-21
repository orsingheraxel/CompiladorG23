%{
package AnalisisLexico;
import AnalisisLexico.ParserVal;
import GeneracionCodigoIntermedio.*;
import AnalisisLexico.AccionesSemanticas.AccionSemantica;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
%}

%token IF ELSE END_IF PRINT CLASS VOID DO UNTIL IMPL INT USHORT DOUBLE ID IGUAL DIST MENORIGUAL MAYORIGUAL ASIG RETURN TOD CADENA ENTERO ENTEROCORTO PUNTOFLOTANTE FOR CTE

%start Programa

%%
Programa:'{' ListSentencias '}' {raiz = new NodoControl("PROGRAMA",(Nodo)$2); AnalizadorLexico.agregarEstructura("Reconoce programa ");}
        //| '{'ListSentencias error {AnalizadorLexico.agregarErrorSintactico("Se espera '}' ");}
	    | error ListSentencias '}' {AnalizadorLexico.agregarErrorSintactico("Se espera '{' ");}
        ;

ListSentencias:  ListSentencias Sentencia ',' {$$ = new NodoComun("Sentencia", (Nodo) $1, (Nodo) $2);}
        | Sentencia ','{$$=$1;}
	//| Sentencia error {AnalizadorLexico.agregarErrorSintactico("Se esperaba una ',' al final de la linea ");}
        ;

Sentencia: SentenciaControl {$$ = $1;}
        | SentenciaEjecutable {$$ = $1;}
        | SentenciaDeclarativa {$$ = null;}
        | RETURN error {AnalizadorLexico.agregarErrorSintactico("RETURN definido fuera de funcion ");}
        ;

ReferenciaObjeto: ID '.' ID {
                            $$ = new NodoComun("ReferenciaObjeto",(Nodo)$1,(Nodo)$3);
                            Token t1 = TablaSimbolos.getToken($1.sval);
                            Token t2 = TablaSimbolos.getToken($3.sval);

                            /*

                            EJEMPLO

                            clase1.a

                            clase1 => uso = objeto
				      tipo = clase1

			    */

			    a:clase1

			    String lexemaConAmbito = t2.getLexema() + ":" + TablaSimbolos.recuperarAmbito(t2.getTipo());

                            if (t.getUso().equals("Objeto")){
                            	Token atributo = TablaSimbolos.getToken(lexConAmbito);
                            	if (atributo != null){
					//asignar cosas
                            	}
                            } else {
                            	agregarErrorSemantico("Referencia a objeto mal definida");
                            }



                            AnalizadorLexico.agregarEstructura("Reconoce referencia objeto ");

                            }
                ;

ReferenciaObjetoFuncion: ID '.' LlamadoFuncion { //chequear q exista y bla bla
                                                $$ = new NodoComun("ReferenciaFuncionObjeto",(Nodo)$1,(Nodo)$3);
                                                AnalizadorLexico.agregarEstructura("Reconoce llamado a funcion de clase ");}
                       ;

SentenciaEjecutable: Asignacion {$$=$1;}
                  | LlamadoFuncion {$$=$1;}
                  | BloqueIF   {$$=$1;}
		  | SalidaMensaje {$$=$1;}
                  | ReferenciaObjetoFuncion {$$=$1;}
                  ;

ListSentenciasClase : ListSentenciasClase SentenciaDeclarativa ','
                   | SentenciaDeclarativa ','{$$=$1;}
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
              | ListVariables ';' ID   {$$ = $1 ; variables_declaradas.add($3.sval);}
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
                | ListVariablesObj ';' ID {$$ = $1 ; variables_declaradas.add($3.sval);}

Tipo : USHORT {tipoActual = $1.sval;} //{(Nodo)$$.setTipo("USHORT");} {((Nodo)yyval).setTipo("USHORT"); System.out.println("TIPO NODO: "+((Nodo)yyval).getTipo());}
     | INT {tipoActual = $1.sval;}
     | DOUBLE {tipoActual = $1.sval;}
     ;

Constante: ENTERO  {
                    chequearEnteroPositivo($1.sval);
                    $$ = new NodoHoja($1.sval);
                    ((Nodo)$$).setTipo("INT");
                    ((Nodo)$$).setUso("Constante");
                    ((Nodo)$$).setAmbito(ambitoAct);
                    ((Nodo)$$).setValor(Integer.parseInt($1.sval));
                    Token t = TablaSimbolos.getToken($1.sval);
                    t.setTipo("INT");
                    t.setUso("Constante");
                    t.setAmbito(ambitoAct);
                    t.setValor(Integer.parseInt($1.sval));
                    TablaSimbolos.removeToken($1.sval);
                    TablaSimbolos.addSimbolo($1.sval,t);
                   }

	| ENTEROCORTO {$$ = new NodoHoja($1.sval);
	               chequearEnteroCorto($1.sval);
	               ((Nodo)$$).setTipo("USHORT");
                   chequearEnteroPositivo($1.sval);
                   ((Nodo)$$).setUso("Constante");
                   ((Nodo)$$).setAmbito(ambitoAct);
                   ((Nodo)$$).setValor(Integer.parseInt($1.sval));
                   Token t = TablaSimbolos.getToken($1.sval);
                   t.setTipo("USHORT");
                   t.setUso("Constante");
                   t.setAmbito(ambitoAct);
                   t.setValor(Integer.parseInt($1.sval));
                   TablaSimbolos.removeToken($1.sval);
                   TablaSimbolos.addSimbolo($1.sval,t);
                   }
	| '-' ENTEROCORTO {AnalizadorLexico.agregarErrorLexico("Un entero corto no puede ser negativo ");}
	| PUNTOFLOTANTE{
	                chequearDouble($1.sval);
	                $$ = new NodoHoja($1.sval);
                    ((Nodo)$$).setTipo("DOUBLE");
                    ((Nodo)$$).setUso("Constante");
                    ((Nodo)$$).setAmbito(ambitoAct);
                    ((Nodo)$$).setValor(Double.parseDouble($1.sval));
	            Token t = TablaSimbolos.getToken($1.sval);
                    t.setTipo("DOUBLE");
                    t.setUso("Constante");
                    t.setAmbito(ambitoAct);
                    t.setValor(Double.parseDouble($1.sval));
                    TablaSimbolos.removeToken($1.sval);
                    TablaSimbolos.addSimbolo($1.sval,t);
                    }

	| '-' ENTERO    {
                    $$ = new NodoHoja($1.sval);
                    chequearEnteroNegativo($2.sval);
                    ((Nodo)$$).setTipo("INT");
                    ((Nodo)$$).setUso("Constante");
                    ((Nodo)$$).setAmbito(ambitoAct);
                    ((Nodo)$$).setValor(Integer.parseInt($1.sval));
                    Token t = TablaSimbolos.getToken($1.sval);
                    t.setTipo("INT");
                    t.setUso("Constante");
                    t.setAmbito(ambitoAct);
                    t.setValor(Integer.parseInt($1.sval));
                    TablaSimbolos.removeToken($1.sval);
                    TablaSimbolos.addSimbolo($1.sval,t);
	                }
	| '-' PUNTOFLOTANTE {chequearDouble($1.sval);
                         $$ = new NodoHoja($1.sval);
                         ((Nodo)$$).setTipo("DOUBLE");
                         ((Nodo)$$).setUso("Constante");
                         ((Nodo)$$).setAmbito(ambitoAct);
                         ((Nodo)$$).setValor(Double.parseDouble($1.sval));
                         Token t = TablaSimbolos.getToken($1.sval);
                         t.setTipo("DOUBLE");
                         t.setUso("Constante");
                         t.setAmbito(ambitoAct);
                         t.setValor(Double.parseDouble($1.sval));
                         TablaSimbolos.removeToken($1.sval);
                         TablaSimbolos.addSimbolo($1.sval,t);
                        }
	;

Expresion: Expresion'+'Termino { $$ = new NodoComun("+",(Nodo)$1,(Nodo)$3);
                                if (((Nodo)$1).getUso()!= "Constante"){
                                    if (!estaAlAlcance(((Nodo)$1).getLexema())){
                                        agregarErrorSemantico("Primer termino fuera de alcance ");
                                        break;
                                    }
                                 }
                                if (((Nodo)$3).getUso()!= "Constante"){
                                   if (!estaAlAlcance(((Nodo)$3).getLexema())){
                                        agregarErrorSemantico("Segundo termino fuera de alcance ");
                                        break;
                                   }
                                }
                                if (((Nodo)$1).getTipo().equals(((Nodo)$3).getTipo())){
                                    ((Nodo)$$).setTipo(((Nodo)$1).getTipo());
                                    ((Nodo)$$).setValor(((Nodo)$1).getValor() + ((Nodo)$3).getValor());
                                }
                                }
| Expresion'-'Termino {$$ = new NodoComun("-",(Nodo)$1,(Nodo)$3);
                        if (((Nodo)$1).getUso()!= "Constante"){
                            if (!estaAlAlcance(((Nodo)$1).getLexema())){
                                agregarErrorSemantico("Primer termino fuera de alcance ");
                                break;
                            }
                        }
                        if (((Nodo)$3).getUso()!= "Constante"){
                            if (!estaAlAlcance(((Nodo)$3).getLexema())){
                                agregarErrorSemantico("Segundo termino fuera de alcance ");
                                break;
                            }
                        }
                        if (((Nodo)$1).getTipo().equals(((Nodo)$3).getTipo())){
                            ((Nodo)$$).setTipo(((Nodo)$1).getTipo());
                            ((Nodo)$$).setValor(((Nodo)$1).getValor() - ((Nodo)$3).getValor());
                        }
                      }
| Termino {$$=$1;}
| ConversionExplicita {$$ = $1;} //PASAR A DOUBLE Y ASIGNAR EL VALUE
        ;


Termino: Termino '*' Factor   {$$ = new NodoComun("*",(Nodo)$1,(Nodo)$3);
                                if (((Nodo)$1).getUso()!= "Constante"){
                                    if (!estaAlAlcance(((Nodo)$1).getLexema())){
                                        agregarErrorSemantico("Primer termino fuera de alcance ");
                                        break;
                                    }
                                }
                                if (((Nodo)$3).getUso()!= "Constante"){
                                    if (!estaAlAlcance(((Nodo)$3).getLexema())){
                                        agregarErrorSemantico("Segundo termino fuera de alcance ");
                                        break;
                                    }
                                }
                                if (((Nodo)$1).getTipo().equals(((Nodo)$3).getTipo())){
                                    ((Nodo)$$).setTipo(((Nodo)$1).getTipo());
                                    ((Nodo)$$).setValor(((Nodo)$1).getValor() * ((Nodo)$3).getValor());
                                }
                              }

| Termino'/'Factor {$$ = new NodoComun("/",(Nodo)$1,(Nodo)$3);
                        if (((Nodo)$1).getUso()!= "Constante"){
                            if (!estaAlAlcance(((Nodo)$1).getLexema())){
                                agregarErrorSemantico("Primer termino fuera de alcance ");
                                break;
                            }
                        }if (((Nodo)$3).getUso()!= "Constante"){
                            if (!estaAlAlcance(((Nodo)$3).getLexema())){
                                agregarErrorSemantico("Segundo termino fuera de alcance ");
                                break;
                            }
                        }
                        if (((Nodo)$1).getTipo().equals(((Nodo)$3).getTipo())){
                            ((Nodo)$$).setTipo(((Nodo)$1).getTipo());
                            ((Nodo)$$).setValor(((Nodo)$1).getValor() / ((Nodo)$3).getValor());
                        }
                    }
| Factor {$$ = $1;}
| Termino'*' Factor_RefObjeto {$$ = new NodoComun("*",(Nodo)$1,(Nodo)$3);
                               if (!((Nodo)$1).getAmbito().equals(((Nodo)$3).getAmbito())){
                                    agregarErrorSemantico("Variable fuera de alcance ");
                               }
                                     ((Nodo)$$).setTipo(tipoPredominante(((Nodo)$1).getTipo(),((Nodo)$3).getTipo()));
                               }
| Termino'/' Factor_RefObjeto {$$ = new NodoComun("/",(Nodo)$1,(Nodo)$3);
                               if (!((Nodo)$1).getAmbito().equals(((Nodo)$3).getAmbito())){
                                    agregarErrorSemantico("Variable fuera de alcance ");
                               }
                                    ((Nodo)$$).setTipo(tipoPredominante(((Nodo)$1).getTipo(),((Nodo)$3).getTipo()));
                               }
| Factor_RefObjeto {$$=$1;}
;

Factor: ID {$$ = new NodoHoja($1.sval);
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
                    ((Nodo)$$).setTipo(TablaSimbolos.getTipo(var));
                    ((Nodo)$$).setUso(TablaSimbolos.getUso(var));
                    ((Nodo)$$).setAmbito(TablaSimbolos.getAmbito(var));
                }
            }
          }
	| Constante {$$=$1;}
	;

Factor_RefObjeto: ReferenciaObjeto {$$=$1;}
                ;

Condicion : '(' Expresion Comparador Expresion ')' { $$ = new NodoComun($3.sval,(Nodo)$2,(Nodo)$4);
                                                    ((Nodo)$$).setTipo(((Nodo)$2).getTipo());
                                                    ((Nodo)$$).setUso("Condicion");
                                                     if (!((((Nodo)$2).getTipo()).equals(((Nodo)$4).getTipo()))){
                                                         agregarErrorSemantico("Error en la comparacion entre expresiones de distintos tipos"); //CHEQUEAR CONVERSIONES
                                                     }
                                                     }
            | '(' Expresion Comparador Expresion error {AnalizadorLexico.agregarErrorSintactico("Se esperaba una ')' ");}
            | error Expresion Comparador Expresion ')' {AnalizadorLexico.agregarErrorSintactico("Se esperaba una '(' ");}
	  ;

BloqueIF: IF Condicion CuerpoIF ELSE CuerpoIF END_IF {Nodo SentenciasIF = new NodoComun("SentenciasIF",new NodoControl("SentenciasIF",(Nodo)$3), new NodoControl("SentenciasELSE",(Nodo)$5));
                                                                      $$= new NodoComun("BloqueIF", new NodoControl("Condicion",(Nodo)$2), SentenciasIF);
                                                                      AnalizadorLexico.agregarEstructura("Reconoce IF ELSE ");}
	    | IF Condicion CuerpoIF END_IF {$$= new NodoComun("BloqueIF", new NodoControl("Condicion",(Nodo)$2), new NodoControl("SentenciasIF",(Nodo)$3));
	                                            AnalizadorLexico.agregarEstructura("Reconoce IF ");}
	    | IF Condicion CuerpoIF ELSE CuerpoIF error   {AnalizadorLexico.agregarErrorSintactico("IF mal definido ");}
	    | IF Condicion CuerpoIF error {AnalizadorLexico.agregarErrorSintactico("IF mal definido ");}
        | IF Condicion SentenciaEjecutable ',' ELSE CuerpoIF END_IF {AnalizadorLexico.agregarEstructura("Reconoce IF ELSE");}
        | IF Condicion SentenciaEjecutable ',' ELSE SentenciaEjecutable ',' END_IF {AnalizadorLexico.agregarEstructura("Reconoce IF ELSE");}
        | IF Condicion CuerpoIF ELSE SentenciaEjecutable ',' END_IF {AnalizadorLexico.agregarEstructura("Reconoce IF ELSE");}
        | IF Condicion SentenciaEjecutable ',' ELSE CuerpoIF error {AnalizadorLexico.agregarErrorSintactico("Se esperaba un END_IF ");}
        | IF Condicion SentenciaEjecutable ',' ELSE SentenciaEjecutable error {AnalizadorLexico.agregarErrorSintactico("Se esperaba un END_IF ");}
        | IF Condicion CuerpoIF ELSE SentenciaEjecutable ',' error {AnalizadorLexico.agregarErrorSintactico("Se esperaba un END_IF ");}
        | IF Condicion SentenciaEjecutable ',' error CuerpoIF END_IF {AnalizadorLexico.agregarErrorSintactico("Se esperaba un ELSE ");}
        | IF Condicion SentenciaEjecutable ',' error SentenciaEjecutable END_IF {AnalizadorLexico.agregarErrorSintactico("IF mal definido ");}
        | IF Condicion SentenciaEjecutable error ELSE  CuerpoIF END_IF {AnalizadorLexico.agregarErrorSintactico("Se esperaba una ',' ");}
        | IF Condicion CuerpoIF ELSE SentenciaEjecutable error END_IF {AnalizadorLexico.agregarErrorSintactico("Se esperaba una ',' " );}
        | IF Condicion SentenciaEjecutable error END_IF {AnalizadorLexico.agregarErrorSintactico("Se esperaba una ',' ");}
        ;

CuerpoIF: '{' SentenciasIF '}'
        | RETURN ','
        | RETURN error {AnalizadorLexico.agregarErrorSintactico("Falta una ',' "); }
        | '{' SentenciasIF RETURN ',' '}'
        | '{' SentenciasIF RETURN error '}' {AnalizadorLexico.agregarErrorSintactico("Falta una ',' "); }
        | error SentenciasIF '}' {AnalizadorLexico.agregarErrorSintactico("Falta un '{'"); }
		|'{' SentenciasIF error {AnalizadorLexico.agregarErrorSintactico("Falta un '}'"); }
        | '{' '}' {AnalizadorLexico.agregarErrorSintactico("No hay sentencias dentro de las llaves."); }
        ;

SentenciasIF: ListaSentenciasIF {$$=$1;}
                ;

ListaSentenciasIF: error {AnalizadorLexico.agregarErrorSintactico("Solo se aceptan sentencias ejecutables "); }
               | SentenciaEjecutable ',' {$$=$1;}
               | SentenciaEjecutable error {AnalizadorLexico.agregarErrorSintactico("Falta una ',' "); }
               | ListaSentenciasIF SentenciaEjecutable ',' {$$ = new NodoComun("SentenciaIF", (Nodo) $1, (Nodo) $2);}
               ;

Comparador: '<' {$$=$1;}
          | '>' {$$=$1;}
          | MAYORIGUAL {$$=$1;}
          | MENORIGUAL {$$=$1;}
          | IGUAL {$$=$1;}
          | DIST {$$=$1;}
          ;

ListFuncion: Funcion
	| FuncionSinCuerpo
	;

Funcion: EncabezadoFuncion Parametro '{' ListSentenciasFuncion '}' {deshacerAmbito(); AnalizadorLexico.agregarEstructura("Reconoce declaracion de funcion ");}
      | VOID error Parametro '{' ListSentenciasFuncion '}' {AnalizadorLexico.agregarErrorSintactico("Se esperaba un nombre para la funcion ");}
      ;

EncabezadoFuncion : VOID ID  {actualizarAmbito($2.sval);
			      Token t = TablaSimbolos.getToken($2.sval);
                              if (t != null){
                                    t.setLexema(var + ":" + ambitoAct);
                                    t.setAmbito(ambitoAct);
                                    t.setUso("Funcion");
                                    t.setTipo("VOID");
                                    TablaSimbolos.removeToken(var);
                                    TablaSimbolos.addSimbolo(t.getLexema(),t);
                              }
                              }
                  ;



Parametro: '(' Tipo ID ')' {
				Token t = TablaSimbolos.getToken($3.sval);
                                if (t != null){
                                	t.setLexema(var + ":" + ambitoAct);
                                	t.setAmbito(ambitoAct);
                                	t.setUso("Parametro");
                                	t.setTipo(tipoActual);
                                	TablaSimbolos.removeToken(var);
                                	TablaSimbolos.addSimbolo(t.getLexema(),t);
                                }
                           }
        | '(' Tipo ID error {AnalizadorLexico.agregarErrorSintactico("Se esperaba un ')' ");}
        |  error Tipo ID ')' {AnalizadorLexico.agregarErrorSintactico("Se esperaba un '(' ");}
        | '(' ')'
        | '(' error {AnalizadorLexico.agregarErrorSintactico("Se esperaba un ')' ");}
        | error ')' {AnalizadorLexico.agregarErrorSintactico("Se esperaba un '(' ");}
        ;

ListSentenciasFuncion:ListSentenciasFuncion SentenciaDeclarativa ',' {$$ = new NodoComun("Sentencia", (Nodo) $1, null);}
		  | ListSentenciasFuncion SentenciaEjecutable ',' {$$ = new NodoComun("Sentencia", (Nodo) $1, (Nodo) $2);}
		  | SentenciaEjecutable ',' {$$ = $1;}
		  | SentenciaDeclarativa ',' {$$ = null;}
		  | RETURN ','
		  | ListSentenciasFuncion RETURN ',' {$$ = $1;}
		  | SentenciaEjecutable error {AnalizadorLexico.agregarErrorSintactico("Se esperaba una ',' al final de la linea ");}
          	  | SentenciaDeclarativa error {AnalizadorLexico.agregarErrorSintactico("Se esperaba una ',' al final de la linea ");}
          	  | RETURN error {AnalizadorLexico.agregarErrorSintactico("Se esperaba una ',' al final de la linea ");}
          ;

LlamadoFuncion: ID '(' ')' {	$$=new NodoHoja($1.sval);
				//Idem clase osea ver en profundidad y detalladamente con mucha precision refObjeto
				AnalizadorLexico.agregarEstructura("Reconoce llamado funcion ");
				TablaSimbolos.removeToken($1.sval);


			   }
            | ID error ')' {AnalizadorLexico.agregarErrorSintactico("Se esperaba un '(' ");}
            | ID '(' error {AnalizadorLexico.agregarErrorSintactico("Se esperaba un ')' ");}
            | ID LlamadoExpresion  {$$=new NodoComun("Llamado Funcion",(Nodo)$1,new NodoControl("Parametro Llamado Funcion",(Nodo)$2));AnalizadorLexico.agregarEstructura("Reconoce llamado funcion ");
                                       TablaSimbolos.removeToken($1.sval);}
            ;

SalidaMensaje: PRINT CADENA {$$ = new NodoControl("PRINT", new NodoHoja($2.sval));
                             AnalizadorLexico.agregarEstructura("Reconoce salida de mensaje por pantalla ");}
            | PRINT Factor {$$ = new NodoControl("PRINT", new NodoHoja($2.sval));
                            AnalizadorLexico.agregarEstructura("Reconoce salida de mensaje por pantalla ");}
            | PRINT error {AnalizadorLexico.agregarErrorSintactico("La funcion PRINT no acepta esa declaracion ");}
            ;

OperadorAsignacion: '=' {$$=$1;}
                  | ASIG {$$=$1;}
                  ;

Asignacion: Factor OperadorAsignacion Expresion {AnalizadorLexico.agregarEstructura("Reconoce asignacion ");
						                        $$ = new NodoComun($2.sval,(Nodo)$1,(Nodo)$3);
						                        String var = getLexemaAlcance(((Nodo)$1).getLexema() + ":" + ambitoAct);
                                                if (var.contains("main")){
                                                    Token t1 = TablaSimbolos.getToken(var);
                                                    if (t1 != null){
                                                        if (t1.getUso().equals("Constante")){
                                                            agregarErrorSemantico("Las constantes no pueden estar del lado izquierdo en una asignacion");
                                                        }
                                                        else {
                                                            if (!getLexemaAlcance(var).equals(((Nodo)$1).getLexema())){
                                                                ((Nodo)$$).setTipo(tipoPredominante(((Nodo)$1).getTipo(),((Nodo)$3).getTipo()));
                                                            }
                                                            else {
                                                                agregarErrorSemantico("Variable " + ((Nodo)$1).getLexema() +" fuera de alcance");
                                                            }
                                                        }
                                                    }
                                                }
						                        else {
						                            agregarErrorSemantico("Variable " + ((Nodo)$1).getLexema() + " no definida");
						                        }
					                            }

	| ReferenciaObjeto OperadorAsignacion ReferenciaObjeto
	| ReferenciaObjeto OperadorAsignacion Factor
	| ReferenciaObjeto OperadorAsignacion error {AnalizadorLexico.agregarErrorSintactico("Se esperaba un valor seguido del operador ");}
	| Factor OperadorAsignacion error {AnalizadorLexico.agregarErrorSintactico("Se esperaba un valor seguido del operador ");}
	| OperadorAsignacion Factor {AnalizadorLexico.agregarErrorSintactico("Se esperaba un operando del lado izquierdo ");}
	;

SentenciaControl: DO CuerpoIF UNTIL Condicion {$$=new NodoComun("Sentencia DO UNTIL", new NodoControl("ListSentenciasDO",(Nodo)$2), new NodoControl("CondicionDO", (Nodo)$4));
                                                        AnalizadorLexico.agregarEstructura("Reconoce funcion DO UNTIL");}
                  |DO CuerpoIF UNTIL error {AnalizadorLexico.agregarErrorSintactico("Se esperaba una condicion ");}
                  ;

//TEMA 29 --------------------------------------------------

LlamadoExpresion:'(' Expresion ')' {$$ = $2;}
		| error Expresion ')' {AnalizadorLexico.agregarErrorSintactico("Se esperaba un '(' ");}
		| '(' Expresion error {AnalizadorLexico.agregarErrorSintactico("Se esperaba un ')' ");}
		;

ConversionExplicita: TOD LlamadoExpresion {$$ = new NodoControl("TOD",(Nodo)$2);
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
  private NodoControl raiz;
  private String ambitoAct = "main";
  private String ambitoNuevo= "";
  static ArrayList<Error> erroresSemanticos = new ArrayList<Error>();
  static ArrayList<String> variables_declaradas = new ArrayList<String>();
  static String tipoActual;

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