// Question: https://leetcode.com/problems/merge-two-binary-trees/description/

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
class MergeTwoBinaryTrees {
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        /**
             1.  root1 is the merged tree,
             so check the corresponding nodes to each other.
         */
        if (root1 == null) {
            return root2;
        }
        if (root2 == null) {
            return root1;
        }

        /**
         2.  Both subtrees are non-null, so merge roots (increase value of root1 by root2),
             and its left and right nodes accordingly.
             Apply these changes to root1 (tree to apply merges).
         */
        root1.val += root2.val;
        root1.left = mergeTrees(root1.left, root2.left);
        root1.right = mergeTrees(root1.right, root2.right);
        return root1;
    }
}