// Question: https://leetcode.com/problems/binary-search-tree-iterator/description/

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
class BinarySearchTreeIterator {
    private List<Integer> list;
    private int pointer;
    private boolean isTest;

    public BSTIterator(TreeNode root) {
        isTest = false;
        list = new ArrayList<>();
        pointer = 0;
        inOrderTraversal(root);
        if (isTest) {
            System.out.println("list: " + list);
            System.out.println("---------------------------------");
        }
    }

    private void inOrderTraversal(TreeNode node) {
        if (node == null) {
            return;
        }
        inOrderTraversal(node.left);
        list.add(node.val);
        inOrderTraversal(node.right);
    }

    public int next() {
        return list.get(pointer++);
    }

    public boolean hasNext() {
        return pointer < list.size();
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */