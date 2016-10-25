package dynamic_programming.equal_average_partition;

import java.util.ArrayList;

/**
 * Created by ugurdonmez on 10/09/16.
 */
public class Solution {

    public static int minimumTotal(ArrayList<ArrayList<Integer>> list) {

        for (int i = 1; i < list.size(); i++) {
            ArrayList<Integer> top = list.get(i-1);
            ArrayList<Integer> bottom = list.get(i);

            for (int j = 0; j < bottom.size(); j++) {
                if (j == 0) {
                    bottom.set(0, bottom.get(0) + top.get(0));
                } else if (j == bottom.size()-1) {
                    bottom.set(bottom.size()-1, bottom.get(bottom.size()-1) + top.get(bottom.size()-2));
                } else {
                    int sumLocal = Integer.min(top.get(j), top.get(j-1));
                    bottom.set(j, bottom.get(j) + sumLocal);
                }
            }
        }

        int min = Integer.MAX_VALUE;

        for (int i = 0; i < list.get(list.size()-1).size(); i++) {
            if (list.get(list.size()-1).get(i) < min) {
                min = list.get(list.size()-1).get(i);
            }
        }

        return min;
    }

}
