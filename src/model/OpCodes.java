package model;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * A class containing op codes for different supported instructions.
 */
public class OpCodes {
    private static final Map<Integer, Integer> map;
    public static final int LW = 35;
    public static final int SW = 43;
    public static final int BEQ = 4;

    /*The instruction codes are mapped to the instruction types.*/
    static {
        Map<Integer, Integer> tempMap = new HashMap<Integer,Integer>();
        tempMap.put(InstructionTypes.LW, 35);
        tempMap.put(InstructionTypes.SW, 43);
        tempMap.put(InstructionTypes.BEQ, 4);
        map = Collections.unmodifiableMap(tempMap);
    }

    /**
     * Returns the op code for the given instruction type.
     * @param type the instruction type.
     * @return the op code.
     */
    public static int get(int type) {
        return map.get(type);
    }
}
