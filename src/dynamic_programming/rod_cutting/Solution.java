package dynamic_programming.rod_cutting;

import java.util.ArrayList;
import java.util.stream.IntStream;

/**
 * Created by ugurdonmez on 10/09/16.
 */
public class Solution {

    /**
     *

     There is a rod of length N lying on x-axis with its left end at x = 0 and right end at x = N. Now, there are M weak points on this rod denoted by positive integer values(all less than N) A1, A2, …, AM. You have to cut rod at all these weak points. You can perform these cuts in any order. After a cut, rod gets divided into two smaller sub-rods. Cost of making a cut is the length of the sub-rod in which you are making a cut.

     Your aim is to minimise this cost. Return an array denoting the sequence in which you will make cuts. If two different sequences of cuts give same cost, return the lexicographically smallest.

     Notes:
     - Sequence a1, a2 ,…, an is lexicographically smaller than b1, b2 ,…, bm, if and only if at the first i where ai and bi differ, ai < bi, or if no such i found, then n < m.
     - N can be upto 109.

     For example,

     N = 6
     A = [1, 2, 5]

     If we make cuts in order [1, 2, 5], let us see what total cost would be.
     For first cut, the length of rod is 6.
     For second cut, the length of sub-rod in which we are making cut is 5(since we already have made a cut at 1).
     For third cut, the length of sub-rod in which we are making cut is 4(since we already have made a cut at 2).
     So, total cost is 6 + 5 + 4.

     Cut order          | Sum of cost
     (lexicographically | of each cut
     sorted)           |
     ___________________|_______________
     [1, 2, 5]          | 6 + 5 + 4 = 15
     [1, 5, 2]          | 6 + 5 + 4 = 15
     [2, 1, 5]          | 6 + 2 + 4 = 12
     [2, 5, 1]          | 6 + 4 + 2 = 12
     [5, 1, 2]          | 6 + 5 + 4 = 15
     [5, 2, 1]          | 6 + 5 + 2 = 13


     So, we return [2, 1, 5].
     */


    public ArrayList<Integer> rodCut(int n, ArrayList<Integer> list) {

        return rodCutHelper(n, list, 0, n);

    }

    public ArrayList<Integer> rodCutHelper(int n, ArrayList<Integer> list, int start, int end) {

        if (list.size() == 0 || list.size() == 1) {
            ArrayList<Integer> result = new ArrayList<>();
            result.add(end-start);
            return result;
        }

        for (int i = 0; i < list.size(); i++) {

        }

        return null;
    }

    public static void main(String [] args) {

        int [] array = {3,5,8,9,10,17,17,20};
        ArrayList<Integer> list = new ArrayList<>();

        IntStream.of(array).forEach(list::add);

        System.out.println(getMaxCut(list));
    }

    public static int getMaxCut(ArrayList<Integer> list) {

        if (list == null || list.size() == 0) {
            return 0;
        }

        if (list.size() == 1) {
            return list.get(0);
        }

        int [] array = new int[list.size()+1];

        array[1] = list.get(0);

        for (int i = 2; i <= list.size(); i++) {
            int max = list.get(i-1);

            for (int j = 1; j <= i / 2; j++) {
                int total = array[j] + array[i-j];

                if (total > max) {
                    max = total;
                }
            }

            array[i] = max;

        }

        return array[list.size()];
    }

}
