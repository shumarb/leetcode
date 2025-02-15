// Question: https://leetcode.com/problems/binary-tree-inorder-traversal/description/

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
class BinaryTreeInorderTraversal {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> inOrderElements = new ArrayList<>();
        populate(root, inOrderElements);
        return inOrderElements;
    }

    private void populate(TreeNode node, List<Integer> inOrderElements) {
        if (node != null) {
            populate(node.left, inOrderElements);
            inOrderElements.add(node.val);
            populate(node.right, inOrderElements);
        }
    }
}