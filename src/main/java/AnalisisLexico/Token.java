package AnalisisLexico;

import java.io.PrintWriter;

public class Token{
    private Integer id;
    private String lexema;
    private Integer linea;
    private String uso;
    private String tipo;
    private String ambito;

    public Token(String lexema) {
        this.id = null;
        this.lexema = lexema;
        this.linea = null;
        this.uso = null;
        this.tipo = null;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setLinea(Integer linea) {
        this.linea = linea;
    }

    public void setTipo(String tipo){
        this.tipo = tipo;
    }

    public String getTipo(){
        return tipo;
    }

    public Token(int id, String lexema) {
        this.id = id;
        this.lexema = lexema;
        this.linea = null;
        this.uso = "";
    }

    public Token(int id, String lexema, int linea) {
        this.id = id;
        this.lexema = lexema;
        this.linea = linea;
        this.uso = "";
    }

    public Token(int id, String lexema, int linea, String uso) {
        this.id = id;
        this.lexema = lexema;
        this.linea = linea;
        this.uso = uso;
    }

    public Token(){
        this.lexema= "";
    }

    public void setAmbito(String ambito) {
        this.ambito = ambito;
    }

    public String getAmbito() {
        return ambito;
    }

    public Token(Token t){
        this.id = t.getId();
        this.lexema = t.getLexema();
    }

    public int getId() {
        return id;
    }

    public int getLinea() {
        return linea;
    }

    public String getUso() {
        return uso;
    }

    public String getLexema() {
        return lexema;
    }

    public void setLexema(String lexema) {
        this.lexema = lexema;
    }

    public void setLinea(int linea) {
        this.linea = linea;
    }

    public void setUso(String uso) {
        this.uso = uso;
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
