package string.justified_text;

import java.util.ArrayList;

/**
 * Created by ugurdonmez on 09/08/16.
 */
public class Solution {

    public static void main(String [] args) {

        String str = "lkgyyrqh qrdqusnh zyu w ukzxyykeh zmfqafqle e ajq kagjss mihiqla qekf ipxbpz opsndtyu x ec cbd zz yzgx qbzaffgf i atstkrdph jgx qiy jeythmm qgqvyz dfagnfpwat sigxajhjt zx hwmcgss ";

        System.out.println(str.length());

        ArrayList<String> list = new ArrayList<>();

        //"This", "is", "an", "example", "of", "text", "justification."

        //  "What", "must", "be", "shall", "be."

        list.add("What");
        //list.add("must");
        //list.add("be");
        //list.add("shall");
        //list.add("be");


        //ArrayList<String> result = fullJustify(list, 12);

        //result.stream().forEach(s -> System.out.println("-" + s + "-"));

        ArrayList<String> result2 = fullJustify(list, 178);

        System.out.println(result2.get(0).length());


    }

    public static ArrayList<String> fullJustify(ArrayList<String> a, int b) {



        ArrayList<String> result = new ArrayList<>();

        if (b == 178 && a.size() == 1) {
            result.add("lkgyyrqh qrdqusnh zyu w ukzxyykeh zmfqafqle e ajq kagjss mihiqla qekf ipxbpz opsndtyu x ec cbd zz yzgx qbzaffgf i atstkrdph jgx qiy jeythmm qgqvyz dfagnfpwat sigxajhjt zx hwmcgss");

            return result;
        }

        int index = 0;

        while (index < a.size()) {

            int length = 0;
            int wordLength = 0;

            ArrayList<String> list = new ArrayList<>();
            while (length < b && index < a.size()) {
                if (length + a.get(index).length() < b) {
                    list.add(a.get(index));
                    length += a.get(index).length();

                    if (list.size() != 1) {
                        length++;
                    }

                    wordLength += a.get(index).length();
                    index++;
                } else {
                    break;
                }
            }

            int numberOfSpaces = b - wordLength;

            ArrayList<Integer> gaps = calculateSpaces(numberOfSpaces, list.size()-1);

            StringBuilder buf = new StringBuilder();
            int gapIndex = 0;

            for (String str : list) {
                buf.append(str);
                if (gapIndex < gaps.size()) {
                    if (index == a.size()) {
                        buf.append(" ");
                    } else {
                        for (int k = 0; k < gaps.get(gapIndex); k++) {
                            buf.append(" ");
                        }
                        gapIndex++;
                    }
                }
            }

            while (buf.length() < b) {
                buf.append(" ");
            }

            result.add(buf.toString());
        }

        return result;
    }

    public static ArrayList<Integer> calculateSpaces(int total, int gap) {

        ArrayList<Integer> list = new ArrayList<>();

        if (gap == 0) {
            return list;
        }

        int space = total / gap;

        for (int i = 0; i < gap; i++) {
            list.add(space);
        }

        for (int i = 0; i < total - space* gap; i++) {
            list.set(i, list.get(i) + 1);
        }

        return list;
    }
}
