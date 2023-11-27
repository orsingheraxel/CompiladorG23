package GeneracionCodigoIntermedio;

public class Funcion {

    private String id;
    private String tipoParametro;

    public Funcion() {
    }

    public boolean equals(Object o){
        Funcion otra = (Funcion) o;
        return this.getId().equals(otra.getId());
    }

    public Funcion(String id, String tipoParametro) {
        this.id = id;
        this.tipoParametro = tipoParametro;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTipoParametro() {
        return tipoParametro;
    }

    public void setTipoParametro(String tipoParametro) {
        this.tipoParametro = tipoParametro;
    }
}
