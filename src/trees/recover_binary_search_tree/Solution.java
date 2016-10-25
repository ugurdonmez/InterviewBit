package trees.recover_binary_search_tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;

/**
 * Created by ugurdonmez on 03/09/16.
 */
public class Solution {

    public static void main(String [] args) {

        TreeNode node10 = new TreeNode(10);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);
        TreeNode node7 = new TreeNode(7);
        TreeNode node15 = new TreeNode(15);

        node10.left = node6;
        node10.right = node5;

        node6.left = node15;
        node6.right = node7;

        System.out.println(recoverTreeInorder(node10));

        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);

        node1.left = node2;
        node1.right = node3;

        System.out.println(recoverTreeInorder(node1));
    }

    public static ArrayList<Integer> recoverTreeInorder(TreeNode node) {

        Stack<TreeNode> stack = new Stack<>();
        ArrayList<Integer> list = new ArrayList<>();

        int prev = Integer.MIN_VALUE;

        TreeNode it = node;

        while (it != null) {
            stack.push(it);
            it = it.left;
        }

        int count = 0;

        while (!stack.isEmpty()) {
            TreeNode n = stack.pop();

            if (n.val < prev) {
                list.add(n.val);
            }

            prev = n.val;
            it = n.right;
            count++;

            while (it != null) {
                stack.push(it);
                it = it.left;
            }
        }

        if (list.size() == 1) {

            it = node;
            prev = Integer.MAX_VALUE;

            while (it != null) {
                stack.push(it);
                it = it.right;
            }

            count = 0;

            while (!stack.isEmpty()) {
                TreeNode n = stack.pop();

                if (n.val > prev) {
                    list.add(n.val);
                }

                prev = n.val;
                it = n.left;
                count++;

                while (it != null) {
                    stack.push(it);
                    it = it.right;
                }
            }
        }

        Collections.sort(list);

        return list;
    }

    public static ArrayList<Integer> recoverTree(TreeNode node) {

        int left = recoverTreeHelper(node.left, Integer.MIN_VALUE, node.val);
        int right = recoverTreeHelper(node.right, node.val, Integer.MAX_VALUE);

        if (left != -1 && right != -1) {
            ArrayList<Integer> list = new ArrayList<>();
            list.add(left);
            list.add(right);
            return list;
        }

        if (left != -1) {
            if (node.val < node.left.val) {
                ArrayList<Integer> list = new ArrayList<>();
                list.add(node.val);
                list.add(node.left.val);
                return list;
            } else {
                return recoverTree(node.left);
            }
        }

        if (right != -1) {
            if (node.val > node.right.val) {
                ArrayList<Integer> list = new ArrayList<>();
                list.add(node.right.val);
                list.add(node.val);
                return list;
            } else {
                return recoverTree(node.right);
            }
        }

        return null;
    }

    public static int recoverTreeHelper(TreeNode node, int low, int high) {

        if (node == null) {
            return -1;
        }

        if (node.val > low && node.val < high) {
            int left = recoverTreeHelper(node.left, low, node.val);
            int right = recoverTreeHelper(node.right, node.val, high);

            if (left == -1 && right == -1) {
                return -1;
            }

            if (left == -1) {
                return right;
            }

            if (right == -1) {
                return left;
            }
        }

        return node.val;
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