package b.GeneracionCodigoIntermedio;

public class NodoControl extends Nodo{ //Tiene un solo hijo, el otro es null siempre

    private String salida;
    private String variable;
    private NodoHoja ultimoNodo;

    public NodoControl(String lex, Nodo a) {
        super(lex);
        this.setDer(a);
        System.out.println("NodoControl " + t);
    }

    public NodoControl(String lex){
        super(lex);
        System.out.println("NodoControl " + lex);
    }

    public String getAssembler() {
        this.salida = "";
        switch (this.getLexema()) {
            case "INVOCACION":
                if (this.getIzq().getIzq() != null) {
                    this.salida = this.salida + this.getIzq().getIzq().getAssembler();
                }

                this.variable = "@aux@" + this.getIzq().getLexema();
                String varAux = getVariableAuxiliar();
                this.ultimoNodo = new NodoHoja(varAux);
                this.ultimoNodo.setUso("variableAuxiliar");
                this.salida = this.salida + "call " + this.getIzq().getLexema() + "\n";
                return this.salida;
            break;
            case "PRINT":
                String variablePrint = getVariablePrint();
                data = variablePrint + " db \"" + this.getIzq().getUltimoNodo().getLexema() + "\", 0 \n";
                this.salida = this.salida + "invoke MessageBox, NULL, addr " + variablePrint + ", addr printMensaje, MB_OK\n";
                return this.salida;
            case "intod":
                this.ultimoNodo = (NodoHoja)this.getIzq();
        }

        return this.getIzq().getAssembler();
    }

}
