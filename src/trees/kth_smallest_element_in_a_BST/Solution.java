package trees.kth_smallest_element_in_a_BST;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * Created by ugurdonmez on 25/08/16.
 */
public class Solution {

    public static void main(String [] args) {

        TreeNode node5 = new TreeNode(5);
        TreeNode node3 = new TreeNode(3);
        TreeNode node6 = new TreeNode(6);
        TreeNode node2 = new TreeNode(2);
        TreeNode node4 = new TreeNode(4);
        TreeNode node1 = new TreeNode(1);

        node5.left = node3;
        node5.right = node6;
        node3.left = node2;
        node3.right = node4;
        node2.left = node1;

        System.out.println(kthSmallest(node5, 4));

    }

    public static int kthSmallest(TreeNode root, int k) {

        Map<Integer, Integer> leftCount = new HashMap<>();

        return kthSmallestHelper(root, k, leftCount);
    }

    public static int kthSmallestHelper(TreeNode root, int k, Map<Integer, Integer> leftCount) {

        if (leftCount.containsKey(root.val) && leftCount.get(root.val) + 1 == k) {
            return root.val;
        }

        if (leftCount.containsKey(root.val) && leftCount.get(root.val) >= k) {
            return kthSmallestHelper(root.left, k, leftCount);
        }

        int leftSize = countChildren(root.left, leftCount);

        leftCount.put(root.val, leftSize);

        if (leftSize + 1 == k) {
            return root.val;
        }

        if (leftSize >= k) {
            return kthSmallestHelper(root.left, k, leftCount);
        }

        return kthSmallestHelper(root.right, k - 1 - leftSize, leftCount);
    }

    public static int countChildren(TreeNode root, Map<Integer, Integer> leftCount) {

        if (root == null) {
            return 0;
        }

        int leftSize = 0;

        if (root.left != null) {
            if (leftCount.containsKey(root.val)) {
                leftSize = leftCount.get(root.val);
            } else {
                leftSize = countChildren(root.left, leftCount);
                leftCount.put(root.val, leftSize);
            }
        }

        int rightSize = countChildren(root.right, leftCount);

        return 1 + leftSize + rightSize;
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