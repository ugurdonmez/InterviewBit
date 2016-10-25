package dynamic_programming.max_product_subarray;

import java.util.List;

/**
 * Created by ugurdonmez on 06/09/16.
 */
public class Solution {

    static int maxProduct(final List<Integer> arr) {
        int n = arr.size();
        // max positive product ending at the current position
        int max_ending_here = 1;

        // min negative product ending at the current position
        int min_ending_here = 1;

        // Initialize overall max product
        int max_so_far = 1;

        /* Traverse through the array. Following
           values are maintained after the ith iteration:
           max_ending_here is always 1 or some positive product
                           ending with arr[i]
           min_ending_here is always 1 or some negative product
                           ending with arr[i] */
        for (int i = 0; i < n; i++)
        {
            /* If this element is positive, update max_ending_here.
                Update min_ending_here only if min_ending_here is
                negative */
            if (arr.get(i) > 0)
            {
                max_ending_here = max_ending_here*arr.get(i);
                min_ending_here = Integer.min (min_ending_here * arr.get(i), 1);
            }

            /* If this element is 0, then the maximum product cannot
               end here, make both max_ending_here and min_ending
              _here 0
               Assumption: Output is alway greater than or equal to 1. */
            else if (arr.get(i) == 0)
            {
                max_ending_here = 1;
                min_ending_here = 1;
            }

            /* If element is negative. This is tricky
               max_ending_here can either be 1 or positive.
               min_ending_here can either be 1 or negative.
               next min_ending_here will always be prev.
               max_ending_here * arr[i]
               next max_ending_here will be 1 if prev
               min_ending_here is 1, otherwise
               next max_ending_here will be
                           prev min_ending_here * arr[i] */
            else
            {
                int temp = max_ending_here;
                max_ending_here = Integer.max (min_ending_here * arr.get(i), 1);
                min_ending_here = temp * arr.get(i);
            }

            // update max_so_far, if needed
            if (max_so_far <  max_ending_here)
                max_so_far  =  max_ending_here;
        }

        return max_so_far;
    }


    public int maxProduct1(final List<Integer> list) {

        int maxPro = Integer.MIN_VALUE;

        for (int i = 0; i < list.size(); i++) {
            int pro = list.get(i);

            if (pro > maxPro) {
                maxPro = pro;
            }

            for (int j = i+1; j < list.size(); j++) {

                pro *= list.get(j);

                if (pro > maxPro) {
                    maxPro = pro;
                }

            }
        }

        return maxPro;
    }

}
