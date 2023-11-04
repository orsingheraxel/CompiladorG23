package AnalisisLexico.AccionesSemanticas;

import AnalisisLexico.AnalizadorLexico;
import AnalisisLexico.Token;

import java.io.Reader;

public class AS_Error extends AccionSemantica {
    @Override
    public void ejecutar(Token t, Reader entrada) {
        t.resetLexema();
        System.out.println("ENTRA A ERRRORRRR AS");
        AnalizadorLexico.agregarErrorSintactico("Error! Hubo una variable mal definida");
        //t.resetLexema();
    }
}
