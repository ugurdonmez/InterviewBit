package array.find_permutation;

import java.util.ArrayList;

/**
 * Created by ugurdonmez on 06/08/16.
 */
public class Solution {

    public static void main(String [] args) {

        System.out.println(findPerm("ID", 3));

    }

    public static ArrayList<Integer> findPerm(final String A, int B) {

        ArrayList<Integer> result = new ArrayList<>();

        int iCount = B;
        int dCount = 1;

        for (int i = A.length()-1; i >=0; i--) {
            if (A.charAt(i) == 'I') {
                result.add(0, iCount);
                iCount--;
            } else {
                result.add(0, dCount);
                dCount++;
            }
        }

        result.add(0, dCount);

        return result;
    }

}
