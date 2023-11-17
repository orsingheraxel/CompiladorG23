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
    4,    4,    4,    4,    4,    5,    5,    5,    5,    5,
    5,    5,   13,   13,   16,   12,   12,   12,   18,   18,
   18,   18,   18,   18,   19,   19,   19,   19,   20,   20,
   20,   20,   20,   20,   22,   22,   23,   24,   24,   24,
   10,   10,   10,   10,   10,   10,   10,   10,   10,   10,
   10,   10,   10,   10,   10,   26,   26,   26,   26,   26,
   26,   26,   26,   27,   28,   28,   28,   28,   25,   25,
   25,   25,   25,   25,   29,   29,   14,   14,   31,   31,
   31,   31,   31,   31,   32,   32,   32,   32,   32,   32,
   32,   32,   32,    8,    8,    8,    8,   11,   11,   11,
   34,   34,   35,    9,    9,    9,    9,    9,    9,    3,
    3,   33,   33,   33,   21,   21,   36,   37,   37,   37,
   37,   37,   37,   37,   37,   15,   30,   17,   17,   17,
};
final static short yylen[] = {                            2,
    3,    3,    2,    3,    1,    1,    1,    2,    3,    3,
    1,    1,    1,    1,    1,    2,    1,    2,    2,    1,
    1,    1,    1,    3,    2,    1,    1,    1,    1,    1,
    2,    1,    2,    2,    3,    3,    1,    1,    3,    3,
    1,    3,    3,    1,    1,    1,    1,    5,    5,    5,
    6,    4,    6,    4,    7,    8,    7,    7,    7,    7,
    7,    7,    7,    7,    5,    3,    2,    2,    5,    5,
    3,    3,    2,    1,    1,    2,    2,    3,    1,    1,
    1,    1,    1,    1,    1,    1,    6,    6,    4,    4,
    4,    2,    2,    2,    3,    3,    2,    2,    2,    3,
    2,    2,    2,    3,    3,    3,    2,    2,    2,    2,
    1,    1,    0,    4,    3,    3,    3,    3,    2,    4,
    4,    3,    3,    3,    2,    3,    3,    3,    4,    2,
    3,    3,    4,    2,    3,    3,    3,    7,    7,    7,
};
final static short yydefred[] = {                         0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
   27,   26,   28,    0,  112,    0,  111,    0,    0,    5,
    6,    7,    0,   15,   12,   11,   13,   14,    0,   17,
   20,   21,   22,    0,    0,   23,    0,    0,    0,    0,
  110,   45,  108,   29,   30,   32,    0,   46,  109,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,  107,    0,    8,    2,    0,    3,    0,   19,    0,
  119,    1,    0,    0,    0,   47,    0,    0,   38,   41,
   44,    0,    0,    0,    0,   33,   31,   34,    0,  136,
    0,    0,    0,    0,   75,    0,    0,    0,   68,   67,
   73,    0,    0,    0,  105,    0,    0,   10,  106,  104,
    0,  118,    0,    4,  117,  115,  116,   24,    0,    0,
    0,  125,   83,   84,   82,   81,    0,    0,   79,   80,
    0,    0,    0,    0,    0,    0,   54,    0,   52,    0,
    0,   85,    0,   86,    0,   94,    0,   93,   92,    0,
    0,    0,   77,   76,   71,    0,   72,    0,   66,    0,
  120,    0,  123,  124,  122,  114,    9,  126,    0,    0,
    0,   39,   42,   40,   43,    0,    0,   65,    0,    0,
    0,    0,    0,    0,  134,  130,    0,  127,    0,    0,
    0,    0,    0,    0,    0,    0,   78,    0,    0,    0,
    0,   50,   49,   48,    0,    0,    0,    0,    0,    0,
    0,   53,   51,    0,  132,  128,    0,  135,    0,  131,
   91,   90,   89,  103,   99,  101,   97,  102,   98,   88,
    0,   87,   70,   69,    0,    0,   63,   62,   61,   59,
    0,   58,   55,   64,   60,   57,    0,    0,  100,   96,
   95,  139,  140,  138,   56,
};
final static short yydgoto[] = {                          3,
   18,   19,   20,   21,   22,   76,   24,   25,   26,   27,
   28,   29,   37,   30,   31,   32,   33,   48,   77,   78,
   79,   80,   81,   40,  131,   56,   97,   98,  143,  144,
   93,  195,   62,   34,  166,   90,  145,
};
final static short yysindex[] = {                      -105,
  101,  101,    0, -243,  -39,  -24, -218, -227, -112, -176,
    0,    0,    0,  -38,    0, -150,    0,   11,   99,    0,
    0,    0,  -16,    0,    0,    0,    0,    0, -226,    0,
    0,    0,    0, -124,   12,    0,   93,   -5,   -5,  155,
    0,    0,    0,    0,    0,    0, -200,    0,    0,   24,
  -37,  -37,  153,   51,  163, -110, -102,  -36,  -98,  -41,
   93,    0,  -10,    0,    0,  101,    0,    7,    0,   93,
    0,    0,  -86,  145,  -34,    0,   59,   -1,    0,    0,
    0,   59,   -7,   53,  -70,    0,    0,    0, -191,    0,
   82,   79,   70,   75,    0,   54,   76,  156,    0,    0,
    0, -106,  -33,  144,    0,  136,  -30,    0,    0,    0,
  -29,    0,   83,    0,    0,    0,    0,    0,  -66,   -5,
  -28,    0,    0,    0,    0,    0,    3,    3,    0,    0,
   -5,    3,    3,   -5, -185, -162,    0,  155,    0, -225,
 -243,    0,   69,    0,    5,    0,  -64,    0,    0,  -61,
  117,  117,    0,    0,    0,  196,    0,   71,    0,   -5,
    0,  -95,    0,    0,    0,    0,    0,    0,   -1,   -1,
  139,    0,    0,    0,    0,   -9, -112,    0,  155,  155,
   78, -142,  -37,  -22,    0,    0, -191,    0, -191,  168,
  -26,   80,   88,   95,   13,   16,    0,   87,  100,  -49,
  -49,    0,    0,    0,   36,   39,   56,   96,  -83,   62,
  -69,    0,    0,   75,    0,    0, -243,    0, -243,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
  133,    0,    0,    0,  104, -101,    0,    0,    0,    0,
   74,    0,    0,    0,    0,    0,   93,   93,    0,    0,
    0,    0,    0,    0,    0,
};
final static short yyrindex[] = {                         0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    6,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    9,    0,    0,    0,    0,    0,    0,    0,    0,   23,
    0,    0,    0,   21,    0,    0,    0,   41,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0, -100,    0,    0,
    0,    0,    0,    0,    0,    0,  -14,    0,    0,    0,
    0,    0,   49,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,   17,
    0,    0,    0,    0,    0,    0,    0,    0,   47,   67,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,   28,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,   43,   45,    0,    0,
    0,    0,    0,    0,    0,
};
final static short yygindex[] = {                         0,
  218,  287,    0,  378,  -82,  288,    0,  162,    0,    0,
    0,  115,  351,   10,    0,    0,    0,    0,  389,   68,
    0,   32,  -74,  252,  277,  -20,  305,    0,  -54,    0,
  -25,  219,  297,  102,    0,    0,    0,
};
final static int YYTABLESIZE=609;
static short yytable[];
static { yytable();}
static void yytable(){
yytable = new short[]{                        110,
   39,   60,   92,   47,  105,  121,   39,   59,   47,   60,
   55,  165,  168,  128,  223,  127,   47,    2,  159,   85,
   47,  216,   17,  254,   74,   36,   94,  201,   51,   69,
   51,  204,   60,  128,   47,  127,   73,   49,   59,   47,
  132,   52,   36,  183,   17,  133,    9,   47,  189,   18,
   50,   47,   25,   17,   66,   66,  231,  173,  175,  231,
  121,   45,   45,   45,   45,   45,   16,   45,  194,  194,
  140,  137,  177,  178,   11,   12,   13,   86,   87,   88,
   45,   37,   45,   37,   37,   37,  133,   36,  129,   36,
   36,   36,  113,  179,  100,  180,  136,  154,  142,  117,
   37,  128,   37,  127,   57,   64,   36,   35,   36,   35,
   35,   35,  186,  212,  199,   63,  213,  182,  129,  149,
  130,  211,  146,  225,   68,  128,   35,  127,   35,  188,
   18,  227,  218,   25,  220,   65,   72,  230,  229,  241,
  232,  121,   67,   53,   71,   45,   89,   16,  251,  157,
    1,   73,  137,  103,  253,   74,  205,  214,  207,  209,
  200,   17,   54,  172,  174,   37,  104,  133,  158,  129,
  107,   36,  242,  113,   74,  243,  163,   17,  128,  202,
  127,  128,  118,  127,   63,  137,  245,  138,  139,  246,
  119,   35,  151,   17,  169,  170,  142,  152,  142,  156,
  155,  162,  167,  141,  190,  147,  150,  191,  221,  235,
  236,  233,    8,   17,  109,   17,   38,   58,   91,   35,
  108,  120,  160,   17,  234,   58,  164,   74,  252,  222,
   36,   41,   74,  215,   75,   15,   44,   45,   46,   75,
   74,   44,   45,   46,   42,  112,  203,   75,   58,   44,
   45,   46,   43,   44,   45,   46,   17,   15,   74,    9,
  187,   18,  115,   74,   25,   75,   15,   44,   45,   46,
   75,   74,   44,   45,   46,   74,   45,   55,   16,   45,
   44,   45,   46,  137,   44,   45,   46,  101,   23,   23,
   45,   45,   45,   45,  237,   45,   37,  238,  133,   37,
  129,  217,   36,  219,  113,   36,   99,  113,  135,  153,
   37,   37,   37,   37,  239,   37,   36,   36,   36,   36,
  244,   36,   35,  113,  185,   35,  198,   23,  123,  124,
  125,  126,  255,  210,  148,  224,   35,   35,   35,   35,
   23,   35,   23,  226,   11,   12,   13,   11,   12,   13,
  228,  240,  114,   23,  161,  116,    4,    5,  134,  102,
    6,    7,    8,    9,   61,   10,   11,   12,   13,   14,
  196,  122,    4,    5,   15,   16,    6,    7,    8,   70,
    0,   10,   11,   12,   13,   14,    0,    0,    4,    5,
   15,  192,    6,    7,    8,    0,    0,   10,   11,   12,
   13,   14,    0,    0,    0,    0,   15,  249,   95,    5,
   53,    5,    6,    0,    6,    0,    0,   84,   95,    5,
    0,   83,    6,   83,    0,   23,   15,   82,   15,   54,
   96,   83,   96,    0,    0,    0,   15,    0,   23,   23,
    0,    0,    0,   23,    0,    0,  106,    0,  111,    0,
    0,  113,    5,    0,    0,    6,    0,    0,    0,    0,
    0,    0,    0,    0,   83,    0,   23,   23,    0,   15,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,  184,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,  106,  111,
    0,    0,    0,    0,    0,  181,    0,    0,   23,  171,
    0,    0,  176,    0,    0,    0,    0,    0,  193,  193,
    0,    0,    0,  197,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,  206,  208,    0,    0,
    0,    0,    0,    0,    0,    0,    0,  247,    0,  248,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,  250,
};
}
static short yycheck[];
static { yycheck(); }
static void yycheck() {
yycheck = new short[] {                         41,
   40,   40,   40,   45,   41,   40,   40,   46,   45,   40,
  123,   41,   41,   43,   41,   45,   45,  123,  125,   40,
   45,   44,   61,  125,  125,  269,   52,  123,  256,  256,
  256,   41,   40,   43,   45,   45,   59,    6,   46,   45,
   42,  269,  269,  269,   61,   47,   61,   45,   44,   44,
  269,   45,   44,   61,   44,   44,   44,  132,  133,   44,
   44,   41,   42,   43,   44,   45,   44,   47,  151,  152,
  262,   44,  258,  259,  266,  267,  268,  278,  279,  280,
   60,   41,   62,   43,   44,   45,   44,   41,   44,   43,
   44,   45,   44,  256,   44,  258,   44,   44,   89,   68,
   60,   43,   62,   45,  281,  256,   60,   41,   62,   43,
   44,   45,   44,  256,   44,   14,  259,  138,   60,   41,
   62,   44,   41,   44,   23,   43,   60,   45,   62,  125,
  125,   44,  187,  125,  189,  125,  125,  125,   44,   44,
  125,  125,   44,  256,  269,  125,  123,  125,  231,  256,
  256,   59,  125,  264,  256,  256,  177,  183,  179,  180,
  256,   61,  275,  132,  133,  125,  269,  125,  275,  125,
  269,  125,  256,  125,  275,  259,   41,   61,   43,   41,
   45,   43,  269,   45,   83,  256,  256,  258,  259,  259,
   46,  125,  123,   61,  127,  128,  187,  123,  189,   44,
  125,   58,  269,   89,  269,   91,   92,  269,   41,  200,
  201,  125,  262,   61,  256,   61,  256,  256,  256,    2,
   59,  256,  256,   61,  125,  256,  256,  269,  125,  256,
  269,  256,  269,  256,  276,  274,  278,  279,  280,  276,
  269,  278,  279,  280,  269,  256,  256,  276,  256,  278,
  279,  280,  277,  278,  279,  280,   61,  274,  269,  274,
  256,  256,  256,  269,  256,  276,  274,  278,  279,  280,
  276,  269,  278,  279,  280,  269,  256,  123,  256,  259,
  278,  279,  280,  256,  278,  279,  280,  125,    1,    2,
  270,  271,  272,  273,  259,  275,  256,  259,  256,  259,
  256,  187,  256,  189,  256,  259,  256,  259,  256,  256,
  270,  271,  272,  273,  259,  275,  270,  271,  272,  273,
  259,  275,  256,  275,  256,  259,  256,   40,  270,  271,
  272,  273,  259,  256,  256,  256,  270,  271,  272,  273,
   53,  275,   55,  256,  266,  267,  268,  266,  267,  268,
  256,  256,   66,   66,  103,   68,  256,  257,   82,   55,
  260,  261,  262,  263,   14,  265,  266,  267,  268,  269,
  152,   75,  256,  257,  274,  275,  260,  261,  262,   29,
   -1,  265,  266,  267,  268,  269,   -1,   -1,  256,  257,
  274,  275,  260,  261,  262,   -1,   -1,  265,  266,  267,
  268,  269,   -1,   -1,   -1,   -1,  274,  275,  256,  257,
  256,  257,  260,   -1,  260,   -1,   -1,   40,  256,  257,
   -1,  269,  260,  269,   -1,  138,  274,   39,  274,  275,
   53,  269,   55,   -1,   -1,   -1,  274,   -1,  151,  152,
   -1,   -1,   -1,  156,   -1,   -1,   58,   -1,   60,   -1,
   -1,   63,  257,   -1,   -1,  260,   -1,   -1,   -1,   -1,
   -1,   -1,   -1,   -1,  269,   -1,  179,  180,   -1,  274,
   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,
   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,
   -1,  141,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,
   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,  120,  121,
   -1,   -1,   -1,   -1,   -1,  138,   -1,   -1,  231,  131,
   -1,   -1,  134,   -1,   -1,   -1,   -1,   -1,  151,  152,
   -1,   -1,   -1,  156,   -1,   -1,   -1,   -1,   -1,   -1,
   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,
   -1,   -1,   -1,   -1,   -1,   -1,  179,  180,   -1,   -1,
   -1,   -1,   -1,   -1,   -1,   -1,   -1,  217,   -1,  219,
   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,
   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,
   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,
   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,  231,
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

//#line 425 "gramatica.y"
  private NodoControl raiz;
  private String ambitoAct = "main";
  static ArrayList<Error> erroresSemanticos = new ArrayList<Error>();
  static ArrayList<String> variables_declaradas = new ArrayList<String>();

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
//#line 651 "Parser.java"
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
{yyval=val_peek(1);}
break;
case 4:
//#line 23 "gramatica.y"
{yyval = new NodoComun("Sentencia", (Nodo) val_peek(2), (Nodo) val_peek(0));}
break;
case 5:
//#line 27 "gramatica.y"
{yyval=val_peek(0);}
break;
case 6:
//#line 28 "gramatica.y"
{yyval=val_peek(0);}
break;
case 7:
//#line 29 "gramatica.y"
{yyval=val_peek(0);}
break;
case 8:
//#line 30 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("RETURN definido fuera de funcion ");}
break;
case 9:
//#line 33 "gramatica.y"
{/*chequear q exista y bla bla*/
                            yyval = new NodoComun("ReferenciaFuncionObjeto",(Nodo)val_peek(2),(Nodo)val_peek(0));
                            AnalizadorLexico.agregarEstructura("Reconoce referencia objeto ");}
break;
case 10:
//#line 38 "gramatica.y"
{ /*chequear q exista y bla bla*/
                                                yyval = new NodoComun("ReferenciaFuncionObjeto",(Nodo)val_peek(2),(Nodo)val_peek(0));
                                                AnalizadorLexico.agregarEstructura("Reconoce llamado a funcion de clase ");}
break;
case 11:
//#line 43 "gramatica.y"
{yyval=val_peek(0);}
break;
case 12:
//#line 44 "gramatica.y"
{yyval=val_peek(0);}
break;
case 13:
//#line 45 "gramatica.y"
{yyval=val_peek(0);}
break;
case 14:
//#line 46 "gramatica.y"
{yyval=val_peek(0);}
break;
case 15:
//#line 47 "gramatica.y"
{yyval=val_peek(0);}
break;
case 16:
//#line 50 "gramatica.y"
{   for (String var : variables_declaradas) { /*CHEQUAER SI UNA VARIABLE CON ESE LEXEMA YA TIENE SETEADO EL USO, SI LO TIENE SETEADO ES PORQ YA EXITE*/
                                                Token t = TablaSimbolos.getToken(var);
                                                if (t != null){
                                                    t.setLexema(var + ":" + ambitoAct);
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
                                            variables_declaradas.clear();
                                          }
break;
case 18:
//#line 67 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se espera el tipo de la variable ");}
break;
case 19:
//#line 68 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se espera identificador de la variable ");}
break;
case 23:
//#line 74 "gramatica.y"
{variables_declaradas.add(val_peek(0).sval);}
break;
case 24:
//#line 75 "gramatica.y"
{yyval = val_peek(2) ; variables_declaradas.add(val_peek(0).sval);}
break;
case 26:
//#line 81 "gramatica.y"
{yyval = val_peek(0);}
break;
case 27:
//#line 82 "gramatica.y"
{yyval = val_peek(0);}
break;
case 28:
//#line 83 "gramatica.y"
{yyval = val_peek(0);}
break;
case 29:
//#line 86 "gramatica.y"
{
                    chequearEnteroPositivo(val_peek(0).sval);
                    yyval = new NodoHoja(val_peek(0).sval) ;
                    ((Nodo)yyval).setTipo(TablaSimbolos.getTipo(val_peek(0).sval));
                    ((Nodo)yyval).setUso("Constante");
                    TablaSimbolos.setUso(val_peek(0).sval, "Constante");
                   }
break;
case 30:
//#line 94 "gramatica.y"
{yyval = new NodoHoja(val_peek(0).sval);
	               chequearEnteroCorto(val_peek(0).sval);
	               ((Nodo)yyval).setTipo(TablaSimbolos.getTipo(val_peek(0).sval));
                   chequearEnteroPositivo(val_peek(0).sval);
                   ((Nodo)yyval).setUso("Constante");
                   TablaSimbolos.setUso(val_peek(0).sval, "Constante");
                   }
break;
case 31:
//#line 101 "gramatica.y"
{AnalizadorLexico.agregarErrorLexico("Un entero corto no puede ser negativo ");}
break;
case 32:
//#line 102 "gramatica.y"
{
	                chequearDouble(val_peek(0).sval);
	                yyval = new NodoHoja(val_peek(0).sval);
                    ((Nodo)yyval).setTipo(TablaSimbolos.getTipo(val_peek(0).sval));
                    ((Nodo)yyval).setUso("Constante");
                    TablaSimbolos.setUso(val_peek(0).sval, "Constante");
                    }
break;
case 33:
//#line 110 "gramatica.y"
{
                    yyval = new NodoHoja(val_peek(1).sval);
                    chequearEnteroNegativo(val_peek(0).sval);
                    ((Nodo)yyval).setTipo(TablaSimbolos.getTipo(val_peek(1).sval));
                    ((Nodo)yyval).setUso("Constante");
                    TablaSimbolos.setUso(val_peek(1).sval, "Constante");
	                }
break;
case 34:
//#line 117 "gramatica.y"
{
                            chequearDouble(val_peek(1).sval);
                            yyval = new NodoHoja(val_peek(1).sval);
                            ((Nodo)yyval).setTipo(TablaSimbolos.getTipo(val_peek(1).sval));
                            ((Nodo)yyval).setUso("Constante");
                            TablaSimbolos.setUso(val_peek(1).sval, "Constante");
                        }
break;
case 35:
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
case 36:
//#line 138 "gramatica.y"
{yyval = new NodoComun("-",(Nodo)val_peek(2),(Nodo)val_peek(0));
                        if (!((Nodo)val_peek(2)).getTipo().equals(((Nodo)val_peek(0)).getTipo())){
                            agregarErrorSemantico("No se puede realizar la suma. Tipos incompatibles ");
                        }
                        if (!((Nodo)val_peek(2)).getAmbito().equals(((Nodo)val_peek(0)).getAmbito())){
                            agregarErrorSemantico("Variable fuera de alcance ");
                        }

                      }
break;
case 37:
//#line 147 "gramatica.y"
{yyval=val_peek(0);}
break;
case 38:
//#line 148 "gramatica.y"
{yyval = val_peek(0);}
break;
case 39:
//#line 152 "gramatica.y"
{yyval = new NodoComun("-",(Nodo)val_peek(2),(Nodo)val_peek(0));
                               if (!((Nodo)val_peek(2)).getTipo().equals(((Nodo)val_peek(0)).getTipo())){
                                    agregarErrorSemantico("No se puede realizar la suma. Tipos incompatibles ");
                               }
                               if (!((Nodo)val_peek(2)).getAmbito().equals(((Nodo)val_peek(0)).getAmbito())){
                                    agregarErrorSemantico("Variable fuera de alcance ");
                               }

                              }
break;
case 40:
//#line 162 "gramatica.y"
{yyval = new NodoComun("-",(Nodo)val_peek(2),(Nodo)val_peek(0));
                    if (!((Nodo)val_peek(2)).getTipo().equals(((Nodo)val_peek(0)).getTipo())){
                        agregarErrorSemantico("No se puede realizar la suma. Tipos incompatibles ");
                    }
                    if (!((Nodo)val_peek(2)).getAmbito().equals(((Nodo)val_peek(0)).getAmbito())){
                        agregarErrorSemantico("Variable fuera de alcance ");
                    }
                    }
break;
case 41:
//#line 170 "gramatica.y"
{yyval = val_peek(0);}
break;
case 42:
//#line 171 "gramatica.y"
{yyval = new NodoComun("-",(Nodo)val_peek(2),(Nodo)val_peek(0));
                               if (!((Nodo)val_peek(2)).getTipo().equals(((Nodo)val_peek(0)).getTipo())){
                                    agregarErrorSemantico("No se puede realizar la suma. Tipos incompatibles ");
                               }
                               if (!((Nodo)val_peek(2)).getAmbito().equals(((Nodo)val_peek(0)).getAmbito())){
                                    agregarErrorSemantico("Variable fuera de alcance ");
                               }

                               }
break;
case 43:
//#line 180 "gramatica.y"
{yyval = new NodoComun("-",(Nodo)val_peek(2),(Nodo)val_peek(0));
                               if (!((Nodo)val_peek(2)).getTipo().equals(((Nodo)val_peek(0)).getTipo())){
                                    agregarErrorSemantico("No se puede realizar la suma. Tipos incompatibles ");
                               }
                               if (!((Nodo)val_peek(2)).getAmbito().equals(((Nodo)val_peek(0)).getAmbito())){
                                    agregarErrorSemantico("Variable fuera de alcance ");
                               }
                               }
break;
case 44:
//#line 188 "gramatica.y"
{yyval=val_peek(0);}
break;
case 45:
//#line 191 "gramatica.y"
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
case 46:
//#line 207 "gramatica.y"
{yyval=val_peek(0);}
break;
case 47:
//#line 210 "gramatica.y"
{yyval=val_peek(0);}
break;
case 48:
//#line 213 "gramatica.y"
{ yyval = new NodoComun(val_peek(2).sval,(Nodo)val_peek(3),(Nodo)val_peek(1));
                                                    ((Nodo)yyval).setTipo(((Nodo)val_peek(3)).getTipo());
                                                    ((Nodo)yyval).setUso("Condicion");
                                                     if (!((((Nodo)val_peek(3)).getTipo()).equals(((Nodo)val_peek(1)).getTipo()))){
                                                         agregarErrorSemantico("Error en la comparacion entre expresiones de distintos tipos"); /*CHEQUEAR CONVERSIONES*/
                                                     }
                                                     }
break;
case 49:
//#line 220 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba una ')' ");}
break;
case 50:
//#line 221 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba una '(' ");}
break;
case 51:
//#line 224 "gramatica.y"
{Nodo SentenciasIF = new NodoComun("SentenciasIF",new NodoControl("SentenciasIF",(Nodo)val_peek(3)), new NodoControl("SentenciasELSE",(Nodo)val_peek(1)));
                                                                      yyval= new NodoComun("BloqueIF", new NodoControl("Condicion",(Nodo)val_peek(4)), SentenciasIF);
                                                                      AnalizadorLexico.agregarEstructura("Reconoce IF ELSE ");}
break;
case 52:
//#line 227 "gramatica.y"
{yyval= new NodoComun("BloqueIF", new NodoControl("Condicion",(Nodo)val_peek(2)), new NodoControl("SentenciasIF",(Nodo)val_peek(1)));
	                                            AnalizadorLexico.agregarEstructura("Reconoce IF ");}
break;
case 53:
//#line 229 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("IF mal definido ");}
break;
case 54:
//#line 230 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("IF mal definido ");}
break;
case 55:
//#line 231 "gramatica.y"
{AnalizadorLexico.agregarEstructura("Reconoce IF ELSE");}
break;
case 56:
//#line 232 "gramatica.y"
{AnalizadorLexico.agregarEstructura("Reconoce IF ELSE");}
break;
case 57:
//#line 233 "gramatica.y"
{AnalizadorLexico.agregarEstructura("Reconoce IF ELSE");}
break;
case 58:
//#line 234 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba un END_IF ");}
break;
case 59:
//#line 235 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba un END_IF ");}
break;
case 60:
//#line 236 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba un END_IF ");}
break;
case 61:
//#line 237 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba un ELSE ");}
break;
case 62:
//#line 238 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("IF mal definido ");}
break;
case 63:
//#line 239 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba una ',' ");}
break;
case 64:
//#line 240 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba una ',' " );}
break;
case 65:
//#line 241 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba una ',' ");}
break;
case 68:
//#line 246 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Falta una ',' "); }
break;
case 70:
//#line 248 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Falta una ',' "); }
break;
case 71:
//#line 249 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Falta un '{'"); }
break;
case 72:
//#line 250 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Falta un '}'"); }
break;
case 73:
//#line 251 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("No hay sentencias dentro de las llaves."); }
break;
case 75:
//#line 257 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Solo se aceptan sentencias ejecutables "); }
break;
case 77:
//#line 259 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Falta una ',' "); }
break;
case 79:
//#line 265 "gramatica.y"
{yyval=val_peek(0);}
break;
case 80:
//#line 266 "gramatica.y"
{yyval=val_peek(0);}
break;
case 81:
//#line 267 "gramatica.y"
{yyval=val_peek(0);}
break;
case 82:
//#line 268 "gramatica.y"
{yyval=val_peek(0);}
break;
case 83:
//#line 269 "gramatica.y"
{yyval=val_peek(0);}
break;
case 84:
//#line 270 "gramatica.y"
{yyval=val_peek(0);}
break;
case 87:
//#line 278 "gramatica.y"
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
case 88:
//#line 292 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba un nombre para la funcion ");}
break;
case 89:
//#line 296 "gramatica.y"
{	yyval = new NodoHoja(val_peek(1).sval);

                           }
break;
case 90:
//#line 299 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba un ')' ");}
break;
case 91:
//#line 300 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba un '(' ");}
break;
case 93:
//#line 302 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba un ')' ");}
break;
case 94:
//#line 303 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba un '(' ");}
break;
case 101:
//#line 312 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba una ',' al final de la linea ");}
break;
case 102:
//#line 313 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba una ',' al final de la linea ");}
break;
case 103:
//#line 314 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba una ',' al final de la linea ");}
break;
case 104:
//#line 318 "gramatica.y"
{yyval=new NodoHoja(val_peek(2).sval);AnalizadorLexico.agregarEstructura("Reconoce llamado funcion ");}
break;
case 105:
//#line 319 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba un '(' ");}
break;
case 106:
//#line 320 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba un ')' ");}
break;
case 107:
//#line 321 "gramatica.y"
{yyval=new NodoComun("Llamado Funcion",(Nodo)val_peek(1),new NodoControl("Parametro Llamado Funcion",(Nodo)val_peek(0)));AnalizadorLexico.agregarEstructura("Reconoce llamado funcion ");}
break;
case 108:
//#line 324 "gramatica.y"
{yyval = new NodoControl("PRINT", new NodoHoja(val_peek(0).sval));
                             AnalizadorLexico.agregarEstructura("Reconoce salida de mensaje por pantalla ");}
break;
case 109:
//#line 326 "gramatica.y"
{yyval = new NodoControl("PRINT", new NodoHoja(val_peek(0).sval));
                            AnalizadorLexico.agregarEstructura("Reconoce salida de mensaje por pantalla ");}
break;
case 110:
//#line 328 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("La funcion PRINT no acepta esa declaracion ");}
break;
case 111:
//#line 331 "gramatica.y"
{yyval=val_peek(0);}
break;
case 112:
//#line 332 "gramatica.y"
{yyval=val_peek(0);}
break;
case 113:
//#line 335 "gramatica.y"
{AnalizadorLexico.agregarEstructura("Reconoce asignacion ");}
break;
case 114:
//#line 337 "gramatica.y"
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
case 117:
//#line 354 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba un valor seguido del operador ");}
break;
case 118:
//#line 355 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba un valor seguido del operador ");}
break;
case 119:
//#line 356 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba un operando del lado izquierdo ");}
break;
case 120:
//#line 359 "gramatica.y"
{yyval=new NodoComun("Sentencia DO UNTIL", new NodoControl("ListSentenciasDO",(Nodo)val_peek(2)), new NodoControl("CondicionDO", (Nodo)val_peek(0)));
                                                        AnalizadorLexico.agregarEstructura("Reconoce funcion DO UNTIL");}
break;
case 121:
//#line 361 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba una condicion ");}
break;
case 122:
//#line 366 "gramatica.y"
{yyval = val_peek(1);}
break;
case 123:
//#line 367 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba un '(' ");}
break;
case 124:
//#line 368 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba un ')' ");}
break;
case 125:
//#line 371 "gramatica.y"
{yyval = new NodoControl("TOD",(Nodo)val_peek(0));
                                            AnalizadorLexico.agregarEstructura("Reconoce funcion TOD ");
                                            }
break;
case 126:
//#line 375 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba una Expresion ");}
break;
case 128:
//#line 382 "gramatica.y"
{

                                               }
break;
case 132:
//#line 388 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba una ',' al final de la linea ");}
break;
case 133:
//#line 389 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba una ',' al final de la linea ");}
break;
case 134:
//#line 390 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba una ',' al final de la linea ");}
break;
case 135:
//#line 391 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba una ',' al final de la linea ");}
break;
case 136:
//#line 394 "gramatica.y"
{ 	String ambito = val_peek(1).sval;
						if (!(TablaSimbolos.existeSimbolo(val_peek(1).sval))) { /*PREGUNTAR TMB X USO EN COND*/
                                                   TablaSimbolos.getToken(val_peek(1).sval).setAmbito(ambitoAct);
                                                   actualizarAmbito(ambitoAct, ambito);
                                                   TablaSimbolos.getToken(val_peek(1).sval).setUso("Clase");
                                                   AnalizadorLexico.agregarEstructura("Reconoce CLASE");
                                               } else {
                                                    agregarErrorSemantico("Clase " + val_peek(1).sval + " ya definida en el ambito actual");
                                               }
                                              int index = ambitoAct.lastIndexOf(":");
                                              ambitoAct = ambitoAct.substring(0, index);
                                              }
break;
case 137:
//#line 409 "gramatica.y"
{AnalizadorLexico.agregarEstructura("Reconoce Funcion sin cuerpo");}
break;
case 138:
//#line 413 "gramatica.y"
{AnalizadorLexico.agregarEstructura("Reconoce funcion IMPL");}
break;
case 139:
//#line 414 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba un '{' ");}
break;
case 140:
//#line 415 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba un '}' ");}
break;
//#line 1422 "Parser.java"
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
