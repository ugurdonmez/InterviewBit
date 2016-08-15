package array.repeat_and_missing_number_array;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ugurdonmez on 05/08/16.
 */
public class Solution {

    public static void main(String [] args) {

        List<Integer> list = new ArrayList<>();

        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(5);

        System.out.println(repeatedNumber(list));
    }

    public static ArrayList<Integer> repeatedNumber(final List<Integer> a) {

        ArrayList<Integer> result = new ArrayList<>();

        // calculate xor
        int xor = 0;
        int sum = 0;
        for (int i = 0; i < a.size(); i++) {
            xor = xor ^ (i+1);
            xor = xor ^ a.get(i);
            sum += a.get(i);
        }

        // xor = missing ^ double

        // calculate missing - double
        int dif = ((a.size()) * (a.size()+1) / 2) - sum;

        if (dif > 0) {
            for (int i = 1; i <= a.size()-dif; i++) {
                int x = xor ^ i ^ (i+dif);
                if (x == 0 && isMissing(a, i+dif)) {
                    result.add(i);
                    result.add(i+dif);
                    return result;
                }
            }
        } else {
            for (int i = 1; i <= a.size()+dif; i++) {
                int x = xor ^ i ^ (i-dif);
                if (x == 0  && isMissing(a, i)) {
                    result.add(i-dif);
                    result.add(i);
                    return result;
                }
            }
        }

        return result;
    }

    public static boolean isMissing(final List<Integer> a, int x) {

        for (int i : a) {
            if (i == x) {
                return false;
            }
        }

        return true;
    }

}
