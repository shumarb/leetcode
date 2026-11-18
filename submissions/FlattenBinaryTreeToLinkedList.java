// Question: https://leetcode.com/problems/flatten-binary-tree-to-linked-list/description/

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
class FlattenBinaryTreeToLinkedList {
    private TreeNode previous;

    public void flatten(TreeNode root) {
        if (root == null || (root.left == null && root.right == null)) {
            return;
        }

        previous = null;
        dfs(root);
    }

    private void dfs(TreeNode node) {
        if (node == null) {
            return;
        }

        TreeNode left = node.left;
        TreeNode right = node.right;

        node.left = null;
        node.right = null;

        if (previous != null) {
            previous.right = node;
        }

        previous = node;
        dfs(left);
        dfs(right);

    }
}
