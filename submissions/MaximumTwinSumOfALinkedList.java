// Question: https://leetcode.com/problems/maximum-twin-sum-of-a-linked-list/description/

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
class MaximumTwinSumOfALinkedList {
    public int pairSum(ListNode head) {
        ListNode first = head;
        ListNode second = head.next;
        boolean isTest = false;
        int index = 0;
        int result = 0;

        while (second != null && second.next != null) {
            second = second.next.next;
            first = first.next;
            index++;
        }
        if (isTest) {
            System.out.println("first: " + first.val + ", index: " + index);
            display("before: ", head);
        }

        first.next = reverse(first.next);

        first = head;
        second = head;
        while (first != null && first.next != null) {
            first = first.next.next;
            second = second.next;
        }
        if (isTest) {
            System.out.print("second: " + second.val);
            if (second.next == null) {
                System.out.println(", next: " + null);
            } else {
                System.out.println(", next: " + second.next.val);
            }
            System.out.println("--------------------------------");
        }
        first = head;
        while (first != second && second != null) {
            int sum = first.val + second.val;
            if (isTest) {
                System.out.println(" * first: " + first.val + ", second: " + second.val + " -> sum: " + sum);
            }
            result = Math.max(result, sum);
            first = first.next;
            second = second.next;
        }
        if (isTest) {
            display("after: ", head);
        }

        return result;
    }

    private ListNode reverse(ListNode head) {
        ListNode current = head;
        ListNode previous = null;

        while (current != null) {
            ListNode next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }

        return previous;
    }

    private void display(String s, ListNode head) {
        System.out.print(s);
        ListNode current = head;

        while (current != null) {
            System.out.print(current.val + " ");
            current = current.next;
        }
        System.out.println("\n--------------------------------");
    }
}