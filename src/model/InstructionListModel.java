package model;

import javax.swing.*;

/**
 * Created by c12mkn on 2014-12-11.
 */
public class InstructionListModel extends AbstractListModel {
    private InstructionMemory instructionMemory;

    public InstructionListModel(InstructionMemory instructionMemory) {
        this.instructionMemory = instructionMemory;
    }

    @Override
    public int getSize() {
        return instructionMemory.size();
    }

    @Override
    public Object getElementAt(int index) {
        Instruction instruction = instructionMemory.getInstruction(index*4);
        String element = instruction.getMnemonic();
        if (SimulatorSettings.showHexadecimal) {
            for (int i = 0; i < instruction.getDecomposed().length; i++) {
                element += " " + Integer.toHexString(instruction.
                        getDecomposed()[i]);
            }
        } else {
            element += " " + instruction.getDecomposedString();
        }
        return element;
    }
}
