package b.GeneracionCodigoIntermedio;

import java.io.PrintWriter;

public class NodoControl extends Nodo{ //Tiene un solo hijo, el otro es null siempre

    private String salida;
    private String variable;
    private NodoHoja ultimoNodo;

    private String labelFin;

    public NodoControl(String lex, Nodo a) {
        super(lex);
        this.setDer(a);
        System.out.print("NodoControl " + this);
        System.out.println(" izq: " + izq + " der: " + der);
    }

    public NodoControl(String lex){
        super(lex);
        System.out.println("NodoControl " + lex);
    }

    public String getAssembler() {
        this.salida = "";
        switch (this.getLexema()) {
            case "LLAMADO FUNCION":
                if (this.getDer().getDer() != null) {
                    this.salida = this.salida + this.getDer().getDer().getAssembler();
                }
                this.variable = "@aux@" + this.getDer().getLexema();
                String varAux = getVariableAuxiliar();
                this.ultimoNodo = new NodoHoja(varAux);
                this.ultimoNodo.setUso("variableAuxiliar");
                this.salida = this.salida + "call " + this.getDer().getLexema() + "\n";
                return this.salida;
            case "PRINT":
                String variablePrint = getVariablePrint();
                data = variablePrint + " db \"" + this.getDer().getUltimoNodo().getLexema() + "\", 0 \n";
                this.salida = this.salida + "invoke MessageBox, NULL, addr " + variablePrint + ", addr printMensaje, MB_OK\n";
                return this.salida;
            case "TOD":
                this.salida = this.salida + this.getDer().getDer().getAssembler();
        }
        if (this.getDer() == null)
            return null;
        return this.getDer().getAssembler();
    }

    @Override
    public NodoHoja getUltimoNodo() {
        return this.ultimoNodo;
    }
    public void recorrerArbol(String s, PrintWriter m) {
        if (!(super.getDer() == null)) {
            m.println(s + "Nodo de control: " + super.getLexema() + "\n");
            s += "    ";
            super.getDer().recorrerArbol(s, m);
        }
    }

}
