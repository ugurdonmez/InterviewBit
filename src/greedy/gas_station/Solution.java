package greedy.gas_station;

import java.util.List;

/**
 * Created by ugurdonmez on 05/09/16.
 */
public class Solution {

    public int canCompleteCircuit(final List<Integer> gas, final List<Integer> cost) {

        int sumRemaining = 0; // track current remaining
        int total = 0; // track total remaining
        int start = 0;

        for (int i = 0; i < gas.size(); i++) {
            int remaining = gas.get(i) - cost.get(i);

            //if sum remaining of (i-1) >= 0, continue
            if (sumRemaining >= 0) {
                sumRemaining += remaining;
                //otherwise, reset start index to be current
            } else {
                sumRemaining = remaining;
                start = i;
            }
            total += remaining;
        }

        if (total >= 0){
            return start;
        }else{
            return -1;
        }

    }

}
