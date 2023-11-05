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
Programa:'{' ListSentencias '}' {AnalizadorLexico.agregarEstructura("Reconoce programa ");}
        | '{'ListSentencias {AnalizadorLexico.agregarErrorSintactico("Se espera '}' en la linea ");}
	    | ListSentencias '}' {AnalizadorLexico.agregarErrorSintactico("Se espera '{' en la linea ");}
	    | ListSentencias {AnalizadorLexico.agregarErrorSintactico("Se esperan '{' '}' en la linea ");}
        ;

ListSentencias: Sentencia ','
		| Sentencia ',' ListSentencias
		| Sentencia  {AnalizadorLexico.agregarErrorSintactico("Se esperaba una ',' al final de la linea ");}
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
			| ListVariables  {AnalizadorLexico.agregarErrorSintactico("Se espera el tipo de la variable en la linea ");}
			| Tipo  {AnalizadorLexico.agregarErrorSintactico("Se espera identificador de la variable en la linea ");}
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

Constante: ENTERO {chequearEnteroPositivo($1.sval);}
	| ENTEROCORTO {chequearEnteroCorto($1.sval);}
	| '-' ENTEROCORTO {AnalizadorLexico.agregarErrorLexico("Un entero corto no puede ser negativo en la linea ");}
	| PUNTOFLOTANTE{chequearDouble($1.sval);}
	| '-' ENTERO {chequearEnteroNegativo($2.sval);}
	| '-' PUNTOFLOTANTE {chequearDouble($2.sval);}
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

Condicion : '(' Expresion Comparador Expresion ')'
            | '(' Expresion Comparador Expresion {AnalizadorLexico.agregarErrorSintactico("Se esperaba una ')' ");}
            | Expresion Comparador Expresion ')' {AnalizadorLexico.agregarErrorSintactico("Se esperaba una '(' ");}
	  ;

BloqueIF: IF Condicion '{' ListSentenciasIF '}' ELSE '{' ListSentenciasIF '}' END_IF {AnalizadorLexico.agregarEstructura("Reconoce IF ELSE ");}
	| IF Condicion '{' ListSentenciasIF '}' END_IF {AnalizadorLexico.agregarEstructura("Reconoce IF ");}
        ;

ListSentenciasIF: SentenciaEjecutable ','
                  | SentenciaEjecutable ',' ListSentenciasIF
                  | SentenciaEjecutable {AnalizadorLexico.agregarErrorSintactico("Se esperaba una ',' ");}
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

Funcion: VOID ID  Parametro '{' CuerpoFuncion '}' {AnalizadorLexico.agregarEstructura("Reconoce funcion VOID ");}
      | VOID ID '(' ')''{' CuerpoFuncion '}'{AnalizadorLexico.agregarEstructura("Reconoce funcion VOID ");}
      | VOID ID '(' ')' CuerpoFuncion '}' {AnalizadorLexico.agregarErrorSintactico("Se esperaba un '{' ");}
      ;


Parametro: '(' Tipo ID ')'
        | '(' Tipo ID {AnalizadorLexico.agregarErrorSintactico("Se esperaba un ')' ");}
        |  Tipo ID ')' {AnalizadorLexico.agregarErrorSintactico("Se esperaba un '(' ");}
        ;

CuerpoFuncion: ListSentenciasFuncion
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
            | ID '(' Expresion ')' {AnalizadorLexico.agregarEstructura("Reconoce llamado funcion ");}
            | ID '('  {AnalizadorLexico.agregarErrorSintactico("Se esperaba una ')' ");}
            | ID  ')' {AnalizadorLexico.agregarErrorSintactico("Se esperaba una '(' ");}
            | ID  Expresion ')' {AnalizadorLexico.agregarErrorSintactico("Se esperaba una '(' ");}
            | ID '(' Expresion {AnalizadorLexico.agregarErrorSintactico("Se esperaba una ')' ");}
            ;

SalidaMensaje: PRINT CADENA {AnalizadorLexico.agregarEstructura("Reconoce salida de mensaje por pantalla ");}
            | PRINT Factor {AnalizadorLexico.agregarEstructura("Reconoce salida de mensaje por pantalla ");}
            ;

OperadorAsignacion: '='
                  | ASIG
                  ;

Asignacion: ID OperadorAsignacion Expresion
	| ReferenciaObjeto OperadorAsignacion ReferenciaObjeto
	| ReferenciaObjeto OperadorAsignacion Factor
	| ID OperadorAsignacion {AnalizadorLexico.agregarErrorSintactico("Se esperaba un operando de lado derecho de la asignación ");}
	| ReferenciaObjeto OperadorAsignacion {AnalizadorLexico.agregarErrorSintactico("Se esperaba un operando de lado derecho de la asignación ");}
	;

SentenciaControl: DO '{' ListSentenciasIF '}' UNTIL Condicion {AnalizadorLexico.agregarEstructura("Reconoce funcion DO UNTIL");}
                  |DO '{' ListSentenciasIF '}' UNTIL {AnalizadorLexico.agregarErrorSintactico("Se esperaba una condicion ");}
                  ;

//TEMA 29 --------------------------------------------------

ConversionExplicita: TOD '(' Expresion ')' {AnalizadorLexico.agregarEstructura("Reconoce funcion TOD ");}
                  | TOD '(' ')' {AnalizadorLexico.agregarErrorSintactico("Se esperaba una Expresion ");}
                  | TOD  Expresion')' {AnalizadorLexico.agregarErrorSintactico("Se esperaba un '(' ");}
                  ;

ListHerencia: Tipo ListVariables ','
		|FuncionIMPL ','
		|FuncionIMPL ',' ListHerencia
		| Tipo ListVariables ',' ListHerencia
		| ListFuncion ','
		| ListFuncion ',' ListHerencia
        ;

HerenciaComposicion: CLASS ID '{' ListHerencia '}'  {AnalizadorLexico.agregarEstructura("Reconoce CLASE");}
                  | CLASS ID
                  | CLASS ID  ListHerencia '}' {AnalizadorLexico.agregarErrorSintactico("Se esperaba un '{' ");}
                  ;

FuncionSinCuerpo: VOID ID  Parametro  ',' {AnalizadorLexico.agregarEstructura("Reconoce Funcion sin cuerpo");}
                  | VOID ID '(' ')' ',' {AnalizadorLexico.agregarEstructura("Reconoce Funcion sin cuerpo");}
                  ;

FuncionIMPL: IMPL FOR ID ':' '{' Funcion '}' {AnalizadorLexico.agregarEstructura("Reconoce funcion IMPL");}
            | IMPL FOR ID ':' '{' Funcion  {AnalizadorLexico.agregarErrorSintactico("Se esperaba un '}' ");}
            | IMPL FOR ID ':' Funcion '}' {AnalizadorLexico.agregarErrorSintactico("Se esperaba un '{' ");}
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