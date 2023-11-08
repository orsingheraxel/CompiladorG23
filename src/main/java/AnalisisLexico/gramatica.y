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
        | '{'ListSentencias {$$=new NodoHoja("Error sintactico"); AnalizadorLexico.agregarErrorSintactico("Se espera '}' ");}
	    | ListSentencias '}' {$$=new NodoHoja("Error sintactico"); AnalizadorLexico.agregarErrorSintactico("Se espera '{' ");}
	    | ListSentencias {$$=new NodoHoja("Error sintactico"); AnalizadorLexico.agregarErrorSintactico("Se esperan '{' '}' ");}
	    |'{''}' {$$=new NodoHoja("Error sintactico"); AnalizadorLexico.agregarErrorSintactico("Programa vacio ");}
        ;

ListSentencias: Sentencia ','{$$=$1;}
		| Sentencia ',' ListSentencias {$$ = new NodoComun("Sentencia", (Nodo) $1, (Nodo) $3);}
		| Sentencia  {$$=new NodoHoja("Error sintactico"); AnalizadorLexico.agregarErrorSintactico("Se esperaba una ',' al final de la linea ");}
        ;

Sentencia: SentenciaControl {$$=$1;}
        | SentenciaEjecutable {$$=$1;}
        | SentenciaDeclarativa {$$=$1;}
        ;

ReferenciaObjeto: ID '.' ID {    /* $$= new NodoComun($2.sval,(Nodo)$1,(Nodo)$3);
                                 ((Nodo)$$).setTipo(((Nodo)$1).getTipo());
                                 ((Nodo)$$).setUso("Condicion");
                                 if (!((((ArbolSintactico)$1).getTipo()).equals(((ArbolSintactico)$3).getTipo()))){
                                    AnalizadorLexico.agregarErrorSemantico("error en la comparacion entre expresiones de distintos tipos ");
                                 } */
                                AnalizadorLexico.agregarEstructura("Reconoce referencia objeto ");}
                ;

ReferenciaObjetoFuncion: ID '.' LlamadoFuncion {AnalizadorLexico.agregarEstructura("Reconoce llamado a funcion de clase ");}
                       ;

SentenciaEjecutable: Asignacion
                  | LlamadoFuncion
                  | BloqueIF   {$$=$1;}
		          | SalidaMensaje
                  | ReferenciaObjetoFuncion
                  ;

SentenciaDeclarativa: Tipo ListVariables { for (String e : ListVariables){
                                                e.setTipo($1.sval);
                                            }
                                          }
			| Funcion
			| ListVariables  {$$=new NodoHoja("Error sintactico"); AnalizadorLexico.agregarErrorSintactico("Se espera el tipo de la variable ");}
			| Tipo  {$$=new NodoHoja("Error sintactico"); AnalizadorLexico.agregarErrorSintactico("Se espera identificador de la variable ");}
			| HerenciaComposicion {$$ = new NodoHoja("Sentencia declarativa");}
			| Objeto_clase {$$ = new NodoHoja("Sentencia declarativa");}
			| FuncionIMPL {$$ = new NodoHoja("Sentencia declarativa");}
            ;

ListVariables : ID
              | ID ';' ListVariables
              ;

Objeto_clase: ID ListVariables
    ;

Tipo : USHORT {$$ = new NodoHoja($1.sval) ; (NodoHoja)$$.getToken().setTipo("Entero corto");}
     | INT {$$ = new NodoHoja($1.sval); (NodoHoja)$$.getToken().setTipo("Entero");}
     | DOUBLE {$$ = new NodoHoja($1.sval); (NodoHoja)$$.getToken().setTipo("Punto flotante");}
     ;

Constante: ENTERO {$$ = new NodoHoja($1.sval) ; chequearEnteroPositivo($1.sval);}
	| ENTEROCORTO {$$ = new NodoHoja($1.sval) ; chequearEnteroCorto($1.sval);}
	| '-' ENTEROCORTO {$$ = new NodoHoja($1.sval) ; $$=new NodoHoja("Error sintactico"); AnalizadorLexico.agregarErrorLexico("Un entero corto no puede ser negativo ");}
	| PUNTOFLOTANTE{$$ = new NodoHoja($1.sval) ; chequearDouble($1.sval);}
	| '-' ENTERO {$$ = new NodoHoja($1.sval) ;chequearEnteroNegativo($2.sval);}
	| '-' PUNTOFLOTANTE {$$ = new NodoHoja($1.sval) ; chequearDouble($2.sval);}
	;

Expresion: Termino '+' Expresion
| Termino '-' Expresion
| Termino {$$=$1;}
| ConversionExplicita
        ;


Termino: Factor '*' Termino
| Factor '/' Termino
| Factor {$$ = $1;}
| Factor_RefObjeto '*' Termino
| Factor_RefObjeto '/' Termino
| Factor_RefObjeto
;

Factor: ID
	| Constante {$$=$1;}
	;

Factor_RefObjeto: ReferenciaObjeto {$$=$1;}
                ;

Condicion : '(' Expresion Comparador Expresion ')' { $$ = new NodoComun($3.sval,(Nodo)$2,(Nodo)$4);
                                                    ((Nodo)$$).getToken().setTipo(((Nodo)$2).getTipo());
                                                    ((Nodo)$$).getToken().setUso("Condicion");
                                                     if (!((((Nodo)$2).getToken().getTipo()).equals(((Nodo)$4).getToken().getTipo()))){
                                                         AnalizadorLexico.agregarErrorSemantico("Error en la comparacion entre expresiones de distintos tipos");
                                                     }
                                                     }
            | '(' Expresion Comparador Expresion {$$=new NodoHoja("Error sintactico"); AnalizadorLexico.agregarErrorSintactico("Se esperaba una ')' ");}
            | Expresion Comparador Expresion ')' {$$=new NodoHoja("Error sintactico"); AnalizadorLexico.agregarErrorSintactico("Se esperaba una '(' ");}
	  ;

BloqueIF: IF Condicion ListSentenciasIF ELSE ListSentenciasIF END_IF {Nodo SentenciasIF = new NodoComun("SentenciasIF",new NodoControl("SentenciasIF",(Nodo)$3, new NodoControl("SentenciasELSE",(Nodo)$5);
                                                                      $$= NodoComun("BloqueIF", new NodoControl("Condicion",(Nodo)$2), SentenciasIF);
                                                                      AnalizadorLexico.agregarEstructura("Reconoce IF ELSE ");}
	    | IF Condicion ListSentenciasIF END_IF {$$=NodoComun("BloqueIF", new NodoControl("Condicion",(Nodo)$2), new NodoControl("SentenciasIF",(Nodo)$3);
	                                            AnalizadorLexico.agregarEstructura("Reconoce IF ");}
        ;

ListSentenciasIF: '{' SentenciasIF '}'
		        |  SentenciasIF '}' {$$=new NodoHoja("Error sintactico"); AnalizadorLexico.agregarErrorSintactico("Falta un '{'"); }
                | '{' '}' {$$=new NodoHoja("Error sintactico"); AnalizadorLexico.agregarErrorSintactico("No hay sentencias dentro de las llaves."); }
                ;

SentenciasIF: ListaSentencias
                ;

ListaSentencias: SentenciaEjecutable ','
               | SentenciaEjecutable ',' ListaSentencias
               | SentenciaEjecutable ListaSentencias {$$=new NodoHoja("Error sintactico"); AnalizadorLexico.agregarErrorSintactico("Falta una ','"); }
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

Funcion: VOID ID  Parametro CuerpoFuncion {AnalizadorLexico.agregarEstructura("Reconoce funcion VOID ");}
      | VOID ID '(' ')' CuerpoFuncion  {AnalizadorLexico.agregarEstructura("Reconoce funcion VOID ");}
      ;


Parametro: '(' Tipo ID ')' {$$ = new NodoHoja($3.sval)
                            ()}
        | '(' Tipo ID {$$=new NodoHoja("Error sintactico"); AnalizadorLexico.agregarErrorSintactico("Se esperaba un ')' ");}
        |  Tipo ID ')' {$$=new NodoHoja("Error sintactico"); AnalizadorLexico.agregarErrorSintactico("Se esperaba un '(' ");}
        ;

CuerpoFuncion: '{' ListSentenciasFuncion '}'
		|  ListSentenciasFuncion '}' {$$=new NodoHoja("Error sintactico"); AnalizadorLexico.agregarErrorSintactico("Se esperaba un '{' ");}
                  ;

ListSentenciasFuncion:SentenciaDeclarativa ',' ListSentenciasFuncion
		  | SentenciaEjecutable ',' ListSentenciasFuncion
		  | SentenciaEjecutable ','
		  | SentenciaDeclarativa ','
		  | RETURN ','
		  | RETURN ',' ListSentenciasFuncion
		  | SentenciaEjecutable {$$=new NodoHoja("Error sintactico"); AnalizadorLexico.agregarErrorSintactico("Se esperaba una ',' al final de la linea ");}
          | SentenciaDeclarativa {$$=new NodoHoja("Error sintactico"); AnalizadorLexico.agregarErrorSintactico("Se esperaba una ',' al final de la linea ");}
          ;



LlamadoFuncion: ID '(' ')' {AnalizadorLexico.agregarEstructura("Reconoce llamado funcion ");}
            | ID LlamadoExpresion  {AnalizadorLexico.agregarEstructura("Reconoce llamado funcion ");}

SalidaMensaje: PRINT CADENA {AnalizadorLexico.agregarEstructura("Reconoce salida de mensaje por pantalla ");}
            | PRINT Factor {AnalizadorLexico.agregarEstructura("Reconoce salida de mensaje por pantalla ");}
            ;

OperadorAsignacion: '=' {$$=$1;}
                  | ASIG {$$=$1;}
                  ;

Asignacion: ID OperadorAsignacion Expresion
	| ReferenciaObjeto OperadorAsignacion ReferenciaObjeto
	| ReferenciaObjeto OperadorAsignacion Factor
	;

SentenciaControl: DO ListSentenciasIF UNTIL Condicion {$$=new NodoComun("Sentencia DO UNTIL", new NodoControl("ListSentenciasDO",(Nodo)$2), new NodoControl("CondicionDO", (Nodo)$4));
                                                        AnalizadorLexico.agregarEstructura("Reconoce funcion DO UNTIL");}
                  |DO ListSentenciasIF UNTIL {$$=new NodoHoja("Error sintactico"); AnalizadorLexico.agregarErrorSintactico("Se esperaba una condicion ");}
                  ;

//TEMA 29 --------------------------------------------------

LlamadoExpresion:'(' Expresion ')'
		| Expresion ')' {$$=new NodoHoja("Error sintactico"); AnalizadorLexico.agregarErrorSintactico("Se esperaba un '(' ");}
		;

ConversionExplicita: TOD LlamadoExpresion {AnalizadorLexico.agregarEstructura("Reconoce funcion TOD ");}
                  | TOD '(' ')' {$$=new NodoHoja("Error sintactico"); AnalizadorLexico.agregarErrorSintactico("Se esperaba una Expresion ");}
                  ;

ListHerencia:'{' SentenciaListHerencia '}'
		//| SentenciaListHerencia '}' {$$=new NodoHoja("Error sintactico"); AnalizadorLexico.agregarErrorSintactico("Se esperaba un '}' ");}
		;

SentenciaListHerencia: Tipo ListVariables ','
		| Tipo ListVariables ',' SentenciaListHerencia
		| ListFuncion ','
		| ListFuncion ',' SentenciaListHerencia
        ;

HerenciaComposicion: CLASS ID  ListHerencia   {AnalizadorLexico.agregarEstructura("Reconoce CLASE");}

                  ;

FuncionSinCuerpo: VOID ID  Parametro {AnalizadorLexico.agregarEstructura("Reconoce Funcion sin cuerpo");}
                  | VOID ID '(' ')' {AnalizadorLexico.agregarEstructura("Reconoce Funcion sin cuerpo");}
                  ;

FuncionIMPL: IMPL FOR ID ':' '{' Funcion '}' {AnalizadorLexico.agregarEstructura("Reconoce funcion IMPL");}
            | IMPL FOR ID ':' Funcion '}' {$$=new NodoHoja("Error sintactico"); AnalizadorLexico.agregarErrorSintactico("Se esperaba un '{' ");}
		;

//TEMA 21 ----------------------------------------------------

/*  Forward declaration => Es simplemente utilizar la regla de sentencias declarativas;
  			   ya que en esta etapa solo controlamos sintaxis
*/

%%
  private NodoControl raiz;
  static ArrayList<Error> erroresLexicos = new ArrayList<Error>();
  static ArrayList<Error> erroresSintacticos = new ArrayList<Error>();
  static ArrayList<String> estructuraReconocida = new ArrayList<String>();

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

  public int yylex() throws IOException{
    Token t = AnalizadorLexico.obtenerToken();
    this.yylval = new ParserVal(t.getLexema());
    return t.getId();
  }

  public static void yyerror(String error){
    System.out.println(error);
  }