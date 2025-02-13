// Question: https://leetcode.com/problems/sort-list/description/

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
class SortList {
    public ListNode sortList(ListNode head) {
        // 1. Edge case: empty list or list with single element
        if (head == null || head.next == null) {
            return head;
        }

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        boolean isTest = false;
        if (isTest) {
            display(head);
        }

        ListNode current = head;
        while (current != null) {
            minHeap.offer(current.val);
            current = current.next;
        }
        if (isTest) {
            System.out.println("minHeap: " + minHeap);
        }

        current = head;
        while (!minHeap.isEmpty()) {
            current.val = minHeap.poll();
            current = current.next;
            if (isTest) {
                System.out.println("minHeap so far: " + minHeap);
            }
        }
        if (isTest) {
            display(head);
        }

        return head;
    }

    private void display(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val + " -> ");
            if (current.next == null) {
                System.out.println("null");
            }
            current = current.next;
        }
    }
}