package binary_search.painters_partition_problem;

import java.util.ArrayList;
import java.util.stream.IntStream;

/**
 * Created by user on 10/08/16.
 */
public class Solution {

    public static void main(String [] args) {

        int[] array = {1000000, 1000000};

        ArrayList<Integer> list = new ArrayList<>();

        IntStream.of(array).forEach(list::add);

        for (int i = 0; i < array.length; i++) {
            System.out.println(i + " " + array[i]);
        }

        System.out.println(paint(1, 1000000, list));
    }

    public static int [] convertToArray(ArrayList<Integer> list) {

        int [] array1 = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            array1[i] = list.get(i);
        }

        return array1;
    }

    private static final int MOD = 10000003;

    public static int paint(int number, int unitTime, ArrayList<Integer> C) {

        long res = Long.MAX_VALUE;
        long low = 0;
        long high = Long.MAX_VALUE;
        long mid;

        while (low <= high) {

            mid = (high + low) / 2;

            boolean status = possible(number, unitTime, C, mid);

            if (status) {
                res = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }


        return (int) (res % MOD);

    }

    private static boolean possible(int number, int unitTime, ArrayList<Integer> C, long time) {

        int n = C.size();
        int index = 0;
        long total;

        for (int i = 0; i < number; i++) {

            total = 0;

            while (total < time && index < n) {

                System.out.println(C.get(index) * unitTime);
                System.out.println((long)C.get(index) * unitTime);

                total += ((long)C.get(index) * unitTime);
                if (total <= time) {
                    index++;
                }
            }

            if (index == n) {
                return true;
            }
        }

        return false;
    }
}
