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
        int carry = 0;

        if (isTest) {
            display("number: ", head);
        }
        while (current != null) {
            stack.push(current);
            current = current.next;
        }

        current = result;
        while (!stack.isEmpty()) {
            int doubledNumber = 2 * stack.pop().val + carry;
            carry = doubledNumber / 10;

            ListNode incoming = new ListNode(doubledNumber % 10);
            incoming.next = result;
            result = incoming;
        }
        if (carry > 0) {
            ListNode incoming = new ListNode(carry);
            incoming.next = result;
            result = incoming;
        }
        if (isTest) {
            display("result: ", result);
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
        System.out.println("-------------------------------------------------------------------");
    }
}