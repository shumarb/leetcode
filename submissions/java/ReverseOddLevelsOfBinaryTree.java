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
        List<List<TreeNode>> levels = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            List<TreeNode> currentLevel = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode current = queue.poll();
                currentLevel.add(current);
                if (current.left != null) {
                    queue.offer(current.left);
                }
                if (current.right != null) {
                    queue.offer(current.right);
                }
            }
            levels.add(currentLevel);
        }
        if (isTest) {
            display(levels);
        }

        for (int i = 0; i < levels.size(); i++) {
            if (i % 2 != 0) {
                if (isTest) {
                    System.out.println("swap at level " + i);
                }
                swap(levels.get(i));
            }
        }
        if (isTest) {
            display(levels);
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

    private void display(List<List<TreeNode>> levels) {
        System.out.println("levels:");
        for (int i = 0; i < levels.size(); i++) {
            List<TreeNode> level = levels.get(i);
            System.out.print(" * level " + i + " --> ");
            for (int j = 0; j < level.size() - 1; j++) {
                TreeNode node = level.get(j);
                System.out.print(node.val + ", ");
            }
            System.out.println(level.get(level.size() - 1).val);
        }
        System.out.println("---------------------------------------------------------");
    }
}