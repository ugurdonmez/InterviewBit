package dynamic_programming.coin_sum_infinite;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.stream.IntStream;

/**
 * Created by ugurdonmez on 05/09/16.
 */
public class Solution {

    public static void main(String [] args) {

        int [] array = {1,2,3};
        ArrayList<Integer> list = new ArrayList<>();

        IntStream.of(array).forEach(list::add);

        System.out.println(recStart(list, 4));
    }

    public static int recStart(ArrayList<Integer> list, int sum) {

        int [][] memory = new int[sum+1][list.size()+1];

        for (int i = 1; i < sum+1; i++) {
            for (int j = 0; j < list.size()+1; j++) {
                memory[i][j] = -1;
            }
        }

        return rec(list, list.size(), sum, memory);
    }

    public static int rec(ArrayList<Integer> list, int level, int sum, int [][] memory) {

        if (sum < 0) {
            return 0;
        }

        if (sum == 0) {
            return 1;
        }

        if (level == 0) {
            if (sum > 0) {
                return 0;
            }
        }

        if (memory[sum][level] != -1) {
            return memory[sum][level];
        }

        int total = 0;

        total += rec(list, level, sum - list.get(level-1), memory);
        total %= 1000007;
        total += rec(list, level-1, sum, memory);
        total %= 1000007;

        memory[sum][level] = total % 1000007;

        return total % 1000007;
    }

    public static int coinchange2(ArrayList<Integer> list, int b) {

        HashMap<Integer, Integer> map = new HashMap<>();

        return helper(list, b, map);
    }

    public static int helper(ArrayList<Integer> list, int sum, HashMap<Integer, Integer> map) {
        if (map.containsKey(sum)) {
            return map.get(sum);
        }

        if (sum == 0) {
            return 1;
        }

        if (sum < 0) {
            return 0;
        }

        int total = 0;

        for (int a : list) {
            total += helper(list, sum-a, map);
        }

        map.put(sum, total);
        return total;
    }

}
