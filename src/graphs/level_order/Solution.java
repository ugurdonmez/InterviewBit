package graphs.level_order;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by ugurdonmez on 10/09/16.
 */
public class Solution {

    public ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {

        Queue<TreeNode> queue1 = new LinkedList<>();
        Queue<TreeNode> queue2 = new LinkedList<>();

        ArrayList<ArrayList<Integer>> result = new ArrayList<>();

        boolean flag = true;
        queue1.add(root);

        while (!queue1.isEmpty() || !queue2.isEmpty()) {
            if (flag) {
                ArrayList<Integer> list = new ArrayList<>();
                while (!queue1.isEmpty()) {
                    TreeNode node = queue1.poll();
                    list.add(node.val);
                    if (node.left != null) {
                        queue2.add(node.left);
                    }
                    if (node.right != null) {
                        queue2.add(node.right);
                    }
                }
                result.add(list);
            } else {
                ArrayList<Integer> list = new ArrayList<>();
                while (!queue2.isEmpty()) {
                    TreeNode node = queue2.poll();
                    list.add(node.val);
                    if (node.left != null) {
                        queue1.add(node.left);
                    }
                    if (node.right != null) {
                        queue1.add(node.right);
                    }
                }
                result.add(list);
            }
            flag = !flag;
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