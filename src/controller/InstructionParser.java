package controller;

import model.Instruction;
import model.RegisterLabels;

import java.util.StringTokenizer;

/**
 * Created by currybullen on 2014-12-07.
 */
public class InstructionParser {
    private FileParser fileParser;

    public InstructionParser(FileParser fileParser) {
        this.fileParser = fileParser;
    }

    public Instruction nextInstruction() {
        String line;

        if ((line = fileParser.nextLine()) == null) {
            return null;
        } else {
            return parseInstruction(line);
        }
    }

    private Instruction parseInstruction(String mnemonic) {
        StringTokenizer tokenizedLine = new StringTokenizer(mnemonic, " ,");
        String type = tokenizedLine.nextToken();
        int decomposed[] = null;
        if (type.equals("add")) {
            int rd = RegisterLabels.get(tokenizedLine.nextToken());
            int rs = RegisterLabels.get(tokenizedLine.nextToken());
            int rt = RegisterLabels.get(tokenizedLine.nextToken());
            decomposed = new int[]{0, rs, rt, rd, 32};
        } else if (type.equals("sub")) {
            int rd = RegisterLabels.get(tokenizedLine.nextToken());
            int rs = RegisterLabels.get(tokenizedLine.nextToken());
            int rt = RegisterLabels.get(tokenizedLine.nextToken());
            decomposed = new int[]{0, rs, rt, rd, 34};
        } else if (type.equals("and")) {
            int rd = RegisterLabels.get(tokenizedLine.nextToken());
            int rs = RegisterLabels.get(tokenizedLine.nextToken());
            int rt = RegisterLabels.get(tokenizedLine.nextToken());
            decomposed = new int[]{0, rs, rt, rd, 36};
        } else if (type.equals("or")) {

        } else if (type.equals("nor")) {

        } else if (type.equals("slt")) {

        } else if (type.equals("lw")) {

        } else if (type.equals("sw")) {

        } else if (type.equals("beq")) {

        } else if (type.equals("nop")) {

        }
        return new Instruction(mnemonic, decomposed);
    }

    private int[] getRegisters(StringTokenizer tokenizedLine,) {

    }
}
