// Question: https://leetcode.com/problems/delete-the-middle-node-of-a-linked-list/description/

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
class DeleteTheMiddleNodeOfALinkedList {
    public ListNode deleteMiddle(ListNode head) {
        // 1. Edge case: List with 1 element.
        if (head.next == null) {
            return null;
        }

        ListNode fast = head.next.next;
        ListNode slow = head;
        boolean isTest = false;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        if (isTest) {
            printList("before: ", head);
            print("slow: ", slow);
            print("fast: ", fast);
        }

        slow.next = slow.next.next;
        if (isTest) {
            printList("------------------------------\nafter: ", head);
        }

        return head;
    }

    private void print(String s, ListNode node) {
        System.out.print(s);
        if (node == null) {
            System.out.println("null");
        } else {
            System.out.println(node.val);
        }
    }

    private void printList(String s, ListNode head) {
        ListNode current = head;

        System.out.print(s);
        while (current != null) {
            System.out.print(current.val + " ");
            current = current.next;
        }
        System.out.println("\n------------------------------");
    }
}
