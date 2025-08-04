// Question: https://leetcode.com/problems/delete-node-in-a-bst/description/

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
class DeleteNodeInABST {
    private boolean isFound = false;

    public TreeNode deleteNode(TreeNode root, int key) {
        // 1. Empty tree.
        if (root == null) {
            return root;
        }

        List<Integer> list = new ArrayList<>();
        boolean isTest = false;

        inOrderTraversal(list, root, key);
        if (isTest) {
            System.out.println("key: " + key + "\nlist: " + list);
        }

        // 2. Key is not in tree.
        if (!isFound) {
            return root;
        }

        return build(list, 0, list.size() - 1);
    }

    private TreeNode build(List<Integer> list, int left, int right) {
        if (left > right) {
            return null;
        }

        int mid = left + (right - left) / 2;
        TreeNode root = new TreeNode(list.get(mid));
        root.left = build(list, left, mid - 1);
        root.right = build(list, mid + 1, right);

        return root;
    }

    private void inOrderTraversal(List<Integer> list, TreeNode node, int key) {
        if (node == null) {
            return;
        }

        inOrderTraversal(list, node.left, key);
        if (node.val == key) {
            isFound = true;
        } else {
            list.add(node.val);
        }
        inOrderTraversal(list, node.right, key);
    }
}