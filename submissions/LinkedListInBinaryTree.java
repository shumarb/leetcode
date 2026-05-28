// Question: https://leetcode.com/problems/linked-list-in-binary-tree/description/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
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
class LinkedListInBinaryTree {
    private List<TreeNode> list;
    private boolean isTest;
    private boolean isSubPath;

    public boolean isSubPath(ListNode head, TreeNode root) {
        isSubPath = false;
        isTest = false;
        list = new ArrayList<>();

        dfs(head, root);
        if (isTest) {
            System.out.print("list: ");
            for (TreeNode e: list) {
                System.out.print(e.val + " ");
            }
            System.out.println();
        }
        for (TreeNode e: list) {
            explore(head, e);
        }

        return isSubPath;
    }

    private void dfs(ListNode head, TreeNode root) {
        if (head == null || root == null) {
            return;
        }

        if (head.val == root.val) {
            list.add(root);
        }
        dfs(head, root.left);
        dfs(head, root.right);
    }

    private void explore(ListNode listNode, TreeNode treeNode) {
        // 1. Entire linked list traversed, so a sub path exists.
        if (listNode == null) {
            if (isTest) {
                System.out.println("end of list");
            }
            isSubPath = true;
            return;
        }

        if (isSubPath || treeNode == null || listNode.val != treeNode.val) {
            return;
        }

        if (isTest) {
            System.out.println("-------------------------------------");
            System.out.println("listNode: " + listNode.val + ", treeNode: " + treeNode.val);
            System.out.println(" * going left");
        }
        explore(listNode.next, treeNode.left);

        if (isTest) {
            System.out.println(" * going right");
        }
        explore(listNode.next, treeNode.right);
    }
}
