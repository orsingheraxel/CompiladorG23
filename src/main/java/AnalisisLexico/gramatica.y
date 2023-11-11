%{
package AnalisisLexico;
import AnalisisLexico.TablaSimbolos.TablaSimbolos;
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
        | '{'ListSentencias {AnalizadorLexico.agregarErrorSintactico("Se espera '}' ");}
	    | ListSentencias '}' {AnalizadorLexico.agregarErrorSintactico("Se espera '{' ");}
	    | ListSentencias {AnalizadorLexico.agregarErrorSintactico("Se esperan '{' '}' ");}
	    |'{''}' {AnalizadorLexico.agregarErrorSintactico("Programa vacio ");}
        ;

ListSentencias: Sentencia ','{$$=$1;}
		| Sentencia ',' ListSentencias {$$ = new NodoComun("Sentencia", (Nodo) $1, (Nodo) $3);}
		| Sentencia  {AnalizadorLexico.agregarErrorSintactico("Se esperaba una ',' al final de la linea ");}
        ;

Sentencia: SentenciaControl {$$=$1;}
        | SentenciaEjecutable {$$=$1;}
        | SentenciaDeclarativa {$$=$1;}
        ;

ReferenciaObjeto: ID '.' ID {AnalizadorLexico.agregarEstructura("Reconoce referencia objeto ");}
                ;

ReferenciaObjetoFuncion: ID '.' LlamadoFuncion { $$ = new NodoComun("ReferenciaFuncionObjeto",(Nodo)$1,(Nodo)$3);
                                                AnalizadorLexico.agregarEstructura("Reconoce llamado a funcion de clase ");}
                       ;

SentenciaEjecutable: Asignacion
                  | LlamadoFuncion
                  | BloqueIF   {$$=$1;}
		          | SalidaMensaje {$$=$1;}
                  | ReferenciaObjetoFuncion {$$=$1;}
                  ;

SentenciaDeclarativa: Tipo ListVariables {  while (((ListVariables)$2).getVariable() != null) { //CHEQUAER SI UNA VARIABLE CON ESE LEXEMA YA TIENE SETEADO EL USO, SI LO TIENE SETEADO ES PORQ YA EXITE
                                                String var = ((ListVariables)$2).getVariable();
                                                Token t = TablaSimbolos.getToken(var);
                                                if (t != null){
                                                    t.setLexema($1.sval + ":" + ambitoAct);
                                                    t.setAmbito(ambitoAct);
                                                    t.setUso("variable");
                                                    t.setTipo($1.sval);
                                                    TablaSimbolos.removeToken(var);
                                                    TablaSimbolos.addSimbolo(t.getLexema(),t);
                                                    }
                                                else {
                                                   agregarErrorSemantico("Ya existe una variable + var + definida en este ambito");
                                                    }
                                            }
                                          }
			| Funcion
			| ListVariables{AnalizadorLexico.agregarErrorSintactico("Se espera el tipo de la variable ");}
			| Tipo  {AnalizadorLexico.agregarErrorSintactico("Se espera identificador de la variable ");}
			| HerenciaComposicion
			| Objeto_clase
			| FuncionIMPL
            ;

ListVariables : ID { $$ = new ListVariables();
                    ((ListVariables)$$).addVariable($1.sval);}
              | ID ';' ListVariables {$$ = $3 ; ((ListVariables)$$).addVariable($1.sval);}
              ;

Objeto_clase: ID ListVariables
    ;

Tipo : USHORT
     | INT
     | DOUBLE
     ;

Constante: ENTERO {$$ = new NodoHoja($1.sval) ; chequearEnteroPositivo($1.sval);}
	| ENTEROCORTO {$$ = new NodoHoja($1.sval) ; chequearEnteroCorto($1.sval);}
	| '-' ENTEROCORTO {AnalizadorLexico.agregarErrorLexico("Un entero corto no puede ser negativo ");}
	| PUNTOFLOTANTE{$$ = new NodoHoja($1.sval) ; chequearDouble($1.sval);}
	| '-' ENTERO {$$ = new NodoHoja($1.sval) ;chequearEnteroNegativo($2.sval);}
	| '-' PUNTOFLOTANTE {$$ = new NodoHoja($1.sval) ; chequearDouble($2.sval);}
	;

Expresion: Termino '+' Expresion { $$ = new NodoComun("+",(Nodo)$1,(Nodo)$3);
                                    if (!(((Nodo)$1).getTipo().equals(((Nodo)$3).getTipo()))){
                                        agregarErrorSemantico("No se puede realizar la suma. Tipos incompatibles.");//hacer conversiones cuando sea posible
                                    }
                                    }
| Termino '-' Expresion {$$ = new NodoComun("-",(Nodo)$1,(Nodo)$3);}
| Termino {$$=$1;}
| ConversionExplicita {$$ = $1;}
        ;


Termino: Factor '*' Termino {/*
                                yyval = new NodoComun("*",(Nodo)val_peek(2), (Nodo)val_peek(0))
                                 if (!(((Nodo)val_peek(2)).getTipo().equals(((Nodo)val_peek(0)).getTipo())))
                                   if Not conversion valida
                                                                     agregarErrorSemantico("No se puede realizar la multiplicacion. Tipos incompatibles.");
                                                             else {
                                                                 ((Nodo)yyval).setTipo(((Nodo)val_peek(2)).getTipo());
                                                             } */
                            }
| Factor '/' Termino
| Factor {$$ = $1;}
| Factor_RefObjeto '*' Termino
| Factor_RefObjeto '/' Termino
| Factor_RefObjeto
;

Factor: ID //chequear si existe la variable, y a su vez ver si esta al alcance (chequear ambito)
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
            | '(' Expresion Comparador Expresion {AnalizadorLexico.agregarErrorSintactico("Se esperaba una ')' ");}
            | Expresion Comparador Expresion ')' {AnalizadorLexico.agregarErrorSintactico("Se esperaba una '(' ");}
	  ;

BloqueIF: IF Condicion ListSentenciasIF ELSE ListSentenciasIF END_IF {Nodo SentenciasIF = new NodoComun("SentenciasIF",new NodoControl("SentenciasIF",(Nodo)$3), new NodoControl("SentenciasELSE",(Nodo)$5));
                                                                      $$= new NodoComun("BloqueIF", new NodoControl("Condicion",(Nodo)$2), SentenciasIF);
                                                                      AnalizadorLexico.agregarEstructura("Reconoce IF ELSE ");}
	    | IF Condicion ListSentenciasIF END_IF {$$= new NodoComun("BloqueIF", new NodoControl("Condicion",(Nodo)$2), new NodoControl("SentenciasIF",(Nodo)$3));
	                                            AnalizadorLexico.agregarEstructura("Reconoce IF ");}
        ;

ListSentenciasIF: '{' SentenciasIF '}'
		        |  SentenciasIF '}' {AnalizadorLexico.agregarErrorSintactico("Falta un '{'"); }
                | '{' '}' {AnalizadorLexico.agregarErrorSintactico("No hay sentencias dentro de las llaves."); }
                ;

SentenciasIF: ListaSentencias
                ;

ListaSentencias: SentenciaEjecutable ',' 
               | SentenciaEjecutable ',' ListaSentencias
               | SentenciaEjecutable ListaSentencias {AnalizadorLexico.agregarErrorSintactico("Falta una ','"); }
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

Funcion: VOID ID Parametro CuerpoFuncion { String ambito = $2.sval;
                                            actualizarAmbito(ambitoAct, ambito);
                                            //chequear si las variables pasadas por parametro estan en el ambito anterior

                                            $$ = new NodoComun("Funcion", new NodoControl("ParametroFuncion", (Nodo)$3), new NodoControl("SentenciasFuncion",(Nodo)$3));

                                            if (!TablaSimbolos.existeSimbolo($2.sval+":"+ambitoAct)){
                                                ((Nodo)$2).setLexema($2.sval+":"+ambitoAct);
                                                ((Nodo)$2).setUso("Funcion");
                                                TablaSimbolos.setAmbito($2.sval+":"+ambitoAct, ambitoAct);
                                            }

                                            AnalizadorLexico.agregarEstructura("Reconoce funcion VOID ");}

      | VOID ID '(' ')' CuerpoFuncion  {    String ambito = $2.sval;
                                            actualizarAmbito(ambitoAct, ambito);
                                            //chequear si las variables pasadas por parametro estan en el ambito anterior

                                            $$ = new NodoComun("Funcion", new NodoControl("ParametroFuncion", (Nodo)$3), new NodoControl("SentenciasFuncion",(Nodo)$3));

                                            if (!TablaSimbolos.existeSimbolo($2.sval+":"+ambitoAct)){
                                                ((Nodo)$2).getToken().setLexema($2.sval+":"+ambitoAct);
                                                ((Nodo)$2).setUso("Funcion");
                                                TablaSimbolos.setAmbito($2.sval+":"+ambitoAct, ambitoAct);
                                            }

                                            AnalizadorLexico.agregarEstructura("Reconoce funcion VOID ");}
      ;


Parametro: '(' Tipo ID ')' {	$$ = new NodoHoja($3.sval);

                           }
        | '(' Tipo ID {AnalizadorLexico.agregarErrorSintactico("Se esperaba un ')' ");}
        |  Tipo ID ')' {AnalizadorLexico.agregarErrorSintactico("Se esperaba un '(' ");}
        ;

CuerpoFuncion: '{' ListSentenciasFuncion '}'
		|  ListSentenciasFuncion '}' {AnalizadorLexico.agregarErrorSintactico("Se esperaba un '{' ");}
                  ;

ListSentenciasFuncion:SentenciaDeclarativa ',' ListSentenciasFuncion
		  | SentenciaEjecutable ',' ListSentenciasFuncion
		  | SentenciaEjecutable ','
		  | SentenciaDeclarativa ','
		  | RETURN ','
		  | RETURN ',' ListSentenciasFuncion
		  | SentenciaEjecutable {AnalizadorLexico.agregarErrorSintactico("Se esperaba una ',' al final de la linea ");}
          | SentenciaDeclarativa {AnalizadorLexico.agregarErrorSintactico("Se esperaba una ',' al final de la linea ");}
          ;



LlamadoFuncion: ID '(' ')' {AnalizadorLexico.agregarEstructura("Reconoce llamado funcion ");}
            | ID LlamadoExpresion  {AnalizadorLexico.agregarEstructura("Reconoce llamado funcion ");}

SalidaMensaje: PRINT CADENA {$$ = new NodoControl("PRINT", new NodoHoja($2.sval));
                             AnalizadorLexico.agregarEstructura("Reconoce salida de mensaje por pantalla ");}
            | PRINT Factor {$$ = new NodoControl("PRINT", new NodoHoja($2.sval));
                            AnalizadorLexico.agregarEstructura("Reconoce salida de mensaje por pantalla ");}
            ;

OperadorAsignacion: '=' {$$=$1;}
                  | ASIG {$$=$1;}
                  ;

Asignacion: ID OperadorAsignacion Expresion {//Chequear ambito de ID y chequear asignacion valida
						/* $$ = new NodoComun($2.sval,(Nodo)$1,(Nodo)$3);
						Token t = TablaSimbolos.getToken($1.sval);
						if (t.getTipo() != null){
							if (t.getLexema() ...) //ambito alcanzable
								//chequear tipo expresion?
								//set uso
						}
						else{
							agregarErrorSemantico("Variable " + var + " no definida"); //SE DEBE CORTAR LA EJECUCION
						    //break;
						}
                        */
					    }
	| ReferenciaObjeto OperadorAsignacion ReferenciaObjeto
	| ReferenciaObjeto OperadorAsignacion Factor
	;

SentenciaControl: DO ListSentenciasIF UNTIL Condicion {$$=new NodoComun("Sentencia DO UNTIL", new NodoControl("ListSentenciasDO",(Nodo)$2), new NodoControl("CondicionDO", (Nodo)$4));
                                                        AnalizadorLexico.agregarEstructura("Reconoce funcion DO UNTIL");}
                  |DO ListSentenciasIF UNTIL {AnalizadorLexico.agregarErrorSintactico("Se esperaba una condicion ");}
                  ;

//TEMA 29 --------------------------------------------------

LlamadoExpresion:'(' Expresion ')' {}
		| Expresion ')' {AnalizadorLexico.agregarErrorSintactico("Se esperaba un '(' ");}
		;

ConversionExplicita: TOD LlamadoExpresion { $$ = new NodoControl("TOD",(Nodo)$2);
                                            AnalizadorLexico.agregarEstructura("Reconoce funcion TOD ");
                                            }

                  | TOD '(' ')' {AnalizadorLexico.agregarErrorSintactico("Se esperaba una Expresion ");}
                  ;

ListHerencia:'{' SentenciaListHerencia '}'
		//| SentenciaListHerencia '}' {AnalizadorLexico.agregarErrorSintactico("Se esperaba un '}' ");}
		;

SentenciaListHerencia: Tipo ListVariables ','
		| Tipo ListVariables ',' SentenciaListHerencia
		| ListFuncion ','
		| ListFuncion ',' SentenciaListHerencia
        ;

HerenciaComposicion: CLASS ID ListHerencia   { String ambito = $2.sval;
                                                actualizarAmbito(ambitoAct, ambito);
                                                AnalizadorLexico.agregarEstructura("Reconoce CLASE");}

                  ;

FuncionSinCuerpo: VOID ID  Parametro {AnalizadorLexico.agregarEstructura("Reconoce Funcion sin cuerpo");}
                  | VOID ID '(' ')' {AnalizadorLexico.agregarEstructura("Reconoce Funcion sin cuerpo");}
                  ;

FuncionIMPL: IMPL FOR ID ':' '{' Funcion '}' {AnalizadorLexico.agregarEstructura("Reconoce funcion IMPL");}
            | IMPL FOR ID ':' Funcion '}' {AnalizadorLexico.agregarErrorSintactico("Se esperaba un '{' ");}
		;

//TEMA 21 ----------------------------------------------------

/*  Forward declaration => Es simplemente utilizar la regla de sentencias declarativas;
  			   ya que en esta etapa solo controlamos sintaxis
*/

%%
  private NodoControl raiz;
  private String ambitoAct = "main";
  static ArrayList<Error> erroresSemanticos = new ArrayList<Error>();

  public void agregarErrorSemantico(String error){
      Error e = new Error(error,AnalizadorLexico.getLineaAct());
      erroresSemanticos.add(e);
    }

   public String buscarAmbito(String ambitoAct,String lexema){
            String ambito = ambitoAct;
            while(!TablaSimbolos.existeSimbolo(lexema+":"+ambito)){
                    if(ambito.equals("main")){
                            //yyerror("La variable " + lexema + " no se encuentra declarada en el ambito " + ambitoAct);
                            ambito = "";
                            break;
                    }else{
                            //retrocede de ambito hasta encontrar el correcto
                            char [] a = ambito.toCharArray();
                            for (int i = a.length;i>=0;i--){
                                    if(a[i-1] == ':'){
                                            ambito = ambito.substring(0,i-1);
                                            break;
                                    }
                            }
                    }
            }
            return ambito;
    }

   public void chequearEnteroNegativo(String m){
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
   }

   public void chequearEnteroPositivo(String m){
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
   }

   public void chequearEnteroCorto(String m){
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
         }

   public void chequearDouble(String m){
           String n = m.replace('D', 'e').replace('d','e');
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
      }

   public void actualizarAmbito(String ambitoAct, String a){
        ambitoAct += ":"+a;
   }

  public int yylex() throws IOException{
    Token t = AnalizadorLexico.obtenerToken();
    this.yylval = new ParserVal(t.getLexema());
    return t.getId();
  }

  public static void yyerror(String error){
    System.out.println(error);
  }