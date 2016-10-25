package graphs.word_search_board;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by ugurdonmez on 12/09/16.
 */
public class Solution {

    public static void main(String [] args) {

        String [] strings = {"FEDCBECD", "FABBGACG", "CDEDGAEC", "BFFEGGBA", "FCEEAFDA", "AGFADEAC", "ADGDCBAA", "EAABDDFF"};



        ArrayList<String> list = new ArrayList<>();

        Arrays.stream(strings).forEach(list::add);

        Arrays.stream(strings).forEach(System.out::println);


        System.out.println(exist(list, "BCDCB"));
    }

    public static int exist(ArrayList<String> list, String string) {

        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < list.get(i).length(); j++) {
                boolean [][] visited = new boolean[list.size()][list.get(0).length()];
                int result = existHelper(list, string, visited, i, j);
                if (result == 1) {
                    return 1;
                }
            }
        }

        return 0;
    }

    public static int existHelper(ArrayList<String> list, String string, boolean[][] visited, int i, int j) {

        if (string.length() == 0) {
            return 1;
        }

        if (i < 0) {
            return -1;
        }

        if (i >= list.size()) {
            return -1;
        }

        if (j < 0) {
            return -1;
        }

        if (j >= list.get(i).length()) {
            return -1;
        }

        if (visited[i][j]) {
            return -1;
        }

        visited[i][j] = true;

        if (list.get(i).charAt(j) == string.charAt(0)) {
            if (existHelper(list, string.substring(1), visited.clone(), i+1, j) == 1) {
                return 1;
            }
            if (existHelper(list, string.substring(1), visited.clone(), i-1, j) == 1) {
                return 1;
            }
            if (existHelper(list, string.substring(1), visited.clone(), i, j+1) == 1) {
                return 1;
            }
            if (existHelper(list, string.substring(1), visited.clone(), i, j-1) == 1) {
                return 1;
            }
            return -1;
        } else {
            return -1;
        }
    }

}
