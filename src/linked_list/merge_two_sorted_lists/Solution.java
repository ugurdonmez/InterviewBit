package linked_lists.merge_two_sorted_lists;

/**
 * Created by user on 12/08/16.
 */
public class Solution {

    public static void main(String [] args) {

        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(3);
        ListNode node5 = new ListNode(4);
        ListNode node6 = new ListNode(4);
        ListNode node7 = new ListNode(5);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node7;

        ListNode result = null;

        while (result != null) {
            System.out.println(result.val);
            result = result.next;
        }
    }

    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {

        ListNode head = null;
        ListNode current = null;

        ListNode it1 = list1;
        ListNode it2 = list2;

        while (it1 != null && it2 != null) {
            if (it1.val < it2.val) {

                if (current == null) {
                    current = it1;
                    head = current;
                } else {
                    current.next = it1;
                    current = current.next;
                }

                it1 = it1.next;
            } else {
                if (current == null) {
                    current = it2;
                    head = current;
                } else {
                    current.next = it2;
                    current = current.next;
                }

                it2 = it2.next;
            }
        }

        while (it1 != null) {
            if (current == null) {
                current = it1;
                head = current;
            } else {
                current.next = it1;
                current = current.next;
            }

            it1 = it1.next;
        }

        while (it2 != null) {
            if (current == null) {
                current = it2;
                head = current;
            } else {
                current.next = it2;
                current = current.next;
            }

            it2 = it2.next;
        }

        return head;
    }

}

class ListNode {

    public int val;
    public ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }
}