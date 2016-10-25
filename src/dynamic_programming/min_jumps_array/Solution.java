package dynamic_programming.min_jumps_array;

import java.util.ArrayList;
import java.util.stream.IntStream;

/**
 * Created by ugurdonmez on 06/09/16.
 */
public class Solution {

    public static void main(String [] args) {

        int [] array = {1,3,4,8,9,2,6,7,8,9};

        ArrayList<Integer> list = new ArrayList<>();

        IntStream.of(array).forEach(list::add);

        System.out.println(getMinStep(list));
    }

    public static int getMinStep(ArrayList<Integer> list) {

        if (list.size() == 0) {
            return 0;
        }

        if (list.size() == 1) {
            return 1;
        }

        int [] steps = new int [list.size()];

        for (int i = 0; i < steps.length; i++) {
            steps[i] = Integer.MAX_VALUE;
        }

        steps[0] = 0;
        int maxReach = 0;

        for (int i = 0; i < steps.length; i++) {
            int stepLength = list.get(i);

            if (stepLength != 0) {
                for (int j = maxReach; j <= i + stepLength && j < steps.length; j++) {
                    steps[j] = Integer.min(steps[j], steps[i] + 1);
                    maxReach = j;
                }
            }

            if (maxReach >= steps.length-1) {
                break;
            }
        }

        return steps[steps.length-1];
    }

}
