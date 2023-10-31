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
    1,    1,    1,    5,    5,    3,    3,    3,    3,    3,
   10,   10,    4,    4,    4,    4,    4,    4,   11,   11,
   11,   12,   12,   12,   12,   12,   15,   15,   15,   15,
   15,   15,   15,   16,   16,   16,   16,   17,   17,   17,
   19,   19,   19,   20,    8,    8,   22,   22,   22,   21,
   21,   21,   21,   21,   21,   23,   23,   23,   23,   13,
   13,   13,   25,   26,   27,   27,   27,   27,   27,   27,
    6,    6,   28,   28,   28,    9,   29,   29,    7,    7,
    7,    7,    7,    2,    2,   18,   18,   30,   30,   30,
   30,   30,   30,   14,   31,   31,   31,   24,   24,   32,
};
final static short yylen[] = {                            2,
    3,    2,    2,    1,    2,    2,    2,    3,    3,    3,
    1,    1,    1,    3,    3,    1,    1,    1,    1,    1,
    3,    2,    2,    1,    1,    1,    1,    1,    1,    3,
    2,    1,    1,    1,    1,    1,    1,    1,    2,    1,
    2,    2,    1,    3,    3,    1,    1,    3,    3,    1,
    1,    1,    1,    3,   12,    8,    2,    3,    1,    1,
    1,    1,    1,    1,    1,    1,    1,    2,    2,   10,
    9,    7,    2,    1,    3,    3,    2,    2,    1,    1,
    3,    4,    1,    1,    1,    2,    1,    1,    3,    3,
    3,    3,    5,    8,    5,    4,    3,    1,    1,    3,
    2,    2,    3,    5,    3,    4,    3,    6,    5,    7,
};
final static short yydefred[] = {                         0,
    0,    0,    0,    0,    0,   34,   33,   35,    0,    0,
    0,    0,    0,    0,    0,   20,   17,   16,   18,   19,
   27,   25,    0,   24,   28,    0,   86,    0,    0,    0,
    0,   88,    0,    0,    0,   87,    0,    0,    0,    3,
    0,    0,    0,   23,    0,    0,   37,   38,   40,   43,
    0,   53,   52,    0,    0,   47,    0,    0,    0,    0,
    0,    0,    0,   31,    0,   15,   30,    0,   81,   52,
   84,    0,   21,    0,   53,   52,   90,    1,    9,   10,
    8,    0,    0,   41,   39,   42,   64,   65,   63,   62,
   60,   61,    0,    0,    0,    0,    0,    0,   36,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,   32,
    0,    0,    0,    0,    0,    0,   82,    0,   97,    0,
   54,   45,   44,   48,   49,    0,    0,    0,    0,    0,
   69,    0,   68,  104,  101,    0,    0,   73,    0,   58,
    0,    0,   93,   96,    0,    0,    0,  107,    0,  103,
  100,    0,    0,    0,   74,    0,    0,    0,    0,    0,
    0,  106,    0,    0,    0,   72,    0,    0,    0,   56,
  109,    0,    0,   76,   75,    0,    0,   94,    0,  108,
    0,   71,    0,    0,  110,   70,    0,   55,
};
final static short yydgoto[] = {                         11,
   12,   13,   14,   15,   16,   17,   18,   19,   20,   21,
   22,   23,   24,   25,   53,   54,   55,   56,   57,   58,
   93,   63,  105,  106,  113,  154,  155,   72,   38,  107,
  108,  109,
};
final static short yysindex[] = {                       -85,
   -9, -238, -222, -179,  -12,    0,    0,    0,   40,   72,
    0,   -2,   95,  100,  105,    0,    0,    0,    0,    0,
    0,    0, -106,    0,    0,  -21,    0,   42,  140, -165,
  -56,    0, -101, -106,  -41,    0,  142,  -13,   63,    0,
   72,   72,   72,    0,  149,  156,    0,    0,    0,    0,
  -80,    0,    0,  -50,   60,    0,   46,  162,   94,   55,
  -27,  171,   92,    0,  -24,    0,    0,  149,    0,    0,
    0,  177,    0,  149,    0,    0,    0,    0,    0,    0,
    0,  -44,  -36,    0,    0,    0,    0,    0,    0,    0,
    0,    0,  -21,  -21,  -21,   33,   33,  103,    0,  -18,
  -32,  201,  -15,  -10,  218,  -10,  143,   94,  226,    0,
  152,   13,  243, -165,   39,   30,    0,  249,    0,  264,
    0,    0,    0,    0,    0, -165,  266,   38, -131,  273,
    0,   94,    0,    0,    0,   94,   85,    0,  185,    0,
  270,  149,    0,    0,  194,   59,  260,    0, -131,    0,
    0,  286,  287, -119,    0,   85,  -21, -161,  -14,  295,
  214,    0,   85,   85,  299,    0,   69,  307,  227,    0,
    0,  -11,   87,    0,    0,  232,  314,    0, -165,    0,
  239,    0,  240,  241,    0,    0,  108,    0,
};
final static short yyrindex[] = {                         0,
    0,    0,   20,    0,    0,    0,    0,    0,   22,    0,
    0,  368,   26,   27,   28,    0,    0,    0,    0,    0,
    0,    0,   23,    0,    0,    0,    0,    0,    0,    0,
   22,    0,    0,    0,    0,    0,    2,    0,  369,    0,
   41,   82,   84,    0,    1,    0,    0,    0,    0,    0,
    0,    0,    0,    0,   21,    0,   15,    0,    0,    0,
    0,  245,    0,    0,   25,    0,    0,  163,    0,    0,
    0,    0,    0,   29,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,  102,    0,  328,    0,  329,    0,  250,  251,    0,
    0,    0,    0,  252,    0,    0,    0,    8,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,  253,    0,    0,    0,    0,    0,    0,    0,    0,
   35,    0,    0,    0,    0,    0,    0,    0, -107,    0,
    0, -118, -114,    0,    0,    0,    0,    0,    0,    0,
    0,    0, -111, -108,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,
};
final static short yygindex[] = {                         0,
   75,    0,    6,  -35,   96,    7,    0,    0,    0,    0,
  193,   65,  128,    0,   19,  136,   17,    0,    0,  217,
    0,  -20,    4,    0,  233,  224,  -22,    0,  316,  -17,
  -42,    0,
};
final static int YYTABLESIZE=381;
static short yytable[];
static { yytable();}
static void yytable(){
yytable = new short[]{                         69,
   51,   22,   34,   51,  119,  166,   79,   14,   51,   91,
   80,   92,   35,   77,   50,   35,   78,  105,   33,   36,
   46,   29,   26,   51,   14,   11,   12,   13,   51,  171,
   26,   51,  180,   36,   95,   62,   36,   10,   27,   66,
    5,   51,   51,   51,   51,   51,   28,   51,   14,   14,
   14,   14,   14,   70,   14,   50,   76,   50,   50,   50,
   51,   46,   51,   36,   46,   29,   26,   14,   14,   14,
   51,   51,   51,   51,   50,   51,   50,   51,   95,   35,
   46,    6,   46,    7,   39,   33,  148,   96,   66,   29,
  135,    1,   97,  140,    2,  111,  169,  170,   34,  159,
   36,  153,   95,   61,   94,  145,  162,  131,  137,  133,
   30,  156,  124,  125,  150,   79,   80,   81,  151,   62,
  153,   52,   40,  103,  112,   51,   22,  153,  153,   99,
   52,   62,   14,   75,    6,    7,    8,  102,   41,   50,
  174,  175,  152,   42,   36,   46,   29,   26,   43,   14,
   11,   12,   13,   51,  105,  165,   79,  105,  184,   95,
   80,  152,   31,   77,   59,    5,   78,   65,  152,  152,
   71,    1,  103,   77,    2,    3,    4,    5,   52,   60,
    6,    7,    8,    9,   62,   73,  104,   78,   52,   52,
   52,   52,   52,  103,   82,   83,  103,   84,   85,   86,
  103,   37,   98,   51,   51,   51,    6,   51,    7,   51,
  112,  143,   31,  103,  114,   44,  115,  117,  120,   87,
   88,   89,   90,   64,  118,  126,   67,   68,  121,  122,
  123,  104,   45,  104,   46,  104,   47,   48,   49,   46,
   50,   47,   48,   49,  129,   50,   32,   45,  128,   32,
  127,  100,   52,  130,   46,   74,   47,   48,   49,  104,
   50,  132,   46,  104,   47,   48,   49,  134,   50,  136,
   51,   51,   51,   51,  137,   51,   22,   14,   14,   14,
   14,  138,   14,  139,   50,   50,   50,   50,   35,   50,
   46,   46,   46,   46,   36,   46,   29,   26,  142,   14,
  181,   45,  141,   51,  144,  146,  147,  156,   31,  157,
   47,   48,   49,   32,   50,   99,  149,  161,  158,   99,
    6,    7,    8,  110,    6,    7,    8,  110,    1,  163,
  164,    2,    3,    4,    5,  172,  173,    6,    7,    8,
    9,    1,  176,  177,    2,    3,    4,  178,    4,  179,
    6,    7,    8,    9,   99,  100,  182,  183,  101,    6,
    7,    8,  102,  185,  186,  187,  188,    4,    2,   59,
   32,   66,   67,  168,   98,   99,   57,  102,  160,  167,
  116,
};
}
static short yycheck[];
static { yycheck(); }
static void yycheck() {
yycheck = new short[] {                         41,
    0,    0,   59,   45,   41,  125,  125,    0,   45,   60,
  125,   62,   40,  125,    0,   40,  125,  125,   46,    0,
    0,    0,    0,   45,    0,    0,    0,    0,    0,   44,
   40,   45,   44,   61,    0,   30,   61,  123,  277,   33,
    0,   41,   42,   43,   44,   45,  269,   47,   41,   42,
   43,   44,   45,   35,   47,   41,   38,   43,   44,   45,
   60,   41,   62,   44,   44,   44,   44,   60,   44,   62,
   42,   43,   44,   45,   60,   47,   62,   45,   44,   40,
   60,    0,   62,    0,   10,   46,  129,   42,   82,  269,
  108,  257,   47,  114,  260,   41,  258,  259,   59,   41,
   61,  137,   43,  269,   45,  126,  149,  104,  123,  106,
  123,  123,   96,   97,  132,   41,   42,   43,  136,  114,
  156,   26,  125,   59,   60,  125,  125,  163,  164,  261,
   35,  126,  125,   38,  266,  267,  268,  269,   44,  125,
  163,  164,  137,   44,  125,  125,  125,  125,   44,  125,
  125,  125,  125,  125,  262,  275,  275,  265,  179,  125,
  275,  156,  269,  275,  123,  125,  275,  269,  163,  164,
   35,  257,  108,   38,  260,  261,  262,  263,   83,   40,
  266,  267,  268,  269,  179,   44,   59,  125,   93,   94,
   95,   96,   97,  129,   46,   40,  132,  278,  279,  280,
  136,    9,   41,   41,   42,   43,  125,   45,  125,   47,
  146,  116,  269,  149,   44,   23,  125,   41,   83,  270,
  271,  272,  273,   31,  269,  123,   34,  269,   93,   94,
   95,  104,  269,  106,  276,  108,  278,  279,  280,  276,
  282,  278,  279,  280,   44,  282,  274,  269,  281,  274,
  269,  262,  157,  269,  276,  269,  278,  279,  280,  132,
  282,   44,  276,  136,  278,  279,  280,  125,  282,   44,
  270,  271,  272,  273,  123,  275,  275,  270,  271,  272,
  273,  269,  275,   41,  270,  271,  272,  273,   40,  275,
  270,  271,  272,  273,  275,  275,  275,  275,  269,  275,
  173,  269,  264,  275,   41,   40,  269,  123,  269,   40,
  278,  279,  280,  274,  282,  261,   44,   58,  125,  261,
  266,  267,  268,  269,  266,  267,  268,  269,  257,   44,
   44,  260,  261,  262,  263,   41,  123,  266,  267,  268,
  269,  257,   44,  275,  260,  261,  262,   41,  262,  123,
  266,  267,  268,  269,  261,  262,  125,   44,  265,  266,
  267,  268,  269,  125,  125,  125,  259,    0,    0,  125,
  269,   44,   44,  157,  125,  125,  125,  125,  146,  156,
   65,
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
"ListSentencias : SentenciaControl",
"ListSentencias : SentenciaEjecutable",
"ListSentencias : SentenciaDeclarativa",
"ReferenciaObjeto : ID '.' ID",
"ReferenciaObjeto : ID '.' LlamadoFuncion",
"SentenciaEjecutable : Asignacion",
"SentenciaEjecutable : LlamadoFuncion",
"SentenciaEjecutable : BloqueIF",
"SentenciaEjecutable : SalidaMensaje",
"SentenciaEjecutable : ReferenciaObjeto",
"ClaseSentenciaEjecutable : ID ListVariables ','",
"ClaseSentenciaEjecutable : ID ListVariables",
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

//#line 212 "gramatica.y"

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
//#line 478 "Parser.java"
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
{agregarErrorSintactico("Se espera '}' en la linea ");}
break;
case 3:
//#line 16 "gramatica.y"
{agregarErrorSintactico("Se espera '{' en la linea ");}
break;
case 4:
//#line 17 "gramatica.y"
{agregarErrorSintactico("Se esperan '{' '}' en la linea ");}
break;
case 11:
//#line 26 "gramatica.y"
{agregarErrorSintactico("Se esperaba una ',' al final de la linea ");}
break;
case 12:
//#line 27 "gramatica.y"
{agregarErrorSintactico("Se esperaba una ',' al final de la linea ");}
break;
case 13:
//#line 28 "gramatica.y"
{agregarErrorSintactico("Se esperaba una ',' al final de la linea ");}
break;
case 22:
//#line 45 "gramatica.y"
{agregarErrorSintactico("Se esperaba una ',' al final de la linea ");}
break;
case 25:
//#line 49 "gramatica.y"
{agregarErrorSintactico("Se espera el tipo de la variable en la linea ");}
break;
case 26:
//#line 50 "gramatica.y"
{agregarErrorSintactico("Se espera identificador de la variable en la linea ");}
break;
case 31:
//#line 56 "gramatica.y"
{agregarErrorSintactico("Se espera un ';' seguido de cada variable en caso de querer agregar mas en la linea ");}
break;
case 39:
//#line 68 "gramatica.y"
{agregarErrorLexico("Un entero corto no puede ser negativo en la linea ");}
break;
case 55:
//#line 94 "gramatica.y"
{agregarEstructura("Reconoce ELSE IF ");}
break;
case 56:
//#line 95 "gramatica.y"
{agregarEstructura("Reconoce IF ");}
break;
case 59:
//#line 100 "gramatica.y"
{agregarErrorSintactico("Se esperaba una ',' al final de la linea ");}
break;
case 70:
//#line 116 "gramatica.y"
{agregarEstructura("Reconoce funcion VOID ");}
break;
case 71:
//#line 117 "gramatica.y"
{agregarEstructura("Reconoce funcion VOID ");}
break;
case 72:
//#line 118 "gramatica.y"
{agregarEstructura("Reconoce funcion VOID ");}
break;
case 79:
//#line 131 "gramatica.y"
{agregarErrorSintactico("Se esperaba una ',' al final de la linea ");}
break;
case 80:
//#line 132 "gramatica.y"
{agregarErrorSintactico("Se esperaba una ',' al final de la linea ");}
break;
case 94:
//#line 168 "gramatica.y"
{agregarEstructura("Reconoce funcion DO UNTIL");}
break;
case 95:
//#line 169 "gramatica.y"
{agregarErrorSintactico("Se esperaba una condicion ");}
break;
case 96:
//#line 174 "gramatica.y"
{agregarEstructura("Reconoce funcion TOD ");}
break;
case 97:
//#line 175 "gramatica.y"
{agregarErrorSintactico("Se esperaba una Expresion ");}
break;
case 104:
//#line 187 "gramatica.y"
{agregarEstructura("Reconoce CLASE");}
break;
case 108:
//#line 198 "gramatica.y"
{agregarEstructura("Reconoce Funcion sin cuerpo");}
break;
case 110:
//#line 202 "gramatica.y"
{agregarEstructura("Reconoce funcion IMPL");}
break;
//#line 731 "Parser.java"
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
