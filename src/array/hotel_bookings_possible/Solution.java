package array.hotel_bookings_possible;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by ugurdonmez on 07/08/16.
 */
public class Solution {

    public boolean hotel(ArrayList<Integer> arrive, ArrayList<Integer> depart, int K) {

        ArrayList<Reservation> list = new ArrayList<>();

        for (int i = 0; i < arrive.size(); i++) {
            list.add(new Reservation(arrive.get(i), true));
            list.add(new Reservation(depart.get(i), false));
        }

        Collections.sort(list);

        int max = 0;
        int current = 0;

        for (Reservation r : list) {
            if (r.type == true) {
                current++;
                if (current > max) {
                    max = current;
                }
            } else {
                current--;
            }
        }

        return max <= K;
    }
}

class Reservation implements Comparable<Reservation>{
    final int time;
    final boolean type;

    public Reservation(int enter, boolean type) {
        this.time = enter;
        this.type = type;
    }

    @Override
    public int compareTo(Reservation o) {
        if (this.time == o.time) {
            return Boolean.compare(this.type, o.type);
        } else {
            return Integer.compare(this.time, o.time);
        }
    }
}