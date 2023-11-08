package GeneracionCodigoIntermedio;
import AnalisisLexico.*;

public class Nodo {
    private Nodo izq;
    private Nodo der;
    private Token t;

    //Incorporar un atributo Uso en la Tabla de Símbolos,
    // indicando el uso del identificador en el programa
    // (variable, nombre de clase, nombre de método, nombre de parámetro, etc.).

    public Nodo(String lex){
        izq = null;
        der = null;
        this.t = new Token(lex);
    }


    public Token getToken(){return this.t;}
    public void setToken(Token t){this.t = t;}

    public String getTipo(){
        return t.getTipo();
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
}
