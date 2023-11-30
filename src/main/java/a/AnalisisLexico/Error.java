package a.AnalisisLexico;

public class Error {
    private final String error;
    private final int nroLinea;

    public Error(String error, int linea){
        this.error=error;
        this.nroLinea=linea;
    }

    public void printError(){
        System.out.println("Linea "+ nroLinea+": "+ error);
    }

    public String getError(){
        return this.error;
    }

    public int getLinea() {
        return this.nroLinea;
    }
}

