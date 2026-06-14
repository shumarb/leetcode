// Question: https://leetcode.com/problems/maximum-twin-sum-of-a-linked-list/description/

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
class MaximumTwinSumOfALinkedList {
    public int pairSum(ListNode head) {
        ListNode current = head;
        boolean isTest = false;
        int[] values = new int[100001];
        int i = 0;
        int j;
        int result = 0;
        int total = 0;

        while (current != null) {
            values[total++] = current.val;
            current = current.next;
        }
        if (isTest) {
            System.out.println("values: " + Arrays.toString(Arrays.copyOfRange(values, 0, total)));
        }

        j = total - 1;
        while (i < j) {
            if (isTest) {
                System.out.println(values[i] + ", " + values[j]);
            }
            result = Math.max(result, values[i++] + values[j--]);
        }
        if (isTest) {
            System.out.println("result: " + result);
        }

        return result;
    }
}
