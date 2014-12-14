package controller;

import model.ALUCodes;

/**
 * A class mimicking the ALU component of a MIPS processor. Supported operations
 * are add, and, nor, or, set on lessthan and subtract.
 */
public class ALU {
    private boolean zeroFlag;

    /**
     * Constructs an ALU.
     */
    public ALU() {
        zeroFlag = false;
    }

    /**
     * Runs an operation on the two registers reg1 and reg2 depending on the
     * supplied data from the ALU Control unit and returns the computed value.
     * @param reg1 the register containing the first value of the operation.
     * @param reg2 the register containing the second value of the operation.
     * @param aluControl the supplied data from the ALU Control unit.
     * @return the result of the operation.
     */
    public int operate(int reg1, int reg2, byte aluControl) {
        int result;

        /*The operation to run is decided.*/
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

        /*If the resulting value equals zero, set the zero flag to true.*/
        if (result == 0) {
            zeroFlag = true;
        }

        return result;
    }

    /**
     * The ALU add operation, adding two values together.
     * @param reg1 the first register value.
     * @param reg2 the second register value.
     * @return the result of the add operation.
     */
    private int add(int reg1, int reg2) {
        return reg1 + reg2;
    }

    /**
     * The ALU and operation, logically and:ing two registers together.
     * @param reg1 the first register value.
     * @param reg2 the second register value.
     * @return the result of the and operation.
     */
    private int and(int reg1, int reg2) {
        return reg1 & reg2;
    }

    /**
     * The ALU nor operation, logically nor:ing two registers together.
     * @param reg1 the first register value.
     * @param reg2 the second register value.
     * @return the result of the nor operation.
     */
    private int nor(int reg1, int reg2) {
        return ~(reg1 | reg2);
    }

    /**
     * The ALU or operation, logically or:ing two registers together.
     * @param reg1 the first register value.
     * @param reg2 the second register value.
     * @return the result of the or operation.
     */
    private int or(int reg1, int reg2) {
        return reg1 | reg2;
    }

    /**
     * The ALU set on less than operation, returning 1 if the first supplied
     * register is less than the scond, else 0.
     * @param reg1 the first register value.
     * @param reg2 the second register value.
     * @return the result of the set on less than operation.
     */
    private int setOnLessThan(int reg1, int reg2) {
        if (reg1 < reg2) {
            return 1;
        } else {
            return 0;
        }
    }

    /**
     * The ALU sub operation, subtracting a second register value from the
     * first.
     * @param reg1 the first register value.
     * @param reg2 the second register value.
     * @return the result of the subtraction.
     */
    private int subtract(int reg1, int reg2) {
        return reg1 - reg2;
    }

    /**
     * Returns the state of the zero flag.
     * @return the zero flag status.
     */
    public boolean zeroFlag() {
        return zeroFlag;
    }
}
