package model;

import javax.swing.*;
import java.util.Observable;
import java.util.Observer;

/**
 * Created by c12mkn on 2014-12-09.
 */
public class Registers extends AbstractListModel implements Observer {
    private int[] values;

    public Registers() {
        values = new int[32];
    }

    public void setRegister(int index, int value) {
        values[index] = value;
        fireContentsChanged(this, index, index);
    }

    public int getRegister(int index) {
        return values[index];
    }

    public void reset() {
        for (int i = 0; i < values.length; i++) {
            values[i] = 0;
        }
        fireContentsChanged(this, 0, values.length-1);
    }

    @Override
    public int getSize() {
        return values.length;
    }

    @Override
    public Object getElementAt(int index) {
        String element;

        switch(index) {
            case 0:
                element = "$zero";
                break;
            case 1:
                element = "$at";
                break;
            case 2:
                element = "$v0";
                break;
            case 3:
                element = "$v1";
                break;
            case 4:
            case 5:
            case 6:
            case 7:
                element = "$a" + (index - 4) ;
                break;
            case 8:
            case 9:
            case 10:
            case 11:
            case 12:
            case 13:
            case 14:
            case 15:
                element = "$t" + (index - 8);
                break;
            case 16:
            case 17:
            case 18:
            case 19:
            case 20:
            case 21:
            case 22:
            case 23:
                element = "$s" + (index-16);
                break;
            case 24:
            case 25:
                element = "$t" + (index -24);
                break;
            case 26:
            case 27:
                element = "$k" + (index - 26);
                break;
            case 28:
                element = "$gp";
                break;
            case 29:
                element = "$sp";
                break;
            case 30:
                element = "$fp";
                break;
            case 31:
                element = "$ra";
                break;
            default:
                element = "";
        }

        if (SimulatorSettings.showHexadecimal) {
            element += ": " + Integer.toHexString(values[index]);
        } else {
            element += ": " + values[index];
        }

        return element;
    }

    @Override
    public void update(Observable observable, Object object) {
        fireContentsChanged(this, 0, getSize()-1);
    }
}
