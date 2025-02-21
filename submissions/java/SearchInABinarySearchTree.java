// Question: https://leetcode.com/problems/search-in-a-binary-search-tree/description/

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
class SearchInABinarySearchTree {
    private TreeNode result = null;

    public TreeNode searchBST(TreeNode root, int val) {
        traverse(root, val);
        return result;
    }

    private void traverse(TreeNode node, int val) {
        if (node == null) {
            return;
        }
        if (node.val == val) {
            result = node;
            return;
        }
        if (val < node.val) {
            traverse(node.left, val);
        } else {
            traverse(node.right, val);
        }
    }
}