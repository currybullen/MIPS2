package controller;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * A listener class defining behaviour for when the user presses the run
 * button.
 */
public class RunButtonListener implements ActionListener {
    private final Simulator simulator;
    private final JList instructionList;
    private final JButton runButton;
    private final JButton stepButton;
    private final JLabel pcLabel;
    private SwingWorker<Void, Void> swingWorker;

    /**
     * Constructs a RunButtonListener.
     * @param simulator a Simulator object.
     * @param instructionList a JList representing the list of instructions.
     * @param runButton a reference to the GUI run button.
     * @param stepButton a reference to the GUI step button.
     * @param pcLabel a reference to the pc JLabel.
     */
    public RunButtonListener(Simulator simulator, JList instructionList,
                             JButton runButton, JButton stepButton,
                             JLabel pcLabel) {
        this.simulator = simulator;
        this.instructionList = instructionList;
        this.runButton = runButton;
        this.stepButton = stepButton;
        this.pcLabel = pcLabel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        runButton.setEnabled(false);
        stepButton.setEnabled(false);

        swingWorker = new SwingWorker<Void, Void>() {
            @Override
            public Void doInBackground() {
                while (!isCancelled()) {
                    if (simulator.step() == -1) {
                        break;
                    }
                }
                return null;
            }

            @Override
            public void done() {
                instructionList.setSelectedIndex(simulator.getPC()/4);
                runButton.setEnabled(true);
                stepButton.setEnabled(true);
                pcLabel.setText("PC: " + simulator.getPC());
            }
        };

        swingWorker.execute();
    }

    /**
     * Interrupts the running execution if it is actually running.
     */
    public void interrupt() {
        if (swingWorker != null && (!swingWorker.isCancelled() ||
                !swingWorker.isDone())) {
            swingWorker.cancel(true);
            runButton.setEnabled(true);
            stepButton.setEnabled(true);
        }
    }
}
