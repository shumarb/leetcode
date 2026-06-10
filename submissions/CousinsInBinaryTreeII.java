// Question: https://leetcode.com/problems/cousins-in-binary-tree-ii/description/

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
class CousinsInBinaryTreeII {
    public TreeNode replaceValueInTree(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        boolean isTest = false;
        int level = 0;

        root.val = 0;
        queue.offer(root);
        while (!queue.isEmpty()) {
            List<TreeNode> list = new ArrayList<>();
            long nextLevelSum = 0l;
            int size = queue.size();

            while (size-- > 0) {
                TreeNode top = queue.poll();
                list.add(top);

                if (top.left != null) {
                    nextLevelSum += top.left.val;
                    queue.offer(top.left);
                }

                if (top.right != null) {
                    nextLevelSum += top.right.val;
                    queue.offer(top.right);
                }
            }
            if (isTest) {
                System.out.print(" * level " + level + ": ");
                for (TreeNode e: list) {
                    System.out.print(e.val + " ");
                }
                System.out.println(" | next level sum: " + nextLevelSum);
            }

            for (TreeNode node: list) {
                long siblingSum = 0l;
                long val = nextLevelSum;

                if (node.left != null) {
                    siblingSum += node.left.val;
                }

                if (node.right != null) {
                    siblingSum += node.right.val;
                }

                int sumOfCousinValues = (int) (nextLevelSum - siblingSum);
                if (node.left != null) {
                    node.left.val = sumOfCousinValues;
                }

                if (node.right != null) {
                    node.right.val = sumOfCousinValues;
                }
            }

            level++;
        }

        return root;
    }
}
