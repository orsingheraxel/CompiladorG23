package AnalisisLexico.AccionesSemanticas;

import AnalisisLexico.AnalizadorLexico;
import AnalisisLexico.TablaSimbolos.TablaSimbolos;
import AnalisisLexico.Token;

import java.io.Reader;

public class AS10 extends AccionSemantica {//CHEQUEA RANGO USHORT Y AGREGA A TS
    private static int longMinUSHORT = 0;
    private static int longMaxUSHORT = 256;
    @Override
    public void ejecutar(Token t, Reader entrada) {
        t.eliminarNoDigitos(); //Eliminamos _us del lexema, y nos quedamos con la parte entera para chequear rango
        long valor = Integer.valueOf(t.getLexema());

        if (valor>=longMinUSHORT && valor<longMaxUSHORT ){
            if (TablaSimbolos.existeSimbolo(t.getLexema())){
                TablaSimbolos.addAtributo(t.getLexema(), AccionSemantica.ENTEROCORTO, AnalizadorLexico.getLineaAct());
            } else{
                TablaSimbolos.addNuevoSimbolo(t.getLexema());
                TablaSimbolos.addAtributo(t.getLexema(), AccionSemantica.ENTEROCORTO, AnalizadorLexico.getLineaAct());
            }
        } else {
            AnalizadorLexico.agregarErrorLexico("Entero corto fuera de rango");

        }
        t.setId(ENTEROCORTO);
    }

}
