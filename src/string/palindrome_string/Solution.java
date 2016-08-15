package string.palindrome_string;

/**
 * Created by ugurdonmez on 09/08/16.
 */
public class Solution {

    public static void main(String [] args) {

        System.out.println(isPalindrome("A man, a plan, a canal: Panama"));
        System.out.println(isPalindrome("race a car"));
        System.out.println(isPalindrome("1a2"));

    }

    public static int isPalindrome(String string) {

        int start = 0;
        int end = string.length()-1;

        while (start < end) {
            if (!Character.isAlphabetic(string.charAt(start)) && !Character.isDigit(string.charAt(start))) {
                start++;
            } else if (!Character.isAlphabetic(string.charAt(end)) && !Character.isDigit(string.charAt(end))) {
                end--;
            } else {
                char c1 = Character.toLowerCase(string.charAt(start));
                char c2 = Character.toLowerCase(string.charAt(end));

                if (c1 != c2) {
                    return 0;
                }

                start++;
                end--;
            }
        }

        return 1;
    }

}
