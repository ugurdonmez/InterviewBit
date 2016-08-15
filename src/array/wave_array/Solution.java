package array.wave_array;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by ugurdonmez on 07/08/16.
 */
public class Solution {

    public ArrayList<Integer> wave(ArrayList<Integer> array) {

        if (array.size() <= 1) {
            return array;
        }

        Collections.sort(array);

        ArrayList<Integer> list = new ArrayList<>();

        for (int i = 0; i < array.size()-1; i = i + 2) {
            list.add(array.get(i+1));
            list.add(array.get(i));
        }

        if (array.size() % 2 == 1) {
            list.add(array.get(array.size()-1));
        }

        return list;
    }

}
