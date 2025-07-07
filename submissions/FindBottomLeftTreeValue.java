// Question: https://leetcode.com/problems/find-bottom-left-tree-value/description/

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
class FindBottomLeftTreeValue {
    public int findBottomLeftValue(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        boolean isTest = false;
        int level = 1;
        int result = 0;

        queue.offer(root);
        while (!queue.isEmpty()) {
            List<TreeNode> list = new ArrayList<>();
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                TreeNode current = queue.poll();
                list.add(current);
                if (list.size() == 1) {
                    result = current.val;
                }
                if (current.left != null) {
                    queue.offer(current.left);
                }
                if (current.right != null) {
                    queue.offer(current.right);
                }
            }
            if (isTest) {
                display("level: " + level + ", list: ", list);
            }

            level++;
        }
        if (isTest) {
            System.out.println("result: " + result);
        }

        return result;
    }

    private void display(String sentence, List<TreeNode> list) {
        System.out.print(sentence);
        for (int i = 0; i < list.size(); i++) {
            if (i == list.size() - 1) {
                System.out.println(list.get(i).val);
            } else {
                System.out.print(list.get(i).val + " ");
            }
        }
        System.out.println("-----------------------------------------");
    }
}