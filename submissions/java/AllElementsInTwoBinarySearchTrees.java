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
        traverse(root1, result);
        traverse(root2, result);
        Collections.sort(result);
        return result;
    }

    private void traverse(TreeNode node, List<Integer> result) {
        if (node != null) {
            result.add(node.val);
            traverse(node.left, result);
            traverse(node.right, result);
        }
    }
}