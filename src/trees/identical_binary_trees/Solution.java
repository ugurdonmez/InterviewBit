package trees.identical_binary_trees;

/**
 * Created by ugurdonmez on 21/08/16.
 */
public class Solution {

    public int isSameTree(TreeNode a, TreeNode b) {

        if (a == null && b == null) {
            return 1;
        }

        if (a == null || b == null) {
            return 0;
        }

        if (a.val != b.val) {
            return 0;
        }

        int left = isSameTree(a.left, b.left);

        if (left == 0) {
            return 0;
        }

        return isSameTree(a.right, b.right);
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