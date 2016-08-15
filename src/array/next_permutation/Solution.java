package array.next_permutation;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by ugurdonmez on 06/08/16.
 */
public class Solution {

    public static void main(String [] args) {

        ArrayList<Integer> list = new ArrayList<>();

        list.add(1);
        list.add(1);
        list.add(5);

        System.out.println(list);

        nextPermutation(list);

        System.out.println(list);

    }

    public static void nextPermutation(ArrayList<Integer> a) {

        if (a.size() == 1 || a.size() == 0) {
            return;
        }

        int index = a.size()-2;

        while (index >= 0 && a.get(a.size()-1) < a.get(index)) {
            index--;
        }

        if (index == 0) {
            Collections.sort(a);
            return;
        } else {
            int temp = a.get(a.size()-1);
            a.set(a.size()-1, a.get(index));
            a.set(index, temp);

            Collections.sort(a.subList(index+1, a.size()));
        }

    }

}
