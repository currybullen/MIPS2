package controller;

import model.*;
import model.InstructionMemory;
import view.GUI;

import java.util.Random;

/**
 * Created by currybullen on 2014-12-06.
 */
public class MIPS {
    private InstructionMemory instructionMemory;
    private Registers registers;
    private DataMemory dataMemory;
    private Simulator simulator;

    public MIPS(String fileName) {
        InstructionParser instructionParser = new InstructionParser(new
                FileParser(fileName));
        instructionMemory = new InstructionMemory(instructionParser);
        registers = new Registers();
        dataMemory = new DataMemory(1000);
        simulator = new Simulator(instructionMemory, registers, dataMemory);
    }

    public static void main(String[] args) {
        new MIPS(args[0]).go();
    }

    private void go() {
        initializeRegisters();
        setUpGUI();
    }

    //Test function
    private void initializeRegisters() {
        Random random = new Random();
        for(int i = 0; i < 32; i++) {
            int randomNumber = random.nextInt(100);
            if (random.nextInt(2) == 1) {
                randomNumber = -randomNumber;
            }
            registers.setRegister(i, randomNumber);
        }
    }

    private void setUpGUI() {
        GUI gui = new GUI();

        //Create models for the lists.

        //Connect the models to the lists.
        gui.getInstructionList().setModel(instructionMemory);
        gui.getRegisterList().setModel(registers);
        gui.getMemoryList().setModel(dataMemory);

        //Set listeners for the buttons.
        gui.getStepButton().addActionListener(new StepButtonListener(simulator,
                gui.getInstructionList()));
        ChangeBaseButtonListener changeBaseButtonListener =
                new ChangeBaseButtonListener(gui.getChangeBaseButton());
        gui.getChangeBaseButton().addActionListener(changeBaseButtonListener);
        gui.getRunButton().addActionListener(new RunButtonListener(simulator,
                gui.getInstructionList()));
        gui.getResetButton().addActionListener(
                new ResetButtonListener(simulator));

        //Add observers to the listeners.
        changeBaseButtonListener.addObserver(instructionMemory);
        changeBaseButtonListener.addObserver(registers);
        changeBaseButtonListener.addObserver(dataMemory);

        gui.getInstructionList().setSelectedIndex(0);
        gui.setVisible(true);
    }
}
