// Question: https://leetcode.com/problems/convert-bst-to-greater-tree/description/

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
class ConvertBstToGreaterTree {
    private List<TreeNode> inOrder;

    public TreeNode convertBST(TreeNode root) {
        boolean isTest = false;
        inOrder = new ArrayList<>();

        inOrderTraversal(root);
        if (isTest) {
            display("before, in-order: ");
        }
        for (int i = inOrder.size() - 2; i >= 0; i--) {
            inOrder.get(i).val += inOrder.get(i + 1).val;
        }
        if (isTest) {
            display("after, in-order: ");
        }

        return root;
    }

    private void inOrderTraversal(TreeNode node) {
        if (node == null) {
            return;
        }

        if (node.left != null) {
            inOrderTraversal(node.left);
        }
        inOrder.add(node);
        if (node.right != null) {
            inOrderTraversal(node.right);
        }
    }

    private void display(String s) {
        System.out.print(s);
        for (TreeNode node: inOrder) {
            System.out.print(node.val + " ");
        }
        System.out.println("\n------------------------------");
    }
}