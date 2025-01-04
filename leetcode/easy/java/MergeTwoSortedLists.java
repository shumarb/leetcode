// Question: https://leetcode.com/problems/merge-two-sorted-lists/description/

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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode p1 = new ListNode();
        ListNode p2 = new ListNode();
        p1 = list1;
        p2 = list2;
        ListNode head = new ListNode();
        ListNode curr = new ListNode();
        curr = head;
        while (p1 != null && p2 != null) {
            ListNode newNode;
            if (p1.val <= p2.val) {
                newNode = new ListNode(p1.val);
                p1 = p1.next;
            } else {
                newNode = new ListNode(p2.val);
                p2 = p2.next;
            }
            curr.next = newNode;
            curr = curr.next;
        }

        if (p1 != null) {
            curr.next = p1;
        }
        if (p2 != null) {
            curr.next = p2;
        }
        return head.next;
    }

}
