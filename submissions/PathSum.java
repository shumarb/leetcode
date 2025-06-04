// Question: https://leetcode.com/problems/path-sum/description/?envType=problem-list-v2&envId=depth-first-search

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
class PathSum {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        // 1. Base case: No path to check, to return false.
        if (root == null) {
            return false;
        }

        // 2. Upon encountering a node, reduce target sum by its value
        targetSum -= root.val;

        // 3. If reached leaf, so check if path sum exists
        if (root.left == null && root.right == null) {
            return targetSum == 0;
        }

        // 4. Recursive case: A path has not been exhausted, so check current node's left and right subtrees.
        return hasPathSum(root.left, targetSum) || hasPathSum(root.right, targetSum);
    }
}