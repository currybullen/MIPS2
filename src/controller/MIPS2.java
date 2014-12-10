package controller;

import model.InstructionMemory;
import model.InstructionMemory;
import model.RegisterLabels;
import model.Registers;

import java.util.Random;

/**
 * Created by currybullen on 2014-12-06.
 */
public class MIPS2 {
    private InstructionMemory instructionMemory;
    private Registers registers;

    public MIPS2(String fileName) {
        InstructionParser instructionParser = new InstructionParser(new
                FileParser(fileName));
        instructionMemory = new InstructionMemory(instructionParser);
    }

    public static void main(String[] args) {
        new MIPS2(args[0]).go();
    }

    private void go() {
        registers = new Registers();
        testInitializeRegisters();
        testPrintRegisters();
        //testPrint();
    }

    private void testPrint() {
        for (int i = 0; i < instructionMemory.size(); i++) {
            String mnemonic = instructionMemory.getInstruction(4*i).
                    getMnemonic();
            String decomposed = instructionMemory.getInstruction(4*i).
                    getDecomposedString();
            System.out.println("Mnemonic: " + mnemonic + " " + "Decomposed: " +
                    decomposed);
        }
    }

    private void testPrintRegisters() {
        for (int i = 0; i < 32; i++) {
            System.out.println("Register " + i + ": " + registers.
                    getRegister(i));
        }
    }

    private void testInitializeRegisters() {
        Random random = new Random();
        for(int i = 0; i < 32; i++) {
            int randomNumber = random.nextInt(Integer.MAX_VALUE);
            if (random.nextInt(2) == 1) {
                randomNumber = -randomNumber;
            }
            registers.setRegister(i, randomNumber);
        }
    }
}
