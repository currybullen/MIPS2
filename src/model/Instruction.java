package model;

import java.util.Arrays;

/**
 * Created by currybullen on 2014-12-06.
 */
public class Instruction {
    protected String mnemonic;
    protected int type;
    protected int decomposed[];

    public Instruction(String mnemonic, int type, int... decomposed) {
        this.mnemonic = mnemonic;
        this.type = type;
        this.decomposed = decomposed;
    }

    public String getMnemonic() {
        return mnemonic;
    }

    public int[] getDecomposed() {
        return decomposed;
    }

    public String getDecomposedString() {
        return Arrays.toString(decomposed);
    }

    public int getType() {
        return type;
    }
}
