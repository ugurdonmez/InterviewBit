package linked_list.insertion_sort_list;

/**
 * Created by ugurdonmez on 12/08/16.
 */
public class Solution {

    public static void main(String [] args) {

        ListNode node1 = new ListNode(8);
        ListNode node2 = new ListNode(7);
        ListNode node3 = new ListNode(6);
        ListNode node4 = new ListNode(5);
        ListNode node5 = new ListNode(4);
        ListNode node6 = new ListNode(3);
        ListNode node7 = new ListNode(2);
        ListNode node8 = new ListNode(10);



        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node7;
        node7.next = node8;

        // node8.next = node4;

        ListNode p = insertionSortList(node1);


        while (p != null) {
            System.out.println(p.val);
            p = p.next;
        }

    }


    public static ListNode insertionSortList(ListNode list) {

        ListNode sortedList = list;

        if (sortedList == null) {
            return null;
        }

        ListNode unsortedList = list.next;

        sortedList.next = null;

        while (unsortedList != null) {

            ListNode node = unsortedList;
            unsortedList = unsortedList.next;
            node.next = null;

            ListNode it = sortedList;

            if (it.val > node.val) {
                node.next = sortedList;
                sortedList = node;
            } else {
                while (it.next != null && it.next.val < node.val) {
                    it = it.next;
                }

                node.next = it.next;
                it.next = node;
            }

        }

        return sortedList;
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