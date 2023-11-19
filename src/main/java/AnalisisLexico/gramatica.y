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

Sentencia: SentenciaControl {$$=$1;}
        | SentenciaEjecutable {$$=$1;}
        | SentenciaDeclarativa {$$= new NodoHoja("SENTENCIA DECLARATIVA");}
        | RETURN error {AnalizadorLexico.agregarErrorSintactico("RETURN definido fuera de funcion ");}
        ;

ReferenciaObjeto: ID '.' ID {//chequear q exista y bla bla
                            $$ = new NodoComun("ReferenciaFuncionObjeto",(Nodo)$1,(Nodo)$3);
                            AnalizadorLexico.agregarEstructura("Reconoce referencia objeto ");}
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

SentenciaDeclarativa: Tipo ListVariables {   for (String var : variables_declaradas) { //CHEQUAER SI UNA VARIABLE CON ESE LEXEMA YA TIENE SETEADO EL USO, SI LO TIENE SETEADO ES PORQ YA EXITE
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
			| Funcion
			| error ListVariables{AnalizadorLexico.agregarErrorSintactico("Se espera el tipo de la variable ");}
			| Tipo error {AnalizadorLexico.agregarErrorSintactico("Se espera identificador de la variable ");}
			| HerenciaComposicion
			| Objeto_clase
			| FuncionIMPL
            ;

ListVariables : ID {variables_declaradas.add($1.sval);}
              | ListVariables ';' ID   {$$ = $1 ; variables_declaradas.add($3.sval);}
              ;

Objeto_clase: ID ListVariables
    ;

Tipo : USHORT {tipoActual = $1.sval;} //{(Nodo)$$.setTipo("USHORT");} {((Nodo)yyval).setTipo("USHORT"); System.out.println("TIPO NODO: "+((Nodo)yyval).getTipo());}
     | INT {tipoActual = $1.sval;}
     | DOUBLE {tipoActual = $1.sval;}
     ;

Constante: ENTERO  {
                    chequearEnteroPositivo($1.sval);
                    $$ = new NodoHoja($1.sval) ;
                    ((Nodo)$$).setTipo("INT");
                    ((Nodo)$$).setUso("Constante");
                   }

	| ENTEROCORTO {$$ = new NodoHoja($1.sval);
	               chequearEnteroCorto($1.sval);
	               ((Nodo)$$).setTipo("USHORT");
                   chequearEnteroPositivo($1.sval);
                   ((Nodo)$$).setUso("Constante");
                   }
	| '-' ENTEROCORTO {AnalizadorLexico.agregarErrorLexico("Un entero corto no puede ser negativo ");}
	| PUNTOFLOTANTE{
	                chequearDouble($1.sval);
	                $$ = new NodoHoja($1.sval);
                    ((Nodo)$$).setTipo("DOUBLE");
                    ((Nodo)$$).setUso("Constante");
                    }

	| '-' ENTERO    {
                    $$ = new NodoHoja($1.sval);
                    chequearEnteroNegativo($2.sval);
                    ((Nodo)$$).setTipo("INT");
                    ((Nodo)$$).setUso("Constante");
	                }
	| '-' PUNTOFLOTANTE {
                            chequearDouble($1.sval);
                            $$ = new NodoHoja($1.sval);
                            ((Nodo)$$).setTipo("DOUBLE");
                            ((Nodo)$$).setUso("Constante");
                        }
	;

Expresion: Expresion'+'Termino { $$ = new NodoComun("+",(Nodo)$1,(Nodo)$3);
                                    if (!((Nodo)$1).getAmbito().equals(((Nodo)$3).getAmbito())){
                                          agregarErrorSemantico("Variable fuera de alcance ");
                                    }
                                        ((Nodo)$$).setTipo(tipoPredominante(((Nodo)$1).getTipo(),((Nodo)$3).getTipo()));
                                    }

| Expresion'-'Termino {$$ = new NodoComun("-",(Nodo)$1,(Nodo)$3);
                        if (!((Nodo)$1).getAmbito().equals(((Nodo)$3).getAmbito())){
                            agregarErrorSemantico("Variable fuera de alcance ");
                        }
                            ((Nodo)$$).setTipo(tipoPredominante(((Nodo)$1).getTipo(),((Nodo)$3).getTipo()));
                      }
| Termino {$$=$1;}
| ConversionExplicita {$$ = $1;}
        ;


Termino: Termino '*' Factor   {$$ = new NodoComun("*",(Nodo)$1,(Nodo)$3);
                               if (!((Nodo)$1).getAmbito().equals(((Nodo)$3).getAmbito())){
                                    agregarErrorSemantico("Variable fuera de alcance ");
                               }
                                    ((Nodo)$$).setTipo(tipoPredominante(((Nodo)$1).getTipo(),((Nodo)$3).getTipo()));
                              }

| Termino'/'Factor {$$ = new NodoComun("/",(Nodo)$1,(Nodo)$3);
                    if (!((Nodo)$1).getAmbito().equals(((Nodo)$3).getAmbito())){
                        agregarErrorSemantico("Variable fuera de alcance ");
                    }
                        ((Nodo)$$).setTipo(tipoPredominante(((Nodo)$1).getTipo(),((Nodo)$3).getTipo()));
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
            String var = $1.sval + ":" + ambitoAct;
            var = estaAlAlcance(var);
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

SentenciasIF: ListaSentenciasIF
                ;

ListaSentenciasIF: error {AnalizadorLexico.agregarErrorSintactico("Solo se aceptan sentencias ejecutables "); }
               | SentenciaEjecutable ','
               | SentenciaEjecutable error {AnalizadorLexico.agregarErrorSintactico("Falta una ',' "); }
               | ListaSentenciasIF SentenciaEjecutable ','
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

EncabezadoFuncion : VOID ID  {ambitoAct = ambitoAct + ":" + $2.sval;}
                  ;
//chequear
Parametro: '(' Tipo ID ')' {	$$ = new NodoHoja($3.sval);

                           }
        | '(' Tipo ID error {AnalizadorLexico.agregarErrorSintactico("Se esperaba un ')' ");}
        |  error Tipo ID ')' {AnalizadorLexico.agregarErrorSintactico("Se esperaba un '(' ");}
        | '(' ')'
        | '(' error {AnalizadorLexico.agregarErrorSintactico("Se esperaba un ')' ");}
        | error ')' {AnalizadorLexico.agregarErrorSintactico("Se esperaba un '(' ");}
        ;

ListSentenciasFuncion:ListSentenciasFuncion SentenciaDeclarativa ','
		  | ListSentenciasFuncion SentenciaEjecutable ','
		  | SentenciaEjecutable ',' {$$ = $1;}
		  | SentenciaDeclarativa ',' {$$ = $1;}
		  | RETURN ','
		  | ListSentenciasFuncion RETURN ','
		  | SentenciaEjecutable error {AnalizadorLexico.agregarErrorSintactico("Se esperaba una ',' al final de la linea ");}
          | SentenciaDeclarativa error {AnalizadorLexico.agregarErrorSintactico("Se esperaba una ',' al final de la linea ");}
          | RETURN error {AnalizadorLexico.agregarErrorSintactico("Se esperaba una ',' al final de la linea ");}
          ;

//chequear que ID sea una clase realmente
LlamadoFuncion: ID '(' ')' {$$=new NodoHoja($1.sval); AnalizadorLexico.agregarEstructura("Reconoce llamado funcion ");}
            | ID error ')' {AnalizadorLexico.agregarErrorSintactico("Se esperaba un '(' ");}
            | ID '(' error {AnalizadorLexico.agregarErrorSintactico("Se esperaba un ')' ");}
            | ID LlamadoExpresion  {$$=new NodoComun("Llamado Funcion",(Nodo)$1,new NodoControl("Parametro Llamado Funcion",(Nodo)$2));AnalizadorLexico.agregarEstructura("Reconoce llamado funcion ");}
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
						                        String var = estaAlAlcance(((Nodo)$1).getLexema() + ":" + ambitoAct);
                                                if (var.contains("main")){
                                                    Token t1 = TablaSimbolos.getToken(var);
                                                    if (t1 != null){
                                                        if (t1.getUso().equals("Constante")){
                                                            agregarErrorSemantico("Las constantes no pueden estar del lado izquierdo en una asignacion");
                                                        }
                                                        else {
                                                            if (!estaAlAlcance(var).equals(((Nodo)$1).getLexema())){
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

ListHerencia:'{' SentenciaListHerencia '}'
		//| SentenciaListHerencia '}' {AnalizadorLexico.agregarErrorSintactico("Se esperaba un '}' ");}
		;

SentenciaListHerencia: Tipo ListVariables ',' {

                                               }
		| SentenciaListHerencia Tipo ListVariables ','
		| ListFuncion ','
		| SentenciaListHerencia ListFuncion ','
        | Tipo ListVariables error {AnalizadorLexico.agregarErrorSintactico("Se esperaba una ',' al final de la linea ");}
        | SentenciaListHerencia error Tipo ListVariables {AnalizadorLexico.agregarErrorSintactico("Se esperaba una ',' al final de la linea ");}
        | ListFuncion error {AnalizadorLexico.agregarErrorSintactico("Se esperaba una ',' al final de la linea ");}
        | SentenciaListHerencia error ListFuncion  {AnalizadorLexico.agregarErrorSintactico("Se esperaba una ',' al final de la linea ");}
        ;

HerenciaComposicion: CLASS ID ListHerencia   { 	String ambito = $2.sval;
						if (!(TablaSimbolos.existeSimbolo($2.sval))) { //PREGUNTAR TMB X USO EN COND
                                                   TablaSimbolos.getToken($2.sval).setAmbito(ambitoAct);
                                                   actualizarAmbito(ambito);
                                                   TablaSimbolos.getToken($2.sval).setUso("Clase");
                                                   AnalizadorLexico.agregarEstructura("Reconoce CLASE");
                                               } else {
                                                    agregarErrorSemantico("Clase " + $2.sval + " ya definida en el ambito actual");
                                               }
                                              int index = ambitoAct.lastIndexOf(":");
                                              ambitoAct = ambitoAct.substring(0, index);
                                              }

                         ;

FuncionSinCuerpo: EncabezadoFuncion Parametro {AnalizadorLexico.agregarEstructura("Reconoce Funcion sin cuerpo");}
                  //si hay un parentesis mal escrito lo reconoce Funcion.
                  ;

FuncionIMPL: IMPL FOR ID ':' '{' Funcion '}' {AnalizadorLexico.agregarEstructura("Reconoce funcion IMPL");}
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

   public String estaAlAlcance(String lexema){ //EN CASO DE QUE ESTE AL ALCANCE DEVUELVE EL LEXEMA CORRECTO, CASO CONTRARIO DEVUELVE EL NOMBRE DE LA VARIABLE SOLA
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