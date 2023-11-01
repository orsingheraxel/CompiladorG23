package AnalisisLexico;

public class Token{
    private int id;
    private String lexema;


    public Token(){
        this.lexema= "";
    }
    public Token(int i, String l){
        id=i;
        lexema=l;
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

    // Usamos una expresión regular para reemplazar todo lo que no sea dígito por una cadena vacía
    public void eliminarNoDigitos() {
        this.lexema = lexema.replaceAll("[^\\d]", "");
    }

    public void resetLexema(){
        this.lexema = "";
    }



}
