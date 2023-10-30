package AnalisisLexico.AccionesSemanticas;

import AnalisisLexico.AnalizadorLexico;
import AnalisisLexico.Token;

import java.io.IOException;
import java.io.Reader;

public class AS1 extends AccionSemantica {

    @Override
    public void ejecutar(Token t, Reader entrada) throws IOException {
        if (t.getLexema().equals("\n"))
            AnalizadorLexico.sumLinea();
        t.resetLexema();
    }



}
