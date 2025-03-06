// Question: https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/description/

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
class BinaryTreeZigZagLevelOrderTraversal {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<List<Integer>> result = new ArrayList<>();
        boolean isTest = false;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            List<Integer> nodesOnCurrentLevel = new ArrayList<>();
            int totalNodesOnCurrentLevel = queue.size();

            for (int i = 0; i < totalNodesOnCurrentLevel; i++) {
                TreeNode node = queue.poll();
                nodesOnCurrentLevel.add(node.val);
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            result.add(nodesOnCurrentLevel);
        }

        for (int i = 0; i < result.size(); i++) {
            if (i % 2 != 0) {
                reverseOrder(result.get(i));
            }
        }

        if (isTest) {
            System.out.println("result: ");
            for (List<Integer> level: result) {
                System.out.println(" * " + level);
            }
        }
        return result;
    }

    private void reverseOrder(List<Integer> level) {
        Stack<Integer> stack = new Stack<>();
        for (int value: level) {
            stack.push(value);
        }
        int i = 0;
        while (!stack.isEmpty()) {
            level.set(i++, stack.pop());
        }
    }
}