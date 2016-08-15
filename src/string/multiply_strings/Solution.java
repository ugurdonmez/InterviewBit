package string.multiply_strings;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by ugurdonmez on 09/08/16.
 */
public class Solution {

    public static void main(String [] args) {

        System.out.println(multiplyDigit("429", '5'));

        System.out.println(sumToString("999", "11"));

        System.out.println(multiply("1111", "22"));

    }


    public static String multiply(String a, String b) {

        if (a.length() < 1 || b.length() < 1) {
            return "";
        }

        if (a.equals("0") || b.equals("0")) {
            return "0";
        }

        if (a.length() > b.length()) {
            return multiply(b, a);
        }

        a = (new StringBuilder(a)).reverse().toString();
        b = (new StringBuilder(b)).reverse().toString();

        String sum = multiplyDigit(a, b.charAt(0));

        Map<Character, String> map = new HashMap<>();

        map.put(b.charAt(0), sum);

        for (int i = 1; i < b.length(); i++) {

            String sumLocal;

            if (map.containsKey(b.charAt(i))) {
                sumLocal = map.get(b.charAt(i));
            } else {
                sumLocal = multiplyDigit(a, b.charAt(i));
                map.put(b.charAt(i), sumLocal);
            }

            StringBuilder stringBuilder = new StringBuilder(sumLocal);

            for (int j = 0; j < i; j++) {
                stringBuilder.insert(0, "0");
            }

            sum = sumToString(sum, stringBuilder.toString());
        }

        StringBuilder result = (new StringBuilder(sum)).reverse();

        while (result.charAt(0) == '0') {
            result.deleteCharAt(0);
        }

        return result.toString();
    }


    public static String multiplyDigit(String str, char multiplier) {

        StringBuilder buf = new StringBuilder();

        int carry = 0;

        int mult = multiplier - '0';

        for (char c : str.toCharArray()) {
            int x = c - '0';

            int r = x * mult + carry;

            buf.append(r % 10);
            carry = r / 10;
        }

        if (carry > 0) {
            buf.append(carry);
        }

        return buf.toString();
    }

    public static String sumToString(String str1, String str2) {

        if(str1.length() < str2.length()) {
            return sumToString(str2, str1);
        }

        StringBuilder buf = new StringBuilder();

        int carry = 0;

        int index = 0;

        for (index = 0; index < str2.length(); index++) {
            int x1 = str1.charAt(index) - '0';
            int x2 = str2.charAt(index) - '0';

            int r = x1 + x2 + carry;

            buf.append(r % 10);
            carry = r / 10;
        }

        while (index < str1.length()) {

            int x1 = str1.charAt(index) - '0';
            int r = x1 + carry;

            buf.append(r % 10);
            carry = r / 10;

            index++;
        }

        if (carry > 0) {
            buf.append(carry);
        }

        return buf.toString();
    }
}
