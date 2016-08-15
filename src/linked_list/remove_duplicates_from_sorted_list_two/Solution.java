package linked_lists.remove_duplicates_from_sorted_list_two;

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

        ListNode result = deleteDuplicates(node1);

        while (result != null) {
            System.out.println(result.val);
            result = result.next;
        }
    }

    public static ListNode deleteDuplicates(ListNode list) {

        ListNode prev = null;
        ListNode head = null;

        while (list != null) {

            if (list.next != null && list.val == list.next.val) {
                ListNode nextNonDuplicate = getNextNotDuplicate(list);

                if (prev == null) {
                    list = nextNonDuplicate;
                } else {
                    prev.next = nextNonDuplicate;
                    list = prev;
                }

            } else {
                prev = list;
                if (list != null) {
                    list = list.next;
                }

                if (head == null) {
                    head = prev;
                }
            }
        }

        return head;
    }

    public static ListNode getNextNotDuplicate(ListNode list) {

        // assume at least two duplicate
        int value = list.val;

        while (list != null && list.val == value) {
            list = list.next;
        }

        return list;
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