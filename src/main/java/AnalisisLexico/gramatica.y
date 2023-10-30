%{
package com.tp.compiladores;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
%}

%token IF ELSE END_IF PRINT CLASS VOID DO UNTIL IMPL INT USHORT DOUBLE ID IGUAL DIST MENORIGUAL MAYORIGUAL ASIG RETURN TOD CADENA ENTERO ENTEROCORTO PUNTOFLOTANTE FOR CTE

%start Programa

%%
Programa:'{' ListSentencias '}'
        | '{'ListSentencias {System.out.println("Se espera '}' en la linea "+ AnalizadorLexico.getLineaAct());}
	| ListSentencias '}' {System.out.println("Se espera '{' en la linea "+ AnalizadorLexico.getLineaAct());}
	| ListSentencias {System.out.println("Se esperan '{' '}' en la linea "+ AnalizadorLexico.getLineaAct());}
        ;

ListSentencias: SentenciaControl ','
		| SentenciaEjecutable ','
		| SentenciaDeclarativa ','
		| SentenciaDeclarativa ',' ListSentencias
		| SentenciaControl ',' ListSentencias
		| SentenciaEjecutable ',' ListSentencias
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

SentenciaDeclarativa: Tipo ListVariables
			| Funcion
			| ListVariables  {System.out.println("Se espera el tipo de la variable en la linea "+ AnalizadorLexico.getLineaAct());}
			| Tipo  {System.out.println("Se espera identificador de la variable en la linea "+ AnalizadorLexico.getLineaAct());}
                        | ClaseSentenciaEjecutable
                        | HerenciaComposicion

                    ;

ListVariables: ID
            | ID ';' ListVariables
            | ID ListVariables {System.out.println("Se espera un ';' seguido de cada variable en caso de querer agregar mas en la linea "+ AnalizadorLexico.getLineaAct());}
            ;

Tipo: ID
      |USHORT
      |INT
      |DOUBLE
      |CLASS //Chequear en prox etapa que no se pase como parametro
      ;

Constante: ENTERO
	| ENTEROCORTO
	| '-' ENTEROCORTO {System.out.println("Un entero corto no puede ser negativo en la linea "+ AnalizadorLexico.getLineaAct());}
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

BloqueIF: IF '(' Condicion ')' '{' ListSentenciasIF '}' ELSE '{' ListSentenciasIF '}' END_IF {System.out.println("Reconoce ELSE IF en la linea "+ AnalizadorLexico.getLineaAct());}
	| IF '(' Condicion ')' '{' ListSentenciasIF '}' END_IF {System.out.println("Reconoce IF en la linea "+ AnalizadorLexico.getLineaAct());}
        ;

ListSentenciasIF: SentenciaEjecutable ','
                  | SentenciaEjecutable ',' ListSentenciasIF
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

Funcion: VOID ID '(' Parametro ')''{' CuerpoFuncion  RETURN ',' '}' {System.out.println("Reconoce funcion VOID en la linea "+ AnalizadorLexico.getLineaAct());}
      |VOID ID '(' ')''{' CuerpoFuncion RETURN ',''}'{System.out.println("Reconoce funcion VOID en la linea "+ AnalizadorLexico.getLineaAct());}
      |VOID ID '(' ')''{' CuerpoFuncion '}'  {System.out.println("Reconoce funcion VOID en la linea "+ AnalizadorLexico.getLineaAct());}
      ;


Parametro: Tipo ID;

CuerpoFuncion: ListSentenciasFuncion
                  ;

ListSentenciasFuncion:SentenciaDeclarativa ',' ListSentenciasFuncion
		  | SentenciaEjecutable ',' ListSentenciasFuncion
		  | SentenciaEjecutable ','
		  | SentenciaDeclarativa ','
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

SentenciaControl: DO '{' ListSentenciasIF '}' UNTIL '(' Condicion ')' {System.out.println("Reconoce funcion DO UNTIL en la linea "+ AnalizadorLexico.getLineaAct());}
                  |DO '{' ListSentenciasIF '}' UNTIL {System.out.println("Se esperaba una condicion");}
                  ;

//TEMA 29 --------------------------------------------------

ConversionExplicita: TOD '(' Expresion ')' {System.out.println("Reconoce funcion TOD en la linea "+ AnalizadorLexico.getLineaAct());}
                  | TOD '(' ')' {System.out.println("Se esperaba una Expresion");}
                  ;

//TEMA 17 ---------------------------------------------------

ListHerencia: DeclaracionAtributo
		|FuncionIMPL
		|FuncionIMPL ',' ListHerencia
		| DeclaracionAtributo ListHerencia
		| ListFuncion ','
		| ListFuncion ',' ListHerencia

HerenciaComposicion: CLASS ID '{' ListHerencia '}'  {System.out.println("Reconoce CLASE en la linea "+ AnalizadorLexico.getLineaAct());}
                  //| CLASS ID '{' ListHerencia  ID ',' '}'
                  ;

DeclaracionAtributo: Tipo ID ','
		| Tipo ID ',' DeclaracionAtributo
		| ID ',' DeclaracionAtributo
		;

//TEMA 20 -----------------------------------------------------

FuncionSinCuerpo: VOID ID '(' Parametro ')' ',' {System.out.println("Reconoce Funcion sin cuerpo, en la linea"+ AnalizadorLexico.getLineaAct());}
                  |VOID ID '(' ')' ','
                  ;

FuncionIMPL: IMPL FOR ID ':' '{' Funcion '}' {System.out.println("Reconoce funcion IMPL en la linea "+ AnalizadorLexico.getLineaAct());}
		;

//TEMA 21 ----------------------------------------------------

/*  Forward declaration => Es simplemente utilizar la regla de sentencias declarativas;
  			   ya que en esta etapa solo controlamos sintaxis
*/

%%
  public int yylex() throws IOException{
    Token t = AnalizadorLexico.obtenerToken();
    this.yylval = new ParserVal(t.getLexema());
    return t.getId();
  }

  public static void yyerror(String error){
    System.out.println(error);
  }