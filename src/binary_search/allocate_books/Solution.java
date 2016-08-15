package binary_search.allocate_books;

import java.util.ArrayList;

/**
 * Created by ugurdonmez on 10/08/16.
 */
public class Solution {


    public static void main(String [] args) {

        ArrayList<Integer> list = new ArrayList<>();

        list.add(12);
        list.add(34);
        list.add(67);
        list.add(90);

        System.out.println(books(list, 2));
    }

    public static int books(ArrayList<Integer> books, int studentNumber) {

        if (books.size() < studentNumber) {
            return -1;
        }

        int start = 0;
        int end = Integer.MAX_VALUE;

        while (start <= end) {

            int mid = (start+end) >> 1;

            if (isPossible(books, studentNumber, mid)) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return start;
    }

    public static boolean isPossible(ArrayList<Integer> books, int studentNumber, int maxPage) {

        int index = 0;

        for (int i = 0; i < studentNumber; i++) {

            int studentSum = 0;

            while (studentSum < maxPage && index < books.size()) {
                studentSum += books.get(index);

                if (studentSum <= maxPage) {
                    index++;
                } else {
                    break;
                }
            }

            if (index == books.size()) {
                return true;
            }
        }

        return false;
    }

}
