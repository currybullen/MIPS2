package model;

import controller.InstructionParser;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

/**
 * Created by c12mkn on 2014-12-08.
 */
public class InstructionMemory extends AbstractListModel implements Observer {
    private ArrayList<Instruction> memory;

    public InstructionMemory(InstructionParser instructionParser) {
        memory = new ArrayList<Instruction>();
        Instruction instruction;
        while ((instruction = instructionParser.nextInstruction()) != null) {
            memory.add(instruction);
        }
    }

    public Instruction getInstruction(int index) {
        return memory.get(index/4);
    }

    @Override
    public int getSize() {
        return memory.size();
    }

    @Override
    public Object getElementAt(int index) {
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

    @Override
    public void update(Observable observable, Object object) {
        fireContentsChanged(this, 0, getSize()-1);
    }
}
