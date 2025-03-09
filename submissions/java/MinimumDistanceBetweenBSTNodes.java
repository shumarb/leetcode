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
class MinimumDistanceBetweenBSTNodes {
    private int minimumDifference = Integer.MAX_VALUE;
    private int previous = -1;

    public int minDiffInBST(TreeNode root) {
        inOrderTraversal(root);
        return minimumDifference;
    }

    private void inOrderTraversal(TreeNode node) {
        if (node == null) {
            return;
        }
        inOrderTraversal(node.left);
        if (previous == -1) {
            previous = node.val;
        } else {
            minimumDifference = Math.min(minimumDifference, node.val - previous);
        }
        previous = node.val;
        inOrderTraversal(node.right);
    }
}