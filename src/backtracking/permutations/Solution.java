package backtracking.permutations;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ugurdonmez on 17/08/16.
 */
public class Solution {

    public static void main(String [] args) {

        ArrayList<Integer> list = new ArrayList<>();

        list.add(1);
        list.add(2);
        list.add(3);

        System.out.println(permute(list));

    }

    public static ArrayList<ArrayList<Integer>> permute(ArrayList<Integer> a) {

        return permuteHelper(a);

    }

    public static ArrayList<ArrayList<Integer>> permuteHelper(ArrayList<Integer> list) {

        if (list.size() == 1) {
            ArrayList<ArrayList<Integer>> results = new ArrayList<>();
            ArrayList<Integer> result = new ArrayList<>();

            result.add(list.get(0));
            results.add(result);

            return results;
        }

        ArrayList<ArrayList<Integer>> results = new ArrayList<>();

        for (int i = 0; i < list.size(); i++) {
            int key = list.get(i);

            ArrayList<Integer> newList = new ArrayList<>();

            for (int j = 0; j < list.size(); j++) {
                if (i != j) {
                    newList.add(list.get(j));
                }
            }

            ArrayList<ArrayList<Integer>> localResults = permuteHelper(newList);

            for (ArrayList<Integer> l : localResults) {
                l.add(0, key);
                results.add(l);
            }
        }

        return results;
    }
}
