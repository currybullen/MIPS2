package model;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by currybullen on 2014-12-07.
 */
public class RegisterLabels {
    private static final Map<String, Integer> map;

    static {
        Map<String, Integer> tempMap = new HashMap<String,Integer>();
        tempMap.put("$zero", 0);
        tempMap.put("$at", 1);
        tempMap.put("$v0", 2);
        tempMap.put("$v1", 3);
        tempMap.put("$a0", 4);
        tempMap.put("$a1", 5);
        tempMap.put("$a2", 6);
        tempMap.put("$a3", 7);
        tempMap.put("$t0", 8);
        tempMap.put("$t1", 9);
        tempMap.put("$t2", 10);
        tempMap.put("$t3", 11);
        tempMap.put("$t4", 12);
        tempMap.put("$t5", 13);
        tempMap.put("$t6", 14);
        tempMap.put("$t7", 15);
        tempMap.put("$s0", 16);
        tempMap.put("$s1", 17);
        tempMap.put("$s2", 18);
        tempMap.put("$s3", 19);
        tempMap.put("$s4", 20);
        tempMap.put("$s5", 21);
        tempMap.put("$s6", 22);
        tempMap.put("$s7", 23);
        tempMap.put("$t8", 24);
        tempMap.put("$t9", 25);
        tempMap.put("$k0", 26);
        tempMap.put("$k1", 27);
        tempMap.put("$gp", 28);
        tempMap.put("$sp", 29);
        tempMap.put("$fp", 30);
        tempMap.put("$ra", 31);
        map = Collections.unmodifiableMap(tempMap);
    }

    public static int get(String label) {
        return map.get(label);
    }
}
