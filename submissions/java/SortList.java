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
        // 1. Edge cases: 0 elements or 1 element in list.
        if (head == null || head.next == null) {
            return head;
        }

        PriorityQueue<ListNode> minHeap = new PriorityQueue<>(
                (a, b) -> Integer.compare(a.val, b.val)
        );
        ListNode current = head;
        while (current != null) {
            minHeap.offer(current);
            current = current.next;
        }

        int count = 0;
        current = head;
        while (!minHeap.isEmpty()) {
            ListNode newNode = minHeap.poll();
            count++;
            if (count == 1) {
                head = newNode;
            }
            newNode.next = null;
            current.next = newNode;
            current = current.next;
        }

        return head;
    }
}