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
    0,    0,    0,    0,    0,    1,    1,    1,    2,    2,
    2,    6,    7,    4,    4,    4,    4,    4,    5,    5,
    5,    5,    5,    5,    5,   13,   13,   16,   12,   12,
   12,   18,   18,   18,   18,   18,   18,   19,   19,   19,
   19,   20,   20,   20,   20,   20,   20,   22,   22,   23,
   24,   24,   24,   10,   10,   26,   26,   26,   27,   28,
   28,   28,   25,   25,   25,   25,   25,   25,   29,   29,
   14,   14,   31,   31,   31,   32,   32,   33,   33,   33,
   33,   33,   33,   33,   33,    8,    8,   11,   11,   35,
   35,    9,    9,    9,    3,    3,   34,   34,   21,   21,
   36,   37,   37,   37,   37,   15,   30,   30,   17,   17,
};
short yylen[] = {                                         2,
    3,    2,    2,    1,    2,    2,    3,    1,    1,    1,
    1,    3,    3,    1,    1,    1,    1,    1,    2,    1,
    1,    1,    1,    1,    1,    1,    3,    2,    1,    1,
    1,    1,    1,    2,    1,    2,    2,    3,    3,    1,
    1,    3,    3,    1,    3,    3,    1,    1,    1,    1,
    5,    4,    4,    6,    4,    3,    2,    2,    1,    2,
    3,    2,    1,    1,    1,    1,    1,    1,    1,    1,
    4,    5,    4,    3,    3,    3,    2,    3,    3,    2,
    2,    2,    3,    1,    1,    3,    2,    2,    2,    1,
    1,    3,    3,    3,    4,    3,    3,    2,    2,    3,
    3,    3,    4,    2,    3,    3,    3,    4,    7,    6,
};
short yydefred[] = {                                      0,
    0,    0,    0,    0,    0,    0,   30,   29,   31,    0,
    0,    0,    0,    0,    9,   10,   11,    0,   18,   15,
   14,   16,   17,    0,   21,   20,   23,   24,   25,    0,
    0,   32,   33,   35,    0,    0,   50,   49,    0,    0,
   41,    0,    0,    0,   48,   88,   89,    0,    0,    0,
    0,    0,    0,    0,   59,    0,    0,   91,    0,    0,
    0,   90,   28,    0,   87,    0,    5,    0,    3,    0,
    0,    0,   19,    0,    0,   99,   36,   34,   37,    0,
   67,   68,   66,   65,   63,   64,    0,    0,    0,    0,
    0,    0,    0,    0,    0,  106,    0,    0,    0,   58,
    0,    0,   62,    0,   57,    0,    0,   13,   27,   86,
    0,   98,   92,    1,    7,   93,   94,   12,  100,    0,
    0,   39,   38,   42,   43,   45,   46,    0,   55,    0,
    0,   69,    0,   70,    0,    0,    0,    0,    0,    0,
    0,    0,   71,    0,   56,   61,   95,    0,   97,    0,
   53,    0,    0,    0,    0,  101,   72,    0,   75,    0,
    0,    0,    0,   77,    0,    0,   51,   54,    0,    0,
    0,  105,   73,   83,   76,   79,   78,    0,  110,    0,
  103,  109,
};
short yydgoto[] = {                                      12,
   13,   14,   15,  141,  142,   37,   19,   20,   21,   22,
   23,   24,   25,   26,   27,   28,   29,   38,   64,   40,
   41,   42,   43,   44,   87,   53,   54,   55,  133,  134,
   99,  143,  144,   65,   66,   96,  135,
};
short yysindex[] = {                                    146,
   37,  -45, -253, -239, -114, -243,    0,    0,    0,  -38,
 -100,    0,  -67,   35,    0,    0,    0,  -57,    0,    0,
    0,    0,    0, -186,    0,    0,    0,    0,    0,   58,
   49,    0,    0,    0, -146,   73,    0,    0,  110,   -4,
    0,   17,   69, -114,    0,    0,    0,  -33,   14,  -26,
 -110,  -41, -166,   -8,    0, -162,  -22,    0, -139, -186,
   61,    0,    0,   98,    0,   73,    0,   15,    0,  237,
  -23,   85,    0, -124,   67,    0,    0,    0,    0,  110,
    0,    0,    0,    0,    0,    0,   73,   73,   73,  -23,
  -23,  -23,  -23, -131, -153,    0,  107, -111,  -70,    0,
   39, -184,    0,   37,    0,  115,   55,    0,    0,    0,
  133,    0,    0,    0,    0,    0,    0,    0,    0,   73,
  135,    0,    0,    0,    0,    0,    0, -114,    0,  -89,
 -186,    0,  134,    0,   54,  -70,  -87,  142,  141,  166,
  144,  145,    0,   68,    0,    0,    0,  -91,    0,  153,
    0,  -73,  102,  156, -153,    0,    0,  160,    0,  166,
   77,  166,  166,    0,  -50,   88,    0,    0,  111,  -70,
 -153,    0,    0,    0,    0,    0,    0,   89,    0,  -70,
    0,    0,
};
short yyrindex[] = {                                      0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,   11,
    0,    0,  215,   10,    0,    0,    0,    0,    0,    0,
    0,    0,    0,   12,    0,    0,    0,    0,    0,    1,
    0,    0,    0,    0,    0,    0,    0,    0,    0,   31,
    0,    6,   26,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,   78,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,  221,    0,   28,
    0,   11,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,  100,    0,   13,    0,    0,  -56,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
  101,  104,    0,    0,    0,    0,    0,    0,    0,   52,
    0,    0,    0,    0,  105,    0,    0,   97,    0,  112,
    0,  114,  119,    0,    0,    0,    0,    0,    0,  178,
  120,    0,    0,    0,    0,    0,    0,    0,    0,  179,
    0,    0,
};
short yygindex[] = {                                      0,
   22,    0,    0,  386,   29,  350,    0,  168,    0,    0,
    0,  295,   50,  -68,    0,    0,    0,    0,  404,  118,
    0,   34,    0,  143,  169,  -27,  200,  -18,    0,    0,
  106, -118,   44,  229,  244,    0,  -90,
};
#define YYTABLESIZE 530
short yytable[] = {                                      35,
   48,   61,  102,   62,   12,   44,   35,   59,   51,    8,
   26,   22,   96,   61,  100,   48,   94,  157,   35,   59,
   60,   35,   62,   74,   67,   47,  132,    6,   17,   49,
   40,  165,   68,  103,   62,   47,   60,   56,   89,   17,
   88,   48,   48,   48,   48,   48,   44,   48,   44,   44,
   44,   52,  140,   97,   26,   22,   96,   69,   90,   63,
   48,  157,   48,   91,  172,   44,   47,   44,   47,   47,
   47,   40,    1,   73,   40,    2,   36,   26,   70,  166,
  181,   35,   72,  146,   50,   47,  132,   47,   75,   95,
   40,  115,   40,   35,   61,   52,  178,  104,   17,   35,
  152,  110,  132,   74,  117,   35,  106,  119,  130,  109,
   92,   35,    7,    8,    9,   93,  105,   35,   48,   48,
   48,   26,   48,   48,   48,   48,  128,  129,   44,  107,
   44,   77,   78,   79,    8,   26,   22,   96,  112,  114,
   74,  169,    1,   60,  118,    2,    1,  136,   47,    2,
   47,  180,    6,   40,   50,   40,    1,  138,   50,    2,
    3,    4,    5,  145,    6,    7,    8,    9,   10,   85,
    4,   86,  148,  149,   52,  151,   52,  155,  156,  153,
  154,  158,  159,  161,  160,  168,    1,  162,  163,    2,
    3,    4,  164,  167,    6,    7,    8,    9,   10,  171,
  173,  175,   26,  174,  139,  176,  177,  124,  125,  126,
  127,    4,  179,  182,    4,    1,   58,   12,    2,   74,
    2,  107,  108,   45,   60,   84,  108,   50,   85,  104,
   57,   46,   32,   33,   34,   58,   82,   31,   80,   32,
   33,   34,   30,   81,  102,   30,  147,   58,  120,   31,
  101,   32,   33,   34,   32,   33,   34,   48,  170,   76,
   48,   71,   44,    0,    0,   44,    0,    0,   11,   48,
   48,   48,   48,   48,   44,   44,   44,   44,   44,    7,
    8,    9,   47,    0,    0,   47,    0,   40,    0,    0,
   40,    0,    0,    0,   47,   47,   47,   47,   47,   40,
   40,   40,   40,   40,    0,   30,    0,    0,   52,    0,
    0,   52,   31,    0,   32,   33,   34,   30,    0,    0,
   52,    0,    0,   30,   31,    0,   32,   33,   34,   30,
   31,    0,   32,   33,   34,   30,   31,    0,   32,   33,
   34,   30,   31,   98,   32,   33,   34,    0,   31,   18,
   32,   33,   34,   74,   18,    0,   74,   74,   74,    0,
   18,   74,   74,   74,   74,   74,    0,    7,    8,    9,
    0,   74,    7,    8,    9,    0,    7,    8,    9,   81,
   82,   83,   84,    0,    0,   16,    0,    0,    0,  131,
   52,  137,    0,   18,    0,    0,   16,    0,    0,    0,
   18,   18,    1,    0,   39,    2,    3,    4,    5,    0,
    6,    7,    8,    9,   10,    0,    0,    0,    0,   18,
  116,    0,    1,    0,    0,    2,    3,    4,    0,   52,
    6,    7,    8,    9,   10,    0,   52,   52,    0,   80,
  139,    0,    0,    0,    0,    0,    0,   98,   18,  131,
    0,   18,    0,    0,    0,   16,    0,    0,    0,    0,
    0,    0,    0,  137,  111,  131,    0,    0,    0,  113,
    0,    0,    0,    0,    0,    0,    0,   18,  111,    0,
    0,    0,    0,    0,    0,   18,    0,   52,    0,   18,
  121,  122,  123,    1,    0,    0,    2,    3,    4,    5,
    0,    6,    7,    8,    9,   10,    0,   39,    0,   18,
    0,   18,   18,   52,    0,    0,    0,    0,    0,   18,
    0,    0,    0,  150,    0,    0,    0,    0,    0,   18,
};
short yycheck[] = {                                      45,
    0,   40,   44,   61,   61,    0,   45,   46,  123,    0,
    0,    0,    0,   40,  125,  269,   44,  136,   45,   46,
   59,   45,   61,   46,  125,    0,   95,    0,    0,  269,
    0,  123,   11,   52,   61,    2,   59,  281,   43,   11,
   45,   41,   42,   43,   44,   45,   41,   47,   43,   44,
   45,    0,  123,   40,   44,   44,   44,  125,   42,   10,
   60,  180,   62,   47,  155,   60,   41,   62,   43,   44,
   45,   41,  257,   24,   44,  260,   40,    0,   44,  148,
  171,   45,  269,  102,  269,   60,  155,   62,   40,  123,
   60,   70,   62,   45,   40,   44,  165,  264,   70,   45,
  128,   41,  171,   46,   71,   45,  269,   41,  262,   60,
   42,   45,  266,  267,  268,   47,  125,   45,   41,   42,
   43,   44,   45,  123,   47,  125,  258,  259,  123,  269,
  125,  278,  279,  280,  125,  125,  125,  125,   41,  125,
   44,   40,  257,   59,  269,  260,  257,   41,  123,  260,
  125,   41,  125,  123,  269,  125,  257,  269,  269,  260,
  261,  262,  263,  125,  265,  266,  267,  268,  269,   60,
  262,   62,   58,   41,  123,   41,  125,   44,  125,  269,
  131,  269,   41,  140,   44,  259,  257,   44,   44,  260,
  261,  262,  125,   41,  265,  266,  267,  268,  269,   44,
   41,  125,  125,  160,  275,  162,  163,   90,   91,   92,
   93,  262,  125,  125,    0,  257,  274,  274,  260,  123,
    0,   44,   44,  269,  125,  125,   59,  269,  125,  125,
  269,  277,  278,  279,  280,  274,  125,  276,  125,  278,
  279,  280,  269,  125,  125,  269,  104,  274,   80,  276,
   51,  278,  279,  280,  278,  279,  280,  257,  153,   31,
  260,   18,  257,   -1,   -1,  260,   -1,   -1,  123,  269,
  270,  271,  272,  273,  269,  270,  271,  272,  273,  266,
  267,  268,  257,   -1,   -1,  260,   -1,  257,   -1,   -1,
  260,   -1,   -1,   -1,  269,  270,  271,  272,  273,  269,
  270,  271,  272,  273,   -1,  269,   -1,   -1,  257,   -1,
   -1,  260,  276,   -1,  278,  279,  280,  269,   -1,   -1,
  269,   -1,   -1,  269,  276,   -1,  278,  279,  280,  269,
  276,   -1,  278,  279,  280,  269,  276,   -1,  278,  279,
  280,  269,  276,   49,  278,  279,  280,   -1,  276,    0,
  278,  279,  280,  257,    5,   -1,  260,  261,  262,   -1,
   11,  265,  266,  267,  268,  269,   -1,  266,  267,  268,
   -1,  275,  266,  267,  268,   -1,  266,  267,  268,  270,
  271,  272,  273,   -1,   -1,    0,   -1,   -1,   -1,   95,
    5,   97,   -1,   44,   -1,   -1,   11,   -1,   -1,   -1,
   51,   52,  257,   -1,    1,  260,  261,  262,  263,   -1,
  265,  266,  267,  268,  269,   -1,   -1,   -1,   -1,   70,
   71,   -1,  257,   -1,   -1,  260,  261,  262,   -1,   44,
  265,  266,  267,  268,  269,   -1,   51,   52,   -1,   36,
  275,   -1,   -1,   -1,   -1,   -1,   -1,  153,   99,  155,
   -1,  102,   -1,   -1,   -1,   70,   -1,   -1,   -1,   -1,
   -1,   -1,   -1,  169,   61,  171,   -1,   -1,   -1,   66,
   -1,   -1,   -1,   -1,   -1,   -1,   -1,  128,   75,   -1,
   -1,   -1,   -1,   -1,   -1,  136,   -1,  102,   -1,  140,
   87,   88,   89,  257,   -1,   -1,  260,  261,  262,  263,
   -1,  265,  266,  267,  268,  269,   -1,  104,   -1,  160,
   -1,  162,  163,  128,   -1,   -1,   -1,   -1,   -1,  170,
   -1,   -1,   -1,  120,   -1,   -1,   -1,   -1,   -1,  180,
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
"Programa : '{' '}'",
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
#line 215 "gramatica.y"

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
#line 487 "y.tab.c"
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
case 5:
#line 20 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Programa vacio ");}
break;
case 8:
#line 25 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba una ',' al final de la linea ");}
break;
case 12:
#line 33 "gramatica.y"
{AnalizadorLexico.agregarEstructura("Reconoce referencia objeto ");}
break;
case 13:
#line 36 "gramatica.y"
{AnalizadorLexico.agregarEstructura("Reconoce llamado a funcion de clase ");}
break;
case 21:
#line 48 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se espera el tipo de la variable ");}
break;
case 22:
#line 49 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se espera identificador de la variable ");}
break;
case 32:
#line 67 "gramatica.y"
{chequearEnteroPositivo(yyvsp[0].sval);}
break;
case 33:
#line 68 "gramatica.y"
{chequearEnteroCorto(yyvsp[0].sval);}
break;
case 34:
#line 69 "gramatica.y"
{AnalizadorLexico.agregarErrorLexico("Un entero corto no puede ser negativo ");}
break;
case 35:
#line 70 "gramatica.y"
{chequearDouble(yyvsp[0].sval);}
break;
case 36:
#line 71 "gramatica.y"
{chequearEnteroNegativo(yyvsp[0].sval);}
break;
case 37:
#line 72 "gramatica.y"
{chequearDouble(yyvsp[0].sval);}
break;
case 52:
#line 98 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba una ')' ");}
break;
case 53:
#line 99 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba una '(' ");}
break;
case 54:
#line 102 "gramatica.y"
{AnalizadorLexico.agregarEstructura("Reconoce IF ELSE ");}
break;
case 55:
#line 103 "gramatica.y"
{AnalizadorLexico.agregarEstructura("Reconoce IF ");}
break;
case 57:
#line 107 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Falta un '{'"); }
break;
case 58:
#line 108 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("No hay sentencias dentro de las llaves."); }
break;
case 62:
#line 115 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Falta una ','"); }
break;
case 71:
#line 130 "gramatica.y"
{AnalizadorLexico.agregarEstructura("Reconoce funcion VOID ");}
break;
case 72:
#line 131 "gramatica.y"
{AnalizadorLexico.agregarEstructura("Reconoce funcion VOID ");}
break;
case 74:
#line 136 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba un ')' ");}
break;
case 75:
#line 137 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba un '(' ");}
break;
case 77:
#line 141 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba un '{' ");}
break;
case 84:
#line 150 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba una ',' al final de la linea ");}
break;
case 85:
#line 151 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba una ',' al final de la linea ");}
break;
case 86:
#line 156 "gramatica.y"
{AnalizadorLexico.agregarEstructura("Reconoce llamado funcion ");}
break;
case 87:
#line 157 "gramatica.y"
{AnalizadorLexico.agregarEstructura("Reconoce llamado funcion ");}
break;
case 88:
#line 159 "gramatica.y"
{AnalizadorLexico.agregarEstructura("Reconoce salida de mensaje por pantalla ");}
break;
case 89:
#line 160 "gramatica.y"
{AnalizadorLexico.agregarEstructura("Reconoce salida de mensaje por pantalla ");}
break;
case 95:
#line 172 "gramatica.y"
{AnalizadorLexico.agregarEstructura("Reconoce funcion DO UNTIL");}
break;
case 96:
#line 173 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba una condicion ");}
break;
case 98:
#line 179 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba un '(' ");}
break;
case 99:
#line 182 "gramatica.y"
{AnalizadorLexico.agregarEstructura("Reconoce funcion TOD ");}
break;
case 100:
#line 183 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba una Expresion ");}
break;
case 106:
#line 196 "gramatica.y"
{AnalizadorLexico.agregarEstructura("Reconoce CLASE");}
break;
case 107:
#line 200 "gramatica.y"
{AnalizadorLexico.agregarEstructura("Reconoce Funcion sin cuerpo");}
break;
case 108:
#line 201 "gramatica.y"
{AnalizadorLexico.agregarEstructura("Reconoce Funcion sin cuerpo");}
break;
case 109:
#line 204 "gramatica.y"
{AnalizadorLexico.agregarEstructura("Reconoce funcion IMPL");}
break;
case 110:
#line 205 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba un '{' ");}
break;
#line 803 "y.tab.c"
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
