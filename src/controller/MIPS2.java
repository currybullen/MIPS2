package controller;

import model.*;
import model.InstructionMemory;
import view.GUI;

import java.util.Random;

/**
 * Created by currybullen on 2014-12-06.
 */
public class MIPS2 {
    private InstructionMemory instructionMemory;
    private Registers registers;
    private DataMemory dataMemory;
    private Simulator simulator;

    public MIPS2(String fileName) {
        InstructionParser instructionParser = new InstructionParser(new
                FileParser(fileName));
        instructionMemory = new InstructionMemory(
                instructionParser);
        registers = new Registers();
        dataMemory = new DataMemory(1000);
        simulator = new Simulator(instructionMemory, registers, dataMemory);
    }

    public static void main(String[] args) {
        new MIPS2(args[0]).go();
    }

    private void go() {
        initializeRegisters();
        setUpGUI();
    }

    //Test function
    private void initializeRegisters() {
        Random random = new Random();
        for(int i = 0; i < 32; i++) {
            int randomNumber = random.nextInt(Integer.MAX_VALUE);
            if (random.nextInt(2) == 1) {
                randomNumber = -randomNumber;
            }
            registers.setRegister(i, randomNumber);
        }
    }

    private void setUpGUI() {
        GUI gui = new GUI();

        //Create models for the lists.
        InstructionListModel instructionListModel = new
                InstructionListModel(instructionMemory);
        RegisterListModel registerListModel = new RegisterListModel(registers);
        MemoryListModel memoryListModel = new MemoryListModel(dataMemory.
                size());

        //Connect the models to the lists.
        gui.getInstructionList().setModel(instructionListModel);
        gui.getRegisterList().setModel(registerListModel);
        gui.getMemoryList().setModel(memoryListModel);

        //Set listeners for the buttons.
        gui.getStepButton().addActionListener(new StepButtonListener(simulator,
                gui.getInstructionList()));
        ChangeBaseButtonListener changeBaseButtonListener =
                new ChangeBaseButtonListener(gui.getChangeBaseButton());
        gui.getChangeBaseButton().addActionListener(changeBaseButtonListener);
        gui.getRunButton().addActionListener(new StepButtonListener(simulator, gui.getInstructionList()));

        //Add observers to the listeners.
        changeBaseButtonListener.addObserver(instructionListModel);
        changeBaseButtonListener.addObserver(registerListModel);
        changeBaseButtonListener.addObserver(memoryListModel);

        gui.getInstructionList().setSelectedIndex(0);
        gui.setVisible(true);
    }
}
