package trees.populate_next_right_pointers_tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by ugurdonmez on 04/09/16.
 */
public class Solution {

    public static void connect(TreeLinkNode root) {

        Queue<TreeLinkNode> queue1 = new LinkedList<>();
        Queue<TreeLinkNode> queue2 = new LinkedList<>();

        queue1.add(root);
        boolean flag = true;

        while (!queue1.isEmpty() || !queue2.isEmpty()) {
            if (flag) {

                TreeLinkNode node = queue1.poll();

                if (queue1.isEmpty()) {
                    node.next = null;
                } else {
                    node.next = queue1.peek();
                }

                if (node.left != null) {
                    queue2.add(node.left);
                }

                if (node.right != null) {
                    queue2.add(node.right);
                }
            } else {
                TreeLinkNode node = queue2.poll();

                if (queue2.isEmpty()) {
                    node.next = null;
                } else {
                    node.next = queue2.peek();
                }

                if (node.left != null) {
                    queue1.add(node.left);
                }

                if (node.right != null) {
                    queue1.add(node.right);
                }
            }

            flag = !flag;
        }

    }

}

class TreeLinkNode {

    int val;
    TreeLinkNode left, right, next;

    TreeLinkNode(int x) {
        val = x;
    }
}