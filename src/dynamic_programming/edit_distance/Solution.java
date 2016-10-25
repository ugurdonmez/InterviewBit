package dynamic_programming.edit_distance;

/**
 * Created by ugurdonmez on 07/09/16.
 */
public class Solution {

    public static void main(String [] args) {

    }

    public int minDistance(String a, String b) {

        int [][] array = new int[a.length()+1][b.length()+1];

        for (int i = 0; i < a.length()+1; i++) {
            array[i][0] = i;
        }

        for (int i = 0; i < b.length()+1; i++) {
            array[0][i] = i;
        }

        for (int i = 1; i < a.length()+1; i++) {
            for (int j = 1; j < b.length()+1; j++) {
                if (a.charAt(i-1) == b.charAt(j-1)) {
                    array[i][j] = array[i-1][j-1];
                } else {
                    int min = Integer.min(array[i-1][j-1], array[i-1][j]);
                    min = Integer.min(min, array[i][j-1]);
                    array[i][j] = min + 1;
                }
            }
        }

        return array[a.length()][b.length()];
    }

}
