// Question: https://leetcode.com/problems/subtree-of-another-tree/description/

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
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        /**
            1. Root is null, so no tree to compare.
         */
        if (root == null) {
            return false;
        }

        /**
            2. Root are subRoot are the same tree.
         */
        if (isSameTree(root, subRoot)) {
            return true;
        }

        /**
            3. Check that subRoot is a subtree of root.
         */
        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }

    private boolean isSameTree(TreeNode first, TreeNode second) {
        /**
            4. Both are the same if both are null.
         */
        if (first == null && second == null) {
            return true;
        }

        /**
            5. Different trees if both values are different.
         */
        if (first == null || second == null || first.val != second.val) {
            return false;
        }

        /**
            6. Same trees is current, left, and right children are the same.
         */
        return isSameTree(first.left, second.left) && isSameTree(first.right, second.right);
    }
}