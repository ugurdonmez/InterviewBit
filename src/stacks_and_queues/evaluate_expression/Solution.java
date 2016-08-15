package stacks_and_queues.evaluate_expression;

import java.util.ArrayList;
import java.util.Stack;
import java.util.stream.IntStream;

/**
 * Created by ugurdonmez on 11/08/16.
 */
public class Solution {

    public static int evalRPN(ArrayList<String> list) {

        Stack<Integer> stack = new Stack<>();

        for (String str : list) {

            if (str.equals("+")) {
                int value2 = stack.pop();
                int value1 = stack.pop();
                stack.push(value1 + value2);
            } else if (str.equals("-")) {
                int value2 = stack.pop();
                int value1 = stack.pop();
                stack.push(value1 - value2);
            } else if (str.equals("*")) {
                int value2 = stack.pop();
                int value1 = stack.pop();
                stack.push(value1 * value2);
            } else if (str.equals("/")) {
                int value2 = stack.pop();
                int value1 = stack.pop();
                stack.push(value1 / value2);
            } else {
                stack.push(Integer.parseInt(str));
            }
        }

        return stack.pop();
    }

}
