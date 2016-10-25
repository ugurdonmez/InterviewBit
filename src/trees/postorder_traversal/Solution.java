package trees.postorder_traversal;

import java.util.ArrayList;
import java.util.Stack;

/**
 * Created by ugurdonmez on 21/08/16.
 */
public class Solution {

    public ArrayList<Integer> postorderTraversal(TreeNode root) {

        Stack<TreeNodeEnc> stack = new Stack<>();

        ArrayList<Integer> result = new ArrayList<>();

        stack.push(new TreeNodeEnc(root, false));

        while (!stack.isEmpty()) {
            TreeNodeEnc n = stack.pop();

            if (n.print == false) {
                stack.add(new TreeNodeEnc(n.node, true));
                if (n.node.right != null) {
                    stack.push(new TreeNodeEnc(n.node.right, false));
                }
                if (n.node.left != null) {
                    stack.push(new TreeNodeEnc(n.node.left, false));
                }
            } else {
                result.add(n.node.val);
            }

        }

        return result;
    }

}

class TreeNodeEnc {
    TreeNode node;
    boolean print;

    public TreeNodeEnc(TreeNode node, boolean print) {
        this.node = node;
        this.print = print;
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