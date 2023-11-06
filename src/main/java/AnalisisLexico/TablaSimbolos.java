package AnalisisLexico;


import AnalisisLexico.Token;

import java.io.PrintWriter;
import java.util.HashMap;

public class TablaSimbolos {

    private static HashMap<String, Token> simbolos = new HashMap<>(); // Lexema, y atributos del mismo.

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

    public static boolean existeSimbolo(String lexema) {
        return simbolos.containsKey(lexema);
    }

    public static void addAtributo(String lexema, int id, int linea) {
        Token t = new Token(id, lexema, linea);
        simbolos.put(lexema, t);
    }

    public static Token getAtributo(String lexema) {
        return simbolos.get(lexema);
    }

    public static void removeAtributo(String lexema) {
        simbolos.remove(lexema);
    }
}