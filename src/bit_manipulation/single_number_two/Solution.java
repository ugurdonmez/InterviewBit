package bit_manipulation.single_number_two;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

/**
 * Created by ugurdonmez on 10/08/16.
 */
public class Solution {

    public static void main(String [] args) {

        int [] array = {1,1,1,2,2,2,3,3,3,4};

        List<Integer> list = new ArrayList<>();

        IntStream.of(array).forEach(list::add);

        System.out.println(getUniqueElement(list));
    }

    public static int getUniqueElement(final List<Integer> arr) {
        int ones = 0 ; //At any point of time, this variable holds XOR of all the elements which have appeared "only" once.
        int twos = 0 ; //At any point of time, this variable holds XOR of all the elements which have appeared "only" twice.
        int not_threes ;

        for( int x : arr ) {
            twos |= ones & x ; //add it to twos if it exists in ones
            ones ^= x ; //if it exists in ones, remove it, otherwise, add it

            // Next 3 lines of code just converts the common 1's between "ones" and "twos" to zero.

            not_threes = ~(ones & twos) ;//if x is in ones and twos, dont add it to Threes.
            ones &= not_threes ;//remove x from ones
            twos &= not_threes ;//remove x from twos
        }
        return ones;
    }

}
