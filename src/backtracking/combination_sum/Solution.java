package backtracking.combination_sum;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
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

        int [] array = {8, 10, 6, 11, 1, 16, 8};

        // int [] array = {1};

        ArrayList<Integer> list = new ArrayList<>();

        IntStream.of(array).forEach(list::add);

        combinationSum(list, 28).stream().forEach(System.out::println);
    }

    public static ArrayList<ArrayList<Integer>> combinationSum(ArrayList<Integer> a, int b) {

        List<ArrayList<Integer>> result = combinationSumHelper(a, b);

        ArrayList<ArrayList<Integer>> returnArrayList = new ArrayList<>();

        if (result == null) {
            return returnArrayList;
        }

        for (ArrayList<Integer> l : result) returnArrayList.add(l);

        // sort the result
        Collections.sort(returnArrayList, new ArrayListComparator());

        return returnArrayList;
    }


    public static List<ArrayList<Integer>> combinationSumHelper(List<Integer> list, int sum) {

        Collections.sort(list);

        if (sum < 0) {
            return null;
        }

        if (list.size() == 0) {
            ArrayList<ArrayList<Integer>> results = new ArrayList<>();

            ArrayList<Integer> result = new ArrayList<>();

            results.add(result);

            return results;
        }

        if (list.get(0) > sum) {
            ArrayList<ArrayList<Integer>> results = new ArrayList<>();

            ArrayList<Integer> result = new ArrayList<>();

            results.add(result);

            return results;
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

            int size = sum / number;

            for (int k  = 0; k <= size; k++) {
                List<ArrayList<Integer>> localResult = combinationSumHelper(subList, sum - (number * k));

                if (localResult != null) {

                    for (ArrayList<Integer> l : localResult) {

                        for (int j = 0; j < k; j++) {
                            l.add(0, number);
                        }

                        if (l.stream().mapToInt(a -> a.intValue()).sum() == sum) {
                            results.add(l);
                        }
                    }
                }
            }

        }

        List<ArrayList<Integer>> distinctResult = results.stream().distinct().collect(Collectors.toList());

        return distinctResult;
    }
}

class ArrayListComparator implements Comparator<ArrayList<Integer>> {

    @Override
    public int compare(ArrayList<Integer> o1, ArrayList<Integer> o2) {

        if (o1.isEmpty() && o2.isEmpty()) {
            return Integer.compare(0,0);
        }

        if (o1.isEmpty() && !o2.isEmpty()) {
            return Integer.compare(0,1);
        }

        if (!o1.isEmpty() && o2.isEmpty()) {
            return Integer.compare(1,0);
        }

        int index = 0;
        while (true) {

            if (o1.size() == index && o2.size() > index) {
                return Integer.compare(0,1);
            }

            if (o1.size() > index && o2.size() == index) {
                return Integer.compare(1,0);
            }

            if (o1.size() == index && o2.size() == index) {
                return Integer.compare(0,0);
            }

            int x1 = o1.get(index);
            int x2 = o2.get(index);

            if (x1 == x2) {
                index++;
            } else if (x1 < x2) {
                return Integer.compare(0,1);
            } else {
                return Integer.compare(1,0);
            }
        }
    }
}