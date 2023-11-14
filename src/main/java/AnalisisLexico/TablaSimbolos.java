package AnalisisLexico;

import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

public class TablaSimbolos {

    private static Map<String, Token> simbolos = new HashMap<>(); // Lexema, y atributos del mismo.

    public static void imprimir(PrintWriter escritor) {
        for (String key : simbolos.keySet()) {
            Token token = simbolos.get(key);
            escritor.print("Clave: " + key + ", ");
            escritor.print("Valor: ");
            token.imprimir(escritor);
        }
    }

    public static void addNuevoSimbolo(String lexema) {
        Token t = new Token();
        simbolos.put(lexema, t);
    }

    public static void addSimbolo(String lexema,Token t){
        simbolos.put(lexema,t);
    }

    public static boolean existeSimbolo(String lexema) {
        return simbolos.containsKey(lexema);
    }

    public static void addAtributo(String lexema, int id, int linea) {
        Token t = new Token(id, lexema, linea);
        simbolos.put(lexema, t);
    }

    public static void setUso (String lexema,String uso){
        Token t = simbolos.get(lexema);
        t.setUso(uso);
        simbolos.put(lexema, t);
    }

    public static String getUso(String lexema){
        Token t = simbolos.get(lexema);
        return t.getUso();
    }

    public static String getTipo(String lexema){
        Token t = simbolos.get(lexema);
        return t.getTipo();
    }

    public static String getAmbito(String lexema){
        Token t = simbolos.get(lexema);
        return t.getAmbito();
    }

    public static void setAmbito (String lexema,String ambito){
        Token t = simbolos.get(lexema);
        t.setAmbito(ambito);
        simbolos.put(lexema, t);
    }
    public static Token getToken(String lexema) {
        return simbolos.get(lexema);
    }

    public static void removeToken(String lexema) {
        simbolos.remove(lexema);
    }
}
