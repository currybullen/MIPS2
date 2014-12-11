package model;

/**
 * Created by c12mkn on 2014-12-11.
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

    public boolean isRegDst() {
        return regDst;
    }

    public void setRegDst(boolean regDst) {
        this.regDst = regDst;
    }

    public boolean isBranch() {
        return branch;
    }

    public void setBranch(boolean branch) {
        this.branch = branch;
    }

    public boolean isMemRead() {
        return memRead;
    }

    public void setMemRead(boolean memRead) {
        this.memRead = memRead;
    }

    public boolean isMemtoReg() {
        return memtoReg;
    }

    public void setMemtoReg(boolean memtoReg) {
        this.memtoReg = memtoReg;
    }

    public byte getAluOP() {
        return aluOP;
    }

    public void setAluOP(byte aluOP) {
        this.aluOP = aluOP;
    }

    public boolean isMemWrite() {
        return memWrite;
    }

    public void setMemWrite(boolean memWrite) {
        this.memWrite = memWrite;
    }

    public boolean isAluSrc() {
        return aluSrc;
    }

    public void setAluSrc(boolean aluSrc) {
        this.aluSrc = aluSrc;
    }

    public boolean isRegWrite() {
        return regWrite;
    }

    public void setRegWrite(boolean regWrite) {
        this.regWrite = regWrite;
    }
}
