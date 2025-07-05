// Question: https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/description/

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class LowestCommonAncestorOfABinarySearchTree {
    private List<TreeNode> pPath;
    private List<TreeNode> qPath;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        boolean isTest = false;
        pPath = new ArrayList<>();
        qPath = new ArrayList<>();

        traverse(root, p, pPath);
        traverse(root, q, qPath);
        if (isTest) {
            display("pPath: ", pPath);
            display("qPath: ", qPath);
        }

        Set<TreeNode> visited = new HashSet<>();
        for (TreeNode node: pPath) {
            visited.add(node);
        }
        for (int i = qPath.size() - 1; i >= 0; i--) {
            TreeNode current = qPath.get(i);
            if (visited.contains(current)) {
                return current;
            }
        }

        return null;
    }

    private void traverse(TreeNode current, TreeNode target, List<TreeNode> path) {
        if (current == null) {
            return;
        }

        path.add(current);

        if (current == target) {
            return;
        }

        /**
         1.  Current is not target, so search for target in its left subtree.
             If target is not in left substree, search for it in right subtree.
             If target is in neither, backtrack.
         */
        traverse(current.left, target, path);
        if (path.get(path.size() - 1) != target) {
            traverse(current.right, target, path);
        }

        if (path.get(path.size() - 1) != target) {
            path.removeLast();
        }
    }

    private void display(String s, List<TreeNode> path) {
        System.out.print(s);
        for (int i = 0; i < path.size() - 1; i++) {
            System.out.print(path.get(i).val + " -> ");
        }
        System.out.println(path.get(path.size() - 1).val);
    }
}