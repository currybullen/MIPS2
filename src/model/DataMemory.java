package model;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;


/**
 * A class mimicking the data memory of a MIPS processor. Extends the
 * AbstractListModel for the sake of accessing it through a GUI. Implements
 * the Observer interface to easily switch from hexadecimal format to decimal
 * and back.
 */
public class DataMemory extends AbstractListModel<String> implements Observer {
    private int[] memory;
    private final ArrayList<Integer> changedValues;

    /**
     * Constructs a data memory of the given size in words.
     * @param size the size in words (32 bit words).
     */
    public DataMemory(int size) {
        memory = new int[size];
        changedValues = new ArrayList<>();
    }

    /**
     * Stores a word at the given address.
     * @param word the word to be stored.
     * @param address the address to be stored at.
     */
    public void storeWord(int word, int address) {
        memory[address/4] = word;
        changedValues.add(address/4);
        fireIntervalAdded(this, changedValues.size() - 1,
                changedValues.size() - 1);
    }

    /**
     * Returns the word from a given address.
     * @param address the address in the memory.
     * @return the word stored at the address.
     */
    public int loadWord(int address) {
        return memory[address/4];
    }

    /**
     * Resets the memory by setting the values of all addresses to 0.
     */
    public void reset() {
        if (changedValues.size() != 0) {
            int lastIndex = changedValues.size()-1;
            changedValues.clear();
            fireIntervalRemoved(this, 0, lastIndex);
        }
    }

    /*Returns not the size of the actual data memory but rather the size of  the
    * list of values that have changed during runtime. Used as a part of the
    * AbstractListModel.*/
    @Override
    public int getSize() {
        return changedValues.size();
    }

    @Override
    public String getElementAt(int index) {
        String element = "";
        if (SimulatorSettings.showHexadecimal) {
            element += Integer.toHexString(changedValues.get(index)*4) + ": ";
            element += Integer.toHexString(memory[changedValues.get(index)]);
        } else {
            element += changedValues.get(index)*4 + ": ";
            element += memory[changedValues.get(index)];
        }
        return element;
    }

    /*Executed when the user presses the change base button to update the
    * entire list of changed values.*/
    @Override
    public void update(Observable observable, Object object) {
        fireContentsChanged(this, 0, getSize()-1);
    }
}
