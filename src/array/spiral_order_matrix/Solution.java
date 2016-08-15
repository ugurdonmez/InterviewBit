package array.spiral_order_matrix;

import java.util.ArrayList;

/**
 * Created by ugurdonmez on 07/08/16.
 */
public class Solution {

    public static void main(String [] args) {
        System.out.println(generateMatrix(3));
    }

    public static ArrayList<ArrayList<Integer>> generateMatrix(int n) {

        ArrayList<ArrayList<Integer>> result = new ArrayList<>();

        if (n == 0) {
            return result;
        }

        if (n == 1) {
            ArrayList<Integer> list = new ArrayList<>();
            list.add(1);
            result.add(list);
            return result;
        }

        for (int i = 0; i < n; i++) {
            ArrayList<Integer> list = new ArrayList<>(n);
            for (int j = 0; j < n; j++) {
                list.add(0);
            }
            result.add(list);
        }

        int top = 0;
        int bottom = n-1;
        int left = 0;
        int right = n-1;

        int count = 1;

        while (top <= bottom && left <= right) {

            // print top
            for (int i = left; i <= right; i++) {
                result.get(top).set(i, count++);
            }
            top++;

            // print right
            for (int i = top; i <= bottom; i++) {
                result.get(i).set(right, count++);
            }
            right--;

            if (top <= bottom) {
                for (int i = right; i >= left; i--) {
                    result.get(bottom).set(i, count++);
                }
                bottom--;
            }

            if (left <= right) {
                for (int i = bottom; i >= top; i--) {
                    result.get(i).set(left, count++);
                }
                left++;
            }
        }

        return result;
    }

}
