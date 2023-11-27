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
    4,    4,    4,    4,    4,   12,   12,   12,   12,    5,
    5,    5,    5,    5,    5,    5,   14,   14,   17,   19,
   19,   13,   13,   13,   20,   20,   20,   20,   20,   20,
   21,   21,   21,   21,   22,   22,   22,   22,   22,   22,
   24,   24,   25,   26,   26,   26,   10,   10,   10,   10,
   10,   10,   10,   10,   10,   10,   10,   10,   10,   10,
   10,   28,   28,   28,   28,   28,   28,   28,   29,   29,
   29,   30,   30,   30,   30,   27,   27,   27,   27,   27,
   27,   15,   15,   31,   31,   31,   33,   34,   34,   34,
   34,   34,   34,   35,   35,   35,   35,   35,   35,   35,
    8,    8,    8,    8,   11,   11,   11,   36,   36,    9,
    9,    9,    9,    9,    9,    3,    3,   37,   37,   37,
   38,   38,   38,   23,   23,   39,   40,   16,   32,   18,
   18,   18,
};
short yylen[] = {                                         2,
    3,    3,    3,    2,    1,    1,    1,    2,    3,    3,
    1,    1,    1,    1,    1,    3,    2,    2,    3,    2,
    1,    2,    2,    1,    1,    1,    1,    3,    2,    1,
    3,    1,    1,    1,    1,    1,    2,    1,    2,    2,
    3,    3,    1,    1,    3,    3,    1,    3,    3,    1,
    1,    1,    1,    5,    5,    5,    6,    4,    6,    4,
    7,    8,    7,    7,    7,    7,    7,    7,    7,    7,
    5,    3,    5,    5,    5,    3,    3,    2,    1,    2,
    2,    1,    2,    2,    3,    1,    1,    1,    1,    1,
    1,    1,    1,    7,    5,    6,    2,    4,    4,    4,
    2,    2,    2,    3,    2,    2,    3,    2,    2,    2,
    3,    3,    3,    4,    2,    2,    2,    1,    1,    3,
    3,    3,    3,    3,    2,    4,    4,    3,    3,    3,
    3,    3,    3,    2,    3,    3,    2,    2,    2,    7,
    7,    7,
};
short yydefred[] = {                                      0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
   33,   32,   34,    0,  119,    0,   35,   36,   38,    0,
  118,    0,    0,    5,    6,    7,    0,   15,   12,   11,
   13,   14,    0,   21,   24,   25,   26,   52,    0,   92,
   93,    0,    0,    0,    0,   27,    0,    0,    0,    0,
  117,   51,  115,  116,  137,    0,   97,    0,    0,    0,
    0,    0,   30,    0,    0,    0,    8,   39,   37,   40,
    2,    0,    4,    0,   23,    0,    0,    0,    0,    0,
  125,    0,  138,    1,    0,    0,    0,   53,    0,    0,
   44,   47,   50,    0,    0,    0,    0,    0,   82,    0,
    0,    0,    0,    0,   78,    0,    0,    0,  112,    0,
   10,  113,  111,    0,    0,    3,  123,  121,  122,  124,
    0,  103,    0,  102,  101,    0,    0,    0,    0,    0,
    0,   28,    0,    0,    0,  134,   90,   91,   89,   88,
    0,    0,   86,   87,    0,    0,    0,    0,    0,    0,
   60,    0,   58,    0,   81,   80,   84,   83,   76,    0,
    0,    0,   77,    0,   72,    0,  126,    0,  114,   31,
    0,    0,    0,    0,    0,    0,    0,   18,   17,    0,
  136,    0,    9,    0,  135,    0,    0,    0,    0,   45,
   48,   46,   49,    0,    0,   71,    0,    0,    0,    0,
    0,   85,    0,    0,    0,    0,    0,  100,   99,   98,
  110,    0,  105,  108,  109,    0,    0,    0,   19,   16,
  132,  133,  131,   56,   55,   54,    0,    0,    0,    0,
    0,    0,    0,   59,   57,   96,   74,   75,   73,    0,
    0,    0,    0,    0,  104,   69,   68,   67,   65,    0,
   64,   61,   70,   66,   63,  141,    0,  142,  140,   94,
   62,
};
short yydgoto[] = {                                       3,
   22,   23,   24,   25,   26,   27,   28,   29,   30,   31,
   32,  131,   33,   47,   34,   35,   36,   37,   66,   38,
   89,   90,   91,   39,   93,   50,  145,   60,  102,  103,
   40,   41,   42,   80,  177,   43,    0,  136,   83,   44,
};
short yysindex[] = {                                   -109,
  173,  173,    0, -246,  -37,  181, -240, -215,  -98, -224,
    0,    0,    0,  -39,    0,   38,    0,    0,    0, -153,
    0,   71,   44,    0,    0,    0,  -14,    0,    0,    0,
    0,    0, -213,    0,    0,    0,    0,    0,  -14,    0,
    0,  -32,   32,  -21,   96,    0,   56,  284,  284,  332,
    0,    0,    0,    0,    0,  -32,    0,  262,  255, -201,
 -157,   87,    0, -129,  -41,   84,    0,    0,    0,    0,
    0,   86,    0,  220,    0,   56,  187,   19,  331,   22,
    0,  371,    0,    0, -125,  100,  -29,    0,  483,    4,
    0,    0,    0,  483,  -34,  -42, -139,   30,    0,   28,
   34,   26,  299,   46,    0, -107,  -25,  108,    0,  -20,
    0,    0,    0,   21,  -99,    0,    0,    0,    0,    0,
   31,    0,  -97,    0,    0,  -96,  217,  -92,  136,  137,
 -106,    0,  -87,  284,  -36,    0,    0,    0,    0,    0,
  296,  296,    0,    0,  284,  296,  296,  284, -214, -169,
    0,  332,    0,  217,    0,    0,    0,    0,    0,  140,
    0,  141,    0,   35,    0,  284,    0,  -91,    0,    0,
  145,  -31,   41,  143,  -68,  -67,  122,    0,    0,  146,
    0,  153,    0,   58,    0,  -15,    4,    4,   68,    0,
    0,    0,    0,   -3,  -98,    0,  332,  332,   42, -204,
  147,    0,   75,   76,   77,  -71,  -71,    0,    0,    0,
    0,    0,    0,    0,    0,  155,  -70,  159,    0,    0,
    0,    0,    0,    0,    0,    0,  -53,  -50,  -49,   48,
 -191,  -48, -186,    0,    0,    0,    0,    0,    0,   88,
  -32, -104,    0,  168,    0,    0,    0,    0,    0,   83,
    0,    0,    0,    0,    0,    0,   22,    0,    0,    0,
    0,
};
short yyrindex[] = {                                      0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,  -13,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,   49,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,   53,    0,    0,    0,    0,
    0,    0,    0,    0,    0,   66,    0,    0,    0,   74,
    0,    0,    0,    0,    0,  461,    0,    0,    0,  507,
    0,    0,    0,    0,  -13,    0,    0,    0,    0,    0,
    0,    0,  -27,    0,    0,    0,    0,    0,    0,   -8,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
  110,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
   39,    0,    0,    0,    0,  172,    0,    0,    0,    0,
    0,    0,    0,    0,  176,  179,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,  540,  564,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,  -11,    0,    0,    0,    0,   17,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,   14,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,
};
short yygindex[] = {                                      0,
  257,   -6,    0,  -23,  -60,  595,    0,  271,    0,    0,
    0,    0,   27,  310,    0,    0,    0,    0,    0,    0,
   59,  -46,    0,  580,  -24,  240,  254,  -19,  -35,    0,
  -72,    0,  -69,  -43,  200,   10,    0,    0,    0,    0,
};
#define YYTABLESIZE 837
short yytable[] = {                                     113,
   65,  150,   49,   20,  185,   65,   64,   79,   20,  210,
  135,   64,   98,    2,   49,   72,   79,  165,  181,   65,
  259,  130,   46,  106,   59,  223,   96,  142,   55,  141,
   97,  207,    8,  106,  101,  101,   74,  226,   72,  142,
   56,  141,   75,  195,  196,  146,   21,   51,   77,  106,
  147,  234,    9,   57,  235,   46,   61,    8,  107,  122,
   95,  169,  107,  142,  251,  141,  176,  252,  162,  254,
  182,  156,  255,  142,  107,  141,   20,  158,  205,  160,
  101,   67,   82,   82,  212,  233,  197,   73,  198,  156,
   20,  250,   22,  176,  187,  188,   29,   79,  221,   82,
  142,   82,  141,  175,  123,  126,   21,   94,  224,   20,
  142,  108,  141,  106,   85,   20,  151,  139,  152,  153,
  174,  191,  193,  114,   68,   69,   70,  109,  199,  116,
  175,   21,  200,  240,  242,  121,  241,  241,  107,  110,
   20,   95,  115,  132,  127,  133,    1,  174,  163,    4,
  159,  258,  154,  120,    7,    8,   21,   58,   10,   11,
   12,   13,  128,   81,  206,  168,   20,  164,  180,  170,
  218,  171,  172,  228,  230,  227,   63,  229,  231,  178,
  179,  183,   21,  202,  203,  208,  213,  214,  215,  219,
    8,   20,  184,  186,  218,   71,  220,  257,  243,  237,
  238,  239,  245,  189,  244,  246,  194,   21,  247,  248,
  253,  260,  256,  149,  112,  127,   62,   20,   48,    6,
   84,   62,    7,   78,  209,   20,  134,   86,   79,   63,
  166,   20,   86,   21,   87,   62,   17,   18,   19,   87,
  222,   17,   18,   19,  106,  106,  217,   79,  106,  106,
  106,  106,  225,  106,  106,  106,  106,  106,   45,   15,
   51,   20,  106,  106,   20,    9,  106,  106,  106,  107,
  107,  236,   95,  107,  107,  107,  107,   21,  107,  107,
  107,  107,  107,  155,   11,   12,   13,  107,  107,  157,
  204,  107,  107,  107,   81,   82,  211,  232,   82,   20,
   52,  161,    5,  249,   22,    6,   20,   82,   29,   17,
   18,   19,   82,   81,   95,   21,   82,   82,   82,   15,
  100,   20,   21,   17,   18,   19,    4,    5,   20,  139,
    6,    7,    8,    9,  111,   10,   11,   12,   13,   14,
   20,  261,   76,   20,   15,   16,  167,  148,   17,   18,
   19,    4,    5,  201,    0,    6,    7,    8,    9,   21,
   10,   11,   12,   13,   14,  120,    0,    0,  120,   15,
   16,  125,    0,   17,   18,   19,   20,    4,    5,  105,
    0,    6,    7,    8,    9,    0,   10,   11,   12,   13,
   14,    0,   21,    0,    0,   15,  216,    0,    0,   17,
   18,   19,    4,    5,    0,    0,    6,    7,    8,    9,
    0,   10,   11,   12,   13,   14,    0,    0,    0,    0,
   15,  216,    0,    0,   17,   18,   19,    0,    4,    5,
    0,    0,    6,    7,    8,    9,   51,   10,   11,   12,
   13,   14,  120,    0,    0,    0,   15,   16,    0,   52,
   17,   18,   19,    0,   59,   86,    0,   53,   17,   18,
   19,    0,   87,    0,   17,   18,   19,    0,    0,    0,
    0,    0,    4,    5,    0,  117,    6,    7,    8,    9,
    0,   10,   11,   12,   13,   14,    0,    0,   86,    0,
   15,  173,    0,    0,   17,   18,   19,   17,   18,   19,
    0,   51,   51,   51,   51,   51,    0,   51,    0,    0,
   99,    5,    0,    0,    6,    0,    0,   99,    5,    0,
   51,    6,   51,   95,    0,  142,    0,  141,   15,  104,
   95,    0,   17,   18,   19,   15,  100,    0,    0,   17,
   18,   19,  143,    0,  144,    0,    0,   43,    0,   43,
   43,   43,   86,    0,    0,    5,    0,    0,    6,   87,
    0,   17,   18,   19,   86,    0,   43,   95,   43,    0,
    0,    0,   15,   17,   18,   19,   17,   18,   19,    0,
   42,    0,   42,   42,   42,   54,  124,   58,    5,    0,
    0,    6,    0,    0,    0,    0,   11,   12,   13,   42,
   95,   42,    0,    0,   41,   15,   41,   41,   41,   17,
   18,   19,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,   81,   41,    0,   41,    4,   92,   92,    0,
    0,    7,    8,    0,    0,   10,   11,   12,   13,  128,
    0,    0,   88,   88,   92,  129,    0,    0,    0,    0,
    0,    0,    0,  119,    0,    0,   92,    0,    0,   88,
    0,    0,    0,    0,    0,    0,    0,    0,  118,    0,
    0,   88,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,   92,   92,    0,   51,    0,    0,   51,
   92,   92,    0,    0,   92,  190,  192,   92,   88,   88,
   51,   51,   51,   51,    0,   88,   88,    0,    0,   88,
   88,   88,   88,    0,    0,   92,    0,    0,    0,    0,
    0,    0,  137,  138,  139,  140,    0,    0,    0,    0,
   88,    0,   43,    0,    0,   43,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,   43,   43,   43,   43,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,   42,    0,    0,   42,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,   42,
   42,   42,   42,    0,    0,    0,    0,    0,    0,   41,
    0,    0,   41,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,   41,   41,   41,   41,
};
short yycheck[] = {                                      41,
   40,   44,   40,   45,   41,   40,   46,   40,   45,   41,
   40,   46,   56,  123,   40,   22,   44,  125,  125,   40,
  125,   82,  269,   59,  123,   41,   50,   43,  269,   45,
   50,  123,   44,   45,   58,   59,   27,   41,   45,   43,
  256,   45,  256,  258,  259,   42,   61,   61,   39,   61,
   47,  256,   61,  269,  259,  269,  281,   44,   45,   41,
   44,   41,  264,   43,  256,   45,  127,  259,  104,  256,
  131,   44,  259,   43,   61,   45,   45,   44,   44,  103,
  104,   44,   44,   45,   44,   44,  256,   44,  258,   44,
   45,   44,   44,  154,  141,  142,   44,  125,   41,   61,
   43,  123,   45,  127,   78,   79,   61,   49,   41,   44,
   43,  269,   45,  125,   59,   45,  256,   44,  258,  259,
  127,  146,  147,   65,  278,  279,  280,   41,  152,   44,
  154,   61,  152,  206,  207,   77,  206,  207,  125,  269,
   45,  125,   59,  269,  123,   46,  256,  154,  256,  256,
  125,  256,  123,   44,  261,  262,   61,  256,  265,  266,
  267,  268,  269,  125,  256,   58,   45,  275,  275,  269,
  177,  269,  269,  197,  198,  195,  269,  197,  198,   44,
   44,  269,   61,   44,   44,   41,   44,  256,  256,   44,
  262,   45,  134,  135,  201,  125,   44,  241,   44,  125,
  125,  125,   44,  145,  275,  259,  148,   61,  259,  259,
  259,   44,  125,  256,  256,   44,  256,   45,  256,   44,
  125,  256,   44,  256,  256,   45,  256,  269,  256,  269,
  256,   45,  269,   61,  276,  256,  278,  279,  280,  276,
  256,  278,  279,  280,  256,  257,  125,  275,  260,  261,
  262,  263,  256,  265,  266,  267,  268,  269,    2,  274,
  274,   45,  274,  275,   45,  274,  278,  279,  280,  256,
  257,  125,  256,  260,  261,  262,  263,   61,  265,  266,
  267,  268,  269,  256,  266,  267,  268,  274,  275,  256,
  256,  278,  279,  280,  256,  257,  256,  256,  260,   45,
  269,  256,  257,  256,  256,  260,   45,  269,  256,  278,
  279,  280,  274,  275,  269,   61,  278,  279,  280,  274,
  275,  256,   61,  278,  279,  280,  256,  257,   45,  256,
  260,  261,  262,  263,   64,  265,  266,  267,  268,  269,
   45,  259,   33,   45,  274,  275,  107,   94,  278,  279,
  280,  256,  257,  154,   -1,  260,  261,  262,  263,   61,
  265,  266,  267,  268,  269,  256,   -1,   -1,  259,  274,
  275,   41,   -1,  278,  279,  280,   45,  256,  257,  125,
   -1,  260,  261,  262,  263,   -1,  265,  266,  267,  268,
  269,   -1,   61,   -1,   -1,  274,  275,   -1,   -1,  278,
  279,  280,  256,  257,   -1,   -1,  260,  261,  262,  263,
   -1,  265,  266,  267,  268,  269,   -1,   -1,   -1,   -1,
  274,  275,   -1,   -1,  278,  279,  280,   -1,  256,  257,
   -1,   -1,  260,  261,  262,  263,  256,  265,  266,  267,
  268,  269,  256,   -1,   -1,   -1,  274,  275,   -1,  269,
  278,  279,  280,   -1,  123,  269,   -1,  277,  278,  279,
  280,   -1,  276,   -1,  278,  279,  280,   -1,   -1,   -1,
   -1,   -1,  256,  257,   -1,  256,  260,  261,  262,  263,
   -1,  265,  266,  267,  268,  269,   -1,   -1,  269,   -1,
  274,  275,   -1,   -1,  278,  279,  280,  278,  279,  280,
   -1,   41,   42,   43,   44,   45,   -1,   47,   -1,   -1,
  256,  257,   -1,   -1,  260,   -1,   -1,  256,  257,   -1,
   60,  260,   62,  269,   -1,   43,   -1,   45,  274,  275,
  269,   -1,  278,  279,  280,  274,  275,   -1,   -1,  278,
  279,  280,   60,   -1,   62,   -1,   -1,   41,   -1,   43,
   44,   45,  269,   -1,   -1,  257,   -1,   -1,  260,  276,
   -1,  278,  279,  280,  269,   -1,   60,  269,   62,   -1,
   -1,   -1,  274,  278,  279,  280,  278,  279,  280,   -1,
   41,   -1,   43,   44,   45,    6,  256,  256,  257,   -1,
   -1,  260,   -1,   -1,   -1,   -1,  266,  267,  268,   60,
  269,   62,   -1,   -1,   41,  274,   43,   44,   45,  278,
  279,  280,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,
   -1,   -1,   43,   60,   -1,   62,  256,   48,   49,   -1,
   -1,  261,  262,   -1,   -1,  265,  266,  267,  268,  269,
   -1,   -1,   48,   49,   65,  275,   -1,   -1,   -1,   -1,
   -1,   -1,   -1,   74,   -1,   -1,   77,   -1,   -1,   65,
   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   74,   -1,
   -1,   77,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,
   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,
   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,
   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,
   -1,   -1,   -1,  134,  135,   -1,  256,   -1,   -1,  259,
  141,  142,   -1,   -1,  145,  146,  147,  148,  134,  135,
  270,  271,  272,  273,   -1,  141,  142,   -1,   -1,  145,
  146,  147,  148,   -1,   -1,  166,   -1,   -1,   -1,   -1,
   -1,   -1,  270,  271,  272,  273,   -1,   -1,   -1,   -1,
  166,   -1,  256,   -1,   -1,  259,   -1,   -1,   -1,   -1,
   -1,   -1,   -1,   -1,   -1,   -1,  270,  271,  272,  273,
   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,
   -1,   -1,   -1,   -1,   -1,  256,   -1,   -1,  259,   -1,
   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,  270,
  271,  272,  273,   -1,   -1,   -1,   -1,   -1,   -1,  256,
   -1,   -1,  259,   -1,   -1,   -1,   -1,   -1,   -1,   -1,
   -1,   -1,   -1,  270,  271,  272,  273,
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
"ListSentencias : ListSentencias Sentencia ','",
"ListSentencias : Sentencia ','",
"Sentencia : SentenciaControl",
"Sentencia : SentenciaEjecutable",
"Sentencia : SentenciaDeclarativa",
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
"Funcion : EncabezadoFuncion Parametro '{' ListSentenciasFuncion '}'",
"Funcion : VOID error Parametro '{' ListSentenciasFuncion '}'",
"EncabezadoFuncion : VOID ID",
"Parametro : '(' Tipo ID ')'",
"Parametro : '(' Tipo ID error",
"Parametro : error Tipo ID ')'",
"Parametro : '(' ')'",
"Parametro : '(' error",
"Parametro : error ')'",
"ListSentenciasFuncion : ListSentenciasFuncion Sentencia ','",
"ListSentenciasFuncion : Sentencia ','",
"ListSentenciasFuncion : RETURN ','",
"ListSentenciasFuncion : ListSentenciasFuncion RETURN ','",
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
"LlamadoExpresion : '(' Expresion ')'",
"LlamadoExpresion : error Expresion ')'",
"LlamadoExpresion : '(' Expresion error",
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
#line 595 "gramatica.y"
  private NodoControl raiz;
  private String ambitoAct = "main";
  private String ambitoNuevo= "";
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
#line 696 "y.tab.c"
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
{yyval = new NodoComun("Sentencia", (Nodo) yyvsp[-2], (Nodo) yyvsp[-1]);}
break;
case 4:
#line 23 "gramatica.y"
{yyval=yyvsp[-1];}
break;
case 5:
#line 27 "gramatica.y"
{yyval = yyvsp[0];}
break;
case 6:
#line 28 "gramatica.y"
{yyval = yyvsp[0];}
break;
case 7:
#line 29 "gramatica.y"
{yyval = new NodoHoja("sentencia declarativa");}
break;
case 8:
#line 30 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("RETURN definido fuera de funcion ");}
break;
case 9:
#line 33 "gramatica.y"
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
#line 52 "gramatica.y"
{ /*chequear q exista y bla bla*/
                                                yyval = new NodoComun("ReferenciaFuncionObjeto",(Nodo)yyvsp[-2],(Nodo)yyvsp[0]);
                                                AnalizadorLexico.agregarEstructura("Reconoce llamado a funcion de clase ");}
break;
case 11:
#line 57 "gramatica.y"
{yyval=yyvsp[0];}
break;
case 12:
#line 58 "gramatica.y"
{yyval=yyvsp[0];}
break;
case 13:
#line 59 "gramatica.y"
{yyval=yyvsp[0];}
break;
case 14:
#line 60 "gramatica.y"
{yyval=yyvsp[0];}
break;
case 15:
#line 61 "gramatica.y"
{yyval=yyvsp[0];}
break;
case 18:
#line 66 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("RETURN definido fuera de funcion ");}
break;
case 19:
#line 67 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("RETURN definido fuera de funcion ");}
break;
case 20:
#line 70 "gramatica.y"
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
#line 89 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se espera el tipo de la variable ");}
break;
case 23:
#line 90 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se espera identificador de la variable ");}
break;
case 27:
#line 96 "gramatica.y"
{variables_declaradas.add(yyvsp[0].sval);}
break;
case 28:
#line 97 "gramatica.y"
{yyval = yyvsp[-2] ; variables_declaradas.add(yyvsp[0].sval);}
break;
case 29:
#line 100 "gramatica.y"
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
#line 118 "gramatica.y"
{variables_declaradas.add(yyvsp[0].sval);}
break;
case 31:
#line 119 "gramatica.y"
{yyval = yyvsp[-2] ; variables_declaradas.add(yyvsp[0].sval);}
break;
case 32:
#line 121 "gramatica.y"
{tipoActual = yyvsp[0].sval;}
break;
case 33:
#line 122 "gramatica.y"
{tipoActual = yyvsp[0].sval;}
break;
case 34:
#line 123 "gramatica.y"
{tipoActual = yyvsp[0].sval;}
break;
case 35:
#line 126 "gramatica.y"
{
                    chequearEnteroPositivo(yyvsp[0].sval);
                    yyval = new NodoHoja(yyvsp[0].sval);
                    ((Nodo)yyval).setTipo("INT");
                    ((Nodo)yyval).setUso("Constante");
                    ((Nodo)yyval).setAmbito(ambitoAct);
                    Token t = TablaSimbolos.getToken(yyvsp[0].sval);
                    t.setTipo("INT");
                    t.setUso("Constante");
                    t.setAmbito(ambitoAct);
                    TablaSimbolos.removeToken(yyvsp[0].sval);
                    TablaSimbolos.addSimbolo(yyvsp[0].sval,t);
                   }
break;
case 36:
#line 140 "gramatica.y"
{yyval = new NodoHoja(yyvsp[0].sval);
	               chequearEnteroCorto(yyvsp[0].sval);
	               ((Nodo)yyval).setTipo("USHORT");
                   chequearEnteroPositivo(yyvsp[0].sval);
                   ((Nodo)yyval).setUso("Constante");
                   ((Nodo)yyval).setAmbito(ambitoAct);
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
#line 155 "gramatica.y"
{AnalizadorLexico.agregarErrorLexico("Un entero corto no puede ser negativo ");}
break;
case 38:
#line 156 "gramatica.y"
{
	                chequearDouble(yyvsp[0].sval);
	                yyval = new NodoHoja(yyvsp[0].sval);
                    ((Nodo)yyval).setTipo("DOUBLE");
                    ((Nodo)yyval).setUso("Constante");
                    ((Nodo)yyval).setAmbito(ambitoAct);
	            Token t = TablaSimbolos.getToken(yyvsp[0].sval);
                    t.setTipo("DOUBLE");
                    t.setUso("Constante");
                    t.setAmbito(ambitoAct);
                    TablaSimbolos.removeToken(yyvsp[0].sval);
                    TablaSimbolos.addSimbolo(yyvsp[0].sval,t);
                    }
break;
case 39:
#line 170 "gramatica.y"
{
                    yyval = new NodoHoja(yyvsp[-1].sval);
                    chequearEnteroNegativo(yyvsp[0].sval);
                    ((Nodo)yyval).setTipo("INT");
                    ((Nodo)yyval).setUso("Constante");
                    ((Nodo)yyval).setAmbito(ambitoAct);
                    Token t = TablaSimbolos.getToken(yyvsp[-1].sval);
                    t.setTipo("INT");
                    t.setUso("Constante");
                    t.setAmbito(ambitoAct);
                    TablaSimbolos.removeToken(yyvsp[-1].sval);
                    TablaSimbolos.addSimbolo(yyvsp[-1].sval,t);
	                }
break;
case 40:
#line 183 "gramatica.y"
{chequearDouble(yyvsp[-1].sval);
                         yyval = new NodoHoja(yyvsp[-1].sval);
                         ((Nodo)yyval).setTipo("DOUBLE");
                         ((Nodo)yyval).setUso("Constante");
                         ((Nodo)yyval).setAmbito(ambitoAct);
                         Token t = TablaSimbolos.getToken(yyvsp[-1].sval);
                         t.setTipo("DOUBLE");
                         t.setUso("Constante");
                         t.setAmbito(ambitoAct);
                         TablaSimbolos.removeToken(yyvsp[-1].sval);
                         TablaSimbolos.addSimbolo(yyvsp[-1].sval,t);
                        }
break;
case 41:
#line 197 "gramatica.y"
{ yyval = new NodoComun("+",(Nodo)yyvsp[-2],(Nodo)yyvsp[0]);
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
#line 214 "gramatica.y"
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
#line 231 "gramatica.y"
{yyval=yyvsp[0];}
break;
case 44:
#line 232 "gramatica.y"
{yyval = yyvsp[0];}
break;
case 45:
#line 236 "gramatica.y"
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
#line 254 "gramatica.y"
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
#line 270 "gramatica.y"
{yyval = yyvsp[0];}
break;
case 48:
#line 271 "gramatica.y"
{yyval = new NodoComun("*",(Nodo)yyvsp[-2],(Nodo)yyvsp[0]);
                               if (!((Nodo)yyvsp[-2]).getAmbito().equals(((Nodo)yyvsp[0]).getAmbito())){
                                    agregarErrorSemantico("Variable fuera de alcance ");
                               }
                                     ((Nodo)yyval).setTipo(tipoPredominante(((Nodo)yyvsp[-2]).getTipo(),((Nodo)yyvsp[0]).getTipo()));
                               }
break;
case 49:
#line 277 "gramatica.y"
{yyval = new NodoComun("/",(Nodo)yyvsp[-2],(Nodo)yyvsp[0]);
                               if (!((Nodo)yyvsp[-2]).getAmbito().equals(((Nodo)yyvsp[0]).getAmbito())){
                                    agregarErrorSemantico("Variable fuera de alcance ");
                               }
                                    ((Nodo)yyval).setTipo(tipoPredominante(((Nodo)yyvsp[-2]).getTipo(),((Nodo)yyvsp[0]).getTipo()));
                               }
break;
case 50:
#line 283 "gramatica.y"
{yyval=yyvsp[0];}
break;
case 51:
#line 286 "gramatica.y"
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
#line 304 "gramatica.y"
{yyval=yyvsp[0];}
break;
case 53:
#line 308 "gramatica.y"
{yyval=yyvsp[0];}
break;
case 54:
#line 311 "gramatica.y"
{ yyval = new NodoComun(yyvsp[-2].sval,(Nodo)yyvsp[-3],(Nodo)yyvsp[-1]);
                                                    ((Nodo)yyval).setTipo(((Nodo)yyvsp[-3]).getTipo());
                                                    ((Nodo)yyval).setUso("Condicion");
                                                    /*if (!(((Nodo)$2).getTipo().equals(((Nodo)$4).getTipo()))){*/
                                                         /*agregarErrorSemantico("Error en la comparacion entre expresiones de distintos tipos"); //CHEQUEAR CONVERSIONES*/
                                                     /*}*/
                                                     }
break;
case 55:
#line 318 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba una ')' ");}
break;
case 56:
#line 319 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba una '(' ");}
break;
case 57:
#line 322 "gramatica.y"
{  yyval = new NodoComun("CUERPO",(Nodo)yyvsp[-3],(Nodo)yyvsp[-1]);
                                                        Nodo aux = (Nodo)yyval;
                                                        yyval = new NodoComun("IF",(Nodo)yyvsp[-4],aux);
                                                        AnalizadorLexico.agregarEstructura("Reconoce IF ELSE");}
break;
case 58:
#line 326 "gramatica.y"
{yyval = new Nodo("CUERPO",(Nodo)yyvsp[-1],null);
	                                    Nodo aux = (Nodo)yyval;
	                                    yyval = new NodoComun("IF",(Nodo)yyvsp[-2],aux);
	                                    AnalizadorLexico.agregarEstructura("Reconoce IF");}
break;
case 59:
#line 330 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba un END_IF ");}
break;
case 60:
#line 331 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("IF mal definido ");}
break;
case 61:
#line 332 "gramatica.y"
{   yyval = new NodoComun("CUERPO",(Nodo)yyvsp[-4],(Nodo)yyvsp[-1]);
                                                                        Nodo aux = (Nodo)yyval;
                                                                        yyval = new NodoComun("IF",(Nodo)yyvsp[-5],aux);
                                                                        AnalizadorLexico.agregarEstructura("Reconoce IF ELSE");}
break;
case 62:
#line 336 "gramatica.y"
{yyval = new NodoComun("CUERPO",(Nodo)yyvsp[-5],(Nodo)yyvsp[-2]);
                                                                                    Nodo aux = (Nodo)yyval;
                                                                                    yyval = new NodoComun("IF",(Nodo)yyvsp[-6],aux);
                                                                                    AnalizadorLexico.agregarEstructura("Reconoce IF ELSE");}
break;
case 63:
#line 340 "gramatica.y"
{   yyval = new NodoComun("CUERPO",(Nodo)yyvsp[-4],(Nodo)yyvsp[-2]);
                                                                        Nodo aux = (Nodo)yyval;
                                                                        yyval = new NodoComun("IF",(Nodo)yyvsp[-5],aux);
                                                                        AnalizadorLexico.agregarEstructura("Reconoce IF ELSE");}
break;
case 64:
#line 344 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba un END_IF ");}
break;
case 65:
#line 345 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba un END_IF ");}
break;
case 66:
#line 346 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba un END_IF ");}
break;
case 67:
#line 347 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba un ELSE ");}
break;
case 68:
#line 348 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba un ELSE");}
break;
case 69:
#line 349 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba una ',' ");}
break;
case 70:
#line 350 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba una ',' " );}
break;
case 71:
#line 351 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba una ',' ");}
break;
case 72:
#line 354 "gramatica.y"
{yyval = yyvsp[-1];}
break;
case 74:
#line 356 "gramatica.y"
{AnalizadorLexico.addWarning("Las sentencias declaradas luego del RETURN no seran ejecutadas "); }
break;
case 75:
#line 357 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Falta una ',' "); }
break;
case 76:
#line 358 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Falta un '{'"); }
break;
case 77:
#line 359 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Falta un '}'"); }
break;
case 78:
#line 360 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("No hay sentencias dentro de las llaves."); }
break;
case 79:
#line 363 "gramatica.y"
{yyval=yyvsp[0];}
break;
case 80:
#line 364 "gramatica.y"
{yyval = new NodoHoja("RETURN");}
break;
case 81:
#line 365 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Falta una ',' "); }
break;
case 82:
#line 368 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Solo se aceptan sentencias ejecutables "); }
break;
case 83:
#line 369 "gramatica.y"
{yyval=yyvsp[-1];}
break;
case 84:
#line 370 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Falta una ',' "); }
break;
case 85:
#line 371 "gramatica.y"
{yyval = new NodoComun("SentenciaIF", (Nodo) yyvsp[-2], (Nodo) yyvsp[-1]);}
break;
case 86:
#line 374 "gramatica.y"
{yyval=yyvsp[0];}
break;
case 87:
#line 375 "gramatica.y"
{yyval=yyvsp[0];}
break;
case 88:
#line 376 "gramatica.y"
{yyval=yyvsp[0];}
break;
case 89:
#line 377 "gramatica.y"
{yyval=yyvsp[0];}
break;
case 90:
#line 378 "gramatica.y"
{yyval=yyvsp[0];}
break;
case 91:
#line 379 "gramatica.y"
{yyval=yyvsp[0];}
break;
case 94:
#line 386 "gramatica.y"
{agregarErrorSemantico("RETURN fuera de funcion");}
break;
case 95:
#line 387 "gramatica.y"
{((Nodo)yyvsp[-4]).setIzq((Nodo)yyvsp[-3]);
                                                                    ((Nodo)yyvsp[-4]).setDer((Nodo)yyvsp[-1]);
                                                                    deshacerAmbito();
                                                                    AnalizadorLexico.agregarEstructura("Reconoce declaracion de funcion ");}
break;
case 96:
#line 391 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba un nombre para la funcion ");}
break;
case 97:
#line 394 "gramatica.y"
{actualizarAmbito(yyvsp[0].sval);
			      Token t = TablaSimbolos.getToken(yyvsp[0].sval);
                              if (t != null){
                                    t.setLexema(yyvsp[0].sval + ":" + ambitoAct);
                                    t.setAmbito(ambitoAct);
                                    t.setUso("Funcion");
                                    t.setTipo("VOID");
                                    TablaSimbolos.removeToken(yyvsp[0].sval);
                                    TablaSimbolos.addSimbolo(t.getLexema(),t);
                              }
                              yyval = new NodoComun(yyvsp[0].sval,null,null);
                              }
break;
case 98:
#line 411 "gramatica.y"
{    Token t = TablaSimbolos.getToken(yyvsp[-1].sval);
                                if (t != null){
                                	t.setLexema(yyvsp[-1].sval + ":" + ambitoAct);
                                	t.setAmbito(ambitoAct);
                                	t.setUso("Parametro");
                                	t.setTipo(tipoActual);
                                	TablaSimbolos.removeToken(yyvsp[-1].sval);
                                	TablaSimbolos.addSimbolo(t.getLexema(),t);
                                }
                                yyval = new NodoHoja(yyvsp[-1].sval);
                           }
break;
case 99:
#line 422 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba un ')' ");}
break;
case 100:
#line 423 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba un '(' ");}
break;
case 102:
#line 425 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba un ')' ");}
break;
case 103:
#line 426 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba un '(' ");}
break;
case 104:
#line 432 "gramatica.y"
{yyval = new NodoComun("Sentencia",(Nodo)yyvsp[-2],(Nodo)yyvsp[-1]);}
break;
case 105:
#line 433 "gramatica.y"
{yyval=yyvsp[-1];}
break;
case 106:
#line 434 "gramatica.y"
{yyval = new NodoHoja("RETURN");}
break;
case 107:
#line 435 "gramatica.y"
{yyval = new NodoComun("Sentencia",(Nodo)yyvsp[-2],(Nodo)yyvsp[-1]);}
break;
case 108:
#line 436 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba una ',' al final de la linea ");}
break;
case 109:
#line 437 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba una ',' al final de la linea ");}
break;
case 110:
#line 438 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba una ',' al final de la linea ");}
break;
case 111:
#line 441 "gramatica.y"
{yyval=new NodoHoja(yyvsp[-2].sval);
                             Token funcion = TablaSimbolos.buscarPorAmbito(yyvsp[-2].sval + ":" + ambitoAct);
                             if (funcion == null){
                                agregarErrorSemantico("La funcion " + yyvsp[-2].sval + " nunca fue declarada");
                             }

				            AnalizadorLexico.agregarEstructura("Reconoce llamado funcion ");
				            TablaSimbolos.removeToken(yyvsp[-2].sval);
				            }
break;
case 112:
#line 450 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba un '(' ");}
break;
case 113:
#line 451 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba un ')' ");}
break;
case 114:
#line 452 "gramatica.y"
{yyval=new NodoComun("Llamado Funcion",(Nodo)yyvsp[-3],new NodoControl("Parametro Llamado Funcion",(Nodo)yyvsp[-2]));
                                    AnalizadorLexico.agregarEstructura("Reconoce llamado funcion ");
                                    Token funcion = TablaSimbolos.buscarPorAmbito(yyvsp[-3].sval + ":" + ambitoAct);
                                    if (funcion == null){
                                        agregarErrorSemantico("La funcion " + yyvsp[-3].sval + " nunca fue declarada");
                                    } else {
                                        Token parametro = TablaSimbolos.getTokenParametroDeFuncion(yyvsp[-3].sval);
                                        parametro.toString();

                                        }

                                    AnalizadorLexico.agregarEstructura("Reconoce llamado funcion ");
                                    TablaSimbolos.removeToken(yyvsp[-3].sval);
                                    }
break;
case 115:
#line 468 "gramatica.y"
{yyval = new NodoControl("PRINT", new NodoHoja(yyvsp[0].sval));
                             AnalizadorLexico.agregarEstructura("Reconoce salida de mensaje por pantalla ");}
break;
case 116:
#line 470 "gramatica.y"
{yyval = new NodoControl("PRINT", new NodoHoja(yyvsp[0].sval));
                            AnalizadorLexico.agregarEstructura("Reconoce salida de mensaje por pantalla ");}
break;
case 117:
#line 472 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("La funcion PRINT no acepta esa declaracion ");}
break;
case 118:
#line 475 "gramatica.y"
{yyval=yyvsp[0];}
break;
case 119:
#line 476 "gramatica.y"
{yyval=yyvsp[0];}
break;
case 120:
#line 479 "gramatica.y"
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
#line 501 "gramatica.y"
{AnalizadorLexico.agregarEstructura("Reconoce asignacion ");
	                                                        yyval = new NodoComun(yyvsp[-1].sval,(Nodo)yyvsp[-2],(Nodo)yyvsp[0]);}
break;
case 122:
#line 504 "gramatica.y"
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
#line 522 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba un valor seguido del operador ");}
break;
case 124:
#line 523 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba un valor seguido del operador ");}
break;
case 125:
#line 524 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba un operando del lado izquierdo ");}
break;
case 126:
#line 527 "gramatica.y"
{yyval=new NodoComun("DO UNTIL", (Nodo)yyvsp[-2] ,(Nodo)yyvsp[0]);
                                                        AnalizadorLexico.agregarEstructura("Reconoce funcion DO UNTIL");}
break;
case 127:
#line 529 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba una condicion ");}
break;
case 128:
#line 534 "gramatica.y"
{yyval = yyvsp[-1];}
break;
case 129:
#line 535 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba un '(' ");}
break;
case 130:
#line 536 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba un ')' ");}
break;
case 131:
#line 539 "gramatica.y"
{yyval = yyvsp[-1];}
break;
case 132:
#line 540 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba un '(' ");}
break;
case 133:
#line 541 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba un ')' ");}
break;
case 134:
#line 544 "gramatica.y"
{yyval = new NodoControl("TOD",(Nodo)yyvsp[0]);
                                            AnalizadorLexico.agregarEstructura("Reconoce funcion TOD ");
                                            }
break;
case 135:
#line 548 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba una Expresion ");}
break;
case 137:
#line 555 "gramatica.y"
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
case 138:
#line 576 "gramatica.y"
{deshacerAmbito();}
break;
case 139:
#line 579 "gramatica.y"
{AnalizadorLexico.agregarEstructura("Reconoce Funcion sin cuerpo");}
break;
case 140:
#line 583 "gramatica.y"
{AnalizadorLexico.agregarEstructura("Reconoce funcion IMPL"); TablaSimbolos.removeToken(yyvsp[-4].sval);}
break;
case 141:
#line 584 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba un '{' ");}
break;
case 142:
#line 585 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba un '}' ");}
break;
#line 1689 "y.tab.c"
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
