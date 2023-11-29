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
    0,    0,    1,    1,    1,    3,    3,    3,    6,    7,
    5,    5,    5,    5,    5,   12,   12,   12,   12,    2,
    2,    2,    2,    2,    2,    2,   14,   14,   17,   19,
   19,   13,   13,   13,   20,   20,   20,   20,   20,   20,
   21,   21,   21,   21,   22,   22,   22,   22,   22,   22,
   24,   24,   25,   26,   26,   26,   10,   10,   10,   10,
   10,   10,   10,   10,   10,   10,   10,   10,   10,   10,
   10,   28,   28,   28,   28,   28,   28,   28,   29,   29,
   29,   30,   30,   30,   30,   27,   27,   27,   27,   27,
   27,   15,   15,   31,   31,   31,   31,   31,   33,   34,
   34,   34,   34,   34,   34,   35,   35,   35,   35,   35,
    8,    8,    8,    8,   11,   11,   11,   36,   36,    9,
    9,    9,    9,    9,    9,    4,    4,   37,   37,   37,
   23,   23,   38,   39,   16,   32,   18,   18,   18,
};
short yylen[] = {                                         2,
    4,    3,    3,    2,    2,    1,    1,    2,    3,    3,
    1,    1,    1,    1,    1,    3,    2,    2,    3,    2,
    1,    2,    2,    1,    1,    1,    1,    3,    2,    1,
    3,    1,    1,    1,    1,    1,    2,    1,    2,    2,
    3,    3,    1,    1,    3,    3,    1,    3,    3,    1,
    1,    1,    1,    5,    5,    5,    6,    4,    6,    4,
    7,    8,    7,    7,    7,    7,    7,    7,    7,    7,
    5,    3,    5,    5,    5,    3,    3,    2,    1,    2,
    2,    1,    2,    2,    3,    1,    1,    1,    1,    1,
    1,    1,    1,    7,    7,    5,    6,    4,    2,    4,
    4,    4,    2,    2,    2,    3,    2,    2,    2,    2,
    3,    3,    3,    4,    2,    2,    2,    1,    1,    3,
    3,    3,    3,    3,    2,    4,    4,    3,    3,    3,
    2,    3,    3,    2,    2,    2,    7,    7,    7,
};
short yydefred[] = {                                      0,
    0,    0,    0,    0,    0,    0,    0,  119,    0,   35,
   36,   38,    0,  118,    0,    0,    6,    7,    0,   15,
   12,   11,   13,   14,   52,    0,    0,    0,    0,    0,
    0,  117,   51,  115,  116,    0,    0,    0,    0,    0,
    0,    8,   39,   37,   40,    2,    0,    5,    4,    0,
    0,  125,    0,    0,    0,    0,   33,   32,   34,    0,
    0,    0,   21,   24,   25,   26,   92,   93,    0,    0,
    0,    0,   53,    0,    0,   44,   47,   50,    0,    0,
    0,   82,    0,    0,    0,    0,    0,   78,    0,    0,
  112,    0,   10,  113,  111,    0,    3,  123,  121,  122,
  124,    0,   27,    0,  134,    0,   99,    0,   30,    0,
    1,   23,    0,    0,    0,    0,    0,  135,    0,    0,
    0,  131,   90,   91,   89,   88,    0,    0,   86,   87,
    0,    0,    0,    0,    0,    0,   60,    0,   58,   81,
   80,   84,   83,   76,    0,    0,    0,   77,    0,   72,
    0,  126,  114,    0,    0,    0,    0,  105,    0,  104,
  103,    0,    0,    0,    0,    0,    0,    9,    0,  132,
    0,    0,    0,    0,   45,   48,   46,   49,    0,    0,
   71,    0,    0,    0,    0,   85,    0,    0,    0,   28,
    0,    0,   31,    0,    0,    0,   98,    0,    0,    0,
    0,   18,   17,    0,  133,    0,  129,  130,  128,   56,
   55,   54,    0,    0,    0,    0,    0,    0,    0,   59,
   57,   74,   75,   73,    0,    0,    0,  102,  101,  100,
  110,  109,  107,  108,    0,    0,    0,   19,   16,   69,
   68,   67,   65,    0,   64,   61,   70,   66,   63,   97,
    0,    0,    0,    0,    0,  106,   62,  138,    0,  139,
  137,   95,   94,
};
short yydgoto[] = {                                       3,
   15,  198,   16,   17,   18,   19,   20,   21,   22,   23,
   24,  167,   62,  104,   63,   64,   65,   66,  110,   25,
   74,   75,   76,   26,   78,   31,  131,   38,   85,   86,
   67,   68,   69,  116,  201,   27,  122,  118,   70,
};
short yysindex[] = {                                   -103,
  149,  149,    0,  -37,  161, -100,  -38,    0,  -26,    0,
    0,    0, -225,    0,   84,   36,    0,    0,   -2,    0,
    0,    0,    0,    0,    0,   -2,  -19,   46,  167,  167,
  175,    0,    0,    0,    0,  212,  109, -236,   59, -233,
  -41,    0,    0,    0,    0,    0,   18,    0,    0,  181,
   92,    0, -160, -154, -234, -153,    0,    0,    0,  -39,
    2, -227,    0,    0,    0,    0,    0,    0,  -34,   12,
   90,  -29,    0,  337,  -17,    0,    0,    0,  337,   66,
 -157,    0,   67,   73,   16,  249,   -4,    0, -112,  -25,
    0,   -9,    0,    0,    0,   15,    0,    0,    0,    0,
    0,    3,    0,   83,    0,  -34,    0, -131,    0,   88,
    0,    0,   83,   51,  264,   25, -172,    0, -126,  167,
  -36,    0,    0,    0,    0,    0,  187,  187,    0,    0,
  167,  187,  187,  167, -184, -150,    0,  175,    0,    0,
    0,    0,    0,    0,  106,    0,  114,    0,   74,    0,
  167,    0,    0, -110,   44,  102, -101,    0,  -98,    0,
    0,  -97,   21,  -96,  125,  130,  283,    0,   20,    0,
  -31,  -17,  -17,   28,    0,    0,    0,    0,    6, -100,
    0,  175,  175,   79, -189,    0,   50,   53,   54,    0,
   71,  -99,    0,  135,   23,   86,    0,  -76,  137,  -74,
  116,    0,    0,  143,    0,  144,    0,    0,    0,    0,
    0,    0,  -70,  -69,  -68,   87, -180,  -62, -173,    0,
    0,    0,    0,    0,  141,  -64,  -64,    0,    0,    0,
    0,    0,    0,    0,  155,  -75,  157,    0,    0,    0,
    0,    0,    0,  -56,    0,    0,    0,    0,    0,    0,
   80,  -34, -104,   82,  160,    0,    0,    0,   25,    0,
    0,    0,    0,
};
short yyrindex[] = {                                      0,
    0,    0,    0,    0,    0,    0,   11,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,   11,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
  433,    0,    0,    0,  453,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,  -27,    0,    0,    0,    0,
    0,   17,    0,    0,    0,    0,    0,    0,    0,    0,
    0,   -5,    0,   -1,    0,    0,    0,    0,    0,   24,
    0,    0,   37,    0,    0,   41,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,  -11,    0,    0,    0,    0,
   96,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,  459,  481,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,  164,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,   60,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,  169,    0,    0,    0,    0,    0,    0,
    0,    0,    0,
};
short yygindex[] = {                                      0,
  209,  -12,  377,    0,    1,  531,    0,  174,    0,    0,
    0,    0,    5,  154,    0,    0,    0,    0,    0,    0,
  535,  -15,    0,  506,   -7,  131,  145,   13,  -10,    0,
 -105,    0,  -93,  -87,   32,   26,    0,    0,    0,
};
#define YYTABLESIZE 754
short yytable[] = {                                      95,
   41,   41,   30,   13,  170,  115,   40,   40,   13,  209,
  121,  128,  150,  127,   30,   61,   79,   42,  155,    2,
  261,  106,   37,  227,  132,   13,   89,   90,  112,  133,
   41,   80,   82,   82,  107,   92,   84,   84,  120,  141,
   13,  103,   22,   81,   50,  128,  212,  127,  128,   82,
  127,   51,   43,   44,   45,  153,   14,  128,   14,  127,
  207,   97,  128,  230,  127,   13,  220,   29,  210,  221,
  128,   51,  127,  180,  181,  245,  147,    9,  246,   49,
   20,   14,  248,   53,  136,  249,  145,   84,   54,   55,
   13,  158,   56,   57,   58,   59,  164,   79,  137,   91,
  138,  139,  165,   96,  166,  182,   14,  183,  103,  136,
  141,  172,  173,   81,  105,   13,  143,  189,  159,  162,
  251,  253,  219,   22,  176,  178,  111,  108,   13,   42,
  244,   14,  252,  252,  117,  119,   13,  156,  184,  127,
  144,  154,  168,  148,   14,  197,  157,  163,   29,  186,
  185,  260,    1,   13,  206,   36,  226,  187,  190,  192,
   13,   20,  149,  200,  259,  136,  191,  193,  202,   14,
  194,  195,  109,  203,  222,  228,   14,  223,  224,  232,
  233,  234,  214,  216,   96,   13,  238,  239,  240,  241,
  242,  200,  213,   13,  215,  217,  247,   55,  254,  255,
  256,   14,  257,  263,  258,   13,  262,    7,   46,   14,
   28,   13,    8,   93,   94,  113,   39,   39,   29,   13,
  152,  114,  225,  134,  208,   13,  120,   71,   79,  109,
  151,   13,   71,   88,   72,   14,   10,   11,   12,   72,
  236,   10,   11,   12,   81,   82,   39,   79,   82,   33,
  120,  146,    4,  120,   22,    5,   13,   82,   10,   11,
   12,  211,   82,   81,    7,  250,   82,   82,   82,    8,
   83,    8,   14,   10,   11,   12,   53,    4,  229,   29,
    5,   54,   55,    6,   51,   56,   57,   58,   59,   60,
    9,   48,   20,   13,    8,  196,  136,   37,   10,   11,
   12,   53,    4,    0,  161,    5,   54,   55,    6,   14,
   56,   57,   58,   59,   60,   96,   57,   58,   59,    8,
    9,  135,  140,   10,   11,   12,   53,    4,  142,  188,
    5,   54,   55,    6,  218,   56,   57,   58,   59,   60,
    4,  231,  243,    5,    8,  196,    6,  101,   10,   11,
   12,  127,    7,    0,    0,    0,    0,    8,    9,    0,
   71,   10,   11,   12,   82,    4,    0,   72,    5,   10,
   11,   12,    4,    0,    0,    5,    0,    7,    6,  128,
    0,  127,    8,   87,    7,    0,   10,   11,   12,    8,
  235,   47,    0,   10,   11,   12,  129,    4,  130,    0,
    5,    0,    0,    6,   47,    4,    0,  205,    5,    7,
    0,    6,    0,    0,    8,    9,   32,    7,   10,   11,
   12,    0,    8,    9,    0,    0,   10,   11,   12,   33,
   36,    4,    0,    0,    5,   71,   98,   34,   10,   11,
   12,    0,   72,    7,   10,   11,   12,    0,    8,   71,
    0,    0,   10,   11,   12,   71,    0,    0,   10,   11,
   12,    0,    0,    0,   10,   11,   12,   82,    4,    0,
    0,    5,    0,   51,   51,   51,   51,   51,    0,   51,
    7,    0,    0,    0,    0,    8,   83,    0,    0,   10,
   11,   12,   51,   43,   51,   43,   43,   43,    0,   42,
    0,   42,   42,   42,    0,    4,    0,    0,    5,    0,
   35,    0,   43,    0,   43,    0,    0,    7,   42,  160,
   42,   41,    8,   41,   41,   41,   10,   11,   12,   57,
   58,   59,   52,    0,   77,   77,    0,    0,   53,  199,
   41,    0,   41,   54,   55,    0,   77,   56,   57,   58,
   59,  164,    0,    0,    0,  100,   77,  204,    0,   73,
   73,    0,    0,    0,   79,    0,    0,  199,    0,    0,
    0,   73,    0,    0,    0,   96,    0,  237,    0,    0,
   99,   73,    0,    0,    0,  102,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,  237,    0,    0,    0,    0,  123,  124,  125,  126,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,   77,   77,    0,    0,    0,
    0,    0,   77,   77,    0,    0,   77,  175,  177,   77,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
   73,   73,    0,    0,  169,  171,   77,   73,   73,    0,
    0,   73,   73,   73,   73,  174,    0,    0,  179,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,   73,    0,    0,    0,    0,    0,    0,   51,    0,
    0,   51,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,   51,   51,   51,   51,    0,    0,   43,    0,
    0,   43,    0,    0,   42,    0,    0,   42,    0,    0,
    0,    0,   43,   43,   43,   43,    0,    0,   42,   42,
   42,   42,    0,    0,    0,    0,   41,    0,    0,   41,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
   41,   41,   41,   41,
};
short yycheck[] = {                                      41,
   40,   40,   40,   45,   41,   40,   46,   46,   45,   41,
   40,   43,  125,   45,   40,   28,   44,   44,  106,  123,
  125,  256,  123,  123,   42,   45,   37,  264,  256,   47,
   40,   31,   44,   45,  269,  269,   36,   37,   44,   44,
   45,  269,   44,   31,   19,   43,   41,   45,   43,   61,
   45,   26,  278,  279,  280,   41,   61,   43,   61,   45,
   41,   44,   43,   41,   45,   45,  256,   44,   41,  259,
   43,   61,   45,  258,  259,  256,   87,   61,  259,   44,
   44,   61,  256,  256,   44,  259,   86,   87,  261,  262,
   45,   41,  265,  266,  267,  268,  269,  125,  256,   41,
  258,  259,  275,   44,  117,  256,   61,  258,  269,   44,
   44,  127,  128,  125,  269,   45,   44,   44,  114,  115,
  226,  227,   44,  125,  132,  133,  125,  281,   45,   44,
   44,   61,  226,  227,  123,   46,   45,  269,  138,   44,
  125,   59,  269,  256,   61,  125,   59,  123,  125,   44,
  138,  256,  256,   45,  167,  256,  256,   44,  269,   58,
   45,  125,  275,  163,  252,  125,  123,  269,   44,   61,
  269,  269,  269,   44,  125,   41,   61,  125,  125,  256,
   44,  256,  182,  183,  125,   45,   44,   44,  259,  259,
  259,  191,  180,   45,  182,  183,  259,  262,   44,  275,
   44,   61,  259,   44,  125,   45,  125,   44,  125,   61,
    2,   45,   44,   40,  256,   62,  256,  256,  256,   45,
   90,  256,  191,   79,  256,   45,  256,  269,  256,  269,
  256,   45,  269,  125,  276,   61,  278,  279,  280,  276,
  125,  278,  279,  280,  256,  257,  256,  275,  260,  269,
  256,  256,  257,  259,  256,  260,   45,  269,  278,  279,
  280,  256,  274,  275,  269,  125,  278,  279,  280,  274,
  275,  274,   61,  278,  279,  280,  256,  257,  256,  256,
  260,  261,  262,  263,  274,  265,  266,  267,  268,  269,
  274,  256,  256,   45,  274,  275,  256,  123,  278,  279,
  280,  256,  257,   -1,   41,  260,  261,  262,  263,   61,
  265,  266,  267,  268,  269,  256,  266,  267,  268,  274,
  275,  256,  256,  278,  279,  280,  256,  257,  256,  256,
  260,  261,  262,  263,  256,  265,  266,  267,  268,  269,
  257,  256,  256,  260,  274,  275,  263,  256,  278,  279,
  280,  256,  269,   -1,   -1,   -1,   -1,  274,  275,   -1,
  269,  278,  279,  280,  256,  257,   -1,  276,  260,  278,
  279,  280,  257,   -1,   -1,  260,   -1,  269,  263,   43,
   -1,   45,  274,  275,  269,   -1,  278,  279,  280,  274,
  275,   15,   -1,  278,  279,  280,   60,  257,   62,   -1,
  260,   -1,   -1,  263,   28,  257,   -1,  125,  260,  269,
   -1,  263,   -1,   -1,  274,  275,  256,  269,  278,  279,
  280,   -1,  274,  275,   -1,   -1,  278,  279,  280,  269,
  256,  257,   -1,   -1,  260,  269,  256,  277,  278,  279,
  280,   -1,  276,  269,  278,  279,  280,   -1,  274,  269,
   -1,   -1,  278,  279,  280,  269,   -1,   -1,  278,  279,
  280,   -1,   -1,   -1,  278,  279,  280,  256,  257,   -1,
   -1,  260,   -1,   41,   42,   43,   44,   45,   -1,   47,
  269,   -1,   -1,   -1,   -1,  274,  275,   -1,   -1,  278,
  279,  280,   60,   41,   62,   43,   44,   45,   -1,   41,
   -1,   43,   44,   45,   -1,  257,   -1,   -1,  260,   -1,
    5,   -1,   60,   -1,   62,   -1,   -1,  269,   60,  256,
   62,   41,  274,   43,   44,   45,  278,  279,  280,  266,
  267,  268,   27,   -1,   29,   30,   -1,   -1,  256,  163,
   60,   -1,   62,  261,  262,   -1,   41,  265,  266,  267,
  268,  269,   -1,   -1,   -1,   50,   51,  275,   -1,   29,
   30,   -1,   -1,   -1,   30,   -1,   -1,  191,   -1,   -1,
   -1,   41,   -1,   -1,   -1,   41,   -1,  201,   -1,   -1,
   50,   51,   -1,   -1,   -1,   51,   -1,   -1,   -1,   -1,
   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,
   -1,  225,   -1,   -1,   -1,   -1,  270,  271,  272,  273,
   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,
   -1,   -1,   -1,   -1,   -1,  120,  121,   -1,   -1,   -1,
   -1,   -1,  127,  128,   -1,   -1,  131,  132,  133,  134,
   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,
  120,  121,   -1,   -1,  120,  121,  151,  127,  128,   -1,
   -1,  131,  132,  133,  134,  131,   -1,   -1,  134,   -1,
   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,
   -1,  151,   -1,   -1,   -1,   -1,   -1,   -1,  256,   -1,
   -1,  259,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,
   -1,   -1,  270,  271,  272,  273,   -1,   -1,  256,   -1,
   -1,  259,   -1,   -1,  256,   -1,   -1,  259,   -1,   -1,
   -1,   -1,  270,  271,  272,  273,   -1,   -1,  270,  271,
  272,  273,   -1,   -1,   -1,   -1,  256,   -1,   -1,  259,
   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,
  270,  271,  272,  273,
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
"Programa : '{' ListSentencias SentenciaDeclarativa '}'",
"Programa : error ListSentencias '}'",
"ListSentencias : ListSentencias Sentencia ','",
"ListSentencias : Sentencia ','",
"ListSentencias : Sentencia error",
"Sentencia : SentenciaControl",
"Sentencia : SentenciaEjecutable",
"Sentencia : RETURN ','",
"ReferenciaObjeto : ID '.' ID",
"ReferenciaObjetoFuncion : ID '.' LlamadoFuncion",
"SentenciaEjecutable : Asignacion",
"SentenciaEjecutable : LlamadoFuncion",
"SentenciaEjecutable : BloqueIF",
"SentenciaEjecutable : SalidaMensaje",
"SentenciaEjecutable : ReferenciaObjetoFuncion",
"ListSentenciasClase : ListSentenciasClase SentenciaDeclarativa ','",
"ListSentenciasClase : SentenciaDeclarativa ','",
"ListSentenciasClase : RETURN ','",
"ListSentenciasClase : ListSentenciasClase RETURN ','",
"SentenciaDeclarativa : Tipo ListVariables",
"SentenciaDeclarativa : ListFuncion",
"SentenciaDeclarativa : error ListVariables",
"SentenciaDeclarativa : Tipo error",
"SentenciaDeclarativa : Clase",
"SentenciaDeclarativa : Objeto_clase",
"SentenciaDeclarativa : FuncionIMPL",
"ListVariables : ID",
"ListVariables : ListVariables ';' ID",
"Objeto_clase : ID ListVariablesObj",
"ListVariablesObj : ID",
"ListVariablesObj : ListVariablesObj ';' ID",
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
"CuerpoIF : '{' SentenciasIF RETURN ',' '}'",
"CuerpoIF : '{' RETURN SentenciasIF ',' '}'",
"CuerpoIF : '{' SentenciasIF RETURN error '}'",
"CuerpoIF : error SentenciasIF '}'",
"CuerpoIF : '{' SentenciasIF error",
"CuerpoIF : '{' '}'",
"SentenciasIF : ListaSentenciasIF",
"SentenciasIF : RETURN ','",
"SentenciasIF : RETURN error",
"ListaSentenciasIF : error",
"ListaSentenciasIF : SentenciaEjecutable ','",
"ListaSentenciasIF : SentenciaEjecutable error",
"ListaSentenciasIF : ListaSentenciasIF SentenciaEjecutable ','",
"Comparador : '<'",
"Comparador : '>'",
"Comparador : MAYORIGUAL",
"Comparador : MENORIGUAL",
"Comparador : IGUAL",
"Comparador : DIST",
"ListFuncion : Funcion",
"ListFuncion : FuncionSinCuerpo",
"Funcion : EncabezadoFuncion Parametro '{' ListSentenciasFuncion '}' RETURN ','",
"Funcion : EncabezadoFuncion Parametro '{' ListSentenciasFuncion RETURN ',' '}'",
"Funcion : EncabezadoFuncion Parametro '{' ListSentenciasFuncion '}'",
"Funcion : VOID error Parametro '{' ListSentenciasFuncion '}'",
"Funcion : EncabezadoFuncion Parametro '{' '}'",
"EncabezadoFuncion : VOID ID",
"Parametro : '(' Tipo ID ')'",
"Parametro : '(' Tipo ID error",
"Parametro : error Tipo ID ')'",
"Parametro : '(' ')'",
"Parametro : '(' error",
"Parametro : error ')'",
"ListSentenciasFuncion : ListSentenciasFuncion Sentencia ','",
"ListSentenciasFuncion : Sentencia ','",
"ListSentenciasFuncion : SentenciaEjecutable error",
"ListSentenciasFuncion : SentenciaDeclarativa error",
"ListSentenciasFuncion : RETURN error",
"LlamadoFuncion : ID '(' ')'",
"LlamadoFuncion : ID error ')'",
"LlamadoFuncion : ID '(' error",
"LlamadoFuncion : ID '(' Expresion ')'",
"SalidaMensaje : PRINT CADENA",
"SalidaMensaje : PRINT Factor",
"SalidaMensaje : PRINT error",
"OperadorAsignacion : '='",
"OperadorAsignacion : ASIG",
"Asignacion : Factor OperadorAsignacion Expresion",
"Asignacion : ReferenciaObjeto OperadorAsignacion ReferenciaObjeto",
"Asignacion : ReferenciaObjeto OperadorAsignacion Factor",
"Asignacion : ReferenciaObjeto OperadorAsignacion error",
"Asignacion : Factor OperadorAsignacion error",
"Asignacion : OperadorAsignacion Factor",
"SentenciaControl : DO CuerpoIF UNTIL Condicion",
"SentenciaControl : DO CuerpoIF UNTIL error",
"ParametroTOD : '(' Expresion ')'",
"ParametroTOD : error Expresion ')'",
"ParametroTOD : '(' Expresion error",
"ConversionExplicita : TOD ParametroTOD",
"ConversionExplicita : TOD '(' ')'",
"ListClase : '{' ListSentenciasClase '}'",
"EncabezadoClase : CLASS ID",
"Clase : EncabezadoClase ListClase",
"FuncionSinCuerpo : EncabezadoFuncion Parametro",
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
#line 619 "gramatica.y"
  public NodoControl raiz;
  private String ambitoAct = "main";
  private String ambitoNuevo= "";
  static ArrayList<Error> erroresSemanticos = new ArrayList<Error>();
  static ArrayList<String> variables_declaradas = new ArrayList<String>();
  static String tipoActual;
  static ArrayList<Funcion> funciones_declaradas = new ArrayList<Funcion>();

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

   public void actualizarAmbito(String a){
        ambitoAct += ":"+a;
   }

   public void deshacerAmbito(){
           String aux = ambitoAct;
           char [] a = aux.toCharArray();
           int i = a.length;
           while ((i>0) && (!(a[i-1] == ':'))){
                i --;
           }
           if (i>0)
            aux = aux.substring(0,i-1);
           ambitoAct = aux;
   }

   public Token obtenerClase(String lexema) {
           Token t = TablaSimbolos.buscarPorAmbito(lexema);
           while (t == null) {
               int index = lexema.lastIndexOf(":");
               if (index != -1){
                    lexema = lexema.substring(0, lexema.lastIndexOf(":"));
               }
               t = TablaSimbolos.buscarPorAmbito(lexema);
           }
           String nombreClase = t.getTipo();
           return TablaSimbolos.buscarPorAmbito(nombreClase + ":" + ambitoAct);
   }

   public String getLexemaAlcance(String lexema){ //EN CASO DE QUE ESTE AL ALCANCE DEVUELVE EL LEXEMA CORRECTO, CASO CONTRARIO DEVUELVE EL NOMBRE DE LA VARIABLE SOLA
              if (!TablaSimbolos.existeSimbolo(lexema)){
                   char [] a = lexema.toCharArray();
                   for (int i = a.length;i>0;i--){
                      if(a[i-1] == ':'){
                          lexema = lexema.substring(0,i-1);
                      }
                      if (TablaSimbolos.existeSimbolo(lexema))
                        return lexema;
                   }
              }
              return lexema;
   }

   public boolean estaAlAlcance(String lexema){
        return getLexemaAlcance(lexema).contains("main");
   }

   public String tipoPredominante(String a, String b){
            if ((a.equals("DOUBLE"))|| (b.equals("DOUBLE"))){
                  return "DOUBLE";
            } else { if ((a.equals("INT"))|| (b.equals("INT"))) {
                        return "INT";
                    }
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
#line 676 "y.tab.c"
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
{   raiz = new NodoControl("PROGRAMA");
                                     raiz.setDer((Nodo)yyvsp[-2].obj);
                                    AnalizadorLexico.agregarEstructura("Reconoce programa ");}
break;
case 2:
#line 21 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se espera '{' ");}
break;
case 3:
#line 24 "gramatica.y"
{yyval.obj = new NodoComun("Sentencia", (Nodo) yyvsp[-2].obj, (Nodo) yyvsp[-1].obj);}
break;
case 4:
#line 25 "gramatica.y"
{yyval.obj=yyvsp[-1].obj;}
break;
case 5:
#line 26 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba una ',' al final de la linea ");}
break;
case 6:
#line 29 "gramatica.y"
{yyval.obj=yyvsp[0].obj;}
break;
case 7:
#line 30 "gramatica.y"
{yyval.obj=yyvsp[0].obj;}
break;
case 8:
#line 31 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("RETURN definido fuera de funcion ");}
break;
case 9:
#line 34 "gramatica.y"
{TablaSimbolos.removeToken(yyvsp[-2].sval);
                            TablaSimbolos.removeToken(yyvsp[0].sval);
                            yyval = new NodoComun("ReferenciaObjeto",new NodoHoja(yyvsp[-2].sval), new NodoHoja(yyvsp[0].sval));
                            Token clase = obtenerClase(yyvsp[-2].sval + ":" + ambitoAct);
                            if (clase == null) {
                                agregarErrorSemantico("El objeto " + yyvsp[-2].sval + " no existe");
                            }
                            else {
                                String nombreClase = clase.getLexema().substring(0, clase.getLexema().indexOf(":"));
                                String lexemaObjeto = yyvsp[0].sval + ":" + ambitoAct + ":"+ nombreClase;
                                Token atributo = TablaSimbolos.getToken(lexemaObjeto);
                                if (atributo == null){
                                    agregarErrorSemantico("Atributo de clase no existe");
                                }
                            }
                            AnalizadorLexico.agregarEstructura("Reconoce llamado a atributo");
                            }
break;
case 10:
#line 53 "gramatica.y"
{ /*chequear q exista y bla bla*/
                                                yyval = new NodoComun("ReferenciaFuncionObjeto",(Nodo)yyvsp[-2],(Nodo)yyvsp[0]);
                                                AnalizadorLexico.agregarEstructura("Reconoce llamado a funcion de clase ");}
break;
case 11:
#line 58 "gramatica.y"
{yyval.obj=yyvsp[0].obj;}
break;
case 12:
#line 59 "gramatica.y"
{yyval.obj=yyvsp[0].obj;}
break;
case 13:
#line 60 "gramatica.y"
{yyval.obj=yyvsp[0].obj;}
break;
case 14:
#line 61 "gramatica.y"
{yyval.obj=yyvsp[0].obj;}
break;
case 15:
#line 62 "gramatica.y"
{yyval.obj=yyvsp[0].obj;}
break;
case 18:
#line 67 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("RETURN definido fuera de funcion ");}
break;
case 19:
#line 68 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("RETURN definido fuera de funcion ");}
break;
case 20:
#line 71 "gramatica.y"
{
						/*CHEQUAER SI UNA VARIABLE CON ESE LEXEMA YA TIENE SETEADO EL USO, SI LO TIENE SETEADO ES PORQ YA EXITE*/
						for (String var : variables_declaradas) {
							Token t = TablaSimbolos.getToken(var);
							if (t != null){
							    t.setLexema(var + ":" + ambitoAct);
							    t.setAmbito(ambitoAct);
							    t.setUso("Variable");
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
case 22:
#line 90 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se espera el tipo de la variable ");}
break;
case 23:
#line 91 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se espera identificador de la variable ");}
break;
case 27:
#line 97 "gramatica.y"
{variables_declaradas.add(yyvsp[0].sval);}
break;
case 28:
#line 98 "gramatica.y"
{variables_declaradas.add(yyvsp[0].sval);}
break;
case 29:
#line 101 "gramatica.y"
{TablaSimbolos.removeToken(yyvsp[-1].sval);
                                    for (String var : variables_declaradas) {
                                    Token t = TablaSimbolos.getToken(var);
                                    if (t != null){
                                        t.setLexema(var + ":" + ambitoAct);
                                        t.setAmbito(ambitoAct);
                                        t.setUso("Objeto");
                                        t.setTipo(yyvsp[-1].sval);
                                        TablaSimbolos.removeToken(var);
                                        TablaSimbolos.addSimbolo(t.getLexema(),t);
                                    }
                                    else {
                                        agregarErrorSemantico("Ya existe un objeto + var + definido en este ambito");
                                    }
                                    }
                                    variables_declaradas.clear();}
break;
case 30:
#line 119 "gramatica.y"
{variables_declaradas.add(yyvsp[0].sval);}
break;
case 31:
#line 120 "gramatica.y"
{variables_declaradas.add(yyvsp[0].sval);}
break;
case 32:
#line 122 "gramatica.y"
{tipoActual = yyvsp[0].sval;}
break;
case 33:
#line 123 "gramatica.y"
{tipoActual = yyvsp[0].sval;}
break;
case 34:
#line 124 "gramatica.y"
{tipoActual = yyvsp[0].sval;}
break;
case 35:
#line 127 "gramatica.y"
{
                    chequearEnteroPositivo(yyvsp[0].sval);
                    NodoHoja aux = new NodoHoja(yyvsp[0].sval);
                    aux.setTipo("INT");
                    aux.setUso("Constante");
                    aux.setAmbito(ambitoAct);
                    yyval.obj = aux;
                    Token t = TablaSimbolos.getToken(yyvsp[0].sval);
                    t.setTipo("INT");
                    t.setUso("Constante");
                    t.setAmbito(ambitoAct);
                    TablaSimbolos.removeToken(yyvsp[0].sval);
                    TablaSimbolos.addSimbolo(yyvsp[0].sval,t);
                   }
break;
case 36:
#line 142 "gramatica.y"
{NodoHoja aux = new NodoHoja(yyvsp[0].sval);
	               chequearEnteroCorto(yyvsp[0].sval);
	               aux.setTipo("USHORT");
                   aux.setUso("Constante");
                   aux.setAmbito(ambitoAct);
                   yyval.obj = aux;
                   Token t = TablaSimbolos.getToken(yyvsp[0].sval);
                   if (t!=null) {
                    t.setTipo("USHORT");
                    t.setUso("Constante");
                    t.setAmbito(ambitoAct);
                    TablaSimbolos.removeToken(yyvsp[0].sval);
                    TablaSimbolos.addSimbolo(yyvsp[0].sval,t);
                   }
                   }
break;
case 37:
#line 157 "gramatica.y"
{AnalizadorLexico.agregarErrorLexico("Un entero corto no puede ser negativo ");}
break;
case 38:
#line 158 "gramatica.y"
{
	                chequearDouble(yyvsp[0].sval);
	                NodoHoja aux = new NodoHoja(yyvsp[0].sval);
                    aux.setTipo("DOUBLE");
                    aux.setUso("Constante");
                    aux.setAmbito(ambitoAct);
                    yyval.obj = aux;
	            Token t = TablaSimbolos.getToken(yyvsp[0].sval);
                    t.setTipo("DOUBLE");
                    t.setUso("Constante");
                    t.setAmbito(ambitoAct);
                    TablaSimbolos.removeToken(yyvsp[0].sval);
                    TablaSimbolos.addSimbolo(yyvsp[0].sval,t);
                    }
break;
case 39:
#line 173 "gramatica.y"
{
                    chequearEnteroNegativo(yyvsp[0].sval);
                    NodoHoja aux = new NodoHoja(yyvsp[-1].sval);
                    aux.setTipo("INT");
                    aux.setUso("Constante");
                    aux.setAmbito(ambitoAct);
                    yyval.obj = aux;
                    Token t = TablaSimbolos.getToken(yyvsp[-1].sval);
                    t.setTipo("INT");
                    t.setUso("Constante");
                    t.setAmbito(ambitoAct);
                    TablaSimbolos.removeToken(yyvsp[-1].sval);
                    TablaSimbolos.addSimbolo(yyvsp[-1].sval,t);
	                }
break;
case 40:
#line 187 "gramatica.y"
{chequearDouble(yyvsp[-1].sval);
                         NodoHoja aux = new NodoHoja(yyvsp[-1].sval);
                         aux.setTipo("DOUBLE");
                         aux.setUso("Constante");
                         aux.setAmbito(ambitoAct);
                         yyval.obj = aux;
                         Token t = TablaSimbolos.getToken(yyvsp[-1].sval);
                         t.setTipo("DOUBLE");
                         t.setUso("Constante");
                         t.setAmbito(ambitoAct);
                         TablaSimbolos.removeToken(yyvsp[-1].sval);
                         TablaSimbolos.addSimbolo(yyvsp[-1].sval,t);
                        }
break;
case 41:
#line 202 "gramatica.y"
{ yyval.obj = new NodoComun("+",(Nodo)yyvsp[-2].obj,(Nodo)yyvsp[0].obj);
                                if (((Nodo)yyvsp[-2]).getUso()!= "Constante"){
                                    if (!estaAlAlcance(((Nodo)yyvsp[-2]).getLexema())){
                                        agregarErrorSemantico("Primer termino fuera de alcance ");
                                        break;
                                    }
                                 }
                                if (((Nodo)yyvsp[0]).getUso()!= "Constante"){
                                   if (!estaAlAlcance(((Nodo)yyvsp[0]).getLexema())){
                                        agregarErrorSemantico("Segundo termino fuera de alcance ");
                                        break;
                                   }
                                }
                                if (((Nodo)yyvsp[-2]).getTipo().equals(((Nodo)yyvsp[0]).getTipo())){
                                    ((Nodo)yyval).setTipo(((Nodo)yyvsp[-2]).getTipo());
                                }
                                }
break;
case 42:
#line 219 "gramatica.y"
{yyval = new NodoComun("-",(Nodo)yyvsp[-2],(Nodo)yyvsp[0]);
                        if (((Nodo)yyvsp[-2]).getUso()!= "Constante"){
                            if (!estaAlAlcance(((Nodo)yyvsp[-2]).getLexema())){
                                agregarErrorSemantico("Primer termino fuera de alcance ");
                                break;
                            }
                        }
                        if (((Nodo)yyvsp[0]).getUso()!= "Constante"){
                            if (!estaAlAlcance(((Nodo)yyvsp[0]).getLexema())){
                                agregarErrorSemantico("Segundo termino fuera de alcance ");
                                break;
                            }
                        }
                        if (((Nodo)yyvsp[-2]).getTipo().equals(((Nodo)yyvsp[0]).getTipo())){
                            ((Nodo)yyval).setTipo(((Nodo)yyvsp[-2]).getTipo());
                        }
                      }
break;
case 43:
#line 236 "gramatica.y"
{yyval=yyvsp[0];}
break;
case 44:
#line 237 "gramatica.y"
{yyval = yyvsp[0];}
break;
case 45:
#line 241 "gramatica.y"
{yyval = new NodoComun("*",(Nodo)yyvsp[-2],(Nodo)yyvsp[0]);
                                if (((Nodo)yyvsp[-2]).getUso()!= "Constante"){
                                    if (!estaAlAlcance(((Nodo)yyvsp[-2]).getLexema())){
                                        agregarErrorSemantico("Primer termino fuera de alcance ");
                                        break;
                                    }
                                }
                                if (((Nodo)yyvsp[0]).getUso()!= "Constante"){
                                    if (!estaAlAlcance(((Nodo)yyvsp[0]).getLexema())){
                                        agregarErrorSemantico("Segundo termino fuera de alcance ");
                                        break;
                                    }
                                }
                                if (((Nodo)yyvsp[-2]).getTipo().equals(((Nodo)yyvsp[0]).getTipo())){
                                    ((Nodo)yyval).setTipo(((Nodo)yyvsp[-2]).getTipo());
                                }
                              }
break;
case 46:
#line 259 "gramatica.y"
{yyval = new NodoComun("/",(Nodo)yyvsp[-2],(Nodo)yyvsp[0]);
                        if (((Nodo)yyvsp[-2]).getUso()!= "Constante"){
                            if (!estaAlAlcance(((Nodo)yyvsp[-2]).getLexema())){
                                agregarErrorSemantico("Primer termino fuera de alcance ");
                                break;
                            }
                        }if (((Nodo)yyvsp[0]).getUso()!= "Constante"){
                            if (!estaAlAlcance(((Nodo)yyvsp[0]).getLexema())){
                                agregarErrorSemantico("Segundo termino fuera de alcance ");
                                break;
                            }
                        }
                        if (((Nodo)yyvsp[-2]).getTipo().equals(((Nodo)yyvsp[0]).getTipo())){
                            ((Nodo)yyval).setTipo(((Nodo)yyvsp[-2]).getTipo());
                        }
                    }
break;
case 47:
#line 275 "gramatica.y"
{yyval = yyvsp[0];}
break;
case 48:
#line 276 "gramatica.y"
{yyval = new NodoComun("*",(Nodo)yyvsp[-2],(Nodo)yyvsp[0]);
                               if (!((Nodo)yyvsp[-2]).getAmbito().equals(((Nodo)yyvsp[0]).getAmbito())){
                                    agregarErrorSemantico("Variable fuera de alcance ");
                               }
                                     ((Nodo)yyval).setTipo(tipoPredominante(((Nodo)yyvsp[-2]).getTipo(),((Nodo)yyvsp[0]).getTipo()));
                               }
break;
case 49:
#line 282 "gramatica.y"
{yyval = new NodoComun("/",(Nodo)yyvsp[-2],(Nodo)yyvsp[0]);
                               if (!((Nodo)yyvsp[-2]).getAmbito().equals(((Nodo)yyvsp[0]).getAmbito())){
                                    agregarErrorSemantico("Variable fuera de alcance ");
                               }
                                    ((Nodo)yyval).setTipo(tipoPredominante(((Nodo)yyvsp[-2]).getTipo(),((Nodo)yyvsp[0]).getTipo()));
                               }
break;
case 50:
#line 288 "gramatica.y"
{yyval=yyvsp[0];}
break;
case 51:
#line 291 "gramatica.y"
{yyval = new NodoHoja(yyvsp[0].sval);
            TablaSimbolos.removeToken(yyvsp[0].sval);
            String var = yyvsp[0].sval + ":" + ambitoAct;
            var = getLexemaAlcance(var);
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
case 52:
#line 309 "gramatica.y"
{yyval=yyvsp[0];}
break;
case 53:
#line 313 "gramatica.y"
{yyval=yyvsp[0];}
break;
case 54:
#line 316 "gramatica.y"
{ yyval = new NodoComun(yyvsp[-2].sval,(Nodo)yyvsp[-3],(Nodo)yyvsp[-1]);
                                                    ((Nodo)yyval).setTipo(((Nodo)yyvsp[-3]).getTipo());
                                                    ((Nodo)yyval).setUso("Condicion");
                                                    /*if (!(((Nodo)$2).getTipo().equals(((Nodo)$4).getTipo()))){*/
                                                         /*agregarErrorSemantico("Error en la comparacion entre expresiones de distintos tipos"); //CHEQUEAR CONVERSIONES*/
                                                     /*}*/
                                                     }
break;
case 55:
#line 323 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba una ')' ");}
break;
case 56:
#line 324 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba una '(' ");}
break;
case 57:
#line 327 "gramatica.y"
{  yyval = new NodoComun("CUERPO",(Nodo)yyvsp[-3],(Nodo)yyvsp[-1]);
                                                        Nodo aux = (Nodo)yyval;
                                                        yyval = new NodoComun("IF",(Nodo)yyvsp[-4],aux);
                                                        AnalizadorLexico.agregarEstructura("Reconoce IF ELSE");}
break;
case 58:
#line 331 "gramatica.y"
{yyval = new Nodo("CUERPO",(Nodo)yyvsp[-1],null);
	                                    Nodo aux = (Nodo)yyval;
	                                    yyval = new NodoComun("IF",(Nodo)yyvsp[-2],aux);
	                                    AnalizadorLexico.agregarEstructura("Reconoce IF");}
break;
case 59:
#line 335 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba un END_IF ");}
break;
case 60:
#line 336 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("IF mal definido ");}
break;
case 61:
#line 337 "gramatica.y"
{   yyval = new NodoComun("CUERPO",(Nodo)yyvsp[-4],(Nodo)yyvsp[-1]);
                                                                        Nodo aux = (Nodo)yyval;
                                                                        yyval = new NodoComun("IF",(Nodo)yyvsp[-5],aux);
                                                                        AnalizadorLexico.agregarEstructura("Reconoce IF ELSE");}
break;
case 62:
#line 341 "gramatica.y"
{yyval = new NodoComun("CUERPO",(Nodo)yyvsp[-5],(Nodo)yyvsp[-2]);
                                                                                    Nodo aux = (Nodo)yyval;
                                                                                    yyval = new NodoComun("IF",(Nodo)yyvsp[-6],aux);
                                                                                    AnalizadorLexico.agregarEstructura("Reconoce IF ELSE");}
break;
case 63:
#line 345 "gramatica.y"
{   yyval = new NodoComun("CUERPO",(Nodo)yyvsp[-4],(Nodo)yyvsp[-2]);
                                                                        Nodo aux = (Nodo)yyval;
                                                                        yyval = new NodoComun("IF",(Nodo)yyvsp[-5],aux);
                                                                        AnalizadorLexico.agregarEstructura("Reconoce IF ELSE");}
break;
case 64:
#line 349 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba un END_IF ");}
break;
case 65:
#line 350 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba un END_IF ");}
break;
case 66:
#line 351 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba un END_IF ");}
break;
case 67:
#line 352 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba un ELSE ");}
break;
case 68:
#line 353 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba un ELSE");}
break;
case 69:
#line 354 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba una ',' ");}
break;
case 70:
#line 355 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba una ',' " );}
break;
case 71:
#line 356 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba una ',' ");}
break;
case 72:
#line 359 "gramatica.y"
{yyval = yyvsp[-1];}
break;
case 74:
#line 361 "gramatica.y"
{AnalizadorLexico.addWarning("Las sentencias declaradas luego del RETURN no seran ejecutadas "); }
break;
case 75:
#line 362 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Falta una ',' "); }
break;
case 76:
#line 363 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Falta un '{'"); }
break;
case 77:
#line 364 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Falta un '}'"); }
break;
case 78:
#line 365 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("No hay sentencias dentro de las llaves."); }
break;
case 79:
#line 368 "gramatica.y"
{yyval=yyvsp[0];}
break;
case 80:
#line 369 "gramatica.y"
{yyval = new NodoHoja("RETURN");}
break;
case 81:
#line 370 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Falta una ',' "); }
break;
case 82:
#line 373 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Solo se aceptan sentencias ejecutables "); }
break;
case 83:
#line 374 "gramatica.y"
{yyval=yyvsp[-1];}
break;
case 84:
#line 375 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Falta una ',' "); }
break;
case 85:
#line 376 "gramatica.y"
{yyval = new NodoComun("SentenciaIF", (Nodo) yyvsp[-2], (Nodo) yyvsp[-1]);}
break;
case 86:
#line 379 "gramatica.y"
{yyval=yyvsp[0];}
break;
case 87:
#line 380 "gramatica.y"
{yyval=yyvsp[0];}
break;
case 88:
#line 381 "gramatica.y"
{yyval=yyvsp[0];}
break;
case 89:
#line 382 "gramatica.y"
{yyval=yyvsp[0];}
break;
case 90:
#line 383 "gramatica.y"
{yyval=yyvsp[0];}
break;
case 91:
#line 384 "gramatica.y"
{yyval=yyvsp[0];}
break;
case 94:
#line 391 "gramatica.y"
{agregarErrorSemantico("RETURN fuera de funcion");}
break;
case 95:
#line 392 "gramatica.y"
{  ((Nodo)yyvsp[-6]).setIzq((Nodo)yyvsp[-5]);
                                                                                ((Nodo)yyvsp[-6]).setDer((Nodo)yyvsp[-3]);
                                                                                deshacerAmbito();
                                                                                AnalizadorLexico.agregarEstructura("Reconoce declaracion de funcion ");}
break;
case 96:
#line 396 "gramatica.y"
{  ((Nodo)yyvsp[-4]).setIzq((Nodo)yyvsp[-3]);
                                                                                ((Nodo)yyvsp[-4]).setDer((Nodo)yyvsp[-1]);
                                                                                deshacerAmbito();
                                                                                AnalizadorLexico.agregarEstructura("Reconoce declaracion de funcion ");}
break;
case 97:
#line 400 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba un nombre para la funcion ");}
break;
case 98:
#line 401 "gramatica.y"
{AnalizadorLexico.addWarning("Función sin cuerpo ");
                                            deshacerAmbito();
                                            AnalizadorLexico.agregarEstructura("Reconoce declaracion de funcion ");}
break;
case 99:
#line 406 "gramatica.y"
{
			      Token t = TablaSimbolos.getToken(yyvsp[0].sval);
                              if (t != null){
                                    t.setLexema(yyvsp[0].sval + ":" + ambitoAct);
                                    t.setAmbito(ambitoAct);
                                    t.setUso("Funcion");
                                    t.setTipo("VOID");
                                    TablaSimbolos.removeToken(yyvsp[0].sval);
                                    TablaSimbolos.addSimbolo(t.getLexema(),t);
                              }
			      Funcion f = new Funcion(yyvsp[0].sval + ":" + ambitoAct, null);
			      funciones_declaradas.add(f);
			      actualizarAmbito(yyvsp[0].sval);
                              yyval = new NodoComun(yyvsp[0].sval,null,null);
                              }
break;
case 100:
#line 426 "gramatica.y"
{    Token t = TablaSimbolos.getToken(yyvsp[-1].sval);
                                if (t != null){
                                	t.setLexema(yyvsp[-1].sval + ":" + ambitoAct);
                                	t.setAmbito(ambitoAct);
                                	t.setUso("Parametro");
                                	t.setTipo(tipoActual);
                                	TablaSimbolos.removeToken(yyvsp[-1].sval);
                                	TablaSimbolos.addSimbolo(t.getLexema(),t);
                                }
                                funciones_declaradas.get(funciones_declaradas.size() - 1).setTipoParametro(yyvsp[-2].sval);
                                yyval = new NodoHoja(yyvsp[-1].sval);
                           }
break;
case 101:
#line 438 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba un ')' ");}
break;
case 102:
#line 439 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba un '(' ");}
break;
case 103:
#line 440 "gramatica.y"
{yyval = null;}
break;
case 104:
#line 441 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba un ')' ");}
break;
case 105:
#line 442 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba un '(' ");}
break;
case 106:
#line 448 "gramatica.y"
{yyval = new NodoComun("Sentencia",(Nodo)yyvsp[-2],(Nodo)yyvsp[-1]);}
break;
case 107:
#line 449 "gramatica.y"
{yyval=yyvsp[-1];}
break;
case 108:
#line 450 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba una ',' al final de la linea ");}
break;
case 109:
#line 451 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba una ',' al final de la linea ");}
break;
case 110:
#line 452 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba una ',' al final de la linea ");}
break;
case 111:
#line 455 "gramatica.y"
{yyval=new NodoHoja(yyvsp[-2].sval);
                            Token tokenFuncion = TablaSimbolos.buscarPorAmbito(yyvsp[-2].sval + ":" + ambitoAct);
                            Funcion funcion = new Funcion(tokenFuncion.getLexema(), null);
                            if (tokenFuncion == null){
                                agregarErrorSemantico("La funcion " + val_peek(3).sval + " nunca fue declarada");
                            } else {
                                if (funciones_declaradas.contains(funcion)) {
                                    int indice = funciones_declaradas.indexOf(funcion);
                                    Funcion f = funciones_declaradas.get(indice);
                                    if (f.getTipoParametro() != null){
                                        agregarErrorSemantico("Se esperaba un parametro en la función ");
                                    }
                                }
                            }
				            AnalizadorLexico.agregarEstructura("Reconoce llamado funcion ");
				            TablaSimbolos.removeToken(yyvsp[-2].sval);
				            }
break;
case 112:
#line 472 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba un '(' ");}
break;
case 113:
#line 473 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba un ')' ");}
break;
case 114:
#line 474 "gramatica.y"
{
            			    NodoHoja nodo1 = new NodoHoja(yyvsp[-3].sval);
            			    yyval=new NodoComun("Llamado Funcion", nodo1, (Nodo)yyvsp[-1]);
                                    Token tokenFuncion = TablaSimbolos.buscarPorAmbito(yyvsp[-3].sval + ":" + ambitoAct);

                                    Funcion funcion = new Funcion(tokenFuncion.getLexema(), null);
                                    if (tokenFuncion == null){
                                    	agregarErrorSemantico("La funcion " + val_peek(3).sval + " nunca fue declarada");
                                    } else {
                                    	if (funciones_declaradas.contains(funcion)) {
                                            int indice = funciones_declaradas.indexOf(funcion);
                                            Funcion f = funciones_declaradas.get(indice);
                                            if (!f.getTipoParametro().equals(((Nodo)yyvsp[-1]).getTipo()) && (((Nodo)yyvsp[-1]).getTipo() != null)){
                                                agregarErrorSemantico("No coinciden los tipos del parametro real y el formal. Se esperaba un " + f.getTipoParametro() + ", se obtuvo un " + ((Nodo)yyvsp[-1]).getTipo());
                                            }
                                        }
                                    }
                                    AnalizadorLexico.agregarEstructura("Reconoce llamado funcion ");
                                    TablaSimbolos.removeToken(yyvsp[-3].sval);
                                    }
break;
case 115:
#line 496 "gramatica.y"
{yyval = new NodoControl("PRINT", new NodoHoja(yyvsp[0].sval));
                             AnalizadorLexico.agregarEstructura("Reconoce salida de mensaje por pantalla ");}
break;
case 116:
#line 498 "gramatica.y"
{yyval = new NodoControl("PRINT", new NodoHoja(yyvsp[0].sval));
                            AnalizadorLexico.agregarEstructura("Reconoce salida de mensaje por pantalla ");}
break;
case 117:
#line 500 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("La funcion PRINT no acepta esa declaracion ");}
break;
case 118:
#line 503 "gramatica.y"
{yyval=yyvsp[0];}
break;
case 119:
#line 504 "gramatica.y"
{yyval=yyvsp[0];}
break;
case 120:
#line 507 "gramatica.y"
{AnalizadorLexico.agregarEstructura("Reconoce asignacion ");
						                        yyval = new NodoComun(yyvsp[-1].sval,(Nodo)yyvsp[-2],(Nodo)yyvsp[0]);
                                                String uso = ((Nodo)yyvsp[-2]).getLexema();
                                                if (!(uso.equals("Constante"))){
                                                String var = getLexemaAlcance(((Nodo)yyvsp[-2]).getLexema() + ":" + ambitoAct);
                                                    if (var.contains("main")){
                                                        Token t1 = TablaSimbolos.getToken(var);
                                                        if (t1 != null){
                                                                if (getLexemaAlcance(var).equals(((Nodo)yyvsp[-2]).getLexema())){
                                                                    agregarErrorSemantico("Variable " + ((Nodo)yyvsp[-2]).getLexema() +" fuera de alcance");
                                                                }
                                                        }
                                                    }
                                                    else {
                                                        agregarErrorSemantico("Variable " + ((Nodo)yyvsp[-2]).getLexema() + " no definida");
                                                    }
                                                }
                                                else {
                                                    agregarErrorSemantico("Las constantes no pueden estar del lado izquierdo en una asignacion");
					                            }
					                            }
break;
case 121:
#line 529 "gramatica.y"
{AnalizadorLexico.agregarEstructura("Reconoce asignacion ");
	                                                        yyval = new NodoComun(yyvsp[-1].sval,(Nodo)yyvsp[-2],(Nodo)yyvsp[0]);}
break;
case 122:
#line 532 "gramatica.y"
{AnalizadorLexico.agregarEstructura("Reconoce asignacion ");
	                                                yyval = new NodoComun(yyvsp[-1].sval,(Nodo)yyvsp[-2],(Nodo)yyvsp[0]);
	                                                String uso = ((Nodo)yyvsp[0]).getUso();
	                                                if (!(uso.equals("Constante"))){
                                                        String var = getLexemaAlcance(((Nodo)yyvsp[0]).getLexema() + ":" + ambitoAct);
                                                        if (var.contains("main")){
                                                            Token t1 = TablaSimbolos.getToken(var);
                                                            if (t1 != null){
                                                                if (getLexemaAlcance(var).equals(((Nodo)yyvsp[-2]).getLexema())){
                                                                        agregarErrorSemantico("Variable " + ((Nodo)yyvsp[-2]).getLexema() +" fuera de alcance");
                                                                    }
                                                            }
                                                        }
                                                        else {
                                                            agregarErrorSemantico("Variable " + ((Nodo)yyvsp[0]).getLexema() + " no definida");
                                                        }
                                                    }
	                                                }
break;
case 123:
#line 550 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba un valor seguido del operador ");}
break;
case 124:
#line 551 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba un valor seguido del operador ");}
break;
case 125:
#line 552 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba un operando del lado izquierdo ");}
break;
case 126:
#line 555 "gramatica.y"
{yyval=new NodoComun("DO UNTIL", (Nodo)yyvsp[-2] ,(Nodo)yyvsp[0]);
                                                        AnalizadorLexico.agregarEstructura("Reconoce funcion DO UNTIL");}
break;
case 127:
#line 557 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba una condicion ");}
break;
case 128:
#line 563 "gramatica.y"
{yyval = yyvsp[-1];}
break;
case 129:
#line 564 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba un '(' ");}
break;
case 130:
#line 565 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba un ')' ");}
break;
case 131:
#line 568 "gramatica.y"
{yyval = new NodoControl("TOD",(Nodo)yyvsp[0]);
                                            AnalizadorLexico.agregarEstructura("Reconoce funcion TOD ");
                                            }
break;
case 132:
#line 572 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba una Expresion ");}
break;
case 134:
#line 579 "gramatica.y"
{Token var = TablaSimbolos.getToken(yyvsp[0].sval + ":" + ambitoAct);
                            if (var != null) {
                                if (var.getUso().equals("Clase")) {
                                    agregarErrorSemantico("Clase " + yyvsp[0].sval + " ya definida en el ambito actual");
                                    break;
                                }
                                agregarErrorSemantico("Este identificador ya fue utilizado en este ambito");
                                break;
                            }
                            Token t = TablaSimbolos.getToken(yyvsp[0].sval);
                            if (t != null){
                                t.setLexema(t.getLexema() + ":" + ambitoAct);
                                t.setAmbito(ambitoAct);
                                t.setUso("Clase");
                                TablaSimbolos.removeToken(yyvsp[0].sval);
                                TablaSimbolos.addSimbolo(t.getLexema(),t);
                            }
                            actualizarAmbito(yyvsp[0].sval);
                            tipoActual = ambitoAct;
                            }
break;
case 135:
#line 600 "gramatica.y"
{deshacerAmbito();}
break;
case 136:
#line 603 "gramatica.y"
{AnalizadorLexico.agregarEstructura("Reconoce Funcion sin cuerpo");}
break;
case 137:
#line 607 "gramatica.y"
{AnalizadorLexico.agregarEstructura("Reconoce funcion IMPL"); TablaSimbolos.removeToken(yyvsp[-4].sval);}
break;
case 138:
#line 608 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba un '{' ");}
break;
case 139:
#line 609 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba un '}' ");}
break;
#line 1690 "y.tab.c"
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
