package array.maximum_consecutive_gap;

import java.util.Collections;
import java.util.List;

/**
 * Created by ugurdonmez on 08/08/16.
 */
public class Solution {

    public int maximumGap(List<Integer> list) {

        if (list.size() < 2) {
            return 0;
        }

        if (list.size() == 2) {
            return Math.abs(list.get(0) - list.get(1));
        }

        Collections.sort(list);

        int maxDif = Integer.MIN_VALUE;

        for (int i = 1; i < list.size(); i++) {
            if (list.get(i) - list.get(i-1) > maxDif) {
                maxDif = list.get(i) - list.get(i-1);
            }
        }

        return maxDif;
    }

}
