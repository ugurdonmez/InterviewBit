package dynamic_programming.regular_expression;

/**
 * Created by ugurdonmez on 08/09/16.
 */

/**
 *

 Implement regular expression matching with support for '.' and '*'.

 '.' Matches any single character.
 '*' Matches zero or more of the preceding element.

 The matching should cover the entire input string (not partial).

 The function prototype should be:

 int isMatch(const char *s, const char *p)

 Some examples:

 isMatch("aa","a") → 0
 isMatch("aa","aa") → 1
 isMatch("aaa","aa") → 0
 isMatch("aa", "a*") → 1
 isMatch("aa", ".*") → 1
 isMatch("ab", ".*") → 1
 isMatch("aab", "c*a*b") → 1

 Return 0 / 1 ( 0 for false, 1 for true ) for this problem

 */

public class Solution {

    public int isMatch(final String s, final String p) {

        if (p.length() == 0) {
            return s.length() == 0 ? 1 : 0;
        }

        //p's length 1 is special case
        if (p.length() == 1 || p.charAt(1) != '*'){
            if(s.length() < 1 || (p.charAt(0) != '.' && s.charAt(0) != p.charAt(0))) {
                return 0;
            }
            return isMatch(s.substring(1), p.substring(1));
        } else {
            int len = s.length();
            int i = -1;

            while(i<len && (i < 0 || p.charAt(0) == '.' || p.charAt(0) == s.charAt(i))){
                if(isMatch(s.substring(i+1), p.substring(2)) == 1) {
                    return 1;
                }

                i++;
            }
            return 0;
        }
    }

}
