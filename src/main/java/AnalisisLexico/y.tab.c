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
    5,    5,    5,   13,   13,   16,   12,   12,   12,   17,
   17,   17,   17,   17,   17,   18,   18,   18,   18,   19,
   19,   19,   19,   19,   19,   21,   21,   22,   23,   23,
   23,   10,   10,   25,   25,   25,   24,   24,   24,   24,
   24,   24,   26,   26,   26,   26,   14,   14,   14,   28,
   28,   28,   29,   30,   30,   30,   30,   30,   30,   30,
   30,    8,    8,    8,    8,    8,    8,   11,   11,   31,
   31,    9,    9,    9,    9,    9,    3,    3,   20,   20,
   20,   32,   32,   32,   32,   32,   32,   15,   15,   15,
   27,   27,   33,   33,   33,
};
short yylen[] = {                                         2,
    3,    2,    2,    1,    2,    3,    1,    1,    1,    1,
    3,    3,    1,    1,    1,    1,    1,    2,    1,    1,
    1,    1,    1,    1,    3,    2,    1,    1,    1,    1,
    1,    2,    1,    2,    2,    3,    3,    1,    1,    3,
    3,    1,    3,    3,    1,    1,    1,    1,    5,    4,
    4,   10,    6,    2,    3,    1,    1,    1,    1,    1,
    1,    1,    1,    1,    2,    2,    6,    7,    6,    4,
    3,    3,    1,    3,    3,    2,    2,    2,    3,    1,
    1,    3,    4,    2,    2,    3,    3,    2,    2,    1,
    1,    3,    3,    3,    2,    2,    6,    5,    4,    3,
    3,    3,    2,    3,    4,    2,    3,    5,    2,    4,
    4,    5,    7,    6,    6,
};
short yydefred[] = {                                      0,
    0,    0,    0,    0,    0,   28,   27,   29,    0,    0,
    0,    0,    0,    8,    9,   10,    0,   17,   14,   13,
   15,   16,    0,   20,   19,   22,   23,    0,    0,   30,
   31,   33,    0,    0,   48,   47,    0,    0,   39,    0,
    0,    0,   46,   88,   89,    0,    0,    0,    0,   91,
    0,    0,    0,   85,   90,   26,    0,    0,    0,    3,
    0,    0,    0,   18,    0,    0,    0,   34,   32,   35,
    0,   61,   62,   60,   59,   57,   58,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,   12,   25,   82,    0,   86,   92,    1,    6,   93,
   94,   11,  100,    0,  101,    0,    0,   37,   36,   40,
   41,   43,   44,    0,    0,    0,    0,    0,   66,    0,
   65,  110,    0,    0,    0,    0,    0,    0,    0,   83,
   99,    0,   51,    0,    0,    0,    0,  108,    0,  107,
  104,    0,    0,    0,    0,    0,   73,    0,   72,    0,
   55,    0,   49,    0,   53,    0,  111,    0,  105,    0,
    0,    0,    0,   69,   70,   67,   97,    0,  112,    0,
    0,   79,   68,   75,   74,    0,    0,  115,    0,  113,
   52,
};
short yydgoto[] = {                                      11,
   12,   13,   14,  154,  155,   35,   18,   19,   20,   21,
   22,   23,   24,   25,   26,   27,   36,   57,   38,   39,
   40,   41,   42,   78,  100,   91,   92,   97,  156,  157,
   58,   93,   94,
};
short yysindex[] = {                                    105,
   22,  -45, -239, -211,  -58,    0,    0,    0,  -38,  -54,
    0,  -37,   51,    0,    0,    0,  -57,    0,    0,    0,
    0,    0, -164,    0,    0,    0,    0,   76,   30,    0,
    0,    0,   14,  -20,    0,    0,  -50,   70,    0,   -9,
   -6,    5,    0,    0,    0, -114,  -22,  -59,   81,    0,
 -136, -164,   36,    0,    0,    0,  108,  -20,   35,    0,
  -54,   48,   96,    0,  -96,   42,  134,    0,    0,    0,
  -50,    0,    0,    0,    0,    0,    0,  -20,  -20,  -20,
   48,   48,   48,   48,  -59,  -84,  -81,  114, -164,  -36,
  161,  -36,  112,  186,   57,  -30,  124,  -26,  207,  138,
  -14,    0,    0,    0,  220,    0,    0,    0,    0,    0,
    0,    0,    0,  228,    0,  -20,  229,    0,    0,    0,
    0,    0,    0,  155,   29,   21,  160,  259,    0,  114,
    0,    0,  114,   88,   38,  263,  133,  -59,   49,    0,
    0,  278,    0,  -90,   69,  -31,  272,    0,  114,    0,
    0,  287,  133,  302,  307,  227,    0,  312,    0,  233,
    0,   22,    0,  236,    0,   72,    0, -106,    0,  133,
  235,  133,  133,    0,    0,    0,    0,  -59,    0,  102,
  244,    0,    0,    0,    0,  245,  250,    0,  118,    0,
    0,
};
short yyrindex[] = {                                      0,
    0,    0,    0,    0,    0,    0,    0,    0,   53,    0,
    0,  361,   32,    0,    0,    0,    0,    0,    0,    0,
    0,    0,   64,    0,    0,    0,    0,    1,    0,    0,
    0,    0,    0,    0,    0,    0,    0,   16,    0,    6,
   11,    0,    0,    0,    0,   74,    0,    0,   59,    0,
    0,    0,   79,    0,    0,    0,    0,   91,  378,    0,
   39,   94,   53,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,  339,
    0,  343,    0,    0,    0,    0,    0,    0,  264,    0,
  -56,    0,    0,    0,  132,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,  266,
    0,    0,  271,    0,    0,    0,    0,  273,    0,    0,
    0,   40,    0,    0,    0,    0,    0,    0,  279,    0,
    0,    0,    0,  280,  281,    0,    0,  -16,    0,    0,
    0,  143,    0,    0,    0,    0,    0,    0,    0,  282,
    0,  284,  285,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,  353,    0,    0,    0,
    0,
};
short yygindex[] = {                                      0,
   19,    0,    0,   89,  111,   24,    0,  352,    0,    0,
    0,  297,  136,  296,    0,    0,    0,  113,   99,    0,
   20,    0,  249,  341,  -48,   54,    0,  288,  -41,  -53,
  397,   37,    0,
};
#define YYTABLESIZE 476
short yytable[] = {                                      33,
   46,   53,   54,   55,   11,   42,   33,   51,   88,   76,
   45,   77,  167,   53,   54,   38,  180,   95,   33,   51,
   52,   45,   55,   17,   33,   53,   54,   71,   59,   46,
   33,    7,   81,   17,   55,   83,  124,   82,    5,   50,
   84,   46,   46,   46,   46,   46,   42,   46,   42,   42,
   42,   45,   24,   45,   45,   45,   38,   47,   24,   38,
   46,   34,   46,   21,   48,   42,   33,   42,  145,   66,
   45,   17,   45,  109,   33,   38,  104,   38,   84,  109,
   33,  111,  113,   50,   17,  110,   33,   60,   15,  161,
   95,  137,   33,   96,   61,  160,   24,  134,   15,   46,
   46,   46,   24,   46,   63,   46,   71,   21,   17,  166,
   16,  171,   80,   37,   79,  179,  182,  109,  184,  185,
   16,   65,   84,   46,  127,   46,   65,   85,   42,  186,
   42,   87,  101,   45,   95,   45,   99,   96,   38,   52,
   38,   67,   98,  129,   56,  131,   71,   86,  106,   15,
   87,    6,    7,    8,   52,    4,    7,   17,   64,  108,
   17,   17,   50,    5,   50,  105,  150,  164,  165,  151,
  107,   16,  112,   99,  115,   87,   17,   24,  114,  120,
  121,  122,  123,   24,  125,  169,   98,  103,   21,   17,
  117,  118,  119,   17,  153,   17,   17,    1,  109,  126,
    2,   17,    1,   84,  130,    2,    3,    4,    5,   98,
  153,    6,    7,    8,    9,   95,   50,   11,   96,   72,
   73,   74,   75,   43,  128,   86,   99,   10,  142,  133,
   49,   44,   30,   31,   32,   50,  132,   29,  136,   30,
   31,   32,   28,    6,    7,    8,  137,   50,   28,   29,
  138,   30,   31,   32,   28,   29,   87,   30,   31,   32,
  140,   29,  139,   30,   31,   32,   99,   98,  141,  143,
   46,   46,   46,   46,   37,   42,   42,   42,   42,  144,
   45,   45,   45,   45,  148,   38,   38,   38,   38,  147,
   28,   68,   69,   70,    6,    7,    8,   29,   28,   30,
   31,   32,  149,  159,   28,   29,  158,   30,   31,   32,
   28,   29,  162,   30,   31,   32,   28,   29,  163,   30,
   31,   32,    6,    7,    8,   30,   31,   32,    1,  168,
  170,    2,    3,    4,    6,    7,    8,    6,    7,    8,
    9,   90,   89,   96,    1,  172,  152,    2,    3,    4,
  173,  174,  175,    6,    7,    8,    9,  176,  178,  183,
    4,    1,  152,    4,    2,    3,    4,    5,  188,  189,
    6,    7,    8,    9,  190,   86,  191,    2,   87,    6,
    7,    8,   63,   90,   89,   90,   64,   90,   56,    1,
  106,  135,    2,    3,    4,  103,  114,   54,    6,    7,
    8,    9,  102,  102,   80,   81,   78,  152,   76,   77,
  177,  116,  146,   62,    0,    0,    0,    0,    0,    0,
    0,   96,    0,    0,    0,   90,   89,    0,   90,   89,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,  135,    0,    0,   90,   89,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,  181,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,  187,
};
short yycheck[] = {                                      45,
    0,   40,   41,   61,   61,    0,   45,   46,  123,   60,
    0,   62,   44,   40,   41,    0,  123,   40,   45,   46,
   59,    2,   61,    0,   45,   40,   41,   44,   10,  269,
   45,    0,   42,   10,   61,   42,   85,   47,    0,    0,
   47,   41,   42,   43,   44,   45,   41,   47,   43,   44,
   45,   41,    0,   43,   44,   45,   41,  269,    0,   44,
   60,   40,   62,    0,  123,   60,   45,   62,   40,   40,
   60,   48,   62,    0,   45,   60,   41,   62,    0,   61,
   45,   62,   41,   44,   61,   62,   45,  125,    0,  138,
    0,  123,   45,    0,   44,  137,   44,   41,   10,   41,
   42,   43,   44,   45,  269,   47,  123,   44,   85,   41,
    0,  153,   43,    1,   45,   44,  170,   44,  172,  173,
   10,   46,   44,  123,   88,  125,   46,  123,  123,  178,
  125,    0,  269,  123,   44,  125,   48,   44,  123,   59,
  125,   29,    0,   90,    9,   92,   34,  262,   41,   61,
  265,  266,  267,  268,   59,  262,  125,  134,   23,  125,
  137,  138,  123,  125,  125,   53,  130,  258,  259,  133,
   58,   61,  269,   85,   41,   44,  153,  125,   66,   81,
   82,   83,   84,  125,  269,  149,   44,   52,  125,  166,
   78,   79,   80,  170,  123,  172,  173,  257,  125,  281,
  260,  178,  257,  125,   44,  260,  261,  262,  263,  269,
  123,  266,  267,  268,  269,  125,  274,  274,  125,  270,
  271,  272,  273,  269,   89,  262,  138,  123,  116,   44,
  269,  277,  278,  279,  280,  274,  125,  276,  269,  278,
  279,  280,  269,  266,  267,  268,  123,  274,  269,  276,
   44,  278,  279,  280,  269,  276,  125,  278,  279,  280,
   41,  276,  125,  278,  279,  280,  178,  125,   41,   41,
  270,  271,  272,  273,  162,  270,  271,  272,  273,  125,
  270,  271,  272,  273,  125,  270,  271,  272,  273,  269,
  269,  278,  279,  280,  266,  267,  268,  276,  269,  278,
  279,  280,   44,   41,  269,  276,  269,  278,  279,  280,
  269,  276,  264,  278,  279,  280,  269,  276,   41,  278,
  279,  280,  266,  267,  268,  278,  279,  280,  257,   58,
   44,  260,  261,  262,  266,  267,  268,  266,  267,  268,
  269,   46,   46,   47,  257,   44,  275,  260,  261,  262,
   44,  125,   41,  266,  267,  268,  269,  125,  123,  125,
    0,  257,  275,  262,  260,  261,  262,  263,  125,  125,
  266,  267,  268,  269,  125,  262,  259,    0,  265,  266,
  267,  268,   44,   88,   88,   90,   44,   92,  125,  257,
  125,   95,  260,  261,  262,  125,   44,  125,  266,  267,
  268,  269,   51,  125,  125,  125,  125,  275,  125,  125,
  162,   71,  125,   17,   -1,   -1,   -1,   -1,   -1,   -1,
   -1,  125,   -1,   -1,   -1,  130,  130,   -1,  133,  133,
   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,
   -1,  145,   -1,   -1,  149,  149,   -1,   -1,   -1,   -1,
   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,
   -1,   -1,   -1,  168,   -1,   -1,   -1,   -1,   -1,   -1,
   -1,   -1,   -1,   -1,   -1,  180,
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
"SentenciaDeclarativa : Tipo ListVariables",
"SentenciaDeclarativa : Funcion",
"SentenciaDeclarativa : ListVariables",
"SentenciaDeclarativa : Tipo",
"SentenciaDeclarativa : HerenciaComposicion",
"SentenciaDeclarativa : Objeto_clase",
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
"BloqueIF : IF Condicion '{' ListSentenciasIF '}' ELSE '{' ListSentenciasIF '}' END_IF",
"BloqueIF : IF Condicion '{' ListSentenciasIF '}' END_IF",
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
"Funcion : VOID ID Parametro '{' CuerpoFuncion '}'",
"Funcion : VOID ID '(' ')' '{' CuerpoFuncion '}'",
"Funcion : VOID ID '(' ')' CuerpoFuncion '}'",
"Parametro : '(' Tipo ID ')'",
"Parametro : '(' Tipo ID",
"Parametro : Tipo ID ')'",
"CuerpoFuncion : ListSentenciasFuncion",
"ListSentenciasFuncion : SentenciaDeclarativa ',' ListSentenciasFuncion",
"ListSentenciasFuncion : SentenciaEjecutable ',' ListSentenciasFuncion",
"ListSentenciasFuncion : SentenciaEjecutable ','",
"ListSentenciasFuncion : SentenciaDeclarativa ','",
"ListSentenciasFuncion : RETURN ','",
"ListSentenciasFuncion : RETURN ',' ListSentenciasFuncion",
"ListSentenciasFuncion : SentenciaEjecutable",
"ListSentenciasFuncion : SentenciaDeclarativa",
"LlamadoFuncion : ID '(' ')'",
"LlamadoFuncion : ID '(' Expresion ')'",
"LlamadoFuncion : ID '('",
"LlamadoFuncion : ID ')'",
"LlamadoFuncion : ID Expresion ')'",
"LlamadoFuncion : ID '(' Expresion",
"SalidaMensaje : PRINT CADENA",
"SalidaMensaje : PRINT Factor",
"OperadorAsignacion : '='",
"OperadorAsignacion : ASIG",
"Asignacion : ID OperadorAsignacion Expresion",
"Asignacion : ReferenciaObjeto OperadorAsignacion ReferenciaObjeto",
"Asignacion : ReferenciaObjeto OperadorAsignacion Factor",
"Asignacion : ID OperadorAsignacion",
"Asignacion : ReferenciaObjeto OperadorAsignacion",
"SentenciaControl : DO '{' ListSentenciasIF '}' UNTIL Condicion",
"SentenciaControl : DO '{' ListSentenciasIF '}' UNTIL",
"ConversionExplicita : TOD '(' Expresion ')'",
"ConversionExplicita : TOD '(' ')'",
"ConversionExplicita : TOD Expresion ')'",
"ListHerencia : Tipo ListVariables ','",
"ListHerencia : FuncionIMPL ','",
"ListHerencia : FuncionIMPL ',' ListHerencia",
"ListHerencia : Tipo ListVariables ',' ListHerencia",
"ListHerencia : ListFuncion ','",
"ListHerencia : ListFuncion ',' ListHerencia",
"HerenciaComposicion : CLASS ID '{' ListHerencia '}'",
"HerenciaComposicion : CLASS ID",
"HerenciaComposicion : CLASS ID ListHerencia '}'",
"FuncionSinCuerpo : VOID ID Parametro ','",
"FuncionSinCuerpo : VOID ID '(' ')' ','",
"FuncionIMPL : IMPL FOR ID ':' '{' Funcion '}'",
"FuncionIMPL : IMPL FOR ID ':' '{' Funcion",
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
#line 210 "gramatica.y"

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
{AnalizadorLexico.agregarErrorSintactico("Se espera '}' en la linea ");}
break;
case 3:
#line 18 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se espera '{' en la linea ");}
break;
case 4:
#line 19 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperan '{' '}' en la linea ");}
break;
case 7:
#line 24 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba una ',' al final de la linea ");}
break;
case 20:
#line 47 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se espera el tipo de la variable en la linea ");}
break;
case 21:
#line 48 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se espera identificador de la variable en la linea ");}
break;
case 30:
#line 65 "gramatica.y"
{chequearEnteroPositivo(yyvsp[0].sval);}
break;
case 31:
#line 66 "gramatica.y"
{chequearEnteroCorto(yyvsp[0].sval);}
break;
case 32:
#line 67 "gramatica.y"
{AnalizadorLexico.agregarErrorLexico("Un entero corto no puede ser negativo en la linea ");}
break;
case 33:
#line 68 "gramatica.y"
{chequearDouble(yyvsp[0].sval);}
break;
case 34:
#line 69 "gramatica.y"
{chequearEnteroNegativo(yyvsp[0].sval);}
break;
case 35:
#line 70 "gramatica.y"
{chequearDouble(yyvsp[0].sval);}
break;
case 50:
#line 96 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba una ')' ");}
break;
case 51:
#line 97 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba una '(' ");}
break;
case 52:
#line 100 "gramatica.y"
{AnalizadorLexico.agregarEstructura("Reconoce ELSE IF ");}
break;
case 53:
#line 101 "gramatica.y"
{AnalizadorLexico.agregarEstructura("Reconoce IF ");}
break;
case 56:
#line 106 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba una ',' ");}
break;
case 67:
#line 123 "gramatica.y"
{AnalizadorLexico.agregarEstructura("Reconoce funcion VOID ");}
break;
case 68:
#line 124 "gramatica.y"
{AnalizadorLexico.agregarEstructura("Reconoce funcion VOID ");}
break;
case 69:
#line 125 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba un '{' ");}
break;
case 71:
#line 130 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba un ')' ");}
break;
case 72:
#line 131 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba un '(' ");}
break;
case 80:
#line 143 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba una ',' al final de la linea ");}
break;
case 81:
#line 144 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba una ',' al final de la linea ");}
break;
case 82:
#line 147 "gramatica.y"
{AnalizadorLexico.agregarEstructura("Reconoce llamado funcion ");}
break;
case 83:
#line 148 "gramatica.y"
{AnalizadorLexico.agregarEstructura("Reconoce llamado funcion ");}
break;
case 84:
#line 149 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba una ')' ");}
break;
case 85:
#line 150 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba una '(' ");}
break;
case 86:
#line 151 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba una '(' ");}
break;
case 87:
#line 152 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba una ')' ");}
break;
case 88:
#line 155 "gramatica.y"
{AnalizadorLexico.agregarEstructura("Reconoce salida de mensaje por pantalla ");}
break;
case 89:
#line 156 "gramatica.y"
{AnalizadorLexico.agregarEstructura("Reconoce salida de mensaje por pantalla ");}
break;
case 95:
#line 166 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba un operando de lado derecho de la asignación ");}
break;
case 96:
#line 167 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba un operando de lado derecho de la asignación ");}
break;
case 97:
#line 170 "gramatica.y"
{AnalizadorLexico.agregarEstructura("Reconoce funcion DO UNTIL");}
break;
case 98:
#line 171 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba una condicion ");}
break;
case 99:
#line 176 "gramatica.y"
{AnalizadorLexico.agregarEstructura("Reconoce funcion TOD ");}
break;
case 100:
#line 177 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba una Expresion ");}
break;
case 101:
#line 178 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba un '(' ");}
break;
case 108:
#line 189 "gramatica.y"
{AnalizadorLexico.agregarEstructura("Reconoce CLASE");}
break;
case 110:
#line 191 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba un '{' ");}
break;
case 111:
#line 194 "gramatica.y"
{AnalizadorLexico.agregarEstructura("Reconoce Funcion sin cuerpo");}
break;
case 112:
#line 195 "gramatica.y"
{AnalizadorLexico.agregarEstructura("Reconoce Funcion sin cuerpo");}
break;
case 113:
#line 198 "gramatica.y"
{AnalizadorLexico.agregarEstructura("Reconoce funcion IMPL");}
break;
case 114:
#line 199 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba un '}' ");}
break;
case 115:
#line 200 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba un '{' ");}
break;
#line 815 "y.tab.c"
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
