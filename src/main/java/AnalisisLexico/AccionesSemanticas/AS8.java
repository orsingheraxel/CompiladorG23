package AnalisisLexico.AccionesSemanticas;

import AnalisisLexico.AnalizadorLexico;
import AnalisisLexico.TablaSimbolos;
import AnalisisLexico.Token;

import java.io.IOException;
import java.io.Reader;

public class AS8 extends AccionSemantica{
    @Override
    public void ejecutar(Token t, Reader entrada) {//CHEQUEA LONGITUD IDENTIFICADORES Y AGREGA A TS
        t.borrarUltimoCaracter();
        try {
            entrada.reset();
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (t.getLexema().length()>AccionSemantica.TAMANIO_VAR){
            String var = t.getLexema();
            t.truncarLexema(AccionSemantica.TAMANIO_VAR);
            AnalizadorLexico.addWarning("la variable "+var+" supera la longitud maxima: "+ AccionSemantica.TAMANIO_VAR);
        }
        Integer idPR = AnalizadorLexico.isPR(t.getLexema());
        //DEBEMOS CHEQUEAR SI ES PR, YA QUE NO HAY MANERA DE DIFERENCIAR ENTRE IDENTIFICADORES Y PR
        if(idPR != null){
            t.setId(idPR);
        }else{
            if (TablaSimbolos.existeSimbolo(t.getLexema())){
                TablaSimbolos.addAtributo(t.getLexema(), AccionSemantica.ID, AnalizadorLexico.getLineaAct());
            } else{
                TablaSimbolos.addNuevoSimbolo(t.getLexema());
                TablaSimbolos.addAtributo(t.getLexema(), AccionSemantica.ID, AnalizadorLexico.getLineaAct());
            }
            t.setId(ID);
        }

    }

    INT a;b;c, ListVariables = {a,b,c}
    VOID f(){
        INT a,
    }

}

