package AnalisisLexico.AccionesSemanticas;

import AnalisisLexico.Token;

import java.io.Reader;

public class AS3 extends AccionSemantica{//SETEA ID DE IDENTIFICADORES
    @Override
    public void ejecutar(Token t, Reader entrada) {
        System.out.println("Se reconocio un comentario.");
    }
}
