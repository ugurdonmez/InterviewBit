package heaps_and_maps.distinct_numbers_in_window;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

/**
 * Created by ugurdonmez on 20/08/16.
 */
public class Solution {

    public static void main(String [] args) {

        int [] array = {1, 2, 1, 3, 4, 3};

        ArrayList<Integer> list = new ArrayList<>();

        IntStream.of(array).forEach(list::add);

        System.out.println(dNums(list, 3));

    }

    public static ArrayList<Integer> dNums(ArrayList<Integer> list, int size) {

        ArrayList<Integer> result = new ArrayList<>();

        if (size > list.size()) {
            return result;
        }

        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < size; i++) {
            if (map.containsKey(list.get(i))) {
                map.put(list.get(i), 1 + map.get(list.get(i)));
            } else {
                map.put(list.get(i), 1);
            }
        }

        result.add(map.size());

        for (int i = size; i < list.size(); i++) {
            // remove i - 1
            if (map.get(list.get(i-size)) == 1) {
                map.remove(list.get(i-size));
            } else {
                map.put(list.get(i-size), map.get(list.get(i-size))-1);
            }

            // put new
            if (map.containsKey(list.get(i))) {
                map.put(list.get(i), 1 + map.get(list.get(i)));
            } else {
                map.put(list.get(i), 1);
            }

            result.add(map.size());
        }

        return result;
    }
}