package AnalisisLexico;

import java.io.PrintWriter;

public class Token{
    private int id;
    private String lexema;
    private int linea;


    public Token(int id, String lexema, int linea) {
        this.id = id;
        this.lexema = lexema;
        this.linea = linea;
    }

    public Token(){
        this.lexema= "";
    }

    public Token(Token t){
        this.id = t.getId();
        this.lexema = t.getLexema();
    }

    public int getId() {
        return id;
    }

    public String getLexema() {
        return lexema;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void truncarLexema(int i){
        lexema = lexema.substring(0, i);
    }

    public void agregarCaracter(String s) {
        this.lexema = lexema + s;
    }

    public void borrarUltimoCaracter(){
        String auxiliarnuevo = "";
        for (int i=0;i<this.lexema.length()-1;i++){
            auxiliarnuevo += lexema.charAt(i);
        }
        this.lexema = auxiliarnuevo;
    }

    public void eliminarNoDigitos() {
        this.lexema = lexema.replaceAll("[^\\d]", "");
    }

    public void resetLexema(){
        this.lexema = "";
    }

    public void imprimir(PrintWriter escritor) {
        escritor.println("ID: " + id);
        escritor.println("Lexema: " + lexema);
        escritor.println("Línea: " + linea);
    }



}
