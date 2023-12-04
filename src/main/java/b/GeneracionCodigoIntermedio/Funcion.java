package b.GeneracionCodigoIntermedio;
import a.AnalisisLexico.*;

public class Funcion {

    private String id;
    private Token parametro;

    public Funcion() {
    }

    public boolean equals(Object o){
        Funcion otra = (Funcion) o;
        return this.getId().equals(otra.getId());
    }

    public Funcion(String id, Token parametro) {
        this.id = id;
        this.parametro = parametro;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    public Token getParametro() {
        return parametro;
    }

    public void setParametro(Token parametro) {
        this.parametro = parametro;
    }


}
