// Question: https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/description/

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
class ConstructBinaryTreeFromPreorderAndInorderTraversal {
    private Map<Integer, Integer> map;
    private int[] inOrder;
    private int[] preOrder;
    private int preOrderIndex;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        map = new HashMap<>();
        inOrder = inorder;
        preOrder = preorder;
        preOrderIndex = 0;

        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }

        return buildTree(0, inorder.length - 1);
    }

    private TreeNode buildTree(int left, int right) {
        if (left > right) {
            return null;
        }

        int rootValue = preOrder[preOrderIndex++];
        int inOrderIndex = map.get(rootValue);
        TreeNode root = new TreeNode(rootValue);
        root.left = buildTree(left, inOrderIndex - 1);
        root.right = buildTree(inOrderIndex + 1, right);

        return root;
    }
}