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
Programa:'{' ListSentencias '}'
        | '{'ListSentencias {agregarErrorSintactico("Se espera '}' en la linea ");}
	    | ListSentencias '}' {agregarErrorSintactico("Se espera '{' en la linea ");}
	    | ListSentencias {agregarErrorSintactico("Se esperan '{' '}' en la linea ");}
        ;

ListSentencias: Sentencia ','
		| Sentencia ',' ListSentencias
		| Sentencia  {agregarErrorSintactico("Se esperaba una ',' al final de la linea ");}
        ;

Sentencia: SentenciaControl
        | SentenciaEjecutable
        | SentenciaDeclarativa
        ;

ReferenciaObjeto: ID '.' ID
                ;

ReferenciaObjetoFuncion: ID '.' LlamadoFuncion
                       ;

SentenciaEjecutable: Asignacion
                  | LlamadoFuncion
                  | BloqueIF
		  | SalidaMensaje
                  | ReferenciaObjetoFuncion
                  ;

SentenciaDeclarativa: Tipo ListVariables
			| Funcion
			| ListVariables  {agregarErrorSintactico("Se espera el tipo de la variable en la linea ");}
			| Tipo  {agregarErrorSintactico("Se espera identificador de la variable en la linea ");}
			| HerenciaComposicion
			| Objeto_clase
            ;

ListVariables : ID
              | ID ';' ListVariables
              ;

Objeto_clase: ID ListVariables
    ;

Tipo : USHORT
     | INT
     | DOUBLE
     ;

Constante: ENTERO{chequearEnteroPositivo($1.sval);}
	| ENTEROCORTO
	| '-' ENTEROCORTO {agregarErrorLexico("Un entero corto no puede ser negativo en la linea ");}
	| PUNTOFLOTANTE{chequearDoublePositivo($1.sval);}
	| '-' ENTERO {chequearEnteroNegativo($2.sval);}
	| '-' PUNTOFLOTANTE {chequearDoubleNegativo($2.sval);}
	;

Expresion: Termino '+' Expresion
| Termino '-' Expresion
| Termino
|ConversionExplicita
        ;


Termino: Factor '*' Termino
| Factor '/' Termino
| Factor
| Factor_RefObjeto '*' Termino
| Factor_RefObjeto '/' Termino
| Factor_RefObjeto
;

Factor: ID
	| Constante
	;

Factor_RefObjeto: ReferenciaObjeto
                ;

Condicion : Expresion Comparador Expresion
	  ;

BloqueIF: IF '(' Condicion ')' '{' ListSentenciasIF '}' ELSE '{' ListSentenciasIF '}' END_IF {agregarEstructura("Reconoce ELSE IF ");}
	| IF '(' Condicion ')' '{' ListSentenciasIF '}' END_IF {agregarEstructura("Reconoce IF ");}
        ;

ListSentenciasIF: SentenciaEjecutable ','
                  | SentenciaEjecutable ',' ListSentenciasIF
                  |SentenciaEjecutable {agregarErrorSintactico("Se esperaba una ',' al final de la linea ");}
                  ;

Comparador: '<'
          | '>'
          | MAYORIGUAL
          | MENORIGUAL
          | IGUAL
          | DIST
          ;

ListFuncion: Funcion
	| FuncionSinCuerpo
	| FuncionSinCuerpo ListFuncion
	| Funcion ListFuncion
	;

Funcion: VOID ID '(' Parametro ')''{' CuerpoFuncion '}' {agregarEstructura("Reconoce funcion VOID ");}
      |VOID ID '(' ')''{' CuerpoFuncion '}'{agregarEstructura("Reconoce funcion VOID ");}
      ;


Parametro: Tipo ID;

CuerpoFuncion: ListSentenciasFuncion
                  ;

ListSentenciasFuncion:SentenciaDeclarativa ',' ListSentenciasFuncion
		  | SentenciaEjecutable ',' ListSentenciasFuncion
		  | SentenciaEjecutable ','
		  | SentenciaDeclarativa ','
		  | RETURN ','
		  | RETURN ',' ListSentenciasFuncion
		  | SentenciaEjecutable {agregarErrorSintactico("Se esperaba una ',' al final de la linea ");}
          | SentenciaDeclarativa {agregarErrorSintactico("Se esperaba una ',' al final de la linea ");}
          ;

LlamadoFuncion: ID '(' ')'
            | ID '(' Expresion ')'
            ;

SalidaMensaje: PRINT CADENA
            | PRINT Factor
            ;

OperadorAsignacion: '='
                  | ASIG
                  ;

Asignacion: ID OperadorAsignacion Expresion
	| ReferenciaObjeto OperadorAsignacion ReferenciaObjeto
	| ReferenciaObjeto OperadorAsignacion Factor
	;

SentenciaControl: DO '{' ListSentenciasIF '}' UNTIL '(' Condicion ')' {agregarEstructura("Reconoce funcion DO UNTIL");}
                  |DO '{' ListSentenciasIF '}' UNTIL {agregarErrorSintactico("Se esperaba una condicion ");}
                  ;

//TEMA 29 --------------------------------------------------

ConversionExplicita: TOD '(' Expresion ')' {agregarEstructura("Reconoce funcion TOD ");}
                  | TOD '(' ')' {agregarErrorSintactico("Se esperaba una Expresion ");}
                  ;

ListHerencia: Tipo ListVariables
		|FuncionIMPL
		|FuncionIMPL ',' ListHerencia
		| Tipo ListVariables ',' ListHerencia
		| ListFuncion ','
		| ListFuncion ',' ListHerencia
        ;

HerenciaComposicion: CLASS ID '{' ListHerencia '}'  {agregarEstructura("Reconoce CLASE");}
                  | CLASS ID
                  ;

FuncionSinCuerpo: VOID ID '(' Parametro ')' ',' {agregarEstructura("Reconoce Funcion sin cuerpo");}
                  |VOID ID '(' ')' ','
                  ;

FuncionIMPL: IMPL FOR ID ':' '{' Funcion '}' {agregarEstructura("Reconoce funcion IMPL");}
		;

//TEMA 21 ----------------------------------------------------

/*  Forward declaration => Es simplemente utilizar la regla de sentencias declarativas;
  			   ya que en esta etapa solo controlamos sintaxis
*/

%%

  static ArrayList<Error> erroresLexicos = new ArrayList<Error>();
  static ArrayList<Error> erroresSintacticos = new ArrayList<Error>();
  static ArrayList<String> estructuraReconocida = new ArrayList<String>();

   public void chequearEnteroNegativo(String m){
          Integer numero = Integer.parseInt(m);
          if (numero <= 32767){
               if (TablaSimbolos.existeSimbolo(m)) {
                     TablaSimbolos.addAtributo(m, AccionSemantica.PUNTOFLOTANTE, AnalizadorLexico.getLineaAct());
               } else {
                     TablaSimbolos.addNuevoSimbolo(m);
                     TablaSimbolos.addAtributo(m, AccionSemantica.PUNTOFLOTANTE, AnalizadorLexico.getLineaAct());
               }
          } else {
               AnalizadorLexico.agregarErrorLexico("Entero negativo fuera de rango");
          }
   }

   public void chequearEnteroPositivo(String m){
             Integer numero = Integer.parseInt(m);
             if (numero >= 32767){
                  if (TablaSimbolos.existeSimbolo(m)) {
                        TablaSimbolos.addAtributo(m, AccionSemantica.PUNTOFLOTANTE, AnalizadorLexico.getLineaAct());
                  } else {
                        TablaSimbolos.addNuevoSimbolo(m);
                        TablaSimbolos.addAtributo(m, AccionSemantica.PUNTOFLOTANTE, AnalizadorLexico.getLineaAct());
                  }
             } else {
                  AnalizadorLexico.agregarErrorLexico("Entero positivo fuera de rango");
             }
      }

   public void chequearDoubleNegativo(String m){
        String n = m.replace('D', 'e').replace('d','e');
        Double numero = Double.parseDouble(n);
        if (((numero <= 2.2250738585072014e-308) && (numero >= 1.7976931348623157e+308)) || numero == 0.0) {
             if (TablaSimbolos.existeSimbolo(m)) {
                   TablaSimbolos.addAtributo(m, AccionSemantica.PUNTOFLOTANTE, AnalizadorLexico.getLineaAct());
             } else {
                   TablaSimbolos.addNuevoSimbolo(m);
                   TablaSimbolos.addAtributo(m, AccionSemantica.PUNTOFLOTANTE, AnalizadorLexico.getLineaAct());
             }
        } else {
             AnalizadorLexico.agregarErrorLexico("Double negativo fuera de rango");
        }
   }

   public void chequearDoublePositivo(String m){
           String n = m.replace('D', 'e').replace('d','e');
           Double numero = Double.parseDouble(n);
           if (((numero >= 2.2250738585072014e-308) && (numero <= 1.7976931348623157e+308)) || numero == 0.0){
                if (TablaSimbolos.existeSimbolo(m)) {
                      TablaSimbolos.addAtributo(m, AccionSemantica.PUNTOFLOTANTE, AnalizadorLexico.getLineaAct());
                } else {
                      TablaSimbolos.addNuevoSimbolo(m);
                      TablaSimbolos.addAtributo(m, AccionSemantica.PUNTOFLOTANTE, AnalizadorLexico.getLineaAct());
                }
           } else {
                AnalizadorLexico.agregarErrorLexico("Double positivo fuera de rango");
           }
      }

   public static void agregarErrorLexico(String error){
          Error e = new Error(error, AnalizadorLexico.getLineaAct());
          erroresLexicos.add(e);
   }

   public static void agregarErrorSintactico(String error){
          Error e = new Error(error, AnalizadorLexico.getLineaAct());
          erroresSintacticos.add(e);
   }

   public static void agregarEstructura(String error){
             estructuraReconocida.add(error);
   }

  public int yylex() throws IOException{
    Token t = AnalizadorLexico.obtenerToken();
    this.yylval = new ParserVal(t.getLexema());
    return t.getId();
  }

  public static void yyerror(String error){
    System.out.println(error);
  }