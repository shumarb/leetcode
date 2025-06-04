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
    private long previous = Long.MIN_VALUE;
    private boolean result = true;

    public boolean isValidBST(TreeNode root) {
        inOrderTraversal(root);
        return result;
    }

    private void inOrderTraversal(TreeNode node) {
        if (node == null) {
            return;
        }
        inOrderTraversal(node.left);
        if (previous == Long.MIN_VALUE) {
            previous = (long) node.val;
        } else {
            if ((long) node.val <= previous) {
                result = false;
                return;
            }
            previous = (long) node.val;
        }
        inOrderTraversal(node.right);
    }
}