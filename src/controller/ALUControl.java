package controller;

import model.ALUCodes;

/**
 * Created by c12arr on 2014-12-09.
 */
public class ALUControl {



    static private byte ALUControl;
    static private int funct;
    static public void processInstruction(byte op) {
        switch(op){
            case 0:
               ALUControl = ALUCodes.ADD;
            case 1:
                ALUControl = ALUCodes.SUBTRACT;
            case 2:
                ALUControl = parseR(funct);
        }
        funct = 0;
    }

    private static byte parseR(int func){

        switch(func) {
            case 32:
                return ALUCodes.ADD;
            case 34:
                return ALUCodes.SUBTRACT;
            case 36:
                return ALUCodes.AND;
            case 37:
                return ALUCodes.OR;
            case 38:
                return ALUCodes.SETONLESSTHAN;
            default:
                return -1;
        }
    }

    public void setFunct(int funct) {
        this.funct = funct;
    }
    public byte getALUOP() {
        return ALUControl;
    }
}
