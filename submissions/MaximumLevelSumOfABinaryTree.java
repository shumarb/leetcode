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
        Queue<TreeNode> queue = new LinkedList<>();
        boolean isTest = false;
        int level = 1;
        int result = 1;
        long maximumSum = Long.MIN_VALUE;

        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            long sum = 0l;

            while (size-- > 0) {
                TreeNode top = queue.poll();
                sum += top.val;
                if (top.left != null) {
                    queue.offer(top.left);
                }
                if (top.right != null) {
                    queue.offer(top.right);
                }
            }
            if (isTest) {
                System.out.println("level " + level + ": " + sum);
            }
            if (sum > maximumSum) {
                maximumSum = sum;
                result = level;
            }

            level++;
        }
        if (isTest) {
            System.out.println("--------------\nresult: " + result);
        }

        return result;
    }
}
