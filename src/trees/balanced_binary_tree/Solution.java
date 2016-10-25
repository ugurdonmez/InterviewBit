package trees.balanced_binary_tree;

/**
 * Created by ugurdonmez on 21/08/16.
 */
public class Solution {


    public static int isBalanced(TreeNode root) {

        return isBalancedHelper(root) < 0 ? 0 : 1;

    }

    public static int isBalancedHelper(TreeNode root) {

        if (root ==  null) {
            return 0;
        }

        int left = isBalancedHelper(root.left);

        if (left < 0) {
            return -1;
        }

        int right = isBalancedHelper(root.right);

        if (right < 0) {
            return -1;
        }

        if (Math.abs(left - right) > 1) {
            return -1;
        }

        return 1 + Integer.max(left, right);
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