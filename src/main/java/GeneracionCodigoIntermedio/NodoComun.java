package GeneracionCodigoIntermedio;
import AnalisisLexico.*;
public class NodoComun extends Nodo{
    public NodoComun(String lex) {
        super(lex);
        System.out.println("NodoComun " + lex);
    }

    public NodoComun(String lex,Nodo izq,Nodo der){
        super(lex,izq,der);
        System.out.print("NodoComun " + this);
        System.out.println(" izq: " + izq + " der: " + der);
    }
}
