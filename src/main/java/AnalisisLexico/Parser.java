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
import AnalisisLexico.TablaSimbolos.TablaSimbolos;
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
    5,    5,    5,   13,   13,   16,   12,   12,   12,   17,
   17,   17,   17,   17,   17,   18,   18,   18,   18,   19,
   19,   19,   19,   19,   19,   21,   21,   22,   23,   10,
   10,   25,   25,   25,   24,   24,   24,   24,   24,   24,
   26,   26,   26,   26,   14,   14,   28,   29,   30,   30,
   30,   30,   30,   30,   30,   30,    8,    8,   11,   11,
   31,   31,    9,    9,    9,    3,    3,   20,   20,   32,
   32,   32,   32,   32,   32,   15,   15,   27,   27,   33,
};
final static short yylen[] = {                            2,
    3,    2,    2,    1,    2,    3,    1,    1,    1,    1,
    3,    3,    1,    1,    1,    1,    1,    2,    1,    1,
    1,    1,    1,    1,    3,    2,    1,    1,    1,    1,
    1,    2,    1,    2,    2,    3,    3,    1,    1,    3,
    3,    1,    3,    3,    1,    1,    1,    1,    3,   12,
    8,    2,    3,    1,    1,    1,    1,    1,    1,    1,
    1,    1,    2,    2,    8,    7,    2,    1,    3,    3,
    2,    2,    2,    3,    1,    1,    3,    4,    2,    2,
    1,    1,    3,    3,    3,    8,    5,    4,    3,    2,
    1,    3,    4,    2,    3,    5,    2,    6,    5,    7,
};
final static short yydefred[] = {                         0,
    0,    0,    0,    0,    0,   28,   27,   29,    0,    0,
    0,    0,    0,    8,    9,   10,    0,   17,   14,   13,
   15,   16,    0,   20,   19,   22,   23,    0,   46,   79,
   30,   31,   33,    0,   47,   80,    0,    0,    0,    0,
   82,    0,    0,    0,   81,   26,    0,    0,    3,    0,
    0,   18,    0,    0,   48,    0,    0,   39,    0,    0,
    0,   34,   32,   35,    0,    0,    0,    0,    0,    0,
   12,   25,   77,    0,   83,    1,    6,   84,   85,    0,
    0,   59,   60,   58,   57,   55,   56,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,   78,   11,
   89,    0,   49,   37,   36,   40,   41,   43,   44,    0,
    0,    0,    0,   64,    0,   63,   96,    0,    0,   67,
    0,   53,    0,   88,    0,    0,    0,    0,   95,   92,
    0,    0,    0,    0,   68,    0,    0,    0,    0,    0,
    0,   93,    0,    0,    0,   66,    0,    0,    0,   51,
   99,    0,    0,   74,   70,   69,   65,   86,    0,   98,
    0,    0,  100,    0,   50,
};
final static short yydgoto[] = {                         11,
   12,   13,   14,  142,  143,   17,   18,   19,   20,   21,
   22,   23,   24,   25,   26,   27,   35,   56,   57,   58,
   59,   60,   61,   88,   69,  100,  101,  106,  144,  145,
   47,  102,  103,
};
final static short yysindex[] = {                      -108,
  -12,  -28, -245, -228,  -64,    0,    0,    0,  -38,  -76,
    0,  -21,   23,    0,    0,    0,  -58,    0,    0,    0,
    0,    0, -182,    0,    0,    0,    0,  -23,    0,    0,
    0,    0,    0,  -69,    0,    0,  -26,   58, -141,   54,
    0, -152, -182,  -41,    0,    0,  -23,   -1,    0,  -76,
  -15,    0,   87,   89,    0,  -50,   45,    0,   27,   63,
   94,    0,    0,    0,  -67,   -8,  -27,  100,   21,  108,
    0,    0,    0,  109,    0,    0,    0,    0,    0, -104,
  -36,    0,    0,    0,    0,    0,    0,  -23,  -23,  -23,
  -15,  -15,  -15,  -15,   59, -101,  -98, -182,  -74,  145,
  -74,   71,  153,   79,  -66,  171, -141,  -51,    0,    0,
    0,  173,    0,    0,    0,    0,    0,    0,    0, -141,
  175,  -52,  174,    0,  -67,    0,    0,  -67, -166,    0,
   96,    0,  184,    0,  101,   24,  167,  -67,    0,    0,
  185,  188,  190,  120,    0, -166,  -23, -175,  -37,  207,
  138,    0, -166, -166, -166,    0,  137,  225,  144,    0,
    0,  -24,    7,    0,    0,    0,    0,    0, -141,    0,
  143,  150,    0,   35,    0,
};
final static short yyrindex[] = {                         0,
    0,    0,    0,    0,    0,    0,    0,    0,   18,    0,
    0,  270,   31,    0,    0,    0,    0,    0,    0,    0,
    0,    0,   26,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,   37,    0,    0,   18,
    0,    0,    0,    0,    0,    0,    0,  280,    0,   32,
    0,    0,    1,    0,    0,    0,   16,    0,    6,   11,
    0,    0,    0,    0,    0,    0,    0,  160,    0,  -47,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,  249,    0,
  251,    0,  172,    0,    0,    0,  176,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,  177,    0,  178,    0,    0,    0,    0,    0,
    0,    0,   38,    0,    0,    0,    0,    0,    0,    0,
    0,  179,   -1,    0,    0,    0,    0,    0,    0,    0,
    0,    0,  180,  181,  182,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,
};
final static short yygindex[] = {                         0,
   43,    0,    0,   25,   29,   83,    0,  254,    0,    0,
    0,   42,   49,   41,    0,    0,    0,   33,  114,    0,
   34,    0,  151,    0,  -80,   19,    0,  163,  154,  -16,
  291,  -13,    0,
};
final static int YYTABLESIZE=308;
static short yytable[];
static { yytable();}
static void yytable(){
yytable = new short[]{                         73,
   46,   44,   45,   34,  111,   42,  161,   42,   34,   86,
   45,   87,   44,   11,   10,   38,   34,   24,   42,  170,
   43,   34,   45,   37,   15,   21,  132,   28,   16,   34,
    7,    5,  104,   45,   15,   36,   97,   87,   16,  135,
   38,   46,   46,   46,   46,   46,   42,   46,   42,   42,
   42,   45,   48,   45,   45,   45,   38,   46,   39,   38,
   46,   24,   46,   68,  149,   42,   50,   42,   91,   21,
   45,   52,   45,   92,   15,   38,   74,   38,   16,   75,
   97,   87,  159,  160,   79,  129,   40,   90,  172,   89,
    1,   72,   77,    2,    3,    4,   65,   66,  146,    6,
    7,    8,    9,   49,   93,   99,   98,  105,  141,   94,
   55,  139,   43,  112,  140,    1,   70,  124,    2,  126,
  113,  114,  115,   76,  152,   46,   55,   67,   81,   55,
   42,   68,   80,   78,   95,   45,  164,  165,  166,   99,
   38,   99,   24,  107,   68,  108,  123,   44,    1,  109,
   21,    2,    3,    4,    5,    7,    5,    6,    7,    8,
    9,   97,   87,   55,  110,   99,   98,  121,   99,   98,
   55,   55,   55,   55,   55,   55,   55,  105,   99,   98,
    1,  120,  122,    2,    3,    4,    5,   96,  125,    6,
    7,    8,    9,   68,   96,  127,  128,   97,    6,    7,
    8,  129,  130,  171,  116,  117,  118,  119,   62,   63,
   64,  131,  133,  134,  136,   41,  137,  138,  146,   82,
   83,   84,   85,  147,  151,  148,   11,   53,  153,   55,
   40,  154,   53,  155,   54,   41,   31,   32,   33,   54,
   29,   31,   32,   33,  156,   53,   41,  162,   30,   31,
   32,   33,   54,   53,   31,   32,   33,    6,    7,    8,
  163,  167,   31,   32,   33,  168,  169,  173,    4,    4,
   46,   46,   46,   46,  174,   42,   42,   42,   42,    2,
   45,   45,   45,   45,   54,   38,   38,   38,   38,    6,
    7,    8,   61,  175,   62,   71,   91,  158,  150,  157,
   52,   90,   94,   75,   73,   71,   72,   51,
};
}
static short yycheck[];
static { yycheck(); }
static void yycheck() {
yycheck = new short[] {                         41,
    0,   40,   61,   45,   41,    0,   44,   46,   45,   60,
    0,   62,   40,   61,  123,    0,   45,    0,   46,   44,
   59,   45,   61,  269,    0,    0,  107,   40,    0,   45,
    0,    0,   41,   61,   10,    2,    0,    0,   10,  120,
  269,   41,   42,   43,   44,   45,   41,   47,   43,   44,
   45,   41,   10,   43,   44,   45,   41,    9,  123,   44,
   60,   44,   62,   39,   41,   60,   44,   62,   42,   44,
   60,   23,   62,   47,   50,   60,   44,   62,   50,   47,
   44,   44,  258,  259,   51,  123,  269,   43,  169,   45,
  257,   43,   50,  260,  261,  262,  123,   40,  123,  266,
  267,  268,  269,  125,   42,   65,   65,   66,  275,   47,
   28,  125,   59,   81,  128,  257,  269,   99,  260,  101,
   88,   89,   90,  125,  138,  125,   44,  269,   40,   47,
  125,  107,   46,   51,   41,  125,  153,  154,  155,   99,
  125,  101,  125,   44,  120,  125,   98,   40,  257,   41,
  125,  260,  261,  262,  263,  125,  125,  266,  267,  268,
  269,  125,  125,   81,  269,  125,  125,  269,  128,  128,
   88,   89,   90,   91,   92,   93,   94,  136,  138,  138,
  257,  123,  281,  260,  261,  262,  263,  262,   44,  266,
  267,  268,  269,  169,  262,  125,   44,  265,  266,  267,
  268,  123,  269,  163,   91,   92,   93,   94,  278,  279,
  280,   41,  264,   41,   40,  274,  269,   44,  123,  270,
  271,  272,  273,   40,   58,  125,  274,  269,   44,  147,
  269,   44,  269,   44,  276,  274,  278,  279,  280,  276,
  269,  278,  279,  280,  125,  269,  274,   41,  277,  278,
  279,  280,  276,  269,  278,  279,  280,  266,  267,  268,
  123,  125,  278,  279,  280,   41,  123,  125,  262,    0,
  270,  271,  272,  273,  125,  270,  271,  272,  273,    0,
  270,  271,  272,  273,  125,  270,  271,  272,  273,  266,
  267,  268,   44,  259,   44,   42,  125,  147,  136,  146,
  125,  125,  125,  125,  125,  125,  125,   17,
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
"Funcion : VOID ID '(' Parametro ')' '{' CuerpoFuncion '}'",
"Funcion : VOID ID '(' ')' '{' CuerpoFuncion '}'",
"Parametro : Tipo ID",
"CuerpoFuncion : ListSentenciasFuncion",
"ListSentenciasFuncion : SentenciaDeclarativa ',' ListSentenciasFuncion",
"ListSentenciasFuncion : SentenciaEjecutable ',' ListSentenciasFuncion",
"ListSentenciasFuncion : SentenciaEjecutable ','",
"ListSentenciasFuncion : SentenciaDeclarativa ','",
"ListSentenciasFuncion : RETURN ','",
"ListSentenciasFuncion : RETURN ',' ListSentenciasFuncion",
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

//#line 194 "gramatica.y"

  static ArrayList<Error> erroresLexicos = new ArrayList<Error>();
  static ArrayList<Error> erroresSintacticos = new ArrayList<Error>();
  static ArrayList<String> estructuraReconocida = new ArrayList<String>();

   public void chequearEnteroNegativo(String m){
          Integer numero = Integer.parseInt(m);
          if (numero <= 32767){
               if (TablaSimbolos.existeSimbolo(m)) {
                     TablaSimbolos.addAtributo(m, AccionSemantica.PUNTOFLOTANTE, AnalizadorLexico.getLineaAct());
               } else {
                     TablaSimbolos.addNuevoSimbolo(m);
                     TablaSimbolos.addAtributo(m, AccionSemantica.PUNTOFLOTANTE, AnalizadorLexico.getLineaAct());
               }
          } else {
               AnalizadorLexico.agregarErrorLexico("Entero negativo fuera de rango");
          }
   }

   public void chequearDoubleNegativo(String m){
        String n = m.replace('D', 'e');
        Double numero = Double.parseDouble(n);
        if (((numero <= 2.2250738585072014e-308) && (numero >= 1.7976931348623157e+308)) || numero == 0.0) {
             if (TablaSimbolos.existeSimbolo(m)) {
                   TablaSimbolos.addAtributo(m, AccionSemantica.PUNTOFLOTANTE, AnalizadorLexico.getLineaAct());
             } else {
                   TablaSimbolos.addNuevoSimbolo(m);
                   TablaSimbolos.addAtributo(m, AccionSemantica.PUNTOFLOTANTE, AnalizadorLexico.getLineaAct());
             }
        } else {
             AnalizadorLexico.agregarErrorLexico("Double negativo fuera de rango");
        }
   }

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
   }

  public int yylex() throws IOException{
    Token t = AnalizadorLexico.obtenerToken();
    this.yylval = new ParserVal(t.getLexema());
    return t.getId();
  }

  public static void yyerror(String error){
    System.out.println(error);
  }
//#line 478 "Parser.java"
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
//#line 17 "gramatica.y"
{agregarErrorSintactico("Se espera '}' en la linea ");}
break;
case 3:
//#line 18 "gramatica.y"
{agregarErrorSintactico("Se espera '{' en la linea ");}
break;
case 4:
//#line 19 "gramatica.y"
{agregarErrorSintactico("Se esperan '{' '}' en la linea ");}
break;
case 7:
//#line 24 "gramatica.y"
{agregarErrorSintactico("Se esperaba una ',' al final de la linea ");}
break;
case 20:
//#line 47 "gramatica.y"
{agregarErrorSintactico("Se espera el tipo de la variable en la linea ");}
break;
case 21:
//#line 48 "gramatica.y"
{agregarErrorSintactico("Se espera identificador de la variable en la linea ");}
break;
case 32:
//#line 67 "gramatica.y"
{agregarErrorLexico("Un entero corto no puede ser negativo en la linea ");}
break;
case 34:
//#line 69 "gramatica.y"
{chequearEnteroNegativo(val_peek(0).sval);}
break;
case 35:
//#line 70 "gramatica.y"
{chequearDoubleNegativo(val_peek(0).sval);}
break;
case 50:
//#line 98 "gramatica.y"
{agregarEstructura("Reconoce ELSE IF ");}
break;
case 51:
//#line 99 "gramatica.y"
{agregarEstructura("Reconoce IF ");}
break;
case 54:
//#line 104 "gramatica.y"
{agregarErrorSintactico("Se esperaba una ',' al final de la linea ");}
break;
case 65:
//#line 121 "gramatica.y"
{agregarEstructura("Reconoce funcion VOID ");}
break;
case 66:
//#line 122 "gramatica.y"
{agregarEstructura("Reconoce funcion VOID ");}
break;
case 75:
//#line 137 "gramatica.y"
{agregarErrorSintactico("Se esperaba una ',' al final de la linea ");}
break;
case 76:
//#line 138 "gramatica.y"
{agregarErrorSintactico("Se esperaba una ',' al final de la linea ");}
break;
case 86:
//#line 158 "gramatica.y"
{agregarEstructura("Reconoce funcion DO UNTIL");}
break;
case 87:
//#line 159 "gramatica.y"
{agregarErrorSintactico("Se esperaba una condicion ");}
break;
case 88:
//#line 164 "gramatica.y"
{agregarEstructura("Reconoce funcion TOD ");}
break;
case 89:
//#line 165 "gramatica.y"
{agregarErrorSintactico("Se esperaba una Expresion ");}
break;
case 96:
//#line 176 "gramatica.y"
{agregarEstructura("Reconoce CLASE");}
break;
case 98:
//#line 180 "gramatica.y"
{agregarEstructura("Reconoce Funcion sin cuerpo");}
break;
case 100:
//#line 184 "gramatica.y"
{agregarEstructura("Reconoce funcion IMPL");}
break;
//#line 719 "Parser.java"
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
