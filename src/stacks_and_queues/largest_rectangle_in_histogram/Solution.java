package stacks_and_queues.largest_rectangle_in_histogram;

import java.util.ArrayList;
import java.util.Stack;
import java.util.stream.IntStream;

/**
 * Created by ugurdonmez on 11/08/16.
 */
public class Solution {


    public static void main(String [] args) {

        int [] array = {2, 82, 11, 89, 7, 21, 92, 13, 11, 94, 4, 96, 3};

        int [] array1 = {2, 1, 5, 6, 2, 3};

        ArrayList<Integer> list1 =  new ArrayList<>();

        IntStream.of(array1).forEach(list1::add);

        System.out.println(largestRectangleArea(list1));

    }

    public static int largestRectangleArea(ArrayList<Integer> array) {

        if (array.size() == 1) {
            return array.get(0);
        }

        Stack<ValueIndexPair> stack = new Stack<>();
        Stack<ValueIndexPair> buffer = new Stack<>();

        int max = Integer.MIN_VALUE;

        for (int i = 0; i < array.size(); i++) {
            if (stack.isEmpty()) {
                stack.push(new ValueIndexPair(array.get(i), i));
                continue;
            }

            int index = i;

            // calculate
            while (!stack.isEmpty()) {
                ValueIndexPair valueIndexPair = stack.pop();

                int bottom = i - valueIndexPair.index + 1;
                int height = Integer.min(array.get(i), valueIndexPair.value);

                int area = bottom * height;

                max = Integer.max(area, max);
                max = Integer.max(max, array.get(i));

                if (array.get(i) > valueIndexPair.value) {
                    buffer.add(valueIndexPair);
                } else {
                    index = valueIndexPair.index;
                }
            }

            while (!buffer.isEmpty()) {
                stack.add(buffer.pop());
            }


            while (!stack.isEmpty() && stack.peek().value > array.get(i)) {
                stack.pop();
            }


            stack.push(new ValueIndexPair(array.get(i), index));
        }

        return max;
    }

}

class ValueIndexPair {

    final int value;
    final int index;

    public ValueIndexPair(int value, int index) {
        this.value = value;
        this.index = index;
    }
}
