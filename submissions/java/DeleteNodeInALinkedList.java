// Question: https://leetcode.com/problems/delete-node-in-a-linked-list/description/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class DeleteNodeInALinkedList {
    public void deleteNode(ListNode node) {
        ListNode current = node;
        while (current != null && current.next != null) {
            if (current.next.next == null) {
                current.val = current.next.val;
                current.next = null;
            } else if (current.next != null) {
                current.val = current.next.val;
                current = current.next;
            }
        }
    }
}