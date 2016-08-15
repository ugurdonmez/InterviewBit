package hashing.diffk_two;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by ugurdonmez on 15/08/16.
 */
public class Solution {

    public static void main(String [] args) {



    }

    public static int diffPossible(final List<Integer> list, int dif) {

        Set<Integer> set = new HashSet<>();

        for (int a : list) {

            int search = dif + a;

            if (set.contains(search)) {
                return 1;
            }

            search = a - dif;

            if (set.contains(search)) {
                return 1;
            }

            set.add(a);
        }

        return 0;
    }

}
