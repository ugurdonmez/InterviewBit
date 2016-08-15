package stacks_and_queues.rain_water_trapped;

import java.util.List;

/**
 * Created by ugurdonmez on 11/08/16.
 */
public class Solution {

    public static int trap(final List<Integer> list) {

        int [] arrayLeft = new int[list.size()];
        int [] arrayRight = new int[list.size()];

        arrayLeft[0] = 0;
        int max = list.get(0);

        for (int i = 1; i < list.size(); i++) {
            arrayLeft[i] = max;
            max = Integer.max(max, list.get(i));
        }

        max = list.get(list.size()-1);
        arrayRight[0] = 0;

        for (int i = list.size()-1; i >= 0; i--) {
            arrayRight[i] = max;
            max = Integer.max(max, list.get(i));
        }

        int total = 0;
        for (int i = 0; i < list.size(); i++) {
            int wall = Integer.min(arrayLeft[i], arrayRight[i]);

            if (wall > list.get(i)) {
                total += wall - list.get(i);
            }
        }

        return total;
    }

}
