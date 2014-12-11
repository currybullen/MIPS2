package model;

import javax.swing.*;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by c12mkn on 2014-12-11.
 */
public class MemoryListModel extends AbstractListModel {
    private ArrayList<Integer> keys;
    private HashMap<Integer, Integer> changedValues;

    public MemoryListModel(int memorySize) {
        changedValues = new HashMap<Integer, Integer>(memorySize);
        keys = new ArrayList<Integer>();
    }

    public void changeValue(int address, int value) {
        if (changedValues.get(address) == null) {
            keys.add(address);
        }
        changedValues.put(address,value);
    }

    @Override
    public int getSize() {
        return keys.size();
    }

    @Override
    public Object getElementAt(int index) {
        String element = keys.get(index) + " " + changedValues.
                get((keys.get(index)));
        return element;
    }
}
