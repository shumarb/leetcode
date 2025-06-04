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
        inOrderTraversal(cloned, target);
        return result;
    }

    private void inOrderTraversal(TreeNode cloned, TreeNode target) {
        if (cloned != null) {
            inOrderTraversal(cloned.left, target);
            if (cloned.val == target.val) {
                result = cloned;
                return;
            }
            inOrderTraversal(cloned.right, target);
        }
    }
}