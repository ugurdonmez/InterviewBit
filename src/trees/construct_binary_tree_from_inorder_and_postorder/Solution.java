package trees.construct_binary_tree_from_inorder_and_postorder;

import java.util.ArrayList;

/**
 * Created by ugurdonmez on 21/08/16.
 */
public class Solution {

    public static void main(String [] args) {

        ArrayList<Integer> in = new ArrayList<>();

        in.add(2);
        in.add(1);
        in.add(3);

        ArrayList<Integer> post = new ArrayList<>();

        post.add(2);
        post.add(3);
        post.add(1);

        Solution sol = new Solution();

        TreeNode n = sol.buildTree(in, post);

        System.out.println();
    }


    public TreeNode buildTree(ArrayList<Integer> inorder, ArrayList<Integer> postorder) {

        if (inorder == null || postorder == null || inorder.size() == 0 || inorder.size() != postorder.size())
            return null;

        TreeNode root;
        int n = inorder.size();

        root = rec(inorder, postorder, 0, n - 1, n - 1);

        return root;

    }


    public TreeNode rec(ArrayList<Integer> inorder, ArrayList<Integer> postorder, int start, int end, int postIndex) {

        if (start > end)
            return null;

        TreeNode node;
        int nodeVal = postorder.get(postIndex);
        node = new TreeNode(nodeVal);
        int i;

        for (i = start; i <= end; i++) {
            if (inorder.get(i) == nodeVal)
                break;
        }

        node.left = rec(inorder, postorder, start, i - 1, postIndex - (end - i + 1));
        node.right = rec(inorder, postorder, i + 1, end, postIndex - 1);

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