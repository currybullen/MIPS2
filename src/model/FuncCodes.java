package model;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by c12mkn on 2014-12-08.
 */
public class FuncCodes {
    private static final Map<Integer, Integer> map;

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

    public static int get(int type) {
        return map.get(type);
    }
}
