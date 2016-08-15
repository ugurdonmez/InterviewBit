package stacks_and_queues.nearest_smaller_element;

import java.util.ArrayList;
import java.util.Stack;
import java.util.stream.IntStream;

/**
 * Created by ugurdonmez on 11/08/16.
 */
public class Solution {

    public static void main(String [] args) {

        int [] array = {4, 5, 2, 10};

        ArrayList<Integer> list1 =  new ArrayList<>();

        IntStream.of(array).forEach(list1::add);

        System.out.println(prevSmaller(list1));
    }

    public static ArrayList<Integer> prevSmaller(ArrayList<Integer> array) {

        ArrayList<Integer> result = new ArrayList<>();

        Stack<Integer> stack = new Stack<>();

        array.stream().map(i -> getMinElement(stack, i)).forEach(result::add);

        return result;
    }

    public static int getMinElement(Stack<Integer> stack, int number) {

        while (!stack.isEmpty() && stack.peek() >= number) {
            stack.pop();
        }

        int returnValue = stack.empty() ? -1 : stack.peek();

        stack.push(number);

        return returnValue;
    }

}
