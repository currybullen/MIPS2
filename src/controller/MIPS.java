package controller;

import model.*;
import model.InstructionMemory;
import view.GUI;

import java.util.Random;

/**
 * A program mimicking a MIPS processor using a simplified model. Included
 * components include instruction memory, data memory, registers, ALU, ALU
 * control, pc and the add unit. Supported instructions are add, sub, and, or,
 * nor, slt, lw, sw, beq and nop.
 */
public class MIPS {
    private final InstructionMemory instructionMemory;
    private final Registers registers;
    private final DataMemory dataMemory;
    private final Simulator simulator;

    /**
     * Constructs a MIPS object.
     * @param fileName the name of a local file containing a set of
     *                 instructions.
     */
    public MIPS(String fileName) {
        /*A parser for the instruction file is created.*/
        InstructionParser instructionParser = new InstructionParser(new
                FileParser(fileName));

        /*The instruction memory, registers and data memory are set up.*/
        instructionMemory = new InstructionMemory(instructionParser);
        registers = new Registers();
        dataMemory = new DataMemory(1000);

        /*A simulator is created from the above.*/
        simulator = new Simulator(instructionMemory, registers,
                dataMemory);

        //TO BE REMOVED.
        initializeRegisters();

        /*The GUI is set up.*/
        setUpGUI();
    }

    public static void main(String[] args) {
        new MIPS(args[0]);
    }

    //Test function, to be removed.
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

    /*Internal help function to set up the GUI.*/
    private void setUpGUI() {

        /*A GUI is created.*/
        GUI gui = new GUI();

        /*The instruction memory, registers and data memory are list models
        * in themselves, they are connected to their corresponding JList
        * components.*/
        gui.getInstructionList().setModel(instructionMemory);
        gui.getRegisterList().setModel(registers);
        gui.getMemoryList().setModel(dataMemory);

        /*A listener is set to the step button.*/
        gui.getStepButton().addActionListener(new StepButtonListener(simulator,
                gui.getInstructionList(), gui.getPCLabel()));

        /*A listener is set to the change base button.*/
        ChangeBaseButtonListener changeBaseButtonListener =
                new ChangeBaseButtonListener(gui.getChangeBaseButton());
        gui.getChangeBaseButton().addActionListener(changeBaseButtonListener);

        /*A listener is set to the run button.*/
        RunButtonListener runButtonListener = new RunButtonListener(simulator,
                gui.getInstructionList(), gui.getRunButton(),
                gui.getStepButton(), gui.getPCLabel());
        gui.getRunButton().addActionListener(runButtonListener);

        /*A listener is et to the reset button.*/
        gui.getResetButton().addActionListener(
                new ResetButtonListener(runButtonListener, simulator,
                        gui.getInstructionList(), gui.getPCLabel()));

        /*Observers are added to the change base button listener to be able
        * to switch the base in a quick fashion.*/
        changeBaseButtonListener.addObserver(instructionMemory);
        changeBaseButtonListener.addObserver(registers);
        changeBaseButtonListener.addObserver(dataMemory);

        /*Set the selected index of the instruction list to zero.*/
        gui.getInstructionList().setSelectedIndex(0);

        /*Display the GUI.*/
        gui.setVisible(true);
    }
}
