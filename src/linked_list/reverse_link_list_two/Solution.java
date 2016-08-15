package linked_list.reverse_link_list_two;

import java.util.Stack;

/**
 * Created by ugurdonmez on 12/08/16.
 */
public class Solution {

    public static void main(String [] args) {

        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        ListNode node6 = new ListNode(6);
        ListNode node7 = new ListNode(7);
        ListNode node8 = new ListNode(8);



        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node7;
        node7.next = node8;

        ListNode p = reverseBetween(node1, 5, 8);

        while (p != null) {
            System.out.println(p.val);
            p = p.next;
        }
    }

    public static ListNode reverseBetween(ListNode node, int start, int end) {

        ListNode startNode = null;
        ListNode endNode = null;

        ListNode it = node;

        Stack<ListNode> stack = new Stack<>();

        for (int i = 1; i <= end; i++) {
            if (i == start - 1) {
                startNode = it;
            }

            if (i >= start) {
                stack.push(it);
            }

            it = it.next;
        }

        while (!stack.isEmpty()) {

            ListNode n = stack.pop();

            if (startNode == null) {
                startNode = n;
                node = n;
            } else {
                startNode.next = n;
                startNode = startNode.next;
            }

            if (stack.isEmpty()) {
                startNode.next = it;
            }
        }

        return node;
    }

}

class ListNode {

    final int val;
    ListNode next;

    public ListNode(int val) {
        this.val = val;
        this.next = null;
    }
}