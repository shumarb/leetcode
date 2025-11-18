// Question: https://leetcode.com/problems/insert-greatest-common-divisors-in-linked-list/description/

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
class InsertGreatestCommonDivisorsInLinkedList {
    public ListNode insertGreatestCommonDivisors(ListNode head) {
        // 1. Edge case: List has 1 element.
        if (head.next == null) {
            return head;
        }

        ListNode current = head;
        boolean isTest = false;

        if (isTest) {
            display("before: ", head);
        }
        while (current != null && current.next != null) {
            ListNode incoming = new ListNode(gcd(current.val, current.next.val));
            incoming.next = current.next;
            current.next = incoming;
            current = current.next.next;
        }
        if (isTest) {
            display("after: ", head);
        }

        return head;
    }

    private int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    private void display(String s, ListNode head) {
        ListNode current = head;

        System.out.print(s);
        while (current.next != null) {
            System.out.print(current.val + " -> ");
            current = current.next;
        }
        System.out.println(current.val);
        System.out.println("----------------------------------------------");
    }
}