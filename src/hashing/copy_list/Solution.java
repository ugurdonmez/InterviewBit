package hashing.copy_list;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by ugurdonmez on 15/08/16.
 */
public class Solution {

    public static void main(String [] args) {


        RandomListNode node1 = new RandomListNode(1);
        RandomListNode node2 = new RandomListNode(2);
        RandomListNode node3 = new RandomListNode(1);

        node1.next = node2;
        node2.next = node3;

        node1.random = node3;
        node2.random = node1;
        node3.random = node1;

        RandomListNode copy = copyRandomList(node1);

        System.out.println();
    }

    public static RandomListNode copyRandomList(RandomListNode head) {

        Map<Integer, RandomListNode> map = new HashMap<>();

        RandomListNode it = head;

        while (it != null) {
            map.put(it.label, new RandomListNode(it.label));
            it = it.next;
        }

        RandomListNode copyHead = map.get(head.label);

        it = head;
        RandomListNode itCopy = copyHead;

        while (it != null) {
            if (it.random != null) {
                itCopy.random = map.get(it.random.label);
            }

            if (it.next != null) {
                itCopy.next = map.get(it.next.label);
            }

            it = it.next;
            itCopy = itCopy.next;
        }

        return copyHead;
    }


}


class RandomListNode {

    int label;
    RandomListNode next;
    RandomListNode random;

    public RandomListNode (int label) {
        this.label = label;
        this.next = null;
        this.random = null;
    }
 }