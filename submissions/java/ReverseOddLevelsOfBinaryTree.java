// Question: https://leetcode.com/problems/reverse-odd-levels-of-binary-tree/description/

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
class ReverseOddLevelsOfBinaryTree {
    public TreeNode reverseOddLevels(TreeNode root) {
        boolean isTest = false;
        Queue<TreeNode> queue = new LinkedList<>();
        int level = 0;
        queue.offer(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            List<TreeNode> oddLevel = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode current = queue.poll();
                if (level % 2 != 0) {
                    oddLevel.add(current);
                }
                if (current.left != null) {
                    queue.offer(current.left);
                }
                if (current.right != null) {
                    queue.offer(current.right);
                }
            }
            if (oddLevel.size() > 1) {
                if (isTest) {
                    System.out.println("swap at level " + level + " --> " + oddLevel);
                }
                swap(oddLevel);
            }
            level++;
        }

        return root;
    }

    private void swap(List<TreeNode> level) {
        int left = 0;
        int right = level.size() - 1;
        while (left < right) {
            TreeNode leftNode = level.get(left);
            TreeNode rightNode = level.get(right);
            int temp = leftNode.val;
            leftNode.val = rightNode.val;
            rightNode.val = temp;
            left++;
            right--;
        }
    }
}