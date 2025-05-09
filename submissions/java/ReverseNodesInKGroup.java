// Question: https://leetcode.com/problems/reverse-nodes-in-k-group/description/

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
class ReverseNodesInKGroup {
    public ListNode reverseKGroup(ListNode head, int k) {
        // 1. Edge case: Linked list has only 1 node.
        if (head == null || head.next == null) {
            return head;
        }

        ListNode current = head;
        int count = 0;
        while (current != null) {
            count++;
            current = current.next;
        }

        ListNode[] nodes = new ListNode[count];
        current = head;
        int i = 0;
        while (current != null) {
            nodes[i++] = current;
            current = current.next;
        }

        for (i = 0; i < count; i += k) {
            int start = i;
            int end = i + k - 1;
            while (end < count && start < end) {
                ListNode temp = nodes[start];
                nodes[start++] = nodes[end];
                nodes[end--] = temp;
            }
        }
        for (i = 0; i < count; i++) {
            if (i == 0) {
                head = nodes[0];
                nodes[0].next = nodes[1];
            } else if (i == count - 1) {
                nodes[i].next = null;
            } else {
                nodes[i].next = nodes[i + 1];
            }
        }

        return head;
    }
}