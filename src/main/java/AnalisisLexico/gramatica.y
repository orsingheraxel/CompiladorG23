%{
package AnalisisLexico;;
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

ListSentencias: SentenciaControl ','
		| SentenciaEjecutable ','
		| SentenciaDeclarativa ','
		| SentenciaDeclarativa ',' ListSentencias
		| SentenciaControl ',' ListSentencias
		| SentenciaEjecutable ',' ListSentencias
		| SentenciaControl  {agregarErrorSintactico("Se esperaba una ',' al final de la linea ");}
		| SentenciaEjecutable {agregarErrorSintactico("Se esperaba una ',' al final de la linea ");}
		| SentenciaDeclarativa {agregarErrorSintactico("Se esperaba una ',' al final de la linea ");}
              ;

ReferenciaObjeto: ID '.' ID
                | ID '.' LlamadoFuncion
                ;

SentenciaEjecutable: Asignacion
                  | LlamadoFuncion
                  | BloqueIF
		          | SalidaMensaje
                  | ReferenciaObjeto
                   ;



ClaseSentenciaEjecutable: ID ListVariables ',';
                        | ID ListVariables {agregarErrorSintactico("Se esperaba una ',' al final de la linea ");}

SentenciaDeclarativa: Tipo ListVariables
			| Funcion
			| ListVariables  {agregarErrorSintactico("Se espera el tipo de la variable en la linea ");}
			| Tipo  {agregarErrorSintactico("Se espera identificador de la variable en la linea ");}
            | ClaseSentenciaEjecutable
            | HerenciaComposicion;

ListVariables: ID
            | ID ';' ListVariables
            | ID ListVariables {agregarErrorSintactico("Se espera un ';' seguido de cada variable en caso de querer agregar mas en la linea ");}
            ;

Tipo: ID
      |USHORT
      |INT
      |DOUBLE
      |CLASS
      ;

Constante: ENTERO
	| ENTEROCORTO
	| '-' ENTEROCORTO {agregarErrorLexico("Un entero corto no puede ser negativo en la linea ");}
	| PUNTOFLOTANTE
	| '-' ENTERO
	| '-' PUNTOFLOTANTE
	| CTE
	;

Expresion: Termino '+' Expresion
| Termino '-' Expresion
| Termino
|ConversionExplicita
        ;

Termino: Factor '*' Termino
| Factor '/' Termino
| Factor
;

Factor: ID
	|Constante
	| ReferenciaObjeto
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

Funcion: VOID ID '(' Parametro ')''{' CuerpoFuncion  RETURN ',' '}' {agregarEstructura("Reconoce funcion VOID ");}
      |VOID ID '(' ')''{' CuerpoFuncion RETURN ',''}'{agregarEstructura("Reconoce funcion VOID ");}
      |VOID ID '(' ')''{' CuerpoFuncion '}'  {agregarEstructura("Reconoce funcion VOID ");}
      ;


Parametro: Tipo ID;

CuerpoFuncion: ListSentenciasFuncion
                  ;

ListSentenciasFuncion:SentenciaDeclarativa ',' ListSentenciasFuncion
		  | SentenciaEjecutable ',' ListSentenciasFuncion
		  | SentenciaEjecutable ','
		  | SentenciaDeclarativa ','
		  | SentenciaEjecutable {agregarErrorSintactico("Se esperaba una ',' al final de la linea ");}
          | SentenciaDeclarativa {agregarErrorSintactico("Se esperaba una ',' al final de la linea ");}
          ;



LlamadoFuncion: ID '(' ')'
            | ID '(' ParametroReal ')'
            ;

ParametroReal:ID
            | Expresion
            | Constante
            ;


SalidaMensaje: PRINT CADENA
            ;

//TEMA 11 -------------------------------------------------

OperadorAsignacion: '='
                  | ASIG
                  ;

Asignacion: ID OperadorAsignacion ID
	| ID OperadorAsignacion Expresion
	| ID OperadorAsignacion Constante
	| ID OperadorAsignacion ReferenciaObjeto
	| ID '.' ID OperadorAsignacion ReferenciaObjeto
	;




//TEMA 14 -------------------------------------------------

SentenciaControl: DO '{' ListSentenciasIF '}' UNTIL '(' Condicion ')' {agregarEstructura("Reconoce funcion DO UNTIL");}
                  |DO '{' ListSentenciasIF '}' UNTIL {agregarErrorSintactico("Se esperaba una condicion ");}
                  ;

//TEMA 29 --------------------------------------------------

ConversionExplicita: TOD '(' Expresion ')' {agregarEstructura("Reconoce funcion TOD ");}
                  | TOD '(' ')' {agregarErrorSintactico("Se esperaba una Expresion ");}
                  ;

//TEMA 17 ---------------------------------------------------

ListHerencia: DeclaracionAtributo
		|FuncionIMPL
		|FuncionIMPL ',' ListHerencia
		| DeclaracionAtributo ListHerencia
		| ListFuncion ','
		| ListFuncion ',' ListHerencia

HerenciaComposicion: CLASS ID '{' ListHerencia '}'  {agregarEstructura("Reconoce CLASE");}
                  //| CLASS ID '{' ListHerencia  ID ',' '}'
                  ;

DeclaracionAtributo: Tipo ID ','
		| Tipo ID ',' DeclaracionAtributo
		| ID ',' DeclaracionAtributo
		;

//TEMA 20 -----------------------------------------------------

FuncionSinCuerpo: VOID ID '(' Parametro ')' ',' {agregarEstructura("Reconoce Funcion sin cuerpo");}
                  |VOID ID '(' ')' ','


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