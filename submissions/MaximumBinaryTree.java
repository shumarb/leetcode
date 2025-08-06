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
    private int[] map;
    private int[] nums;

    private TreeNode constructMaximumBinaryTree(int left, int right) {
        if (left > right) {
            return null;
        }

        int maximum = nums[left];
        int maximumIndex = left;

        for (int i = left + 1; i <= right; i++) {
            if (nums[i] > maximum) {
                maximum = nums[i];
                maximumIndex = i;
            }
        }

        TreeNode root = new TreeNode(nums[maximumIndex]);
        root.left = constructMaximumBinaryTree(left, maximumIndex - 1);
        root.right = constructMaximumBinaryTree(maximumIndex + 1, right);

        return root;
    }

    private void populate() {
        int largest = nums[0];

        for (int i = 1; i < nums.length; i++) {
            largest = Math.max(largest, nums[i]);
        }
        map = new int[largest + 1];
        for (int i = 0; i < nums.length; i++) {
            map[nums[i]] = i;
        }
    }

    public TreeNode constructMaximumBinaryTree(int[] nums) {
        // 1. Edge case: Construct tree with 1 element.
        if (nums.length == 1) {
            return new TreeNode(nums[0]);
        }

        this.nums = nums;
        populate();

        return constructMaximumBinaryTree(0, nums.length - 1);
    }
}