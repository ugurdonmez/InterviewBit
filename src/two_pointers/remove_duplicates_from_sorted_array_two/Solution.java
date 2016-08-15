package two_pointers.remove_duplicates_from_sorted_array_two;

import java.util.List;

/**
 * Created by ugurdonmez on 08/08/16.
 */
public class Solution {

    public static int removeDuplicates(List<Integer> a) {

        int duplicates = 0;

        for (int i = 1; i < a.size(); i++) {

            int i1 = a.get(i-1);
            int i2 = a.get(i);

            if (i1 == i2) {
                duplicates++;
            }
        }

        int value = a.size() - duplicates;

        int index = 0;

        while (index < a.size()-1) {
            if (a.get(index) == a.get(index+1)) {
                a.remove(index);
            } else {
                index++;
            }
        }

        return value;
    }

}
