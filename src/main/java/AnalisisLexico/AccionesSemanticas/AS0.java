package AnalisisLexico.AccionesSemanticas;

import AnalisisLexico.Token;

import java.io.Reader;

public class AS0 extends AccionSemantica{

    private final AS5 as5 = new AS5();
    public AS0(){

    }
    @Override
    public void ejecutar(Token t, Reader entrada) {
        switch (t.getLexema()) {
            case "!!" -> t.setId(DIST);
            case "+=" -> t.setId(ASIG);
            case "<=" -> t.setId(MENORIGUAL);
            case ">=" -> t.setId(MAYORIGUAL);
            case "==" -> t.setId(IGUAL);
            default -> {
                int cod_ascii = (int) t.getLexema().charAt(0); //Obtenemos el cod ASCII
                t.setId(cod_ascii);
            }
        }
    }

}