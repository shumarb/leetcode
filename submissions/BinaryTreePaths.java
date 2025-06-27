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
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<>();
        boolean isTest = false;

        findBinaryTreePaths(root, new StringBuilder(), result);
        if (isTest) {
            System.out.println("result: " + result);
        }

        return result;
    }

    private void findBinaryTreePaths(TreeNode current, StringBuilder path, List<String> result) {
        if (current == null) {
            return;
        }

        // 1. Store length of path before further checks for backtracking.
        int len = path.length();
        path.append(current.val);

        // 2. Leaf reached, so a binary path is found.
        if (current.left == null && current.right == null) {
            result.add(path.toString());
        } else {
            path.append("->");
            findBinaryTreePaths(current.left, path, result);
            findBinaryTreePaths(current.right, path, result);
        }

        // 3. Backtrack by setting path as it's value before recently-added vertex.
        path.setLength(len);
    }
}