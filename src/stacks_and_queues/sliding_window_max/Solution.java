package stacks_and_queues.sliding_window_max;

import java.util.*;
import java.util.stream.IntStream;

/**
 * Created by ugurdonmez on 11/08/16.
 */
public class Solution {

    public static void main(String [] args) {

        int [] array = {1, 3, -1, -3, 5, 3, 6, 7};

        List<Integer> list = new ArrayList<>();

        IntStream.of(array).forEach(list::add);

        System.out.println(slidingMaximumOptimized(list, 3));
        System.out.println(slidingMaximumSolution(list, 3));
    }

    public static ArrayList<Integer> slidingMaximumSolution(final List<Integer> list, int windowSize) {

        int i;
        ArrayList<Integer> res = new ArrayList<>();

        int window = Math.min(list.size(), windowSize);

        Deque<Node> deque = new LinkedList<>();

        int val;


        for (i = 0; i < window - 1; i++) {
            val = list.get(i);

            while (!deque.isEmpty() && deque.peekFirst().val <= val) {
                deque.pollFirst();
            }

            deque.addFirst(new Node(i, val));
        }

        for (; i < list.size(); i++) {

            val = list.get(i);

            if (!deque.isEmpty() && (i - deque.peekLast().index >= window)) {
                deque.pollLast();
            }

            while (!deque.isEmpty() && deque.peekFirst().val <= val) {
                deque.pollFirst();
            }

            deque.addFirst(new Node(i, val));

            res.add(deque.peekLast().val);
        }

        return res;
    }

    public static ArrayList<Integer> slidingMaximumOptimized(final List<Integer> list, int windowSize) {

        ArrayList<Integer> result = new ArrayList<>();

        if (windowSize >= list.size()) {

            list.stream().max(Comparator.naturalOrder()).ifPresent(result::add);

            return result;
        }

        Stack<Integer> addStack = new Stack<>();
        Stack<Integer> removeStack = new Stack<>();
        Stack<Integer> maxStack = new Stack<>();

        // add to add stack
        for (int i = 0; i < windowSize; i++) {
            addStack.push(list.get(i));
        }

        // move to remove stack and populate max stack
        while (!addStack.isEmpty()) {
            int number = addStack.pop();

            removeStack.push(number);

            if (maxStack.isEmpty()) {
                maxStack.push(number);
            } else if (number > maxStack.peek()) {
                maxStack.push(number);
            } else {
                maxStack.push(maxStack.peek());
            }
        }

        result.add(maxStack.peek());

        for (int i = 0; i < list.size() - windowSize; i++) {

            // delete old element
            removeStack.pop();
            maxStack.pop();

            // move remove stack to add stack
            while (!removeStack.isEmpty()) {
                addStack.push(removeStack.pop());
                maxStack.pop();
            }

            // add new element to add stack
            addStack.push(list.get(i + windowSize));

            // move to remove stack and populate max stack
            while (!addStack.isEmpty()) {
                int number = addStack.pop();

                removeStack.push(number);

                if (maxStack.isEmpty()) {
                    maxStack.push(number);
                } else if (number > maxStack.peek()) {
                    maxStack.push(number);
                } else {
                    maxStack.push(maxStack.peek());
                }
            }

            result.add(maxStack.peek());
        }

        return result;
    }

    public static ArrayList<Integer> slidingMaximum(final List<Integer> list, int windowSize) {

        ArrayList<Integer> result = new ArrayList<>();

        if (windowSize >= list.size()) {

            list.stream().max(Comparator.naturalOrder()).ifPresent(result::add);

            return result;
        }

        Deque<Integer> arrayDeque = new ArrayDeque<>();

        for (int i = 0; i < windowSize; i++) {
            arrayDeque.addLast(list.get(i));
        }

        arrayDeque.stream().max(Comparator.naturalOrder()).ifPresent(result::add);

        int oldMax = result.get(result.size()-1);

        for (int i = 0; i < list.size() - windowSize; i++) {

            // remove first
            int removed = arrayDeque.removeFirst();

            // add i
            int added = list.get(i + windowSize);
            arrayDeque.addLast(added);

            // find max
            if (list.get(i + windowSize) >= oldMax) {
                result.add(list.get(i + windowSize));
                oldMax = list.get(i + windowSize);
            } else if (removed >= oldMax) {
                arrayDeque.stream().max(Comparator.naturalOrder()).ifPresent(result::add);
                oldMax = result.get(result.size() - 1);
            } else {
                result.add(oldMax);
            }
        }

        return result;
    }

}

class Node {
    int val;
    int index;

    public Node(int index, int val) {
        this.index = index;
        this.val = val;
    }
}
