package view;

import javax.swing.*;
import java.awt.*;

/**
 * Created by c12mkn on 2014-12-11.
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

    public GUI() {
        super("MIPS Simulator");

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(true);
        setSize(800,500);

        pcLabel = new JLabel("PC: 0");

        instructionList = new JList();
        registerList = new JList();
        memoryList = new JList();

        instructionList.setEnabled(false);
        registerList.setEnabled(false);
        memoryList.setEnabled(false);

        add(pcLabel, BorderLayout.NORTH);

        add(new JScrollPane(instructionList), BorderLayout.WEST);
        add(new JScrollPane(registerList), BorderLayout.CENTER);
        add(new JScrollPane(memoryList), BorderLayout.EAST);

        JPanel bottomPanel = new JPanel();

        bottomPanel.add((stepButton = new JButton("Step")));
        bottomPanel.add((runButton = new JButton("Run")));
        bottomPanel.add((resetButton = new JButton("Reset")));
        bottomPanel.add((changeBaseButton) = new JButton("Switch to " +
                "hexadecimal"));
        add(bottomPanel, BorderLayout.SOUTH);
    }

    public JList getInstructionList() {
        return instructionList;
    }

    public JList getRegisterList() {
        return registerList;
    }

    public JList getMemoryList() {
        return memoryList;
    }

    public JButton getStepButton() {
        return stepButton;
    }

    public JButton getChangeBaseButton() {
        return changeBaseButton;
    }

    public JButton getRunButton() {
        return runButton;
    }

    public JButton getResetButton() {
        return resetButton;
    }

    public void setPC(int count) {
        pcLabel.setText("PC: " + count);
    }
}
