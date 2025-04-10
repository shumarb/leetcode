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
class IncreasingOrderSearchTree {
    public TreeNode increasingBST(TreeNode root) {
        List<TreeNode> elements = new ArrayList<>();
        boolean isTest = false;

        inOrderTraversal(root, elements);
        if (isTest) {
            display(elements);
        }
        for (int i = 0; i < elements.size(); i++) {
            TreeNode current = elements.get(i);
            current.left = null;
            if (i == elements.size() - 1) {
                // 1. Only last element's right child is set to null
                current.right = null;
            } else {
                current.right = elements.get(i + 1);
            }
        }

        // 2. Set root to first element in the list.
        root = elements.get(0);
        return root;
    }

    private void display(List<TreeNode> elements) {
        System.out.print("in order: ");
        for (int i = 0; i < elements.size() - 1; i++) {
            System.out.print(elements.get(i).val + " -> ");
        }
        System.out.println(elements.get(elements.size() - 1).val);
    }

    private void inOrderTraversal(TreeNode node, List<TreeNode> elements) {
        if (node != null) {
            inOrderTraversal(node.left, elements);
            elements.add(node);
            inOrderTraversal(node.right, elements);
        }
    }
}