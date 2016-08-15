package hashing.valid_sudoku;

import java.util.*;

/**
 * Created by ugurdonmez on 14/08/16.
 */
public class Solution {

    public static void main(String [] args) {

    }

    public static int isValidSudoku(final List<String> strings) {

        if (strings.size() != 9) {
            return 0;
        }

        // rows
        for (String string : strings) {

            Set<Character> set = new HashSet<>();

            for (char c : string.toCharArray()) {
                if (c == '.') {
                    continue;
                }

                if (set.contains(c)) {
                    return 0;
                } else {
                    set.add(c);
                }
            }

        }

        // columns
        for (int i = 0; i < 9; i++) {
            Set<Character> set = new HashSet<>();

            for (int j = 0; j < 9; j++) {
                char c = strings.get(j).charAt(i);

                if (c == '.') {
                    continue;
                }

                if (set.contains(c)) {
                    return 0;
                } else {
                    set.add(c);
                }
            }
        }

        // boxes
        for (int i = 0; i < 3; i++) {
            for (int j =0; j < 3; j++) {

                Set<Character> set = new HashSet<>();

                for (int k = 0; k < 9; k++) {

                    int row = i * 3 + k / 3;
                    int column = j * 3 + k % 3;

                    char c = strings.get(row).charAt(column);

                    if (c == '.') {
                        continue;
                    }

                    if (set.contains(c)) {
                        return 0;
                    } else {
                        set.add(c);
                    }

                }

            }
        }

        return 1;

    }
}
