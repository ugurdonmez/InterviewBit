package binary_search.search_for_a_range;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

/**
 * Created by ugurdonmez on 10/08/16.
 */
public class Solution {

    public static void main(String [] args) {

        // int [] array = {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10};

        // int [] array = {2, 2, 6, 9, 9};

        // int [] array = {1};

        int [] array = {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 8, 8, 8, 8, 8, 8, 8, 8, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10};

        for (int i = 0; i < array.length; i++) {
            System.out.println(i + " " + array[i]);
        }

        ArrayList<Integer> list = new ArrayList<>();

        IntStream.of(array).forEach(list::add);

        System.out.println(searchRange(list, 10));
    }

    public static ArrayList<Integer> searchRange(final List<Integer> list, int b) {

        ArrayList<Integer> result = new ArrayList<>();

        int start = 0;
        int end = list.size()-1;

        int mid = 0;

        while (!(start > end)) {
            mid = (start+end) / 2;

            if (start == end && list.get(mid) != b) {
                result.add(-1);
                result.add(-1);
                return result;
            }

            if (list.get(mid) == b) {
                break;
            } else if (list.get(mid) > b) {
                end = mid-1;
            } else {
                start = mid+1;
            }
        }

        end = mid;
        start = 0;

        // find left
        while (start <= end) {

            if (mid > 1 && list.get(mid) == b && list.get(mid-1) == b && list.get(mid-2) != b) {
                mid = mid - 1;
                break;
            }

            if (mid > 0 && list.get(mid) == b && list.get(mid-1) != b) {
                break;
            }

            if (start == 0 && list.get(start) == b) {
                mid = start;
                break;
            }

            /*
            if (start == end) {
                mid = (start+end) / 2;
                break;
            }
            */

            mid = (start+end) / 2;

            if (list.get(mid) == b) {
                end = mid-1;
            } else {
                start = mid+1;
            }
        }

        result.add(mid);

        start = mid;
        end = list.size()-1;

        // find right
        while (start <= end) {

            if (mid < list.size()-2 && list.get(mid) == b && list.get(mid+1) == b && list.get(mid+2) != b) {
                mid = mid+1;
                break;
            }

            if (mid < list.size()-1 && list.get(mid) == b && list.get(mid+1) != b) {
                break;
            }

            if (end == list.size()-1 && list.get(end) == b) {
                mid = end;
                break;
            }

            /*
            if (start == end) {
                mid = (start+end) / 2;
                break;
            }
            */

            mid = (start+end) / 2;

            if (list.get(mid) == b) {
                start = mid+1;
            } else {
                end = mid-1;
            }
        }

        result.add(mid);

        return result;
    }

}
