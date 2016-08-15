package array.min_steps_in_infinite_grid;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ugurdonmez on 04/08/16.
 */
public class Solution {

    public static void main(String [] args) {

        List<Integer> X = new ArrayList<>();
        List<Integer> Y = new ArrayList<>();

        X.add(0);
        X.add(1);
        X.add(1);

        Y.add(0);
        Y.add(1);
        Y.add(2);

        System.out.println(coverPoints(X,Y));
    }

    public static int coverPoints(List<Integer> X, List<Integer> Y) {

        int step = 0;

        for (int i = 0; i < X.size()-1; i++) {
            step += getDiff(X.get(i), Y.get(i), X.get(i+1), Y.get(i+1));
        }

        return step;

    }

    public static int getDiff(int x1, int y1, int x2, int y2) {

        int difX = Math.abs(x1-x2);
        int difY = Math.abs(y1-y2);

        return Integer.max(difX, difY);
    }

}
