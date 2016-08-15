package array.set_matrix_zeros;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by ugurdonmez on 06/08/16.
 */
public class Solution {


    public static void setZeroes(ArrayList<ArrayList<Integer>> a) {

        Set<Integer> rows = new HashSet<>();
        Set<Integer> columns = new HashSet<>();

        for (int i = 0; i < a.size(); i++) {
            for (int j = 0; j < a.get(i).size(); j++) {
                if (a.get(i).get(j) == 0) {
                    rows.add(i);
                    columns.add(j);
                }
            }
        }

        for (int i = 0; i < a.size(); i++) {
            for (int j = 0; j < a.get(i).size(); j++) {
                if (rows.contains(i) || columns.contains(j)) {
                    a.get(i).set(j, 0);
                }
            }
        }

    }

}
