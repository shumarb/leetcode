// Question: https://leetcode.com/problems/remove-zero-sum-consecutive-nodes-from-linked-list/description/

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
class RemoveZeroSumConsecutiveNodesFromLinkedList {
    public ListNode removeZeroSumSublists(ListNode head) {
        ListNode result = new ListNode(0);
        Map<Integer, ListNode> prefixSumMap = new HashMap<>();
        int sum = 0;
        result.next = head;

        // 1. Record last appearance of each prefix sum.
        for (ListNode node = result; node != null; node = node.next) {
            sum += node.val;
            prefixSumMap.put(sum, node);
        }

        // 2. Remove zero-sum sequences.
        sum = 0;
        for (ListNode node = result; node != null; node = node.next) {
            sum += node.val;
            node.next = prefixSumMap.get(sum).next;
        }

        return result.next;
    }
}