package two_pointers.diffk;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Created by ugurdonmez on 08/08/16.
 */
public class Solution {

    public static void main(String [] args) {


        int [] array = {1, 2, 3};

        List<Integer> list = IntStream.of(array).boxed().collect(Collectors.toList());

        System.out.println(diffPossible(list, 0));
    }

    public static int diffPossible(List<Integer> list, int b) {

        if (list.size() <= 1) {
            return 0;
        }

        int first = 0;
        int last = list.size()-1;

        int diff = list.get(last) - list.get(first);

        while (diff > b && last > 1) {
            last--;
            diff = list.get(last) - list.get(first);
        }

        if (diff == b) {
            return 1;
        }

        while (first < last && first < list.size()-1) {
            first++;
            if (first == last) {
                last++;
            }

            if (first == list.size() || last == list.size()) {
                return 0;
            }

            diff = list.get(last) - list.get(first);

            while (diff < b  && last < list.size()-1) {
                last++;
                diff = list.get(last) - list.get(first);
            }

            if (diff == b && first != last) {
                return 1;
            }
        }

        return 0;
    }

}
