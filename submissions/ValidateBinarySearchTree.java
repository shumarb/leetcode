// Question: https://leetcode.com/problems/validate-binary-search-tree/description/

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
class ValidateBinarySearchTree {
    private boolean result;
    private long last;

    public boolean isValidBST(TreeNode root) {
        last = Long.MIN_VALUE;
        result = true;

        inOrder(root);

        return result;
    }

    private void inOrder(TreeNode node) {
        if (node == null) {
            return;
        }

        if (node.left != null) {
            inOrder(node.left);
        }

        if (last != Long.MIN_VALUE && node.val <= last) {
            result = false;
            return;
        }
        last = node.val;

        if (node.right != null) {
            inOrder(node.right);
        }
    }
}