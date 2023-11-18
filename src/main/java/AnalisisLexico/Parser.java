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
   34,   34,    9,    9,    9,    9,    9,    9,    3,    3,
   33,   33,   33,   21,   21,   35,   36,   36,   36,   36,
   36,   36,   36,   36,   15,   30,   17,   17,   17,
};
final static short yylen[] = {                            2,
    3,    3,    3,    2,    1,    1,    1,    2,    3,    3,
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
    1,    1,    3,    3,    3,    3,    3,    2,    4,    4,
    3,    3,    3,    2,    3,    3,    3,    4,    2,    3,
    3,    4,    2,    3,    3,    3,    7,    7,    7,
};
final static short yydefred[] = {                         0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
   27,   26,   28,    0,  112,    0,  111,    0,    0,    5,
    6,    7,    0,   15,   12,   11,   13,   14,    0,   17,
   20,   21,   22,    0,    0,   23,    0,    0,    0,    0,
  110,   45,  108,   29,   30,   32,    0,   46,  109,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,  107,    0,    8,    2,    0,    4,    0,   19,    0,
  118,    1,    0,    0,    0,   47,    0,    0,   38,   41,
   44,    0,    0,    0,    0,   33,   31,   34,    0,  135,
    0,    0,    0,    0,   75,    0,    0,    0,   68,   67,
   73,    0,    0,    0,  105,    0,    0,   10,  106,  104,
    0,  117,    0,    3,  116,  114,  115,   24,    0,    0,
    0,  124,   83,   84,   82,   81,    0,    0,   79,   80,
    0,    0,    0,    0,    0,    0,   54,    0,   52,    0,
    0,   85,    0,   86,    0,   94,    0,   93,   92,    0,
    0,    0,   77,   76,   71,    0,   72,    0,   66,    0,
  119,    0,  122,  123,  121,    9,  125,    0,    0,    0,
   39,   42,   40,   43,    0,    0,   65,    0,    0,    0,
    0,    0,    0,  133,  129,    0,  126,    0,    0,    0,
    0,    0,    0,    0,    0,   78,    0,    0,    0,    0,
   50,   49,   48,    0,    0,    0,    0,    0,    0,    0,
   53,   51,    0,  131,  127,    0,  134,    0,  130,   91,
   90,   89,  103,   99,  101,   97,  102,   98,   88,    0,
   87,   70,   69,    0,    0,   63,   62,   61,   59,    0,
   58,   55,   64,   60,   57,    0,    0,  100,   96,   95,
  138,  139,  137,   56,
};
final static short yydgoto[] = {                          3,
   18,   19,   20,   21,   22,   23,   24,   25,   26,   27,
   28,   29,   37,   30,   31,   32,   33,   48,   77,   78,
   79,   80,   81,   40,  131,   56,   97,   98,  143,  144,
   93,  194,   62,   34,   90,  145,
};
final static short yysindex[] = {                      -105,
  107,  107,    0, -249,  -39,  -24, -241, -218,  -96, -239,
    0,    0,    0,  -38,    0, -189,    0,   91,   36,    0,
    0,    0,  -50,    0,    0,    0,    0,    0, -213,    0,
    0,    0,    0, -164,  132,    0,   61,   -5,   -5,  218,
    0,    0,    0,    0,    0,    0, -205,    0,    0,   -8,
  -37,  -37,  197,   43,  246, -143, -144,  -36, -136,  -41,
   61,    0,  -10,    0,    0,   96,    0,    7,    0,   61,
    0,    0,  -92,  118,  -34,    0,   57,   52,    0,    0,
    0,   57,   -7,   54, -111,    0,    0,    0,  -79,    0,
   77,   65,   58,   68,    0,   69,   73,  142,    0,    0,
    0, -106,  -33,  136,    0,  122,  -30,    0,    0,    0,
  -29,    0,   71,    0,    0,    0,    0,    0,  -65,   -5,
  -28,    0,    0,    0,    0,    0,    3,    3,    0,    0,
   -5,    3,    3,   -5, -163,  -56,    0,  218,    0, -198,
 -249,    0,   78,    0,    9,    0,  -61,    0,    0,  -57,
  148,  148,    0,    0,    0,  199,    0,   79,    0,   -5,
    0,  -94,    0,    0,    0,    0,    0,   52,   52,  156,
    0,    0,    0,    0,   -9,  -96,    0,  218,  218,   80,
 -209,  -37,  -22,    0,    0,  -79,    0,  -79,  172,  -26,
   93,   94,   99,    1,   11,    0,   89,   95,   -1,   -1,
    0,    0,    0,   19,   39,   87,  105, -124,  103,  -83,
    0,    0,   68,    0,    0, -249,    0, -249,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,  164,
    0,    0,    0,  104, -101,    0,    0,    0,    0,  119,
    0,    0,    0,    0,    0,   61,   61,    0,    0,    0,
    0,    0,    0,    0,
};
final static short yyrindex[] = {                         0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,   28,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
   32,    0,    0,    0,    0,    0,    0,    0,    0,   33,
    0,    0,    0,   21,    0,    0,    0,   41,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,  -95,    0,    0,
    0,    0,    0,    0,    0,    0,  -12,    0,    0,    0,
    0,    0,   49,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,  177,
    0,    0,    0,    0,    0,    0,    0,   47,   67,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,   34,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,   45,   53,    0,    0,    0,
    0,    0,    0,    0,
};
final static short yygindex[] = {                         0,
  293,   26,    0,  387, -126,  426,    0,  245,    0,    0,
    0,  -32,  161,  -58,    0,    0,    0,    0,  441,   83,
    0,   63,   74,  212,  298,    6,  328,    0,   17,    0,
  -11,  232,  310,   56,    0,    0,
};
final static int YYTABLESIZE=617;
static short yytable[];
static { yytable();}
static void yytable(){
yytable = new short[]{                        110,
   39,   60,   92,   47,  105,  121,   39,   59,   47,   60,
   17,  165,  167,  128,  222,  127,   47,    2,  159,   36,
   47,  215,   17,  253,  193,  193,   55,   50,  200,   74,
  142,  203,   60,  128,   47,  127,   73,   51,   59,   47,
   94,   57,   69,   66,  230,   85,  211,   47,    9,  212,
   52,   47,  188,   17,  230,   36,  141,   51,  147,  150,
   66,   45,   45,   45,   45,   45,   64,   45,   49,   63,
  182,   18,   86,   87,   88,   25,   16,  136,   68,   67,
   45,   37,   45,   37,   37,   37,  100,   36,  132,   36,
   36,   36,  113,  132,  176,  177,  128,  136,  133,  128,
   37,  127,   37,  250,   71,  149,   36,   35,   36,   35,
   35,   35,  154,  128,   89,  127,  129,  146,  130,   73,
  103,  185,  198,  210,  104,  229,   35,  142,   35,  142,
  117,  241,  107,  187,  242,  231,  224,  226,   63,  114,
  234,  235,  228,  181,  137,   45,  138,  139,  240,  157,
    1,   17,   18,  216,  252,  218,   25,   16,  136,   53,
   74,  199,  163,  119,  128,   37,  127,   17,  158,  132,
  213,   36,  244,  113,   61,  245,  118,  128,   54,   74,
  151,  204,  140,  206,  208,  156,   11,   12,   13,   70,
  152,   35,   17,  162,  171,  173,  201,  155,  128,  178,
  127,  179,  217,  166,  219,  172,  174,  189,   17,  168,
  169,  190,  220,  232,  109,   65,   38,   58,   91,  233,
  120,  120,  160,   15,   17,   58,  164,   74,  251,  221,
   36,   41,   74,  214,   75,   15,   44,   45,   46,   75,
   74,   44,   45,   46,   42,  112,  202,   75,   58,   44,
   45,   46,   43,   44,   45,   46,   72,   17,   74,   17,
    8,    9,  115,   74,  186,   75,   15,   44,   45,   46,
   75,   74,   44,   45,   46,   74,   45,  236,   17,   45,
   44,   45,   46,   18,   44,   45,   46,   25,   16,  136,
   45,   45,   45,   45,   35,   45,   37,  237,   99,   37,
  132,  183,   36,  108,  113,   36,   17,  113,  128,  135,
   37,   37,   37,   37,  161,   37,   36,   36,   36,   36,
  148,   36,   35,  113,  153,   35,  123,  124,  125,  126,
   11,   12,   13,  184,  197,  209,   35,   35,   35,   35,
   55,   35,   11,   12,   13,  238,    4,    5,  223,  225,
    6,    7,    8,    9,  227,   10,   11,   12,   13,   14,
  239,  243,    4,    5,   15,   16,    6,    7,    8,    9,
  101,   10,   11,   12,   13,   14,  246,  254,  247,  134,
   15,   16,  102,  195,  122,    0,    0,    4,    5,    0,
    0,    6,    7,    8,    9,    0,   10,   11,   12,   13,
   14,    0,    0,    4,    5,   15,   16,    6,    7,    8,
    0,    0,   10,   11,   12,   13,   14,    0,    0,    4,
    5,   15,  191,    6,    7,    8,   84,    0,   10,   11,
   12,   13,   14,    0,    0,    0,    0,   15,  248,   96,
    0,   96,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,   95,    5,    0,    5,    6,    0,    6,    0,
    0,    0,    0,   76,   76,   83,    0,   83,    0,    0,
   15,    0,   15,   53,    5,    0,    0,    6,    0,   82,
    0,    0,    0,   76,    0,   76,   83,    0,   76,    0,
    0,   15,   54,  116,    0,    0,    0,    0,  106,    0,
  111,   95,    5,  113,    0,    6,    0,    0,    0,    0,
    0,    0,    0,    0,   83,    0,    0,    0,    0,   15,
    0,    0,    0,    0,  180,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,  192,  192,    0,
    0,    0,  196,    0,    0,   76,   76,    0,    0,    0,
    0,    0,   76,   76,    0,    0,   76,   76,   76,   76,
  106,  111,    0,    0,  205,  207,    0,    0,    0,    0,
    0,  170,    0,    0,  175,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,   76,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,  249,
};
}
static short yycheck[];
static { yycheck(); }
static void yycheck() {
yycheck = new short[] {                         41,
   40,   40,   40,   45,   41,   40,   40,   46,   45,   40,
   61,   41,   41,   43,   41,   45,   45,  123,  125,  269,
   45,   44,   61,  125,  151,  152,  123,  269,  123,  125,
   89,   41,   40,   43,   45,   45,   59,  256,   46,   45,
   52,  281,  256,   18,   44,   40,  256,   45,   61,  259,
  269,   45,   44,   61,   44,  269,   89,  256,   91,   92,
   35,   41,   42,   43,   44,   45,  256,   47,    6,   14,
  269,   44,  278,  279,  280,   44,   44,   44,   23,   44,
   60,   41,   62,   43,   44,   45,   44,   41,   44,   43,
   44,   45,   44,   42,  258,  259,   44,   44,   47,   43,
   60,   45,   62,  230,  269,   41,   60,   41,   62,   43,
   44,   45,   44,   43,  123,   45,   60,   41,   62,   59,
  264,   44,   44,   44,  269,  125,   60,  186,   62,  188,
   68,  256,  269,  125,  259,  125,   44,   44,   83,   44,
  199,  200,   44,  138,  256,  125,  258,  259,   44,  256,
  256,   61,  125,  186,  256,  188,  125,  125,  125,  256,
  256,  256,   41,   46,   43,  125,   45,   61,  275,  125,
  182,  125,  256,  125,   14,  259,  269,  125,  275,  275,
  123,  176,  262,  178,  179,   44,  266,  267,  268,   29,
  123,  125,   61,   58,  132,  133,   41,  125,   43,  256,
   45,  258,  186,  269,  188,  132,  133,  269,   61,  127,
  128,  269,   41,  125,  256,  125,  256,  256,  256,  125,
   44,  256,  256,  274,   61,  256,  256,  269,  125,  256,
  269,  256,  269,  256,  276,  274,  278,  279,  280,  276,
  269,  278,  279,  280,  269,  256,  256,  276,  256,  278,
  279,  280,  277,  278,  279,  280,  125,   61,  269,   61,
  262,  274,  256,  269,  256,  276,  274,  278,  279,  280,
  276,  269,  278,  279,  280,  269,  256,  259,   61,  259,
  278,  279,  280,  256,  278,  279,  280,  256,  256,  256,
  270,  271,  272,  273,    2,  275,  256,  259,  256,  259,
  256,  141,  256,   59,  256,  259,   61,  259,  256,  256,
  270,  271,  272,  273,  103,  275,  270,  271,  272,  273,
  256,  275,  256,  275,  256,  259,  270,  271,  272,  273,
  266,  267,  268,  256,  256,  256,  270,  271,  272,  273,
  123,  275,  266,  267,  268,  259,  256,  257,  256,  256,
  260,  261,  262,  263,  256,  265,  266,  267,  268,  269,
  256,  259,  256,  257,  274,  275,  260,  261,  262,  263,
  125,  265,  266,  267,  268,  269,  216,  259,  218,   82,
  274,  275,   55,  152,   75,   -1,   -1,  256,  257,   -1,
   -1,  260,  261,  262,  263,   -1,  265,  266,  267,  268,
  269,   -1,   -1,  256,  257,  274,  275,  260,  261,  262,
   -1,   -1,  265,  266,  267,  268,  269,   -1,   -1,  256,
  257,  274,  275,  260,  261,  262,   40,   -1,  265,  266,
  267,  268,  269,   -1,   -1,   -1,   -1,  274,  275,   53,
   -1,   55,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,
   -1,   -1,  256,  257,   -1,  257,  260,   -1,  260,   -1,
   -1,   -1,   -1,   38,   39,  269,   -1,  269,   -1,   -1,
  274,   -1,  274,  256,  257,   -1,   -1,  260,   -1,   39,
   -1,   -1,   -1,   58,   -1,   60,  269,   -1,   63,   -1,
   -1,  274,  275,   68,   -1,   -1,   -1,   -1,   58,   -1,
   60,  256,  257,   63,   -1,  260,   -1,   -1,   -1,   -1,
   -1,   -1,   -1,   -1,  269,   -1,   -1,   -1,   -1,  274,
   -1,   -1,   -1,   -1,  138,   -1,   -1,   -1,   -1,   -1,
   -1,   -1,   -1,   -1,   -1,   -1,   -1,  151,  152,   -1,
   -1,   -1,  156,   -1,   -1,  120,  121,   -1,   -1,   -1,
   -1,   -1,  127,  128,   -1,   -1,  131,  132,  133,  134,
  120,  121,   -1,   -1,  178,  179,   -1,   -1,   -1,   -1,
   -1,  131,   -1,   -1,  134,   -1,   -1,   -1,   -1,   -1,
   -1,   -1,   -1,   -1,   -1,  160,   -1,   -1,   -1,   -1,
   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,
   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,
   -1,   -1,   -1,   -1,   -1,   -1,  230,
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
"Asignacion : ID OperadorAsignacion Expresion",
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

//#line 402 "gramatica.y"
  private NodoControl raiz;
  private String ambitoAct = "main";
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

   public void actualizarAmbito(String ambitoAct, String a){
        ambitoAct += ":"+a;
   }

   public String estaAlAlcance(String lexema){ //EN CASO DE QUE ESTE AL ALCANCE DEVUELVE EL LEXEMA CORRECTO, CASO CONTRARIO DEVUELVE EL NOMBRE DE LA VARIABLE SOLA
           if (!TablaSimbolos.existeSimbolo(lexema)){
                char [] a = lexema.toCharArray();
                for (int i = a.length;i>0;i--){
                   if(a[i-1] == ':'){
                       lexema = lexema.substring(0,i-1);
                       lexema = estaAlAlcance(lexema);
                   }
                }
           }
           return lexema;
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
//#line 677 "Parser.java"
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
{yyval=val_peek(0);}
break;
case 6:
//#line 28 "gramatica.y"
{yyval=val_peek(0);}
break;
case 7:
//#line 29 "gramatica.y"
{yyval= new NodoHoja("SENTENCIA DECLARATIVA");}
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
{tipoActual = val_peek(0).sval;}
break;
case 27:
//#line 82 "gramatica.y"
{tipoActual = val_peek(0).sval;}
break;
case 28:
//#line 83 "gramatica.y"
{tipoActual = val_peek(0).sval;}
break;
case 29:
//#line 86 "gramatica.y"
{
                    chequearEnteroPositivo(val_peek(0).sval);
                    yyval = new NodoHoja(val_peek(0).sval) ;
                    ((Nodo)yyval).setTipo("INT");
                    ((Nodo)yyval).setUso("Constante");
                   }
break;
case 30:
//#line 93 "gramatica.y"
{yyval = new NodoHoja(val_peek(0).sval);
	               chequearEnteroCorto(val_peek(0).sval);
	               ((Nodo)yyval).setTipo("USHORT");
                   chequearEnteroPositivo(val_peek(0).sval);
                   ((Nodo)yyval).setUso("Constante");
                   }
break;
case 31:
//#line 99 "gramatica.y"
{AnalizadorLexico.agregarErrorLexico("Un entero corto no puede ser negativo ");}
break;
case 32:
//#line 100 "gramatica.y"
{
	                chequearDouble(val_peek(0).sval);
	                yyval = new NodoHoja(val_peek(0).sval);
                    ((Nodo)yyval).setTipo("DOUBLE");
                    ((Nodo)yyval).setUso("Constante");
                    }
break;
case 33:
//#line 107 "gramatica.y"
{
                    yyval = new NodoHoja(val_peek(1).sval);
                    chequearEnteroNegativo(val_peek(0).sval);
                    ((Nodo)yyval).setTipo("INT");
                    ((Nodo)yyval).setUso("Constante");
	                }
break;
case 34:
//#line 113 "gramatica.y"
{
                            chequearDouble(val_peek(1).sval);
                            yyval = new NodoHoja(val_peek(1).sval);
                            ((Nodo)yyval).setTipo("DOUBLE");
                            ((Nodo)yyval).setUso("Constante");
                        }
break;
case 35:
//#line 121 "gramatica.y"
{ yyval = new NodoComun("+",(Nodo)val_peek(2),(Nodo)val_peek(0));
                                    if (!((Nodo)val_peek(2)).getAmbito().equals(((Nodo)val_peek(0)).getAmbito())){
                                          agregarErrorSemantico("Variable fuera de alcance ");
                                    }
                                        ((Nodo)yyval).setTipo(tipoPredominante(((Nodo)val_peek(2)).getTipo(),((Nodo)val_peek(0)).getTipo()));
                                    }
break;
case 36:
//#line 128 "gramatica.y"
{yyval = new NodoComun("-",(Nodo)val_peek(2),(Nodo)val_peek(0));
                        if (!((Nodo)val_peek(2)).getAmbito().equals(((Nodo)val_peek(0)).getAmbito())){
                            agregarErrorSemantico("Variable fuera de alcance ");
                        }
                            ((Nodo)yyval).setTipo(tipoPredominante(((Nodo)val_peek(2)).getTipo(),((Nodo)val_peek(0)).getTipo()));
                      }
break;
case 37:
//#line 134 "gramatica.y"
{yyval=val_peek(0);}
break;
case 38:
//#line 135 "gramatica.y"
{yyval = val_peek(0);}
break;
case 39:
//#line 139 "gramatica.y"
{yyval = new NodoComun("*",(Nodo)val_peek(2),(Nodo)val_peek(0));
                               if (!((Nodo)val_peek(2)).getAmbito().equals(((Nodo)val_peek(0)).getAmbito())){
                                    agregarErrorSemantico("Variable fuera de alcance ");
                               }
                                    ((Nodo)yyval).setTipo(tipoPredominante(((Nodo)val_peek(2)).getTipo(),((Nodo)val_peek(0)).getTipo()));
                              }
break;
case 40:
//#line 146 "gramatica.y"
{yyval = new NodoComun("/",(Nodo)val_peek(2),(Nodo)val_peek(0));
                    if (!((Nodo)val_peek(2)).getAmbito().equals(((Nodo)val_peek(0)).getAmbito())){
                        agregarErrorSemantico("Variable fuera de alcance ");
                    }
                        ((Nodo)yyval).setTipo(tipoPredominante(((Nodo)val_peek(2)).getTipo(),((Nodo)val_peek(0)).getTipo()));
                    }
break;
case 41:
//#line 152 "gramatica.y"
{yyval = val_peek(0);}
break;
case 42:
//#line 153 "gramatica.y"
{yyval = new NodoComun("*",(Nodo)val_peek(2),(Nodo)val_peek(0));
                               if (!((Nodo)val_peek(2)).getAmbito().equals(((Nodo)val_peek(0)).getAmbito())){
                                    agregarErrorSemantico("Variable fuera de alcance ");
                               }
                                     ((Nodo)yyval).setTipo(tipoPredominante(((Nodo)val_peek(2)).getTipo(),((Nodo)val_peek(0)).getTipo()));
                               }
break;
case 43:
//#line 159 "gramatica.y"
{yyval = new NodoComun("/",(Nodo)val_peek(2),(Nodo)val_peek(0));
                               if (!((Nodo)val_peek(2)).getAmbito().equals(((Nodo)val_peek(0)).getAmbito())){
                                    agregarErrorSemantico("Variable fuera de alcance ");
                               }
                                    ((Nodo)yyval).setTipo(tipoPredominante(((Nodo)val_peek(2)).getTipo(),((Nodo)val_peek(0)).getTipo()));
                               }
break;
case 44:
//#line 165 "gramatica.y"
{yyval=val_peek(0);}
break;
case 45:
//#line 168 "gramatica.y"
{yyval = new NodoHoja(val_peek(0).sval);
            String var = val_peek(0).sval + ":" + ambitoAct;
            var = estaAlAlcance(var);
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
case 46:
//#line 185 "gramatica.y"
{yyval=val_peek(0);}
break;
case 47:
//#line 188 "gramatica.y"
{yyval=val_peek(0);}
break;
case 48:
//#line 191 "gramatica.y"
{ yyval = new NodoComun(val_peek(2).sval,(Nodo)val_peek(3),(Nodo)val_peek(1));
                                                    ((Nodo)yyval).setTipo(((Nodo)val_peek(3)).getTipo());
                                                    ((Nodo)yyval).setUso("Condicion");
                                                     if (!((((Nodo)val_peek(3)).getTipo()).equals(((Nodo)val_peek(1)).getTipo()))){
                                                         agregarErrorSemantico("Error en la comparacion entre expresiones de distintos tipos"); /*CHEQUEAR CONVERSIONES*/
                                                     }
                                                     }
break;
case 49:
//#line 198 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba una ')' ");}
break;
case 50:
//#line 199 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba una '(' ");}
break;
case 51:
//#line 202 "gramatica.y"
{Nodo SentenciasIF = new NodoComun("SentenciasIF",new NodoControl("SentenciasIF",(Nodo)val_peek(3)), new NodoControl("SentenciasELSE",(Nodo)val_peek(1)));
                                                                      yyval= new NodoComun("BloqueIF", new NodoControl("Condicion",(Nodo)val_peek(4)), SentenciasIF);
                                                                      AnalizadorLexico.agregarEstructura("Reconoce IF ELSE ");}
break;
case 52:
//#line 205 "gramatica.y"
{yyval= new NodoComun("BloqueIF", new NodoControl("Condicion",(Nodo)val_peek(2)), new NodoControl("SentenciasIF",(Nodo)val_peek(1)));
	                                            AnalizadorLexico.agregarEstructura("Reconoce IF ");}
break;
case 53:
//#line 207 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("IF mal definido ");}
break;
case 54:
//#line 208 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("IF mal definido ");}
break;
case 55:
//#line 209 "gramatica.y"
{AnalizadorLexico.agregarEstructura("Reconoce IF ELSE");}
break;
case 56:
//#line 210 "gramatica.y"
{AnalizadorLexico.agregarEstructura("Reconoce IF ELSE");}
break;
case 57:
//#line 211 "gramatica.y"
{AnalizadorLexico.agregarEstructura("Reconoce IF ELSE");}
break;
case 58:
//#line 212 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba un END_IF ");}
break;
case 59:
//#line 213 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba un END_IF ");}
break;
case 60:
//#line 214 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba un END_IF ");}
break;
case 61:
//#line 215 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba un ELSE ");}
break;
case 62:
//#line 216 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("IF mal definido ");}
break;
case 63:
//#line 217 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba una ',' ");}
break;
case 64:
//#line 218 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba una ',' " );}
break;
case 65:
//#line 219 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba una ',' ");}
break;
case 68:
//#line 224 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Falta una ',' "); }
break;
case 70:
//#line 226 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Falta una ',' "); }
break;
case 71:
//#line 227 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Falta un '{'"); }
break;
case 72:
//#line 228 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Falta un '}'"); }
break;
case 73:
//#line 229 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("No hay sentencias dentro de las llaves."); }
break;
case 75:
//#line 235 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Solo se aceptan sentencias ejecutables "); }
break;
case 77:
//#line 237 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Falta una ',' "); }
break;
case 79:
//#line 243 "gramatica.y"
{yyval=val_peek(0);}
break;
case 80:
//#line 244 "gramatica.y"
{yyval=val_peek(0);}
break;
case 81:
//#line 245 "gramatica.y"
{yyval=val_peek(0);}
break;
case 82:
//#line 246 "gramatica.y"
{yyval=val_peek(0);}
break;
case 83:
//#line 247 "gramatica.y"
{yyval=val_peek(0);}
break;
case 84:
//#line 248 "gramatica.y"
{yyval=val_peek(0);}
break;
case 87:
//#line 256 "gramatica.y"
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
//#line 270 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba un nombre para la funcion ");}
break;
case 89:
//#line 274 "gramatica.y"
{	yyval = new NodoHoja(val_peek(1).sval);

                           }
break;
case 90:
//#line 277 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba un ')' ");}
break;
case 91:
//#line 278 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba un '(' ");}
break;
case 93:
//#line 280 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba un ')' ");}
break;
case 94:
//#line 281 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba un '(' ");}
break;
case 101:
//#line 290 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba una ',' al final de la linea ");}
break;
case 102:
//#line 291 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba una ',' al final de la linea ");}
break;
case 103:
//#line 292 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba una ',' al final de la linea ");}
break;
case 104:
//#line 296 "gramatica.y"
{yyval=new NodoHoja(val_peek(2).sval);AnalizadorLexico.agregarEstructura("Reconoce llamado funcion ");}
break;
case 105:
//#line 297 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba un '(' ");}
break;
case 106:
//#line 298 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba un ')' ");}
break;
case 107:
//#line 299 "gramatica.y"
{yyval=new NodoComun("Llamado Funcion",(Nodo)val_peek(1),new NodoControl("Parametro Llamado Funcion",(Nodo)val_peek(0)));AnalizadorLexico.agregarEstructura("Reconoce llamado funcion ");}
break;
case 108:
//#line 302 "gramatica.y"
{yyval = new NodoControl("PRINT", new NodoHoja(val_peek(0).sval));
                             AnalizadorLexico.agregarEstructura("Reconoce salida de mensaje por pantalla ");}
break;
case 109:
//#line 304 "gramatica.y"
{yyval = new NodoControl("PRINT", new NodoHoja(val_peek(0).sval));
                            AnalizadorLexico.agregarEstructura("Reconoce salida de mensaje por pantalla ");}
break;
case 110:
//#line 306 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("La funcion PRINT no acepta esa declaracion ");}
break;
case 111:
//#line 309 "gramatica.y"
{yyval=val_peek(0);}
break;
case 112:
//#line 310 "gramatica.y"
{yyval=val_peek(0);}
break;
case 113:
//#line 313 "gramatica.y"
{AnalizadorLexico.agregarEstructura("Reconoce asignacion ");
						                        yyval = new NodoComun(val_peek(1).sval,(Nodo)val_peek(2),(Nodo)val_peek(0));
						                        Token t1 = TablaSimbolos.getToken(val_peek(2).sval);
						                        if (t1.getUso() != null){
						                            if (!estaAlAlcance(val_peek(2).sval + ":" + ambitoAct).equals(val_peek(2).sval)){
                                                        ((Nodo)yyval).setTipo(tipoPredominante(((Nodo)val_peek(2)).getTipo(),((Nodo)val_peek(0)).getTipo()));
						                            }
						                            else {
						                                agregarErrorSemantico("Variable " + val_peek(2).sval +" fuera de alcance");
						                            }
						                        }
						                        else {
						                            agregarErrorSemantico("Variable " + t1.getLexema() + " no definida");
						                        }
					    }
break;
case 116:
//#line 331 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba un valor seguido del operador ");}
break;
case 117:
//#line 332 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba un valor seguido del operador ");}
break;
case 118:
//#line 333 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba un operando del lado izquierdo ");}
break;
case 119:
//#line 336 "gramatica.y"
{yyval=new NodoComun("Sentencia DO UNTIL", new NodoControl("ListSentenciasDO",(Nodo)val_peek(2)), new NodoControl("CondicionDO", (Nodo)val_peek(0)));
                                                        AnalizadorLexico.agregarEstructura("Reconoce funcion DO UNTIL");}
break;
case 120:
//#line 338 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba una condicion ");}
break;
case 121:
//#line 343 "gramatica.y"
{yyval = val_peek(1);}
break;
case 122:
//#line 344 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba un '(' ");}
break;
case 123:
//#line 345 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba un ')' ");}
break;
case 124:
//#line 348 "gramatica.y"
{yyval = new NodoControl("TOD",(Nodo)val_peek(0));
                                            AnalizadorLexico.agregarEstructura("Reconoce funcion TOD ");
                                            }
break;
case 125:
//#line 352 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba una Expresion ");}
break;
case 127:
//#line 359 "gramatica.y"
{

                                               }
break;
case 131:
//#line 365 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba una ',' al final de la linea ");}
break;
case 132:
//#line 366 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba una ',' al final de la linea ");}
break;
case 133:
//#line 367 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba una ',' al final de la linea ");}
break;
case 134:
//#line 368 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba una ',' al final de la linea ");}
break;
case 135:
//#line 371 "gramatica.y"
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
case 136:
//#line 386 "gramatica.y"
{AnalizadorLexico.agregarEstructura("Reconoce Funcion sin cuerpo");}
break;
case 137:
//#line 390 "gramatica.y"
{AnalizadorLexico.agregarEstructura("Reconoce funcion IMPL");}
break;
case 138:
//#line 391 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba un '{' ");}
break;
case 139:
//#line 392 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba un '}' ");}
break;
//#line 1423 "Parser.java"
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
