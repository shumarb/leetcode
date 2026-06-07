// Question: https://leetcode.com/problems/create-binary-tree-from-descriptions/description/

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
class CreateBinaryTreeFromDescriptions {
    public TreeNode createBinaryTree(int[][] descriptions) {
        TreeNode[] nodes = new TreeNode[100001];
        TreeNode root = null;
        boolean[] isChild = new boolean[100001];
        boolean isTest = false;

        for (int[] e: descriptions) {
            int child = e[1];
            int childType = e[2];
            int parent = e[0];

            if (nodes[parent] == null) {
                nodes[parent] = new TreeNode(parent);
            }
            if (nodes[child] == null) {
                nodes[child] = new TreeNode(child);
            }
            isChild[child] = true;
            if (childType == 0) {
                nodes[parent].right = nodes[child];
            } else {
                nodes[parent].left = nodes[child];
            }
        }
        for (int i = 1; i < nodes.length; i++) {
            if (nodes[i] != null && !isChild[i]) {
                root = nodes[i];
                break;
            }
        }
        if (isTest) {
            System.out.println("root: " + root.val + "\ntree:");
            for (int i = 1; i < nodes.length; i++) {
                if (nodes[i] != null) {
                    System.out.print(" * node: " + nodes[i].val + " | left: ");
                    if (nodes[i].left == null) {
                        System.out.print("null");
                    } else {
                        System.out.print(nodes[i].left.val);
                    }
                    System.out.print(" | right: ");
                    if (nodes[i].right == null) {
                        System.out.println("null");
                    } else {
                        System.out.println(nodes[i].right.val);
                    }
                }
            }
        }

        return root;
    }
}
