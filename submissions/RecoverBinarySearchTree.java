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
class RecoverBinarySearchTree {
    private TreeNode first;
    private TreeNode second;
    private TreeNode previous;

    private void inOrder(TreeNode node) {
        if (node == null) {
            return;
        }

        inOrder(node.left);
        if (first == null && previous.val > node.val) {
            first = previous;
        }
        if (first != null && previous.val > node.val) {
            second = node;
        }
        previous = node;
        inOrder(node.right);
    }

    public void recoverTree(TreeNode root) {
        first = null;
        second = null;
        previous = new TreeNode(Integer.MIN_VALUE);

        inOrder(root);
        int temp = first.val;
        first.val = second.val;
        second.val = temp;
    }
}