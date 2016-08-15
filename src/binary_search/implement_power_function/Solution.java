package binary_search.implement_power_function;

/**
 * Created by user on 10/08/16.
 */
public class Solution {

    public static void main(String [] args) {

        System.out.println(powSolution(2, 11, 10000000));

        System.out.println(pow(71045970, 41535484, 64735492));
        System.out.println(powSolution(71045970, 41535484, 64735492));

        System.out.println(pow(5, 2, 3));
    }

    public static int powSolution(int x, int n, int d) {

        long a = x;
        long res = 1;

        while (n > 0) {

            if (n % 2 == 1) {
                res *= a;
                res %= d;
            }

            a *= a;
            a %= d;
            n = n >> 1;

        }

        res = (res + d) % d;

        return (int) res;

    }

    public static int pow(int x, int n, int d) {

        if (x == 0) {
            return 0;
        }

        if (n == 0) {
            return 1;
        }

        double pro = 1;
        double mult = x % d;

        while (n > 0) {
            if (n%2 == 1) {
                pro *= mult;
                pro = pro % d;
            }

            mult *= mult;
            mult = mult % d;
            n /= 2;
        }

        return (int) (pro * mult + d) % d;
    }
}
