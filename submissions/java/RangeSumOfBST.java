// Question: https://leetcode.com/problems/range-sum-of-bst/description/

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
class RangeSumOfBST {
    private int sum = 0;

    public int rangeSumBST(TreeNode root, int low, int high) {
        inOrderTraversal(root, low, high);
        return sum;
    }

    private void inOrderTraversal(TreeNode node, int low, int high) {
        if (node != null) {
            inOrderTraversal(node.left, low, high);
            if (node.val >= low && node.val <= high) {
                sum += node.val;
            }
            inOrderTraversal(node.right, low, high);
        }
    }
}