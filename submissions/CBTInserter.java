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
    private TreeNode[] tree;
    private boolean isTest;
    private int index;

    public CBTInserter(TreeNode root) {
        index = 0;
        isTest = false;
        tree = new TreeNode[10001];

        bfs(root);
        if (isTest) {
            print("tree:");
        }
    }

    private void print(String s) {
        System.out.println("-------------------------\n" + s);
        for (int i = 0; i < index; i++) {
            System.out.print(tree[i].val + " ");
        }
        System.out.println();
    }

    private void bfs(TreeNode node) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(node);

        while (!queue.isEmpty()) {
            TreeNode top = queue.poll();
            tree[index++] = top;
            if (top.left != null) {
                queue.offer(top.left);
            }
            if (top.right != null) {
                queue.offer(top.right);
            }
        }
    }

    public int insert(int val) {
        TreeNode node = new TreeNode(val);

        int n = index;
        int parentIndex = (n - 1) / 2;
        TreeNode parent = tree[parentIndex];
        tree[index++] = node;

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
        return tree[0];
    }
}

/**
 * Your CBTInserter object will be instantiated and called as such:
 * CBTInserter obj = new CBTInserter(root);
 * int param_1 = obj.insert(val);
 * TreeNode param_2 = obj.get_root();
 */