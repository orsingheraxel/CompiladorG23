package AnalisisLexico.AccionesSemanticas;

import AnalisisLexico.AnalizadorLexico;
import AnalisisLexico.TablaSimbolos.TablaSimbolos;
import AnalisisLexico.Token;
import java.io.IOException;
import java.io.Reader;

public class AS7 extends AccionSemantica{
    private final Double longMinDOUBLE = Math.pow(1.17549435, -38.0);
    private final Double longMaxDOUBLE = Math.pow(3.40282347, 38.0);

    @Override
    public void ejecutar(Token t, Reader entrada) { //CHEQUEA RANGO DOUBLE Y AGREGA A TS
        t.borrarUltimoCaracter();
        try {
            entrada.reset();
        } catch (IOException e1) {
            e1.printStackTrace();
        }
        String lexema = t.getLexema();
        int i =0;
        char caracter=' ';
        String digito=""; //parte numerica
        String exponente=""; //parte exponencial
        while (!((caracter == 'D') || (caracter == 'd'))) {
            caracter = lexema.charAt(i);
            digito+= caracter;
            i++;
        }
        Double d = Double.parseDouble(digito); //d va a tener la parte numerica
        for (int j=i ; j < (lexema.length()); j++) {
            caracter = lexema.charAt(j);
            exponente += caracter;
        }
        Double e = Double.parseDouble(exponente);
        Double numero = Math.pow(d, e); //numero del lexema convertido a double
        if ((numero < longMaxDOUBLE) || (numero > longMinDOUBLE)) {
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
