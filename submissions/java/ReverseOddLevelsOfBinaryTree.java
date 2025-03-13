// Question: https://leetcode.com/problems/reverse-odd-levels-of-binary-tree/description/

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
class ReverseOddLevelsOfBinaryTree {
    public TreeNode reverseOddLevels(TreeNode root) {
        reverseOddLevels(root.left, root.right, 1);
        return root;
    }

    private void reverseOddLevels(TreeNode leftSubtree, TreeNode rightSubtree, int level) {
        if (leftSubtree == null && rightSubtree == null) {
            return;
        }

        if (level % 2 == 1) {
            int temp = leftSubtree.val;
            leftSubtree.val = rightSubtree.val;
            rightSubtree.val = temp;
        }

        reverseOddLevels(leftSubtree.left, rightSubtree.right, level + 1);
        reverseOddLevels(leftSubtree.right, rightSubtree.left, level + 1);
    }
}