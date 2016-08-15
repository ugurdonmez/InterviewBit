package two_pointers.container_with_most_water;

import java.util.ArrayList;

/**
 * Created by ugurdonmez on 08/08/16.
 */
public class Solution {

    public int maxArea(ArrayList<Integer> list) {

        int max = 0;

        for (int i = 0; i < list.size(); i++) {
            for (int j = i+1; j < list.size(); j++) {
                if ((j-i) * Integer.min(list.get(i), list.get(j)) > max) {
                    max = (j-i) * Integer.min(list.get(i), list.get(j));
                }
            }
        }

        return max;
    }

}
