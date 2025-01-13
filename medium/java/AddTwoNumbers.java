// Question: https://leetcode.com/problems/add-two-numbers/description/

import java.math.BigInteger;

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
        ListNode head = new ListNode();
        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        boolean t = false;

        update(l1, sb1);
        update(l2, sb2);
        if (t) {
            System.out.println("sb1: " + sb1 + "\nsb2: " + sb2);
        }

        BigInteger b1 = new BigInteger(sb1.toString());
        BigInteger b2 = new BigInteger(sb2.toString());
        if (t) {
            System.out.println("b1: " + b1 + "\nb2: " + b2);
        }
        String sum = b1.add(b2).toString();
        if (t) {
            System.out.println("sum: " + sum);
        }

        head.val = Character.getNumericValue(sum.charAt(sum.length() - 1));
        ListNode curr = head;
        if (t) {
            System.out.println("head: " + head.val);
        }
        if (sum.length() > 1) {
            for (int i = sum.length() - 2; i >= 0; i--) {
                ListNode newN = new ListNode(Character.getNumericValue(sum.charAt(i)));
                curr.next = newN;
                curr = curr.next;
            }
        }

        return head;
    }

    private void update(ListNode l, StringBuilder s) {
        ListNode curr = l;
        while (curr != null) {
            int v = curr.val;
            s.append(Character.forDigit(v, 10));
            curr = curr.next;
        }
        s = s.reverse();
    }
}