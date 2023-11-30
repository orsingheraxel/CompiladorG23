package a.AnalisisLexico.AccionesSemanticas;

import a.AnalisisLexico.AnalizadorLexico;
import a.AnalisisLexico.Token;

import java.io.Reader;

public class AS3 extends AccionSemantica{//SETEA ID DE IDENTIFICADORES
    @Override
    public void ejecutar(Token t, Reader entrada) {
        AnalizadorLexico.agregarEstructura("Se reconocio un comentario");
    }
}
