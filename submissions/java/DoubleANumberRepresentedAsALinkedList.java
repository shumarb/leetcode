// Question: https://leetcode.com/problems/double-a-number-represented-as-a-linked-list/description/

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
class DoubleANumberRepresentedAsALinkedList {
    public ListNode doubleIt(ListNode head) {
        ListNode current = head;
        StringBuilder str = new StringBuilder();
        boolean isTest = false;

        while (current != null) {
            str.append(current.val);
            current = current.next;
        }
        BigInteger number = new BigInteger(str.toString());
        if (isTest) {
            display("number list: ", head);
            System.out.println("str: " + str.toString());
            System.out.println("number: " + number);
        }

        number = number.multiply(new BigInteger("2"));
        if (isTest) {
            System.out.println("doubled number: " + number);
        }

        ListNode result = new ListNode(-1);
        current = result;
        String doubledNumber = number.toString();
        int len = doubledNumber.length();
        if (isTest) {
            System.out.println("doubled number string: " + doubledNumber);
        }
        for (int i = 0; i < len; i++) {
            ListNode incoming = new ListNode(Character.getNumericValue(doubledNumber.charAt(i)));
            current.next = incoming;
            current = current.next;
        }
        if (isTest) {
            display("doubled number list: ", result.next);
        }

        return result.next;
    }

    private void display(String sentence, ListNode head) {
        System.out.print(sentence);
        ListNode current = head;
        while (current != null) {
            if (current.next != null) {
                System.out.print(current.val + " -> ");
            } else {
                System.out.println(current.val);
            }
            current = current.next;
        }
        System.out.println("----------------------------------------------------------------------");
    }
}