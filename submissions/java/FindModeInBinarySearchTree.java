// Question: https://leetcode.com/problems/find-mode-in-binary-search-tree/description/

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
class FindModeInBinarySearchTree {
    private int[] numberFrequency = new int[200001];
    private int maximumFrequency = 0;
    private int countMaximumFrequency = 0;

    public int[] findMode(TreeNode root) {
        boolean isTest = false;

        helper(root);
        if (isTest) {
            System.out.println("maximumFrequency: " + maximumFrequency);
            System.out.println("countMaximumFrequency: " + countMaximumFrequency);
        }

        int[] result = new int[countMaximumFrequency];
        int j = 0;
        int len = numberFrequency.length;
        for (int i = 0; i < len; i++) {
            if (numberFrequency[i] == maximumFrequency) {
                result[j++] = i - 100000;
            }
        }
        if (isTest) {
            System.out.println("result: " + Arrays.toString(result));
        }

        return result;
    }

    private void helper(TreeNode node) {
        if (node != null) {
            numberFrequency[node.val + 100000]++;
            if (numberFrequency[node.val + 100000] > maximumFrequency) {
                maximumFrequency = numberFrequency[node.val + 100000];
                countMaximumFrequency = 1;
            } else if (numberFrequency[node.val + 100000] == maximumFrequency) {
                countMaximumFrequency++;
            }
            helper(node.left);
            helper(node.right);
        }
    }
}