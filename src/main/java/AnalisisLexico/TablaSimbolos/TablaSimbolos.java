package AnalisisLexico.TablaSimbolos;


import AnalisisLexico.Token;

import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class TablaSimbolos {

    private static HashMap<String, Token> tokens = new HashMap<>(); // Lexema, y atributos del mismo.

    public static void imprimir(PrintWriter escritor) {
        for (String key : tokens.keySet()) {
            Token token = tokens.get(key);
            escritor.print("Clave: " + key + ", ");
            escritor.print("Valor: ");
            token.imprimir(escritor);
        }
    }

    public static void addNuevoSimbolo(String lexema) {
        Token t = new Token();
        tokens.put(lexema, t);
    }

    public static boolean existeSimbolo(String lexema) {
        return tokens.containsKey(lexema);
    }

    public static void addAtributo(String lexema, int id, int linea) {
        Token t = new Token(id, lexema, linea);
        tokens.put(lexema, t);
    }

    public static Token getToken(String lexema) {
        return tokens.get(lexema);
    }

    public static void removeToken(String lexema) {
        tokens.remove(lexema);
    }
}
