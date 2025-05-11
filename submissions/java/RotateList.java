// Question: https://leetcode.com/problems/rotate-list/description/

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
class RotateList {
    private ListNode[] nodes;

    public ListNode rotateRight(ListNode head, int k) {
        ListNode current = head;
        boolean isTest = false;
        int count = 0;

        while (current != null) {
            count++;
            current = current.next;
        }

        /**
         1. Edge cases (no rotations):
         1. Linked list has 0 nodes.
         2. Linked list has 1 node.
         3. k == number of nodes.
         */
        if (head == null || head.next == null || k == count) {
            return head;
        }

        // 2. Set k to be itself modulo count to eliminate unnecessary rotations.
        k %= count;
        nodes = new ListNode[count];
        current = head;
        int i = 0;
        while (current != null) {
            nodes[i++] = current;
            current = current.next;
        }
        if (isTest) {
            display("before | ", head);
        }

        /**
         3. Execute rotations
         1. Reverse all elements.
         2. Reverse first k elements.
         3. Reverse last (count - k) elements.
         */
        reverse(0, count - 1);
        reverse(0, k - 1);
        reverse(k, count - 1);

        // 4. Update next pointers and head.
        head = nodes[0];
        nodes[count - 1].next = null;
        for (i = 0; i < count - 1; i++) {
            nodes[i].next = nodes[i + 1];
        }
        if (isTest) {
            display("after  | ", head);
        }

        return head;
    }

    private void reverse(int start, int end) {
        while (start < end) {
            ListNode temp = nodes[start];
            nodes[start++] = nodes[end];
            nodes[end--] = temp;
        }
    }

    private void display(String sentence, ListNode head) {
        System.out.print(sentence);
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val + " -> ");
            if (current.next == null) {
                System.out.println("null");
            }
            current = current.next;
        }
        System.out.println("------------------------------------------------------------------");
    }

}