// Question: https://leetcode.com/problems/sum-of-root-to-leaf-binary-numbers/description/

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
class Solution {
    private boolean isTest;
    private int sum;

    public int sumRootToLeaf(TreeNode root) {
        isTest = false;
        sum = 0;

        traverse(root, 0);
        if (isTest) {
            System.out.println("------------------------------\nsum: " + sum);
        }

        return sum;
    }

    private void traverse(TreeNode node, int current) {
        if (node == null) {
            return;
        }

        current = current * 2 + node.val;
        if (node.left == null && node.right == null) {
            if (isTest) {
                System.out.println(" * current: " + current);
            }
            sum += current;
            return;
        }

        if (node.left != null) {
            traverse(node.left, current);
        }
        if (node.right != null) {
            traverse(node.right, current);
        }
    }
}