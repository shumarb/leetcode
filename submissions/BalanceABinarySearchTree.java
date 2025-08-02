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
    public TreeNode balanceBST(TreeNode root) {
        List<TreeNode> nodes = new ArrayList<>();
        boolean isTest = false;

        inOrder(root, nodes);
        if (isTest) {
            System.out.println("nodes (in-order traversal): ");
            for (TreeNode node: nodes) {
                System.out.print(node.val + " ");
            }
        }

        return build(nodes, 0, nodes.size() - 1);
    }

    private TreeNode build(List<TreeNode> nodes, int left, int right) {
        if (left > right) {
            return null;
        }

        int mid = left + (right - left) / 2;
        TreeNode root = nodes.get(mid);
        root.left = build(nodes, left, mid - 1);
        root.right = build(nodes, mid + 1, right);

        return root;
    }

    private void inOrder(TreeNode node, List<TreeNode> nodes) {
        if (node == null) {
            return;
        }

        inOrder(node.left, nodes);
        nodes.add(node);
        inOrder(node.right, nodes);
    }
}