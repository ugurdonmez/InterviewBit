package math.excel_column_number;

/**
 * Created by user on 08/08/16.
 */
public class Solution {

    public static void main(String [] args) {

        System.out.println(titleToNumber("AB"));

    }
    public static int titleToNumber(String string) {

        int number = 0;

        int power = 1;
        for (int i = string.length() - 1; i >= 0; i--) {
            number += power * (Math.abs('A'- string.charAt(i)) + 1);
            power *= 26;
        }

        return number;
    }


}
