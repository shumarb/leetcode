// Question: https://leetcode.com/problems/count-good-nodes-in-binary-tree/description/

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
class CountGoodNodesInBinaryTree {
    private List<List<Integer>> paths = new ArrayList<>();

    public int goodNodes(TreeNode root) {
        boolean isTest = false;
        int count = 0;

        dfs(root, new ArrayList<>());
        for (List<Integer> path: paths) {
            boolean isValid = true;
            int maximum = path.get(path.size() - 1);
            for (int i = path.size() - 2; i >= 0; i--) {
                if (path.get(i) > maximum) {
                    isValid = false;
                    break;
                }
            }
            if (isValid) {
                if (isTest) {
                    System.out.println(" * valid path: " + path);
                }
                count++;
            }
        }
        if (isTest) {
            System.out.println("-----------------------------------------");
            System.out.println("paths:");
            for (List<Integer> path: paths) {
                System.out.println(" * " + path);
            }
            System.out.println("-----------------------------------------");
            System.out.println("count: " + count);
        }

        return count;
    }

    private void dfs(TreeNode node, List<Integer> path) {
        if (node == null) {
            return;
        }

        path.add(node.val);
        paths.add(new ArrayList<>(path));

        if (node.left != null) {
            dfs(node.left, path);
        }
        if (node.right != null) {
            dfs(node.right, path);
        }
        path.removeLast();
    }
}