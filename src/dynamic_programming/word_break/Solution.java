package dynamic_programming.word_break;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * Created by ugurdonmez on 10/09/16.
 */
public class Solution {

    public static void main(String [] args) {

        ArrayList<String> words = new ArrayList<>();

        words.add("cat");
        words.add("cats");
        words.add("and");
        words.add("sand");
        words.add("dog");

        System.out.println(wordBreak("catsanddog", words));
    }

    public static int wordBreak(String string, ArrayList<String> wordList) {

        boolean [] hasEnd = new boolean[string.length()+1];

        Set<String> set = new HashSet<>(wordList);

        hasEnd[0] = true;

        for (int i = 0; i < string.length()+1; i++) {
            if (hasEnd[i] == false) {
                continue;
            }

            Iterator<String > it = set.iterator();
            while (it.hasNext()) {

                String str = it.next();

                int end = i + str.length();

                if (end > string.length()) {
                    continue;
                }

                String sub = string.substring(i, end);

                if (sub.equals(str)) {
                    hasEnd[end] = true;
                }
            }
        }

        return hasEnd[string.length()] ? 1 : 0;
    }

}
