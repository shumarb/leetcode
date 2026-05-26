// Question: https://leetcode.com/problems/complete-binary-tree-inserter/description/

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
class CBTInserter {
    private List<TreeNode> tree;
    private boolean isTest;

    public CBTInserter(TreeNode root) {
        isTest = false;
        tree = new ArrayList<>();
        bfs(root);
        if (isTest) {
            print("tree:");
        }
    }

    private void print(String s) {
        System.out.println("-------------------------\n" + s);
        for (TreeNode e: tree) {
            System.out.print(e.val + " ");
        }
        System.out.println();
    }

    private void bfs(TreeNode node) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(node);

        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                TreeNode top = queue.poll();
                tree.add(top);
                if (top.left != null) {
                    queue.offer(top.left);
                }
                if (top.right != null) {
                    queue.offer(top.right);
                }
            }
        }
    }

    public int insert(int val) {
        TreeNode node = new TreeNode(val);

        int n = tree.size();
        int parentIndex = (n - 1) / 2;
        TreeNode parent = tree.get(parentIndex);
        tree.add(node);

        if (isTest) {
            print("after inserting " + val + ", tree:");
        }
        if (n % 2 == 1) {
            parent.left = node;
        } else {
            parent.right = node;
        }
        if (isTest) {
            System.out.println(" * parent: " + parent.val + " @ index " + parentIndex);
        }

        return parent.val;
    }

    public TreeNode get_root() {
        return tree.get(0);
    }
}

/**
 * Your CBTInserter object will be instantiated and called as such:
 * CBTInserter obj = new CBTInserter(root);
 * int param_1 = obj.insert(val);
 * TreeNode param_2 = obj.get_root();
 */
