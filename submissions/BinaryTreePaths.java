// Question: https://leetcode.com/problems/binary-tree-paths/description/

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
class BinaryTreePaths {
    private List<List<Integer>> allRootToLeafPaths = new ArrayList<>();

    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<>();
        boolean isTest = false;

        findAllRootToLeafPaths(root, new ArrayList<>());

        for (List<Integer> path: allRootToLeafPaths) {
            StringBuilder incoming = new StringBuilder();
            for (int i = 0; i < path.size(); i++) {
                incoming.append(path.get(i));
                if (i < path.size() - 1) {
                    incoming.append("->");
                }
            }
            result.add(incoming.toString());
        }
        if (isTest) {
            System.out.println("all root-to-leaf-paths:");
            for (List<Integer> path: allRootToLeafPaths) {
                System.out.println(" * " + path);
            }
            System.out.println("-------------------------------------------");
            System.out.println("result: " + result);
        }

        return result;
    }

    private void findAllRootToLeafPaths(TreeNode current, List<Integer> path) {
        if (current == null) {
            return;
        }

        path.add(current.val);

        // 1. Path from root to leaf found, so add it to list of all root-to-leaf-paths.
        if (current.left == null && current.right == null) {
            allRootToLeafPaths.add(new ArrayList<>(path));
        } else {
            findAllRootToLeafPaths(current.left, path);
            findAllRootToLeafPaths(current.right,path);
        }

        // 2. Backtrack by eliminating last-inserted node and traverse previous path.
        path.remove(path.size() - 1);
    }
}