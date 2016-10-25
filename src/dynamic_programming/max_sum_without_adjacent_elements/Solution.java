package dynamic_programming.max_sum_without_adjacent_elements;

import java.util.ArrayList;
import java.util.stream.IntStream;

/**
 * Created by ugurdonmez on 06/09/16.
 */
public class Solution {

    public static void main(String [] args) {

        int [] array = {3, 2, 7, 10};

        ArrayList<Integer> list = new ArrayList<>();

        IntStream.of(array).forEach(list::add);

        System.out.println(getSum(list));
    }

    public static int adjacent(ArrayList<ArrayList<Integer>> list) {

        if (list.get(0).size() < 1) {
            return 0;
        }

        int with = Integer.max(list.get(0).get(0), list.get(1).get(0));
        int out = 0;

        for (int i = 1; i < list.get(0).size(); i++) {
            int old = with;
            with = out +Integer.max(list.get(0).get(i), list.get(1).get(i));
            out = Integer.max(out, old);
        }

        return Integer.max(with, out);
    }

    public static int getSum(ArrayList<Integer> list) {

        if (list.size() < 1) {
            return 0;
        }

        int with = list.get(0);
        int out = 0;

        for (int i = 1; i < list.size(); i++) {
            int old = with;
            with = out + list.get(i);
            out = Integer.max(out, old);
        }

        return Integer.max(with, out);
    }

}
