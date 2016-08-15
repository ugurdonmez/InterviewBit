package two_pointers.three_sum;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Created by ugurdonmez on 08/08/16.
 */
public class Solution {

    public static void main(String [] args) {


        int [] array = {10, -6, 3, 4, -8, -5};

        List<Integer> list = IntStream.of(array).boxed().collect(Collectors.toList());

        System.out.println(threeSumClosest(list, 3));
    }

    public static int threeSumClosest(List<Integer> list, int number) {

        Collections.sort(list);

        int closest = 0;
        boolean count = true;

        for (int i = 0; i < list.size(); i++) {
            int first = 0;
            int last = list.size()-1;

            while (first < last) {
                if (first == i) {
                    first++;
                    continue;
                }

                if (last == i) {
                    last--;
                    continue;
                }

                int sum  = list.get(i) + list.get(first) + list.get(last);

                if (count) {
                    closest = sum;
                    count = false;
                } else if (Math.abs(number - sum) <= Math.abs(number-closest)) {
                    closest = sum;
                }

                if (sum > number) {
                    last--;
                } else if (sum < number) {
                    first++;
                } else {
                    return number;
                }
            }
        }

        return closest;
    }

}
