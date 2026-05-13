// Question: https://leetcode.com/problems/even-odd-tree/description/

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
class EvenOddTree {
    public boolean isEvenOddTree(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        boolean isIncreasing = true;

        queue.offer(root);
        while (!queue.isEmpty()) {
            int previous = isIncreasing ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            int size = queue.size();

            if (isIncreasing) {
                for (TreeNode node: queue) {
                    if (node.val % 2 == 0 || node.val <= previous) {
                        return false;
                    }

                    previous = node.val;
                }
            } else {
                for (TreeNode node: queue) {
                    if (node.val % 2 == 1 || node.val >= previous) {
                        return false;
                    }

                    previous = node.val;
                }
            }

            while (size-- > 0) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }

            isIncreasing = !isIncreasing;
        }

        return true;
    }
}
