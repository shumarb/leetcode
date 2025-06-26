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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode current = head;
        boolean isTest = false;
        int total = 0;

        while (current != null) {
            total++;
            current = current.next;
        }
        if (isTest) {
            System.out.println("n: " + n + "\ntotal: " + total);
            display("before, list: ", head);
            System.out.println("---------------------------------------------");
        }

        // 1. Edge case: Delete first node.
        if (n == total) {
            head = head.next;
            return head;
        }

        int count = 0;
        current = head;
        while (current != null) {
            count++;
            if (count == total - n) {
                current.next = current.next.next;
            }
            current = current.next;
        }
        if (isTest) {
            display("after, list: ", head);
        }

        return head;
    }

    private void display(String sentence, ListNode head) {
        System.out.print(sentence);
        ListNode current = head;
        while (current != null) {
            if (current.next == null) {
                System.out.println(current.val);
            } else {
                System.out.print(current.val + " -> ");
            }
            current = current.next;
        }
    }
}