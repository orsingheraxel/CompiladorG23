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
    0,    0,    0,    0,    1,    1,    1,    2,    2,    2,
    6,    7,    4,    4,    4,    4,    4,    5,    5,    5,
    5,    5,    5,    5,   13,   13,   16,   12,   12,   12,
   18,   18,   18,   18,   18,   18,   19,   19,   19,   19,
   20,   20,   20,   20,   20,   20,   22,   22,   23,   24,
   24,   24,   10,   10,   26,   26,   26,   27,   28,   28,
   28,   25,   25,   25,   25,   25,   25,   29,   29,   14,
   14,   31,   31,   31,   32,   32,   33,   33,   33,   33,
   33,   33,   33,   33,    8,    8,   11,   11,   35,   35,
    9,    9,    9,    3,    3,   34,   34,   21,   21,   36,
   37,   37,   37,   37,   15,   30,   30,   17,   17,
};
final static short yylen[] = {                            2,
    3,    2,    2,    1,    2,    3,    1,    1,    1,    1,
    3,    3,    1,    1,    1,    1,    1,    2,    1,    1,
    1,    1,    1,    1,    1,    3,    2,    1,    1,    1,
    1,    1,    2,    1,    2,    2,    3,    3,    1,    1,
    3,    3,    1,    3,    3,    1,    1,    1,    1,    5,
    4,    4,    6,    4,    3,    2,    2,    1,    2,    3,
    2,    1,    1,    1,    1,    1,    1,    1,    1,    4,
    5,    4,    3,    3,    3,    2,    3,    3,    2,    2,
    2,    3,    1,    1,    3,    2,    2,    2,    1,    1,
    3,    3,    3,    4,    3,    3,    2,    2,    3,    3,
    3,    4,    2,    3,    3,    3,    4,    7,    6,
};
final static short yydefred[] = {                         0,
    0,    0,    0,    0,    0,    0,   29,   28,   30,    0,
    0,    0,    0,    0,    8,    9,   10,    0,   17,   14,
   13,   15,   16,    0,   20,   19,   22,   23,   24,    0,
    0,   31,   32,   34,    0,    0,   49,   48,    0,    0,
   40,    0,    0,    0,   47,   87,   88,    0,    0,    0,
    0,    0,    0,    0,   58,    0,    0,   90,    0,    0,
    0,   89,   27,    0,   86,    0,    0,    3,    0,    0,
    0,   18,    0,    0,   98,   35,   33,   36,    0,   66,
   67,   65,   64,   62,   63,    0,    0,    0,    0,    0,
    0,    0,    0,    0,  105,    0,    0,    0,   57,    0,
    0,   61,    0,   56,    0,    0,   12,   26,   85,    0,
   97,   91,    1,    6,   92,   93,   11,   99,    0,    0,
   38,   37,   41,   42,   44,   45,    0,   54,    0,    0,
   68,    0,   69,    0,    0,    0,    0,    0,    0,    0,
    0,   70,    0,   55,   60,   94,    0,   96,    0,   52,
    0,    0,    0,    0,  100,   71,    0,   74,    0,    0,
    0,    0,   76,    0,    0,   50,   53,    0,    0,    0,
  104,   72,   82,   75,   78,   77,    0,  109,    0,  102,
  108,
};
final static short yydgoto[] = {                         12,
   13,   14,   15,  140,  141,   37,   19,   20,   21,   22,
   23,   24,   25,   26,   27,   28,   29,   38,   64,   40,
   41,   42,   43,   44,   86,   53,   54,   55,  132,  133,
   98,  142,  143,   65,   66,   95,  134,
};
final static short yysindex[] = {                       146,
   37,  -45, -245, -233, -114, -216,    0,    0,    0,  -38,
  233,    0,  -52,   32,    0,    0,    0,  -57,    0,    0,
    0,    0,    0, -186,    0,    0,    0,    0,    0,   38,
   49,    0,    0,    0, -146,   73,    0,    0,  110,   19,
    0,   -9,   -8, -114,    0,    0,    0,  -16,   14,  -26,
 -110,  -41, -155,  -11,    0, -142,   46,    0, -141, -186,
   61,    0,    0,   89,    0,   73,   20,    0,  233,  -23,
   80,    0, -109,   67,    0,    0,    0,    0,  110,    0,
    0,    0,    0,    0,    0,   73,   73,   73,  -23,  -23,
  -23,  -23, -200, -151,    0,  107, -108,  -70,    0,   40,
 -156,    0,   37,    0,   82,   55,    0,    0,    0,  121,
    0,    0,    0,    0,    0,    0,    0,    0,   73,  127,
    0,    0,    0,    0,    0,    0, -114,    0,  -96, -186,
    0,  130,    0,   51,  -70,  -91,  138,  141,  166,  142,
  144,    0,   64,    0,    0,    0, -105,    0,  152,    0,
  -88,  102,  150, -151,    0,    0,  159,    0,  166,   76,
  166,  166,    0,  -58,   81,    0,    0,  111,  -70, -151,
    0,    0,    0,    0,    0,    0,   83,    0,  -70,    0,
    0,
};
final static short yyrindex[] = {                         0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,   11,
    0,    0,  207,   10,    0,    0,    0,    0,    0,    0,
    0,    0,    0,   12,    0,    0,    0,    0,    0,    1,
    0,    0,    0,    0,    0,    0,    0,    0,    0,   31,
    0,    6,   26,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,   78,    0,    0,    0,
    0,    0,    0,    0,    0,    0,  211,    0,   28,    0,
   11,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
   87,    0,   13,    0,    0,  -56,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,   88,
   90,    0,    0,    0,    0,    0,    0,    0,   52,    0,
    0,    0,    0,   96,    0,    0,   97,    0,   98,    0,
  100,  101,    0,    0,    0,    0,    0,    0,  170,  104,
    0,    0,    0,    0,    0,    0,    0,    0,  178,    0,
    0,
};
final static short yygindex[] = {                         0,
   21,    0,    0,  158,   29,  350,    0,  171,    0,    0,
    0,  295,   50,  -67,    0,    0,    0,    0,  394,   92,
    0,   15,    0,  134,  160,  -28,  193,  -22,    0,    0,
   93,  -98,    5,  216,  231,    0, -129,
};
final static int YYTABLESIZE=529;
static short yytable[];
static { yytable();}
static void yytable(){
yytable = new short[]{                         35,
   47,   61,  101,   62,   11,   43,   35,   59,   51,    7,
   25,   21,   95,   61,   99,   93,   47,  164,   35,   59,
   60,   35,   62,   48,  171,   46,  131,    5,   17,  102,
   39,   67,   89,   91,   62,   49,  156,   90,   92,   17,
  180,   47,   47,   47,   47,   47,   43,   47,   43,   43,
   43,   51,  139,   96,   25,   21,   95,  127,  128,   63,
   47,   88,   47,   87,   56,   43,   46,   43,   46,   46,
   46,   39,   68,   72,   39,   69,   36,   25,  145,  165,
  156,   35,   71,   73,  116,   46,  131,   46,   74,  114,
   39,   73,   39,   35,   61,   51,  177,   17,  151,   35,
    1,  109,  131,    2,   60,   35,   94,  118,  103,  108,
  129,   35,   50,  104,    7,    8,    9,   35,   47,   47,
   47,   25,   47,   47,   47,   47,  105,  106,   43,  111,
   43,   76,   77,   78,    7,   25,   21,   95,   60,  147,
   73,  168,    1,  160,  113,    2,    1,  135,   46,    2,
   46,  179,    5,   39,   50,   39,    4,   16,   50,  117,
  137,  148,   52,  173,  144,  175,  176,  150,   16,   84,
  167,   85,  152,  154,   51,  155,   51,  157,  158,  153,
  123,  124,  125,  126,  159,  161,    1,  162,  163,    2,
    3,    4,  166,  170,    6,    7,    8,    9,   10,  172,
  174,   52,   25,    4,  138,  178,    4,  181,   52,   52,
    2,   59,   83,  106,   84,    1,   58,   11,    2,   73,
  103,  107,   81,   45,   79,   80,   16,   50,  101,  107,
   57,   46,   32,   33,   34,   58,  146,   31,  119,   32,
   33,   34,   30,  100,  169,   30,   75,   58,   70,   31,
    0,   32,   33,   34,   32,   33,   34,   47,   52,    0,
   47,    0,   43,    0,    0,   43,    0,    0,   11,   47,
   47,   47,   47,   47,   43,   43,   43,   43,   43,    7,
    8,    9,   46,    0,   52,   46,    0,   39,    0,    0,
   39,    0,    0,    0,   46,   46,   46,   46,   46,   39,
   39,   39,   39,   39,    0,   30,    0,    0,   51,    0,
    0,   51,   31,    0,   32,   33,   34,   30,    0,    0,
   51,    0,    0,   30,   31,    0,   32,   33,   34,   30,
   31,    0,   32,   33,   34,   30,   31,    0,   32,   33,
   34,   30,   31,   97,   32,   33,   34,    0,   31,   18,
   32,   33,   34,   73,   18,    0,   73,   73,   73,    0,
   18,   73,   73,   73,   73,   73,    0,    7,    8,    9,
    0,   73,    7,    8,    9,    0,    7,    8,    9,   80,
   81,   82,   83,    0,    0,    0,    0,    0,  130,    0,
  136,    0,    0,   18,   39,    0,    0,    0,    0,    0,
   18,   18,    1,    0,    0,    2,    3,    4,    5,    0,
    6,    7,    8,    9,   10,    0,    0,    0,   18,  115,
    0,    0,    1,    0,    0,    2,    3,    4,    0,   79,
    6,    7,    8,    9,   10,    0,    0,    0,    0,    0,
  138,    0,    0,    0,    0,    0,   97,   18,  130,    0,
   18,    0,    0,    0,  110,    0,    0,    0,    0,  112,
    0,    0,  136,    0,  130,    0,    0,  110,    0,    0,
    0,    0,    0,    0,    0,    0,   18,    0,    0,  120,
  121,  122,    0,    0,   18,    0,    0,    0,   18,    1,
    0,    0,    2,    3,    4,    5,   39,    6,    7,    8,
    9,   10,    0,    0,    0,    0,    0,    0,   18,    0,
   18,   18,  149,    0,    0,    0,    0,    0,   18,    0,
    0,    0,    0,    0,    0,    0,    0,    0,   18,
};
}
static short yycheck[];
static { yycheck(); }
static void yycheck() {
yycheck = new short[] {                         45,
    0,   40,   44,   61,   61,    0,   45,   46,  123,    0,
    0,    0,    0,   40,  125,   44,    2,  123,   45,   46,
   59,   45,   61,  269,  154,    0,   94,    0,    0,   52,
    0,   11,   42,   42,   61,  269,  135,   47,   47,   11,
  170,   41,   42,   43,   44,   45,   41,   47,   43,   44,
   45,    0,  123,   40,   44,   44,   44,  258,  259,   10,
   60,   43,   62,   45,  281,   60,   41,   62,   43,   44,
   45,   41,  125,   24,   44,   44,   40,    0,  101,  147,
  179,   45,  269,   46,   70,   60,  154,   62,   40,   69,
   60,   46,   62,   45,   40,   44,  164,   69,  127,   45,
  257,   41,  170,  260,   59,   45,  123,   41,  264,   60,
  262,   45,  269,  125,  266,  267,  268,   45,   41,   42,
   43,   44,   45,  123,   47,  125,  269,  269,  123,   41,
  125,  278,  279,  280,  125,  125,  125,  125,   59,   58,
   44,   40,  257,  139,  125,  260,  257,   41,  123,  260,
  125,   41,  125,  123,  269,  125,  262,    0,  269,  269,
  269,   41,    5,  159,  125,  161,  162,   41,   11,   60,
  259,   62,  269,   44,  123,  125,  125,  269,   41,  130,
   89,   90,   91,   92,   44,   44,  257,   44,  125,  260,
  261,  262,   41,   44,  265,  266,  267,  268,  269,   41,
  125,   44,  125,  262,  275,  125,    0,  125,   51,   52,
    0,  125,  125,   44,  125,  257,  274,  274,  260,  123,
  125,   44,  125,  269,  125,  125,   69,  269,  125,   59,
  269,  277,  278,  279,  280,  274,  103,  276,   79,  278,
  279,  280,  269,   51,  152,  269,   31,  274,   18,  276,
   -1,  278,  279,  280,  278,  279,  280,  257,  101,   -1,
  260,   -1,  257,   -1,   -1,  260,   -1,   -1,  123,  269,
  270,  271,  272,  273,  269,  270,  271,  272,  273,  266,
  267,  268,  257,   -1,  127,  260,   -1,  257,   -1,   -1,
  260,   -1,   -1,   -1,  269,  270,  271,  272,  273,  269,
  270,  271,  272,  273,   -1,  269,   -1,   -1,  257,   -1,
   -1,  260,  276,   -1,  278,  279,  280,  269,   -1,   -1,
  269,   -1,   -1,  269,  276,   -1,  278,  279,  280,  269,
  276,   -1,  278,  279,  280,  269,  276,   -1,  278,  279,
  280,  269,  276,   49,  278,  279,  280,   -1,  276,    0,
  278,  279,  280,  257,    5,   -1,  260,  261,  262,   -1,
   11,  265,  266,  267,  268,  269,   -1,  266,  267,  268,
   -1,  275,  266,  267,  268,   -1,  266,  267,  268,  270,
  271,  272,  273,   -1,   -1,   -1,   -1,   -1,   94,   -1,
   96,   -1,   -1,   44,    1,   -1,   -1,   -1,   -1,   -1,
   51,   52,  257,   -1,   -1,  260,  261,  262,  263,   -1,
  265,  266,  267,  268,  269,   -1,   -1,   -1,   69,   70,
   -1,   -1,  257,   -1,   -1,  260,  261,  262,   -1,   36,
  265,  266,  267,  268,  269,   -1,   -1,   -1,   -1,   -1,
  275,   -1,   -1,   -1,   -1,   -1,  152,   98,  154,   -1,
  101,   -1,   -1,   -1,   61,   -1,   -1,   -1,   -1,   66,
   -1,   -1,  168,   -1,  170,   -1,   -1,   74,   -1,   -1,
   -1,   -1,   -1,   -1,   -1,   -1,  127,   -1,   -1,   86,
   87,   88,   -1,   -1,  135,   -1,   -1,   -1,  139,  257,
   -1,   -1,  260,  261,  262,  263,  103,  265,  266,  267,
  268,  269,   -1,   -1,   -1,   -1,   -1,   -1,  159,   -1,
  161,  162,  119,   -1,   -1,   -1,   -1,   -1,  169,   -1,
   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,  179,
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

//#line 214 "gramatica.y"

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
//#line 550 "Parser.java"
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
case 7:
//#line 24 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba una ',' al final de la linea ");}
break;
case 20:
//#line 47 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se espera el tipo de la variable ");}
break;
case 21:
//#line 48 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se espera identificador de la variable ");}
break;
case 31:
//#line 66 "gramatica.y"
{chequearEnteroPositivo(val_peek(0).sval);}
break;
case 32:
//#line 67 "gramatica.y"
{chequearEnteroCorto(val_peek(0).sval);}
break;
case 33:
//#line 68 "gramatica.y"
{AnalizadorLexico.agregarErrorLexico("Un entero corto no puede ser negativo ");}
break;
case 34:
//#line 69 "gramatica.y"
{chequearDouble(val_peek(0).sval);}
break;
case 35:
//#line 70 "gramatica.y"
{chequearEnteroNegativo(val_peek(0).sval);}
break;
case 36:
//#line 71 "gramatica.y"
{chequearDouble(val_peek(0).sval);}
break;
case 51:
//#line 97 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba una ')' ");}
break;
case 52:
//#line 98 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba una '(' ");}
break;
case 53:
//#line 101 "gramatica.y"
{AnalizadorLexico.agregarEstructura("Reconoce IF ELSE ");}
break;
case 54:
//#line 102 "gramatica.y"
{AnalizadorLexico.agregarEstructura("Reconoce IF ");}
break;
case 56:
//#line 106 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Falta un '{'"); }
break;
case 57:
//#line 107 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("No hay sentencias dentro de las llaves."); }
break;
case 61:
//#line 114 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Falta una ','"); }
break;
case 70:
//#line 129 "gramatica.y"
{AnalizadorLexico.agregarEstructura("Reconoce funcion VOID ");}
break;
case 71:
//#line 130 "gramatica.y"
{AnalizadorLexico.agregarEstructura("Reconoce funcion VOID ");}
break;
case 73:
//#line 135 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba un ')' ");}
break;
case 74:
//#line 136 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba un '(' ");}
break;
case 76:
//#line 140 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba un '{' ");}
break;
case 83:
//#line 149 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba una ',' al final de la linea ");}
break;
case 84:
//#line 150 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba una ',' al final de la linea ");}
break;
case 85:
//#line 155 "gramatica.y"
{AnalizadorLexico.agregarEstructura("Reconoce llamado funcion ");}
break;
case 86:
//#line 156 "gramatica.y"
{AnalizadorLexico.agregarEstructura("Reconoce llamado funcion ");}
break;
case 87:
//#line 158 "gramatica.y"
{AnalizadorLexico.agregarEstructura("Reconoce salida de mensaje por pantalla ");}
break;
case 88:
//#line 159 "gramatica.y"
{AnalizadorLexico.agregarEstructura("Reconoce salida de mensaje por pantalla ");}
break;
case 94:
//#line 171 "gramatica.y"
{AnalizadorLexico.agregarEstructura("Reconoce funcion DO UNTIL");}
break;
case 95:
//#line 172 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba una condicion ");}
break;
case 97:
//#line 178 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba un '(' ");}
break;
case 98:
//#line 181 "gramatica.y"
{AnalizadorLexico.agregarEstructura("Reconoce funcion TOD ");}
break;
case 99:
//#line 182 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba una Expresion ");}
break;
case 105:
//#line 195 "gramatica.y"
{AnalizadorLexico.agregarEstructura("Reconoce CLASE");}
break;
case 106:
//#line 199 "gramatica.y"
{AnalizadorLexico.agregarEstructura("Reconoce Funcion sin cuerpo");}
break;
case 107:
//#line 200 "gramatica.y"
{AnalizadorLexico.agregarEstructura("Reconoce Funcion sin cuerpo");}
break;
case 108:
//#line 203 "gramatica.y"
{AnalizadorLexico.agregarEstructura("Reconoce funcion IMPL");}
break;
case 109:
//#line 204 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba un '{' ");}
break;
//#line 863 "Parser.java"
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
