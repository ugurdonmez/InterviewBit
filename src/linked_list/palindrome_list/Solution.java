package linked_list.palindrome_list;

/**
 * Created by ugurdonmez on 12/08/16.
 */
public class Solution {

    public static void main(String [] args) {

        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(1);

        node1.next = node2;
        node2.next = node3;

        System.out.println(lPalin(node1));
    }

    public static int lPalin(ListNode node) {

        ListNode slow = node;
        ListNode fast = node;

        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode reverse = reverse(slow.next);

        while (reverse != null) {
            if (node.val != reverse.val) {
                return 0;
            }
            reverse = reverse.next;
            node = node.next;
        }

        return 1;
    }

    public static ListNode reverse(ListNode node) {

        ListNode n = null;

        while (node != null) {
            ListNode temp = node;
            node = node.next;
            temp.next = n;
            n = temp;
        }

        return n;
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