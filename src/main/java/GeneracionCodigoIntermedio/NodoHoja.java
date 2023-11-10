package GeneracionCodigoIntermedio;
import AnalisisLexico.*;

public class NodoHoja extends Nodo{
    
    public NodoHoja(String lex) {
        super(lex);
    }
    //Para los Identificadores, se deberá registrar el tipo, a partir de las sentencias declarativas.
    // Para las constantes, se deberá registrar el tipo durante el Análisis Léxico.
}
