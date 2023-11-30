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
import java.io.*;
import a.AnalisisLexico.*;
import b.GeneracionCodigoIntermedio.*;
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
    4,    4,    4,    4,    4,    4,    4,   14,   14,   17,
   19,   19,   13,   13,   13,   20,   20,   20,   20,   20,
   20,   21,   21,   21,   21,   22,   22,   22,   22,   22,
   22,   24,   24,   25,   26,   26,   26,   10,   10,   10,
   10,   10,   10,   10,   10,   10,   10,   10,   10,   10,
   10,   10,   28,   28,   28,   28,   28,   28,   29,   30,
   30,   30,   30,   27,   27,   27,   27,   27,   27,   15,
   15,   31,   31,   31,   31,   31,   33,   34,   34,   34,
   34,   34,   34,   35,   35,   35,   35,   35,    8,    8,
    8,    8,   11,   11,   11,   36,   36,    9,    9,    9,
    9,    9,    9,    3,    3,    3,    3,    3,    3,   37,
   37,   37,   23,   23,   38,   39,   16,   32,   18,   18,
   18,   18,
};
final static short yylen[] = {                            2,
    3,    3,    3,    2,    2,    1,    1,    1,    2,    3,
    3,    1,    1,    1,    1,    1,    3,    2,    2,    3,
    2,    1,    2,    2,    1,    1,    1,    1,    3,    2,
    1,    3,    1,    1,    1,    1,    1,    2,    1,    2,
    2,    3,    3,    1,    1,    3,    3,    1,    3,    3,
    1,    1,    1,    1,    5,    5,    5,    6,    4,    6,
    4,    7,    8,    7,    7,    7,    7,    7,    7,    7,
    7,    5,    3,    5,    5,    3,    3,    2,    1,    1,
    2,    2,    3,    1,    1,    1,    1,    1,    1,    1,
    1,    7,    7,    5,    6,    4,    2,    4,    4,    4,
    2,    2,    2,    3,    2,    2,    2,    2,    3,    3,
    3,    4,    2,    2,    2,    1,    1,    3,    3,    3,
    3,    3,    2,    4,    4,    5,    5,    4,    4,    3,
    3,    3,    2,    3,    3,    2,    2,    2,    7,    7,
    7,    7,
};
final static short yydefred[] = {                         0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
   34,   33,   35,    0,  117,    0,   36,   37,   39,    0,
  116,    0,    0,    6,    7,    8,    0,   16,   13,   12,
   14,   15,    0,   22,   25,   26,   27,   53,    0,   90,
   91,    0,    0,    0,    0,   28,    0,    0,    0,    0,
  115,   52,  113,  114,  136,    0,   97,    0,    0,    0,
    0,    0,    0,    0,   31,    0,    0,    0,    9,   40,
   38,   41,    2,    0,    5,    4,    0,   24,    0,    0,
    0,    0,    0,  123,    0,  137,    1,    0,    0,    0,
   54,    0,    0,   45,   48,   51,    0,    0,    0,    0,
    0,   80,    0,    0,    0,    0,   78,    0,    0,    0,
    0,    0,  110,    0,   11,  111,  109,    0,    0,    3,
  121,  119,  120,  122,    0,  103,    0,  102,  101,    0,
    0,    0,    0,    0,    0,   29,    0,    0,    0,  133,
   88,   89,   87,   86,    0,    0,   84,   85,    0,    0,
    0,    0,    0,    0,   61,    0,   59,    0,  128,   82,
   81,   76,    0,   77,    0,   73,  129,    0,    0,  124,
    0,  112,   32,    0,    0,    0,   96,    0,    0,    0,
    0,   19,   18,    0,  135,    0,   10,    0,  134,    0,
    0,    0,    0,   46,   49,   47,   50,    0,    0,   72,
    0,    0,    0,    0,    0,   83,    0,    0,    0,  126,
    0,    0,  100,   99,   98,  108,  105,  107,  106,    0,
    0,    0,   20,   17,  131,  132,  130,   57,   56,   55,
    0,    0,    0,    0,    0,    0,    0,   60,   58,   95,
   75,   74,    0,    0,    0,    0,    0,  104,   70,   69,
   68,   66,    0,   65,   62,   71,   67,   64,  140,    0,
  142,  139,   93,   92,   63,
};
final static short yydgoto[] = {                          3,
   22,   23,   24,   25,   26,   27,   28,   29,   30,   31,
   32,  135,   33,   47,   34,   35,   36,   37,   68,   38,
   92,   93,   94,   39,   96,   50,  149,   62,  105,  106,
   40,   41,   42,   83,  181,   43,  140,   86,   44,
};
final static short yysindex[] = {                      -109,
  114,  114,    0, -226,  -27,  178, -217, -229,  164, -223,
    0,    0,    0,  -38,    0,   23,    0,    0,    0, -197,
    0,  -11,   34,    0,    0,    0,  -50,    0,    0,    0,
    0,    0, -228,    0,    0,    0,    0,    0,  -50,    0,
    0,  -22,  220,  -47,   14,    0,   29,  202,  202,  217,
    0,    0,    0,    0,    0,  -22,    0,  171,  -30,  342,
  -43, -171, -174,   71,    0, -168,  -41,   65,    0,    0,
    0,    0,    0,   86,    0,    0,  214,    0,   29,  185,
  144,  319,   15,    0,  -64,    0,    0, -161,   87,  -20,
    0,  519,  -18,    0,    0,    0,  519,  267,   35, -188,
   17,    0,  -27,   41,   16,  292,    0, -119,  -27, -122,
  -15,   85,    0,   -8,    0,    0,    0,   20, -125,    0,
    0,    0,    0,    0,  -12,    0, -124,    0,    0, -120,
   39, -118,  113,  116,  -89,    0, -111,  202,  -36,    0,
    0,    0,    0,    0,  239,  239,    0,    0,  202,  239,
  239,  202, -220, -169,    0,  217,    0,  139,    0,    0,
    0,    0,  117,    0,   42,    0,    0,   -3,  202,    0,
 -104,    0,    0,  121,    5,   47,    0,  119,  -86,  -82,
   64,    0,    0,  137,    0,  138,    0,   21,    0,    4,
  -18,  -18,   49,    0,    0,    0,    0,   10, -102,    0,
  217,  217,   53, -179,   89,    0,   58,   62,  202,    0,
  -74,  -74,    0,    0,    0,    0,    0,    0,    0,  146,
  -81,  149,    0,    0,    0,    0,    0,    0,    0,    0,
  -63,  -60,  -52,   54, -154,  -51, -139,    0,    0,    0,
    0,    0,   81,  -22, -103,   88,  166,    0,    0,    0,
    0,    0,  -42,    0,    0,    0,    0,    0,    0,   15,
    0,    0,    0,    0,    0,
};
final static short yyrindex[] = {                         0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,   -1,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,   55,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,   -1,    0,
    0,    0,    0,    0,    0,    0,    0,   59,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,   60,    0,
    0,    0,   66,    0,    0,    0,    0,    0,  460,    0,
    0,    0,  470,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0, -110,    0,    0,    0,    0,
    0,    0,    0,   11,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,  -37,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,   67,    0,
    0,    0,    0,    0,    0,    0,    0,    0,  168,  176,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
  494,  514,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,   78,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
   30,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,  228,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,
};
final static short yygindex[] = {                         0,
  333,  -10,    0,  -62,  534,  672,    0,  270,    0,    0,
    0,    0,   25,  308,    0,    0,    0,    0,    0,    0,
  -23,  -14,    0,  630,  -32,  -55,  250,  -33,  288,    0,
  -84,    0,  -76,  -53,  201,    3,    0,    0,    0,
};
final static int YYTABLESIZE=881;
static short yytable[];
static { yytable();}
static void yytable(){
yytable = new short[]{                        117,
  110,   67,  101,   20,  189,  166,  118,   66,   20,   67,
   21,   74,   49,    2,   79,   66,  100,   82,  212,  139,
   60,  262,  134,  150,   49,   97,   56,   78,  151,   77,
  146,   67,  145,   20,   74,  185,   49,  199,  200,   57,
   46,   80,   46,  118,  227,  215,  146,  159,  145,   21,
  230,   55,  146,  167,  145,  170,  125,   63,   20,   52,
  172,  225,  146,  146,  145,  145,   69,  155,  179,  156,
  157,   10,  186,   94,   21,   85,  238,   76,  154,  239,
   70,   71,   72,   20,  161,  208,  201,   88,  202,  228,
   69,  146,  111,  145,  112,  179,  237,  253,   23,   21,
  114,  254,   30,   21,  255,  127,  130,  136,   20,  138,
  125,  113,  210,   73,  188,  190,  257,  195,  197,  258,
  178,  127,  204,  119,   21,  193,  243,  245,  198,  120,
  191,  192,  137,   20,  244,  244,  164,  131,   87,  158,
  162,  168,  171,  173,  174,   79,    1,  178,  175,   21,
   65,  211,  261,   98,   94,  165,  182,  187,   20,  183,
  206,  213,  217,  177,   79,  231,    4,  233,  235,  218,
  222,    7,    8,  219,   21,   10,   11,   12,   13,  132,
  223,  224,  241,   20,  126,  184,  242,    8,  221,  246,
  260,    4,  248,  247,  222,  249,    7,    8,  250,   21,
   10,   11,   12,   13,  132,  259,  251,  256,   20,  264,
  133,    7,  263,  240,  116,   20,  265,   64,  118,    8,
  109,  118,   20,   15,   21,   64,  118,   89,   48,   20,
   65,   21,   89,   81,   90,  138,   17,   18,   19,   90,
  169,   17,   18,   19,    4,    5,   20,   64,    6,    7,
    8,    9,  209,   10,   11,   12,   13,   14,   20,  226,
  214,   20,   15,   16,   20,  229,   17,   18,   19,    4,
    5,    9,   52,    6,    7,    8,    9,   21,   10,   11,
   12,   13,   14,   20,   10,   94,   60,   15,   16,   75,
  153,   17,   18,   19,    4,    5,  160,  207,    6,    7,
    8,    9,  216,   10,   11,   12,   13,   14,  236,  252,
   23,   20,   15,  176,   30,   21,   17,   18,   19,    4,
    5,  138,  125,    6,    7,    8,    9,   21,   10,   11,
   12,   13,   14,  127,   45,  115,   20,   15,  220,   60,
   79,   17,   18,   19,    4,    5,  152,  108,    6,    7,
    8,    9,   21,   10,   11,   12,   13,   14,  205,  129,
    0,    0,   15,   16,    0,    0,   17,   18,   19,    4,
    5,    0,    0,    6,    7,    8,    9,    0,   10,   11,
   12,   13,   14,    0,    0,    0,   20,   15,   16,    0,
    0,   17,   18,   19,    4,    5,    0,    0,    6,    7,
    8,    9,   21,   10,   11,   12,   13,   14,    0,   11,
   12,   13,   15,  176,    0,    0,   17,   18,   19,   58,
    5,    0,    0,    6,    0,    0,  102,    5,    0,    0,
    6,    0,   59,   51,  103,    0,    0,   15,    0,   59,
  124,   17,   18,   19,   15,    0,   52,    0,   17,   18,
   19,    0,    0,   89,   53,   17,   18,   19,    0,    0,
   90,    0,   17,   18,   19,    0,  107,    0,    0,  121,
   89,    0,   98,    5,    0,    0,    6,   90,    0,   17,
   18,   19,   89,    0,    0,   59,    0,    0,   52,    0,
   15,   17,   18,   19,   17,   18,   19,   17,   18,   19,
   52,   52,   52,   52,   52,    0,   52,   89,    0,    0,
   44,    0,   44,   44,   44,    0,   17,   18,   19,   52,
    0,   52,  102,    5,    0,    0,    6,    0,    0,   44,
    0,   44,    0,    0,   43,   59,   43,   43,   43,    0,
   15,    0,   61,    0,   17,   18,   19,    0,    5,    0,
    0,    6,    0,   43,   42,   43,   42,   42,   42,    0,
   59,  146,    0,  145,    0,   15,    0,    0,    0,   17,
   18,   19,    0,   42,  128,   42,    0,    0,  147,    0,
  148,    0,    0,   99,   11,   12,   13,    0,    0,    0,
    0,  104,    0,  104,    0,    0,    0,  102,    5,    0,
    0,    6,    0,    0,    0,    0,    0,    0,    0,    0,
   59,    0,    0,    0,    0,   15,    0,    0,    0,   17,
   18,   19,    0,    0,    0,    0,    0,    0,    0,    0,
    0,  104,    0,    0,    0,   54,    0,    0,    0,  163,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,  180,    0,    0,    0,    0,    0,
    0,    0,   84,    0,    0,    0,    0,   95,   95,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,  203,
    0,  180,    0,    0,    0,    0,   95,    0,    0,    0,
    0,    0,    0,    0,    0,    0,  123,    0,    0,   95,
    0,    0,    0,    0,    0,   52,    0,    0,   52,   91,
   91,    0,    0,   52,    0,   44,    0,    0,   44,   52,
   52,   52,   52,   44,  232,  234,    0,    0,   91,   44,
   44,   44,   44,    0,    0,    0,    0,    0,  122,   43,
    0,   91,   43,    0,    0,    0,    0,   43,    0,    0,
    0,    0,    0,   43,   43,   43,   43,   95,   95,   42,
    0,    0,   42,    0,   95,   95,    0,   42,   95,  194,
  196,   95,    0,   42,   42,   42,   42,    0,  141,  142,
  143,  144,    0,    0,    0,    0,    0,    0,   95,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,   91,
   91,    0,    0,    0,    0,    0,   91,   91,    0,    0,
   91,   91,   91,   91,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,   95,    0,
   91,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
   91,
};
}
static short yycheck[];
static { yycheck(); }
static void yycheck() {
yycheck = new short[] {                         41,
   44,   40,   56,   45,   41,  125,   44,   46,   45,   40,
   61,   22,   40,  123,  125,   46,   50,   40,  123,   40,
  123,  125,   85,   42,   40,   49,  256,  256,   47,   27,
   43,   40,   45,   45,   45,  125,   40,  258,  259,  269,
  269,   39,  269,   67,   41,   41,   43,  103,   45,   61,
   41,  269,   43,  109,   45,  111,   80,  281,   45,   61,
   41,   41,   43,   43,   45,   45,   44,  256,  131,  258,
  259,   61,  135,   44,   61,  123,  256,   44,   44,  259,
  278,  279,  280,   45,   44,   44,  256,   59,  258,   41,
   44,   43,  264,   45,  269,  158,   44,   44,   44,   61,
  269,  256,   44,   44,  259,   81,   82,  269,   45,   44,
   44,   41,  168,  125,  138,  139,  256,  150,  151,  259,
  131,   44,  156,   59,   61,  149,  211,  212,  152,   44,
  145,  146,   46,   45,  211,  212,  256,  123,  125,  123,
  125,  264,   58,  269,  269,  256,  256,  158,  269,   61,
  269,  256,  256,  256,  125,  275,   44,  269,   45,   44,
   44,   41,   44,  125,  275,  199,  256,  201,  202,  256,
  181,  261,  262,  256,   61,  265,  266,  267,  268,  269,
   44,   44,  125,   45,   41,  275,  125,  262,  125,   44,
  244,  256,   44,  275,  205,  259,  261,  262,  259,   61,
  265,  266,  267,  268,  269,  125,  259,  259,   45,   44,
  275,   44,  125,  125,  256,   45,  259,  256,  256,   44,
  264,  259,   45,  274,   61,  256,  264,  269,  256,   45,
  269,   61,  269,  256,  276,  256,  278,  279,  280,  276,
  256,  278,  279,  280,  256,  257,   45,  256,  260,  261,
  262,  263,  256,  265,  266,  267,  268,  269,   45,  256,
  256,   45,  274,  275,   45,  256,  278,  279,  280,  256,
  257,   44,  274,  260,  261,  262,  263,   61,  265,  266,
  267,  268,  269,   45,  274,  256,  123,  274,  275,  256,
  256,  278,  279,  280,  256,  257,  256,  256,  260,  261,
  262,  263,  256,  265,  266,  267,  268,  269,  256,  256,
  256,   45,  274,  275,  256,  256,  278,  279,  280,  256,
  257,  256,  256,  260,  261,  262,  263,   61,  265,  266,
  267,  268,  269,  256,    2,   66,   45,  274,  275,  123,
   33,  278,  279,  280,  256,  257,   97,   60,  260,  261,
  262,  263,   61,  265,  266,  267,  268,  269,  158,   41,
   -1,   -1,  274,  275,   -1,   -1,  278,  279,  280,  256,
  257,   -1,   -1,  260,  261,  262,  263,   -1,  265,  266,
  267,  268,  269,   -1,   -1,   -1,   45,  274,  275,   -1,
   -1,  278,  279,  280,  256,  257,   -1,   -1,  260,  261,
  262,  263,   61,  265,  266,  267,  268,  269,   -1,  266,
  267,  268,  274,  275,   -1,   -1,  278,  279,  280,  256,
  257,   -1,   -1,  260,   -1,   -1,  256,  257,   -1,   -1,
  260,   -1,  269,  256,  264,   -1,   -1,  274,   -1,  269,
  256,  278,  279,  280,  274,   -1,  269,   -1,  278,  279,
  280,   -1,   -1,  269,  277,  278,  279,  280,   -1,   -1,
  276,   -1,  278,  279,  280,   -1,  125,   -1,   -1,  256,
  269,   -1,  256,  257,   -1,   -1,  260,  276,   -1,  278,
  279,  280,  269,   -1,   -1,  269,   -1,   -1,  269,   -1,
  274,  278,  279,  280,  278,  279,  280,  278,  279,  280,
   41,   42,   43,   44,   45,   -1,   47,  269,   -1,   -1,
   41,   -1,   43,   44,   45,   -1,  278,  279,  280,   60,
   -1,   62,  256,  257,   -1,   -1,  260,   -1,   -1,   60,
   -1,   62,   -1,   -1,   41,  269,   43,   44,   45,   -1,
  274,   -1,    9,   -1,  278,  279,  280,   -1,  257,   -1,
   -1,  260,   -1,   60,   41,   62,   43,   44,   45,   -1,
  269,   43,   -1,   45,   -1,  274,   -1,   -1,   -1,  278,
  279,  280,   -1,   60,  256,   62,   -1,   -1,   60,   -1,
   62,   -1,   -1,   50,  266,  267,  268,   -1,   -1,   -1,
   -1,   58,   -1,   60,   -1,   -1,   -1,  256,  257,   -1,
   -1,  260,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,
  269,   -1,   -1,   -1,   -1,  274,   -1,   -1,   -1,  278,
  279,  280,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,
   -1,   98,   -1,   -1,   -1,    6,   -1,   -1,   -1,  106,
   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,
   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,
   -1,   -1,   -1,   -1,  131,   -1,   -1,   -1,   -1,   -1,
   -1,   -1,   43,   -1,   -1,   -1,   -1,   48,   49,   -1,
   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,  156,
   -1,  158,   -1,   -1,   -1,   -1,   67,   -1,   -1,   -1,
   -1,   -1,   -1,   -1,   -1,   -1,   77,   -1,   -1,   80,
   -1,   -1,   -1,   -1,   -1,  256,   -1,   -1,  259,   48,
   49,   -1,   -1,  264,   -1,  256,   -1,   -1,  259,  270,
  271,  272,  273,  264,  201,  202,   -1,   -1,   67,  270,
  271,  272,  273,   -1,   -1,   -1,   -1,   -1,   77,  256,
   -1,   80,  259,   -1,   -1,   -1,   -1,  264,   -1,   -1,
   -1,   -1,   -1,  270,  271,  272,  273,  138,  139,  256,
   -1,   -1,  259,   -1,  145,  146,   -1,  264,  149,  150,
  151,  152,   -1,  270,  271,  272,  273,   -1,  270,  271,
  272,  273,   -1,   -1,   -1,   -1,   -1,   -1,  169,   -1,
   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,  138,
  139,   -1,   -1,   -1,   -1,   -1,  145,  146,   -1,   -1,
  149,  150,  151,  152,   -1,   -1,   -1,   -1,   -1,   -1,
   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,  209,   -1,
  169,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,
   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,
   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,
   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,
  209,
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
"FuncionIMPL : IMPL FOR ID ':' '{' Funcion '}'",
"FuncionIMPL : IMPL FOR ID ':' error Funcion '}'",
"FuncionIMPL : IMPL FOR ID ':' error Funcion '}'",
"FuncionIMPL : IMPL FOR ID ':' '{' Funcion error",
};

//#line 643 "gramatica.y"
  public NodoControl raiz;
  private String ambitoAct = "main";
  private String ambitoNuevo= "";
  static ArrayList<Error> erroresSemanticos = new ArrayList<Error>();
  static ArrayList<String> variables_declaradas = new ArrayList<String>();
  static String tipoActual;
  static ArrayList<Funcion> funciones_declaradas = new ArrayList<Funcion>();

  public NodoControl getRaiz(){
  	return this.raiz;
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
//#line 776 "Parser.java"
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
int yyparse()
{
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
                                     raiz.setDer((Nodo)val_peek(1).obj);
                                    AnalizadorLexico.agregarEstructura("Reconoce programa ");}
break;
case 2:
//#line 21 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se espera '{' ");}
break;
case 3:
//#line 24 "gramatica.y"
{yyval.obj = new NodoComun("Sentencia", (Nodo) val_peek(2).obj, (Nodo) val_peek(1).obj);}
break;
case 4:
//#line 25 "gramatica.y"
{yyval.obj=val_peek(1).obj;}
break;
case 5:
//#line 26 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba una ',' ");}
break;
case 6:
//#line 29 "gramatica.y"
{yyval.obj=val_peek(0).obj;}
break;
case 7:
//#line 30 "gramatica.y"
{yyval.obj=val_peek(0).obj;}
break;
case 8:
//#line 31 "gramatica.y"
{yyval.obj=val_peek(0).obj;}
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
{yyval.obj=val_peek(0).obj;}
break;
case 13:
//#line 60 "gramatica.y"
{yyval.obj=val_peek(0).obj;}
break;
case 14:
//#line 61 "gramatica.y"
{yyval.obj=val_peek(0).obj;}
break;
case 15:
//#line 62 "gramatica.y"
{yyval.obj=val_peek(0).obj;}
break;
case 16:
//#line 63 "gramatica.y"
{yyval.obj=val_peek(0).obj;}
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
                    NodoHoja aux = new NodoHoja(val_peek(0).sval);
                    aux.setTipo("INT");
                    aux.setUso("Constante");
                    aux.setAmbito(ambitoAct);
                    yyval.obj = aux;
                    Token t = TablaSimbolos.getToken(val_peek(0).sval);
                    t.setTipo("INT");
                    t.setUso("Constante");
                    t.setAmbito(ambitoAct);
                    TablaSimbolos.removeToken(val_peek(0).sval);
                    TablaSimbolos.addSimbolo(val_peek(0).sval,t);
                   }
break;
case 37:
//#line 143 "gramatica.y"
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
case 38:
//#line 158 "gramatica.y"
{AnalizadorLexico.agregarErrorLexico("Un entero corto no puede ser negativo ");}
break;
case 39:
//#line 159 "gramatica.y"
{
	                chequearDouble(val_peek(0).sval);
	                NodoHoja aux = new NodoHoja(val_peek(0).sval);
                    aux.setTipo("DOUBLE");
                    aux.setUso("Constante");
                    aux.setAmbito(ambitoAct);
                    yyval.obj = aux;
	            Token t = TablaSimbolos.getToken(val_peek(0).sval);
                    t.setTipo("DOUBLE");
                    t.setUso("Constante");
                    t.setAmbito(ambitoAct);
                    TablaSimbolos.removeToken(val_peek(0).sval);
                    TablaSimbolos.addSimbolo(val_peek(0).sval,t);
                    }
break;
case 40:
//#line 174 "gramatica.y"
{
                    chequearEnteroNegativo(val_peek(0).sval);
                    NodoHoja aux = new NodoHoja(val_peek(1).sval);
                    aux.setTipo("INT");
                    aux.setUso("Constante");
                    aux.setAmbito(ambitoAct);
                    yyval.obj = aux;
                    Token t = TablaSimbolos.getToken(val_peek(1).sval);
                    t.setTipo("INT");
                    t.setUso("Constante");
                    t.setAmbito(ambitoAct);
                    TablaSimbolos.removeToken(val_peek(1).sval);
                    TablaSimbolos.addSimbolo(val_peek(1).sval,t);
	                }
break;
case 41:
//#line 188 "gramatica.y"
{chequearDouble(val_peek(1).sval);
                         NodoHoja aux = new NodoHoja(val_peek(1).sval);
                         aux.setTipo("DOUBLE");
                         aux.setUso("Constante");
                         aux.setAmbito(ambitoAct);
                         yyval.obj = aux;
                         Token t = TablaSimbolos.getToken(val_peek(1).sval);
                         t.setTipo("DOUBLE");
                         t.setUso("Constante");
                         t.setAmbito(ambitoAct);
                         TablaSimbolos.removeToken(val_peek(1).sval);
                         TablaSimbolos.addSimbolo(val_peek(1).sval,t);
                        }
break;
case 42:
//#line 203 "gramatica.y"
{ yyval.obj = new NodoComun("+",(Nodo)val_peek(2).obj,(Nodo)val_peek(0).obj);
                                Nodo n1 = new Nodo ((Nodo)val_peek(2).obj);
                                Nodo n2 = new Nodo ((Nodo)val_peek(0).obj);
                                if (n1.getUso()!= "Constante"){
                                    if (!estaAlAlcance(n1.getLexema())){
                                        agregarErrorSemantico("Primer termino fuera de alcance ");
                                        break;
                                    }
                                 }
                                if (n2.getUso()!= "Constante"){
                                   if (!estaAlAlcance(n2.getLexema())){
                                        agregarErrorSemantico("Segundo termino fuera de alcance ");
                                        break;
                                   }
                                }
                                if (n1.getTipo().equals(n2.getTipo())){
                                    ((Nodo)yyval.obj).setTipo(n1.getTipo());
                                }
                                }
break;
case 43:
//#line 222 "gramatica.y"
{yyval.obj = new NodoComun("-",(Nodo)val_peek(2).obj,(Nodo)val_peek(0).obj);
                       Nodo n1 = new Nodo ((Nodo)val_peek(2).obj);
                       Nodo n2 = new Nodo ((Nodo)val_peek(0).obj);
                        if (n1.getUso()!= "Constante"){
                            if (!estaAlAlcance(n1.getLexema())){
                                agregarErrorSemantico("Primer termino fuera de alcance ");
                                break;
                            }
                        }
                        if (n2.getUso()!= "Constante"){
                            if (!estaAlAlcance(n2.getLexema())){
                                agregarErrorSemantico("Segundo termino fuera de alcance ");
                                break;
                            }
                        }
                        if (n1.getTipo().equals(n2.getTipo())){
                            ((Nodo)yyval.obj).setTipo(n1.getTipo());
                        }
                      }
break;
case 44:
//#line 241 "gramatica.y"
{yyval.obj=val_peek(0).obj;}
break;
case 45:
//#line 242 "gramatica.y"
{yyval.obj=val_peek(0).obj;}
break;
case 46:
//#line 246 "gramatica.y"
{yyval.obj = new NodoComun("*",(Nodo)val_peek(2).obj,(Nodo)val_peek(0).obj);
                                Nodo n1 = new Nodo ((Nodo)val_peek(2).obj);
                                Nodo n2 = new Nodo ((Nodo)val_peek(0).obj);
                                if (n1.getUso()!= "Constante"){
                                    if (!estaAlAlcance(n1.getLexema())){
                                        agregarErrorSemantico("Primer termino fuera de alcance ");
                                        break;
                                    }
                                }
                                if (n2.getUso()!= "Constante"){
                                    if (!estaAlAlcance(n2.getLexema())){
                                        agregarErrorSemantico("Segundo termino fuera de alcance ");
                                        break;
                                    }
                                }
                                if (n1.getTipo().equals(n2.getTipo())){
                                    ((Nodo)yyval.obj).setTipo(n1.getTipo());
                                }
                              }
break;
case 47:
//#line 266 "gramatica.y"
{yyval.obj = new NodoComun("/",(Nodo)val_peek(2).obj,(Nodo)val_peek(0).obj);
                    Nodo n1 = new Nodo ((Nodo)val_peek(2).obj);
                    Nodo n2 = new Nodo ((Nodo)val_peek(0).obj);
                        if (n1.getUso()!= "Constante"){
                            if (!estaAlAlcance(n1.getLexema())){
                                agregarErrorSemantico("Primer termino fuera de alcance ");
                                break;
                            }
                        }if (n2.getUso()!= "Constante"){
                            if (!estaAlAlcance(n2.getLexema())){
                                agregarErrorSemantico("Segundo termino fuera de alcance ");
                                break;
                            }
                        }
                        if (n1.getTipo().equals(n2.getTipo())){
                            ((Nodo)yyval.obj).setTipo(n1.getTipo());
                        }
                    }
break;
case 48:
//#line 284 "gramatica.y"
{yyval.obj = val_peek(0).obj;}
break;
case 49:
//#line 285 "gramatica.y"
{yyval = new NodoComun("*",(Nodo)val_peek(2),(Nodo)val_peek(0));
                               Nodo n1 = new Nodo ((Nodo)val_peek(2).obj);
                               Nodo n2 = new Nodo ((Nodo)val_peek(0).obj);
                               if (!n1.getAmbito().equals(n2.getAmbito())){
                                    agregarErrorSemantico("Variable fuera de alcance ");
                               }
                                     ((Nodo)yyval.obj).setTipo(tipoPredominante(n1.getTipo(),n2.getTipo()));
                               }
break;
case 50:
//#line 293 "gramatica.y"
{yyval.obj = new NodoComun("/",(Nodo)val_peek(2).obj,(Nodo)val_peek(0).obj);
                               Nodo n1 = new Nodo ((Nodo)val_peek(2).obj);
                               Nodo n2 = new Nodo ((Nodo)val_peek(0).obj);
                               if (!n1.getAmbito().equals(n2.getAmbito())){
                                    agregarErrorSemantico("Variable fuera de alcance ");
                               }
                                    ((Nodo)yyval.obj).setTipo(tipoPredominante(n1.getTipo(),n2.getTipo()));
                               }
break;
case 51:
//#line 301 "gramatica.y"
{yyval.obj=val_peek(0).obj;}
break;
case 52:
//#line 304 "gramatica.y"
{Nodo aux = new NodoHoja ((String)val_peek(0).sval);
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
                    aux.setTipo(TablaSimbolos.getTipo(var));
                    aux.setUso(TablaSimbolos.getUso(var));
                    aux.setAmbito(TablaSimbolos.getAmbito(var));
                }
            }
            yyval.obj = aux;
          }
break;
case 53:
//#line 323 "gramatica.y"
{yyval.obj=val_peek(0).obj;}
break;
case 54:
//#line 327 "gramatica.y"
{yyval.obj=val_peek(0).obj;}
break;
case 55:
//#line 330 "gramatica.y"
{ NodoComun aux = new NodoComun(val_peek(2).sval,(Nodo)val_peek(3).obj,(Nodo)val_peek(1).obj);
                                                    Nodo a = new Nodo((Nodo)val_peek(3).obj);
                                                    aux.setTipo(a.getTipo());
                                                    aux.setUso("Condicion");
                                                    yyval.obj = aux.obj;
                                                    /*if (!(((Nodo)$2).getTipo().equals(((Nodo)$4).getTipo()))){*/
                                                         /*agregarErrorSemantico("Error en la comparacion entre expresiones de distintos tipos"); //CHEQUEAR CONVERSIONES*/
                                                     /*}*/
                                                     }
break;
case 56:
//#line 339 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba una ')' ");}
break;
case 57:
//#line 340 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba una '(' ");}
break;
case 58:
//#line 343 "gramatica.y"
{  yyval.obj = new NodoComun("CUERPO",(Nodo)val_peek(3).obj,(Nodo)val_peek(1).obj);
                                                        Nodo aux = new Nodo ((Nodo)yyval.obj);
                                                        yyval.obj = new NodoComun("IF",(Nodo)val_peek(4).obj,aux);
                                                        AnalizadorLexico.agregarEstructura("Reconoce IF ELSE");}
break;
case 59:
//#line 347 "gramatica.y"
{yyval.obj = new Nodo("CUERPO",(Nodo)val_peek(1).obj,null);
	                                    Nodo aux = new Nodo ((Nodo)yyval.obj);
	                                    yyval.obj = new NodoComun("IF",(Nodo)val_peek(2).obj,aux);
	                                    AnalizadorLexico.agregarEstructura("Reconoce IF");}
break;
case 60:
//#line 351 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba un END_IF ");}
break;
case 61:
//#line 352 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("IF mal definido ");}
break;
case 62:
//#line 353 "gramatica.y"
{   yyval.obj = new NodoComun("CUERPO",(Nodo)val_peek(4).obj,(Nodo)val_peek(1).obj);
                                                                        Nodo aux = new Nodo ((Nodo)yyval.obj);
                                                                        yyval.obj = new NodoComun("IF",(Nodo)val_peek(5).obj,aux);
                                                                        AnalizadorLexico.agregarEstructura("Reconoce IF ELSE");}
break;
case 63:
//#line 357 "gramatica.y"
{yyval.obj = new NodoComun("CUERPO",(Nodo)val_peek(5).obj,(Nodo)val_peek(2).obj);
                                                                                    Nodo aux = new Nodo ((Nodo)yyval.obj);
                                                                                    yyval.obj = new NodoComun("IF",(Nodo)val_peek(6).obj,aux);
                                                                                    AnalizadorLexico.agregarEstructura("Reconoce IF ELSE");}
break;
case 64:
//#line 361 "gramatica.y"
{   yyval.obj = new NodoComun("CUERPO",(Nodo)val_peek(4).obj,(Nodo)val_peek(2).obj);
                                                                        Nodo aux = new Nodo ((Nodo)yyval.obj);
                                                                        yyval.obj = new NodoComun("IF",(Nodo)val_peek(5).obj,aux);
                                                                        AnalizadorLexico.agregarEstructura("Reconoce IF ELSE");}
break;
case 65:
//#line 365 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba un END_IF ");}
break;
case 66:
//#line 366 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba un END_IF ");}
break;
case 67:
//#line 367 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba un END_IF ");}
break;
case 68:
//#line 368 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba un ELSE ");}
break;
case 69:
//#line 369 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba un ELSE");}
break;
case 70:
//#line 370 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba una ',' ");}
break;
case 71:
//#line 371 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba una ',' " );}
break;
case 72:
//#line 372 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba una ',' ");}
break;
case 73:
//#line 375 "gramatica.y"
{yyval.obj = val_peek(1).obj;}
break;
case 74:
//#line 376 "gramatica.y"
{yyval.obj = val_peek(3).obj;}
break;
case 75:
//#line 378 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Falta una ',' "); }
break;
case 76:
//#line 379 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Falta un '{'"); }
break;
case 77:
//#line 380 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Falta un '}'"); }
break;
case 78:
//#line 381 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("No hay sentencias dentro de las llaves."); }
break;
case 79:
//#line 384 "gramatica.y"
{yyval.obj=val_peek(0).obj;}
break;
case 80:
//#line 387 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Solo se aceptan sentencias ejecutables "); }
break;
case 81:
//#line 388 "gramatica.y"
{yyval=val_peek(1);}
break;
case 82:
//#line 389 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Falta una ',' "); }
break;
case 83:
//#line 390 "gramatica.y"
{yyval.obj = new NodoComun("SentenciaIF", (Nodo) val_peek(2).obj, (Nodo) val_peek(1).obj);}
break;
case 84:
//#line 393 "gramatica.y"
{yyval.obj=val_peek(0).obj;}
break;
case 85:
//#line 394 "gramatica.y"
{yyval.obj=val_peek(0).obj;}
break;
case 86:
//#line 395 "gramatica.y"
{yyval.obj=val_peek(0).obj;}
break;
case 87:
//#line 396 "gramatica.y"
{yyval.obj=val_peek(0).obj;}
break;
case 88:
//#line 397 "gramatica.y"
{yyval.obj=val_peek(0).obj;}
break;
case 89:
//#line 398 "gramatica.y"
{yyval.obj=val_peek(0).obj;}
break;
case 92:
//#line 405 "gramatica.y"
{agregarErrorSemantico("RETURN fuera de funcion");}
break;
case 93:
//#line 406 "gramatica.y"
{  ((Nodo)val_peek(6).obj).setIzq((Nodo)val_peek(5).obj);
                                                                                ((Nodo)val_peek(6).obj).setDer((Nodo)val_peek(3).obj);
                                                                                deshacerAmbito();
                                                                                AnalizadorLexico.agregarEstructura("Reconoce declaracion de funcion ");}
break;
case 94:
//#line 410 "gramatica.y"
{ ((Nodo)val_peek(4).obj).setIzq((Nodo)val_peek(3).obj);
                                                                    ((Nodo)val_peek(4).obj).setDer((Nodo)val_peek(1).obj);
                                                                    deshacerAmbito();
                                                                    AnalizadorLexico.agregarEstructura("Reconoce declaracion de funcion ");}
break;
case 95:
//#line 414 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba un nombre para la funcion ");}
break;
case 96:
//#line 415 "gramatica.y"
{AnalizadorLexico.addWarning("Función sin cuerpo ");
                                            deshacerAmbito();
                                            AnalizadorLexico.agregarEstructura("Reconoce declaracion de funcion ");}
break;
case 97:
//#line 420 "gramatica.y"
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
                  yyval.obj = new NodoComun(val_peek(0).sval,null,null);
                              }
break;
case 98:
//#line 440 "gramatica.y"
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
                                yyval.obj = new NodoHoja(val_peek(1).sval);
                           }
break;
case 99:
//#line 452 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba un ')' ");}
break;
case 100:
//#line 453 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba un '(' ");}
break;
case 101:
//#line 454 "gramatica.y"
{yyval.obj = null;}
break;
case 102:
//#line 455 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba un ')' ");}
break;
case 103:
//#line 456 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba un '(' ");}
break;
case 104:
//#line 462 "gramatica.y"
{yyval.obj = new NodoComun("Sentencia",(Nodo)val_peek(2).obj,(Nodo)val_peek(1).obj);}
break;
case 105:
//#line 463 "gramatica.y"
{yyval.obj=val_peek(1).obj;}
break;
case 106:
//#line 464 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba una ',' al final de la linea ");}
break;
case 107:
//#line 465 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba una ',' al final de la linea ");}
break;
case 108:
//#line 466 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba una ',' al final de la linea ");}
break;
case 109:
//#line 469 "gramatica.y"
{yyval.obj=new NodoHoja(val_peek(2).sval);
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
case 110:
//#line 486 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba un '(' ");}
break;
case 111:
//#line 487 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba un ')' ");}
break;
case 112:
//#line 488 "gramatica.y"
{
            			    NodoHoja nodo1 = new NodoHoja(val_peek(3).sval);
            			    yyval.obj=new NodoComun("Llamado Funcion", nodo1, (Nodo)val_peek(1).obj);
            			    Nodo n3 = new Nodo((Nodo)val_peek(1).obj);
                                    Token tokenFuncion = TablaSimbolos.buscarPorAmbito(val_peek(3).sval + ":" + ambitoAct);

                                    Funcion funcion = new Funcion(tokenFuncion.getLexema(), null);
                                    if (tokenFuncion == null){
                                    	agregarErrorSemantico("La funcion " + val_peek(3).sval + " nunca fue declarada");
                                    } else {
                                    	if (funciones_declaradas.contains(funcion)) {
                                            int indice = funciones_declaradas.indexOf(funcion);
                                            Funcion f = funciones_declaradas.get(indice);
                                            if (!f.getTipoParametro().equals(n3.getTipo()) && (n3.getTipo() != null)){
                                                agregarErrorSemantico("No coinciden los tipos del parametro real y el formal. Se esperaba un " + f.getTipoParametro() + ", se obtuvo un " + ((Nodo)val_peek(1)).getTipo());
                                            }
                                        }
                                    }
                                    AnalizadorLexico.agregarEstructura("Reconoce llamado funcion ");
                                    TablaSimbolos.removeToken(val_peek(3).sval);
                                    }
break;
case 113:
//#line 511 "gramatica.y"
{yyval.obj = new NodoControl("PRINT", new NodoHoja(val_peek(0).sval));
                             AnalizadorLexico.agregarEstructura("Reconoce salida de mensaje por pantalla ");}
break;
case 114:
//#line 513 "gramatica.y"
{yyval.obj = new NodoControl("PRINT", new NodoHoja(val_peek(0).sval));
                            AnalizadorLexico.agregarEstructura("Reconoce salida de mensaje por pantalla ");}
break;
case 115:
//#line 515 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("La funcion PRINT no acepta esa declaracion ");}
break;
case 116:
//#line 518 "gramatica.y"
{yyval.obj=val_peek(0).obj;}
break;
case 117:
//#line 519 "gramatica.y"
{yyval.obj=val_peek(0).obj;}
break;
case 118:
//#line 522 "gramatica.y"
{AnalizadorLexico.agregarEstructura("Reconoce asignacion ");
						                        yyval.obj = new NodoComun(val_peek(1).sval,(Nodo)val_peek(2).obj,(Nodo)val_peek(0).obj);
						                        Nodo n1 = new Nodo ((Nodo)val_peek(2).obj);
                                                String uso = n1.getLexema();
                                                if (!(uso.equals("Constante"))){
                                                String var = getLexemaAlcance(n1.getLexema() + ":" + ambitoAct);
                                                    if (var.contains("main")){
                                                        Token t1 = TablaSimbolos.getToken(var);
                                                        if (t1 != null){
                                                                if (getLexemaAlcance(var).equals(n1.getLexema())){
                                                                    agregarErrorSemantico("Variable " + n1.getLexema() +" fuera de alcance");
                                                                }
                                                        }
                                                    }
                                                    else {
                                                        agregarErrorSemantico("Variable " + n1.getLexema() + " no definida");
                                                    }
                                                }
                                                else {
                                                    agregarErrorSemantico("Las constantes no pueden estar del lado izquierdo en una asignacion");
					                            }
					                            }
break;
case 119:
//#line 545 "gramatica.y"
{AnalizadorLexico.agregarEstructura("Reconoce asignacion ");
	                                                        yyval.obj = new NodoComun(val_peek(1).sval,(Nodo)val_peek(2).obj,(Nodo)val_peek(0).obj);}
break;
case 120:
//#line 548 "gramatica.y"
{AnalizadorLexico.agregarEstructura("Reconoce asignacion ");
	                                                yyval.obj = new NodoComun(val_peek(1).sval,(Nodo)val_peek(2).obj,(Nodo)val_peek(0).obj);
	                                                Nodo n1 = new Nodo((Nodo)val_peek(2).obj);
	                                                Nodo n2 = new Nodo((Nodo)val_peek(0).obj);
	                                                String uso = n2.getUso();
	                                                if (!(uso.equals("Constante"))){
                                                        String var = getLexemaAlcance(n2.getLexema() + ":" + ambitoAct);
                                                        if (var.contains("main")){
                                                            Token t1 = TablaSimbolos.getToken(var);
                                                            if (t1 != null){
                                                                if (getLexemaAlcance(var).equals(n1.getLexema())){
                                                                        agregarErrorSemantico("Variable " + n1.getLexema() +" fuera de alcance");
                                                                    }
                                                            }
                                                        }
                                                        else {
                                                            agregarErrorSemantico("Variable " + n2.getLexema() + " no definida");
                                                        }
                                                    }
	                                                }
break;
case 121:
//#line 568 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba un valor seguido del operador ");}
break;
case 122:
//#line 569 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba un valor seguido del operador ");}
break;
case 123:
//#line 570 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba un operando del lado izquierdo ");}
break;
case 124:
//#line 573 "gramatica.y"
{yyval.obj=new NodoComun("DO UNTIL", (Nodo)val_peek(2).obj ,(Nodo)val_peek(0).obj);
                                                        AnalizadorLexico.agregarEstructura("Reconoce funcion DO UNTIL");}
break;
case 125:
//#line 575 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba una condicion ");}
break;
case 126:
//#line 576 "gramatica.y"
{yyval.obj = new NodoComun("DO UNTIL", (Nodo)val_peek(3).obj ,(Nodo)val_peek(1).obj);
                                                               AnalizadorLexico.agregarEstructura("Reconoce funcion DO UNTIL");}
break;
case 127:
//#line 578 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba una condicion ");}
break;
case 128:
//#line 579 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba una sentencia ejecutable ");}
break;
case 129:
//#line 580 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba una ',' ");}
break;
case 130:
//#line 586 "gramatica.y"
{yyval.obj = val_peek(1).obj;}
break;
case 131:
//#line 587 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba un '(' ");}
break;
case 132:
//#line 588 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba un ')' ");}
break;
case 133:
//#line 591 "gramatica.y"
{yyval.obj = new NodoControl("TOD",(Nodo)val_peek(0).obj);
                                            AnalizadorLexico.agregarEstructura("Reconoce funcion TOD ");
                                            }
break;
case 134:
//#line 595 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba una Expresion ");}
break;
case 136:
//#line 602 "gramatica.y"
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
case 137:
//#line 623 "gramatica.y"
{deshacerAmbito();}
break;
case 138:
//#line 626 "gramatica.y"
{AnalizadorLexico.agregarEstructura("Reconoce Funcion sin cuerpo");}
break;
case 139:
//#line 630 "gramatica.y"
{AnalizadorLexico.agregarEstructura("Reconoce funcion IMPL"); TablaSimbolos.removeToken(val_peek(4).sval);}
break;
case 140:
//#line 631 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba un '{' ");}
break;
case 141:
//#line 632 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba un '{' ");}
break;
case 142:
//#line 633 "gramatica.y"
{AnalizadorLexico.agregarErrorSintactico("Se esperaba un '}' ");}
break;
//#line 1835 "Parser.java"
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
public void run()
{
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
