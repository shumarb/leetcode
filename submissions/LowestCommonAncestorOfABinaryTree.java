// Question: https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/description/

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class LowestCommonAncestorOfABinaryTree {
    private List<TreeNode> pPath;
    private List<TreeNode> qPath;
    private Set<TreeNode> ancestors;
    private TreeNode p;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        boolean isTest = false;
        ancestors = new HashSet<>();
        pPath = new ArrayList<>();
        qPath = new ArrayList<>();
        this.p = p;

        findPath(root, p, pPath);
        findPath(root, q, qPath);
        if (isTest) {
            display("p path: ", pPath);
            display("q path: ", qPath);
        }

        for (int i = qPath.size() - 1; i >= 0; i--) {
            TreeNode current = qPath.get(i);
            if (ancestors.contains(current)) {
                return current;
            }
        }

        return null;
    }

    private void findPath(TreeNode current, TreeNode target, List<TreeNode> path) {
        if (current == null) {
            return;
        }

        path.add(current);
        if (target == p) {
            ancestors.add(current);
        }
        if (current == target) {
            return;
        }

        findPath(current.left, target, path);
        if (path.get(path.size() - 1) != target) {
            findPath(current.right, target, path);
        }

        if (path.get(path.size() - 1) != target) {
            if (target == p) {
                ancestors.remove(current);
            }
            path.removeLast();
        }
    }

    private void display(String sentence, List<TreeNode> path) {
        System.out.print(sentence);
        for (int i = 0; i < path.size() - 1; i++) {
            System.out.print(path.get(i).val + " -> ");
        }
        System.out.println(path.get(path.size() - 1).val);
    }
}