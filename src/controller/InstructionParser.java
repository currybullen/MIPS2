package controller;

import model.*;

import java.util.StringTokenizer;

/**
 * A class used to parse instructions to be later stored in an instruction
 * memory.
 */
public class InstructionParser {
    private FileParser fileParser;

    /**
     * Constructs an InstructionParser.
     * @param fileParser a FileParser linked to a text file of instructions.
     */
    public InstructionParser(FileParser fileParser) {
        this.fileParser = fileParser;
    }

    /**
     * Returns the next instruction parsed by the file parser.
     * @return the next instruction parsed by the file parser. Returns null
     * if there are no more instructions to parse.
     */
    public Instruction nextInstruction() {
        String line;

        if ((line = fileParser.nextLine()) == null) {
            return null;
        } else {
            return parseInstruction(line);
        }
    }

    /**
     * Parses an instruction from its mnemonic format.
     * @param mnemonic the mnemonic format of the instruction.
     * @return an Instruction object corresponding to the supplied mnemonic
     * string.
     */
    private Instruction parseInstruction(String mnemonic) {

        /*Split the mnemonic string.*/
        StringTokenizer tokenizedLine = new StringTokenizer(mnemonic, " ,()");

        /*Get the type of instruction.*/
        int type = InstructionTypes.get(tokenizedLine.nextToken());

        /*Parse the instruction differently depending on its type.*/
        Instruction instruction;
        int rd, rs, rt, offset, label;
        switch(type) {
            case InstructionTypes.ADD:
            case InstructionTypes.SUB:
            case InstructionTypes.AND:
            case InstructionTypes.OR:
            case InstructionTypes.NOR:
            case InstructionTypes.SLT:
                rd = RegisterLabels.get(tokenizedLine.nextToken());
                rs = RegisterLabels.get(tokenizedLine.nextToken());
                rt = RegisterLabels.get(tokenizedLine.nextToken());
                instruction = new Instruction(mnemonic, type, 0, rs, rt, rd, 0,
                        FuncCodes.get(type));
                break;
            case InstructionTypes.LW:
            case InstructionTypes.SW:
                rt = RegisterLabels.get(tokenizedLine.nextToken());
                offset = 0;
                if (tokenizedLine.countTokens() == 2) {
                    offset = Integer.parseInt(tokenizedLine.nextToken());
                }
                rs = RegisterLabels.get(tokenizedLine.nextToken());
                instruction = new Instruction(mnemonic, type, OpCodes.get(type),
                        rs, rt, offset);
                break;
            case InstructionTypes.BEQ:
                rs = RegisterLabels.get(tokenizedLine.nextToken());
                rt = RegisterLabels.get(tokenizedLine.nextToken());
                label = Integer.parseInt(tokenizedLine.nextToken());
                instruction = new Instruction(mnemonic, type, OpCodes.get(type),
                        rs, rt, label);
                break;
            case InstructionTypes.NOP:
                instruction = new Instruction(mnemonic, type, 0, 0, 0, 0, 0, 0);
                break;
            case InstructionTypes.EXIT:
                instruction = new Instruction(mnemonic, type);
                break;
            default:
                instruction = null;
        }

        return instruction;
    }

}
