package AnalisisLexico;

import AnalisisLexico.AccionesSemanticas.*;
import AnalisisLexico.AccionesSemanticas.AS_Error;

public class GeneradorMatrices {

    private static final AccionSemantica AS0 = new AS0();
    private static final AccionSemantica AS1 = new AS1();
    private static final AccionSemantica AS2 = new AS2();
    private static final AccionSemantica AS3 = new AS3();
    private static final AccionSemantica AS5 = new AS5();
    private static final AccionSemantica AS6 = new AS6();
    private static final AccionSemantica AS7 = new AS7();
    private static final AccionSemantica AS8 = new AS8();
    private static final AccionSemantica AS9 = new AS9();
    private static final AccionSemantica AS10 = new AS10();
    private static final AccionSemantica AS11 = new AS11();

    private static final AccionSemantica E = new AS_Error();

    public static AccionSemantica[][] getMatrizAS() {
        int rows = 19;
        int columns = 20;

        AccionSemantica[][] as_matrix = new AccionSemantica[rows][columns];

        // Llena las matrices con valores   //0     1   2    3    4   5     6    7    8    9    10   11   12  13   14   15   16   17   18   19
        as_matrix[0] = new AccionSemantica[]{AS2, AS2, AS2, AS2, AS0, AS0, AS0, AS0, AS0, AS0, AS2, AS2, AS1, AS0, AS2, AS2, AS2, AS2, AS2,AS1 };
        as_matrix[1] = new AccionSemantica[]{AS2, AS2, AS2, AS8, AS8, AS8, AS8, AS8, AS8, AS8, AS2, AS8, AS8, AS8, AS8, AS2, AS2, AS2, AS8,AS8};
        as_matrix[2] = new AccionSemantica[]{AS9, AS9, AS9, AS9, AS9, AS0, AS9, AS9, AS9, AS9, AS9, AS9, AS9, AS9, AS9, AS9, AS9, AS9, AS9,AS9};
        as_matrix[3] = new AccionSemantica[]{AS9, AS9, AS9, AS9, AS9, AS9, AS9, AS9, AS0, AS9, AS9, AS9, AS9, AS9, AS9, AS9, AS9, AS9, AS9,AS9};
        as_matrix[4] = new AccionSemantica[]{AS9, AS9, AS9, AS9, AS9, AS0, AS9, AS9, AS9, AS9, AS9, AS9, AS9, AS9, AS9, AS9, AS9, AS9, AS9,AS9};
        as_matrix[5] = new AccionSemantica[]{AS9, AS9, AS9, AS9, AS9, AS0, AS9, AS9, AS9, AS9, AS9, AS9, AS9, AS9, AS9, AS9, AS9, AS9, AS9,AS9};
        as_matrix[6] = new AccionSemantica[]{E, E, AS2, E, E, E, E, E, E, E, AS2, E, E, E, AS2, E, E, AS2, E, E };
        as_matrix[7] = new AccionSemantica[]{E, E, E, E, E, E, E, E, E, E, E, E, E, E, E, AS2, AS11, E, E,E};
        as_matrix[8] = new AccionSemantica[]{E, E, E, E, E, E, E, E, E, E, E, E, E, E, E, E, E, AS10, E,E};
        as_matrix[9] = new AccionSemantica[]{AS9, AS9, AS2, AS9, AS9, AS9, AS9, AS9, AS9, AS9, AS9, AS9, AS9, AS9, AS9, AS9, AS9, AS9, AS9,AS9};
        as_matrix[10] = new AccionSemantica[]{AS5, AS5, AS2, AS5, AS5, AS5, AS5, AS5, AS5, AS5, AS5, AS5, AS5, AS5, AS5, AS5, AS5, AS5, AS2,AS5};
        as_matrix[11] = new AccionSemantica[]{E, E, E, E, AS2, E, E, E, E, AS2, E, E, E, E, E, E, E, E, E,E};
        as_matrix[12] = new AccionSemantica[]{E, E, AS2, E, E, E, E, E, E, E, E, E, E, E, E, E, E, E, E,E};
        as_matrix[13] = new AccionSemantica[]{AS2, AS8, AS8, AS8, AS8, AS8, AS8, AS8, AS8, AS8, AS2, AS8, AS8, AS8, AS8, AS8, AS8, AS8, AS2,AS8};
        as_matrix[14] = new AccionSemantica[]{AS9, AS9, AS9, AS3, AS9, AS9, AS9, AS9, AS9, AS9, AS9, AS9, AS9, AS9, AS9, AS9, AS9, AS9, AS9,AS9};
        as_matrix[15] = new AccionSemantica[]{AS2, AS2, AS2, AS2, AS2, AS2, AS2, AS2, AS2, AS2, AS2, AS2, AS1, AS2, AS2, AS2, AS2, AS2, AS2,AS2};
        as_matrix[16] = new AccionSemantica[]{AS2, AS2, AS2, AS2, AS2, AS2, AS2, AS2, AS2, AS2, AS2, AS6, E, AS2, AS2, AS2, AS2, AS2, AS2,AS2};
        as_matrix[17] = new AccionSemantica[]{AS5, AS5, AS2, AS5, AS5, AS5, AS5, AS5, AS5, AS5, AS2, AS5, AS5, AS5, AS5, AS5, AS5, AS5, AS2,AS5};
        as_matrix[18] = new AccionSemantica[]{AS7,AS7,AS2,AS7,AS7,AS7,AS7,AS7,AS7,AS7,AS7,AS7,AS7,AS7,AS7,AS7,AS7,AS7,AS7,AS7,AS7};
        return as_matrix;
    }
    public static int[][] getMatrizEstados() {
        int rows = 19;
        int columns = 20;

        int[][] te_matrix = new int[rows][columns];

        // Llena la matriz te_matrix con valores
        te_matrix[0] = new int[]{13, 1, 6, 14, 5, 2, 4, 4, 3, 0, 1, 16, 0, 0, 9, 1, 1, 1, 13,0};
        te_matrix[1] = new int[]{0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1, 1, 1, 0,0};
        te_matrix[2] = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,0};
        te_matrix[3] = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,0};
        te_matrix[4] = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,0};
        te_matrix[5] = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,0};
        te_matrix[6] = new int[]{-1, -1, 6, -1, -1, -1, -1, -1, -1, -1, 7, -1, -1, 0, 17, -1, -1, -1, -1,0};
        te_matrix[7] = new int[]{-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 8, 0, -1, -1,-1};
        te_matrix[8] = new int[]{-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 0, -1,-1};
        te_matrix[9] = new int[]{0, 0, 10, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,0};
        te_matrix[10] = new int[]{0, 0, 10, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 11,0};
        te_matrix[11] = new int[]{-1, -1, -1, -1, 12, -1, -1, -1, -1, 12, -1, -1, -1, -1, -1, -1, -1, -1, -1,-1};
        te_matrix[12] = new int[]{0, 0, 18, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,-1};
        te_matrix[13] = new int[]{13, 0, 0, 0, 0, 0, 0, 0, 0, 0, 13, 0, 0, 0, 0, 0, 0, 0, 13,0};
        te_matrix[14] = new int[]{0, 0, 0, 15, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,0};
        te_matrix[15] = new int[]{15, 15, 15, 15, 15, 15, 15, 15, 15, 15, 15, 15, 0, 15, 15, 15, 15, 15, 15,15};
        te_matrix[16] = new int[]{16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 0, -1, 16, 16, 16, 16, 16, 16,16};
        te_matrix[17] = new int[]{0, 0, 10, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 11,0};
        te_matrix[18] = new int[]{0, 0, 18, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,0};
        return te_matrix;
    }
}