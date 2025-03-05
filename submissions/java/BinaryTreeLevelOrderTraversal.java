// Question: https://leetcode.com/problems/binary-tree-level-order-traversal/description/

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
class BinaryTreeLevelOrderTraversal {
    public List<List<Integer>> levelOrder(TreeNode root) {
        boolean isTest = false;
        List<List<Integer>> result = new ArrayList<>();

        // 1. No nodes in tree.
        if (root == null) {
            return result;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            /**
             2.  All nodes in queue at start of iteration 
             are all nodes in the same level,
             so take note of its size (number of nodes).
             */
            int countNodes = queue.size();

            /**
             3.  Prepare list to add all nodes at current level.
             */
            List<Integer> level = new ArrayList<>();
            for (int i = 0; i < countNodes; i++) {
                /**
                 4.  Obtain each node one by one,
                 add it to list of nodes at current level,
                 add the node's left child if it exists,
                 followed by its right child if it exists,
                 and repeat for all remaining nodes at current and next level.
                 */
                TreeNode current = queue.poll();
                level.add(current.val);
                if (current.left != null) {
                    queue.offer(current.left);
                }
                if (current.right != null) {
                    queue.offer(current.right);
                }
            }

            /**
             5.  All nodes at current level added to list,
             so add list to results.
             */
            result.add(level);
        }
        if (isTest) {
            System.out.println("result: ");
            for (List<Integer> level: result) {
                System.out.println(" * " + level);
            }
        }

        return result;
    }
}