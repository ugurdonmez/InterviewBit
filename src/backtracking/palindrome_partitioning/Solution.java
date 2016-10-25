package backtracking.palindrome_partitioning;

import java.util.ArrayList;

/**
 * Created by ugurdonmez on 17/08/16.
 */
public class Solution {

    public static void main(String [] args) {

        System.out.println(partition("aabcb"));

    }

    public static ArrayList<ArrayList<String>> partition(String string) {

        ArrayList<ArrayList<String>> results = new ArrayList<>();

        partitionHelper(string, 0, results);

        return results;
    }

    public static void partitionHelper(String string, int index, ArrayList<ArrayList<String>> results) {

        if (index == string.length()) {
            results.add(new ArrayList<>());
            return;
        }

        for (int i = index; i < string.length(); i++) {
            String left = string.substring(index, i+1);

            if (isPalindrome(left)) {
                ArrayList<ArrayList<String>> resultsCopy = new ArrayList<>();
                partitionHelper(string, i+1, resultsCopy);


                for (ArrayList<String> list : resultsCopy) {
                    list.add(0, left);
                    results.add(list);
                }

            }
        }

    }

    public static boolean isPalindrome(String s) {
        int n = s.length();
        for (int i=0;i<(n / 2);++i) {
            if (s.charAt(i) != s.charAt(n - i - 1)) {
                return false;
            }
        }

        return true;
    }
}
