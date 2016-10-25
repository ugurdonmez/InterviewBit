package zalando;

/**
 * Created by ugurdonmez on 22/10/16.
 */
public class Question1 {

    public static void main(String [] args) {





    }

    public static int solution(String string) {
        // write your code in Java SE 8


        if (string == null) {
            return -1;
        }

        if (string.length() == 0) {
            return -1;
        }

        if (!containsCapital(string)) {
            return -1;
        }

        int max = -1;

        for (int i = 0; i < string.length(); i++) {
            for (int j = i+1; j <= string.length(); j++) {
                System.out.println(string.substring(i, j));
                if (isValidPassword(string.substring(i, j))) {
                    max = Integer.max(max, string.substring(i, j).length());
                }
            }
        }

        return max;
    }

    public static boolean isValidPassword(String string) {

        //contains number
        if (containsNumeric(string)) {
            return false;
        }

        //not contain capital
        if (!containsCapital(string)) {
            return false;
        }

        return true;
    }

    public static boolean containsNumeric(String string) {

        for (char c : string.toCharArray()) {
            if (c >= '0' && c <= '9') {
                return true;
            }
        }

        return false;
    }

    public static boolean containsCapital(String string) {
        for (char c : string.toCharArray()) {
            if (c >= 'A' && c <= 'Z') {
                return true;
            }
        }

        return false;
    }

}
