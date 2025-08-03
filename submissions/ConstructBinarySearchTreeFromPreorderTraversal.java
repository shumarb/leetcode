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
    private int[] inorderIndexMap;
    private int[] inorder;
    private int[] preorder;
    private int i;
    private int largest;

    public TreeNode bstFromPreorder(int[] preorder) {
        // 1. Edge case: 1 element in tree.
        if (preorder.length == 1) {
            return new TreeNode(preorder[0]);
        }

        boolean isTest = false;
        i = 0;
        inorder = sort(preorder.clone());
        inorderIndexMap = new int[largest + 1];
        this.preorder = preorder;

        for (int i = 0; i < inorder.length; i++) {
            inorderIndexMap[inorder[i]] = i;
        }
        if (isTest) {
            System.out.println("preorder: " + Arrays.toString(preorder));
            System.out.println("inorder:  " + Arrays.toString(inorder) + "\ninorderIndexMap: " + Arrays.toString(inorderIndexMap));
        }

        return build(0, preorder.length - 1);
    }

    private int[] sort(int[] arr) {
        int[] frequency;
        int j = 0;
        largest = arr[0];

        for (int number: arr) {
            largest = Math.max(largest, number);
        }
        frequency = new int[largest + 1];
        for (int number: arr) {
            frequency[number]++;
        }

        for (int i = 0; i <= largest; i++) {
            while (frequency[i]-- > 0) {
                arr[j++] = i;
            }
        }

        return arr;
    }

    private TreeNode build(int left, int right) {
        if (left > right) {
            return null;
        }

        int rootValue = preorder[i++];
        TreeNode root = new TreeNode(rootValue);
        int rootInorderIndex = inorderIndexMap[rootValue];
        root.left = build(left, rootInorderIndex - 1);
        root.right = build(rootInorderIndex + 1, right);

        return root;
    }
}