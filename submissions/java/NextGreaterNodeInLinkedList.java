// Question: https://leetcode.com/problems/next-greater-node-in-linked-list/description/

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
class NextGreaterNodeInLinkedList {
    public int[] nextLargerNodes(ListNode head) {
        if (head.next == null) {
            return new int[] {0};
        }
        ListNode current = head;
        boolean isTest = false;
        int[] arr;
        int[] suffix;
        int count = 0;

        while (current != null) {
            count++;
            current = current.next;
        }

        int i = 0;
        arr = new int[count];
        suffix = new int[count];
        current = head;
        while (current != null) {
            arr[i++] = current.val;
            current = current.next;
        }
        for (i = 0; i < count - 1; i++) {
            for (int j = i + 1; j < count; j++) {
                if (arr[j] > arr[i]) {
                    suffix[i] = arr[j];
                    break;
                }
            }
        }
        if (isTest) {
            System.out.println("arr:    " + Arrays.toString(arr));
            System.out.println("suffix: " + Arrays.toString(suffix));
        }

        return suffix;
    }
}