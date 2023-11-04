package AnalisisLexico.AccionesSemanticas;

import AnalisisLexico.*;
import AnalisisLexico.TablaSimbolos.TablaSimbolos;

import java.io.Reader;

public class AS11 extends AccionSemantica{
    @Override
    public void ejecutar(Token t, Reader entrada) { //CHEQUEA RANGO ENTEROS Y AGREGA A TS
        t.eliminarNoDigitos();
        t.setId(ENTERO);
    }
}
