package AnalisisLexico.TablaSimbolos;


import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class TablaSimbolos {

    private static HashMap<String, Simbolo> simbolos = new HashMap<>(); //Lexema, y atributos del mismo.



    public static void imprimir(PrintWriter escritor){
        for (String key : simbolos.keySet()) {
            Simbolo simbolo = simbolos.get(key);
            escritor.print("Clave: " + key + ", ");
            escritor.print("Valor: ");
            simbolo.imprimir(escritor);
        }

    }
    public static void addNuevoSimbolo(String lexema) {
        Simbolo s = new Simbolo();
        simbolos.put(lexema, s);
    }

    public static boolean existeSimbolo(String lexema) {
        return simbolos.containsKey(lexema);
    }

    public static void addAtributo(String lexema, int id, int linea) {
        Simbolo s = new Simbolo(id, linea);
        simbolos.put(lexema, s);
    }

    public static Simbolo getAtributo(String lexema) {
        if (simbolos.get(lexema) != null)
            return simbolos.get(lexema);
        return null;
    }

    public static void removeAtributo(String lexema) {
        simbolos.remove(lexema);
    }

    //public static void imprimirTabla();


    public static Simbolo getAtributos (String lexema) {
        return simbolos.get(lexema);
    }

}
