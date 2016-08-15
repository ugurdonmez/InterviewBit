package hashing.points_on_the_straight_line;

/**
 * Created by ugurdonmez on 15/08/16.
 */
public class Solution {



}

class Line {

    private final Point start;
    private final Point end;
    private final double m;
    private final double b;

    public Line(Point start, Point end) {
        this.start = start;
        this.end = end;

        this.m = (double)(end.getY() - start.getY()) / (end.getX() - start.getX());
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

        if (this.start.getX() > x && this.end.getX() < x) {
            return true;
        }

        return false;
    }

    public double getY (double x) {

        return this.m * x - this.b;

    }

    @Override
    public int hashCode() {
        int result = 1;
        result = 31 *  Double.hashCode(m) + 17 * Double.hashCode(b) ;
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

        if (line.m != this.m) {
            return false;
        }

        return true;
    }
}

class Point {

    private final double x;
    private final double y;

    public Point(double x, double y) {
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
