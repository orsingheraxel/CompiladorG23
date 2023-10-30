package AnalisisLexico;

import java.io.BufferedReader;
import java.io.IOException;

public class ImpresorEntrada {
    BufferedReader entrada;
    public ImpresorEntrada(BufferedReader entrada){
        this.entrada= entrada;
    }

    public void imprimirEntrada() throws IOException {
        int i = 1;
        while (this.entrada.ready()) {
            System.out.println("Linea "+ i + ": "+ entrada.readLine());
            i++;
        }
    }
}
