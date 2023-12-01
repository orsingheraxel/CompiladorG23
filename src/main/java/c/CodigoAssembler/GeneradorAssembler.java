package c.CodigoAssembler;

import a.AnalisisLexico.Parser;
import a.AnalisisLexico.TablaSimbolos;
import b.GeneracionCodigoIntermedio.Nodo;
import b.GeneracionCodigoIntermedio.NodoControl;
import java.util.Iterator;

public class GeneradorAssembler {
    private String data, code, codigoArbol, bibliotecas, codigoFunciones;
    private Nodo arbol;


    public GeneradorAssembler(Parser parser){
        this.bibliotecas = ".386 \n.model flat, stdcall \noption casemap :none  \n"
                +"include \\masm32\\include\\windows.inc \n"
                +"include \\masm32\\include\\kernel32.inc \n"
                +"include \\masm32\\include\\masm32.inc  \n"
                +"includelib \\masm32\\lib\\kernel32.lib \n"
                +"includelib \\masm32\\lib\\masm32.lib\n"
                +"include \\masm32\\include\\user32.inc \n"
                +"includelib \\masm32\\lib\\user32.lib \n";
        this.data= "\n.data\n"
                + "AutoinvocacionFunciones db \"Una funcion no puede llamarse a si misma.\", 0 \n"
                + "OverflowSumaEnteros db \"Se produjo un overflow en la suma de enteros.\", 0 \n"
                + "OverflowProductoDouble db \"Se produjo un un overflow en el producto de doubles.\", 0 \n"
                + "error db \"Error\", 0 \n"
                + "printMensaje db \"Print\", 0 \n";

        this.code="";
        this.codigoFunciones= "invoke MessageBox, NULL, addr AutoinvocacionFunciones, addr error, MB_OK \n"
                + "invoke ExitProcess, 0 \n"
                + "invoke MessageBox, NULL, addr OverflowSumaEnteros, addr error, MB_OK \n"
                + "invoke ExitProcess, 0 \n"
                + "invoke MessageBox, NULL, addr OverflowProductoDouble, addr error, MB_OK \n"
                + "invoke ExitProcess, 0 \n";
        this.codigoArbol="";
        this.arbol=parser.getRaiz();
        System.out.println("AAAAAAAAAAAARRRBOOOLLL: " + arbol);



        for (Nodo a : parser.getFunciones()) {
            codigoFunciones += a.getAssembler()+"\n";
        }
        codigoArbol +=this.arbol.getAssembler();
        System.out.println("ASSEMBLEEERR: " + arbol.getAssembler());
        generarCode();
        generarData();

    }


    private void generarData(){

        for (String k :  TablaSimbolos.getSimbolos().keySet()){
            String uso = TablaSimbolos.getToken(k).getUso();
            String tipo = TablaSimbolos.getToken(k).getTipo();
            if(uso != null){
                if(uso.equals("Constante")){
                    String prefijo = "_";
                    if(tipo.equals("USHORT"))
                    {
                        data += prefijo + k + " dd " + k + "\n";
                    }
                    else if(tipo.equals("DOUBLE"))
                    {
                        data += prefijo + k + " dd " + k + "\n";
                    }
                    else
                    {
                        data += prefijo +  k + " dd " + k + "\n";
                    }

                }
                if( uso.equals("Variable")  ||  uso.equals("variableAuxiliar"))
                {
                    String prefijo = "";
                    if(uso.equals("Variable"))
                    {
                        prefijo = "_";
                    }
                    if(tipo.equals("USHORT"))
                    {
                        data += prefijo +  k + " dd " + "?" + "\n";
                    }
                    else if(tipo.equals("DOUBLE"))
                    {
                        data += prefijo + k + " dd " + "?" + "\n";
                    }
                    else
                    {

                        data += prefijo +  k + " dd " + "?" + "\n";
                    }
                }
            }
        }
        data+= NodoControl.data;
    }

    private void generarCode() {
        code = "\n.code\n";

        code+= codigoFunciones;
        code+= "main:\n";

        code+= this.codigoArbol;
        code+= "invoke ExitProcess, 0 \n";
        code+= "end main";
    }

    public String getAssembler(){
        return (this.bibliotecas + this.data + this.code);

    }
}
