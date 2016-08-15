package hashing.four_sum;

import java.util.ArrayList;
import java.util.Collections;
import java.util.stream.IntStream;

/**
 * Created by ugurdonmez on 14/08/16.
 */
public class Solution {

    public static void main(String [] args) {

        int [] array = {1,0,-1,0,-2,2,0,0};

        ArrayList<Integer> list = new ArrayList<>();

        IntStream.of(array).forEach(list::add);

        System.out.println(fourSum(list, 0));

    }

    public static ArrayList<ArrayList<Integer>> fourSum(ArrayList<Integer> list, int sum) {

        ArrayList<ArrayList<Integer>> result = new ArrayList<>();

        if (list.size() < 4) {
            return result;
        }

        Collections.sort(list);

        int iPrev = 0;
        int jPrev = 0;
        boolean checkJ = false;

        for (int i = 0; i < list.size()-3; i++) {

            if (i != 0) {
                if (iPrev == list.get(i)) {
                    continue;
                }
            }

            for (int j = i+1; j < list.size()-2; j++) {

                if (checkJ) {
                    if (jPrev == list.get(j)) {
                        continue;
                    }
                }

                int first = j+1;
                int last = list.size()-1;

                int aim = sum - (list.get(i) + list.get(j));

                while (first < last) {

                    int localSum = list.get(first) + list.get(last);

                    if (localSum == aim) {
                        ArrayList<Integer> sol = new ArrayList<>();
                        sol.add(list.get(i));
                        sol.add(list.get(j));
                        sol.add(list.get(first));
                        sol.add(list.get(last));

                        result.add(sol);

                        int prev= list.get(first);

                        while (first < last && prev == list.get(first)) {
                            first++;
                        }
                    } else if (localSum < aim) {
                        first++;
                    } else {
                        last--;
                    }
                }

                jPrev = list.get(j);
                checkJ = true;
            }

            iPrev = list.get(i);
            checkJ = false;
        }

        return result;
    }

}
