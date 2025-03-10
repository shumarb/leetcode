// Question: https://leetcode.com/problems/univalued-binary-tree/description/

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
class UnivaluedBinaryTree {
    private boolean isUnivaluedTree = true;
    private int previous = -1;

    public boolean isUnivalTree(TreeNode root) {
        inOrderTraversal(root);
        return isUnivaluedTree;
    }

    private void inOrderTraversal(TreeNode node) {
        if (node != null) {
            inOrderTraversal(node.left);
            if (previous == -1) {
                previous = node.val;
            } else {
                if (node.val != previous) {
                    isUnivaluedTree = false;
                    return;
                }
            }
            inOrderTraversal(node.right);
        }
    }
}