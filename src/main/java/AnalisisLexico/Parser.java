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
import java.nio.file.Files;
import java.nio.file.Paths;
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
    0,    0,    0,    0,    0,    1,    1,    1,    2,    2,
    2,    6,    7,    4,    4,    4,    4,    4,    5,    5,
    5,    5,    5,    5,    5,   13,   13,   16,   12,   12,
   12,   18,   18,   18,   18,   18,   18,   19,   19,   19,
   19,   20,   20,   20,   20,   20,   20,   22,   22,   23,
   24,   24,   24,   10,   10,   26,   26,   26,   27,   28,
   28,   28,   25,   25,   25,   25,   25,   25,   29,   29,
   14,   14,   31,   31,   31,   32,   32,   33,   33,   33,
   33,   33,   33,   33,   33,    8,    8,   11,   11,   35,
   35,    9,    9,    9,    3,    3,   34,   34,   21,   21,
   36,   37,   37,   37,   37,   15,   30,   30,   17,   17,
};
final static short yylen[] = {                            2,
    3,    2,    2,    1,    2,    2,    3,    1,    1,    1,
    1,    3,    3,    1,    1,    1,    1,    1,    2,    1,
    1,    1,    1,    1,    1,    1,    3,    2,    1,    1,
    1,    1,    1,    2,    1,    2,    2,    3,    3,    1,
    1,    3,    3,    1,    3,    3,    1,    1,    1,    1,
    5,    4,    4,    6,    4,    3,    2,    2,    1,    2,
    3,    2,    1,    1,    1,    1,    1,    1,    1,    1,
    4,    5,    4,    3,    3,    3,    2,    3,    3,    2,
    2,    2,    3,    1,    1,    3,    2,    2,    2,    1,
    1,    3,    3,    3,    4,    3,    3,    2,    2,    3,
    3,    3,    4,    2,    3,    3,    3,    4,    7,    6,
};
final static short yydefred[] = {                         0,
    0,    0,    0,    0,    0,    0,   30,   29,   31,    0,
    0,    0,    0,    0,    9,   10,   11,    0,   18,   15,
   14,   16,   17,    0,   21,   20,   23,   24,   25,    0,
    0,   32,   33,   35,    0,    0,   50,   49,    0,    0,
   41,    0,    0,    0,   48,   88,   89,    0,    0,    0,
    0,    0,    0,    0,   59,    0,    0,   91,    0,    0,
    0,   90,   28,    0,   87,    0,    5,    0,    3,    0,
    0,    0,   19,    0,    0,   99,   36,   34,   37,    0,
   67,   68,   66,   65,   63,   64,    0,    0,    0,    0,
    0,    0,    0,    0,    0,  106,    0,    0,    0,   58,
    0,    0,   62,    0,   57,    0,    0,   13,   27,   86,
    0,   98,   92,    1,    7,   93,   94,   12,  100,    0,
    0,   39,   38,   42,   43,   45,   46,    0,   55,    0,
    0,   69,    0,   70,    0,    0,    0,    0,    0,    0,
    0,    0,   71,    0,   56,   61,   95,    0,   97,    0,
   53,    0,    0,    0,    0,  101,   72,    0,   75,    0,
    0,    0,    0,   77,    0,    0,   51,   54,    0,    0,
    0,  105,   73,   83,   76,   79,   78,    0,  110,    0,
  103,  109,
};
final static short yydgoto[] = {                         12,
   13,   14,   15,  141,  142,   37,   19,   20,   21,   22,
   23,   24,   25,   26,   27,   28,   29,   38,   64,   40,
   41,   42,   43,   44,   87,   53,   54,   55,  133,  134,
   99,  143,  144,   65,   66,   96,  135,
};
final static short yysindex[] = {                       146,
   37,  -45, -253, -239, -114, -243,    0,    0,    0,  -38,
 -100,    0,  -67,   35,    0,    0,    0,  -57,    0,    0,
    0,    0,    0, -186,    0,    0,    0,    0,    0,   58,
   49,    0,    0,    0, -146,   73,    0,    0,  110,   -4,
    0,   17,   69, -114,    0,    0,    0,  -33,   14,  -26,
 -110,  -41, -166,   -8,    0, -162,  -22,    0, -139, -186,
   61,    0,    0,   98,    0,   73,    0,   15,    0,  237,
  -23,   85,    0, -124,   67,    0,    0,    0,    0,  110,
    0,    0,    0,    0,    0,    0,   73,   73,   73,  -23,
  -23,  -23,  -23, -131, -153,    0,  107, -111,  -70,    0,
   39, -184,    0,   37,    0,  115,   55,    0,    0,    0,
  133,    0,    0,    0,    0,    0,    0,    0,    0,   73,
  135,    0,    0,    0,    0,    0,    0, -114,    0,  -89,
 -186,    0,  134,    0,   54,  -70,  -87,  142,  141,  166,
  144,  145,    0,   68,    0,    0,    0,  -91,    0,  153,
    0,  -73,  102,  156, -153,    0,    0,  160,    0,  166,
   77,  166,  166,    0,  -50,   88,    0,    0,  111,  -70,
 -153,    0,    0,    0,    0,    0,    0,   89,    0,  -70,
    0,    0,
};
final static short yyrindex[] = {                         0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,   11,
    0,    0,  215,   10,    0,    0,    0,    0,    0,    0,
    0,    0,    0,   12,    0,    0,    0,    0,    0,    1,
    0,    0,    0,    0,    0,    0,    0,    0,    0,   31,
    0,    6,   26,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,   78,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,  221,    0,   28,
    0,   11,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,  100,    0,   13,    0,    0,  -56,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
  101,  104,    0,    0,    0,    0,    0,    0,    0,   52,
    0,    0,    0,    0,  105,    0,    0,   97,    0,  112,
    0,  114,  119,    0,    0,    0,    0,    0,    0,  178,
  120,    0,    0,    0,    0,    0,    0,    0,    0,  179,
    0,    0,
};
final static short yygindex[] = {                         0,
   22,    0,    0,  386,   29,  350,    0,  168,    0,    0,
    0,  295,   50,  -68,    0,    0,    0,    0,  404,  118,
    0,   34,    0,  143,  169,  -27,  200,  -18,    0,    0,
  106, -118,   44,  229,  244,    0,  -90,
};
final static int YYTABLESIZE=530;
static short yytable[];
static { yytable();}
static void yytable(){
yytable = new short[]{                         35,
   48,   61,  102,   62,   12,   44,   35,   59,   51,    8,
   26,   22,   96,   61,  100,   48,   94,  157,   35,   59,
   60,   35,   62,   74,   67,   47,  132,    6,   17,   49,
   40,  165,   68,  103,   62,   47,   60,   56,   89,   17,
   88,   48,   48,   48,   48,   48,   44,   48,   44,   44,
   44,   52,  140,   97,   26,   22,   96,   69,   90,   63,
   48,  157,   48,   91,  172,   44,   47,   44,   47,   47,
   47,   40,    1,   73,   40,    2,   36,   26,   70,  166,
  181,   35,   72,  146,   50,   47,  132,   47,   75,   95,
   40,  115,   40,   35,   61,   52,  178,  104,   17,   35,
  152,  110,  132,   74,  117,   35,  106,  119,  130,  109,
   92,   35,    7,    8,    9,   93,  105,   35,   48,   48,
   48,   26,   48,   48,   48,   48,  128,  129,   44,  107,
   44,   77,   78,   79,    8,   26,   22,   96,  112,  114,
   74,  169,    1,   60,  118,    2,    1,  136,   47,    2,
   47,  180,    6,   40,   50,   40,    1,  138,   50,    2,
    3,    4,    5,  145,    6,    7,    8,    9,   10,   85,
    4,   86,  148,  149,   52,  151,   52,  155,  156,  153,
  154,  158,  159,  161,  160,  168,    1,  162,  163,    2,
    3,    4,  164,  167,    6,    7,    8,    9,   10,  171,
  173,  175,   26,  174,  139,  176,  177,  124,  125,  126,
  127,    4,  179,  182,    4,    1,   58,   12,    2,   74,
    2,  107,  108,   45,   60,   84,  108,   50,   85,  104,
   57,   46,   32,   33,   34,   58,   82,   31,   80,   32,
   33,   34,   30,   81,  102,   30,  147,   58,  120,   31,
  101,   32,   33,   34,   32,   33,   34,   48,  170,   76,
   48,   71,   44,    0,    0,   44,    0,    0,   11,   48,
   48,   48,   48,   48,   44,   44,   44,   44,   44,    7,
    8,    9,   47,    0,    0,   47,    0,   40,    0,    0,
   40,    0,    0,    0,   47,   47,   47,   47,   47,   40,
   40,   40,   40,   40,    0,   30,    0,    0,   52,    0,
    0,   52,   31,    0,   32,   33,   34,   30,    0,    0,
   52,    0,    0,   30,   31,    0,   32,   33,   34,   30,
   31,    0,   32,   33,   34,   30,   31,    0,   32,   33,
   34,   30,   31,   98,   32,   33,   34,    0,   31,   18,
   32,   33,   34,   74,   18,    0,   74,   74,   74,    0,
   18,   74,   74,   74,   74,   74,    0,    7,    8,    9,
    0,   74,    7,    8,    9,    0,    7,    8,    9,   81,
   82,   83,   84,    0,    0,   16,    0,    0,    0,  131,
   52,  137,    0,   18,    0,    0,   16,    0,    0,    0,
   18,   18,    1,    0,   39,    2,    3,    4,    5,    0,
    6,    7,    8,    9,   10,    0,    0,    0,    0,   18,
  116,    0,    1,    0,    0,    2,    3,    4,    0,   52,
    6,    7,    8,    9,   10,    0,   52,   52,    0,   80,
  139,    0,    0,    0,    0,    0,    0,   98,   18,  131,
    0,   18,    0,    0,    0,   16,    0,    0,    0,    0,
    0,    0,    0,  137,  111,  131,    0,    0,    0,  113,
    0,    0,    0,    0,    0,    0,    0,   18,  111,    0,
    0,    0,    0,    0,    0,   18,    0,   52,    0,   18,
  121,  122,  123,    1,    0,    0,    2,    3,    4,    5,
    0,    6,    7,    8,    9,   10,    0,   39,    0,   18,
    0,   18,   18,   52,    0,    0,    0,    0,    0,   18,
    0,    0,    0,  150,    0,    0,    0,    0,    0,   18,
};
}
static short yycheck[];
static { yycheck(); }
static void yycheck() {
yycheck = new short[] {                         45,
    0,   40,   44,   61,   61,    0,   45,   46,  123,    0,
    0,    0,    0,   40,  125,  269,   44,  136,   45,   46,
   59,   45,   61,   46,  125,    0,   95,    0,    0,  269,
    0,  123,   11,   52,   61,    2,   59,  281,   43,   11,
   45,   41,   42,   43,   44,   45,   41,   47,   43,   44,
   45,    0,  123,   40,   44,   44,   44,  125,   42,   10,
   60,  180,   62,   47,  155,   60,   41,   62,   43,   44,
   45,   41,  257,   24,   44,  260,   40,    0,   44,  148,
  171,   45,  269,  102,  269,   60,  155,   62,   40,  123,
   60,   70,   62,   45,   40,   44,  165,  264,   70,   45,
  128,   41,  171,   46,   71,   45,  269,   41,  262,   60,
   42,   45,  266,  267,  268,   47,  125,   45,   41,   42,
   43,   44,   45,  123,   47,  125,  258,  259,  123,  269,
  125,  278,  279,  280,  125,  125,  125,  125,   41,  125,
   44,   40,  257,   59,  269,  260,  257,   41,  123,  260,
  125,   41,  125,  123,  269,  125,  257,  269,  269,  260,
  261,  262,  263,  125,  265,  266,  267,  268,  269,   60,
  262,   62,   58,   41,  123,   41,  125,   44,  125,  269,
  131,  269,   41,  140,   44,  259,  257,   44,   44,  260,
  261,  262,  125,   41,  265,  266,  267,  268,  269,   44,
   41,  125,  125,  160,  275,  162,  163,   90,   91,   92,
   93,  262,  125,  125,    0,  257,  274,  274,  260,  123,
    0,   44,   44,  269,  125,  125,   59,  269,  125,  125,
  269,  277,  278,  279,  280,  274,  125,  276,  125,  278,
  279,  280,  269,  125,  125,  269,  104,  274,   80,  276,
   51,  278,  279,  280,  278,  279,  280,  257,  153,   31,
  260,   18,  257,   -1,   -1,  260,   -1,   -1,  123,  269,
  270,  271,  272,  273,  269,  270,  271,  272,  273,  266,
  267,  268,  257,   -1,   -1,  260,   -1,  257,   -1,   -1,
  260,   -1,   -1,   -1,  269,  270,  271,  272,  273,  269,
  270,  271,  272,  273,   -1,  269,   -1,   -1,  257,   -1,
   -1,  260,  276,   -1,  278,  279,  280,  269,   -1,   -1,
  269,   -1,   -1,  269,  276,   -1,  278,  279,  280,  269,
  276,   -1,  278,  279,  280,  269,  276,   -1,  278,  279,
  280,  269,  276,   49,  278,  279,  280,   -1,  276,    0,
  278,  279,  280,  257,    5,   -1,  260,  261,  262,   -1,
   11,  265,  266,  267,  268,  269,   -1,  266,  267,  268,
   -1,  275,  266,  267,  268,   -1,  266,  267,  268,  270,
  271,  272,  273,   -1,   -1,    0,   -1,   -1,   -1,   95,
    5,   97,   -1,   44,   -1,   -1,   11,   -1,   -1,   -1,
   51,   52,  257,   -1,    1,  260,  261,  262,  263,   -1,
  265,  266,  267,  268,  269,   -1,   -1,   -1,   -1,   70,
   71,   -1,  257,   -1,   -1,  260,  261,  262,   -1,   44,
  265,  266,  267,  268,  269,   -1,   51,   52,   -1,   36,
  275,   -1,   -1,   -1,   -1,   -1,   -1,  153,   99,  155,
   -1,  102,   -1,   -1,   -1,   70,   -1,   -1,   -1,   -1,
   -1,   -1,   -1,  169,   61,  171,   -1,   -1,   -1,   66,
   -1,   -1,   -1,   -1,   -1,   -1,   -1,  128,   75,   -1,
   -1,   -1,   -1,   -1,   -1,  136,   -1,  102,   -1,  140,
   87,   88,   89,  257,   -1,   -1,  260,  261,  262,  263,
   -1,  265,  266,  267,  268,  269,   -1,  104,   -1,  160,
   -1,  162,  163,  128,   -1,   -1,   -1,   -1,   -1,  170,
   -1,   -1,   -1,  120,   -1,   -1,   -1,   -1,   -1,  180,
};
}
final static short YYFINAL=12;
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
"Programa : '{' '}'",
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
"SentenciaDeclarativa : FuncionIMPL",
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
"BloqueIF : IF Condicion ListSentenciasIF ELSE ListSentenciasIF END_IF",
"BloqueIF : IF Condicion ListSentenciasIF END_IF",
"ListSentenciasIF : '{' SentenciasIF '}'",
"ListSentenciasIF : SentenciasIF '}'",
"ListSentenciasIF : '{' '}'",
"SentenciasIF : ListaSentencias",
"ListaSentencias : SentenciaEjecutable ','",
"ListaSentencias : SentenciaEjecutable ',' ListaSentencias",
"ListaSentencias : SentenciaEjecutable ListaSentencias",
"Comparador : '<'",
"Comparador : '>'",
"Comparador : MAYORIGUAL",
"Comparador : MENORIGUAL",
"Comparador : IGUAL",
"Comparador : DIST",
"ListFuncion : Funcion",
"ListFuncion : FuncionSinCuerpo",
"Funcion : VOID ID Parametro CuerpoFuncion",
"Funcion : VOID ID '(' ')' CuerpoFuncion",
"Parametro : '(' Tipo ID ')'",
"Parametro : '(' Tipo ID",
"Parametro : Tipo ID ')'",
"CuerpoFuncion : '{' ListSentenciasFuncion '}'",
"CuerpoFuncion : ListSentenciasFuncion '}'",
"ListSentenciasFuncion : SentenciaDeclarativa ',' ListSentenciasFuncion",
"ListSentenciasFuncion : SentenciaEjecutable ',' ListSentenciasFuncion",
"ListSentenciasFuncion : SentenciaEjecutable ','",
"ListSentenciasFuncion : SentenciaDeclarativa ','",
"ListSentenciasFuncion : RETURN ','",
"ListSentenciasFuncion : RETURN ',' ListSentenciasFuncion",
"ListSentenciasFuncion : SentenciaEjecutable",
"ListSentenciasFuncion : SentenciaDeclarativa",
"LlamadoFuncion : ID '(' ')'",
"LlamadoFuncion : ID LlamadoExpresion",
"SalidaMensaje : PRINT CADENA",
"SalidaMensaje : PRINT Factor",
"OperadorAsignacion : '='",
"OperadorAsignacion : ASIG",
"Asignacion : ID OperadorAsignacion Expresion",
"Asignacion : ReferenciaObjeto OperadorAsignacion ReferenciaObjeto",
"Asignacion : ReferenciaObjeto OperadorAsignacion Factor",
"SentenciaControl : DO ListSentenciasIF UNTIL Condicion",
"SentenciaControl : DO ListSentenciasIF UNTIL",
"LlamadoExpresion : '(' Expresion ')'",
"LlamadoExpresion : Expresion ')'",
"ConversionExplicita : TOD LlamadoExpresion",
"ConversionExplicita : TOD '(' ')'",
"ListHerencia : '{' SentenciaListHerencia '}'",
"SentenciaListHerencia : Tipo ListVariables ','",
"SentenciaListHerencia : Tipo ListVariables ',' SentenciaListHerencia",
"SentenciaListHerencia : ListFuncion ','",
"SentenciaListHerencia : ListFuncion ',' SentenciaListHerencia",
"HerenciaComposicion : CLASS ID ListHerencia",
"FuncionSinCuerpo : VOID ID Parametro",
"FuncionSinCuerpo : VOID ID '(' ')'",
"FuncionIMPL : IMPL FOR ID ':' '{' Funcion '}'",
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
//#line 551 "Parser.java"
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
{AnalizadorLexico.agregarErrorSintactico("Se espera '}' ");}
break;
case 3:
//#line 18 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se espera '{' ");}
break;
case 4:
//#line 19 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperan '{' '}' ");}
break;
case 5:
//#line 20 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Programa vacio ");}
break;
case 8:
//#line 25 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba una ',' al final de la linea ");}
break;
case 12:
//#line 33 "gramatica.y"
{AnalizadorLexico.agregarEstructura("Reconoce referencia objeto ");}
break;
case 13:
//#line 36 "gramatica.y"
{AnalizadorLexico.agregarEstructura("Reconoce llamado a funcion de clase ");}
break;
case 21:
//#line 48 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se espera el tipo de la variable ");}
break;
case 22:
//#line 49 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se espera identificador de la variable ");}
break;
case 32:
//#line 67 "gramatica.y"
{chequearEnteroPositivo(val_peek(0).sval);}
break;
case 33:
//#line 68 "gramatica.y"
{chequearEnteroCorto(val_peek(0).sval);}
break;
case 34:
//#line 69 "gramatica.y"
{AnalizadorLexico.agregarErrorLexico("Un entero corto no puede ser negativo ");}
break;
case 35:
//#line 70 "gramatica.y"
{chequearDouble(val_peek(0).sval);}
break;
case 36:
//#line 71 "gramatica.y"
{chequearEnteroNegativo(val_peek(0).sval);}
break;
case 37:
//#line 72 "gramatica.y"
{chequearDouble(val_peek(0).sval);}
break;
case 52:
//#line 98 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba una ')' ");}
break;
case 53:
//#line 99 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba una '(' ");}
break;
case 54:
//#line 102 "gramatica.y"
{AnalizadorLexico.agregarEstructura("Reconoce IF ELSE ");}
break;
case 55:
//#line 103 "gramatica.y"
{AnalizadorLexico.agregarEstructura("Reconoce IF ");}
break;
case 57:
//#line 107 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Falta un '{'"); }
break;
case 58:
//#line 108 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("No hay sentencias dentro de las llaves."); }
break;
case 62:
//#line 115 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Falta una ','"); }
break;
case 71:
//#line 130 "gramatica.y"
{AnalizadorLexico.agregarEstructura("Reconoce funcion VOID ");}
break;
case 72:
//#line 131 "gramatica.y"
{AnalizadorLexico.agregarEstructura("Reconoce funcion VOID ");}
break;
case 74:
//#line 136 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba un ')' ");}
break;
case 75:
//#line 137 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba un '(' ");}
break;
case 77:
//#line 141 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba un '{' ");}
break;
case 84:
//#line 150 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba una ',' al final de la linea ");}
break;
case 85:
//#line 151 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba una ',' al final de la linea ");}
break;
case 86:
//#line 156 "gramatica.y"
{AnalizadorLexico.agregarEstructura("Reconoce llamado funcion ");}
break;
case 87:
//#line 157 "gramatica.y"
{AnalizadorLexico.agregarEstructura("Reconoce llamado funcion ");}
break;
case 88:
//#line 159 "gramatica.y"
{AnalizadorLexico.agregarEstructura("Reconoce salida de mensaje por pantalla ");}
break;
case 89:
//#line 160 "gramatica.y"
{AnalizadorLexico.agregarEstructura("Reconoce salida de mensaje por pantalla ");}
break;
case 95:
//#line 172 "gramatica.y"
{AnalizadorLexico.agregarEstructura("Reconoce funcion DO UNTIL");}
break;
case 96:
//#line 173 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba una condicion ");}
break;
case 98:
//#line 179 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba un '(' ");}
break;
case 99:
//#line 182 "gramatica.y"
{AnalizadorLexico.agregarEstructura("Reconoce funcion TOD ");}
break;
case 100:
//#line 183 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba una Expresion ");}
break;
case 106:
//#line 196 "gramatica.y"
{AnalizadorLexico.agregarEstructura("Reconoce CLASE");}
break;
case 107:
//#line 200 "gramatica.y"
{AnalizadorLexico.agregarEstructura("Reconoce Funcion sin cuerpo");}
break;
case 108:
//#line 201 "gramatica.y"
{AnalizadorLexico.agregarEstructura("Reconoce Funcion sin cuerpo");}
break;
case 109:
//#line 204 "gramatica.y"
{AnalizadorLexico.agregarEstructura("Reconoce funcion IMPL");}
break;
case 110:
//#line 205 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba un '{' ");}
break;
//#line 876 "Parser.java"
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
