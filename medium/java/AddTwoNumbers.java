// Question: https://leetcode.com/problems/add-two-numbers/description/

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
class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(-1);
        ListNode current = head;
        ListNode l1Current = l1;
        ListNode l2Current = l2;
        int carry = 0;
        boolean isTest = false;

        while (l1Current != null || l2Current != null | carry != 0) {
            int val1 = (l1Current != null) ? l1Current.val : 0;
            int val2 = (l2Current != null) ? l2Current.val : 0;
            int sum = val1 + val2 + carry;

            if (isTest) {
                System.out.println("val1: " + val1 + ", val2: " + val2 + ", carry: " + carry + " ==> sum: " + sum);
            }

            current.next = new ListNode(sum % 10);
            carry = sum / 10;
            current = current.next;
            if (l1Current != null) {
                l1Current = l1Current.next;
            }
            if (l2Current != null) {
                l2Current = l2Current.next;
            }
        }

        return head.next;
    }
}