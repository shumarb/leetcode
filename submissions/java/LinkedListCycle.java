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
        // 1. No elements to check
        if (head == null) {
            return false;
        }

        ListNode slow = head;
        ListNode fast = head;
        while (fast != null) {
            // 2. currently at tail (last element)
            if (fast.next == null) {
                return false;
            }

            // 3. Adjust and check if both point to same element
            // if yes, a cycle is detected
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }
        }

        // 4. Traversed all elements of linked list
        return false;
    }
}