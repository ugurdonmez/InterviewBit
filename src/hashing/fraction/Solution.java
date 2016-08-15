package hashing.fraction;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by ugurdonmez on 15/08/16.
 */
public class Solution {

    public static void main(String [] args) {

        //System.out.println(fractionToDecimal(10, 5));
        //System.out.println(fractionToDecimal(1, 2));
        //System.out.println(fractionToDecimal(1, 10));
        //System.out.println(fractionToDecimal(1, 100));
        //System.out.println(fractionToDecimal(1, 1000));
        //System.out.println(fractionToDecimal(1, 25));
        //System.out.println(fractionToDecimal(1, 3));
        //System.out.println(fractionToDecimal(5, 12));
        System.out.println(fractionToDecimal(1, 7));
        System.out.println(fractionToDecimal(-2147483648, -1));
        //System.out.println(fractionToDecimalEx(2, 3));
        //System.out.println(fractionToDecimalEx(1, 7));
        //System.out.println(fractionToDecimalEx(1, 12));

        //System.out.println(2.0/3);

    }

    public static String fractionToDecimal(int num, int den) {

        if (num == 0) {
            return "0";
        }

        if (den == 0) {
            return "";
        }

        StringBuilder buf = new StringBuilder();

        if ((num < 0 && den > 0) || (num > 0 && den < 0)) {
            buf.append("-");
        }

        long numerator = Math.abs((long)num);
        long denominator = Math.abs((long)den);

        // integer part
        buf.append(numerator/denominator);

        numerator = numerator - (numerator/denominator) * denominator;

        if (numerator == 0) {
            return buf.toString();
        }

        buf.append(".");

        Map<Long, Integer> map = new HashMap<>();

        numerator *= 10;

        // calculate fraction
        while (numerator > 0) {

            long fraction = numerator / denominator;
            buf.append(fraction);

            if (map.containsKey(numerator)) {
                int start = map.get(numerator);
                String recurrence = buf.substring(start, buf.length()-1);
                buf.delete(start, buf.length());
                buf.append("(").append(recurrence).append(")");
                break;
            } else {
                map.put(numerator, buf.length()-1);
            }

            numerator = numerator - (numerator/denominator) * denominator;

            numerator *= 10;
        }

        return buf.toString();
    }

    public static String fractionToDecimalEx(int numerator, int denominator) {
        if (numerator == 0)
            return "0";
        if (denominator == 0)
            return "";

        String result = "";

        // is result is negative
        if ((numerator < 0) ^ (denominator < 0)) {
            result += "-";
        }

        // convert int to long
        long num = numerator, den = denominator;
        num = Math.abs(num);
        den = Math.abs(den);

        // quotient
        long res = num / den;
        result += String.valueOf(res);

        // if remainder is 0, return result
        long remainder = (num % den) * 10;
        if (remainder == 0)
            return result;

        // right-hand side of decimal point
        HashMap<Long, Integer> map = new HashMap<Long, Integer>();
        result += ".";
        while (remainder != 0) {
            // if digits repeat
            if (map.containsKey(remainder)) {
                int beg = map.get(remainder);
                String part1 = result.substring(0, beg);
                String part2 = result.substring(beg, result.length());
                result = part1 + "(" + part2 + ")";
                return result;
            }

            // continue
            map.put(remainder, result.length());
            res = remainder / den;
            result += String.valueOf(res);
            remainder = (remainder % den) * 10;
        }

        return result;
    }

}
