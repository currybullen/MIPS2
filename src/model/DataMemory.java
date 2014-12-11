package model;

/**
 * Created by c12mkn on 2014-12-11.
 */
public class DataMemory {
    private int[] memory;

    public DataMemory(int size) {
        memory = new int[size];
    }

    public void storeWord(int word, int address) {
        memory[address/4] = word;
    }

    public int loadWord(int address) {
        return memory[address/4];
    }
}
