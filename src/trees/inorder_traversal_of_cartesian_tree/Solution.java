package trees.inorder_traversal_of_cartesian_tree;

import java.util.ArrayList;

/**
 * Created by ugurdonmez on 21/08/16.
 */
public class Solution {

    public TreeNode buildTree(ArrayList<Integer> a) {

        return buildTreeHelper(0, a.size(), a);

    }

    public TreeNode buildTreeHelper(int start, int end, ArrayList<Integer> list) {

        if (start >= end) {
            return null;
        }

        int middle = start;
        int max = list.get(start);

        for (int i = start; i < end; i++) {
            if (list.get(i) > max) {
                max = list.get(i);
                middle = i;
            }
        }

        TreeNode left = buildTreeHelper(start, middle, list);
        TreeNode right = buildTreeHelper(middle+1, end, list);

        TreeNode node = new TreeNode(list.get(middle));
        node.left = left;
        node.right = right;

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