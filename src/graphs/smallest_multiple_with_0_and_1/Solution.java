package graphs.smallest_multiple_with_0_and_1;

import java.math.BigInteger;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by ugurdonmez on 12/09/16.
 */
public class Solution {

    public String multiple(int number) {

        if (number == 1) {
            return "1";
        }

        if (number == 0) {
            return "0";
        }

        Queue<String> queue = new LinkedList<>();
        queue.add("1");

        while (!queue.isEmpty()) {

            String str = queue.poll();

            BigInteger bigInteger = new BigInteger(str);

            if (bigInteger.remainder(BigInteger.valueOf(number)).equals(BigInteger.valueOf(0))) {
                return str;
            }

            queue.add(str + "0");
            queue.add(str + "1");
        }

        return null;
    }

}


