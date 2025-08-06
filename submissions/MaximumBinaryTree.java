// Question: https://leetcode.com/problems/maximum-binary-tree/description/

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
class MaximumBinaryTree {
    private TreeNode constructMaximumBinaryTree(int[] nums, int left, int right) {
        if (left > right) {
            return null;
        }

        int maximumIndex = left;
        for (int i = left + 1; i <= right; i++) {
            if (nums[i] > nums[maximumIndex]) {
                maximumIndex = i;
            }
        }

        TreeNode root = new TreeNode(nums[maximumIndex]);
        root.left = constructMaximumBinaryTree(nums, left, maximumIndex - 1);
        root.right = constructMaximumBinaryTree(nums, maximumIndex + 1, right);

        return root;
    }

    public TreeNode constructMaximumBinaryTree(int[] nums) {
        // 1. Edge case: Construct tree with 1 element.
        if (nums.length == 1) {
            return new TreeNode(nums[0]);
        }

        return constructMaximumBinaryTree(nums, 0, nums.length - 1);
    }
}