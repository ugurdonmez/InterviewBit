package heaps_and_maps.merge_k_sorted_lists;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by ugurdonmez on 19/08/16.
 */
public class Solution {

    public static void main(String [] args) {

    }

    public ListNode mergeKLists(ArrayList<ListNode> list) {

        PriorityQueue<ListNode> queue = new PriorityQueue<>(list.size(), new ListNodeComparator());

        for (int i = 0; i < list.size(); i++) {
            queue.add(list.get(i));
        }

        ListNode head = null;
        ListNode it = null;

        while (!queue.isEmpty()) {

            ListNode node = queue.poll();

            if (node.next != null) {
                queue.add(node.next);
            }

            if (head == null) {
                head = node;
                it = head;
            } else {
                it.next = node;
                it = it.next;
            }

            it.next = null;
        }

        return head;
    }

}

class ListNodeComparator implements Comparator<ListNode> {

    @Override
    public int compare(ListNode o1, ListNode o2) {
        return Integer.compare(o1.val, o2.val);
    }
}

class ListNode {

    public int val;

    public ListNode next;

    ListNode(int x) {
        val = x; next = null;
    }
}
