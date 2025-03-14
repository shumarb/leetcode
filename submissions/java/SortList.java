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
        // 1. Edge cases: List has either 0 elements or 1 element.
        if (head == null || head.next == null) {
            return head;
        }

        int[] valueFrequency = new int[200001];
        ListNode current = head;
        while (current != null) {
            valueFrequency[current.val + 100000]++;
            current = current.next;
        }

        current = head;
        for (int i = 0; i < valueFrequency.length; i++) {
            while (valueFrequency[i] > 0) {
                current.val = i - 100000;
                current = current.next;
                valueFrequency[i]--;
            }
        }

        return head;
    }
}