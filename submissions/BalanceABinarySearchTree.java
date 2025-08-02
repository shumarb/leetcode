// Question: https://leetcode.com/problems/balance-a-binary-search-tree/description/

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
class BalanceABinarySearchTree {
    private TreeNode[] nodes;
    private int i = 0;

    public TreeNode balanceBST(TreeNode root) {
        boolean isTest = false;
        int count = count(root);

        nodes = new TreeNode[count];
        preOrder(root);
        if (isTest) {
            System.out.println("count: " + count);
            System.out.print("-------------------\nnodes: ");
            for (TreeNode node: nodes) {
                System.out.print(node.val + " ");
            }
        }

        return build(0, nodes.length - 1);
    }

    private TreeNode build(int left, int right) {
        if (left > right) {
            return null;
        }

        int mid = left + (right - left) / 2;
        TreeNode root = nodes[mid];
        root.left = build(left, mid - 1);
        root.right = build(mid + 1, right);

        return root;
    }

    private void preOrder(TreeNode node) {
        if (node == null) {
            return;
        }

        preOrder(node.left);
        nodes[i++] = node;
        preOrder(node.right);
    }

    private int count(TreeNode node) {
        return node == null ? 0 : 1 + count(node.left) + count(node.right);
    }
}