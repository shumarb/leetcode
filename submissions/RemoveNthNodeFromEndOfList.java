// Question: https://leetcode.com/problems/remove-nth-node-from-end-of-list/description/

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
class RemoveNthNodeFromEndOfList {
    private boolean isTest = false;

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode current = head;
        int total = displayAndGetTotalNodes(head);

        if (isTest) {
            System.out.println("total: " + total + "\nn: " + n);
        }

        // 1. Removal of first element.
        if (n == total) {
            head = head.next;
        } else {
            int count = 0;
            while (current != null) {
                count++;
                if (count == (total - n)) {
                    current.next = current.next.next;
                }
                current = current.next;
            }
        }

        if (isTest) {
            total = displayAndGetTotalNodes(head);
        }

        return head;
    }

    private int displayAndGetTotalNodes(ListNode head) {
        int total = 0;
        ListNode current = head;
        while (current != null) {
            if (isTest) {
                System.out.print(current.val + " -> ");
            }
            total++;
            current = current.next;
        }
        if (isTest) {
            System.out.println("null");
        }

        return total;
    }
}