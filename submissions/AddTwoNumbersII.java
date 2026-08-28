// Question: https://leetcode.com/problems/add-two-numbers-ii/description/

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
class AddTwoNumbersTwo {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = null;
        int carry = 0;
        boolean isTest = true;

        Stack<Integer> l1Stack = new Stack<>();
        Stack<Integer> l2Stack = new Stack<>();
        populate(l1, l1Stack);
        populate(l2, l2Stack);

        while (!l1Stack.isEmpty() || !l2Stack.isEmpty() || carry != 0) {
            int sum = carry;

            if (!l1Stack.isEmpty()) {
                sum += l1Stack.pop();
            }

            if (!l2Stack.isEmpty()) {
                sum += l2Stack.pop();
            }

            carry = sum / 10;
            ListNode newNode = new ListNode(sum % 10);
            newNode.next = result;
            result = newNode;
        }

        return result;
    }

    private void populate(ListNode head, Stack<Integer> stack) {
        ListNode current = head;
        while (current != null) {
            stack.push(current.val);
            current = current.next;
        }
    }
}