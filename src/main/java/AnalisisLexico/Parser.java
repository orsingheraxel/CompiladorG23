//### This file created by BYACC 1.8(/Java extension  1.15)
//### Java capabilities added 7 Jan 97, Bob Jamison
//### Updated : 27 Nov 97  -- Bob Jamison, Joe Nieten
//###           01 Jan 98  -- Bob Jamison -- fixed generic semantic constructor
//###           01 Jun 99  -- Bob Jamison -- added Runnable support
//###           06 Aug 00  -- Bob Jamison -- made state variables class-global
//###           03 Jan 01  -- Bob Jamison -- improved flags, tracing
//###           16 May 01  -- Bob Jamison -- added custom stack sizing
//###           04 Mar 02  -- Yuval Oren  -- improved java performance, added options
//###           14 Mar 02  -- Tomas Hurka -- -d support, static initializer workaround
//### Please send bug reports to tom@hukatronic.cz
//### static char yysccsid[] = "@(#)yaccpar	1.8 (Berkeley) 01/20/90";






//#line 2 "gramatica.y"
package AnalisisLexico;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
//#line 23 "Parser.java"




public class Parser
{

boolean yydebug;        //do I want debug output?
int yynerrs;            //number of errors so far
int yyerrflag;          //was there an error?
int yychar;             //the current working character

//########## MESSAGES ##########
//###############################################################
// method: debug
//###############################################################
void debug(String msg)
{
  if (yydebug)
    System.out.println(msg);
}

//########## STATE STACK ##########
final static int YYSTACKSIZE = 500;  //maximum stack size
int statestk[] = new int[YYSTACKSIZE]; //state stack
int stateptr;
int stateptrmax;                     //highest index of stackptr
int statemax;                        //state when highest index reached
//###############################################################
// methods: state stack push,pop,drop,peek
//###############################################################
final void state_push(int state)
{
  try {
		stateptr++;
		statestk[stateptr]=state;
	 }
	 catch (ArrayIndexOutOfBoundsException e) {
     int oldsize = statestk.length;
     int newsize = oldsize * 2;
     int[] newstack = new int[newsize];
     System.arraycopy(statestk,0,newstack,0,oldsize);
     statestk = newstack;
     statestk[stateptr]=state;
  }
}
final int state_pop()
{
  return statestk[stateptr--];
}
final void state_drop(int cnt)
{
  stateptr -= cnt; 
}
final int state_peek(int relative)
{
  return statestk[stateptr-relative];
}
//###############################################################
// method: init_stacks : allocate and prepare stacks
//###############################################################
final boolean init_stacks()
{
  stateptr = -1;
  val_init();
  return true;
}
//###############################################################
// method: dump_stacks : show n levels of the stacks
//###############################################################
void dump_stacks(int count)
{
int i;
  System.out.println("=index==state====value=     s:"+stateptr+"  v:"+valptr);
  for (i=0;i<count;i++)
    System.out.println(" "+i+"    "+statestk[i]+"      "+valstk[i]);
  System.out.println("======================");
}


//########## SEMANTIC VALUES ##########
//public class ParserVal is defined in ParserVal.java


String   yytext;//user variable to return contextual strings
ParserVal yyval; //used to return semantic vals from action routines
ParserVal yylval;//the 'lval' (result) I got from yylex()
ParserVal valstk[];
int valptr;
//###############################################################
// methods: value stack push,pop,drop,peek.
//###############################################################
void val_init()
{
  valstk=new ParserVal[YYSTACKSIZE];
  yyval=new ParserVal();
  yylval=new ParserVal();
  valptr=-1;
}
void val_push(ParserVal val)
{
  if (valptr>=YYSTACKSIZE)
    return;
  valstk[++valptr]=val;
}
ParserVal val_pop()
{
  if (valptr<0)
    return new ParserVal();
  return valstk[valptr--];
}
void val_drop(int cnt)
{
int ptr;
  ptr=valptr-cnt;
  if (ptr<0)
    return;
  valptr = ptr;
}
ParserVal val_peek(int relative)
{
int ptr;
  ptr=valptr-relative;
  if (ptr<0)
    return new ParserVal();
  return valstk[ptr];
}
final ParserVal dup_yyval(ParserVal val)
{
  ParserVal dup = new ParserVal();
  dup.ival = val.ival;
  dup.dval = val.dval;
  dup.sval = val.sval;
  dup.obj = val.obj;
  return dup;
}
//#### end semantic value section ####
public final static short IF=257;
public final static short ELSE=258;
public final static short END_IF=259;
public final static short PRINT=260;
public final static short CLASS=261;
public final static short VOID=262;
public final static short DO=263;
public final static short UNTIL=264;
public final static short IMPL=265;
public final static short INT=266;
public final static short USHORT=267;
public final static short DOUBLE=268;
public final static short ID=269;
public final static short IGUAL=270;
public final static short DIST=271;
public final static short MENORIGUAL=272;
public final static short MAYORIGUAL=273;
public final static short ASIG=274;
public final static short RETURN=275;
public final static short TOD=276;
public final static short CADENA=277;
public final static short ENTERO=278;
public final static short ENTEROCORTO=279;
public final static short PUNTOFLOTANTE=280;
public final static short FOR=281;
public final static short CTE=282;
public final static short YYERRCODE=256;
final static short yylhs[] = {                           -1,
    0,    0,    0,    0,    1,    1,    1,    1,    1,    1,
    5,    5,    3,    3,    3,    3,    3,   10,    4,    4,
    4,    4,    4,    4,   11,   11,   11,   12,   12,   12,
   12,   12,   15,   15,   15,   15,   15,   15,   15,   16,
   16,   16,   16,   17,   17,   17,   19,   19,   19,   20,
    8,    8,   22,   22,   21,   21,   21,   21,   21,   21,
   23,   23,   23,   23,   13,   13,   13,   25,   26,   27,
   27,   27,   27,    6,    6,   28,   28,   28,    9,   29,
   29,    7,    7,    7,    7,    7,    2,    2,   18,   18,
   30,   30,   30,   30,   30,   30,   14,   31,   31,   31,
   24,   24,   32,
};
final static short yylen[] = {                            2,
    3,    2,    2,    1,    2,    2,    2,    3,    3,    3,
    3,    3,    1,    1,    1,    1,    1,    3,    2,    1,
    1,    1,    1,    1,    1,    3,    2,    1,    1,    1,
    1,    1,    1,    1,    2,    1,    2,    2,    1,    3,
    3,    1,    1,    3,    3,    1,    1,    1,    1,    3,
   12,    8,    2,    3,    1,    1,    1,    1,    1,    1,
    1,    1,    2,    2,   10,    9,    7,    2,    1,    3,
    3,    2,    2,    3,    4,    1,    1,    1,    2,    1,
    1,    3,    3,    3,    3,    5,    8,    5,    4,    3,
    1,    1,    3,    2,    2,    3,    5,    3,    4,    3,
    6,    5,    7,
};
final static short yydefred[] = {                         0,
    0,    0,    0,    0,    0,   30,   29,   31,    0,    0,
    0,    0,    0,    0,    0,   17,   14,   13,   15,   16,
   23,   21,    0,   20,   24,    0,   79,    0,    0,    0,
    0,   81,    0,    0,    0,   80,    0,    0,    0,    3,
    0,    0,    0,   19,    0,    0,   33,   34,   36,   39,
    0,   49,   48,    0,    0,   43,    0,    0,    0,    0,
    0,    0,    0,   27,    0,   12,   26,    0,   74,   48,
   77,    0,   18,    0,   49,   48,   83,    1,    9,   10,
    8,    0,    0,   37,   35,   38,   59,   60,   58,   57,
   55,   56,    0,    0,    0,    0,    0,    0,   32,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,   28,
    0,    0,    0,    0,    0,    0,   75,    0,   90,    0,
   50,   41,   40,   44,   45,    0,    0,    0,    0,    0,
   64,    0,   63,   97,   94,    0,    0,   68,    0,   54,
    0,    0,   86,   89,    0,    0,    0,  100,    0,   96,
   93,    0,    0,    0,   69,    0,    0,    0,    0,    0,
    0,   99,    0,    0,    0,   67,    0,    0,    0,   52,
  102,    0,    0,   71,   70,    0,    0,   87,    0,  101,
    0,   66,    0,    0,  103,   65,    0,   51,
};
final static short yydgoto[] = {                         11,
   12,   13,   14,   15,   16,   17,   18,   19,   20,   21,
   22,   23,   24,   25,   53,   54,   55,   56,   57,   58,
   93,   63,  105,  106,  113,  154,  155,   72,   38,  107,
  108,  109,
};
final static short yysindex[] = {                       -95,
   -3, -248, -229, -226,  -68,    0,    0,    0,   -5,  -63,
    0,  -43,   55,   61,   68,    0,    0,    0,    0,    0,
    0,    0, -152,    0,    0,  -24,    0,   12,   98, -230,
  -53,    0, -145, -152,  -41,    0,  106,  -19,   28,    0,
  -63,  -63,  -63,    0,  110,  111,    0,    0,    0,    0,
 -187,    0,    0,  -59,    1,    0,  -11,  118,  -44,   34,
  -38,  125,   45,    0,  -27,    0,    0,  110,    0,    0,
    0,  134,    0,  110,    0,    0,    0,    0,    0,    0,
    0,  -85,  -36,    0,    0,    0,    0,    0,    0,    0,
    0,    0,  -24,  -24,  -24,   -7,   -7,   62,    0,  -78,
  -86,  157,  -62,  -60,  164,  -60,   85,  -44,  165,    0,
   92,  -50,  179, -230,  -37,  -21,    0,  186,    0,  208,
    0,    0,    0,    0,    0, -230,  211,   -4,   52,  209,
    0,  -44,    0,    0,    0,  -44,  -80,    0,  143,    0,
  227,  110,    0,    0,  145,   43,  210,    0,   52,    0,
    0,  230,  236, -118,    0,  -80,  -24, -179,  -29,  240,
  159,    0,  -80,  -80,  239,    0,    9,  244,  167,    0,
    0,  -28,   44,    0,    0,  180,  263,    0, -230,    0,
  183,    0,  189,  190,    0,    0,   57,    0,
};
final static short yyrindex[] = {                         0,
    0,    0,  273,    0,    0,    0,    0,    0,  278,    0,
    0,  323,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,  280,    0,    0,    0,    0,    0,    0,    0,
  278,    0,    0,    0,    0,    0,    0,    0,  325,    0,
   17,   18,   19,    0,    6,    0,    0,    0,    0,    0,
    0,    0,    0,    0,   21,    0,   26,    0,    0,    0,
    0,    0,    0,    0,  282,    0,    0,   84,    0,    0,
    0,    0,    0,  187,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0, -229,    0,  283,    0,  284,    0,  204,  205,    0,
    0,    0,    0,  206,    0,    0,    0,   16,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,  207,    0,    0,    0,    0,    0,    0,    0,    0,
  289,    0,    0,    0,    0,    0,    0,    0, -113,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0, -115, -114,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,
};
final static short yygindex[] = {                         0,
   77,    0,  -16,  -48,    7,   -9,    0,    0,    0,    0,
  105,   47,    5,    0,  -13,   39,   49,    0,    0,  177,
    0,  -94,   86,    0,  191,  182,  -67,    0,  270,   22,
  -77,    0,
};
final static int YYTABLESIZE=338;
static short yytable[];
static { yytable();}
static void yytable(){
yytable = new short[]{                         69,
   91,   35,   92,   51,  119,   34,  166,   33,   51,   72,
   73,   98,   35,   62,  171,  180,    5,    6,    7,  140,
   51,   70,   36,   66,   76,   51,    1,   10,   27,    2,
   96,  145,   52,   36,   35,   97,   26,   51,   61,   28,
   33,   52,   29,   95,   75,   94,   47,   47,   47,   47,
   47,  148,   47,   34,   30,   36,   11,   11,   11,   11,
   11,   42,   11,  104,   42,   47,   46,   47,   46,   46,
   46,  162,   66,   71,  111,   11,   77,   11,  169,  170,
   42,   40,   42,  159,  184,   46,   39,   46,  153,   52,
   84,   85,   86,  137,  156,  174,  175,   62,   41,   52,
   52,   52,   52,   52,   42,  103,  112,  153,  104,   62,
  104,   43,  104,   37,  153,  153,   31,   79,   80,   81,
  152,  120,  143,   65,   47,   47,   47,   44,   47,  135,
   47,  121,  122,  123,   59,   64,  104,   60,   67,  152,
  104,    5,    6,    7,  124,  125,  152,  152,   98,   73,
   83,   98,   78,  150,  103,   82,  165,  151,   98,   72,
   73,    1,   62,   52,    2,    3,    4,    5,  114,  115,
    6,    7,    8,    9,  117,  103,    1,  181,  103,    2,
    3,    4,  103,  118,  126,    6,    7,    8,    9,  131,
  127,  133,  112,    1,  128,  103,    2,    3,    4,    5,
  129,  100,    6,    7,    8,    9,  130,  132,  136,  134,
   87,   88,   89,   90,  137,   31,   99,  100,  138,  139,
  101,    6,    7,    8,  102,   35,  141,   68,   47,   47,
   47,   47,   45,   47,   46,   32,   47,   48,   49,   46,
   50,   47,   48,   49,   45,   50,   32,  142,  144,   74,
  146,   46,  149,   47,   48,   49,   46,   50,   47,   48,
   49,   45,   50,   31,  147,  156,  157,  161,   32,  158,
   47,   48,   49,  163,   50,   47,   47,   47,   47,  164,
  172,  173,  176,  177,  178,   11,   11,   11,   11,  179,
   42,   42,   42,   42,   99,   46,   46,   46,   46,    6,
    7,    8,  110,   99,  182,    4,  183,  185,    6,    7,
    8,  110,   99,  186,  187,  188,   32,    6,    7,    8,
  102,   25,    4,   22,    2,   11,   61,   62,   91,   92,
   53,   95,   88,  168,  116,    0,  160,  167,
};
}
static short yycheck[];
static { yycheck(); }
static void yycheck() {
yycheck = new short[] {                         41,
   60,   40,   62,   45,   41,   59,  125,   46,   45,  125,
  125,  125,   40,   30,   44,   44,    0,    0,    0,  114,
   45,   35,   61,   33,   38,   45,  257,  123,  277,  260,
   42,  126,   26,   61,   40,   47,   40,   45,  269,  269,
   46,   35,  269,   43,   38,   45,   41,   42,   43,   44,
   45,  129,   47,   59,  123,   61,   41,   42,   43,   44,
   45,   41,   47,   59,   44,   60,   41,   62,   43,   44,
   45,  149,   82,   35,   41,   60,   38,   62,  258,  259,
   60,  125,   62,   41,  179,   60,   10,   62,  137,   83,
  278,  279,  280,  123,  123,  163,  164,  114,   44,   93,
   94,   95,   96,   97,   44,   59,   60,  156,  104,  126,
  106,   44,  108,    9,  163,  164,  269,   41,   42,   43,
  137,   83,  116,  269,   41,   42,   43,   23,   45,  108,
   47,   93,   94,   95,  123,   31,  132,   40,   34,  156,
  136,  125,  125,  125,   96,   97,  163,  164,  262,   44,
   40,  265,  125,  132,  108,   46,  275,  136,   41,  275,
  275,  257,  179,  157,  260,  261,  262,  263,   44,  125,
  266,  267,  268,  269,   41,  129,  257,  173,  132,  260,
  261,  262,  136,  269,  123,  266,  267,  268,  269,  104,
  269,  106,  146,  257,  281,  149,  260,  261,  262,  263,
   44,  262,  266,  267,  268,  269,  269,   44,   44,  125,
  270,  271,  272,  273,  123,  269,  261,  262,  269,   41,
  265,  266,  267,  268,  269,   40,  264,  269,   42,   43,
   44,   45,  269,   47,  276,  274,  278,  279,  280,  276,
  282,  278,  279,  280,  269,  282,  274,  269,   41,  269,
   40,  276,   44,  278,  279,  280,  276,  282,  278,  279,
  280,  269,  282,  269,  269,  123,   40,   58,  274,  125,
  278,  279,  280,   44,  282,  270,  271,  272,  273,   44,
   41,  123,   44,  275,   41,  270,  271,  272,  273,  123,
  270,  271,  272,  273,  261,  270,  271,  272,  273,  266,
  267,  268,  269,  261,  125,  262,   44,  125,  266,  267,
  268,  269,  261,  125,  125,  259,   44,  266,  267,  268,
  269,   44,    0,   44,    0,   44,   44,   44,  125,  125,
  125,  125,   44,  157,   65,   -1,  146,  156,
};
}
final static short YYFINAL=11;
final static short YYMAXTOKEN=282;
final static String yyname[] = {
"end-of-file",null,null,null,null,null,null,null,null,null,null,null,null,null,
null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,
null,null,null,null,null,null,null,null,null,null,"'('","')'","'*'","'+'","','",
"'-'","'.'","'/'",null,null,null,null,null,null,null,null,null,null,"':'","';'",
"'<'","'='","'>'",null,null,null,null,null,null,null,null,null,null,null,null,
null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,
null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,
null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,
"'{'",null,"'}'",null,null,null,null,null,null,null,null,null,null,null,null,
null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,
null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,
null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,
null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,
null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,
null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,
null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,
null,null,null,null,null,null,null,"IF","ELSE","END_IF","PRINT","CLASS","VOID",
"DO","UNTIL","IMPL","INT","USHORT","DOUBLE","ID","IGUAL","DIST","MENORIGUAL",
"MAYORIGUAL","ASIG","RETURN","TOD","CADENA","ENTERO","ENTEROCORTO",
"PUNTOFLOTANTE","FOR","CTE",
};
final static String yyrule[] = {
"$accept : Programa",
"Programa : '{' ListSentencias '}'",
"Programa : '{' ListSentencias",
"Programa : ListSentencias '}'",
"Programa : ListSentencias",
"ListSentencias : SentenciaControl ','",
"ListSentencias : SentenciaEjecutable ','",
"ListSentencias : SentenciaDeclarativa ','",
"ListSentencias : SentenciaDeclarativa ',' ListSentencias",
"ListSentencias : SentenciaControl ',' ListSentencias",
"ListSentencias : SentenciaEjecutable ',' ListSentencias",
"ReferenciaObjeto : ID '.' ID",
"ReferenciaObjeto : ID '.' LlamadoFuncion",
"SentenciaEjecutable : Asignacion",
"SentenciaEjecutable : LlamadoFuncion",
"SentenciaEjecutable : BloqueIF",
"SentenciaEjecutable : SalidaMensaje",
"SentenciaEjecutable : ReferenciaObjeto",
"ClaseSentenciaEjecutable : ID ListVariables ','",
"SentenciaDeclarativa : Tipo ListVariables",
"SentenciaDeclarativa : Funcion",
"SentenciaDeclarativa : ListVariables",
"SentenciaDeclarativa : Tipo",
"SentenciaDeclarativa : ClaseSentenciaEjecutable",
"SentenciaDeclarativa : HerenciaComposicion",
"ListVariables : ID",
"ListVariables : ID ';' ListVariables",
"ListVariables : ID ListVariables",
"Tipo : ID",
"Tipo : USHORT",
"Tipo : INT",
"Tipo : DOUBLE",
"Tipo : CLASS",
"Constante : ENTERO",
"Constante : ENTEROCORTO",
"Constante : '-' ENTEROCORTO",
"Constante : PUNTOFLOTANTE",
"Constante : '-' ENTERO",
"Constante : '-' PUNTOFLOTANTE",
"Constante : CTE",
"Expresion : Termino '+' Expresion",
"Expresion : Termino '-' Expresion",
"Expresion : Termino",
"Expresion : ConversionExplicita",
"Termino : Factor '*' Termino",
"Termino : Factor '/' Termino",
"Termino : Factor",
"Factor : ID",
"Factor : Constante",
"Factor : ReferenciaObjeto",
"Condicion : Expresion Comparador Expresion",
"BloqueIF : IF '(' Condicion ')' '{' ListSentenciasIF '}' ELSE '{' ListSentenciasIF '}' END_IF",
"BloqueIF : IF '(' Condicion ')' '{' ListSentenciasIF '}' END_IF",
"ListSentenciasIF : SentenciaEjecutable ','",
"ListSentenciasIF : SentenciaEjecutable ',' ListSentenciasIF",
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
"LlamadoFuncion : ID '(' ')'",
"LlamadoFuncion : ID '(' ParametroReal ')'",
"ParametroReal : ID",
"ParametroReal : Expresion",
"ParametroReal : Constante",
"SalidaMensaje : PRINT CADENA",
"OperadorAsignacion : '='",
"OperadorAsignacion : ASIG",
"Asignacion : ID OperadorAsignacion ID",
"Asignacion : ID OperadorAsignacion Expresion",
"Asignacion : ID OperadorAsignacion Constante",
"Asignacion : ID OperadorAsignacion ReferenciaObjeto",
"Asignacion : ID '.' ID OperadorAsignacion ReferenciaObjeto",
"SentenciaControl : DO '{' ListSentenciasIF '}' UNTIL '(' Condicion ')'",
"SentenciaControl : DO '{' ListSentenciasIF '}' UNTIL",
"ConversionExplicita : TOD '(' Expresion ')'",
"ConversionExplicita : TOD '(' ')'",
"ListHerencia : DeclaracionAtributo",
"ListHerencia : FuncionIMPL",
"ListHerencia : FuncionIMPL ',' ListHerencia",
"ListHerencia : DeclaracionAtributo ListHerencia",
"ListHerencia : ListFuncion ','",
"ListHerencia : ListFuncion ',' ListHerencia",
"HerenciaComposicion : CLASS ID '{' ListHerencia '}'",
"DeclaracionAtributo : Tipo ID ','",
"DeclaracionAtributo : Tipo ID ',' DeclaracionAtributo",
"DeclaracionAtributo : ID ',' DeclaracionAtributo",
"FuncionSinCuerpo : VOID ID '(' Parametro ')' ','",
"FuncionSinCuerpo : VOID ID '(' ')' ','",
"FuncionIMPL : IMPL FOR ID ':' '{' Funcion '}'",
};

//#line 210 "gramatica.y"
  public int yylex() throws IOException{
    Token t = AnalizadorLexico.obtenerToken();
    this.yylval = new ParserVal(t.getLexema());
    return t.getId();
  }

  public static void yyerror(String error){
    System.out.println(error);
  }
//#line 442 "Parser.java"
//###############################################################
// method: yylexdebug : check lexer state
//###############################################################
void yylexdebug(int state,int ch)
{
String s=null;
  if (ch < 0) ch=0;
  if (ch <= YYMAXTOKEN) //check index bounds
     s = yyname[ch];    //now get it
  if (s==null)
    s = "illegal-symbol";
  debug("state "+state+", reading "+ch+" ("+s+")");
}





//The following are now global, to aid in error reporting
int yyn;       //next next thing to do
int yym;       //
int yystate;   //current parsing state from state table
String yys;    //current token string


//###############################################################
// method: yyparse : parse input and execute indicated items
//###############################################################
int yyparse() throws IOException {
boolean doaction;
  init_stacks();
  yynerrs = 0;
  yyerrflag = 0;
  yychar = -1;          //impossible char forces a read
  yystate=0;            //initial state
  state_push(yystate);  //save it
  val_push(yylval);     //save empty value
  while (true) //until parsing is done, either correctly, or w/error
    {
    doaction=true;
    if (yydebug) debug("loop"); 
    //#### NEXT ACTION (from reduction table)
    for (yyn=yydefred[yystate];yyn==0;yyn=yydefred[yystate])
      {
      if (yydebug) debug("yyn:"+yyn+"  state:"+yystate+"  yychar:"+yychar);
      if (yychar < 0)      //we want a char?
        {
        yychar = yylex();  //get next token
        if (yydebug) debug(" next yychar:"+yychar);
        //#### ERROR CHECK ####
        if (yychar < 0)    //it it didn't work/error
          {
          yychar = 0;      //change it to default string (no -1!)
          if (yydebug)
            yylexdebug(yystate,yychar);
          }
        }//yychar<0
      yyn = yysindex[yystate];  //get amount to shift by (shift index)
      if ((yyn != 0) && (yyn += yychar) >= 0 &&
          yyn <= YYTABLESIZE && yycheck[yyn] == yychar)
        {
        if (yydebug)
          debug("state "+yystate+", shifting to state "+yytable[yyn]);
        //#### NEXT STATE ####
        yystate = yytable[yyn];//we are in a new state
        state_push(yystate);   //save it
        val_push(yylval);      //push our lval as the input for next rule
        yychar = -1;           //since we have 'eaten' a token, say we need another
        if (yyerrflag > 0)     //have we recovered an error?
           --yyerrflag;        //give ourselves credit
        doaction=false;        //but don't process yet
        break;   //quit the yyn=0 loop
        }

    yyn = yyrindex[yystate];  //reduce
    if ((yyn !=0 ) && (yyn += yychar) >= 0 &&
            yyn <= YYTABLESIZE && yycheck[yyn] == yychar)
      {   //we reduced!
      if (yydebug) debug("reduce");
      yyn = yytable[yyn];
      doaction=true; //get ready to execute
      break;         //drop down to actions
      }
    else //ERROR RECOVERY
      {
      if (yyerrflag==0)
        {
        yyerror("syntax error");
        yynerrs++;
        }
      if (yyerrflag < 3) //low error count?
        {
        yyerrflag = 3;
        while (true)   //do until break
          {
          if (stateptr<0)   //check for under & overflow here
            {
            yyerror("stack underflow. aborting...");  //note lower case 's'
            return 1;
            }
          yyn = yysindex[state_peek(0)];
          if ((yyn != 0) && (yyn += YYERRCODE) >= 0 &&
                    yyn <= YYTABLESIZE && yycheck[yyn] == YYERRCODE)
            {
            if (yydebug)
              debug("state "+state_peek(0)+", error recovery shifting to state "+yytable[yyn]+" ");
            yystate = yytable[yyn];
            state_push(yystate);
            val_push(yylval);
            doaction=false;
            break;
            }
          else
            {
            if (yydebug)
              debug("error recovery discarding state "+state_peek(0)+" ");
            if (stateptr<0)   //check for under & overflow here
              {
              yyerror("Stack underflow. aborting...");  //capital 'S'
              return 1;
              }
            state_pop();
            val_pop();
            }
          }
        }
      else            //discard this token
        {
        if (yychar == 0)
          return 1; //yyabort
        if (yydebug)
          {
          yys = null;
          if (yychar <= YYMAXTOKEN) yys = yyname[yychar];
          if (yys == null) yys = "illegal-symbol";
          debug("state "+yystate+", error recovery discards token "+yychar+" ("+yys+")");
          }
        yychar = -1;  //read another
        }
      }//end error recovery
    }//yyn=0 loop
    if (!doaction)   //any reason not to proceed?
      continue;      //skip action
    yym = yylen[yyn];          //get count of terminals on rhs
    if (yydebug)
      debug("state "+yystate+", reducing "+yym+" by rule "+yyn+" ("+yyrule[yyn]+")");
    if (yym>0)                 //if count of rhs not 'nil'
      yyval = val_peek(yym-1); //get current semantic value
    yyval = dup_yyval(yyval); //duplicate yyval if ParserVal is used as semantic value
    switch(yyn)
      {
//########## USER-SUPPLIED ACTIONS ##########
case 2:
//#line 15 "gramatica.y"
{System.out.println("Se espera '}' en la linea "+ AnalizadorLexico.getLineaAct());}
break;
case 3:
//#line 16 "gramatica.y"
{System.out.println("Se espera '{' en la linea "+ AnalizadorLexico.getLineaAct());}
break;
case 4:
//#line 17 "gramatica.y"
{System.out.println("Se esperan '{' '}' en la linea "+ AnalizadorLexico.getLineaAct());}
break;
case 21:
//#line 48 "gramatica.y"
{System.out.println("Se espera el tipo de la variable en la linea "+ AnalizadorLexico.getLineaAct());}
break;
case 22:
//#line 49 "gramatica.y"
{System.out.println("Se espera identificador de la variable en la linea "+ AnalizadorLexico.getLineaAct());}
break;
case 27:
//#line 57 "gramatica.y"
{System.out.println("Se espera un ';' seguido de cada variable en caso de querer agregar mas en la linea "+ AnalizadorLexico.getLineaAct());}
break;
case 35:
//#line 69 "gramatica.y"
{System.out.println("Un entero corto no puede ser negativo en la linea "+ AnalizadorLexico.getLineaAct());}
break;
case 51:
//#line 95 "gramatica.y"
{System.out.println("Reconoce ELSE IF en la linea "+ AnalizadorLexico.getLineaAct());}
break;
case 52:
//#line 96 "gramatica.y"
{System.out.println("Reconoce IF en la linea "+ AnalizadorLexico.getLineaAct());}
break;
case 65:
//#line 116 "gramatica.y"
{System.out.println("Reconoce funcion VOID en la linea "+ AnalizadorLexico.getLineaAct());}
break;
case 66:
//#line 117 "gramatica.y"
{System.out.println("Reconoce funcion VOID en la linea "+ AnalizadorLexico.getLineaAct());}
break;
case 67:
//#line 118 "gramatica.y"
{System.out.println("Reconoce funcion VOID en la linea "+ AnalizadorLexico.getLineaAct());}
break;
case 87:
//#line 166 "gramatica.y"
{System.out.println("Reconoce funcion DO UNTIL en la linea "+ AnalizadorLexico.getLineaAct());}
break;
case 88:
//#line 167 "gramatica.y"
{System.out.println("Se esperaba una condicion");}
break;
case 89:
//#line 172 "gramatica.y"
{System.out.println("Reconoce funcion TOD en la linea "+ AnalizadorLexico.getLineaAct());}
break;
case 90:
//#line 173 "gramatica.y"
{System.out.println("Se esperaba una Expresion");}
break;
case 97:
//#line 185 "gramatica.y"
{System.out.println("Reconoce CLASE en la linea "+ AnalizadorLexico.getLineaAct());}
break;
case 101:
//#line 196 "gramatica.y"
{System.out.println("Reconoce Funcion sin cuerpo, en la linea"+ AnalizadorLexico.getLineaAct());}
break;
case 103:
//#line 200 "gramatica.y"
{System.out.println("Reconoce funcion IMPL en la linea "+ AnalizadorLexico.getLineaAct());}
break;
//#line 667 "Parser.java"
//########## END OF USER-SUPPLIED ACTIONS ##########
    }//switch
    //#### Now let's reduce... ####
    if (yydebug) debug("reduce");
    state_drop(yym);             //we just reduced yylen states
    yystate = state_peek(0);     //get new state
    val_drop(yym);               //corresponding value drop
    yym = yylhs[yyn];            //select next TERMINAL(on lhs)
    if (yystate == 0 && yym == 0)//done? 'rest' state and at first TERMINAL
      {
      if (yydebug) debug("After reduction, shifting from state 0 to state "+YYFINAL+"");
      yystate = YYFINAL;         //explicitly say we're done
      state_push(YYFINAL);       //and save it
      val_push(yyval);           //also save the semantic value of parsing
      if (yychar < 0)            //we want another character?
        {
        yychar = yylex();        //get next character
        if (yychar<0) yychar=0;  //clean, if necessary
        if (yydebug)
          yylexdebug(yystate,yychar);
        }
      if (yychar == 0)          //Good exit (if lex returns 0 ;-)
         break;                 //quit the loop--all DONE
      }//if yystate
    else                        //else not done yet
      {                         //get next state and push, for next yydefred[]
      yyn = yygindex[yym];      //find out where to go
      if ((yyn != 0) && (yyn += yystate) >= 0 &&
            yyn <= YYTABLESIZE && yycheck[yyn] == yystate)
        yystate = yytable[yyn]; //get new state
      else
        yystate = yydgoto[yym]; //else go to new defred
      if (yydebug) debug("after reduction, shifting from state "+state_peek(0)+" to state "+yystate+"");
      state_push(yystate);     //going again, so push state & val...
      val_push(yyval);         //for next action
      }
    }//main loop
  return 0;//yyaccept!!
}
//## end of method parse() ######################################



//## run() --- for Thread #######################################
/**
 * A default run method, used for operating this parser
 * object in the background.  It is intended for extending Thread
 * or implementing Runnable.  Turn off with -Jnorun .
 */
public void run() throws IOException {
  yyparse();
}
//## end of method run() ########################################



//## Constructors ###############################################
/**
 * Default constructor.  Turn off with -Jnoconstruct .

 */
public Parser()
{
  //nothing to do
}


/**
 * Create a parser, setting the debug to true or false.
 * @param debugMe true for debugging, false for no debug.
 */
public Parser(boolean debugMe)
{
  yydebug=debugMe;
}
//###############################################################



}
//################### END OF CLASS ##############################
