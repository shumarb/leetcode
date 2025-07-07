// Question: https://leetcode.com/problems/find-bottom-left-tree-value/description/

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
class FindBottomLeftTreeValue {
    // 1. List of left-most node at i-th level.
    private List<Integer> list;
    private boolean isTest;

    public int findBottomLeftValue(TreeNode root) {
        isTest = false;
        list = new ArrayList<>();

        helper(root, 0);
        if (isTest) {
            System.out.println("list: " + list);
        }
        return list.get(list.size() - 1);
    }

    private void helper(TreeNode node, int level) {
        if (node == null) {
            return;
        }
        if (isTest) {
            System.out.println("node: " + node.val + ", level: " + level);
            System.out.println(" * before: , list: " + list);
        }
        if (list.size() == level) {
            list.add(node.val);
        }
        if (isTest) {
            System.out.println(" * after: , list: " + list);
            System.out.println("-------------------------------------");
        }

        helper(node.left, level + 1);
        helper(node.right, level + 1);
    }
}