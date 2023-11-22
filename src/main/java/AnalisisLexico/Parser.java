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
import AnalisisLexico.ParserVal;
import GeneracionCodigoIntermedio.*;
import AnalisisLexico.AccionesSemanticas.AccionSemantica;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
//#line 26 "Parser.java"




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
    0,    0,    1,    1,    2,    2,    2,    2,    6,    7,
    4,    4,    4,    4,    4,   12,   12,    5,    5,    5,
    5,    5,    5,    5,   14,   14,   17,   19,   19,   13,
   13,   13,   20,   20,   20,   20,   20,   20,   21,   21,
   21,   21,   22,   22,   22,   22,   22,   22,   24,   24,
   25,   26,   26,   26,   10,   10,   10,   10,   10,   10,
   10,   10,   10,   10,   10,   10,   10,   10,   10,   28,
   28,   28,   28,   28,   28,   28,   28,   29,   30,   30,
   30,   30,   27,   27,   27,   27,   27,   27,   15,   15,
   31,   31,   33,   34,   34,   34,   34,   34,   34,   35,
   35,   35,   35,   35,   35,   35,   35,   35,    8,    8,
    8,    8,   11,   11,   11,   37,   37,    9,    9,    9,
    9,    9,    9,    3,    3,   36,   36,   36,   38,   38,
   38,   23,   23,   39,   40,   16,   32,   18,   18,   18,
};
final static short yylen[] = {                            2,
    3,    3,    3,    2,    1,    1,    1,    2,    3,    3,
    1,    1,    1,    1,    1,    3,    2,    2,    1,    2,
    2,    1,    1,    1,    1,    3,    2,    1,    3,    1,
    1,    1,    1,    1,    2,    1,    2,    2,    3,    3,
    1,    1,    3,    3,    1,    3,    3,    1,    1,    1,
    1,    5,    5,    5,    6,    4,    6,    4,    7,    8,
    7,    7,    7,    7,    7,    7,    7,    7,    5,    3,
    2,    2,    5,    5,    3,    3,    2,    1,    1,    2,
    2,    3,    1,    1,    1,    1,    1,    1,    1,    1,
    5,    6,    2,    4,    4,    4,    2,    2,    2,    3,
    3,    2,    2,    2,    3,    2,    2,    2,    3,    3,
    3,    2,    2,    2,    2,    1,    1,    3,    3,    3,
    3,    3,    2,    4,    4,    3,    3,    3,    3,    3,
    3,    2,    3,    3,    2,    2,    2,    7,    7,    7,
};
final static short yydefred[] = {                         0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
   31,   30,   32,    0,  117,    0,   33,   34,   36,    0,
  116,    0,    0,    5,    6,    7,    0,   15,   12,   11,
   13,   14,    0,   19,   22,   23,   24,   50,    0,   89,
   90,    0,    0,    0,    0,   25,    0,    0,    0,    0,
  115,   49,  113,  114,  135,    0,   93,    0,    0,    0,
    0,    0,    0,   28,    0,    0,    0,  112,    8,   37,
   35,   38,    2,    0,    4,    0,   21,    0,    0,    0,
    0,    0,  123,    0,  136,    1,    0,    0,    0,   51,
    0,    0,   42,   45,   48,    0,    0,    0,    0,    0,
   79,    0,    0,    0,   72,   71,   77,    0,    0,    0,
  110,    0,    0,   10,  111,  109,    0,    0,    3,  121,
  119,  120,  122,    0,   99,    0,   98,   97,    0,    0,
    0,    0,    0,   26,    0,    0,    0,  132,   87,   88,
   86,   85,    0,    0,   83,   84,    0,    0,    0,    0,
    0,    0,   58,    0,   56,    0,   81,   80,   75,    0,
   76,    0,   70,    0,  124,    0,  127,  128,  126,   29,
    0,    0,    0,    0,    0,    0,   17,  134,    0,    9,
    0,  133,    0,    0,    0,    0,   43,   46,   44,   47,
    0,    0,   69,    0,    0,    0,    0,    0,   82,    0,
    0,    0,    0,   96,   95,   94,  108,  104,  106,  102,
  107,  103,    0,   91,    0,    0,   16,  130,  131,  129,
   54,   53,   52,    0,    0,    0,    0,    0,    0,    0,
   57,   55,   92,   74,   73,    0,    0,    0,  105,  101,
  100,   67,   66,   65,   63,    0,   62,   59,   68,   64,
   61,  139,    0,  140,  138,   60,
};
final static short yydgoto[] = {                          3,
   22,   23,   24,   25,   26,   27,   28,   29,   30,   31,
   32,  133,   33,   47,   34,   35,   36,   37,   67,   38,
   91,   92,   93,   39,   95,   50,  147,   61,  103,  104,
   40,   41,   42,   82,  176,   68,   43,  138,   85,   44,
};
final static short yysindex[] = {                       -97,
   47,   47,    0, -249,  -37,  191, -239, -219, -105, -242,
    0,    0,    0,  -39,    0, -212,    0,    0,    0, -166,
    0,   -3,   15,    0,    0,    0,  -49,    0,    0,    0,
    0,    0, -216,    0,    0,    0,    0,    0,  -49,    0,
    0,  -30,  159,  -13,   22,    0,   14,  176,  176,  147,
    0,    0,    0,    0,    0,  -30,    0,  184,   12,  155,
 -180, -154,  -36,    0, -132,  -41,   79,    0,    0,    0,
    0,    0,    0,   96,    0,  210,    0,   14,  130,   52,
  164,   20,    0, -190,    0,    0, -125,  100,  -29,    0,
  463,   49,    0,    0,    0,  463,  -38,   13, -211,   26,
    0,   17,   23,  250,    0,    0,    0, -111,  -25,   92,
    0,   56,  -24,    0,    0,    0,  -22, -117,    0,    0,
    0,    0,    0,   73,    0, -115,    0,    0, -114,  122,
 -112,  117,  -55,    0, -107,  176,  -28,    0,    0,    0,
    0,    0,  204,  204,    0,    0,  176,  204,  204,  176,
 -194, -129,    0,  147,    0,  122,    0,    0,    0,  121,
    0,   18,    0,  176,    0,  -96,    0,    0,    0,    0,
  132,    5,   25,   30,   36,   72,    0,    0,  127,    0,
   59,    0,  -10,   49,   49,   66,    0,    0,    0,    0,
   -9, -105,    0,  147,  147,   37, -196,   97,    0,   51,
   53,  -88,  -88,    0,    0,    0,    0,    0,    0,    0,
    0,    0,  133,    0,  135,  136,    0,    0,    0,    0,
    0,    0,    0,  -78,  -77,  -75,   38, -171,  -74, -153,
    0,    0,    0,    0,    0,   63,  -30, -100,    0,    0,
    0,    0,    0,    0,    0,  -73,    0,    0,    0,    0,
    0,    0,   20,    0,    0,    0,
};
final static short yyrindex[] = {                         0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,  -18,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,   42,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,   43,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,   50,    0,    0,
    0,   61,    0,    0,    0,    0,    0,  433,    0,    0,
    0,  405,    0,    0,    0,    0,  -18,    0,    0,    0,
    0,    0,    0, -103,    0,    0,    0,    0,    0,    0,
    0,    0,   -7,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,   86,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,  145,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,  453,  458,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,
};
final static short yygindex[] = {                         0,
  188,    6,    0,  496,  -35,  468,    0,  126,    0,    0,
    0,    0,    9,  160,    0,    0,    0,    0,    0,    0,
  -11,  -20,    0,  494,  -17,   85,   99,  -26,  138,    0,
  -83,    0,  -68,  -50,   40,    0,    2,    0,    0,    0,
};
final static int YYTABLESIZE=736;
static short yytable[];
static { yytable();}
static void yytable(){
yytable = new short[]{                        116,
   66,   66,   49,   20,  111,  100,   65,   65,   20,   81,
  137,   21,  182,  163,   49,   66,   20,   60,  169,   46,
  144,   78,  143,   99,  255,    2,  203,   74,   76,   55,
  220,  223,  144,  144,  143,  143,   56,   96,   62,   77,
   79,   20,   49,   69,  153,  206,  154,  155,  132,   57,
   74,  112,   46,    9,  117,  106,  152,   21,   75,  231,
  158,  201,  232,  192,  193,    4,   20,  124,  208,  178,
    7,    8,   87,  210,   10,   11,   12,   13,  131,  212,
  230,  246,   21,  109,  247,   20,   27,  248,  126,  129,
  148,   20,  125,   18,  175,  149,  167,  179,  144,  218,
  143,  144,  250,  143,  137,  251,  221,   21,  144,   84,
  143,   70,   71,   72,  110,  144,   20,  143,  236,  238,
  175,   73,  184,  185,  181,  183,  194,  197,  195,  118,
  188,  190,   21,  237,  237,  186,  113,  118,  191,  119,
  216,   20,  130,  134,  161,  135,   86,  159,  156,  166,
   58,  170,   78,  171,  172,  254,   64,   21,    1,  202,
  177,  180,  216,  162,  199,  224,   20,  226,  228,   59,
  217,   78,  204,    8,   20,  234,  239,  235,  240,  241,
  242,  243,   21,  244,  249,  256,  253,  252,  125,   45,
  114,   20,   78,  165,  150,  198,  214,  108,    0,   20,
    4,    0,    0,   20,  128,    7,    8,   21,    0,   10,
   11,   12,   13,  131,  115,   21,   63,   63,   48,    0,
   20,  233,    0,    0,   15,   80,  136,   88,   20,   64,
  164,   63,   88,  168,   89,   20,   17,   18,   19,   89,
   88,   17,   18,   19,   21,  219,  222,   89,   20,   17,
   18,   19,    4,    5,   20,   49,    6,    7,    8,    9,
  205,   10,   11,   12,   13,   14,    9,  105,  151,   60,
   15,   16,  157,  200,   17,   18,   19,    4,    5,  107,
  207,    6,    7,    8,    9,  209,   10,   11,   12,   13,
   14,  211,  229,  245,   20,   15,   16,   20,   27,   17,
   18,   19,    4,    5,    0,   18,    6,    7,    8,    9,
   21,   10,   11,   12,   13,   14,  137,   11,   12,   13,
   15,   16,    0,    0,   17,   18,   19,    4,    5,    0,
    0,    6,    7,    8,    0,    0,   10,   11,   12,   13,
   14,  118,    0,    0,  118,   15,  213,    0,    0,   17,
   18,   19,    4,    5,    0,    0,    6,    7,    8,    0,
    0,   10,   11,   12,   13,   14,    0,    0,    0,    0,
   15,  213,    0,    0,   17,   18,   19,    4,    5,    0,
    0,    6,    7,    8,    0,  123,   10,   11,   12,   13,
   14,    0,    0,    0,    0,   15,  173,    0,   88,   17,
   18,   19,   58,    5,    0,   89,    6,   17,   18,   19,
  101,    5,    0,    0,    6,   97,    0,    0,    0,  127,
   15,   59,    0,   97,   17,   18,   19,   52,   15,   11,
   12,   13,   17,   18,   19,    0,   17,   18,   19,  101,
    5,    0,    0,    6,   88,   41,   51,   41,   41,   41,
    0,   89,   97,   17,   18,   19,    0,   15,    0,   52,
    0,   17,   18,   19,   41,  120,   41,   53,   17,   18,
   19,    0,   88,   49,   49,   49,   49,   49,   88,   49,
    0,   17,   18,   19,    0,    0,    0,   17,   18,   19,
    0,    0,   49,   40,   49,   40,   40,   40,   39,   54,
   39,   39,   39,    0,    0,  144,    5,  143,    0,    6,
    0,    0,   40,    0,   40,   90,   90,   39,   97,   39,
    0,    0,  145,   15,  146,    0,    0,   17,   18,   19,
   90,    0,    0,   90,    0,    0,   83,    0,    0,    0,
    0,   94,   94,  121,    0,   98,   90,    0,    0,    0,
    0,    0,    0,  102,    0,  102,   94,    0,    0,   94,
    0,    0,    0,    0,    0,    0,    0,    0,    0,  122,
    0,    0,   94,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,  160,
    0,    0,    0,   90,   90,    0,    0,    0,    0,    0,
   90,   90,    0,    0,   90,   90,   90,   90,    0,    0,
    0,    0,    0,    0,    0,  174,    0,    0,    0,   94,
   94,   90,    0,    0,    0,    0,   94,   94,    0,    0,
   94,  187,  189,   94,    0,    0,    0,    0,    0,  196,
    0,  174,    0,    0,    0,    0,    0,   94,    0,    0,
   41,    0,    0,   41,    0,    0,    0,    0,    0,    0,
    0,  215,    0,    0,   41,   41,   41,   41,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,   49,  225,
  227,   49,    0,  215,    0,    0,    0,    0,    0,    0,
    0,    0,   49,   49,   49,   49,    0,    0,   40,    0,
    0,   40,    0,   39,    0,    0,   39,    0,    0,    0,
    0,    0,   40,   40,   40,   40,    0,   39,   39,   39,
   39,    0,  139,  140,  141,  142,
};
}
static short yycheck[];
static { yycheck(); }
static void yycheck() {
yycheck = new short[] {                         41,
   40,   40,   40,   45,   41,   56,   46,   46,   45,   40,
   40,   61,   41,  125,   40,   40,   45,  123,   41,  269,
   43,  125,   45,   50,  125,  123,  123,   22,   27,  269,
   41,   41,   43,   43,   45,   45,  256,   49,  281,  256,
   39,   45,   61,  256,  256,   41,  258,  259,   84,  269,
   45,   63,  269,   61,   66,   44,   44,   61,   44,  256,
   44,   44,  259,  258,  259,  256,   45,   79,   44,  125,
  261,  262,   59,   44,  265,  266,  267,  268,  269,   44,
   44,   44,   61,  264,  256,   44,   44,  259,   80,   81,
   42,   45,   41,   44,  130,   47,   41,  133,   43,   41,
   45,   43,  256,   45,   44,  259,   41,   61,   43,  123,
   45,  278,  279,  280,  269,   43,   45,   45,  202,  203,
  156,  125,  143,  144,  136,  137,  256,  154,  258,   44,
  148,  149,   61,  202,  203,  147,  269,   59,  150,   44,
  176,   45,  123,  269,  256,   46,  125,  125,  123,   58,
  256,  269,  256,  269,  269,  256,  269,   61,  256,  256,
   44,  269,  198,  275,   44,  192,   45,  194,  195,  275,
   44,  275,   41,  262,   45,  125,   44,  125,   44,   44,
  259,  259,   61,  259,  259,  259,  237,  125,   44,    2,
   65,   45,   33,  109,   96,  156,  125,   60,   -1,   45,
  256,   -1,   -1,   45,   41,  261,  262,   61,   -1,  265,
  266,  267,  268,  269,  256,   61,  256,  256,  256,   -1,
   45,  125,   -1,   -1,  274,  256,  256,  269,   45,  269,
  256,  256,  269,  256,  276,   45,  278,  279,  280,  276,
  269,  278,  279,  280,   61,  256,  256,  276,   45,  278,
  279,  280,  256,  257,   45,  274,  260,  261,  262,  263,
  256,  265,  266,  267,  268,  269,  274,  256,  256,  123,
  274,  275,  256,  256,  278,  279,  280,  256,  257,  125,
  256,  260,  261,  262,  263,  256,  265,  266,  267,  268,
  269,  256,  256,  256,   45,  274,  275,  256,  256,  278,
  279,  280,  256,  257,   -1,  256,  260,  261,  262,  263,
   61,  265,  266,  267,  268,  269,  256,  266,  267,  268,
  274,  275,   -1,   -1,  278,  279,  280,  256,  257,   -1,
   -1,  260,  261,  262,   -1,   -1,  265,  266,  267,  268,
  269,  256,   -1,   -1,  259,  274,  275,   -1,   -1,  278,
  279,  280,  256,  257,   -1,   -1,  260,  261,  262,   -1,
   -1,  265,  266,  267,  268,  269,   -1,   -1,   -1,   -1,
  274,  275,   -1,   -1,  278,  279,  280,  256,  257,   -1,
   -1,  260,  261,  262,   -1,  256,  265,  266,  267,  268,
  269,   -1,   -1,   -1,   -1,  274,  275,   -1,  269,  278,
  279,  280,  256,  257,   -1,  276,  260,  278,  279,  280,
  256,  257,   -1,   -1,  260,  269,   -1,   -1,   -1,  256,
  274,  275,   -1,  269,  278,  279,  280,  269,  274,  266,
  267,  268,  278,  279,  280,   -1,  278,  279,  280,  256,
  257,   -1,   -1,  260,  269,   41,  256,   43,   44,   45,
   -1,  276,  269,  278,  279,  280,   -1,  274,   -1,  269,
   -1,  278,  279,  280,   60,  256,   62,  277,  278,  279,
  280,   -1,  269,   41,   42,   43,   44,   45,  269,   47,
   -1,  278,  279,  280,   -1,   -1,   -1,  278,  279,  280,
   -1,   -1,   60,   41,   62,   43,   44,   45,   41,    6,
   43,   44,   45,   -1,   -1,   43,  257,   45,   -1,  260,
   -1,   -1,   60,   -1,   62,   48,   49,   60,  269,   62,
   -1,   -1,   60,  274,   62,   -1,   -1,  278,  279,  280,
   63,   -1,   -1,   66,   -1,   -1,   43,   -1,   -1,   -1,
   -1,   48,   49,   76,   -1,   50,   79,   -1,   -1,   -1,
   -1,   -1,   -1,   58,   -1,   60,   63,   -1,   -1,   66,
   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   76,
   -1,   -1,   79,   -1,   -1,   -1,   -1,   -1,   -1,   -1,
   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,
   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,  104,
   -1,   -1,   -1,  136,  137,   -1,   -1,   -1,   -1,   -1,
  143,  144,   -1,   -1,  147,  148,  149,  150,   -1,   -1,
   -1,   -1,   -1,   -1,   -1,  130,   -1,   -1,   -1,  136,
  137,  164,   -1,   -1,   -1,   -1,  143,  144,   -1,   -1,
  147,  148,  149,  150,   -1,   -1,   -1,   -1,   -1,  154,
   -1,  156,   -1,   -1,   -1,   -1,   -1,  164,   -1,   -1,
  256,   -1,   -1,  259,   -1,   -1,   -1,   -1,   -1,   -1,
   -1,  176,   -1,   -1,  270,  271,  272,  273,   -1,   -1,
   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,  256,  194,
  195,  259,   -1,  198,   -1,   -1,   -1,   -1,   -1,   -1,
   -1,   -1,  270,  271,  272,  273,   -1,   -1,  256,   -1,
   -1,  259,   -1,  256,   -1,   -1,  259,   -1,   -1,   -1,
   -1,   -1,  270,  271,  272,  273,   -1,  270,  271,  272,
  273,   -1,  270,  271,  272,  273,
};
}
final static short YYFINAL=3;
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
"Programa : error ListSentencias '}'",
"ListSentencias : ListSentencias Sentencia ','",
"ListSentencias : Sentencia ','",
"Sentencia : SentenciaControl",
"Sentencia : SentenciaEjecutable",
"Sentencia : SentenciaDeclarativa",
"Sentencia : RETURN error",
"ReferenciaObjeto : ID '.' ID",
"ReferenciaObjetoFuncion : ID '.' LlamadoFuncion",
"SentenciaEjecutable : Asignacion",
"SentenciaEjecutable : LlamadoFuncion",
"SentenciaEjecutable : BloqueIF",
"SentenciaEjecutable : SalidaMensaje",
"SentenciaEjecutable : ReferenciaObjetoFuncion",
"ListSentenciasClase : ListSentenciasClase SentenciaDeclarativa ','",
"ListSentenciasClase : SentenciaDeclarativa ','",
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
"BloqueIF : IF Condicion CuerpoIF ELSE CuerpoIF error",
"BloqueIF : IF Condicion CuerpoIF error",
"BloqueIF : IF Condicion SentenciaEjecutable ',' ELSE CuerpoIF END_IF",
"BloqueIF : IF Condicion SentenciaEjecutable ',' ELSE SentenciaEjecutable ',' END_IF",
"BloqueIF : IF Condicion CuerpoIF ELSE SentenciaEjecutable ',' END_IF",
"BloqueIF : IF Condicion SentenciaEjecutable ',' ELSE CuerpoIF error",
"BloqueIF : IF Condicion SentenciaEjecutable ',' ELSE SentenciaEjecutable error",
"BloqueIF : IF Condicion CuerpoIF ELSE SentenciaEjecutable ',' error",
"BloqueIF : IF Condicion SentenciaEjecutable ',' error CuerpoIF END_IF",
"BloqueIF : IF Condicion SentenciaEjecutable ',' error SentenciaEjecutable END_IF",
"BloqueIF : IF Condicion SentenciaEjecutable error ELSE CuerpoIF END_IF",
"BloqueIF : IF Condicion CuerpoIF ELSE SentenciaEjecutable error END_IF",
"BloqueIF : IF Condicion SentenciaEjecutable error END_IF",
"CuerpoIF : '{' SentenciasIF '}'",
"CuerpoIF : RETURN ','",
"CuerpoIF : RETURN error",
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
"Funcion : EncabezadoFuncion Parametro '{' ListSentenciasFuncion '}'",
"Funcion : VOID error Parametro '{' ListSentenciasFuncion '}'",
"EncabezadoFuncion : VOID ID",
"Parametro : '(' Tipo ID ')'",
"Parametro : '(' Tipo ID error",
"Parametro : error Tipo ID ')'",
"Parametro : '(' ')'",
"Parametro : '(' error",
"Parametro : error ')'",
"ListSentenciasFuncion : ListSentenciasFuncion SentenciaDeclarativa ','",
"ListSentenciasFuncion : ListSentenciasFuncion SentenciaEjecutable ','",
"ListSentenciasFuncion : SentenciaEjecutable ','",
"ListSentenciasFuncion : SentenciaDeclarativa ','",
"ListSentenciasFuncion : RETURN ','",
"ListSentenciasFuncion : ListSentenciasFuncion RETURN ','",
"ListSentenciasFuncion : SentenciaEjecutable error",
"ListSentenciasFuncion : SentenciaDeclarativa error",
"ListSentenciasFuncion : RETURN error",
"LlamadoFuncion : ID '(' ')'",
"LlamadoFuncion : ID error ')'",
"LlamadoFuncion : ID '(' error",
"LlamadoFuncion : ID LlamadoExpresion",
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
"LlamadoExpresion : '(' Expresion ')'",
"LlamadoExpresion : error Expresion ')'",
"LlamadoExpresion : '(' Expresion error",
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

//#line 564 "gramatica.y"
  private NodoControl raiz;
  private String ambitoAct = "main";
  private String ambitoNuevo= "";
  static ArrayList<Error> erroresSemanticos = new ArrayList<Error>();
  static ArrayList<String> variables_declaradas = new ArrayList<String>();
  static String tipoActual;

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
//#line 733 "Parser.java"
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
//#line 17 "gramatica.y"
{raiz = new NodoControl("PROGRAMA",(Nodo)val_peek(1)); AnalizadorLexico.agregarEstructura("Reconoce programa ");}
break;
case 2:
//#line 19 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se espera '{' ");}
break;
case 3:
//#line 22 "gramatica.y"
{yyval = new NodoComun("Sentencia", (Nodo) val_peek(2), (Nodo) val_peek(1));}
break;
case 4:
//#line 23 "gramatica.y"
{yyval=val_peek(1);}
break;
case 5:
//#line 27 "gramatica.y"
{yyval = val_peek(0);}
break;
case 6:
//#line 28 "gramatica.y"
{yyval = val_peek(0);}
break;
case 7:
//#line 29 "gramatica.y"
{yyval = new NodoHoja("sentencia declarativa");}
break;
case 8:
//#line 30 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("RETURN definido fuera de funcion ");}
break;
case 9:
//#line 33 "gramatica.y"
{TablaSimbolos.removeToken(val_peek(2).sval);
                            TablaSimbolos.removeToken(val_peek(0).sval);
                            yyval = new NodoComun("ReferenciaObjeto",new NodoHoja(val_peek(2).sval), new NodoHoja(val_peek(0).sval));
                            Token clase = obtenerClase(val_peek(2).sval + ":" + ambitoAct);
                            if (clase == null) {
                                agregarErrorSemantico("El objeto " + val_peek(2).sval + " no existe");
                            }
                            else {
                                String nombreClase = clase.getLexema().substring(0, clase.getLexema().indexOf(":"));
                                String lexemaObjeto = val_peek(0).sval + ":" + ambitoAct + ":"+ nombreClase;
                                Token atributo = TablaSimbolos.getToken(lexemaObjeto);
                                if (atributo == null){
                                    agregarErrorSemantico("Atributo de clase no existe");
                                }
                            }
                            AnalizadorLexico.agregarEstructura("Reconoce llamado a atributo");
                            }
break;
case 10:
//#line 52 "gramatica.y"
{ /*chequear q exista y bla bla*/
                                                yyval = new NodoComun("ReferenciaFuncionObjeto",(Nodo)val_peek(2),(Nodo)val_peek(0));
                                                AnalizadorLexico.agregarEstructura("Reconoce llamado a funcion de clase ");}
break;
case 11:
//#line 57 "gramatica.y"
{yyval=val_peek(0);}
break;
case 12:
//#line 58 "gramatica.y"
{yyval=val_peek(0);}
break;
case 13:
//#line 59 "gramatica.y"
{yyval=val_peek(0);}
break;
case 14:
//#line 60 "gramatica.y"
{yyval=val_peek(0);}
break;
case 15:
//#line 61 "gramatica.y"
{yyval=val_peek(0);}
break;
case 16:
//#line 64 "gramatica.y"
{yyval=null;}
break;
case 17:
//#line 65 "gramatica.y"
{yyval=null;}
break;
case 18:
//#line 68 "gramatica.y"
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
case 20:
//#line 87 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se espera el tipo de la variable ");}
break;
case 21:
//#line 88 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se espera identificador de la variable ");}
break;
case 25:
//#line 94 "gramatica.y"
{variables_declaradas.add(val_peek(0).sval);}
break;
case 26:
//#line 95 "gramatica.y"
{yyval = val_peek(2) ; variables_declaradas.add(val_peek(0).sval);}
break;
case 27:
//#line 98 "gramatica.y"
{TablaSimbolos.removeToken(val_peek(1).sval);
                                    for (String var : variables_declaradas) {
                                    Token t = TablaSimbolos.getToken(var);
                                    if (t != null){
                                        t.setLexema(var + ":" + ambitoAct);
                                        t.setAmbito(ambitoAct);
                                        t.setUso("Objeto");
                                        t.setTipo(val_peek(1).sval);
                                        TablaSimbolos.removeToken(var);
                                        TablaSimbolos.addSimbolo(t.getLexema(),t);
                                    }
                                    else {
                                        agregarErrorSemantico("Ya existe un objeto + var + definido en este ambito");
                                    }
                                    }
                                    variables_declaradas.clear();}
break;
case 28:
//#line 116 "gramatica.y"
{variables_declaradas.add(val_peek(0).sval);}
break;
case 29:
//#line 117 "gramatica.y"
{yyval = val_peek(2) ; variables_declaradas.add(val_peek(0).sval);}
break;
case 30:
//#line 119 "gramatica.y"
{tipoActual = val_peek(0).sval;}
break;
case 31:
//#line 120 "gramatica.y"
{tipoActual = val_peek(0).sval;}
break;
case 32:
//#line 121 "gramatica.y"
{tipoActual = val_peek(0).sval;}
break;
case 33:
//#line 124 "gramatica.y"
{
                    chequearEnteroPositivo(val_peek(0).sval);
                    yyval = new NodoHoja(val_peek(0).sval);
                    ((Nodo)yyval).setTipo("INT");
                    ((Nodo)yyval).setUso("Constante");
                    ((Nodo)yyval).setAmbito(ambitoAct);
                    Token t = TablaSimbolos.getToken(val_peek(0).sval);
                    t.setTipo("INT");
                    t.setUso("Constante");
                    t.setAmbito(ambitoAct);
                    TablaSimbolos.removeToken(val_peek(0).sval);
                    TablaSimbolos.addSimbolo(val_peek(0).sval,t);
                   }
break;
case 34:
//#line 138 "gramatica.y"
{yyval = new NodoHoja(val_peek(0).sval);
	               chequearEnteroCorto(val_peek(0).sval);
	               ((Nodo)yyval).setTipo("USHORT");
                   chequearEnteroPositivo(val_peek(0).sval);
                   ((Nodo)yyval).setUso("Constante");
                   ((Nodo)yyval).setAmbito(ambitoAct);
                   Token t = TablaSimbolos.getToken(val_peek(0).sval);
                   if (t!=null) {
                     t.setTipo("USHORT");
                     t.setUso("Constante");
                     t.setAmbito(ambitoAct);
                     TablaSimbolos.removeToken(val_peek(0).sval);
                     TablaSimbolos.addSimbolo(val_peek(0).sval,t);
                   }
}
break;
case 35:
//#line 151 "gramatica.y"
{AnalizadorLexico.agregarErrorLexico("Un entero corto no puede ser negativo ");}
break;
case 36:
//#line 152 "gramatica.y"
{
	                chequearDouble(val_peek(0).sval);
	                yyval = new NodoHoja(val_peek(0).sval);
                    ((Nodo)yyval).setTipo("DOUBLE");
                    ((Nodo)yyval).setUso("Constante");
                    ((Nodo)yyval).setAmbito(ambitoAct);
	            Token t = TablaSimbolos.getToken(val_peek(0).sval);
                    t.setTipo("DOUBLE");
                    t.setUso("Constante");
                    t.setAmbito(ambitoAct);
                    TablaSimbolos.removeToken(val_peek(0).sval);
                    TablaSimbolos.addSimbolo(val_peek(0).sval,t);
                    }
break;
case 37:
//#line 166 "gramatica.y"
{
                    yyval = new NodoHoja(val_peek(1).sval);
                    chequearEnteroNegativo(val_peek(0).sval);
                    ((Nodo)yyval).setTipo("INT");
                    ((Nodo)yyval).setUso("Constante");
                    ((Nodo)yyval).setAmbito(ambitoAct);
                    Token t = TablaSimbolos.getToken(val_peek(1).sval);
                    t.setTipo("INT");
                    t.setUso("Constante");
                    t.setAmbito(ambitoAct);
                    TablaSimbolos.removeToken(val_peek(1).sval);
                    TablaSimbolos.addSimbolo(val_peek(1).sval,t);
	                }
break;
case 38:
//#line 179 "gramatica.y"
{chequearDouble(val_peek(1).sval);
                         yyval = new NodoHoja(val_peek(1).sval);
                         ((Nodo)yyval).setTipo("DOUBLE");
                         ((Nodo)yyval).setUso("Constante");
                         ((Nodo)yyval).setAmbito(ambitoAct);
                         Token t = TablaSimbolos.getToken(val_peek(1).sval);
                         t.setTipo("DOUBLE");
                         t.setUso("Constante");
                         t.setAmbito(ambitoAct);
                         TablaSimbolos.removeToken(val_peek(1).sval);
                         TablaSimbolos.addSimbolo(val_peek(1).sval,t);
                        }
break;
case 39:
//#line 193 "gramatica.y"
{ yyval = new NodoComun("+",(Nodo)val_peek(2),(Nodo)val_peek(0));
                                if (((Nodo)val_peek(2)).getUso()!= "Constante"){
                                    if (!estaAlAlcance(((Nodo)val_peek(2)).getLexema())){
                                        agregarErrorSemantico("Primer termino fuera de alcance ");
                                        break;
                                    }
                                 }
                                if (((Nodo)val_peek(0)).getUso()!= "Constante"){
                                   if (!estaAlAlcance(((Nodo)val_peek(0)).getLexema())){
                                        agregarErrorSemantico("Segundo termino fuera de alcance ");
                                        break;
                                   }
                                }
                                if (((Nodo)val_peek(2)).getTipo().equals(((Nodo)val_peek(0)).getTipo())){
                                    ((Nodo)yyval).setTipo(((Nodo)val_peek(2)).getTipo());
                                }
                                }
break;
case 40:
//#line 210 "gramatica.y"
{yyval = new NodoComun("-",(Nodo)val_peek(2),(Nodo)val_peek(0));
                        if (((Nodo)val_peek(2)).getUso()!= "Constante"){
                            if (!estaAlAlcance(((Nodo)val_peek(2)).getLexema())){
                                agregarErrorSemantico("Primer termino fuera de alcance ");
                                break;
                            }
                        }
                        if (((Nodo)val_peek(0)).getUso()!= "Constante"){
                            if (!estaAlAlcance(((Nodo)val_peek(0)).getLexema())){
                                agregarErrorSemantico("Segundo termino fuera de alcance ");
                                break;
                            }
                        }
                        if (((Nodo)val_peek(2)).getTipo().equals(((Nodo)val_peek(0)).getTipo())){
                            ((Nodo)yyval).setTipo(((Nodo)val_peek(2)).getTipo());
                        }
                      }
break;
case 41:
//#line 227 "gramatica.y"
{yyval=val_peek(0);}
break;
case 42:
//#line 228 "gramatica.y"
{yyval = val_peek(0);}
break;
case 43:
//#line 232 "gramatica.y"
{yyval = new NodoComun("*",(Nodo)val_peek(2),(Nodo)val_peek(0));
                                if (((Nodo)val_peek(2)).getUso()!= "Constante"){
                                    if (!estaAlAlcance(((Nodo)val_peek(2)).getLexema())){
                                        agregarErrorSemantico("Primer termino fuera de alcance ");
                                        break;
                                    }
                                }
                                if (((Nodo)val_peek(0)).getUso()!= "Constante"){
                                    if (!estaAlAlcance(((Nodo)val_peek(0)).getLexema())){
                                        agregarErrorSemantico("Segundo termino fuera de alcance ");
                                        break;
                                    }
                                }
                                if (((Nodo)val_peek(2)).getTipo().equals(((Nodo)val_peek(0)).getTipo())){
                                    ((Nodo)yyval).setTipo(((Nodo)val_peek(2)).getTipo());
                                }
                              }
break;
case 44:
//#line 250 "gramatica.y"
{yyval = new NodoComun("/",(Nodo)val_peek(2),(Nodo)val_peek(0));
                        if (((Nodo)val_peek(2)).getUso()!= "Constante"){
                            if (!estaAlAlcance(((Nodo)val_peek(2)).getLexema())){
                                agregarErrorSemantico("Primer termino fuera de alcance ");
                                break;
                            }
                        }if (((Nodo)val_peek(0)).getUso()!= "Constante"){
                            if (!estaAlAlcance(((Nodo)val_peek(0)).getLexema())){
                                agregarErrorSemantico("Segundo termino fuera de alcance ");
                                break;
                            }
                        }
                        if (((Nodo)val_peek(2)).getTipo().equals(((Nodo)val_peek(0)).getTipo())){
                            ((Nodo)yyval).setTipo(((Nodo)val_peek(2)).getTipo());
                        }
                    }
break;
case 45:
//#line 266 "gramatica.y"
{yyval = val_peek(0);}
break;
case 46:
//#line 267 "gramatica.y"
{yyval = new NodoComun("*",(Nodo)val_peek(2),(Nodo)val_peek(0));
                               if (!((Nodo)val_peek(2)).getAmbito().equals(((Nodo)val_peek(0)).getAmbito())){
                                    agregarErrorSemantico("Variable fuera de alcance ");
                               }
                                     ((Nodo)yyval).setTipo(tipoPredominante(((Nodo)val_peek(2)).getTipo(),((Nodo)val_peek(0)).getTipo()));
                               }
break;
case 47:
//#line 273 "gramatica.y"
{yyval = new NodoComun("/",(Nodo)val_peek(2),(Nodo)val_peek(0));
                               if (!((Nodo)val_peek(2)).getAmbito().equals(((Nodo)val_peek(0)).getAmbito())){
                                    agregarErrorSemantico("Variable fuera de alcance ");
                               }
                                    ((Nodo)yyval).setTipo(tipoPredominante(((Nodo)val_peek(2)).getTipo(),((Nodo)val_peek(0)).getTipo()));
                               }
break;
case 48:
//#line 279 "gramatica.y"
{yyval=val_peek(0);}
break;
case 49:
//#line 282 "gramatica.y"
{yyval = new NodoHoja(val_peek(0).sval);
            TablaSimbolos.removeToken(val_peek(0).sval);
            String var = val_peek(0).sval + ":" + ambitoAct;
            var = getLexemaAlcance(var);
            if (var.equals(val_peek(0).sval)){
                agregarErrorSemantico("Variable no declarada en este ambito ");
            }
            else {
                if(!TablaSimbolos.getUso(var).equals("Variable")){
                    agregarErrorSemantico("El ID en uso no es una variable ");
                }
                else {
                    ((Nodo)yyval).setTipo(TablaSimbolos.getTipo(var));
                    ((Nodo)yyval).setUso(TablaSimbolos.getUso(var));
                    ((Nodo)yyval).setAmbito(TablaSimbolos.getAmbito(var));
                }
            }
          }
break;
case 50:
//#line 300 "gramatica.y"
{yyval=val_peek(0);}
break;
case 51:
//#line 304 "gramatica.y"
{yyval=val_peek(0);}
break;
case 52:
//#line 307 "gramatica.y"
{ yyval = new NodoComun(val_peek(2).sval,(Nodo)val_peek(3),(Nodo)val_peek(1));
                                                    ((Nodo)yyval).setTipo(((Nodo)val_peek(3)).getTipo());
                                                    ((Nodo)yyval).setUso("Condicion");
                                                     if (!((((Nodo)val_peek(3)).getTipo()).equals(((Nodo)val_peek(1)).getTipo()))){
                                                         agregarErrorSemantico("Error en la comparacion entre expresiones de distintos tipos"); /*CHEQUEAR CONVERSIONES*/
                                                     }
                                                     }
break;
case 53:
//#line 314 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba una ')' ");}
break;
case 54:
//#line 315 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba una '(' ");}
break;
case 55:
//#line 318 "gramatica.y"
{Nodo SentenciasIF = new NodoComun("SentenciasIF",new NodoControl("SentenciasIF",(Nodo)val_peek(3)), new NodoControl("SentenciasELSE",(Nodo)val_peek(1)));
                                                                      yyval= new NodoComun("BloqueIF", new NodoControl("Condicion",(Nodo)val_peek(4)), SentenciasIF);
                                                                      AnalizadorLexico.agregarEstructura("Reconoce IF ELSE ");}
break;
case 56:
//#line 321 "gramatica.y"
{yyval= new NodoComun("BloqueIF", new NodoControl("Condicion",(Nodo)val_peek(2)), new NodoControl("SentenciasIF",(Nodo)val_peek(1)));
	                                            AnalizadorLexico.agregarEstructura("Reconoce IF ");}
break;
case 57:
//#line 323 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("IF mal definido ");}
break;
case 58:
//#line 324 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("IF mal definido ");}
break;
case 59:
//#line 325 "gramatica.y"
{AnalizadorLexico.agregarEstructura("Reconoce IF ELSE");}
break;
case 60:
//#line 326 "gramatica.y"
{AnalizadorLexico.agregarEstructura("Reconoce IF ELSE");}
break;
case 61:
//#line 327 "gramatica.y"
{AnalizadorLexico.agregarEstructura("Reconoce IF ELSE");}
break;
case 62:
//#line 328 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba un END_IF ");}
break;
case 63:
//#line 329 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba un END_IF ");}
break;
case 64:
//#line 330 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba un END_IF ");}
break;
case 65:
//#line 331 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba un ELSE ");}
break;
case 66:
//#line 332 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("IF mal definido ");}
break;
case 67:
//#line 333 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba una ',' ");}
break;
case 68:
//#line 334 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba una ',' " );}
break;
case 69:
//#line 335 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba una ',' ");}
break;
case 72:
//#line 340 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Falta una ',' "); }
break;
case 74:
//#line 342 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Falta una ',' "); }
break;
case 75:
//#line 343 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Falta un '{'"); }
break;
case 76:
//#line 344 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Falta un '}'"); }
break;
case 77:
//#line 345 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("No hay sentencias dentro de las llaves."); }
break;
case 78:
//#line 348 "gramatica.y"
{yyval=val_peek(0);}
break;
case 79:
//#line 351 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Solo se aceptan sentencias ejecutables "); }
break;
case 80:
//#line 352 "gramatica.y"
{yyval=val_peek(1);}
break;
case 81:
//#line 353 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Falta una ',' "); }
break;
case 82:
//#line 354 "gramatica.y"
{yyval = new NodoComun("SentenciaIF", (Nodo) val_peek(2), (Nodo) val_peek(1));}
break;
case 83:
//#line 357 "gramatica.y"
{yyval=val_peek(0);}
break;
case 84:
//#line 358 "gramatica.y"
{yyval=val_peek(0);}
break;
case 85:
//#line 359 "gramatica.y"
{yyval=val_peek(0);}
break;
case 86:
//#line 360 "gramatica.y"
{yyval=val_peek(0);}
break;
case 87:
//#line 361 "gramatica.y"
{yyval=val_peek(0);}
break;
case 88:
//#line 362 "gramatica.y"
{yyval=val_peek(0);}
break;
case 91:
//#line 369 "gramatica.y"
{deshacerAmbito(); AnalizadorLexico.agregarEstructura("Reconoce declaracion de funcion ");}
break;
case 92:
//#line 370 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba un nombre para la funcion ");}
break;
case 93:
//#line 373 "gramatica.y"
{actualizarAmbito(val_peek(0).sval);
			      Token t = TablaSimbolos.getToken(val_peek(0).sval);
                              if (t != null){
                                    t.setLexema(val_peek(0).sval + ":" + ambitoAct);
                                    t.setAmbito(ambitoAct);
                                    t.setUso("Funcion");
                                    t.setTipo("VOID");
                                    TablaSimbolos.removeToken(val_peek(0).sval);
                                    TablaSimbolos.addSimbolo(t.getLexema(),t);
                              }
                              }
break;
case 94:
//#line 388 "gramatica.y"
{
				Token t = TablaSimbolos.getToken(val_peek(1).sval);
                                if (t != null){
                                	t.setLexema(val_peek(1).sval + ":" + ambitoAct);
                                	t.setAmbito(ambitoAct);
                                	t.setUso("Parametro");
                                	t.setTipo(tipoActual);
                                	TablaSimbolos.removeToken(val_peek(1).sval);
                                	TablaSimbolos.addSimbolo(t.getLexema(),t);
                                }
                           }
break;
case 95:
//#line 399 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba un ')' ");}
break;
case 96:
//#line 400 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba un '(' ");}
break;
case 98:
//#line 402 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba un ')' ");}
break;
case 99:
//#line 403 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba un '(' ");}
break;
case 100:
//#line 406 "gramatica.y"
{yyval = new NodoComun("Sentencia", (Nodo) val_peek(2), (Nodo) val_peek(1));}
break;
case 101:
//#line 407 "gramatica.y"
{yyval = new NodoComun("Sentencia", (Nodo) val_peek(2), (Nodo) val_peek(1));}
break;
case 102:
//#line 408 "gramatica.y"
{yyval = val_peek(1);}
break;
case 103:
//#line 409 "gramatica.y"
{yyval = new NodoHoja("sentencia declarativa");}
break;
case 105:
//#line 411 "gramatica.y"
{yyval = val_peek(2);}
break;
case 106:
//#line 412 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba una ',' al final de la linea ");}
break;
case 107:
//#line 413 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba una ',' al final de la linea ");}
break;
case 108:
//#line 414 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba una ',' al final de la linea ");}
break;
case 109:
//#line 417 "gramatica.y"
{yyval=new NodoHoja(val_peek(2).sval);
                             Token funcion = TablaSimbolos.buscarPorAmbito(val_peek(2).sval + ":" + ambitoAct);
                             if (funcion == null){
                                agregarErrorSemantico("La funcion " + val_peek(2).sval + " nunca fue declarada");
                             }
				            AnalizadorLexico.agregarEstructura("Reconoce llamado funcion ");
				            TablaSimbolos.removeToken(val_peek(2).sval);
				            }
break;
case 110:
//#line 425 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba un '(' ");}
break;
case 111:
//#line 426 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba un ')' ");}
break;
case 112:
//#line 427 "gramatica.y"
{yyval=new NodoComun("Llamado Funcion",(Nodo)val_peek(1),new NodoControl("Parametro Llamado Funcion",(Nodo)val_peek(0)));AnalizadorLexico.agregarEstructura("Reconoce llamado funcion ");
                                    Token funcion = TablaSimbolos.buscarPorAmbito(val_peek(1).sval + ":" + ambitoAct);
                                    if (funcion == null){
                                        agregarErrorSemantico("La funcion " + val_peek(1).sval + " nunca fue declarada");
                                    }
                                    AnalizadorLexico.agregarEstructura("Reconoce llamado funcion ");
                                    TablaSimbolos.removeToken(val_peek(1).sval);
                                    }
break;
case 113:
//#line 437 "gramatica.y"
{yyval = new NodoControl("PRINT", new NodoHoja(val_peek(0).sval));
                             AnalizadorLexico.agregarEstructura("Reconoce salida de mensaje por pantalla ");}
break;
case 114:
//#line 439 "gramatica.y"
{yyval = new NodoControl("PRINT", new NodoHoja(val_peek(0).sval));
                            AnalizadorLexico.agregarEstructura("Reconoce salida de mensaje por pantalla ");}
break;
case 115:
//#line 441 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("La funcion PRINT no acepta esa declaracion ");}
break;
case 116:
//#line 444 "gramatica.y"
{yyval=val_peek(0);}
break;
case 117:
//#line 445 "gramatica.y"
{yyval=val_peek(0);}
break;
case 118:
//#line 448 "gramatica.y"
{AnalizadorLexico.agregarEstructura("Reconoce asignacion ");
						                        yyval = new NodoComun(val_peek(1).sval,(Nodo)val_peek(2),(Nodo)val_peek(0));
                                                String uso = ((Nodo)val_peek(2)).getLexema();
                                                if (!(uso.equals("Constante"))){
                                                String var = getLexemaAlcance(((Nodo)val_peek(2)).getLexema() + ":" + ambitoAct);
                                                    if (var.contains("main")){
                                                        Token t1 = TablaSimbolos.getToken(var);
                                                        if (t1 != null){
                                                                if (getLexemaAlcance(var).equals(((Nodo)val_peek(2)).getLexema())){
                                                                    agregarErrorSemantico("Variable " + ((Nodo)val_peek(2)).getLexema() +" fuera de alcance");
                                                                }
                                                        }
                                                    }
                                                    else {
                                                        agregarErrorSemantico("Variable " + ((Nodo)val_peek(2)).getLexema() + " no definida");
                                                    }
                                                }
                                                else {
                                                    agregarErrorSemantico("Las constantes no pueden estar del lado izquierdo en una asignacion");
					                            }
					                            }
break;
case 119:
//#line 470 "gramatica.y"
{AnalizadorLexico.agregarEstructura("Reconoce asignacion ");
	                                                        yyval = new NodoComun(val_peek(1).sval,(Nodo)val_peek(2),(Nodo)val_peek(0));}
break;
case 120:
//#line 473 "gramatica.y"
{AnalizadorLexico.agregarEstructura("Reconoce asignacion ");
	                                                yyval = new NodoComun(val_peek(1).sval,(Nodo)val_peek(2),(Nodo)val_peek(0));
	                                                String uso = ((Nodo)val_peek(0)).getUso();
	                                                if (!(uso.equals("Constante"))){
                                                        String var = getLexemaAlcance(((Nodo)val_peek(0)).getLexema() + ":" + ambitoAct);
                                                        if (var.contains("main")){
                                                            Token t1 = TablaSimbolos.getToken(var);
                                                            if (t1 != null){
                                                                if (getLexemaAlcance(var).equals(((Nodo)val_peek(2)).getLexema())){
                                                                        agregarErrorSemantico("Variable " + ((Nodo)val_peek(2)).getLexema() +" fuera de alcance");
                                                                    }
                                                            }
                                                        }
                                                        else {
                                                            agregarErrorSemantico("Variable " + ((Nodo)val_peek(0)).getLexema() + " no definida");
                                                        }
                                                    }
	                                                }
break;
case 121:
//#line 491 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba un valor seguido del operador ");}
break;
case 122:
//#line 492 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba un valor seguido del operador ");}
break;
case 123:
//#line 493 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba un operando del lado izquierdo ");}
break;
case 124:
//#line 496 "gramatica.y"
{yyval=new NodoComun("Sentencia DO UNTIL", new NodoControl("ListSentenciasDO",(Nodo)val_peek(2)), new NodoControl("CondicionDO", (Nodo)val_peek(0)));
                                                        AnalizadorLexico.agregarEstructura("Reconoce funcion DO UNTIL");}
break;
case 125:
//#line 498 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba una condicion ");}
break;
case 126:
//#line 503 "gramatica.y"
{yyval = val_peek(1);}
break;
case 127:
//#line 504 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba un '(' ");}
break;
case 128:
//#line 505 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba un ')' ");}
break;
case 129:
//#line 508 "gramatica.y"
{yyval = val_peek(1);}
break;
case 130:
//#line 509 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba un '(' ");}
break;
case 131:
//#line 510 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba un ')' ");}
break;
case 132:
//#line 513 "gramatica.y"
{yyval = new NodoControl("TOD",(Nodo)val_peek(0));
                                            AnalizadorLexico.agregarEstructura("Reconoce funcion TOD ");
                                            }
break;
case 133:
//#line 517 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba una Expresion ");}
break;
case 135:
//#line 524 "gramatica.y"
{Token var = TablaSimbolos.getToken(val_peek(0).sval + ":" + ambitoAct);
                            if (var != null) {
                                if (var.getUso().equals("Clase")) {
                                    agregarErrorSemantico("Clase " + val_peek(0).sval + " ya definida en el ambito actual");
                                    break;
                                }
                                agregarErrorSemantico("Este identificador ya fue utilizado en este ambito");
                                break;
                            }
                            Token t = TablaSimbolos.getToken(val_peek(0).sval);
                            if (t != null){
				    t.setLexema(t.getLexema() + ":" + ambitoAct);
				    t.setAmbito(ambitoAct);
				    t.setUso("Clase");
				    TablaSimbolos.removeToken(val_peek(0).sval);
				    TablaSimbolos.addSimbolo(t.getLexema(),t);
                            }
                            actualizarAmbito(val_peek(0).sval);
                            tipoActual = ambitoAct;
                            }
break;
case 136:
//#line 545 "gramatica.y"
{deshacerAmbito();}
break;
case 137:
//#line 548 "gramatica.y"
{AnalizadorLexico.agregarEstructura("Reconoce Funcion sin cuerpo");}
break;
case 138:
//#line 552 "gramatica.y"
{AnalizadorLexico.agregarEstructura("Reconoce funcion IMPL"); TablaSimbolos.removeToken(val_peek(4).sval);}
break;
case 139:
//#line 553 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba un '{' ");}
break;
case 140:
//#line 554 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba un '}' ");}
break;
//#line 1698 "Parser.java"
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
