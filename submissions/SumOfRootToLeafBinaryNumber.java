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
class SumOfRootToLeafBinaryNumber {
    private boolean isTest = false;
    private int sum = 0;

    public int sumRootToLeaf(TreeNode root) {
        traverse(root, 0);
        if (isTest) {
            System.out.println("------------------------------");
            System.out.println("sum: " + sum);
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
        }

        traverse(node.left, current);
        traverse(node.right, current);
    }
}