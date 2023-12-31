package a.AnalisisLexico.AccionesSemanticas;

import a.AnalisisLexico.AnalizadorLexico;
import a.AnalisisLexico.TablaSimbolos;
import a.AnalisisLexico.Token;

import java.io.IOException;
import java.io.Reader;


public class AS6 extends AccionSemantica{

    @Override
    public void ejecutar(Token t, Reader entrada) throws IOException {
        if (t.getLexema().charAt(t.getLexema().length()-1) == '#') {
            if (TablaSimbolos.existeSimbolo(t.getLexema())) {
                TablaSimbolos.addAtributo(t.getLexema(), AccionSemantica.CADENA, AnalizadorLexico.getLineaAct());
            } else {
                TablaSimbolos.addNuevoSimbolo(t.getLexema());
                TablaSimbolos.addAtributo(t.getLexema(), AccionSemantica.CADENA, AnalizadorLexico.getLineaAct());
            }
        }
        else {
            t.borrarUltimoCaracter();
            AnalizadorLexico.agregarErrorLexico("Las cadenas deben finalizar con un #");
        }

        t.setId(CADENA);
    }
}
