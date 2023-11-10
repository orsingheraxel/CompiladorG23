package AnalisisLexico.AccionesSemanticas;

import AnalisisLexico.Token;

import java.io.Reader;

public class AS10 extends AccionSemantica {//CHEQUEA RANGO USHORT Y AGREGA A TS
    @Override
    public void ejecutar(Token t, Reader entrada) {
        t.eliminarNoDigitos(); //Eliminamos _us del lexema, y nos quedamos con la parte entera para chequear rango
        t.setId(ENTEROCORTO);
        t.setTipo("USHORT");
    }

}
