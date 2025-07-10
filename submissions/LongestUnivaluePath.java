// Question: https://leetcode.com/problems/longest-univalue-path/description/

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
class LongestUnivaluePath {
    private int result;

    public int longestUnivaluePath(TreeNode root) {
        if (root == null) {
            return 0;
        }

        result = 0;
        helper(root);

        return result;
    }

    private int helper(TreeNode node) {
        int left = 0;
        int right = 0;

        if (node.left != null) {
            left = helper(node.left);
        }
        if (node.right != null) {
            right = helper(node.right);
        }

        int leftPath = (node.left != null && node.left.val == node.val) ? left + 1 : 0;
        int rightPath = (node.right != null && node.right.val == node.val) ? right + 1 : 0;
        result = Math.max(result, leftPath + rightPath);

        return Math.max(leftPath, rightPath);
    }
}