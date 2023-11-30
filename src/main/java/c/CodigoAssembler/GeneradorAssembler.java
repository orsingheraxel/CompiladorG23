package c.CodigoAssembler;

import a.AnalisisLexico.Parser;
import a.AnalisisLexico.TablaSimbolos;
import b.GeneracionCodigoIntermedio.Nodo;
import b.GeneracionCodigoIntermedio.NodoControl;
import java.util.Iterator;

public class GeneradorAssembler {
    private String data = "\n.data\nDivisionPorCero db \"No se puede dividir por cero.\", 0 \nOverflowProductoEnteros db \"Se produjo un overflow en el producto de enteros.\", 0 \nOverflowSumaDouble db \"Se produjo un un overflow en la suma de double.\", 0 \nerror db \"Error\", 0 \nprintMensaje db \"Print\", 0 \n";
    private String code = "";
    private String codigoArbol = "";
    private String bibliotecas = ".386 \n.model flat, stdcall \noption casemap :none  \ninclude \\masm32\\include\\windows.inc \ninclude \\masm32\\include\\kernel32.inc \ninclude \\masm32\\include\\masm32.inc  \nincludelib \\masm32\\lib\\kernel32.lib \nincludelib \\masm32\\lib\\masm32.lib\ninclude \\masm32\\include\\user32.inc \nincludelib \\masm32\\lib\\user32.lib \n";
    private String codigoFunciones = "invoke MessageBox, NULL, addr DivisionPorCero, addr error, MB_OK \ninvoke ExitProcess, 0 \ninvoke MessageBox, NULL, addr OverflowProductoEnteros, addr error, MB_OK \ninvoke ExitProcess, 0 \ninvoke MessageBox, NULL, addr OverflowSumaDouble, addr error, MB_OK \ninvoke ExitProcess, 0 \n";
    private Nodo arbol;

    public GeneradorAssembler(Parser parser) {
        this.arbol = parser.getRaiz();

        Nodo a;
        for(Iterator var3 = parser.getFuncion().iterator(); var3.hasNext(); this.codigoFunciones = this.codigoFunciones + a.getAssembler() + "\n") {
            a = (Nodo)var3.next();
        }

        this.codigoArbol = this.codigoArbol + this.arbol.getAssembler();
        this.generarCode();
        this.generarData();
    }

    private void generarData() {
        Iterator var2 = TablaSimbolos.getSimbolos().keySet().iterator();

        while(true) {
            String k;
            String uso;
            String tipo;
            String prefijo;
            do {
                do {
                    if (!var2.hasNext()) {
                        this.data = this.data + NodoControl.data;
                        return;
                    }

                    k = (String)var2.next();
                    uso = (String)TablaSimbolos.getAtributo(k, "Uso");
                    tipo = (String)TablaSimbolos.getAtributo(k, "Tipo");
                } while(uso == null);

                if (uso.equals("Constante")) {
                    prefijo = "_";
                    if (tipo.equals("USHORT")) {
                        this.data = this.data + prefijo + k + " dd " + k + "\n";
                    } else if (tipo.equals("INT")) {
                        this.data = this.data + prefijo + k + " dd " + k + "\n";
                    } else {
                        this.data = this.data + prefijo + k + " dd " + k + "\n";
                    }
                }
            } while(!uso.equals("Variable") && !uso.equals("variableAuxiliar"));

            prefijo = "";
            if (uso.equals("Variable")) {
                prefijo = "_";
            }

            if (tipo.equals("USHORT")) {
                this.data = this.data + prefijo + k + " dd " + "?" + "\n";
            } else if (tipo.equals("INT")) {
                this.data = this.data + prefijo + k + " dd " + "?" + "\n";
            } else {
                this.data = this.data + prefijo + k + " dd " + "?" + "\n";
            }
        }
    }

    private void generarCode() {
        this.code = "\n.code\n";
        this.code = this.code + this.codigoFunciones;
        this.code = this.code + "main:\n";
        this.code = this.code + this.codigoArbol;
        this.code = this.code + "invoke ExitProcess, 0 \n";
        this.code = this.code + "end main";
    }

    public String getAssembler() {
        return this.bibliotecas + this.data + this.code;
    }
}
