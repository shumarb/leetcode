// Question: https://leetcode.com/problems/check-completeness-of-a-binary-tree/description/

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
class CheckCompletenessOfABinaryTree {
    public boolean isCompleteTree(TreeNode root) {
        return isCompleteTree(root, 0, countNodes(root));
    }

    private boolean isCompleteTree(TreeNode node, int index, int n) {
        if (node == null) {
            return true;
        }

        if (index >= n) {
            return false;
        }

        return isCompleteTree(node.left, 2 * index + 1, n) && isCompleteTree(node.right, 2 * index + 2, n);
    }

    private int countNodes(TreeNode root) {
        return (root == null) ? 0 : (1 + countNodes(root.left) + countNodes(root.right));
    }
}