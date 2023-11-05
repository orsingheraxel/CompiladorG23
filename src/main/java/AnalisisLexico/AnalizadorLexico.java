package AnalisisLexico;

import AnalisisLexico.AccionesSemanticas.AccionSemantica;

import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

public class AnalizadorLexico {

    private static int tamanioMaximo = 20;
    private static int lineaAct = 1;
    private static int estadoAct = 0;
    private static TPR tablaPalabrasReservadas = new TPR();
    private static Reader entrada;
    private static int[][] matrizEstados  = GeneradorMatrices.getMatrizEstados();;
    private static AccionSemantica[][] matrizAS = GeneradorMatrices.getMatrizAS();;
    static List<Error> erroresLexicos = new ArrayList<Error>();
    static List<Error> erroresSintacticos = new ArrayList<Error>();
    //private static List<ErrorSintactico> erroresYACC = new ArrayList<ErrorSintactico>();

    static List<Error> estructuraReconocida = new ArrayList<String>();
    static List<Error> warnings = new ArrayList<Error>();

    public static int getLineaAct() {
        return lineaAct;
    }

    public static void sumLinea() {
        lineaAct++;
    }

    public int getTamanioMaximo() {
        return tamanioMaximo;
    }

    public static void agregarErrorLexico(String error){
        Error e = new Error(error, getLineaAct());
        erroresLexicos.add(e);
    }

    public static void agregarErrorSintactico(String error){
        Error e = new Error(error, AnalizadorLexico.getLineaAct());
        erroresSintacticos.add(e);
    }

    public static void agregarEstructura(String error){
        Error e = new Error(error, AnalizadorLexico.getLineaAct());
        estructuraReconocida.add(e);
    }

    public static void addWarning(String s) {
        Error e = new Error(s, getLineaAct());
        warnings.add(e);
    }

    public static void setEntrada(Reader entrada){
        AnalizadorLexico.entrada = entrada;
    }

    public static Integer isPR(String key){
        return tablaPalabrasReservadas.get(key);
    }
    private static char mapCaracter(char c) {
        if (Character.isDigit(c)) {
            return '0';
        }
        if ((Character.isUpperCase(c) && c != 'D')){
            return 'L';
        }
        if ((Character.isLowerCase(c) && c != 'u' && c != 'i' && c != 's' && c != 'd')) {
            return 'l';
        }
        return c;
    }

    public static boolean caracterEspecial(String caracterComoString){
        return ((caracterComoString.equals("\n") || caracterComoString.equals("\r")
                || caracterComoString.equals("\t") || caracterComoString.isEmpty()));
    }
    public static Token obtenerToken() throws IOException {
        Token token = new Token();
        int valorLeido = 0;
        entrada.mark(1);
        int val =0;
        while (estadoAct != -1 && val != 100 && (-1 != (valorLeido = entrada.read()))) {
            char caracter = Character.toChars(valorLeido)[0];
            String caracterComoString = Character.toString(caracter);
            token.agregarCaracter(caracterComoString);
            int valorCaracter = getCaracter(caracter);
            matrizAS[estadoAct][valorCaracter].ejecutar(token, entrada);
            estadoAct = matrizEstados[estadoAct][valorCaracter];
            System.out.println("estadoAct: " + estadoAct + "valorCaracter: " + valorCaracter);
            entrada.mark(1);
            if (estadoAct == 0){
                val = 100;
            }
            if (caracterEspecial(token.getLexema()) || token.getLexema().isEmpty() || token.getLexema().isBlank()){
                val = 0;
            }

        }
        val =0;
        System.out.println("Lexema = " + token.getLexema() + " | ID = " +  token.getId());
        Token ret = new Token(token);
        token.resetLexema();
        return ret;
    }

    private static int getCaracter(char c){
        int valor;
        switch(mapCaracter(c)){
            case 'L':
                valor = 0;
                break;
            case 'l':
                valor = 1;
                break;
            case '0':
                valor = 2;
                break;
            case '*':
                valor = 3;
                break;
            case '+':
                valor = 4;
                break;
            case '=':
                valor = 5;
                break;
            case '<':
                valor = 6;
                break;
            case '>':
                valor = 7;
                break;
            case '!':
                valor = 8;
                break;
            case '-':
                valor = 9;
                break;
            case '_':
                valor = 10;
                break;
            case '#':
                valor = 11;
                break;
            case '\t':
            case '\n':
            case '\r':
                valor = 12;
                break;
            case '.':
                valor = 14;
                break;
            case 'u':
                valor = 15;
                break;
            case 'i':
                valor = 16;
                break;
            case 's':
                valor = 17;
                break;
            case 'D' :
                valor = 18;
                break;
            case ' ':
                valor = 19;
                break;
            case 'd':
                valor = 20;
                break;
            default:
                valor = 13 ;
        }
        return valor;
    }

}
