// Question: https://leetcode.com/problems/diameter-of-binary-tree/description/

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
class DiameterOfBinaryTree {
    private boolean isTest = false;
    private int diameter = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        findDepth(root);
        return diameter;
    }

    private int findDepth(TreeNode current) {
        if (current == null) {
            return 0;
        }

        int leftDepth = findDepth(current.left);
        int rightDepth = findDepth(current.right);
        diameter = Math.max(diameter, leftDepth + rightDepth);
        if (isTest) {
            System.out.println("-------------------------------------------");
            System.out.println("current: " + current.val);
            System.out.println("leftDepth: " + leftDepth + ", rightDepth: " + rightDepth);
            System.out.println("diameter: " + diameter);
        }

        return 1 + Math.max(leftDepth, rightDepth);
    }
}