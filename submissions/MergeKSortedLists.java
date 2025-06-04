// Question: https://leetcode.com/problems/merge-k-sorted-lists/description/

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
class MergeKSortedLists {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null) {
            return null;
        }

        PriorityQueue<ListNode> minHeap = new PriorityQueue<>(
                (a, b) -> Integer.compare(a.val, b.val)
        );
        for (ListNode list: lists) {
            if (list != null) {
                minHeap.offer(list);
            }
        }

        ListNode head = new ListNode();
        ListNode current = head;
        while (!minHeap.isEmpty()) {
            ListNode newNode = minHeap.poll();
            if (newNode.next != null) {
                minHeap.offer(newNode.next);
            }
            newNode.next = null;
            current.next = newNode;
            current = current.next;
        }

        return head.next;
    }
}