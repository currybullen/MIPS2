package controller;

import model.ALUCodes;

public class ALU {
    private boolean zeroFlag;

    public ALU() {
        zeroFlag = false;
    }

    public int operate(int reg1, int reg2, byte aluControl) {
        int result;

        switch(aluControl) {
            case ALUCodes.ADD:
                result = add(reg1, reg2);
                break;
            case ALUCodes.AND:
                result = and(reg1, reg2);
                break;
            case ALUCodes.NOR:
                result = nor(reg1, reg2);
                break;
            case ALUCodes.OR:
                result = or(reg1, reg2);
                break;
            case ALUCodes.SETONLESSTHAN:
                result = setOnLessThan(reg1, reg2);
                break;
            case ALUCodes.SUBTRACT:
                result = subtract(reg1, reg2);
                break;
            default:
                result = 0;
        }

        if (result == 0) {
            zeroFlag = true;
        }

        return result;
    }

    private int add(int reg1, int reg2) {
        return reg1 + reg2;
    }

    private int and(int reg1, int reg2) {
        return reg1 & reg2;
    }

    private int nor(int reg1, int reg2) {
        return ~(reg1 | reg2);
    }

    private int or(int reg1, int reg2) {
        return reg1 | reg2;
    }

    private int setOnLessThan(int reg1, int reg2) {
        if (reg1 < reg2) {
            return 1;
        } else {
            return 0;
        }
    }

    private int subtract(int reg1, int reg2) {
        return reg1 - reg2;
    }

    public boolean zeroFlag() {
        return zeroFlag;
    }
}
