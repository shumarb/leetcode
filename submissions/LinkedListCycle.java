// Question: https://leetcode.com/problems/linked-list-cycle/description/

/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class LinkedListCycle {
    public boolean hasCycle(ListNode head) {
        // 1. Empty list.
        if (head == null) {
            return false;
        }

        /**
         2.  Using slow and fast pointers,
             If both pointers are pointing to the same node, a cycle exists.
             If not, set slow to it's next pointer, and fast to its next's next's pointers.
         */
        ListNode fast = head;
        ListNode slow = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                return true;
            }
        }

        return false;
    }
}