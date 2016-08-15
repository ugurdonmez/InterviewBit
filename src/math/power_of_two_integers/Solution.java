package math.power_of_two_integers;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;

/**
 * Created by user on 08/08/16.
 */
public class Solution {

    public static void main(String [] args) {
        System.out.println(isPower(4));

        System.out.println(isPower(27));
        System.out.println(isPower(10));

        System.out.println(isPower(1024064001));

    }

    public static boolean isPower(int number) {

        if (isPrime(number)) {
            return true;
        }

        List<Integer> primes = new ArrayList<>();

        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (isPrime(i)) {
                primes.add(i);
            }
        }

        for (int i = 0; i < primes.size(); i++) {
            long product = 1;

            while (product < number) {
                product = product * primes.get(i);
            }

            if (number % product == 0) {
                return true;
            }
        }

        return false;
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
