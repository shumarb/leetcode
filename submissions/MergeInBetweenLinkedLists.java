// Question: https://leetcode.com/problems/merge-in-between-linked-lists/description/

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
class MergeInBetweenLinkedLists {
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        ListNode connection = null;
        ListNode current = list1;
        ListNode start = null;
        boolean isTest = false;
        int count = -1;

        while (current != null) {
            count++;
            if (count == a - 1) {
                start = current;
            } else if (count == b + 1) {
                connection = current;
            }
            current = current.next;
        }
        start.next = list2;

        current = list2;
        while (current != null && current.next != null) {
            current = current.next;
        }
        current.next = connection;
        if (isTest) {
            display("before, list1: ", list1);
            System.out.println(" * start: " + start.val + "\n * connection: " + connection.val);
            System.out.println("----------------------------------------------------------");
            display("after, list1: ", list1);
        }

        return list1;
    }

    private void display(String s, ListNode head) {
        ListNode current = head;

        System.out.print(s);
        while (current != null) {
            System.out.print(current.val + " ");
            if (current.next == null) {
                System.out.println();
            }
            current = current.next;
        }
        System.out.println("----------------------------------------------------------");
    }
}