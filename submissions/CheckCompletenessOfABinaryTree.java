// Question: https://leetcode.com/problems/check-completeness-of-a-binary-tree/description/

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
class Solution {
    public boolean isCompleteTree(TreeNode root) {
        List<String> list = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        boolean isTest = false;
        int deepestLevel = dfs(root) - 1;
        int level = 0;

        if (isTest) {
            System.out.println("deepest level: " + deepestLevel);
            System.out.println("-------------------------------------------------------");
        }

        queue.offer(root);
        if (root == null) {
            list.add("null");
        } else {
            list.add(Integer.toString(root.val));
        }

        while (!queue.isEmpty()) {
            if (isTest) {
                System.out.println("level: " + level + ": " + list);
            }

            if (level != deepestLevel) {
                for (int i = list.size() - 1; i >= 0; i--) {
                    if (list.get(i).equals("null")) {
                        return false;
                    }
                }
            } else {
                for (int i = 0; i < list.size() - 1; i++) {
                    if (list.get(i).equals("null") && !list.get(i + 1).equals("null")) {
                        return false;
                    }
                }
            }

            list.clear();
            level++;
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                TreeNode top = queue.poll();
                if (top.left == null) {
                    list.add("null");
                } else {
                    list.add(Integer.toString(top.left.val));
                }
                if (top.right == null) {
                    list.add("null");
                } else {
                    list.add(Integer.toString(top.right.val));
                }

                if (top.left != null) {
                    queue.offer(top.left);
                }
                if (top.right != null) {
                    queue.offer(top.right);
                }
            }
        }

        return true;
    }

    private int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + Math.max(dfs(root.left), dfs(root.right));
    }
}