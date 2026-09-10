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
class IncreasingOrderSearchTree {
    public TreeNode increasingBST(TreeNode root) {
        List<TreeNode> list = new ArrayList<>();
        TreeNode last;
        boolean isTest = false;
        int n;

        inOrder(list, root);

        n = list.size();
        if (isTest) {
            print("before, list:", list);
        }

        last = list.get(n - 1);
        last.left = null;
        last.right = null;
        for (int i = 0; i < n - 1; i++) {
            TreeNode node = list.get(i);
            node.left = null;
            node.right = list.get(i + 1);
        }
        if (isTest) {
            print("after, list:", list);
        }

        return list.get(0);
    }

    private void print(String s, List<TreeNode> list) {
        System.out.println(s);
        for (TreeNode e: list) {
            int l = e.left == null ? -1 : e.left.val;
            int r = e.right == null ? -1 : e.right.val;
            System.out.println(" * " + e.val + " | l: " + l + " | r: " + r);
        }
        System.out.println("-----------------------------");
    }

    private void inOrder(List<TreeNode> list, TreeNode node) {
        if (node == null) {
            return;
        }

        inOrder(list, node.left);
        list.add(node);
        inOrder(list, node.right);
    }
}