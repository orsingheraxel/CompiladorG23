package a.AnalisisLexico.AccionesSemanticas;

import a.AnalisisLexico.AnalizadorLexico;
import a.AnalisisLexico.Token;

import java.io.Reader;

public class AS_Error_Identificadores extends AccionSemantica {
    @Override
    public void ejecutar(Token t, Reader entrada) {
        AnalizadorLexico.agregarErrorLexico("Los identificadores solo pueden contener digitos, letras minúsculas o '_' ");
    }

}
