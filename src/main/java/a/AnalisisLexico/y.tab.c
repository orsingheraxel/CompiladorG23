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
    0,    0,    1,    1,    1,    2,    2,    2,    2,    6,
    7,    5,    5,    5,    5,    5,   12,   12,   12,   12,
    4,    4,    4,    4,    4,    4,    4,   14,   14,   17,
   19,   19,   13,   13,   13,   20,   20,   20,   20,   20,
   20,   21,   21,   21,   21,   22,   22,   22,   22,   22,
   22,   24,   24,   25,   26,   26,   26,   10,   10,   10,
   10,   10,   10,   10,   10,   10,   10,   10,   10,   10,
   10,   10,   10,   28,   28,   28,   28,   28,   28,   29,
   30,   30,   30,   30,   27,   27,   27,   27,   27,   27,
   15,   15,   31,   31,   31,   31,   31,   33,   34,   34,
   34,   34,   34,   34,   35,   35,   35,   35,   35,    8,
    8,    8,    8,   11,   11,   11,   36,   36,    9,    9,
    9,    9,    9,    9,    3,    3,    3,    3,    3,    3,
   37,   37,   37,   23,   23,   38,   39,   16,   32,   18,
   18,   18,
};
short yylen[] = {                                         2,
    3,    3,    3,    2,    2,    1,    1,    1,    2,    3,
    3,    1,    1,    1,    1,    1,    3,    2,    2,    3,
    2,    1,    2,    2,    1,    1,    1,    1,    3,    2,
    1,    3,    1,    1,    1,    1,    1,    2,    1,    2,
    2,    3,    3,    1,    1,    3,    3,    1,    3,    3,
    1,    1,    1,    1,    5,    5,    5,    6,    4,    5,
    7,    8,    7,    4,    6,    7,    7,    7,    7,    7,
    7,    7,    5,    3,    5,    5,    3,    3,    2,    1,
    1,    2,    2,    3,    1,    1,    1,    1,    1,    1,
    1,    1,    7,    7,    5,    6,    4,    2,    4,    4,
    4,    2,    2,    2,    3,    2,    2,    2,    2,    3,
    3,    3,    4,    2,    2,    2,    1,    1,    3,    3,
    3,    3,    3,    2,    4,    4,    5,    5,    4,    4,
    3,    3,    3,    2,    3,    3,    2,    2,    2,    7,
    7,    7,
};
short yydefred[] = {                                      0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
   34,   33,   35,    0,  118,    0,   36,   37,   39,    0,
  117,    0,    0,    6,    7,    8,    0,   16,   13,   12,
   14,   15,    0,   22,   25,   26,   27,   53,    0,   91,
   92,    0,    0,    0,    0,   28,    0,    0,    0,    0,
  116,   52,  114,  115,  137,    0,   98,    0,    0,    0,
    0,    0,    0,    0,   31,    0,    0,    0,    9,   40,
   38,   41,    2,    0,    5,    4,    0,   24,    0,    0,
    0,    0,    0,  124,    0,  138,    1,    0,    0,    0,
   54,    0,    0,   45,   48,   51,    0,    0,    0,    0,
    0,   81,    0,    0,    0,    0,   79,    0,    0,    0,
    0,    0,  111,    0,   11,  112,  110,    0,    0,    3,
  122,  120,  121,  123,    0,  104,    0,  103,  102,    0,
    0,    0,    0,    0,    0,   29,    0,    0,    0,  134,
   89,   90,   88,   87,    0,    0,   85,   86,    0,    0,
    0,    0,    0,    0,   64,    0,   59,    0,  129,   83,
   82,   77,    0,   78,    0,   74,  130,    0,    0,  125,
    0,  113,   32,    0,    0,    0,   97,    0,    0,    0,
    0,   19,   18,    0,  136,    0,   10,    0,  135,    0,
    0,    0,    0,   46,   49,   47,   50,    0,    0,   73,
    0,    0,   60,    0,    0,    0,   84,    0,    0,    0,
  127,    0,    0,  101,  100,   99,  109,  106,  108,  107,
    0,    0,    0,   20,   17,  132,  133,  131,   57,   56,
   55,    0,    0,    0,    0,    0,    0,    0,   65,   58,
   96,   76,   75,    0,    0,    0,    0,    0,  105,   71,
   70,   69,   67,    0,   66,   61,   72,   68,   63,  141,
    0,  142,  140,   94,   93,   62,
};
short yydgoto[] = {                                       3,
   22,   23,   24,   25,   26,   27,   28,   29,   30,   31,
   32,  135,   33,   47,   34,   35,   36,   37,   68,   38,
   92,   93,   94,   39,   96,   50,  149,   62,  105,  106,
   40,   41,   42,   83,  181,   43,  140,   86,   44,
};
short yysindex[] = {                                   -109,
  114,  114,    0, -245,  -27,  178, -238, -230,  164, -218,
    0,    0,    0,  -38,    0,    8,    0,    0,    0, -185,
    0,  -11,   34,    0,    0,    0,  -50,    0,    0,    0,
    0,    0, -229,    0,    0,    0,    0,    0,  -50,    0,
    0,  -22,  220,  -56,   14,    0,   12,  202,  202,  217,
    0,    0,    0,    0,    0,  -22,    0,  171,  -30,  342,
  -43, -187, -188,   65,    0, -173,  -41,   49,    0,    0,
    0,    0,    0,   68,    0,    0,  214,    0,   12,  185,
  144,  319,  -10,    0,  -63,    0,    0, -151,   94,  -20,
    0,  519,  -14,    0,    0,    0,  519,  267,   35, -215,
    9,    0,  -27,   41,   16,  292,    0, -113,  -27, -120,
  -15,   87,    0,   -8,    0,    0,    0,   25, -123,    0,
    0,    0,    0,    0,   62,    0, -118,    0,    0, -115,
   39, -112,  105,  116,  -89,    0, -111,  202,  -36,    0,
    0,    0,    0,    0,  239,  239,    0,    0,  202,  239,
  239,  202, -201, -176,    0,  217,    0,  139,    0,    0,
    0,    0,  117,    0,   42,    0,    0,   -3,  202,    0,
 -108,    0,    0,  122,    5,   47,    0,  126,  -82,  -74,
   64,    0,    0,  137,    0,  143,    0,   83,    0,    4,
  -14,  -14,   86,    0,    0,    0,    0,   10, -100,    0,
  217,  217,    0,   53, -221,   89,    0,   58,   63,  202,
    0,  -71,  -71,    0,    0,    0,    0,    0,    0,    0,
  150,  -80,  152,    0,    0,    0,    0,    0,    0,    0,
    0,  -62,  -58,  -52,   54, -183,  -51, -169,    0,    0,
    0,    0,    0,   85,  -22, -103,   88,  167,    0,    0,
    0,    0,    0,  -42,    0,    0,    0,    0,    0,    0,
  -10,    0,    0,    0,    0,    0,
};
short yyrindex[] = {                                      0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,   -1,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,   55,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,   -1,    0,
    0,    0,    0,    0,    0,    0,    0,   59,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,   60,    0,
    0,    0,   66,    0,    0,    0,    0,    0,  460,    0,
    0,    0,  470,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0, -104,    0,    0,    0,    0,
    0,    0,    0,   11,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,  -37,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,   67,    0,
    0,    0,    0,    0,    0,    0,    0,    0,  176,  228,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
  494,  514,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,   78,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,   30,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,  291,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,
};
short yygindex[] = {                                      0,
  334,  -16,    0,  -66,  534,  672,    0,  275,    0,    0,
    0,    0,    7,  314,    0,    0,    0,    0,    0,    0,
  -19,  -44,    0,  630,  -34,  -47,  251,  -33,  299,    0,
  -77,    0,  -75,  -53,  203,   15,    0,    0,    0,
};
#define YYTABLESIZE 882
short yytable[] = {                                     117,
  110,   67,  101,   20,  189,   74,  119,   66,   20,   67,
   21,  166,   49,    2,  213,   66,  100,   82,  134,  139,
   80,  263,   60,   46,   49,   56,   78,  150,   74,   97,
   55,   67,  151,   20,  239,  185,   49,  240,   57,   46,
  155,   77,  156,  157,  228,  216,  146,  118,  145,   21,
  231,   69,  146,   80,  145,  159,  199,  200,   20,   52,
  125,  167,   63,  170,  179,  172,   85,  146,  186,  145,
   88,   10,  255,   95,   21,  256,  111,   76,  154,  201,
  112,  202,  203,   20,  161,  209,  258,  127,  130,  259,
   69,  179,   70,   71,   72,  114,  238,  254,   23,   21,
  191,  192,   30,   21,  146,  113,  145,  119,   20,  139,
  126,  120,  131,   73,  178,  195,  197,  136,  188,  190,
  211,  128,  205,  226,   21,  146,  229,  145,  146,  193,
  145,  158,  198,   20,  244,  246,  245,  245,   87,  137,
  162,  178,  164,  168,  171,  173,    1,  212,  182,   21,
  174,   80,  262,  175,   95,   98,   65,  187,   20,  183,
  207,  165,  214,  177,  223,  232,    4,  234,  236,  218,
   80,    7,    8,  219,   21,   10,   11,   12,   13,  132,
  224,  220,  242,   20,  126,  184,  225,  243,  222,  223,
    8,  261,    4,  247,  248,  249,  250,    7,    8,   21,
  251,   10,   11,   12,   13,  132,  252,  257,   20,  260,
  265,  133,  264,  241,  116,   20,  266,   64,  119,    7,
  109,  119,   20,   15,   21,   64,  119,   89,   48,   20,
   65,   21,   89,   81,   90,  138,   17,   18,   19,   90,
  169,   17,   18,   19,    4,    5,   20,   64,    6,    7,
    8,    9,  210,   10,   11,   12,   13,   14,   20,  227,
  215,   20,   15,   16,   20,  230,   17,   18,   19,    4,
    5,    8,   52,    6,    7,    8,    9,   21,   10,   11,
   12,   13,   14,   20,   10,   95,   60,   15,   16,   75,
  153,   17,   18,   19,    4,    5,  160,  208,    6,    7,
    8,    9,  217,   10,   11,   12,   13,   14,  237,  253,
   23,   20,   15,  176,   30,   21,   17,   18,   19,    4,
    5,  139,  126,    6,    7,    8,    9,   21,   10,   11,
   12,   13,   14,  128,    9,   45,   20,   15,  221,   60,
  115,   17,   18,   19,    4,    5,   79,  152,    6,    7,
    8,    9,   21,   10,   11,   12,   13,   14,  108,  129,
  206,    0,   15,   16,    0,    0,   17,   18,   19,    4,
    5,    0,    0,    6,    7,    8,    9,    0,   10,   11,
   12,   13,   14,    0,    0,    0,   20,   15,   16,    0,
    0,   17,   18,   19,    4,    5,    0,    0,    6,    7,
    8,    9,   21,   10,   11,   12,   13,   14,    0,   11,
   12,   13,   15,  176,    0,    0,   17,   18,   19,   58,
    5,    0,    0,    6,    0,    0,  102,    5,    0,    0,
    6,    0,   59,   51,  103,    0,    0,   15,    0,   59,
  124,   17,   18,   19,   15,    0,   52,    0,   17,   18,
   19,    0,    0,   89,   53,   17,   18,   19,    0,    0,
   90,    0,   17,   18,   19,    0,  107,    0,    0,  121,
   89,    0,   98,    5,    0,    0,    6,   90,    0,   17,
   18,   19,   89,    0,    0,   59,    0,    0,   52,    0,
   15,   17,   18,   19,   17,   18,   19,   17,   18,   19,
   52,   52,   52,   52,   52,    0,   52,   89,    0,    0,
   44,    0,   44,   44,   44,    0,   17,   18,   19,   52,
    0,   52,  102,    5,    0,    0,    6,    0,    0,   44,
    0,   44,    0,    0,   43,   59,   43,   43,   43,    0,
   15,    0,   61,    0,   17,   18,   19,    0,    5,    0,
    0,    6,    0,   43,   42,   43,   42,   42,   42,    0,
   59,  146,    0,  145,    0,   15,    0,    0,    0,   17,
   18,   19,    0,   42,  128,   42,    0,    0,  147,    0,
  148,    0,    0,   99,   11,   12,   13,    0,    0,    0,
    0,  104,    0,  104,    0,    0,    0,  102,    5,    0,
    0,    6,    0,    0,    0,    0,    0,    0,    0,    0,
   59,    0,    0,    0,    0,   15,    0,    0,    0,   17,
   18,   19,    0,    0,    0,    0,    0,    0,    0,    0,
    0,  104,    0,    0,    0,   54,    0,    0,    0,  163,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,  180,    0,    0,    0,    0,    0,
    0,    0,   84,    0,    0,    0,    0,   95,   95,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,  204,
    0,  180,    0,    0,    0,    0,   95,    0,    0,    0,
    0,    0,    0,    0,    0,    0,  123,    0,    0,   95,
    0,    0,    0,    0,    0,   52,    0,    0,   52,   91,
   91,    0,    0,   52,    0,   44,    0,    0,   44,   52,
   52,   52,   52,   44,  233,  235,    0,    0,   91,   44,
   44,   44,   44,    0,    0,    0,    0,    0,  122,   43,
    0,   91,   43,    0,    0,    0,    0,   43,    0,    0,
    0,    0,    0,   43,   43,   43,   43,   95,   95,   42,
    0,    0,   42,    0,   95,   95,    0,   42,   95,  194,
  196,   95,    0,   42,   42,   42,   42,    0,  141,  142,
  143,  144,    0,    0,    0,    0,    0,    0,   95,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,   91,
   91,    0,    0,    0,    0,    0,   91,   91,    0,    0,
   91,   91,   91,   91,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,   95,
   91,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,   91,
};
short yycheck[] = {                                      41,
   44,   40,   56,   45,   41,   22,   44,   46,   45,   40,
   61,  125,   40,  123,  123,   46,   50,   40,   85,   40,
  125,  125,  123,  269,   40,  256,  256,   42,   45,   49,
  269,   40,   47,   45,  256,  125,   40,  259,  269,  269,
  256,   27,  258,  259,   41,   41,   43,   67,   45,   61,
   41,   44,   43,   39,   45,  103,  258,  259,   45,   61,
   80,  109,  281,  111,  131,   41,  123,   43,  135,   45,
   59,   61,  256,   44,   61,  259,  264,   44,   44,  256,
  269,  258,  259,   45,   44,   44,  256,   81,   82,  259,
   44,  158,  278,  279,  280,  269,   44,   44,   44,   61,
  145,  146,   44,   44,   43,   41,   45,   59,   45,   44,
   44,   44,  123,  125,  131,  150,  151,  269,  138,  139,
  168,   44,  156,   41,   61,   43,   41,   45,   43,  149,
   45,  123,  152,   45,  212,  213,  212,  213,  125,   46,
  125,  158,  256,  264,   58,  269,  256,  256,   44,   61,
  269,  256,  256,  269,  125,  256,  269,  269,   45,   44,
   44,  275,   41,  125,  181,  199,  256,  201,  202,   44,
  275,  261,  262,  256,   61,  265,  266,  267,  268,  269,
   44,  256,  125,   45,   41,  275,   44,  125,  125,  206,
  262,  245,  256,   44,  275,   44,  259,  261,  262,   61,
  259,  265,  266,  267,  268,  269,  259,  259,   45,  125,
   44,  275,  125,  125,  256,   45,  259,  256,  256,   44,
  264,  259,   45,  274,   61,  256,  264,  269,  256,   45,
  269,   61,  269,  256,  276,  256,  278,  279,  280,  276,
  256,  278,  279,  280,  256,  257,   45,  256,  260,  261,
  262,  263,  256,  265,  266,  267,  268,  269,   45,  256,
  256,   45,  274,  275,   45,  256,  278,  279,  280,  256,
  257,   44,  274,  260,  261,  262,  263,   61,  265,  266,
  267,  268,  269,   45,  274,  256,  123,  274,  275,  256,
  256,  278,  279,  280,  256,  257,  256,  256,  260,  261,
  262,  263,  256,  265,  266,  267,  268,  269,  256,  256,
  256,   45,  274,  275,  256,  256,  278,  279,  280,  256,
  257,  256,  256,  260,  261,  262,  263,   61,  265,  266,
  267,  268,  269,  256,   44,    2,   45,  274,  275,  123,
   66,  278,  279,  280,  256,  257,   33,   97,  260,  261,
  262,  263,   61,  265,  266,  267,  268,  269,   60,   41,
  158,   -1,  274,  275,   -1,   -1,  278,  279,  280,  256,
  257,   -1,   -1,  260,  261,  262,  263,   -1,  265,  266,
  267,  268,  269,   -1,   -1,   -1,   45,  274,  275,   -1,
   -1,  278,  279,  280,  256,  257,   -1,   -1,  260,  261,
  262,  263,   61,  265,  266,  267,  268,  269,   -1,  266,
  267,  268,  274,  275,   -1,   -1,  278,  279,  280,  256,
  257,   -1,   -1,  260,   -1,   -1,  256,  257,   -1,   -1,
  260,   -1,  269,  256,  264,   -1,   -1,  274,   -1,  269,
  256,  278,  279,  280,  274,   -1,  269,   -1,  278,  279,
  280,   -1,   -1,  269,  277,  278,  279,  280,   -1,   -1,
  276,   -1,  278,  279,  280,   -1,  125,   -1,   -1,  256,
  269,   -1,  256,  257,   -1,   -1,  260,  276,   -1,  278,
  279,  280,  269,   -1,   -1,  269,   -1,   -1,  269,   -1,
  274,  278,  279,  280,  278,  279,  280,  278,  279,  280,
   41,   42,   43,   44,   45,   -1,   47,  269,   -1,   -1,
   41,   -1,   43,   44,   45,   -1,  278,  279,  280,   60,
   -1,   62,  256,  257,   -1,   -1,  260,   -1,   -1,   60,
   -1,   62,   -1,   -1,   41,  269,   43,   44,   45,   -1,
  274,   -1,    9,   -1,  278,  279,  280,   -1,  257,   -1,
   -1,  260,   -1,   60,   41,   62,   43,   44,   45,   -1,
  269,   43,   -1,   45,   -1,  274,   -1,   -1,   -1,  278,
  279,  280,   -1,   60,  256,   62,   -1,   -1,   60,   -1,
   62,   -1,   -1,   50,  266,  267,  268,   -1,   -1,   -1,
   -1,   58,   -1,   60,   -1,   -1,   -1,  256,  257,   -1,
   -1,  260,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,
  269,   -1,   -1,   -1,   -1,  274,   -1,   -1,   -1,  278,
  279,  280,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,
   -1,   98,   -1,   -1,   -1,    6,   -1,   -1,   -1,  106,
   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,
   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,
   -1,   -1,   -1,   -1,  131,   -1,   -1,   -1,   -1,   -1,
   -1,   -1,   43,   -1,   -1,   -1,   -1,   48,   49,   -1,
   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,  156,
   -1,  158,   -1,   -1,   -1,   -1,   67,   -1,   -1,   -1,
   -1,   -1,   -1,   -1,   -1,   -1,   77,   -1,   -1,   80,
   -1,   -1,   -1,   -1,   -1,  256,   -1,   -1,  259,   48,
   49,   -1,   -1,  264,   -1,  256,   -1,   -1,  259,  270,
  271,  272,  273,  264,  201,  202,   -1,   -1,   67,  270,
  271,  272,  273,   -1,   -1,   -1,   -1,   -1,   77,  256,
   -1,   80,  259,   -1,   -1,   -1,   -1,  264,   -1,   -1,
   -1,   -1,   -1,  270,  271,  272,  273,  138,  139,  256,
   -1,   -1,  259,   -1,  145,  146,   -1,  264,  149,  150,
  151,  152,   -1,  270,  271,  272,  273,   -1,  270,  271,
  272,  273,   -1,   -1,   -1,   -1,   -1,   -1,  169,   -1,
   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,  138,
  139,   -1,   -1,   -1,   -1,   -1,  145,  146,   -1,   -1,
  149,  150,  151,  152,   -1,   -1,   -1,   -1,   -1,   -1,
   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,  210,
  169,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,
   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,
   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,
   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,
   -1,  210,
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
"Sentencia : SentenciaControl",
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
"SentenciaControl : DO SentenciaEjecutable ',' UNTIL Condicion",
"SentenciaControl : DO SentenciaEjecutable ',' UNTIL error",
"SentenciaControl : DO error UNTIL Condicion",
"SentenciaControl : DO SentenciaEjecutable UNTIL Condicion",
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
#line 524 "gramatica.y"
  public NodoControl raiz;
  private String ambitoAct = "main";
  private String ambitoNuevo= "";
  static ArrayList<Error> erroresSemanticos = new ArrayList<Error>();
  static ArrayList<String> variables_declaradas = new ArrayList<String>();
  static String tipoActual;
  static ArrayList<Funcion> funciones_declaradas = new ArrayList<Funcion>();
  static ArrayList<Nodo> funciones = new ArrayList<Nodo>();

  public NodoControl getRaiz(){
  	return this.raiz;
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

    NodoComun controlarTipos(Nodo n1, String op, Nodo n3 ){ 
        NodoComun aux = null;
        if(n1.getTipo().equals(n3.getTipo()))
        {
                aux = new NodoComun(op,n1,n3);
                aux.setTipo(n1.getTipo());

        }
        else 
        {
                if ((n1.getTipo().equals("USHORT") || n1.getTipo().equals("INT")) && (n3.getTipo().equals("USHORT")|| n3.getTipo().equals("INT")))
                {
                        {agregarErrorSemantico("Incompatibilidad de tipos ");}
                        return null;
                }
        }
        return aux;        
}

NodoComun controlarTiposAsignacion(Nodo n1, String asig, Nodo n3)
{ 
        NodoComun aux;
        if(n1.getTipo().equals(n3.getTipo()))
        {
                aux= new NodoComun(asig,n1,n3);
                aux.setTipo(n1.getTipo());

        }
        else 
        {   
                if (n1.getTipo().equals("USHORT")||n1.getTipo().equals("INT"))
                {
                        {agregarErrorSemantico("Incompatibilidad de tipos ");}
                        return null;
                }
        }
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
#line 755 "y.tab.c"
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
{   raiz = new NodoControl("PROGRAMA", (Nodo)yyvsp[-1].obj);
                                    AnalizadorLexico.agregarEstructura("Reconoce programa ");}
break;
case 2:
#line 20 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se espera '{' ");}
break;
case 3:
#line 23 "gramatica.y"
{yyval.obj = new NodoComun("SENTENCIA", (Nodo) yyvsp[-2].obj, (Nodo) yyvsp[-1].obj);}
break;
case 4:
#line 24 "gramatica.y"
{yyval.obj=yyvsp[-1].obj;}
break;
case 5:
#line 25 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba una ',' ");}
break;
case 6:
#line 28 "gramatica.y"
{yyval.obj=yyvsp[0].obj;}
break;
case 7:
#line 29 "gramatica.y"
{yyval.obj=yyvsp[0].obj;}
break;
case 8:
#line 30 "gramatica.y"
{yyval.obj=yyvsp[0].obj;}
break;
case 9:
#line 31 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("RETURN definido fuera de funcion ");}
break;
case 10:
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
case 11:
#line 53 "gramatica.y"
{ /*chequear q exista y bla bla*/
                                                yyval = new NodoComun("ReferenciaFuncionObjeto",(Nodo)yyvsp[-2],(Nodo)yyvsp[0]);
                                                AnalizadorLexico.agregarEstructura("Reconoce llamado a funcion de clase ");}
break;
case 12:
#line 58 "gramatica.y"
{yyval.obj=yyvsp[0].obj;}
break;
case 13:
#line 59 "gramatica.y"
{yyval.obj=yyvsp[0].obj;}
break;
case 14:
#line 60 "gramatica.y"
{yyval.obj=yyvsp[0].obj;}
break;
case 15:
#line 61 "gramatica.y"
{yyval.obj=yyvsp[0].obj;}
break;
case 16:
#line 62 "gramatica.y"
{yyval.obj=yyvsp[0].obj;}
break;
case 19:
#line 67 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("RETURN definido fuera de funcion ");}
break;
case 20:
#line 68 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("RETURN definido fuera de funcion ");}
break;
case 21:
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
case 23:
#line 90 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se espera el tipo de la variable ");}
break;
case 24:
#line 91 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se espera identificador de la variable ");}
break;
case 28:
#line 97 "gramatica.y"
{variables_declaradas.add(yyvsp[0].sval);}
break;
case 29:
#line 98 "gramatica.y"
{variables_declaradas.add(yyvsp[0].sval);}
break;
case 30:
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
case 31:
#line 119 "gramatica.y"
{variables_declaradas.add(yyvsp[0].sval);}
break;
case 32:
#line 120 "gramatica.y"
{variables_declaradas.add(yyvsp[0].sval);}
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
#line 124 "gramatica.y"
{tipoActual = yyvsp[0].sval;}
break;
case 36:
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
case 37:
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
case 38:
#line 157 "gramatica.y"
{AnalizadorLexico.agregarErrorLexico("Un entero corto no puede ser negativo ");}
break;
case 39:
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
case 40:
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
case 41:
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
case 42:
#line 202 "gramatica.y"
{yyval.obj = controlarTipos((Nodo)yyvsp[-2].obj,yyvsp[-1].sval,(Nodo)yyvsp[0].obj);}
break;
case 43:
#line 203 "gramatica.y"
{yyval.obj = controlarTipos((Nodo)yyvsp[-2].obj,yyvsp[-1].sval,(Nodo)yyvsp[0].obj);}
break;
case 44:
#line 204 "gramatica.y"
{yyval.obj=yyvsp[0].obj;}
break;
case 45:
#line 205 "gramatica.y"
{yyval.obj=yyvsp[0].obj;}
break;
case 46:
#line 209 "gramatica.y"
{yyval.obj = controlarTipos((Nodo)yyvsp[-2].obj,yyvsp[-1].sval,(Nodo)yyvsp[0].obj);}
break;
case 47:
#line 211 "gramatica.y"
{yyval.obj = controlarTipos((Nodo)yyvsp[-2].obj,yyvsp[-1].sval,(Nodo)yyvsp[0].obj);}
break;
case 48:
#line 212 "gramatica.y"
{yyval.obj = yyvsp[0].obj;}
break;
case 49:
#line 213 "gramatica.y"
{yyval.obj = controlarTipos((Nodo)yyvsp[-2].obj,yyvsp[-1].sval,(Nodo)yyvsp[0].obj);}
break;
case 50:
#line 214 "gramatica.y"
{yyval.obj = controlarTipos((Nodo)yyvsp[-2].obj,yyvsp[-1].sval,(Nodo)yyvsp[0].obj);}
break;
case 51:
#line 215 "gramatica.y"
{yyval.obj=yyvsp[0].obj;}
break;
case 52:
#line 218 "gramatica.y"
{Nodo aux = new NodoHoja ((String)yyvsp[0].sval);
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
                    aux.setTipo(TablaSimbolos.getTipo(var));
                    aux.setUso(TablaSimbolos.getUso(var));
                    aux.setAmbito(TablaSimbolos.getAmbito(var));
                }
            }
            yyval.obj = aux;
          }
break;
case 53:
#line 237 "gramatica.y"
{yyval.obj=yyvsp[0].obj;}
break;
case 54:
#line 241 "gramatica.y"
{yyval.obj=yyvsp[0].obj;}
break;
case 55:
#line 244 "gramatica.y"
{yyval.obj = controlarTipos((Nodo)yyvsp[-3].obj,yyvsp[-2].sval,(Nodo)yyvsp[-1].obj);}
break;
case 56:
#line 245 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba una ')' ");}
break;
case 57:
#line 246 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba una '(' ");}
break;
case 58:
#line 249 "gramatica.y"
{  yyval.obj = new NodoComun("CUERPO",(Nodo)yyvsp[-3].obj,(Nodo)yyvsp[-1].obj);
                                                        Nodo aux = (Nodo)yyval.obj;
                                                        yyval.obj = new NodoComun("IF",(Nodo)yyvsp[-4].obj,aux);
                                                        AnalizadorLexico.agregarEstructura("Reconoce IF ELSE");}
break;
case 59:
#line 253 "gramatica.y"
{yyval.obj = new NodoComun("IF",(Nodo)yyvsp[-2].obj,(Nodo)yyvsp[-1].obj);
	                                    AnalizadorLexico.agregarEstructura("Reconoce IF");}
break;
case 60:
#line 255 "gramatica.y"
{  yyval.obj = new NodoComun("IF",(Nodo)yyvsp[-3].obj,(Nodo)yyvsp[-2].obj);
         	                                            AnalizadorLexico.agregarEstructura("Reconoce IF");}
break;
case 61:
#line 257 "gramatica.y"
{   yyval.obj = new NodoComun("CUERPO",(Nodo)yyvsp[-4].obj,(Nodo)yyvsp[-1].obj);
                                                                        Nodo aux = (Nodo)yyval.obj;
                                                                        yyval.obj = new NodoComun("IF",(Nodo)yyvsp[-5].obj,aux);
                                                                        AnalizadorLexico.agregarEstructura("Reconoce IF ELSE");}
break;
case 62:
#line 261 "gramatica.y"
{yyval.obj = new NodoComun("CUERPO",(Nodo)yyvsp[-5].obj,(Nodo)yyvsp[-2].obj);
                                                                                    Nodo aux = (Nodo)yyval.obj;
                                                                                    yyval.obj = new NodoComun("IF",(Nodo)yyvsp[-6].obj,aux);
                                                                                    AnalizadorLexico.agregarEstructura("Reconoce IF ELSE");}
break;
case 63:
#line 265 "gramatica.y"
{   yyval.obj = new NodoComun("CUERPO",(Nodo)yyvsp[-4].obj,(Nodo)yyvsp[-2].obj);
                                                                        Nodo aux = (Nodo)yyval.obj;
                                                                        yyval.obj = new NodoComun("IF",(Nodo)yyvsp[-5].obj,aux);
                                                                        AnalizadorLexico.agregarEstructura("Reconoce IF ELSE");}
break;
case 64:
#line 272 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("IF mal definido ");}
break;
case 65:
#line 273 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba un END_IF ");}
break;
case 66:
#line 274 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba un END_IF ");}
break;
case 67:
#line 275 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba un END_IF ");}
break;
case 68:
#line 276 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba un END_IF ");}
break;
case 69:
#line 277 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba un ELSE ");}
break;
case 70:
#line 278 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba un ELSE");}
break;
case 71:
#line 279 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba una ',' ");}
break;
case 72:
#line 280 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba una ',' " );}
break;
case 73:
#line 281 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba una ',' ");}
break;
case 74:
#line 284 "gramatica.y"
{yyval.obj = yyvsp[-1].obj;}
break;
case 75:
#line 285 "gramatica.y"
{yyval.obj = yyvsp[-3].obj;}
break;
case 76:
#line 287 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Falta una ',' "); }
break;
case 77:
#line 288 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Falta un '{'"); }
break;
case 78:
#line 289 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Falta un '}'"); }
break;
case 79:
#line 290 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("No hay sentencias dentro de las llaves."); }
break;
case 80:
#line 293 "gramatica.y"
{yyval.obj=yyvsp[0].obj;}
break;
case 81:
#line 296 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Solo se aceptan sentencias ejecutables "); }
break;
case 82:
#line 297 "gramatica.y"
{yyval.obj=yyvsp[-1].obj;}
break;
case 83:
#line 298 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Falta una ',' "); }
break;
case 84:
#line 299 "gramatica.y"
{yyval.obj = new NodoComun("SENTENCIA", (Nodo) yyvsp[-2].obj, (Nodo) yyvsp[-1].obj);}
break;
case 85:
#line 302 "gramatica.y"
{yyval.obj=yyvsp[0].obj;}
break;
case 86:
#line 303 "gramatica.y"
{yyval.obj=yyvsp[0].obj;}
break;
case 87:
#line 304 "gramatica.y"
{yyval.obj=yyvsp[0].obj;}
break;
case 88:
#line 305 "gramatica.y"
{yyval.obj=yyvsp[0].obj;}
break;
case 89:
#line 306 "gramatica.y"
{yyval.obj=yyvsp[0].obj;}
break;
case 90:
#line 307 "gramatica.y"
{yyval.obj=yyvsp[0].obj;}
break;
case 93:
#line 314 "gramatica.y"
{agregarErrorSemantico("RETURN fuera de funcion");}
break;
case 94:
#line 315 "gramatica.y"
{  ((Nodo)yyvsp[-6].obj).setIzq((Nodo)yyvsp[-5].obj);
                                                                                ((Nodo)yyvsp[-6].obj).setDer((Nodo)yyvsp[-3].obj);
                                                                                deshacerAmbito();
                                                                                funciones.add((Nodo)yyvsp[-6]);
                                                                                AnalizadorLexico.agregarEstructura("Reconoce declaracion de funcion ");}
break;
case 95:
#line 320 "gramatica.y"
{ ((Nodo)yyvsp[-4].obj).setIzq((Nodo)yyvsp[-3].obj);
                                                                    ((Nodo)yyvsp[-4].obj).setDer((Nodo)yyvsp[-1].obj);
                                                                    deshacerAmbito();
                                                                    AnalizadorLexico.agregarEstructura("Reconoce declaracion de funcion ");}
break;
case 96:
#line 324 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba un nombre para la funcion ");}
break;
case 97:
#line 325 "gramatica.y"
{AnalizadorLexico.addWarning("Función sin cuerpo ");
                                            deshacerAmbito();
                                            AnalizadorLexico.agregarEstructura("Reconoce declaracion de funcion ");}
break;
case 98:
#line 330 "gramatica.y"
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
                  yyval.obj = new NodoComun(yyvsp[0].sval,null,null);
                  }
break;
case 99:
#line 350 "gramatica.y"
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
                                yyval.obj = new NodoHoja(yyvsp[-1].sval);
                           }
break;
case 100:
#line 362 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba un ')' ");}
break;
case 101:
#line 363 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba un '(' ");}
break;
case 102:
#line 364 "gramatica.y"
{yyval.obj = null;}
break;
case 103:
#line 365 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba un ')' ");}
break;
case 104:
#line 366 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba un '(' ");}
break;
case 105:
#line 372 "gramatica.y"
{yyval.obj = new NodoComun("Sentencia",(Nodo)yyvsp[-2].obj,(Nodo)yyvsp[-1].obj);}
break;
case 106:
#line 373 "gramatica.y"
{yyval.obj=yyvsp[-1].obj;}
break;
case 107:
#line 374 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba una ',' al final de la linea ");}
break;
case 108:
#line 375 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba una ',' al final de la linea ");}
break;
case 109:
#line 376 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba una ',' al final de la linea ");}
break;
case 110:
#line 379 "gramatica.y"
{yyval.obj=new NodoHoja(yyvsp[-2].sval);
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
case 111:
#line 396 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba un '(' ");}
break;
case 112:
#line 397 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba un ')' ");}
break;
case 113:
#line 398 "gramatica.y"
{
            			    NodoHoja nodo1 = new NodoHoja(yyvsp[-3].sval);
            			    yyval.obj=new NodoComun("Llamado Funcion", nodo1, (Nodo)yyvsp[-1].obj);
            			    Nodo n3 = (Nodo)yyvsp[-1].obj;
                                    Token tokenFuncion = TablaSimbolos.buscarPorAmbito(yyvsp[-3].sval + ":" + ambitoAct);

                                    Funcion funcion = new Funcion(tokenFuncion.getLexema(), null);
                                    if (tokenFuncion == null){
                                    	agregarErrorSemantico("La funcion " + val_peek(3).sval + " nunca fue declarada");
                                    } else {
                                    	if (funciones_declaradas.contains(funcion)) {
                                            int indice = funciones_declaradas.indexOf(funcion);
                                            Funcion f = funciones_declaradas.get(indice);
                                            if (!f.getTipoParametro().equals(n3.getTipo()) && (n3.getTipo() != null)){
                                                agregarErrorSemantico("No coinciden los tipos del parametro real y el formal. Se esperaba un " + f.getTipoParametro() + ", se obtuvo un " + ((Nodo)yyvsp[-1]).getTipo());
                                            }
                                        }
                                    }
                                    AnalizadorLexico.agregarEstructura("Reconoce llamado funcion ");
                                    TablaSimbolos.removeToken(yyvsp[-3].sval);
                                    }
break;
case 114:
#line 421 "gramatica.y"
{yyval.obj = new NodoControl("PRINT", new NodoHoja(yyvsp[0].sval));
                             AnalizadorLexico.agregarEstructura("Reconoce salida de mensaje por pantalla ");}
break;
case 115:
#line 423 "gramatica.y"
{yyval.obj = new NodoControl("PRINT", new NodoHoja(yyvsp[0].sval));
                            AnalizadorLexico.agregarEstructura("Reconoce salida de mensaje por pantalla ");}
break;
case 116:
#line 425 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("La funcion PRINT no acepta esa declaracion ");}
break;
case 117:
#line 428 "gramatica.y"
{yyval.obj=yyvsp[0].obj;}
break;
case 118:
#line 429 "gramatica.y"
{yyval.obj=yyvsp[0].obj;}
break;
case 119:
#line 432 "gramatica.y"
{AnalizadorLexico.agregarEstructura("Reconoce asignacion ");
                                                if (yyvsp[-1].sval.equals("="))
						                            yyval.obj = controlarTiposAsignacion((Nodo)yyvsp[-2].obj, "=", (Nodo)yyvsp[0].obj);
						                        else
						                            yyval.obj = controlarTiposAsignacion((Nodo)yyvsp[-2].obj, "+=", (Nodo)yyvsp[0].obj);}
break;
case 120:
#line 438 "gramatica.y"
{AnalizadorLexico.agregarEstructura("Reconoce asignacion ");
	                                                        if (yyvsp[-1].sval.equals("="))
	                                                            yyval.obj = controlarTiposAsignacion((Nodo)yyvsp[-2].obj, "=", (Nodo)yyvsp[0].obj);
	                                                        else
	                                                            yyval.obj = controlarTiposAsignacion((Nodo)yyvsp[-2].obj, "+=", (Nodo)yyvsp[0].obj);}
break;
case 121:
#line 444 "gramatica.y"
{AnalizadorLexico.agregarEstructura("Reconoce asignacion ");
	                                                if (yyvsp[-1].sval.equals("="))
	                                                    yyval.obj = controlarTiposAsignacion((Nodo)yyvsp[-2].obj, "=", (Nodo)yyvsp[0].obj);
                                                 	else
                                                 	    yyval.obj = controlarTiposAsignacion((Nodo)yyvsp[-2].obj, "+=", (Nodo)yyvsp[0].obj);}
break;
case 122:
#line 449 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba un valor seguido del operador ");}
break;
case 123:
#line 450 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba un valor seguido del operador ");}
break;
case 124:
#line 451 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba un operando del lado izquierdo ");}
break;
case 125:
#line 454 "gramatica.y"
{yyval.obj=new NodoComun("DO UNTIL", (Nodo)yyvsp[-2].obj ,(Nodo)yyvsp[0].obj);
                                                        AnalizadorLexico.agregarEstructura("Reconoce funcion DO UNTIL");}
break;
case 126:
#line 456 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba una condicion ");}
break;
case 127:
#line 457 "gramatica.y"
{yyval.obj = new NodoComun("DO UNTIL", (Nodo)yyvsp[-3].obj ,(Nodo)yyvsp[-1].obj);
                                                               AnalizadorLexico.agregarEstructura("Reconoce funcion DO UNTIL");}
break;
case 128:
#line 459 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba una condicion ");}
break;
case 129:
#line 460 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba una sentencia ejecutable ");}
break;
case 130:
#line 461 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba una ',' ");}
break;
case 131:
#line 467 "gramatica.y"
{yyval.obj = yyvsp[-1].obj;}
break;
case 132:
#line 468 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba un '(' ");}
break;
case 133:
#line 469 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba un ')' ");}
break;
case 134:
#line 472 "gramatica.y"
{yyval.obj = new NodoControl("TOD",(Nodo)yyvsp[0].obj);
                                            ((Nodo)yyvsp[0].obj).setTipo("DOUBLE");
                                            AnalizadorLexico.agregarEstructura("Reconoce funcion TOD ");
                                            }
break;
case 135:
#line 477 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba una Expresion ");}
break;
case 137:
#line 484 "gramatica.y"
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
#line 505 "gramatica.y"
{deshacerAmbito();}
break;
case 139:
#line 508 "gramatica.y"
{AnalizadorLexico.agregarEstructura("Reconoce Funcion sin cuerpo");}
break;
case 140:
#line 512 "gramatica.y"
{AnalizadorLexico.agregarEstructura("Reconoce funcion IMPL"); TablaSimbolos.removeToken(yyvsp[-4].sval);}
break;
case 141:
#line 513 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba un '{' ");}
break;
case 142:
#line 514 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba un '}' ");}
break;
#line 1683 "y.tab.c"
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
