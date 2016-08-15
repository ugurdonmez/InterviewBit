package two_pointers.tree_sum_zero;

import java.util.*;

/**
 * Created by ugurdonmez on 08/08/16.
 */
public class Solution {

    public ArrayList<ArrayList<Integer>> threeSum(ArrayList<Integer> list) {

        Collections.sort(list);

        Set<Triplet> result = new HashSet<>();

        for (int i = 0; i < list.size(); i++) {
            int first = 0;
            int last = list.size()-1;

            while (first < last) {
                if (first == i) {
                    first++;
                    continue;
                }

                if (last == i) {
                    last--;
                    continue;
                }

                int sum  = list.get(i) + list.get(first) + list.get(last);

                if (sum == 0) {
                    ArrayList<Integer> r = new ArrayList<>();
                    r.add(list.get(i));
                    r.add(list.get(first));
                    r.add(list.get(last));
                    Collections.sort(r);
                    result.add(new Triplet(r.get(0), r.get(1), r.get(2)));
                    first++;
                }else if (sum > 0) {
                    last--;
                } else if (sum < 0) {
                    first++;
                }
            }
        }

        ArrayList<ArrayList<Integer>> returnList = new ArrayList<>();

        Iterator<Triplet> it = result.iterator();

        while (it.hasNext()) {
            ArrayList<Integer> r = new ArrayList<>();
            Triplet t = it.next();
            r.add(t.x1);
            r.add(t.x2);
            r.add(t.x3);
            returnList.add(r);
        }

        return returnList;
    }

}

class Triplet {
    final int x1;
    final int x2;
    final int x3;

    public Triplet(int x1, int x2, int x3) {
        this.x1 = x1;
        this.x2 = x2;
        this.x3 = x3;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Triplet triplet = (Triplet) o;

        if (x1 != triplet.x1) return false;
        if (x2 != triplet.x2) return false;
        return x3 == triplet.x3;

    }

    @Override
    public int hashCode() {
        int result = x1;
        result = 31 * result + x2;
        result = 31 * result + x3;
        return result;
    }
}