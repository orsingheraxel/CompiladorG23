package a.AnalisisLexico.AccionesSemanticas;

import a.AnalisisLexico.Token;

import java.io.IOException;
import java.io.Reader;

public class AS5 extends AccionSemantica{
    @Override
    public void ejecutar(Token t, Reader entrada) {
        t.borrarUltimoCaracter();
        try {
            entrada.reset();
        } catch (IOException e1) {
            e1.printStackTrace();
        }
        t.setId(PUNTOFLOTANTE);
        t.setTipo("DOUBLE");
    }
}
