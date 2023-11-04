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
            case "!!":
                t.setId(DIST);
                break;
            case "+=":
                t.setId(ASIG);
                break;
            case "<=":
                t.setId(MENORIGUAL);
                break;
            case ">=":
                t.setId(MAYORIGUAL);
                break;
            case "==":
                t.setId(IGUAL);
                break;
            default:
                int cod_ascii = (int) t.getLexema().charAt(0); // Obtenemos el código ASCII
                t.setId(cod_ascii);
        }
    }
    }

}