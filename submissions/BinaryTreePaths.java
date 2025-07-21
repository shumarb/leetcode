// Question: https://leetcode.com/problems/binary-tree-paths/description/

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
class BinaryTreePaths {
    private List<String> binaryTreePaths;

    public List<String> binaryTreePaths(TreeNode root) {
        binaryTreePaths = new ArrayList<>();
        boolean isTest = false;

        helper(root, new StringBuilder());
        if (isTest) {
            System.out.println("binaryTreePaths: " + binaryTreePaths);
        }

        return binaryTreePaths;
    }

    private void helper(TreeNode node, StringBuilder path) {
        if (node == null) {
            return;
        }

        path.append(node.val);
        if (node.left == null && node.right == null) {
            binaryTreePaths.add(path.toString());
            return;
        }

        path.append("->");
        if (node.left != null) {
            int len = path.length();
            helper(node.left, path);
            path.setLength(len);
        }
        if (node.right != null) {
            int len = path.length();
            helper(node.right, path);
            path.setLength(len);
        }
    }
}