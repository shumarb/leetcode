// Question: https://leetcode.com/problems/find-bottom-left-tree-value/description/

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
class FindBottomLeftTreeValue {
    private int maximumDepth;
    private int result;

    public int findBottomLeftValue(TreeNode root) {
        boolean isTest = false;
        maximumDepth = -1;
        result = -1;

        helper(root, 0);
        if (isTest) {
            System.out.println("maximum depth: " + maximumDepth + "\nresult: " + result);
        }

        return result;
    }

    private void helper(TreeNode node, int currentDepth) {
        if (currentDepth > maximumDepth) {
            maximumDepth = currentDepth;
            result = node.val;
        }

        if (node.left != null) {
            helper(node.left, currentDepth + 1);
        }

        if (node.right != null) {
            helper(node.right, currentDepth + 1);
        }
    }
}