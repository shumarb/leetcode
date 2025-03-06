// Question: https://leetcode.com/problems/binary-tree-level-order-traversal-ii/description/

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
class BinaryTreeLevelOrderTraversalTwo {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }

        List<List<Integer>> result = new ArrayList<>();
        boolean isTest = false;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            List<Integer> nodesAtCurrentLevel = new ArrayList<>();
            int totalNodeAtCurrentLevel = queue.size();

            for (int i = 0; i < totalNodeAtCurrentLevel; i++) {
                TreeNode node = queue.poll();
                nodesAtCurrentLevel.add(node.val);
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }

            }
            result.add(0, nodesAtCurrentLevel);
        }
        if (isTest) {
            System.out.println("result: ");
            for (List<Integer> nodesPerLevel: result) {
                System.out.println(" * " + nodesPerLevel);
            }
        }

        return result;
    }
}