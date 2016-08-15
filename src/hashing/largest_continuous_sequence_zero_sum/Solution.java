package hashing.largest_continuous_sequence_zero_sum;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

/**
 * Created by ugurdonmez on 14/08/16.
 */
public class Solution {

    public static void main(String [] args) {

        int [] array = {0, 22, 7, 21, -11, -6, -7, -16, -2};

        ArrayList<Integer> list = new ArrayList<>();

        IntStream.of(array).forEach(list::add);

        System.out.println(lszero(list));
    }

    public static ArrayList<Integer> lszero(ArrayList<Integer> list) {

        int sum = 0;

        Map<Integer, Integer> map = new HashMap<>();

        // map.put(sum, 0);

        int maxLength = 0;
        int maxStart = 0;
        int maxEnd = -1;

        for (int i = 0; i < list.size(); i++) {
            sum  += list.get(i);

            if (sum == 0) {
                int length = i + 1;
                if (length > maxLength) {
                    maxStart = 0;
                    maxEnd = i;
                    maxLength = length;
                }
            } else {
                if (map.containsKey(sum)) {
                    int length = i - map.get(sum);

                    if (length > maxLength) {
                        maxStart = map.get(sum) + 1;
                        maxEnd = i;
                        maxLength = length;
                    }
                } else {
                    map.put(sum, i);
                }
            }
        }

        ArrayList<Integer> result = new ArrayList<>();

        if (maxEnd != -1) {
            for (int i = maxStart; i <= maxEnd; i++) {
                result.add(list.get(i));
            }
        }

        return result;

    }

}
