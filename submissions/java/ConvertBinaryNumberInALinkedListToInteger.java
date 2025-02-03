// Question: https://leetcode.com/problems/convert-binary-number-in-a-linked-list-to-integer/description/

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
class ConvertBinaryNumberInALinkedListToInteger {
    public int getDecimalValue(ListNode head) {
        int decimalValue = 0;
        int count = 0;
        ListNode curr = head;
        boolean isTest = false;

        while (curr != null) {
            count++;
            if (isTest) {
                System.out.println("count: " + count + ", current val: " + curr.val);
            }
            curr = curr.next;
        }

        curr = head;
        while (curr != null) {
            if (curr.val == 1) {
                if (isTest) {
                    System.out.println("count: " + count + ", decimalValue: " + decimalValue + ", adding: " + Math.pow(2.0, count - 1));
                }
                decimalValue += Math.pow(2.0, count - 1);
            }
            count--;
            curr = curr.next;
        }

        return decimalValue;
    }
}