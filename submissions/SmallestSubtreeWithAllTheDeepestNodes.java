// Question: https://leetcode.com/problems/smallest-subtree-with-all-the-deepest-nodes/description/

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
class SmallestSubtreeWithAllTheDeepestNodes {
    private TreeNode result;
    private boolean isTest;

    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        Set<TreeNode> deepestNodes = new HashSet<>();
        int level = 0;
        isTest = false;
        result = null;

        queue.offer(root);
        while (!queue.isEmpty()) {
            deepestNodes = new HashSet<>();
            for (TreeNode node: queue) {
                deepestNodes.add(node);
            }
            if (isTest) {
                System.out.print("level " + level + ": ");
                for (TreeNode node: queue) {
                    System.out.print(node.val + " ");
                }
                System.out.println();
            }

            int size = queue.size();
            while (size-- > 0) {
                TreeNode top = queue.poll();

                if (top.left != null) {
                    queue.offer(top.left);
                }
                if (top.right != null) {
                    queue.offer(top.right);
                }
            }

            level++;
        }
        if (isTest) {
            System.out.print("----------------------\ndeepestNodes: ");
            for (TreeNode node: deepestNodes) {
                System.out.print(node.val + " ");
            }
            System.out.println("\n----------------------");
        }

        dfs(root, deepestNodes);
        if (isTest) {
            System.out.println("----------------------\nresult: " + result.val);
        }

        return result;
    }

    private int dfs(TreeNode root, Set<TreeNode> set) {
        if (result != null || root == null) {
            return 0;
        }

        int left = dfs(root.left, set);
        int right = dfs(root.right, set);
        int totalDeepestNodes = left + right;

        if (set.contains(root)) {
            totalDeepestNodes++;
        }
        if (isTest) {
            System.out.println("root: " + root.val + " | total deepest nodes: " + totalDeepestNodes);
        }
        if (result == null && totalDeepestNodes == set.size()) {
            result = root;
        }

        return totalDeepestNodes;
    }
}
