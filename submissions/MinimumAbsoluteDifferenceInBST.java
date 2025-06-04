// Question: https://leetcode.com/problems/minimum-absolute-difference-in-bst/description/

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
class MinimumAbsoluteDifferenceInBST {
    private TreeNode previous = null;
    private int minimumDifference = Integer.MAX_VALUE;

    public int getMinimumDifference(TreeNode root) {
        inOrderTraversal(root);
        return minimumDifference;
    }

    private void inOrderTraversal(TreeNode node) {
        if (node != null) {
            inOrderTraversal(node.left);
            if (previous != null) {
                minimumDifference = Math.min(minimumDifference, Math.abs(node.val - previous.val));
            }
            previous = node;
            inOrderTraversal(node.right);
        }
    }
}