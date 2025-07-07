// Question: https://leetcode.com/problems/maximum-difference-between-node-and-ancestor/description/

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
class MaximumDifferenceBetweenNodeAndAncestor {
    private int maxAncestorDiff = 0;

    public int maxAncestorDiff(TreeNode root) {
        boolean isTest = false;
        helper(root, new ArrayList<>());
        return maxAncestorDiff;
    }

    private void helper(TreeNode node, ArrayList<Integer> path) {
        if (node == null) {
            return;
        }

        path.add(node.val);
        if (node.left == null && node.right == null) {
            int maximum = Integer.MIN_VALUE;
            int minimum = Integer.MAX_VALUE;
            for (int value: path) {
                maximum = Math.max(maximum, value);
                minimum = Math.min(minimum, value);
            }
            maxAncestorDiff = Math.max(maxAncestorDiff, maximum - minimum);
        }

        helper(node.left, path);
        helper(node.right, path);
        path.removeLast();
    }
}