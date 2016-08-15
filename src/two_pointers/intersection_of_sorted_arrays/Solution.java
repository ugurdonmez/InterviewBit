package two_pointers.intersection_of_sorted_arrays;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ugurdonmez on 08/08/16.
 */
public class Solution {

    public static void main(String [] args) {

        List<Integer> a = new ArrayList<>();
        a.add(10000000);

        List<Integer> b = new ArrayList<>();
        b.add(10000000);

        System.out.println(intersect(a, b));

    }

    public static ArrayList<Integer> intersect(final List<Integer> a, final List<Integer> b) {

        ArrayList<Integer> list = new ArrayList<>();

        int index1 = 0;
        int index2 = 0;

        while (index1 < a.size() && index2 < b.size()) {

            int x1 = a.get(index1);
            int x2 = b.get(index2);

            if (x1 == x2) {
                list.add(a.get(index1));
                index1++;
                index2++;
            } else if (x1 < x2) {
                index1++;
            } else {
                index2++;
            }
        }

        return list;
    }

}
