// Question: https://leetcode.com/problems/maximum-difference-between-node-and-ancestor/description/

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
class MaximumDifferenceBetweenNodeAndAncestor {
    private int maxAncestorDiff = 0;

    public int maxAncestorDiff(TreeNode root) {
        helper(root, root.val, root.val);
        return maxAncestorDiff;
    }

    private void helper(TreeNode node, int currentMaximum, int currentMinimum) {
        if (node == null) {
            return;
        }

        int nodeValue = node.val;
        int difference1 = Math.abs(nodeValue - currentMinimum);
        int difference2 = Math.abs(nodeValue - currentMaximum);
        maxAncestorDiff = Math.max(maxAncestorDiff, Math.max(difference1, difference2));

        currentMaximum = Math.max(currentMaximum, nodeValue);
        currentMinimum = Math.min(currentMinimum, nodeValue);

        helper(node.left, currentMaximum, currentMinimum);
        helper(node.right, currentMaximum, currentMinimum);
    }
}