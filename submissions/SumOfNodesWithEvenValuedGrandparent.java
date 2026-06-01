// Question: https://leetcode.com/problems/sum-of-nodes-with-even-valued-grandparent/description/

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
class SumOfNodesWithEvenValuedGrandparent {
    private int result;

    public int sumEvenGrandparent(TreeNode root) {
        result = 0;
        dfs(root);
        return result;
    }

    private void dfs(TreeNode node) {
        if (node == null) {
            return;
        }

        if (node.val % 2 == 0) {
            result += getSumOfGrandchildren(node.left);
            result += getSumOfGrandchildren(node.right);
        }

        dfs(node.left);
        dfs(node.right);
    }

    private int getSumOfGrandchildren(TreeNode node) {
        if (node == null) {
            return 0;
        }

        int sum = 0;
        if (node.left != null) {
            sum += node.left.val;
        }
        if (node.right != null) {
            sum += node.right.val;
        }

        return sum;
    }
}
