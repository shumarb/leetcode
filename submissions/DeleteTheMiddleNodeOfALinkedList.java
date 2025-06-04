// Question: https://leetcode.com/problems/delete-the-middle-node-of-a-linked-list/description/

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
class DeleteTheMiddleNodeOfALinkedList {
    public ListNode deleteMiddle(ListNode head) {
        if (head.next == null) {
            return null;
        }

        boolean isTest = false;
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        if (isTest) {
            display(head);
            System.out.println("middle: " + slow.val);
        }

        previous.next = slow.next;
        slow.next = null;
        if (isTest) {
            display(head);
        }

        return head;
    }

    private void display(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val + " --> ");
            if (current.next == null) {
                System.out.println(current.val);
            }
            current = current.next;
        }
    }
}