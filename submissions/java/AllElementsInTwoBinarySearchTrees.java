// Question: https://leetcode.com/problems/all-elements-in-two-binary-search-trees/description/

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
class AllElementsInTwoBinarySearchTrees {
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        List<Integer> result = new ArrayList<>();
        int[] elementFrequency = new int[200001];
        inOrderTraversal(root1, elementFrequency);
        inOrderTraversal(root2, elementFrequency);
        populate(result, elementFrequency);
        return result;
    }

    private void populate(List<Integer> result, int[] elementFrequency) {
        for (int i = 0; i < elementFrequency.length; i++) {
            if (elementFrequency[i] > 0) {
                for (int j = 0; j < elementFrequency[i]; j++) {
                    result.add(i - 100000);
                }
            }
        }
    }

    private void inOrderTraversal(TreeNode node, int[] elementFrequency) {
        if (node != null) {
            inOrderTraversal(node.left, elementFrequency);
            elementFrequency[node.val + 100000]++;
            inOrderTraversal(node.right, elementFrequency);
        }
    }
}