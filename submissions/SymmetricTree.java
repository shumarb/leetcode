// Question: https://leetcode.com/problems/symmetric-tree/description/

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
class SymmetricTree {
    public boolean isSymmetric(TreeNode root) {
        return isSymmetric(root.left, root.right);
    }

    private boolean isSymmetric(TreeNode left, TreeNode right) {
        // 1. Symmetric if both left and right nodes are null
        if (left == null && right == null) {
            return true;
        }

        // 2. Not symmetric if either one of the nodes - but not both - are null
        if ((left == null && right != null) || (right == null && left != null)) {
            return false;
        }

        /**
         3.  Both left and right nodes are not null,
         so both are symmetric if:
         1. both nodes share same value.
         2. left's left subtree == right's right subtree.
         3. left's right subtree == right's left subtree.
         */
        return left.val == right.val && isSymmetric(left.left, right.right) && isSymmetric(left.right, right.left);
    }
}