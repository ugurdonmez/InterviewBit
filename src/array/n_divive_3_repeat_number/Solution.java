package array.n_divive_3_repeat_number;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ugurdonmez on 06/08/16.
 */
public class Solution {

    public static void main(String [] args) {

        List<Integer> list = new ArrayList<>();

        list.add(1);
        list.add(1);
        list.add(2);

        System.out.println(repeatedNumber(list));
    }

    public static int repeatedNumber(final List<Integer> a) {

        int number1 = -1;
        int number2 = -1;
        int count1 = 0;
        int count2 = 0;

        for (int i = 0; i < a.size(); i++) {

            if (number1 == a.get(i)) {
                count1++;
            } else if (number2 == a.get(i)) {
                count2++;
            } else if (number1 == -1) {
                number1 = a.get(i);
                count1 = 1;
            } else if (number2 == -1) {
                number2 = a.get(i);
                count2 = 1;
            } else if (number1 == a.get(i)) {
                count1++;
            } else if (number2 == a.get(i)) {
                count2++;
            } else {
                count1--;
                count2--;

                if (count1 == 0) {
                    number1 = -1;
                }

                if (count2 == 0) {
                    number2 = -1;
                }
            }
        }

        if (count1 != 0) {
            return number1;
        } else if (count2 != 0) {
            return number2;
        } else {
            return -1;
        }
    }
}
