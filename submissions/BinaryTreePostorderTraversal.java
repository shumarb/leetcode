// Question: https://leetcode.com/problems/binary-tree-postorder-traversal/description/

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
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> postOrderElements = new ArrayList<>();
        populate(root, postOrderElements);
        return postOrderElements;
    }

    private void populate(TreeNode node, List<Integer> postOrderElements) {
        if (node != null) {
            populate(node.left, postOrderElements);
            populate(node.right, postOrderElements);
            postOrderElements.add(node.val);
        }
    }
}