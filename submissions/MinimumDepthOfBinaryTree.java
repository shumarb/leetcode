// Question: https://leetcode.com/problems/minimum-depth-of-binary-tree/description/

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
class MinimumDepthOfBinaryTree {
    public int minDepth(TreeNode root) {
        // 1. Empty tree, so depth is 0.
        if (root == null) {
            return 0;
        }

        /**
         2.  At least one node exists in Binary Tree.
         Since BFS starts at root, depth is 1.
         */
        int depth = 1;
        Queue<TreeNode> queue = new LinkedList<>();
        boolean isTest = false;
        queue.offer(root);
        while (!queue.isEmpty()) {
            if (isTest) {
                System.out.println("current depth: " + depth);
            }
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode currentNode = queue.poll();
                if (isTest) {
                    System.out.println(" * current node: " + currentNode.val);
                }
                /**
                 3. Minimum depth of tree is found when first leaf is encountered.
                 */
                if (currentNode.left == null && currentNode.right == null) {
                    if (isTest) {
                        System.out.println(" *** current node: " + currentNode.val + " is a leaf. returning depth of " + depth);
                    }
                    return depth;
                }

                /**
                 4.  Current node is not a leaf,
                 hence continue BFS by adding current node's children from left to right.
                 */
                if (currentNode.left != null) {
                    queue.offer(currentNode.left);
                }
                if (currentNode.right != null) {
                    queue.offer(currentNode.right);
                }
            }

            /**
             5. Increase depth by 1 for traversal onto next level.
             */
            depth++;
        }

        return depth;
    }
}