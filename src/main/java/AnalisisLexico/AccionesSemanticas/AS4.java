package AnalisisLexico.AccionesSemanticas;

import AnalisisLexico.AnalizadorLexico;
import AnalisisLexico.TablaSimbolos.TablaSimbolos;
import AnalisisLexico.Token;

import java.io.IOException;
import java.io.Reader;

public class AS4 extends AccionSemantica{

    private static int longMinINT= - (int) Math.pow(2, 15);
    private static int longMaxINT= (int) Math.pow(2, 15) - 1;

    @Override
    public void ejecutar(Token t, Reader entrada) throws IOException {
        t.borrarUltimoCaracter();
        try {
            entrada.reset();
        } catch (IOException e) {
            e.printStackTrace();
        }
        long valor = Integer.valueOf(t.getLexema());
        System.out.println(valor);

        if (valor>longMinINT && valor<longMaxINT ){
            if (TablaSimbolos.existeSimbolo(t.getLexema())){
                TablaSimbolos.addAtributo(t.getLexema(),AccionSemantica.CTE, AnalizadorLexico.getLineaAct());
            } else{
                TablaSimbolos.addNuevoSimbolo(t.getLexema());
                TablaSimbolos.addAtributo(t.getLexema(), AccionSemantica.CTE
                        , AnalizadorLexico.getLineaAct());
            }
        }else {
            AnalizadorLexico.agregarErrorLexico("Constante entera fuera de rango");
        }
        t.setId(CTE);
    }
}
