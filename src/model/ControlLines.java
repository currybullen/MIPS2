package model;

/**
 * Contains the MIPS control lines and means of setting and getting them.
 */
public class ControlLines {
    private boolean regDst;
    private boolean branch;
    private boolean memRead;
    private boolean memtoReg;
    private byte aluOP;
    private boolean memWrite;
    private boolean aluSrc;
    private boolean regWrite;

    /**
     * Constructs a ControlLines object and sets all of the control lines to
     * false from the start.
     */
    public ControlLines() {
        regDst = false;
        branch = false;
        memRead = false;
        memtoReg = false;
        aluOP = 0;
        memWrite = false;
        aluSrc = false;
        regWrite = false;
    }

    /**
     * Returns the value of the RegDst control line.
     * @return the value of the RegDst control line.
     */
    public boolean isRegDst() {
        return regDst;
    }

    /**
     * Sets the value of the RegDst control line.
     * @param regDst the value for the RegDst control line.
     */
    public void setRegDst(boolean regDst) {
        this.regDst = regDst;
    }

    /**
     * Returns the value of the Branch control line.
     * @return the value of the Branch control line.
     */
    public boolean isBranch() {
        return branch;
    }

    /**
     * Sets the value of the Branch control line.
     * @param branch the value for the branch control line.
     */
    public void setBranch(boolean branch) {
        this.branch = branch;
    }

    /**
     * Returns the value of the MemRead control line.
     * @return the value of the MemRead control line.
     */
    public boolean isMemRead() {
        return memRead;
    }

    /**
     * Sets the value of the MemRead control line.
     * @param memRead the value for the MemRead control line.
     */
    public void setMemRead(boolean memRead) {
        this.memRead = memRead;
    }

    /**
     * Returns the value of the MemtoReg control line.
     * @return the value of the MemtoReg control line.
     */
    public boolean isMemtoReg() {
        return memtoReg;
    }

    /**
     * Sets the value of the MemtoReg control line.
     * @param memtoReg the value for the MemtoReg control line.
     */
    public void setMemtoReg(boolean memtoReg) {
        this.memtoReg = memtoReg;
    }

    /**
     * Returns the AluOP code control line.
     * @return the AluOP code.
     */
    public byte getAluOP() {
        return aluOP;
    }

    /**
     * Sets the AluOP code control line.
     * @param aluOP the value for the AluOP control line.
     */
    public void setAluOP(byte aluOP) {
        this.aluOP = aluOP;
    }

    /**
     * Returns the value of the MemWrite control line.
     * @return the value of the MemWrite control line.
     */
    public boolean isMemWrite() {
        return memWrite;
    }

    /**
     * Sets the value of the MemWrite control line.
     * @param memWrite the value for the MemWrite control line.
     */
    public void setMemWrite(boolean memWrite) {
        this.memWrite = memWrite;
    }

    /**
     * Returns the value of the AluSrc control line.
     * @return the value of the AluSrc control line.
     */
    public boolean isAluSrc() {
        return aluSrc;
    }

    /**
     * Sets the value for the AluSrc control line.
     * @param aluSrc the value for the AluSrc control line.
     */
    public void setAluSrc(boolean aluSrc) {
        this.aluSrc = aluSrc;
    }

    /**
     * Returns the value of the RegWrite control line.
     * @return the value of the RegWrite control line.
     */
    public boolean isRegWrite() {
        return regWrite;
    }

    /**
     * Sets the value for the RegWrite control line.
     * @param regWrite a value for the RegWrite control line.
     */
    public void setRegWrite(boolean regWrite) {
        this.regWrite = regWrite;
    }
}
