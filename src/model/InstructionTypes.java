package model;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * Gives all of the instructions a corresponding integer type for easy
 * recognition.
 */
public class InstructionTypes {
    private static final Map<String, Integer> map;

    public static final int ADD = 0;
    public static final int SUB = 1;
    public static final int AND = 2;
    public static final int OR = 3;
    public static final int NOR = 4;
    public static final int SLT = 5;
    public static final int LW = 6;
    public static final int SW = 7;
    public static final int BEQ = 8;
    public static final int NOP = 9;
    public static final int EXIT = 10;

    /*A hash map of the instruction types is created so that they can easily
    * be extracted using the name.*/
    static {
        Map<String, Integer> tempMap = new HashMap<String,Integer>();
        tempMap.put("add", ADD);
        tempMap.put("sub", SUB);
        tempMap.put("and", AND);
        tempMap.put("or", OR);
        tempMap.put("nor", NOR);
        tempMap.put("slt", SLT);
        tempMap.put("lw", LW);
        tempMap.put("sw", SW);
        tempMap.put("beq", BEQ);
        tempMap.put("nop", NOP);
        tempMap.put("exit", EXIT);
        map = Collections.unmodifiableMap(tempMap);
    }

    /**
     * Returns the type of instruction given its name or label (e.g. add).
     * @param label essentially the name of the instruction.
     * @return the instruction type.
     */
    public static int get(String label) {
        return map.get(label);
    }
}
