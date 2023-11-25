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
   35,   35,    8,    8,    8,    8,   11,   11,   11,   36,
   36,    9,    9,    9,    9,    9,    9,    3,    3,   37,
   37,   37,   38,   38,   38,   23,   23,   39,   40,   16,
   32,   18,   18,   18,
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
    2,    2,    2,    3,    3,    2,    2,    2,    3,    2,
    2,    2,    3,    3,    3,    4,    2,    2,    2,    1,
    1,    3,    3,    3,    3,    3,    2,    4,    4,    3,
    3,    3,    3,    3,    3,    2,    3,    3,    2,    2,
    2,    7,    7,    7,
};
short yydefred[] = {                                      0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
   33,   32,   34,    0,  121,    0,   35,   36,   38,    0,
  120,    0,    0,    5,    6,    7,    0,   15,   12,   11,
   13,   14,    0,   21,   24,   25,   26,   52,    0,   92,
   93,    0,    0,    0,    0,   27,    0,    0,    0,    0,
  119,   51,  117,  118,  139,    0,   97,    0,    0,    0,
    0,    0,   30,    0,    0,    0,    8,   39,   37,   40,
    2,    0,    4,    0,   23,    0,    0,    0,    0,    0,
  127,    0,  140,    1,    0,    0,    0,   53,    0,    0,
   44,   47,   50,    0,    0,    0,    0,    0,   82,    0,
    0,    0,    0,    0,   78,    0,    0,    0,  114,    0,
   10,  115,  113,    0,    0,    3,  125,  123,  124,  126,
    0,  103,    0,  102,  101,    0,    0,    0,    0,    0,
    0,   28,    0,    0,    0,  136,   90,   91,   89,   88,
    0,    0,   86,   87,    0,    0,    0,    0,    0,    0,
   60,    0,   58,    0,   81,   80,   84,   83,   76,    0,
    0,    0,   77,    0,   72,    0,  128,    0,  116,   31,
    0,    0,    0,    0,    0,    0,   18,   17,    0,  138,
    0,    9,    0,  137,    0,    0,    0,    0,   45,   48,
   46,   49,    0,    0,   71,    0,    0,    0,    0,    0,
   85,    0,    0,    0,    0,    0,  100,   99,   98,  112,
  108,  110,  106,  111,  107,    0,    0,    0,    0,   19,
   16,  134,  135,  133,   56,   55,   54,    0,    0,    0,
    0,    0,    0,    0,   59,   57,   96,   74,   75,   73,
    0,    0,    0,  109,    0,  105,  104,   69,   68,   67,
   65,    0,   64,   61,   70,   66,   63,  143,    0,  144,
  142,   94,   62,
};
short yydgoto[] = {                                       3,
   22,   23,   24,   25,   26,   27,   28,   29,   30,   31,
   32,  131,   33,   47,   34,   35,   36,   37,   66,   38,
   89,   90,   91,   39,   93,   50,  145,   60,  102,  103,
   40,   41,   42,   80,  176,   43,    0,  136,   83,   44,
};
short yysindex[] = {                                   -109,
   71,   71,    0, -249,  -37,  240, -240, -224, -107, -211,
    0,    0,    0,  -39,    0,   51,    0,    0,    0, -241,
    0,   21,   64,    0,    0,    0,  -42,    0,    0,    0,
    0,    0, -220,    0,    0,    0,    0,    0,  -42,    0,
    0,  -32,  -18,  -10,   46,    0,   56,  165,  165,  212,
    0,    0,    0,    0,    0,  -32,    0,  180,  173, -143,
 -144,   93,    0, -136,  -41,   81,    0,    0,    0,    0,
    0,   99,    0,  252,    0,   56,  246,   26,  238,   22,
    0, -188,    0,    0, -119,  106,  -30,    0,  467,    5,
    0,    0,    0,  467,  -34,   49, -162,   30,    0,   61,
   62,   29,  205,   -4,    0, -112,  -29,  100,    0,  -25,
    0,    0,    0,   13, -113,    0,    0,    0,    0,    0,
   18,    0, -110,    0,    0, -108,  147, -104,  116,  118,
  -72,    0, -103,  165,  -36,    0,    0,    0,    0,    0,
  209,  209,    0,    0,  165,  209,  209,  165, -169, -173,
    0,  212,    0,  147,    0,    0,    0,    0,    0,  120,
    0,  126,    0,   66,    0,  165,    0, -105,    0,    0,
  133,   24,   67,   73,   74,   96,    0,    0,  131,    0,
  132,    0,   19,    0,  -20,    5,    5,   43,    0,    0,
    0,    0,    3, -107,    0,  212,  212,   85, -187,  122,
    0,   52,   53,   55,  -77,  -77,    0,    0,    0,    0,
    0,    0,    0,    0,    0,  142,  -88,  154,  155,    0,
    0,    0,    0,    0,    0,    0,    0,  -68,  -59,  -58,
   86, -156,  -57, -147,    0,    0,    0,    0,    0,    0,
   79,  -32, -101,    0,  161,    0,    0,    0,    0,    0,
    0,  -53,    0,    0,    0,    0,    0,    0,   22,    0,
    0,    0,    0,
};
short yyrindex[] = {                                      0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,  -19,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,   87,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,   91,    0,    0,    0,    0,
    0,    0,    0,    0,    0,   92,    0,    0,    0,   98,
    0,    0,    0,    0,    0,  492,    0,    0,    0,  454,
    0,    0,    0,    0,  -19,    0,    0,    0,    0,    0,
    0,    0,  -27,    0,    0,    0,    0,    0,    0,   -2,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
   60,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
  -11,    0,    0,    0,    0,  163,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,  497,  502,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,   48,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,
};
short yygindex[] = {                                      0,
  207,    6,    0,  -28,  429,  523,    0,  148,    0,    0,
    0,    0,   23,  178,    0,    0,    0,    0,    0,    0,
  527,  -22,    0,  501,  -24,  107,  119,  -15,  -33,    0,
  -78,    0,  -67,  -54,   69,   16,    0,    0,    0,    0,
};
#define YYTABLESIZE 775
short yytable[] = {                                     113,
   65,   98,   49,   20,  184,   65,   64,   79,   20,  135,
   49,   64,  165,    2,   65,   59,   79,  206,   21,   46,
  224,   96,  142,  261,  141,  106,   20,   72,   55,  101,
  101,   56,   82,   82,   97,   75,   68,   69,   70,  156,
   20,   51,   74,  227,   57,  142,  146,  141,   46,   82,
   72,  147,  180,  169,   77,  142,   21,  141,    9,  222,
  142,  142,  141,  141,  209,   20,  122,    4,  235,   61,
  162,  236,    7,    8,  160,  101,   10,   11,   12,   13,
  128,   21,  196,  225,  197,  142,  129,  141,  194,  195,
   20,   95,  150,  151,   67,  152,  153,   79,  174,  253,
  123,  126,  254,  122,  156,  158,   21,   73,  256,  204,
  211,  257,   82,   81,   85,   20,  213,  215,  186,  187,
  107,  190,  192,  198,  108,  174,  241,  243,  234,  252,
   22,   21,  110,  109,   29,   20,  199,  242,  242,  115,
   20,  141,  116,  163,  127,   71,    1,  218,   58,  132,
  205,  133,  154,  159,  260,  170,   21,  168,  171,  177,
  172,  178,  164,  201,   63,  182,   20,  229,  231,  202,
   84,  218,   95,  207,  220,  221,  238,  239,  228,  240,
  230,  232,   21,    4,    8,  244,  245,  259,    7,    8,
  248,   20,   10,   11,   12,   13,  128,  246,  247,  249,
  250,  255,  179,  258,  262,  263,  129,   21,   45,   20,
   76,  111,  148,  167,  112,    0,   62,   20,   48,    0,
  217,   62,  200,   78,   20,  134,  166,   86,   79,   63,
   62,   15,   86,   21,   87,  223,   17,   18,   19,   87,
   21,   17,   18,   19,   81,   82,  237,   79,   82,   20,
   52,  161,    5,   20,   51,    6,   20,   82,  226,   17,
   18,   19,   82,   81,   95,   21,   82,   82,   82,   15,
  100,    9,   21,   17,   18,   19,    4,    5,  125,  208,
    6,    7,    8,    9,   20,   10,   11,   12,   13,   14,
   20,   11,   12,   13,   15,   16,   20,  105,   17,   18,
   19,    4,    5,   95,  149,    6,    7,    8,    9,    0,
   10,   11,   12,   13,   14,  122,  155,  157,  122,   15,
   16,  203,  210,   17,   18,   19,    4,    5,  212,  214,
    6,    7,    8,    9,   59,   10,   11,   12,   13,   14,
  233,  251,   22,    0,   15,   16,   29,   20,   17,   18,
   19,    4,    5,  141,    0,    6,    7,    8,    0,    0,
   10,   11,   12,   13,   14,    0,    0,    0,    0,   15,
  216,    0,    0,   17,   18,   19,    0,    4,    5,    0,
    0,    6,    7,    8,    0,    0,   10,   11,   12,   13,
   14,    0,    0,    0,    0,   15,  216,    0,    0,   17,
   18,   19,    4,    5,    0,    0,    6,    7,    8,    0,
    0,   10,   11,   12,   13,   14,    0,    0,    0,    0,
   15,  173,    0,    0,   17,   18,   19,    0,   99,    5,
    0,    0,    6,   86,    0,   99,    5,    0,    0,    6,
   87,   95,   17,   18,   19,    0,   15,  104,   95,    0,
   17,   18,   19,   15,  100,    0,    0,   17,   18,   19,
    0,    5,    0,    0,    6,    0,    0,   58,    5,    0,
    0,    6,    0,   95,    0,    0,    0,   86,   15,    0,
   95,    0,   17,   18,   19,   15,   17,   18,   19,   17,
   18,   19,    0,  124,   43,   51,   43,   43,   43,    0,
    0,  120,    0,   11,   12,   13,   54,  117,   52,  142,
  130,  141,    0,   43,   86,   43,   53,   17,   18,   19,
   86,   87,    0,   17,   18,   19,  143,    0,  144,   17,
   18,   19,   51,   51,   51,   51,   51,   42,   51,   42,
   42,   42,   41,   81,   41,   41,   41,    0,   92,   92,
    0,   51,    0,   51,    0,  175,   42,    0,   42,  181,
    0,   41,    0,   41,    0,   92,    0,    0,    0,    0,
   88,   88,    0,    0,  119,   94,    0,   92,    0,    0,
    0,    0,  175,    0,    0,    0,    0,   88,    0,    0,
    0,  114,    0,    0,    0,    0,  118,    0,    0,   88,
    0,    0,    0,  121,  219,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,  219,    0,
    0,    0,    0,    0,   92,   92,    0,    0,    0,    0,
    0,   92,   92,    0,    0,   92,  189,  191,   92,    0,
    0,    0,    0,    0,    0,    0,   88,   88,    0,    0,
  183,  185,    0,   88,   88,    0,   92,   88,   88,   88,
   88,  188,    0,    0,  193,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,   88,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,   43,
    0,    0,   43,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,   43,   43,   43,   43,    0,    0,    0,
    0,    0,    0,    0,    0,    0,  137,  138,  139,  140,
    0,    0,    0,    0,    0,    0,    0,   51,    0,    0,
   51,    0,   42,    0,    0,   42,    0,   41,    0,    0,
   41,   51,   51,   51,   51,    0,   42,   42,   42,   42,
    0,   41,   41,   41,   41,
};
short yycheck[] = {                                      41,
   40,   56,   40,   45,   41,   40,   46,   40,   45,   40,
   40,   46,  125,  123,   40,  123,   44,  123,   61,  269,
   41,   50,   43,  125,   45,   59,   45,   22,  269,   58,
   59,  256,   44,   45,   50,  256,  278,  279,  280,   44,
   45,   61,   27,   41,  269,   43,   42,   45,  269,   61,
   45,   47,  125,   41,   39,   43,   61,   45,   61,   41,
   43,   43,   45,   45,   41,   45,   41,  256,  256,  281,
  104,  259,  261,  262,  103,  104,  265,  266,  267,  268,
  269,   61,  256,   41,  258,   43,  275,   45,  258,  259,
   45,   44,   44,  256,   44,  258,  259,  125,  127,  256,
   78,   79,  259,   44,   44,   44,   61,   44,  256,   44,
   44,  259,  123,  125,   59,   45,   44,   44,  141,  142,
  264,  146,  147,  152,  269,  154,  205,  206,   44,   44,
   44,   61,  269,   41,   44,   44,  152,  205,  206,   59,
   45,   44,   44,  256,  123,  125,  256,  176,  256,  269,
  256,   46,  123,  125,  256,  269,   61,   58,  269,   44,
  269,   44,  275,   44,  269,  269,   45,  196,  197,   44,
  125,  200,  125,   41,   44,   44,  125,  125,  194,  125,
  196,  197,   61,  256,  262,   44,  275,  242,  261,  262,
  259,   45,  265,  266,  267,  268,  269,   44,   44,  259,
  259,  259,  275,  125,   44,  259,   44,   61,    2,   45,
   33,   64,   94,  107,  256,   -1,  256,   45,  256,   -1,
  125,  256,  154,  256,   45,  256,  256,  269,  256,  269,
  256,  274,  269,   61,  276,  256,  278,  279,  280,  276,
   61,  278,  279,  280,  256,  257,  125,  275,  260,   45,
  269,  256,  257,   45,  274,  260,   45,  269,  256,  278,
  279,  280,  274,  275,  269,   61,  278,  279,  280,  274,
  275,  274,   61,  278,  279,  280,  256,  257,   41,  256,
  260,  261,  262,  263,   45,  265,  266,  267,  268,  269,
   45,  266,  267,  268,  274,  275,   45,  125,  278,  279,
  280,  256,  257,  256,  256,  260,  261,  262,  263,   -1,
  265,  266,  267,  268,  269,  256,  256,  256,  259,  274,
  275,  256,  256,  278,  279,  280,  256,  257,  256,  256,
  260,  261,  262,  263,  123,  265,  266,  267,  268,  269,
  256,  256,  256,   -1,  274,  275,  256,  256,  278,  279,
  280,  256,  257,  256,   -1,  260,  261,  262,   -1,   -1,
  265,  266,  267,  268,  269,   -1,   -1,   -1,   -1,  274,
  275,   -1,   -1,  278,  279,  280,   -1,  256,  257,   -1,
   -1,  260,  261,  262,   -1,   -1,  265,  266,  267,  268,
  269,   -1,   -1,   -1,   -1,  274,  275,   -1,   -1,  278,
  279,  280,  256,  257,   -1,   -1,  260,  261,  262,   -1,
   -1,  265,  266,  267,  268,  269,   -1,   -1,   -1,   -1,
  274,  275,   -1,   -1,  278,  279,  280,   -1,  256,  257,
   -1,   -1,  260,  269,   -1,  256,  257,   -1,   -1,  260,
  276,  269,  278,  279,  280,   -1,  274,  275,  269,   -1,
  278,  279,  280,  274,  275,   -1,   -1,  278,  279,  280,
   -1,  257,   -1,   -1,  260,   -1,   -1,  256,  257,   -1,
   -1,  260,   -1,  269,   -1,   -1,   -1,  269,  274,   -1,
  269,   -1,  278,  279,  280,  274,  278,  279,  280,  278,
  279,  280,   -1,  256,   41,  256,   43,   44,   45,   -1,
   -1,  256,   -1,  266,  267,  268,    6,  256,  269,   43,
   82,   45,   -1,   60,  269,   62,  277,  278,  279,  280,
  269,  276,   -1,  278,  279,  280,   60,   -1,   62,  278,
  279,  280,   41,   42,   43,   44,   45,   41,   47,   43,
   44,   45,   41,   43,   43,   44,   45,   -1,   48,   49,
   -1,   60,   -1,   62,   -1,  127,   60,   -1,   62,  131,
   -1,   60,   -1,   62,   -1,   65,   -1,   -1,   -1,   -1,
   48,   49,   -1,   -1,   74,   49,   -1,   77,   -1,   -1,
   -1,   -1,  154,   -1,   -1,   -1,   -1,   65,   -1,   -1,
   -1,   65,   -1,   -1,   -1,   -1,   74,   -1,   -1,   77,
   -1,   -1,   -1,   77,  176,   -1,   -1,   -1,   -1,   -1,
   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,
   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,  200,   -1,
   -1,   -1,   -1,   -1,  134,  135,   -1,   -1,   -1,   -1,
   -1,  141,  142,   -1,   -1,  145,  146,  147,  148,   -1,
   -1,   -1,   -1,   -1,   -1,   -1,  134,  135,   -1,   -1,
  134,  135,   -1,  141,  142,   -1,  166,  145,  146,  147,
  148,  145,   -1,   -1,  148,   -1,   -1,   -1,   -1,   -1,
   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,  166,   -1,
   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,
   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,  256,
   -1,   -1,  259,   -1,   -1,   -1,   -1,   -1,   -1,   -1,
   -1,   -1,   -1,  270,  271,  272,  273,   -1,   -1,   -1,
   -1,   -1,   -1,   -1,   -1,   -1,  270,  271,  272,  273,
   -1,   -1,   -1,   -1,   -1,   -1,   -1,  256,   -1,   -1,
  259,   -1,  256,   -1,   -1,  259,   -1,  256,   -1,   -1,
  259,  270,  271,  272,  273,   -1,  270,  271,  272,  273,
   -1,  270,  271,  272,  273,
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
#line 597 "gramatica.y"
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
#line 686 "y.tab.c"
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
{yyval = new NodoComun("Sentencia",(Nodo)yyvsp[-2],(Nodo)yyvsp[-1]);}
break;
case 106:
#line 434 "gramatica.y"
{yyval=yyvsp[-1];}
break;
case 107:
#line 435 "gramatica.y"
{yyval= new NodoHoja("sentencia declarativa");}
break;
case 108:
#line 436 "gramatica.y"
{yyval = new NodoHoja("RETURN");}
break;
case 109:
#line 437 "gramatica.y"
{yyval = new NodoComun("Sentencia",(Nodo)yyvsp[-2],(Nodo)yyvsp[-1]);}
break;
case 110:
#line 438 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba una ',' al final de la linea ");}
break;
case 111:
#line 439 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba una ',' al final de la linea ");}
break;
case 112:
#line 440 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba una ',' al final de la linea ");}
break;
case 113:
#line 443 "gramatica.y"
{yyval=new NodoHoja(yyvsp[-2].sval);
                             Token funcion = TablaSimbolos.buscarPorAmbito(yyvsp[-2].sval + ":" + ambitoAct);
                             if (funcion == null){
                                agregarErrorSemantico("La funcion " + yyvsp[-2].sval + " nunca fue declarada");
                             }

				            AnalizadorLexico.agregarEstructura("Reconoce llamado funcion ");
				            TablaSimbolos.removeToken(yyvsp[-2].sval);
				            }
break;
case 114:
#line 452 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba un '(' ");}
break;
case 115:
#line 453 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba un ')' ");}
break;
case 116:
#line 454 "gramatica.y"
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
case 117:
#line 470 "gramatica.y"
{yyval = new NodoControl("PRINT", new NodoHoja(yyvsp[0].sval));
                             AnalizadorLexico.agregarEstructura("Reconoce salida de mensaje por pantalla ");}
break;
case 118:
#line 472 "gramatica.y"
{yyval = new NodoControl("PRINT", new NodoHoja(yyvsp[0].sval));
                            AnalizadorLexico.agregarEstructura("Reconoce salida de mensaje por pantalla ");}
break;
case 119:
#line 474 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("La funcion PRINT no acepta esa declaracion ");}
break;
case 120:
#line 477 "gramatica.y"
{yyval=yyvsp[0];}
break;
case 121:
#line 478 "gramatica.y"
{yyval=yyvsp[0];}
break;
case 122:
#line 481 "gramatica.y"
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
case 123:
#line 503 "gramatica.y"
{AnalizadorLexico.agregarEstructura("Reconoce asignacion ");
	                                                        yyval = new NodoComun(yyvsp[-1].sval,(Nodo)yyvsp[-2],(Nodo)yyvsp[0]);}
break;
case 124:
#line 506 "gramatica.y"
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
case 125:
#line 524 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba un valor seguido del operador ");}
break;
case 126:
#line 525 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba un valor seguido del operador ");}
break;
case 127:
#line 526 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba un operando del lado izquierdo ");}
break;
case 128:
#line 529 "gramatica.y"
{yyval=new NodoComun("DO UNTIL", (Nodo)yyvsp[-2] ,(Nodo)yyvsp[0]);
                                                        AnalizadorLexico.agregarEstructura("Reconoce funcion DO UNTIL");}
break;
case 129:
#line 531 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba una condicion ");}
break;
case 130:
#line 536 "gramatica.y"
{yyval = yyvsp[-1];}
break;
case 131:
#line 537 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba un '(' ");}
break;
case 132:
#line 538 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba un ')' ");}
break;
case 133:
#line 541 "gramatica.y"
{yyval = yyvsp[-1];}
break;
case 134:
#line 542 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba un '(' ");}
break;
case 135:
#line 543 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba un ')' ");}
break;
case 136:
#line 546 "gramatica.y"
{yyval = new NodoControl("TOD",(Nodo)yyvsp[0]);
                                            AnalizadorLexico.agregarEstructura("Reconoce funcion TOD ");
                                            }
break;
case 137:
#line 550 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba una Expresion ");}
break;
case 139:
#line 557 "gramatica.y"
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
case 140:
#line 578 "gramatica.y"
{deshacerAmbito();}
break;
case 141:
#line 581 "gramatica.y"
{AnalizadorLexico.agregarEstructura("Reconoce Funcion sin cuerpo");}
break;
case 142:
#line 585 "gramatica.y"
{AnalizadorLexico.agregarEstructura("Reconoce funcion IMPL"); TablaSimbolos.removeToken(yyvsp[-4].sval);}
break;
case 143:
#line 586 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba un '{' ");}
break;
case 144:
#line 587 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba un '}' ");}
break;
#line 1687 "y.tab.c"
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
