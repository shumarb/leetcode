// Question: https://leetcode.com/problems/find-elements-in-a-contaminated-binary-tree/description/

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
class FindElements {
    private Set<Long> set;

    public FindElements(TreeNode root) {
        set = new HashSet<>();

        root.val = 0;
        set.add(0l);

        dfs(root);
    }

    private void dfs(TreeNode node) {
        if (node == null) {
            return;
        }

        if (node.left != null) {
            node.left.val = node.val * 2 + 1;
            set.add((long) node.left.val);
        }
        if (node.right != null) {
            node.right.val = node.val * 2 + 2;
            set.add((long) node.right.val);
        }

        dfs(node.left);
        dfs(node.right);
    }

    public boolean find(int target) {
        return set.contains((long) target);
    }
}

/**
 * Your FindElements object will be instantiated and called as such:
 * FindElements obj = new FindElements(root);
 * boolean param_1 = obj.find(target);
 */
