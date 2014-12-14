package model;

import controller.InstructionParser;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

/**
 * A class mimicking the instruction memory of a MIPS processor. Extends the
 * AbstractListModel for the sake of accessing it through a GUI. Implements
 * the Observer interface to easily switch from hexadecimal format to decimal
 * and back.
 */
public class InstructionMemory extends AbstractListModel<String>
        implements Observer {
    private final ArrayList<Instruction> memory;

    /**
     * Creates an instruction memory object.
     * @param instructionParser a reference to an instruction parser to
     *                          fetch instructions from.
     */
    public InstructionMemory(InstructionParser instructionParser) {
        memory = new ArrayList<>();
        Instruction instruction;
        while ((instruction = instructionParser.nextInstruction()) != null) {
            memory.add(instruction);
        }
    }

    /**
     * Returns the instruction at the given address.
     * @param address the address of the instruction.
     * @return the isntruction at the given address.
     */
    public Instruction getInstruction(int address) {
        return memory.get(address/4);
    }

    /*Returns the size of the data memory.*/
    @Override
    public int getSize() {
        return memory.size();
    }

    @Override
    public String getElementAt(int index) {
        Instruction instruction = memory.get(index);
        String element = instruction.getMnemonic() + " |";
        if (SimulatorSettings.showHexadecimal) {
            for (int i = 0; i < instruction.getDecomposed().length; i++) {
                element += " " + Integer.toHexString(instruction.
                        getDecomposed()[i]);
            }
        } else {
            for (int i = 0; i < instruction.getDecomposed().length; i++) {
                element += " " + instruction.getDecomposed()[i];
            }
        }
        return element;
    }

    /*Executed when the user presses the change base button to update the
    * entire list of changed values.*/
    @Override
    public void update(Observable observable, Object object) {
        fireContentsChanged(this, 0, getSize()-1);
    }
}
