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
        PriorityQueue<Integer> minHeap = new PriorityQueue<> ();
        if (lists == null || lists.length == 0) {
            return null;
        }
        for (int i = 0; i < lists.length; i++) {
            ListNode head = lists[i];
            ListNode curr = new ListNode();
            curr = head;
            while (curr != null) {
                minHeap.offer(curr.val);
                curr = curr.next;
            }
        }
        ListNode head = new ListNode();
        ListNode curr = new ListNode();
        curr = head;
        while (!minHeap.isEmpty()) {
            ListNode newNode = new ListNode(minHeap.poll());
            curr.next = newNode;
            curr = curr.next;
        }
        return head.next;
    }
}
