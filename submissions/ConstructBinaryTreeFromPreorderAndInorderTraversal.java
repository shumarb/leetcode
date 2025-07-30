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
    private Map<Integer, Integer> inOrderIndexMap;
    private int[] inOrder;
    private int[] preOrder;
    private int preOrderIndex;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        inOrderIndexMap = new HashMap<>();
        preOrderIndex = 0;
        this.preOrder = preorder;
        this.inOrder = inorder;

        for (int i = 0; i < inorder.length; i++) {
            inOrderIndexMap.put(inorder[i], i);
        }

        return buildTree(0, inorder.length - 1);
    }

    private TreeNode buildTree(int left, int right) {
        if (left > right) {
            return null;
        }

        int rootValue = preOrder[preOrderIndex++];
        TreeNode root = new TreeNode(rootValue);

        int inOrderIndex = inOrderIndexMap.get(rootValue);
        root.left = buildTree(left, inOrderIndex - 1);
        root.right = buildTree(inOrderIndex + 1, right);

        return root;
    }
}