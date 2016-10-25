package greedy.highest_product;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.stream.IntStream;

/**
 * Created by ugurdonmez on 04/09/16.
 */
public class Solution {

    public static void main(String [] args) {

        int [] array = {0, -1, 3, 100, -70, -50};

        ArrayList<Integer> list = new ArrayList<>();

        IntStream.of(array).forEach(list::add);

        System.out.println(maxp3(list));
    }

    public static int maxp3(ArrayList<Integer> list) {

        PriorityQueue<Integer> queueNegative = new PriorityQueue<>(2, Comparator.reverseOrder());
        PriorityQueue<Integer> queuePositive = new PriorityQueue<>(3);

        for (int a : list) {
            if (a > 0) {
                if (queuePositive.size() < 3) {
                    queuePositive.add(a);
                } else {
                    if (queuePositive.peek() < a) {
                        queuePositive.poll();
                        queuePositive.add(a);
                    }
                }
            } else if (a < 0) {
                if (queueNegative.size() < 2) {
                    queueNegative.add(a);
                } else {
                    if (queueNegative.peek() > a) {
                        queueNegative.poll();
                        queueNegative.add(a);
                    }
                }
            }
        }

        if (queuePositive.size() == 0) {
            for (int a : list) {
                if (queuePositive.size() < 3) {
                    queuePositive.add(a);
                } else {
                    if (queuePositive.peek() < a) {
                        queuePositive.poll();
                        queuePositive.add(a);
                    }
                }
            }

            return queuePositive.poll() * queuePositive.poll() * queuePositive.poll();
        }


        int proNeg = 1;
        if (queueNegative.size() == 2) {
            proNeg = queueNegative.poll() * queueNegative.poll();
        }

        if (queuePositive.size() == 2) {
            queuePositive.poll();
            return proNeg * queuePositive.poll();
        }

        if (queuePositive.size() == 1) {
            return proNeg * queuePositive.poll();
        }

        int proPos = queuePositive.poll() * queuePositive.poll();

        if (proNeg > proPos) {
            return proNeg * queuePositive.poll();
        } else {
            return proPos * queuePositive.poll();
        }
    }
}
