package hashing.equal;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

/**
 * Created by ugurdonmez on 15/08/16.
 */
public class Solution {

    public static void main(String [] args) {

        int [] array = {3, 4, 7, 1, 2, 9, 8};

        ArrayList<Integer> list = new ArrayList<>();

        IntStream.of(array).forEach(list::add);

        System.out.println(equal(list));

    }

    public static ArrayList<Integer> equal(ArrayList<Integer> list) {

        ArrayList<Integer> result = new ArrayList<>();
        ArrayList<Quadro> res = new ArrayList<>();

        if (list.size() < 4) {
            return result;
        }

        Map<Integer, Pair> map = new HashMap<>();


        for (int a = 0; a < list.size(); a++) {
            for (int b = a+1; b < list.size(); b++) {

                int sum = list.get(a) + list.get(b);

                if (map.containsKey(sum)) {
                    Pair pair = map.get(sum);

                    if (a != pair.x && a!= pair.y && b != pair.x && b != pair.y) {
                        res.add(new Quadro(pair.x, pair.y, a, b));
                    }
                } else {
                    map.put(sum, new Pair(a, b));
                }
            }
        }

        Collections.sort(res);

        if (res.size() != 0) {
            result.add(res.get(0).x);
            result.add(res.get(0).y);
            result.add(res.get(0).z);
            result.add(res.get(0).t);
        }

        return result;
    }
}

class Pair {
    final int x;
    final int y;

    public Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

class Quadro implements Comparable<Quadro>{
    final int x;
    final int y;
    final int z;
    final int t;

    public Quadro(int x, int y, int z, int t) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.t = t;
    }

    @Override
    public int compareTo(Quadro o) {
        if (this.x == o.x) {
            if (this.y == o.y) {
                if (this.z == o.z) {
                    return Integer.compare(this.t, o.t);
                } else {
                    return Integer.compare(this.z, o.z);
                }
            } else {
                return Integer.compare(this.y, o.y);
            }
        } else {
            return Integer.compare(this.x, o.x);
        }
    }
}