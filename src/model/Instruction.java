package model;

import java.util.ArrayList;

/**
 * Created by currybullen on 2014-12-06.
 */
public class Instruction {
    private String mnemonic;
    private int[] decomposed;

    public Instruction(String mnemonic, int[] decomposed) {
        this.mnemonic = mnemonic;
        this.decomposed = decomposed;
    }

    public String getMnemonic(String mnemonic) {
        return mnemonic;
    }

    public int getValue(int index) {
        return decomposed[index];
    }
}
