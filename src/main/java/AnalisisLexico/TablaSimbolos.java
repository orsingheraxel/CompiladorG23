package AnalisisLexico;

import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

public class TablaSimbolos {

    private static Map<String, Token> simbolos = new HashMap<>(); // Lexema, y atributos del mismo.

    public static void imprimir(PrintWriter escritor) {
        for (String key : simbolos.keySet()) {
            Token token = simbolos.get(key);
            escritor.println(token.toString());
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
        try{
            return simbolos.get(lexema);
        } catch (Exception e) {
            return null;
        }
    }

    public static Token buscarPorAmbito (String palabra) {
        for (Map.Entry<String, Token> entry : simbolos.entrySet()) {
            String lexema = entry.getKey();
            if (lexema.toLowerCase().contains(palabra.toLowerCase())) {
                Token t = entry.getValue();
                return t;
            }
        }
        return null; // Retornar null si no se encuentra ninguna coincidencia
    }

    public static void removeToken(String lexema) {
        simbolos.remove(lexema);
    }

    public static Token getTokenParametroDeFuncion(String nombreFuncion) {
        for (Map.Entry<String, Token> entry : simbolos.entrySet()) {
            String lexema = entry.getKey();
            Token token = entry.getValue();

            // Verifica si el lexema representa una función y si su ámbito coincide con el nombre de la función proporcionado
            if (token.getTipo().equals("funcion") && lexema.toLowerCase().equals(nombreFuncion.toLowerCase())) {
                // Busca el parámetro asociado a la función
                String[] partesLexema = lexema.split(":");
                if (partesLexema.length == 3) {  // Verifica si hay al menos 3 partes en el lexema
                    String nombreParametro = partesLexema[2];
                    return simbolos.get(nombreParametro);
                }
            }
        }
        return null;  // Retorna null si no se encuentra la función o no tiene un parámetro asociado
    }

}
