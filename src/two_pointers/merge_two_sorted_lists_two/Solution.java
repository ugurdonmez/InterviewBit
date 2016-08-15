package two_pointers.merge_two_sorted_lists_two;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ugurdonmez on 08/08/16.
 */
public class Solution {

    public static void main(String [] args) {

        List<Integer> a = new ArrayList<>();
        a.add(-4);
        a.add(3);

        List<Integer> b = new ArrayList<>();
        b.add(-2);
        b.add(-2);

        merge(a, b);

        System.out.println(a);

    }

    public static void merge(final List<Integer> a, final List<Integer> b) {

        ArrayList<Integer> list = new ArrayList<>();

        int index1 = 0;
        int index2 = 0;

        while (index1 < a.size() && index2 < b.size()) {

            int x1 = a.get(index1);
            int x2 = b.get(index2);

            if (x1 == x2) {
                list.add(x1);
                index1++;
            } else if (x1 < x2) {
                list.add(x1);
                index1++;
            } else {
                list.add(x2);
                index2++;
            }
        }

        while (index1 < a.size()) {
            int x1 = a.get(index1);
            list.add(x1);
            index1++;
        }

        while (index2 < b.size()) {
            int x1 = b.get(index2);
            list.add(x1);
            index2++;
        }

        a.clear();

        for (int i = 0; i < list.size(); i++) {
            a.add(list.get(i));
        }

    }

}
