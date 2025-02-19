// Question: https://leetcode.com/problems/second-minimum-node-in-a-binary-tree/description/

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
class SecondMinimumNodeInABinaryTree {
    private int secondMinimum = -1;
    private int minimum = -1;

    public int findSecondMinimumValue(TreeNode root) {
        // 1. Guaranteed root is minimum value given root.val = min(root.left.val, root.right.val) always holds
        minimum = root.val;
        findSecondMinimum(root);
        return secondMinimum;
    }

    private void findSecondMinimum(TreeNode node) {
        if (node == null) {
            return;
        }
        if (node.val != minimum) {
            if (secondMinimum == -1 || node.val < secondMinimum) {
                secondMinimum = node.val;
            }
        }
        findSecondMinimum(node.left);
        findSecondMinimum(node.right);
    }
}