// Question: https://leetcode.com/problems/binary-tree-preorder-traversal/description/

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
class BinaryTreePreorderTraversal {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> preOrderElements = new ArrayList<>();
        populate(root, preOrderElements);
        return preOrderElements;
    }

    private void populate(TreeNode node, List<Integer> preOrderElements) {
        if (node != null) {
            preOrderElements.add(node.val);
            populate(node.left, preOrderElements);
            populate(node.right, preOrderElements);
        }
    }
}