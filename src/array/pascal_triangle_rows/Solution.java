package array.pascal_triangle_rows;

import java.util.ArrayList;

/**
 * Created by ugurdonmez on 07/08/16.
 */
public class Solution {

    public static void main(String [] args) {

        System.out.println(generate(5));

    }

    public static ArrayList<ArrayList<Integer>> generate(int k) {

        ArrayList<ArrayList<Integer>> result = new ArrayList<>();

        if (k == 1) {
            ArrayList<Integer> list = new ArrayList<>();
            list.add(1);
            result.add(list);
            return result;
        }

        if (k == 2) {
            ArrayList<Integer> list = new ArrayList<>();
            list.add(1);
            list.add(1);
            result.add(list);
            return result;
        }

        ArrayList<Integer> listZero = new ArrayList<>();
        listZero.add(1);
        result.add(listZero);

        ArrayList<Integer> listOne = new ArrayList<>();
        listOne.add(1);
        listOne.add(1);
        result.add(listOne);

        for (int i = 2; i < k; i++) {
            ArrayList<Integer> list = new ArrayList<>();
            list.add(1);

            ArrayList<Integer> prevList = result.get(i-1);
            for (int j = 1; j < i; j++) {
                list.add(prevList.get(j-1) + prevList.get(j));
            }

            list.add(1);
            result.add(list);
        }

        return result;
    }

}
