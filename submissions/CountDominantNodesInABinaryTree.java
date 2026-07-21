// Question: https://leetcode.com/problems/count-dominant-nodes-in-a-binary-tree/description/

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
class CountDominantNodesInABinaryTree {
    private boolean isTest;
    private int result;

    public int countDominantNodes(TreeNode root) {
        isTest = false;
        result = 0;

        dfs(root);

        return result;
    }

    private int dfs(TreeNode node) {
        if (node == null) {
            return 0;
        }

        // 1. Leaves are dominant.
        if (node.left == null && node.right == null) {
            if (isTest) {
                System.out.println(" * dominant: " + node.val);
            }

            result++;
            return node.val;
        }

        // 2. Node is dominant if it's value is the maximum after comparing it with the maximum values in its left and right subtrees.
        int leftMaximum = dfs(node.left);
        int rightMaximum = dfs(node.right);
        int subtreeMaximum = Math.max(node.val, Math.max(leftMaximum, rightMaximum));

        if (node.val == subtreeMaximum) {
            if (isTest) {
                System.out.println(" * dominant: " + node.val);
            }

            result++;
        }

        return subtreeMaximum;
    }
}
