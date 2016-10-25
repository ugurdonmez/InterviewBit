package trees.sorted_array_to_balanced_BST;

import java.util.List;

/**
 * Created by ugurdonmez on 21/08/16.
 */
public class Solution {

    public TreeNode sortedArrayToBST(final List<Integer> a) {
        return sortedArrayToBSTHelper(0, a.size(), a);
    }

    public static TreeNode sortedArrayToBSTHelper(int start, int end, final List<Integer> list) {

        if (start >= end) {
            return null;
        }

        int middle = (start + end) / 2;

        TreeNode leftNode = sortedArrayToBSTHelper(start, middle, list);
        TreeNode rightNode = sortedArrayToBSTHelper(middle+1, end, list);

        TreeNode node = new TreeNode(list.get(middle));
        node.left = leftNode;
        node.right = rightNode;

        return node;
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
