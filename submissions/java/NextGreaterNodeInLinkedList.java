// Question: https://leetcode.com/problems/next-greater-node-in-linked-list/description/

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
class NextGreaterNodeInLinkedList {
    public int[] nextLargerNodes(ListNode head) {
        if (head.next == null) {
            return new int[] {0};
        }
        ListNode current = head;
        boolean isTest = false;
        int[] values;
        int[] result;
        int count = 0;

        while (current != null) {
            count++;
            current = current.next;
        }

        int i = 0;
        values = new int[count];
        result = new int[count];
        current = head;
        while (current != null) {
            values[i++] = current.val;
            current = current.next;
        }

        Stack<Integer> stack = new Stack<>();
        for (i = 0; i < count; i++) {
            while (!stack.isEmpty() && values[stack.peek()] < values[i]) {
                result[stack.pop()] = values[i];
            }
            stack.push(i);
        }
        if (isTest) {
            System.out.println("values:    " + Arrays.toString(values));
            System.out.println("result:    " + Arrays.toString(result));
        }

        return result;
    }
}