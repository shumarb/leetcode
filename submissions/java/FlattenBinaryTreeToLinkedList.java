// Question: https://leetcode.com/problems/flatten-binary-tree-to-linked-list/description/

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
class FlattenBinaryTreeToLinkedList {
    private List<TreeNode> elements = new ArrayList<>();

    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }

        boolean isTest = false;
        preOrderTraversal(root);
        if (isTest) {
            System.out.println("number of elements: " + elements.size());
            for (TreeNode element: elements) {
                System.out.print(element.val + " --> ");
            }
            System.out.println("null");
        }

        for (int i = 0; i < elements.size(); i++) {
            TreeNode current = elements.get(i);
            current.left = null;
            if (i != elements.size() - 1) {
                current.right = elements.get(i + 1);
            }
        }
        root = elements.get(0);
    }

    private void preOrderTraversal(TreeNode node) {
        if (node == null) {
            return;
        }
        elements.add(node);
        preOrderTraversal(node.left);
        preOrderTraversal(node.right);
    }
}