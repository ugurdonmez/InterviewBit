package linked_list.rotate_list;

import java.util.List;

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



        //node1.next = node2;
        //node2.next = node3;
        //node3.next = node4;
        //node4.next = node5;
        //node5.next = node6;
        //node6.next = node7;
        //node7.next = node8;

        ListNode p = rotateRight(node1, 1);

        while (p != null) {
            System.out.println(p.val);
            p = p.next;
        }
    }

    public static ListNode rotateRight(ListNode node, int n) {

        ListNode faster = node;
        ListNode slower = node;

        for (int i = 0; i < n; i++) {
            faster = faster.next;
            if (faster == null) {
                faster = node;
            }
        }


        while (faster != null && faster.next != null) {
            faster = faster.next;
            slower = slower.next;
        }

        if (slower.next == null) {
            return node;
        }

        ListNode result = slower.next;
        slower.next = null;

        faster.next = node;

        return result;
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