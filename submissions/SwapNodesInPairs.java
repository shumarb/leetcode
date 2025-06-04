// Question: https://leetcode.com/problems/swap-nodes-in-pairs/description/

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
class SwapNodesInPairs {
    public ListNode swapPairs(ListNode head) {
        boolean isTest = false;
        if (isTest) {
            display("initial list: ", head);
        }

        // 1. Edge case: empty list, list with single element
        if (head == null || head.next == null) {
            return head;
        }

        ListNode dummy = new ListNode(Integer.MIN_VALUE);
        dummy.next = head;
        ListNode previous = dummy;

        while (head != null && head.next != null) {
            // 2. Identify pair of adjacent nodes to do swap
            ListNode first = head;
            ListNode second = head.next;
            if (isTest) {
                System.out.print("* swap elements: " + first.val + " <----> " + second.val + " | ");
            }

            // 3. Swap
            first.next = second.next;
            second.next = first;
            previous.next = second;
            previous = first;
            if (isTest) {
                display("after swap, list so far: ", dummy.next);
            }

            // 4. Move to next pair of adjacent nodes
            head = first.next;
        }
        if (isTest) {
            display("final list: ", dummy.next);
        }

        return dummy.next;
    }

    private void display(String str, ListNode head) {
        System.out.print(str);
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val + " -> ");
            if (current.next == null) {
                System.out.println("null");
            }
            current = current.next;
        }
    }
}