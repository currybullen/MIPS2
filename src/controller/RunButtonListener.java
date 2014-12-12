package controller;

import com.sun.org.apache.bcel.internal.generic.InstructionList;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by c12mkn on 2014-12-11.
 */
public class RunButtonListener implements ActionListener {
    private Simulator simulator;
    private JList instructionList;

    public RunButtonListener(Simulator simulator, JList instructionList) {
        this.simulator = simulator;
        this.instructionList = instructionList;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        new SwingWorker<Void, Void>() {
            @Override
            protected Void doInBackground() {
                simulator.run();
                return null;
            }

            @Override
            public void done() {
                instructionList.setSelectedIndex(simulator.getPC()/4);
            }
        }.execute();
    }
}
