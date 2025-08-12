// Question: https://leetcode.com/problems/linked-list-cycle-ii/description/

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
public class LinkedListCycleTwo {
    public ListNode detectCycle(ListNode head) {
        ListNode current = head;
        Set<ListNode> set = new HashSet<>();

        while (current != null) {
            if (current.next != null && set.contains(current.next)) {
                return current.next;
            }
            set.add(current);
            current = current.next;
        }

        return null;
    }
}