// Question: https://leetcode.com/problems/count-good-nodes-in-binary-tree/description/

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
class CountGoodNodesInBinaryTree {
    private boolean isTest = false;
    private int count = 0;

    public int goodNodes(TreeNode root) {
        dfs(root, new ArrayList<>());
        if (isTest) {
            System.out.println("count: " + count);
        }

        return count;
    }

    private void dfs(TreeNode node, List<Integer> path) {
        if (node == null) {
            return;
        }

        path.add(node.val);
        if (isValid(path)) {
            if (isTest) {
                System.out.println(" * valid last node in path: " + path);
                System.out.println("-------------------------------------");
            }
            count++;
        }

        if (node.left != null) {
            dfs(node.left, path);
        }
        if (node.right != null) {
            dfs(node.right, path);
        }

        path.removeLast();
    }

    private boolean isValid(List<Integer> path) {
        for (int i = path.size() - 2; i >= 0; i--) {
            if (path.get(i) > path.get(path.size() - 1)) {
                return false;
            }
        }
        return true;
    }
}