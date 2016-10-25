package greedy.majority_element;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by ugurdonmez on 04/09/16.
 */
public class Solution {

    public static void main(String [] args) {

    }

    public int majorityElement(ArrayList<Integer> nums) {

        Map<Integer, Integer> map = new HashMap<>();

        for (int a : nums) {
            if (map.containsKey(a)) {
                map.put(a, map.get(a) + 1);
            } else {
                map.put(a, 1);
            }
        }

        Iterator<Map.Entry<Integer, Integer>> it = map.entrySet().iterator();

        while (it.hasNext()) {
            Map.Entry<Integer, Integer> entry = it.next();

            if (entry.getValue() > nums.size() / 2) {
                return entry.getKey();
            }
        }

        return 0;
    }
}
