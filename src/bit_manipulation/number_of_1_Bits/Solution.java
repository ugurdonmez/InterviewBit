package bit_manipulation.number_of_1_Bits;

/**
 * Created by ugurdonmez on 10/08/16.
 */
public class Solution {

    public static void main(String [] args) {

        System.out.println(getNumberOf1Bits(5));

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
