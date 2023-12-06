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
package a.AnalisisLexico;
import a.AnalisisLexico.ParserVal;
import b.GeneracionCodigoIntermedio.*;
import a.AnalisisLexico.AccionesSemanticas.AccionSemantica;
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
    7,    5,    5,    5,    5,    5,   12,   12,   12,   12,
    4,    4,    4,    4,    4,    4,    4,    4,   14,   14,
   17,   20,   20,   13,   13,   13,   21,   21,   21,   21,
   21,   21,   22,   22,   22,   22,   23,   23,   23,   23,
   23,   23,   25,   25,   26,   27,   27,   27,   10,   10,
   10,   10,   10,   10,   10,   10,   10,   10,   10,   10,
   10,   10,   10,   10,   29,   29,   29,   29,   29,   29,
   30,   31,   31,   31,   31,   28,   28,   28,   28,   28,
   28,   15,   15,   32,   32,   32,   32,   34,   35,   35,
   35,   35,   35,   35,   36,   36,   36,   36,   36,    8,
    8,    8,    8,   11,   11,   11,   37,   37,    9,    9,
    9,    9,    9,    9,    3,    3,    3,    3,    3,    3,
   38,   38,   38,   24,   24,   39,   19,   16,   33,   40,
   18,   18,   18,
};
final static short yylen[] = {                            2,
    3,    3,    3,    2,    2,    1,    1,    1,    2,    3,
    3,    1,    1,    1,    1,    1,    3,    2,    2,    3,
    2,    1,    2,    2,    1,    1,    1,    1,    1,    3,
    2,    1,    3,    1,    1,    1,    1,    1,    2,    1,
    2,    2,    3,    3,    1,    1,    3,    3,    1,    3,
    3,    1,    1,    1,    1,    5,    5,    5,    6,    4,
    5,    7,    8,    7,    4,    6,    7,    7,    7,    7,
    7,    7,    7,    5,    3,    5,    5,    3,    3,    2,
    1,    1,    2,    2,    3,    1,    1,    1,    1,    1,
    1,    1,    1,    7,    7,    5,    6,    2,    4,    4,
    4,    2,    2,    2,    3,    2,    2,    2,    2,    3,
    3,    3,    4,    2,    2,    2,    1,    1,    3,    3,
    3,    3,    3,    2,    4,    4,    5,    5,    4,    4,
    3,    3,    3,    2,    3,    3,    2,    2,    2,    4,
    4,    3,    3,
};
final static short yydefred[] = {                         0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
   35,   34,   36,    0,  118,    0,   37,   38,   40,    0,
    0,  117,    0,    0,    6,    7,    8,    0,   16,   13,
   12,   14,   15,    0,   22,   25,   26,   27,    0,   54,
    0,   92,   93,    0,    0,    0,    0,   29,    0,    0,
    0,    0,    0,    0,  116,   53,  114,  115,  137,    0,
   98,    0,    0,    0,    0,    0,    0,    0,   32,    0,
    0,    0,    9,    0,   41,   39,   42,    2,    0,    5,
    4,    0,   24,    0,    0,  138,    0,    0,    0,    0,
  124,    0,    1,    0,  142,    0,    0,    0,   55,    0,
    0,   46,   49,   52,    0,    0,    0,    0,    0,   82,
    0,    0,    0,    0,   80,    0,    0,    0,    0,    0,
  111,    0,   11,  112,  110,    0,    0,  143,    3,  122,
  120,  121,    0,    0,    0,    0,  123,    0,  104,    0,
  103,  102,    0,    0,    0,   30,    0,    0,    0,  134,
   90,   91,   89,   88,    0,    0,   86,   87,    0,    0,
    0,    0,    0,    0,   65,    0,   60,    0,  129,   84,
   83,   78,    0,   79,    0,   75,  130,    0,    0,  125,
  140,  113,   33,   19,   18,    0,  136,    0,    0,    0,
    0,    0,    0,    0,    0,  141,   10,    0,  135,    0,
    0,    0,    0,   47,   50,   48,   51,    0,    0,   74,
    0,    0,   61,    0,    0,    0,   85,    0,    0,    0,
  127,   20,   17,  101,  100,   99,  109,  106,  108,  107,
    0,    0,    0,  132,  133,  131,   58,   57,   56,    0,
    0,    0,    0,    0,    0,    0,   66,   59,   97,   77,
   76,    0,    0,  105,   72,   71,   70,   68,    0,   67,
   62,   73,   69,   64,   95,   94,   63,
};
final static short yydgoto[] = {                          3,
   23,   24,   25,   26,   27,   28,   29,   30,   31,   32,
   33,  136,   34,   49,   35,   36,   37,   38,   39,   72,
   40,  100,  101,  102,   41,  104,   54,  159,   66,  113,
  114,   42,   43,   44,   90,  195,   45,  150,   86,   46,
};
final static short yysindex[] = {                      -111,
   89,   89,    0, -241,  -37,  181, -218, -230,  143, -223,
    0,    0,    0,  -39,    0,   50,    0,    0,    0, -166,
 -216,    0,  -11,    9,    0,    0,    0,  -13,    0,    0,
    0,    0,    0, -227,    0,    0,    0,    0,  -17,    0,
  -13,    0,    0,  -29,   93,  -10,   14,    0,   62,    2,
  -29,  187,  187,  150,    0,    0,    0,    0,    0,  -29,
    0,  175,  -32,  315,  -42, -129, -128,   99,    0, -127,
  -41,   84,    0, -112,    0,    0,    0,    0,  102,    0,
    0,  214,    0,   62,  362,    0,  135,   44,  212,   26,
    0, -166,    0, -117,    0,   26,  108,  -27,    0,  488,
   19,    0,    0,    0,  488,  217,   16, -189,   33,    0,
  -37,   30,   36,  242,    0, -109,  -37, -107,  -25,   97,
    0,  -22,    0,    0,    0,   47, -110,    0,    0,    0,
    0,    0, -104,  114,  116,  346,    0,    1,    0, -101,
    0,    0, -100,  118,   45,    0,  -98,  187,  -36,    0,
    0,    0,    0,    0,  147,  147,    0,    0,  187,  147,
  147,  187, -234, -176,    0,  150,    0,  118,    0,    0,
    0,    0,  128,    0,   34,    0,    0,   -9,  187,    0,
    0,    0,    0,    0,    0,  129,    0,  134,  140,  -31,
   35,  138,  -73,  -72,   39,    0,    0,   48,    0,   -8,
   19,   19,   85,    0,    0,    0,    0,    4, -103,    0,
  150,  150,    0,   42, -161,   64,    0,   61,   65,  187,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
  141,  -84,  149,    0,    0,    0,    0,    0,    0,  -65,
  -62,  -61,   53, -139,  -60, -123,    0,    0,    0,    0,
    0,   71,  156,    0,    0,    0,    0,    0,  -58,    0,
    0,    0,    0,    0,    0,    0,    0,
};
final static short yyrindex[] = {                         0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,   10,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,   59,    0,
    0,    0,    0,    0,    0,    0,    0,    0,   60,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,   10,    0,    0,    0,    0,    0,    0,    0,
    0,   66,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,   67,    0,    0,    0,    0,    0,   72,
    0,    0,    0,    0,    0,    0,  463,    0,    0,    0,
  402,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0, -108,    0,    0,    0,    0,    0,    0,
    0,   11,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,  177,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,   78,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,  159,  161,    0,    0,    0,    0,    0,    0,
  483,  493,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,   79,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,  -38,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,  162,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,
};
final static short yygindex[] = {                         0,
  205,    7,    0,  -63,  526,  627,    0,  139,    0,    0,
    0,    0,  -12,  174,    0,    0,    0,    0,    0,    0,
    0,  -30,  -54,    0,  551,  -53,  -79,  105,  -35,  152,
    0,   23,    0,   32,    5,   46,   27,    0,    0,    0,
};
final static int YYTABLESIZE=847;
static short yytable[];
static { yytable();}
static void yytable(){
yytable = new short[]{                        125,
   71,  118,   53,   21,  199,   96,   70,   71,   21,  226,
   89,    2,  149,   70,   53,  176,   81,   71,  108,   64,
    8,  135,  105,  209,  210,   60,   50,   48,   83,   79,
   53,  169,  236,   21,  156,   51,  155,  177,   61,  180,
  126,   48,   74,  156,  239,  155,  156,   22,  155,   22,
   59,   51,   81,   79,   82,   96,  138,   67,   21,  164,
  160,   75,   76,   77,  109,  161,  165,   87,  166,  167,
   53,   10,  188,  171,   22,  140,  143,  219,   73,  211,
  193,  212,  213,   21,  139,  246,   96,  182,  234,  156,
  156,  155,  155,   73,  247,    8,  259,  248,  221,   22,
  201,  202,   28,   23,  193,   85,  205,  207,   21,   31,
   21,   20,   92,   78,  145,  139,  260,  198,  200,  261,
   94,  126,  128,   51,   22,  237,   95,  156,  203,  155,
  215,  208,  263,   21,  119,  264,   20,   21,   93,  121,
  120,  122,  127,  128,    1,  129,  174,   81,  144,   22,
  192,  146,  106,  147,  181,  168,  178,  184,  183,  185,
  172,   20,   21,  232,   69,  175,   81,  189,  190,  196,
  197,  217,  222,  240,  192,  242,  244,  223,   22,   21,
  224,  228,  229,  230,  252,  250,   20,   21,  249,  251,
  253,   21,  254,  255,   21,  265,  256,  257,  262,  266,
  267,  233,    7,   22,    8,    9,   47,   84,  123,  162,
   22,   20,    0,  216,  124,  116,   68,   96,   52,   21,
  119,  117,  233,   68,  225,   21,   88,   97,  148,   69,
  179,   21,   97,   68,   98,   22,   17,   18,   19,   98,
   20,   17,   18,   19,    4,    5,  220,  235,    6,    7,
    8,    9,  142,   10,   11,   12,   13,   14,   21,  238,
   15,   21,   15,   16,   80,   64,   17,   18,   19,    4,
    5,  163,   64,    6,    7,    8,    9,   22,   10,   11,
   12,   13,   14,   53,   10,  170,   21,   15,   16,  218,
  227,   17,   18,   19,    4,    5,    0,  245,    6,    7,
    8,    9,   22,   10,   11,   12,   13,   14,  258,   11,
   12,   13,   15,  231,   28,   23,   17,   18,   19,    4,
    5,   31,   21,    6,    7,    8,    9,  139,   10,   11,
   12,   13,   14,  126,  128,    0,    0,   15,   16,    0,
    0,   17,   18,   19,    4,    5,    0,    0,    6,    7,
    8,    9,    0,   10,   11,   12,   13,   14,    0,   21,
    0,   56,   15,   16,    0,    0,   17,   18,   19,    0,
   17,   18,   19,    4,    5,   22,    0,    6,    7,    8,
    9,    0,   10,   11,   12,   13,   14,    0,    0,    0,
  137,   15,  191,    0,    0,   17,   18,   19,   62,    5,
    0,    0,    6,   97,    0,  106,    5,    0,    0,    6,
   98,   63,   17,   18,   19,   97,   15,    0,   63,    0,
   17,   18,   19,   15,   17,   18,   19,   17,   18,   19,
  110,    5,  119,    0,    6,  119,   55,    0,  111,  115,
  119,    0,   45,   63,   45,   45,   45,    0,   15,   56,
    0,    0,   17,   18,   19,   97,    0,   57,   17,   18,
   19,   45,   98,   45,   17,   18,   19,  141,   20,  130,
  187,    0,  110,    5,    0,    0,    6,   11,   12,   13,
    0,    0,   97,    0,   20,   63,    0,    0,    0,    0,
   15,   17,   18,   19,   17,   18,   19,    0,    5,    0,
    0,    6,    0,   53,   53,   53,   53,   53,    0,   53,
   63,    0,    0,    0,    0,   15,    0,    0,    0,   17,
   18,   19,   53,   44,   53,   44,   44,   44,    0,    0,
  156,    0,  155,   43,   65,   43,   43,   43,    0,    0,
    0,    0,   44,    0,   44,    0,    0,  157,    0,  158,
    0,    0,   43,    0,   43,    0,   58,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
  110,    5,    0,    0,    6,    0,    0,    0,    0,  107,
    0,    0,    0,   63,    0,    0,    0,  112,   15,  112,
    0,    0,   17,   18,   19,   91,    0,    0,    0,    0,
    0,    4,  103,  103,    0,    0,    7,    8,    0,    0,
   10,   11,   12,   13,  133,    0,    0,    4,    0,    0,
  186,  103,    7,    8,    0,    0,   10,   11,   12,   13,
  133,  112,  132,    0,    0,    0,  134,  103,    0,  173,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,   45,    0,    0,
   45,    0,    0,    0,    0,   45,    0,    0,    0,  194,
    0,   45,   45,   45,   45,    0,    0,    0,   99,   99,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,  214,    0,  194,    0,    0,    0,   99,  103,  103,
    0,    0,    0,    0,    0,  103,  103,    0,  131,  103,
  204,  206,  103,   99,    0,    0,    0,    0,   53,    0,
    0,   53,    0,    0,    0,    0,   53,    0,    0,  103,
    0,    0,   53,   53,   53,   53,  241,  243,   44,    0,
    0,   44,    0,    0,    0,    0,   44,    0,   43,    0,
    0,   43,   44,   44,   44,   44,   43,  151,  152,  153,
  154,    0,   43,   43,   43,   43,    0,    0,    0,    0,
  103,    0,    0,    0,   99,   99,    0,    0,    0,    0,
    0,   99,   99,    0,    0,   99,   99,   99,   99,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,   99,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,   99,
};
}
static short yycheck[];
static { yycheck(); }
static void yycheck() {
yycheck = new short[] {                         41,
   40,   44,   40,   45,   41,   44,   46,   40,   45,   41,
   40,  123,   40,   46,   40,  125,  125,   40,   54,  123,
  262,   85,   53,  258,  259,  256,    4,  269,  256,   23,
   40,  111,   41,   45,   43,    4,   45,  117,  269,  119,
   71,  269,   20,   43,   41,   45,   43,   61,   45,   61,
  269,   20,   44,   47,   28,   51,   87,  281,   45,   44,
   42,  278,  279,  280,   60,   47,  256,   41,  258,  259,
   61,   61,  136,   44,   61,   88,   89,   44,   44,  256,
  144,  258,  259,   45,   41,   44,  125,   41,   41,   43,
   43,   45,   45,   44,  256,  262,   44,  259,  178,   61,
  155,  156,   44,   44,  168,  123,  160,  161,   45,   44,
   44,  123,  123,  125,   92,   44,  256,  148,  149,  259,
   59,   44,   44,   92,   61,   41,  125,   43,  159,   45,
  166,  162,  256,   45,  264,  259,  123,   45,  125,   41,
  269,  269,   59,  256,  256,   44,  256,  256,  123,   61,
  144,  269,  256,   46,   58,  123,  264,   44,  269,   44,
  125,  123,   45,  125,  269,  275,  275,  269,  269,  125,
  269,   44,   44,  209,  168,  211,  212,   44,   61,   45,
   41,   44,  256,  256,   44,  125,  123,   45,  125,  125,
  275,   45,   44,  259,   45,  125,  259,  259,  259,   44,
  259,  195,   44,   61,   44,   44,    2,   34,   70,  105,
   61,  123,   -1,  168,  256,   64,  256,  256,  256,   45,
   44,  264,  216,  256,  256,   45,  256,  269,  256,  269,
  256,   45,  269,  256,  276,   61,  278,  279,  280,  276,
  123,  278,  279,  280,  256,  257,  256,  256,  260,  261,
  262,  263,   41,  265,  266,  267,  268,  269,   45,  256,
  274,   45,  274,  275,  256,  123,  278,  279,  280,  256,
  257,  256,  123,  260,  261,  262,  263,   61,  265,  266,
  267,  268,  269,  274,  274,  256,   45,  274,  275,  256,
  256,  278,  279,  280,  256,  257,   -1,  256,  260,  261,
  262,  263,   61,  265,  266,  267,  268,  269,  256,  266,
  267,  268,  274,  275,  256,  256,  278,  279,  280,  256,
  257,  256,  256,  260,  261,  262,  263,  256,  265,  266,
  267,  268,  269,  256,  256,   -1,   -1,  274,  275,   -1,
   -1,  278,  279,  280,  256,  257,   -1,   -1,  260,  261,
  262,  263,   -1,  265,  266,  267,  268,  269,   -1,   45,
   -1,  269,  274,  275,   -1,   -1,  278,  279,  280,   -1,
  278,  279,  280,  256,  257,   61,   -1,  260,  261,  262,
  263,   -1,  265,  266,  267,  268,  269,   -1,   -1,   -1,
  256,  274,  275,   -1,   -1,  278,  279,  280,  256,  257,
   -1,   -1,  260,  269,   -1,  256,  257,   -1,   -1,  260,
  276,  269,  278,  279,  280,  269,  274,   -1,  269,   -1,
  278,  279,  280,  274,  278,  279,  280,  278,  279,  280,
  256,  257,  256,   -1,  260,  259,  256,   -1,  264,  125,
  264,   -1,   41,  269,   43,   44,   45,   -1,  274,  269,
   -1,   -1,  278,  279,  280,  269,   -1,  277,  278,  279,
  280,   60,  276,   62,  278,  279,  280,  256,  123,  256,
  125,   -1,  256,  257,   -1,   -1,  260,  266,  267,  268,
   -1,   -1,  269,   -1,  123,  269,   -1,   -1,   -1,   -1,
  274,  278,  279,  280,  278,  279,  280,   -1,  257,   -1,
   -1,  260,   -1,   41,   42,   43,   44,   45,   -1,   47,
  269,   -1,   -1,   -1,   -1,  274,   -1,   -1,   -1,  278,
  279,  280,   60,   41,   62,   43,   44,   45,   -1,   -1,
   43,   -1,   45,   41,    9,   43,   44,   45,   -1,   -1,
   -1,   -1,   60,   -1,   62,   -1,   -1,   60,   -1,   62,
   -1,   -1,   60,   -1,   62,   -1,    6,   -1,   -1,   -1,
   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,
  256,  257,   -1,   -1,  260,   -1,   -1,   -1,   -1,   54,
   -1,   -1,   -1,  269,   -1,   -1,   -1,   62,  274,   64,
   -1,   -1,  278,  279,  280,   45,   -1,   -1,   -1,   -1,
   -1,  256,   52,   53,   -1,   -1,  261,  262,   -1,   -1,
  265,  266,  267,  268,  269,   -1,   -1,  256,   -1,   -1,
  275,   71,  261,  262,   -1,   -1,  265,  266,  267,  268,
  269,  106,   82,   -1,   -1,   -1,  275,   87,   -1,  114,
   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,
   -1,   -1,   -1,   -1,   -1,   -1,   -1,  256,   -1,   -1,
  259,   -1,   -1,   -1,   -1,  264,   -1,   -1,   -1,  144,
   -1,  270,  271,  272,  273,   -1,   -1,   -1,   52,   53,
   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,
   -1,  166,   -1,  168,   -1,   -1,   -1,   71,  148,  149,
   -1,   -1,   -1,   -1,   -1,  155,  156,   -1,   82,  159,
  160,  161,  162,   87,   -1,   -1,   -1,   -1,  256,   -1,
   -1,  259,   -1,   -1,   -1,   -1,  264,   -1,   -1,  179,
   -1,   -1,  270,  271,  272,  273,  211,  212,  256,   -1,
   -1,  259,   -1,   -1,   -1,   -1,  264,   -1,  256,   -1,
   -1,  259,  270,  271,  272,  273,  264,  270,  271,  272,
  273,   -1,  270,  271,  272,  273,   -1,   -1,   -1,   -1,
  220,   -1,   -1,   -1,  148,  149,   -1,   -1,   -1,   -1,
   -1,  155,  156,   -1,   -1,  159,  160,  161,  162,   -1,
   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,
   -1,   -1,   -1,   -1,   -1,  179,   -1,   -1,   -1,   -1,
   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,
   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,
   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,
   -1,   -1,   -1,   -1,   -1,   -1,  220,
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
"Sentencia : SentenciaDeclarativa",
"Sentencia : SentenciaEjecutable",
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
"SentenciaDeclarativa : EncabezadoClase",
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
"BloqueIF : IF Condicion SentenciaEjecutable ',' END_IF",
"BloqueIF : IF Condicion SentenciaEjecutable ',' ELSE CuerpoIF END_IF",
"BloqueIF : IF Condicion SentenciaEjecutable ',' ELSE SentenciaEjecutable ',' END_IF",
"BloqueIF : IF Condicion CuerpoIF ELSE SentenciaEjecutable ',' END_IF",
"BloqueIF : IF Condicion CuerpoIF error",
"BloqueIF : IF Condicion CuerpoIF ELSE CuerpoIF error",
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
"Funcion : EncabezadoFuncion Parametro '{' ListSentenciasFuncion '}' RETURN ','",
"Funcion : EncabezadoFuncion Parametro '{' ListSentenciasFuncion RETURN ',' '}'",
"Funcion : EncabezadoFuncion Parametro '{' ListSentenciasFuncion '}'",
"Funcion : VOID error Parametro '{' ListSentenciasFuncion '}'",
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
"SentenciaControl : DO SentenciaEjecutable ',' UNTIL Condicion",
"SentenciaControl : DO SentenciaEjecutable ',' UNTIL error",
"SentenciaControl : DO error UNTIL Condicion",
"SentenciaControl : DO SentenciaEjecutable UNTIL Condicion",
"ParametroTOD : '(' Expresion ')'",
"ParametroTOD : error Expresion ')'",
"ParametroTOD : '(' Expresion error",
"ConversionExplicita : TOD ParametroTOD",
"ConversionExplicita : TOD '(' ')'",
"ListClase : '{' ListSentenciasClase '}'",
"EncabezadoClase : CLASS ID",
"Clase : EncabezadoClase ListClase",
"FuncionSinCuerpo : EncabezadoFuncion Parametro",
"EncabezadoIMPL : IMPL FOR ID ':'",
"FuncionIMPL : EncabezadoIMPL '{' Funcion '}'",
"FuncionIMPL : error Funcion '}'",
"FuncionIMPL : '{' Funcion error",
};

//#line 580 "gramatica.y"
  public NodoControl raiz;
  private String ambitoAct = "main";
  private String claseAct;
  private String ambitoNuevo= "";
  private String nameFunctionSinCuerpo;
  static ArrayList<Error> erroresSemanticos = new ArrayList<Error>();
  static ArrayList<String> variables_declaradas = new ArrayList<String>();
  static String tipoActual;
  static ArrayList<Nodo> parametros = new ArrayList<Nodo>();
  static ArrayList<String> clases_forward_declaration = new ArrayList<String>();
  static ArrayList<String> clases_declaradas = new ArrayList<String>();
  static ArrayList<Funcion> funciones_declaradas = new ArrayList<Funcion>();
  static ArrayList<Nodo> funciones = new ArrayList<Nodo>();

  public NodoControl getRaiz(){
  	return this.raiz;
  }

  public List<Nodo> getFunciones(){
        return funciones;
  }

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

    NodoComun controlarTipos(Nodo n1, String op, Nodo n3 ){ 
        NodoComun aux = null;
        if ((n1 == null) || (n3==null)) {
            agregarErrorSemantico("Incompatibilidad de tipos ");
            return null;
        }
        if (n1.getTipo().equals(n3.getTipo()))
        {
                aux = new NodoComun(op,n1,n3);
                aux.setTipo(n1.getTipo());

        }
        else 
        {
                if ((n1.getTipo().equals("USHORT") || n1.getTipo().equals("INT")) && (n3.getTipo().equals("USHORT")|| n3.getTipo().equals("INT")))
                {
                        agregarErrorSemantico("Incompatibilidad de tipos ");
                        return null;
                }
        }
        return aux;        
}

public Nodo getNodoParametro(String m){
    for (Nodo n : parametros){
        if (n.getLexema().contains(m)){
            return n;
        }
    }
    return null;
}

NodoComun controlarTiposAsignacion(Nodo n1, String asig, Nodo n3)
{ 
        NodoComun aux = null;
                if ((n1 == null) || (n3==null)) {
                          return null;
                }
                if (n1.getTipo()==null){
                    n1 = getNodoParametro(n1.getLexema());
                }

                if (!((n1==null)||(n3==null))) {
                  if (n1.getTipo().equals(n3.getTipo())) {
                    aux = new NodoComun(asig, n1, n3);
                    aux.setTipo(n1.getTipo());

                  } else {
                    if (n1.getTipo().equals("USHORT") || n1.getTipo().equals("INT")) {
                      agregarErrorSemantico("Incompatibilidad de tipos ");
                      return null;
                    }
                  }
                }else{
                        return null;}
                  return aux;
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
//#line 836 "Parser.java"
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
{ for (String c : clases_forward_declaration){
                                        if (!(clases_declaradas.contains(c))){
                                            agregarErrorSemantico("La clase "+c+" fue declarada, pero no fue implementada");
                                        }
                                    }
                                    raiz = new NodoControl("PROGRAMA", (Nodo)val_peek(1).obj);
                                    AnalizadorLexico.agregarEstructura("Reconoce programa ");}
break;
case 2:
//#line 25 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se espera '{' ");}
break;
case 3:
//#line 28 "gramatica.y"
{yyval.obj = new NodoComun("SENTENCIA", (Nodo) val_peek(2).obj, (Nodo) val_peek(1).obj);}
break;
case 4:
//#line 29 "gramatica.y"
{yyval.obj=val_peek(1).obj;}
break;
case 5:
//#line 30 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba una ',' ");}
break;
case 6:
//#line 33 "gramatica.y"
{yyval.obj=val_peek(0).obj;}
break;
case 7:
//#line 34 "gramatica.y"
{yyval.obj=val_peek(0).obj;}
break;
case 8:
//#line 35 "gramatica.y"
{yyval.obj=val_peek(0).obj;}
break;
case 9:
//#line 36 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("RETURN definido fuera de funcion ");}
break;
case 10:
//#line 39 "gramatica.y"
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
//#line 58 "gramatica.y"
{ if ((TablaSimbolos.getToken(val_peek(2).sval +":"+ambitoAct))==null)
                                                    agregarErrorSemantico("Atributo de clase " + val_peek(2).sval + " no existe ");
                                                else{
                                                    yyval.obj = new NodoComun("ReferenciaFuncionObjeto",(Nodo)val_peek(2).obj,(Nodo)val_peek(0).obj);
                                                    AnalizadorLexico.agregarEstructura("Reconoce llamado a funcion de clase ");
                                                }
                                                TablaSimbolos.removeToken(val_peek(2).sval);
                                                }
break;
case 12:
//#line 68 "gramatica.y"
{yyval.obj=val_peek(0).obj;}
break;
case 13:
//#line 69 "gramatica.y"
{yyval.obj=val_peek(0).obj;}
break;
case 14:
//#line 70 "gramatica.y"
{yyval.obj=val_peek(0).obj;}
break;
case 15:
//#line 71 "gramatica.y"
{yyval.obj=val_peek(0).obj;}
break;
case 16:
//#line 72 "gramatica.y"
{yyval.obj=val_peek(0).obj;}
break;
case 19:
//#line 77 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("RETURN definido fuera de funcion ");}
break;
case 20:
//#line 78 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("RETURN definido fuera de funcion ");}
break;
case 21:
//#line 81 "gramatica.y"
{
						/*CHEQUAER SI UNA VARIABLE CON ESE LEXEMA YA TIENE SETEADO EL USO, SI LO TIENE SETEADO ES PORQ YA EXITE*/
						for (String var : variables_declaradas) {
							Token t = TablaSimbolos.getToken(var);
							if (!(TablaSimbolos.existeSimbolo(var+ ":" + ambitoAct))){
							    t.setLexema(var + ":" + ambitoAct);
							    t.setAmbito(ambitoAct);
							    t.setUso("Variable");
							    t.setTipo(tipoActual);
							    TablaSimbolos.removeToken(var);
							    TablaSimbolos.addSimbolo(t.getLexema(),t);
                            }
							else {
							    TablaSimbolos.removeToken(var);
							   agregarErrorSemantico("Ya existe una variable " + var +" definida en este ambito");
                                                	}
                                            	}
                                            	variables_declaradas.clear();
                        }
break;
case 23:
//#line 101 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se espera el tipo de la variable ");}
break;
case 24:
//#line 102 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se espera identificador de la variable ");}
break;
case 28:
//#line 106 "gramatica.y"
{deshacerAmbito();}
break;
case 29:
//#line 109 "gramatica.y"
{variables_declaradas.add(val_peek(0).sval);}
break;
case 30:
//#line 110 "gramatica.y"
{variables_declaradas.add(val_peek(0).sval);}
break;
case 31:
//#line 113 "gramatica.y"
{TablaSimbolos.removeToken(val_peek(1).sval);
                                   if (clases_declaradas.contains(val_peek(1).sval + ":" + ambitoAct)){
                                        for (String var : variables_declaradas) {
                                        Token t = TablaSimbolos.getToken(var);
                                        if (!(TablaSimbolos.existeSimbolo(var+ ":" + ambitoAct))){
                                            t.setLexema(var + ":" + ambitoAct);
                                            t.setAmbito(ambitoAct);
                                            t.setUso("Objeto");
                                            t.setTipo(val_peek(1).sval);
                                            TablaSimbolos.removeToken(var);
                                            TablaSimbolos.addSimbolo(t.getLexema(),t);
                                        }
                                        else {
                                            agregarErrorSemantico("Ya existe un objeto + var + definido en este ambito ");
                                        }
                                        }
                                        variables_declaradas.clear();
                                   }else{agregarErrorSemantico("La clase "+ val_peek(1).sval +" no esta definida ");}
                                   }
break;
case 32:
//#line 134 "gramatica.y"
{variables_declaradas.add(val_peek(0).sval);}
break;
case 33:
//#line 135 "gramatica.y"
{variables_declaradas.add(val_peek(0).sval);}
break;
case 34:
//#line 137 "gramatica.y"
{tipoActual = val_peek(0).sval;}
break;
case 35:
//#line 138 "gramatica.y"
{tipoActual = val_peek(0).sval;}
break;
case 36:
//#line 139 "gramatica.y"
{tipoActual = val_peek(0).sval;}
break;
case 37:
//#line 142 "gramatica.y"
{
                    chequearEnteroPositivo(val_peek(0).sval);
                    NodoHoja aux = new NodoHoja(val_peek(0).sval);
                    aux.setTipo("INT");
                    aux.setUso("Constante");
                    aux.setAmbito(ambitoAct);
                    yyval.obj = aux;
                    Token t = TablaSimbolos.getToken(val_peek(0).sval);
                    if (!(t==null)){
                        t.setTipo("INT");
                        t.setUso("Constante");
                        t.setAmbito(ambitoAct);
                        TablaSimbolos.removeToken(val_peek(0).sval);
                        TablaSimbolos.addSimbolo(val_peek(0).sval,t);
                    }
                   }
break;
case 38:
//#line 159 "gramatica.y"
{NodoHoja aux = new NodoHoja(val_peek(0).sval);
	               chequearEnteroCorto(val_peek(0).sval);
	               aux.setTipo("USHORT");
                   aux.setUso("Constante");
                   aux.setAmbito(ambitoAct);
                   yyval.obj = aux;
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
case 39:
//#line 174 "gramatica.y"
{AnalizadorLexico.agregarErrorLexico("Un entero corto no puede ser negativo ");}
break;
case 40:
//#line 175 "gramatica.y"
{
	                chequearDouble(val_peek(0).sval);
	                NodoHoja aux = new NodoHoja(val_peek(0).sval);
                    aux.setTipo("DOUBLE");
                    aux.setUso("Constante");
                    aux.setAmbito(ambitoAct);
                    yyval.obj = aux;
                    Token t = TablaSimbolos.getToken(val_peek(0).sval);
                    if (!(t==null)){
                        t.setTipo("DOUBLE");
                        t.setUso("Constante");
                        t.setAmbito(ambitoAct);
                        TablaSimbolos.removeToken(val_peek(0).sval);
                        TablaSimbolos.addSimbolo(val_peek(0).sval,t);
                    }
                    }
break;
case 41:
//#line 192 "gramatica.y"
{
                    chequearEnteroNegativo(val_peek(0).sval);
                    NodoHoja aux = new NodoHoja(val_peek(0).sval);
                    aux.setTipo("INT");
                    aux.setUso("Constante");
                    aux.setAmbito(ambitoAct);
                    yyval.obj = aux;
                    Token t = TablaSimbolos.getToken(val_peek(0).sval);
                    if (!(t==null)){
                        t.setTipo("INT");
                        t.setUso("Constante");
                        t.setAmbito(ambitoAct);
                        TablaSimbolos.removeToken(val_peek(0).sval);
                        TablaSimbolos.addSimbolo(val_peek(0).sval,t);
                    }
	                }
break;
case 42:
//#line 208 "gramatica.y"
{chequearDouble(val_peek(0).sval);
                         NodoHoja aux = new NodoHoja(val_peek(0).sval);
                         aux.setTipo("DOUBLE");
                         aux.setUso("Constante");
                         aux.setAmbito(ambitoAct);
                         yyval.obj = aux;
                         Token t = TablaSimbolos.getToken(val_peek(0).sval);
                         if (!(t==null)){
                             t.setTipo("DOUBLE");
                             t.setUso("Constante");
                             t.setAmbito(ambitoAct);
                             TablaSimbolos.removeToken(val_peek(0).sval);
                             TablaSimbolos.addSimbolo(val_peek(0).sval,t);
                         }
                        }
break;
case 43:
//#line 225 "gramatica.y"
{yyval.obj = controlarTipos((Nodo)val_peek(2).obj,val_peek(1).sval,(Nodo)val_peek(0).obj);}
break;
case 44:
//#line 226 "gramatica.y"
{yyval.obj = controlarTipos((Nodo)val_peek(2).obj,val_peek(1).sval,(Nodo)val_peek(0).obj);}
break;
case 45:
//#line 227 "gramatica.y"
{yyval.obj=val_peek(0).obj;}
break;
case 46:
//#line 228 "gramatica.y"
{yyval.obj=val_peek(0).obj;}
break;
case 47:
//#line 232 "gramatica.y"
{yyval.obj = controlarTipos((Nodo)val_peek(2).obj,val_peek(1).sval,(Nodo)val_peek(0).obj);}
break;
case 48:
//#line 234 "gramatica.y"
{yyval.obj = controlarTipos((Nodo)val_peek(2).obj,val_peek(1).sval,(Nodo)val_peek(0).obj);}
break;
case 49:
//#line 235 "gramatica.y"
{yyval.obj = val_peek(0).obj;}
break;
case 50:
//#line 236 "gramatica.y"
{yyval.obj = controlarTipos((Nodo)val_peek(2).obj,val_peek(1).sval,(Nodo)val_peek(0).obj);}
break;
case 51:
//#line 237 "gramatica.y"
{yyval.obj = controlarTipos((Nodo)val_peek(2).obj,val_peek(1).sval,(Nodo)val_peek(0).obj);}
break;
case 52:
//#line 238 "gramatica.y"
{yyval.obj=val_peek(0).obj;}
break;
case 53:
//#line 241 "gramatica.y"
{Nodo aux = new NodoHoja ((String)val_peek(0).sval);
            TablaSimbolos.removeToken(val_peek(0).sval);
            String var = val_peek(0).sval + ":" + ambitoAct;
            var = getLexemaAlcance(var);
            if (var.equals(val_peek(0).sval)){
                agregarErrorSemantico("Variable no declarada en este ambito ");
            }
            else {
                if((!TablaSimbolos.getUso(var).equals("Variable")) && (!TablaSimbolos.getUso(var).equals("Parametro"))){
                    agregarErrorSemantico("El ID en uso no es una variable ");
                }
                else {
                    aux.setTipo(TablaSimbolos.getTipo(var));
                    aux.setUso(TablaSimbolos.getUso(var));
                    aux.setAmbito(TablaSimbolos.getAmbito(var));
                }
            }
            yyval.obj = aux;
          }
break;
case 54:
//#line 260 "gramatica.y"
{yyval.obj=val_peek(0).obj;}
break;
case 55:
//#line 264 "gramatica.y"
{yyval.obj=val_peek(0).obj;}
break;
case 56:
//#line 267 "gramatica.y"
{yyval.obj = controlarTipos((Nodo)val_peek(3).obj,val_peek(2).sval,(Nodo)val_peek(1).obj);}
break;
case 57:
//#line 268 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba una ')' ");}
break;
case 58:
//#line 269 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba una '(' ");}
break;
case 59:
//#line 272 "gramatica.y"
{  yyval.obj = new NodoComun("CUERPO",(Nodo)val_peek(3).obj,(Nodo)val_peek(1).obj);
                                                        Nodo aux = (Nodo)yyval.obj;
                                                        yyval.obj = new NodoComun("IF",(Nodo)val_peek(4).obj,aux);
                                                        AnalizadorLexico.agregarEstructura("Reconoce IF ELSE");}
break;
case 60:
//#line 276 "gramatica.y"
{yyval.obj = new NodoComun("IF",(Nodo)val_peek(2).obj,(Nodo)val_peek(1).obj);
	                                    AnalizadorLexico.agregarEstructura("Reconoce IF");}
break;
case 61:
//#line 278 "gramatica.y"
{  yyval.obj = new NodoComun("IF",(Nodo)val_peek(3).obj,(Nodo)val_peek(2).obj);
         	                                            AnalizadorLexico.agregarEstructura("Reconoce IF");}
break;
case 62:
//#line 280 "gramatica.y"
{   yyval.obj = new NodoComun("CUERPO",(Nodo)val_peek(4).obj,(Nodo)val_peek(1).obj);
                                                                        Nodo aux = (Nodo)yyval.obj;
                                                                        yyval.obj = new NodoComun("IF",(Nodo)val_peek(5).obj,aux);
                                                                        AnalizadorLexico.agregarEstructura("Reconoce IF ELSE");}
break;
case 63:
//#line 284 "gramatica.y"
{yyval.obj = new NodoComun("CUERPO",(Nodo)val_peek(5).obj,(Nodo)val_peek(2).obj);
                                                                                    Nodo aux = (Nodo)yyval.obj;
                                                                                    yyval.obj = new NodoComun("IF",(Nodo)val_peek(6).obj,aux);
                                                                                    AnalizadorLexico.agregarEstructura("Reconoce IF ELSE");}
break;
case 64:
//#line 288 "gramatica.y"
{   yyval.obj = new NodoComun("CUERPO",(Nodo)val_peek(4).obj,(Nodo)val_peek(2).obj);
                                                                        Nodo aux = (Nodo)yyval.obj;
                                                                        yyval.obj = new NodoComun("IF",(Nodo)val_peek(5).obj,aux);
                                                                        AnalizadorLexico.agregarEstructura("Reconoce IF ELSE");}
break;
case 65:
//#line 295 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("IF mal definido ");}
break;
case 66:
//#line 296 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba un END_IF ");}
break;
case 67:
//#line 297 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba un END_IF ");}
break;
case 68:
//#line 298 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba un END_IF ");}
break;
case 69:
//#line 299 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba un END_IF ");}
break;
case 70:
//#line 300 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba un ELSE ");}
break;
case 71:
//#line 301 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba un ELSE");}
break;
case 72:
//#line 302 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba una ',' ");}
break;
case 73:
//#line 303 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba una ',' " );}
break;
case 74:
//#line 304 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba una ',' ");}
break;
case 75:
//#line 307 "gramatica.y"
{yyval.obj = val_peek(1).obj;}
break;
case 76:
//#line 308 "gramatica.y"
{yyval.obj = val_peek(3).obj;}
break;
case 77:
//#line 310 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Falta una ',' "); }
break;
case 78:
//#line 311 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Falta un '{'"); }
break;
case 79:
//#line 312 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Falta un '}'"); }
break;
case 80:
//#line 313 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("No hay sentencias dentro de las llaves."); }
break;
case 81:
//#line 316 "gramatica.y"
{yyval.obj=val_peek(0).obj;}
break;
case 82:
//#line 319 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Solo se aceptan sentencias ejecutables "); }
break;
case 83:
//#line 320 "gramatica.y"
{yyval.obj=val_peek(1).obj;}
break;
case 84:
//#line 321 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Falta una ',' "); }
break;
case 85:
//#line 322 "gramatica.y"
{yyval.obj = new NodoComun("SENTENCIA", (Nodo) val_peek(2).obj, (Nodo) val_peek(1).obj);}
break;
case 86:
//#line 325 "gramatica.y"
{yyval.obj=val_peek(0).obj;}
break;
case 87:
//#line 326 "gramatica.y"
{yyval.obj=val_peek(0).obj;}
break;
case 88:
//#line 327 "gramatica.y"
{yyval.obj=val_peek(0).obj;}
break;
case 89:
//#line 328 "gramatica.y"
{yyval.obj=val_peek(0).obj;}
break;
case 90:
//#line 329 "gramatica.y"
{yyval.obj=val_peek(0).obj;}
break;
case 91:
//#line 330 "gramatica.y"
{yyval.obj=val_peek(0).obj;}
break;
case 94:
//#line 337 "gramatica.y"
{agregarErrorSemantico("RETURN fuera de funcion");}
break;
case 95:
//#line 338 "gramatica.y"
{  yyval.obj = (Nodo)val_peek(6).obj;
                                                                                deshacerAmbito();
                                                                                Nodo aux = new NodoComun("Funcion",(Nodo)val_peek(6).obj,(Nodo)val_peek(3).obj);
                                                                                funciones.add(aux);
                                                                                AnalizadorLexico.agregarEstructura("Reconoce declaracion de funcion ");}
break;
case 96:
//#line 343 "gramatica.y"
{ yyval.obj = (Nodo)val_peek(4).obj;
                                                                    deshacerAmbito();
                                                                    Nodo aux = new NodoComun("Funcion",(Nodo)val_peek(4).obj,(Nodo)val_peek(1).obj);
                                                                    funciones.add(aux);
                                                                    AnalizadorLexico.agregarEstructura("Reconoce declaracion de funcion ");}
break;
case 97:
//#line 348 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba un nombre para la funcion ");}
break;
case 98:
//#line 351 "gramatica.y"
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
                  yyval.obj = new NodoHoja(val_peek(0).sval);
                  }
break;
case 99:
//#line 369 "gramatica.y"
{    Token t = TablaSimbolos.getToken(val_peek(1).sval);
                                if (t != null){
                                	t.setLexema(val_peek(1).sval + ":" + ambitoAct);
                                	t.setAmbito(ambitoAct);
                                	t.setUso("Parametro");
                                	t.setTipo(tipoActual);
                                	TablaSimbolos.removeToken(val_peek(1).sval);
                                	TablaSimbolos.addSimbolo(t.getLexema(),t);
                                }
                                funciones_declaradas.get(funciones_declaradas.size() - 1).setParametro(t);
                                NodoHoja aux = new NodoHoja(val_peek(1).sval);
                                aux.setAmbito(ambitoAct);
                                aux.setTipo(tipoActual);
                                aux.setUso("Parametro");
                                parametros.add(aux);
                                yyval.obj = aux;
                           }
break;
case 100:
//#line 386 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba un ')' ");}
break;
case 101:
//#line 387 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba un '(' ");}
break;
case 102:
//#line 388 "gramatica.y"
{yyval.obj = null;}
break;
case 103:
//#line 389 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba un ')' ");}
break;
case 104:
//#line 390 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba un '(' ");}
break;
case 105:
//#line 396 "gramatica.y"
{yyval.obj = new NodoComun("Sentencia",(Nodo)val_peek(2).obj,(Nodo)val_peek(1).obj);}
break;
case 106:
//#line 397 "gramatica.y"
{yyval.obj=val_peek(1).obj;}
break;
case 107:
//#line 398 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba una ',' al final de la linea ");}
break;
case 108:
//#line 399 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba una ',' al final de la linea ");}
break;
case 109:
//#line 400 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba una ',' al final de la linea ");}
break;
case 110:
//#line 403 "gramatica.y"
{yyval.obj=new NodoControl("LLAMADO FUNCION", new NodoHoja(val_peek(2).sval));
                            Token tokenFuncion = TablaSimbolos.buscarPorAmbito(val_peek(2).sval + ":" + ambitoAct);

                            if (tokenFuncion == null){
                                agregarErrorSemantico("La funcion " + val_peek(3).sval + " nunca fue declarada");
                            } else {
                                Funcion funcion = new Funcion(tokenFuncion.getLexema(), null);
                                if (funciones_declaradas.contains(funcion)) {
                                    int indice = funciones_declaradas.indexOf(funcion);
                                    Funcion f = funciones_declaradas.get(indice);
                                    if (f.getParametro() != null){
                                        agregarErrorSemantico("Se esperaba un parametro en la función ");
                                    }
                                }
                            }
				            AnalizadorLexico.agregarEstructura("Reconoce llamado funcion ");
				            TablaSimbolos.removeToken(val_peek(2).sval);
				            }
break;
case 111:
//#line 421 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba un '(' ");}
break;
case 112:
//#line 422 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba un ')' ");}
break;
case 113:
//#line 423 "gramatica.y"
{
            			            NodoHoja nodo1 = new NodoHoja(val_peek(3).sval);
            			            Nodo n3 = (Nodo)val_peek(1).obj;
                                    Token tokenFuncion = TablaSimbolos.buscarPorAmbito(val_peek(3).sval + ":" + ambitoAct);

                                    if (tokenFuncion == null){
                                    	agregarErrorSemantico("La funcion " + val_peek(3).sval + " nunca fue declarada");
                                    } else {
                                        Token tokenParametro = TablaSimbolos.getToken(n3.getLexema());
                                        Funcion funcion = new Funcion(tokenFuncion.getLexema(), null);
                                    	if (funciones_declaradas.contains(funcion)) {
                                            int indice = funciones_declaradas.indexOf(funcion);
                                            Funcion f = funciones_declaradas.get(indice);
                                            if (!(f.getParametro() == null)) {
                                                if (!(f.getParametro().getTipo().equals(n3.getTipo())) && (n3.getTipo() != null)){
                                                    agregarErrorSemantico("No coinciden los tipos del parametro real y el formal. Se esperaba un " + f.getParametro().getTipo() + ", se obtuvo un " + n3.getTipo());
                                                }else{n3.setAmbito(f.getParametro().getAmbito());
                                                      n3.setUso(f.getParametro().getUso());
                                                      /*f.setParametro(tokenParametro);  cambiamos parametro formal por el real*/
                                                      }
                                            }else{agregarErrorSemantico("La funcion invocada no lleva parametros ");}
                                        }
                                    }

                                    yyval.obj=new NodoControl("LLAMADO FUNCION", new NodoComun(val_peek(3).sval,null,n3));
                                    AnalizadorLexico.agregarEstructura("Reconoce llamado funcion ");
                                    TablaSimbolos.removeToken(val_peek(3).sval);
                                    }
break;
case 114:
//#line 453 "gramatica.y"
{yyval.obj = new NodoControl("PRINT", new NodoHoja(val_peek(0).sval));
                             AnalizadorLexico.agregarEstructura("Reconoce salida de mensaje por pantalla ");}
break;
case 115:
//#line 455 "gramatica.y"
{yyval.obj = new NodoControl("PRINT", new NodoHoja(val_peek(0).sval));
                            AnalizadorLexico.agregarEstructura("Reconoce salida de mensaje por pantalla ");}
break;
case 116:
//#line 457 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("La funcion PRINT no acepta esa declaracion ");}
break;
case 117:
//#line 460 "gramatica.y"
{yyval.obj=val_peek(0).obj;}
break;
case 118:
//#line 461 "gramatica.y"
{yyval.obj=val_peek(0).obj;}
break;
case 119:
//#line 464 "gramatica.y"
{AnalizadorLexico.agregarEstructura("Reconoce asignacion ");
                                                if (val_peek(1).sval.equals("="))
						                            yyval.obj = controlarTiposAsignacion((Nodo)val_peek(2).obj, "=", (Nodo)val_peek(0).obj);
						                        else
						                            yyval.obj = controlarTiposAsignacion((Nodo)val_peek(2).obj, "+=", (Nodo)val_peek(0).obj);}
break;
case 120:
//#line 470 "gramatica.y"
{AnalizadorLexico.agregarEstructura("Reconoce asignacion ");
	                                                        if (val_peek(1).sval.equals("="))
	                                                            yyval.obj = controlarTiposAsignacion((Nodo)val_peek(2).obj, "=", (Nodo)val_peek(0).obj);
	                                                        else
	                                                            yyval.obj = controlarTiposAsignacion((Nodo)val_peek(2).obj, "+=", (Nodo)val_peek(0).obj);}
break;
case 121:
//#line 476 "gramatica.y"
{AnalizadorLexico.agregarEstructura("Reconoce asignacion ");
	                                                if (val_peek(1).sval.equals("="))
	                                                    yyval.obj = controlarTiposAsignacion((Nodo)val_peek(2).obj, "=", (Nodo)val_peek(0).obj);
                                                 	else
                                                 	    yyval.obj = controlarTiposAsignacion((Nodo)val_peek(2).obj, "+=", (Nodo)val_peek(0).obj);}
break;
case 122:
//#line 481 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba un valor seguido del operador ");}
break;
case 123:
//#line 482 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba un valor seguido del operador ");}
break;
case 124:
//#line 483 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba un operando del lado izquierdo ");}
break;
case 125:
//#line 486 "gramatica.y"
{yyval.obj=new NodoComun("DO UNTIL", (Nodo)val_peek(2).obj ,(Nodo)val_peek(0).obj);
                                                        AnalizadorLexico.agregarEstructura("Reconoce funcion DO UNTIL");}
break;
case 126:
//#line 488 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba una condicion ");}
break;
case 127:
//#line 489 "gramatica.y"
{yyval.obj = new NodoComun("DO UNTIL", (Nodo)val_peek(3).obj ,(Nodo)val_peek(1).obj);
                                                               AnalizadorLexico.agregarEstructura("Reconoce funcion DO UNTIL");}
break;
case 128:
//#line 491 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba una condicion ");}
break;
case 129:
//#line 492 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba una sentencia ejecutable ");}
break;
case 130:
//#line 493 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba una ',' ");}
break;
case 131:
//#line 499 "gramatica.y"
{yyval.obj = val_peek(1).obj;}
break;
case 132:
//#line 500 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba un '(' ");}
break;
case 133:
//#line 501 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba un ')' ");}
break;
case 134:
//#line 504 "gramatica.y"
{((Nodo)val_peek(0).obj).setTipo("DOUBLE");
                                            yyval.obj = (Nodo)val_peek(0).obj;
                                            AnalizadorLexico.agregarEstructura("Reconoce funcion TOD ");
                                            }
break;
case 135:
//#line 509 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba una Expresion ");}
break;
case 137:
//#line 516 "gramatica.y"
{  if (!(clases_forward_declaration.contains(val_peek(0).sval + ":" + ambitoAct)))  {
                                        clases_forward_declaration.add(val_peek(0).sval + ":" + ambitoAct);

                                        Token var = TablaSimbolos.getToken(val_peek(0).sval + ":" + ambitoAct);
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

                                            TablaSimbolos.addSimbolo(t.getLexema(),t);
                                        }
                                        tipoActual = val_peek(0).sval;
                                        claseAct = val_peek(0).sval;
                                        actualizarAmbito(val_peek(0).sval);}
                                     TablaSimbolos.removeToken(val_peek(0).sval);
                            }
break;
case 138:
//#line 542 "gramatica.y"
{deshacerAmbito();
                                  clases_declaradas.add(claseAct+":"+ambitoAct);
                                  }
break;
case 139:
//#line 547 "gramatica.y"
{ deshacerAmbito();
                                                AnalizadorLexico.agregarEstructura("Reconoce Funcion sin cuerpo");
                                               }
break;
case 140:
//#line 553 "gramatica.y"
{  if (!(clases_declaradas.contains(val_peek(1).sval+":"+ambitoAct))){
                                        agregarErrorSemantico("La clase no esta definida ");
                                    }
                                    actualizarAmbito(val_peek(1).sval);
                                 }
break;
case 141:
//#line 560 "gramatica.y"
{
                                                 Nodo n = (Nodo)val_peek(1).obj;
                                                 Funcion f = new Funcion(n.getLexema()+":"+ambitoAct ,null);
                                                 if (!(funciones_declaradas.contains(f)))
                                                        agregarErrorSemantico("La funcion declarada no fue definida ");
                                                 AnalizadorLexico.agregarEstructura("Reconoce funcion IMPL");

                                                 deshacerAmbito();
                                               }
break;
case 142:
//#line 569 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba un '{' ");}
break;
case 143:
//#line 570 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba un '}' ");}
break;
//#line 1832 "Parser.java"
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
