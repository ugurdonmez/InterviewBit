package stacks_and_queues.min_stack;

import java.util.Stack;

/**
 * Created by ugurdonmez on 11/08/16.
 */
public class Solution {

    public static void main(String [] args) {

        Solution solution = new Solution();

        solution.push(4);
        solution.push(4);
        solution.push(-1);
        solution.push(4);
        solution.push(4);

        System.out.println(solution.getMin());

    }

    private Stack<Integer> stack;
    private Stack<Integer> min;

    public Solution() {

        this.stack = new Stack<>();
        this.min = new Stack<>();
    }

    public void push(int x) {

        stack.push(x);

        if (min.isEmpty() || x <= min.peek()) {
            min.push(x);
        }

    }

    public void pop() {

        if (stack.isEmpty()) {
            return;
        }

        int value = stack.pop();

        if (value <= min.peek()) {
            min.pop();
        }

    }

    public int top() {

        if (stack.isEmpty()) {
            return -1;
        }

        return stack.peek();
    }

    public int getMin() {

        if (stack.isEmpty()) {
            return -1;
        }

        return min.peek();
    }

}
