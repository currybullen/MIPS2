package controller;

import model.InstructionListModel;
import model.MemoryListModel;
import model.RegisterListModel;
import model.SimulatorSettings;
import view.GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by c12mkn on 2014-12-11.
 */
public class ChangeBaseButtonListener implements ActionListener {
    private GUI gui;

    public ChangeBaseButtonListener() {
        this.gui = gui;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (SimulatorSettings.showHexadecimal = false) {
            SimulatorSettings.showHexadecimal = true;
        } else {
            SimulatorSettings.showHexadecimal = false;
        }
        //Ändra på knappen
    }
}
