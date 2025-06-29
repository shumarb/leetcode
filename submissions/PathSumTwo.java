// Question: https://leetcode.com/problems/path-sum-ii/description/

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
class PathSumTwo {
    private List<List<Integer>> result = new ArrayList<>();
    private boolean isTest = false;

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        result = new ArrayList<>();

        // 1. Edge case: 0 nodes in tree.
        if (root == null) {
            return result;
        }

        findPath(root, targetSum, new ArrayList<>());
        if (isTest) {
            System.out.println("----------------------------------");
            System.out.println("result: " + result);
        }

        return result;
    }

    private void findPath(TreeNode node, int targetSum, List<Integer> path) {
        if (node == null) {
            return;
        }

        path.add(node.val);
        if (node.left == null && node.right == null) {
            if (isTest) {
                System.out.println("----------------------------------");
                System.out.println("path: " + path);
            }
            if (targetSum == node.val) {
                if (isTest) {
                    System.out.println(" *** valid *** ");
                }
                result.add(new ArrayList<>(path));
            }
        } else {
            findPath(node.left, targetSum - node.val, path);
            findPath(node.right, targetSum - node.val, path);
        }

        /**
         1.  Backtrack by removing latest entry in current recursive call
             to restore state of list as per previous recursive call.
         */
        path.remove(path.size() - 1);
    }
}