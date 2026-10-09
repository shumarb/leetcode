// Question: https://leetcode.com/problems/reorder-list/description/

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
class ReorderList {
    public void reorderList(ListNode head) {
        ListNode[] nodes = new ListNode[50001];
        ListNode current = head;
        int index = 0;
        int left = 0;
        int right;

        while (current != null) {
            nodes[index++] = current;
            current = current.next;
        }

        right = index - 1;
        while (left < right) {
            nodes[left++].next = nodes[right];
            nodes[right].next = nodes[left];
            right--;
        }

        nodes[left].next = null;
    }
}
