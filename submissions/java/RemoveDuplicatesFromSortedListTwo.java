// Question: https://leetcode.com/problems/remove-duplicates-from-sorted-list-ii/description/

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
class RemoveDuplicatesFromSortedListTwo {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode newHead = new ListNode(-1);
        newHead.next = head;
        ListNode previous = newHead;

        while (head != null) {
            boolean isDuplicate = false;

            while (head.next != null && head.next.val == head.val) {
                head = head.next;
                isDuplicate = true;
            }

            if (isDuplicate) {
                previous.next = head.next;
            } else {
                previous = previous.next;
            }

            head = head.next;
        }

        return newHead.next;
    }
}