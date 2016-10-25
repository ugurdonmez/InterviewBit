package hashing.anagrams;

import java.util.*;
import java.util.stream.IntStream;

/**
 * Created by ugurdonmez on 15/08/16.
 */
public class Solution {

    public static void main(String [] args) {

        String [] array = {"abbbaabbbabbbbabababbbbbbbaabaaabbaaababbabbabbaababbbaaabbabaabbaabbabbbbbababbbababbbbaabababba", "abaaabbbabaaabbbbabaabbabaaaababbbbabbbaaaabaababbbbaaaabbbaaaabaabbaaabbaabaaabbabbaaaababbabbaa", "babbabbaaabbbbabaaaabaabaabbbabaabaaabbbbbbabbabababbbabaabaabbaabaabaabbaabbbabaabbbabaaaabbbbab", "bbbabaaabaaaaabaabaaaaaaabbabaaaabbababbabbabbaabbabaaabaabbbabbaabaabaabaaaabbabbabaaababbaababb", "abbbbbbbbbbbbabaabbbbabababaabaabbbababbabbabaaaabaabbabbaaabbaaaabbaabbbbbaaaabaaaaababababaabab", "aabbbbaaabbaabbbbabbbbbaabbababbbbababbbabaabbbbbbababaaaabbbabaabbbbabbbababbbaaabbabaaaabaaaaba", "abbaaababbbabbbbabababbbababbbaaaaabbbbbbaaaabbaaabbbbbbabbabbabbaabbbbaabaabbababbbaabbbaababbaa", "aabaaabaaaaaabbbbaabbabaaaabbaababaaabbabbaaaaababaaabaabbbabbababaabababbaabaababbaabbabbbaaabbb"};

        List<String> list = new ArrayList<>();

        Arrays.stream(array).forEach(list::add);

        System.out.println(anagrams(list));

    }

    public static ArrayList<ArrayList<Integer>> anagrams(final List<String> list) {

        ArrayList<ArrayList<Integer>> result = new ArrayList<>();

        int [][] charMap = new int[list.size()][28];

        for (int i = 0; i < list.size(); i++) {

            for (char c : list.get(i).toCharArray()) {
                charMap[i][c-'a']++;
            }
        }

        Set<Integer> added = new HashSet<>();

        for (int i = 0; i < list.size(); i++) {

            if (added.contains(i)) {
                continue;
            }

            Set<Integer> add = new TreeSet<>();

            add.add(i);

            for (int j = i+1; j < list.size(); j++) {
                if (isAnagram(charMap[i], charMap[j])) {
                    add.add(i);
                    add.add(j);

                    added.add(i);
                    added.add(j);
                }
            }

            Iterator<Integer> it = add.iterator();

            ArrayList<Integer> res = new ArrayList<>();

            while (it.hasNext()) {
                res.add(it.next()+1);
            }

            result.add(res);
        }

        return result;
    }

    public static boolean isAnagram(int [] w1, int [] w2) {

        for (int i = 0; i < w1.length; i++) {
            if (w1[i] != w2[i]) {
                return false;
            }
        }

        return true;
    }

}
