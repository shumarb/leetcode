// Question: https://leetcode.com/problems/count-complete-tree-nodes/description/

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
class CountCompleteTreeNodes {
    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftHeight = getHeight(root, "left");
        int rightHeight = getHeight(root, "right");

        // 1. Perfect tree (all levels filled) has 2^height - 1 nodes.
        if (leftHeight == rightHeight) {
            return (int) Math.pow(2, leftHeight) - 1;
        }

        // 2. Recursive count nodes for non-perfect tree. Worst-case is counting all nodes.
        return 1 + countNodes(root.left) + countNodes(root.right);
    }

    private int getHeight(TreeNode current, String direction) {
        int height = 0;

        while (current != null) {
            height++;
            if (direction.equals("left")) {
                current = current.left;
            } else {
                current = current.right;
            }
        }

        return height;
    }
}