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
#define ListaSentencias 283
#define YYERRCODE 256
short yylhs[] = {                                        -1,
    0,    0,    1,    1,    1,    2,    2,    2,    2,    6,
    7,    4,    4,    4,    4,    4,    5,    5,    5,    5,
    5,    5,    5,   13,   13,   16,   12,   12,   12,   18,
   18,   18,   18,   18,   18,   19,   19,   19,   19,   20,
   20,   20,   20,   20,   20,   22,   22,   23,   24,   24,
   24,   10,   10,   10,   10,   10,   10,   10,   10,   10,
   10,   10,   10,   10,   10,   10,   26,   26,   26,   26,
   26,   26,   26,   26,   27,   28,   28,   28,   28,   28,
   28,   25,   25,   25,   25,   25,   25,   29,   29,   14,
   14,   14,   14,   31,   31,   31,   32,   32,   32,   33,
   33,   33,   33,   33,   33,    8,    8,    8,    8,   11,
   11,   11,   35,   35,   36,    9,    9,    9,    3,    3,
   34,   34,   21,   21,   37,   38,   38,   38,   38,   38,
   38,   38,   38,   15,   30,   30,   17,   17,   17,
};
short yylen[] = {                                         2,
    3,    3,    2,    3,    1,    1,    1,    1,    2,    3,
    3,    1,    1,    1,    1,    1,    2,    1,    2,    2,
    1,    1,    1,    1,    3,    2,    1,    1,    1,    1,
    1,    2,    1,    2,    2,    3,    3,    1,    1,    3,
    3,    1,    3,    3,    1,    1,    1,    1,    5,    5,
    5,    6,    4,    6,    4,    7,    8,    7,    7,    7,
    7,    7,    7,    7,    7,    5,    3,    2,    2,    5,
    5,    3,    3,    2,    1,    1,    2,    2,    3,    3,
    3,    1,    1,    1,    1,    1,    1,    1,    1,    4,
    5,    5,    5,    4,    4,    4,    3,    3,    3,    3,
    3,    2,    2,    2,    3,    3,    3,    3,    2,    2,
    2,    2,    1,    1,    0,    4,    3,    3,    4,    3,
    3,    2,    2,    3,    3,    3,    4,    2,    3,    3,
    4,    2,    3,    3,    3,    4,    7,    7,    7,
};
short yydefred[] = {                                      0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
   28,   27,   29,    0,    0,    0,    0,    6,    7,    8,
    0,   16,   13,   12,   14,   15,    0,   18,   21,   22,
   23,    0,    0,   19,    0,    0,    0,  112,   46,  110,
   30,   31,   33,    0,   47,  111,    0,    0,    0,    0,
    0,    0,    0,    0,    0,  114,    0,    0,    0,  113,
   48,   26,    0,    0,   39,    0,    0,  109,    0,    9,
    2,    0,    0,   20,   17,    1,    0,    0,    0,    0,
    0,    0,    0,   34,   32,   35,    0,  134,    0,    0,
    0,   75,    0,   69,   68,   74,    0,    0,    0,  107,
    0,    0,  123,    0,   11,  108,  106,    0,  122,    0,
    0,    0,    0,    0,    0,  115,    4,  117,  118,   25,
   86,   87,   85,   84,   82,   83,    0,    0,    0,    0,
   55,    0,   53,    0,    0,   88,    0,   89,    0,    0,
    0,    0,    0,    0,    0,    0,   90,   72,   73,    0,
   67,  119,    0,   10,  124,  121,   37,   36,   40,   41,
   43,   44,  116,    0,    0,    0,   66,    0,    0,    0,
    0,    0,    0,    0,    0,  125,   92,    0,   93,   91,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
   51,   50,   49,    0,    0,    0,    0,    0,    0,    0,
   54,   52,    0,    0,    0,    0,  133,  129,   96,   95,
   94,    0,    0,    0,   98,   99,   97,   71,   70,    0,
    0,   64,   63,   62,   60,    0,   59,   56,   65,   61,
   58,    0,  131,  127,  105,  101,  100,  138,  139,  137,
   57,
};
short yydgoto[] = {                                       3,
   16,   17,   18,  183,  184,   61,   22,   23,   24,   25,
   26,   27,   34,   28,   29,   30,   31,   45,   63,   64,
   65,   66,   67,   37,  127,   52,   93,    0,  137,  138,
   91,  147,  185,   68,   69,  163,   88,  139,
};
short yysindex[] = {                                   -101,
  106,  106,    0, -241,  -39,   18, -224, -214, -105, -200,
    0,    0,    0,  -40, -189,  -13,   60,    0,    0,    0,
  -46,    0,    0,    0,    0,    0, -217,    0,    0,    0,
    0,    4,   80,    0,   23,   23, -111,    0,    0,    0,
    0,    0,    0,  -84,    0,    0,   21,  -38, -122,  -35,
 -121,  -82,  -77,  143,   12,    0,   -9,  -76,   -3,    0,
    0,    0,  144,  136,    0,   22,   35,    0,   23,    0,
    0,  106,   11,    0,    0,    0, -241,  141,   88,   88,
  -32,  -33, -102,    0,    0,    0, -188,    0,  -17,   76,
  -97,    0,   73,    0,    0,    0, -109,  -39,  146,    0,
  -64,    3,    0,  -15,    0,    0,    0,  167,    0,   23,
   23,   11,   11,   11,   11,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,   23,   23, -197, -135,
    0, -111,    0,  -60, -241,    0,  -24,    0,   85,  -97,
  -58,  -97,  -97,  -57,  122,  122,    0,    0,    0,  -21,
    0,    0,  -96,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,  172,  -34, -105,    0, -111, -111,  -11,
  -87,  -37,   -4, -188, -188,    0,    0,  173,    0,    0,
  -31,  176,  182,  183,  108,  -93,  118,  131,   -5,   -5,
    0,    0,    0,    9,   19,   27,   -1,  -85,   29,  -79,
    0,    0,   89,  -97, -188, -188,    0,    0,    0,    0,
    0,  122,  122,  122,    0,    0,    0,    0,    0,  133,
  -88,    0,    0,    0,    0,   34,    0,    0,    0,    0,
    0,  -97,    0,    0,    0,    0,    0,    0,    0,    0,
    0,
};
short yyrindex[] = {                                      0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,  134,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,  -25,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,   90,    0,    0,    0,    0,    0,
    0,    0,    0,   78,    0,   53,   58,    0,    0,    0,
    0,  137,    0,    0,    0,    0,    0,   48,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,   28,    0,    0,
    0,    0,    0,  -44,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,  169,  175,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,  264,  185,  186,    0,    0,    0,    0,
    0,  197,  202,  208,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,  291,    0,    0,    0,    0,    0,    0,    0,    0,
    0,
};
short yygindex[] = {                                      0,
   39,    0,    0,   33,   64,  304,    0,  278,    0,    0,
    0,  110,   32,    1,    0,    0,    0,    0,   14,  -28,
    0,   41,    0,  240,  259,   20,  289,    0,    0,    0,
  174,  -89,  -86,  290,  331,    0,    0,  -99,
};
#define YYTABLESIZE 518
short yytable[] = {                                      59,
   36,   90,  203,   96,   44,   58,  193,   59,   95,  211,
  130,   51,   44,   58,   60,  151,   10,   51,   24,  175,
   60,    2,  188,  140,   59,  146,  190,   33,   60,   44,
  102,  217,  200,   19,   19,   44,  240,  107,   74,  206,
   32,   44,  226,  155,   47,   62,   46,   44,   79,   80,
  177,   33,  179,  180,   48,   44,   83,  101,   75,  186,
  166,  167,   44,  112,   20,   20,   70,   44,  113,   82,
   77,  120,  108,  134,  207,  208,  114,   11,   12,   13,
   53,  115,  116,  159,  160,  161,  162,  136,   46,   46,
   46,   46,   46,   42,   46,   42,   42,   42,   45,   24,
   45,   45,   45,   72,   19,  233,  234,   46,  120,   46,
  117,   71,   42,  119,   42,  108,  143,   45,   38,   45,
  168,   38,  169,  157,  158,  235,  236,  237,   76,  232,
   46,   46,   46,   24,   46,   20,   46,   38,   77,   38,
  164,  165,  180,   87,   49,    5,  149,  125,    6,  126,
   49,  171,  120,  131,    1,  132,  133,   81,  145,  189,
   92,   92,  216,   50,  170,  150,  173,  239,  201,   50,
  227,  202,   46,  228,  136,  136,  230,   42,  111,  231,
  110,   98,   45,  100,  109,  194,  101,  196,  198,  220,
  221,   99,  104,   84,   85,   86,  135,  148,  141,  144,
  195,  197,   38,  153,  154,  136,  136,  156,  172,  176,
  178,  181,  191,  209,   24,   54,   35,   89,   89,  212,
   94,  192,  129,   54,  210,  213,  214,   56,   55,   10,
   24,  174,  215,   56,  187,   57,   78,   41,   42,   43,
   54,   56,  218,   57,  199,   41,   42,   43,   11,   12,
   13,  205,  106,   78,  225,  219,    8,  238,    5,   78,
   57,    3,   41,   42,   43,   78,   57,  222,   41,   42,
   43,   78,   57,   38,   41,   42,   43,  223,   57,   78,
   41,   42,   43,  135,  135,  224,   39,  229,   41,   42,
   43,   78,  241,  132,   40,   41,   42,   43,   57,  128,
   41,   42,   43,   46,   21,   21,   46,  135,   42,  130,
  126,   42,  144,   45,  135,  135,   45,   46,   46,   46,
   46,  104,   42,   42,   42,   42,  102,   45,   45,   45,
   45,  142,  103,   38,  136,  105,   38,  152,  128,   97,
   21,   11,   12,   13,  142,  204,  103,   38,   38,   38,
   38,   73,    0,    0,   11,   12,   13,  121,  122,  123,
  124,    4,    5,    0,    0,    6,    7,    8,    9,    0,
   10,   11,   12,   13,   14,   21,  118,    4,    5,    0,
   15,    6,    7,    8,    0,    0,   10,   11,   12,   13,
   14,    0,    0,    0,    0,    0,  182,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,   21,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,   21,   21,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,   21,   21,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,   21,   21,   21,
};
short yycheck[] = {                                      40,
   40,   40,   40,  125,   45,   46,   41,   40,   44,   41,
   44,  123,   45,   46,   61,  125,   61,  123,   44,   44,
   61,  123,   44,   41,   40,  123,  123,  269,   61,   45,
   40,  125,   44,    1,    2,   45,  125,   41,  256,   44,
    2,   45,   44,   41,  269,   14,    6,   45,   35,   36,
  140,  269,  142,  143,  269,   45,   37,   46,   27,  146,
  258,  259,   45,   42,    1,    2,  256,   45,   47,   37,
   59,   44,   59,  262,  174,  175,   42,  266,  267,  268,
  281,   47,   69,  112,  113,  114,  115,   87,   41,   42,
   43,   44,   45,   41,   47,   43,   44,   45,   41,  125,
   43,   44,   45,   44,   72,  205,  206,   60,   77,   62,
   72,  125,   60,   73,   62,  102,   41,   60,   41,   62,
  256,   44,  258,  110,  111,  212,  213,  214,  125,   41,
   41,   42,   43,   44,   45,   72,   47,   60,   59,   62,
  127,  128,  232,  123,  256,  257,  256,   60,  260,   62,
  256,  132,  125,  256,  256,  258,  259,  269,  256,  256,
  283,  283,  256,  275,  132,  275,  135,  256,  256,  275,
  256,  259,  125,  259,  174,  175,  256,  125,   43,  259,
   45,  264,  125,   41,   41,  166,   46,  168,  169,  189,
  190,  269,  269,  278,  279,  280,   87,  125,   89,   90,
  168,  169,  125,   58,  269,  205,  206,   41,  269,  125,
  269,  269,   41,   41,  125,  256,  256,  256,  256,   44,
  256,  256,  256,  256,  256,   44,   44,  274,  269,  274,
  256,  256,  125,  274,  256,  276,  269,  278,  279,  280,
  256,  274,  125,  276,  256,  278,  279,  280,  266,  267,
  268,  256,  256,  269,  256,  125,  262,  125,  125,  269,
  276,  125,  278,  279,  280,  269,  276,  259,  278,  279,
  280,  269,  276,  256,  278,  279,  280,  259,  276,  269,
  278,  279,  280,  174,  175,  259,  269,  259,  278,  279,
  280,  269,  259,  125,  277,  278,  279,  280,  276,  125,
  278,  279,  280,  256,    1,    2,  259,   44,  256,  125,
  125,  259,  203,  256,  205,  206,  259,  270,  271,  272,
  273,  125,  270,  271,  272,  273,  125,  270,  271,  272,
  273,  256,  125,  256,   44,   58,  259,   98,   80,   51,
   37,  266,  267,  268,  256,  172,   57,  270,  271,  272,
  273,   21,   -1,   -1,  266,  267,  268,  270,  271,  272,
  273,  256,  257,   -1,   -1,  260,  261,  262,  263,   -1,
  265,  266,  267,  268,  269,   72,   73,  256,  257,   -1,
  275,  260,  261,  262,   -1,   -1,  265,  266,  267,  268,
  269,   -1,   -1,   -1,   -1,   -1,  275,   -1,   -1,   -1,
   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,
   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,
   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,
   -1,   -1,   -1,   -1,   -1,  132,   -1,   -1,   -1,   -1,
   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,  145,  146,
   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,
   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,
   -1,  168,  169,   -1,   -1,   -1,   -1,   -1,   -1,   -1,
   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,
   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,
   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,
   -1,   -1,   -1,   -1,   -1,  212,  213,  214,
};
#define YYFINAL 3
#ifndef YYDEBUG
#define YYDEBUG 0
#endif
#define YYMAXTOKEN 283
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
"PUNTOFLOTANTE","FOR","CTE","ListaSentencias",
};
char *yyrule[] = {
"$accept : Programa",
"Programa : '{' ListSentencias '}'",
"Programa : error ListSentencias '}'",
"ListSentencias : Sentencia ','",
"ListSentencias : Sentencia ',' ListSentencias",
"ListSentencias : Sentencia",
"Sentencia : SentenciaControl",
"Sentencia : SentenciaEjecutable",
"Sentencia : SentenciaDeclarativa",
"Sentencia : RETURN error",
"ReferenciaObjeto : ID '.' ID",
"ReferenciaObjetoFuncion : ID '.' LlamadoFuncion",
"SentenciaEjecutable : Asignacion",
"SentenciaEjecutable : LlamadoFuncion",
"SentenciaEjecutable : BloqueIF",
"SentenciaEjecutable : SalidaMensaje",
"SentenciaEjecutable : ReferenciaObjetoFuncion",
"SentenciaDeclarativa : Tipo ListVariables",
"SentenciaDeclarativa : Funcion",
"SentenciaDeclarativa : error ListVariables",
"SentenciaDeclarativa : Tipo error",
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
"Condicion : '(' Expresion Comparador Expresion error",
"Condicion : error Expresion Comparador Expresion ')'",
"BloqueIF : IF Condicion CuerpoIF ELSE CuerpoIF END_IF",
"BloqueIF : IF Condicion CuerpoIF END_IF",
"BloqueIF : IF Condicion CuerpoIF ELSE CuerpoIF error",
"BloqueIF : IF Condicion CuerpoIF error",
"BloqueIF : IF Condicion SentenciaEjecutable ',' ELSE CuerpoIF END_IF",
"BloqueIF : IF Condicion SentenciaEjecutable ',' ELSE SentenciaEjecutable ',' END_IF",
"BloqueIF : IF Condicion CuerpoIF ELSE SentenciaEjecutable ',' END_IF",
"BloqueIF : IF Condicion SentenciaEjecutable ',' ELSE CuerpoIF error",
"BloqueIF : IF Condicion SentenciaEjecutable ',' ELSE SentenciaEjecutable error",
"BloqueIF : IF Condicion CuerpoIF ELSE SentenciaEjecutable ',' error",
"BloqueIF : IF Condicion SentenciaEjecutable ',' error CuerpoIF END_IF",
"BloqueIF : IF Condicion SentenciaEjecutable ',' error SentenciaEjecutable END_IF",
"BloqueIF : IF Condicion SentenciaEjecutable error ELSE CuerpoIF END_IF",
"BloqueIF : IF Condicion CuerpoIF ELSE SentenciaEjecutable error END_IF",
"BloqueIF : IF Condicion SentenciaEjecutable error END_IF",
"CuerpoIF : '{' SentenciasIF '}'",
"CuerpoIF : RETURN ','",
"CuerpoIF : RETURN error",
"CuerpoIF : '{' SentenciasIF RETURN ',' '}'",
"CuerpoIF : '{' SentenciasIF RETURN error '}'",
"CuerpoIF : error SentenciasIF '}'",
"CuerpoIF : '{' SentenciasIF error",
"CuerpoIF : '{' '}'",
"SentenciasIF : ListaSentencias",
"ListaSentenciasIF : error",
"ListaSentenciasIF : SentenciaEjecutable ','",
"ListaSentenciasIF : SentenciaEjecutable error",
"ListaSentenciasIF : SentenciaEjecutable ',' ListaSentencias",
"ListaSentenciasIF : SentenciaEjecutable ',' error",
"ListaSentenciasIF : SentenciaEjecutable error ListaSentencias",
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
"Funcion : VOID ID error ')' CuerpoFuncion",
"Funcion : VOID ID '(' error CuerpoFuncion",
"Parametro : '(' Tipo ID ')'",
"Parametro : '(' Tipo ID error",
"Parametro : error Tipo ID ')'",
"CuerpoFuncion : '{' ListSentenciasFuncion '}'",
"CuerpoFuncion : error ListSentenciasFuncion '}'",
"CuerpoFuncion : '{' ListSentenciasFuncion error",
"ListSentenciasFuncion : SentenciaDeclarativa ',' ListSentenciasFuncion",
"ListSentenciasFuncion : SentenciaEjecutable ',' ListSentenciasFuncion",
"ListSentenciasFuncion : SentenciaEjecutable ','",
"ListSentenciasFuncion : SentenciaDeclarativa ','",
"ListSentenciasFuncion : RETURN ','",
"ListSentenciasFuncion : RETURN ',' ListSentenciasFuncion",
"LlamadoFuncion : ID '(' ')'",
"LlamadoFuncion : ID error ')'",
"LlamadoFuncion : ID '(' error",
"LlamadoFuncion : ID LlamadoExpresion",
"SalidaMensaje : PRINT CADENA",
"SalidaMensaje : PRINT Factor",
"SalidaMensaje : PRINT error",
"OperadorAsignacion : '='",
"OperadorAsignacion : ASIG",
"$$1 :",
"Asignacion : ID OperadorAsignacion Expresion $$1",
"Asignacion : ReferenciaObjeto OperadorAsignacion ReferenciaObjeto",
"Asignacion : ReferenciaObjeto OperadorAsignacion Factor",
"SentenciaControl : DO CuerpoIF UNTIL Condicion",
"SentenciaControl : DO CuerpoIF UNTIL",
"LlamadoExpresion : '(' Expresion ')'",
"LlamadoExpresion : Expresion ')'",
"ConversionExplicita : TOD LlamadoExpresion",
"ConversionExplicita : TOD '(' ')'",
"ListHerencia : '{' SentenciaListHerencia '}'",
"SentenciaListHerencia : Tipo ListVariables ','",
"SentenciaListHerencia : Tipo ListVariables ',' SentenciaListHerencia",
"SentenciaListHerencia : ListFuncion ','",
"SentenciaListHerencia : ListFuncion ',' SentenciaListHerencia",
"SentenciaListHerencia : Tipo ListVariables error",
"SentenciaListHerencia : Tipo ListVariables error SentenciaListHerencia",
"SentenciaListHerencia : ListFuncion error",
"SentenciaListHerencia : ListFuncion error SentenciaListHerencia",
"HerenciaComposicion : CLASS ID ListHerencia",
"FuncionSinCuerpo : VOID ID Parametro",
"FuncionSinCuerpo : VOID ID '(' ')'",
"FuncionIMPL : IMPL FOR ID ':' '{' Funcion '}'",
"FuncionIMPL : IMPL FOR ID ':' error Funcion '}'",
"FuncionIMPL : IMPL FOR ID ':' '{' Funcion error",
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
#line 346 "gramatica.y"
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
          try {
                Integer numero = Integer.parseInt(m);
          } catch (Exception e) {
                AnalizadorLexico.agregarErrorLexico("Entero negativo fuera de rango");
          }
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
             try {
                  Integer numero = Integer.parseInt(m);
             } catch (Exception e) {
                  AnalizadorLexico.agregarErrorLexico("Entero positivo fuera de rango");
             }
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
                try {
                     Integer numero = Integer.parseInt(m);
                } catch (Exception e) {
                     AnalizadorLexico.agregarErrorLexico("Entero positivo fuera de rango");
                }
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
           try {
                Double numero = Double.parseDouble(n);
           }
           } catch (Exception e) {
                AnalizadorLexico.agregarErrorLexico("Double fuera de rango");
           }
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
#line 586 "y.tab.c"
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
{raiz = new NodoControl("PROGRAMA",(Nodo)yyvsp[-1]); AnalizadorLexico.agregarEstructura("Reconoce programa ");}
break;
case 2:
#line 18 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se espera '{' ");}
break;
case 3:
#line 21 "gramatica.y"
{yyval=yyvsp[-1];}
break;
case 4:
#line 22 "gramatica.y"
{yyval = new NodoComun("Sentencia", (Nodo) yyvsp[-2], (Nodo) yyvsp[0]);}
break;
case 5:
#line 23 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba una ',' al final de la linea ");}
break;
case 6:
#line 27 "gramatica.y"
{yyval=yyvsp[0];}
break;
case 7:
#line 28 "gramatica.y"
{yyval=yyvsp[0];}
break;
case 8:
#line 29 "gramatica.y"
{yyval=yyvsp[0];}
break;
case 9:
#line 30 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("RETURN definido fuera de funcion ");}
break;
case 10:
#line 33 "gramatica.y"
{AnalizadorLexico.agregarEstructura("Reconoce referencia objeto ");}
break;
case 11:
#line 36 "gramatica.y"
{ yyval = new NodoComun("ReferenciaFuncionObjeto",(Nodo)yyvsp[-2],(Nodo)yyvsp[0]);
                                                AnalizadorLexico.agregarEstructura("Reconoce llamado a funcion de clase ");}
break;
case 14:
#line 42 "gramatica.y"
{yyval=yyvsp[0];}
break;
case 15:
#line 43 "gramatica.y"
{yyval=yyvsp[0];}
break;
case 16:
#line 44 "gramatica.y"
{yyval=yyvsp[0];}
break;
case 17:
#line 47 "gramatica.y"
{  while (((ListVariables)yyvsp[0]).getVariable() != null) { /*CHEQUAER SI UNA VARIABLE CON ESE LEXEMA YA TIENE SETEADO EL USO, SI LO TIENE SETEADO ES PORQ YA EXITE*/
                                                String var = ((ListVariables)yyvsp[0]).getVariable();
                                                Token t = TablaSimbolos.getToken(var);
                                                if (t != null){
                                                    t.setLexema(yyvsp[-1].sval + ":" + ambitoAct);
                                                    t.setAmbito(ambitoAct);
                                                    t.setUso("variable");
                                                    t.setTipo(yyvsp[-1].sval);
                                                    TablaSimbolos.removeToken(var);
                                                    TablaSimbolos.addSimbolo(t.getLexema(),t);
                                                    }
                                                else {
                                                   agregarErrorSemantico("Ya existe una variable + var + definida en este ambito");
                                                    }
                                            }
                                          }
break;
case 19:
#line 64 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se espera el tipo de la variable ");}
break;
case 20:
#line 65 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se espera identificador de la variable ");}
break;
case 24:
#line 71 "gramatica.y"
{ yyval = new ListVariables();
                    ((ListVariables)yyval).addVariable(yyvsp[0].sval);}
break;
case 25:
#line 73 "gramatica.y"
{yyval = yyvsp[0] ; ((ListVariables)yyval).addVariable(yyvsp[-2].sval);}
break;
case 30:
#line 84 "gramatica.y"
{yyval = new NodoHoja(yyvsp[0].sval) ; chequearEnteroPositivo(yyvsp[0].sval);}
break;
case 31:
#line 85 "gramatica.y"
{yyval = new NodoHoja(yyvsp[0].sval) ; chequearEnteroCorto(yyvsp[0].sval);}
break;
case 32:
#line 86 "gramatica.y"
{AnalizadorLexico.agregarErrorLexico("Un entero corto no puede ser negativo ");}
break;
case 33:
#line 87 "gramatica.y"
{yyval = new NodoHoja(yyvsp[0].sval) ; chequearDouble(yyvsp[0].sval);}
break;
case 34:
#line 88 "gramatica.y"
{yyval = new NodoHoja(yyvsp[-1].sval) ;chequearEnteroNegativo(yyvsp[0].sval);}
break;
case 35:
#line 89 "gramatica.y"
{yyval = new NodoHoja(yyvsp[-1].sval) ; chequearDouble(yyvsp[0].sval);}
break;
case 36:
#line 92 "gramatica.y"
{ yyval = new NodoComun("+",(Nodo)yyvsp[-2],(Nodo)yyvsp[0]);
                                    if (!(((Nodo)yyvsp[-2]).getTipo().equals(((Nodo)yyvsp[0]).getTipo()))){
                                        agregarErrorSemantico("No se puede realizar la suma. Tipos incompatibles.");/*hacer conversiones cuando sea posible*/
                                    }
                                    }
break;
case 37:
#line 97 "gramatica.y"
{yyval = new NodoComun("-",(Nodo)yyvsp[-2],(Nodo)yyvsp[0]);}
break;
case 38:
#line 98 "gramatica.y"
{yyval=yyvsp[0];}
break;
case 39:
#line 99 "gramatica.y"
{yyval = yyvsp[0];}
break;
case 40:
#line 103 "gramatica.y"
{/*
                                yyval = new NodoComun("*",(Nodo)val_peek(2), (Nodo)val_peek(0))
                                 if (!(((Nodo)val_peek(2)).getTipo().equals(((Nodo)val_peek(0)).getTipo())))
                                   if Not conversion valida
                                                                     agregarErrorSemantico("No se puede realizar la multiplicacion. Tipos incompatibles.");
                                                             else {
                                                                 ((Nodo)yyval).setTipo(((Nodo)val_peek(2)).getTipo());
                                                             } */
                            }
break;
case 42:
#line 113 "gramatica.y"
{yyval = yyvsp[0];}
break;
case 47:
#line 120 "gramatica.y"
{yyval=yyvsp[0];}
break;
case 48:
#line 123 "gramatica.y"
{yyval=yyvsp[0];}
break;
case 49:
#line 126 "gramatica.y"
{ yyval = new NodoComun(yyvsp[-2].sval,(Nodo)yyvsp[-3],(Nodo)yyvsp[-1]);
                                                    ((Nodo)yyval).setTipo(((Nodo)yyvsp[-3]).getTipo());
                                                    ((Nodo)yyval).setUso("Condicion");
                                                     if (!((((Nodo)yyvsp[-3]).getTipo()).equals(((Nodo)yyvsp[-1]).getTipo()))){
                                                         agregarErrorSemantico("Error en la comparacion entre expresiones de distintos tipos"); /*CHEQUEAR CONVERSIONES*/
                                                     }
                                                     }
break;
case 50:
#line 133 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba una ')' ");}
break;
case 51:
#line 134 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba una '(' ");}
break;
case 52:
#line 137 "gramatica.y"
{Nodo SentenciasIF = new NodoComun("SentenciasIF",new NodoControl("SentenciasIF",(Nodo)yyvsp[-3]), new NodoControl("SentenciasELSE",(Nodo)yyvsp[-1]));
                                                                      yyval= new NodoComun("BloqueIF", new NodoControl("Condicion",(Nodo)yyvsp[-4]), SentenciasIF);
                                                                      AnalizadorLexico.agregarEstructura("Reconoce IF ELSE ");}
break;
case 53:
#line 140 "gramatica.y"
{yyval= new NodoComun("BloqueIF", new NodoControl("Condicion",(Nodo)yyvsp[-2]), new NodoControl("SentenciasIF",(Nodo)yyvsp[-1]));
	                                            AnalizadorLexico.agregarEstructura("Reconoce IF ");}
break;
case 54:
#line 142 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba un END_IF al final del programa ");}
break;
case 55:
#line 143 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba un END_IF al final del programa ");}
break;
case 56:
#line 145 "gramatica.y"
{AnalizadorLexico.agregarEstructura("Reconoce IF ELSE");}
break;
case 57:
#line 146 "gramatica.y"
{AnalizadorLexico.agregarEstructura("Reconoce IF ELSE");}
break;
case 58:
#line 147 "gramatica.y"
{AnalizadorLexico.agregarEstructura("Reconoce IF ELSE");}
break;
case 59:
#line 148 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba un END_IF ");}
break;
case 60:
#line 149 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba un END_IF ");}
break;
case 61:
#line 150 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba un END_IF ");}
break;
case 62:
#line 151 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba un ELSE ");}
break;
case 63:
#line 152 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba un ELSE ");}
break;
case 64:
#line 154 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba una ',' ");}
break;
case 65:
#line 156 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba una ',' " );}
break;
case 66:
#line 158 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba una ',' ");}
break;
case 69:
#line 163 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Falta una ',' "); }
break;
case 71:
#line 165 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Falta una ',' "); }
break;
case 72:
#line 166 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Falta un '{'"); }
break;
case 73:
#line 167 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Falta un '}'"); }
break;
case 74:
#line 168 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("No hay sentencias dentro de las llaves."); }
break;
case 76:
#line 174 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Solo se aceptan sentencias ejecutables "); }
break;
case 78:
#line 176 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Falta una ','"); }
break;
case 80:
#line 178 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Solo se aceptan sentencias ejecutables "); }
break;
case 81:
#line 179 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Falta una ','"); }
break;
case 82:
#line 184 "gramatica.y"
{yyval=yyvsp[0];}
break;
case 83:
#line 185 "gramatica.y"
{yyval=yyvsp[0];}
break;
case 84:
#line 186 "gramatica.y"
{yyval=yyvsp[0];}
break;
case 85:
#line 187 "gramatica.y"
{yyval=yyvsp[0];}
break;
case 86:
#line 188 "gramatica.y"
{yyval=yyvsp[0];}
break;
case 87:
#line 189 "gramatica.y"
{yyval=yyvsp[0];}
break;
case 90:
#line 196 "gramatica.y"
{ String ambito = yyvsp[-2].sval;
                                            actualizarAmbito(ambitoAct, ambito);
                                            /*chequear si las variables pasadas por parametro estan en el ambito anterior*/

                                            yyval = new NodoComun("Funcion", new NodoControl("ParametroFuncion", (Nodo)yyvsp[-1]), new NodoControl("SentenciasFuncion",(Nodo)yyvsp[-1]));

                                            if (!TablaSimbolos.existeSimbolo(yyvsp[-2].sval+":"+ambitoAct)){
                                                ((Nodo)yyvsp[-2]).setLexema(yyvsp[-2].sval+":"+ambitoAct);
                                                ((Nodo)yyvsp[-2]).setUso("Funcion");
                                                TablaSimbolos.setAmbito(yyvsp[-2].sval+":"+ambitoAct, ambitoAct);
                                            }

                                            AnalizadorLexico.agregarEstructura("Reconoce funcion VOID ");}
break;
case 91:
#line 210 "gramatica.y"
{    String ambito = yyvsp[-3].sval;
                                            actualizarAmbito(ambitoAct, ambito);
                                            /*chequear si las variables pasadas por parametro estan en el ambito anterior*/

                                            yyval = new NodoComun("Funcion", new NodoControl("ParametroFuncion", (Nodo)yyvsp[-2]), new NodoControl("SentenciasFuncion",(Nodo)yyvsp[-2]));

                                            if (!TablaSimbolos.existeSimbolo(yyvsp[-3].sval+":"+ambitoAct)){
                                                ((Nodo)yyvsp[-3]).getToken().setLexema(yyvsp[-3].sval+":"+ambitoAct);
                                                ((Nodo)yyvsp[-3]).setUso("Funcion");
                                                TablaSimbolos.setAmbito(yyvsp[-3].sval+":"+ambitoAct, ambitoAct);
                                            }

                                            AnalizadorLexico.agregarEstructura("Reconoce funcion VOID ");}
break;
case 92:
#line 225 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba un '(' ");}
break;
case 93:
#line 226 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba un ')' ");}
break;
case 94:
#line 230 "gramatica.y"
{	yyval = new NodoHoja(yyvsp[-1].sval);

                           }
break;
case 95:
#line 233 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba un ')' ");}
break;
case 96:
#line 234 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba un '(' ");}
break;
case 98:
#line 238 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba un '{' ");}
break;
case 99:
#line 239 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba un '}' ");}
break;
case 106:
#line 253 "gramatica.y"
{AnalizadorLexico.agregarEstructura("Reconoce llamado funcion ");}
break;
case 107:
#line 254 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba un '(' ");}
break;
case 108:
#line 255 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba un ')' ");}
break;
case 109:
#line 256 "gramatica.y"
{AnalizadorLexico.agregarEstructura("Reconoce llamado funcion ");}
break;
case 110:
#line 258 "gramatica.y"
{yyval = new NodoControl("PRINT", new NodoHoja(yyvsp[0].sval));
                             AnalizadorLexico.agregarEstructura("Reconoce salida de mensaje por pantalla ");}
break;
case 111:
#line 260 "gramatica.y"
{yyval = new NodoControl("PRINT", new NodoHoja(yyvsp[0].sval));
                            AnalizadorLexico.agregarEstructura("Reconoce salida de mensaje por pantalla ");}
break;
case 112:
#line 262 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("La funcion PRINT no acepta esa declaracion ");}
break;
case 113:
#line 265 "gramatica.y"
{yyval=yyvsp[0];}
break;
case 114:
#line 266 "gramatica.y"
{yyval=yyvsp[0];}
break;
case 115:
#line 269 "gramatica.y"
{AnalizadorLexico.agregarEstructura("Reconoce asignacion ");}
break;
case 116:
#line 271 "gramatica.y"
{/*Chequear ambito de ID y chequear asignacion valida*/
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
break;
case 119:
#line 290 "gramatica.y"
{yyval=new NodoComun("Sentencia DO UNTIL", new NodoControl("ListSentenciasDO",(Nodo)yyvsp[-2]), new NodoControl("CondicionDO", (Nodo)yyvsp[0]));
                                                        AnalizadorLexico.agregarEstructura("Reconoce funcion DO UNTIL");}
break;
case 120:
#line 292 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba una condicion ");}
break;
case 121:
#line 297 "gramatica.y"
{}
break;
case 122:
#line 298 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba un '(' ");}
break;
case 123:
#line 301 "gramatica.y"
{ yyval = new NodoControl("TOD",(Nodo)yyvsp[0]);
                                            AnalizadorLexico.agregarEstructura("Reconoce funcion TOD ");
                                            }
break;
case 124:
#line 305 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba una Expresion ");}
break;
case 130:
#line 316 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba una ',' al final de la linea ");}
break;
case 131:
#line 317 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba una ',' al final de la linea ");}
break;
case 132:
#line 318 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba una ',' al final de la linea ");}
break;
case 133:
#line 319 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba una ',' al final de la linea ");}
break;
case 134:
#line 322 "gramatica.y"
{ String ambito = yyvsp[-1].sval;
                                                actualizarAmbito(ambitoAct, ambito);
                                                AnalizadorLexico.agregarEstructura("Reconoce CLASE");}
break;
case 135:
#line 328 "gramatica.y"
{AnalizadorLexico.agregarEstructura("Reconoce Funcion sin cuerpo");}
break;
case 136:
#line 329 "gramatica.y"
{AnalizadorLexico.agregarEstructura("Reconoce Funcion sin cuerpo");}
break;
case 137:
#line 334 "gramatica.y"
{AnalizadorLexico.agregarEstructura("Reconoce funcion IMPL");}
break;
case 138:
#line 335 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba un '{' ");}
break;
case 139:
#line 336 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba un '}' ");}
break;
#line 1218 "y.tab.c"
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
