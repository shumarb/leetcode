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
        List<Integer> elements = new ArrayList<>();
        inOrderTraversal(root, elements);
        return elements;
    }

    private void inOrderTraversal(TreeNode node, List<Integer> elements) {
        if (node != null) {
            inOrderTraversal(node.left, elements);
            elements.add(node.val);
            inOrderTraversal(node.right, elements);
        }
    }
}