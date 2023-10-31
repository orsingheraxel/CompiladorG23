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
package AnalisisLexico;;
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
    0,    0,    0,    0,    1,    1,    1,    2,    2,    2,
    6,    6,    4,    4,    4,    4,    4,   11,   11,    5,
    5,    5,    5,    5,    5,   12,   12,   12,   13,   13,
   13,   13,   13,   16,   16,   16,   16,   16,   16,   16,
   17,   17,   17,   17,   18,   18,   18,   20,   20,   20,
   21,    9,    9,   23,   23,   23,   22,   22,   22,   22,
   22,   22,   24,   24,   24,   24,   14,   14,   14,   26,
   27,   28,   28,   28,   28,   28,   28,    7,    7,   29,
   29,   29,   10,   30,   30,    8,    8,    8,    8,    8,
    3,    3,   19,   19,   31,   31,   31,   31,   31,   31,
   15,   32,   32,   32,   25,   25,   33,
};
final static short yylen[] = {                            2,
    3,    2,    2,    1,    2,    3,    1,    1,    1,    1,
    3,    3,    1,    1,    1,    1,    1,    3,    2,    2,
    1,    1,    1,    1,    1,    1,    3,    2,    1,    1,
    1,    1,    1,    1,    1,    2,    1,    2,    2,    1,
    3,    3,    1,    1,    3,    3,    1,    1,    1,    1,
    3,   12,    8,    2,    3,    1,    1,    1,    1,    1,
    1,    1,    1,    1,    2,    2,   10,    9,    7,    2,
    1,    3,    3,    2,    2,    1,    1,    3,    4,    1,
    1,    1,    2,    1,    1,    3,    3,    3,    3,    5,
    8,    5,    4,    3,    1,    1,    3,    2,    2,    3,
    5,    3,    4,    3,    6,    5,    7,
};
final static short yydefred[] = {                         0,
    0,    0,    0,    0,    0,   31,   30,   32,    0,    0,
    0,    0,    0,    8,    9,   10,   17,   14,   13,   15,
   16,   24,   22,    0,   21,   25,    0,   83,    0,    0,
    0,    0,   85,    0,    0,    0,   84,    0,    0,    0,
    3,    0,   20,    0,    0,   34,   35,   37,   40,    0,
   50,   49,    0,    0,   44,    0,    0,    0,    0,    0,
    0,    0,   28,    0,   12,   27,    0,   78,   49,   81,
    0,   18,    0,   50,   49,   87,    1,    6,    0,    0,
   38,   36,   39,   61,   62,   60,   59,   57,   58,    0,
    0,    0,    0,    0,    0,   33,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,   29,    0,    0,    0,
    0,    0,    0,   79,    0,   94,    0,   51,   42,   41,
   45,   46,    0,    0,    0,    0,    0,   66,    0,   65,
  101,   98,    0,    0,   70,    0,   55,    0,    0,   90,
   93,    0,    0,    0,  104,    0,  100,   97,    0,    0,
    0,   71,    0,    0,    0,    0,    0,    0,  103,    0,
    0,    0,   69,    0,    0,    0,   53,  106,    0,    0,
   73,   72,    0,    0,   91,    0,  105,    0,   68,    0,
    0,  107,   67,    0,   52,
};
final static short yydgoto[] = {                         11,
   12,   13,   14,   61,  150,   17,   18,   19,   20,   21,
   22,   23,   24,   25,   26,   52,   53,   54,   55,   56,
   57,   90,   62,  102,  103,  110,  151,  152,   71,   39,
  104,  105,  106,
};
final static short yysindex[] = {                       -92,
   -4, -223, -178, -165,  -11,    0,    0,    0,   40,  -64,
    0,    3,   85,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0, -137,    0,    0,  -21,    0,   12,   96,
 -139,  -56,    0, -131, -137,  -41,    0,  100,  -13,   24,
    0,  -64,    0,  107,  122,    0,    0,    0,    0,  -63,
    0,    0,  -50,   65,    0,   -9,  125,   88,   55,  -27,
  119,   48,    0,  -24,    0,    0,  107,    0,    0,    0,
  131,    0,  107,    0,    0,    0,    0,    0,  -90,  -36,
    0,    0,    0,    0,    0,    0,    0,    0,    0,  -21,
  -21,  -21,   33,   33,   57,    0,  -86,  -96,  143,  -75,
  -67,  157,  -67,   84,   88,  162,    0,   89,  -51,  188,
 -139,  -19,  -20,    0,  213,    0,  219,    0,    0,    0,
    0,    0, -139,  214,   -7,  -42,  220,    0,   88,    0,
    0,    0,   88,   72,    0,  145,    0,  230,  107,    0,
    0,  150,   59,  224,    0,  -42,    0,    0,  240,  245,
 -119,    0,   72,  -21, -218,  -16,  258,  178,    0,   72,
   72,  259,    0,   32,  267,  187,    0,    0,  -14,   56,
    0,    0,  192,  275,    0, -139,    0,  205,    0,  206,
  210,    0,    0,   77,    0,
};
final static short yyrindex[] = {                         0,
    0,    0,   20,    0,    0,    0,    0,    0,   22,    0,
    0,  337,   26,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,   23,    0,    0,    0,    0,    0,    0,
    0,   22,    0,    0,    0,    0,    0,    2,    0,  342,
    0,   27,    0,    1,    0,    0,    0,    0,    0,    0,
    0,    0,    0,   21,    0,   15,    0,    0,    0,    0,
  218,    0,    0,   25,    0,    0,  189,    0,    0,    0,
    0,    0,   29,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0, -178,    0,
  300,    0,  301,    0,  221,  222,    0,    0,    0,    0,
  223,    0,    0,    0,    8,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,  226,    0,
    0,    0,    0,    0,    0,    0,    0,   35,    0,    0,
    0,    0,    0,    0,    0, -107,    0,    0, -118, -114,
    0,    0,    0,    0,    0,    0,    0,    0,    0, -111,
 -108,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,
};
final static short yygindex[] = {                         0,
   75,    0,    0,   47,   82,   98,    5,    0,    0,    0,
    0,   79,  247,   81,    0,   66,   51,    4,    0,    0,
  204,    0,  -17,   19,    0,  216,  207,  -45,    0,  297,
  -10,  -33,    0,
};
final static int YYTABLESIZE=393;
static short yytable[];
static { yytable();}
static void yytable(){
yytable = new short[]{                         68,
   48,   19,   35,   50,  116,  163,   76,   11,   50,   88,
   77,   89,   36,   74,   47,   36,   75,  102,   34,   33,
   43,   26,   23,   50,   11,    7,    5,  168,   48,  177,
   10,   50,   93,   37,   92,   27,   37,   94,   65,  166,
  167,   48,   48,   48,   48,   48,   15,   48,   11,   11,
   11,   11,   11,   28,   11,   47,   15,   47,   47,   47,
   48,   43,   48,   33,   43,   26,   23,   11,   11,   11,
   48,   48,   48,   48,   47,   48,   47,   50,   92,   36,
   43,   16,   43,   65,   40,   34,   70,   38,   15,   76,
   29,   16,  145,  137,  132,  108,  121,  122,   35,  156,
   37,   69,   43,   30,   75,  142,  134,   92,  153,   91,
   63,   31,  159,   66,  171,  172,   78,    1,  147,  128,
    2,  130,  148,   16,   51,   48,   19,   41,   42,   60,
  117,   32,   11,   51,   58,   59,   74,   64,  101,   47,
  118,  119,  120,   72,   33,   43,   26,   23,   77,   11,
    7,    5,   79,   48,  102,  162,   76,  102,  181,   92,
   77,   80,  111,   74,    1,   95,   75,    2,    3,    4,
    5,  114,  112,    6,    7,    8,    9,   51,  115,  123,
  149,  101,  124,  101,  125,  101,  126,   51,   51,   51,
   51,   51,    1,  127,   97,    2,    3,    4,    5,  149,
  129,    6,    7,    8,    9,  133,  149,  149,  131,  101,
  140,  134,   32,  101,   81,   82,   83,  135,   96,   84,
   85,   86,   87,    6,    7,    8,   99,   67,  136,   48,
   48,   48,   44,   48,   45,   48,   46,   47,   48,   45,
   49,   46,   47,   48,  138,   49,   33,   44,  139,   33,
  178,   51,   36,  143,   45,   73,   46,   47,   48,  141,
   49,  144,   45,  146,   46,   47,   48,  153,   49,  154,
   48,   48,   48,   48,  155,   48,   19,   11,   11,   11,
   11,  158,   11,  160,   47,   47,   47,   47,  161,   47,
   43,   43,   43,   43,   33,   43,   26,   23,  169,   11,
  170,   44,  173,   48,  100,  109,  174,  175,   32,  176,
   46,   47,   48,   33,   49,   96,  179,    4,  180,   96,
    6,    7,    8,  107,    6,    7,    8,  107,    1,  182,
  183,    2,    3,    4,  184,  185,    4,    6,    7,    8,
    9,    2,   56,   63,   64,   95,   96,   54,   96,   97,
   99,  100,   98,    6,    7,    8,   99,  165,  157,  164,
  113,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,  100,    0,    0,  100,    0,    0,    0,  100,
    0,    0,    0,    0,    0,    0,    0,    0,    0,  109,
    0,    0,  100,
};
}
static short yycheck[];
static { yycheck(); }
static void yycheck() {
yycheck = new short[] {                         41,
    0,    0,   59,   45,   41,  125,  125,    0,   45,   60,
  125,   62,   40,  125,    0,   40,  125,  125,   46,    0,
    0,    0,    0,   45,    0,    0,    0,   44,    0,   44,
  123,   45,   42,   61,    0,   40,   61,   47,   34,  258,
  259,   41,   42,   43,   44,   45,    0,   47,   41,   42,
   43,   44,   45,  277,   47,   41,   10,   43,   44,   45,
   60,   41,   62,   44,   44,   44,   44,   60,   44,   62,
   42,   43,   44,   45,   60,   47,   62,   45,   44,   40,
   60,    0,   62,   79,   10,   46,   36,    9,   42,   39,
  269,   10,  126,  111,  105,   41,   93,   94,   59,   41,
   61,   36,   24,  269,   39,  123,  123,   43,  123,   45,
   32,  123,  146,   35,  160,  161,   42,  257,  129,  101,
  260,  103,  133,   42,   27,  125,  125,  125,   44,  269,
   80,  269,  125,   36,  123,   40,   39,  269,   58,  125,
   90,   91,   92,   44,  125,  125,  125,  125,  125,  125,
  125,  125,   46,  125,  262,  275,  275,  265,  176,  125,
  275,   40,   44,  275,  257,   41,  275,  260,  261,  262,
  263,   41,  125,  266,  267,  268,  269,   80,  269,  123,
  134,  101,  269,  103,  281,  105,   44,   90,   91,   92,
   93,   94,  257,  269,  262,  260,  261,  262,  263,  153,
   44,  266,  267,  268,  269,   44,  160,  161,  125,  129,
  113,  123,  269,  133,  278,  279,  280,  269,  261,  270,
  271,  272,  273,  266,  267,  268,  269,  269,   41,   41,
   42,   43,  269,   45,  276,   47,  278,  279,  280,  276,
  282,  278,  279,  280,  264,  282,  274,  269,  269,  274,
  170,  154,   40,   40,  276,  269,  278,  279,  280,   41,
  282,  269,  276,   44,  278,  279,  280,  123,  282,   40,
  270,  271,  272,  273,  125,  275,  275,  270,  271,  272,
  273,   58,  275,   44,  270,  271,  272,  273,   44,  275,
  270,  271,  272,  273,  275,  275,  275,  275,   41,  275,
  123,  269,   44,  275,   58,   59,  275,   41,  269,  123,
  278,  279,  280,  274,  282,  261,  125,  262,   44,  261,
  266,  267,  268,  269,  266,  267,  268,  269,  257,  125,
  125,  260,  261,  262,  125,  259,    0,  266,  267,  268,
  269,    0,  125,   44,   44,  125,  125,  125,  261,  262,
  125,  105,  265,  266,  267,  268,  269,  154,  143,  153,
   64,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,
   -1,   -1,  126,   -1,   -1,  129,   -1,   -1,   -1,  133,
   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,  143,
   -1,   -1,  146,
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
"ListSentencias : Sentencia ','",
"ListSentencias : Sentencia ',' ListSentencias",
"ListSentencias : Sentencia",
"Sentencia : SentenciaControl",
"Sentencia : SentenciaEjecutable",
"Sentencia : SentenciaDeclarativa",
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

//#line 216 "gramatica.y"
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
//#line 476 "Parser.java"
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
int yyparse()
{
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
case 7:
//#line 22 "gramatica.y"
{agregarErrorSintactico("Se esperaba una ',' al final de la linea ");}
break;
case 19:
//#line 44 "gramatica.y"
{agregarErrorSintactico("Se esperaba una ',' al final de la linea ");}
break;
case 22:
//#line 49 "gramatica.y"
{agregarErrorSintactico("Se espera el tipo de la variable en la linea ");}
break;
case 23:
//#line 50 "gramatica.y"
{agregarErrorSintactico("Se espera identificador de la variable en la linea ");}
break;
case 28:
//#line 57 "gramatica.y"
{agregarErrorSintactico("Se espera un ';' seguido de cada variable en caso de querer agregar mas en la linea ");}
break;
case 36:
//#line 69 "gramatica.y"
{agregarErrorLexico("Un entero corto no puede ser negativo en la linea ");}
break;
case 52:
//#line 95 "gramatica.y"
{agregarEstructura("Reconoce ELSE IF ");}
break;
case 53:
//#line 96 "gramatica.y"
{agregarEstructura("Reconoce IF ");}
break;
case 56:
//#line 101 "gramatica.y"
{agregarErrorSintactico("Se esperaba una ',' al final de la linea ");}
break;
case 67:
//#line 118 "gramatica.y"
{agregarEstructura("Reconoce funcion VOID ");}
break;
case 68:
//#line 119 "gramatica.y"
{agregarEstructura("Reconoce funcion VOID ");}
break;
case 69:
//#line 120 "gramatica.y"
{agregarEstructura("Reconoce funcion VOID ");}
break;
case 76:
//#line 133 "gramatica.y"
{agregarErrorSintactico("Se esperaba una ',' al final de la linea ");}
break;
case 77:
//#line 134 "gramatica.y"
{agregarErrorSintactico("Se esperaba una ',' al final de la linea ");}
break;
case 91:
//#line 170 "gramatica.y"
{agregarEstructura("Reconoce funcion DO UNTIL");}
break;
case 92:
//#line 171 "gramatica.y"
{agregarErrorSintactico("Se esperaba una condicion ");}
break;
case 93:
//#line 176 "gramatica.y"
{agregarEstructura("Reconoce funcion TOD ");}
break;
case 94:
//#line 177 "gramatica.y"
{agregarErrorSintactico("Se esperaba una Expresion ");}
break;
case 101:
//#line 190 "gramatica.y"
{agregarEstructura("Reconoce CLASE");}
break;
case 105:
//#line 201 "gramatica.y"
{agregarEstructura("Reconoce Funcion sin cuerpo");}
break;
case 107:
//#line 206 "gramatica.y"
{agregarEstructura("Reconoce funcion IMPL");}
break;
//#line 721 "Parser.java"
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
public void run()
{
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
