package GeneracionCodigoIntermedio;
import AnalisisLexico.ParserVal;
import java.util.ArrayList;
import java.util.List;

public class ListVariables extends ParserVal {

    List<String> ids;

    public ListVariables(){
        ids = new ArrayList<>();
    }

    public void addVariable(String var){
        ids.add(var);
    }

    public String getVariable(){
       if (!ids.isEmpty()){
            String var = ids.get(0);
            ids.remove(0);
            return var;
       }
       else return null;
    }
}
