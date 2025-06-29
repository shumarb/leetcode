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
class PathSumThree {
    private int count = 0;

    public int pathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return 0;
        }

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode current = stack.pop();
            if (current.left != null) {
                stack.push(current.left);
            }
            if (current.right != null) {
                stack.push(current.right);
            }
            findPath(current, (long) targetSum);
        }

        return count;
    }

    private void findPath(TreeNode node, long targetSum) {
        if (node == null) {
            return;
        }

        if ((long) node.val == targetSum) {
            count++;
        }

        findPath(node.left, targetSum - node.val);
        findPath(node.right, targetSum - node.val);
    }
}