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
    private boolean aluOP0;
    private boolean aluOP1;
    private boolean memWrite;
    private boolean aluSrc;
    private boolean regWrite;

    public Control() {
        regDst = false;
        branch = false;
        memRead = false;
        memtoReg = false;
        aluOP0 = false;
        aluOP1 = false;
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
                aluOP0 = true;
                aluOP1 = false;
                memWrite = false;
                aluSrc = false;
                regWrite = true;
                break;
            case OpCodes.LW:
                regDst = false;
                branch =false;
                memRead = true;
                memtoReg = true;
                aluOP0 = false;
                aluOP1 = false;
                memWrite = false;
                aluSrc = true;
                regWrite = true;
                break;
            case OpCodes.SW:
                branch = false;
                memRead = false;
                aluOP0 = false;
                aluOP1 = false;
                memWrite = true;
                aluSrc = true;
                regWrite = false;
                break;
            case OpCodes.BEQ:
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

    public boolean aluOP0() {
        return aluOP0;
    }

    public boolean aluOP1() {
        return aluOP1;
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
