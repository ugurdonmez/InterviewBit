package dynamic_programming.min_sum_path_in_matrix;

import java.util.ArrayList;

/**
 * Created by ugurdonmez on 08/09/16.
 */
public class Solution {

    public int minPathSum(ArrayList<ArrayList<Integer>> matrix) {

        int [][] array = new int[matrix.size()][matrix.get(0).size()];

        array[0][0] = matrix.get(0).get(0);

        for (int i = 1; i < matrix.get(0).size(); i++) {
            array[0][i] = array[0][i-1] + matrix.get(0).get(i);
        }

        for (int i = 1; i < matrix.size(); i++) {
            array[i][0] = array[i-1][0] + matrix.get(i).get(0);
        }

        for (int i = 1; i < matrix.size(); i++) {
            for (int j = 1; j < matrix.get(0).size(); j++) {
                array[i][j] = Integer.min(array[i-1][j], array[i][j-1]) + matrix.get(i).get(j);
            }
        }

        return array[matrix.size()-1][matrix.get(0).size()-1];
    }


}
