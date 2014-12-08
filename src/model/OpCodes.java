package model;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by c12mkn on 2014-12-08.
 */
public class OpCodes {
    private static final Map<Integer, Integer> map;
    public static final int LW = 35;
    public static final int SW = 43;
    public static final int BEQ = 4;

    static {
        Map<Integer, Integer> tempMap = new HashMap<Integer,Integer>();
        tempMap.put(InstructionTypes.LW, 35);
        tempMap.put(InstructionTypes.SW, 43);
        tempMap.put(InstructionTypes.BEQ, 4);
        map = Collections.unmodifiableMap(tempMap);
    }

    public static int get(int type) {
        return map.get(type);
    }
}
