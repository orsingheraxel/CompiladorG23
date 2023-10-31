#ifndef lint
static char yysccsid[] = "@(#)yaccpar	1.8 (Berkeley) 01/20/90";
#endif
#define YYBYACC 1
#line 2 "gramatica.y"
package AnalisisLexico;;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
#line 12 "y.tab.c"
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
    6,    7,    4,    4,    4,    4,    4,   12,   12,    5,
    5,    5,    5,    5,    5,    5,   17,   17,   13,   13,
   13,   19,   18,   14,   14,   14,   20,   20,   20,   20,
   20,   20,   21,   21,   21,   21,   22,   22,   22,   22,
   22,   22,   24,   24,   25,   26,   10,   10,   28,   28,
   28,   27,   27,   27,   27,   27,   27,   29,   29,   29,
   29,   15,   15,   15,   31,   32,   33,   33,   33,   33,
   33,   33,    8,    8,    8,   11,   34,   34,    9,    9,
    9,    9,    9,    3,    3,   23,   23,   35,   35,   35,
   35,   35,   35,   16,   16,   36,   36,   36,   30,   30,
   37,
};
short yylen[] = {                                         2,
    3,    2,    2,    1,    2,    3,    1,    1,    1,    1,
    3,    3,    1,    1,    1,    1,    1,    3,    2,    2,
    1,    1,    1,    1,    1,    1,    1,    3,    1,    3,
    0,    1,    2,    1,    1,    1,    1,    1,    2,    1,
    2,    2,    3,    3,    1,    1,    3,    3,    1,    3,
    3,    1,    1,    1,    1,    3,   12,    8,    2,    3,
    1,    1,    1,    1,    1,    1,    1,    1,    1,    2,
    2,   10,    9,    7,    2,    1,    3,    3,    2,    2,
    1,    1,    3,    4,    4,    2,    1,    1,    3,    3,
    3,    3,    3,    8,    5,    4,    3,    1,    1,    3,
    2,    2,    3,    5,    2,    3,    4,    3,    6,    5,
    7,
};
short yydefred[] = {                                      0,
    0,    0,    0,    0,    0,   35,   34,   36,    0,    0,
    0,    0,    0,    8,    9,   10,    0,   17,   14,   13,
   15,   16,   24,   22,    0,   21,   25,   26,    0,    0,
    0,   86,    0,    0,    0,   32,   88,    0,    0,   87,
    0,    0,    0,    3,    0,    0,   32,   20,    0,    0,
    0,    0,   37,   38,   40,    0,   55,   54,    0,    0,
   46,    0,    0,    0,    0,    0,    0,    0,    0,    0,
   12,   83,    0,    0,   18,    0,   55,   54,   90,    1,
    6,    0,   93,   28,   30,    0,    0,   41,   39,   42,
   66,   67,   65,   64,   62,   63,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,   84,
   85,   11,   97,    0,   56,   44,   43,   47,   48,   50,
   51,    0,    0,    0,    0,    0,   71,    0,   70,  104,
  101,    0,    0,   75,    0,   60,    0,   96,    0,    0,
    0,  108,    0,  103,  100,    0,    0,    0,   76,    0,
    0,    0,    0,    0,    0,  107,    0,    0,    0,   74,
    0,    0,    0,   58,  110,    0,    0,   78,   77,    0,
    0,   94,    0,  109,    0,   73,    0,    0,  111,   72,
    0,   57,
};
short yydgoto[] = {                                      11,
   12,   13,   14,   68,  157,   17,   18,   19,   20,   21,
   22,   23,   24,   25,   26,   27,   28,   29,   30,   58,
   59,   60,   61,   62,   63,   64,   97,   69,  110,  111,
  117,  158,  159,   42,  112,  113,  114,
};
short yysindex[] = {                                    -86,
   -6, -236, -222, -172,  -23,    0,    0,    0,   45,   79,
    0,   -4,   65,    0,    0,    0,  -58,    0,    0,    0,
    0,    0,    0,    0, -157,    0,    0,    0,   70,   90,
  -28,    0,   38,  111, -162,    0,    0, -107,  -41,    0,
  119,  -16,   42,    0,   79,  -91,    0,    0, -157, -157,
  126,  139,    0,    0,    0, -138,    0,    0,  -49,   89,
    0,   46,   73,  143,  -60,  -10,   -7,  144,   62,  151,
    0,    0,  153,   81,    0,  126,    0,    0,    0,    0,
    0,  126,    0,    0,    0,  -77,  -36,    0,    0,    0,
    0,    0,    0,    0,    0,    0,  -28,  -28,  -28,  -33,
  -33,  -33,  -33,   72,  -73,  -81,  155,  -66,  -52,  169,
  -52,   95,  -60,  170,  102,  -54,  176, -162,  -46,    0,
    0,    0,    0,  185,    0,    0,    0,    0,    0,    0,
    0, -162,  187,  -35,  -37,  210,    0,  -60,    0,    0,
    0,  -60,   64,    0,  136,    0,  225,    0,  141,   49,
  211,    0,  -37,    0,    0,  224,  226, -118,    0,   64,
  -28, -134,  -18,  234,  159,    0,   64,   64,  244,    0,
   15,  258,  178,    0,    0,  -12,   44,    0,    0,  179,
  264,    0, -162,    0,  186,    0,  188,  193,    0,    0,
   69,    0,
};
short yyrindex[] = {                                     60,
    0,    0,    0,    0,    0,    0,    0,    0,   25,   60,
    0,  322,   10,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,   20,    0,    0,    0,   22,   23,
    0,    0,   27,    0,    0,    0,    0,    0,    0,    0,
    2,    0,  329,    0,   86,    0,    0,    0,   28,   28,
    1,    0,    0,    0,    0,    0,    0,    0,    0,   21,
    0,    8,   14,    0,    0,    0,    0,  212,    0,  -55,
    0,    0,    0,   93,    0,   35,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,  291,    0,
  299,    0,  219,  228,    0,    0,    0,  229,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,  230,    0,    0,
    0,    0,  -26,    0,    0,    0,   87,    0,    0,    0,
    0,    0, -106,    0,    0, -110, -109,    0,    0,  -20,
    0,    0,    0,    0,    0,    0,  -26,  -26,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,
};
short yygindex[] = {                                      0,
   63,    0,    0,   30,   92,  281,    0,  318,    0,    0,
    0,    0,   94,   51,  196,    0,    0,    0,    0,  315,
   71,  249,    0,  319,    0,  198,    0,  -82,  -15,    0,
  213,  200,  -13,  344,  -24,  -97,    0,
};
#define YYTABLESIZE 442
short yytable[] = {                                      72,
   53,   19,   40,   56,  123,   11,  170,   49,   56,    7,
   95,   56,   96,   52,   81,   82,   56,   31,  106,   23,
   45,   27,   29,   31,   31,  175,  105,   31,   56,   15,
  115,  184,   39,   31,   53,  146,   10,  152,   38,   15,
   32,   53,   53,   53,   53,   53,   33,   53,   49,  149,
   49,   49,   49,   40,   52,  166,   52,   52,   52,   31,
   53,   45,   53,   23,   45,   27,   29,   49,   31,   49,
  105,   31,   43,   52,   15,   52,   53,   53,   53,   53,
   45,   53,   45,   32,   39,    5,   95,  100,  141,  163,
   38,   16,  101,  137,    1,  139,   34,    2,   31,   35,
  188,   16,   41,   31,  143,   40,   67,   81,   45,   73,
  160,   47,   79,  154,  102,  108,  116,  155,   48,  103,
   44,  121,  100,  173,  174,   53,   19,  101,   49,   31,
   95,   99,   49,   98,    7,   49,   16,   49,   52,   88,
   89,   90,   84,   85,   23,   45,   27,   29,   50,   31,
   66,  105,   31,  178,  179,  106,  169,  124,  106,   53,
   65,   70,   75,  108,   81,   82,   80,  125,  126,  127,
    1,   86,  156,    2,    3,    4,    5,   82,   87,    6,
    7,    8,    9,  104,   31,  108,  119,  118,  108,  156,
   39,  122,  108,  120,  132,  133,  156,  156,  135,  134,
  116,  105,  136,  108,  106,    6,    7,    8,  107,  105,
    5,   95,  138,  142,  144,   37,  145,  147,   11,  140,
   91,   92,   93,   94,  143,  148,  150,   51,    6,    7,
    8,  107,   51,  151,   52,   51,   53,   54,   55,   52,
   51,   53,   54,   55,   53,   54,   55,   52,   31,   53,
   54,   55,   76,  153,   31,    6,    7,    8,  160,   52,
  109,   53,   54,   55,  161,  162,   37,  167,  165,  168,
   53,   53,   53,   53,  176,   53,   19,   49,   49,   49,
   49,  177,   49,   52,   52,   52,   52,  180,   52,  181,
   45,   45,   45,   45,   23,   45,   27,   29,  182,   31,
  183,  105,   31,  186,  109,    4,  109,  187,  109,   53,
  189,   57,  190,   36,    6,    7,    8,  191,   37,   57,
    1,    4,   77,    2,    3,    4,   83,  192,    2,    6,
    7,    8,    9,  109,   68,    1,   61,  109,    2,    3,
    4,    5,   69,   98,    6,    7,    8,    9,  128,  129,
  130,  131,   99,   59,  102,   71,   78,   74,  172,  171,
   46,    0,  164,    0,    0,    0,    0,   57,    0,    0,
    0,    0,  185,    0,    0,    0,    0,   57,   57,   57,
   57,   57,   57,   57,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,   57,
};
short yycheck[] = {                                      41,
    0,    0,   61,   45,   41,   61,  125,    0,   45,    0,
   60,   45,   62,    0,  125,  125,   45,   44,  125,    0,
    0,    0,    0,   44,    0,   44,    0,    0,   45,    0,
   41,   44,   40,   40,    0,  118,  123,  135,   46,   10,
  277,   41,   42,   43,   44,   45,  269,   47,   41,  132,
   43,   44,   45,   61,   41,  153,   43,   44,   45,    0,
   60,   41,   62,   44,   44,   44,   44,   60,   44,   62,
   44,   44,   10,   60,   45,   62,   42,   43,   44,   45,
   60,   47,   62,   59,   40,    0,    0,   42,  113,   41,
   46,    0,   47,  109,  257,  111,  269,  260,  125,  123,
  183,   10,    9,   44,  123,   61,  269,   45,   44,   39,
  123,  269,   42,  138,   42,   65,   66,  142,   25,   47,
  125,   41,   42,  258,  259,  125,  125,   47,   59,   44,
   44,   43,  125,   45,  125,   43,   45,   45,  125,  278,
  279,  280,   49,   50,  125,  125,  125,  125,   59,  125,
   40,  125,  125,  167,  168,  262,  275,   87,  265,  125,
  123,  269,   44,  113,  275,  275,  125,   97,   98,   99,
  257,   46,  143,  260,  261,  262,  263,  269,   40,  266,
  267,  268,  269,   41,  125,  135,  125,   44,  138,  160,
   40,  269,  142,   41,  123,  269,  167,  168,   44,  281,
  150,  262,  269,  153,  265,  266,  267,  268,  269,  262,
  125,  125,   44,   44,  269,  274,   41,  264,  274,  125,
  270,  271,  272,  273,  123,   41,   40,  269,  266,  267,
  268,  269,  269,  269,  276,  269,  278,  279,  280,  276,
  269,  278,  279,  280,  278,  279,  280,  276,  275,  278,
  279,  280,  269,   44,  275,  266,  267,  268,  123,  276,
   65,  278,  279,  280,   40,  125,  274,   44,   58,   44,
  270,  271,  272,  273,   41,  275,  275,  270,  271,  272,
  273,  123,  275,  270,  271,  272,  273,   44,  275,  275,
  270,  271,  272,  273,  275,  275,  275,  275,   41,  275,
  123,  275,  275,  125,  109,  262,  111,   44,  113,  275,
  125,   31,  125,  269,  266,  267,  268,  125,  274,   39,
  257,    0,   42,  260,  261,  262,   46,  259,    0,  266,
  267,  268,  269,  138,   44,  257,  125,  142,  260,  261,
  262,  263,   44,  125,  266,  267,  268,  269,  100,  101,
  102,  103,  125,  125,  125,   38,   42,   39,  161,  160,
   17,   -1,  150,   -1,   -1,   -1,   -1,   87,   -1,   -1,
   -1,   -1,  177,   -1,   -1,   -1,   -1,   97,   98,   99,
  100,  101,  102,  103,   -1,   -1,   -1,   -1,   -1,   -1,
   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,
   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,
   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,
   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,
   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,
   -1,  161,
};
#define YYFINAL 11
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
"ClaseSentenciaEjecutable : ID ListVariables ','",
"ClaseSentenciaEjecutable : ID ListVariables",
"SentenciaDeclarativa : Tipo ListVariables",
"SentenciaDeclarativa : Funcion",
"SentenciaDeclarativa : ListVariables",
"SentenciaDeclarativa : Tipo",
"SentenciaDeclarativa : ClaseSentenciaEjecutable",
"SentenciaDeclarativa : HerenciaComposicion",
"SentenciaDeclarativa : List_objeto_clase",
"List_objeto_clase : Objeto_clase",
"List_objeto_clase : Objeto_clase ';' ListVariables",
"ListVariables : DeclaracionVariable",
"ListVariables : DeclaracionVariable ';' ListVariables",
"ListVariables :",
"DeclaracionVariable : ID",
"Objeto_clase : ID ID",
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
"Condicion : Expresion Comparador Expresion",
"BloqueIF : IF '(' Condicion ')' '{' ListSentenciasIF '}' ELSE '{' ListSentenciasIF '}' END_IF",
"BloqueIF : IF '(' Condicion ')' '{' ListSentenciasIF '}' END_IF",
"ListSentenciasIF : SentenciaEjecutable ','",
"ListSentenciasIF : SentenciaEjecutable ',' ListSentenciasIF",
"ListSentenciasIF : SentenciaEjecutable",
"Comparador : '<'",
"Comparador : '>'",
"Comparador : MAYORIGUAL",
"Comparador : MENORIGUAL",
"Comparador : IGUAL",
"Comparador : DIST",
"ListFuncion : Funcion",
"ListFuncion : FuncionSinCuerpo",
"ListFuncion : FuncionSinCuerpo ListFuncion",
"ListFuncion : Funcion ListFuncion",
"Funcion : VOID ID '(' Parametro ')' '{' CuerpoFuncion RETURN ',' '}'",
"Funcion : VOID ID '(' ')' '{' CuerpoFuncion RETURN ',' '}'",
"Funcion : VOID ID '(' ')' '{' CuerpoFuncion '}'",
"Parametro : Tipo ID",
"CuerpoFuncion : ListSentenciasFuncion",
"ListSentenciasFuncion : SentenciaDeclarativa ',' ListSentenciasFuncion",
"ListSentenciasFuncion : SentenciaEjecutable ',' ListSentenciasFuncion",
"ListSentenciasFuncion : SentenciaEjecutable ','",
"ListSentenciasFuncion : SentenciaDeclarativa ','",
"ListSentenciasFuncion : SentenciaEjecutable",
"ListSentenciasFuncion : SentenciaDeclarativa",
"LlamadoFuncion : ID '(' ')'",
"LlamadoFuncion : ID '(' Expresion ')'",
"LlamadoFuncion : ID '(' Factor ')'",
"SalidaMensaje : PRINT CADENA",
"OperadorAsignacion : '='",
"OperadorAsignacion : ASIG",
"Asignacion : ID OperadorAsignacion ID",
"Asignacion : ID OperadorAsignacion Expresion",
"Asignacion : ID OperadorAsignacion Constante",
"Asignacion : ID OperadorAsignacion ReferenciaObjeto",
"Asignacion : ReferenciaObjeto OperadorAsignacion ReferenciaObjeto",
"SentenciaControl : DO '{' ListSentenciasIF '}' UNTIL '(' Condicion ')'",
"SentenciaControl : DO '{' ListSentenciasIF '}' UNTIL",
"ConversionExplicita : TOD '(' Expresion ')'",
"ConversionExplicita : TOD '(' ')'",
"ListHerencia : DeclaracionAtributo",
"ListHerencia : FuncionIMPL",
"ListHerencia : FuncionIMPL ',' ListHerencia",
"ListHerencia : DeclaracionAtributo ListHerencia",
"ListHerencia : ListFuncion ','",
"ListHerencia : ListFuncion ',' ListHerencia",
"HerenciaComposicion : CLASS ID '{' ListHerencia '}'",
"HerenciaComposicion : CLASS ID",
"DeclaracionAtributo : Tipo ID ','",
"DeclaracionAtributo : Tipo ID ',' DeclaracionAtributo",
"DeclaracionAtributo : ID ',' DeclaracionAtributo",
"FuncionSinCuerpo : VOID ID '(' Parametro ')' ','",
"FuncionSinCuerpo : VOID ID '(' ')' ','",
"FuncionIMPL : IMPL FOR ID ':' '{' Funcion '}'",
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
#line 211 "gramatica.y"
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
#line 431 "y.tab.c"
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
case 2:
#line 15 "gramatica.y"
{agregarErrorSintactico("Se espera '}' en la linea ");}
break;
case 3:
#line 16 "gramatica.y"
{agregarErrorSintactico("Se espera '{' en la linea ");}
break;
case 4:
#line 17 "gramatica.y"
{agregarErrorSintactico("Se esperan '{' '}' en la linea ");}
break;
case 7:
#line 22 "gramatica.y"
{agregarErrorSintactico("Se esperaba una ',' al final de la linea ");}
break;
case 19:
#line 44 "gramatica.y"
{agregarErrorSintactico("Se esperaba una ',' al final de la linea ");}
break;
case 22:
#line 49 "gramatica.y"
{agregarErrorSintactico("Se espera el tipo de la variable en la linea ");}
break;
case 23:
#line 50 "gramatica.y"
{agregarErrorSintactico("Se espera identificador de la variable en la linea ");}
break;
case 39:
#line 78 "gramatica.y"
{agregarErrorLexico("Un entero corto no puede ser negativo en la linea ");}
break;
case 57:
#line 109 "gramatica.y"
{agregarEstructura("Reconoce ELSE IF ");}
break;
case 58:
#line 110 "gramatica.y"
{agregarEstructura("Reconoce IF ");}
break;
case 61:
#line 115 "gramatica.y"
{agregarErrorSintactico("Se esperaba una ',' al final de la linea ");}
break;
case 72:
#line 132 "gramatica.y"
{agregarEstructura("Reconoce funcion VOID ");}
break;
case 73:
#line 133 "gramatica.y"
{agregarEstructura("Reconoce funcion VOID ");}
break;
case 74:
#line 134 "gramatica.y"
{agregarEstructura("Reconoce funcion VOID ");}
break;
case 81:
#line 147 "gramatica.y"
{agregarErrorSintactico("Se esperaba una ',' al final de la linea ");}
break;
case 82:
#line 148 "gramatica.y"
{agregarErrorSintactico("Se esperaba una ',' al final de la linea ");}
break;
case 94:
#line 170 "gramatica.y"
{agregarEstructura("Reconoce funcion DO UNTIL");}
break;
case 95:
#line 171 "gramatica.y"
{agregarErrorSintactico("Se esperaba una condicion ");}
break;
case 96:
#line 176 "gramatica.y"
{agregarEstructura("Reconoce funcion TOD ");}
break;
case 97:
#line 177 "gramatica.y"
{agregarErrorSintactico("Se esperaba una Expresion ");}
break;
case 104:
#line 188 "gramatica.y"
{agregarEstructura("Reconoce CLASE");}
break;
case 109:
#line 197 "gramatica.y"
{agregarEstructura("Reconoce Funcion sin cuerpo");}
break;
case 111:
#line 201 "gramatica.y"
{agregarEstructura("Reconoce funcion IMPL");}
break;
#line 663 "y.tab.c"
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
