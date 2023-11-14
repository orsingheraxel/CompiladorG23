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
   31,   31,   31,   31,   31,   32,   32,   32,   32,   32,
   32,   32,   32,   32,    8,    8,    8,    8,   11,   11,
   11,   34,   34,   35,    9,    9,    9,    3,    3,   33,
   33,   33,   21,   21,   36,   37,   37,   37,   37,   37,
   37,   37,   37,   15,   30,   17,   17,   17,
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
    1,    1,    1,    1,    1,    1,    1,    6,    4,    4,
    4,    4,    2,    2,    2,    3,    3,    2,    2,    2,
    3,    2,    2,    2,    3,    3,    3,    2,    2,    2,
    2,    1,    1,    0,    4,    3,    3,    4,    4,    3,
    3,    3,    2,    3,    3,    3,    4,    2,    3,    3,
    4,    2,    3,    3,    3,    7,    7,    7,
};
short yydefred[] = {                                      0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
   28,   27,   29,    0,    0,    0,    0,    6,    7,    8,
    0,   16,   13,   12,   14,   15,    0,   18,   21,   22,
   23,    0,   24,    0,    0,    0,    0,  111,   46,  109,
   30,   31,   33,    0,   47,  110,    0,    0,    0,    0,
    0,    0,    0,    0,    0,  113,    0,    0,  112,    0,
  108,    0,    9,    2,    0,    5,    3,    0,   20,    0,
    1,    0,    0,    0,   48,    0,    0,   39,   42,   45,
    0,    0,    0,    0,   34,   32,   35,    0,  134,    0,
    0,    0,    0,   76,    0,    0,    0,   69,   68,   74,
    0,    0,    0,  106,    0,    0,   11,  107,  105,    0,
    0,    4,  116,  117,   25,    0,    0,    0,  123,   84,
   85,   83,   82,    0,    0,   80,   81,    0,    0,    0,
    0,    0,    0,   55,    0,   53,    0,    0,   86,    0,
   87,    0,   95,    0,   94,   93,    0,    0,    0,    0,
    0,    0,   78,   77,   72,    0,   73,    0,   67,    0,
  118,    0,  121,  122,  120,  115,   10,  124,    0,    0,
    0,   40,   43,   41,   44,    0,    0,   66,    0,    0,
    0,    0,    0,    0,  132,  128,    0,  125,    0,    0,
    0,  104,  100,  102,   98,  103,   99,    0,    0,   79,
    0,    0,    0,    0,   51,   50,   49,    0,    0,    0,
    0,    0,    0,    0,   54,   52,    0,  130,  126,    0,
  133,    0,  129,   92,   91,   90,  101,   97,   96,   88,
   71,   70,    0,    0,   64,   63,   62,   60,    0,   59,
   56,   65,   61,   58,    0,    0,  137,  138,  136,   57,
};
short yydgoto[] = {                                       3,
   16,   17,   18,   19,   20,   75,   22,   23,   24,   25,
   26,   27,   34,   28,   29,   30,   31,   45,   76,   77,
   78,   79,   80,   37,  128,   53,   96,   97,  140,  141,
   92,  151,   61,   62,  166,   89,  142,
};
short yysindex[] = {                                    -94,
  112,  112,    0, -227,  -39,  -24, -223, -162, -101, -221,
    0,    0,    0,  -38, -192,   -7,   70,    0,    0,    0,
  -50,    0,    0,    0,    0,    0, -156,    0,    0,    0,
    0,    8,    0,   38,  -12,  -12, -103,    0,    0,    0,
    0,    0,    0,  -68,    0,    0,  -31,  -37,  -37, -128,
   71,  -81, -148, -139,  -36,    0, -135,  -41,    0,   38,
    0,  -12,    0,    0,  112,    0,    0,  -20,    0,   38,
    0, -134,  110,  -34,    0,   46,   -4,    0,    0,    0,
   46,   41,   75, -232,    0,    0,    0,  -59,    0,   62,
   57,  149,   40,    0,   76,   42,  129,    0,    0,    0,
  -97,  -33,  119,    0,   24,  -30,    0,    0,    0,  -27,
  103,    0,    0,    0,    0,  -87,  -12,  -28,    0,    0,
    0,    0,    0,  -20,  -20,    0,    0,  -12,  -20,  -20,
  -12, -187,  -52,    0, -103,    0, -152, -227,    0,   77,
    0,   15,    0,  -69,    0,    0,  -53,   78,   79,   80,
  155,  149,    0,    0,    0,  -64,    0,   81,    0,  -12,
    0,  -88,    0,    0,    0,    0,    0,    0,   -4,   -4,
  104,    0,    0,    0,    0,   -9, -101,    0, -103, -103,
   82,  -70,  -37,   26,    0,    0,  -59,    0,  -59,  222,
  -22,    0,    0,    0,    0,    0,    0,  181,   11,    0,
  145,  168,   45,   45,    0,    0,    0,   21,   61,   87,
   83,   31,   88,   43,    0,    0,   40,    0,    0, -227,
    0, -227,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,  176,  -86,    0,    0,    0,    0,   89,    0,
    0,    0,    0,    0,   38,   38,    0,    0,    0,    0,
};
short yyrindex[] = {                                      0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,   17,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,   18,
    0,    0,    0,    0,    0,    0,    0,    0,    0,   19,
    0,    0,    6,    0,    0,    0,   13,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,  -95,    0,    0,    0,
    0,    0,    0,    0,    0,  -49,    0,    0,    0,    0,
  -29,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
  -85,    0,    0,    0,    0,    0,    0,    0,    0,   35,
    0,    0,    0,    0,    0,    0,    0,    0,   33,   39,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,   44,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,   65,   66,    0,    0,    0,    0,
};
short yygindex[] = {                                      0,
  347,  285,    0,  305,  -47,  339,    0,  294,    0,    0,
    0,  107,  123,   -2,    0,    0,    0,    0,  308,  -13,
    0,   84,   91,  250,  272,    4,  302,    0,    5,    0,
  -18,  204,  284,  338,    0,    0,    0,
};
#define YYTABLESIZE 537
short yytable[] = {                                     109,
   36,   58,   91,   44,  104,  118,   36,   57,   44,   58,
   59,   10,  168,  165,  114,  125,   44,  124,  226,   52,
   44,   52,   59,  134,   44,  135,  136,  159,    2,   75,
   93,  207,   44,  125,  204,  124,   65,  129,  249,   89,
   84,   33,  130,  100,  150,   47,   46,   46,   46,   46,
   46,   65,   46,   38,  198,   38,   38,   38,  189,   54,
   19,   26,   17,   63,  163,   46,  125,   46,  124,  219,
  177,  178,   38,   37,   38,   37,   37,   37,  119,   36,
   58,   36,   36,   36,   72,  139,   57,  135,  125,   46,
  124,   88,   37,   48,   37,  114,   72,  146,   36,   69,
   36,   59,  143,   48,  150,  126,   49,  127,  131,  127,
  169,  170,   33,   67,   99,  102,  183,   64,  133,  154,
  186,  193,  195,  197,  202,  214,  239,   94,    5,  103,
   46,    6,   71,  106,  115,  230,   60,   38,  182,  188,
   82,   19,   26,   17,  205,  125,  125,  124,  124,   70,
  229,  114,   50,    5,   50,  116,    6,   37,  157,  119,
   75,    1,  152,   36,  217,   82,  155,  203,  135,  248,
   89,   51,  156,   51,   94,    5,  162,  158,    6,   75,
  208,  167,  210,  212,  139,  215,  139,   82,  216,  131,
  127,  221,    5,  223,  138,    6,  144,  147,  198,  190,
  233,  234,  137,  179,   82,  180,   11,   12,   13,   85,
   86,   87,  172,  174,  108,  191,   35,   55,   90,  173,
  175,  117,  160,   56,   10,   55,  114,   73,  164,  114,
   33,   38,   73,  225,   74,   56,   41,   42,   43,   74,
   73,   41,   42,   43,   39,  114,  206,   74,   73,   41,
   42,   43,   40,   41,   42,   43,   73,   41,   42,   43,
  184,   46,  224,   74,   46,   41,   42,   43,   38,  231,
  187,   38,   19,   26,   17,   46,   46,   46,   46,  235,
   46,  218,   38,   38,   38,   38,  240,   38,   37,  241,
  119,   37,  232,  220,   36,  222,   55,   36,  243,  135,
  247,  244,   37,   37,   37,   37,    8,   37,   36,   36,
   36,   36,  145,   36,   56,  120,  121,  122,  123,  236,
  131,  127,   11,   12,   13,   66,   98,   11,   12,   13,
  132,  153,  185,  192,  194,  196,  201,  213,  238,   21,
   21,   83,  245,   81,  246,  237,  242,  250,   32,  112,
  107,  161,  131,  101,   95,  199,   95,  119,   68,    0,
    0,    0,  105,    0,    0,  110,    0,    4,    5,  111,
    0,    6,    7,    8,    9,   21,   10,   11,   12,   13,
   14,    0,    0,    0,    0,    0,   15,    0,   21,    0,
   21,    0,    0,    0,    0,    0,  149,    0,    0,    0,
    0,    0,    0,   21,    4,    5,  113,    0,    6,    7,
    8,    0,    0,   10,   11,   12,   13,   14,    0,    0,
    0,    0,    0,  148,  105,  110,    0,    0,    0,    0,
   21,    0,    0,    0,    0,  171,    4,    5,  176,  181,
    6,    7,    8,    0,    0,   10,   11,   12,   13,   14,
    0,    0,    0,    0,    0,  227,  149,    0,    0,    0,
  200,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,   21,    0,    0,    0,    0,    0,    0,
    0,    0,    0,  209,  211,    0,    0,    0,    0,    0,
   21,    0,    0,    0,   21,    0,    0,    0,    0,    0,
    0,    0,  228,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,   21,   21,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,   21,
};
short yycheck[] = {                                      41,
   40,   40,   40,   45,   41,   40,   40,   46,   45,   40,
   61,   61,   41,   41,   44,   43,   45,   45,   41,  123,
   45,  123,   61,  256,   45,  258,  259,  125,  123,  125,
   49,   41,   45,   43,  123,   45,   44,   42,  125,  125,
   37,  269,   47,  125,   92,  269,   41,   42,   43,   44,
   45,   44,   47,   41,   44,   43,   44,   45,   44,  281,
   44,   44,   44,  256,   41,   60,   43,   62,   45,   44,
  258,  259,   60,   41,   62,   43,   44,   45,   44,   41,
   40,   43,   44,   45,   59,   88,   46,   44,   43,    6,
   45,  123,   60,  256,   62,  125,   59,   41,   60,  256,
   62,   61,   41,  256,  152,   60,  269,   62,   44,   44,
  124,  125,  269,   44,   44,  264,  269,  125,   44,   44,
   44,   44,   44,   44,   44,   44,   44,  256,  257,  269,
  125,  260,  125,  269,  269,  125,   14,  125,  135,  125,
  269,  125,  125,  125,   41,   43,   43,   45,   45,   27,
  198,   68,  256,  257,  256,   46,  260,  125,  256,  125,
  256,  256,  123,  125,  183,  269,  125,  256,  125,  256,
  256,  275,   44,  275,  256,  257,   58,  275,  260,  275,
  177,  269,  179,  180,  187,  256,  189,  269,  259,  125,
  125,  187,  257,  189,   88,  260,   90,   91,   44,  269,
  203,  204,  262,  256,  269,  258,  266,  267,  268,  278,
  279,  280,  129,  130,  256,  269,  256,  256,  256,  129,
  130,  256,  256,  274,  274,  256,  256,  269,  256,  259,
  269,  256,  269,  256,  276,  274,  278,  279,  280,  276,
  269,  278,  279,  280,  269,  275,  256,  276,  269,  278,
  279,  280,  277,  278,  279,  280,  269,  278,  279,  280,
  138,  256,   41,  276,  259,  278,  279,  280,  256,  125,
  256,  259,  256,  256,  256,  270,  271,  272,  273,  259,
  275,  256,  270,  271,  272,  273,  256,  275,  256,  259,
  256,  259,  125,  187,  256,  189,  256,  259,  256,  256,
  125,  259,  270,  271,  272,  273,  262,  275,  270,  271,
  272,  273,  256,  275,  274,  270,  271,  272,  273,  259,
  256,  256,  266,  267,  268,  256,  256,  266,  267,  268,
  256,  256,  256,  256,  256,  256,  256,  256,  256,    1,
    2,   37,  220,   36,  222,  259,  259,  259,    2,   65,
   57,  102,   81,   52,   50,  152,   52,   74,   21,   -1,
   -1,   -1,   55,   -1,   -1,   58,   -1,  256,  257,   62,
   -1,  260,  261,  262,  263,   37,  265,  266,  267,  268,
  269,   -1,   -1,   -1,   -1,   -1,  275,   -1,   50,   -1,
   52,   -1,   -1,   -1,   -1,   -1,   92,   -1,   -1,   -1,
   -1,   -1,   -1,   65,  256,  257,   68,   -1,  260,  261,
  262,   -1,   -1,  265,  266,  267,  268,  269,   -1,   -1,
   -1,   -1,   -1,  275,  117,  118,   -1,   -1,   -1,   -1,
   92,   -1,   -1,   -1,   -1,  128,  256,  257,  131,  135,
  260,  261,  262,   -1,   -1,  265,  266,  267,  268,  269,
   -1,   -1,   -1,   -1,   -1,  275,  152,   -1,   -1,   -1,
  156,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,
   -1,   -1,   -1,  135,   -1,   -1,   -1,   -1,   -1,   -1,
   -1,   -1,   -1,  179,  180,   -1,   -1,   -1,   -1,   -1,
  152,   -1,   -1,   -1,  156,   -1,   -1,   -1,   -1,   -1,
   -1,   -1,  198,   -1,   -1,   -1,   -1,   -1,   -1,   -1,
   -1,   -1,   -1,   -1,   -1,   -1,   -1,  179,  180,   -1,
   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,
   -1,   -1,   -1,   -1,   -1,   -1,  198,
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
"Funcion : VOID ID Parametro '{' ListSentenciasFuncion '}'",
"Funcion : VOID error Parametro ListSentenciasFuncion",
"Parametro : '(' Tipo ID ')'",
"Parametro : '(' Tipo ID error",
"Parametro : error Tipo ID ')'",
"Parametro : '(' ')'",
"Parametro : '(' error",
"Parametro : error ')'",
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
"LlamadoExpresion : error Expresion ')'",
"LlamadoExpresion : '(' Expresion error",
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
#line 378 "gramatica.y"
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
#line 588 "y.tab.c"
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
{/*chequear q exista y bla bla*/
                            yyval = new NodoComun("ReferenciaFuncionObjeto",(Nodo)yyvsp[-2],(Nodo)yyvsp[0]);
                            AnalizadorLexico.agregarEstructura("Reconoce referencia objeto ");}
break;
case 11:
#line 37 "gramatica.y"
{ /*chequear q exista y bla bla*/
                                                yyval = new NodoComun("ReferenciaFuncionObjeto",(Nodo)yyvsp[-2],(Nodo)yyvsp[0]);
                                                AnalizadorLexico.agregarEstructura("Reconoce llamado a funcion de clase ");}
break;
case 12:
#line 42 "gramatica.y"
{yyval=yyvsp[0];}
break;
case 13:
#line 43 "gramatica.y"
{yyval=yyvsp[0];}
break;
case 14:
#line 44 "gramatica.y"
{yyval=yyvsp[0];}
break;
case 15:
#line 45 "gramatica.y"
{yyval=yyvsp[0];}
break;
case 16:
#line 46 "gramatica.y"
{yyval=yyvsp[0];}
break;
case 17:
#line 49 "gramatica.y"
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
#line 66 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se espera el tipo de la variable ");}
break;
case 20:
#line 67 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se espera identificador de la variable ");}
break;
case 24:
#line 73 "gramatica.y"
{ yyval = new ListVariables();
                    ((ListVariables)yyval).addVariable(yyvsp[0].sval);}
break;
case 25:
#line 75 "gramatica.y"
{yyval = yyvsp[0] ; ((ListVariables)yyval).addVariable(yyvsp[0].sval);}
break;
case 30:
#line 86 "gramatica.y"
{
                    chequearEnteroPositivo(yyvsp[0].sval);
                    yyval = new NodoHoja(yyvsp[0].sval) ;
                    ((Nodo)yyval).setTipo(TablaSimbolos.getTipo(yyvsp[0].sval));
                    ((Nodo)yyval).setUso("Constante");
                    TablaSimbolos.setUso(yyvsp[0].sval, "Constante");
                   }
break;
case 31:
#line 94 "gramatica.y"
{yyval = new NodoHoja(yyvsp[0].sval)
	               chequearEnteroCorto(yyvsp[0].sval);
	               ((Nodo)yyval).setTipo(TablaSimbolos.getTipo(yyvsp[0].sval));
                   chequearEnteroPositivo(yyvsp[0].sval);
                   ((Nodo)yyval).setUso("Constante");
                   TablaSimbolos.setUso(yyvsp[0].sval, "Constante");
                   }
break;
case 32:
#line 101 "gramatica.y"
{AnalizadorLexico.agregarErrorLexico("Un entero corto no puede ser negativo ");}
break;
case 33:
#line 102 "gramatica.y"
{
	                chequearDouble(yyvsp[0].sval);
	                yyval = new NodoHoja(yyvsp[0].sval);
                    ((Nodo)yyval).setTipo(TablaSimbolos.getTipo(yyvsp[0].sval));
                    ((Nodo)yyval).setUso("Constante");
                    TablaSimbolos.setUso(yyvsp[0].sval, "Constante");
                    }
break;
case 34:
#line 110 "gramatica.y"
{
                    yyval = new NodoHoja(yyvsp[-1].sval);
                    chequearEnteroNegativo(yyvsp[0].sval);
                    ((Nodo)yyval).setTipo(TablaSimbolos.getTipo(yyvsp[-1].sval));
                    ((Nodo)yyval).setUso("Constante");
                    TablaSimbolos.setUso(yyvsp[-1].sval, "Constante");
	                }
break;
case 35:
#line 117 "gramatica.y"
{
                            chequearDouble(yyvsp[-1].sval);
                            yyval = new NodoHoja(yyvsp[-1].sval);
                            ((Nodo)yyval).setTipo(TablaSimbolos.getTipo(yyvsp[-1].sval));
                            ((Nodo)yyval).setUso("Constante");
                            TablaSimbolos.setUso(yyvsp[-1].sval, "Constante");
                        }
break;
case 36:
#line 126 "gramatica.y"
{ yyval = new NodoComun("+",(Nodo)yyvsp[-2],(Nodo)yyvsp[0]);
                                    if (!((Nodo)(yyvsp[-2]).getTipo().equals((Nodo)(yyvsp[0]).getTipo()))){
                                        agregarErrorSemantico("No se puede realizar la suma. Tipos incompatibles ");
                                    }
                                    if (!(Nodo)(yyvsp[-2]).getAmbito().equals((Nodo)(yyvsp[0]).getAmbito())){
                                          agregarErrorSemantico("Variable fuera de alcance ");
                                    }



                                    }
break;
case 37:
#line 138 "gramatica.y"
{yyval = new NodoComun("-",(Nodo)yyvsp[-2],(Nodo)yyvsp[0]);}
break;
case 38:
#line 139 "gramatica.y"
{yyval=yyvsp[0];}
break;
case 39:
#line 140 "gramatica.y"
{yyval = yyvsp[0];}
break;
case 40:
#line 144 "gramatica.y"
{yyval=new NodoComun("*",(Nodo)yyvsp[-2].sval,(Nodo)yyvsp[-1].sval);}
break;
case 41:
#line 154 "gramatica.y"
{yyval=new NodoComun("/",(Nodo)yyvsp[-2].sval,(Nodo)yyvsp[-1].sval);}
break;
case 42:
#line 155 "gramatica.y"
{yyval = yyvsp[0];}
break;
case 43:
#line 156 "gramatica.y"
{yyval=new NodoComun("*",(Nodo)yyvsp[-2].sval,(Nodo)yyvsp[-1].sval);}
break;
case 44:
#line 157 "gramatica.y"
{yyval=new NodoComun("/",(Nodo)yyvsp[-2].sval,(Nodo)yyvsp[-1].sval);}
break;
case 45:
#line 158 "gramatica.y"
{yyval=yyvsp[0];}
break;
case 46:
#line 161 "gramatica.y"
{yyval = new NodoHoja(yyvsp[0].sval);
            String var = yyvsp[0].sval + ":" + ambitoAct
            if (!TablaSimbolos.existeSimbolo(var)){
                agregarErrorSemantico("Variable no declarada en este ambito ");
            }
            else {
                if(!TablaSimbolos.getUso(var).equals("Variable")){
                    agregarErrorSemantico("El ID en uso no es una variable ");
                }
                else {
                    ((Nodo)yyval).setTipo(TablaSimbolos.getTipo(yyvsp[0].sval));
                    ((Nodo)yyval).setUso(TablaSimbolos.getUso(yyvsp[0].sval));
                    ((Nodo)yyval).setAmbito(TablaSimbolos.getAmbito(yyvsp[0].sval));
                }
            }
            }
break;
case 47:
#line 177 "gramatica.y"
{yyval=yyvsp[0];}
break;
case 48:
#line 180 "gramatica.y"
{yyval=yyvsp[0];}
break;
case 49:
#line 183 "gramatica.y"
{ yyval = new NodoComun(yyvsp[-2].sval,(Nodo)yyvsp[-3],(Nodo)yyvsp[-1]);
                                                    ((Nodo)yyval).setTipo(((Nodo)yyvsp[-3]).getTipo());
                                                    ((Nodo)yyval).setUso("Condicion");
                                                     if (!((((Nodo)yyvsp[-3]).getTipo()).equals(((Nodo)yyvsp[-1]).getTipo()))){
                                                         agregarErrorSemantico("Error en la comparacion entre expresiones de distintos tipos"); /*CHEQUEAR CONVERSIONES*/
                                                     }
                                                     }
break;
case 50:
#line 190 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba una ')' ");}
break;
case 51:
#line 191 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba una '(' ");}
break;
case 52:
#line 194 "gramatica.y"
{Nodo SentenciasIF = new NodoComun("SentenciasIF",new NodoControl("SentenciasIF",(Nodo)yyvsp[-3]), new NodoControl("SentenciasELSE",(Nodo)yyvsp[-1]));
                                                                      yyval= new NodoComun("BloqueIF", new NodoControl("Condicion",(Nodo)yyvsp[-4]), SentenciasIF);
                                                                      AnalizadorLexico.agregarEstructura("Reconoce IF ELSE ");}
break;
case 53:
#line 197 "gramatica.y"
{yyval= new NodoComun("BloqueIF", new NodoControl("Condicion",(Nodo)yyvsp[-2]), new NodoControl("SentenciasIF",(Nodo)yyvsp[-1]));
	                                            AnalizadorLexico.agregarEstructura("Reconoce IF ");}
break;
case 54:
#line 199 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("IF mal definido ");}
break;
case 55:
#line 200 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("IF mal definido ");}
break;
case 56:
#line 201 "gramatica.y"
{AnalizadorLexico.agregarEstructura("Reconoce IF ELSE");}
break;
case 57:
#line 202 "gramatica.y"
{AnalizadorLexico.agregarEstructura("Reconoce IF ELSE");}
break;
case 58:
#line 203 "gramatica.y"
{AnalizadorLexico.agregarEstructura("Reconoce IF ELSE");}
break;
case 59:
#line 204 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba un END_IF ");}
break;
case 60:
#line 205 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba un END_IF ");}
break;
case 61:
#line 206 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba un END_IF ");}
break;
case 62:
#line 207 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba un ELSE ");}
break;
case 63:
#line 208 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("IF mal definido ");}
break;
case 64:
#line 209 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba una ',' ");}
break;
case 65:
#line 210 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba una ',' " );}
break;
case 66:
#line 211 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba una ',' ");}
break;
case 69:
#line 216 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Falta una ',' "); }
break;
case 71:
#line 218 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Falta una ',' "); }
break;
case 72:
#line 219 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Falta un '{'"); }
break;
case 73:
#line 220 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Falta un '}'"); }
break;
case 74:
#line 221 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("No hay sentencias dentro de las llaves."); }
break;
case 76:
#line 227 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Solo se aceptan sentencias ejecutables "); }
break;
case 78:
#line 229 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Falta una ',' "); }
break;
case 80:
#line 235 "gramatica.y"
{yyval=yyvsp[0];}
break;
case 81:
#line 236 "gramatica.y"
{yyval=yyvsp[0];}
break;
case 82:
#line 237 "gramatica.y"
{yyval=yyvsp[0];}
break;
case 83:
#line 238 "gramatica.y"
{yyval=yyvsp[0];}
break;
case 84:
#line 239 "gramatica.y"
{yyval=yyvsp[0];}
break;
case 85:
#line 240 "gramatica.y"
{yyval=yyvsp[0];}
break;
case 88:
#line 247 "gramatica.y"
{ String ambito = yyvsp[-4].sval;
                                            actualizarAmbito(ambitoAct, ambito);
                                            /*chequear si las variables pasadas por parametro estan en el ambito anterior*/

                                            yyval = new NodoComun("Funcion", new NodoControl("ParametroFuncion", (Nodo)yyvsp[-3]), new NodoControl("SentenciasFuncion",(Nodo)yyvsp[-3]));

                                            if (!TablaSimbolos.existeSimbolo(yyvsp[-4].sval+":"+ambitoAct)){
                                                ((Nodo)yyvsp[-4]).setLexema(yyvsp[-4].sval+":"+ambitoAct);
                                                ((Nodo)yyvsp[-4]).setUso("Funcion");
                                                TablaSimbolos.setAmbito(yyvsp[-4].sval+":"+ambitoAct, ambitoAct);
                                            }

                                            AnalizadorLexico.agregarEstructura("Reconoce funcion VOID ");}
break;
case 89:
#line 261 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba un nombre para la funcion ");}
break;
case 90:
#line 265 "gramatica.y"
{	yyval = new NodoHoja(yyvsp[-1].sval);

                           }
break;
case 91:
#line 268 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba un ')' ");}
break;
case 92:
#line 269 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba un '(' ");}
break;
case 94:
#line 271 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba un ')' ");}
break;
case 95:
#line 272 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba un '(' ");}
break;
case 102:
#line 281 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba una ',' al final de la linea ");}
break;
case 103:
#line 282 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba una ',' al final de la linea ");}
break;
case 104:
#line 283 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba una ',' al final de la linea ");}
break;
case 105:
#line 286 "gramatica.y"
{yyval=new NodoComun("Llamado Funcion",(Nodo)yyvsp[-2], null);AnalizadorLexico.agregarEstructura("Reconoce llamado funcion ");}
break;
case 106:
#line 287 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba un '(' ");}
break;
case 107:
#line 288 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba un ')' ");}
break;
case 108:
#line 289 "gramatica.y"
{yyval=new NodoComun("Llamado Funcion",(Nodo)yyvsp[-1],(Nodo)yyvsp[0]);AnalizadorLexico.agregarEstructura("Reconoce llamado funcion ");}
break;
case 109:
#line 291 "gramatica.y"
{yyval = new NodoControl("PRINT", new NodoHoja(yyvsp[0].sval));
                             AnalizadorLexico.agregarEstructura("Reconoce salida de mensaje por pantalla ");}
break;
case 110:
#line 293 "gramatica.y"
{yyval = new NodoControl("PRINT", new NodoHoja(yyvsp[0].sval));
                            AnalizadorLexico.agregarEstructura("Reconoce salida de mensaje por pantalla ");}
break;
case 111:
#line 295 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("La funcion PRINT no acepta esa declaracion ");}
break;
case 112:
#line 298 "gramatica.y"
{yyval=yyvsp[0];}
break;
case 113:
#line 299 "gramatica.y"
{yyval=yyvsp[0];}
break;
case 114:
#line 302 "gramatica.y"
{AnalizadorLexico.agregarEstructura("Reconoce asignacion ");}
break;
case 115:
#line 304 "gramatica.y"
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
case 118:
#line 323 "gramatica.y"
{yyval=new NodoComun("Sentencia DO UNTIL", new NodoControl("ListSentenciasDO",(Nodo)yyvsp[-2]), new NodoControl("CondicionDO", (Nodo)yyvsp[0]));
                                                        AnalizadorLexico.agregarEstructura("Reconoce funcion DO UNTIL");}
break;
case 119:
#line 325 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba una condicion ");}
break;
case 120:
#line 330 "gramatica.y"
{yyval = yyvsp[-1];}
break;
case 121:
#line 331 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba un '(' ");}
break;
case 122:
#line 332 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba un ')' ");}
break;
case 123:
#line 335 "gramatica.y"
{ yyval = new NodoControl("TOD",(Nodo)yyvsp[0]);
                                            AnalizadorLexico.agregarEstructura("Reconoce funcion TOD ");
                                            }
break;
case 124:
#line 339 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba una Expresion ");}
break;
case 130:
#line 350 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba una ',' al final de la linea ");}
break;
case 131:
#line 351 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba una ',' al final de la linea ");}
break;
case 132:
#line 352 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba una ',' al final de la linea ");}
break;
case 133:
#line 353 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba una ',' al final de la linea ");}
break;
case 134:
#line 356 "gramatica.y"
{ String ambito = yyvsp[-1].sval;
                                                actualizarAmbito(ambitoAct, ambito);
                                                AnalizadorLexico.agregarEstructura("Reconoce CLASE");}
break;
case 135:
#line 362 "gramatica.y"
{AnalizadorLexico.agregarEstructura("Reconoce Funcion sin cuerpo");}
break;
case 136:
#line 366 "gramatica.y"
{AnalizadorLexico.agregarEstructura("Reconoce funcion IMPL");}
break;
case 137:
#line 367 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba un '{' ");}
break;
case 138:
#line 368 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba un '}' ");}
break;
#line 1278 "y.tab.c"
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
