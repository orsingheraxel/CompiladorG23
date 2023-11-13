package AnalisisLexico.AccionesSemanticas;

import AnalisisLexico.AnalizadorLexico;
import AnalisisLexico.Token;

import java.io.IOException;
import java.io.Reader;

public class AS_Error_Digitos extends AccionSemantica{

    @Override
    public void ejecutar(Token t, Reader entrada) throws IOException {
        AnalizadorLexico.agregarErrorLexico("Variable númerica mal definida");
        t.eliminarNoDigitos();
        try {
            entrada.reset();
        } catch (IOException e) {
            e.printStackTrace();
        }
        t.setId(ENTERO); //Generamos un id para que siga compilando
    }
}
