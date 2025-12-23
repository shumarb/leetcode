// Question: https://leetcode.com/problems/linked-list-components/description/

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
class LinkedListComponents {
    public int numComponents(ListNode head, int[] nums) {
        ListNode current = head;
        boolean[] isPresentInNums = new boolean[10001];
        int result = 0;

        for (int e: nums) {
            isPresentInNums[e] = true;
        }
        while (current != null) {
            if (isPresentInNums[current.val]) {
                while (current != null && isPresentInNums[current.val]) {
                    current = current.next;
                }
                result++;

            } else {
                current = current.next;
            }
        }

        return result;
    }
}