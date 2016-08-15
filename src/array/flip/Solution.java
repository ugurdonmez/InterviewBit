package array.flip;

import java.util.ArrayList;

/**
 * Created by ugurdonmez on 07/08/16.
 */
public class Solution {

    public static void main(String [] args) {

        System.out.println(flip("1111"));

        System.out.println(flip("010"));

        System.out.println(flipOptimized("010"));

    }

    /**
     *
     Note what is the net change in number of 1s in string S when we flip bits of string S.
     Say it has A 0s and B 1s. Eventually, there are B 0s and A 1s.

     So, number of 1s increase by A - B. We want to choose a subarray which maximises this.
     Note, if we change 1s two -1, then sum of values will give us A - B.
     Then, we have to find a subarray with maximum sum, which can be done via Kadane’s Algorithm.

     * @param string
     * @return
     */
    public static ArrayList<Integer> flipOptimized(String string) {

        int [] array = new int[string.length()];

        for (int i = 0; i < string.length(); i++) {
            if (string.charAt(i) == '1') {
                array[i] = -1;
            } else {
                array[i] = 1;
            }
        }

        int bestTillNow = 0;
        int bestEndingHere = 0;
        int l = 0;

        int maxStart = Integer.MAX_VALUE;
        int maxEnd = Integer.MAX_VALUE;

        for (int i = 0; i < array.length; i++) {
            if(bestEndingHere+array[i]<0){
                l=i+1;
                bestEndingHere=0;
            } else {
                bestEndingHere+=array[i];
            }

            if(bestEndingHere>bestTillNow){
                bestTillNow=bestEndingHere;
                maxStart=l;
                maxEnd=i;
            }
        }

        if (maxStart == Integer.MAX_VALUE) {
            return new ArrayList<>();
        }

        ArrayList<Integer> list = new ArrayList<>();

        list.add(maxStart+1);
        list.add(maxEnd+1);

        return list;
    }

    public static ArrayList<Integer> flip(String string) {

        ArrayList<Integer> list = new ArrayList<>();

        // check that all 1
        boolean allOne = true;
        for (char c : string.toCharArray()) {
            if (c != '1') {
                allOne = false;
                break;
            }
        }

        if (allOne) {
            return list;
        }


        int maxOne = 0;
        int maxStart = 0;
        int maxEnd = 0;

        for (int i = 0; i < string.length(); i++) {
            for (int j= i; j < string.length(); j++) {

                int count = 0;

                for (int k = 0; k < string.length(); k++) {
                    if (k < i) {
                        if (string.charAt(k) == '1') {
                            count++;
                        }
                    } else if (k > j) {
                        if (string.charAt(k) == '1') {
                            count++;
                        }
                    } else {
                        if (string.charAt(k) == '0') {
                            count++;
                        }
                    }
                }

                if (count > maxOne) {
                    maxStart = i;
                    maxEnd = j;
                    maxOne = count;
                }

            }
        }

        list.add(maxStart+1);
        list.add(maxEnd+1);

        return list;
    }
}
