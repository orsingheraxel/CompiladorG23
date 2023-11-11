package GeneracionCodigoIntermedio;
import AnalisisLexico.*;
public class NodoControl extends Nodo{ //tiene un solo hijo, el otro es null siempre

    public NodoControl(String t, Nodo a) {
        super(t);
        this.der = a;
        System.out.println("NodoControl " + t);
    }

}
