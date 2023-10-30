package AnalisisLexico.AccionesSemanticas;

import AnalisisLexico.Token;

import java.io.IOException;
import java.io.Reader;

public class AS9 extends AccionSemantica { //BORRA Y SETEA ID DE CARACTERES ESPECIALES

    private final AccionSemantica AS0 = new AS0();
    @Override
    public void ejecutar(Token t, Reader entrada) throws IOException {
        t.borrarUltimoCaracter();
        try {
            entrada.reset();
        } catch (IOException e) {
            e.printStackTrace();
        }
        AS0.ejecutar(t, entrada);
    }
}

