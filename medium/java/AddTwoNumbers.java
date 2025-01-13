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
        BigInteger sb1R = new BigInteger(sb1.reverse().toString());
        BigInteger sb2R = new BigInteger(sb2.reverse().toString());
        if (t) {
            System.out.println("sb1R: " + sb1R + "\nsb2R: " + sb2R);
        }
        BigInteger r = sb1R.add(sb2R);
        if (t) {
            System.out.println("r: " + r);
        }

        String rR = r.toString();
        StringBuilder sRev = new StringBuilder();
        for (int i = rR.length() - 1; i >= 0; i--) {
            sRev.append(rR.charAt(i));
        }
        if (t) {
            System.out.println("sRev: " + sRev);
        }

        head.val = Character.getNumericValue(sRev.charAt(0));
        if (t) {
            System.out.println("head.val: " + head.val);
        }
        ListNode curr = head;
        if (sRev.length() > 1) {
            for (int i = 1; i < sRev.length(); i++) {
                ListNode newNode = new ListNode(Character.getNumericValue(sRev.charAt(i)));
                curr.next = newNode;
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
    }
}