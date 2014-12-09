package model;

/**
 * Created by c12mkn on 2014-12-09.
 */
public class Registers {
    private int[] values;

    public Registers() {
        values = new int[32];
    }

    public void setRegister(int index, int value) {
        values[index] = value;
    }

    public int getRegister(int index) {
        return values[index];
    }
}
