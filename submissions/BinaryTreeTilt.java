// Question: https://leetcode.com/problems/binary-tree-tilt/description/

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class BinaryTreeTilt {
    private int totalTilt;

    private int helper(TreeNode node) {
        if (node == null) {
            return 0;
        }

        int leftSum = helper(node.left);
        int rightSum = helper(node.right);
        totalTilt += Math.abs(leftSum - rightSum);

        return node.val + leftSum + rightSum;
    }

    public int findTilt(TreeNode root) {
        helper(root);
        return totalTilt;
    }
}