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
    private boolean[] isDeepestLeaf;
    private boolean isSolutionFound;
    private boolean isTest;
    private int totalDeepestLeaves;

    public TreeNode lcaDeepestLeaves(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        int level = 0;
        isDeepestLeaf = new boolean[1001];
        isSolutionFound = false;
        isTest = false;
        result = null;
        totalDeepestLeaves = 0;

        queue.offer(root);
        while (!queue.isEmpty()) {
            if (isTest) {
                System.out.print("level " + level + ": ");
                for (TreeNode e: queue) {
                    System.out.print(e.val + " ");
                }
                System.out.println();
            }

            int size = queue.size();
            isDeepestLeaf = new boolean[1001];
            totalDeepestLeaves = 0;

            while (size-- > 0) {
                TreeNode top = queue.poll();

                isDeepestLeaf[top.val] = true;
                totalDeepestLeaves++;

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
            System.out.print("----------------------\ntotalDeepestLeaves: " + totalDeepestLeaves + "\ndeepestLeaves: ");
            for (int i = 0; i < isDeepestLeaf.length; i++) {
                if (isDeepestLeaf[i]) {
                    System.out.print(i + " ");
                }
            }
            System.out.println("\n----------------------");
        }

        dfs(root);
        if (isTest) {
            System.out.print("----------------------\nresult: " + result.val);
        }

        return result;
    }

    private int dfs(TreeNode root) {
        if (isSolutionFound || root == null) {
            return 0;
        }

        int countDeepestLeavesInLeft = dfs(root.left);
        int countDeepestLeavesInRight = dfs(root.right);
        int totalDeepestLeavesInRootSubtree = countDeepestLeavesInLeft + countDeepestLeavesInRight;

        if (isDeepestLeaf[root.val]) {
            totalDeepestLeavesInRootSubtree++;
        }

        if (isTest) {
            System.out.println(" * root: " + root.val + " | countDeepestLeavesInLeft: " + countDeepestLeavesInLeft + " | countDeepestLeavesInRight: " + countDeepestLeavesInRight + " | totalDeepestLeavesInRootSubtree: " + totalDeepestLeavesInRootSubtree);
        }

        if (!isSolutionFound && totalDeepestLeavesInRootSubtree == totalDeepestLeaves) {
            isSolutionFound = true;
            result = root;
        }

        return totalDeepestLeavesInRootSubtree;
    }
}
