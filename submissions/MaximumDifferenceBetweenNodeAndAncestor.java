// Question: https://leetcode.com/problems/maximum-difference-between-node-and-ancestor/description/

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
class MaximumDifferenceBetweenNodeAndAncestor {
    private List<List<Integer>> paths;

    public int maxAncestorDiff(TreeNode root) {
        boolean isTest = false;
        int maxAncestorDiff = 0;
        paths = new ArrayList<>();

        helper(root, new ArrayList<>());
        if (isTest) {
            System.out.println("paths:");
            for (List<Integer> path: paths) {
                System.out.println(" * " + path);
            }
            System.out.println("--------------------------------");
        }
        for (List<Integer> path: paths) {
            int maximum = Integer.MIN_VALUE;
            int minimum = Integer.MAX_VALUE;
            for (int value: path) {
                maximum = Math.max(maximum, value);
                minimum = Math.min(minimum, value);
            }
            if (isTest) {
                System.out.println(" * path: " + path);
                System.out.println(" ** maximum: " + maximum + ", minimum: " + minimum);
                System.out.println(" *** before, maxAncestorDiff: " + maxAncestorDiff + " | compare: " + (maximum - minimum));
            }
            maxAncestorDiff = Math.max(maxAncestorDiff, maximum - minimum);
            if (isTest) {
                System.out.println(" *** after, maxAncestorDiff: " + maxAncestorDiff);
                System.out.println("--------------------------------");
            }
        }

        return maxAncestorDiff;
    }

    private void helper(TreeNode node, ArrayList<Integer> path) {
        if (node == null) {
            return;
        }

        path.add(node.val);
        if (node.left == null && node.right == null) {
            paths.add(new ArrayList<>(path));
        }

        helper(node.left, path);
        helper(node.right, path);
        path.removeLast();

    }
}