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
        // 1. Edge cases: 0 or 1 nodes in list.
        if (head == null || head.next == null) {
            return head;
        }

        List<ListNode> list = new ArrayList<>();
        ListNode current = head;
        boolean isTest = false;

        if (isTest) {
            display("before: ", head);
        }
        while (current != null) {
            if (current.val < x) {
                list.add(current);
            }
            current = current.next;
        }
        current = head;
        while (current != null) {
            if (current.val >= x) {
                list.add(current);
            }
            current = current.next;
        }

        head = list.get(0);
        list.get(list.size() - 1).next = null;
        for (int i = 0; i < list.size() - 1; i++) {
            list.get(i).next = list.get(i + 1);
        }
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