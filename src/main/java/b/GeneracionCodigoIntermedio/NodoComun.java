package b.GeneracionCodigoIntermedio;
import a.AnalisisLexico.*;

import java.io.PrintWriter;

public class NodoComun extends Nodo{

    private NodoHoja ultimoNodo = null;
    private String variable;
    private String label;
    private String labelFin;
    private String salidaDer;
    public NodoComun(String lex) {
        super(lex);
        System.out.println("NodoComun " + lex);
    }

    public NodoComun(String lex,Nodo izq,Nodo der){
        super(lex,izq,der);
        System.out.print("NodoComun " + this);
        System.out.println(" izq: " + izq + " der: " + der);
    }

    public String getAssembler() {
        String salida = "";
        switch(super.getLexema()){

            case "SENTENCIA":
                if (getIzq()!= null)
                    salida+= getIzq().getAssembler();
                if (getDer()!= null)
                    salida+= getDer().getAssembler();
                break;
            case "+=":
                salida += getDer().getAssembler() + getIzq().getAssembler();
                if(getIzq().getTipo().equals("USHORT")||getIzq().getTipo().equals("INT")){
                    salida += "MOV EAX, " + getIzq().getUltimoNodo().getLexema() + "\n";
                    salida += "ADD EAX, " + getDer().getUltimoNodo().getLexema() + "\n";
                    salida+= "MOV " + getIzq().getUltimoNodo().getLexema() + ", " + "EAX" + "\n";
                }else {
                    salida += "FLD " + getDer().getUltimoNodo().getLexema() + "\n";
                    salida += "FADD " + getDer().getUltimoNodo().getLexema() + "\n";
                    salida += "FST " + getIzq().getUltimoNodo().getLexema() + "\n";
                }
                break;

            case "=":
                salida += getDer().getAssembler() + getIzq().getAssembler();
                if(getIzq().getTipo().equals("USHORT")||getIzq().getTipo().equals("INT")){
                    salida+= "MOV EAX , " + getDer().getUltimoNodo().getLexema() + "\n";
                    salida+= "MOV " + getIzq().getUltimoNodo().getLexema() + ", " + "EAX" + "\n";
                }else {
                    salida += "FLD " + getDer().getUltimoNodo().getLexema() + "\n";
                    salida += "FST " + getIzq().getUltimoNodo().getLexema() + "\n";
                }
                break;
            case "Funcion":
                salida+= getIzq().getLexema() + ":\n"; //getLexema() pq la izquierda es el ID de la funcion.
                salida+= getDer().getAssembler() + "ret";
                if (Parser.getFuncionAutoInvocada())
                    salida += " JMP errorInvocacionFuncion\n";
                break;
            case "+":
                salida += getDer().getAssembler() + getIzq().getAssembler();
                variable = getVariableAuxiliar();

                this.ultimoNodo = new NodoHoja(variable);
                this.ultimoNodo.setTipo(this.getIzq().getTipo());
                this.ultimoNodo.setUso("variableAuxiliar");

                if(getIzq().getTipo().equals("USHORT")||getIzq().getTipo().equals("INT")) {
                    salida += "MOV EAX, " + getIzq().getUltimoNodo().getLexema() + "\n";
                    salida += "ADD EAX, " + getDer().getUltimoNodo().getLexema() + "\n";
                    salida += "JO errorSumaEnteros\n";
                    salida += "MOV " + variable + ", EAX" + "\n";
                }
                else
                {
                    salida += "FLD " + getIzq().getUltimoNodo().getLexema() + "\n";
                    salida += "FADD " + getDer().getUltimoNodo().getLexema() + "\n";

                    salida += "FST "+ variable + "\n";
                }
                break;


            case "-":
                salida += getDer().getAssembler() + getIzq().getAssembler();
                variable = getVariableAuxiliar();

                this.ultimoNodo = new NodoHoja(variable);
                this.ultimoNodo.setTipo(this.getIzq().getTipo());
                this.ultimoNodo.setUso("variableAuxiliar");

                if (getIzq().getTipo().equals("USHORT")||getIzq().getTipo().equals("INT")) {
                    salida += "MOV EAX, " + getIzq().getUltimoNodo().getLexema() + "\n";
                    salida += "SUB EAX, " + getDer().getUltimoNodo().getLexema() + "\n";

                    salida += "MOV " + variable + ", EAX" + "\n";

                } else
                {
                    salida += "FLD " + getIzq().getUltimoNodo().getLexema() + "\n";
                    salida += "FSUB " + getDer().getUltimoNodo().getLexema() + "\n";

                    salida += "FST " + variable + "\n";
                }
                break;

            case "*":
                salida += getDer().getAssembler() + getIzq().getAssembler();
                variable = getVariableAuxiliar();

                this.ultimoNodo = new NodoHoja(variable);
                this.ultimoNodo.setTipo(this.getIzq().getTipo());
                this.ultimoNodo.setUso("variableAuxiliar");

                if (getIzq().getTipo().equals("USHORT")||getIzq().getTipo().equals("INT")) {
                    salida += "MOV EAX, " + getIzq().getUltimoNodo().getLexema() + "\n";
                    salida += "IMUL EAX, " + getDer().getUltimoNodo().getLexema() + "\n";

                    salida += "MOV " + variable + ", EAX" + "\n";

                } else {
                    salida += "FLD " + getIzq().getUltimoNodo().getLexema() + "\n";
                    salida += "FMUL " + getDer().getUltimoNodo().getLexema() + "\n";
                    salida += "JO errorProductoDouble\n";
                    salida += "FST " + variable + "\n";
                }
                break;


            case "/":
                salida += getDer().getAssembler() + getIzq().getAssembler();
                variable = getVariableAuxiliar();

                this.ultimoNodo = new NodoHoja(variable);
                this.ultimoNodo.setTipo(this.getIzq().getTipo());
                this.ultimoNodo.setUso("variableAuxiliar");

                if (getIzq().getTipo().equals("USHORT")||getIzq().getTipo().equals("INT")) {
                    salida += "CMP " + getDer().getUltimoNodo().getLexema() + ", 0\n";

                    salida += "MOV EAX, " + getIzq().getUltimoNodo().getLexema() + "\n";
                    salida += "IDIV " + getDer().getUltimoNodo().getLexema() + "\n";
                    salida += "MOV " + variable + ", EAX" + "\n";

                } else {
                    salida += "FLD " + getDer().getUltimoNodo().getLexema() + "\n";
                    salida += "FSUB " + getDer().getUltimoNodo().getLexema() + "\n";
                    salida += "FTST ";

                    salida += "FLD " + getIzq().getUltimoNodo().getLexema() + "\n";
                    salida += "FDIV " + getDer().getUltimoNodo().getLexema() + "\n";
                    salida += "FST " + variable + "\n";
                }
                break;


            case "==":
                salida += getDer().getAssembler() + getIzq().getAssembler();
                variable = getVariableAuxiliar();
                label = pilaLabels.pop();

                this.ultimoNodo = new NodoHoja(variable);
                this.ultimoNodo.setTipo(this.getIzq().getTipo());
                this.ultimoNodo.setUso("variableAuxiliar");

                if (getIzq().getTipo().equals("USHORT")||getIzq().getTipo().equals("INT")) {
                    salida += "MOV EAX, " + getIzq().getUltimoNodo().getLexema() + "\n";
                    salida += "CMP EAX, " + getDer().getUltimoNodo().getLexema() + "\n";
                    salida += "JNE " + label + "\n";
                } else {
                    salida += "FLD " + getIzq().getUltimoNodo().getLexema() + "\n";
                    salida += "FCOM " + getDer().getUltimoNodo().getLexema() + "\n";
                    salida += "JNE " + label + "\n";
                }
                break;

            case "!!":
                salida += getDer().getAssembler() + getIzq().getAssembler();
                variable = getVariableAuxiliar();
                label = pilaLabels.pop();

                this.ultimoNodo = new NodoHoja(variable);
                this.ultimoNodo.setTipo(this.getIzq().getTipo());
                this.ultimoNodo.setUso("variableAuxiliar");

                if (getIzq().getTipo().equals("USHORT")||getIzq().getTipo().equals("INT")) {
                    salida += "MOV EAX, " + getIzq().getUltimoNodo().getLexema() + "\n";
                    salida += "CMP EAX, " + getDer().getUltimoNodo().getLexema() + "\n";
                    salida += "JE " + label + "\n";
                } else {
                    salida += "FLD " + getIzq().getUltimoNodo().getLexema() + "\n";
                    salida += "FCOM " + getDer().getUltimoNodo().getLexema() + "\n";
                    salida += "JE " + label + "\n";
                }
                break;

            case ">":
                salida += getDer().getAssembler() + getIzq().getAssembler();
                variable = getVariableAuxiliar();
                label = pilaLabels.pop();

                this.ultimoNodo = new NodoHoja(variable);
                this.ultimoNodo.setTipo(this.getIzq().getTipo());
                this.ultimoNodo.setUso("variableAuxiliar");

                if (getIzq().getTipo().equals("USHORT")||getIzq().getTipo().equals("INT")) {
                    salida += "MOV EAX, " + getIzq().getUltimoNodo().getLexema() + "\n";
                    salida += "CMP EAX, " + getDer().getUltimoNodo().getLexema() + "\n";
                    salida += "JLE " + label + "\n";
                } else {
                    salida += "FLD " + getIzq().getUltimoNodo().getLexema() + "\n";
                    salida += "FCOM " + getDer().getUltimoNodo().getLexema() + "\n";
                    salida += "JLE " + label + "\n";
                }
                break;

            case ">=":
                salida += getDer().getAssembler() + getIzq().getAssembler();
                variable = getVariableAuxiliar();
                label = pilaLabels.pop();

                this.ultimoNodo = new NodoHoja(variable);
                this.ultimoNodo.setTipo(this.getIzq().getTipo());
                this.ultimoNodo.setUso("variableAuxiliar");

                if (getIzq().getTipo().equals("USHORT")||getIzq().getTipo().equals("INT")) {
                    salida += "MOV EAX, " + getIzq().getUltimoNodo().getLexema() + "\n";
                    salida += "CMP EAX, " + getDer().getUltimoNodo().getLexema() + "\n";
                    salida += "JL " + label + "\n";
                } else {
                    salida += "FLD " + getIzq().getUltimoNodo().getLexema() + "\n";
                    salida += "FCOM " + getDer().getUltimoNodo().getLexema() + "\n";
                    salida += "JL " + label + "\n";
                }
                break;

            case "<":
                salida += getDer().getAssembler() + getIzq().getAssembler();
                variable = getVariableAuxiliar();
                label = pilaLabels.pop();

                this.ultimoNodo = new NodoHoja(variable);
                this.ultimoNodo.setTipo(this.getIzq().getTipo());
                this.ultimoNodo.setUso("variableAuxiliar");

                if (getIzq().getTipo().equals("USHORT")||getIzq().getTipo().equals("INT")) {
                    salida += "MOV EAX, " + getIzq().getUltimoNodo().getLexema() + "\n";
                    salida += "CMP EAX, " + getDer().getUltimoNodo().getLexema() + "\n";
                    salida += "JGE " + label + "\n";
                } else {
                    salida += "FLD " + getIzq().getUltimoNodo().getLexema() + "\n";
                    salida += "FCOM " + getDer().getUltimoNodo().getLexema() + "\n";
                    salida += "JGE " + label + "\n";
                }
                break;

            case "<=":
                salida += getDer().getAssembler() + getIzq().getAssembler();
                variable = getVariableAuxiliar();
                label = pilaLabels.pop();

                this.ultimoNodo = new NodoHoja(variable);
                this.ultimoNodo.setTipo(this.getIzq().getTipo());
                this.ultimoNodo.setUso("variableAuxiliar");

                if (getIzq().getTipo().equals("USHORT")||getIzq().getTipo().equals("INT")) {
                    salida += "MOV EAX, " + getIzq().getUltimoNodo().getLexema() + "\n";
                    salida += "CMP EAX, " + getDer().getUltimoNodo().getLexema() + "\n";
                    salida += "JG " + label + "\n";
                } else {
                    salida += "FLD " + getIzq().getUltimoNodo().getLexema() + "\n";
                    salida += "FCOM " + getDer().getUltimoNodo().getLexema() + "\n";
                    salida += "JG " + label + "\n";
                }
                break;

            case "IF":
                salidaDer =  getDer().getAssembler();
                if(!(getDer().getLexema().equals("CUERPO"))){
                    label = getLabel();
                    pilaLabels.push(label);
                    salida+=getIzq().getAssembler() + salidaDer + label+":\n";
                    break;
                }

                salida+= getIzq().getAssembler() + salidaDer;

                break;

            case "CUERPO":
                labelFin = getLabel();
                String labelElse = getLabel();
                pilaLabels.push(labelElse);

                salida+= getIzq().getAssembler();
                salida+= "JMP " + labelFin + "\n";

                salida += labelElse + ":\n";
                salida+= getDer().getAssembler()+ labelFin+":\n";

                break;
            case "DO UNTIL":
                label = getLabel();
                pilaLabels.push(label);

                salida += "JMP "+ label + "\n";
                salida += label + ":\n";
                salida += getIzq().getAssembler() + getDer().getAssembler();
                break;
            case "REFERENCIA FUNCION OBJETO":
                salida+= getIzq().getLexema(); //getLexema() pq la izquierda es el ID del objeto.
                salida+= getDer().getAssembler();
                break;
        }
        return salida;
    }

    public NodoHoja getUltimoNodo() {
        return this.ultimoNodo;
    }

    public void recorrerArbol(String s, PrintWriter m) {
        m.println(s+"Lexama Nodo: " + super.getLexema() + "\n");

        if (!(super.getIzq() == null)){
            m.println(s+"Hijo Izquierdo: " + "\n");
            super.getIzq().recorrerArbol(s+"    ", m);
        }

        if (!(super.getDer() == null)){
            m.println(s+"Hijo Derecho: "+ "\n");
            super.getDer().recorrerArbol(s+"    ",m);
        }

    }

}
