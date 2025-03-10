// Question: https://leetcode.com/problems/find-a-corresponding-node-of-a-binary-tree-in-a-clone-of-that-tree/description/

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class FindACorrespondingNodeOfABinaryTreeInACloneOfThatTree {
    private TreeNode result = null;

    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        inOrderTraversal(original, cloned, target);
        return result;
    }

    private void inOrderTraversal(TreeNode original, TreeNode cloned, TreeNode target) {
        if (cloned != null) {
            inOrderTraversal(original.left, cloned.left, target);
            if (original.val == target.val && cloned.val == target.val) {
                result = cloned;
                return;
            }
            inOrderTraversal(original.right, cloned.right, target);
        }
    }
}