// Question: https://leetcode.com/problems/balanced-binary-tree/description/

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
class BalancedBinaryTree {
    public boolean isBalanced(TreeNode root) {
        return helper(root) != -1;
    }

    private int helper(TreeNode node) {
        // 1. Base case: node == null, so tree is balanced with height of 0
        if (node == null) {
            return 0;
        }

        /**
         2.  Recursively ibtain height of left subtree.
         If it is unbalaned, entire tree is unbalanced.
         */
        int leftSubtreeHeight = helper(node.left);
        if (leftSubtreeHeight == -1) {
            return -1;
        }

        /**
         3.  Recursively obtain height of left subtree.
         If it is unbalaned, entire tree is unbalanced.
         */
        int rightSubtreeHeight = helper(node.right);
        if (rightSubtreeHeight == -1) {
            return -1;
        }

        /**
         4.  Check if subtree with its root being current node is unbalanced.
         If it is unbalanced, entire tree is unbalanced
         */
        if (Math.abs(rightSubtreeHeight - leftSubtreeHeight) > 1) {
            return -1;
        }

        /**
         Current tree is balanced, so return its height.
         */
        return 1 + Math.max(leftSubtreeHeight, rightSubtreeHeight);
    }
}