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
        switch (super.getLexema()) {
            case "SENTENCIA":
                if (this.getIzq() != null) {
                    salida = salida + this.getIzq().getAssembler();
                }

                if (this.getDer() != null) {
                    salida = salida + this.getDer().getAssembler();
                }
                break;
            case "Cuerpo_IF":
                this.labelFin = getLabel();
                String labelElse = getLabel();
                pilaLabels.push(labelElse);
                salida = salida + this.getIzq().getAssembler();
                salida = salida + "JMP " + this.labelFin + "\n";
                salida = salida + labelElse + ":\n";
                salida = salida + this.getDer().getAssembler() + this.labelFin + ":\n";
                break;
            case "*":
                salida = salida + this.getDer().getAssembler() + this.getIzq().getAssembler();
                this.variable = getVariableAuxiliar();
                this.ultimoNodo = new NodoHoja(this.variable);
                this.ultimoNodo.setTipo(this.getIzq().getTipo());
                this.ultimoNodo.setUso("variableAuxiliar");
                if (!this.getIzq().getTipo().equals("USHORT") && !this.getIzq().getTipo().equals("LONG")) {
                    salida = salida + "FLD " + this.getIzq().getUltimoNodo().getLexema() + "\n";
                    salida = salida + "FMUL " + this.getDer().getUltimoNodo().getLexema() + "\n";
                    salida = salida + "FST " + this.variable + "\n";
                } else {
                    salida = salida + "MOV EAX, " + this.getIzq().getUltimoNodo().getLexema() + "\n";
                    salida = salida + "IMUL EAX, " + this.getDer().getUltimoNodo().getLexema() + "\n";
                    salida = salida + "JO errorProductoEnteros\n";
                    salida = salida + "MOV " + this.variable + ", EAX" + "\n";
                }
                break;
            case "+":
                salida = salida + this.getDer().getAssembler() + this.getIzq().getAssembler();
                this.variable = getVariableAuxiliar();
                this.ultimoNodo = new NodoHoja(this.variable);
                this.ultimoNodo.setTipo(this.getIzq().getTipo());
                this.ultimoNodo.setUso("variableAuxiliar");
                if (!this.getIzq().getTipo().equals("USHORT") && !this.getIzq().getTipo().equals("LONG")) {
                    salida = salida + "FLD " + this.getIzq().getUltimoNodo().getLexema() + "\n";
                    salida = salida + "FADD " + this.getDer().getUltimoNodo().getLexema() + "\n";
                    salida = salida + "JO errorSumaDouble\n";
                    salida = salida + "FST " + this.variable + "\n";
                } else {
                    salida = salida + "MOV EAX, " + this.getIzq().getUltimoNodo().getLexema() + "\n";
                    salida = salida + "ADD EAX, " + this.getDer().getUltimoNodo().getLexema() + "\n";
                    salida = salida + "MOV " + this.variable + ", EAX" + "\n";
                }
                break;
            case "-":
                salida = salida + this.getDer().getAssembler() + this.getIzq().getAssembler();
                this.variable = getVariableAuxiliar();
                this.ultimoNodo = new NodoHoja(this.variable);
                this.ultimoNodo.setTipo(this.getIzq().getTipo());
                this.ultimoNodo.setUso("variableAuxiliar");
                if (!this.getIzq().getTipo().equals("USHORT") && !this.getIzq().getTipo().equals("LONG")) {
                    salida = salida + "FLD " + this.getIzq().getUltimoNodo().getLexema() + "\n";
                    salida = salida + "FSUB " + this.getDer().getUltimoNodo().getLexema() + "\n";
                    salida = salida + "FST " + this.variable + "\n";
                } else {
                    salida = salida + "MOV EAX, " + this.getIzq().getUltimoNodo().getLexema() + "\n";
                    salida = salida + "SUB EAX, " + this.getDer().getUltimoNodo().getLexema() + "\n";
                    salida = salida + "MOV " + this.variable + ", EAX" + "\n";
                }
                break;
            case "/":
                salida = salida + this.getDer().getAssembler() + this.getIzq().getAssembler();
                this.variable = getVariableAuxiliar();
                this.ultimoNodo = new NodoHoja(this.variable);
                this.ultimoNodo.setTipo(this.getIzq().getTipo());
                this.ultimoNodo.setUso("variableAuxiliar");
                if (!this.getIzq().getTipo().equals("USHORT") && !this.getIzq().getTipo().equals("LONG")) {
                    salida = salida + "FLD " + this.getDer().getUltimoNodo().getLexema() + "\n";
                    salida = salida + "FSUB " + this.getDer().getUltimoNodo().getLexema() + "\n";
                    salida = salida + "FTST ";
                    salida = salida + "JE errorDivisionPorCero\n";
                    salida = salida + "FLD " + this.getIzq().getUltimoNodo().getLexema() + "\n";
                    salida = salida + "FDIV " + this.getDer().getUltimoNodo().getLexema() + "\n";
                    salida = salida + "FST " + this.variable + "\n";
                } else {
                    salida = salida + "CMP " + this.getDer().getUltimoNodo().getLexema() + ", 0\n";
                    salida = salida + "JE errorDivisionPorCero\n";
                    salida = salida + "MOV EAX, " + this.getIzq().getUltimoNodo().getLexema() + "\n";
                    salida = salida + "IDIV " + this.getDer().getUltimoNodo().getLexema() + "\n";
                    salida = salida + "MOV " + this.variable + ", EAX" + "\n";
                }
                break;
            case "<":
                salida = salida + this.getDer().getAssembler() + this.getIzq().getAssembler();
                this.variable = getVariableAuxiliar();
                this.label = (String)pilaLabels.pop();
                this.ultimoNodo = new NodoHoja(this.variable);
                this.ultimoNodo.setTipo(this.getIzq().getTipo());
                this.ultimoNodo.setUso("variableAuxiliar");
                if (!this.getIzq().getTipo().equals("USHORT") && !this.getIzq().getTipo().equals("LONG")) {
                    salida = salida + "FLD " + this.getIzq().getUltimoNodo().getLexema() + "\n";
                    salida = salida + "FCOM " + this.getDer().getUltimoNodo().getLexema() + "\n";
                    salida = salida + "JGE " + this.label + "\n";
                } else {
                    salida = salida + "MOV EAX, " + this.getIzq().getUltimoNodo().getLexema() + "\n";
                    salida = salida + "CMP EAX, " + this.getDer().getUltimoNodo().getLexema() + "\n";
                    salida = salida + "JGE " + this.label + "\n";
                }
                break;
            case "=":
                salida = salida + this.getDer().getAssembler() + this.getIzq().getAssembler();
                if (!this.getIzq().getTipo().equals("USHORT") && !this.getIzq().getTipo().equals("LONG")) {
                    salida = salida + "FLD " + this.getDer().getUltimoNodo().getLexema() + "\n";
                    salida = salida + "FST " + this.getIzq().getUltimoNodo().getLexema() + "\n";
                } else {
                    salida = salida + "MOV EAX , " + this.getDer().getUltimoNodo().getLexema() + "\n";
                    salida = salida + "MOV " + this.getIzq().getUltimoNodo().getLexema() + ", " + "EAX" + "\n";
                }
                break;
            case ">":
                salida = salida + this.getDer().getAssembler() + this.getIzq().getAssembler();
                this.variable = getVariableAuxiliar();
                this.label = (String)pilaLabels.pop();
                this.ultimoNodo = new NodoHoja(this.variable);
                this.ultimoNodo.setTipo(this.getIzq().getTipo());
                this.ultimoNodo.setUso("variableAuxiliar");
                if (!this.getIzq().getTipo().equals("USHORT") && !this.getIzq().getTipo().equals("LONG")) {
                    salida = salida + "FLD " + this.getIzq().getUltimoNodo().getLexema() + "\n";
                    salida = salida + "FCOM " + this.getDer().getUltimoNodo().getLexema() + "\n";
                    salida = salida + "JLE " + this.label + "\n";
                } else {
                    salida = salida + "MOV EAX, " + this.getIzq().getUltimoNodo().getLexema() + "\n";
                    salida = salida + "CMP EAX, " + this.getDer().getUltimoNodo().getLexema() + "\n";
                    salida = salida + "JLE " + this.label + "\n";
                }
                break;
            case "!!":
                salida = salida + this.getDer().getAssembler() + this.getIzq().getAssembler();
                this.variable = getVariableAuxiliar();
                this.label = (String)pilaLabels.pop();
                this.ultimoNodo = new NodoHoja(this.variable);
                this.ultimoNodo.setTipo(this.getIzq().getTipo());
                this.ultimoNodo.setUso("variableAuxiliar");
                if (!this.getIzq().getTipo().equals("USHORT") && !this.getIzq().getTipo().equals("LONG")) {
                    salida = salida + "FLD " + this.getIzq().getUltimoNodo().getLexema() + "\n";
                    salida = salida + "FCOM " + this.getDer().getUltimoNodo().getLexema() + "\n";
                    salida = salida + "JE " + this.label + "\n";
                } else {
                    salida = salida + "MOV EAX, " + this.getIzq().getUltimoNodo().getLexema() + "\n";
                    salida = salida + "CMP EAX, " + this.getDer().getUltimoNodo().getLexema() + "\n";
                    salida = salida + "JE " + this.label + "\n";
                }
                break;
            case "+=":
                salida = salida + this.getDer().getAssembler() + this.getIzq().getAssembler();
                if (!this.getIzq().getTipo().equals("USHORT") && !this.getIzq().getTipo().equals("LONG")) {
                    salida = salida + "FLD " + this.getDer().getUltimoNodo().getLexema() + "\n";
                    salida = salida + "FADD " + this.getDer().getUltimoNodo().getLexema() + "\n";
                    salida = salida + "FST " + this.getIzq().getUltimoNodo().getLexema() + "\n";
                } else {
                    salida = salida + "MOV EAX, " + this.getIzq().getUltimoNodo().getLexema() + "\n";
                    salida = salida + "ADD EAX, " + this.getDer().getUltimoNodo().getLexema() + "\n";
                    salida = salida + "MOV " + this.getIzq().getUltimoNodo().getLexema() + ", " + "EAX" + "\n";
                }
                break;
            case "<=":
                salida = salida + this.getDer().getAssembler() + this.getIzq().getAssembler();
                this.variable = getVariableAuxiliar();
                this.label = (String)pilaLabels.pop();
                this.ultimoNodo = new NodoHoja(this.variable);
                this.ultimoNodo.setTipo(this.getIzq().getTipo());
                this.ultimoNodo.setUso("variableAuxiliar");
                if (!this.getIzq().getTipo().equals("USHORT") && !this.getIzq().getTipo().equals("LONG")) {
                    salida = salida + "FLD " + this.getIzq().getUltimoNodo().getLexema() + "\n";
                    salida = salida + "FCOM " + this.getDer().getUltimoNodo().getLexema() + "\n";
                    salida = salida + "JG " + this.label + "\n";
                } else {
                    salida = salida + "MOV EAX, " + this.getIzq().getUltimoNodo().getLexema() + "\n";
                    salida = salida + "CMP EAX, " + this.getDer().getUltimoNodo().getLexema() + "\n";
                    salida = salida + "JG " + this.label + "\n";
                }
                break;
            case "==":
                salida = salida + this.getDer().getAssembler() + this.getIzq().getAssembler();
                this.variable = getVariableAuxiliar();
                this.label = (String)pilaLabels.pop();
                this.ultimoNodo = new NodoHoja(this.variable);
                this.ultimoNodo.setTipo(this.getIzq().getTipo());
                this.ultimoNodo.setUso("variableAuxiliar");
                if (!this.getIzq().getTipo().equals("USHORT") && !this.getIzq().getTipo().equals("LONG")) {
                    salida = salida + "FLD " + this.getIzq().getUltimoNodo().getLexema() + "\n";
                    salida = salida + "FCOM " + this.getDer().getUltimoNodo().getLexema() + "\n";
                    salida = salida + "JNE " + this.label + "\n";
                } else {
                    salida = salida + "MOV EAX, " + this.getIzq().getUltimoNodo().getLexema() + "\n";
                    salida = salida + "CMP EAX, " + this.getDer().getUltimoNodo().getLexema() + "\n";
                    salida = salida + "JNE " + this.label + "\n";
                }
                break;
            case ">=":
                salida = salida + this.getDer().getAssembler() + this.getIzq().getAssembler();
                this.variable = getVariableAuxiliar();
                this.label = (String)pilaLabels.pop();
                this.ultimoNodo = new NodoHoja(this.variable);
                this.ultimoNodo.setTipo(this.getIzq().getTipo());
                this.ultimoNodo.setUso("variableAuxiliar");
                if (!this.getIzq().getTipo().equals("USHORT") && !this.getIzq().getTipo().equals("LONG")) {
                    salida = salida + "FLD " + this.getIzq().getUltimoNodo().getLexema() + "\n";
                    salida = salida + "FCOM " + this.getDer().getUltimoNodo().getLexema() + "\n";
                    salida = salida + "JL " + this.label + "\n";
                } else {
                    salida = salida + "MOV EAX, " + this.getIzq().getUltimoNodo().getLexema() + "\n";
                    salida = salida + "CMP EAX, " + this.getDer().getUltimoNodo().getLexema() + "\n";
                    salida = salida + "JL " + this.label + "\n";
                }
                break;
            case "IF":
                this.salidaDer = this.getDer().getAssembler();
                if (!this.getDer().getLexema().equals("Cuerpo_IF")) {
                    this.label = getLabel();
                    pilaLabels.push(this.label);
                    salida = salida + this.getIzq().getAssembler() + this.salidaDer + this.label + ":\n";
                } else {
                    salida = salida + this.getIzq().getAssembler() + this.salidaDer;
                }
                break;
            case "FOR":
                this.label = getLabel();
                this.labelFin = getLabel();
                pilaLabels.push(this.labelFin);
                pilaLabels.push(this.label);
                salida = salida + this.getIzq().getAssembler() + this.getDer().getAssembler();
                salida = salida + "JMP " + this.label + "\n";
                salida = salida + this.labelFin + ":\n";
                break;
            case "AUXFOR1":
                this.label = (String)pilaLabels.pop();
                salida = salida + this.getIzq().getAssembler();
                salida = salida + this.label + ":\n";
                salida = salida + this.getDer().getAssembler();
                break;
            case "AUXFOR2":
                salida = salida + this.getIzq().getAssembler() + this.getDer().getAssembler();
                break;
            case "Funcion":
                salida = salida + this.getIzq().getLexema() + ":\n";
                salida = salida + this.getDer().getAssembler() + "ret";
                return salida;
            case "BLOQUE SENTENCIAS":
                if (this.getIzq() != null) {
                    salida = salida + this.getIzq().getAssembler();
                }

                if (this.getDer() != null) {
                    salida = salida + this.getDer().getAssembler();
                }
        }

        return salida;
    }

    public NodoHoja getUltimoNodo() {
        return this.ultimoNodo;
    }

}
