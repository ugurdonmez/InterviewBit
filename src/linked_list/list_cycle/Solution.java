package linked_list.list_cycle;

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

        node8.next = node4;

        ListNode p = detectCycle(node1);

        System.out.println(p.val);

        /*
        while (p != null) {
            System.out.println(p.val);
            p = p.next;
        }
        */
    }

    public static ListNode detectCycle(ListNode node) {

        ListNode fast = node.next.next;
        ListNode slow = node.next;

        while (fast != null && fast.next != null && slow != null && fast != slow) {
            fast = fast.next.next;
            slow = slow.next;
        }

        if (fast == null || fast.next == null) {
            return null;
        }

        while (slow != node) {
            slow = slow.next;
            node = node.next;
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