package view;

import javax.swing.*;
import java.awt.*;

/**
 * The GUI class for the MIPS processor.
 */
public class GUI extends JFrame {
    private static final long serialVersionUID = 1L;

    private JLabel pcLabel;

    private JList instructionList;
    private JList registerList;
    private JList memoryList;

    private JButton stepButton;
    private JButton runButton;
    private JButton resetButton;
    private JButton changeBaseButton;

    /**
     * Constructs a MIPS GUI.
     */
    public GUI() {

        /*Set the name of the window.*/
        super("MIPS Simulator");

        /*Default close operation and sizing options.*/
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(true);
        setSize(800,500);

        /*Initialize the pc counter.*/
        pcLabel = new JLabel("PC: 0");

        /*Create the lists.*/
        instructionList = new JList();
        registerList = new JList();
        memoryList = new JList();

        /*Keep the user from interacting with the lists directly.*/
        instructionList.setEnabled(false);
        registerList.setEnabled(false);
        memoryList.setEnabled(false);

        /*Add the pc label to the frame.*/
        add(pcLabel, BorderLayout.NORTH);

        /*Create a center panel for the lists.*/
        JPanel centerPanel = new JPanel(new GridLayout(1,3));

        /*Add the lists to the center panel wrapped in scroll panes.*/
        centerPanel.add(new JScrollPane(instructionList));
        centerPanel.add(new JScrollPane(registerList));
        centerPanel.add(new JScrollPane(memoryList));
        add(centerPanel, BorderLayout.CENTER);

        /*Create a bottom panel for the buttons.*/
        JPanel bottomPanel = new JPanel();

        /*Add the buttons to the bottom panel.*/
        bottomPanel.add((stepButton = new JButton("Step")));
        bottomPanel.add((runButton = new JButton("Run")));
        bottomPanel.add((resetButton = new JButton("Reset")));
        bottomPanel.add((changeBaseButton) = new JButton("Switch to " +
                "hexadecimal"));

        /*Add the bottom panel to the frame.*/
        add(bottomPanel, BorderLayout.SOUTH);
    }

    /**
     * Returns the instruction JList.
     * @return the instruction JList.
     */
    public JList getInstructionList() {
        return instructionList;
    }

    /**
     * Returns the register JList.
     * @return the register JList.
     */
    public JList getRegisterList() {
        return registerList;
    }

    /**
     * Returns the data memory JLIst.
     * @return the data memory JList.
     */
    public JList getMemoryList() {
        return memoryList;
    }

    /**
     * Returns the step JButton.
     * @return the step JButton.
     */
    public JButton getStepButton() {
        return stepButton;
    }

    /**
     * Returns the change base JButton.
     * @return the change base JButton.
     */
    public JButton getChangeBaseButton() {
        return changeBaseButton;
    }

    /**
     * Returns the run JButton.
     * @return
     */
    public JButton getRunButton() {
        return runButton;
    }

    /**
     * Returns the reset JButton.
     * @return the reset JButton.
     */
    public JButton getResetButton() {
        return resetButton;
    }

    /**
     * Returns the PC JLabel.
     * @return the PC Jlabel.
     */
    public JLabel getPCLabel() {
        return pcLabel;
    }
}
