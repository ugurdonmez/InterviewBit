package trees.inorder_traversal;

import java.util.ArrayList;
import java.util.Stack;
import java.util.stream.IntStream;

/**
 * Created by ugurdonmez on 21/08/16.
 */
public class Solution {

    public ArrayList<Integer> inorderTraversal(TreeNode root) {

        Stack<TreeNode> stack = new Stack<>();

        ArrayList<Integer> result = new ArrayList<>();

        addToStack(root, stack);

        while (!stack.isEmpty()) {
            TreeNode n = stack.pop();

            result.add(n.val);

            addToStack(n.right, stack);
        }

        return result;
    }

    public static void addToStack(TreeNode root, Stack<TreeNode> stack) {
        while (root != null) {
            stack.add(root);
            root = root.left;
        }
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