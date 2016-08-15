package binary_search.matrix_search;

import java.util.ArrayList;
import java.util.stream.IntStream;

/**
 * Created by ugurdonmez on 09/08/16.
 */
public class Solution {

    public static void main(String [] args) {


        int [][] matrixArray = {
                {3, 3, 11, 12, 14},
                {16, 17, 30, 34, 35},
                {45, 48, 49, 50, 52},
                {56, 59, 63, 63, 65},
                {67, 71, 72, 73, 79},
                {80, 84, 85, 85, 88},
                {88, 91, 92, 93, 94}
        };

        ArrayList<ArrayList<Integer>> matrix = new ArrayList<>();

        for (int [] array : matrixArray) {
            ArrayList<Integer> line = new ArrayList<>();

            IntStream.of(array).forEach(line::add);

            matrix.add(line);
        }

        for (ArrayList<Integer> array : matrix) {
            System.out.println(array);
        }

        System.out.println(searchMatrix(matrix, 11));
        System.out.println(searchMatrix(matrix, 12));
        System.out.println(searchMatrix(matrix, 14));
        System.out.println(searchMatrix(matrix, 3));
        System.out.println(searchMatrix(matrix, 88));
        System.out.println(searchMatrix(matrix, 94));
        System.out.println(searchMatrix(matrix, 80));

        System.out.println();

        System.out.println(searchMatrix(matrix, 1));
        System.out.println(searchMatrix(matrix, 100));
        System.out.println(searchMatrix(matrix, 89));
        System.out.println(searchMatrix(matrix, 44));
        System.out.println(searchMatrix(matrix, 13));
        System.out.println(searchMatrix(matrix, 86));
        System.out.println(searchMatrix(matrix, 33));

    }

    public static int searchMatrix(ArrayList<ArrayList<Integer>> matrix, int b) {

        int rowEnd = matrix.size();
        int columnEnd = matrix.get(0).size();

        return searchMatrix(matrix, b, 0, rowEnd-1, 0, columnEnd-1, rowEnd-1, columnEnd-1);

    }

    public static int searchMatrix(ArrayList<ArrayList<Integer>> matrix, int b, int rowStart, int rowEnd, int columnStart, int columnEnd, int maxRow, int maxColumn) {

        if (rowStart > rowEnd || columnStart > columnEnd) {
            return 0;
        }

        if (rowStart < 0 || rowEnd > maxRow || columnStart < 0 || columnEnd > maxColumn) {
            return 0;
        }

        int midRow = (rowStart + rowEnd) / 2;
        int midColumn = (columnStart + columnEnd) / 2;

        if (matrix.get(midRow).get(midColumn) == b) {
            return 1;
        } else if (matrix.get(midRow).get(midColumn) > b){
            int matrixResult = searchMatrix(matrix, b, rowStart, midRow-1, 0, maxColumn, maxRow, maxColumn);
            int lineResult = lineSearch(matrix, b, midRow, 0, midColumn-1);

            if (matrixResult == 1 || lineResult == 1) {
                return 1;
            } else {
                return 0;
            }
        } else {
            int matrixResult = searchMatrix(matrix, b, midRow+1, rowEnd, 0, maxColumn, maxRow, maxColumn);
            int lineResult = lineSearch(matrix, b, midRow, midColumn+1, maxColumn);

            if (matrixResult == 1 || lineResult == 1) {
                return 1;
            } else {
                return 0;
            }
        }
    }

    public static int lineSearch(ArrayList<ArrayList<Integer>> matrix, int b, int row, int columnStart, int columnEnd) {

        if (columnStart > columnEnd) {
            return 0;
        }

        int mid = (columnEnd + columnStart) / 2;

        if (matrix.get(row).get(mid) == b) {
            return 1;
        } else if (matrix.get(row).get(mid) < b) {
            return lineSearch(matrix, b, row, mid+1, columnEnd);
        } else {
            return lineSearch(matrix, b, row, columnStart, mid-1);
        }
    }
}
