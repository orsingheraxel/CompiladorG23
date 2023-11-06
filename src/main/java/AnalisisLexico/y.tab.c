#ifndef lint
static char yysccsid[] = "@(#)yaccpar	1.8 (Berkeley) 01/20/90";
#endif
#define YYBYACC 1
#line 2 "gramatica.y"
package AnalisisLexico;
import AnalisisLexico.TablaSimbolos.TablaSimbolos;
import AnalisisLexico.AccionesSemanticas.AccionSemantica;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
#line 14 "y.tab.c"
#define IF 257
#define ELSE 258
#define END_IF 259
#define PRINT 260
#define CLASS 261
#define VOID 262
#define DO 263
#define UNTIL 264
#define IMPL 265
#define INT 266
#define USHORT 267
#define DOUBLE 268
#define ID 269
#define IGUAL 270
#define DIST 271
#define MENORIGUAL 272
#define MAYORIGUAL 273
#define ASIG 274
#define RETURN 275
#define TOD 276
#define CADENA 277
#define ENTERO 278
#define ENTEROCORTO 279
#define PUNTOFLOTANTE 280
#define FOR 281
#define CTE 282
#define YYERRCODE 256
short yylhs[] = {                                        -1,
    0,    0,    0,    0,    1,    1,    1,    2,    2,    2,
    6,    7,    4,    4,    4,    4,    4,    5,    5,    5,
    5,    5,    5,    5,   13,   13,   16,   12,   12,   12,
   18,   18,   18,   18,   18,   18,   19,   19,   19,   19,
   20,   20,   20,   20,   20,   20,   22,   22,   23,   24,
   24,   24,   10,   10,   26,   26,   26,   27,   28,   28,
   28,   25,   25,   25,   25,   25,   25,   29,   29,   14,
   14,   31,   31,   31,   32,   32,   33,   33,   33,   33,
   33,   33,   33,   33,    8,    8,   11,   11,   35,   35,
    9,    9,    9,    3,    3,   34,   34,   21,   21,   36,
   37,   37,   37,   37,   15,   30,   30,   17,   17,
};
short yylen[] = {                                         2,
    3,    2,    2,    1,    2,    3,    1,    1,    1,    1,
    3,    3,    1,    1,    1,    1,    1,    2,    1,    1,
    1,    1,    1,    1,    1,    3,    2,    1,    1,    1,
    1,    1,    2,    1,    2,    2,    3,    3,    1,    1,
    3,    3,    1,    3,    3,    1,    1,    1,    1,    5,
    4,    4,    6,    4,    3,    2,    2,    1,    2,    3,
    2,    1,    1,    1,    1,    1,    1,    1,    1,    4,
    5,    4,    3,    3,    3,    2,    3,    3,    2,    2,
    2,    3,    1,    1,    3,    2,    2,    2,    1,    1,
    3,    3,    3,    4,    3,    3,    2,    2,    3,    3,
    3,    4,    2,    3,    3,    3,    4,    7,    6,
};
short yydefred[] = {                                      0,
    0,    0,    0,    0,    0,    0,   29,   28,   30,    0,
    0,    0,    0,    0,    8,    9,   10,    0,   17,   14,
   13,   15,   16,    0,   20,   19,   22,   23,   24,    0,
    0,   31,   32,   34,    0,    0,   49,   48,    0,    0,
   40,    0,    0,    0,   47,   87,   88,    0,    0,    0,
    0,    0,    0,    0,   58,    0,    0,   90,    0,    0,
    0,   89,   27,    0,   86,    0,    0,    3,    0,    0,
    0,   18,    0,    0,   98,   35,   33,   36,    0,   66,
   67,   65,   64,   62,   63,    0,    0,    0,    0,    0,
    0,    0,    0,    0,  105,    0,    0,    0,   57,    0,
    0,   61,    0,   56,    0,    0,   12,   26,   85,    0,
   97,   91,    1,    6,   92,   93,   11,   99,    0,    0,
   38,   37,   41,   42,   44,   45,    0,   54,    0,    0,
   68,    0,   69,    0,    0,    0,    0,    0,    0,    0,
    0,   70,    0,   55,   60,   94,    0,   96,    0,   52,
    0,    0,    0,    0,  100,   71,    0,   74,    0,    0,
    0,    0,   76,    0,    0,   50,   53,    0,    0,    0,
  104,   72,   82,   75,   78,   77,    0,  109,    0,  102,
  108,
};
short yydgoto[] = {                                      12,
   13,   14,   15,  140,  141,   37,   19,   20,   21,   22,
   23,   24,   25,   26,   27,   28,   29,   38,   64,   40,
   41,   42,   43,   44,   86,   53,   54,   55,  132,  133,
   98,  142,  143,   65,   66,   95,  134,
};
short yysindex[] = {                                    146,
   37,  -45, -245, -233, -114, -216,    0,    0,    0,  -38,
  233,    0,  -52,   32,    0,    0,    0,  -57,    0,    0,
    0,    0,    0, -186,    0,    0,    0,    0,    0,   38,
   49,    0,    0,    0, -146,   73,    0,    0,  110,   19,
    0,   -9,   -8, -114,    0,    0,    0,  -16,   14,  -26,
 -110,  -41, -155,  -11,    0, -142,   46,    0, -141, -186,
   61,    0,    0,   89,    0,   73,   20,    0,  233,  -23,
   80,    0, -109,   67,    0,    0,    0,    0,  110,    0,
    0,    0,    0,    0,    0,   73,   73,   73,  -23,  -23,
  -23,  -23, -200, -151,    0,  107, -108,  -70,    0,   40,
 -156,    0,   37,    0,   82,   55,    0,    0,    0,  121,
    0,    0,    0,    0,    0,    0,    0,    0,   73,  127,
    0,    0,    0,    0,    0,    0, -114,    0,  -96, -186,
    0,  130,    0,   51,  -70,  -91,  138,  141,  166,  142,
  144,    0,   64,    0,    0,    0, -105,    0,  152,    0,
  -88,  102,  150, -151,    0,    0,  159,    0,  166,   76,
  166,  166,    0,  -58,   81,    0,    0,  111,  -70, -151,
    0,    0,    0,    0,    0,    0,   83,    0,  -70,    0,
    0,
};
short yyrindex[] = {                                      0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,   11,
    0,    0,  207,   10,    0,    0,    0,    0,    0,    0,
    0,    0,    0,   12,    0,    0,    0,    0,    0,    1,
    0,    0,    0,    0,    0,    0,    0,    0,    0,   31,
    0,    6,   26,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,   78,    0,    0,    0,
    0,    0,    0,    0,    0,    0,  211,    0,   28,    0,
   11,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
   87,    0,   13,    0,    0,  -56,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,   88,
   90,    0,    0,    0,    0,    0,    0,    0,   52,    0,
    0,    0,    0,   96,    0,    0,   97,    0,   98,    0,
  100,  101,    0,    0,    0,    0,    0,    0,  170,  104,
    0,    0,    0,    0,    0,    0,    0,    0,  178,    0,
    0,
};
short yygindex[] = {                                      0,
   21,    0,    0,  158,   29,  350,    0,  171,    0,    0,
    0,  295,   50,  -67,    0,    0,    0,    0,  394,   92,
    0,   15,    0,  134,  160,  -28,  193,  -22,    0,    0,
   93,  -98,    5,  216,  231,    0, -129,
};
#define YYTABLESIZE 529
short yytable[] = {                                      35,
   47,   61,  101,   62,   11,   43,   35,   59,   51,    7,
   25,   21,   95,   61,   99,   93,   47,  164,   35,   59,
   60,   35,   62,   48,  171,   46,  131,    5,   17,  102,
   39,   67,   89,   91,   62,   49,  156,   90,   92,   17,
  180,   47,   47,   47,   47,   47,   43,   47,   43,   43,
   43,   51,  139,   96,   25,   21,   95,  127,  128,   63,
   47,   88,   47,   87,   56,   43,   46,   43,   46,   46,
   46,   39,   68,   72,   39,   69,   36,   25,  145,  165,
  156,   35,   71,   73,  116,   46,  131,   46,   74,  114,
   39,   73,   39,   35,   61,   51,  177,   17,  151,   35,
    1,  109,  131,    2,   60,   35,   94,  118,  103,  108,
  129,   35,   50,  104,    7,    8,    9,   35,   47,   47,
   47,   25,   47,   47,   47,   47,  105,  106,   43,  111,
   43,   76,   77,   78,    7,   25,   21,   95,   60,  147,
   73,  168,    1,  160,  113,    2,    1,  135,   46,    2,
   46,  179,    5,   39,   50,   39,    4,   16,   50,  117,
  137,  148,   52,  173,  144,  175,  176,  150,   16,   84,
  167,   85,  152,  154,   51,  155,   51,  157,  158,  153,
  123,  124,  125,  126,  159,  161,    1,  162,  163,    2,
    3,    4,  166,  170,    6,    7,    8,    9,   10,  172,
  174,   52,   25,    4,  138,  178,    4,  181,   52,   52,
    2,   59,   83,  106,   84,    1,   58,   11,    2,   73,
  103,  107,   81,   45,   79,   80,   16,   50,  101,  107,
   57,   46,   32,   33,   34,   58,  146,   31,  119,   32,
   33,   34,   30,  100,  169,   30,   75,   58,   70,   31,
    0,   32,   33,   34,   32,   33,   34,   47,   52,    0,
   47,    0,   43,    0,    0,   43,    0,    0,   11,   47,
   47,   47,   47,   47,   43,   43,   43,   43,   43,    7,
    8,    9,   46,    0,   52,   46,    0,   39,    0,    0,
   39,    0,    0,    0,   46,   46,   46,   46,   46,   39,
   39,   39,   39,   39,    0,   30,    0,    0,   51,    0,
    0,   51,   31,    0,   32,   33,   34,   30,    0,    0,
   51,    0,    0,   30,   31,    0,   32,   33,   34,   30,
   31,    0,   32,   33,   34,   30,   31,    0,   32,   33,
   34,   30,   31,   97,   32,   33,   34,    0,   31,   18,
   32,   33,   34,   73,   18,    0,   73,   73,   73,    0,
   18,   73,   73,   73,   73,   73,    0,    7,    8,    9,
    0,   73,    7,    8,    9,    0,    7,    8,    9,   80,
   81,   82,   83,    0,    0,    0,    0,    0,  130,    0,
  136,    0,    0,   18,   39,    0,    0,    0,    0,    0,
   18,   18,    1,    0,    0,    2,    3,    4,    5,    0,
    6,    7,    8,    9,   10,    0,    0,    0,   18,  115,
    0,    0,    1,    0,    0,    2,    3,    4,    0,   79,
    6,    7,    8,    9,   10,    0,    0,    0,    0,    0,
  138,    0,    0,    0,    0,    0,   97,   18,  130,    0,
   18,    0,    0,    0,  110,    0,    0,    0,    0,  112,
    0,    0,  136,    0,  130,    0,    0,  110,    0,    0,
    0,    0,    0,    0,    0,    0,   18,    0,    0,  120,
  121,  122,    0,    0,   18,    0,    0,    0,   18,    1,
    0,    0,    2,    3,    4,    5,   39,    6,    7,    8,
    9,   10,    0,    0,    0,    0,    0,    0,   18,    0,
   18,   18,  149,    0,    0,    0,    0,    0,   18,    0,
    0,    0,    0,    0,    0,    0,    0,    0,   18,
};
short yycheck[] = {                                      45,
    0,   40,   44,   61,   61,    0,   45,   46,  123,    0,
    0,    0,    0,   40,  125,   44,    2,  123,   45,   46,
   59,   45,   61,  269,  154,    0,   94,    0,    0,   52,
    0,   11,   42,   42,   61,  269,  135,   47,   47,   11,
  170,   41,   42,   43,   44,   45,   41,   47,   43,   44,
   45,    0,  123,   40,   44,   44,   44,  258,  259,   10,
   60,   43,   62,   45,  281,   60,   41,   62,   43,   44,
   45,   41,  125,   24,   44,   44,   40,    0,  101,  147,
  179,   45,  269,   46,   70,   60,  154,   62,   40,   69,
   60,   46,   62,   45,   40,   44,  164,   69,  127,   45,
  257,   41,  170,  260,   59,   45,  123,   41,  264,   60,
  262,   45,  269,  125,  266,  267,  268,   45,   41,   42,
   43,   44,   45,  123,   47,  125,  269,  269,  123,   41,
  125,  278,  279,  280,  125,  125,  125,  125,   59,   58,
   44,   40,  257,  139,  125,  260,  257,   41,  123,  260,
  125,   41,  125,  123,  269,  125,  262,    0,  269,  269,
  269,   41,    5,  159,  125,  161,  162,   41,   11,   60,
  259,   62,  269,   44,  123,  125,  125,  269,   41,  130,
   89,   90,   91,   92,   44,   44,  257,   44,  125,  260,
  261,  262,   41,   44,  265,  266,  267,  268,  269,   41,
  125,   44,  125,  262,  275,  125,    0,  125,   51,   52,
    0,  125,  125,   44,  125,  257,  274,  274,  260,  123,
  125,   44,  125,  269,  125,  125,   69,  269,  125,   59,
  269,  277,  278,  279,  280,  274,  103,  276,   79,  278,
  279,  280,  269,   51,  152,  269,   31,  274,   18,  276,
   -1,  278,  279,  280,  278,  279,  280,  257,  101,   -1,
  260,   -1,  257,   -1,   -1,  260,   -1,   -1,  123,  269,
  270,  271,  272,  273,  269,  270,  271,  272,  273,  266,
  267,  268,  257,   -1,  127,  260,   -1,  257,   -1,   -1,
  260,   -1,   -1,   -1,  269,  270,  271,  272,  273,  269,
  270,  271,  272,  273,   -1,  269,   -1,   -1,  257,   -1,
   -1,  260,  276,   -1,  278,  279,  280,  269,   -1,   -1,
  269,   -1,   -1,  269,  276,   -1,  278,  279,  280,  269,
  276,   -1,  278,  279,  280,  269,  276,   -1,  278,  279,
  280,  269,  276,   49,  278,  279,  280,   -1,  276,    0,
  278,  279,  280,  257,    5,   -1,  260,  261,  262,   -1,
   11,  265,  266,  267,  268,  269,   -1,  266,  267,  268,
   -1,  275,  266,  267,  268,   -1,  266,  267,  268,  270,
  271,  272,  273,   -1,   -1,   -1,   -1,   -1,   94,   -1,
   96,   -1,   -1,   44,    1,   -1,   -1,   -1,   -1,   -1,
   51,   52,  257,   -1,   -1,  260,  261,  262,  263,   -1,
  265,  266,  267,  268,  269,   -1,   -1,   -1,   69,   70,
   -1,   -1,  257,   -1,   -1,  260,  261,  262,   -1,   36,
  265,  266,  267,  268,  269,   -1,   -1,   -1,   -1,   -1,
  275,   -1,   -1,   -1,   -1,   -1,  152,   98,  154,   -1,
  101,   -1,   -1,   -1,   61,   -1,   -1,   -1,   -1,   66,
   -1,   -1,  168,   -1,  170,   -1,   -1,   74,   -1,   -1,
   -1,   -1,   -1,   -1,   -1,   -1,  127,   -1,   -1,   86,
   87,   88,   -1,   -1,  135,   -1,   -1,   -1,  139,  257,
   -1,   -1,  260,  261,  262,  263,  103,  265,  266,  267,
  268,  269,   -1,   -1,   -1,   -1,   -1,   -1,  159,   -1,
  161,  162,  119,   -1,   -1,   -1,   -1,   -1,  169,   -1,
   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,  179,
};
#define YYFINAL 12
#ifndef YYDEBUG
#define YYDEBUG 0
#endif
#define YYMAXTOKEN 282
#if YYDEBUG
char *yyname[] = {
"end-of-file",0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,
0,0,0,0,0,0,"'('","')'","'*'","'+'","','","'-'","'.'","'/'",0,0,0,0,0,0,0,0,0,0,
"':'","';'","'<'","'='","'>'",0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,
0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,"'{'",0,
"'}'",0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,
0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,
0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,
0,0,0,0,0,0,0,0,0,0,0,0,0,0,"IF","ELSE","END_IF","PRINT","CLASS","VOID","DO",
"UNTIL","IMPL","INT","USHORT","DOUBLE","ID","IGUAL","DIST","MENORIGUAL",
"MAYORIGUAL","ASIG","RETURN","TOD","CADENA","ENTERO","ENTEROCORTO",
"PUNTOFLOTANTE","FOR","CTE",
};
char *yyrule[] = {
"$accept : Programa",
"Programa : '{' ListSentencias '}'",
"Programa : '{' ListSentencias",
"Programa : ListSentencias '}'",
"Programa : ListSentencias",
"ListSentencias : Sentencia ','",
"ListSentencias : Sentencia ',' ListSentencias",
"ListSentencias : Sentencia",
"Sentencia : SentenciaControl",
"Sentencia : SentenciaEjecutable",
"Sentencia : SentenciaDeclarativa",
"ReferenciaObjeto : ID '.' ID",
"ReferenciaObjetoFuncion : ID '.' LlamadoFuncion",
"SentenciaEjecutable : Asignacion",
"SentenciaEjecutable : LlamadoFuncion",
"SentenciaEjecutable : BloqueIF",
"SentenciaEjecutable : SalidaMensaje",
"SentenciaEjecutable : ReferenciaObjetoFuncion",
"SentenciaDeclarativa : Tipo ListVariables",
"SentenciaDeclarativa : Funcion",
"SentenciaDeclarativa : ListVariables",
"SentenciaDeclarativa : Tipo",
"SentenciaDeclarativa : HerenciaComposicion",
"SentenciaDeclarativa : Objeto_clase",
"SentenciaDeclarativa : FuncionIMPL",
"ListVariables : ID",
"ListVariables : ID ';' ListVariables",
"Objeto_clase : ID ListVariables",
"Tipo : USHORT",
"Tipo : INT",
"Tipo : DOUBLE",
"Constante : ENTERO",
"Constante : ENTEROCORTO",
"Constante : '-' ENTEROCORTO",
"Constante : PUNTOFLOTANTE",
"Constante : '-' ENTERO",
"Constante : '-' PUNTOFLOTANTE",
"Expresion : Termino '+' Expresion",
"Expresion : Termino '-' Expresion",
"Expresion : Termino",
"Expresion : ConversionExplicita",
"Termino : Factor '*' Termino",
"Termino : Factor '/' Termino",
"Termino : Factor",
"Termino : Factor_RefObjeto '*' Termino",
"Termino : Factor_RefObjeto '/' Termino",
"Termino : Factor_RefObjeto",
"Factor : ID",
"Factor : Constante",
"Factor_RefObjeto : ReferenciaObjeto",
"Condicion : '(' Expresion Comparador Expresion ')'",
"Condicion : '(' Expresion Comparador Expresion",
"Condicion : Expresion Comparador Expresion ')'",
"BloqueIF : IF Condicion ListSentenciasIF ELSE ListSentenciasIF END_IF",
"BloqueIF : IF Condicion ListSentenciasIF END_IF",
"ListSentenciasIF : '{' SentenciasIF '}'",
"ListSentenciasIF : SentenciasIF '}'",
"ListSentenciasIF : '{' '}'",
"SentenciasIF : ListaSentencias",
"ListaSentencias : SentenciaEjecutable ','",
"ListaSentencias : SentenciaEjecutable ',' ListaSentencias",
"ListaSentencias : SentenciaEjecutable ListaSentencias",
"Comparador : '<'",
"Comparador : '>'",
"Comparador : MAYORIGUAL",
"Comparador : MENORIGUAL",
"Comparador : IGUAL",
"Comparador : DIST",
"ListFuncion : Funcion",
"ListFuncion : FuncionSinCuerpo",
"Funcion : VOID ID Parametro CuerpoFuncion",
"Funcion : VOID ID '(' ')' CuerpoFuncion",
"Parametro : '(' Tipo ID ')'",
"Parametro : '(' Tipo ID",
"Parametro : Tipo ID ')'",
"CuerpoFuncion : '{' ListSentenciasFuncion '}'",
"CuerpoFuncion : ListSentenciasFuncion '}'",
"ListSentenciasFuncion : SentenciaDeclarativa ',' ListSentenciasFuncion",
"ListSentenciasFuncion : SentenciaEjecutable ',' ListSentenciasFuncion",
"ListSentenciasFuncion : SentenciaEjecutable ','",
"ListSentenciasFuncion : SentenciaDeclarativa ','",
"ListSentenciasFuncion : RETURN ','",
"ListSentenciasFuncion : RETURN ',' ListSentenciasFuncion",
"ListSentenciasFuncion : SentenciaEjecutable",
"ListSentenciasFuncion : SentenciaDeclarativa",
"LlamadoFuncion : ID '(' ')'",
"LlamadoFuncion : ID LlamadoExpresion",
"SalidaMensaje : PRINT CADENA",
"SalidaMensaje : PRINT Factor",
"OperadorAsignacion : '='",
"OperadorAsignacion : ASIG",
"Asignacion : ID OperadorAsignacion Expresion",
"Asignacion : ReferenciaObjeto OperadorAsignacion ReferenciaObjeto",
"Asignacion : ReferenciaObjeto OperadorAsignacion Factor",
"SentenciaControl : DO ListSentenciasIF UNTIL Condicion",
"SentenciaControl : DO ListSentenciasIF UNTIL",
"LlamadoExpresion : '(' Expresion ')'",
"LlamadoExpresion : Expresion ')'",
"ConversionExplicita : TOD LlamadoExpresion",
"ConversionExplicita : TOD '(' ')'",
"ListHerencia : '{' SentenciaListHerencia '}'",
"SentenciaListHerencia : Tipo ListVariables ','",
"SentenciaListHerencia : Tipo ListVariables ',' SentenciaListHerencia",
"SentenciaListHerencia : ListFuncion ','",
"SentenciaListHerencia : ListFuncion ',' SentenciaListHerencia",
"HerenciaComposicion : CLASS ID ListHerencia",
"FuncionSinCuerpo : VOID ID Parametro",
"FuncionSinCuerpo : VOID ID '(' ')'",
"FuncionIMPL : IMPL FOR ID ':' '{' Funcion '}'",
"FuncionIMPL : IMPL FOR ID ':' Funcion '}'",
};
#endif
#ifndef YYSTYPE
typedef int YYSTYPE;
#endif
#define yyclearin (yychar=(-1))
#define yyerrok (yyerrflag=0)
#ifdef YYSTACKSIZE
#ifndef YYMAXDEPTH
#define YYMAXDEPTH YYSTACKSIZE
#endif
#else
#ifdef YYMAXDEPTH
#define YYSTACKSIZE YYMAXDEPTH
#else
#define YYSTACKSIZE 500
#define YYMAXDEPTH 500
#endif
#endif
int yydebug;
int yynerrs;
int yyerrflag;
int yychar;
short *yyssp;
YYSTYPE *yyvsp;
YYSTYPE yyval;
YYSTYPE yylval;
short yyss[YYSTACKSIZE];
YYSTYPE yyvs[YYSTACKSIZE];
#define yystacksize YYSTACKSIZE
#line 214 "gramatica.y"

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
#line 486 "y.tab.c"
#define YYABORT goto yyabort
#define YYACCEPT goto yyaccept
#define YYERROR goto yyerrlab
int
yyparse()
{
    register int yym, yyn, yystate;
#if YYDEBUG
    register char *yys;
    extern char *getenv();

    if (yys = getenv("YYDEBUG"))
    {
        yyn = *yys;
        if (yyn >= '0' && yyn <= '9')
            yydebug = yyn - '0';
    }
#endif

    yynerrs = 0;
    yyerrflag = 0;
    yychar = (-1);

    yyssp = yyss;
    yyvsp = yyvs;
    *yyssp = yystate = 0;

yyloop:
    if (yyn = yydefred[yystate]) goto yyreduce;
    if (yychar < 0)
    {
        if ((yychar = yylex()) < 0) yychar = 0;
#if YYDEBUG
        if (yydebug)
        {
            yys = 0;
            if (yychar <= YYMAXTOKEN) yys = yyname[yychar];
            if (!yys) yys = "illegal-symbol";
            printf("yydebug: state %d, reading %d (%s)\n", yystate,
                    yychar, yys);
        }
#endif
    }
    if ((yyn = yysindex[yystate]) && (yyn += yychar) >= 0 &&
            yyn <= YYTABLESIZE && yycheck[yyn] == yychar)
    {
#if YYDEBUG
        if (yydebug)
            printf("yydebug: state %d, shifting to state %d (%s)\n",
                    yystate, yytable[yyn],yyrule[yyn]);
#endif
        if (yyssp >= yyss + yystacksize - 1)
        {
            goto yyoverflow;
        }
        *++yyssp = yystate = yytable[yyn];
        *++yyvsp = yylval;
        yychar = (-1);
        if (yyerrflag > 0)  --yyerrflag;
        goto yyloop;
    }
    if ((yyn = yyrindex[yystate]) && (yyn += yychar) >= 0 &&
            yyn <= YYTABLESIZE && yycheck[yyn] == yychar)
    {
        yyn = yytable[yyn];
        goto yyreduce;
    }
    if (yyerrflag) goto yyinrecovery;
#ifdef lint
    goto yynewerror;
#endif
yynewerror:
    yyerror("syntax error");
#ifdef lint
    goto yyerrlab;
#endif
yyerrlab:
    ++yynerrs;
yyinrecovery:
    if (yyerrflag < 3)
    {
        yyerrflag = 3;
        for (;;)
        {
            if ((yyn = yysindex[*yyssp]) && (yyn += YYERRCODE) >= 0 &&
                    yyn <= YYTABLESIZE && yycheck[yyn] == YYERRCODE)
            {
#if YYDEBUG
                if (yydebug)
                    printf("yydebug: state %d, error recovery shifting\
 to state %d\n", *yyssp, yytable[yyn]);
#endif
                if (yyssp >= yyss + yystacksize - 1)
                {
                    goto yyoverflow;
                }
                *++yyssp = yystate = yytable[yyn];
                *++yyvsp = yylval;
                goto yyloop;
            }
            else
            {
#if YYDEBUG
                if (yydebug)
                    printf("yydebug: error recovery discarding state %d\n",
                            *yyssp);
#endif
                if (yyssp <= yyss) goto yyabort;
                --yyssp;
                --yyvsp;
            }
        }
    }
    else
    {
        if (yychar == 0) goto yyabort;
#if YYDEBUG
        if (yydebug)
        {
            yys = 0;
            if (yychar <= YYMAXTOKEN) yys = yyname[yychar];
            if (!yys) yys = "illegal-symbol";
            printf("yydebug: state %d, error recovery discards token %d (%s)\n",
                    yystate, yychar, yys);
        }
#endif
        yychar = (-1);
        goto yyloop;
    }
yyreduce:
#if YYDEBUG
    if (yydebug)
        printf("yydebug: state %d, reducing by rule %d (%s)\n",
                yystate, yyn, yyrule[yyn]);
#endif
    yym = yylen[yyn];
    yyval = yyvsp[1-yym];
    switch (yyn)
    {
case 1:
#line 16 "gramatica.y"
{AnalizadorLexico.agregarEstructura("Reconoce programa ");}
break;
case 2:
#line 17 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se espera '}' ");}
break;
case 3:
#line 18 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se espera '{' ");}
break;
case 4:
#line 19 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperan '{' '}' ");}
break;
case 7:
#line 24 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba una ',' al final de la linea ");}
break;
case 20:
#line 47 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se espera el tipo de la variable ");}
break;
case 21:
#line 48 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se espera identificador de la variable ");}
break;
case 31:
#line 66 "gramatica.y"
{chequearEnteroPositivo(yyvsp[0].sval);}
break;
case 32:
#line 67 "gramatica.y"
{chequearEnteroCorto(yyvsp[0].sval);}
break;
case 33:
#line 68 "gramatica.y"
{AnalizadorLexico.agregarErrorLexico("Un entero corto no puede ser negativo ");}
break;
case 34:
#line 69 "gramatica.y"
{chequearDouble(yyvsp[0].sval);}
break;
case 35:
#line 70 "gramatica.y"
{chequearEnteroNegativo(yyvsp[0].sval);}
break;
case 36:
#line 71 "gramatica.y"
{chequearDouble(yyvsp[0].sval);}
break;
case 51:
#line 97 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba una ')' ");}
break;
case 52:
#line 98 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba una '(' ");}
break;
case 53:
#line 101 "gramatica.y"
{AnalizadorLexico.agregarEstructura("Reconoce IF ELSE ");}
break;
case 54:
#line 102 "gramatica.y"
{AnalizadorLexico.agregarEstructura("Reconoce IF ");}
break;
case 56:
#line 106 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Falta un '{'"); }
break;
case 57:
#line 107 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("No hay sentencias dentro de las llaves."); }
break;
case 61:
#line 114 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Falta una ','"); }
break;
case 70:
#line 129 "gramatica.y"
{AnalizadorLexico.agregarEstructura("Reconoce funcion VOID ");}
break;
case 71:
#line 130 "gramatica.y"
{AnalizadorLexico.agregarEstructura("Reconoce funcion VOID ");}
break;
case 73:
#line 135 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba un ')' ");}
break;
case 74:
#line 136 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba un '(' ");}
break;
case 76:
#line 140 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba un '{' ");}
break;
case 83:
#line 149 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba una ',' al final de la linea ");}
break;
case 84:
#line 150 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba una ',' al final de la linea ");}
break;
case 85:
#line 155 "gramatica.y"
{AnalizadorLexico.agregarEstructura("Reconoce llamado funcion ");}
break;
case 86:
#line 156 "gramatica.y"
{AnalizadorLexico.agregarEstructura("Reconoce llamado funcion ");}
break;
case 87:
#line 158 "gramatica.y"
{AnalizadorLexico.agregarEstructura("Reconoce salida de mensaje por pantalla ");}
break;
case 88:
#line 159 "gramatica.y"
{AnalizadorLexico.agregarEstructura("Reconoce salida de mensaje por pantalla ");}
break;
case 94:
#line 171 "gramatica.y"
{AnalizadorLexico.agregarEstructura("Reconoce funcion DO UNTIL");}
break;
case 95:
#line 172 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba una condicion ");}
break;
case 97:
#line 178 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba un '(' ");}
break;
case 98:
#line 181 "gramatica.y"
{AnalizadorLexico.agregarEstructura("Reconoce funcion TOD ");}
break;
case 99:
#line 182 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba una Expresion ");}
break;
case 105:
#line 195 "gramatica.y"
{AnalizadorLexico.agregarEstructura("Reconoce CLASE");}
break;
case 106:
#line 199 "gramatica.y"
{AnalizadorLexico.agregarEstructura("Reconoce Funcion sin cuerpo");}
break;
case 107:
#line 200 "gramatica.y"
{AnalizadorLexico.agregarEstructura("Reconoce Funcion sin cuerpo");}
break;
case 108:
#line 203 "gramatica.y"
{AnalizadorLexico.agregarEstructura("Reconoce funcion IMPL");}
break;
case 109:
#line 204 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba un '{' ");}
break;
#line 790 "y.tab.c"
    }
    yyssp -= yym;
    yystate = *yyssp;
    yyvsp -= yym;
    yym = yylhs[yyn];
    if (yystate == 0 && yym == 0)
    {
#if YYDEBUG
        if (yydebug)
            printf("yydebug: after reduction, shifting from state 0 to\
 state %d\n", YYFINAL);
#endif
        yystate = YYFINAL;
        *++yyssp = YYFINAL;
        *++yyvsp = yyval;
        if (yychar < 0)
        {
            if ((yychar = yylex()) < 0) yychar = 0;
#if YYDEBUG
            if (yydebug)
            {
                yys = 0;
                if (yychar <= YYMAXTOKEN) yys = yyname[yychar];
                if (!yys) yys = "illegal-symbol";
                printf("yydebug: state %d, reading %d (%s)\n",
                        YYFINAL, yychar, yys);
            }
#endif
        }
        if (yychar == 0) goto yyaccept;
        goto yyloop;
    }
    if ((yyn = yygindex[yym]) && (yyn += yystate) >= 0 &&
            yyn <= YYTABLESIZE && yycheck[yyn] == yystate)
        yystate = yytable[yyn];
    else
        yystate = yydgoto[yym];
#if YYDEBUG
    if (yydebug)
        printf("yydebug: after reduction, shifting from state %d \
to state %d\n", *yyssp, yystate);
#endif
    if (yyssp >= yyss + yystacksize - 1)
    {
        goto yyoverflow;
    }
    *++yyssp = yystate;
    *++yyvsp = yyval;
    goto yyloop;
yyoverflow:
    yyerror("yacc stack overflow");
yyabort:
    return (1);
yyaccept:
    return (0);
}
