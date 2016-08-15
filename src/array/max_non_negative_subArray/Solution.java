package array.max_non_negative_subArray;

import java.util.ArrayList;

/**
 * Created by ugurdonmez on 04/08/16.
 */
public class Solution {

    public static void main(String [] args) {

        ArrayList<Integer> result = new ArrayList<>();
        result.add(-1);
        result.add(-2);
        result.add(-5);
        result.add(-7);
        result.add(-2);
        result.add(-3);

        System.out.println(maxset(result));

    }

    public static ArrayList<Integer> maxset(ArrayList<Integer> list) {

        ArrayList<Integer> result = new ArrayList<>();

        int currentSum = -1;
        int currentStart = -1;

        int maxSum = -1;
        int maxStart = -1;
        int maxEnd = 0;

        for (int i = 0; i < list.size(); i++) {
            if(list.get(i) <= 0) {
                if (currentSum > maxSum) {
                    maxSum = currentSum;
                    maxStart = currentStart;
                    maxEnd = i-1;
                }
                currentSum = -1;
                currentStart = -1;
            } else {
                if (currentStart == -1) {
                    currentStart = i;
                    currentSum = list.get(i);
                } else {
                    currentSum += list.get(i);
                }
            }
        }

        if (currentSum >= 0) {
            if (currentSum > maxSum) {
                maxStart = currentStart;
                maxEnd = list.size()-1;
            }
        }

        for (int i = maxStart; i <= maxEnd && maxStart >= 0; i++) {
            result.add(list.get(i));
        }

        return result;
    }

}
