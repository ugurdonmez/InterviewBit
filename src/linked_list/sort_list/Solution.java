package linked_list.sort_list;

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

        ListNode p = sortList(node1);


        while (p != null) {
            System.out.println(p.val);
            p = p.next;
        }

    }


    public static ListNode sortList(ListNode list) {

        if (list == null) {
            return null;
        }

        // divide list

        ListNode key = list;
        list = list.next;
        key.next = null;



        ListNode bigger = null;
        ListNode smaller = null;

        while (list != null) {

            ListNode node = list;
            list = list.next;

            if (node.val > key.val) {
                node.next = bigger;
                bigger = node;
            } else {
                node.next = smaller;
                smaller = node;
            }
        }

        smaller = sortList(smaller);
        bigger = sortList(bigger);

        key.next = bigger;

        ListNode it = smaller;

        if (it == null) {
            return key;
        }

        while (it.next != null) {
            it = it.next;
        }

        it.next = key;

        return smaller;
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
