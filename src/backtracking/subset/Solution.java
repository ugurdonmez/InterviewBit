package backtracking.subset;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.stream.IntStream;

/**
 * Created by ugurdonmez on 18/08/16.
 */

/*
If S = [1,2,3], a solution is:

[
  [],
  [1],
  [1, 2],
  [1, 2, 3],
  [1, 3],
  [2],
  [2, 3],
  [3],
]


 */

public class Solution {

    public static void main(String [] args) {

        int [] array = {1, 2, 3};

        ArrayList<Integer> list = new ArrayList<>();

        IntStream.of(array).forEach(list::add);

        System.out.println(subsets(list));

    }

    public static ArrayList<ArrayList<Integer>> subsets(ArrayList<Integer> list) {

        Collections.sort(list);

        ArrayList<ArrayList<Integer>> results = new ArrayList<>();

        if (list.size() == 0) {
            ArrayList<Integer> result = new ArrayList<>();
            results.add(result);

            return results;
        }

        if (list.size() == 1) {
            ArrayList<Integer> result1 = new ArrayList<>();
            results.add(result1);

            ArrayList<Integer> result2 = new ArrayList<>();
            result2.add(list.get(0));

            results.add(result2);

            return results;
        }

        int first = list.get(0);

        list.remove(0);

        ArrayList<ArrayList<Integer>> localResult = subsets(list);

        results.add(localResult.get(0));

        for (ArrayList<Integer> l : localResult) {
            ArrayList<Integer> localList = (ArrayList<Integer>)l.clone();
            localList.add(0, first);
            results.add(localList);
        }

        for (int i = 1; i < localResult.size(); i++) {
            results.add(localResult.get(i));
        }

        return results;
    }
}