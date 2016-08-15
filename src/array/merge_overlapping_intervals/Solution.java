package array.merge_overlapping_intervals;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;

/**
 * Created by ugurdonmez on 05/08/16.
 */

public class Solution {

    public static void main(String [] args) {

        ArrayList<Interval> list = new ArrayList<>();

        list.add(new Interval(1,10));
        list.add(new Interval(2,9));
        list.add(new Interval(3,8));
        list.add(new Interval(4,7));
        list.add(new Interval(5,6));
        list.add(new Interval(6,6));

        System.out.println(merge(list));

    }

    public static ArrayList<Interval> merge(ArrayList<Interval> intervals) {

        ArrayList<Interval> result = new ArrayList<>();

        if (intervals.size() == 0) {
            return result;
        }

        Collections.sort(intervals);
        Stack<Interval> stack = new Stack<>();

        for (Interval interval : intervals) {
            if (stack.isEmpty()) {
                stack.push(interval);
            } else if (Interval.isMerge(stack.peek(), interval)) {
                stack.push(Interval.merge(stack.pop(), interval));
            } else {
                stack.push(interval);
            }
        }

        while (!stack.isEmpty()) {
            result.add(stack.pop());
        }

        Collections.sort(result);

        return result;
    }
}

class Interval implements Comparable<Interval>{

    int start;
    int end;

    Interval(int s, int e) {
        start = s;
        end = e;
    }

    public static boolean isMerge(Interval i1, Interval i2) {

        if (i1.start <= i2.end && i1.start >= i2.start) {
            return true;
        }

        if (i1.end >= i2.start && i1.end <= i2.end) {
            return true;
        }

        if (i2.start >= i1.start && i2.end <= i1.end) {
            return true;
        }

        return false;
    }

    public static Interval merge(Interval i1, Interval i2) {
        int start = Integer.min(i1.start, i2.start);
        int end = Integer.max(i1.end, i2.end);

        return new Interval(start, end);
    }

    @Override
    public int compareTo(Interval o) {
        return Integer.compare(this.start, o.start);
    }

    @Override
    public String toString() {
        return "Interval{" +
                "start=" + start +
                ", end=" + end +
                '}';
    }
}
