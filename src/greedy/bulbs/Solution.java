package greedy.bulbs;

import java.util.ArrayList;

/**
 * Created by ugurdonmez on 04/09/16.
 */
public class Solution {

    public int bulbs(ArrayList<Integer> list) {

        int count = 0;

        for (int i = 0; i < list.size(); i++) {
            if (i % 2 == 1) {
                count += list.get(i);
            } else {
                if (list.get(i) == 0) {
                    count++;
                }
            }
        }

        return count;
    }

}
