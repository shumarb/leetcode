// Question: https://leetcode.com/problems/find-the-minimum-and-maximum-number-of-nodes-between-critical-points/description/

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
class FindTheMinimumAndMaximumNumberOfNodesBetweenCriticalPoints {
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        ListNode left = head;
        ListNode middle = head.next;
        ListNode right = head.next.next;
        int count = 0;
        int first = -1;
        int last = -1;
        int minimum = Integer.MAX_VALUE;

        while (right != null) {
            if ((middle.val > left.val && middle.val > right.val) || (middle.val < left.val && middle.val < right.val)) {
                if (first == -1) {
                    first = count;
                } else {
                    minimum = Math.min(minimum, count - last);
                }
                last = count;
            }

            left = left.next;
            middle = middle.next;
            right = right.next;
            count++;
        }

        return first == last ? new int[] {-1, -1} : new int[] {minimum, last - first};
    }
}