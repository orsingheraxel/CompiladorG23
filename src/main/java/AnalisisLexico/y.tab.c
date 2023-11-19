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
   25,   25,   25,   25,   29,   29,   14,   14,   31,   32,
   32,   32,   32,   32,   32,   33,   33,   33,   33,   33,
   33,   33,   33,   33,    8,    8,    8,    8,   11,   11,
   11,   35,   35,    9,    9,    9,    9,    9,    9,    3,
    3,   34,   34,   34,   21,   21,   36,   37,   37,   37,
   37,   37,   37,   37,   37,   15,   30,   17,   17,   17,
};
short yylen[] = {                                         2,
    3,    3,    3,    2,    1,    1,    1,    2,    3,    3,
    1,    1,    1,    1,    1,    2,    1,    2,    2,    1,
    1,    1,    1,    3,    2,    1,    1,    1,    1,    1,
    2,    1,    2,    2,    3,    3,    1,    1,    3,    3,
    1,    3,    3,    1,    1,    1,    1,    5,    5,    5,
    6,    4,    6,    4,    7,    8,    7,    7,    7,    7,
    7,    7,    7,    7,    5,    3,    2,    2,    5,    5,
    3,    3,    2,    1,    1,    2,    2,    3,    1,    1,
    1,    1,    1,    1,    1,    1,    5,    6,    2,    4,
    4,    4,    2,    2,    2,    3,    3,    2,    2,    2,
    3,    2,    2,    2,    3,    3,    3,    2,    2,    2,
    2,    1,    1,    3,    3,    3,    3,    3,    2,    4,
    4,    3,    3,    3,    2,    3,    3,    3,    4,    2,
    3,    3,    4,    2,    3,    3,    2,    7,    7,    7,
};
short yydefred[] = {                                      0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
   27,   26,   28,    0,  113,    0,   29,   30,   32,    0,
  112,    0,    0,    5,    6,    7,    0,   15,   12,   11,
   13,   14,    0,   17,   20,   21,   22,   46,    0,    0,
    0,    0,   23,    0,    0,    0,    0,  111,   45,  109,
  110,    0,    0,   89,    0,    0,    0,    0,    0,    0,
    0,    0,    0,  108,    8,   33,   31,   34,    2,    0,
    4,    0,   19,    0,    0,    0,    0,    0,  119,    1,
    0,    0,    0,   47,    0,    0,   38,   41,   44,    0,
    0,    0,    0,    0,  136,    0,   75,    0,    0,    0,
   68,   67,   73,    0,    0,    0,  106,    0,    0,   10,
  107,  105,    0,    3,  117,  115,  116,  118,    0,   95,
    0,   94,   93,    0,    0,   24,    0,    0,    0,  125,
   83,   84,   82,   81,    0,    0,   79,   80,    0,    0,
    0,    0,    0,    0,   54,    0,   52,    0,   85,    0,
   86,    0,    0,    0,   77,   76,   71,    0,   72,    0,
   66,    0,  120,    0,  123,  124,  122,    0,    0,    0,
    0,    0,    0,    9,  126,    0,    0,    0,   39,   42,
   40,   43,    0,    0,   65,    0,    0,    0,    0,    0,
  134,  130,    0,    0,  127,    0,    0,    0,   78,    0,
    0,    0,    0,   92,   91,   90,  104,  100,  102,   98,
  103,   99,    0,   87,    0,    0,   50,   49,   48,    0,
    0,    0,    0,    0,    0,    0,   53,   51,  132,  128,
    0,  135,    0,  131,   88,   70,   69,    0,    0,  101,
   97,   96,   63,   62,   61,   59,    0,   58,   55,   64,
   60,   57,    0,  129,  139,  140,  138,   56,
};
short yydgoto[] = {                                       3,
   22,   23,   24,   25,   26,   27,   28,   29,   30,   31,
   32,   33,   44,   34,   35,   36,   37,   38,   85,   86,
   87,   39,   89,   47,  139,   58,   99,  100,  150,  151,
   40,   78,  173,   64,   41,   95,  153,
};
short yysindex[] = {                                    -99,
   47,   47,    0, -231,  -30,  191, -223, -228, -104, -227,
    0,    0,    0,  -39,    0, -206,    0,    0,    0, -151,
    0,   -3,   33,    0,    0,    0,  -49,    0,    0,    0,
    0,    0, -217,    0,    0,    0,    0,    0,  -49,  -29,
  159,   22,    0,   60,  176,  176,  147,    0,    0,    0,
    0,   15,  -29,    0,  184,   12,  155, -175, -146,  -36,
 -134,  -41,   60,    0,    0,    0,    0,    0,    0,   90,
    0,  210,    0,   60,  130,   52,  164,   20,    0,    0,
 -130,   98,  -25,    0,  463,   62,    0,    0,    0,  463,
  -32,   13, -168, -165,    0,   40,    0,   17,   21,  250,
    0,    0,    0, -119,  -24,   87,    0,   23,  -22,    0,
    0,    0,  -10,    0,    0,    0,    0,    0,   55,    0,
 -108,    0,    0, -100,  122,    0,  -96,  176,  -28,    0,
    0,    0,    0,    0,  204,  204,    0,    0,  176,  204,
  204,  176, -199, -145,    0,  147,    0, -231,    0,   18,
    0,  -29, -102,  122,    0,    0,    0,  132,    0,   25,
    0,  176,    0,  -97,    0,    0,    0,  136,  -38,   30,
   36,   37,   72,    0,    0,   62,   62,   69,    0,    0,
    0,    0,   -9, -104,    0,  147,  147,   38, -184,   11,
    0,    0,   20, -165,    0, -231,  137,   97,    0,   57,
   68,  -77,  -77,    0,    0,    0,    0,    0,    0,    0,
    0,    0,  142,    0,  143,  150,    0,    0,    0,  -64,
  -61,  -60,   42, -141,  -58, -135,    0,    0,    0,    0,
 -231,    0,  -14,    0,    0,    0,    0,   81, -105,    0,
    0,    0,    0,    0,    0,    0,  -52,    0,    0,    0,
    0,    0,   60,    0,    0,    0,    0,    0,
};
short yyrindex[] = {                                      0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,  -18,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,   43,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,   50,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,   61,    0,    0,    0,    0,    0,    0,
    0,  433,    0,    0,    0,  405,    0,    0,    0,    0,
  -18,    0,    0,    0,    0,    0,    0,    0,    0, -103,
    0,    0,    0,    0,    0,    0,    0,    0,  -13,    0,
    0,    0,    0,    0,    0,    0,    0,    0,   86,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,  165,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,  453,  458,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,  280,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,  -88,    0,    0,    0,    0,    0,
};
short yygindex[] = {                                      0,
  208,    7,    0,   16,  -78,  505,    0,  151,    0,    0,
    0,    2,  -12,  -54,    0,    0,    0,    0,  509,   -4,
    0,  481,  -34,  106,  123,    4,  163,    0, -109,    0,
  -69,  -26,  169,  140,   26,    0,    0,
};
#define YYTABLESIZE 736
short yytable[] = {                                     112,
   62,   63,  206,   20,  107,  161,   61,   62,   20,   46,
   77,   21,  175,   61,  129,   46,   20,   62,   57,  257,
   74,   74,  195,    2,  152,  203,   96,   53,   70,  254,
  167,  219,  136,  136,  135,  135,  133,   43,   73,  149,
   54,   20,   45,  197,   81,   52,  172,    9,   70,   65,
   93,   43,   72,   59,  230,  102,  144,   21,  184,  185,
  156,  192,   92,  165,   75,  136,   20,  135,  201,   81,
   98,  227,   98,  208,  228,  172,   71,  121,  124,  210,
  212,  226,   21,  152,  232,  247,   18,  145,  105,  146,
  147,   20,  120,   25,  216,  148,    8,  136,  149,  135,
   11,   12,   13,  140,   16,  180,  182,   21,  141,  217,
  186,  136,  187,  135,  248,  158,   20,  249,   81,  216,
  251,   69,  106,  252,  152,  193,   66,   67,   68,  114,
  176,  177,   21,  114,  109,  190,  159,   94,  126,  149,
  171,   20,  125,  127,  164,  157,   80,  238,  239,  189,
  256,   55,   74,  194,  196,  160,    1,   21,  202,    8,
  168,  188,  154,   11,   12,   13,   20,  133,  169,  171,
   56,   74,  174,  133,   20,  199,  204,  133,  133,  133,
  234,  236,   21,  233,    8,  240,  241,  220,  215,  222,
  224,   20,  237,  242,  243,  231,  214,  244,  245,   20,
  250,  221,  223,   20,  123,  255,  258,   21,  121,   42,
  163,  110,  142,  215,  111,   21,   60,  205,  253,  104,
   20,  235,  130,   60,   15,   45,   76,   82,   20,   43,
  128,  162,   82,   60,   83,   20,   17,   18,   19,   83,
   82,   17,   18,   19,   21,  166,  218,   83,   20,   17,
   18,   19,    4,    5,   20,   45,    6,    7,    8,    9,
    9,   10,   11,   12,   13,   14,  229,  101,  143,   57,
   15,   16,  155,  191,   17,   18,   19,    4,    5,  103,
  200,    6,    7,    8,    9,  207,   10,   11,   12,   13,
   14,  209,  211,  225,   20,   15,   16,  246,   18,   17,
   18,   19,    4,    5,    0,   25,    6,    7,    8,    9,
   21,   10,   11,   12,   13,   14,   16,   11,   12,   13,
   15,   16,  198,  137,   17,   18,   19,    4,    5,    0,
    0,    6,    7,    8,    0,    0,   10,   11,   12,   13,
   14,  114,    0,    0,  114,   15,  213,    0,    0,   17,
   18,   19,    4,    5,    0,    0,    6,    7,    8,    0,
    0,   10,   11,   12,   13,   14,    0,    0,    0,    0,
   15,  213,    0,    0,   17,   18,   19,    4,    5,    0,
    0,    6,    7,    8,    0,  118,   10,   11,   12,   13,
   14,    0,    0,    0,    0,   15,  170,    0,   82,   17,
   18,   19,   55,    5,  137,   83,    6,   17,   18,   19,
   97,    5,    0,    0,    6,   91,    0,    0,    0,  122,
   15,   56,    0,   91,   17,   18,   19,   49,   15,   11,
   12,   13,   17,   18,   19,    0,   17,   18,   19,   97,
    5,    0,    0,    6,   82,   37,   48,   37,   37,   37,
    0,   83,   91,   17,   18,   19,    0,   15,    0,   49,
    0,   17,   18,   19,   37,  115,   37,   50,   17,   18,
   19,    0,   82,   45,   45,   45,   45,   45,   82,   45,
    0,   17,   18,   19,    0,    0,   51,   17,   18,   19,
    0,    0,   45,   36,   45,   36,   36,   36,   35,    0,
   35,   35,   35,    0,    0,  136,    5,  135,    0,    6,
    0,    0,   36,    0,   36,    0,    0,   35,   91,   35,
    0,   79,  137,   15,  138,   88,   88,   17,   18,   19,
    0,    0,    0,    0,    0,  137,    0,    0,    0,    0,
   88,  137,   88,    0,    0,  137,  137,  137,    0,   84,
   84,    0,  117,    0,   90,   88,    0,    0,    0,    0,
    0,    0,    0,    0,   84,    0,   84,    0,  108,    0,
  113,    0,    0,    0,    0,    0,  116,    0,    0,   84,
    0,    0,    0,  119,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,   88,   88,
    0,    0,    0,    0,    0,   88,   88,    0,    0,   88,
  179,  181,   88,    0,    0,    0,    0,    0,    0,    0,
    0,    0,   84,   84,    0,    0,  108,  113,    0,   84,
   84,    0,   88,   84,   84,   84,   84,  178,    0,    0,
  183,    0,    0,    0,    0,    0,    0,    0,    0,    0,
   37,    0,    0,   37,    0,    0,   84,    0,    0,    0,
    0,    0,    0,    0,   37,   37,   37,   37,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,   45,    0,
    0,   45,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,   45,   45,   45,   45,    0,    0,   36,    0,
    0,   36,    0,   35,    0,    0,   35,    0,    0,    0,
    0,    0,   36,   36,   36,   36,    0,   35,   35,   35,
   35,    0,  131,  132,  133,  134,
};
short yycheck[] = {                                      41,
   40,   14,   41,   45,   41,  125,   46,   40,   45,   40,
   40,   61,   41,   46,   40,   40,   45,   40,  123,  125,
   33,  125,  125,  123,   94,  123,   53,  256,   22,   44,
   41,   41,   43,   43,   45,   45,  125,  269,  256,   94,
  269,   45,   61,  153,   59,  269,  125,   61,   42,  256,
   47,  269,   27,  281,   44,   44,   44,   61,  258,  259,
   44,   44,   47,   41,   39,   43,   45,   45,   44,   59,
   55,  256,   57,   44,  259,  154,   44,   76,   77,   44,
   44,   44,   61,  153,  194,   44,   44,  256,  264,  258,
  259,   45,   41,   44,  173,   94,  262,   43,  153,   45,
  266,  267,  268,   42,   44,  140,  141,   61,   47,   41,
  256,   43,  258,   45,  256,  100,   45,  259,   59,  198,
  256,  125,  269,  259,  194,  152,  278,  279,  280,   44,
  135,  136,   61,   44,  269,  148,  256,  123,  269,  194,
  125,   45,  123,   46,   58,  125,  125,  202,  203,  146,
  256,  256,  256,  256,  153,  275,  256,   61,  256,  262,
  269,  146,  123,  266,  267,  268,   45,  256,  269,  154,
  275,  275,  269,  262,   45,   44,   41,  266,  267,  268,
   44,  125,   61,  196,  262,   44,   44,  184,  173,  186,
  187,   45,  125,   44,  259,  194,  125,  259,  259,   45,
  259,  186,  187,   45,   41,  125,  259,   61,   44,    2,
  105,   61,   90,  198,  256,   61,  256,  256,  231,   57,
   45,  125,   83,  256,  274,  256,  256,  269,   45,  269,
  256,  256,  269,  256,  276,   45,  278,  279,  280,  276,
  269,  278,  279,  280,   61,  256,  256,  276,   45,  278,
  279,  280,  256,  257,   45,  274,  260,  261,  262,  263,
  274,  265,  266,  267,  268,  269,  256,  256,  256,  123,
  274,  275,  256,  256,  278,  279,  280,  256,  257,  125,
  256,  260,  261,  262,  263,  256,  265,  266,  267,  268,
  269,  256,  256,  256,   45,  274,  275,  256,  256,  278,
  279,  280,  256,  257,   -1,  256,  260,  261,  262,  263,
   61,  265,  266,  267,  268,  269,  256,  266,  267,  268,
  274,  275,  154,   44,  278,  279,  280,  256,  257,   -1,
   -1,  260,  261,  262,   -1,   -1,  265,  266,  267,  268,
  269,  256,   -1,   -1,  259,  274,  275,   -1,   -1,  278,
  279,  280,  256,  257,   -1,   -1,  260,  261,  262,   -1,
   -1,  265,  266,  267,  268,  269,   -1,   -1,   -1,   -1,
  274,  275,   -1,   -1,  278,  279,  280,  256,  257,   -1,
   -1,  260,  261,  262,   -1,  256,  265,  266,  267,  268,
  269,   -1,   -1,   -1,   -1,  274,  275,   -1,  269,  278,
  279,  280,  256,  257,  125,  276,  260,  278,  279,  280,
  256,  257,   -1,   -1,  260,  269,   -1,   -1,   -1,  256,
  274,  275,   -1,  269,  278,  279,  280,  269,  274,  266,
  267,  268,  278,  279,  280,   -1,  278,  279,  280,  256,
  257,   -1,   -1,  260,  269,   41,  256,   43,   44,   45,
   -1,  276,  269,  278,  279,  280,   -1,  274,   -1,  269,
   -1,  278,  279,  280,   60,  256,   62,  277,  278,  279,
  280,   -1,  269,   41,   42,   43,   44,   45,  269,   47,
   -1,  278,  279,  280,   -1,   -1,    6,  278,  279,  280,
   -1,   -1,   60,   41,   62,   43,   44,   45,   41,   -1,
   43,   44,   45,   -1,   -1,   43,  257,   45,   -1,  260,
   -1,   -1,   60,   -1,   62,   -1,   -1,   60,  269,   62,
   -1,   41,   60,  274,   62,   45,   46,  278,  279,  280,
   -1,   -1,   -1,   -1,   -1,  256,   -1,   -1,   -1,   -1,
   60,  262,   62,   -1,   -1,  266,  267,  268,   -1,   45,
   46,   -1,   72,   -1,   46,   75,   -1,   -1,   -1,   -1,
   -1,   -1,   -1,   -1,   60,   -1,   62,   -1,   60,   -1,
   62,   -1,   -1,   -1,   -1,   -1,   72,   -1,   -1,   75,
   -1,   -1,   -1,   75,   -1,   -1,   -1,   -1,   -1,   -1,
   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,
   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,  128,  129,
   -1,   -1,   -1,   -1,   -1,  135,  136,   -1,   -1,  139,
  140,  141,  142,   -1,   -1,   -1,   -1,   -1,   -1,   -1,
   -1,   -1,  128,  129,   -1,   -1,  128,  129,   -1,  135,
  136,   -1,  162,  139,  140,  141,  142,  139,   -1,   -1,
  142,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,
  256,   -1,   -1,  259,   -1,   -1,  162,   -1,   -1,   -1,
   -1,   -1,   -1,   -1,  270,  271,  272,  273,   -1,   -1,
   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,  256,   -1,
   -1,  259,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,
   -1,   -1,  270,  271,  272,  273,   -1,   -1,  256,   -1,
   -1,  259,   -1,  256,   -1,   -1,  259,   -1,   -1,   -1,
   -1,   -1,  270,  271,  272,  273,   -1,  270,  271,  272,
  273,   -1,  270,  271,  272,  273,
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
"ListaSentenciasIF : ListaSentenciasIF SentenciaEjecutable ','",
"Comparador : '<'",
"Comparador : '>'",
"Comparador : MAYORIGUAL",
"Comparador : MENORIGUAL",
"Comparador : IGUAL",
"Comparador : DIST",
"ListFuncion : Funcion",
"ListFuncion : FuncionSinCuerpo",
"Funcion : EncabezadoFuncion Parametro '{' ListSentenciasFuncion '}'",
"Funcion : VOID error Parametro '{' ListSentenciasFuncion '}'",
"EncabezadoFuncion : VOID ID",
"Parametro : '(' Tipo ID ')'",
"Parametro : '(' Tipo ID error",
"Parametro : error Tipo ID ')'",
"Parametro : '(' ')'",
"Parametro : '(' error",
"Parametro : error ')'",
"ListSentenciasFuncion : ListSentenciasFuncion SentenciaDeclarativa ','",
"ListSentenciasFuncion : ListSentenciasFuncion SentenciaEjecutable ','",
"ListSentenciasFuncion : SentenciaEjecutable ','",
"ListSentenciasFuncion : SentenciaDeclarativa ','",
"ListSentenciasFuncion : RETURN ','",
"ListSentenciasFuncion : ListSentenciasFuncion RETURN ','",
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
"ConversionExplicita : TOD LlamadoExpresion",
"ConversionExplicita : TOD '(' ')'",
"ListHerencia : '{' SentenciaListHerencia '}'",
"SentenciaListHerencia : Tipo ListVariables ','",
"SentenciaListHerencia : SentenciaListHerencia Tipo ListVariables ','",
"SentenciaListHerencia : ListFuncion ','",
"SentenciaListHerencia : SentenciaListHerencia ListFuncion ','",
"SentenciaListHerencia : Tipo ListVariables error",
"SentenciaListHerencia : SentenciaListHerencia error Tipo ListVariables",
"SentenciaListHerencia : ListFuncion error",
"SentenciaListHerencia : SentenciaListHerencia error ListFuncion",
"HerenciaComposicion : CLASS ID ListHerencia",
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
#line 399 "gramatica.y"
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

   public void actualizarAmbito(String ambitoAct, String a){
        ambitoAct += ":"+a;
   }
   public void deshacerAmbito(String ambitoAct){
           String aux = ambitoAct;
           char [] a = aux.toCharArray();
           int i = a.length;
           while ((i>0) && (!(a[i-1] == ':'))){
                i --;
           }
           aux = aux.substring(0,i-1);
           ambitoAct = aux;
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
#line 649 "y.tab.c"
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
{yyval=yyvsp[0];}
break;
case 6:
#line 28 "gramatica.y"
{yyval=yyvsp[0];}
break;
case 7:
#line 29 "gramatica.y"
{yyval= new NodoHoja("SENTENCIA DECLARATIVA");}
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
                    ((Nodo)yyval).setTipo("INT");
                    ((Nodo)yyval).setUso("Constante");
                   }
break;
case 30:
#line 93 "gramatica.y"
{yyval = new NodoHoja(yyvsp[0].sval);
	               chequearEnteroCorto(yyvsp[0].sval);
	               ((Nodo)yyval).setTipo("USHORT");
                   chequearEnteroPositivo(yyvsp[0].sval);
                   ((Nodo)yyval).setUso("Constante");
                   }
break;
case 31:
#line 99 "gramatica.y"
{AnalizadorLexico.agregarErrorLexico("Un entero corto no puede ser negativo ");}
break;
case 32:
#line 100 "gramatica.y"
{
	                chequearDouble(yyvsp[0].sval);
	                yyval = new NodoHoja(yyvsp[0].sval);
                    ((Nodo)yyval).setTipo("DOUBLE");
                    ((Nodo)yyval).setUso("Constante");
                    }
break;
case 33:
#line 107 "gramatica.y"
{
                    yyval = new NodoHoja(yyvsp[-1].sval);
                    chequearEnteroNegativo(yyvsp[0].sval);
                    ((Nodo)yyval).setTipo("INT");
                    ((Nodo)yyval).setUso("Constante");
	                }
break;
case 34:
#line 113 "gramatica.y"
{
                            chequearDouble(yyvsp[-1].sval);
                            yyval = new NodoHoja(yyvsp[-1].sval);
                            ((Nodo)yyval).setTipo("DOUBLE");
                            ((Nodo)yyval).setUso("Constante");
                        }
break;
case 35:
#line 121 "gramatica.y"
{ yyval = new NodoComun("+",(Nodo)yyvsp[-2],(Nodo)yyvsp[0]);
                                    if (!((Nodo)yyvsp[-2]).getAmbito().equals(((Nodo)yyvsp[0]).getAmbito())){
                                          agregarErrorSemantico("Variable fuera de alcance ");
                                    }
                                        ((Nodo)yyval).setTipo(tipoPredominante(((Nodo)yyvsp[-2]).getTipo(),((Nodo)yyvsp[0]).getTipo()));
                                    }
break;
case 36:
#line 128 "gramatica.y"
{yyval = new NodoComun("-",(Nodo)yyvsp[-2],(Nodo)yyvsp[0]);
                        if (!((Nodo)yyvsp[-2]).getAmbito().equals(((Nodo)yyvsp[0]).getAmbito())){
                            agregarErrorSemantico("Variable fuera de alcance ");
                        }
                            ((Nodo)yyval).setTipo(tipoPredominante(((Nodo)yyvsp[-2]).getTipo(),((Nodo)yyvsp[0]).getTipo()));
                      }
break;
case 37:
#line 134 "gramatica.y"
{yyval=yyvsp[0];}
break;
case 38:
#line 135 "gramatica.y"
{yyval = yyvsp[0];}
break;
case 39:
#line 139 "gramatica.y"
{yyval = new NodoComun("*",(Nodo)yyvsp[-2],(Nodo)yyvsp[0]);
                               if (!((Nodo)yyvsp[-2]).getAmbito().equals(((Nodo)yyvsp[0]).getAmbito())){
                                    agregarErrorSemantico("Variable fuera de alcance ");
                               }
                                    ((Nodo)yyval).setTipo(tipoPredominante(((Nodo)yyvsp[-2]).getTipo(),((Nodo)yyvsp[0]).getTipo()));
                              }
break;
case 40:
#line 146 "gramatica.y"
{yyval = new NodoComun("/",(Nodo)yyvsp[-2],(Nodo)yyvsp[0]);
                    if (!((Nodo)yyvsp[-2]).getAmbito().equals(((Nodo)yyvsp[0]).getAmbito())){
                        agregarErrorSemantico("Variable fuera de alcance ");
                    }
                        ((Nodo)yyval).setTipo(tipoPredominante(((Nodo)yyvsp[-2]).getTipo(),((Nodo)yyvsp[0]).getTipo()));
                    }
break;
case 41:
#line 152 "gramatica.y"
{yyval = yyvsp[0];}
break;
case 42:
#line 153 "gramatica.y"
{yyval = new NodoComun("*",(Nodo)yyvsp[-2],(Nodo)yyvsp[0]);
                               if (!((Nodo)yyvsp[-2]).getAmbito().equals(((Nodo)yyvsp[0]).getAmbito())){
                                    agregarErrorSemantico("Variable fuera de alcance ");
                               }
                                     ((Nodo)yyval).setTipo(tipoPredominante(((Nodo)yyvsp[-2]).getTipo(),((Nodo)yyvsp[0]).getTipo()));
                               }
break;
case 43:
#line 159 "gramatica.y"
{yyval = new NodoComun("/",(Nodo)yyvsp[-2],(Nodo)yyvsp[0]);
                               if (!((Nodo)yyvsp[-2]).getAmbito().equals(((Nodo)yyvsp[0]).getAmbito())){
                                    agregarErrorSemantico("Variable fuera de alcance ");
                               }
                                    ((Nodo)yyval).setTipo(tipoPredominante(((Nodo)yyvsp[-2]).getTipo(),((Nodo)yyvsp[0]).getTipo()));
                               }
break;
case 44:
#line 165 "gramatica.y"
{yyval=yyvsp[0];}
break;
case 45:
#line 168 "gramatica.y"
{yyval = new NodoHoja(yyvsp[0].sval);
            String var = yyvsp[0].sval + ":" + ambitoAct;
            var = estaAlAlcance(var);
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
#line 185 "gramatica.y"
{yyval=yyvsp[0];}
break;
case 47:
#line 188 "gramatica.y"
{yyval=yyvsp[0];}
break;
case 48:
#line 191 "gramatica.y"
{ yyval = new NodoComun(yyvsp[-2].sval,(Nodo)yyvsp[-3],(Nodo)yyvsp[-1]);
                                                    ((Nodo)yyval).setTipo(((Nodo)yyvsp[-3]).getTipo());
                                                    ((Nodo)yyval).setUso("Condicion");
                                                     if (!((((Nodo)yyvsp[-3]).getTipo()).equals(((Nodo)yyvsp[-1]).getTipo()))){
                                                         agregarErrorSemantico("Error en la comparacion entre expresiones de distintos tipos"); /*CHEQUEAR CONVERSIONES*/
                                                     }
                                                     }
break;
case 49:
#line 198 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba una ')' ");}
break;
case 50:
#line 199 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba una '(' ");}
break;
case 51:
#line 202 "gramatica.y"
{Nodo SentenciasIF = new NodoComun("SentenciasIF",new NodoControl("SentenciasIF",(Nodo)yyvsp[-3]), new NodoControl("SentenciasELSE",(Nodo)yyvsp[-1]));
                                                                      yyval= new NodoComun("BloqueIF", new NodoControl("Condicion",(Nodo)yyvsp[-4]), SentenciasIF);
                                                                      AnalizadorLexico.agregarEstructura("Reconoce IF ELSE ");}
break;
case 52:
#line 205 "gramatica.y"
{yyval= new NodoComun("BloqueIF", new NodoControl("Condicion",(Nodo)yyvsp[-2]), new NodoControl("SentenciasIF",(Nodo)yyvsp[-1]));
	                                            AnalizadorLexico.agregarEstructura("Reconoce IF ");}
break;
case 53:
#line 207 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("IF mal definido ");}
break;
case 54:
#line 208 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("IF mal definido ");}
break;
case 55:
#line 209 "gramatica.y"
{AnalizadorLexico.agregarEstructura("Reconoce IF ELSE");}
break;
case 56:
#line 210 "gramatica.y"
{AnalizadorLexico.agregarEstructura("Reconoce IF ELSE");}
break;
case 57:
#line 211 "gramatica.y"
{AnalizadorLexico.agregarEstructura("Reconoce IF ELSE");}
break;
case 58:
#line 212 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba un END_IF ");}
break;
case 59:
#line 213 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba un END_IF ");}
break;
case 60:
#line 214 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba un END_IF ");}
break;
case 61:
#line 215 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba un ELSE ");}
break;
case 62:
#line 216 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("IF mal definido ");}
break;
case 63:
#line 217 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba una ',' ");}
break;
case 64:
#line 218 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba una ',' " );}
break;
case 65:
#line 219 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba una ',' ");}
break;
case 68:
#line 224 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Falta una ',' "); }
break;
case 70:
#line 226 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Falta una ',' "); }
break;
case 71:
#line 227 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Falta un '{'"); }
break;
case 72:
#line 228 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Falta un '}'"); }
break;
case 73:
#line 229 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("No hay sentencias dentro de las llaves."); }
break;
case 75:
#line 235 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Solo se aceptan sentencias ejecutables "); }
break;
case 77:
#line 237 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Falta una ',' "); }
break;
case 79:
#line 243 "gramatica.y"
{yyval=yyvsp[0];}
break;
case 80:
#line 244 "gramatica.y"
{yyval=yyvsp[0];}
break;
case 81:
#line 245 "gramatica.y"
{yyval=yyvsp[0];}
break;
case 82:
#line 246 "gramatica.y"
{yyval=yyvsp[0];}
break;
case 83:
#line 247 "gramatica.y"
{yyval=yyvsp[0];}
break;
case 84:
#line 248 "gramatica.y"
{yyval=yyvsp[0];}
break;
case 87:
#line 255 "gramatica.y"
{deshacerAmbito(ambitoAct);}
break;
case 88:
#line 256 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba un nombre para la funcion ");}
break;
case 89:
#line 259 "gramatica.y"
{ambitoNuevo = yyvsp[0].sval;}
break;
case 90:
#line 262 "gramatica.y"
{	yyval = new NodoHoja(yyvsp[-1].sval);

                           }
break;
case 91:
#line 265 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba un ')' ");}
break;
case 92:
#line 266 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba un '(' ");}
break;
case 94:
#line 268 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba un ')' ");}
break;
case 95:
#line 269 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba un '(' ");}
break;
case 96:
#line 272 "gramatica.y"
{actualizarAmbito(ambitoAct,ambitoNuevo);}
break;
case 97:
#line 273 "gramatica.y"
{actualizarAmbito(ambitoAct,ambitoNuevo);}
break;
case 98:
#line 274 "gramatica.y"
{actualizarAmbito(ambitoAct,ambitoNuevo);
		                            yyval = yyvsp[-1];}
break;
case 99:
#line 276 "gramatica.y"
{actualizarAmbito(ambitoAct,ambitoNuevo);}
break;
case 100:
#line 277 "gramatica.y"
{actualizarAmbito(ambitoAct,ambitoNuevo);}
break;
case 101:
#line 278 "gramatica.y"
{actualizarAmbito(ambitoAct,ambitoNuevo);}
break;
case 102:
#line 279 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba una ',' al final de la linea ");}
break;
case 103:
#line 280 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba una ',' al final de la linea ");}
break;
case 104:
#line 281 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba una ',' al final de la linea ");}
break;
case 105:
#line 285 "gramatica.y"
{yyval=new NodoHoja(yyvsp[-2].sval);AnalizadorLexico.agregarEstructura("Reconoce llamado funcion ");}
break;
case 106:
#line 286 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba un '(' ");}
break;
case 107:
#line 287 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba un ')' ");}
break;
case 108:
#line 288 "gramatica.y"
{yyval=new NodoComun("Llamado Funcion",(Nodo)yyvsp[-1],new NodoControl("Parametro Llamado Funcion",(Nodo)yyvsp[0]));AnalizadorLexico.agregarEstructura("Reconoce llamado funcion ");}
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
{AnalizadorLexico.agregarEstructura("Reconoce asignacion ");
						                        yyval = new NodoComun(yyvsp[-1].sval,(Nodo)yyvsp[-2],(Nodo)yyvsp[0]);
						                        String var = estaAlAlcance(((Nodo)yyvsp[-2]).getLexema() + ":" + ambitoAct);
                                                if (var.contains("main")){
                                                    Token t1 = TablaSimbolos.getToken(var);
                                                    if (t1 != null){
                                                        if (t1.getUso().equals("Constante")){
                                                            agregarErrorSemantico("Las constantes no pueden estar del lado izquierdo en una asignacion");
                                                        }
                                                        else {
                                                            if (!estaAlAlcance(var).equals(((Nodo)yyvsp[-2]).getLexema())){
                                                                ((Nodo)yyval).setTipo(tipoPredominante(((Nodo)yyvsp[-2]).getTipo(),((Nodo)yyvsp[0]).getTipo()));
                                                            }
                                                            else {
                                                                agregarErrorSemantico("Variable " + ((Nodo)yyvsp[-2]).getLexema() +" fuera de alcance");
                                                            }
                                                        }
                                                    }
                                                }
						                        else {
						                            agregarErrorSemantico("Variable " + ((Nodo)yyvsp[-2]).getLexema() + " no definida");
						                        }
					    }
break;
case 117:
#line 328 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba un valor seguido del operador ");}
break;
case 118:
#line 329 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba un valor seguido del operador ");}
break;
case 119:
#line 330 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba un operando del lado izquierdo ");}
break;
case 120:
#line 333 "gramatica.y"
{yyval=new NodoComun("Sentencia DO UNTIL", new NodoControl("ListSentenciasDO",(Nodo)yyvsp[-2]), new NodoControl("CondicionDO", (Nodo)yyvsp[0]));
                                                        AnalizadorLexico.agregarEstructura("Reconoce funcion DO UNTIL");}
break;
case 121:
#line 335 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba una condicion ");}
break;
case 122:
#line 340 "gramatica.y"
{yyval = yyvsp[-1];}
break;
case 123:
#line 341 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba un '(' ");}
break;
case 124:
#line 342 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba un ')' ");}
break;
case 125:
#line 345 "gramatica.y"
{yyval = new NodoControl("TOD",(Nodo)yyvsp[0]);
                                            AnalizadorLexico.agregarEstructura("Reconoce funcion TOD ");
                                            }
break;
case 126:
#line 349 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba una Expresion ");}
break;
case 128:
#line 356 "gramatica.y"
{

                                               }
break;
case 132:
#line 362 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba una ',' al final de la linea ");}
break;
case 133:
#line 363 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba una ',' al final de la linea ");}
break;
case 134:
#line 364 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba una ',' al final de la linea ");}
break;
case 135:
#line 365 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba una ',' al final de la linea ");}
break;
case 136:
#line 368 "gramatica.y"
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
case 137:
#line 383 "gramatica.y"
{AnalizadorLexico.agregarEstructura("Reconoce Funcion sin cuerpo");}
break;
case 138:
#line 387 "gramatica.y"
{AnalizadorLexico.agregarEstructura("Reconoce funcion IMPL");}
break;
case 139:
#line 388 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba un '{' ");}
break;
case 140:
#line 389 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba un '}' ");}
break;
#line 1411 "y.tab.c"
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
