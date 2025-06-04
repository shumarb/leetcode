// Question: https://leetcode.com/problems/even-odd-tree/description/

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
class EvenOddTree {
    private boolean isTest = false;

    public boolean isEvenOddTree(TreeNode root) {
        int level = -1;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            level++;
            int size = queue.size();
            List<Integer> valuesOnCurrentLevel = new ArrayList<>();

            for (int i = 0; i < size; i++) {
                TreeNode current = queue.poll();
                valuesOnCurrentLevel.add(current.val);
                if (current.left != null) {
                    queue.offer(current.left);
                }
                if (current.right != null) {
                    queue.offer(current.right);
                }
            }

            if (!isValidLevel(level, valuesOnCurrentLevel)) {
                return false;
            }
        }

        return true;
    }

    private boolean isValidLevel(int level, List<Integer> values) {
        if (isTest) {
            System.out.println("------------------------------------------------------------------------------------------");
            System.out.println(" * level: " + level + ", values: " + values);
        }
        if (level == 0) {
            if (values.get(0).intValue() % 2 == 0) {
                return false;
            } else {
                return true;
            }
        }
        if (level % 2 == 0) {
            for (int value: values) {
                if (value % 2 == 0) {
                    return false;
                }
            }

            for (int i = 1; i < values.size(); i++) {
                if (values.get(i).intValue() <= values.get(i - 1).intValue()) {
                    return false;
                }
            }

        } else {
            for (int value: values) {
                if (value % 2 != 0) {
                    return false;
                }
            }

            for (int i = 1; i < values.size(); i++) {
                if (values.get(i).intValue() >= values.get(i - 1).intValue()) {
                    return false;
                }
            }
        }

        return true;
    }
}