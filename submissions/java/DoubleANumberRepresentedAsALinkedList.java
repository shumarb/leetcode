// Question: https://leetcode.com/problems/double-a-number-represented-as-a-linked-list/description/

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
        ListNode result = null;
        Stack<ListNode> stack = new Stack<>();
        boolean isTest = false;

        while (current != null) {
            stack.push(current);
            current = current.next;
        }
        if (isTest) {
            display("number: ", head);
        }

        int carry = 0;
        current = result;
        while (!stack.isEmpty()) {
            int number = stack.pop().val;
            int doubled = 2 * number + carry;
            int digit = doubled % 10;
            carry = doubled / 10;

            ListNode incoming = new ListNode(digit);
            incoming.next = result;
            result = incoming;
        }
        if (carry > 0) {
            ListNode incoming = new ListNode(carry);
            incoming.next = result;
            result = incoming;
        }
        if (isTest) {
            display("result: ", result.next);
        }

        return result;
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
        System.out.println("-----------------------------------------------------------------------");
    }
}