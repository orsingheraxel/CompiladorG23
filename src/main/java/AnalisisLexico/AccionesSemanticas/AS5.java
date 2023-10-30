package AnalisisLexico.AccionesSemanticas;

import AnalisisLexico.AnalizadorLexico;
import AnalisisLexico.TablaSimbolos.TablaSimbolos;
import AnalisisLexico.Token;

import java.io.IOException;
import java.io.Reader;

public class AS5 extends AccionSemantica{

    private final Double longMinDOUBLE = Math.pow(1.17549435, -38.0);
    private final Double longMaxDOUBLE = Math.pow(3.40282347, 38.0);
    @Override
    public void ejecutar(Token t, Reader entrada) {
        t.borrarUltimoCaracter();
        try {
            entrada.reset();
        } catch (IOException e1) {
            e1.printStackTrace();
        }
        Double d = Double.parseDouble(t.getLexema());
        if ((d < longMaxDOUBLE) || (d > longMinDOUBLE)) {
            if (TablaSimbolos.existeSimbolo(t.getLexema())){
                TablaSimbolos.addAtributo(t.getLexema(),AccionSemantica.PUNTOFLOTANTE, AnalizadorLexico.getLineaAct());
            } else{
                TablaSimbolos.addNuevoSimbolo(t.getLexema());
                TablaSimbolos.addAtributo(t.getLexema(),AccionSemantica.PUNTOFLOTANTE, AnalizadorLexico.getLineaAct());
            }

        }else{
            //Fuera de rango
            AnalizadorLexico.agregarErrorLexico("Double fuera de rango");
        }
        t.setId(PUNTOFLOTANTE);
    }
}
