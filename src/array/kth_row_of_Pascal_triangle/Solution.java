package array.kth_row_of_Pascal_triangle;

import java.util.ArrayList;

/**
 * Created by ugurdonmez on 07/08/16.
 */
public class Solution {

    public static void main(String [] args) {

        System.out.println(getRow(8));

    }

    public static ArrayList<Integer> getRow(int k) {

        ArrayList<Integer> list = new ArrayList<>();

        if (k < 0) {
            return list;
        }

        if (k == 0) {
            list.add(1);
            return list;
        }

        if (k == 1) {
            list.add(1);
            list.add(1);
            return list;
        }

        double top = 1;
        double bottom = 1;

        for (int i = k; i >= 0; i--) {
            list.add( (int) (top / bottom));
            top *= i;
            bottom *= (k - i + 1);
        }

        return list;
    }

}
