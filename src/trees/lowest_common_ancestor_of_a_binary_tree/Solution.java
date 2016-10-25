package trees.lowest_common_ancestor_of_a_binary_tree;

/**
 * Created by ugurdonmez on 24/08/16.
 */
public class Solution {

    public static void main(String [] args) {
        TreeNode node = new TreeNode(1);

        System.out.println(lowestCommonAncestor(node, 1, 1));
    }

    public static int lowestCommonAncestor(TreeNode root, int p, int q) {

        if (root == null) {
            return -1;
        }

        if (root.val == p && root.val == q) {
            return root.val;
        }

        if (root.val == p) {
            if (isChild(root.left, q) || isChild(root.right, q)) {
                return root.val;
            } else {
                return -1;
            }
        }

        if (root.val == q) {
            if (isChild(root.left, p) || isChild(root.right, p)) {
                return root.val;
            } else {
                return -1;
            }
        }

        boolean left = isChild(root.left, p) || isChild(root.left, q);
        boolean right = isChild(root.right, p) || isChild(root.right, q);

        if (left && right) {
            return root.val;
        }

        if (left) {
            return lowestCommonAncestor(root.left, p, q);
        }

        if (right) {
            return lowestCommonAncestor(root.right, p, q);
        }

        return -1;
    }

    public static boolean isChild(TreeNode root, int node) {

        if (root == null) {
            return false;
        }

        if (root.val == node) {
            return true;
        }

        return isChild(root.left, node) || isChild(root.right, node);
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