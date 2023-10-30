package AnalisisLexico.TablaSimbolos;

public class Simbolo {
    private int id; //ID CTE USHORT INT DOUBLE
    private int linea;

    public Simbolo() {
    }

    public Simbolo(int id, int linea){
        this.id=id;
        this.linea=linea;
    }


    public void imprimir() {
        System.out.println("ID: " + id);
        System.out.println("Línea: " + linea);
    }
    /*

    if 30 > 2

    lexema 30
    tipo CTE
    linea 12

    =========

    if 2_i

    lexema 2_i
    tipo INT
    linea 23


    */

}
