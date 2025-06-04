// Question: https://leetcode.com/problems/deepest-leaves-sum/description/

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
class DeepestLeavesSum {
    private int maximumLevel = 0;
    private int deepestLeavesSum = 0;

    public int deepestLeavesSum(TreeNode root) {
        dfs(root, 1);
        return deepestLeavesSum;
    }

    private void dfs(TreeNode node, int currentLevel) {
        if (node != null) {
            if (currentLevel > maximumLevel) {
                maximumLevel = currentLevel;
                deepestLeavesSum = node.val;
            } else if (currentLevel == maximumLevel) {
                deepestLeavesSum += node.val;
            }

            if (node.left != null) {
                dfs(node.left, 1 + currentLevel);
            }
            if (node.right != null) {
                dfs(node.right, 1 + currentLevel);
            }
        }
    }
}
