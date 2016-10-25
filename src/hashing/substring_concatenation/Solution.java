package hashing.substring_concatenation;

import java.util.*;

/**
 * Created by ugurdonmez on 15/08/16.
 */
public class Solution {

    public static void main(String [] args) {

        /*
        for (char a = 'a'; a <= 'z'; a = (char)(a + 1)) {
            for (char b = 'a'; b <= 'z'; b = (char)(b + 1)) {
                for (char c = 'a'; c <= 'z'; c = (char)(c + 1)) {
                    String str = String.valueOf(a) + String.valueOf(b) + String.valueOf(c);

                    System.out.println(str + " " + str.hashCode());
                }
            }
        }
        */

        String [] array = {"c", "b", "a", "c", "a", "a", "a", "b", "c"};

        ArrayList<String> stringArrayList = new ArrayList<>();

        Arrays.stream(array).forEach(stringArrayList::add);

        System.out.println(findSubstringMy("bcabbcaabbccacacbabccacaababcbb", stringArrayList));

    }

    public static ArrayList<Integer> findSubstringMy(String string, final List<String> stringList) {

        ArrayList<Integer> res = new ArrayList<>();

        if (string == null || stringList == null || stringList.size() == 0 || string.length() == 0)
            return res;

        long hash = 0;
        int length = 0;

        for (String str : stringList) {
            length += str.length();
            hash += str.hashCode();
        }

        Map<String, Integer> wordsMap = new HashMap<>();

        for (String str : stringList) {
            int val = 1;
            if (wordsMap.containsKey(str)) {
                val = wordsMap.get(str) + 1;
            }
            wordsMap.put(str, val);
        }

        int wordLength = stringList.get(0).length();

        for (int i = 0; i < string.length() - length + 1; i++) {

            long localHash = 0;

            for (int j = 0; j < stringList.size(); j++) {
                String localStr = string.substring(i+j*wordLength, i + (j+1)*wordLength);
                localHash += localStr.hashCode();
            }

            if (localHash == hash) {

                Map<String, Integer> map = new HashMap<>();

                for (int j = 0; j < stringList.size(); j++) {
                    String localStr = string.substring(i+j*wordLength, i + (j+1)*wordLength);
                    int val = 1;
                    if (map.containsKey(localStr)) {
                        val = map.get(localStr) + 1;
                    }
                    map.put(localStr, val);
                }

                if (wordsMap.equals(map)) {
                    res.add(i);
                }
            }
        }

        return res;
    }

    public ArrayList<Integer> findSubstringSecond(String string, final List<String> stringList) {

        ArrayList<Integer> res = new ArrayList<>();

        if (string == null || stringList == null || stringList.size() == 0 || string.length() == 0)
            return res;

        HashMap<String, Integer> words = new HashMap<>();


        for (String str : stringList) {
            int val = 1;
            if (words.containsKey(str)) {
                val = words.get(str) + 1;
            }
            words.put(str, val);
        }

        int len = stringList.get(0).length();

        int size = stringList.size();
        int index;

        for (int i = 0; i <= string.length() - len * size; i++) {

            index = i;
            int loop = size;
            HashMap<String, Integer> hashMap = new HashMap<>(words);

            for (int j = 0; j < loop; j++) {
                String str = string.substring(index + j * len, index + j * len + len);
                if (hashMap.containsKey(str)) {
                    int val = hashMap.get(str);
                    if (val == 1) {
                        hashMap.remove(str);
                    } else {
                        hashMap.put(str, val - 1);
                    }
                } else {
                    break;
                }
            }

            if (hashMap.isEmpty()) {
                res.add(i);
            }

        }

        return res;

    }


    public static ArrayList<Integer> findSubstring(String a, final List<String> b) {

        String [] array = b.toArray(new String[b.size()]);

        return findSubstring(a, array);
    }

    public static ArrayList<Integer> findSubstring(String string, String[] words) {

        ArrayList<Integer> result = new ArrayList<>();

        if(string == null || string.length() == 0 || words == null || words.length==0){
            return result;
        }

        //frequency of words
        HashMap<String, Integer> map = new HashMap<>();
        for(String w: words){
            if(map.containsKey(w)){
                map.put(w, map.get(w)+1);
            }else{
                map.put(w, 1);
            }
        }

        int len = words[0].length();

        for (int j = 0; j < len; j++) {
            HashMap<String, Integer> currentMap = new HashMap<>();
            int start = j;//start index of start
            int count = 0;//count total qualified words so far

            for (int i = j; i <= string.length()-len; i = i+len) {

                String sub = string.substring(i, i+len);

                if (map.containsKey(sub)) {

                    //set frequency in current map
                    if (currentMap.containsKey(sub)) {
                        currentMap.put(sub, currentMap.get(sub)+1);
                    } else {
                        currentMap.put(sub, 1);
                    }

                    count++;

                    while (currentMap.get(sub) > map.get(sub)) {
                        String left = string.substring(start, start+len);
                        currentMap.put(left, currentMap.get(left)-1);

                        count--;
                        start = start + len;
                    }


                    if (count == words.length) {
                        result.add(start); //add to result

                        //shift right and reset currentMap, count & start point
                        String left = string.substring(start, start+len);
                        currentMap.put(left, currentMap.get(left)-1);
                        count--;
                        start = start + len;
                    }
                } else {
                    currentMap.clear();
                    start = i+len;
                    count = 0;
                }
            }
        }

        return result;
    }

}
