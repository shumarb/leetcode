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
    private int result;

    public int averageOfSubtree(TreeNode root) {
        result = 0;

        dfs(root);

        return result;
    }

    private int[] dfs(TreeNode node) {
        if (node == null) {
            return new int[] {0, 0};
        }

        boolean isTest = false;
        int[] leftSubtree = dfs(node.left);
        int[] rightSubtree = dfs(node.right);
        int element = node.val;
        int n = 1 + leftSubtree[1] + rightSubtree[1];
        int sum = element + leftSubtree[0] + rightSubtree[0];
        int average = sum / n;

        if (average == element) {
            result++;
        }
        if (isTest) {
            System.out.print("-----------------------------------\n" + node.val + "\n * leftSubtree: " + Arrays.toString(leftSubtree) + "\n * rightSubtreee: " + Arrays.toString(leftSubtree) + "\n * sum: " + sum + "\n * n: " + n + "\n * average: " + average);
            if (average == element) {
                System.out.println("\n ** valid");
            } else {
                System.out.println();
            }
        }

        return new int[] {sum, n};
    }
}
