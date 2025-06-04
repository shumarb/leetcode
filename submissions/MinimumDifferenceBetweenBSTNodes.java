// Question: https://leetcode.com/problems/minimum-distance-between-bst-nodes/description/

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
class MinimumDifferenceBetweenBSTNodes {
    private int minimumDifference = Integer.MAX_VALUE;
    private TreeNode previous = null;

    public int minDiffInBST(TreeNode root) {
        inOrderTraversal(root);
        return minimumDifference;
    }

    private void inOrderTraversal(TreeNode node) {
        if (node != null) {
            inOrderTraversal(node.left);
            if (previous != null) {
                minimumDifference = Math.min(minimumDifference, node.val - previous.val);
            }
            previous = node;
            inOrderTraversal(node.right);
        }
    }
}