package graphs.convert_sorted_list_to_binary_search_tree;

/**
 * Created by ugurdonmez on 11/09/16.
 */
public class Solution {

    public static void main(String [] args) {

        ListNode listNode = new ListNode(1);

        TreeNode treeNode = sortedListToBST(listNode);

        System.out.println(treeNode.val);
    }

    public static TreeNode sortedListToBST(ListNode listNode) {

        if (listNode == null) {
            return null;
        }

        ListNode slow = listNode;
        ListNode prev = null;
        ListNode fast = listNode;

        while (fast.next != null && fast.next.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        TreeNode treeNode = new TreeNode(slow.val);
        if (prev != null) {
            prev.next = null;
            treeNode.left = sortedListToBST(listNode);
        }

        ListNode rightNode = slow.next;
        slow.next = null;
        treeNode.right = sortedListToBST(rightNode);

        return treeNode;
    }
}

class ListNode {

    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }
}

class TreeNode {

    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}