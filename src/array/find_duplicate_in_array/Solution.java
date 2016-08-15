package array.find_duplicate_in_array;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by ugurdonmez on 06/08/16.
 */
public class Solution {

    public int repeatedNumberOptimized(int [] array) {

        int sqrt = (int) Math.sqrt(array.length);

        if (sqrt * sqrt < array.length) {
            sqrt++;
        }

        Map<Integer, Integer> map = new HashMap<>();

        for (int a : array) {
            int key = 0;
            if (a % sqrt == 0) {
                key = (a-1) / sqrt;
            } else {
                key = a / sqrt;
            }

            if (map.containsKey(key)) {
                map.put(key, map.get(key)+1);
            } else {
                map.put(key, 1);
            }
        }

        for (int i = 0; i <= sqrt; i++) {
            if (map.containsKey(i) && map.get(i) > sqrt) {

                int [] check = new int[sqrt+1];

                for (int a : array) {
                    int key = 0;
                    if (a % sqrt == 0) {
                        key = (a-1) / sqrt;
                    } else {
                        key = a / sqrt;
                    }

                    if (key == i) {
                        if (check[a-i*sqrt] > 0) {
                            return a;
                        } else {
                            check[a-i*sqrt] = 1;
                        }
                    }
                }

            }
        }

        return -1;
    }

    public int repeatedNumber(final List<Integer> a) {

        int [] array = new int[a.size()+1];

        for (int i : a) {
            if (array[i] != 0) {
                return i;
            } else {
                array[i]++;
            }
        }

        return -1;
    }

}
