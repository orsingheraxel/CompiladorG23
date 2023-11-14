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
    0,    0,    1,    1,    1,    2,    2,    2,    2,    6,
    7,    4,    4,    4,    4,    4,    5,    5,    5,    5,
    5,    5,    5,   13,   13,   16,   12,   12,   12,   18,
   18,   18,   18,   18,   18,   19,   19,   19,   19,   20,
   20,   20,   20,   20,   20,   22,   22,   23,   24,   24,
   24,   10,   10,   10,   10,   10,   10,   10,   10,   10,
   10,   10,   10,   10,   10,   10,   26,   26,   26,   26,
   26,   26,   26,   26,   27,   28,   28,   28,   28,   25,
   25,   25,   25,   25,   25,   29,   29,   14,   14,   31,
   31,   31,   31,   31,   31,   32,   32,   32,   33,   33,
   33,   33,   33,   33,   33,   33,   33,    8,    8,    8,
    8,   11,   11,   11,   35,   35,   36,    9,    9,    9,
    3,    3,   34,   34,   21,   21,   37,   38,   38,   38,
   38,   38,   38,   38,   38,   15,   30,   17,   17,   17,
};
short yylen[] = {                                         2,
    3,    3,    2,    3,    2,    1,    1,    1,    2,    3,
    3,    1,    1,    1,    1,    1,    2,    1,    2,    2,
    1,    1,    1,    1,    3,    2,    1,    1,    1,    1,
    1,    2,    1,    2,    2,    3,    3,    1,    1,    3,
    3,    1,    3,    3,    1,    1,    1,    1,    5,    5,
    5,    6,    4,    6,    4,    7,    8,    7,    7,    7,
    7,    7,    7,    7,    7,    5,    3,    2,    2,    5,
    5,    3,    3,    2,    1,    1,    2,    2,    3,    1,
    1,    1,    1,    1,    1,    1,    1,    5,    4,    4,
    4,    4,    2,    2,    2,    3,    3,    3,    3,    3,
    2,    2,    2,    3,    2,    2,    2,    3,    3,    3,
    2,    2,    2,    2,    1,    1,    0,    4,    3,    3,
    4,    4,    3,    2,    2,    3,    3,    3,    4,    2,
    3,    3,    4,    2,    3,    3,    3,    7,    7,    7,
};
short yydefred[] = {                                      0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
   28,   27,   29,    0,    0,    0,    0,    6,    7,    8,
    0,   16,   13,   12,   14,   15,    0,   18,   21,   22,
   23,    0,   24,    0,    0,    0,    0,  114,   46,  112,
   30,   31,   33,    0,   47,  113,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,  116,    0,    0,    0,
  115,   48,    0,    0,    0,   39,   42,   45,  111,    0,
    9,    2,    0,    5,    3,    0,   20,    0,    1,    0,
    0,    0,    0,    0,    0,    0,   34,   32,   35,    0,
  136,    0,    0,    0,    0,   76,    0,    0,    0,   69,
   68,   74,    0,    0,    0,  109,    0,    0,  125,    0,
   11,  110,  108,    0,    0,    0,  124,    0,    0,    0,
    4,  119,  120,   25,   84,   85,   83,   82,   80,   81,
    0,    0,    0,    0,   55,    0,   53,    0,    0,   86,
    0,   87,    0,   95,    0,   94,   93,    0,    0,    0,
   89,    0,   78,   77,   72,    0,   73,    0,   67,    0,
  121,    0,   10,  126,  123,    0,    0,   40,   43,   41,
   44,  118,    0,    0,    0,   66,    0,    0,    0,    0,
    0,    0,  134,  130,    0,  127,    0,    0,    0,    0,
    0,    0,    0,    0,   88,   79,    0,    0,    0,    0,
   51,   50,   49,    0,    0,    0,    0,    0,    0,    0,
   54,   52,    0,  132,  128,    0,  135,    0,  131,   92,
   91,   90,  107,  103,  105,  101,  106,  102,   97,    0,
   98,   96,   71,   70,    0,    0,   64,   63,   62,   60,
    0,   59,   56,   65,   61,   58,    0,    0,  104,  100,
   99,  139,  140,  138,   57,
};
short yydgoto[] = {                                       3,
   16,   17,   18,   19,   20,   62,   22,   23,   24,   25,
   26,   27,   34,   28,   29,   30,   31,   45,   64,   65,
   66,   67,   68,   37,  131,   53,   98,   99,  141,  142,
   94,  151,  193,   69,   70,  172,   91,  143,
};
short yysindex[] = {                                    -96,
  115,  115,    0, -208,  -37,   18, -185, -216, -100, -203,
    0,    0,    0,  -40, -162,  -18,   -1,    0,    0,    0,
  -52,    0,    0,    0,    0,    0, -207,    0,    0,    0,
    0,   37,    0,   43,   23,   23, -111,    0,    0,    0,
    0,    0,    0, -233,    0,    0,  -14,  -36,  -36,  184,
   59,  -71, -151, -125,  136,  141,    0,   -9,  -75,   -3,
    0,    0,   43,  109,   64,    0,    0,    0,    0,   23,
    0,    0,  115,    0,    0,   11,    0,   43,    0,  -56,
  141,  -21,  -21,  -32,   60,  137,    0,    0,    0,  -63,
    0,   97,   93,  -91,   98,    0,   61,  110,  199,    0,
    0,    0, -114,  -33,  198,    0,  -10,    3,    0,  -15,
    0,    0,    0,  166,   11,   11,    0,   11,   11,   12,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
   23,   23,  -57, -191,    0, -111,    0, -205, -208,    0,
   68,    0,  -28,    0,   16,    0,    0,   36,  142,  142,
    0,  -91,    0,    0,    0, -121,    0,   77,    0,   23,
    0,  -89,    0,    0,    0,   64,   64,    0,    0,    0,
    0,    0,  167,  -26, -100,    0, -111, -111,   79,  -80,
  -36,  -24,    0,    0,  -63,    0,  -63,  227,  -31,   83,
   85,   86,   41,  -11,    0,    0,  197,  211,   76,   76,
    0,    0,    0,   84,  103,  114,   88,  -68,  120,  -41,
    0,    0,   98,    0,    0, -208,    0, -208,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,  162,
    0,    0,    0,    0,  244,  -88,    0,    0,    0,    0,
  126,    0,    0,    0,    0,    0,   43,   43,    0,    0,
    0,    0,    0,    0,    0,
};
short yyrindex[] = {                                      0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    6,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,   28,    0,    0,    0,    0,
    0,    0,   22,    0,   55,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,   30,    0,    0,
   48,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,  -97,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,  -43,
    0,    0,    0,    0,    0,    0,    0,    0,    0,  -42,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,   32,
    0,    0,    0,    0,    0,   75,   81,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,   38,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,   44,   57,    0,    0,
    0,    0,    0,    0,    0,
};
short yygindex[] = {                                      0,
  372,  314,    0,  318,  -90,  256,    0,  330,    0,    0,
    0,  -13,  170,   -4,    0,    0,    0,    0,  331,  111,
    0,   52,  239,  290,  317,   15,  345,    0,  125,    0,
  -48,  261,  264,  357,  395,    0,    0,    0,
};
#define YYTABLESIZE 548
short yytable[] = {                                      60,
   95,  117,   36,   93,   44,   59,   36,   60,   61,  222,
  159,   52,   44,   59,  203,  187,  116,   10,  115,  215,
   61,  116,   52,  115,   60,   73,    2,   75,   61,   44,
  108,  150,  230,  200,   80,   44,  254,  113,  129,   48,
  130,   44,   75,  164,   87,   88,   89,   44,   77,   19,
   48,   86,   49,  102,  116,   44,  115,   46,  192,  192,
   33,   33,   44,  181,  177,   26,  178,   44,   46,   46,
   46,   24,   46,   17,   46,  122,  139,   54,  145,  148,
   73,  137,  117,   47,  230,  140,   24,  133,   46,   46,
   46,   46,   46,   71,   46,   38,  186,   38,   38,   38,
  129,   80,  101,  134,  154,  118,   72,   46,   90,   46,
  119,  184,  104,  232,   38,   37,   38,   37,   37,   37,
  198,   36,  210,   36,   36,   36,  224,  123,  226,  228,
   19,  241,  213,  147,   37,    5,   37,  144,    6,  251,
   36,  157,   36,  105,   50,    5,   26,   84,    6,  117,
  180,  116,   24,  115,   17,   50,  122,   84,   75,    1,
  158,   79,  137,   51,  149,  229,  199,  253,  133,  168,
  170,  216,   46,  218,   51,  211,  106,   75,  212,   38,
  140,  129,  140,   63,   96,    5,  107,  242,    6,  204,
  243,  206,  208,  110,  235,  236,   78,   84,  138,   37,
  175,  176,   11,   12,   13,   36,  165,  201,  116,  116,
  115,  115,  124,  117,  245,   55,  117,  246,   35,   92,
  152,   57,  160,   55,  221,  166,  167,  185,   56,  202,
   10,  214,  117,   57,  155,   58,   81,   41,   42,   43,
   55,   57,  156,   58,  231,   41,   42,   43,  125,  126,
  127,  128,  112,   81,   74,  162,   21,   21,  163,   81,
   58,   19,   41,   42,   43,   81,   58,  220,   41,   42,
   43,   81,   58,   38,   41,   42,   43,   26,   58,   81,
   41,   42,   43,   24,  188,   17,   39,  122,   41,   42,
   43,   81,   21,  137,   40,   41,   42,   43,   58,  133,
   41,   42,   43,   46,  189,   21,   46,   21,  182,  217,
   38,  219,  129,   38,  100,  133,  153,   46,   46,   46,
   46,  233,   46,  183,   38,   38,   38,   38,   21,   38,
   37,  122,  197,   37,  209,  234,   36,    8,  223,   36,
  225,  227,  237,  240,   37,   37,   37,   37,  146,   37,
   36,   36,   36,   36,   85,   36,  169,  171,   11,   12,
   13,  238,   11,   12,   13,   82,   83,   97,  252,   97,
    4,    5,  239,   32,    6,    7,    8,    9,  244,   10,
   11,   12,   13,   14,  255,  247,  121,  248,  111,   15,
  114,   21,  135,  161,  136,  137,  103,    4,    5,  132,
  120,    6,    7,    8,   21,   21,   10,   11,   12,   13,
   14,   21,  195,  194,  109,   76,  190,    4,    5,    0,
    0,    6,    7,    8,    0,    0,   10,   11,   12,   13,
   14,    0,   21,   21,    0,    0,  249,    0,  114,   96,
    5,    0,    0,    6,    0,    0,    0,    0,    0,    0,
    0,    0,   84,  179,    0,    0,    0,    0,    0,    0,
    0,  173,  174,    0,    0,    0,  191,  191,    0,    0,
    0,    0,    0,  196,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,   21,    0,    0,    0,    0,
   82,    0,    0,    0,  205,  207,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,  250,
};
short yycheck[] = {                                      40,
   49,   44,   40,   40,   45,   46,   40,   40,   61,   41,
  125,  123,   45,   46,   41,   44,   43,   61,   45,   44,
   61,   43,  123,   45,   40,   44,  123,  125,   61,   45,
   40,  123,   44,  123,   59,   45,  125,   41,   60,  256,
   62,   45,   44,   41,  278,  279,  280,   45,  256,   44,
  256,   37,  269,  125,   43,   45,   45,    6,  149,  150,
  269,  269,   45,  269,  256,   44,  258,   45,   41,   42,
   43,   44,   45,   44,   47,   44,   90,  281,   92,   93,
   44,   44,  125,  269,   44,   90,   59,   44,   41,   42,
   43,   44,   45,  256,   47,   41,  125,   43,   44,   45,
   44,   59,   44,   44,   44,   42,  125,   60,  123,   62,
   47,   44,  264,  125,   60,   41,   62,   43,   44,   45,
   44,   41,   44,   43,   44,   45,   44,   76,   44,   44,
  125,   44,  181,   41,   60,  257,   62,   41,  260,  230,
   60,  256,   62,  269,  256,  257,  125,  269,  260,   41,
  136,   43,  125,   45,  125,  256,  125,  269,  256,  256,
  275,  125,  125,  275,  256,  125,  256,  256,  125,  118,
  119,  185,  125,  187,  275,  256,   41,  275,  259,  125,
  185,  125,  187,   14,  256,  257,   46,  256,  260,  175,
  259,  177,  178,  269,  199,  200,   27,  269,  262,  125,
  258,  259,  266,  267,  268,  125,   41,   41,   43,   43,
   45,   45,  269,  256,  256,  256,  259,  259,  256,  256,
  123,  274,  256,  256,  256,  115,  116,  256,  269,  256,
  274,  256,  275,  274,  125,  276,  269,  278,  279,  280,
  256,  274,   44,  276,  256,  278,  279,  280,  270,  271,
  272,  273,  256,  269,  256,   58,    1,    2,  269,  269,
  276,  256,  278,  279,  280,  269,  276,   41,  278,  279,
  280,  269,  276,  256,  278,  279,  280,  256,  276,  269,
  278,  279,  280,  256,  269,  256,  269,  256,  278,  279,
  280,  269,   37,  256,  277,  278,  279,  280,  276,  256,
  278,  279,  280,  256,  269,   50,  259,   52,  139,  185,
  256,  187,  256,  259,  256,  256,  256,  270,  271,  272,
  273,  125,  275,  256,  270,  271,  272,  273,   73,  275,
  256,   76,  256,  259,  256,  125,  256,  262,  256,  259,
  256,  256,  259,  256,  270,  271,  272,  273,  256,  275,
  270,  271,  272,  273,   37,  275,  118,  119,  266,  267,
  268,  259,  266,  267,  268,   35,   36,   50,  125,   52,
  256,  257,  259,    2,  260,  261,  262,  263,  259,  265,
  266,  267,  268,  269,  259,  216,   73,  218,   59,  275,
   60,  136,  256,  104,  258,  259,   52,  256,  257,   83,
   70,  260,  261,  262,  149,  150,  265,  266,  267,  268,
  269,  156,  152,  150,   58,   21,  275,  256,  257,   -1,
   -1,  260,  261,  262,   -1,   -1,  265,  266,  267,  268,
  269,   -1,  177,  178,   -1,   -1,  275,   -1,  108,  256,
  257,   -1,   -1,  260,   -1,   -1,   -1,   -1,   -1,   -1,
   -1,   -1,  269,  136,   -1,   -1,   -1,   -1,   -1,   -1,
   -1,  131,  132,   -1,   -1,   -1,  149,  150,   -1,   -1,
   -1,   -1,   -1,  156,   -1,   -1,   -1,   -1,   -1,   -1,
   -1,   -1,   -1,   -1,   -1,  230,   -1,   -1,   -1,   -1,
  160,   -1,   -1,   -1,  177,  178,   -1,   -1,   -1,   -1,
   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,
   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,
   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,
   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,
   -1,   -1,   -1,   -1,   -1,   -1,   -1,  230,
};
#define YYFINAL 3
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
"Programa : error ListSentencias '}'",
"ListSentencias : Sentencia ','",
"ListSentencias : ListSentencias ',' Sentencia",
"ListSentencias : Sentencia error",
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
"ListVariables : ListVariables ';' ID",
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
"Expresion : Expresion '+' Termino",
"Expresion : Expresion '-' Termino",
"Expresion : Termino",
"Expresion : ConversionExplicita",
"Termino : Termino '*' Factor",
"Termino : Termino '/' Factor",
"Termino : Factor",
"Termino : Termino '*' Factor_RefObjeto",
"Termino : Termino '/' Factor_RefObjeto",
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
"SentenciasIF : ListaSentenciasIF",
"ListaSentenciasIF : error",
"ListaSentenciasIF : SentenciaEjecutable ','",
"ListaSentenciasIF : SentenciaEjecutable error",
"ListaSentenciasIF : ListaSentenciasIF ',' SentenciaEjecutable",
"Comparador : '<'",
"Comparador : '>'",
"Comparador : MAYORIGUAL",
"Comparador : MENORIGUAL",
"Comparador : IGUAL",
"Comparador : DIST",
"ListFuncion : Funcion",
"ListFuncion : FuncionSinCuerpo",
"Funcion : VOID ID Parametro '{' CuerpoFuncion",
"Funcion : VOID error Parametro CuerpoFuncion",
"Parametro : '(' Tipo ID ')'",
"Parametro : '(' Tipo ID error",
"Parametro : error Tipo ID ')'",
"Parametro : '(' ')'",
"Parametro : '(' error",
"Parametro : error ')'",
"CuerpoFuncion : '{' ListSentenciasFuncion '}'",
"CuerpoFuncion : error ListSentenciasFuncion '}'",
"CuerpoFuncion : '{' ListSentenciasFuncion error",
"ListSentenciasFuncion : ListSentenciasFuncion ',' SentenciaDeclarativa",
"ListSentenciasFuncion : ListSentenciasFuncion ',' SentenciaEjecutable",
"ListSentenciasFuncion : SentenciaEjecutable ','",
"ListSentenciasFuncion : SentenciaDeclarativa ','",
"ListSentenciasFuncion : RETURN ','",
"ListSentenciasFuncion : ListSentenciasFuncion ',' RETURN",
"ListSentenciasFuncion : SentenciaEjecutable error",
"ListSentenciasFuncion : SentenciaDeclarativa error",
"ListSentenciasFuncion : RETURN error",
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
"SentenciaControl : DO CuerpoIF UNTIL error",
"LlamadoExpresion : '(' Expresion ')'",
"LlamadoExpresion : Expresion ')'",
"ConversionExplicita : TOD LlamadoExpresion",
"ConversionExplicita : TOD '(' ')'",
"ListHerencia : '{' SentenciaListHerencia '}'",
"SentenciaListHerencia : Tipo ListVariables ','",
"SentenciaListHerencia : SentenciaListHerencia ',' Tipo ListVariables",
"SentenciaListHerencia : ListFuncion ','",
"SentenciaListHerencia : SentenciaListHerencia ',' ListFuncion",
"SentenciaListHerencia : Tipo ListVariables error",
"SentenciaListHerencia : SentenciaListHerencia error Tipo ListVariables",
"SentenciaListHerencia : ListFuncion error",
"SentenciaListHerencia : SentenciaListHerencia error ListFuncion",
"HerenciaComposicion : CLASS ID ListHerencia",
"FuncionSinCuerpo : VOID ID Parametro",
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
#line 328 "gramatica.y"
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
#line 595 "y.tab.c"
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
#line 26 "gramatica.y"
{yyval=yyvsp[0];}
break;
case 7:
#line 27 "gramatica.y"
{yyval=yyvsp[0];}
break;
case 8:
#line 28 "gramatica.y"
{yyval=yyvsp[0];}
break;
case 9:
#line 29 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("RETURN definido fuera de funcion ");}
break;
case 10:
#line 32 "gramatica.y"
{AnalizadorLexico.agregarEstructura("Reconoce referencia objeto ");}
break;
case 11:
#line 35 "gramatica.y"
{ yyval = new NodoComun("ReferenciaFuncionObjeto",(Nodo)yyvsp[-2],(Nodo)yyvsp[0]);
                                                AnalizadorLexico.agregarEstructura("Reconoce llamado a funcion de clase ");}
break;
case 14:
#line 41 "gramatica.y"
{yyval=yyvsp[0];}
break;
case 15:
#line 42 "gramatica.y"
{yyval=yyvsp[0];}
break;
case 16:
#line 43 "gramatica.y"
{yyval=yyvsp[0];}
break;
case 17:
#line 46 "gramatica.y"
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
#line 63 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se espera el tipo de la variable ");}
break;
case 20:
#line 64 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se espera identificador de la variable ");}
break;
case 24:
#line 70 "gramatica.y"
{ yyval = new ListVariables();
                    ((ListVariables)yyval).addVariable(yyvsp[0].sval);}
break;
case 25:
#line 72 "gramatica.y"
{yyval = yyvsp[0] ; ((ListVariables)yyval).addVariable(yyvsp[0].sval);}
break;
case 30:
#line 83 "gramatica.y"
{yyval = new NodoHoja(yyvsp[0].sval) ; chequearEnteroPositivo(yyvsp[0].sval);}
break;
case 31:
#line 84 "gramatica.y"
{yyval = new NodoHoja(yyvsp[0].sval) ; chequearEnteroCorto(yyvsp[0].sval);}
break;
case 32:
#line 85 "gramatica.y"
{AnalizadorLexico.agregarErrorLexico("Un entero corto no puede ser negativo ");}
break;
case 33:
#line 86 "gramatica.y"
{yyval = new NodoHoja(yyvsp[0].sval) ; chequearDouble(yyvsp[0].sval);}
break;
case 34:
#line 87 "gramatica.y"
{yyval = new NodoHoja(yyvsp[-1].sval) ;chequearEnteroNegativo(yyvsp[0].sval);}
break;
case 35:
#line 88 "gramatica.y"
{yyval = new NodoHoja(yyvsp[-1].sval) ; chequearDouble(yyvsp[0].sval);}
break;
case 36:
#line 91 "gramatica.y"
{ yyval = new NodoComun("+",(Nodo)yyvsp[-2],(Nodo)yyvsp[0]);
                                    if (!(((Nodo)yyvsp[-2]).getTipo().equals(((Nodo)yyvsp[0]).getTipo()))){
                                        agregarErrorSemantico("No se puede realizar la suma. Tipos incompatibles.");/*hacer conversiones cuando sea posible*/
                                    }
                                    }
break;
case 37:
#line 96 "gramatica.y"
{yyval = new NodoComun("-",(Nodo)yyvsp[-2],(Nodo)yyvsp[0]);}
break;
case 38:
#line 97 "gramatica.y"
{yyval=yyvsp[0];}
break;
case 39:
#line 98 "gramatica.y"
{yyval = yyvsp[0];}
break;
case 40:
#line 102 "gramatica.y"
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
#line 112 "gramatica.y"
{yyval = yyvsp[0];}
break;
case 47:
#line 119 "gramatica.y"
{yyval=yyvsp[0];}
break;
case 48:
#line 122 "gramatica.y"
{yyval=yyvsp[0];}
break;
case 49:
#line 125 "gramatica.y"
{ yyval = new NodoComun(yyvsp[-2].sval,(Nodo)yyvsp[-3],(Nodo)yyvsp[-1]);
                                                    ((Nodo)yyval).setTipo(((Nodo)yyvsp[-3]).getTipo());
                                                    ((Nodo)yyval).setUso("Condicion");
                                                     if (!((((Nodo)yyvsp[-3]).getTipo()).equals(((Nodo)yyvsp[-1]).getTipo()))){
                                                         agregarErrorSemantico("Error en la comparacion entre expresiones de distintos tipos"); /*CHEQUEAR CONVERSIONES*/
                                                     }
                                                     }
break;
case 50:
#line 132 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba una ')' ");}
break;
case 51:
#line 133 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba una '(' ");}
break;
case 52:
#line 136 "gramatica.y"
{Nodo SentenciasIF = new NodoComun("SentenciasIF",new NodoControl("SentenciasIF",(Nodo)yyvsp[-3]), new NodoControl("SentenciasELSE",(Nodo)yyvsp[-1]));
                                                                      yyval= new NodoComun("BloqueIF", new NodoControl("Condicion",(Nodo)yyvsp[-4]), SentenciasIF);
                                                                      AnalizadorLexico.agregarEstructura("Reconoce IF ELSE ");}
break;
case 53:
#line 139 "gramatica.y"
{yyval= new NodoComun("BloqueIF", new NodoControl("Condicion",(Nodo)yyvsp[-2]), new NodoControl("SentenciasIF",(Nodo)yyvsp[-1]));
	                                            AnalizadorLexico.agregarEstructura("Reconoce IF ");}
break;
case 54:
#line 141 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba un END_IF al final del programa ");}
break;
case 55:
#line 142 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba un END_IF al final del programa ");}
break;
case 56:
#line 144 "gramatica.y"
{AnalizadorLexico.agregarEstructura("Reconoce IF ELSE");}
break;
case 57:
#line 145 "gramatica.y"
{AnalizadorLexico.agregarEstructura("Reconoce IF ELSE");}
break;
case 58:
#line 146 "gramatica.y"
{AnalizadorLexico.agregarEstructura("Reconoce IF ELSE");}
break;
case 59:
#line 147 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba un END_IF ");}
break;
case 60:
#line 148 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba un END_IF ");}
break;
case 61:
#line 149 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba un END_IF ");}
break;
case 62:
#line 150 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba un ELSE ");}
break;
case 63:
#line 151 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba un ELSE ");}
break;
case 64:
#line 153 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba una ',' ");}
break;
case 65:
#line 155 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba una ',' " );}
break;
case 66:
#line 157 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba una ',' ");}
break;
case 69:
#line 162 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Falta una ',' "); }
break;
case 71:
#line 164 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Falta una ',' "); }
break;
case 72:
#line 165 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Falta un '{'"); }
break;
case 73:
#line 166 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Falta un '}'"); }
break;
case 74:
#line 167 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("No hay sentencias dentro de las llaves."); }
break;
case 76:
#line 173 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Solo se aceptan sentencias ejecutables "); }
break;
case 78:
#line 175 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Falta una ',' "); }
break;
case 80:
#line 181 "gramatica.y"
{yyval=yyvsp[0];}
break;
case 81:
#line 182 "gramatica.y"
{yyval=yyvsp[0];}
break;
case 82:
#line 183 "gramatica.y"
{yyval=yyvsp[0];}
break;
case 83:
#line 184 "gramatica.y"
{yyval=yyvsp[0];}
break;
case 84:
#line 185 "gramatica.y"
{yyval=yyvsp[0];}
break;
case 85:
#line 186 "gramatica.y"
{yyval=yyvsp[0];}
break;
case 88:
#line 193 "gramatica.y"
{ String ambito = yyvsp[-3].sval;
                                            actualizarAmbito(ambitoAct, ambito);
                                            /*chequear si las variables pasadas por parametro estan en el ambito anterior*/

                                            yyval = new NodoComun("Funcion", new NodoControl("ParametroFuncion", (Nodo)yyvsp[-2]), new NodoControl("SentenciasFuncion",(Nodo)yyvsp[-2]));

                                            if (!TablaSimbolos.existeSimbolo(yyvsp[-3].sval+":"+ambitoAct)){
                                                ((Nodo)yyvsp[-3]).setLexema(yyvsp[-3].sval+":"+ambitoAct);
                                                ((Nodo)yyvsp[-3]).setUso("Funcion");
                                                TablaSimbolos.setAmbito(yyvsp[-3].sval+":"+ambitoAct, ambitoAct);
                                            }

                                            AnalizadorLexico.agregarEstructura("Reconoce funcion VOID ");}
break;
case 89:
#line 207 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba un nombre para la funcion ");}
break;
case 90:
#line 211 "gramatica.y"
{	yyval = new NodoHoja(yyvsp[-1].sval);

                           }
break;
case 91:
#line 214 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba un ')' ");}
break;
case 92:
#line 215 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba un '(' ");}
break;
case 94:
#line 217 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba un ')' ");}
break;
case 95:
#line 218 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba un '(' ");}
break;
case 97:
#line 222 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba un '{' ");}
break;
case 98:
#line 223 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba un '}' ");}
break;
case 105:
#line 232 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba una ',' al final de la linea ");}
break;
case 106:
#line 233 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba una ',' al final de la linea ");}
break;
case 107:
#line 234 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba una ',' al final de la linea ");}
break;
case 108:
#line 237 "gramatica.y"
{AnalizadorLexico.agregarEstructura("Reconoce llamado funcion ");}
break;
case 109:
#line 238 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba un '(' ");}
break;
case 110:
#line 239 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba un ')' ");}
break;
case 111:
#line 240 "gramatica.y"
{AnalizadorLexico.agregarEstructura("Reconoce llamado funcion ");}
break;
case 112:
#line 242 "gramatica.y"
{yyval = new NodoControl("PRINT", new NodoHoja(yyvsp[0].sval));
                             AnalizadorLexico.agregarEstructura("Reconoce salida de mensaje por pantalla ");}
break;
case 113:
#line 244 "gramatica.y"
{yyval = new NodoControl("PRINT", new NodoHoja(yyvsp[0].sval));
                            AnalizadorLexico.agregarEstructura("Reconoce salida de mensaje por pantalla ");}
break;
case 114:
#line 246 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("La funcion PRINT no acepta esa declaracion ");}
break;
case 115:
#line 249 "gramatica.y"
{yyval=yyvsp[0];}
break;
case 116:
#line 250 "gramatica.y"
{yyval=yyvsp[0];}
break;
case 117:
#line 253 "gramatica.y"
{AnalizadorLexico.agregarEstructura("Reconoce asignacion ");}
break;
case 118:
#line 255 "gramatica.y"
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
case 121:
#line 274 "gramatica.y"
{yyval=new NodoComun("Sentencia DO UNTIL", new NodoControl("ListSentenciasDO",(Nodo)yyvsp[-2]), new NodoControl("CondicionDO", (Nodo)yyvsp[0]));
                                                        AnalizadorLexico.agregarEstructura("Reconoce funcion DO UNTIL");}
break;
case 122:
#line 276 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba una condicion ");}
break;
case 123:
#line 281 "gramatica.y"
{}
break;
case 124:
#line 282 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba un '(' ");}
break;
case 125:
#line 285 "gramatica.y"
{ yyval = new NodoControl("TOD",(Nodo)yyvsp[0]);
                                            AnalizadorLexico.agregarEstructura("Reconoce funcion TOD ");
                                            }
break;
case 126:
#line 289 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba una Expresion ");}
break;
case 132:
#line 300 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba una ',' al final de la linea ");}
break;
case 133:
#line 301 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba una ',' al final de la linea ");}
break;
case 134:
#line 302 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba una ',' al final de la linea ");}
break;
case 135:
#line 303 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba una ',' al final de la linea ");}
break;
case 136:
#line 306 "gramatica.y"
{ String ambito = yyvsp[-1].sval;
                                                actualizarAmbito(ambitoAct, ambito);
                                                AnalizadorLexico.agregarEstructura("Reconoce CLASE");}
break;
case 137:
#line 312 "gramatica.y"
{AnalizadorLexico.agregarEstructura("Reconoce Funcion sin cuerpo");}
break;
case 138:
#line 316 "gramatica.y"
{AnalizadorLexico.agregarEstructura("Reconoce funcion IMPL");}
break;
case 139:
#line 317 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba un '{' ");}
break;
case 140:
#line 318 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba un '}' ");}
break;
#line 1215 "y.tab.c"
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
