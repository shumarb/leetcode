// Question: https://leetcode.com/problems/count-good-nodes-in-binary-tree/description/

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
class CountGoodNodesInBinaryTree {
    private boolean isTest = false;
    private int totalGoodNodes = 0;

    public int goodNodes(TreeNode root) {
        dfs(root, Integer.MIN_VALUE);
        if (isTest) {
            System.out.println("-----------------------------------------------");
            System.out.println("totalGoodNodes: " + totalGoodNodes);
        }

        return totalGoodNodes;
    }

    private void dfs(TreeNode node, int maximumSoFar) {
        if (isTest) {
            System.out.println("-----------------------------------------------");
            System.out.println("node: " + node.val + ", maximumSoFar: " + maximumSoFar);
        }
        if (maximumSoFar <= node.val) {
            if (isTest) {
                System.out.println(" * good");
            }
            totalGoodNodes++;
        }

        if (node.left != null) {
            dfs(node.left, Math.max(node.val, maximumSoFar));
        }
        if (node.right != null) {
            dfs(node.right, Math.max(node.val, maximumSoFar));
        }
    }
}