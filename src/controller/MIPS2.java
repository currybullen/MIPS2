package controller;

import model.InstuctionMemory;
import model.RegisterLabels;

/**
 * Created by currybullen on 2014-12-06.
 */
public class MIPS2 {
    private InstuctionMemory instructionMemory;

    public MIPS2(String fileName) {
        /*InstructionParser instructionParser = new InstructionParser(new
                FileParser(fileName));
        instructionMemory = new InstructionMemory(instructionParser);*/
    }

    public static void main(String[] args) {
        System.out.println(RegisterLabels.get("$v0"));
    }

    private void go() {
    }
}
