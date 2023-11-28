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
    0,    0,    1,    1,    1,    2,    2,    2,    2,    6,
    7,    4,    4,    4,    4,    4,   12,   12,   12,   12,
    5,    5,    5,    5,    5,    5,    5,   14,   14,   17,
   19,   19,   13,   13,   13,   20,   20,   20,   20,   20,
   20,   21,   21,   21,   21,   22,   22,   22,   22,   22,
   22,   24,   24,   25,   26,   26,   26,   10,   10,   10,
   10,   10,   10,   10,   10,   10,   10,   10,   10,   10,
   10,   10,   28,   28,   28,   28,   28,   28,   28,   29,
   29,   29,   30,   30,   30,   30,   27,   27,   27,   27,
   27,   27,   15,   15,   31,   31,   31,   31,   31,   33,
   34,   34,   34,   34,   34,   34,   35,   35,   35,   35,
   35,    8,    8,    8,    8,   11,   11,   11,   36,   36,
    9,    9,    9,    9,    9,    9,    3,    3,   37,   37,
   37,   23,   23,   38,   39,   16,   32,   18,   18,   18,
};
final static short yylen[] = {                            2,
    3,    3,    3,    2,    2,    1,    1,    1,    2,    3,
    3,    1,    1,    1,    1,    1,    3,    2,    2,    3,
    2,    1,    2,    2,    1,    1,    1,    1,    3,    2,
    1,    3,    1,    1,    1,    1,    1,    2,    1,    2,
    2,    3,    3,    1,    1,    3,    3,    1,    3,    3,
    1,    1,    1,    1,    5,    5,    5,    6,    4,    6,
    4,    7,    8,    7,    7,    7,    7,    7,    7,    7,
    7,    5,    3,    5,    5,    5,    3,    3,    2,    1,
    2,    2,    1,    2,    2,    3,    1,    1,    1,    1,
    1,    1,    1,    1,    7,    7,    5,    6,    4,    2,
    4,    4,    4,    2,    2,    2,    3,    2,    2,    2,
    2,    3,    3,    3,    4,    2,    2,    2,    1,    1,
    3,    3,    3,    3,    3,    2,    4,    4,    3,    3,
    3,    2,    3,    3,    2,    2,    2,    7,    7,    7,
};
final static short yydefred[] = {                         0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
   34,   33,   35,    0,  120,    0,   36,   37,   39,    0,
  119,    0,    0,    6,    7,    8,    0,   16,   13,   12,
   14,   15,    0,   22,   25,   26,   27,   53,    0,   93,
   94,    0,    0,    0,    0,   28,    0,    0,    0,    0,
  118,   52,  116,  117,  135,    0,  100,    0,    0,    0,
    0,    0,   31,    0,    0,    0,    9,   40,   38,   41,
    2,    0,    5,    4,    0,   24,    0,    0,    0,    0,
    0,  126,    0,  136,    1,    0,    0,    0,   54,    0,
    0,   45,   48,   51,    0,    0,    0,    0,    0,   83,
    0,    0,    0,    0,    0,   79,    0,    0,    0,  113,
    0,   11,  114,  112,    0,    0,    3,  124,  122,  123,
  125,    0,  106,    0,  105,  104,    0,    0,    0,    0,
    0,    0,   29,    0,    0,    0,  132,   91,   92,   90,
   89,    0,    0,   87,   88,    0,    0,    0,    0,    0,
    0,   61,    0,   59,    0,   82,   81,   85,   84,   77,
    0,    0,    0,   78,    0,   73,    0,  127,    0,  115,
   32,    0,    0,    0,   99,    0,    0,    0,    0,   19,
   18,    0,  134,    0,   10,    0,  133,    0,    0,    0,
    0,   46,   49,   47,   50,    0,    0,   72,    0,    0,
    0,    0,    0,   86,    0,    0,    0,    0,    0,  103,
  102,  101,  111,  108,  109,  110,    0,    0,    0,   20,
   17,  130,  131,  129,   57,   56,   55,    0,    0,    0,
    0,    0,    0,    0,   60,   58,   98,   75,   76,   74,
    0,    0,    0,    0,    0,  107,   70,   69,   68,   66,
    0,   65,   62,   71,   67,   64,  139,    0,  140,  138,
   96,   95,   63,
};
final static short yydgoto[] = {                          3,
   22,   23,   24,   25,   26,   27,   28,   29,   30,   31,
   32,  132,   33,   47,   34,   35,   36,   37,   66,   38,
   90,   91,   92,   39,   94,   50,  146,   60,  103,  104,
   40,   41,   42,   81,  179,   43,  137,   84,   44,
};
final static short yysindex[] = {                      -109,
  147,  147,    0, -231,  -37,  274, -216, -234, -105, -217,
    0,    0,    0,  -39,    0,   39,    0,    0,    0, -209,
    0,   21,   24,    0,    0,    0,  -42,    0,    0,    0,
    0,    0, -220,    0,    0,    0,    0,    0,  -42,    0,
    0,  -32,  -18,  -21,   46,    0,   52,  180,  180,  212,
    0,    0,    0,    0,    0,  -32,    0,  249,  205, -135,
 -139,   90,    0, -136,  -41,   76,    0,    0,    0,    0,
    0,   92,    0,    0,  327,    0,   52,  324,  127,  345,
   14,    0, -141,    0,    0, -131,   97,  -30,    0,  505,
    4,    0,    0,    0,  505,  -34,   29, -159,   19,    0,
   35,   36,   25,  299,   -4,    0, -112,  -29,   87,    0,
  -25,    0,    0,    0,   11, -115,    0,    0,    0,    0,
    0,   15,    0, -113,    0,    0, -111,   71, -110,  116,
  117,  -63,    0, -107,  180,  -36,    0,    0,    0,    0,
    0,  209,  209,    0,    0,  180,  209,  209,  180, -211,
 -155,    0,  212,    0,  173,    0,    0,    0,    0,    0,
  120,    0,  125,    0,   37,    0,  180,    0, -103,    0,
    0,  129,    3,   41,    0,  128,  -82,  -81,   96,    0,
    0,  132,    0,  133,    0,   20,    0,  -20,    4,    4,
   31,    0,    0,    0,    0,  -15, -105,    0,  212,  212,
   42, -227,  122,    0,   53,   54,   55,  -96,  -96,    0,
    0,    0,    0,    0,    0,    0,  137,  -93,  141,    0,
    0,    0,    0,    0,    0,    0,    0,  -70,  -69,  -68,
   48, -181,  -65, -172,    0,    0,    0,    0,    0,    0,
   70,  -32, -101,   75,  157,    0,    0,    0,    0,    0,
  -52,    0,    0,    0,    0,    0,    0,   14,    0,    0,
    0,    0,    0,
};
final static short yyrindex[] = {                         0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,  -19,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,   49,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,   60,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,   61,    0,    0,    0,
   62,    0,    0,    0,    0,    0,  452,    0,    0,    0,
  457,    0,    0,    0,    0,  -19,    0,    0,    0,    0,
    0,    0,    0,  -27,    0,    0,    0,    0,    0,    0,
   -2,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,  121,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,  -11,    0,    0,    0,    0,   66,    0,    0,    0,
    0,    0,    0,    0,    0,    0,  167,  169,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,  495,  501,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,   23,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,  170,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,
};
final static short yygindex[] = {                         0,
  214,   -6,    0,  540,  -38,  656,    0,  259,    0,    0,
    0,    0,    9,  296,    0,    0,    0,    0,    0,    0,
   74,  -47,    0,  543,  -35,  233,  247,  -13,  -28,    0,
 -100,    0,  -90,  -54,  188,   16,    0,    0,    0,
};
final static int YYTABLESIZE=823;
static short yytable[];
static { yytable();}
static void yytable(){
yytable = new short[]{                        114,
   65,   99,   49,   20,  187,   65,   64,   80,   20,  136,
   49,   64,  166,    2,   65,   72,   80,   59,   21,  209,
  224,   56,  143,  260,  142,  227,   20,  143,  235,  142,
  107,  236,   83,   83,   57,   76,   98,   46,   72,  157,
   20,   52,   75,  212,  131,  147,  197,  198,   46,   83,
  148,  170,   55,  143,   78,  142,   21,  143,   10,  142,
  222,  183,  143,   61,  142,   20,   97,   74,   68,   69,
   70,  225,  151,  143,  252,  142,  163,  253,  157,  159,
  207,   21,   67,  255,   67,  234,  256,  124,  127,  178,
   20,  251,   23,  184,  189,  190,  152,   80,  153,  154,
  199,   83,  200,   30,   21,  137,   21,  241,  243,  128,
   86,  193,  195,   82,    4,   20,  178,  242,  242,    7,
    8,  176,   95,   10,   11,   12,   13,  129,  108,  109,
  110,   21,  111,  130,  116,  117,  128,  133,  115,  202,
   20,  155,  134,  164,  169,   71,    1,   97,  176,  160,
   58,  122,  208,  171,  259,  172,   21,  173,   63,  180,
  181,  185,  165,  204,  121,    8,   20,  123,  205,  210,
   85,  214,  219,  215,  216,  220,  221,  238,  239,  240,
  244,  245,   21,  228,  246,  230,  232,  258,  247,  248,
  249,   20,    4,  254,  257,  175,  219,    7,    8,  261,
  262,   10,   11,   12,   13,  129,  263,   21,  186,  188,
    7,  182,    8,    9,  113,   45,   62,   20,   48,  191,
  218,   62,  196,   79,   20,  135,  167,   87,   80,   63,
   62,   15,   87,   21,   88,  223,   17,   18,   19,   88,
  226,   17,   18,   19,   82,   83,  237,   80,   83,   20,
   52,  162,    5,   20,   52,    6,   20,   83,  211,   17,
   18,   19,   83,   82,   96,   21,   83,   83,   83,   15,
  101,   10,   21,   17,   18,   19,    4,    5,   97,   73,
    6,    7,    8,    9,  150,   10,   11,   12,   13,   14,
  156,  158,  206,   20,   15,   16,  213,  233,   17,   18,
   19,    4,    5,  250,   23,    6,    7,    8,    9,   21,
   10,   11,   12,   13,   14,   30,   21,  137,   20,   15,
   16,  128,  112,   17,   18,   19,    4,    5,   77,  106,
    6,    7,    8,    9,   59,   10,   11,   12,   13,   14,
  168,  149,  203,   20,   15,  174,    0,    0,   17,   18,
   19,    4,    5,    0,    0,    6,    7,    8,    9,   21,
   10,   11,   12,   13,   14,    0,    0,    0,   20,   15,
  217,   20,    0,   17,   18,   19,  121,    4,    5,  121,
    0,    6,    7,    8,    9,  126,   10,   11,   12,   13,
   14,    0,   11,   12,   13,   15,   16,    0,    0,   17,
   18,   19,    4,    5,    0,    0,    6,    7,    8,    9,
    0,   10,   11,   12,   13,   14,    0,    0,    0,    0,
   15,   16,    0,    0,   17,   18,   19,    0,    4,    5,
    0,    0,    6,    7,    8,    9,    0,   10,   11,   12,
   13,   14,    0,    0,    0,    0,   15,  174,   87,    0,
   17,   18,   19,    0,    0,   88,    0,   17,   18,   19,
  100,    5,    0,    0,    6,    0,    0,   58,    5,    0,
    0,    6,    0,   96,    0,    0,    0,   87,   15,  105,
   96,    0,   17,   18,   19,   15,   17,   18,   19,   17,
   18,   19,   52,   52,   52,   52,   52,   44,   52,   44,
   44,   44,    0,    0,  100,    5,    0,    0,    6,    0,
    0,   52,    0,   52,    0,    0,   44,   96,   44,    0,
    0,    0,   15,  101,    0,    0,   17,   18,   19,   51,
    0,    0,    0,    0,    0,   43,    0,   43,   43,   43,
    0,   42,   52,   42,   42,   42,    0,  143,   54,  142,
   53,   17,   18,   19,   43,    5,   43,    0,    6,    0,
   42,    0,   42,    0,  144,    0,  145,   96,    0,    0,
    0,    0,   15,    0,    0,    0,   17,   18,   19,  121,
    0,    0,  118,    0,    0,   82,    0,    0,    0,   97,
   93,   93,   87,    0,    0,   87,    0,  102,  102,   88,
  125,   17,   18,   19,   17,   18,   19,   93,    0,    0,
   11,   12,   13,    0,    0,    0,    0,  120,    0,    0,
   93,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,  161,  102,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,  177,    0,    0,
    0,    0,    0,    0,    0,    0,    0,   93,   93,    0,
    0,    0,    0,    0,   93,   93,    0,    0,   93,  192,
  194,   93,  201,    0,  177,    0,    0,    0,    0,    0,
    0,    0,    0,   89,   89,    0,    0,   52,    0,   93,
   52,    0,   44,    0,    0,   44,    0,    0,    0,    0,
   89,   52,   52,   52,   52,    0,   44,   44,   44,   44,
  119,    0,    0,   89,    0,    0,    0,    0,  229,  231,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
   43,    0,    0,   43,    0,    0,   42,    0,    0,   42,
    0,    0,    0,    0,   43,   43,   43,   43,    0,    0,
   42,   42,   42,   42,  138,  139,  140,  141,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
   89,   89,    0,    0,    0,    0,    0,   89,   89,    0,
    0,   89,   89,   89,   89,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,   89,
};
}
static short yycheck[];
static { yycheck(); }
static void yycheck() {
yycheck = new short[] {                         41,
   40,   56,   40,   45,   41,   40,   46,   40,   45,   40,
   40,   46,  125,  123,   40,   22,   44,  123,   61,  123,
   41,  256,   43,  125,   45,   41,   45,   43,  256,   45,
   59,  259,   44,   45,  269,  256,   50,  269,   45,   44,
   45,   61,   27,   41,   83,   42,  258,  259,  269,   61,
   47,   41,  269,   43,   39,   45,   61,   43,   61,   45,
   41,  125,   43,  281,   45,   45,   44,   44,  278,  279,
  280,   41,   44,   43,  256,   45,  105,  259,   44,   44,
   44,   61,   44,  256,   44,   44,  259,   79,   80,  128,
   45,   44,   44,  132,  142,  143,  256,  125,  258,  259,
  256,  123,  258,   44,   44,   44,   61,  208,  209,   44,
   59,  147,  148,  125,  256,   45,  155,  208,  209,  261,
  262,  128,   49,  265,  266,  267,  268,  269,  264,  269,
   41,   61,  269,  275,   59,   44,  123,  269,   65,  153,
   45,  123,   46,  256,   58,  125,  256,  125,  155,  125,
  256,   78,  256,  269,  256,  269,   61,  269,  269,   44,
   44,  269,  275,   44,   44,  262,   45,   41,   44,   41,
  125,   44,  179,  256,  256,   44,   44,  125,  125,  125,
   44,  275,   61,  197,   44,  199,  200,  242,  259,  259,
  259,   45,  256,  259,  125,  125,  203,  261,  262,  125,
   44,  265,  266,  267,  268,  269,  259,   61,  135,  136,
   44,  275,   44,   44,  256,    2,  256,   45,  256,  146,
  125,  256,  149,  256,   45,  256,  256,  269,  256,  269,
  256,  274,  269,   61,  276,  256,  278,  279,  280,  276,
  256,  278,  279,  280,  256,  257,  125,  275,  260,   45,
  269,  256,  257,   45,  274,  260,   45,  269,  256,  278,
  279,  280,  274,  275,  269,   61,  278,  279,  280,  274,
  275,  274,   61,  278,  279,  280,  256,  257,  256,  256,
  260,  261,  262,  263,  256,  265,  266,  267,  268,  269,
  256,  256,  256,   45,  274,  275,  256,  256,  278,  279,
  280,  256,  257,  256,  256,  260,  261,  262,  263,   61,
  265,  266,  267,  268,  269,  256,  256,  256,   45,  274,
  275,  256,   64,  278,  279,  280,  256,  257,   33,  125,
  260,  261,  262,  263,  123,  265,  266,  267,  268,  269,
  108,   95,  155,   45,  274,  275,   -1,   -1,  278,  279,
  280,  256,  257,   -1,   -1,  260,  261,  262,  263,   61,
  265,  266,  267,  268,  269,   -1,   -1,   -1,   45,  274,
  275,   45,   -1,  278,  279,  280,  256,  256,  257,  259,
   -1,  260,  261,  262,  263,   41,  265,  266,  267,  268,
  269,   -1,  266,  267,  268,  274,  275,   -1,   -1,  278,
  279,  280,  256,  257,   -1,   -1,  260,  261,  262,  263,
   -1,  265,  266,  267,  268,  269,   -1,   -1,   -1,   -1,
  274,  275,   -1,   -1,  278,  279,  280,   -1,  256,  257,
   -1,   -1,  260,  261,  262,  263,   -1,  265,  266,  267,
  268,  269,   -1,   -1,   -1,   -1,  274,  275,  269,   -1,
  278,  279,  280,   -1,   -1,  276,   -1,  278,  279,  280,
  256,  257,   -1,   -1,  260,   -1,   -1,  256,  257,   -1,
   -1,  260,   -1,  269,   -1,   -1,   -1,  269,  274,  275,
  269,   -1,  278,  279,  280,  274,  278,  279,  280,  278,
  279,  280,   41,   42,   43,   44,   45,   41,   47,   43,
   44,   45,   -1,   -1,  256,  257,   -1,   -1,  260,   -1,
   -1,   60,   -1,   62,   -1,   -1,   60,  269,   62,   -1,
   -1,   -1,  274,  275,   -1,   -1,  278,  279,  280,  256,
   -1,   -1,   -1,   -1,   -1,   41,   -1,   43,   44,   45,
   -1,   41,  269,   43,   44,   45,   -1,   43,    6,   45,
  277,  278,  279,  280,   60,  257,   62,   -1,  260,   -1,
   60,   -1,   62,   -1,   60,   -1,   62,  269,   -1,   -1,
   -1,   -1,  274,   -1,   -1,   -1,  278,  279,  280,  256,
   -1,   -1,  256,   -1,   -1,   43,   -1,   -1,   -1,   50,
   48,   49,  269,   -1,   -1,  269,   -1,   58,   59,  276,
  256,  278,  279,  280,  278,  279,  280,   65,   -1,   -1,
  266,  267,  268,   -1,   -1,   -1,   -1,   75,   -1,   -1,
   78,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,
   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,
   -1,   -1,   -1,  104,  105,   -1,   -1,   -1,   -1,   -1,
   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,
   -1,   -1,   -1,   -1,   -1,   -1,   -1,  128,   -1,   -1,
   -1,   -1,   -1,   -1,   -1,   -1,   -1,  135,  136,   -1,
   -1,   -1,   -1,   -1,  142,  143,   -1,   -1,  146,  147,
  148,  149,  153,   -1,  155,   -1,   -1,   -1,   -1,   -1,
   -1,   -1,   -1,   48,   49,   -1,   -1,  256,   -1,  167,
  259,   -1,  256,   -1,   -1,  259,   -1,   -1,   -1,   -1,
   65,  270,  271,  272,  273,   -1,  270,  271,  272,  273,
   75,   -1,   -1,   78,   -1,   -1,   -1,   -1,  199,  200,
   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,
  256,   -1,   -1,  259,   -1,   -1,  256,   -1,   -1,  259,
   -1,   -1,   -1,   -1,  270,  271,  272,  273,   -1,   -1,
  270,  271,  272,  273,  270,  271,  272,  273,   -1,   -1,
   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,
  135,  136,   -1,   -1,   -1,   -1,   -1,  142,  143,   -1,
   -1,  146,  147,  148,  149,   -1,   -1,   -1,   -1,   -1,
   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,
   -1,   -1,  167,
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
"ListSentencias : Sentencia error",
"Sentencia : SentenciaControl",
"Sentencia : SentenciaEjecutable",
"Sentencia : SentenciaDeclarativa",
"Sentencia : RETURN ','",
"ReferenciaObjeto : ID '.' ID",
"ReferenciaObjetoFuncion : ID '.' LlamadoFuncion",
"SentenciaEjecutable : Asignacion",
"SentenciaEjecutable : LlamadoFuncion",
"SentenciaEjecutable : BloqueIF",
"SentenciaEjecutable : SalidaMensaje",
"SentenciaEjecutable : ReferenciaObjetoFuncion",
"ListSentenciasClase : ListSentenciasClase SentenciaDeclarativa ','",
"ListSentenciasClase : SentenciaDeclarativa ','",
"ListSentenciasClase : RETURN ','",
"ListSentenciasClase : ListSentenciasClase RETURN ','",
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
"CuerpoIF : '{' SentenciasIF RETURN ',' '}'",
"CuerpoIF : '{' RETURN SentenciasIF ',' '}'",
"CuerpoIF : '{' SentenciasIF RETURN error '}'",
"CuerpoIF : error SentenciasIF '}'",
"CuerpoIF : '{' SentenciasIF error",
"CuerpoIF : '{' '}'",
"SentenciasIF : ListaSentenciasIF",
"SentenciasIF : RETURN ','",
"SentenciasIF : RETURN error",
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
"Funcion : EncabezadoFuncion Parametro '{' ListSentenciasFuncion '}' RETURN ','",
"Funcion : EncabezadoFuncion Parametro '{' ListSentenciasFuncion RETURN ',' '}'",
"Funcion : EncabezadoFuncion Parametro '{' ListSentenciasFuncion '}'",
"Funcion : VOID error Parametro '{' ListSentenciasFuncion '}'",
"Funcion : EncabezadoFuncion Parametro '{' '}'",
"EncabezadoFuncion : VOID ID",
"Parametro : '(' Tipo ID ')'",
"Parametro : '(' Tipo ID error",
"Parametro : error Tipo ID ')'",
"Parametro : '(' ')'",
"Parametro : '(' error",
"Parametro : error ')'",
"ListSentenciasFuncion : ListSentenciasFuncion Sentencia ','",
"ListSentenciasFuncion : Sentencia ','",
"ListSentenciasFuncion : SentenciaEjecutable error",
"ListSentenciasFuncion : SentenciaDeclarativa error",
"ListSentenciasFuncion : RETURN error",
"LlamadoFuncion : ID '(' ')'",
"LlamadoFuncion : ID error ')'",
"LlamadoFuncion : ID '(' error",
"LlamadoFuncion : ID '(' Expresion ')'",
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

//#line 616 "gramatica.y"
  public NodoControl raiz;
  private String ambitoAct = "main";
  private String ambitoNuevo= "";
  static ArrayList<Error> erroresSemanticos = new ArrayList<Error>();
  static ArrayList<String> variables_declaradas = new ArrayList<String>();
  static String tipoActual;
  static ArrayList<Funcion> funciones_declaradas = new ArrayList<Funcion>();

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
//#line 755 "Parser.java"
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
{   raiz = new NodoControl("PROGRAMA");
                                    raiz.setDer((Nodo)val_peek(1));
                                    AnalizadorLexico.agregarEstructura("Reconoce programa ");}
break;
case 2:
//#line 21 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se espera '{' ");}
break;
case 3:
//#line 24 "gramatica.y"
{yyval = new NodoComun("Sentencia", (Nodo) val_peek(2), (Nodo) val_peek(1));}
break;
case 4:
//#line 25 "gramatica.y"
{yyval=val_peek(1);}
break;
case 5:
//#line 26 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba una ',' al final de la linea ");}
break;
case 6:
//#line 29 "gramatica.y"
{yyval = val_peek(0);}
break;
case 7:
//#line 30 "gramatica.y"
{yyval = val_peek(0);}
break;
case 8:
//#line 31 "gramatica.y"
{}
break;
case 9:
//#line 32 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("RETURN definido fuera de funcion ");}
break;
case 10:
//#line 35 "gramatica.y"
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
case 11:
//#line 54 "gramatica.y"
{ /*chequear q exista y bla bla*/
                                                yyval = new NodoComun("ReferenciaFuncionObjeto",(Nodo)val_peek(2),(Nodo)val_peek(0));
                                                AnalizadorLexico.agregarEstructura("Reconoce llamado a funcion de clase ");}
break;
case 12:
//#line 59 "gramatica.y"
{yyval=val_peek(0);}
break;
case 13:
//#line 60 "gramatica.y"
{yyval=val_peek(0);}
break;
case 14:
//#line 61 "gramatica.y"
{yyval=val_peek(0);}
break;
case 15:
//#line 62 "gramatica.y"
{yyval=val_peek(0);}
break;
case 16:
//#line 63 "gramatica.y"
{yyval=val_peek(0);}
break;
case 19:
//#line 68 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("RETURN definido fuera de funcion ");}
break;
case 20:
//#line 69 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("RETURN definido fuera de funcion ");}
break;
case 21:
//#line 72 "gramatica.y"
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
case 23:
//#line 91 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se espera el tipo de la variable ");}
break;
case 24:
//#line 92 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se espera identificador de la variable ");}
break;
case 28:
//#line 98 "gramatica.y"
{variables_declaradas.add(val_peek(0).sval);}
break;
case 29:
//#line 99 "gramatica.y"
{variables_declaradas.add(val_peek(0).sval);}
break;
case 30:
//#line 102 "gramatica.y"
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
case 31:
//#line 120 "gramatica.y"
{variables_declaradas.add(val_peek(0).sval);}
break;
case 32:
//#line 121 "gramatica.y"
{variables_declaradas.add(val_peek(0).sval);}
break;
case 33:
//#line 123 "gramatica.y"
{tipoActual = val_peek(0).sval;}
break;
case 34:
//#line 124 "gramatica.y"
{tipoActual = val_peek(0).sval;}
break;
case 35:
//#line 125 "gramatica.y"
{tipoActual = val_peek(0).sval;}
break;
case 36:
//#line 128 "gramatica.y"
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
case 37:
//#line 142 "gramatica.y"
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
case 38:
//#line 157 "gramatica.y"
{AnalizadorLexico.agregarErrorLexico("Un entero corto no puede ser negativo ");}
break;
case 39:
//#line 158 "gramatica.y"
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
case 40:
//#line 172 "gramatica.y"
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
case 41:
//#line 185 "gramatica.y"
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
case 42:
//#line 199 "gramatica.y"
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
case 43:
//#line 216 "gramatica.y"
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
case 44:
//#line 233 "gramatica.y"
{yyval=val_peek(0);}
break;
case 45:
//#line 234 "gramatica.y"
{yyval = val_peek(0);}
break;
case 46:
//#line 238 "gramatica.y"
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
case 47:
//#line 256 "gramatica.y"
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
case 48:
//#line 272 "gramatica.y"
{yyval = val_peek(0);}
break;
case 49:
//#line 273 "gramatica.y"
{yyval = new NodoComun("*",(Nodo)val_peek(2),(Nodo)val_peek(0));
                               if (!((Nodo)val_peek(2)).getAmbito().equals(((Nodo)val_peek(0)).getAmbito())){
                                    agregarErrorSemantico("Variable fuera de alcance ");
                               }
                                     ((Nodo)yyval).setTipo(tipoPredominante(((Nodo)val_peek(2)).getTipo(),((Nodo)val_peek(0)).getTipo()));
                               }
break;
case 50:
//#line 279 "gramatica.y"
{yyval = new NodoComun("/",(Nodo)val_peek(2),(Nodo)val_peek(0));
                               if (!((Nodo)val_peek(2)).getAmbito().equals(((Nodo)val_peek(0)).getAmbito())){
                                    agregarErrorSemantico("Variable fuera de alcance ");
                               }
                                    ((Nodo)yyval).setTipo(tipoPredominante(((Nodo)val_peek(2)).getTipo(),((Nodo)val_peek(0)).getTipo()));
                               }
break;
case 51:
//#line 285 "gramatica.y"
{yyval=val_peek(0);}
break;
case 52:
//#line 288 "gramatica.y"
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
case 53:
//#line 306 "gramatica.y"
{yyval=val_peek(0);}
break;
case 54:
//#line 310 "gramatica.y"
{yyval=val_peek(0);}
break;
case 55:
//#line 313 "gramatica.y"
{ yyval = new NodoComun(val_peek(2).sval,(Nodo)val_peek(3),(Nodo)val_peek(1));
                                                    ((Nodo)yyval).setTipo(((Nodo)val_peek(3)).getTipo());
                                                    ((Nodo)yyval).setUso("Condicion");
                                                    /*if (!(((Nodo)$2).getTipo().equals(((Nodo)$4).getTipo()))){*/
                                                         /*agregarErrorSemantico("Error en la comparacion entre expresiones de distintos tipos"); //CHEQUEAR CONVERSIONES*/
                                                     /*}*/
                                                     }
break;
case 56:
//#line 320 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba una ')' ");}
break;
case 57:
//#line 321 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba una '(' ");}
break;
case 58:
//#line 324 "gramatica.y"
{  yyval = new NodoComun("CUERPO",(Nodo)val_peek(3),(Nodo)val_peek(1));
                                                        Nodo aux = (Nodo)yyval;
                                                        yyval = new NodoComun("IF",(Nodo)val_peek(4),aux);
                                                        AnalizadorLexico.agregarEstructura("Reconoce IF ELSE");}
break;
case 59:
//#line 328 "gramatica.y"
{yyval = new Nodo("CUERPO",(Nodo)val_peek(1),null);
	                                    Nodo aux = (Nodo)yyval;
	                                    yyval = new NodoComun("IF",(Nodo)val_peek(2),aux);
	                                    AnalizadorLexico.agregarEstructura("Reconoce IF");}
break;
case 60:
//#line 332 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba un END_IF ");}
break;
case 61:
//#line 333 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("IF mal definido ");}
break;
case 62:
//#line 334 "gramatica.y"
{   yyval = new NodoComun("CUERPO",(Nodo)val_peek(4),(Nodo)val_peek(1));
                                                                        Nodo aux = (Nodo)yyval;
                                                                        yyval = new NodoComun("IF",(Nodo)val_peek(5),aux);
                                                                        AnalizadorLexico.agregarEstructura("Reconoce IF ELSE");}
break;
case 63:
//#line 338 "gramatica.y"
{yyval = new NodoComun("CUERPO",(Nodo)val_peek(5),(Nodo)val_peek(2));
                                                                                    Nodo aux = (Nodo)yyval;
                                                                                    yyval = new NodoComun("IF",(Nodo)val_peek(6),aux);
                                                                                    AnalizadorLexico.agregarEstructura("Reconoce IF ELSE");}
break;
case 64:
//#line 342 "gramatica.y"
{   yyval = new NodoComun("CUERPO",(Nodo)val_peek(4),(Nodo)val_peek(2));
                                                                        Nodo aux = (Nodo)yyval;
                                                                        yyval = new NodoComun("IF",(Nodo)val_peek(5),aux);
                                                                        AnalizadorLexico.agregarEstructura("Reconoce IF ELSE");}
break;
case 65:
//#line 346 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba un END_IF ");}
break;
case 66:
//#line 347 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba un END_IF ");}
break;
case 67:
//#line 348 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba un END_IF ");}
break;
case 68:
//#line 349 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba un ELSE ");}
break;
case 69:
//#line 350 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba un ELSE");}
break;
case 70:
//#line 351 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba una ',' ");}
break;
case 71:
//#line 352 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba una ',' " );}
break;
case 72:
//#line 353 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba una ',' ");}
break;
case 73:
//#line 356 "gramatica.y"
{yyval = val_peek(1);}
break;
case 75:
//#line 358 "gramatica.y"
{AnalizadorLexico.addWarning("Las sentencias declaradas luego del RETURN no seran ejecutadas "); }
break;
case 76:
//#line 359 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Falta una ',' "); }
break;
case 77:
//#line 360 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Falta un '{'"); }
break;
case 78:
//#line 361 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Falta un '}'"); }
break;
case 79:
//#line 362 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("No hay sentencias dentro de las llaves."); }
break;
case 80:
//#line 365 "gramatica.y"
{yyval=val_peek(0);}
break;
case 81:
//#line 366 "gramatica.y"
{yyval = new NodoHoja("RETURN");}
break;
case 82:
//#line 367 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Falta una ',' "); }
break;
case 83:
//#line 370 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Solo se aceptan sentencias ejecutables "); }
break;
case 84:
//#line 371 "gramatica.y"
{yyval=val_peek(1);}
break;
case 85:
//#line 372 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Falta una ',' "); }
break;
case 86:
//#line 373 "gramatica.y"
{yyval = new NodoComun("SentenciaIF", (Nodo) val_peek(2), (Nodo) val_peek(1));}
break;
case 87:
//#line 376 "gramatica.y"
{yyval=val_peek(0);}
break;
case 88:
//#line 377 "gramatica.y"
{yyval=val_peek(0);}
break;
case 89:
//#line 378 "gramatica.y"
{yyval=val_peek(0);}
break;
case 90:
//#line 379 "gramatica.y"
{yyval=val_peek(0);}
break;
case 91:
//#line 380 "gramatica.y"
{yyval=val_peek(0);}
break;
case 92:
//#line 381 "gramatica.y"
{yyval=val_peek(0);}
break;
case 95:
//#line 388 "gramatica.y"
{agregarErrorSemantico("RETURN fuera de funcion");}
break;
case 96:
//#line 389 "gramatica.y"
{  ((Nodo)val_peek(6)).setIzq((Nodo)val_peek(5));
                                                                                ((Nodo)val_peek(6)).setDer((Nodo)val_peek(3));
                                                                                deshacerAmbito();
                                                                                AnalizadorLexico.agregarEstructura("Reconoce declaracion de funcion ");}
break;
case 97:
//#line 393 "gramatica.y"
{  ((Nodo)val_peek(4)).setIzq((Nodo)val_peek(3));
                                                                                ((Nodo)val_peek(4)).setDer((Nodo)val_peek(1));
                                                                                deshacerAmbito();
                                                                                AnalizadorLexico.agregarEstructura("Reconoce declaracion de funcion ");}
break;
case 98:
//#line 397 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba un nombre para la funcion ");}
break;
case 99:
//#line 398 "gramatica.y"
{AnalizadorLexico.addWarning("Función sin cuerpo ");
                                            deshacerAmbito();
                                            AnalizadorLexico.agregarEstructura("Reconoce declaracion de funcion ");}
break;
case 100:
//#line 403 "gramatica.y"
{
			      Token t = TablaSimbolos.getToken(val_peek(0).sval);
                              if (t != null){
                                    t.setLexema(val_peek(0).sval + ":" + ambitoAct);
                                    t.setAmbito(ambitoAct);
                                    t.setUso("Funcion");
                                    t.setTipo("VOID");
                                    TablaSimbolos.removeToken(val_peek(0).sval);
                                    TablaSimbolos.addSimbolo(t.getLexema(),t);
                              }
			      Funcion f = new Funcion(val_peek(0).sval + ":" + ambitoAct, null);
			      funciones_declaradas.add(f);
			      actualizarAmbito(val_peek(0).sval);
                              yyval = new NodoComun(val_peek(0).sval,null,null);
                              }
break;
case 101:
//#line 423 "gramatica.y"
{    Token t = TablaSimbolos.getToken(val_peek(1).sval);
                                if (t != null){
                                	t.setLexema(val_peek(1).sval + ":" + ambitoAct);
                                	t.setAmbito(ambitoAct);
                                	t.setUso("Parametro");
                                	t.setTipo(tipoActual);
                                	TablaSimbolos.removeToken(val_peek(1).sval);
                                	TablaSimbolos.addSimbolo(t.getLexema(),t);
                                }
                                funciones_declaradas.get(funciones_declaradas.size() - 1).setTipoParametro(val_peek(2).sval);
                                yyval = new NodoHoja(val_peek(1).sval);
                           }
break;
case 102:
//#line 435 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba un ')' ");}
break;
case 103:
//#line 436 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba un '(' ");}
break;
case 104:
//#line 437 "gramatica.y"
{yyval = null;}
break;
case 105:
//#line 438 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba un ')' ");}
break;
case 106:
//#line 439 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba un '(' ");}
break;
case 107:
//#line 445 "gramatica.y"
{yyval = new NodoComun("Sentencia",(Nodo)val_peek(2),(Nodo)val_peek(1));}
break;
case 108:
//#line 446 "gramatica.y"
{yyval=val_peek(1);}
break;
case 109:
//#line 447 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba una ',' al final de la linea ");}
break;
case 110:
//#line 448 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba una ',' al final de la linea ");}
break;
case 111:
//#line 449 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba una ',' al final de la linea ");}
break;
case 112:
//#line 452 "gramatica.y"
{yyval=new NodoHoja(val_peek(2).sval);
                            Token tokenFuncion = TablaSimbolos.buscarPorAmbito(val_peek(2).sval + ":" + ambitoAct);
                            Funcion funcion = new Funcion(tokenFuncion.getLexema(), null);
                            if (tokenFuncion == null){
                                agregarErrorSemantico("La funcion " + val_peek(3).sval + " nunca fue declarada");
                            } else {
                                if (funciones_declaradas.contains(funcion)) {
                                    int indice = funciones_declaradas.indexOf(funcion);
                                    Funcion f = funciones_declaradas.get(indice);
                                    if (f.getTipoParametro() != null){
                                        agregarErrorSemantico("Se esperaba un parametro en la función ");
                                    }
                                }
                            }
				            AnalizadorLexico.agregarEstructura("Reconoce llamado funcion ");
				            TablaSimbolos.removeToken(val_peek(2).sval);
				            }
break;
case 113:
//#line 469 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba un '(' ");}
break;
case 114:
//#line 470 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba un ')' ");}
break;
case 115:
//#line 471 "gramatica.y"
{
            			    NodoHoja nodo1 = new NodoHoja(val_peek(3).sval);
            			    yyval=new NodoComun("Llamado Funcion", nodo1, (Nodo)val_peek(1));
                                    Token tokenFuncion = TablaSimbolos.buscarPorAmbito(val_peek(3).sval + ":" + ambitoAct);

                                    Funcion funcion = new Funcion(tokenFuncion.getLexema(), null);
                                    if (tokenFuncion == null){
                                    	agregarErrorSemantico("La funcion " + val_peek(3).sval + " nunca fue declarada");
                                    } else {
                                    	if (funciones_declaradas.contains(funcion)) {
                                            int indice = funciones_declaradas.indexOf(funcion);
                                            Funcion f = funciones_declaradas.get(indice);
                                            if (!f.getTipoParametro().equals(((Nodo)val_peek(1)).getTipo()) && (((Nodo)val_peek(1)).getTipo() != null)){
                                                agregarErrorSemantico("No coinciden los tipos del parametro real y el formal. Se esperaba un " + f.getTipoParametro() + ", se obtuvo un " + ((Nodo)val_peek(1)).getTipo());
                                            }
                                        }
                                    }
                                    AnalizadorLexico.agregarEstructura("Reconoce llamado funcion ");
                                    TablaSimbolos.removeToken(val_peek(3).sval);
                                    }
break;
case 116:
//#line 493 "gramatica.y"
{yyval = new NodoControl("PRINT", new NodoHoja(val_peek(0).sval));
                             AnalizadorLexico.agregarEstructura("Reconoce salida de mensaje por pantalla ");}
break;
case 117:
//#line 495 "gramatica.y"
{yyval = new NodoControl("PRINT", new NodoHoja(val_peek(0).sval));
                            AnalizadorLexico.agregarEstructura("Reconoce salida de mensaje por pantalla ");}
break;
case 118:
//#line 497 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("La funcion PRINT no acepta esa declaracion ");}
break;
case 119:
//#line 500 "gramatica.y"
{yyval=val_peek(0);}
break;
case 120:
//#line 501 "gramatica.y"
{yyval=val_peek(0);}
break;
case 121:
//#line 504 "gramatica.y"
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
case 122:
//#line 526 "gramatica.y"
{AnalizadorLexico.agregarEstructura("Reconoce asignacion ");
	                                                        yyval = new NodoComun(val_peek(1).sval,(Nodo)val_peek(2),(Nodo)val_peek(0));}
break;
case 123:
//#line 529 "gramatica.y"
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
case 124:
//#line 547 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba un valor seguido del operador ");}
break;
case 125:
//#line 548 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba un valor seguido del operador ");}
break;
case 126:
//#line 549 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba un operando del lado izquierdo ");}
break;
case 127:
//#line 552 "gramatica.y"
{yyval=new NodoComun("DO UNTIL", (Nodo)val_peek(2) ,(Nodo)val_peek(0));
                                                        AnalizadorLexico.agregarEstructura("Reconoce funcion DO UNTIL");}
break;
case 128:
//#line 554 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba una condicion ");}
break;
case 129:
//#line 560 "gramatica.y"
{yyval = val_peek(1);}
break;
case 130:
//#line 561 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba un '(' ");}
break;
case 131:
//#line 562 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba un ')' ");}
break;
case 132:
//#line 565 "gramatica.y"
{yyval = new NodoControl("TOD",(Nodo)val_peek(0));
                                            AnalizadorLexico.agregarEstructura("Reconoce funcion TOD ");
                                            }
break;
case 133:
//#line 569 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba una Expresion ");}
break;
case 135:
//#line 576 "gramatica.y"
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
//#line 597 "gramatica.y"
{deshacerAmbito();}
break;
case 137:
//#line 600 "gramatica.y"
{AnalizadorLexico.agregarEstructura("Reconoce Funcion sin cuerpo");}
break;
case 138:
//#line 604 "gramatica.y"
{AnalizadorLexico.agregarEstructura("Reconoce funcion IMPL"); TablaSimbolos.removeToken(val_peek(4).sval);}
break;
case 139:
//#line 605 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba un '{' ");}
break;
case 140:
//#line 606 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba un '}' ");}
break;
//#line 1778 "Parser.java"
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
