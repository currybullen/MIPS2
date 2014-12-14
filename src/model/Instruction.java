package model;

/**
 * A class representing a MIPS instruction.
 */
public class Instruction {
    protected final String mnemonic;
    protected final int type;
    protected final int decomposed[];

    /**
     * Constructs an instruction.
     * @param mnemonic the mnemonic representation of the instruction.
     * @param type the type of instruction as defined in InstructionTypes.
     * @param decomposed the decomposed representation of the instruction.
     */
    public Instruction(String mnemonic, int type, int... decomposed) {
        this.mnemonic = mnemonic;
        this.type = type;
        this.decomposed = decomposed;
    }

    /**
     * Returns the mnemonic representation of the instruction.
     * @return the mnemonic representation of the instruction.
     */
    public String getMnemonic() {
        return mnemonic;
    }

    /**
     * Returns the decomposed representation of the instruction.
     * @return the decomposed representation of the instruction.
     */
    public int[] getDecomposed() {
        return decomposed;
    }

    /**
     * Returns the type of the instruction as defined in InstructionTypes.
     * @return the type of the instruction.
     */
    public int getType() {
        return type;
    }
}
