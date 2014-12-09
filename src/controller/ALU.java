package controller;

import model.ALUCodes;

/**
 * Created by c12mkn on 2014-12-09.
 */
public class ALU {
    private boolean zeroFlag;
    private boolean overflowFlag;
    private boolean carryFlag;

    public ALU() {
        zeroFlag = false;
        overflowFlag = false;
        carryFlag = false;
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
        int sum = reg1 + reg2;
        if (Integer.signum(reg1) == Integer.signum(reg2) &&
                Integer.signum(reg1) != Integer.signum(sum)) {
            overflowFlag = true;
        }

        return sum;
    }

    private int and(int reg1, int reg2) {
        carryFlag = false;
        overflowFlag = false;
        return reg1 & reg2;
    }

    private int nor(int reg1, int reg2) {
        carryFlag = false;
        overflowFlag = false;
        return ~(reg1 | reg2);
    }

    private int or(int reg1, int reg2) {
        carryFlag = false;
        overflowFlag = false;
        return reg1 | reg2;
    }

    private int setOnLessThan(int reg1, int reg2) {
        carryFlag = false;
        overflowFlag = false;
        if (reg1 < reg2) {
            return 1;
        } else {
            return 0;
        }
    }

    private int subtract(int reg1, int reg2) {
        int sum = reg1 - reg2;
        if (Integer.signum(reg1) != Integer.signum(reg2) &&
                Integer.signum(reg1) != Integer.signum(sum)) {
            overflowFlag = true;
        }

        return sum;
    }

    public boolean zeroFlag() {
        return zeroFlag;
    }

    public boolean carryFlag() {
        return carryFlag;
    }

    public boolean overflowFlag() {
        return overflowFlag;
    }
}
