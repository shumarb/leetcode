// Question: https://leetcode.com/problems/maximum-level-sum-of-a-binary-tree/description/

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
class MaximumLevelSumOfABinaryTree {
    public int maxLevelSum(TreeNode root) {
        int maximumLevelSum = Integer.MIN_VALUE;
        int smallestLevelOfMaximumSum = Integer.MAX_VALUE;
        int level = 0;
        boolean isTest = true;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            level++;
            int size = queue.size();
            int currentLevelSum = 0;
            for (int i = 0; i < size; i++) {
                TreeNode current = queue.poll();
                currentLevelSum += current.val;
                if (current.left != null) {
                    queue.offer(current.left);
                }
                if (current.right != null) {
                    queue.offer(current.right);
                }
            }
            if (currentLevelSum > maximumLevelSum) {
                maximumLevelSum = currentLevelSum;
                smallestLevelOfMaximumSum = level;
            } else if (currentLevelSum == maximumLevelSum && level < smallestLevelOfMaximumSum) {
                smallestLevelOfMaximumSum = level;
            }
        }

        return smallestLevelOfMaximumSum;
    }
}