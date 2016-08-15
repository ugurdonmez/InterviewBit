package two_pointers.array_three_pointers;

import java.util.List;

/**
 * Created by ugurdonmez on 08/08/16.
 */
public class Solution {

    public int minimize(final List<Integer> a, final List<Integer> b, final List<Integer> c) {

        int index1 = 0;
        int index2 = 0;
        int index3 = 0;

        int minDif = Integer.MAX_VALUE;

        while (index1 < a.size() && index2 < b.size() && index3 < c.size()) {

            int max = Integer.max(a.get(index1), b.get(index2));
            max = Integer.max(max, c.get(index3));

            int min = Integer.min(a.get(index1), b.get(index2));
            min = Integer.min(min, c.get(index3));

            int dif = max - min;

            if (dif < minDif) {
                minDif = dif;
            }

            if (a.get(index1) <= b.get(index2) && a.get(index1) <= c.get(index3)) {
                index1++;
            } else if (b.get(index2) <= a.get(index1) && b.get(index2) <= c.get(index3)) {
                index2++;
            } else {
                index3++;
            }
        }

        return minDif;
    }

}
