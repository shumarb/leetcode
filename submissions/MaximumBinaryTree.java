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

        int rootValue = getMaximum(left, right);
        int rootIndex = map[rootValue];

        TreeNode root = new TreeNode(rootValue);
        root.left = constructMaximumBinaryTree(left, rootIndex - 1);
        root.right = constructMaximumBinaryTree(rootIndex + 1, right);

        return root;
    }

    private int getMaximum(int left, int right) {
        int largest = -1;

        for (int i = left; i <= right; i++) {
            largest = Math.max(largest, nums[i]);
        }

        return largest;
    }

    public TreeNode constructMaximumBinaryTree(int[] nums) {
        // 1. Edge case: Construct tree with 1 element.
        if (nums.length == 1) {
            return new TreeNode(nums[0]);
        }

        boolean isTest = false;
        int largest = -1;
        this.nums = nums;

        for (int number: nums) {
            largest = Math.max(largest, number);
        }
        map = new int[largest + 1];
        Arrays.fill(map, -1);
        for (int i = 0; i < nums.length; i++) {
            map[nums[i]] = i;
        }
        if (isTest) {
            System.out.println("nums: " + Arrays.toString(nums) + "\nmap:  " + Arrays.toString(map));
        }

        return constructMaximumBinaryTree(0, nums.length - 1);
    }
}