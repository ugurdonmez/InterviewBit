package zalando;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.IntStream;

/**
 * Created by ugurdonmez on 22/10/16.
 */
public class Question3 {

    public static void main(String [] args) {

        int [] a = {40,40,100,80,20};
        int [] b = {3,3,2,2,3};

        System.out.println(solution(a, b, 5, 2, 200));
    }

    public static int solution(int[] weight, int[] target, int maxFloor, int maxPeople, int maxWeight) {
        // write your code in Java SE 8

        int index = 0;

        int total = 0;

        while (index < weight.length) {
            int n = 0;
            int w = 0;
            Set<Integer> targets = new HashSet<>();
            targets.add(0);
            while (index < weight.length && n < maxPeople && w < maxWeight) {
                if (w + weight[index] < maxWeight) {
                    n++;
                    w += weight[index];
                    targets.add(target[index]);
                    index++;
                } else {
                    break;
                }
            }

            total += targets.size();
        }

        return total;
    }

}
