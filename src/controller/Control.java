package controller;

import model.ControlLines;
import model.OpCodes;

/**
 * Created by currybullen on 2014-12-08.
 */
public class Control {
    private ControlLines controlLines;

    public Control(ControlLines controlLines) {
        this.controlLines = controlLines;
    }

    public void setValues(int opCode) {
        switch(opCode) {
            case 0:
                controlLines.setRegDst(true);
                controlLines.setBranch(false);
                controlLines.setMemRead(false);
                controlLines.setMemtoReg(false);
                controlLines.setAluOP((byte) 1);
                controlLines.setMemWrite(false);
                controlLines.setAluSrc(false);
                controlLines.setRegWrite(true);
                break;
            case OpCodes.LW:
                controlLines.setRegDst(false);
                controlLines.setBranch(false);
                controlLines.setMemRead(true);
                controlLines.setMemtoReg(true);
                controlLines.setAluOP((byte) 0);
                controlLines.setMemWrite(false);
                controlLines.setAluSrc(true);
                controlLines.setRegWrite(true);
                break;
            case OpCodes.SW:
                controlLines.setBranch(false);
                controlLines.setMemRead(false);
                controlLines.setAluOP((byte) 0);
                controlLines.setMemWrite(true);
                controlLines.setAluSrc(true);
                controlLines.setRegWrite(false);
                break;
            case OpCodes.BEQ:
                controlLines.setBranch(true);
                controlLines.setMemRead(false);
                controlLines.setAluOP((byte) 1);
                controlLines.setMemWrite(false);
                controlLines.setAluSrc(false);
                controlLines.setRegWrite(false);
                break;
        }
    }
}
