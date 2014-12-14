package model;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * A class of function codes for different R-format instructions.
 */
public class FuncCodes {
    private static final Map<Integer, Integer> map;

    /*A map of function codes corresponding to instruction types is created.*/
    static {
        Map<Integer, Integer> tempMap = new HashMap<Integer,Integer>();
        tempMap.put(InstructionTypes.ADD, 32);
        tempMap.put(InstructionTypes.SUB, 34);
        tempMap.put(InstructionTypes.AND, 36);
        tempMap.put(InstructionTypes.OR, 37);
        tempMap.put(InstructionTypes.NOR, 39);
        tempMap.put(InstructionTypes.SLT, 42);
        map = Collections.unmodifiableMap(tempMap);
    }

    /*Returns the function code given the instruction.*/
    public static int get(int type) {
        return map.get(type);
    }
}
