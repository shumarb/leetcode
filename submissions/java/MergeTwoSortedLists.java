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
class MergeTwoSortedLists {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        // 1. No nodes in both nodes
        if (list1 == null && list2 == null) {
            return null;
        }
        ListNode list1Current = list1;
        ListNode list2Current = list2;
        ListNode head = new ListNode(-1);
        ListNode current = head;

        /**
         2.  Both lists are have at least 1 node,
         so check its corresponding elements to identify smaller element
         and add it to combined list
         */
        while (list1Current != null && list2Current != null) {
            ListNode newNode;
            if (list1Current.val <= list2Current.val) {
                newNode = new ListNode(list1Current.val);
                list1Current = list1Current.next;
            } else {
                newNode = new ListNode(list2Current.val);
                list2Current = list2Current.next;
            }
            current.next = newNode;
            current = current.next;
        }

        /**
         3.  If both lists are of different lengths,
         while loop above iterates the entirety of shorter list but not the other list
         so set current node's next to the start node of remaining nodes of the other list 
         that has not been traversed fully.
         */
        if (list1Current != null) {
            current.next = list1Current;
        }
        if (list2Current != null) {
            current.next = list2Current;
        }

        return head.next;
    }

}
