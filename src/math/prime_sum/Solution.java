package math.prime_sum;

import java.util.ArrayList;

/**
 * Created by user on 08/08/16.
 */
public class Solution {

    public ArrayList<Integer> primesum(int number) {

        ArrayList<Integer> list = new ArrayList<>();

        if (number < 4) {
            return list;
        }

        for (int i = 2; i< number; i++) {
            int j = number - i;

            if (isPrime(i) && isPrime(j)) {
                list.add(i);
                list.add(j);
                return list;
            }
        }

        return list;
    }

    private static boolean isPrime(int num) {
        if (num < 2) return false;
        if (num == 2) return true;
        if (num % 2 == 0) return false;
        for (int i = 3; i * i <= num; i += 2)
            if (num % i == 0) return false;
        return true;
    }
}
