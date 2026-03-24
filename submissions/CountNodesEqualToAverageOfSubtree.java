// Question: https://leetcode.com/problems/count-nodes-equal-to-average-of-subtree/description/

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
class CountNodesEqualToAverageOfSubtree {
    private boolean isTest;
    private int result;

    public int averageOfSubtree(TreeNode root) {
        isTest = false;
        result = 0;

        dfs(root);

        return result;
    }

    private int[] dfs(TreeNode node) {
        if (node == null) {
            return new int[] {0, 0};
        }

        int[] leftSubtree = dfs(node.left);
        int[] rightSubtree = dfs(node.right);

        int count = leftSubtree[1] + rightSubtree[1] + 1;
        int sum = leftSubtree[0] + rightSubtree[0] + node.val;

        if (isTest) {
            System.out.println(" * node: " + node.val + " | leftSubtree: " + Arrays.toString(leftSubtree) + " | rightSubtree: " + Arrays.toString(rightSubtree));
        }
        if ((sum / count) == node.val) {
            result++;
        }

        return new int[] {sum, count};
    }
}