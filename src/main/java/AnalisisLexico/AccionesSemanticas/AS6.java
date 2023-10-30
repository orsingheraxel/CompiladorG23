package AnalisisLexico.AccionesSemanticas;

import AnalisisLexico.Token;

import java.io.IOException;
import java.io.Reader;


public class AS6 extends AccionSemantica{

    @Override
    public void ejecutar(Token t, Reader entrada) throws IOException {
        t.setId(CADENA);
    }
}
