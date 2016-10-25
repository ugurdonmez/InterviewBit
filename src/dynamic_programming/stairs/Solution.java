package dynamic_programming.stairs;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by ugurdonmez on 06/09/16.
 */
public class Solution {

    public static int climbStairs(int step) {

        Map<Integer, Integer> map = new HashMap<>();

        return climbHelper(step, map);
    }

    public static int climbHelper(int step, Map<Integer, Integer> map) {
        if (map.containsKey(step)) {
            return map.get(step);
        }

        if (step == 0) {
            return 1;
        }

        if (step < 0) {
            return 0;
        }

        int sum = climbHelper(step-1, map) + climbHelper(step-2, map);

        map.put(step, sum);

        return sum;
    }
}
