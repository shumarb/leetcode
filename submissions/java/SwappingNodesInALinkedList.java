// Question: https://leetcode.com/problems/swapping-nodes-in-a-linked-list/description/

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
class SwappingNodesInALinkedList {
    public ListNode swapNodes(ListNode head, int k) {
        // 1. Edge case: List has only 1 element.
        if (head.next == null) {
            return head;
        }

        ListNode current = head;
        ListNode kthNodeFront = head;
        boolean isTest = false;
        int count = 0;

        while (current != null) {
            count++;
            if (count == k) {
                kthNodeFront = current;
            }
            current = current.next;
        }

        // 2. Edge case: No kth node if number of nodes < k.
        if (count < k) {
            return head;
        }

        ListNode kthNodeBack = head;
        for (int i = 0; i < count - k; i++) {
            kthNodeBack = kthNodeBack.next;
        }
        if (isTest) {
            System.out.println("count: " + count + "\nk: " + k);
            display(head);
            System.out.println("kthNodeFront: " + kthNodeFront.val);
            System.out.println("kthNodeBack: " + kthNodeBack.val);
        }

        int temp = kthNodeFront.val;
        kthNodeFront.val = kthNodeBack.val;
        kthNodeBack.val = temp;
        if (isTest) {
            System.out.println("-----------------------------------------------------------------------");
            display(head);
        }

        return head;
    }

    private void display(ListNode head) {
        ListNode current = head;
        while (current.next != null) {
            System.out.print(current.val + " --> ");
            current = current.next;
        }
        System.out.println(current.val);
    }
}