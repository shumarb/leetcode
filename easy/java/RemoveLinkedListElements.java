// Question: https://leetcode.com/problems/remove-linked-list-elements/description/
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
class Solution {
    public ListNode removeElements(ListNode head, int val) {
        boolean t = false;
        if (t) {
            p("list: ", head);
        }

        ListNode curr;

        while (head != null && head.val == val) {
            curr = head;
            head = head.next;
            curr.next = null;
        }

        // Guaranteed iteration here starts with its element != val
        curr = head;
        ListNode r = curr;
        while (curr != null) {
            while (curr.next != null && curr.next.val == val) {
                r = curr.next;
                curr.next = r.next;
                r.next = null;
            }

            curr = curr.next;
        }
        if (t) {
            p("list: ", head);
        }
        return head;
    }

    private void p(String s, ListNode h) {
        ListNode c = h;
        System.out.print(s);
        while (c != null) {
            System.out.print(c.val + " -> ");
            c = c.next;
        }
        System.out.println("null");
    }
}