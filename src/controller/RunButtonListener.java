package controller;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by c12mkn on 2014-12-11.
 */
public class RunButtonListener implements ActionListener {
    private Simulator simulator;

    public RunButtonListener(Simulator simulator) {
        this.simulator = simulator;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        new SwingWorker<Void, Void>() {
            @Override
            protected Void doInBackground() {
                simulator.run();
                return null;
            }
        }.execute();
    }
}
