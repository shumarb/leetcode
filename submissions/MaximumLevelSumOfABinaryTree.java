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
        int levelOfMaximum = 1;
        int maximumSum = root.val;

        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            int sum = 0;

            for (int i = 0; i < size; i++) {
                TreeNode current = queue.poll();
                sum += current.val;
                if (current.left != null) {
                    queue.offer(current.left);
                }
                if (current.right != null) {
                    queue.offer(current.right);
                }
            }
            if (isTest) {
                System.out.println("level " + level + " -> " + sum );
                System.out.println(" * before, maximumSum: " + maximumSum + ", levelOfMaximum: " + levelOfMaximum);
            }

            if (sum > maximumSum) {
                maximumSum = sum;
                levelOfMaximum = level;
            }
            if (isTest) {
                System.out.println(" * after, maximumSum: " + maximumSum + ", levelOfMaximum: " + levelOfMaximum);
                System.out.println("-------------------------------------------------------------------------");
            }

            level++;
        }

        return levelOfMaximum;
    }
}
