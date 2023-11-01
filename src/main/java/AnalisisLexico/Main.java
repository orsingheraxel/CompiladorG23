package AnalisisLexico;

import AnalisisLexico.TablaSimbolos.TablaSimbolos;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException{
        Scanner lector=new Scanner(System.in);
        System.out.println("Ingrese el nombre del archivo del cual se quiere leer seguido de '.' y la extención del archivo.");

        String nombreArchivo = lector.nextLine();
        BufferedReader entrada = new BufferedReader(new FileReader("C:/Users/Axel/Desktop/Compiladores/src/main/java/AnalisisLexico/"+nombreArchivo));

        BufferedReader entradaAMostrar = new BufferedReader(new FileReader("C:/Users/Axel/Desktop/Compiladores/src/main/java/AnalisisLexico/" + nombreArchivo));
        System.out.println("\nEntrada: \n");
        ImpresorEntrada impresora = new ImpresorEntrada(entradaAMostrar);
        impresora.imprimirEntrada();
        System.out.println("\n\n");

        AnalizadorLexico.setEntrada(entrada);
        Parser parser=new Parser();
        parser.run();

        System.out.println( "------------------------------------------TABLA DE SIMBOLOS------------------------------------------");
        TablaSimbolos.imprimir();
        System.out.println(" ");
        System.out.println( "-------------------------------------------ERRORES LEXICOS-------------------------------------------");
        for (int i = 0; i < AnalizadorLexico.erroresLexicos.size(); i++) {
            Error elemento = AnalizadorLexico.erroresLexicos.get(i);
            System.out.println("Error Lexico: " + elemento.getError() + " en la linea: " + elemento.getLinea());
        }
        System.out.println(" ");
        System.out.println( "-------------------------------------------ERRORES SINTACTICOS-------------------------------------------");
        System.out.println(" ");
        for (int i = 0; i < AnalizadorLexico.erroresSintacticos.size(); i++) {
            Error elemento = AnalizadorLexico.erroresSintacticos.get(i);
            System.out.println("Error Sintactico: " + elemento.getError() + " en la linea: " + elemento.getLinea());
        }
        System.out.println(" ");
        System.out.println( "-------------------------------------------WARNINGS-------------------------------------------");
        System.out.println(" ");
        for (int i = 0; i < AnalizadorLexico.warnings.size(); i++) {
            Error elemento = AnalizadorLexico.warnings.get(i);
            System.out.println("Warning: " + elemento.getError() + " en la linea: " + elemento.getLinea());
        }
        System.out.println(" ");
        System.out.println( "-------------------------------------------ESTRUCTURAS RECONOCIDAS-------------------------------------------");
        System.out.println(" ");
        for (int i = 0; i < AnalizadorLexico.estructuraReconocida.size(); i++) {
            String elemento = AnalizadorLexico.estructuraReconocida.get(i);
            System.out.println("Estructura: " + elemento);
        }

    }
}