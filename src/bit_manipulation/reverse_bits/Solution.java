package bit_manipulation.reverse_bits;

/**
 * Created by ugurdonmez on 11/08/16.
 */
public class Solution {

    public static void main(String [] args) {

        System.out.println(reverse(4294967295L));

    }

    public static long reverse(long a) {

        long b = 0;

        for (int i = 0; i < 32; i++) {


            long bit = a & 1;
            a = a >>> 1;
            b = b << 1;
            b = b | bit;
        }

        return b;
    }


}
