package math.rearrange_array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by user on 08/08/16.
 */
public class Solution {

    public static void main(String [] args) {

        ArrayList<Integer> list = new ArrayList<>();

        list.add(4);
        list.add(0);
        list.add(2);
        list.add(1);
        list.add(3);

        arrange(list);

        System.out.println(list);
    }

    public static void arrange(ArrayList<Integer> a) {

        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < a.size(); i++) {
            map.put(i, a.get(a.get(i)));
        }

        for (int i = 0; i < a.size(); i++) {
            a.set(i, map.get(i));
        }
    }

}
