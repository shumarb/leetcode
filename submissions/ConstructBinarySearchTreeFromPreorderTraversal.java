// Question: https://leetcode.com/problems/construct-binary-search-tree-from-preorder-traversal/description/

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
class ConstructBinarySearchTreeFromPreorderTraversal {
    private int[] preorder;
    private int rootIndex;

    private TreeNode bstFromPreorder(int lowerBound, int upperBound) {
        if (rootIndex == preorder.length || preorder[rootIndex] < lowerBound || preorder[rootIndex] > upperBound) {
            return null;
        }

        int rootValue = preorder[rootIndex++];
        TreeNode root = new TreeNode(rootValue);
        root.left = bstFromPreorder(lowerBound, rootValue);
        root.right = bstFromPreorder(rootValue, upperBound);

        return root;
    }

    public TreeNode bstFromPreorder(int[] preorder) {
        rootIndex = 0;
        this.preorder = preorder;

        return bstFromPreorder(1, 1000);
    }
}