package trees.path_sum;

import java.math.BigInteger;
import java.util.LinkedList;

/**
 * Created by ugurdonmez on 23/08/16.
 */
public class Solution {

    public int hasPathSum(TreeNode root, int sum) {

        if (root == null && sum != 0) {
            return 0;
        }

        if (root == null && sum == 0) {
            return 1;
        }

        if (hasPathSum(root.left, sum - root.val) == 1) {
            return 1;
        }

        if (hasPathSum(root.right, sum - root.val) == 1) {
            return 1;
        }

        BigInteger bigInteger = new BigInteger("10001010");

        bigInteger.remainder(BigInteger.valueOf(1023)).intValue();

        return 0;
    }

    public int hasPathSum1(TreeNode root, int sum) {
        if(root == null) return 0;

        LinkedList<TreeNode> nodes = new LinkedList<TreeNode>();
        LinkedList<Integer> values = new LinkedList<Integer>();

        nodes.add(root);
        values.add(root.val);

        while(!nodes.isEmpty()){
            TreeNode curr = nodes.poll();
            int sumValue = values.poll();

            if(curr.left == null && curr.right == null && sumValue==sum){
                return 1;
            }

            if(curr.left != null){
                nodes.add(curr.left);
                values.add(sumValue+curr.left.val);
            }

            if(curr.right != null){
                nodes.add(curr.right);
                values.add(sumValue+curr.right.val);
            }
        }

        return 0;
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