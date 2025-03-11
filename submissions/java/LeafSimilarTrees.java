// Question: https://leetcode.com/problems/leaf-similar-trees/description/

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
class LeafSimilarTrees {
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> leaves1 = new ArrayList<>();
        List<Integer> leaves2 = new ArrayList<>();
        boolean isTest = false;

        dfs(root1, leaves1);
        dfs(root2, leaves2);
        if (isTest) {
            System.out.println("leaves1: " + leaves1 + "\nleaves2:" + leaves2);
        }

        if (leaves1.size() != leaves2.size()) {
            return false;
        }
        for (int i = 0; i < leaves1.size(); i++) {
            if (Integer.compare(leaves1.get(i), leaves2.get(i)) != 0) {
                return false;
            }
        }
        return true;
    }

    private void dfs(TreeNode node, List<Integer> leaves) {
        if (node != null) {
            dfs(node.left, leaves);
            if (node.left == null && node.right == null) {
                leaves.add(node.val);
            }
            dfs(node.right, leaves);
        }
    }
}