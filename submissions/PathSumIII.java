// Question: https://leetcode.com/problems/path-sum-iii/description/

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
class PathSumIII {
    private int result;
    private long target;

    private void dfs(TreeNode node, long sum) {
        if (node != null) {
            sum += node.val;
            if (sum == target) {
                result++;
            }

            dfs(node.left, sum);
            dfs(node.right, sum);
        }
    }

    private void dfs(TreeNode node) {
        if (node != null) {
            dfs(node, 0);
            dfs(node.left);
            dfs(node.right);
        }
    }

    public int pathSum(TreeNode root, int targetSum) {
        result = 0;
        target = targetSum;
        dfs(root);

        return result;
    }
}
