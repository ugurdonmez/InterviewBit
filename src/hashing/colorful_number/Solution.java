package hashing.colorful_number;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by ugurdonmez on 12/08/16.
 */
public class Solution {

    public static void main(String [] args) {

        System.out.println(colorful(12));
        System.out.println(colorful(23));
        System.out.println(colorful(111));

    }

    public static int colorful(int number) {

        Set<Integer> set = new HashSet<>();

        String str = Integer.toString(number);

        for (int i = 0; i < str.length(); i++) {
            for (int j = i+1; j <= str.length(); j++) {
                String sub = str.substring(i, j);

                    System.out.println(sub);

                    int pro = 1;

                    for (int k = 1; k <= sub.length(); k++) {
                        pro *= Integer.parseInt(sub.substring(k-1, k));
                    }

                    if (set.contains(pro)) {
                        return 0;
                    } else {
                        set.add(pro);
                    }


            }
        }

        return 1;
    }

}
