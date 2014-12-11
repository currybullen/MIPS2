package controller;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by c12mkn on 2014-12-11.
 */
public class StepButtonListener implements ActionListener {
    private Simulator simulator;
    private JList instructionList;

    public StepButtonListener(Simulator simulator, JList instructionList) {
        this.simulator = simulator;
        this.instructionList = instructionList;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        new SwingWorker<Void, Void>() {
            @Override
            protected Void doInBackground() {
                simulator.step();
                return null;
            }
        }.execute();

        instructionList.setSelectedIndex(simulator.getPC()/4);
    }
}
