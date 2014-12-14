package controller;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


/**
 * A class defining behaviour for when the user presses the reset button.
 */
public class ResetButtonListener implements ActionListener {
    private final RunButtonListener runButtonListener;
    private final Simulator simulator;
    private final JList instructionList;
    private final JLabel pcLabel;

    /**
     * Constructs a ResetButtonListener.
     * @param runButtonListener a reference to the run button listener.
     * @param simulator a reference to a simulator.
     * @param instructionList a reference to the instruction JList.
     * @param pcLabel a reference to the pc JLabel.
     */
    public ResetButtonListener(RunButtonListener runButtonListener,
                               Simulator simulator, JList instructionList,
                               JLabel pcLabel) {
        this.runButtonListener = runButtonListener;
        this.simulator = simulator;
        this.instructionList = instructionList;
        this.pcLabel = pcLabel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        /*When the user presses the reset button, interrupt the running
        * simulator thread.*/
        runButtonListener.interrupt();

        /*Also reset all of the values.*/
        simulator.reset();

        instructionList.setSelectedIndex(0);
        pcLabel.setText("PC: 0");
    }
}
