package hashing.longest_substring_without_repeat;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by ugurdonmez on 15/08/16.
 */
public class Solution {

    public static void main(String [] args) {

        System.out.println(lengthOfLongestSubstring("abcabcbb"));
        System.out.println(lengthOfLongestSubstring("bbbbbbbb"));

    }

    public static int lengthOfLongestSubstring(String string) {

        int max = Integer.MIN_VALUE;

        for (int i = 0; i < string.length(); i++) {

            Set<Character> set = new HashSet<>();

            int index = i;
            while (index < string.length()) {
                if (set.contains(string.charAt(index))) {
                    max = Integer.max(max, set.size());
                    break;
                } else {
                    set.add(string.charAt(index));
                }
                index++;
            }

            if (index == string.length()) {
                max = Integer.max(max, set.size());
            }
        }

        return max;
    }

}
