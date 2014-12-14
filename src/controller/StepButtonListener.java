package controller;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


/**
 * A class defining behaviour for when the user presses the step button.
 */
public class StepButtonListener implements ActionListener {
    private final Simulator simulator;
    private final JList instructionList;
    private final JLabel pcLabel;

    /**
     * Constructs a StepButtonListener.
     * @param simulator a reference to a simulator.
     * @param instructionList a reference to an instruction list (JList).
     * @param pcLabel a reference to the pc JLabel.
     */
    public StepButtonListener(Simulator simulator, JList instructionList,
                              JLabel pcLabel) {
        this.simulator = simulator;
        this.instructionList = instructionList;
        this.pcLabel = pcLabel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        new SwingWorker<Void, Void>() {
            @Override
            protected Void doInBackground() {

                /*Execute one step of the simulation.*/
                simulator.step();
                return null;
            }

            @Override
            public void done() {

                /*When done, update the selected instruction in the GUI.*/
                instructionList.setSelectedIndex(simulator.getPC()/4);
                pcLabel.setText("PC: " + simulator.getPC());
            }

        }.execute();
    }
}
