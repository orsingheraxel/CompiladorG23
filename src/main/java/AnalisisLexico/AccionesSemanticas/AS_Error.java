package AnalisisLexico.AccionesSemanticas;

import AnalisisLexico.AnalizadorLexico;
import AnalisisLexico.Token;

import java.io.Reader;

public class AS_Error extends AccionSemantica {
    @Override
    public void ejecutar(Token t, Reader entrada) {
        AnalizadorLexico.agregarErrorSintactico("Error! Hubo una variable mal definida");
    }
}
