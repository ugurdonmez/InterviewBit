package binary_search.median_of_array;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

/**
 * Created by user on 10/08/16.
 */
public class Solution {

    public static void main(String [] args) {

        int[] array = {173, 174, 175, 176, 177};

        ArrayList<Integer> list = new ArrayList<>();

        IntStream.of(array).forEach(list::add);

        for (int i = 0; i < array.length; i++) {
            System.out.println(i + " " + array[i]);
        }
    }

    public double findMedianSortedArrays(final List<Integer> a, final List<Integer> b) {

        int [] array1 = new int[a.size()];
        for (int i = 0; i < a.size(); i++) {
            array1[i] = a.get(i);
        }

        int [] array2 = new int[b.size()];
        for (int i = 0; i < b.size(); i++) {
            array2[i] = b.get(i);
        }

        return findMedianSortedArrays(array1, array2);
    }

    public static double findMedianSortedArrays(int A[], int B[]) {
        int m = A.length;
        int n = B.length;

        if ((m + n) % 2 != 0) // odd
            return (double) findKth(A, B, (m + n) / 2, 0, m - 1, 0, n - 1);
        else { // even
            return (findKth(A, B, (m + n) / 2, 0, m - 1, 0, n - 1)
                    + findKth(A, B, (m + n) / 2 - 1, 0, m - 1, 0, n - 1)) * 0.5;
        }
    }

    public static int findKth(int A[], int B[], int k,
                              int aStart, int aEnd, int bStart, int bEnd) {

        int aLen = aEnd - aStart + 1;
        int bLen = bEnd - bStart + 1;

        // Handle special cases
        if (aLen == 0)
            return B[bStart + k];
        if (bLen == 0)
            return A[aStart + k];
        if (k == 0)
            return A[aStart] < B[bStart] ? A[aStart] : B[bStart];

        int aMid = aLen * k / (aLen + bLen); // a's middle count
        int bMid = k - aMid - 1; // b's middle count

        // make aMid and bMid to be array index
        aMid = aMid + aStart;
        bMid = bMid + bStart;

        if (A[aMid] > B[bMid]) {
            k = k - (bMid - bStart + 1);
            aEnd = aMid;
            bStart = bMid + 1;
        } else {
            k = k - (aMid - aStart + 1);
            bEnd = bMid;
            aStart = aMid + 1;
        }

        return findKth(A, B, k, aStart, aEnd, bStart, bEnd);
    }

}
