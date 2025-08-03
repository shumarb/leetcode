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
    private Map<Integer, Integer> inorderIndexMap;
    private int[] inorder;
    private int[] preorder;
    private int i;

    public TreeNode bstFromPreorder(int[] preorder) {
        // 1. Edge case: 1 element in tree.
        if (preorder.length == 1) {
            return new TreeNode(preorder[0]);
        }

        boolean isTest = false;
        i = 0;
        inorder = preorder.clone();
        inorderIndexMap = new HashMap<>();
        this.preorder = preorder;

        Arrays.sort(inorder);
        for (int i = 0; i < inorder.length; i++) {
            inorderIndexMap.put(inorder[i], i);
        }
        if (isTest) {
            System.out.println("preorder: " + Arrays.toString(preorder));
            System.out.println("inorder:  " + Arrays.toString(inorder) + "\ninorderIndexMap: " + inorderIndexMap);
        }

        return build(0, preorder.length - 1);
    }

    private TreeNode build(int left, int right) {
        if (left > right) {
            return null;
        }

        int rootValue = preorder[i++];
        TreeNode root = new TreeNode(rootValue);
        int rootInorderIndex = inorderIndexMap.get(rootValue);
        root.left = build(left, rootInorderIndex - 1);
        root.right = build(rootInorderIndex + 1, right);

        return root;
    }
}