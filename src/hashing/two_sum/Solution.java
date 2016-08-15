package hashing.two_sum;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by ugurdonmez on 14/08/16.
 */
public class Solution {

    public static void main(String [] args) {



    }

    public ArrayList<Integer> twoSum(final List<Integer> list, int number) {

        ArrayList<Integer> result = new ArrayList<>();

        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < list.size(); i++) {

            if (map.containsKey(number - list.get(i))) {
                result.add(map.get(number - list.get(i)) + 1);
                result.add(i+1);
                return result;
            }

            if (!map.containsKey(list.get(i))) {
                map.put(list.get(i), i);
            }

        }

        return result;

    }
}
