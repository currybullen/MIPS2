package controller;

import model.OpCodes;

/**
 * Created by currybullen on 2014-12-08.
 */
public class Control {
    private boolean regDst;
    private boolean branch;
    private boolean memRead;
    private boolean memtoReg;
    private byte aluOP;
    private boolean memWrite;
    private boolean aluSrc;
    private boolean regWrite;

    public Control() {
        regDst = false;
        branch = false;
        memRead = false;
        memtoReg = false;
        aluOP = 0;
        memWrite = false;
        aluSrc = false;
        regWrite = false;
    }

    public void setValues(int opCode) {
        switch(opCode) {
            case 0:
                regDst = true;
                branch = false;
                memRead = false;
                memtoReg = false;
                aluOP = 1;
                memWrite = false;
                aluSrc = false;
                regWrite = true;
                break;
            case OpCodes.LW:
                regDst = false;
                branch =false;
                memRead = true;
                memtoReg = true;
                aluOP = 0;
                memWrite = false;
                aluSrc = true;
                regWrite = true;
                break;
            case OpCodes.SW:
                branch = false;
                memRead = false;
                aluOP = 0;
                memWrite = true;
                aluSrc = true;
                regWrite = false;
                break;
            case OpCodes.BEQ:
                branch = true;
                memRead = false;
                aluOP = 1;
                memWrite = false;
                aluSrc = false;
                regWrite = false;
                break;
        }
    }

    public boolean regDst() {
        return regDst;
    }

    public boolean branch() {
        return branch;
    }

    public boolean memRead() {
        return memRead;
    }

    public boolean memToReg() {
        return memtoReg;
    }

    public byte aluOP() {
        return aluOP;
    }

    public boolean memWrite() {
        return memWrite;
    }

    public boolean aluSrc() {
        return aluSrc;
    }

    public boolean regWrite() {
        return regWrite;
    }
}
