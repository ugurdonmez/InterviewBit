package greedy.assign_mice_to_holes;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by ugurdonmez on 04/09/16.
 */
public class Solution {

    public int mice(ArrayList<Integer> mice, ArrayList<Integer> holes) {

        Collections.sort(mice);
        Collections.sort(holes);

        int dif = 0;

        for (int i = 0; i < mice.size(); i++) {
            int localDif = Math.abs(mice.get(i) - holes.get(i));
            dif = Integer.max(dif, localDif);
        }

        return dif;
    }

}
