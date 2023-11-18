#ifndef lint
static char yysccsid[] = "@(#)yaccpar	1.8 (Berkeley) 01/20/90";
#endif
#define YYBYACC 1
#line 2 "gramatica.y"
package AnalisisLexico;
import AnalisisLexico.ParserVal;
import GeneracionCodigoIntermedio.*;
import AnalisisLexico.AccionesSemanticas.AccionSemantica;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
#line 15 "y.tab.c"
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
    0,    0,    1,    1,    2,    2,    2,    2,    6,    7,
    4,    4,    4,    4,    4,    5,    5,    5,    5,    5,
    5,    5,   13,   13,   16,   12,   12,   12,   18,   18,
   18,   18,   18,   18,   19,   19,   19,   19,   20,   20,
   20,   20,   20,   20,   22,   22,   23,   24,   24,   24,
   10,   10,   10,   10,   10,   10,   10,   10,   10,   10,
   10,   10,   10,   10,   10,   26,   26,   26,   26,   26,
   26,   26,   26,   27,   28,   28,   28,   28,   25,   25,
   25,   25,   25,   25,   29,   29,   14,   14,   31,   31,
   31,   31,   31,   31,   32,   32,   32,   32,   32,   32,
   32,   32,   32,    8,    8,    8,    8,   11,   11,   11,
   34,   34,    9,    9,    9,    9,    9,    9,    3,    3,
   33,   33,   33,   21,   21,   35,   36,   36,   36,   36,
   36,   36,   36,   36,   15,   30,   17,   17,   17,
};
short yylen[] = {                                         2,
    3,    3,    2,    3,    1,    1,    1,    2,    3,    3,
    1,    1,    1,    1,    1,    2,    1,    2,    2,    1,
    1,    1,    1,    3,    2,    1,    1,    1,    1,    1,
    2,    1,    2,    2,    3,    3,    1,    1,    3,    3,
    1,    3,    3,    1,    1,    1,    1,    5,    5,    5,
    6,    4,    6,    4,    7,    8,    7,    7,    7,    7,
    7,    7,    7,    7,    5,    3,    2,    2,    5,    5,
    3,    3,    2,    1,    1,    2,    2,    3,    1,    1,
    1,    1,    1,    1,    1,    1,    6,    6,    4,    4,
    4,    2,    2,    2,    3,    3,    2,    2,    2,    3,
    2,    2,    2,    3,    3,    3,    2,    2,    2,    2,
    1,    1,    3,    3,    3,    3,    3,    2,    4,    4,
    3,    3,    3,    2,    3,    3,    3,    4,    2,    3,
    3,    4,    2,    3,    3,    3,    7,    7,    7,
};
short yydefred[] = {                                      0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
   27,   26,   28,    0,  112,    0,  111,    0,    0,    5,
    6,    7,    0,   15,   12,   11,   13,   14,    0,   17,
   20,   21,   22,    0,    0,   23,    0,    0,    0,    0,
  110,   45,  108,   29,   30,   32,    0,   46,  109,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,  107,    0,    8,    2,    0,    3,    0,   19,    0,
  118,    1,    0,    0,    0,   47,    0,    0,   38,   41,
   44,    0,    0,    0,    0,   33,   31,   34,    0,  135,
    0,    0,    0,    0,   75,    0,    0,    0,   68,   67,
   73,    0,    0,    0,  105,    0,    0,   10,  106,  104,
    0,  117,    0,    4,  116,  114,  115,   24,    0,    0,
    0,  124,   83,   84,   82,   81,    0,    0,   79,   80,
    0,    0,    0,    0,    0,    0,   54,    0,   52,    0,
    0,   85,    0,   86,    0,   94,    0,   93,   92,    0,
    0,    0,   77,   76,   71,    0,   72,    0,   66,    0,
  119,    0,  122,  123,  121,    9,  125,    0,    0,    0,
   39,   42,   40,   43,    0,    0,   65,    0,    0,    0,
    0,    0,    0,  133,  129,    0,  126,    0,    0,    0,
    0,    0,    0,    0,    0,   78,    0,    0,    0,    0,
   50,   49,   48,    0,    0,    0,    0,    0,    0,    0,
   53,   51,    0,  131,  127,    0,  134,    0,  130,   91,
   90,   89,  103,   99,  101,   97,  102,   98,   88,    0,
   87,   70,   69,    0,    0,   63,   62,   61,   59,    0,
   58,   55,   64,   60,   57,    0,    0,  100,   96,   95,
  138,  139,  137,   56,
};
short yydgoto[] = {                                       3,
   18,   19,   20,   21,   22,   76,   24,   25,   26,   27,
   28,   29,   37,   30,   31,   32,   33,   48,   77,   78,
   79,   80,   81,   40,  131,   56,   97,   98,  143,  144,
   93,  194,   62,   34,   90,  145,
};
short yysindex[] = {                                    -96,
   90,   90,    0, -249,  -39,  -24, -244, -226,  -97, -250,
    0,    0,    0,  -38,    0, -209,    0,   11,   31,    0,
    0,    0,  -50,    0,    0,    0,    0,    0, -200,    0,
    0,    0,    0, -165,   27,    0,   66,   -5,   -5,  237,
    0,    0,    0,    0,    0,    0,  -74,    0,    0,   12,
  -37,  -37,  110,    2,  153, -123, -125,  -36, -122,  -41,
   66,    0,  -10,    0,    0,   90,    0,    7,    0,   66,
    0,    0,  -99,  127,  -34,    0,   57,   96,    0,    0,
    0,   57,   -7,   34,  167,    0,    0,    0,  -79,    0,
   77,   65,   53,   86,    0,   43,   68,  177,    0,    0,
    0, -107,  -33,  142,    0,  122,  -30,    0,    0,    0,
  -29,    0,   83,    0,    0,    0,    0,    0,  -44,   -5,
  -28,    0,    0,    0,    0,    0,    3,    3,    0,    0,
   -5,    3,    3,   -5, -179,  -94,    0,  237,    0, -195,
 -249,    0,   45,    0,    5,    0,  -40,    0,    0,   26,
  121,  121,    0,    0,    0,  159,    0,   51,    0,   -5,
    0,  -95,    0,    0,    0,    0,    0,   96,   96,  156,
    0,    0,    0,    0,   -9,  -97,    0,  237,  237,   69,
 -214,  -37,  -22,    0,    0,  -79,    0,  -79,  219,  -26,
   78,   79,   80,   50,   61,    0,  179,  190,   40,   40,
    0,    0,    0,  103,  109,  112,   93, -186,  113, -160,
    0,    0,   86,    0,    0, -249,    0, -249,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,  137,
    0,    0,    0,  216, -101,    0,    0,    0,    0,  114,
    0,    0,    0,    0,    0,   66,   66,    0,    0,    0,
    0,    0,    0,    0,
};
short yyrindex[] = {                                      0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    6,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    9,    0,    0,    0,    0,    0,    0,    0,    0,   23,
    0,    0,    0,   21,    0,    0,    0,   41,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0, -106,    0,    0,
    0,    0,    0,    0,    0,    0,  -17,    0,    0,    0,
    0,    0,   49,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,   70,
    0,    0,    0,    0,    0,    0,    0,   47,   67,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,   28,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,   32,   33,    0,    0,    0,
    0,    0,    0,    0,
};
short yygindex[] = {                                      0,
  373,  314,    0,  381,  -19,  308,    0,  326,    0,    0,
    0,  -32,  340,    8,    0,    0,    0,    0,   82,  -12,
    0,   52,   58,  288,  310,    1,  345,    0,   24,    0,
   -1,  249,  332,   15,    0,    0,
};
#define YYTABLESIZE 611
short yytable[] = {                                     110,
   39,   60,   92,   47,  105,  121,   39,   59,   47,   60,
   17,  165,  167,  128,  222,  127,   47,  159,   74,   36,
   47,  215,   17,  253,   50,   55,    2,  200,   63,   51,
   57,  203,   60,  128,   47,  127,   73,   68,   59,   47,
   85,  211,   52,    9,  212,  100,   64,   47,  188,   18,
   94,   47,   25,   17,   66,   69,  141,   49,  147,  150,
   51,   45,   45,   45,   45,   45,   16,   45,   36,  241,
   66,  136,  242,  182,   67,  132,  128,  136,  176,  177,
   45,   37,   45,   37,   37,   37,  154,   36,  185,   36,
   36,   36,  113,  230,  198,  244,  142,   63,  245,  128,
   37,  127,   37,   71,  230,  149,   36,   35,   36,   35,
   35,   35,  210,  120,  168,  169,  129,  146,  130,  117,
   82,  224,  226,  228,   73,  128,   35,  127,   35,  187,
   18,  193,  193,   25,   89,   65,  240,  132,  181,  106,
  103,  111,  133,  104,  113,   45,  107,   16,  157,   74,
   17,   72,  136,  216,  252,  218,  132,  128,   53,    1,
  199,  178,  163,  179,  128,   37,  127,  158,   74,  118,
   17,   36,  119,  113,  229,  151,  204,   54,  206,  208,
  213,   17,  140,  171,  173,  231,   11,   12,   13,  172,
  174,   35,  155,  142,  120,  142,  201,   17,  128,  162,
  127,  106,  111,   86,   87,   88,  234,  235,  152,  217,
  250,  219,  170,   17,  109,  175,   38,   58,   91,   17,
  156,  120,  160,   15,  166,   58,  164,   74,  189,  221,
   36,   41,   74,  214,   75,   15,   44,   45,   46,   75,
   74,   44,   45,   46,   42,  112,  202,   75,   58,   44,
   45,   46,   43,   44,   45,   46,    9,   99,   74,  220,
  186,   18,  115,   74,   25,   75,   15,   44,   45,   46,
   75,   74,   44,   45,   46,   74,   45,  101,   16,   45,
   44,   45,   46,  136,   44,   45,   46,  132,  128,  135,
   45,   45,   45,   45,  190,   45,   37,   17,  153,   37,
  184,    8,   36,  232,  113,   36,  197,  113,   23,   23,
   37,   37,   37,   37,  233,   37,   36,   36,   36,   36,
  148,   36,   35,  113,  209,   35,  123,  124,  125,  126,
   11,   12,   13,  223,  225,  227,   35,   35,   35,   35,
  251,   35,   11,   12,   13,    4,    5,   23,  239,    6,
    7,    8,    9,   61,   10,   11,   12,   13,   14,   55,
   23,  236,   23,   15,   16,   95,    5,  237,   70,    6,
  238,  243,  254,   23,   35,  116,    4,    5,   83,  114,
    6,    7,    8,   15,  108,   10,   11,   12,   13,   14,
  161,  134,    4,    5,   15,  191,    6,    7,    8,  102,
  195,   10,   11,   12,   13,   14,  122,    0,   95,    5,
   15,  248,    6,    0,    0,    5,    0,    0,    6,    0,
   84,   83,  137,    0,  138,  139,   15,   83,    0,    0,
    0,    0,   15,   96,    0,   96,    0,    0,    0,    0,
    0,    0,    0,    0,    0,   23,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,   23,   23,
    0,    0,    0,   23,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
  183,    0,    0,    0,    0,   23,   23,    0,    0,    0,
    0,    0,   53,    5,    0,    0,    6,    0,    0,    0,
    0,    0,    0,    0,    0,   83,    0,    0,    0,    0,
   15,   54,    0,    0,    0,    0,    0,    0,  180,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,  192,  192,    0,    0,    0,  196,   23,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,  246,    0,  247,  205,  207,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
  249,
};
short yycheck[] = {                                      41,
   40,   40,   40,   45,   41,   40,   40,   46,   45,   40,
   61,   41,   41,   43,   41,   45,   45,  125,  125,  269,
   45,   44,   61,  125,  269,  123,  123,  123,   14,  256,
  281,   41,   40,   43,   45,   45,   59,   23,   46,   45,
   40,  256,  269,   61,  259,   44,  256,   45,   44,   44,
   52,   45,   44,   61,   44,  256,   89,    6,   91,   92,
  256,   41,   42,   43,   44,   45,   44,   47,  269,  256,
   44,   44,  259,  269,   44,   44,   44,   44,  258,  259,
   60,   41,   62,   43,   44,   45,   44,   41,   44,   43,
   44,   45,   44,   44,   44,  256,   89,   83,  259,   43,
   60,   45,   62,  269,   44,   41,   60,   41,   62,   43,
   44,   45,   44,   44,  127,  128,   60,   41,   62,   68,
   39,   44,   44,   44,   59,   43,   60,   45,   62,  125,
  125,  151,  152,  125,  123,  125,   44,   42,  138,   58,
  264,   60,   47,  269,   63,  125,  269,  125,  256,  256,
   61,  125,  125,  186,  256,  188,  125,  125,  256,  256,
  256,  256,   41,  258,   43,  125,   45,  275,  275,  269,
   61,  125,   46,  125,  125,  123,  176,  275,  178,  179,
  182,   61,  262,  132,  133,  125,  266,  267,  268,  132,
  133,  125,  125,  186,  125,  188,   41,   61,   43,   58,
   45,  120,  121,  278,  279,  280,  199,  200,  123,  186,
  230,  188,  131,   61,  256,  134,  256,  256,  256,   61,
   44,  256,  256,  274,  269,  256,  256,  269,  269,  256,
  269,  256,  269,  256,  276,  274,  278,  279,  280,  276,
  269,  278,  279,  280,  269,  256,  256,  276,  256,  278,
  279,  280,  277,  278,  279,  280,  274,  256,  269,   41,
  256,  256,  256,  269,  256,  276,  274,  278,  279,  280,
  276,  269,  278,  279,  280,  269,  256,  125,  256,  259,
  278,  279,  280,  256,  278,  279,  280,  256,  256,  256,
  270,  271,  272,  273,  269,  275,  256,   61,  256,  259,
  256,  262,  256,  125,  256,  259,  256,  259,    1,    2,
  270,  271,  272,  273,  125,  275,  270,  271,  272,  273,
  256,  275,  256,  275,  256,  259,  270,  271,  272,  273,
  266,  267,  268,  256,  256,  256,  270,  271,  272,  273,
  125,  275,  266,  267,  268,  256,  257,   40,  256,  260,
  261,  262,  263,   14,  265,  266,  267,  268,  269,  123,
   53,  259,   55,  274,  275,  256,  257,  259,   29,  260,
  259,  259,  259,   66,    2,   68,  256,  257,  269,   66,
  260,  261,  262,  274,   59,  265,  266,  267,  268,  269,
  103,   82,  256,  257,  274,  275,  260,  261,  262,   55,
  152,  265,  266,  267,  268,  269,   75,   -1,  256,  257,
  274,  275,  260,   -1,   -1,  257,   -1,   -1,  260,   -1,
   40,  269,  256,   -1,  258,  259,  274,  269,   -1,   -1,
   -1,   -1,  274,   53,   -1,   55,   -1,   -1,   -1,   -1,
   -1,   -1,   -1,   -1,   -1,  138,   -1,   -1,   -1,   -1,
   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,  151,  152,
   -1,   -1,   -1,  156,   -1,   -1,   -1,   -1,   -1,   -1,
   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,
  141,   -1,   -1,   -1,   -1,  178,  179,   -1,   -1,   -1,
   -1,   -1,  256,  257,   -1,   -1,  260,   -1,   -1,   -1,
   -1,   -1,   -1,   -1,   -1,  269,   -1,   -1,   -1,   -1,
  274,  275,   -1,   -1,   -1,   -1,   -1,   -1,  138,   -1,
   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,
   -1,  151,  152,   -1,   -1,   -1,  156,  230,   -1,   -1,
   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,
   -1,   -1,   -1,   -1,   -1,  216,   -1,  218,  178,  179,
   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,
   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,
   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,
   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,
   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,
  230,
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
"Funcion : VOID error Parametro '{' ListSentenciasFuncion '}'",
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
"Asignacion : ID OperadorAsignacion Expresion",
"Asignacion : ReferenciaObjeto OperadorAsignacion ReferenciaObjeto",
"Asignacion : ReferenciaObjeto OperadorAsignacion Factor",
"Asignacion : ReferenciaObjeto OperadorAsignacion error",
"Asignacion : ID OperadorAsignacion error",
"Asignacion : OperadorAsignacion ID",
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
#line 407 "gramatica.y"
  private NodoControl raiz;
  private String ambitoAct = "main";
  static ArrayList<Error> erroresSemanticos = new ArrayList<Error>();
  static ArrayList<String> variables_declaradas = new ArrayList<String>();
  static String tipoActual;

  public void agregarErrorSemantico(String error){
      Error e = new Error(error,AnalizadorLexico.getLineaAct());
      erroresSemanticos.add(e);
    }

   public void chequearEnteroNegativo(String m){
             try {
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
             } catch (Exception e) {
                   AnalizadorLexico.agregarErrorLexico("Entero negativo fuera de rango");
             }
   }

   public void chequearEnteroPositivo(String m){
                try {
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
                } catch (Exception e) {
                     AnalizadorLexico.agregarErrorLexico("Entero positivo fuera de rango");
                }
   }

   public void chequearEnteroCorto(String m){
                try {
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
                } catch (Exception e) {
                     AnalizadorLexico.agregarErrorLexico("Entero positivo fuera de rango");
                }

         }

   public void chequearDouble(String m){
           String n = m.replace('D', 'e').replace('d','e');
           try {
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
           } catch (Exception e) {
                AnalizadorLexico.agregarErrorLexico("Double fuera de rango");
           }
      }

   public void actualizarAmbito(String ambitoAct, String a){
        ambitoAct += ":"+a;
   }

   public String estaAlAlcance(String lexema){ //EN CASO DE QUE ESTE AL ALCANCE DEVUELVE EL LEXEMA CORRECTO, CASO CONTRARIO DEVUELVE EL NOMBRE DE LA VARIABLE SOLA
           if (!TablaSimbolos.existeSimbolo(lexema)){
                char [] a = lexema.toCharArray();
                for (int i = a.length;i>0;i--){
                   if(a[i-1] == ':'){
                       lexema = lexema.substring(0,i-1);
                       lexema = estaAlAlcance(lexema);
                   }
                }
           }
           return lexema;
   }

   public String tipoPredominante(String a, String b){
            if ((a.getTipo().equals("DOUBLE"))|| (b.getTipo().equals("DOUBLE"))){
                  return "DOUBLE";
            } else { ((a.getTipo().equals("INT"))|| (b.getTipo().equals("INT")))
                    return "INT";
            }
            return "USHORT";
   }


  public int yylex() throws IOException{
    Token t = AnalizadorLexico.obtenerToken();
    this.yylval = new ParserVal(t.getLexema());
    return t.getId();
  }

  public static void yyerror(String error){
    System.out.println(error);
  }
#line 612 "y.tab.c"
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
#line 17 "gramatica.y"
{raiz = new NodoControl("PROGRAMA",(Nodo)yyvsp[-1]); AnalizadorLexico.agregarEstructura("Reconoce programa ");}
break;
case 2:
#line 19 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se espera '{' ");}
break;
case 3:
#line 22 "gramatica.y"
{yyval=yyvsp[-1];}
break;
case 4:
#line 23 "gramatica.y"
{yyval = new NodoComun("Sentencia", (Nodo) yyvsp[-2], (Nodo) yyvsp[0]);}
break;
case 5:
#line 27 "gramatica.y"
{yyval=yyvsp[0];}
break;
case 6:
#line 28 "gramatica.y"
{yyval=yyvsp[0];}
break;
case 7:
#line 29 "gramatica.y"
{yyval=yyvsp[0];}
break;
case 8:
#line 30 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("RETURN definido fuera de funcion ");}
break;
case 9:
#line 33 "gramatica.y"
{/*chequear q exista y bla bla*/
                            yyval = new NodoComun("ReferenciaFuncionObjeto",(Nodo)yyvsp[-2],(Nodo)yyvsp[0]);
                            AnalizadorLexico.agregarEstructura("Reconoce referencia objeto ");}
break;
case 10:
#line 38 "gramatica.y"
{ /*chequear q exista y bla bla*/
                                                yyval = new NodoComun("ReferenciaFuncionObjeto",(Nodo)yyvsp[-2],(Nodo)yyvsp[0]);
                                                AnalizadorLexico.agregarEstructura("Reconoce llamado a funcion de clase ");}
break;
case 11:
#line 43 "gramatica.y"
{yyval=yyvsp[0];}
break;
case 12:
#line 44 "gramatica.y"
{yyval=yyvsp[0];}
break;
case 13:
#line 45 "gramatica.y"
{yyval=yyvsp[0];}
break;
case 14:
#line 46 "gramatica.y"
{yyval=yyvsp[0];}
break;
case 15:
#line 47 "gramatica.y"
{yyval=yyvsp[0];}
break;
case 16:
#line 50 "gramatica.y"
{   for (String var : variables_declaradas) { /*CHEQUAER SI UNA VARIABLE CON ESE LEXEMA YA TIENE SETEADO EL USO, SI LO TIENE SETEADO ES PORQ YA EXITE*/
                                                Token t = TablaSimbolos.getToken(var);
                                                if (t != null){
                                                    t.setLexema(var + ":" + ambitoAct);
                                                    t.setAmbito(ambitoAct);
                                                    t.setUso("variable");
                                                    t.setTipo(tipoActual);
                                                    TablaSimbolos.removeToken(var);
                                                    TablaSimbolos.addSimbolo(t.getLexema(),t);
                                                }
                                                else {
                                                   agregarErrorSemantico("Ya existe una variable + var + definida en este ambito");
                                                }
                                            }
                                            variables_declaradas.clear();
                                          }
break;
case 18:
#line 67 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se espera el tipo de la variable ");}
break;
case 19:
#line 68 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se espera identificador de la variable ");}
break;
case 23:
#line 74 "gramatica.y"
{variables_declaradas.add(yyvsp[0].sval);}
break;
case 24:
#line 75 "gramatica.y"
{yyval = yyvsp[-2] ; variables_declaradas.add(yyvsp[0].sval);}
break;
case 26:
#line 81 "gramatica.y"
{tipoActual = yyvsp[0].sval;}
break;
case 27:
#line 82 "gramatica.y"
{tipoActual = yyvsp[0].sval;}
break;
case 28:
#line 83 "gramatica.y"
{tipoActual = yyvsp[0].sval;}
break;
case 29:
#line 86 "gramatica.y"
{
                    chequearEnteroPositivo(yyvsp[0].sval);
                    yyval = new NodoHoja(yyvsp[0].sval) ;
                    ((Nodo)yyval).setTipo(TablaSimbolos.getTipo(yyvsp[0].sval));
                    ((Nodo)yyval).setUso("Constante");
                    TablaSimbolos.setUso(yyvsp[0].sval, "Constante");
                   }
break;
case 30:
#line 94 "gramatica.y"
{yyval = new NodoHoja(yyvsp[0].sval);
	               chequearEnteroCorto(yyvsp[0].sval);
	               ((Nodo)yyval).setTipo(TablaSimbolos.getTipo(yyvsp[0].sval));
                   chequearEnteroPositivo(yyvsp[0].sval);
                   ((Nodo)yyval).setUso("Constante");
                   TablaSimbolos.setUso(yyvsp[0].sval, "Constante");
                   }
break;
case 31:
#line 101 "gramatica.y"
{AnalizadorLexico.agregarErrorLexico("Un entero corto no puede ser negativo ");}
break;
case 32:
#line 102 "gramatica.y"
{
	                chequearDouble(yyvsp[0].sval);
	                yyval = new NodoHoja(yyvsp[0].sval);
                    ((Nodo)yyval).setTipo(TablaSimbolos.getTipo(yyvsp[0].sval));
                    ((Nodo)yyval).setUso("Constante");
                    TablaSimbolos.setUso(yyvsp[0].sval, "Constante");
                    }
break;
case 33:
#line 110 "gramatica.y"
{
                    yyval = new NodoHoja(yyvsp[-1].sval);
                    chequearEnteroNegativo(yyvsp[0].sval);
                    ((Nodo)yyval).setTipo(TablaSimbolos.getTipo(yyvsp[-1].sval));
                    ((Nodo)yyval).setUso("Constante");
                    TablaSimbolos.setUso(yyvsp[-1].sval, "Constante");
	                }
break;
case 34:
#line 117 "gramatica.y"
{
                            chequearDouble(yyvsp[-1].sval);
                            yyval = new NodoHoja(yyvsp[-1].sval);
                            ((Nodo)yyval).setTipo(TablaSimbolos.getTipo(yyvsp[-1].sval));
                            ((Nodo)yyval).setUso("Constante");
                            TablaSimbolos.setUso(yyvsp[-1].sval, "Constante");
                        }
break;
case 35:
#line 126 "gramatica.y"
{ yyval = new NodoComun("+",(Nodo)yyvsp[-2],(Nodo)yyvsp[0]);
                                    if (!((Nodo)yyvsp[-2]).getAmbito().equals(((Nodo)yyvsp[0]).getAmbito())){
                                          agregarErrorSemantico("Variable fuera de alcance ");
                                    }
                                        (Nodo)yyval.setTipo(tipoPredominante(((Nodo)yyvsp[-2]).getTipo(),((Nodo)yyvsp[0]).getTipo());
                                    }
break;
case 36:
#line 133 "gramatica.y"
{yyval = new NodoComun("-",(Nodo)yyvsp[-2],(Nodo)yyvsp[0]);
                        if (!((Nodo)yyvsp[-2]).getAmbito().equals(((Nodo)yyvsp[0]).getAmbito())){
                            agregarErrorSemantico("Variable fuera de alcance ");
                        }
                            (Nodo)yyval.setTipo(tipoPredominante(((Nodo)yyvsp[-2]).getTipo(),((Nodo)yyvsp[0]).getTipo());
                      }
break;
case 37:
#line 139 "gramatica.y"
{yyval=yyvsp[0];}
break;
case 38:
#line 140 "gramatica.y"
{yyval = yyvsp[0];}
break;
case 39:
#line 144 "gramatica.y"
{yyval = new NodoComun("*",(Nodo)yyvsp[-2],(Nodo)yyvsp[0]);
                               if (!((Nodo)yyvsp[-2]).getAmbito().equals(((Nodo)yyvsp[0]).getAmbito())){
                                    agregarErrorSemantico("Variable fuera de alcance ");
                               }
                                    (Nodo)yyval.setTipo(tipoPredominante(((Nodo)yyvsp[-2]).getTipo(),((Nodo)yyvsp[0]).getTipo());
                              }
break;
case 40:
#line 151 "gramatica.y"
{yyval = new NodoComun("/",(Nodo)yyvsp[-2],(Nodo)yyvsp[0]);
                    if (!((Nodo)yyvsp[-2]).getAmbito().equals(((Nodo)yyvsp[0]).getAmbito())){
                        agregarErrorSemantico("Variable fuera de alcance ");
                    }
                        (Nodo)yyval.setTipo(tipoPredominante(((Nodo)yyvsp[-2]).getTipo(),((Nodo)yyvsp[0]).getTipo());
                    }
break;
case 41:
#line 157 "gramatica.y"
{yyval = yyvsp[0];}
break;
case 42:
#line 158 "gramatica.y"
{yyval = new NodoComun("*",(Nodo)yyvsp[-2],(Nodo)yyvsp[0]);
                               if (!((Nodo)yyvsp[-2]).getAmbito().equals(((Nodo)yyvsp[0]).getAmbito())){
                                    agregarErrorSemantico("Variable fuera de alcance ");
                               }
                                    (Nodo)yyval.setTipo(tipoPredominante(yyvsp[-2].sval,yyvsp[-1].sval));
                               }
break;
case 43:
#line 164 "gramatica.y"
{yyval = new NodoComun("/",(Nodo)yyvsp[-2],(Nodo)yyvsp[0]);
                               if (!((Nodo)yyvsp[-2]).getAmbito().equals(((Nodo)yyvsp[0]).getAmbito())){
                                    agregarErrorSemantico("Variable fuera de alcance ");
                               }
                                    (Nodo)yyval.setTipo(tipoPredominante(((Nodo)yyvsp[-2]).getTipo(),((Nodo)yyvsp[0]).getTipo());
                               }
break;
case 44:
#line 170 "gramatica.y"
{yyval=yyvsp[0];}
break;
case 45:
#line 173 "gramatica.y"
{yyval = new NodoHoja(yyvsp[0].sval);
            String var = yyvsp[0].sval + ":" + ambitoAct;
            String var = estaAlAlcance(var);
            if (var.equals(yyvsp[0].sval)){
                agregarErrorSemantico("Variable no declarada en este ambito ");
            }
            else {
                if(!TablaSimbolos.getUso(var).equals("Variable")){
                    agregarErrorSemantico("El ID en uso no es una variable ");
                }
                else {
                    ((Nodo)yyval).setTipo(TablaSimbolos.getTipo(var));
                    ((Nodo)yyval).setUso(TablaSimbolos.getUso(var));
                    ((Nodo)yyval).setAmbito(TablaSimbolos.getAmbito(var));
                }
            }
          }
break;
case 46:
#line 190 "gramatica.y"
{yyval=yyvsp[0];}
break;
case 47:
#line 193 "gramatica.y"
{yyval=yyvsp[0];}
break;
case 48:
#line 196 "gramatica.y"
{ yyval = new NodoComun(yyvsp[-2].sval,(Nodo)yyvsp[-3],(Nodo)yyvsp[-1]);
                                                    ((Nodo)yyval).setTipo(((Nodo)yyvsp[-3]).getTipo());
                                                    ((Nodo)yyval).setUso("Condicion");
                                                     if (!((((Nodo)yyvsp[-3]).getTipo()).equals(((Nodo)yyvsp[-1]).getTipo()))){
                                                         agregarErrorSemantico("Error en la comparacion entre expresiones de distintos tipos"); /*CHEQUEAR CONVERSIONES*/
                                                     }
                                                     }
break;
case 49:
#line 203 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba una ')' ");}
break;
case 50:
#line 204 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba una '(' ");}
break;
case 51:
#line 207 "gramatica.y"
{Nodo SentenciasIF = new NodoComun("SentenciasIF",new NodoControl("SentenciasIF",(Nodo)yyvsp[-3]), new NodoControl("SentenciasELSE",(Nodo)yyvsp[-1]));
                                                                      yyval= new NodoComun("BloqueIF", new NodoControl("Condicion",(Nodo)yyvsp[-4]), SentenciasIF);
                                                                      AnalizadorLexico.agregarEstructura("Reconoce IF ELSE ");}
break;
case 52:
#line 210 "gramatica.y"
{yyval= new NodoComun("BloqueIF", new NodoControl("Condicion",(Nodo)yyvsp[-2]), new NodoControl("SentenciasIF",(Nodo)yyvsp[-1]));
	                                            AnalizadorLexico.agregarEstructura("Reconoce IF ");}
break;
case 53:
#line 212 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("IF mal definido ");}
break;
case 54:
#line 213 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("IF mal definido ");}
break;
case 55:
#line 214 "gramatica.y"
{AnalizadorLexico.agregarEstructura("Reconoce IF ELSE");}
break;
case 56:
#line 215 "gramatica.y"
{AnalizadorLexico.agregarEstructura("Reconoce IF ELSE");}
break;
case 57:
#line 216 "gramatica.y"
{AnalizadorLexico.agregarEstructura("Reconoce IF ELSE");}
break;
case 58:
#line 217 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba un END_IF ");}
break;
case 59:
#line 218 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba un END_IF ");}
break;
case 60:
#line 219 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba un END_IF ");}
break;
case 61:
#line 220 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba un ELSE ");}
break;
case 62:
#line 221 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("IF mal definido ");}
break;
case 63:
#line 222 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba una ',' ");}
break;
case 64:
#line 223 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba una ',' " );}
break;
case 65:
#line 224 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba una ',' ");}
break;
case 68:
#line 229 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Falta una ',' "); }
break;
case 70:
#line 231 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Falta una ',' "); }
break;
case 71:
#line 232 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Falta un '{'"); }
break;
case 72:
#line 233 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Falta un '}'"); }
break;
case 73:
#line 234 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("No hay sentencias dentro de las llaves."); }
break;
case 75:
#line 240 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Solo se aceptan sentencias ejecutables "); }
break;
case 77:
#line 242 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Falta una ',' "); }
break;
case 79:
#line 248 "gramatica.y"
{yyval=yyvsp[0];}
break;
case 80:
#line 249 "gramatica.y"
{yyval=yyvsp[0];}
break;
case 81:
#line 250 "gramatica.y"
{yyval=yyvsp[0];}
break;
case 82:
#line 251 "gramatica.y"
{yyval=yyvsp[0];}
break;
case 83:
#line 252 "gramatica.y"
{yyval=yyvsp[0];}
break;
case 84:
#line 253 "gramatica.y"
{yyval=yyvsp[0];}
break;
case 87:
#line 261 "gramatica.y"
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
case 88:
#line 275 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba un nombre para la funcion ");}
break;
case 89:
#line 279 "gramatica.y"
{	yyval = new NodoHoja(yyvsp[-1].sval);

                           }
break;
case 90:
#line 282 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba un ')' ");}
break;
case 91:
#line 283 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba un '(' ");}
break;
case 93:
#line 285 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba un ')' ");}
break;
case 94:
#line 286 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba un '(' ");}
break;
case 101:
#line 295 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba una ',' al final de la linea ");}
break;
case 102:
#line 296 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba una ',' al final de la linea ");}
break;
case 103:
#line 297 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba una ',' al final de la linea ");}
break;
case 104:
#line 301 "gramatica.y"
{yyval=new NodoHoja(yyvsp[-2].sval);AnalizadorLexico.agregarEstructura("Reconoce llamado funcion ");}
break;
case 105:
#line 302 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba un '(' ");}
break;
case 106:
#line 303 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba un ')' ");}
break;
case 107:
#line 304 "gramatica.y"
{yyval=new NodoComun("Llamado Funcion",(Nodo)yyvsp[-1],new NodoControl("Parametro Llamado Funcion",(Nodo)yyvsp[0]));AnalizadorLexico.agregarEstructura("Reconoce llamado funcion ");}
break;
case 108:
#line 307 "gramatica.y"
{yyval = new NodoControl("PRINT", new NodoHoja(yyvsp[0].sval));
                             AnalizadorLexico.agregarEstructura("Reconoce salida de mensaje por pantalla ");}
break;
case 109:
#line 309 "gramatica.y"
{yyval = new NodoControl("PRINT", new NodoHoja(yyvsp[0].sval));
                            AnalizadorLexico.agregarEstructura("Reconoce salida de mensaje por pantalla ");}
break;
case 110:
#line 311 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("La funcion PRINT no acepta esa declaracion ");}
break;
case 111:
#line 314 "gramatica.y"
{yyval=yyvsp[0];}
break;
case 112:
#line 315 "gramatica.y"
{yyval=yyvsp[0];}
break;
case 113:
#line 318 "gramatica.y"
{AnalizadorLexico.agregarEstructura("Reconoce asignacion ");
						                        yyval = new NodoComun(yyvsp[-1].sval,(Nodo)yyvsp[-2],(Nodo)yyvsp[0]);
						                        Token t1 = TablaSimbolos.getToken(yyvsp[-2].sval);
						                        if (t1.getUso() != null){
						                            if (!estaAlAlcance(yyvsp[-2].sval + ":" + ambitoAct).equals(yyvsp[-2].sval)){
                                                        ((Nodo)yyval).setTipo(tipoPredominante(((Nodo)yyvsp[-2]).getTipo(),((Nodo)yyvsp[0]).getTipo()));
						                            }
						                            else {
						                                agregarErrorSemantico("Variable " + yyvsp[-2].sval " fuera de alcance");
						                            }
						                        }
						                        else {
						                            agregarErrorSemantico("Variable " + t1.getLexema() + " no definida");
						                        }
					    }
break;
case 116:
#line 336 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba un valor seguido del operador ");}
break;
case 117:
#line 337 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba un valor seguido del operador ");}
break;
case 118:
#line 338 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba un operando del lado izquierdo ");}
break;
case 119:
#line 341 "gramatica.y"
{yyval=new NodoComun("Sentencia DO UNTIL", new NodoControl("ListSentenciasDO",(Nodo)yyvsp[-2]), new NodoControl("CondicionDO", (Nodo)yyvsp[0]));
                                                        AnalizadorLexico.agregarEstructura("Reconoce funcion DO UNTIL");}
break;
case 120:
#line 343 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba una condicion ");}
break;
case 121:
#line 348 "gramatica.y"
{yyval = yyvsp[-1];}
break;
case 122:
#line 349 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba un '(' ");}
break;
case 123:
#line 350 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba un ')' ");}
break;
case 124:
#line 353 "gramatica.y"
{yyval = new NodoControl("TOD",(Nodo)yyvsp[0]);
                                            AnalizadorLexico.agregarEstructura("Reconoce funcion TOD ");
                                            }
break;
case 125:
#line 357 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba una Expresion ");}
break;
case 127:
#line 364 "gramatica.y"
{

                                               }
break;
case 131:
#line 370 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba una ',' al final de la linea ");}
break;
case 132:
#line 371 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba una ',' al final de la linea ");}
break;
case 133:
#line 372 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba una ',' al final de la linea ");}
break;
case 134:
#line 373 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba una ',' al final de la linea ");}
break;
case 135:
#line 376 "gramatica.y"
{ 	String ambito = yyvsp[-1].sval;
						if (!(TablaSimbolos.existeSimbolo(yyvsp[-1].sval))) { /*PREGUNTAR TMB X USO EN COND*/
                                                   TablaSimbolos.getToken(yyvsp[-1].sval).setAmbito(ambitoAct);
                                                   actualizarAmbito(ambitoAct, ambito);
                                                   TablaSimbolos.getToken(yyvsp[-1].sval).setUso("Clase");
                                                   AnalizadorLexico.agregarEstructura("Reconoce CLASE");
                                               } else {
                                                    agregarErrorSemantico("Clase " + yyvsp[-1].sval + " ya definida en el ambito actual");
                                               }
                                              int index = ambitoAct.lastIndexOf(":");
                                              ambitoAct = ambitoAct.substring(0, index);
                                              }
break;
case 136:
#line 391 "gramatica.y"
{AnalizadorLexico.agregarEstructura("Reconoce Funcion sin cuerpo");}
break;
case 137:
#line 395 "gramatica.y"
{AnalizadorLexico.agregarEstructura("Reconoce funcion IMPL");}
break;
case 138:
#line 396 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba un '{' ");}
break;
case 139:
#line 397 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba un '}' ");}
break;
#line 1354 "y.tab.c"
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
