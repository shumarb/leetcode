// Question: https://leetcode.com/problems/lowest-common-ancestor-of-deepest-leaves/description/

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
class LowestCommonAncestorOfDeepestLeaves {
    private TreeNode result;
    private boolean isSolutionFound;
    private boolean isTest;

    public TreeNode lcaDeepestLeaves(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        Set<TreeNode> deepestLeaves = new HashSet<>();
        int level = 0;
        isSolutionFound = false;
        isTest = false;
        result = null;

        queue.offer(root);
        while (!queue.isEmpty()) {
            if (isTest) {
                System.out.print("level " + level + ": ");
                for (TreeNode e: queue) {
                    System.out.print(e.val + " ");
                }
                System.out.println();
            }

            deepestLeaves = new HashSet<>();
            int size = queue.size();
            while (size-- > 0) {
                TreeNode top = queue.poll();

                deepestLeaves.add(top);
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
            System.out.print("----------------------\ndeepestLeaves: ");
            for (TreeNode e: deepestLeaves) {
                System.out.print(e.val + " ");
            }
            System.out.println("\n----------------------");
        }

        dfs(root, deepestLeaves);
        if (isTest) {
            System.out.print("----------------------\nresult: " + result.val);
        }

        return result;
    }

    private int dfs(TreeNode root, Set<TreeNode> deepestLeaves) {
        if (isSolutionFound || root == null) {
            return 0;
        }

        int countDeepestLeavesInLeft = dfs(root.left, deepestLeaves);
        int countDeepestLeavesInRight = dfs(root.right, deepestLeaves);
        int totalDeepestLeavesInRootSubtree = countDeepestLeavesInLeft + countDeepestLeavesInRight;

        if (deepestLeaves.contains(root)) {
            totalDeepestLeavesInRootSubtree++;
        }

        if (isTest) {
            System.out.println(" * root: " + root.val + " | countDeepestLeavesInLeft: " + countDeepestLeavesInLeft + " | countDeepestLeavesInRight: " + countDeepestLeavesInRight + " | totalDeepestLeavesInRootSubtree: " + totalDeepestLeavesInRootSubtree);
        }

        if (!isSolutionFound && totalDeepestLeavesInRootSubtree == deepestLeaves.size()) {
            isSolutionFound = true;
            result = root;
        }

        return totalDeepestLeavesInRootSubtree;
    }
}
