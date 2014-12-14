package controller;


import model.SimulatorSettings;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;

/**
 * A listener class that is used for when the user presses the change base
 * button of the GUI.
 */
public class ChangeBaseButtonListener extends Observable
        implements ActionListener {
    private final JButton changeBaseButton;

    /**
     * Constructs a ChangeBaseButtonListener.
     * @param changeBaseButton a reference to the actual button.
     */
    public ChangeBaseButtonListener(JButton changeBaseButton) {
        this.changeBaseButton = changeBaseButton;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        /*If the GUI is currently displaying values in decimal, switch it
        * to hexadecimal.*/
        if (!SimulatorSettings.showHexadecimal) {
            SimulatorSettings.showHexadecimal = true;
            changeBaseButton.setText("Switch to decimal");

            /*Else, switch it to decimal.*/
        } else {
            SimulatorSettings.showHexadecimal = false;
            changeBaseButton.setText("Switch to hexadecimal");
        }

        /*Notify the observers, which in this case are the data models for
        * the lists. They will upon notification update themselves.*/
        setChanged();
        notifyObservers();
        clearChanged();
    }
}
