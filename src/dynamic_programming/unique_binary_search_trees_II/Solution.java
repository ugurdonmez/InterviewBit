package dynamic_programming.unique_binary_search_trees_II;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by ugurdonmez on 08/09/16.
 */
public class Solution {

    public int numTrees(int a) {

        Map<Integer, Integer> map = new HashMap<>();

        map.put(0, 1);
        map.put(1, 1);

        return numTreesHelper(a, map);
    }

    public int numTreesHelper(int size, Map<Integer, Integer> map) {

        if (map.containsKey(size)) {
            return map.get(size);
        }

        int sum = 0;

        for (int i = 0; i < size; i++) {
            sum += numTreesHelper(i, map) * numTreesHelper(size - i - 1, map);
        }

        map.put(size, sum);

        return sum;
    }

}
