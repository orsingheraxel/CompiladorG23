package a.AnalisisLexico;

import java.io.*;
import java.util.Iterator;

import b.GeneracionCodigoIntermedio.Nodo;
import c.CodigoAssembler.*;

import javax.swing.text.html.HTMLDocument;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {

        args = new String[]{"C:\\Users\\sanlu\\Documents\\Facultad\\CompiladorG23\\src\\main\\java\\CasosDePrueba\\pruebaArbol.txt"};

        if (args.length < 1) {
            System.out.println("Debe proporcionar el nombre del archivo como argumento.");
            return;
        }

        String archivo = args[0]; // El primer argumento es el nombre del archivo.

        try {
            // Abre y lee el archivo
            BufferedReader br = new BufferedReader(new FileReader(archivo));

            // Abre un archivo de salida para guardar la salida

            AnalizadorLexico.setEntrada(br);
            Parser parser = new Parser();
            parser.run();

            ///////////////////////////////////////////////////// Escribe en el archivo de salida
            String salida = "salida-" + archivo;
            File archivoEntradaFile = new File(archivo);
            String directorioEntrada = archivoEntradaFile.getParent(); // Obtiene el directorio del archivo de entrada
            String archivoSalida = directorioEntrada + File.separator + "salida.txt"; // "salida.txt"
            FileWriter fw = new FileWriter(archivoSalida);
            PrintWriter escritor = new PrintWriter(fw);



            //////////////////////////////////////////////////////

            escritor.println("------------------------------------------TABLA DE SIMBOLOS------------------------------------------");
            TablaSimbolos.imprimir(escritor);
            escritor.println(" ");
            escritor.println("-------------------------------------------ERRORES LEXICOS-------------------------------------------");
            for (int i = 0; i < AnalizadorLexico.erroresLexicos.size(); i++) {
                Error elemento = AnalizadorLexico.erroresLexicos.get(i);
                escritor.println("Error Lexico: " + elemento.getError() + " en la linea: " + elemento.getLinea());
            }

            escritor.println(" ");
            escritor.println("-------------------------------------------ERRORES SINTACTICOS-------------------------------------------");
            escritor.println(" ");
            for (int i = 0; i < AnalizadorLexico.erroresSintacticos.size(); i++) {
                Error elemento = AnalizadorLexico.erroresSintacticos.get(i);
                escritor.println("Error Sintactico: " + elemento.getError() + " en la linea: " + elemento.getLinea());
            }
            escritor.println("");
            escritor.println("-------------------------------------------ERRORES SEMANTICOS-------------------------------------------");
            escritor.println(" ");
            for (int i = 0; i < Parser.erroresSemanticos.size(); i++) {
                Error elemento = Parser.erroresSemanticos.get(i);
                escritor.println("Error Semantico: " + elemento.getError() + " en la linea: " + elemento.getLinea());
            }
            escritor.println("");
            escritor.println("-------------------------------------------WARNINGS-------------------------------------------");
            escritor.println(" ");
            for (int i = 0; i < AnalizadorLexico.warnings.size(); i++) {
                Error elemento = AnalizadorLexico.warnings.get(i);
                escritor.println("Warning: " + elemento.getError() + " en la linea: " + elemento.getLinea());
            }
            escritor.println(" ");
            /*escritor.println("-------------------------------------------ESTRUCTURAS RECONOCIDAS-------------------------------------------");
            escritor.println(" ");
            for (int i = 0; i < AnalizadorLexico.estructuraReconocida.size(); i++) {
                    Error elemento = AnalizadorLexico.estructuraReconocida.get(i);
                    escritor.println("Estructura: " + elemento.getError() + " en la linea: " + elemento.getLinea());
            }
            escritor.println(" ");*/
            escritor.println("-------------------------------------------NODOS ARBOL SINTACTICO-------------------------------------------");
            escritor.println(" ");
            if (parser.getRaiz()!=null)
                parser.getRaiz().recorrerArbol("", escritor);

            escritor.println("-------------------------------------------FUNCIONES NODOS ARBOL SINTACTICO-------------------------------------------");
            escritor.println(" ");
            for (int i = 0; i<parser.getFunciones().size();i++){
                Nodo e = parser.getFunciones().get(i);
                e.recorrerArbol(" ", escritor);
            }

            escritor.println(parser.getFunciones());

            GeneradorAssembler generador = new GeneradorAssembler(parser);
            File f = new File(archivo.substring(0,archivo.length()-4)+".asm");
            f.createNewFile();
            PrintWriter pw;
            try {
                pw = new PrintWriter(archivo.substring(0,archivo.length()-4)+".asm");
                pw.print(generador.getAssembler());
                pw.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }

            br.close();
            escritor.close();
            fw.close();

        } catch (IOException e){System.err.println("Error al leer el archivo: " + e.getMessage());}
    }
}