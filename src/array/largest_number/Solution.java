package array.largest_number;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by ugurdonmez on 06/08/16.
 */
public class Solution {

    public static void main(String [] args) {

        List<Integer> list = new ArrayList<>();

        list.add(3);
        list.add(30);
        list.add(34);
        list.add(5);
        list.add(9);

        System.out.println(largestNumber(list));

    }

    public static String largestNumber(final List<Integer> a) {

        StringBuilder buf = new StringBuilder();

        Number [] array = new Number[a.size()];

        boolean allZero = true;

        for (int i = 0; i < a.size(); i++) {
            if (a.get(i) != 0) {
                allZero = false;
            }
            array[i] = new Number(a.get(i));
        }

        if (allZero) {
            return "0";
        }

        Arrays.sort(array);

        Arrays.stream(array).forEach(buf::append);

        return buf.toString();
    }

}

class Number implements Comparable<Number>{
    final int value;

    Number(int value) {
        this.value = value;
    }


    @Override
    public String toString() {
        return String.valueOf(value);
    }

    @Override
    public int compareTo(Number o) {

        String strThis = String.valueOf(value);
        String obj = String.valueOf(o.value);

        int index1 = 0;
        int index2 = 0;

        while (index1 < strThis.length() && index2 < obj.length()) {
            if (strThis.charAt(index1) > obj.charAt(index2)) {
                return -1;
            } else if (strThis.charAt(index1) < obj.charAt(index2)) {
                return 1;
            }
            index1++;
            index2++;
        }

        if (index1 == strThis.length()) {
            index1--;

            while (index2 < obj.length()) {
                if (strThis.charAt(index1) > obj.charAt(index2)) {
                    return -1;
                } else if (strThis.charAt(index1) < obj.charAt(index2)) {
                    return 1;
                }
                index2++;
            }

            // longest is index2
            // TODO: compare start and end
            return 0;
        }

        if (index2 == obj.length()) {
            index2--;

            while (index1 < strThis.length()) {
                if (strThis.charAt(index1) > obj.charAt(index2)) {
                    return -1;
                } else if (strThis.charAt(index1) < obj.charAt(index2)) {
                    return 1;
                }
                index1++;
            }

            // longest is index2
            return 0;
        }

        return 0;
    }
}