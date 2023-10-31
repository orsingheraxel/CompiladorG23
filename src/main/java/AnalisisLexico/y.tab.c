#ifndef lint
static char yysccsid[] = "@(#)yaccpar	1.8 (Berkeley) 01/20/90";
#endif
#define YYBYACC 1
#line 2 "gramatica.y"
package AnalisisLexico;;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
#line 12 "y.tab.c"
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
   19,   19,   19,   19,   19,   21,   21,   22,   23,   10,
   10,   25,   25,   25,   24,   24,   24,   24,   24,   24,
   26,   26,   26,   26,   14,   14,   14,   28,   29,   30,
   30,   30,   30,   30,   30,    8,    8,   11,   31,   31,
    9,    9,    9,    3,    3,   20,   20,   32,   32,   32,
   32,   32,   32,   15,   15,   27,   27,   33,
};
short yylen[] = {                                         2,
    3,    2,    2,    1,    2,    3,    1,    1,    1,    1,
    3,    3,    1,    1,    1,    1,    1,    2,    1,    1,
    1,    1,    1,    1,    3,    2,    1,    1,    1,    1,
    1,    2,    1,    2,    2,    3,    3,    1,    1,    3,
    3,    1,    3,    3,    1,    1,    1,    1,    3,   12,
    8,    2,    3,    1,    1,    1,    1,    1,    1,    1,
    1,    1,    2,    2,   10,    9,    7,    2,    1,    3,
    3,    2,    2,    1,    1,    3,    4,    2,    1,    1,
    3,    3,    3,    8,    5,    4,    3,    2,    1,    3,
    4,    2,    3,    5,    2,    6,    5,    7,
};
short yydefred[] = {                                      0,
    0,    0,    0,    0,    0,   28,   27,   29,    0,    0,
    0,    0,    0,    8,    9,   10,    0,   17,   14,   13,
   15,   16,    0,   20,   19,   22,   23,    0,   78,    0,
    0,    0,    0,   80,    0,    0,    0,   79,   26,    0,
    0,    3,    0,    0,   18,    0,    0,   30,   31,   33,
    0,   48,   47,    0,    0,   39,    0,    0,    0,    0,
    0,    0,    0,    0,    0,   12,   25,   76,    0,   81,
    1,    6,   82,   83,    0,    0,   34,   32,   35,   59,
   60,   58,   57,   55,   56,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,   77,   11,   87,    0,
   49,   37,   36,   40,   41,   43,   44,    0,    0,    0,
    0,   64,    0,   63,   94,    0,    0,   68,    0,   53,
    0,   86,    0,    0,    0,    0,   93,   90,    0,    0,
    0,   69,    0,    0,    0,    0,    0,    0,   91,    0,
    0,    0,   67,    0,    0,    0,   51,   97,    0,    0,
   71,   70,    0,    0,   84,    0,   96,    0,   66,    0,
    0,   98,   65,    0,   50,
};
short yydgoto[] = {                                      11,
   12,   13,   14,   63,  140,   52,   18,   19,   20,   21,
   22,   23,   24,   25,   26,   27,   53,   54,   55,   56,
   57,   58,   59,   86,   64,   98,   99,  104,  141,  142,
   40,  100,  101,
};
short yysindex[] = {                                    -76,
   52, -192, -161, -156,   -6,    0,    0,    0,   -5,  -63,
    0,  -10,   81,    0,    0,    0,  -59,    0,    0,    0,
    0,    0, -145,    0,    0,    0,    0,  -28,    0,    4,
   91, -166,   73,    0, -129, -145,  -41,    0,    0,  -28,
   16,    0,  -63,  -33,    0,   96,  104,    0,    0,    0,
 -168,    0,    0,  -49,   57,    0,   -8,   31,  109, -146,
  -12,  -21,  111,   33,  121,    0,    0,    0,  122,    0,
    0,    0,    0,    0, -102,  -36,    0,    0,    0,    0,
    0,    0,    0,    0,    0,  -28,  -28,  -28,  -33,  -33,
  -33,  -33,   47, -101, -108, -145,  -91,  128,  -91,   49,
  131,   55,  -90,  139, -166,  -82,    0,    0,    0,  142,
    0,    0,    0,    0,    0,    0,    0, -166,  148,  -80,
  151,    0, -146,    0,    0, -146,   43,    0,   78,    0,
  156,    0,   77,   -9,  149, -146,    0,    0,  164,  165,
 -119,    0,   43,  -28, -163,  -16,  169,   88,    0,   43,
   43,  168,    0,  -62,  173,   95,    0,    0,  -14,  -43,
    0,    0,  100,  176,    0, -166,    0,  101,    0,  105,
  106,    0,    0,  -30,    0,
};
short yyrindex[] = {                                      0,
    0,    0,    0,    0,    0,    0,    0,    0,   20,    0,
    0,  232,   18,    0,    0,    0,    0,    0,    0,    0,
    0,    0,   22,    0,    0,    0,    0,    0,    0,   23,
    0,    0,   20,    0,    0,    0,    0,    0,    0,    0,
  234,    0,   24,    0,    0,    1,    0,    0,    0,    0,
    0,    0,    0,    0,   21,    0,    8,   14,    0,    0,
    0,    0,  137,    0,  -58,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,  219,    0,  221,    0,
  141,    0,    0,    0,  143,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
  145,    0,  150,    0,    0,    0,    0,    0,    0,    0,
   27,    0,    0,    0,    0,    0,    0,    0, -118, -115,
    0,    0,    0,    0,    0,    0,    0,    0,    0, -110,
 -109,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,
};
short yygindex[] = {                                      0,
   50,    0,    0,   26,   80,  217,    0,  242,    0,    0,
    0,   28,   63,  -22,    0,    0,    0,   42,   45,    0,
  223,    0,  138,    0,  -68,  -66,    0,  154,  147,  -45,
  282,  -39,    0,
};
#define YYTABLESIZE 383
short yytable[] = {                                      68,
   46,   38,   11,   51,  109,  153,   74,   42,   51,   75,
   84,   51,   85,   45,   72,   73,   51,    7,   37,   24,
   38,   21,   95,    5,   35,   15,   85,  158,  102,  167,
  122,  146,  124,   89,   37,   15,  130,   97,   90,   38,
   35,   46,   46,   46,   46,   46,   10,   46,   42,  133,
   42,   42,   42,   36,   45,   38,   45,   45,   45,   41,
   46,   38,   46,   24,   38,   21,   95,   42,   15,   42,
   85,   39,   91,   45,   97,   45,   97,   92,   69,   16,
   38,   70,   38,  137,   29,   45,  138,   96,  103,   16,
    1,   28,   72,    2,  156,  157,  149,  171,   67,   88,
   97,   87,   62,   97,  161,  162,  127,   30,  143,   77,
   78,   79,   31,   97,   42,   94,   32,  110,   95,    6,
    7,    8,   16,   33,   43,   46,   60,  111,  112,  113,
   61,   36,   42,  114,  115,  116,  117,  168,   45,   65,
   71,   75,    7,   76,   24,   38,   21,   95,    5,   93,
   96,   85,  139,   96,  105,  152,   74,  106,  121,   75,
   37,  103,  107,   96,   72,   73,  108,  119,  139,  118,
   94,  123,  120,  125,  126,  139,  139,  127,  128,  129,
    1,  131,  132,    2,    3,    4,    5,  134,  135,    6,
    7,    8,    9,    1,  136,  144,    2,    3,    4,    5,
  143,  145,    6,    7,    8,    9,  148,  150,  151,  159,
  160,  163,  164,  165,   34,   11,   17,  166,    4,  170,
   80,   81,   82,   83,  169,  172,   17,   46,  175,  173,
  174,    4,   46,    2,   47,   46,   48,   49,   50,   47,
   46,   48,   49,   50,   48,   49,   50,   47,   17,   48,
   49,   50,   34,    6,    7,    8,    6,    7,    8,   17,
   73,   54,   61,   33,   62,   89,   74,   52,   34,   88,
   46,   46,   46,   46,   92,   46,   66,   42,   42,   42,
   42,  155,   42,   45,   45,   45,   45,  147,   45,  154,
   38,   38,   38,   38,   24,   38,   21,   95,   44,    1,
    0,    0,    2,    3,    4,    0,    0,    0,    6,    7,
    8,    9,    0,    0,    0,    0,    0,    0,    0,    0,
    0,   17,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,   17,    0,    0,    0,    0,    0,
    0,    0,    0,   17,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,   17,
    0,    0,    0,    0,    0,    0,   17,   17,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,   17,
};
short yycheck[] = {                                      41,
    0,   61,   61,   45,   41,  125,  125,    0,   45,  125,
   60,   45,   62,    0,  125,  125,   45,    0,   40,    0,
    0,    0,    0,    0,   46,    0,    0,   44,   41,   44,
   97,   41,   99,   42,   40,   10,  105,   60,   47,   61,
   46,   41,   42,   43,   44,   45,  123,   47,   41,  118,
   43,   44,   45,   59,   41,   61,   43,   44,   45,   10,
   60,   41,   62,   44,   44,   44,   44,   60,   43,   62,
   44,    9,   42,   60,   97,   62,   99,   47,   37,    0,
   60,   40,   62,  123,  277,   23,  126,   60,   61,   10,
  257,   40,   43,  260,  258,  259,  136,  166,   36,   43,
  123,   45,  269,  126,  150,  151,  123,  269,  123,  278,
  279,  280,  269,  136,  125,  262,  123,   76,  265,  266,
  267,  268,   43,  269,   44,  125,  123,   86,   87,   88,
   40,   59,  125,   89,   90,   91,   92,  160,  125,  269,
  125,   46,  125,   40,  125,  125,  125,  125,  125,   41,
  123,  125,  127,  126,   44,  275,  275,  125,   96,  275,
   40,  134,   41,  136,  275,  275,  269,  269,  143,  123,
  262,   44,  281,  125,   44,  150,  151,  123,  269,   41,
  257,  264,   41,  260,  261,  262,  263,   40,  269,  266,
  267,  268,  269,  257,   44,   40,  260,  261,  262,  263,
  123,  125,  266,  267,  268,  269,   58,   44,   44,   41,
  123,   44,  275,   41,  274,  274,    0,  123,  262,   44,
  270,  271,  272,  273,  125,  125,   10,  269,  259,  125,
  125,    0,  269,    0,  276,  269,  278,  279,  280,  276,
  269,  278,  279,  280,  278,  279,  280,  276,   32,  278,
  279,  280,  274,  266,  267,  268,  266,  267,  268,   43,
   44,  125,   44,  269,   44,  125,   44,  125,  274,  125,
  270,  271,  272,  273,  125,  275,   35,  270,  271,  272,
  273,  144,  275,  270,  271,  272,  273,  134,  275,  143,
  270,  271,  272,  273,  275,  275,  275,  275,   17,  257,
   -1,   -1,  260,  261,  262,   -1,   -1,   -1,  266,  267,
  268,  269,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,
   -1,  105,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,
   -1,   -1,   -1,   -1,  118,   -1,   -1,   -1,   -1,   -1,
   -1,   -1,   -1,  127,   -1,   -1,   -1,   -1,   -1,   -1,
   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,  143,
   -1,   -1,   -1,   -1,   -1,   -1,  150,  151,   -1,   -1,
   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,
   -1,   -1,  166,
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
"Condicion : Expresion Comparador Expresion",
"BloqueIF : IF '(' Condicion ')' '{' ListSentenciasIF '}' ELSE '{' ListSentenciasIF '}' END_IF",
"BloqueIF : IF '(' Condicion ')' '{' ListSentenciasIF '}' END_IF",
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
"Funcion : VOID ID '(' Parametro ')' '{' CuerpoFuncion RETURN ',' '}'",
"Funcion : VOID ID '(' ')' '{' CuerpoFuncion RETURN ',' '}'",
"Funcion : VOID ID '(' ')' '{' CuerpoFuncion '}'",
"Parametro : Tipo ID",
"CuerpoFuncion : ListSentenciasFuncion",
"ListSentenciasFuncion : SentenciaDeclarativa ',' ListSentenciasFuncion",
"ListSentenciasFuncion : SentenciaEjecutable ',' ListSentenciasFuncion",
"ListSentenciasFuncion : SentenciaEjecutable ','",
"ListSentenciasFuncion : SentenciaDeclarativa ','",
"ListSentenciasFuncion : SentenciaEjecutable",
"ListSentenciasFuncion : SentenciaDeclarativa",
"LlamadoFuncion : ID '(' ')'",
"LlamadoFuncion : ID '(' Expresion ')'",
"SalidaMensaje : PRINT CADENA",
"OperadorAsignacion : '='",
"OperadorAsignacion : ASIG",
"Asignacion : ID OperadorAsignacion Expresion",
"Asignacion : ReferenciaObjeto OperadorAsignacion ReferenciaObjeto",
"Asignacion : ReferenciaObjeto OperadorAsignacion Factor",
"SentenciaControl : DO '{' ListSentenciasIF '}' UNTIL '(' Condicion ')'",
"SentenciaControl : DO '{' ListSentenciasIF '}' UNTIL",
"ConversionExplicita : TOD '(' Expresion ')'",
"ConversionExplicita : TOD '(' ')'",
"ListHerencia : Tipo ListVariables",
"ListHerencia : FuncionIMPL",
"ListHerencia : FuncionIMPL ',' ListHerencia",
"ListHerencia : Tipo ListVariables ',' ListHerencia",
"ListHerencia : ListFuncion ','",
"ListHerencia : ListFuncion ',' ListHerencia",
"HerenciaComposicion : CLASS ID '{' ListHerencia '}'",
"HerenciaComposicion : CLASS ID",
"FuncionSinCuerpo : VOID ID '(' Parametro ')' ','",
"FuncionSinCuerpo : VOID ID '(' ')' ','",
"FuncionIMPL : IMPL FOR ID ':' '{' Funcion '}'",
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
#line 190 "gramatica.y"
  static ArrayList<Error> erroresLexicos = new ArrayList<Error>();
  static ArrayList<Error> erroresSintacticos = new ArrayList<Error>();
  static ArrayList<String> estructuraReconocida = new ArrayList<String>();

   public static void agregarErrorLexico(String error){
          Error e = new Error(error, AnalizadorLexico.getLineaAct());
          erroresLexicos.add(e);
   }

   public static void agregarErrorSintactico(String error){
          Error e = new Error(error, AnalizadorLexico.getLineaAct());
          erroresSintacticos.add(e);
   }

   public static void agregarEstructura(String error){
             estructuraReconocida.add(error);
   }

  public int yylex() throws IOException{
    Token t = AnalizadorLexico.obtenerToken();
    this.yylval = new ParserVal(t.getLexema());
    return t.getId();
  }

  public static void yyerror(String error){
    System.out.println(error);
  }
#line 396 "y.tab.c"
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
case 2:
#line 15 "gramatica.y"
{agregarErrorSintactico("Se espera '}' en la linea ");}
break;
case 3:
#line 16 "gramatica.y"
{agregarErrorSintactico("Se espera '{' en la linea ");}
break;
case 4:
#line 17 "gramatica.y"
{agregarErrorSintactico("Se esperan '{' '}' en la linea ");}
break;
case 7:
#line 22 "gramatica.y"
{agregarErrorSintactico("Se esperaba una ',' al final de la linea ");}
break;
case 20:
#line 45 "gramatica.y"
{agregarErrorSintactico("Se espera el tipo de la variable en la linea ");}
break;
case 21:
#line 46 "gramatica.y"
{agregarErrorSintactico("Se espera identificador de la variable en la linea ");}
break;
case 32:
#line 65 "gramatica.y"
{agregarErrorLexico("Un entero corto no puede ser negativo en la linea ");}
break;
case 50:
#line 96 "gramatica.y"
{agregarEstructura("Reconoce ELSE IF ");}
break;
case 51:
#line 97 "gramatica.y"
{agregarEstructura("Reconoce IF ");}
break;
case 54:
#line 102 "gramatica.y"
{agregarErrorSintactico("Se esperaba una ',' al final de la linea ");}
break;
case 65:
#line 119 "gramatica.y"
{agregarEstructura("Reconoce funcion VOID ");}
break;
case 66:
#line 120 "gramatica.y"
{agregarEstructura("Reconoce funcion VOID ");}
break;
case 67:
#line 121 "gramatica.y"
{agregarEstructura("Reconoce funcion VOID ");}
break;
case 74:
#line 134 "gramatica.y"
{agregarErrorSintactico("Se esperaba una ',' al final de la linea ");}
break;
case 75:
#line 135 "gramatica.y"
{agregarErrorSintactico("Se esperaba una ',' al final de la linea ");}
break;
case 84:
#line 154 "gramatica.y"
{agregarEstructura("Reconoce funcion DO UNTIL");}
break;
case 85:
#line 155 "gramatica.y"
{agregarErrorSintactico("Se esperaba una condicion ");}
break;
case 86:
#line 160 "gramatica.y"
{agregarEstructura("Reconoce funcion TOD ");}
break;
case 87:
#line 161 "gramatica.y"
{agregarErrorSintactico("Se esperaba una Expresion ");}
break;
case 94:
#line 172 "gramatica.y"
{agregarEstructura("Reconoce CLASE");}
break;
case 96:
#line 176 "gramatica.y"
{agregarEstructura("Reconoce Funcion sin cuerpo");}
break;
case 98:
#line 180 "gramatica.y"
{agregarEstructura("Reconoce funcion IMPL");}
break;
#line 624 "y.tab.c"
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
