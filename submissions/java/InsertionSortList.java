// Question: https://leetcode.com/problems/insertion-sort-list/description/

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
class InsertionSortList {
    public ListNode insertionSortList(ListNode head) {
        ListNode current = head;
        int count = 0;

        while (current != null) {
            count++;
            current = current.next;
        }
        ListNode[] arr = new ListNode[count];
        int i = 0;
        current = head;
        while (current != null) {
            arr[i++] = current;
            current = current.next;
        }

        for (i = 1; i < count; i++) {
            current = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j].val > current.val) {
                arr[j + 1] = arr[j--];
            }
            arr[j + 1] = current;
        }

        for (i = 0; i < count - 1; i++) {
            arr[i].next = arr[i + 1];
        }
        head = arr[0];
        arr[count - 1].next = null;

        return head;
    }
}