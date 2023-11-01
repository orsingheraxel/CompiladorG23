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
#define YYERRCODE 256
short yylhs[] = {                                        -1,
    0,    0,    0,    0,    1,    1,    1,    2,    2,    2,
    6,    7,    4,    4,    4,    4,    4,    5,    5,    5,
    5,    5,    5,   13,   13,   16,   12,   12,   12,   17,
   17,   17,   17,   17,   17,   18,   18,   18,   18,   19,
   19,   19,   19,   19,   19,   21,   21,   22,   23,   10,
   10,   25,   25,   25,   24,   24,   24,   24,   24,   24,
   26,   26,   26,   26,   14,   14,   28,   29,   30,   30,
   30,   30,   30,   30,   30,   30,    8,    8,   11,   11,
   31,   31,    9,    9,    9,    3,    3,   20,   20,   32,
   32,   32,   32,   32,   32,   15,   15,   27,   27,   33,
};
short yylen[] = {                                         2,
    3,    2,    2,    1,    2,    3,    1,    1,    1,    1,
    3,    3,    1,    1,    1,    1,    1,    2,    1,    1,
    1,    1,    1,    1,    3,    2,    1,    1,    1,    1,
    1,    2,    1,    2,    2,    3,    3,    1,    1,    3,
    3,    1,    3,    3,    1,    1,    1,    1,    3,   12,
    8,    2,    3,    1,    1,    1,    1,    1,    1,    1,
    1,    1,    2,    2,    8,    7,    2,    1,    3,    3,
    2,    2,    2,    3,    1,    1,    3,    4,    2,    2,
    1,    1,    3,    3,    3,    8,    5,    4,    3,    2,
    1,    3,    4,    2,    3,    5,    2,    6,    5,    7,
};
short yydefred[] = {                                      0,
    0,    0,    0,    0,    0,   28,   27,   29,    0,    0,
    0,    0,    0,    8,    9,   10,    0,   17,   14,   13,
   15,   16,    0,   20,   19,   22,   23,    0,   46,   79,
   30,   31,   33,    0,   47,   80,    0,    0,    0,    0,
   82,    0,    0,    0,   81,   26,    0,    0,    3,    0,
    0,   18,    0,    0,   48,    0,    0,   39,    0,    0,
    0,   34,   32,   35,    0,    0,    0,    0,    0,    0,
   12,   25,   77,    0,   83,    1,    6,   84,   85,    0,
    0,   59,   60,   58,   57,   55,   56,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,   78,   11,
   89,    0,   49,   37,   36,   40,   41,   43,   44,    0,
    0,    0,    0,   64,    0,   63,   96,    0,    0,   67,
    0,   53,    0,   88,    0,    0,    0,    0,   95,   92,
    0,    0,    0,    0,   68,    0,    0,    0,    0,    0,
    0,   93,    0,    0,    0,   66,    0,    0,    0,   51,
   99,    0,    0,   74,   70,   69,   65,   86,    0,   98,
    0,    0,  100,    0,   50,
};
short yydgoto[] = {                                      11,
   12,   13,   14,  142,  143,   17,   18,   19,   20,   21,
   22,   23,   24,   25,   26,   27,   35,   56,   57,   58,
   59,   60,   61,   88,   69,  100,  101,  106,  144,  145,
   47,  102,  103,
};
short yysindex[] = {                                   -108,
  -12,  -28, -245, -228,  -64,    0,    0,    0,  -38,  -76,
    0,  -21,   23,    0,    0,    0,  -58,    0,    0,    0,
    0,    0, -182,    0,    0,    0,    0,  -23,    0,    0,
    0,    0,    0,  -69,    0,    0,  -26,   58, -141,   54,
    0, -152, -182,  -41,    0,    0,  -23,   -1,    0,  -76,
  -15,    0,   87,   89,    0,  -50,   45,    0,   27,   63,
   94,    0,    0,    0,  -67,   -8,  -27,  100,   21,  108,
    0,    0,    0,  109,    0,    0,    0,    0,    0, -104,
  -36,    0,    0,    0,    0,    0,    0,  -23,  -23,  -23,
  -15,  -15,  -15,  -15,   59, -101,  -98, -182,  -74,  145,
  -74,   71,  153,   79,  -66,  171, -141,  -51,    0,    0,
    0,  173,    0,    0,    0,    0,    0,    0,    0, -141,
  175,  -52,  174,    0,  -67,    0,    0,  -67, -166,    0,
   96,    0,  184,    0,  101,   24,  167,  -67,    0,    0,
  185,  188,  190,  120,    0, -166,  -23, -175,  -37,  207,
  138,    0, -166, -166, -166,    0,  137,  225,  144,    0,
    0,  -24,    7,    0,    0,    0,    0,    0, -141,    0,
  143,  150,    0,   35,    0,
};
short yyrindex[] = {                                      0,
    0,    0,    0,    0,    0,    0,    0,    0,   18,    0,
    0,  270,   31,    0,    0,    0,    0,    0,    0,    0,
    0,    0,   26,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,   37,    0,    0,   18,
    0,    0,    0,    0,    0,    0,    0,  280,    0,   32,
    0,    0,    1,    0,    0,    0,   16,    0,    6,   11,
    0,    0,    0,    0,    0,    0,    0,  160,    0,  -47,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,  249,    0,
  251,    0,  172,    0,    0,    0,  176,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,  177,    0,  178,    0,    0,    0,    0,    0,
    0,    0,   38,    0,    0,    0,    0,    0,    0,    0,
    0,  179,   -1,    0,    0,    0,    0,    0,    0,    0,
    0,    0,  180,  181,  182,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,
};
short yygindex[] = {                                      0,
   43,    0,    0,   25,   29,   83,    0,  254,    0,    0,
    0,   42,   49,   41,    0,    0,    0,   33,  114,    0,
   34,    0,  151,    0,  -80,   19,    0,  163,  154,  -16,
  291,  -13,    0,
};
#define YYTABLESIZE 308
short yytable[] = {                                      73,
   46,   44,   45,   34,  111,   42,  161,   42,   34,   86,
   45,   87,   44,   11,   10,   38,   34,   24,   42,  170,
   43,   34,   45,   37,   15,   21,  132,   28,   16,   34,
    7,    5,  104,   45,   15,   36,   97,   87,   16,  135,
   38,   46,   46,   46,   46,   46,   42,   46,   42,   42,
   42,   45,   48,   45,   45,   45,   38,   46,   39,   38,
   46,   24,   46,   68,  149,   42,   50,   42,   91,   21,
   45,   52,   45,   92,   15,   38,   74,   38,   16,   75,
   97,   87,  159,  160,   79,  129,   40,   90,  172,   89,
    1,   72,   77,    2,    3,    4,   65,   66,  146,    6,
    7,    8,    9,   49,   93,   99,   98,  105,  141,   94,
   55,  139,   43,  112,  140,    1,   70,  124,    2,  126,
  113,  114,  115,   76,  152,   46,   55,   67,   81,   55,
   42,   68,   80,   78,   95,   45,  164,  165,  166,   99,
   38,   99,   24,  107,   68,  108,  123,   44,    1,  109,
   21,    2,    3,    4,    5,    7,    5,    6,    7,    8,
    9,   97,   87,   55,  110,   99,   98,  121,   99,   98,
   55,   55,   55,   55,   55,   55,   55,  105,   99,   98,
    1,  120,  122,    2,    3,    4,    5,   96,  125,    6,
    7,    8,    9,   68,   96,  127,  128,   97,    6,    7,
    8,  129,  130,  171,  116,  117,  118,  119,   62,   63,
   64,  131,  133,  134,  136,   41,  137,  138,  146,   82,
   83,   84,   85,  147,  151,  148,   11,   53,  153,   55,
   40,  154,   53,  155,   54,   41,   31,   32,   33,   54,
   29,   31,   32,   33,  156,   53,   41,  162,   30,   31,
   32,   33,   54,   53,   31,   32,   33,    6,    7,    8,
  163,  167,   31,   32,   33,  168,  169,  173,    4,    4,
   46,   46,   46,   46,  174,   42,   42,   42,   42,    2,
   45,   45,   45,   45,   54,   38,   38,   38,   38,    6,
    7,    8,   61,  175,   62,   71,   91,  158,  150,  157,
   52,   90,   94,   75,   73,   71,   72,   51,
};
short yycheck[] = {                                      41,
    0,   40,   61,   45,   41,    0,   44,   46,   45,   60,
    0,   62,   40,   61,  123,    0,   45,    0,   46,   44,
   59,   45,   61,  269,    0,    0,  107,   40,    0,   45,
    0,    0,   41,   61,   10,    2,    0,    0,   10,  120,
  269,   41,   42,   43,   44,   45,   41,   47,   43,   44,
   45,   41,   10,   43,   44,   45,   41,    9,  123,   44,
   60,   44,   62,   39,   41,   60,   44,   62,   42,   44,
   60,   23,   62,   47,   50,   60,   44,   62,   50,   47,
   44,   44,  258,  259,   51,  123,  269,   43,  169,   45,
  257,   43,   50,  260,  261,  262,  123,   40,  123,  266,
  267,  268,  269,  125,   42,   65,   65,   66,  275,   47,
   28,  125,   59,   81,  128,  257,  269,   99,  260,  101,
   88,   89,   90,  125,  138,  125,   44,  269,   40,   47,
  125,  107,   46,   51,   41,  125,  153,  154,  155,   99,
  125,  101,  125,   44,  120,  125,   98,   40,  257,   41,
  125,  260,  261,  262,  263,  125,  125,  266,  267,  268,
  269,  125,  125,   81,  269,  125,  125,  269,  128,  128,
   88,   89,   90,   91,   92,   93,   94,  136,  138,  138,
  257,  123,  281,  260,  261,  262,  263,  262,   44,  266,
  267,  268,  269,  169,  262,  125,   44,  265,  266,  267,
  268,  123,  269,  163,   91,   92,   93,   94,  278,  279,
  280,   41,  264,   41,   40,  274,  269,   44,  123,  270,
  271,  272,  273,   40,   58,  125,  274,  269,   44,  147,
  269,   44,  269,   44,  276,  274,  278,  279,  280,  276,
  269,  278,  279,  280,  125,  269,  274,   41,  277,  278,
  279,  280,  276,  269,  278,  279,  280,  266,  267,  268,
  123,  125,  278,  279,  280,   41,  123,  125,  262,    0,
  270,  271,  272,  273,  125,  270,  271,  272,  273,    0,
  270,  271,  272,  273,  125,  270,  271,  272,  273,  266,
  267,  268,   44,  259,   44,   42,  125,  147,  136,  146,
  125,  125,  125,  125,  125,  125,  125,   17,
};
#define YYFINAL 11
#ifndef YYDEBUG
#define YYDEBUG 0
#endif
#define YYMAXTOKEN 281
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
"PUNTOFLOTANTE","FOR",
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
"Funcion : VOID ID '(' Parametro ')' '{' CuerpoFuncion '}'",
"Funcion : VOID ID '(' ')' '{' CuerpoFuncion '}'",
"Parametro : Tipo ID",
"CuerpoFuncion : ListSentenciasFuncion",
"ListSentenciasFuncion : SentenciaDeclarativa ',' ListSentenciasFuncion",
"ListSentenciasFuncion : SentenciaEjecutable ',' ListSentenciasFuncion",
"ListSentenciasFuncion : SentenciaEjecutable ','",
"ListSentenciasFuncion : SentenciaDeclarativa ','",
"ListSentenciasFuncion : RETURN ','",
"ListSentenciasFuncion : RETURN ',' ListSentenciasFuncion",
"ListSentenciasFuncion : SentenciaEjecutable",
"ListSentenciasFuncion : SentenciaDeclarativa",
"LlamadoFuncion : ID '(' ')'",
"LlamadoFuncion : ID '(' Expresion ')'",
"SalidaMensaje : PRINT CADENA",
"SalidaMensaje : PRINT Factor",
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
#line 192 "gramatica.y"
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
#line 381 "y.tab.c"
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
case 75:
#line 135 "gramatica.y"
{agregarErrorSintactico("Se esperaba una ',' al final de la linea ");}
break;
case 76:
#line 136 "gramatica.y"
{agregarErrorSintactico("Se esperaba una ',' al final de la linea ");}
break;
case 86:
#line 156 "gramatica.y"
{agregarEstructura("Reconoce funcion DO UNTIL");}
break;
case 87:
#line 157 "gramatica.y"
{agregarErrorSintactico("Se esperaba una condicion ");}
break;
case 88:
#line 162 "gramatica.y"
{agregarEstructura("Reconoce funcion TOD ");}
break;
case 89:
#line 163 "gramatica.y"
{agregarErrorSintactico("Se esperaba una Expresion ");}
break;
case 96:
#line 174 "gramatica.y"
{agregarEstructura("Reconoce CLASE");}
break;
case 98:
#line 178 "gramatica.y"
{agregarEstructura("Reconoce Funcion sin cuerpo");}
break;
case 100:
#line 182 "gramatica.y"
{agregarEstructura("Reconoce funcion IMPL");}
break;
#line 605 "y.tab.c"
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
