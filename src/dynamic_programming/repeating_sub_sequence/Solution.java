package dynamic_programming.repeating_sub_sequence;

/**
 * Created by ugurdonmez on 08/09/16.
 */
public class Solution {

    public static int getRepeating(String string) {

        int [][] array = new int[string.length()+1][string.length()+1];

        for (int i = 0; i < string.length()+1; i++) {
            array[i][0] = 0;
            array[0][i] = 0;
        }

        for (int i = 1; i < string.length()+1; i++) {
            for (int j = 1; j < string.length()+1; j++) {
                if (i == j || string.charAt(i-1) != string.charAt(j-1)) {
                    array[i][j] = Integer.max(array[i-1][j], array[i][j-1]);
                } else {
                    array[i][j] = array[i-1][j-1] + 1;
                }
            }
        }

        return array[string.length()][string.length()];
    }

}
