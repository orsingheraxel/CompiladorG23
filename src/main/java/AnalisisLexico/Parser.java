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
import GeneracionCodigoIntermedio.*;
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
    0,    0,    1,    1,    1,    2,    2,    2,    2,    6,
    7,    4,    4,    4,    4,    4,    5,    5,    5,    5,
    5,    5,    5,   13,   13,   16,   12,   12,   12,   18,
   18,   18,   18,   18,   18,   19,   19,   19,   19,   20,
   20,   20,   20,   20,   20,   22,   22,   23,   24,   24,
   24,   10,   10,   10,   10,   10,   10,   10,   10,   10,
   10,   10,   10,   10,   10,   10,   26,   26,   26,   26,
   26,   26,   26,   26,   27,   28,   28,   28,   28,   25,
   25,   25,   25,   25,   25,   29,   29,   14,   14,   31,
   31,   31,   31,   31,   31,   32,   32,   32,   32,   32,
   32,   32,   32,   32,    8,    8,    8,    8,   11,   11,
   11,   34,   34,   35,    9,    9,    9,    9,    9,    9,
    3,    3,   33,   33,   33,   21,   21,   36,   37,   37,
   37,   37,   37,   37,   37,   37,   15,   30,   17,   17,
   17,
};
final static short yylen[] = {                            2,
    3,    3,    2,    3,    2,    1,    1,    1,    2,    3,
    3,    1,    1,    1,    1,    1,    2,    1,    2,    2,
    1,    1,    1,    1,    3,    2,    1,    1,    1,    1,
    1,    2,    1,    2,    2,    3,    3,    1,    1,    3,
    3,    1,    3,    3,    1,    1,    1,    1,    5,    5,
    5,    6,    4,    6,    4,    7,    8,    7,    7,    7,
    7,    7,    7,    7,    7,    5,    3,    2,    2,    5,
    5,    3,    3,    2,    1,    1,    2,    2,    3,    1,
    1,    1,    1,    1,    1,    1,    1,    6,    6,    4,
    4,    4,    2,    2,    2,    3,    3,    2,    2,    2,
    3,    2,    2,    2,    3,    3,    3,    2,    2,    2,
    2,    1,    1,    0,    4,    3,    3,    3,    3,    2,
    4,    4,    3,    3,    3,    2,    3,    3,    3,    4,
    2,    3,    3,    4,    2,    3,    3,    3,    7,    7,
    7,
};
final static short yydefred[] = {                         0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
   28,   27,   29,    0,  113,    0,  112,    0,    0,    6,
    7,    8,    0,   16,   13,   12,   14,   15,    0,   18,
   21,   22,   23,    0,    0,   24,    0,    0,    0,    0,
  111,   46,  109,   30,   31,   33,    0,   47,  110,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,  108,    0,    9,    2,    0,    5,    3,    0,   20,
    0,  120,    1,    0,    0,    0,   48,    0,    0,   39,
   42,   45,    0,    0,    0,    0,   34,   32,   35,    0,
  137,    0,    0,    0,    0,   76,    0,    0,    0,   69,
   68,   74,    0,    0,    0,  106,    0,    0,   11,  107,
  105,    0,  119,    0,    4,  118,  116,  117,   25,    0,
    0,    0,  126,   84,   85,   83,   82,    0,    0,   80,
   81,    0,    0,    0,    0,    0,    0,   55,    0,   53,
    0,    0,   86,    0,   87,    0,   95,    0,   94,   93,
    0,    0,    0,   78,   77,   72,    0,   73,    0,   67,
    0,  121,    0,  124,  125,  123,  115,   10,  127,    0,
    0,    0,   40,   43,   41,   44,    0,    0,   66,    0,
    0,    0,    0,    0,    0,  135,  131,    0,  128,    0,
    0,    0,    0,    0,    0,    0,    0,   79,    0,    0,
    0,    0,   51,   50,   49,    0,    0,    0,    0,    0,
    0,    0,   54,   52,    0,  133,  129,    0,  136,    0,
  132,   92,   91,   90,  104,  100,  102,   98,  103,   99,
   89,    0,   88,   71,   70,    0,    0,   64,   63,   62,
   60,    0,   59,   56,   65,   61,   58,    0,    0,  101,
   97,   96,  140,  141,  139,   57,
};
final static short yydgoto[] = {                          3,
   18,   19,   20,   21,   22,   77,   24,   25,   26,   27,
   28,   29,   37,   30,   31,   32,   33,   48,   78,   79,
   80,   81,   82,   40,  132,   56,   98,   99,  144,  145,
   94,  196,   62,   34,  167,   91,  146,
};
final static short yysindex[] = {                       -99,
   99,   99,    0, -242,  -39,  -24, -218, -210, -112, -212,
    0,    0,    0,  -38,    0, -179,    0,   11,   51,    0,
    0,    0,  -16,    0,    0,    0,    0,    0, -198,    0,
    0,    0,    0, -163,   12,    0,   66,   -5,   -5,  155,
    0,    0,    0,    0,    0,    0, -237,    0,    0,   -6,
  -37,  -37,  196,   54,  163, -129, -108,  -36, -102,  -41,
   66,    0,  -10,    0,    0,   99,    0,    0,    7,    0,
   66,    0,    0,  -83,  149,  -34,    0,   59,   58,    0,
    0,    0,   59,   -7,   69,  -94,    0,    0,    0,  -79,
    0,   82,   79,   81,   84,    0,   71,   76,  164,    0,
    0,    0, -106,  -33,  152,    0,   35,  -30,    0,    0,
    0,  -29,    0,  102,    0,    0,    0,    0,    0,  -58,
   -5,  -28,    0,    0,    0,    0,    0,    3,    3,    0,
    0,   -5,    3,    3,   -5,  -65, -162,    0,  155,    0,
 -196, -242,    0,   78,    0,    5,    0,  -55,    0,    0,
  -49,  115,  115,    0,    0,    0,  148,    0,   80,    0,
   -5,    0,  -97,    0,    0,    0,    0,    0,    0,   58,
   58,   73,    0,    0,    0,    0,   -9, -112,    0,  155,
  155,   88, -101,  -37,  -22,    0,    0,  -79,    0,  -79,
  171,  -26,   95,   96,   97,   13,   17,    0,  100,  104,
   33,   33,    0,    0,    0,  -46,   39,   56,  107,  -57,
   62,  -56,    0,    0,   84,    0,    0, -242,    0, -242,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,  135,    0,    0,    0,  177, -107,    0,    0,    0,
    0,   74,    0,    0,    0,    0,    0,   66,   66,    0,
    0,    0,    0,    0,    0,    0,
};
final static short yyrindex[] = {                         0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    6,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    9,    0,    0,    0,    0,    0,    0,    0,    0,    0,
   23,    0,    0,    0,   21,    0,    0,    0,   41,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0, -100,    0,
    0,    0,    0,    0,    0,    0,    0,  -14,    0,    0,
    0,    0,    0,   49,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
   28,    0,    0,    0,    0,    0,    0,    0,    0,   47,
   67,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,   43,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,   45,   53,    0,
    0,    0,    0,    0,    0,    0,
};
final static short yygindex[] = {                         0,
  219,  238,    0,  373,  -78,  288,    0,  299,    0,    0,
    0,  -62,  356,  -11,    0,    0,    0,    0,  375,   52,
    0,   64,   72,  265,  295,    4,  324,    0,  -17,    0,
  -32,  233,  311,   15,    0,    0,    0,
};
final static int YYTABLESIZE=605;
static short yytable[];
static { yytable();}
static void yytable(){
yytable = new short[]{                        111,
   39,   60,   93,   47,  106,  122,   39,   59,   47,   60,
   55,  166,  169,  129,  224,  128,   47,  255,  160,   95,
   47,  217,   17,    2,   75,  202,   36,  142,   63,  148,
  151,  205,   60,  129,   47,  128,   74,   69,   59,   47,
   87,   88,   89,   86,   17,   51,   10,   47,  190,   19,
   50,   47,   26,   17,   66,   66,  232,   70,   52,   51,
  232,   46,   46,   46,   46,   46,   17,   46,   57,   49,
   36,  122,  184,  195,  195,  164,   64,  129,  143,  128,
   46,   38,   46,   38,   38,   38,  138,   37,  134,   37,
   37,   37,  114,  180,   68,  181,  130,  101,   63,  133,
   38,  129,   38,  128,  134,   72,   37,   36,   37,   36,
   36,   36,  137,  203,  155,  129,   90,  128,  130,  150,
  131,  187,  147,  200,   74,  218,   36,  220,   36,  189,
   19,  212,  118,   26,  104,   65,   73,  231,  226,  228,
  230,  233,  183,   53,  129,   46,  128,   17,  254,  158,
  242,  215,  122,  252,  213,   75,    1,  214,  201,   17,
  105,  138,   54,  139,  140,   38,  108,  138,  159,  134,
  219,   37,  221,  114,   75,   17,  143,  130,  143,  170,
  171,  206,  141,  208,  210,  119,   11,   12,   13,  236,
  237,   36,  178,  179,  120,   17,  173,  175,  243,  246,
  156,  244,  247,  152,  174,  176,  153,  157,   17,  163,
  168,  222,  238,  191,  110,   17,   38,   58,   92,  192,
   35,  121,  161,   17,  234,   58,  165,   75,  235,  223,
   36,   41,   75,  216,   76,   15,   44,   45,   46,   76,
   75,   44,   45,   46,   42,  113,  204,   76,   58,   44,
   45,   46,   43,   44,   45,   46,   17,   15,   75,   10,
  188,   19,  116,   75,   26,   76,   15,   44,   45,   46,
   76,   75,   44,   45,   46,   75,   46,   55,   17,   46,
   44,   45,   46,  122,   44,   45,   46,  102,   23,   23,
   46,   46,   46,   46,    8,   46,   38,  239,  138,   38,
  134,  253,   37,  115,  114,   37,   67,  114,  130,  100,
   38,   38,   38,   38,  240,   38,   37,   37,   37,   37,
  245,   37,   36,  114,  136,   36,  154,   23,  124,  125,
  126,  127,  256,  186,  149,  199,   36,   36,   36,   36,
   23,   36,   23,  211,   11,   12,   13,   11,   12,   13,
  225,  227,  229,   23,    4,    5,  117,  109,    6,    7,
    8,    9,  241,   10,   11,   12,   13,   14,  162,   61,
    4,    5,   15,   16,    6,    7,    8,  135,  103,   10,
   11,   12,   13,   14,   71,  197,  123,    0,   15,  193,
    4,    5,    0,    0,    6,    7,    8,    0,    0,   10,
   11,   12,   13,   14,    5,    0,    0,    6,   15,  250,
   53,    5,   85,   83,    6,    0,   84,    0,   96,    5,
    0,   15,    6,   84,    0,   97,   23,   97,   15,   54,
    0,   84,  107,    0,  112,    0,   15,  114,    0,   23,
   23,    0,    0,    0,   23,    0,    0,    0,    0,    0,
    0,   96,    5,    0,    0,    6,    0,    0,    0,    0,
    0,    0,    0,    0,   84,    0,    0,   23,   23,   15,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,  107,  112,  185,    0,    0,
    0,    0,    0,    0,    0,    0,  172,    0,    0,  177,
    0,  182,    0,    0,    0,    0,    0,    0,    0,   23,
    0,    0,    0,    0,  194,  194,    0,    0,    0,  198,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,  207,  209,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,  248,    0,  249,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,  251,
};
}
static short yycheck[];
static { yycheck(); }
static void yycheck() {
yycheck = new short[] {                         41,
   40,   40,   40,   45,   41,   40,   40,   46,   45,   40,
  123,   41,   41,   43,   41,   45,   45,  125,  125,   52,
   45,   44,   61,  123,  125,  123,  269,   90,   14,   92,
   93,   41,   40,   43,   45,   45,   59,   23,   46,   45,
  278,  279,  280,   40,   61,  256,   61,   45,   44,   44,
  269,   45,   44,   61,   44,   44,   44,  256,  269,  256,
   44,   41,   42,   43,   44,   45,   44,   47,  281,    6,
  269,   44,  269,  152,  153,   41,  256,   43,   90,   45,
   60,   41,   62,   43,   44,   45,   44,   41,   44,   43,
   44,   45,   44,  256,   44,  258,   44,   44,   84,   42,
   60,   43,   62,   45,   47,  269,   60,   41,   62,   43,
   44,   45,   44,   41,   44,   43,  123,   45,   60,   41,
   62,   44,   41,   44,   59,  188,   60,  190,   62,  125,
  125,   44,   69,  125,  264,  125,  125,  125,   44,   44,
   44,  125,  139,  256,   43,  125,   45,  125,  256,  256,
   44,  184,  125,  232,  256,  256,  256,  259,  256,   61,
  269,  256,  275,  258,  259,  125,  269,  125,  275,  125,
  188,  125,  190,  125,  275,   61,  188,  125,  190,  128,
  129,  178,  262,  180,  181,  269,  266,  267,  268,  201,
  202,  125,  258,  259,   46,   61,  133,  134,  256,  256,
  125,  259,  259,  123,  133,  134,  123,   44,   61,   58,
  269,   41,  259,  269,  256,   61,  256,  256,  256,  269,
    2,  256,  256,   61,  125,  256,  256,  269,  125,  256,
  269,  256,  269,  256,  276,  274,  278,  279,  280,  276,
  269,  278,  279,  280,  269,  256,  256,  276,  256,  278,
  279,  280,  277,  278,  279,  280,   61,  274,  269,  274,
  256,  256,  256,  269,  256,  276,  274,  278,  279,  280,
  276,  269,  278,  279,  280,  269,  256,  123,  256,  259,
  278,  279,  280,  256,  278,  279,  280,  125,    1,    2,
  270,  271,  272,  273,  262,  275,  256,  259,  256,  259,
  256,  125,  256,   66,  256,  259,  256,  259,  256,  256,
  270,  271,  272,  273,  259,  275,  270,  271,  272,  273,
  259,  275,  256,  275,  256,  259,  256,   40,  270,  271,
  272,  273,  259,  256,  256,  256,  270,  271,  272,  273,
   53,  275,   55,  256,  266,  267,  268,  266,  267,  268,
  256,  256,  256,   66,  256,  257,   69,   59,  260,  261,
  262,  263,  256,  265,  266,  267,  268,  269,  104,   14,
  256,  257,  274,  275,  260,  261,  262,   83,   55,  265,
  266,  267,  268,  269,   29,  153,   76,   -1,  274,  275,
  256,  257,   -1,   -1,  260,  261,  262,   -1,   -1,  265,
  266,  267,  268,  269,  257,   -1,   -1,  260,  274,  275,
  256,  257,   40,   39,  260,   -1,  269,   -1,  256,  257,
   -1,  274,  260,  269,   -1,   53,  139,   55,  274,  275,
   -1,  269,   58,   -1,   60,   -1,  274,   63,   -1,  152,
  153,   -1,   -1,   -1,  157,   -1,   -1,   -1,   -1,   -1,
   -1,  256,  257,   -1,   -1,  260,   -1,   -1,   -1,   -1,
   -1,   -1,   -1,   -1,  269,   -1,   -1,  180,  181,  274,
   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,
   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,
   -1,   -1,   -1,   -1,   -1,  121,  122,  142,   -1,   -1,
   -1,   -1,   -1,   -1,   -1,   -1,  132,   -1,   -1,  135,
   -1,  139,   -1,   -1,   -1,   -1,   -1,   -1,   -1,  232,
   -1,   -1,   -1,   -1,  152,  153,   -1,   -1,   -1,  157,
   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,
   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,
   -1,   -1,  180,  181,   -1,   -1,   -1,   -1,   -1,   -1,
   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,
   -1,   -1,   -1,  218,   -1,  220,   -1,   -1,   -1,   -1,
   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,
   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,
   -1,   -1,   -1,   -1,  232,
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
"ListSentencias : Sentencia ','",
"ListSentencias : ListSentencias ',' Sentencia",
"ListSentencias : Sentencia error",
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
"SentenciaDeclarativa : Tipo ListVariables",
"SentenciaDeclarativa : Funcion",
"SentenciaDeclarativa : error ListVariables",
"SentenciaDeclarativa : Tipo error",
"SentenciaDeclarativa : HerenciaComposicion",
"SentenciaDeclarativa : Objeto_clase",
"SentenciaDeclarativa : FuncionIMPL",
"ListVariables : ID",
"ListVariables : ListVariables ';' ID",
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
"ListaSentenciasIF : ListaSentenciasIF ',' SentenciaEjecutable",
"Comparador : '<'",
"Comparador : '>'",
"Comparador : MAYORIGUAL",
"Comparador : MENORIGUAL",
"Comparador : IGUAL",
"Comparador : DIST",
"ListFuncion : Funcion",
"ListFuncion : FuncionSinCuerpo",
"Funcion : VOID ID Parametro '{' ListSentenciasFuncion '}'",
"Funcion : VOID error Parametro '{' ListSentenciasFuncion '}'",
"Parametro : '(' Tipo ID ')'",
"Parametro : '(' Tipo ID error",
"Parametro : error Tipo ID ')'",
"Parametro : '(' ')'",
"Parametro : '(' error",
"Parametro : error ')'",
"ListSentenciasFuncion : ListSentenciasFuncion ',' SentenciaDeclarativa",
"ListSentenciasFuncion : ListSentenciasFuncion ',' SentenciaEjecutable",
"ListSentenciasFuncion : SentenciaEjecutable ','",
"ListSentenciasFuncion : SentenciaDeclarativa ','",
"ListSentenciasFuncion : RETURN ','",
"ListSentenciasFuncion : ListSentenciasFuncion ',' RETURN",
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
"$$1 :",
"Asignacion : ID OperadorAsignacion Expresion $$1",
"Asignacion : ReferenciaObjeto OperadorAsignacion ReferenciaObjeto",
"Asignacion : ReferenciaObjeto OperadorAsignacion Factor",
"Asignacion : ReferenciaObjeto OperadorAsignacion error",
"Asignacion : ID OperadorAsignacion error",
"Asignacion : OperadorAsignacion ID",
"SentenciaControl : DO CuerpoIF UNTIL Condicion",
"SentenciaControl : DO CuerpoIF UNTIL error",
"LlamadoExpresion : '(' Expresion ')'",
"LlamadoExpresion : error Expresion ')'",
"LlamadoExpresion : '(' Expresion error",
"ConversionExplicita : TOD LlamadoExpresion",
"ConversionExplicita : TOD '(' ')'",
"ListHerencia : '{' SentenciaListHerencia '}'",
"SentenciaListHerencia : Tipo ListVariables ','",
"SentenciaListHerencia : SentenciaListHerencia ',' Tipo ListVariables",
"SentenciaListHerencia : ListFuncion ','",
"SentenciaListHerencia : SentenciaListHerencia ',' ListFuncion",
"SentenciaListHerencia : Tipo ListVariables error",
"SentenciaListHerencia : SentenciaListHerencia error Tipo ListVariables",
"SentenciaListHerencia : ListFuncion error",
"SentenciaListHerencia : SentenciaListHerencia error ListFuncion",
"HerenciaComposicion : CLASS ID ListHerencia",
"FuncionSinCuerpo : VOID ID Parametro",
"FuncionIMPL : IMPL FOR ID ':' '{' Funcion '}'",
"FuncionIMPL : IMPL FOR ID ':' error Funcion '}'",
"FuncionIMPL : IMPL FOR ID ':' '{' Funcion error",
};

//#line 382 "gramatica.y"
  private NodoControl raiz;
  private String ambitoAct = "main";
  static ArrayList<Error> erroresSemanticos = new ArrayList<Error>();

  public void agregarErrorSemantico(String error){
      Error e = new Error(error,AnalizadorLexico.getLineaAct());
      erroresSemanticos.add(e);
    }

   public String buscarAmbito(String ambitoAct,String lexema){
            String ambito = ambitoAct;
            while(!TablaSimbolos.existeSimbolo(lexema+":"+ambito)){
                    if(ambito.equals("main")){
                            //yyerror("La variable " + lexema + " no se encuentra declarada en el ambito " + ambitoAct);
                            ambito = "";
                            break;
                    }else{
                            //retrocede de ambito hasta encontrar el correcto
                            char [] a = ambito.toCharArray();
                            for (int i = a.length;i>=0;i--){
                                    if(a[i-1] == ':'){
                                            ambito = ambito.substring(0,i-1);
                                            break;
                                    }
                            }
                    }
            }
            return ambito;
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

   public void actualizarAmbito(String ambitoAct, String a){
        ambitoAct += ":"+a;
   }

  public int yylex() throws IOException{
    Token t = AnalizadorLexico.obtenerToken();
    this.yylval = new ParserVal(t.getLexema());
    return t.getId();
  }

  public static void yyerror(String error){
    System.out.println(error);
  }
//#line 673 "Parser.java"
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
{raiz = new NodoControl("PROGRAMA",(Nodo)val_peek(1)); AnalizadorLexico.agregarEstructura("Reconoce programa ");}
break;
case 2:
//#line 18 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se espera '{' ");}
break;
case 3:
//#line 21 "gramatica.y"
{yyval=val_peek(1);}
break;
case 4:
//#line 22 "gramatica.y"
{yyval = new NodoComun("Sentencia", (Nodo) val_peek(2), (Nodo) val_peek(0));}
break;
case 5:
//#line 23 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba una ',' al final de la linea ");}
break;
case 6:
//#line 26 "gramatica.y"
{yyval=val_peek(0);}
break;
case 7:
//#line 27 "gramatica.y"
{yyval=val_peek(0);}
break;
case 8:
//#line 28 "gramatica.y"
{yyval=val_peek(0);}
break;
case 9:
//#line 29 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("RETURN definido fuera de funcion ");}
break;
case 10:
//#line 32 "gramatica.y"
{/*chequear q exista y bla bla*/
                            yyval = new NodoComun("ReferenciaFuncionObjeto",(Nodo)val_peek(2),(Nodo)val_peek(0));
                            AnalizadorLexico.agregarEstructura("Reconoce referencia objeto ");}
break;
case 11:
//#line 37 "gramatica.y"
{ /*chequear q exista y bla bla*/
                                                yyval = new NodoComun("ReferenciaFuncionObjeto",(Nodo)val_peek(2),(Nodo)val_peek(0));
                                                AnalizadorLexico.agregarEstructura("Reconoce llamado a funcion de clase ");}
break;
case 12:
//#line 42 "gramatica.y"
{yyval=val_peek(0);}
break;
case 13:
//#line 43 "gramatica.y"
{yyval=val_peek(0);}
break;
case 14:
//#line 44 "gramatica.y"
{yyval=val_peek(0);}
break;
case 15:
//#line 45 "gramatica.y"
{yyval=val_peek(0);}
break;
case 16:
//#line 46 "gramatica.y"
{yyval=val_peek(0);}
break;
case 17:
//#line 49 "gramatica.y"
{  while (((ListVariables)val_peek(0)).getVariable() != null) { /*CHEQUAER SI UNA VARIABLE CON ESE LEXEMA YA TIENE SETEADO EL USO, SI LO TIENE SETEADO ES PORQ YA EXITE*/
                                                String var = ((ListVariables)val_peek(0)).getVariable();
                                                Token t = TablaSimbolos.getToken(var);
                                                if (t != null){
                                                    t.setLexema(val_peek(1).sval + ":" + ambitoAct);
                                                    t.setAmbito(ambitoAct);
                                                    t.setUso("variable");
                                                    t.setTipo(val_peek(1).sval);
                                                    TablaSimbolos.removeToken(var);
                                                    TablaSimbolos.addSimbolo(t.getLexema(),t);
                                                    }
                                                else {
                                                   agregarErrorSemantico("Ya existe una variable + var + definida en este ambito");
                                                    }
                                            }
                                          }
break;
case 19:
//#line 66 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se espera el tipo de la variable ");}
break;
case 20:
//#line 67 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se espera identificador de la variable ");}
break;
case 24:
//#line 73 "gramatica.y"
{ yyval = new ListVariables();
                    ((ListVariables)yyval).addVariable(val_peek(0).sval);}
break;
case 25:
//#line 75 "gramatica.y"
{yyval = val_peek(0) ; ((ListVariables)yyval).addVariable(val_peek(0).sval);}
break;
case 30:
//#line 86 "gramatica.y"
{
                    chequearEnteroPositivo(val_peek(0).sval);
                    yyval = new NodoHoja(val_peek(0).sval) ;
                    ((Nodo)yyval).setTipo(TablaSimbolos.getTipo(val_peek(0).sval));
                    ((Nodo)yyval).setUso("Constante");
                    TablaSimbolos.setUso(val_peek(0).sval, "Constante");
                   }
break;
case 31:
//#line 94 "gramatica.y"
{yyval = new NodoHoja(val_peek(0).sval);
	               chequearEnteroCorto(val_peek(0).sval);
	               ((Nodo)yyval).setTipo(TablaSimbolos.getTipo(val_peek(0).sval));
                   chequearEnteroPositivo(val_peek(0).sval);
                   ((Nodo)yyval).setUso("Constante");
                   TablaSimbolos.setUso(val_peek(0).sval, "Constante");
                   }
break;
case 32:
//#line 101 "gramatica.y"
{AnalizadorLexico.agregarErrorLexico("Un entero corto no puede ser negativo ");}
break;
case 33:
//#line 102 "gramatica.y"
{
	                chequearDouble(val_peek(0).sval);
	                yyval = new NodoHoja(val_peek(0).sval);
                    ((Nodo)yyval).setTipo(TablaSimbolos.getTipo(val_peek(0).sval));
                    ((Nodo)yyval).setUso("Constante");
                    TablaSimbolos.setUso(val_peek(0).sval, "Constante");
                    }
break;
case 34:
//#line 110 "gramatica.y"
{
                    yyval = new NodoHoja(val_peek(1).sval);
                    chequearEnteroNegativo(val_peek(0).sval);
                    ((Nodo)yyval).setTipo(TablaSimbolos.getTipo(val_peek(1).sval));
                    ((Nodo)yyval).setUso("Constante");
                    TablaSimbolos.setUso(val_peek(1).sval, "Constante");
	                }
break;
case 35:
//#line 117 "gramatica.y"
{
                            chequearDouble(val_peek(1).sval);
                            yyval = new NodoHoja(val_peek(1).sval);
                            ((Nodo)yyval).setTipo(TablaSimbolos.getTipo(val_peek(1).sval));
                            ((Nodo)yyval).setUso("Constante");
                            TablaSimbolos.setUso(val_peek(1).sval, "Constante");
                        }
break;
case 36:
//#line 126 "gramatica.y"
{ yyval = new NodoComun("+",(Nodo)val_peek(2),(Nodo)val_peek(0));
                                    if (!((Nodo)val_peek(2)).getTipo().equals(((Nodo)val_peek(0)).getTipo())){
                                        agregarErrorSemantico("No se puede realizar la suma. Tipos incompatibles ");
                                    }
                                    if (!((Nodo)val_peek(2)).getAmbito().equals(((Nodo)val_peek(0)).getAmbito())){
                                          agregarErrorSemantico("Variable fuera de alcance ");
                                    }



                                    }
break;
case 37:
//#line 138 "gramatica.y"
{yyval = new NodoComun("-",(Nodo)val_peek(2),(Nodo)val_peek(0));}
break;
case 38:
//#line 139 "gramatica.y"
{yyval=val_peek(0);}
break;
case 39:
//#line 140 "gramatica.y"
{yyval = val_peek(0);}
break;
case 40:
//#line 144 "gramatica.y"
{yyval=new NodoComun("*",(Nodo)val_peek(2),(Nodo)val_peek(1));}
break;
case 41:
//#line 154 "gramatica.y"
{yyval=new NodoComun("/",(Nodo)val_peek(2),(Nodo)val_peek(1));}
break;
case 42:
//#line 155 "gramatica.y"
{yyval = val_peek(0);}
break;
case 43:
//#line 156 "gramatica.y"
{yyval=new NodoComun("*",(Nodo)val_peek(2),(Nodo)val_peek(1));}
break;
case 44:
//#line 157 "gramatica.y"
{yyval=new NodoComun("/",(Nodo)val_peek(2),(Nodo)val_peek(1));}
break;
case 45:
//#line 158 "gramatica.y"
{yyval=val_peek(0);}
break;
case 46:
//#line 161 "gramatica.y"
{yyval = new NodoHoja(val_peek(0).sval);
            String var = val_peek(0).sval + ":" + ambitoAct;
            if (!TablaSimbolos.existeSimbolo(var)){
                agregarErrorSemantico("Variable no declarada en este ambito ");
            }
            else {
                if(!TablaSimbolos.getUso(var).equals("Variable")){
                    agregarErrorSemantico("El ID en uso no es una variable ");
                }
                else {
                    ((Nodo)yyval).setTipo(TablaSimbolos.getTipo(val_peek(0).sval));
                    ((Nodo)yyval).setUso(TablaSimbolos.getUso(val_peek(0).sval));
                    ((Nodo)yyval).setAmbito(TablaSimbolos.getAmbito(val_peek(0).sval));
                }
            }
            }
break;
case 47:
//#line 177 "gramatica.y"
{yyval=val_peek(0);}
break;
case 48:
//#line 180 "gramatica.y"
{yyval=val_peek(0);}
break;
case 49:
//#line 183 "gramatica.y"
{ yyval = new NodoComun(val_peek(2).sval,(Nodo)val_peek(3),(Nodo)val_peek(1));
                                                    ((Nodo)yyval).setTipo(((Nodo)val_peek(3)).getTipo());
                                                    ((Nodo)yyval).setUso("Condicion");
                                                     if (!((((Nodo)val_peek(3)).getTipo()).equals(((Nodo)val_peek(1)).getTipo()))){
                                                         agregarErrorSemantico("Error en la comparacion entre expresiones de distintos tipos"); /*CHEQUEAR CONVERSIONES*/
                                                     }
                                                     }
break;
case 50:
//#line 190 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba una ')' ");}
break;
case 51:
//#line 191 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba una '(' ");}
break;
case 52:
//#line 194 "gramatica.y"
{Nodo SentenciasIF = new NodoComun("SentenciasIF",new NodoControl("SentenciasIF",(Nodo)val_peek(3)), new NodoControl("SentenciasELSE",(Nodo)val_peek(1)));
                                                                      yyval= new NodoComun("BloqueIF", new NodoControl("Condicion",(Nodo)val_peek(4)), SentenciasIF);
                                                                      AnalizadorLexico.agregarEstructura("Reconoce IF ELSE ");}
break;
case 53:
//#line 197 "gramatica.y"
{yyval= new NodoComun("BloqueIF", new NodoControl("Condicion",(Nodo)val_peek(2)), new NodoControl("SentenciasIF",(Nodo)val_peek(1)));
	                                            AnalizadorLexico.agregarEstructura("Reconoce IF ");}
break;
case 54:
//#line 199 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("IF mal definido ");}
break;
case 55:
//#line 200 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("IF mal definido ");}
break;
case 56:
//#line 201 "gramatica.y"
{AnalizadorLexico.agregarEstructura("Reconoce IF ELSE");}
break;
case 57:
//#line 202 "gramatica.y"
{AnalizadorLexico.agregarEstructura("Reconoce IF ELSE");}
break;
case 58:
//#line 203 "gramatica.y"
{AnalizadorLexico.agregarEstructura("Reconoce IF ELSE");}
break;
case 59:
//#line 204 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba un END_IF ");}
break;
case 60:
//#line 205 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba un END_IF ");}
break;
case 61:
//#line 206 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba un END_IF ");}
break;
case 62:
//#line 207 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba un ELSE ");}
break;
case 63:
//#line 208 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("IF mal definido ");}
break;
case 64:
//#line 209 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba una ',' ");}
break;
case 65:
//#line 210 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba una ',' " );}
break;
case 66:
//#line 211 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba una ',' ");}
break;
case 69:
//#line 216 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Falta una ',' "); }
break;
case 71:
//#line 218 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Falta una ',' "); }
break;
case 72:
//#line 219 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Falta un '{'"); }
break;
case 73:
//#line 220 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Falta un '}'"); }
break;
case 74:
//#line 221 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("No hay sentencias dentro de las llaves."); }
break;
case 76:
//#line 227 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Solo se aceptan sentencias ejecutables "); }
break;
case 78:
//#line 229 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Falta una ',' "); }
break;
case 80:
//#line 235 "gramatica.y"
{yyval=val_peek(0);}
break;
case 81:
//#line 236 "gramatica.y"
{yyval=val_peek(0);}
break;
case 82:
//#line 237 "gramatica.y"
{yyval=val_peek(0);}
break;
case 83:
//#line 238 "gramatica.y"
{yyval=val_peek(0);}
break;
case 84:
//#line 239 "gramatica.y"
{yyval=val_peek(0);}
break;
case 85:
//#line 240 "gramatica.y"
{yyval=val_peek(0);}
break;
case 88:
//#line 248 "gramatica.y"
{ String ambito = val_peek(4).sval;
                                            actualizarAmbito(ambitoAct, ambito);
                                            /*chequear si las variables pasadas por parametro estan en el ambito anterior*/

                                            yyval = new NodoComun("Funcion", new NodoControl("ParametroFuncion", (Nodo)val_peek(3)), new NodoControl("SentenciasFuncion",(Nodo)val_peek(3)));

                                            if (!TablaSimbolos.existeSimbolo(val_peek(4).sval+":"+ambitoAct)){
                                                ((Nodo)val_peek(4)).setLexema(val_peek(4).sval+":"+ambitoAct);
                                                ((Nodo)val_peek(4)).setUso("Funcion");
                                                TablaSimbolos.setAmbito(val_peek(4).sval+":"+ambitoAct, ambitoAct);
                                            }

                                            AnalizadorLexico.agregarEstructura("Reconoce funcion VOID ");}
break;
case 89:
//#line 262 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba un nombre para la funcion ");}
break;
case 90:
//#line 266 "gramatica.y"
{	yyval = new NodoHoja(val_peek(1).sval);

                           }
break;
case 91:
//#line 269 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba un ')' ");}
break;
case 92:
//#line 270 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba un '(' ");}
break;
case 94:
//#line 272 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba un ')' ");}
break;
case 95:
//#line 273 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba un '(' ");}
break;
case 102:
//#line 282 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba una ',' al final de la linea ");}
break;
case 103:
//#line 283 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba una ',' al final de la linea ");}
break;
case 104:
//#line 284 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba una ',' al final de la linea ");}
break;
case 105:
//#line 287 "gramatica.y"
{yyval=new NodoComun("Llamado Funcion",(Nodo)val_peek(2), null);AnalizadorLexico.agregarEstructura("Reconoce llamado funcion ");}
break;
case 106:
//#line 288 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba un '(' ");}
break;
case 107:
//#line 289 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba un ')' ");}
break;
case 108:
//#line 290 "gramatica.y"
{yyval=new NodoComun("Llamado Funcion",(Nodo)val_peek(1),(Nodo)val_peek(0));AnalizadorLexico.agregarEstructura("Reconoce llamado funcion ");}
break;
case 109:
//#line 292 "gramatica.y"
{yyval = new NodoControl("PRINT", new NodoHoja(val_peek(0).sval));
                             AnalizadorLexico.agregarEstructura("Reconoce salida de mensaje por pantalla ");}
break;
case 110:
//#line 294 "gramatica.y"
{yyval = new NodoControl("PRINT", new NodoHoja(val_peek(0).sval));
                            AnalizadorLexico.agregarEstructura("Reconoce salida de mensaje por pantalla ");}
break;
case 111:
//#line 296 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("La funcion PRINT no acepta esa declaracion ");}
break;
case 112:
//#line 299 "gramatica.y"
{yyval=val_peek(0);}
break;
case 113:
//#line 300 "gramatica.y"
{yyval=val_peek(0);}
break;
case 114:
//#line 303 "gramatica.y"
{AnalizadorLexico.agregarEstructura("Reconoce asignacion ");}
break;
case 115:
//#line 305 "gramatica.y"
{/*Chequear ambito de ID y chequear asignacion valida*/
						/* $$ = new NodoComun($2.sval,(Nodo)$1,(Nodo)$3);
						Token t = TablaSimbolos.getToken($1.sval);
						if (t.getTipo() != null){
							if (t.getLexema() ...) //ambito alcanzable
								//chequear tipo expresion?
								//set uso
						}
						else{
							agregarErrorSemantico("Variable " + var + " no definida"); //SE DEBE CORTAR LA EJECUCION
						    //break;
						}
                        */
					    }
break;
case 118:
//#line 322 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba un valor seguido del operador ");}
break;
case 119:
//#line 323 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba un valor seguido del operador ");}
break;
case 120:
//#line 324 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba un operando del lado izquierdo ");}
break;
case 121:
//#line 327 "gramatica.y"
{yyval=new NodoComun("Sentencia DO UNTIL", new NodoControl("ListSentenciasDO",(Nodo)val_peek(2)), new NodoControl("CondicionDO", (Nodo)val_peek(0)));
                                                        AnalizadorLexico.agregarEstructura("Reconoce funcion DO UNTIL");}
break;
case 122:
//#line 329 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba una condicion ");}
break;
case 123:
//#line 334 "gramatica.y"
{yyval = val_peek(1);}
break;
case 124:
//#line 335 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba un '(' ");}
break;
case 125:
//#line 336 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba un ')' ");}
break;
case 126:
//#line 339 "gramatica.y"
{yyval = new NodoControl("TOD",(Nodo)val_peek(0));
                                            AnalizadorLexico.agregarEstructura("Reconoce funcion TOD ");
                                            }
break;
case 127:
//#line 343 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba una Expresion ");}
break;
case 133:
//#line 354 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba una ',' al final de la linea ");}
break;
case 134:
//#line 355 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba una ',' al final de la linea ");}
break;
case 135:
//#line 356 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba una ',' al final de la linea ");}
break;
case 136:
//#line 357 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba una ',' al final de la linea ");}
break;
case 137:
//#line 360 "gramatica.y"
{ String ambito = val_peek(1).sval;
                                                actualizarAmbito(ambitoAct, ambito);
                                                AnalizadorLexico.agregarEstructura("Reconoce CLASE");}
break;
case 138:
//#line 366 "gramatica.y"
{AnalizadorLexico.agregarEstructura("Reconoce Funcion sin cuerpo");}
break;
case 139:
//#line 370 "gramatica.y"
{AnalizadorLexico.agregarEstructura("Reconoce funcion IMPL");}
break;
case 140:
//#line 371 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba un '{' ");}
break;
case 141:
//#line 372 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba un '}' ");}
break;
//#line 1384 "Parser.java"
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
