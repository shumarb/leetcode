// Question: https://leetcode.com/problems/two-sum-iv-input-is-a-bst/description/

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
class TwoSumFourInputIsABST {
    public boolean findTarget(TreeNode root, int k) {
        boolean isTest = false;
        List<Integer> elements = new ArrayList<>();

        populate(elements, root);
        if (isTest) {
            System.out.println("elements: " + elements + " | k: " + k);
        }

        int left = 0;
        int right = elements.size() - 1;
        while (left < right) {
            int sum = elements.get(left) + elements.get(right);
            if (sum == k) {
                return true;
            } else if (sum < k) {
                left++;
            } else {
                right--;
            }
        }

        return false;
    }

    private void populate(List<Integer> elements, TreeNode node) {
        if (node != null) {
            populate(elements, node.left);
            elements.add(node.val);
            populate(elements, node.right);
        }
    }
}