package zalando;

/**
 * Created by ugurdonmez on 22/10/16.
 */
public class Question2 {

    public int solution(int a, int b) {
        // write your code in Java SE 8

        String aStr = String.valueOf(a);
        String bStr = String.valueOf(b);

        int index1 = 0;
        int index2 = 0;

        StringBuilder buf = new StringBuilder();

        while (index1 < aStr.length() && index2 < bStr.length()) {
            buf.append(aStr.charAt(index1)).append(bStr.charAt(index2));
            index1++;
            index2++;

            if (buf.length() > 10) {
                return -1;
            }
        }

        while (index1 < aStr.length()) {
            buf.append(aStr.charAt(index1));
            index1++;
            if (buf.length() > 10) {
                return -1;
            }
        }

        while (index2 < bStr.length()) {
            buf.append(bStr.charAt(index1));
            index2++;
            if (buf.length() > 10) {
                return -1;
            }
        }

        if (buf.length() > 10) {
            return -1;
        }

        int last = Integer.valueOf(buf.toString());

        if (last > 100000000) {
            return -1;
        } else {
            return last;
        }
    }

}
