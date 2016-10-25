package hashing.points_on_the_straight_line;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.stream.IntStream;

/**
 * Created by ugurdonmez on 15/08/16.
 */
public class Solution {

    public static void main(String [] args) {

        int [] xArray = {1, 2, 3, 4};
        int [] yArray = {1, 2, 3, 4};

        ArrayList<Integer> xList = new ArrayList<>();
        IntStream.of(xArray).forEach(xList::add);

        ArrayList<Integer> yList = new ArrayList<>();
        IntStream.of(yArray).forEach(yList::add);

        System.out.println(maxPoints(xList, yList));
    }


    public static int maxPoints(ArrayList<Integer> x, ArrayList<Integer> y) {

        int max = 0;

        for (int i = 0; i < x.size(); i++) {

            Map<Line, Integer> map = new HashMap<>();

            for (int j = i+1; j < x.size(); j++) {

                Line line = new Line(new Point(x.get(i), y.get(i)), new Point(x.get(j), y.get(j)));

                if (map.containsKey(line)) {
                    map.put(line, map.get(line) + 1);
                } else {
                    map.put(line, 2);
                }
            }

            Iterator<Map.Entry<Line, Integer>> it = map.entrySet().iterator();

            while (it.hasNext()) {
                int size = it.next().getValue();

                max = Integer.max(max, size);
            }
        }

        return max;
    }


}

class Line {

    private final Point start;
    private final Point end;
    private final double m;
    private final double b;

    public Line(Point start, Point end) {
        this.start = start;
        this.end = end;

        this.m = (end.getY() - start.getY()) / (end.getX() - start.getX());
        this.b = start.getY() - this.m * start.getX();
    }

    public Point getStart() {
        return start;
    }

    public Point getEnd() {
        return end;
    }

    public double getM() {
        return m;
    }

    public double getB() {
        return b;
    }

    public boolean isInclude (double x) {
        if (this.start.getX() < x && this.end.getX() > x) {
            return true;
        }

        if (this.start.getX() > x) if (this.end.getX() < x) return true;
        return false;

    }

    public double getY (double x) {

        return this.m * x - this.b;

    }

    @Override
    public int hashCode() {
        int result = 1;
        result += 31 *  Double.hashCode(m) + 17 * Double.hashCode(b) ;
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null) {
            return false;
        }

        if ( !(o instanceof Line)) {
            return false;
        }

        Line line = (Line) o;

        if (line.b != this.b) {
            return false;
        }

        return line.m == this.m;

    }
}

class Point {

    private final double x;
    private final double y;

    Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    @Override
    public String toString() {
        return "x " + x + " y " +y;
    }
}
