package model;

import javax.swing.*;
import java.util.Observable;
import java.util.Observer;

/**
 * A class mimicking the registers of a MIPS processor.
 */
public class Registers extends AbstractListModel implements Observer {
    private int[] values;

    /**
     * Constructs a Registers object with 32 registers.
     */
    public Registers() {
        values = new int[32];
    }

    /**
     * Sets a register at a supplied index to a supplied value.
     * @param index the index of the register.
     * @param value the value to be set.
     */
    public void setRegister(int index, int value) {
        values[index] = value;
        fireContentsChanged(this, index, index);
    }

    /**
     * Returns the register value from a given register.
     * @param index the index of the register.
     * @return the register value.
     */
    public int getRegister(int index) {
        return values[index];
    }

    /**
     * Sets all of the register values to 0.
     */
    public void reset() {
        for (int i = 0; i < values.length; i++) {
            values[i] = 0;
        }
        fireContentsChanged(this, 0, values.length-1);
    }

    /*Returns the size of the data memory.*/
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

    /*Executed when the user presses the change base button to update the
    * entire list of changed values.*/
    @Override
    public void update(Observable observable, Object object) {
        fireContentsChanged(this, 0, getSize()-1);
    }
}
