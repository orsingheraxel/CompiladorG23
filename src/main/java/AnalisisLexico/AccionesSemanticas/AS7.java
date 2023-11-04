package AnalisisLexico.AccionesSemanticas;

import AnalisisLexico.AnalizadorLexico;
import AnalisisLexico.TablaSimbolos.TablaSimbolos;
import AnalisisLexico.Token;
import java.io.IOException;
import java.io.Reader;

public class AS7 extends AccionSemantica{
    private final Double longMinDOUBLE_positivo = 2.2250738585072014e-308;
    private final Double longMaxDOUBLE_positivo = 1.7976931348623157e+308;

    @Override
    public void ejecutar(Token t, Reader entrada) { //CHEQUEA RANGO DOUBLE Y AGREGA A TS
        t.borrarUltimoCaracter();
        try {
            entrada.reset();
        } catch (IOException e1) {
            e1.printStackTrace();
        }

        /*String n = t.getLexema().replace('D', 'e');
        Double numero = Double.parseDouble(n);

        if ((numero <= longMaxDOUBLE_positivo) && (numero >= longMinDOUBLE_positivo)) {
            if (TablaSimbolos.existeSimbolo(t.getLexema())) {
                TablaSimbolos.addAtributo(t.getLexema(), AccionSemantica.PUNTOFLOTANTE, AnalizadorLexico.getLineaAct());
            } else {
                TablaSimbolos.addNuevoSimbolo(t.getLexema());
                TablaSimbolos.addAtributo(t.getLexema(), AccionSemantica.PUNTOFLOTANTE, AnalizadorLexico.getLineaAct());
            }
        } else {
            AnalizadorLexico.agregarErrorLexico("Double positivo fuera de rango");
        }

         */
        t.setId(PUNTOFLOTANTE); }
}
