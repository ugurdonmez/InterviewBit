package array.add_one_to_number;

import java.util.ArrayList;

/**
 * Created by ugurdonmez on 04/08/16.
 */
public class Solution {

    public static void main(String [] args) {

        ArrayList<Integer> list = new ArrayList<>();

        list.add(9);
        list.add(9);
        list.add(9);

        System.out.println(list);

        list = plusOne(list);

        System.out.println(list);

    }


    public static ArrayList<Integer> plusOne(ArrayList<Integer> a) {

        int index = a.size()-1;

        while (index >= 0 && a.get(index) == 9) {
            a.remove(index);
            a.add(index, 0);
            index--;
        }

        if (index < 0) {
            a.add(0,1);
        } else {
            int x = a.get(index);
            x++;
            a.remove(index);
            a.add(index, x);
        }

        while (a.get(0) == 0) {
            a.remove(0);
        }

        return a;
    }


}
