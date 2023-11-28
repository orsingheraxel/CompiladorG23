package GeneracionCodigoIntermedio;
import AnalisisLexico.*;
public class NodoControl extends Nodo{ //tiene un solo hijo, el otro es null siempre

    public NodoControl(String lex, Nodo a) {
        super(lex);
        this.setDer(a);
        System.out.println("NodoControl " + t);
    }

    public NodoControl(String lex){
        super(lex);
    }

}
