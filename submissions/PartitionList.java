// Question: https://leetcode.com/problems/partition-list/description/

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
class PartitionList {
    public ListNode partition(ListNode head, int x) {
        // 1. Edge cases: List contains 0 or 1 nodes.
        if (head == null || head.next == null) {
            return head;
        }

        /**
         1.  Create 2 sublists: all elements < x, and all elements >= x.
             Use 2 pointers for each sublist, one to reference the start of each sublist,
             and one used to populate the sublists.
         */
        ListNode left = new ListNode(-1);
        ListNode leftCurrent = left;
        ListNode right = new ListNode(-1);
        ListNode rightCurrent = right;
        boolean isTest = false;

        if (isTest) {
            display("before: ", head);
        }
        while (head != null) {
            if (head.val < x) {
                leftCurrent.next = head;
                leftCurrent = leftCurrent.next;
            } else {
                rightCurrent.next = head;
                rightCurrent = rightCurrent.next;
            }
            head = head.next;
        }

        /**
         2.  Set head as first element < x,
             set next of last element < x as first element >= x,
             and next set the last element >= x as null.
         */
        leftCurrent.next = right.next;
        rightCurrent.next = null;
        head = left.next;
        if (isTest) {
            display("after:  ", head);
        }

        return head;
    }

    private void display(String s, ListNode head) {
        ListNode current = head;

        System.out.print(s);
        while (current != null) {
            System.out.print(current.val + " ");
            current = current.next;
        }
        System.out.println();
    }
}