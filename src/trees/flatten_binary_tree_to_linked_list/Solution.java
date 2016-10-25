package trees.flatten_binary_tree_to_linked_list;

import java.util.Stack;

/**
 * Created by ugurdonmez on 24/08/16.
 */
public class Solution {

    public TreeNode flatten(TreeNode node) {

        if (node == null) {
            return null;
        }

        TreeNode result = new TreeNode(-1);
        TreeNode resultIt = result;

        Stack<TreeNode> stack = new Stack<>();

        stack.push(node);

        while (!stack.isEmpty()) {

            TreeNode n = stack.pop();

            resultIt.right = new TreeNode(n.val);
            resultIt = resultIt.right;

            if (n.right != null) {
                stack.push(n.right);
            }

            if (n.left != null) {
                stack.push(n.left);
            }

            /*
            while (n != null) {
                resultIt.right = new TreeNode(n.val);
                resultIt = resultIt.right;

                if (n.right != null) {
                    stack.push(n.right);
                }

                n= n.left;
            }
            */
        }

        return result.right;
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