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
    private List<List<Integer>> result;
    private boolean isTest = false;
    private int targetSum;

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        boolean isTest = true;
        result = new ArrayList<>();
        this.targetSum = targetSum;

        // 1. Edge case: 0 nodes in tree.
        if (root == null) {
            return result;
        }

        traverse(root, new ArrayList<>());
        if (isTest) {
            System.out.println("result: " + result);
        }

        return result;
    }

    private void traverse(TreeNode current, List<Integer> list) {
        if (current == null) {
            return;
        }

        list.add(current.val);
        if (current.left == null && current.right == null) {
            int sum = 0;
            for (int number: list) {
                sum += number;
            }
            if (sum == targetSum) {
                List<Integer> toAdd = new ArrayList<>();
                for (int number: list) {
                    toAdd.add(number);
                }
                result.add(toAdd);
            }
            if (isTest) {
                System.out.println("root to leaf path: " + list);
                if (sum == targetSum) {
                    System.out.println(" * valid: " + list);
                }
                System.out.println("---------------------------------------");
            }

        } else {
            traverse(current.left, list);
            traverse(current.right, list);
        }

        /**
         1.  Backtrack by removing latest entry in current recursive call
             to restore state of list as per previous recursive call.
         */
        list.remove(list.size() - 1);
    }
}