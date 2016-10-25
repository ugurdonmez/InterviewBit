package greedy.seats;

/**
 * Created by ugurdonmez on 05/09/16.
 */
public class Solution {



    int seats(String s) {
        int i = findMedian(s.toCharArray());
        if (i == -1) {
            return 0;
        }
        return shift(s.toCharArray(), i);
    }

    // Shifts each person the the unoccupied seat closest to seat i.
    int shift(char s[], int i) {
        int count = 0;
        int j = 0;
        int k = i;
        while (j < k) {
            if (s[j] == '.') {
                j++;
            }
            else if (s[k] == 'x') {
                k--;
            }
            else {
                s[k] = s[j];
                s[j] = '.';
                count += k-j;
                count = count % 10000003;
                j++;
                k--;
            }
        }
        j = s.length - 1;
        k = i;
        while (j > k) {
            if (s[j] == '.') {
                j--;
            }
            else if (s[k] == 'x') {
                k++;
            }
            else {
                s[k] = s[j];
                s[j] = '.';
                count += j-k;
                count = count % 10000003;
                j--;
                k++;
            }
        }
        return count % 10000003;
    }

    // Finds the median person.
    int findMedian(char s[]) {
        int count1 = 0;
        for (char c : s) {
            if (c == 'x') {
                count1++;
            }
        }
        if (count1 == 0) {
            return -1;
        }
        count1 = (count1 + 1) / 2;
        int count2 = 0;
        for (int i = 0; i < s.length; ++i) {
            if (s[i] == 'x') {
                count2++;
                if (count2 == count1) {
                    return i;
                }
            }
        }
        throw new RuntimeException("yuk!");
    }

}
