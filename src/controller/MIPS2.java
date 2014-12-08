package controller;

import model.InstructionMemory;
import model.InstuctionMemory;
import model.RegisterLabels;

/**
 * Created by currybullen on 2014-12-06.
 */
public class MIPS2 {
    private InstructionMemory instructionMemory;

    public MIPS2(String fileName) {
        InstructionParser instructionParser = new InstructionParser(new
                FileParser(fileName));
        instructionMemory = new InstructionMemory(instructionParser);
    }

    public static void main(String[] args) {
        new MIPS2(args[0]).go();
    }

    private void go() {
        testPrint();
    }

    private void testPrint() {
        for (int i = 0; i < instructionMemory.size(); i++) {
            String mnemonic = instructionMemory.getInstruction(i).getMnemonic();
            String decomposed = instructionMemory.getInstruction(i).getDecomposedString();
            System.out.println("Mnemonic: " + mnemonic + " " + "Decomposed: " + decomposed);
        }
    }
}
