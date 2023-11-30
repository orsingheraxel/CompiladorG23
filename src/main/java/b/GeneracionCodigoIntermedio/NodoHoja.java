package b.GeneracionCodigoIntermedio;

public class NodoHoja extends Nodo{
    
    public NodoHoja(String lex) {
        super(lex);
        System.out.println("NodoHoja " + this);
    }

    @Override
    public String getAssembler() {
        return "";
    }

    @Override
    public NodoHoja getUltimoNodo() {
        return this;
    }
    //Para los Identificadores, se deberá registrar el tipo, a partir de las sentencias declarativas.
    // Para las constantes, se deberá registrar el tipo durante el Análisis Léxico.
}
