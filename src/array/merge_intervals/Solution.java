package array.merge_intervals;

/**
 * Created by ugurdonmez on 05/08/16.
 */

import java.util.ArrayList;

/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
public class Solution {

    public ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {



        ArrayList<Interval> result = new ArrayList<>();

        if (intervals.size() == 1) {
            result.add(newInterval);
            return result;
        }

        int start = Integer.MAX_VALUE;
        int end = Integer.MIN_VALUE;
        boolean add = false;
        boolean isMerged = false;

        for (Interval interval : intervals) {
            if (Interval.isMerge(interval, newInterval)) {
                start = Integer.min(interval.start, start);
                start = Integer.min(newInterval.start, start);
                end = Integer.max(interval.end, end);
                end = Integer.max(newInterval.end, end);
                add = true;
            } else {
                if (add == false) {
                    result.add(interval);
                } else {
                    result.add(new Interval(start, end));
                    add = false;
                    isMerged = true;
                }
            }
        }

        if (add == true) {
            result.add(new Interval(start, end));
            isMerged = true;
        }



        if (isMerged == false) {
            // check beginning
            if (intervals.get(0).start > newInterval.end) {
                result.add(0, newInterval);
            } else if (intervals.get(intervals.size()-1).end < newInterval.start) {
                result.add(newInterval);
            } else {
                int index = 1;
                while (index < intervals.size()) {
                    if (intervals.get(index-1).end < newInterval.start && intervals.get(index).start > newInterval.end) {
                        result.add(index, newInterval);
                        break;
                    }
                }
            }
        }


        return result;
    }
}

class Interval {
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

        return false;
    }
}