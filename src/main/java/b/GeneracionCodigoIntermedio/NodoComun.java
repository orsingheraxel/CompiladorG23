package b.GeneracionCodigoIntermedio;
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

            case "Sentencia":
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
                salida+= getIzq().getLexema() + ":\n";
                salida+= getDer().getAssembler() + "ret";

                return salida;
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
                    salida += "JE errorDivisionPorCero\n";

                    salida += "MOV EAX, " + getIzq().getUltimoNodo().getLexema() + "\n";
                    salida += "IDIV " + getDer().getUltimoNodo().getLexema() + "\n";
                    salida += "MOV " + variable + ", EAX" + "\n";

                } else {
                    salida += "FLD " + getDer().getUltimoNodo().getLexema() + "\n";
                    salida += "FSUB " + getDer().getUltimoNodo().getLexema() + "\n";
                    salida += "FTST ";
                    salida += "JE errorDivisionPorCero\n";

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
                labelFin = getLabel();
                pilaLabels.push(labelFin);
                pilaLabels.push(label);

                salida += getIzq().getAssembler() + getDer().getAssembler();
                salida += "JMP "+ label + "\n";
                salida += labelFin + ":\n";
                break;
        }
        return salida;
    }

    public NodoHoja getUltimoNodo() {
        return this.ultimoNodo;
    }

}
