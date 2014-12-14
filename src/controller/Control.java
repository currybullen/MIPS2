package controller;

import model.ControlLines;
import model.OpCodes;

/**
 * A class mimicking the Control unit of a MIPS processor. Works for all
 * R-format instructions as well as the lw, sw and beq instructions.
 */
public class Control {
    private final ControlLines controlLines;

    /**
     * Constructs a Control object.
     * @param controlLines a reference to a ControlLines object containing the
     * control lines of the MIPS processor.
     */
    public Control(ControlLines controlLines) {
        this.controlLines = controlLines;
    }

    /*Sets the values of the control lines depending on the op code of the
    * instruction.*/
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
