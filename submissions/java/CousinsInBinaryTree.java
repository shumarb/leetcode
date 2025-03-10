// Question: https://leetcode.com/problems/cousins-in-binary-tree/description/

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
class CousinsInBinaryTree {
    private List<TreeNodeInfo> list = new ArrayList<>();
    private TreeNodeInfo xNode = null;
    private TreeNodeInfo yNode = null;

    public boolean isCousins(TreeNode root, int x, int y) {
        boolean isTest = false;

        list.add(new TreeNodeInfo(new TreeNode(-1), root.val, 1));
        traverse(root, 1);

        if (isTest) {
            System.out.println("node info:");
            for (TreeNodeInfo node: list) {
                System.out.println(" * " + "node value: " + node.getValue() + " | parent: " + node.getParent().val + " | depth: " + node.getDepth());
            }
        }

        for (TreeNodeInfo node: list) {
            if (node.getValue() == x) {
                xNode = node;
            }
            if (node.getValue() == y) {
                yNode = node;
            }
        }

        return xNode.getParent() != yNode.getParent() && xNode.getDepth() == yNode.getDepth();
    }

    private void traverse(TreeNode node, int depth) {
        if (node != null && xNode == null && yNode == null) {
            depth++;
            if (node.left != null) {
                list.add(new TreeNodeInfo(node, node.left.val, depth));
            }
            if (node.right != null) {
                list.add(new TreeNodeInfo(node, node.right.val, depth));
            }
            traverse(node.left, depth);
            traverse(node.right, depth);
        }
    }
}

class TreeNodeInfo {
    private TreeNode parent;
    private int value;
    private int depth;

    public TreeNodeInfo(TreeNode parent, int value, int depth) {
        this.parent = parent;
        this.value = value;
        this.depth = depth;
    }

    public TreeNode getParent() {
        return parent;
    }

    public int getValue() {
        return value;
    }

    public int getDepth() {
        return depth;
    }
}