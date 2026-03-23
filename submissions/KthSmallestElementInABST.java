// Question: https://leetcode.com/problems/kth-smallest-element-in-a-bst/description/

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
class KthSmallestElementInABST {
    private int count;
    private int result;

    public int kthSmallest(TreeNode root, int k) {
        count = 0;
        result = 0;

        inOrder(root, k);

        return result;
    }

    private void inOrder(TreeNode node, int k) {
        if (node == null) {
            return;
        }

        inOrder(node.left, k);
        if (++count == k) {
            result = node.val;
            return;
        }
        inOrder(node.right, k);
    }
}
