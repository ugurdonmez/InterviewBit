package greedy.distribute_candy;

import java.util.*;
import java.util.stream.IntStream;

/**
 * Created by ugurdonmez on 04/09/16.
 */

/*
There are N children standing in a line. Each child is assigned a rating value.

    You are giving candies to these children subjected to the following requirements:

        Each child must have at least one candy.
        Children with a higher rating get more candies than their neighbors.

What is the minimum candies you must give?
 */

public class Solution {

    public static void main(String [] args) {

        int [] array = {1,2,3,2,1};
        ArrayList<Integer> list = new ArrayList<>();

        IntStream.of(array).forEach(list::add);

        System.out.println(candy(list));

    }

    public static int candy(ArrayList<Integer> ratings) {

        int [] array = new int[ratings.size()];

        for (int i = 0; i < array.length; i++) {
            array[i] = 1;
        }

        for (int i = 1; i < array.length; i++) {
            if (ratings.get(i) > ratings.get(i-1)) {
                array[i] = 1 + array[i-1];
            }
        }

        for (int i = array.length-2; i >=0; i--) {
            if (ratings.get(i) > ratings.get(i+1)) {
                array[i] = Integer.max(array[i], array[i+1]+1);
            }
        }

        return IntStream.of(array).sum();
    }

    public static int candyWrong2(ArrayList<Integer> ratings) {
        int min = Integer.MAX_VALUE;

        int total = 0;

        int current = 0;
        for (int i = 1; i < ratings.size(); i++) {
            if (ratings.get(i-1) > ratings.get(i)) {
                current = 0;
                total += current;
                if (current < min) {
                    min = current;
                }
            } else if (ratings.get(i-1) < ratings.get(i)) {
                current++;
                total += current;
            } else {
                current = 0;
                total += current;
            }
        }

        // find min size of n
        if (min < 0) {
            int n = Math.abs(min) + 1;
            return ratings.size() * n + total;
        } else {
            return ratings.size() + total;
        }
    }

    public static int candyWrong(ArrayList<Integer> ratings) {

        Map<Integer, Integer> map = new TreeMap<>();

        for (int a : ratings) {
            if (map.containsKey(a)) {
                map.put(a, map.get(a) + 1);
            } else {
                map.put(a, 1);
            }
        }

        Iterator<Map.Entry<Integer, Integer>> iterator = map.entrySet().iterator();

        int count = 0;
        int index = 1;
        while (iterator.hasNext()) {

            count += iterator.next().getValue() * index;
            index++;
        }

        return count;
    }
}
