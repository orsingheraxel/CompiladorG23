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
import AnalisisLexico.AccionesSemanticas.AccionSemantica;
import java.io.*;
import java.util.*;
//#line 25 "Parser.java"




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
    6,    7,    4,    4,    4,    4,    4,    5,    5,    5,
    5,    5,    5,   13,   13,   16,   12,   12,   12,   17,
   17,   17,   17,   17,   17,   18,   18,   18,   18,   19,
   19,   19,   19,   19,   19,   21,   21,   22,   23,   23,
   23,   10,   10,   25,   25,   25,   24,   24,   24,   24,
   24,   24,   26,   26,   26,   26,   14,   14,   14,   14,
   28,   28,   28,   29,   30,   30,   30,   30,   30,   30,
   30,   30,    8,    8,    8,    8,    8,    8,   11,   11,
   31,   31,    9,    9,    9,    9,    9,    3,    3,   20,
   20,   20,   20,   32,   32,   32,   32,   32,   32,   15,
   15,   15,   15,   27,   27,   27,   27,   33,   33,   33,
};
final static short yylen[] = {                            2,
    3,    2,    2,    1,    2,    3,    1,    1,    1,    1,
    3,    3,    1,    1,    1,    1,    1,    2,    1,    1,
    1,    1,    1,    1,    3,    2,    1,    1,    1,    1,
    1,    2,    1,    2,    2,    3,    3,    1,    1,    3,
    3,    1,    3,    3,    1,    1,    1,    1,    5,    4,
    4,   10,    6,    2,    3,    1,    1,    1,    1,    1,
    1,    1,    1,    1,    2,    2,    6,    7,    6,    6,
    4,    3,    3,    1,    3,    3,    2,    2,    2,    3,
    1,    1,    3,    4,    2,    2,    3,    3,    2,    2,
    1,    1,    3,    3,    3,    2,    2,    6,    5,    4,
    3,    3,    3,    2,    1,    3,    4,    2,    3,    5,
    2,    4,    4,    4,    5,    4,    3,    7,    6,    6,
};
final static short yydefred[] = {                         0,
    0,    0,    0,    0,    0,   28,   27,   29,    0,    0,
    0,    0,    0,    8,    9,   10,    0,   17,   14,   13,
   15,   16,    0,   20,   19,   22,   23,    0,    0,   30,
   31,   33,    0,    0,   48,   47,    0,    0,   39,    0,
    0,    0,   46,   89,   90,    0,    0,    0,    0,   92,
    0,    0,    0,   86,   91,   26,    0,    0,    0,    3,
    0,    0,    0,   18,    0,    0,    0,   34,   32,   35,
    0,   61,   62,   60,   59,   57,   58,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,   12,   25,   83,    0,   87,   93,    1,    6,   94,
   95,   11,  101,    0,  103,    0,    0,   37,   36,   40,
   41,   43,   44,    0,    0,    0,    0,    0,   66,    0,
   65,  113,    0,    0,    0,    0,    0,    0,    0,   84,
  100,    0,   51,    0,    0,    0,    0,  110,    0,  109,
  106,    0,    0,    0,    0,    0,   74,    0,   73,    0,
   55,    0,   49,    0,   53,    0,  114,    0,  107,    0,
    0,    0,    0,   69,   71,   67,   98,    0,  115,    0,
    0,   80,   68,   76,   75,    0,    0,  120,    0,  118,
   52,
};
final static short yydgoto[] = {                         11,
   12,   13,   14,  154,  155,   35,   18,   19,   20,   21,
   22,   23,   24,   25,   26,   27,   36,   57,   38,   39,
   40,   41,   42,   78,  100,   91,   92,   97,  156,  157,
   58,   93,   94,
};
final static short yysindex[] = {                       -56,
   73,  -45, -236, -233,  -33,    0,    0,    0,  -30,  270,
    0,  -27,   48,    0,    0,    0,  -53,    0,    0,    0,
    0,    0, -149,    0,    0,    0,    0,   91,   94,    0,
    0,    0,  -80,   41,    0,    0,  114,   10,    0,   58,
   93,   23,    0,    0,    0,  -97,  -26,   47,  163,    0,
 -108, -149,  -24,    0,    0,    0,  141,   41,   63,    0,
  270,   46,  131,    0,  -77,   67,  167,    0,    0,    0,
  114,    0,    0,    0,    0,    0,    0,   41,   41,   41,
   46,   46,   46,   46,   47,  -43,  -61,  189, -149,  -25,
  192,  -25,  113,  199,  -37,  -22,  130,   61,  213,  145,
  -18,    0,    0,    0,  225,    0,    0,    0,    0,    0,
    0,    0,    0,  240,    0,   41,  252,    0,    0,    0,
    0,    0,    0,  183,  111,   42,  184,  268,    0,  189,
    0,    0,  189,  -82,   49,  272,  166,   47,   59,    0,
    0,  288,    0,  -86,  115,   66,  273,    0,  189,    0,
    0,  289,  166,  290,  304,  207,    0,  309,    0,  231,
    0,   73,    0,  235,    0,  100,    0, -104,    0,  166,
  234,  166,  166,    0,    0,    0,    0,   47,    0,  109,
  239,    0,    0,    0,    0,  255,  263,    0,  132,    0,
    0,
};
final static short yyrindex[] = {                         0,
    0,    0,    0,    0,    0,    0,    0,    0,   20,    0,
    0,  394,   24,    0,    0,    0,    0,    0,    0,    0,
    0,    0,   30,    0,    0,    0,    0,    1,    0,    0,
    0,    0,    0,    0,    0,    0,    0,   18,    0,    6,
   13,    0,    0,    0,    0,   28,    0,    0,   52,    0,
    0,    0,   32,    0,    0,    0,    0,   37,  395,    0,
   34,   38,   20,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,  352,
    0,  355,    0,    2,    0,    0,    0,    0,  276,    0,
  -49,    0,    0,    0,   39,    0,    0,    0,    0,    0,
    0,    0,    0,   25,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,   40,    3,    0,   35,
    0,    0,    0,    0,    0,    0,    0,  277,    0,    0,
    0,   71,    0,    0,    0,  146,    0,    0,    0,    0,
    0,    0,    0,    5,    7,    0,    0,  -35,    0,    0,
    0,   70,    0,    0,    0,    0,    0,    0,    0,   77,
   60,   89,  103,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,   65,    0,    0,    0,
    0,
};
final static short yygindex[] = {                         0,
  106,    0,    0,  344,  142,  328,    0,  353,    0,    0,
    0,  372,  102,  360,    0,    0,    0,  364,  134,    0,
  121,    0,  241,  336,   81,   27,    0,  284,   44,  133,
  393,  267,    0,
};
final static int YYTABLESIZE=540;
static short yytable[];
static { yytable();}
static void yytable(){
yytable = new short[]{                         33,
   46,  105,  104,  134,   81,   42,   82,   55,   72,   53,
   54,   11,   45,   95,   33,   51,  104,   38,  180,   24,
   33,   53,   54,    7,  102,   88,   33,  111,   52,   21,
   55,   85,   46,    5,  108,   47,   96,   97,   88,  112,
  153,   46,   46,   46,   46,   46,   42,   46,   42,   42,
   42,   24,   80,   45,   79,   45,   45,   45,   38,   70,
   46,   38,   46,   24,  119,   42,   10,   42,  102,   99,
   50,  111,   45,   21,   45,   85,   79,   38,  108,   38,
   96,   97,   88,  112,  102,   33,  102,   72,   77,   48,
   33,   61,   46,   46,   46,   24,   46,   60,   46,   81,
   53,   54,   78,   70,   82,   33,   51,  113,  119,  167,
   56,   33,   34,   99,   50,   59,  129,   33,  131,   63,
   79,   55,   45,   46,   64,   46,  105,  104,   42,   81,
   42,   82,   77,   66,   83,   45,   65,   45,   33,   84,
   38,   16,   38,  179,   24,   85,   78,  102,    7,  102,
  145,   16,  111,  103,   21,  166,   85,    4,    5,  108,
  101,   96,   97,   88,   86,  124,  109,   87,    6,    7,
    8,  164,  165,   76,    1,   77,   24,    2,    3,    4,
  160,  106,  111,    6,    7,    8,    9,  108,  137,   52,
  128,  112,  152,   50,   99,   50,  171,   68,   69,   70,
    1,   79,   16,    2,    3,    4,    5,  115,   65,    6,
    7,    8,    9,   77,  120,  121,  122,  123,  161,  126,
   50,   52,  153,   43,   11,  125,   72,   78,    6,    7,
    8,   44,   30,   31,   32,  130,   86,  132,   49,    6,
    7,    8,  133,   50,   28,   29,  136,   30,   31,   32,
   28,   29,  137,   30,   31,   32,  138,   29,  186,   30,
   31,   32,   46,  105,  104,  140,   81,   42,   82,  139,
   46,   46,   46,   46,   45,   42,   42,   42,   42,   38,
  141,   24,   45,   45,   45,   45,  102,   38,   38,   38,
   38,   21,  143,   85,  102,  102,  102,  102,   96,   97,
   88,  112,  182,    1,  184,  185,    2,  144,  148,   28,
  147,  149,  159,   24,   28,   98,   29,  158,   30,   31,
   32,   70,  162,   30,   31,   32,  119,   17,  163,   28,
  168,  174,  170,  172,   50,   28,   29,   17,   30,   31,
   32,   28,   29,   15,   30,   31,   32,  173,   29,  175,
   30,   31,   32,   15,  127,  176,    1,  178,  183,    2,
    3,    4,   28,  188,   37,    6,    7,    8,    9,   29,
    4,   30,   31,   32,  152,   17,    6,    7,    8,  189,
    6,    7,    8,   72,   73,   74,   75,  190,   17,  110,
  191,   99,   67,    4,    2,   63,  150,   71,   64,  151,
   56,   54,  177,  102,   15,   90,  116,  117,  146,   62,
    0,    0,   17,    0,    0,  169,  105,   89,   96,    0,
    0,  107,    1,    0,    0,    2,    3,    4,   99,  114,
    0,    6,    7,    8,    9,    0,    0,    0,    0,    0,
  152,  117,  118,  119,    0,    0,    0,   90,    0,   90,
   86,   90,    0,   87,    6,    7,    8,    0,    0,   89,
    0,   17,    0,    0,   17,   17,  135,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,  142,
   17,   99,    0,    0,    0,    0,    0,    0,    0,   90,
    0,    0,   90,   17,    0,    0,   96,   17,    0,   17,
   17,   89,    0,    0,   89,   17,    0,    0,   90,    0,
    0,    0,    0,    0,    0,    0,  135,    0,    0,    0,
   89,   99,    0,    0,    0,   37,    1,  181,    0,    2,
    3,    4,    5,    0,    0,    6,    7,    8,    9,  187,
};
}
static short yycheck[];
static { yycheck(); }
static void yycheck() {
yycheck = new short[] {                         45,
    0,    0,    0,   41,    0,    0,    0,   61,   44,   40,
   41,   61,    0,   40,   45,   46,   41,    0,  123,    0,
   45,   40,   41,    0,    0,  123,   45,    0,   59,    0,
   61,    0,  269,    0,    0,  269,    0,    0,    0,    0,
  123,   41,   42,   43,   44,   45,   41,   47,   43,   44,
   45,    0,   43,   41,   45,   43,   44,   45,   41,    0,
   60,   44,   62,   44,    0,   60,  123,   62,   44,    0,
    0,   44,   60,   44,   62,   44,    0,   60,   44,   62,
   44,   44,   44,   44,   60,   45,   62,  123,    0,  123,
   45,   44,   41,   42,   43,   44,   45,  125,   47,   42,
   40,   41,    0,   44,   47,   45,   46,   41,   44,   44,
    9,   45,   40,   44,   44,   10,   90,   45,   92,  269,
   44,   61,    2,  123,   23,  125,  125,  125,  123,  125,
  125,  125,   44,   40,   42,  123,   46,  125,   45,   47,
  123,    0,  125,   44,  125,  123,   44,  123,  125,  125,
   40,   10,  125,   52,  125,   41,  125,  262,  125,  125,
  269,  125,  125,  125,  262,   85,   61,  265,  266,  267,
  268,  258,  259,   60,  257,   62,  125,  260,  261,  262,
  137,   41,   62,  266,  267,  268,  269,  125,  123,   59,
   89,  269,  275,  123,  125,  125,  153,  278,  279,  280,
  257,  125,   61,  260,  261,  262,  263,   41,   46,  266,
  267,  268,  269,  125,   81,   82,   83,   84,  138,  281,
  274,   59,  123,  269,  274,  269,  262,  125,  266,  267,
  268,  277,  278,  279,  280,   44,  262,  125,  269,  266,
  267,  268,   44,  274,  269,  276,  269,  278,  279,  280,
  269,  276,  123,  278,  279,  280,   44,  276,  178,  278,
  279,  280,  262,  262,  262,   41,  262,  262,  262,  125,
  270,  271,  272,  273,  262,  270,  271,  272,  273,  262,
   41,  262,  270,  271,  272,  273,  262,  270,  271,  272,
  273,  262,   41,  262,  270,  271,  272,  273,  262,  262,
  262,  262,  170,  257,  172,  173,  260,  125,  125,  269,
  269,   44,   41,  262,  269,  269,  276,  269,  278,  279,
  280,  262,  264,  278,  279,  280,  262,    0,   41,  269,
   58,  125,   44,   44,  274,  269,  276,   10,  278,  279,
  280,  269,  276,    0,  278,  279,  280,   44,  276,   41,
  278,  279,  280,   10,   88,  125,  257,  123,  125,  260,
  261,  262,  269,  125,    1,  266,  267,  268,  269,  276,
  262,  278,  279,  280,  275,   48,  266,  267,  268,  125,
  266,  267,  268,  270,  271,  272,  273,  125,   61,   62,
  259,   48,   29,    0,    0,   44,  130,   34,   44,  133,
  125,  125,  162,   51,   61,   46,   71,  262,  125,   17,
   -1,   -1,   85,   -1,   -1,  149,   53,   46,   47,   -1,
   -1,   58,  257,   -1,   -1,  260,  261,  262,   85,   66,
   -1,  266,  267,  268,  269,   -1,   -1,   -1,   -1,   -1,
  275,   78,   79,   80,   -1,   -1,   -1,   88,   -1,   90,
  262,   92,   -1,  265,  266,  267,  268,   -1,   -1,   88,
   -1,  134,   -1,   -1,  137,  138,   95,   -1,   -1,   -1,
   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,  116,
  153,  138,   -1,   -1,   -1,   -1,   -1,   -1,   -1,  130,
   -1,   -1,  133,  166,   -1,   -1,  125,  170,   -1,  172,
  173,  130,   -1,   -1,  133,  178,   -1,   -1,  149,   -1,
   -1,   -1,   -1,   -1,   -1,   -1,  145,   -1,   -1,   -1,
  149,  178,   -1,   -1,   -1,  162,  257,  168,   -1,  260,
  261,  262,  263,   -1,   -1,  266,  267,  268,  269,  180,
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
"Condicion : '(' Expresion Comparador Expresion ')'",
"Condicion : '(' Expresion Comparador Expresion",
"Condicion : Expresion Comparador Expresion ')'",
"BloqueIF : IF Condicion '{' ListSentenciasIF '}' ELSE '{' ListSentenciasIF '}' END_IF",
"BloqueIF : IF Condicion '{' ListSentenciasIF '}' END_IF",
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
"Funcion : VOID ID Parametro '{' CuerpoFuncion '}'",
"Funcion : VOID ID '(' ')' '{' CuerpoFuncion '}'",
"Funcion : VOID ID '(' ')' CuerpoFuncion '}'",
"Funcion : VOID ID '(' ')' '{' CuerpoFuncion",
"Parametro : '(' Tipo ID ')'",
"Parametro : '(' Tipo ID",
"Parametro : Tipo ID ')'",
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
"LlamadoFuncion : ID '('",
"LlamadoFuncion : ID ')'",
"LlamadoFuncion : ID Expresion ')'",
"LlamadoFuncion : ID '(' Expresion",
"SalidaMensaje : PRINT CADENA",
"SalidaMensaje : PRINT Factor",
"OperadorAsignacion : '='",
"OperadorAsignacion : ASIG",
"Asignacion : ID OperadorAsignacion Expresion",
"Asignacion : ReferenciaObjeto OperadorAsignacion ReferenciaObjeto",
"Asignacion : ReferenciaObjeto OperadorAsignacion Factor",
"Asignacion : ID OperadorAsignacion",
"Asignacion : ReferenciaObjeto OperadorAsignacion",
"SentenciaControl : DO '{' ListSentenciasIF '}' UNTIL Condicion",
"SentenciaControl : DO '{' ListSentenciasIF '}' UNTIL",
"ConversionExplicita : TOD '(' Expresion ')'",
"ConversionExplicita : TOD '(' ')'",
"ConversionExplicita : TOD '(' Expresion",
"ConversionExplicita : TOD Expresion ')'",
"ListHerencia : Tipo ListVariables",
"ListHerencia : FuncionIMPL",
"ListHerencia : FuncionIMPL ',' ListHerencia",
"ListHerencia : Tipo ListVariables ',' ListHerencia",
"ListHerencia : ListFuncion ','",
"ListHerencia : ListFuncion ',' ListHerencia",
"HerenciaComposicion : CLASS ID '{' ListHerencia '}'",
"HerenciaComposicion : CLASS ID",
"HerenciaComposicion : CLASS ID '{' ListHerencia",
"HerenciaComposicion : CLASS ID ListHerencia '}'",
"FuncionSinCuerpo : VOID ID Parametro ','",
"FuncionSinCuerpo : VOID ID '(' ')' ','",
"FuncionSinCuerpo : VOID ID '(' ')'",
"FuncionSinCuerpo : VOID ID Parametro",
"FuncionIMPL : IMPL FOR ID ':' '{' Funcion '}'",
"FuncionIMPL : IMPL FOR ID ':' '{' Funcion",
"FuncionIMPL : IMPL FOR ID ':' Funcion '}'",
};

//#line 215 "gramatica.y"

  static ArrayList<Error> erroresLexicos = new ArrayList<Error>();
  static ArrayList<Error> erroresSintacticos = new ArrayList<Error>();
  static ArrayList<String> estructuraReconocida = new ArrayList<String>();

   public void chequearEnteroNegativo(String m){
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
   }

   public void chequearEnteroPositivo(String m){
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
   }

   public void chequearEnteroCorto(String m){
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
         }

   public void chequearDouble(String m){
           String n = m.replace('D', 'e').replace('d','e');
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
      }

  public int yylex() throws IOException{
    Token t = AnalizadorLexico.obtenerToken();
    this.yylval = new ParserVal(t.getLexema());
    return t.getId();
  }

  public static void yyerror(String error){
    System.out.println(error);
  }
//#line 568 "Parser.java"
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
case 1:
//#line 16 "gramatica.y"
{AnalizadorLexico.agregarEstructura("Reconoce programa ");}
break;
case 2:
//#line 17 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se espera '}' en la linea ");}
break;
case 3:
//#line 18 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se espera '{' en la linea ");}
break;
case 4:
//#line 19 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperan '{' '}' en la linea ");}
break;
case 7:
//#line 24 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba una ',' al final de la linea ");}
break;
case 20:
//#line 47 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se espera el tipo de la variable en la linea ");}
break;
case 21:
//#line 48 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se espera identificador de la variable en la linea ");}
break;
case 30:
//#line 65 "gramatica.y"
{chequearEnteroPositivo(val_peek(0).sval);}
break;
case 31:
//#line 66 "gramatica.y"
{chequearEnteroCorto(val_peek(0).sval);}
break;
case 32:
//#line 67 "gramatica.y"
{AnalizadorLexico.agregarErrorLexico("Un entero corto no puede ser negativo en la linea ");}
break;
case 33:
//#line 68 "gramatica.y"
{chequearDouble(val_peek(0).sval);}
break;
case 34:
//#line 69 "gramatica.y"
{chequearEnteroNegativo(val_peek(0).sval);}
break;
case 35:
//#line 70 "gramatica.y"
{chequearDouble(val_peek(0).sval);}
break;
case 50:
//#line 96 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba una ')' ");}
break;
case 51:
//#line 97 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba una '(' ");}
break;
case 52:
//#line 100 "gramatica.y"
{AnalizadorLexico.agregarEstructura("Reconoce IF ELSE ");}
break;
case 53:
//#line 101 "gramatica.y"
{AnalizadorLexico.agregarEstructura("Reconoce IF ");}
break;
case 56:
//#line 106 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba una ',' ");}
break;
case 67:
//#line 123 "gramatica.y"
{AnalizadorLexico.agregarEstructura("Reconoce funcion VOID ");}
break;
case 68:
//#line 124 "gramatica.y"
{AnalizadorLexico.agregarEstructura("Reconoce funcion VOID ");}
break;
case 69:
//#line 125 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba un '{' ");}
break;
case 70:
//#line 126 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba un '}' ");}
break;
case 72:
//#line 131 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba un ')' ");}
break;
case 73:
//#line 132 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba un '(' ");}
break;
case 81:
//#line 144 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba una ',' al final de la linea ");}
break;
case 82:
//#line 145 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba una ',' al final de la linea ");}
break;
case 83:
//#line 148 "gramatica.y"
{AnalizadorLexico.agregarEstructura("Reconoce llamado funcion ");}
break;
case 84:
//#line 149 "gramatica.y"
{AnalizadorLexico.agregarEstructura("Reconoce llamado funcion ");}
break;
case 85:
//#line 150 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba una ')' ");}
break;
case 86:
//#line 151 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba una '(' ");}
break;
case 87:
//#line 152 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba una '(' ");}
break;
case 88:
//#line 153 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba una ')' ");}
break;
case 89:
//#line 156 "gramatica.y"
{AnalizadorLexico.agregarEstructura("Reconoce salida de mensaje por pantalla ");}
break;
case 90:
//#line 157 "gramatica.y"
{AnalizadorLexico.agregarEstructura("Reconoce salida de mensaje por pantalla ");}
break;
case 96:
//#line 167 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba un operando de lado derecho de la asignación ");}
break;
case 97:
//#line 168 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba un operando de lado derecho de la asignación ");}
break;
case 98:
//#line 171 "gramatica.y"
{AnalizadorLexico.agregarEstructura("Reconoce funcion DO UNTIL");}
break;
case 99:
//#line 172 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba una condicion ");}
break;
case 100:
//#line 177 "gramatica.y"
{AnalizadorLexico.agregarEstructura("Reconoce funcion TOD ");}
break;
case 101:
//#line 178 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba una Expresion ");}
break;
case 102:
//#line 179 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba un ')' ");}
break;
case 103:
//#line 180 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba un '(' ");}
break;
case 110:
//#line 191 "gramatica.y"
{AnalizadorLexico.agregarEstructura("Reconoce CLASE");}
break;
case 112:
//#line 193 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba un '}' ");}
break;
case 113:
//#line 194 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba un '{' ");}
break;
case 114:
//#line 197 "gramatica.y"
{AnalizadorLexico.agregarEstructura("Reconoce Funcion sin cuerpo");}
break;
case 115:
//#line 198 "gramatica.y"
{AnalizadorLexico.agregarEstructura("Reconoce Funcion sin cuerpo");}
break;
case 116:
//#line 199 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba una ',' ");}
break;
case 117:
//#line 200 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba una ',' ");}
break;
case 118:
//#line 203 "gramatica.y"
{AnalizadorLexico.agregarEstructura("Reconoce funcion IMPL");}
break;
case 119:
//#line 204 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba un '}' ");}
break;
case 120:
//#line 205 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba un '{' ");}
break;
//#line 925 "Parser.java"
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
