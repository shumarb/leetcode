// Question:

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
class SameTree {
    private boolean result = true;

    public boolean isSameTree(TreeNode p, TreeNode q) {
        helper(p, q);
        return result;
    }

    private void helper(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return;
        }

        if (p != null && q == null) {
            result = false;
            return;
        }

        if (p == null && q != null) {
            result = false;
            return;
        }

        if (p.val != q.val) {
            result = false;
            return;
        }

        helper(p.left, q.left);
        helper(p.right, q.right);

    }
}