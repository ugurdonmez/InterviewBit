package array.max_distance;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * Created by ugurdonmez on 07/08/16.
 */
public class Solution {

    public static int maximumGapOptimizedSecond(final List<Integer> list) {

        if (list.size() == 0) {
            return -1;
        }

        if (list.size() == 1) {
            return 0;
        }

        StoreIndex [] array = new StoreIndex[list.size()];

        for (int i = 0; i < list.size(); i++) {
            array[i] = new StoreIndex(list.get(i), i);
        }

        Arrays.sort(array);

        int maxDistance = 0;
        int maxIndex = array[array.length-1].index;

        for (int i = array.length-2; i >= 0; i--) {
            maxDistance = Integer.max(maxDistance, maxIndex - array[i].index);
            maxIndex =Integer.max(maxIndex, array[i].index);
        }

        return maxDistance;
    }

    public static int maximumGapOptimized(final List<Integer> list) {

        StoreIndex [] array = new StoreIndex[list.size()];

        for (int i = 0; i < list.size(); i++) {
            array[i] = new StoreIndex(list.get(i), i);
        }

        Arrays.sort(array);

        int maxDistance = -1;

        for (int i = 0; i < array.length; i++) {
            for (int j = i; j < array.length; j++) {
                if (array[j].index - array[i].index > maxDistance) {
                    maxDistance = array[j].index - array[i].index;
                }
            }
        }

        return maxDistance;
    }

    public int maximumGap(final List<Integer> list) {

        int maxDistance = -1;

        for (int i = 0; i < list.size(); i++) {
            for (int j = list.size() - 1; j > i; j--) {
                if (list.get(j) >= list.get(i)) {
                    if (j - i > maxDistance) {
                        maxDistance = j - i;
                    }
                    break;
                }
            }
        }

        return maxDistance;
    }

}

class StoreIndex implements Comparable<StoreIndex> {
    final int value;
    final int index;

    public StoreIndex(int value, int index) {
        this.value = value;
        this.index = index;
    }


    @Override
    public int compareTo(StoreIndex o) {
        if (this.value == o.value) {
            return Integer.compare(this.index, o.index);
        } else {
            return Integer.compare(this.value, o.value);
        }
    }
}