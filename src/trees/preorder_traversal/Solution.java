package trees.preorder_traversal;

import java.util.ArrayList;
import java.util.Stack;

/**
 * Created by ugurdonmez on 21/08/16.
 */
public class Solution {

    public ArrayList<Integer> preorderTraversal(TreeNode root) {

        Stack<TreeNode> stack = new Stack<>();

        ArrayList<Integer> result = new ArrayList<>();

        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode n = stack.pop();

            result.add(n.val);

            if (n.right != null) {
                stack.push(n.right);
            }

            if (n.left != null) {
                stack.push(n.left);
            }

        }

        return result;
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