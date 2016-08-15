package array.first_missing_integer;

import java.util.ArrayList;
import java.util.stream.Collectors;

/**
 * Created by ugurdonmez on 06/08/16.
 */
public class Solution {

    public static void main(String [] args) {

        ArrayList<Integer> list = new ArrayList<>();

        list.add(9);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);
        list.add(7);

        System.out.println(firstMissingPositive(list));

    }

    public static int firstMissingPositive(ArrayList<Integer> a) {

        int count = (int) a.stream()
                .filter(i -> i > 0)
                .count();

        int [] array = new int[count+2];

        a.stream()
                .filter(i -> i > 0 && i <= count)
                .forEach(i -> array[i] = 1);

        for (int i = 1; i < array.length; i++) {
            if (array[i] == 0) {
                return i;
            }
        }

        return a.size();
    }

}
