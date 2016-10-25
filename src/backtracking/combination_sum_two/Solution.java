package backtracking.combination_sum_two;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Created by ugurdonmez on 18/08/16.
 */
public class Solution {

    public static void main(String [] args) {

        //int [] array = {10,1,2,7,6,1,5};

        // int [] array = {3,4,7};
        int [] array = {};

        ArrayList<Integer> list = new ArrayList<>();

        IntStream.of(array).forEach(list::add);

        System.out.println(combinationSum(list, 8));
    }

    public static ArrayList<ArrayList<Integer>> combinationSum(ArrayList<Integer> a, int b) {

        List<ArrayList<Integer>> result = combinationSumHelper(a, b);

        ArrayList<ArrayList<Integer>> returnArrayList = new ArrayList<>();

        if (result == null) {
            return returnArrayList;
        }

        for (ArrayList<Integer> l : result) {
            returnArrayList.add(l);
        }

        return returnArrayList;
    }


    public static List<ArrayList<Integer>> combinationSumHelper(List<Integer> list, int sum) {

        Collections.sort(list);

        if (sum < 0) {
            return null;
        }

        if (list.size() == 0) {
            return null;
        }

        if (list.get(0) > sum) {
            return null;
        }

        if (list.get(0) == sum) {
            ArrayList<ArrayList<Integer>> results = new ArrayList<>();

            ArrayList<Integer> result = new ArrayList<>();

            result.add(list.get(0));

            results.add(result);

            return results;
        }

        ArrayList<ArrayList<Integer>> results = new ArrayList<>();

        for (int i = 0; i < list.size(); i++) {

            int number = list.get(i);

            List<Integer> subList = list.subList(i+1, list.size());

            List<ArrayList<Integer>> localResult = combinationSumHelper(subList, sum-number);
            List<ArrayList<Integer>> localResult1 = combinationSumHelper(subList, sum);

            if (localResult != null) {

                for (ArrayList<Integer> l : localResult) {
                    l.add(0, number);

                    if (l.stream().mapToInt(a -> a.intValue()).sum() == sum) {
                        results.add(l);
                    }
                }

            }

            if (localResult1 != null) {

                results.addAll(localResult1.stream().filter(l -> l.stream().mapToInt(a -> a.intValue()).sum() == sum).collect(Collectors.toList()));
            }
        }

        List<ArrayList<Integer>> distinctResult = results.stream().distinct().collect(Collectors.toList());

        return distinctResult;
    }
}
