package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by c12mkn on 2014-12-11.
 */
public class ResetButtonListener implements ActionListener {
    private Simulator simulator;

    public ResetButtonListener(Simulator simulator) {
        this.simulator = simulator;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        new Thread() {
            @Override
            public void run() {
                simulator.reset();
            }
        }.start();
    }
}
