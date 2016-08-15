package two_pointers.remove_duplicates_from_sorted_array;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Created by ugurdonmez on 08/08/16.
 */
public class Solution {

    public static void main(String [] args) {


        int [] array = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3};

        List<Integer> list = IntStream.of(array).boxed().collect(Collectors.toList());

        ArrayList<Integer> a = new ArrayList<>();

        a.add(0);
        a.add(0);
        a.add(0);
        a.add(1);
        a.add(1);
        a.add(1);
        a.add(1);

        System.out.println(remove(a));
    }

    public static int remove(ArrayList<Integer> list) {

        int length = list.size();

        if (list.size() == 1) {
            return 0;
        }

        HashSet<Integer> set = new HashSet<>();

        list.stream().forEach(set::add);

        list.clear();

        set.stream().forEach(list::add);

        return length - list.size();
    }

    public static int removeDuplicates(List<Integer> a) {

        int duplicates = 0;

        for (int i = 1; i < a.size(); i++) {

            int i1 = a.get(i-1);
            int i2 = a.get(i);

            if (i1 == i2) {
                duplicates++;
            }
        }

        int value = a.size() - duplicates;

        int index = 0;

        while (index < a.size()-1) {
            if (a.get(index) == a.get(index+1)) {
                a.remove(index);
            } else {
                index++;
            }
        }

        return value;
    }

}
