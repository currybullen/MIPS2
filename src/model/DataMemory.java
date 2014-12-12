package model;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

/**
 * Created by c12mkn on 2014-12-11.
 */
public class DataMemory extends AbstractListModel implements Observer {
    private int[] memory;
    private ArrayList<Integer> changedValues;

    public DataMemory(int size) {
        memory = new int[size];
        changedValues = new ArrayList<Integer>();
    }

    public void storeWord(int word, int address) {
        memory[address/4] = word;
        changedValues.add(address/4);
        fireIntervalAdded(this, changedValues.size() - 1,
                changedValues.size() - 1);
    }

    public int loadWord(int address) {
        return memory[address/4];
    }

    public void reset() {
        if (changedValues.size() != 0) {
            int lastIndex = changedValues.size()-1;
            changedValues.clear();
            fireIntervalRemoved(this, 0, lastIndex);
        }
    }

    @Override
    public int getSize() {
        return changedValues.size();
    }

    @Override
    public Object getElementAt(int index) {
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

    @Override
    public void update(Observable observable, Object object) {
        fireContentsChanged(this, 0, getSize()-1);
    }
}
