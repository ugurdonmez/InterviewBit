package binary_search.square_root_of_integer;

/**
 * Created by ugurdonmez on 10/08/16.
 */
public class Solution {

    public static void main(String [] args) {

        System.out.println(sqrt(2147483647));

        for (int i = 0; i <= 100; i++) {
            System.out.println(i + " " + sqrt(i));
        }

    }

    public static int sqrt(int a) {

        int start = 0;
        int end = a / 2 + 1;

        while (start <= end) {

            int mid = (start + end)  >> 1;

            long midSquare = (long) mid * mid;
            long midSquareForward = (long) (mid + 1) * (mid + 1);

            if (a == midSquare) {
                return mid;
            }

            if (a > midSquare && a < midSquareForward) {
                return mid;
            }

            if (a > midSquare) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return -1;
    }
}
