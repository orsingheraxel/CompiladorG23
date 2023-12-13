#ifndef lint
static char yysccsid[] = "@(#)yaccpar	1.8 (Berkeley) 01/20/90";
#endif
#define YYBYACC 1
#line 2 "gramatica.y"
package a.AnalisisLexico;
import a.AnalisisLexico.ParserVal;
import b.GeneracionCodigoIntermedio.*;
import a.AnalisisLexico.AccionesSemanticas.AccionSemantica;
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
    0,    0,    1,    1,    1,    2,    2,    2,    5,    6,
    4,    4,    4,    4,    4,    4,   12,   12,   12,   12,
    3,    3,    3,    3,    3,    3,    3,    3,   14,   14,
   17,   20,   20,   13,   13,   13,   21,   21,   21,   21,
   21,   21,   22,   22,   22,   22,   23,   23,   23,   23,
   23,   23,   25,   25,   26,   27,   27,   27,    9,    9,
    9,    9,    9,    9,    9,    9,    9,    9,    9,    9,
    9,    9,    9,    9,   29,   29,   29,   29,   29,   29,
   30,   31,   31,   31,   31,   28,   28,   28,   28,   28,
   28,   15,   15,   32,   32,   32,   32,   34,   35,   35,
   35,   35,   35,   35,   36,   36,   36,   36,   36,    7,
    7,    7,    7,   10,   10,   10,   37,   37,    8,    8,
    8,    8,    8,    8,   11,   11,   11,   11,   11,   11,
   38,   38,   38,   24,   24,   19,   16,   16,   33,   39,
   18,   18,   18,
};
short yylen[] = {                                         2,
    3,    3,    3,    2,    2,    1,    1,    2,    3,    3,
    1,    1,    1,    1,    1,    1,    3,    2,    2,    3,
    2,    1,    2,    2,    1,    1,    1,    1,    1,    3,
    2,    1,    3,    1,    1,    1,    1,    1,    2,    1,
    2,    2,    3,    3,    1,    1,    3,    3,    1,    3,
    3,    1,    1,    1,    1,    5,    5,    5,    6,    4,
    5,    7,    8,    7,    4,    6,    7,    7,    7,    7,
    7,    7,    7,    5,    3,    5,    5,    3,    3,    2,
    1,    1,    2,    2,    3,    1,    1,    1,    1,    1,
    1,    1,    1,    7,    7,    5,    6,    2,    4,    4,
    4,    2,    2,    2,    3,    2,    2,    2,    2,    3,
    3,    3,    4,    2,    2,    2,    1,    1,    3,    3,
    3,    3,    3,    2,    4,    4,    5,    5,    4,    4,
    3,    3,    3,    2,    3,    2,    6,    4,    2,    4,
    4,    3,    3,
};
short yydefred[] = {                                      0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
   35,   34,   36,    0,  118,    0,   37,   38,   40,    0,
    0,  117,    0,    0,    6,    7,    0,   15,   12,   11,
   13,   14,   16,    0,   22,   25,   26,   27,    0,   54,
    0,   92,   93,    0,    0,    0,    0,   29,    0,    0,
    0,    0,    0,    0,  116,   53,  114,  115,  136,    0,
   98,    0,    0,    0,    0,    0,    0,    0,   32,    0,
    0,    0,    8,    0,   41,   39,   42,    2,    0,    5,
    4,    0,   24,    0,    0,    0,    0,    0,    0,  124,
    0,    1,    0,  142,    0,    0,    0,   55,    0,    0,
   46,   49,   52,    0,    0,    0,    0,    0,   82,    0,
    0,    0,    0,   80,    0,    0,    0,    0,    0,  111,
    0,   10,  112,  110,    0,    0,  143,    3,  122,  120,
  121,    0,    0,    0,    0,  123,    0,  104,    0,  103,
  102,    0,    0,    0,   30,    0,    0,    0,  134,   90,
   91,   89,   88,    0,    0,   86,   87,    0,    0,    0,
    0,    0,    0,   65,    0,   60,    0,  129,   84,   83,
   78,    0,   79,    0,   75,  130,    0,    0,  125,  140,
  113,   33,   19,   18,    0,    0,  138,    0,    0,    0,
    0,    0,    0,    0,    0,  141,    9,    0,  135,    0,
    0,    0,    0,   47,   50,   48,   51,    0,    0,   74,
    0,    0,   61,    0,    0,    0,   85,    0,    0,    0,
  127,    0,   20,   17,  101,  100,   99,  109,  106,  108,
  107,    0,    0,    0,  132,  133,  131,   58,   57,   56,
    0,    0,    0,    0,    0,    0,    0,   66,   59,   97,
   77,   76,  137,    0,    0,  105,   72,   71,   70,   68,
    0,   67,   62,   73,   69,   64,   95,   94,   63,
};
short yydgoto[] = {                                       3,
   23,   24,   25,   26,   27,   28,   29,   30,   31,   32,
   33,  135,   34,   49,   35,   36,   37,   38,   39,   72,
   40,   99,  100,  101,   41,  103,   54,  158,   66,  112,
  113,   42,   43,   44,   89,  195,   45,  149,   46,
};
short yysindex[] = {                                   -110,
   89,   89,    0, -221,   -9,  187, -242, -227,  143, -238,
    0,    0,    0,  -38,    0,    3,    0,    0,    0, -190,
 -148,    0,  -11,   34,    0,    0,  -58,    0,    0,    0,
    0,    0,    0, -218,    0,    0,    0,    0,  -47,    0,
  -58,    0,    0,   -8,   93,  -29,   14,    0,   21,  -20,
   -8,  140,  140,  168,    0,    0,    0,    0,    0,   -8,
    0,  217,  -22,  315,  -34, -182, -173,   72,    0, -152,
  -41,   49,    0, -133,    0,    0,    0,    0,   80,    0,
    0,  214,    0,   21,  -70,  135,   69,  269,   13,    0,
 -190,    0, -142,    0,   13,   87,   -3,    0,  345,   10,
    0,    0,    0,  345,  242,   41, -166,   19,    0,   -9,
   42,   18,  175,    0, -108,   -9, -120,    4,  103,    0,
    5,    0,    0,    0,   20, -124,    0,    0,    0,    0,
    0, -118,  105,  121, -109,    0,   11,    0, -101,    0,
    0, -100,  118,   50,    0,  -95,  140,  -36,    0,    0,
    0,    0,    0,  172,  172,    0,    0,  140,  172,  172,
  140, -171, -140,    0,  168,    0,  118,    0,    0,    0,
    0,  132,    0,   53,    0,    0,    9,  140,    0,    0,
    0,    0,    0,    0,  -43,  133,    0,  134,  141,  -35,
   55,  137,  -73,  -72,   39,    0,    0,   23,    0,   17,
   10,   10,   36,    0,    0,    0,    0,   28, -102,    0,
  168,  168,    0,   59, -233,   64,    0,   68,   75,  140,
    0,   76,    0,    0,    0,    0,    0,    0,    0,    0,
    0,  150,  -69,  158,    0,    0,    0,    0,    0,    0,
  -56,  -51,  -48,   60, -189,   26, -161,    0,    0,    0,
    0,    0,    0,   82,  165,    0,    0,    0,    0,    0,
   63,    0,    0,    0,    0,    0,    0,    0,    0,
};
short yyrindex[] = {                                      0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,  -50,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,   67,    0,
    0,    0,    0,    0,    0,    0,    0,    0,   78,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,  -50,    0,    0,    0,    0,    0,    0,    0,
    0,   84,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,   85,    0,    0,    0,    0,   91,    0,
    0,    0,    0,    0,    0,  416,    0,    0,    0,  444,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,  -85,    0,    0,    0,    0,    0,    0,    0,
  -49,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,  -37,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,  170,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,  166,  179,    0,    0,    0,    0,    0,    0,
  469,  489,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,  284,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,   30,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,  228,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,
};
short yygindex[] = {                                      0,
  310,  518,  -52,  589,  684,    0,  278,    0,    0,    0,
    0,    0,   33,  319,    0,    0,    0,    0,    0,    0,
    0,  429,  -53,    0,  551,  -19,  -88,  255,  -39,  297,
    0,   15,    0,   16,   -5,  198,   -2,    0,    0,
};
#define YYTABLESIZE 904
short yytable[] = {                                     124,
  222,   71,   22,   21,  199,  227,  119,   70,   21,  117,
   53,    9,    2,   20,  107,  187,  175,   71,   50,   51,
   64,  168,  248,   70,   82,  249,   59,  176,   60,  179,
   53,   88,  134,   21,   74,   51,  148,   83,   86,   81,
    8,   61,   67,   53,   71,   95,   73,   48,   53,   22,
   48,  159,   20,  155,  108,  154,  160,  237,   21,  155,
  181,  154,  155,  235,  154,  155,  262,  154,  240,  263,
  155,    8,  154,   96,   22,   85,  238,   81,  155,   93,
  154,  118,  188,   21,  163,  170,  209,  210,  221,  164,
  193,  165,  166,   91,  265,  119,  219,  266,   73,   22,
  201,  202,  247,  261,   94,  144,   51,  126,   21,  138,
   28,   20,  120,   78,  193,  211,  121,  212,  213,  139,
  142,   23,  127,  128,   22,  215,  145,   31,   21,   75,
   76,   77,  146,   21,  139,  143,   20,   21,   92,  205,
  207,  167,  171,  177,  182,    1,    4,  173,  183,   22,
   69,    7,    8,  105,   96,   10,   11,   12,   13,  185,
  180,   20,   21,  233,  184,  186,  174,  189,  190,  241,
   81,  243,  245,  197,  196,  217,  223,  224,   22,   21,
  229,  225,  230,  231,   21,    4,   20,   21,  250,   81,
    7,    8,  251,  254,   10,   11,   12,   13,  132,  252,
  253,  256,  257,   22,  133,  255,  267,  258,  268,    6,
  259,   20,   21,  126,  123,   15,   21,   68,  119,   21,
  226,  119,    7,   53,    9,   69,  119,   96,   22,  116,
   69,   21,   96,   68,   97,   22,   17,   18,   19,   97,
   20,   17,   18,   19,    4,    5,   52,   87,    6,    7,
    8,    9,  147,   10,   11,   12,   13,   14,   21,  178,
   68,   21,   15,   16,  220,   64,   17,   18,   19,    4,
    5,    8,  236,    6,    7,    8,    9,   22,   10,   11,
   12,   13,   14,  239,  264,   96,   21,   15,   16,   80,
   64,   17,   18,   19,    4,    5,  162,  169,    6,    7,
    8,    9,   22,   10,   11,   12,   13,   14,  218,  141,
  228,   47,   15,  232,  246,  260,   17,   18,   19,    4,
    5,  269,   28,    6,    7,    8,    9,  128,   10,   11,
   12,   13,   14,   23,   11,   12,   13,   15,   16,   31,
   21,   17,   18,   19,    4,    5,  139,  122,    6,    7,
    8,    9,   84,   10,   11,   12,   13,   14,  161,   21,
  115,   56,   15,   16,  216,    0,   17,   18,   19,    0,
   17,   18,   19,    4,    5,   22,    0,    6,    7,    8,
    9,    0,   10,   11,   12,   13,   14,  155,    0,  154,
  136,   15,  191,    0,    0,   17,   18,   19,   62,    5,
    0,    0,    6,   96,  156,    9,  157,    0,   96,    0,
   97,   63,   17,   18,   19,   97,   15,   17,   18,   19,
   17,   18,   19,  105,    5,  126,    0,    6,  126,    0,
    9,    5,    0,  126,    6,    0,   63,    9,    0,  114,
   96,   15,   55,   63,    0,   17,   18,   19,   15,   17,
   18,   19,   17,   18,   19,   56,   53,   53,   53,   53,
   53,    0,   53,   57,   17,   18,   19,    0,    0,  129,
    0,    0,  109,    5,    0,   53,    6,   53,    0,    9,
  110,  104,   96,    0,   45,   63,   45,   45,   45,    0,
   15,   17,   18,   19,   17,   18,   19,  109,    5,  125,
    0,    6,    0,   45,    9,   45,    0,    0,    0,   44,
   63,   44,   44,   44,  137,   15,    0,    0,    0,   17,
   18,   19,    0,    0,  140,    0,    0,    0,   44,   43,
   44,   43,   43,   43,   11,   12,   13,    0,    0,  128,
   79,    0,  128,    0,    0,    0,    0,  128,   43,    0,
   43,    0,    0,    0,    0,    0,   58,    0,    0,    0,
    0,    0,    0,    0,   79,    0,    0,    0,    0,    0,
  109,    5,    0,    0,    6,  198,  200,    9,    0,    0,
    0,    0,    0,   63,    0,    0,  203,    0,   15,  208,
    0,    0,   17,   18,   19,   90,    0,   65,    0,    0,
    0,    0,  102,  102,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,  150,  151,  152,  153,    0,    0,
    0,  102,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,  131,    0,    0,    0,  102,    0,    0,    0,
    0,    0,  106,    0,    0,    0,    0,    0,    0,    0,
  111,    0,  111,    0,    0,    0,    0,    0,    0,    0,
  192,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,   53,    0,    0,   53,    0,    0,    0,    0,   53,
    0,    0,    0,    0,  192,   53,   53,   53,   53,    0,
    0,    0,    0,  111,    0,    0,    0,  102,  102,   45,
    0,  172,   45,    0,  102,  102,    0,   45,  102,  204,
  206,  102,  234,   45,   45,   45,   45,    0,    0,    0,
    0,    0,    0,    0,   44,    0,    0,   44,  102,    0,
    0,  194,   44,  234,    0,   98,   98,    0,   44,   44,
   44,   44,    0,    0,   43,    0,    0,   43,    0,    0,
    0,    0,   43,  214,   98,  194,    0,    0,   43,   43,
   43,   43,    0,    0,    0,  130,    0,    0,    0,   98,
  102,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,  242,
  244,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
   98,   98,    0,    0,    0,    0,    0,   98,   98,    0,
    0,   98,   98,   98,   98,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,   98,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,   98,
};
short yycheck[] = {                                      41,
   44,   40,   61,   45,   41,   41,   44,   46,   45,   44,
   61,   61,  123,  123,   54,  125,  125,   40,    4,    4,
  123,  110,  256,   46,   27,  259,  269,  116,  256,  118,
   40,   40,   85,   45,   20,   20,   40,  256,   41,  125,
  262,  269,  281,   40,   40,   51,   44,  269,   40,   61,
  269,   42,  123,   43,   60,   45,   47,   41,   45,   43,
   41,   45,   43,   41,   45,   43,  256,   45,   41,  259,
   43,  262,   45,   44,   61,  123,   41,   44,   43,   59,
   45,  264,  135,   45,   44,   44,  258,  259,  177,  256,
  143,  258,  259,  123,  256,  269,   44,  259,   44,   61,
  154,  155,   44,   44,  125,   91,   91,   59,   45,   41,
   44,  123,   41,  125,  167,  256,  269,  258,  259,   87,
   88,   44,  256,   44,   61,  165,  269,   44,   44,  278,
  279,  280,   46,   45,   44,  123,  123,   45,  125,  159,
  160,  123,  125,  264,  269,  256,  256,  256,   44,   61,
  269,  261,  262,  256,  125,  265,  266,  267,  268,  269,
   58,  123,   45,  125,   44,  275,  275,  269,  269,  209,
  256,  211,  212,  269,  125,   44,   44,   44,   61,   45,
   44,   41,  256,  256,   45,  256,  123,   45,  125,  275,
  261,  262,  125,   44,  265,  266,  267,  268,  269,  125,
  125,   44,  259,   61,  275,  275,  125,  259,   44,   44,
  259,  123,   45,   44,  256,  274,   45,  256,  256,   45,
  256,  259,   44,  274,  274,  269,  264,  269,   61,  264,
  269,   45,  269,  256,  276,   61,  278,  279,  280,  276,
  123,  278,  279,  280,  256,  257,  256,  256,  260,  261,
  262,  263,  256,  265,  266,  267,  268,  269,   45,  256,
  256,   45,  274,  275,  256,  123,  278,  279,  280,  256,
  257,   44,  256,  260,  261,  262,  263,   61,  265,  266,
  267,  268,  269,  256,  259,  256,   45,  274,  275,  256,
  123,  278,  279,  280,  256,  257,  256,  256,  260,  261,
  262,  263,   61,  265,  266,  267,  268,  269,  256,   41,
  256,    2,  274,  275,  256,  256,  278,  279,  280,  256,
  257,  259,  256,  260,  261,  262,  263,   44,  265,  266,
  267,  268,  269,  256,  266,  267,  268,  274,  275,  256,
  256,  278,  279,  280,  256,  257,  256,   70,  260,  261,
  262,  263,   34,  265,  266,  267,  268,  269,  104,   45,
   64,  269,  274,  275,  167,   -1,  278,  279,  280,   -1,
  278,  279,  280,  256,  257,   61,   -1,  260,  261,  262,
  263,   -1,  265,  266,  267,  268,  269,   43,   -1,   45,
  256,  274,  275,   -1,   -1,  278,  279,  280,  256,  257,
   -1,   -1,  260,  269,   60,  263,   62,   -1,  269,   -1,
  276,  269,  278,  279,  280,  276,  274,  278,  279,  280,
  278,  279,  280,  256,  257,  256,   -1,  260,  259,   -1,
  263,  257,   -1,  264,  260,   -1,  269,  263,   -1,  125,
  269,  274,  256,  269,   -1,  278,  279,  280,  274,  278,
  279,  280,  278,  279,  280,  269,   41,   42,   43,   44,
   45,   -1,   47,  277,  278,  279,  280,   -1,   -1,  256,
   -1,   -1,  256,  257,   -1,   60,  260,   62,   -1,  263,
  264,   53,  269,   -1,   41,  269,   43,   44,   45,   -1,
  274,  278,  279,  280,  278,  279,  280,  256,  257,   71,
   -1,  260,   -1,   60,  263,   62,   -1,   -1,   -1,   41,
  269,   43,   44,   45,   86,  274,   -1,   -1,   -1,  278,
  279,  280,   -1,   -1,  256,   -1,   -1,   -1,   60,   41,
   62,   43,   44,   45,  266,  267,  268,   -1,   -1,  256,
   23,   -1,  259,   -1,   -1,   -1,   -1,  264,   60,   -1,
   62,   -1,   -1,   -1,   -1,   -1,    6,   -1,   -1,   -1,
   -1,   -1,   -1,   -1,   47,   -1,   -1,   -1,   -1,   -1,
  256,  257,   -1,   -1,  260,  147,  148,  263,   -1,   -1,
   -1,   -1,   -1,  269,   -1,   -1,  158,   -1,  274,  161,
   -1,   -1,  278,  279,  280,   45,   -1,    9,   -1,   -1,
   -1,   -1,   52,   53,   -1,   -1,   -1,   -1,   -1,   -1,
   -1,   -1,   -1,   -1,  270,  271,  272,  273,   -1,   -1,
   -1,   71,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,
   -1,   -1,   82,   -1,   -1,   -1,   86,   -1,   -1,   -1,
   -1,   -1,   54,   -1,   -1,   -1,   -1,   -1,   -1,   -1,
   62,   -1,   64,   -1,   -1,   -1,   -1,   -1,   -1,   -1,
  143,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,
   -1,  256,   -1,   -1,  259,   -1,   -1,   -1,   -1,  264,
   -1,   -1,   -1,   -1,  167,  270,  271,  272,  273,   -1,
   -1,   -1,   -1,  105,   -1,   -1,   -1,  147,  148,  256,
   -1,  113,  259,   -1,  154,  155,   -1,  264,  158,  159,
  160,  161,  195,  270,  271,  272,  273,   -1,   -1,   -1,
   -1,   -1,   -1,   -1,  256,   -1,   -1,  259,  178,   -1,
   -1,  143,  264,  216,   -1,   52,   53,   -1,  270,  271,
  272,  273,   -1,   -1,  256,   -1,   -1,  259,   -1,   -1,
   -1,   -1,  264,  165,   71,  167,   -1,   -1,  270,  271,
  272,  273,   -1,   -1,   -1,   82,   -1,   -1,   -1,   86,
  220,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,
   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,
   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,  211,
  212,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,
   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,
   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,
  147,  148,   -1,   -1,   -1,   -1,   -1,  154,  155,   -1,
   -1,  158,  159,  160,  161,   -1,   -1,   -1,   -1,   -1,
   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,
   -1,  178,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,
   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,
   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,
   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,
   -1,   -1,   -1,  220,
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
"ListSentencias : Sentencia error",
"Sentencia : SentenciaDeclarativa",
"Sentencia : SentenciaEjecutable",
"Sentencia : RETURN ','",
"ReferenciaObjeto : ID '.' ID",
"ReferenciaObjetoFuncion : ID '.' LlamadoFuncion",
"SentenciaEjecutable : Asignacion",
"SentenciaEjecutable : LlamadoFuncion",
"SentenciaEjecutable : BloqueIF",
"SentenciaEjecutable : SalidaMensaje",
"SentenciaEjecutable : ReferenciaObjetoFuncion",
"SentenciaEjecutable : SentenciaControl",
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
"SentenciaDeclarativa : EncabezadoClase",
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
"BloqueIF : IF Condicion SentenciaEjecutable ',' END_IF",
"BloqueIF : IF Condicion SentenciaEjecutable ',' ELSE CuerpoIF END_IF",
"BloqueIF : IF Condicion SentenciaEjecutable ',' ELSE SentenciaEjecutable ',' END_IF",
"BloqueIF : IF Condicion CuerpoIF ELSE SentenciaEjecutable ',' END_IF",
"BloqueIF : IF Condicion CuerpoIF error",
"BloqueIF : IF Condicion CuerpoIF ELSE CuerpoIF error",
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
"Funcion : EncabezadoFuncion Parametro '{' ListSentenciasFuncion '}' RETURN ','",
"Funcion : EncabezadoFuncion Parametro '{' ListSentenciasFuncion RETURN ',' '}'",
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
"SentenciaControl : DO SentenciaEjecutable ',' UNTIL Condicion",
"SentenciaControl : DO SentenciaEjecutable ',' UNTIL error",
"SentenciaControl : DO error UNTIL Condicion",
"SentenciaControl : DO SentenciaEjecutable UNTIL Condicion",
"ParametroTOD : '(' Expresion ')'",
"ParametroTOD : error Expresion ')'",
"ParametroTOD : '(' Expresion error",
"ConversionExplicita : TOD ParametroTOD",
"ConversionExplicita : TOD '(' ')'",
"EncabezadoClase : CLASS ID",
"Clase : EncabezadoClase '{' ListSentenciasClase ID ',' '}'",
"Clase : EncabezadoClase '{' ListSentenciasClase '}'",
"FuncionSinCuerpo : EncabezadoFuncion Parametro",
"EncabezadoIMPL : IMPL FOR ID ':'",
"FuncionIMPL : EncabezadoIMPL '{' Funcion '}'",
"FuncionIMPL : error Funcion '}'",
"FuncionIMPL : '{' Funcion error",
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
#line 676 "gramatica.y"
  public NodoControl raiz;
  private String ambitoAct = "main";
  private String claseAct;
  private static boolean funcion_autoInvocada;
  static List<Error> erroresSemanticos = new ArrayList<Error>();
  static List<String> variables_declaradas = new ArrayList<String>();
  static String tipoActual;
  static List<Nodo> parametros = new ArrayList<Nodo>();
  static List<String> clases_forward_declaration = new ArrayList<String>(); //utiliada para asegurarnos que una clase delcarada tambien este implementada
  static List<String> clases_declaradas = new ArrayList<String>();
  static List<Funcion> funciones_declaradas = new ArrayList<Funcion>();  //utilizada para chequear que no haya autoinvocaciones y demas
  static List<Nodo> funciones = new ArrayList<Nodo>(); //utilizada para almacenar las funciones que luego se imprimiran en main
  static Map<String,Boolean> comprobacion_uso_variables = new HashMap<String,Boolean>(); //cada vez q se declara variable se guarda lexema, si se usa del lado derecho en el ambito boolean=true.

  static Map<String, String> clase_hijo_padre = new HashMap<String, String>();
  static ArrayList<String> listaFunciones = new ArrayList<String>();
  static Map<String, ArrayList<String>> funcionesClases = new HashMap<String, ArrayList<String>>();
  static ArrayList<String> listaAtributos = new ArrayList<String>();
  static Map<String, ArrayList<String>> atributosClases = new HashMap<String, ArrayList<String>>(); //utilizado para chequear que una clase que hereda no sobreescriba atributos de la clase padre

  public NodoControl getRaiz(){
  	return this.raiz;
  }

  public static boolean getFuncionAutoInvocada(){
    return funcion_autoInvocada;
  }

  public List<Nodo> getFunciones(){
        return funciones;
  }

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

      public void chequearAtributosRepetidos(String a, String b){
           ArrayList<String> hijo = atributosClases.get(a);
           ArrayList<String> padre = atributosClases.get(b);
            if ((hijo != null)&&(padre!=null)) {
               for (String atributo : hijo)
                    if (padre.contains(atributo)) {
                               agregarErrorSemantico ("Una clase que hereda no puede sobreescribir atributos del padre ");
                               hijo.remove(atributo);
                               TablaSimbolos.removeToken(atributo+":"+ambitoAct+":"+a);
                               break;
                    }
            }
      }

     NodoComun controlarTipos(Nodo n1, String op, Nodo n3 ){
         NodoComun aux = null;
         if ((n1 == null) || (n3==null)) {
             agregarErrorSemantico("Incompatibilidad de tipos ");
             return null;
         }
         if (n1.getTipo().equals(n3.getTipo())){
                 aux = new NodoComun(op,n1,n3);
                 aux.setTipo(n1.getTipo());

         }else {
                 if ((n1.getTipo().equals("USHORT") || n1.getTipo().equals("INT")) && (n3.getTipo().equals("USHORT")|| n3.getTipo().equals("INT")))
                 {
                         agregarErrorSemantico("Incompatibilidad de tipos ");
                         aux = new NodoComun(op,n1,n3);
                         aux.setTipo(n1.getTipo());
                 }else{
                   aux = new NodoComun(op,n1,n3);
                   aux.setTipo(n1.getTipo());
                   agregarErrorSemantico("Incompatibilidad de tipos, es necesario un casteo ");}
         }
         return aux;
 }

public Nodo getNodoParametro(String m){
    for (Nodo n : parametros){
        if (n.getLexema().contains(m)){
            return n;
        }
    }
    return null;
}

public boolean padreTieneAtributo (String clase,String atributo){
    //String clasePadre = clase_hijo_padre.get(clase);
    ArrayList<String> atributosPadre = atributosClases.get(clase);

    atributo = atributo.substring(0, atributo.indexOf(":"));

    if ((atributosPadre!=null)&&(atributosPadre.contains(atributo)))
        return true;
    return false;
}

NodoComun controlarTiposAsignacion(Nodo n1, String asig, Nodo n3)
{ 
        NodoComun aux = null;
                if ((n1 == null) || (n3==null)) {
                          return null;
                }
                if (n1.getTipo()==null){
                    n1 = getNodoParametro(n1.getLexema());
                }

                if (!((n1==null)||(n3==null))) {
                  if (n1.getTipo().equals(n3.getTipo())) {
                    aux = new NodoComun(asig, n1, n3);
                    aux.setTipo(n1.getTipo());

                  } else {
                    if (n1.getTipo().equals("USHORT") || n1.getTipo().equals("INT")) {
                      agregarErrorSemantico("Incompatibilidad de tipos ");
                      aux = new NodoComun(asig, n1, n3);
                      aux.setTipo(n1.getTipo());
                    }
                  }
                }else{agregarErrorSemantico("Incompatibilidad de tipos, es necesario un casteo ");
                      aux = new NodoComun(asig, n1, n3);
                      aux.setTipo(n1.getTipo());}
                  return aux;
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
           /*String nombreClase = t.getTipo();
           return TablaSimbolos.buscarPorAmbito(nombreClase + ":" + ambitoAct);*/
           String nombreClase = t.getLexema();
           return TablaSimbolos.buscarPorAmbito(nombreClase+":"+ambitoAct);
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

   public boolean tieneFuncion(String clase, String funcion){

        if (clase != null){
            ArrayList<String> funcionesClase = funcionesClases.get(clase);
            if !(funcionesClase.isEmpty())
                for (String f : funcionesClase)
                    if (f.equals(funcion))
                        return true;
        }
        return false;
   }

  public int yylex() throws IOException{
    Token t = AnalizadorLexico.obtenerToken();
    this.yylval = new ParserVal(t.getLexema());
    return t.getId();
  }

  public static void yyerror(String error){
    System.out.println(error);
  }
#line 835 "y.tab.c"
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
{ for (String c : clases_forward_declaration){
                                        if (!(clases_declaradas.contains(c))){
                                            agregarErrorSemantico("La clase "+c+" fue declarada, pero no fue implementada");
                                        }
                                    }
                                    raiz = new NodoControl("PROGRAMA", (Nodo)yyvsp[-1].obj);
                                    AnalizadorLexico.agregarEstructura("Reconoce programa ");}
break;
case 2:
#line 25 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se espera '{' ");}
break;
case 3:
#line 28 "gramatica.y"
{yyval.obj = new NodoComun("SENTENCIA", (Nodo) yyvsp[-2].obj, (Nodo) yyvsp[-1].obj);}
break;
case 4:
#line 29 "gramatica.y"
{yyval.obj=yyvsp[-1].obj;}
break;
case 5:
#line 30 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba una ',' ");}
break;
case 7:
#line 34 "gramatica.y"
{yyval.obj=yyvsp[0].obj;}
break;
case 8:
#line 35 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("RETURN definido fuera de funcion ");}
break;
case 9:
#line 38 "gramatica.y"
{TablaSimbolos.removeToken(yyvsp[-2].sval);
                            TablaSimbolos.removeToken(yyvsp[0].sval);

                            Token clase = obtenerClase(yyvsp[-2].sval + ":" + ambitoAct);
                            String nombreClase = clase.getLexema().substring(clase.getLexema().lastIndexOf(":") + 1);
                            String lexemaAtributoHijo = yyvsp[0].sval + ":" + ambitoAct + ":"+ nombreClase;

                            Token atributoPadre = null;

                            if (padreTieneAtributo(nombreClase,lexemaAtributoHijo)){
                                String lexemaAtributoPadre = yyvsp[0].sval + ":" + ambitoAct + ":"+ nombreClase;
                                atributoPadre = TablaSimbolos.getToken(lexemaAtributoPadre);
                            }

                            Token atributo = TablaSimbolos.getToken(lexemaAtributoHijo);
                            if (clase == null) {
                                agregarErrorSemantico("El objeto " + yyvsp[-2].sval + " no existe");
                            }
                            else {
                                if ((atributo == null) && (atributoPadre == null)){
                                    agregarErrorSemantico("Atributo de clase no existe");
                                }
                            }
                            Nodo a = new NodoHoja(yyvsp[0].sval);
                            if (atributo != null)
                                a.setTipo(atributo.getTipo());
                            if (atributoPadre != null)
                                a.setTipo(atributoPadre.getTipo());
                            yyval.obj = new NodoComun("REFERENCIA ATRIBUTO OBJETO",new NodoHoja(yyvsp[-2].sval), a);
                            AnalizadorLexico.agregarEstructura("Reconoce llamado a atributo");
                            }
break;
case 10:
#line 71 "gramatica.y"
{ Nodo a = ((Nodo)yyvsp[0].obj).getDer();
                                                String nombreFuncion = a.getLexema();

                                                Token clase = obtenerClase(yyvsp[-2].sval + ":" + ambitoAct);
                                                String nombreClase = clase.getLexema().substring(clase.getLexema().lastIndexOf(":") + 1);

                                                String clasePadre = clases_hijo_padre.get(clase);

                                                if ((tieneFuncion(nombreClase,nombreFuncion))||(tieneFuncion(clasePadre,nombreFuncion))){

                                                    if ((TablaSimbolos.getToken(yyvsp[-2].sval +":"+ambitoAct))==null)
                                                        agregarErrorSemantico("Atributo de clase " + yyvsp[-2].sval + " no existe ");
                                                    else{
                                                        String m = (String)yyvsp[-2].sval;
                                                        Nodo a = new NodoHoja(m);
                                                        yyval.obj = new NodoComun("REFERENCIA FUNCION OBJETO",a,(Nodo)yyvsp[0].obj);
                                                        AnalizadorLexico.agregarEstructura("Reconoce llamado a funcion de clase ");
                                                    }
                                                }else{agregarErrorSemantico("La funcion no esta al alcance ");}
                                                TablaSimbolos.removeToken(yyvsp[-2].sval);
                                                }
break;
case 11:
#line 94 "gramatica.y"
{yyval.obj=yyvsp[0].obj;}
break;
case 12:
#line 95 "gramatica.y"
{yyval.obj=yyvsp[0].obj;}
break;
case 13:
#line 96 "gramatica.y"
{yyval.obj=yyvsp[0].obj;}
break;
case 14:
#line 97 "gramatica.y"
{yyval.obj=yyvsp[0].obj;}
break;
case 15:
#line 98 "gramatica.y"
{yyval.obj=yyvsp[0].obj;}
break;
case 16:
#line 99 "gramatica.y"
{yyval.obj=yyvsp[0].obj;}
break;
case 19:
#line 104 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("RETURN definido fuera de funcion ");}
break;
case 20:
#line 105 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("RETURN definido fuera de funcion ");}
break;
case 21:
#line 108 "gramatica.y"
{
						for (String var : variables_declaradas) {
							Token t = TablaSimbolos.getToken(var);
							if (!(TablaSimbolos.existeSimbolo(var+ ":" + ambitoAct))){
							    t.setLexema(var + ":" + ambitoAct);
							    t.setAmbito(ambitoAct);
							    t.setUso("Variable");
							    t.setTipo(tipoActual);
							    TablaSimbolos.removeToken(var);
							    TablaSimbolos.addSimbolo(t.getLexema(),t);
							    comprobacion_uso_variables.put(t.getLexema(),false);
							    if (claseAct != null){
							        listaAtributos.add(var);
                                    atributosClases.put(claseAct, listaAtributos);
							    }
                            }
							else {
							    TablaSimbolos.removeToken(var);
							   agregarErrorSemantico("Ya existe una variable " + var +" definida en este ambito");
                                                	}
                                            	}
                                            	variables_declaradas.clear();
                        }
break;
case 23:
#line 132 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se espera el tipo de la variable ");}
break;
case 24:
#line 133 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se espera identificador de la variable ");}
break;
case 28:
#line 137 "gramatica.y"
{deshacerAmbito();}
break;
case 29:
#line 140 "gramatica.y"
{variables_declaradas.add(yyvsp[0].sval);}
break;
case 30:
#line 141 "gramatica.y"
{variables_declaradas.add(yyvsp[0].sval);}
break;
case 31:
#line 144 "gramatica.y"
{TablaSimbolos.removeToken(yyvsp[-1].sval);
                                   if (clases_declaradas.contains(yyvsp[-1].sval + ":" + ambitoAct)){
                                        for (String var : variables_declaradas) {
                                        Token t = TablaSimbolos.getToken(var);
                                        if (!(TablaSimbolos.existeSimbolo(var+ ":" + ambitoAct))){
                                            t.setLexema(var + ":" + ambitoAct);
                                            t.setAmbito(ambitoAct);
                                            t.setUso("Objeto");
                                            t.setTipo(yyvsp[-1].sval);
                                            TablaSimbolos.removeToken(var);
                                            TablaSimbolos.addSimbolo(t.getLexema(),t);
                                        }
                                        else {
                                            agregarErrorSemantico("Ya existe un objeto + var + definido en este ambito ");
                                        }
                                        }
                                        variables_declaradas.clear();
                                   }else{agregarErrorSemantico("La clase "+ yyvsp[-1].sval +" no esta definida ");}
                                   }
break;
case 32:
#line 165 "gramatica.y"
{variables_declaradas.add(yyvsp[0].sval);}
break;
case 33:
#line 166 "gramatica.y"
{variables_declaradas.add(yyvsp[0].sval);}
break;
case 34:
#line 168 "gramatica.y"
{tipoActual = yyvsp[0].sval;}
break;
case 35:
#line 169 "gramatica.y"
{tipoActual = yyvsp[0].sval;}
break;
case 36:
#line 170 "gramatica.y"
{tipoActual = yyvsp[0].sval;}
break;
case 37:
#line 173 "gramatica.y"
{
                    chequearEnteroPositivo(yyvsp[0].sval);
                    NodoHoja aux = new NodoHoja(yyvsp[0].sval);
                    aux.setTipo("INT");
                    aux.setUso("Constante");
                    aux.setAmbito(ambitoAct);
                    yyval.obj = aux;
                    Token t = TablaSimbolos.getToken(yyvsp[0].sval);
                    if (!(t==null)){
                        t.setTipo("INT");
                        t.setUso("Constante");
                        t.setAmbito(ambitoAct);
                        TablaSimbolos.removeToken(yyvsp[0].sval);
                        TablaSimbolos.addSimbolo(yyvsp[0].sval,t);
                    }
                   }
break;
case 38:
#line 190 "gramatica.y"
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
case 39:
#line 205 "gramatica.y"
{AnalizadorLexico.agregarErrorLexico("Un entero corto no puede ser negativo ");}
break;
case 40:
#line 206 "gramatica.y"
{
	                chequearDouble(yyvsp[0].sval);
	                NodoHoja aux = new NodoHoja(yyvsp[0].sval);
                    aux.setTipo("DOUBLE");
                    aux.setUso("Constante");
                    aux.setAmbito(ambitoAct);
                    yyval.obj = aux;
                    Token t = TablaSimbolos.getToken(yyvsp[0].sval);
                    if (!(t==null)){
                        t.setTipo("DOUBLE");
                        t.setUso("Constante");
                        t.setAmbito(ambitoAct);
                        TablaSimbolos.removeToken(yyvsp[0].sval);
                        TablaSimbolos.addSimbolo(yyvsp[0].sval,t);
                    }
                    }
break;
case 41:
#line 223 "gramatica.y"
{
                    chequearEnteroNegativo(yyvsp[0].sval);
                    NodoHoja aux = new NodoHoja(yyvsp[0].sval);
                    aux.setTipo("INT");
                    aux.setUso("Constante");
                    aux.setAmbito(ambitoAct);
                    yyval.obj = aux;
                    Token t = TablaSimbolos.getToken(yyvsp[0].sval);
                    if (!(t==null)){
                        t.setTipo("INT");
                        t.setUso("Constante");
                        t.setAmbito(ambitoAct);
                        TablaSimbolos.removeToken(yyvsp[0].sval);
                        TablaSimbolos.addSimbolo(yyvsp[0].sval,t);
                    }
	                }
break;
case 42:
#line 239 "gramatica.y"
{chequearDouble(yyvsp[0].sval);
                         NodoHoja aux = new NodoHoja(yyvsp[0].sval);
                         aux.setTipo("DOUBLE");
                         aux.setUso("Constante");
                         aux.setAmbito(ambitoAct);
                         yyval.obj = aux;
                         Token t = TablaSimbolos.getToken(yyvsp[0].sval);
                         if (!(t==null)){
                             t.setTipo("DOUBLE");
                             t.setUso("Constante");
                             t.setAmbito(ambitoAct);
                             TablaSimbolos.removeToken(yyvsp[0].sval);
                             TablaSimbolos.addSimbolo(yyvsp[0].sval,t);
                         }
                        }
break;
case 43:
#line 256 "gramatica.y"
{yyval.obj = controlarTipos((Nodo)yyvsp[-2].obj,yyvsp[-1].sval,(Nodo)yyvsp[0].obj);}
break;
case 44:
#line 257 "gramatica.y"
{yyval.obj = controlarTipos((Nodo)yyvsp[-2].obj,yyvsp[-1].sval,(Nodo)yyvsp[0].obj);}
break;
case 45:
#line 258 "gramatica.y"
{yyval.obj=yyvsp[0].obj;}
break;
case 46:
#line 259 "gramatica.y"
{yyval.obj=yyvsp[0].obj;}
break;
case 47:
#line 263 "gramatica.y"
{yyval.obj = controlarTipos((Nodo)yyvsp[-2].obj,yyvsp[-1].sval,(Nodo)yyvsp[0].obj);}
break;
case 48:
#line 265 "gramatica.y"
{yyval.obj = controlarTipos((Nodo)yyvsp[-2].obj,yyvsp[-1].sval,(Nodo)yyvsp[0].obj);}
break;
case 49:
#line 266 "gramatica.y"
{yyval.obj = yyvsp[0].obj;}
break;
case 50:
#line 267 "gramatica.y"
{yyval.obj = controlarTipos((Nodo)yyvsp[-2].obj,yyvsp[-1].sval,(Nodo)yyvsp[0].obj);}
break;
case 51:
#line 268 "gramatica.y"
{yyval.obj = controlarTipos((Nodo)yyvsp[-2].obj,yyvsp[-1].sval,(Nodo)yyvsp[0].obj);}
break;
case 52:
#line 269 "gramatica.y"
{yyval.obj=yyvsp[0].obj;}
break;
case 53:
#line 272 "gramatica.y"
{Nodo aux = new NodoHoja ((String)yyvsp[0].sval);
            TablaSimbolos.removeToken(yyvsp[0].sval);
            String var = yyvsp[0].sval + ":" + ambitoAct;
            var = getLexemaAlcance(var);
            if (var.equals(yyvsp[0].sval)){
                agregarErrorSemantico("Variable no declarada en este ambito ");
            }
            else {
                if((!TablaSimbolos.getUso(var).equals("Variable")) && (!TablaSimbolos.getUso(var).equals("Parametro"))){
                    agregarErrorSemantico("El ID en uso no es una variable ");
                }
                else {
                    aux.setTipo(TablaSimbolos.getTipo(var));
                    aux.setUso(TablaSimbolos.getUso(var));
                    aux.setAmbito(TablaSimbolos.getAmbito(var));
                }
            }
            yyval.obj = aux;
          }
break;
case 54:
#line 291 "gramatica.y"
{yyval.obj=yyvsp[0].obj;}
break;
case 55:
#line 295 "gramatica.y"
{yyval.obj=yyvsp[0].obj;}
break;
case 56:
#line 298 "gramatica.y"
{yyval.obj = controlarTipos((Nodo)yyvsp[-3].obj,yyvsp[-2].sval,(Nodo)yyvsp[-1].obj);}
break;
case 57:
#line 299 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba una ')' ");}
break;
case 58:
#line 300 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba una '(' ");}
break;
case 59:
#line 303 "gramatica.y"
{  yyval.obj = new NodoComun("CUERPO",(Nodo)yyvsp[-3].obj,(Nodo)yyvsp[-1].obj);
                                                        Nodo aux = (Nodo)yyval.obj;
                                                        yyval.obj = new NodoComun("IF",(Nodo)yyvsp[-4].obj,aux);
                                                        AnalizadorLexico.agregarEstructura("Reconoce IF ELSE");}
break;
case 60:
#line 307 "gramatica.y"
{yyval.obj = new NodoComun("IF",(Nodo)yyvsp[-2].obj,(Nodo)yyvsp[-1].obj);
	                                    AnalizadorLexico.agregarEstructura("Reconoce IF");}
break;
case 61:
#line 309 "gramatica.y"
{  yyval.obj = new NodoComun("IF",(Nodo)yyvsp[-3].obj,(Nodo)yyvsp[-2].obj);
         	                                            AnalizadorLexico.agregarEstructura("Reconoce IF");}
break;
case 62:
#line 311 "gramatica.y"
{   yyval.obj = new NodoComun("CUERPO",(Nodo)yyvsp[-4].obj,(Nodo)yyvsp[-1].obj);
                                                                        Nodo aux = (Nodo)yyval.obj;
                                                                        yyval.obj = new NodoComun("IF",(Nodo)yyvsp[-5].obj,aux);
                                                                        AnalizadorLexico.agregarEstructura("Reconoce IF ELSE");}
break;
case 63:
#line 315 "gramatica.y"
{yyval.obj = new NodoComun("CUERPO",(Nodo)yyvsp[-5].obj,(Nodo)yyvsp[-2].obj);
                                                                                    Nodo aux = (Nodo)yyval.obj;
                                                                                    yyval.obj = new NodoComun("IF",(Nodo)yyvsp[-6].obj,aux);
                                                                                    AnalizadorLexico.agregarEstructura("Reconoce IF ELSE");}
break;
case 64:
#line 319 "gramatica.y"
{   yyval.obj = new NodoComun("CUERPO",(Nodo)yyvsp[-4].obj,(Nodo)yyvsp[-2].obj);
                                                                        Nodo aux = (Nodo)yyval.obj;
                                                                        yyval.obj = new NodoComun("IF",(Nodo)yyvsp[-5].obj,aux);
                                                                        AnalizadorLexico.agregarEstructura("Reconoce IF ELSE");}
break;
case 65:
#line 326 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("IF mal definido ");}
break;
case 66:
#line 327 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba un END_IF ");}
break;
case 67:
#line 328 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba un END_IF ");}
break;
case 68:
#line 329 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba un END_IF ");}
break;
case 69:
#line 330 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba un END_IF ");}
break;
case 70:
#line 331 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba un ELSE ");}
break;
case 71:
#line 332 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba un ELSE");}
break;
case 72:
#line 333 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba una ',' ");}
break;
case 73:
#line 334 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba una ',' " );}
break;
case 74:
#line 335 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba una ',' ");}
break;
case 75:
#line 338 "gramatica.y"
{yyval.obj = yyvsp[-1].obj;}
break;
case 76:
#line 339 "gramatica.y"
{yyval.obj = yyvsp[-3].obj;}
break;
case 77:
#line 341 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Falta una ',' "); }
break;
case 78:
#line 342 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Falta un '{'"); }
break;
case 79:
#line 343 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Falta un '}'"); }
break;
case 80:
#line 344 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("No hay sentencias dentro de las llaves."); }
break;
case 81:
#line 347 "gramatica.y"
{yyval.obj=yyvsp[0].obj;}
break;
case 82:
#line 350 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Solo se aceptan sentencias ejecutables "); }
break;
case 83:
#line 351 "gramatica.y"
{yyval.obj=yyvsp[-1].obj;}
break;
case 84:
#line 352 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Falta una ',' "); }
break;
case 85:
#line 353 "gramatica.y"
{yyval.obj = new NodoComun("SENTENCIA", (Nodo) yyvsp[-2].obj, (Nodo) yyvsp[-1].obj);}
break;
case 86:
#line 356 "gramatica.y"
{yyval.sval=yyvsp[0].sval;}
break;
case 87:
#line 357 "gramatica.y"
{yyval.sval=yyvsp[0].sval;}
break;
case 88:
#line 358 "gramatica.y"
{yyval.sval=yyvsp[0].sval;}
break;
case 89:
#line 359 "gramatica.y"
{yyval.sval=yyvsp[0].sval;}
break;
case 90:
#line 360 "gramatica.y"
{yyval.sval=yyvsp[0].sval;}
break;
case 91:
#line 361 "gramatica.y"
{yyval.sval=yyvsp[0].sval;}
break;
case 94:
#line 368 "gramatica.y"
{agregarErrorSemantico("RETURN fuera de funcion");}
break;
case 95:
#line 369 "gramatica.y"
{  yyval.obj = (Nodo)yyvsp[-6].obj;
                                                                                String nombreFuncion=((Nodo)yyvsp[-6].obj).getLexema();
                                                                                if (claseAct!=null)
                                                                                    listaFunciones.add(nombreFuncion);
                                                                                deshacerAmbito();
                                                                                Nodo aux = new NodoComun("Funcion",(Nodo)yyvsp[-6].obj,(Nodo)yyvsp[-3].obj);
                                                                                funciones.add(aux);
                                                                                AnalizadorLexico.agregarEstructura("Reconoce declaracion de funcion ");}
break;
case 96:
#line 377 "gramatica.y"
{ yyval.obj = (Nodo)yyvsp[-4].obj;
                                                                    String nombreFuncion=((Nodo)yyvsp[-4].obj).getLexema();
                                                                    if (claseAct!=null)
                                                                        listaFunciones.add(nombreFuncion);
                                                                    deshacerAmbito();
                                                                    Nodo aux = new NodoComun("Funcion",(Nodo)yyvsp[-4].obj,(Nodo)yyvsp[-1].obj);
                                                                    funciones.add(aux);
                                                                    AnalizadorLexico.agregarEstructura("Reconoce declaracion de funcion ");}
break;
case 97:
#line 385 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba un nombre para la funcion ");}
break;
case 98:
#line 388 "gramatica.y"
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
                  yyval.obj = new NodoHoja(yyvsp[0].sval);
                  }
break;
case 99:
#line 406 "gramatica.y"
{    Token t = TablaSimbolos.getToken(yyvsp[-1].sval);
                                if (t != null){
                                	t.setLexema(yyvsp[-1].sval + ":" + ambitoAct);
                                	t.setAmbito(ambitoAct);
                                	t.setUso("Parametro");
                                	t.setTipo(tipoActual);
                                	TablaSimbolos.removeToken(yyvsp[-1].sval);
                                	TablaSimbolos.addSimbolo(t.getLexema(),t);
                                }
                                funciones_declaradas.get(funciones_declaradas.size() - 1).setParametro(t);
                                NodoHoja aux = new NodoHoja(yyvsp[-1].sval);
                                aux.setAmbito(ambitoAct);
                                aux.setTipo(tipoActual);
                                aux.setUso("Parametro");
                                parametros.add(aux);
                                yyval.obj = aux;
                           }
break;
case 100:
#line 423 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba un ')' ");}
break;
case 101:
#line 424 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba un '(' ");}
break;
case 102:
#line 425 "gramatica.y"
{yyval.obj = null;}
break;
case 103:
#line 426 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba un ')' ");}
break;
case 104:
#line 427 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba un '(' ");}
break;
case 105:
#line 433 "gramatica.y"
{yyval.obj = new NodoComun("SENTENCIA",(Nodo)yyvsp[-2].obj,(Nodo)yyvsp[-1].obj);}
break;
case 106:
#line 434 "gramatica.y"
{yyval.obj=yyvsp[-1].obj;}
break;
case 107:
#line 435 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba una ',' al final de la linea ");}
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
#line 440 "gramatica.y"
{yyval.obj=new NodoControl("LLAMADO FUNCION", new NodoHoja(yyvsp[-2].sval));
                            Token tokenFuncion = TablaSimbolos.buscarPorAmbito(yyvsp[-2].sval + ":" + ambitoAct);

                            String aux = yyvsp[-2].sval+":"+ambitoAct;

                            int lastIndex = aux.lastIndexOf(":");
                            if (lastIndex != -1) {
                                aux = aux.substring(0, lastIndex);   /*recorto del lexema la parte de la funcion*/
                            }                                        /*ya que sino no habra coincidencia en caso de autoinvocacion.*/
                                                                     /*Ejemplo: f:main:f no daria coincidencia.*/

                            Funcion a = new Funcion(aux, null);
                            if(funciones_declaradas.contains(a)){
                                funcion_autoInvocada = true;
                            }

                            if (tokenFuncion == null){
                                agregarErrorSemantico("La funcion " + yyvsp[-2].sval + " nunca fue declarada");
                            } else {
                                Funcion funcion = new Funcion(tokenFuncion.getLexema(), null);
                                if (funciones_declaradas.contains(funcion)) {
                                    int indice = funciones_declaradas.indexOf(funcion);
                                    Funcion f = funciones_declaradas.get(indice);
                                    if (f.getParametro() != null){
                                        agregarErrorSemantico("Se esperaba un parametro en la función ");
                                    }
                                }
                            }
				            AnalizadorLexico.agregarEstructura("Reconoce llamado funcion ");
				            TablaSimbolos.removeToken(yyvsp[-2].sval);
				            }
break;
case 111:
#line 471 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba un '(' ");}
break;
case 112:
#line 472 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba un ')' ");}
break;
case 113:
#line 473 "gramatica.y"
{
            			            NodoHoja nodo1 = new NodoHoja(yyvsp[-3].sval);
            			            Nodo n3 = (Nodo)yyvsp[-1].obj;
                                    Token tokenFuncion = TablaSimbolos.buscarPorAmbito(yyvsp[-3].sval + ":" + ambitoAct);

                                    String aux = yyvsp[-3].sval+":"+ambitoAct;

                                    int lastIndex = aux.lastIndexOf(":");
                                    if (lastIndex != -1) {
                                        aux = aux.substring(0, lastIndex);   /*recorto del lexema la parte de la funcion*/
                                    }                                        /*ya que sino no habra coincidencia en caso de autoinvocacion.*/
                                                                             /*Ejemplo: f:main:f no daria coincidencia.*/

                                    Funcion a = new Funcion(aux, null);
                                    if(funciones_declaradas.contains(a)){
                                        funcion_autoInvocada = true;
                                    }


                                    if (tokenFuncion == null){
                                    	agregarErrorSemantico("La funcion " + yyvsp[-3].sval + " nunca fue declarada");
                                    } else {
                                        Token tokenParametro = TablaSimbolos.getToken(n3.getLexema());
                                        Funcion funcion = new Funcion(tokenFuncion.getLexema(), null);
                                    	if (funciones_declaradas.contains(funcion)) {
                                            int indice = funciones_declaradas.indexOf(funcion);
                                            Funcion f = funciones_declaradas.get(indice);
                                            if (!(f.getParametro() == null)) {
                                                if (!(f.getParametro().getTipo().equals(n3.getTipo())) && (n3.getTipo() != null)){
                                                    agregarErrorSemantico("No coinciden los tipos del parametro real y el formal. Se esperaba un " + f.getParametro().getTipo() + ", se obtuvo un " + n3.getTipo());
                                                }else{n3.setAmbito(f.getParametro().getAmbito());
                                                      n3.setUso(f.getParametro().getUso());
                                                      /*f.setParametro(tokenParametro);  cambiamos parametro formal por el real*/
                                                      }
                                            }else{agregarErrorSemantico("La funcion invocada no lleva parametros ");}
                                        }
                                    }

                                    yyval.obj=new NodoControl("LLAMADO FUNCION", new NodoComun(yyvsp[-3].sval,null,n3));
                                    AnalizadorLexico.agregarEstructura("Reconoce llamado funcion ");
                                    TablaSimbolos.removeToken(yyvsp[-3].sval);
                                    }
break;
case 114:
#line 517 "gramatica.y"
{yyval.obj = new NodoControl("PRINT", new NodoHoja(yyvsp[0].sval));
                             AnalizadorLexico.agregarEstructura("Reconoce salida de mensaje por pantalla ");}
break;
case 115:
#line 519 "gramatica.y"
{yyval.obj = new NodoControl("PRINT", new NodoHoja(yyvsp[0].sval));
                            AnalizadorLexico.agregarEstructura("Reconoce salida de mensaje por pantalla ");}
break;
case 116:
#line 521 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("La funcion PRINT no acepta esa declaracion ");}
break;
case 117:
#line 524 "gramatica.y"
{yyval.obj=yyvsp[0].obj;}
break;
case 118:
#line 525 "gramatica.y"
{yyval.obj=yyvsp[0].obj;}
break;
case 119:
#line 528 "gramatica.y"
{AnalizadorLexico.agregarEstructura("Reconoce asignacion ");
                                                if (yyvsp[-1].sval.equals("="))
						                            yyval.obj = controlarTiposAsignacion((Nodo)yyvsp[-2].obj, "=", (Nodo)yyvsp[0].obj);
						                        else
						                            yyval.obj = controlarTiposAsignacion((Nodo)yyvsp[-2].obj, "+=", (Nodo)yyvsp[0].obj);


						                        }
break;
case 120:
#line 537 "gramatica.y"
{AnalizadorLexico.agregarEstructura("Reconoce asignacion ");
	                                                        Nodo a = ((Nodo)yyvsp[-2].obj).getDer();
	                                                        Nodo b = ((Nodo)yyvsp[0].obj).getDer();
	                                                        if (yyvsp[-1].sval.equals("="))
	                                                            yyval.obj = controlarTiposAsignacion(a, "=", b);
	                                                        else
	                                                            yyval.obj = controlarTiposAsignacion(a, "+=", b);}
break;
case 121:
#line 545 "gramatica.y"
{AnalizadorLexico.agregarEstructura("Reconoce asignacion ");
	                                                Nodo a = ((Nodo)yyvsp[-2].obj).getDer();
	                                                if (yyvsp[-1].sval.equals("="))
	                                                    yyval.obj = controlarTiposAsignacion(a, "=", (Nodo)yyvsp[0].obj);
                                                 	else
                                                 	    yyval.obj = controlarTiposAsignacion(a, "+=", (Nodo)yyvsp[0].obj);

                                                    }
break;
case 122:
#line 553 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba un valor seguido del operador ");}
break;
case 123:
#line 554 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba un valor seguido del operador ");}
break;
case 124:
#line 555 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba un operando del lado izquierdo ");}
break;
case 125:
#line 558 "gramatica.y"
{yyval.obj=new NodoComun("DO UNTIL", (Nodo)yyvsp[-2].obj ,(Nodo)yyvsp[0].obj);
                                                        AnalizadorLexico.agregarEstructura("Reconoce funcion DO UNTIL");}
break;
case 126:
#line 560 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba una condicion ");}
break;
case 127:
#line 561 "gramatica.y"
{yyval.obj = new NodoComun("DO UNTIL", (Nodo)yyvsp[-3].obj ,(Nodo)yyvsp[-1].obj);
                                                               AnalizadorLexico.agregarEstructura("Reconoce funcion DO UNTIL");}
break;
case 128:
#line 563 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba una condicion ");}
break;
case 129:
#line 564 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba una sentencia ejecutable ");}
break;
case 130:
#line 565 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba una ',' ");}
break;
case 131:
#line 571 "gramatica.y"
{yyval.obj = yyvsp[-1].obj;}
break;
case 132:
#line 572 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba un '(' ");}
break;
case 133:
#line 573 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba un ')' ");}
break;
case 134:
#line 576 "gramatica.y"
{((Nodo)yyvsp[0].obj).setTipo("DOUBLE");
                                            yyval.obj = (Nodo)yyvsp[0].obj;
                                            AnalizadorLexico.agregarEstructura("Reconoce funcion TOD ");
                                            }
break;
case 135:
#line 581 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba una Expresion ");}
break;
case 136:
#line 584 "gramatica.y"
{  if (!(clases_forward_declaration.contains(yyvsp[0].sval + ":" + ambitoAct)))  {
                                        clases_forward_declaration.add(yyvsp[0].sval + ":" + ambitoAct);

                                        Token var = TablaSimbolos.getToken(yyvsp[0].sval + ":" + ambitoAct);
                                        if (var != null) {
                                            if (var.getUso().equals("Clase")) {
                                                agregarErrorSemantico("Clase " + yyvsp[0].sval + " ya definida en el ambito actual");
                                                break;
                                            }
                                            agregarErrorSemantico("Este identificador ya fue utilizado en este ambito");
                                            yyval.sval= " ";
                                            break;
                                        }else{yyval.sval = yyvsp[0].sval;}
                                        Token t = TablaSimbolos.getToken(yyvsp[0].sval);
                                        if (t != null){
                                            t.setLexema(t.getLexema() + ":" + ambitoAct);
                                            t.setAmbito(ambitoAct);
                                            t.setUso("Clase");

                                            TablaSimbolos.addSimbolo(t.getLexema(),t);
                                        }
                                        tipoActual = yyvsp[0].sval;
                                        claseAct = yyvsp[0].sval;
                                        atributosClases.put(yyvsp[0].sval,null);
                                        actualizarAmbito(yyvsp[0].sval);}
                                     TablaSimbolos.removeToken(yyvsp[0].sval);


                            }
break;
case 137:
#line 614 "gramatica.y"
{
                                                deshacerAmbito();
                                                clases_declaradas.add(claseAct+":"+ambitoAct);
                                                if (yyvsp[-5].sval != " "){
                                                    if (clases_declaradas.contains(yyvsp[-2].sval+":"+ambitoAct)){
                                                        chequearAtributosRepetidos (yyvsp[-5].sval,yyvsp[-2].sval);

                                                    }
                                                }
                                                clase_hijo_padre.put(yyvsp[-2].sval,yyvsp[-5].sval);
                                                ArrayList<String> atributosCopia = new ArrayList<>(listaAtributos);
                                                ArrayList<String> funcionesCopia = new ArrayList<>(listaFunciones);

                                                String clase = claseAct;

                                                funcionesClases.put(clase, funcionesCopia);
                                                atributosClases.put(clase, atributosCopia);
                                                listaAtributos.clear();
                                                claseAct=null; /*lo vuelvo null para que no genere conflicto cuabdo guardo atributos de clase*/
                                              }
break;
case 138:
#line 635 "gramatica.y"
{deshacerAmbito();
                                          clases_declaradas.add(claseAct+":"+ambitoAct);
                                          ArrayList<String> atributosCopia = new ArrayList<>(listaAtributos);
                                          ArrayList<String> funcionesCopia = new ArrayList<>(listaFunciones);

                                          String clase = claseAct;

                                          funcionesClases.put(clase, funcionesCopia);
                                          atributosClases.put(clase, atributosCopia);
                                          listaAtributos.clear();
                                          claseAct=null;
                                          }
break;
case 139:
#line 649 "gramatica.y"
{ deshacerAmbito();
                                                AnalizadorLexico.agregarEstructura("Reconoce Funcion sin cuerpo");
                                               }
break;
case 140:
#line 655 "gramatica.y"
{  if (!(clases_declaradas.contains(yyvsp[-1].sval+":"+ambitoAct))){
                                        agregarErrorSemantico("La clase no esta definida ");
                                    }
                                    actualizarAmbito(yyvsp[-1].sval);
                                 }
break;
case 141:
#line 662 "gramatica.y"
{
                                                 Nodo n = (Nodo)yyvsp[-1].obj;
                                                 Funcion f = new Funcion(n.getLexema()+":"+ambitoAct ,null);
                                                 if (!(funciones_declaradas.contains(f)))
                                                        agregarErrorSemantico("La funcion declarada no fue definida ");
                                                 AnalizadorLexico.agregarEstructura("Reconoce funcion IMPL");

                                                 deshacerAmbito();
                                               }
break;
case 142:
#line 671 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba un '{' ");}
break;
case 143:
#line 672 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba un '}' ");}
break;
#line 1926 "y.tab.c"
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
