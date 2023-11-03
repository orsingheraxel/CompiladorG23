package AnalisisLexico.AccionesSemanticas;

import AnalisisLexico.*;
import AnalisisLexico.TablaSimbolos.TablaSimbolos;

import java.io.Reader;

public class AS11 extends AccionSemantica{
    private static int longMinINT= - (int) Math.pow(2, 15);
    private static int longMaxINT= (int) Math.pow(2, 15) - 1;
    @Override
    public void ejecutar(Token t, Reader entrada) { //CHEQUEA RANGO ENTEROS Y AGREGA A TS
        t.eliminarNoDigitos();
        long valor = Integer.parseInt(t.getLexema());

        if (valor>=longMinINT && valor<=longMaxINT ){
            if (TablaSimbolos.existeSimbolo(t.getLexema())){
                TablaSimbolos.addAtributo(t.getLexema(),AccionSemantica.ENTERO, AnalizadorLexico.getLineaAct());
            } else{
                TablaSimbolos.addNuevoSimbolo(t.getLexema());
                TablaSimbolos.addAtributo(t.getLexema(), AccionSemantica.ENTERO
                        , AnalizadorLexico.getLineaAct());
            }
        }else {
            AnalizadorLexico.agregarErrorLexico("Entero fuera de rango");
        }
        t.setId(ENTERO);
    }
}
