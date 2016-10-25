package dynamic_programming.unique_paths_in_a_grid;

import java.util.ArrayList;

/**
 * Created by ugurdonmez on 10/09/16.
 */
public class Solution {

    public static void main(String [] args) {

        ArrayList<ArrayList<Integer>> matrix = new ArrayList<>();

        ArrayList<Integer> list = new ArrayList<>();

        list.add(0);
        list.add(0);

        matrix.add(list);

        System.out.println(uniquePathsWithObstacles(matrix));

    }

    public static int uniquePathsWithObstacles(ArrayList<ArrayList<Integer>> matrix) {

        if (matrix == null) {
            return 0;
        }

        if (matrix.size() < 1) {
            return 0;
        }

        if (matrix.size() == 1 && matrix.get(0).size() == 1) {
           if (matrix.get(0).get(0) == 1) {
               return 0;
           } else {
               return 1;
           }
        }

        int [][] array = new int[matrix.size()][matrix.get(0).size()];

        if (matrix.get(0).get(0) == 1 ) {
            array[0][0] = 0;
        } else {
            array[0][0] = 1;
        }

        for (int i = 1; i < matrix.get(0).size(); i++) {
            if (matrix.get(0).get(i) != 1 && array[0][i-1] != 0) {
                array[0][i] = 1;
            }
        }

        for (int i = 1; i < matrix.size(); i++) {
            if (matrix.get(i).get(0) != 1 && array[i-1][0] != 0) {
                array[i][0] = 1;
            }
        }

        for (int i = 1; i < matrix.size(); i++) {
            for (int j = 1; j < matrix.get(0).size(); j++) {
                if (matrix.get(i).get(j) == 1) {
                    array[i][j] = 0;
                } else {
                    array[i][j] = array[i-1][j] + array[i][j-1];
                }
            }
        }

        return array[matrix.size()-1][matrix.get(0).size()-1];
    }

}
