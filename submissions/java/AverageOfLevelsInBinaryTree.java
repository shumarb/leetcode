// Question: https://leetcode.com/problems/average-of-levels-in-binary-tree/description/

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
class AverageOfLevelsInBinaryTree {
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> result = new ArrayList<>();
        boolean isTest = false;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            double sumOfLevel = 0;
            for (int i = 0; i < size; i++) {
                TreeNode current = queue.poll();
                sumOfLevel += (double) current.val;
                if (current.left != null) {
                    queue.offer(current.left);
                }
                if (current.right != null) {
                    queue.offer(current.right);
                }
            }
            if (isTest) {
                System.out.println(" * sumOfLevel: " + sumOfLevel + ", size: " + (double) size + ", adding: " + (sumOfLevel / (double) size));
            }
            result.add(sumOfLevel / (double) size);
        }

        if (isTest) {
            System.out.println("result: " + result);
        }
        return result;
    }
}