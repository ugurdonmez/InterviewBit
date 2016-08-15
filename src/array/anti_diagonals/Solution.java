package array.anti_diagonals;

import java.util.ArrayList;

/**
 * Created by ugurdonmez on 07/08/16.
 */
public class Solution {

    public static ArrayList<ArrayList<Integer>> diagonal(ArrayList<ArrayList<Integer>> matrix) {

        if (matrix.size() <= 1) {
            return matrix;
        }

        ArrayList<ArrayList<Integer>> result = new ArrayList<>();

        int n = matrix.size();

        for (int i = 0; i < n; i++) {

            ArrayList<Integer> list = new ArrayList<>();

            int row = 0;
            int column = i;

            while (row < n && column >= 0) {
                list.add(matrix.get(row).get(column));
                row++;
                column--;
            }

            result.add(list);
        }

        for (int i = 1; i < n; i++) {
            ArrayList<Integer> list = new ArrayList<>();

            int row = i;
            int column = n-1;

            while (row < n && column >= 0) {
                list.add(matrix.get(row).get(column));
                row++;
                column--;
            }

            result.add(list);
        }

        return result;
    }

}
