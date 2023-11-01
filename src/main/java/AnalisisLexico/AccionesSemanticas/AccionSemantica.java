package AnalisisLexico.AccionesSemanticas;

import AnalisisLexico.Token;

import java.io.IOException;
import java.io.Reader;

public abstract class AccionSemantica {
    //PONER TOKENS
    public final static short ID=269;
    public final static short IGUAL=270;
    public final static short DIST=271;
    public final static short MENORIGUAL=272;
    public final static short MAYORIGUAL=273;
    public final static short ASIG=274;
    public final static short CADENA=277;
    public final static short ENTERO=278;
    public final static short ENTEROCORTO=279;
    public final static short PUNTOFLOTANTE=280;
    protected static final int TAMANIO_VAR=20;


    public abstract void ejecutar(Token t, Reader entrada) throws IOException;
}
