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
    public int findBottomLeftValue(TreeNode root) {
        // 1. Edge case: Tree has 1 node.
        if (root.left == null && root.right == null) {
            return root.val;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        boolean isTest = false;
        int level = 1;
        int result = 0;

        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            if (isTest) {
                display(" * level: " + level + ", queue: ", queue);
            }
            for (int i = 0; i < size; i++) {
                TreeNode current = queue.poll();
                if (i == 0) {
                    result = current.val;
                }
                if (current.left != null) {
                    queue.offer(current.left);
                }
                if (current.right != null) {
                    queue.offer(current.right);
                }
            }
            level++;
        }
        if (isTest) {
            System.out.println("result: " + result);
        }

        return result;
    }

    private void display(String sentence, Queue<TreeNode> queue) {
        System.out.print(sentence);
        for (TreeNode node: queue) {
            System.out.print(node.val + " ");
        }
        System.out.println();
        System.out.println("-----------------------------------------");
    }
}