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
    0,    0,    0,    0,    1,    1,    1,    2,    2,    2,
    6,    7,    4,    4,    4,    4,    4,    5,    5,    5,
    5,    5,    5,   13,   13,   16,   12,   12,   12,   17,
   17,   17,   17,   17,   17,   18,   18,   18,   18,   19,
   19,   19,   19,   19,   19,   21,   21,   22,   23,   10,
   10,   25,   25,   25,   24,   24,   24,   24,   24,   24,
   26,   26,   26,   26,   28,   28,   28,   28,   14,   14,
   30,   29,   29,   29,   29,   31,   31,   31,   31,   31,
   31,    8,    8,   11,   11,   32,   32,    9,    9,    9,
    3,    3,   20,   20,   33,   33,   33,   33,   33,   33,
   15,   15,   27,   27,   34,
};
final static short yylen[] = {                            2,
    3,    2,    2,    1,    2,    3,    1,    1,    1,    1,
    3,    3,    1,    1,    1,    1,    1,    2,    1,    1,
    1,    1,    1,    1,    3,    2,    1,    1,    1,    1,
    1,    2,    1,    2,    2,    3,    3,    1,    1,    3,
    3,    1,    3,    3,    1,    1,    1,    1,    3,   12,
    8,    2,    3,    1,    1,    1,    1,    1,    1,    1,
    1,    1,    2,    2,    1,    1,    3,    3,    8,    7,
    2,    1,    2,    2,    3,    3,    3,    2,    2,    1,
    1,    3,    4,    2,    2,    1,    1,    3,    3,    3,
    8,    5,    4,    3,    2,    1,    3,    4,    2,    3,
    5,    2,    6,    5,    7,
};
final static short yydefred[] = {                         0,
    0,    0,    0,    0,    0,   28,   27,   29,    0,    0,
    0,    0,    0,    8,    9,   10,    0,   17,   14,   13,
   15,   16,    0,   20,   19,   22,   23,    0,   46,   84,
   30,   31,   33,    0,   47,   85,    0,    0,    0,    0,
   87,    0,    0,    0,   86,   26,    0,    0,    3,    0,
    0,   18,    0,    0,   48,    0,    0,   39,    0,    0,
    0,   34,   32,   35,    0,    0,    0,    0,    0,    0,
   12,   25,   82,    0,   88,    1,    6,   89,   90,    0,
    0,   59,   60,   58,   57,   55,   56,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,   83,   11,
   94,    0,   49,   37,   36,   40,   41,   43,   44,    0,
    0,    0,    0,   64,    0,   63,  101,    0,    0,   71,
    0,   53,    0,   93,    0,    0,    0,    0,  100,   97,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,   98,    0,    0,    0,   70,   74,    0,    0,    0,
   51,  104,    0,    0,   75,   77,   76,   69,   91,    0,
  103,    0,    0,  105,    0,   50,
};
final static short yydgoto[] = {                         11,
   12,   13,   14,  142,  143,   17,   18,   19,   20,   21,
   22,   23,   24,   25,   26,   27,   35,   56,   57,   58,
   59,   60,   61,   88,   69,  100,  101,    0,  144,  106,
  145,   47,  102,  103,
};
final static short yysindex[] = {                       -70,
   -2,  -28, -209, -193,  -33,    0,    0,    0,   -9,  -56,
    0,  -31,   65,    0,    0,    0,  -55,    0,    0,    0,
    0,    0, -153,    0,    0,    0,    0,  -23,    0,    0,
    0,    0,    0, -137,    0,    0,   -6,  104, -136,   86,
    0, -120, -153,  -41,    0,    0,  -23,   33,    0,  -56,
    6,    0,  101,  114,    0,  -50,   29,    0,   68,   80,
  118,    0,    0,    0,  165,   38,  -38,  116,   44,  134,
    0,    0,    0,  135,    0,    0,    0,    0,    0,  -94,
  -36,    0,    0,    0,    0,    0,    0,  -23,  -23,  -23,
    6,    6,    6,    6,   59,  -88,  -97, -153,  -77,  145,
  -77,   69,  151,   79,  -66,  167, -136,  -49,    0,    0,
    0,  168,    0,    0,    0,    0,    0,    0,    0, -136,
  174,  -52,  180,    0,  165,    0,    0,  165,  140,    0,
   95,    0,  185,    0,  102,   55,  171,  165,    0,    0,
  186,  187,  190,  120,  140,  140,  -23, -226,  -18,  206,
  131,    0,  140,  156,  156,    0,    0,  139,  218,  143,
    0,    0,  -17,   15,    0,    0,    0,    0,    0, -136,
    0,  154,  155,    0,   36,    0,
};
final static short yyrindex[] = {                         0,
    0,    0,    0,    0,    0,    0,    0,    0,  107,    0,
    0,  297,    7,    0,    0,    0,    0,    0,    0,    0,
    0,    0,  123,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,   75,    0,    0,   91,
    0,    0,    0,    0,    0,    0,    0,  299,    0,   14,
    0,    0,    1,    0,    0,    0,   58,    0,   21,   41,
    0,    0,    0,    0,    0,    0,    0,  175,    0,  -48,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,  273,    0,
  290,    0,  213,    0,    0,    0,  214,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,  215,    0,  220,    0,    0,    0,    0,    0,
    0,    0,   11,    0,    0,    0,    0,    0,    0,    0,
    0, -105,  -89,    0,  221,    0,    0,    0,    0,    0,
    0,    0,  222, -122, -110,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,
};
final static short yygindex[] = {                         0,
   39,    0,    0,   18,   30,  348,    0,  307,    0,    0,
    0,   12,   16,  -30,    0,    0,    0,   23,   37,    0,
   22,    0,  207,    0,  -73,  -45,    0,    0,  -53,  219,
  -67,  339, -109,    0,
};
final static int YYTABLESIZE=495;
static short yytable[];
static { yytable();}
static void yytable(){
yytable = new short[]{                         73,
   46,   44,   78,   34,  111,   45,    7,   42,   34,   86,
   92,   87,   11,    5,   79,  139,   34,   15,  140,   80,
   42,   34,   45,   36,   46,  162,  171,   15,  152,   16,
   44,  160,  161,  132,   99,   81,   42,   28,   52,   16,
   45,   46,   46,   46,   46,   46,  135,   46,   48,   43,
   34,   45,   10,  124,   92,  126,   68,   38,   72,   37,
   46,   42,   46,   42,   42,   42,   74,   15,   99,   75,
   99,   90,   79,   89,  102,   38,   98,  105,  104,   16,
   42,   45,   42,   45,   45,   45,  166,  167,   77,   39,
   24,  157,  158,   49,   99,  149,  173,   99,   38,  165,
   45,   38,   45,  112,  129,  146,   24,   99,   50,   91,
  113,  114,  115,  123,   92,   40,   65,   38,  102,   38,
    1,   93,   21,    2,   68,   46,   94,  116,  117,  118,
  119,    7,   67,  172,   24,   92,   98,   68,    5,   98,
   62,   63,   64,   66,   43,   42,   80,  105,   70,   98,
   24,   80,   78,   81,   80,   80,   80,   76,   95,  107,
   80,   80,   80,   80,   79,   45,   21,   81,  108,   80,
   81,   81,   81,   44,  110,  109,   81,   81,   81,   81,
  121,  120,   38,  122,   96,   81,    1,   68,  125,    2,
    3,    4,    5,  127,  128,    6,    7,    8,    9,  102,
    1,  129,  130,    2,    3,    4,    5,  131,  134,    6,
    7,    8,    9,  136,  133,   24,  137,  146,   41,   82,
   83,   84,   85,  138,  147,   11,  148,   53,  151,  153,
  154,   24,   53,  155,   54,   41,   31,   32,   33,   54,
   29,   31,   32,   33,  156,   53,  163,   21,   30,   31,
   32,   33,   54,  164,   31,   32,   33,   46,  169,   40,
   46,   46,   46,  168,   41,  170,   46,   46,   46,   46,
   46,   46,   46,   46,   53,   46,    4,   42,  174,  175,
   42,   42,   42,   31,   32,   33,   42,   42,   42,   42,
   42,   42,   42,   42,  176,   42,    4,   45,    2,   54,
   45,   45,   45,    6,    7,    8,   45,   45,   45,   45,
   45,   45,   45,   45,   38,   45,   61,   38,   38,   38,
    6,    7,    8,   38,   38,   38,   38,   38,   38,   38,
   38,  102,   38,   62,  102,  102,  102,   96,   52,   95,
  102,  102,  102,  102,   99,   72,   73,   24,   71,  102,
   24,   24,   24,  159,  150,   51,   24,   24,   24,   24,
    0,    0,    0,   24,    0,   24,   24,   24,   24,    0,
    0,    0,   24,   24,   24,   55,    0,    0,    0,   21,
    0,   24,   21,   21,   21,    0,    0,    0,   21,   21,
   21,   55,    0,    0,   55,    0,    1,   21,   78,    2,
    3,    4,    0,    0,    0,    6,    7,    8,    9,    0,
    0,    0,    1,    0,  141,    2,    3,    4,    0,    0,
    0,    6,    7,    8,    9,    0,   96,    0,   55,   97,
    6,    7,    8,    0,    0,   55,   55,   55,   55,   55,
   55,   55,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,   55,
};
}
static short yycheck[];
static { yycheck(); }
static void yycheck() {
yycheck = new short[] {                         41,
    0,   40,  125,   45,   41,   61,    0,   46,   45,   60,
    0,   62,   61,    0,  125,  125,   45,    0,  128,  125,
    0,   45,   61,    2,    9,   44,   44,   10,  138,    0,
   40,  258,  259,  107,   65,  125,   46,   40,   23,   10,
    0,   41,   42,   43,   44,   45,  120,   47,   10,   59,
   45,   61,  123,   99,   44,  101,   39,    0,   43,  269,
   60,   41,   62,   43,   44,   45,   44,   50,   99,   47,
  101,   43,   51,   45,    0,  269,   65,   66,   41,   50,
   60,   41,   62,   43,   44,   45,  154,  155,   50,  123,
    0,  145,  146,  125,  125,   41,  170,  128,   41,  153,
   60,   44,   62,   81,  123,  123,    0,  138,   44,   42,
   88,   89,   90,   98,   47,  269,  123,   60,   44,   62,
  257,   42,    0,  260,  107,  125,   47,   91,   92,   93,
   94,  125,  269,  164,   44,  125,  125,  120,  125,  128,
  278,  279,  280,   40,   59,  125,   46,  136,  269,  138,
   44,  257,  275,   40,  260,  261,  262,  125,   41,   44,
  266,  267,  268,  269,  275,  125,   44,  257,  125,  275,
  260,  261,  262,   40,  269,   41,  266,  267,  268,  269,
  269,  123,  125,  281,  262,  275,  257,  170,   44,  260,
  261,  262,  263,  125,   44,  266,  267,  268,  269,  125,
  257,  123,  269,  260,  261,  262,  263,   41,   41,  266,
  267,  268,  269,   40,  264,  125,  269,  123,  274,  270,
  271,  272,  273,   44,   40,  274,  125,  269,   58,   44,
   44,  125,  269,   44,  276,  274,  278,  279,  280,  276,
  269,  278,  279,  280,  125,  269,   41,  125,  277,  278,
  279,  280,  276,  123,  278,  279,  280,  257,   41,  269,
  260,  261,  262,  125,  274,  123,  266,  267,  268,  269,
  270,  271,  272,  273,  269,  275,  262,  257,  125,  125,
  260,  261,  262,  278,  279,  280,  266,  267,  268,  269,
  270,  271,  272,  273,  259,  275,    0,  257,    0,  125,
  260,  261,  262,  266,  267,  268,  266,  267,  268,  269,
  270,  271,  272,  273,  257,  275,   44,  260,  261,  262,
  266,  267,  268,  266,  267,  268,  269,  270,  271,  272,
  273,  257,  275,   44,  260,  261,  262,  125,  125,  125,
  266,  267,  268,  269,  125,  125,  125,  257,   42,  275,
  260,  261,  262,  147,  136,   17,  266,  267,  268,  269,
   -1,   -1,   -1,  257,   -1,  275,  260,  261,  262,   -1,
   -1,   -1,  266,  267,  268,   28,   -1,   -1,   -1,  257,
   -1,  275,  260,  261,  262,   -1,   -1,   -1,  266,  267,
  268,   44,   -1,   -1,   47,   -1,  257,  275,   51,  260,
  261,  262,   -1,   -1,   -1,  266,  267,  268,  269,   -1,
   -1,   -1,  257,   -1,  275,  260,  261,  262,   -1,   -1,
   -1,  266,  267,  268,  269,   -1,  262,   -1,   81,  265,
  266,  267,  268,   -1,   -1,   88,   89,   90,   91,   92,
   93,   94,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,
   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,
   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,
   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,
   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,
   -1,   -1,   -1,   -1,  147,
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
"CuerpoFuncionConReturn : CuerpoFuncion",
"CuerpoFuncionConReturn : RETURN",
"CuerpoFuncionConReturn : CuerpoFuncion ',' CuerpoFuncionConReturn",
"CuerpoFuncionConReturn : RETURN ',' CuerpoFuncionConReturn",
"Funcion : VOID ID '(' Parametro ')' '{' CuerpoFuncion '}'",
"Funcion : VOID ID '(' ')' '{' CuerpoFuncion '}'",
"Parametro : Tipo ID",
"CuerpoFuncion : ListSentenciasFuncion",
"CuerpoFuncion : RETURN ','",
"CuerpoFuncion : ListSentenciasFuncion CuerpoFuncion",
"CuerpoFuncion : RETURN ',' CuerpoFuncion",
"ListSentenciasFuncion : SentenciaDeclarativa ',' ListSentenciasFuncion",
"ListSentenciasFuncion : SentenciaEjecutable ',' ListSentenciasFuncion",
"ListSentenciasFuncion : SentenciaEjecutable ','",
"ListSentenciasFuncion : SentenciaDeclarativa ','",
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

//#line 198 "gramatica.y"
  /* static List<Error> erroresLexicos = new ArrayList<Error>();
  static List<Error> erroresSintacticos = new ArrayList<Error>();
  static List<String> estructuraReconocida = new ArrayList<String>();

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
   } */

  public int yylex() throws IOException{
    Token t = AnalizadorLexico.obtenerToken();
    this.yylval = new ParserVal(t.getLexema());
    return t.getId();
  }

  public static void yyerror(String error){
    System.out.println(error);
  }
//#line 491 "Parser.java"
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
{AnalizadorLexico.agregarErrorSintactico("Se espera '}' en la linea ");}
break;
case 3:
//#line 16 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se espera '{' en la linea ");}
break;
case 4:
//#line 17 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperan '{' '}' en la linea ");}
break;
case 7:
//#line 22 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba una ',' al final de la linea ");}
break;
case 20:
//#line 45 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se espera el tipo de la variable en la linea ");}
break;
case 21:
//#line 46 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se espera identificador de la variable en la linea ");}
break;
case 32:
//#line 65 "gramatica.y"
{AnalizadorLexico.agregarErrorLexico("Un entero corto no puede ser negativo en la linea ");}
break;
case 50:
//#line 96 "gramatica.y"
{AnalizadorLexico.agregarEstructura("Reconoce ELSE IF ");}
break;
case 51:
//#line 97 "gramatica.y"
{AnalizadorLexico.agregarEstructura("Reconoce IF ");}
break;
case 54:
//#line 102 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba una ',' al final de la linea ");}
break;
case 69:
//#line 125 "gramatica.y"
{AnalizadorLexico.agregarEstructura("Reconoce funcion VOID ");}
break;
case 70:
//#line 126 "gramatica.y"
{AnalizadorLexico.agregarEstructura("Reconoce funcion VOID ");}
break;
case 80:
//#line 141 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba una ',' al final de la linea ");}
break;
case 81:
//#line 142 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba una ',' al final de la linea ");}
break;
case 91:
//#line 162 "gramatica.y"
{AnalizadorLexico.agregarEstructura("Reconoce funcion DO UNTIL");}
break;
case 92:
//#line 163 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba una condicion ");}
break;
case 93:
//#line 168 "gramatica.y"
{AnalizadorLexico.agregarEstructura("Reconoce funcion TOD ");}
break;
case 94:
//#line 169 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba una Expresion ");}
break;
case 101:
//#line 180 "gramatica.y"
{AnalizadorLexico.agregarEstructura("Reconoce CLASE");}
break;
case 103:
//#line 184 "gramatica.y"
{AnalizadorLexico.agregarEstructura("Reconoce Funcion sin cuerpo");}
break;
case 105:
//#line 188 "gramatica.y"
{AnalizadorLexico.agregarEstructura("Reconoce funcion IMPL");}
break;
//#line 724 "Parser.java"
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
