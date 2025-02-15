// Question: https://leetcode.com/problems/kth-smallest-element-in-a-bst/description/

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
class KthSmallestElementInABST {
    private boolean isTest = true;

    public int kthSmallest(TreeNode root, int k) {
        List<Integer> elements = new ArrayList<>();
        populate(root, elements);
        if (isTest) {
            System.out.println("elements (sorted): " + elements);
        }

        return elements.get(k - 1);
    }

    private void populate(TreeNode node, List<Integer> elements) {
        if (node != null) {
            populate(node.left, elements);
            elements.add(node.val);
            populate(node.right, elements);
        }
    }
}