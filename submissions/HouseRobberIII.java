// Question: https://leetcode.com/problems/house-robber-iii/description/

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
class HouseRobberIII {
    public int rob(TreeNode root) {
        int[] result = dfs(root);

        // result[0]: maximum if we don't rob this node.
        // result[1]: maximum if we rob this node.
        return Math.max(result[0], result[1]);
    }

    private int[] dfs(TreeNode node) {
        if (node == null) {
            return new int[] {0, 0};
        }

        // left: maximum if we don't rob this node.
        // right: maximum if we rob this node.
        int[] left = dfs(node.left);
        int[] right = dfs(node.right);

        int notRobLeft = left[0];
        int notRobRight = right[0];
        int robLeft = left[1];
        int robRight = right[1];

        // 1. Rob node => can't rob both left and right.
        //    Not rob node ==> choose maximum combination of robbing/not robbing node's left and right subtrees.
        int totalIfNotRobNode = Math.max(notRobLeft, robLeft) + Math.max(notRobRight, robRight);
        int totalIfRobNode = node.val + notRobLeft + notRobRight;

        return new int[] {totalIfNotRobNode, totalIfRobNode};
    }
}
