package model;

import controller.InstructionParser;

import java.util.ArrayList;

/**
 * Created by c12mkn on 2014-12-08.
 */
public class InstructionMemory extends InstuctionMemory {
    private ArrayList<Instruction> memory;

    public InstructionMemory(InstructionParser instructionParser) {
        memory = new ArrayList<Instruction>();
        Instruction instruction;
        while ((instruction = instructionParser.nextInstruction()) != null) {
            memory.add(instruction);
        }
    }

    public Instruction getInstruction(int index) {
        return memory.get(index);
    }

    public int size() {
        return memory.size();
    }
}
