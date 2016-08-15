package bit_manipulation.different_bits_sum_pairwise;

import java.util.ArrayList;

/**
 * Created by ugurdonmez on 10/08/16.
 */
public class Solution {

    public static void main(String [] args) {

        ArrayList<Integer> list = new ArrayList<>();

        list.add(1);
        list.add(3);
        list.add(5);

        System.out.println(cntBits(list));
        System.out.println(cntBitsEfficient(list));
    }

    public static int cntBitsEfficient(ArrayList<Integer> list) {

        int ans = 0;

        for (int i = 0; i < 32; i++) {

            int count = 0;

            for (int j = 0; j < list.size(); j++) {

                int mask = (1 << i);
                int x = list.get(j);

                int bit = mask & x;
                bit = bit >>> i;

                count += bit;
            }

            ans += (count) * (list.size() - count) * 2;
            ans %= 1000000009;
        }

        return ans % 1000000009;
    }

    public static int cntBits(ArrayList<Integer> list) {

        long sum = 0;

        for (int i = 0; i < list.size(); i++) {
            for (int j = i+1; j < list.size(); j++) {
                sum += getNumberOf1Bits(list.get(i) ^ list.get(j));
                sum %= 1000000009;
            }
        }

        sum *= 2;
        sum %= 1000000009;

        return (int) sum;
    }

    public static int getNumberOf1Bits(int n) {

        int count = 0;

        int index = 0;

        while (index < 32) {

            index++;

            if ((n & 1) == 1) {
                count ++;
            }

            n = n >> 1;
        }

        return count;
    }
}
