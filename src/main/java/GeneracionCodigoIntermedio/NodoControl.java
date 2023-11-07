package GeneracionCodigoIntermedio;
import AnalisisLexico.*;
public class NodoControl extends Nodo{
    private Nodo hijo;

    public NodoControl(String t, Nodo a) {
        super(t);
        this.hijo=a;
    }
}
