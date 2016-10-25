package dynamic_programming.the_longest_increasing_subsequence;

import java.util.ArrayList;

/**
 * Created by ugurdonmez on 07/09/16.
 */
public class Solution {

    public static void main(String [] args) {

        ArrayList<Integer> list = new ArrayList<>();

        list.add(1);

        System.out.println(lis(list));

    }

    public static int lis(ArrayList<Integer> list) {

        int lisArray[] = new int[list.size()];
        int i,j,max = 0;

          /* Initialize LIS values for all indexes */
        for ( i = 0; i < list.size(); i++ )
            lisArray[i] = 1;

           /* Compute optimized LIS values in bottom up manner */
        for ( i = 1; i < list.size(); i++ )
            for ( j = 0; j < i; j++ )
                if ( list.get(i) > list.get(j) && lisArray[i] < lisArray[j] + 1)
                    lisArray[i] = lisArray[j] + 1;

           /* Pick maximum of all LIS values */
        for ( i = 0; i < list.size(); i++ )
            if ( max < lisArray[i] )
                max = lisArray[i];

        return max;
    }

}
