package controller;

import model.InstructionListModel;
import model.MemoryListModel;
import model.RegisterListModel;
import model.SimulatorSettings;
import view.GUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;

/**
 * Created by c12mkn on 2014-12-11.
 */
public class ChangeBaseButtonListener extends Observable
        implements ActionListener {
    private JButton changeBaseButton;

    public ChangeBaseButtonListener(JButton changeBaseButton) {
        this.changeBaseButton = changeBaseButton;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (SimulatorSettings.showHexadecimal == false) {
            SimulatorSettings.showHexadecimal = true;
            changeBaseButton.setText("Switch to decimal");
        } else {
            SimulatorSettings.showHexadecimal = false;
            changeBaseButton.setText("Switch to hexadecimal");
        }

        setChanged();
        notifyObservers(-1);
        clearChanged();
    }
}
