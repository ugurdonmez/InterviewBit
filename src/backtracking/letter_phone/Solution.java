package backtracking.letter_phone;

import java.util.ArrayList;
import java.util.Collections;
import java.util.stream.Collectors;

/**
 * Created by ugurdonmez on 16/08/16.
 */
public class Solution {

    public static void main(String [] args) {

        System.out.println(letterCombinations("0"));
        System.out.println(letterCombinations("1"));

    }

    public static ArrayList<String> letterCombinations(String string) {

        ArrayList<String> list = new ArrayList<>();

        letterCombinationsHelper(string, 0, list);

        Collections.sort(list);

        return list;
    }

    public static void letterCombinationsHelper(String string, int index, ArrayList<String> list) {

        if (index == string.length()) {
            list.add("");
            return;
        }

        letterCombinationsHelper(string, index+1, list);

        char c = string.charAt(index);

        if (c == '2') {
            ArrayList<String> copyList = (ArrayList<String>)list.clone();
            list.clear();

            for (String s : copyList) {
                list.add('a' + s);
                list.add('b' + s);
                list.add('c' + s);
            }
        } else if (c == '3') {
            ArrayList<String> copyList = (ArrayList<String>)list.clone();
            list.clear();

            for (String s : copyList) {
                list.add('d' + s);
                list.add('e' + s);
                list.add('f' + s);
            }
        } else if (c == '4') {
            ArrayList<String> copyList = (ArrayList<String>)list.clone();
            list.clear();

            for (String s : copyList) {
                list.add('g' + s);
                list.add('h' + s);
                list.add('i' + s);
            }
        } else if (c == '5') {
            ArrayList<String> copyList = (ArrayList<String>)list.clone();
            list.clear();

            for (String s : copyList) {
                list.add('j' + s);
                list.add('k' + s);
                list.add('l' + s);
            }
        } else if (c == '6') {
            ArrayList<String> copyList = (ArrayList<String>)list.clone();
            list.clear();

            for (String s : copyList) {
                list.add('m' + s);
                list.add('n' + s);
                list.add('o' + s);
            }
        } else if (c == '7') {
            ArrayList<String> copyList = (ArrayList<String>)list.clone();
            list.clear();

            for (String s : copyList) {
                list.add('p' + s);
                list.add('r' + s);
                list.add('s' + s);
                list.add('q' + s);
            }
        } else if (c == '8') {
            ArrayList<String> copyList = (ArrayList<String>)list.clone();
            list.clear();

            for (String s : copyList) {
                list.add('t' + s);
                list.add('u' + s);
                list.add('v' + s);
            }
        } else if (c == '9') {
            ArrayList<String> copyList = (ArrayList<String>)list.clone();
            list.clear();

            for (String s : copyList) {
                list.add('w' + s);
                list.add('x' + s);
                list.add('y' + s);
                list.add('z' + s);
            }
        } else if (c == '0') {
            ArrayList<String> copyList = (ArrayList<String>)list.clone();
            list.clear();

            for (String s : copyList) {
                list.add('0' + s);
            }
        } else if (c == '1') {
            ArrayList<String> copyList = (ArrayList<String>)list.clone();
            list.clear();

            list.addAll(copyList.stream().map(s -> '1' + s).collect(Collectors.toList()));
        }
    }

}
