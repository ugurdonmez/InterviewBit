package trees.binary_search_tree_iterator;

import java.util.Stack;

/**
 * Created by ugurdonmez on 03/09/16.
 */
public class Solution {


}

class BSTIterator {

    Stack<TreeNode> stack;

    public BSTIterator(TreeNode root) {
        stack = new Stack<>();
        TreeNode it = root;

        while (it != null) {
            stack.push(it);
            it = it.left;
        }
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        if (stack.isEmpty()) {
            return false;
        } else {
            return true;
        }
    }

    /** @return the next smallest number */
    public int next() {
        TreeNode node = stack.pop();

        TreeNode it = node.right;

        while (it != null) {
            stack.push(it);
            it = it.left;
        }

        return node.val;
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