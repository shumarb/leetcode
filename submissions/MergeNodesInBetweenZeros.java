// Question: https://leetcode.com/problems/merge-nodes-in-between-zeros/description/

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
class MergeNodesInBetweenZeros {
    public ListNode mergeNodes(ListNode head) {
        ListNode current = head.next;
        ListNode result = head;
        int sum = 0;

        while (current != null) {
            int value = current.val;
            if (value != 0) {
                sum += value;
            } else {
                result.next = new ListNode(sum);
                result = result.next;
                sum = 0;
            }
            current = current.next;
        }

        return head.next;
    }
}