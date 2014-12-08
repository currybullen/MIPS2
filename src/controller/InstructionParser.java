package controller;

import model.*;

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
        StringTokenizer tokenizedLine = new StringTokenizer(mnemonic, " ,()");
        String nextLine = tokenizedLine.nextToken();
        int type = InstructionTypes.get(nextLine);
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
                instruction = new Instruction(mnemonic, type, 0, rs, rt, rd, 0, FuncCodes.get(type));
                break;
            case InstructionTypes.LW:
            case InstructionTypes.SW:
                rt = RegisterLabels.get(tokenizedLine.nextToken());
                offset = 0;
                if (tokenizedLine.countTokens() == 2) {
                    offset = Integer.parseInt(tokenizedLine.nextToken());
                }
                rs = RegisterLabels.get(tokenizedLine.nextToken());
                instruction = new Instruction(mnemonic, type, OpCodes.get(type), rs, rt, offset);
                break;
            case InstructionTypes.BEQ:
                rs = RegisterLabels.get(tokenizedLine.nextToken());
                rt = RegisterLabels.get(tokenizedLine.nextToken());
                label = Integer.parseInt(tokenizedLine.nextToken());
                instruction = new Instruction(mnemonic, type, OpCodes.get(type), rs, rt, label);
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
