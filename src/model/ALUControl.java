package model;

/**
 * Created by c12arr on 2014-12-09.
 */
public class ALUControl {

    public static final byte AND = 0;
    public static final byte OR = 1;
    public static final byte ADD = 2;
    public static final byte SUBTRACT = 6;
    public static final byte SETONLESSTHAN = 7;
    public static final byte NOR = 12;

    static private byte ALUControl;

    static public void processInstruction(Instruction molly) {
       int op = molly.getDecomposed()[0];
       int funct;
        switch(op){
            case 0:
               ALUControl = ADD;
            case 1:
                ALUControl = SUBTRACT;
            case 2:
                funct = molly.getDecomposed()[molly.getDecomposed().length];
                ALUControl = parseR(funct);
        }
    }

    private static byte parseR(int func){

        switch(func) {
            case 32:
                return ADD;
            case 34:
                return SUBTRACT;
            case 36:
                return AND;
            case 37:
                return OR;
            case 38:
                return SETONLESSTHAN;
            default:
                return -1;
        }
    }

    public byte getALUOP() {
        return ALUControl;
    }
}
