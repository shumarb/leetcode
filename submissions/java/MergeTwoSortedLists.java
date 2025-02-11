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
class MergeTwoSortedLists  {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        // 1. No nodes in both nodes
        if (list1 == null && list2 == null) {
            return null;
        }
        ListNode head = new ListNode(-1);
        ListNode current = head;

        /**
         2.  Both lists are have at least 1 node,
         so check its corresponding elements to identify smaller element
         and add it to combined list
         */
        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                current.next = list1;
                list1 = list1.next;
            } else {
                current.next = list2;
                list2 = list2.next;
            }
            current = current.next;
        }

        /**
         3.  If both lists are of different lengths,
         while loop above iterates the entirety of shorter list but not the other list
         so set current node's next to the start node of remaining nodes of the other list 
         that has not been traversed fully.
         */
        if (list1 != null) {
            current.next = list1;
        }
        if (list2 != null) {
            current.next = list2;
        }

        return head.next;
    }

}
