package bit_manipulation.single_number;

import java.util.List;

/**
 * Created by ugurdonmez on 10/08/16.
 */
public class Solution {

    public static int singleNumber(final List<Integer> list) {

        int value = 0;

        for (int a : list) {
            value ^= a;
        }

        return value;
    }

}
