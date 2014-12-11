package model;

import javax.swing.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Observable;
import java.util.Observer;

/**
 * Created by c12mkn on 2014-12-11.
 */
public class MemoryListModel extends AbstractListModel implements Observer {
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
        String element = keys.get(index) + ": ";
        if (SimulatorSettings.showHexadecimal) {
            element += Integer.toHexString(changedValues.get(keys.get(index)));
        } else {
            element += changedValues.get(keys.get(index));
        }

        return element;
    }

    @Override
    public void update(Observable observable, Object object) {
        fireContentsChanged(this, 0, getSize()-1);
    }
}
