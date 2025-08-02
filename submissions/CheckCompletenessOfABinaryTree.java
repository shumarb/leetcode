// Question: https://leetcode.com/problems/check-completeness-of-a-binary-tree/description/

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
class CheckCompletenessOfABinaryTree {
    public boolean isCompleteTree(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        boolean isNullFoundEarlier = false;

        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode current = queue.poll();

            if (current == null) {
                isNullFoundEarlier = true;
                continue;

            } else if (current != null && isNullFoundEarlier) {
                return false;
            }

            queue.offer(current.left);
            queue.offer(current.right);
        }

        return true;
    }
}