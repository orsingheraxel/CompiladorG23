package b.GeneracionCodigoIntermedio;

import a.AnalisisLexico.ParserVal;
import a.AnalisisLexico.Token;

import java.util.Stack;


public abstract class Nodo extends ParserVal {
    protected Nodo izq;
    protected Nodo der;

    protected Token t;
    public static int numeroVariable = 0;
    protected static int numeroLabel = 0;
    protected static int numeroPrint = 0;
    public static String data = "";
    protected static Stack<String> pilaLabels = new Stack();


    public Nodo (Nodo e){
        if (e.getIzq()!=null) {
            this.izq = e.getIzq();
        } else {this.izq=null;}
        if (e.getDer()!=null) {
            this.der = e.getDer();
        }else{this.der=null;}
        this.t = e.getToken();
    }

    public Nodo(String lex){
        izq = null;
        der = null;
        this.t = new Token(lex);
    }

    public Nodo(String lex,Nodo izq,Nodo der){
        this.t = new Token(lex);
        this.izq = izq;
        this.der = der;
    }

    public Token getToken(){return this.t;}
    public void setToken(Token t){this.t = t;}

    public String getTipo(){
        return t.getTipo();
    }

    public void setTipo(String tipo){
        t.setTipo(tipo);
    }

    public void setAmbito(String amb){
        t.setAmbito(amb);
    }

    public String getAmbito(){
        return t.getAmbito();
    }

    public void setLexema(String lex){
        t.setTipo(lex);
    }

    public String getLexema(){
        return t.getLexema();
    }

    public String getUso(){
        return t.getUso();
    }

    public void setUso(String uso){
        t.setUso(uso);
    }

    public Nodo getIzq(){return this.izq;}
    public Nodo getDer(){return this.der;}
    public void setIzq(Nodo izq) { this.izq = izq; }
    public void setDer(Nodo der) { this.der = der; }

    @Override
    public String toString() {
        return t.getLexema();
    }


    public static String getVariableAuxiliar() {
        ++numeroVariable;
        return "@aux" + numeroVariable;
    }

    public static String getVariablePrint() {
        ++numeroPrint;
        return "@print" + numeroPrint;
    }

    public static String getLabel() {
        ++numeroLabel;
        return "label" + numeroLabel;
    }
    public abstract void recorrerArbol(String s);
    public abstract String getAssembler();
    public abstract NodoHoja getUltimoNodo();

}
