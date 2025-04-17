// Question: https://leetcode.com/problems/reverse-linked-list-ii/description/

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
class ReversedLinkedListTwo {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode current = head;
        boolean isTest = false;
        int count = 0;

        while (current != null) {
            count++;
            current = current.next;
        }

        int[] values = new int[count];
        current = head;
        int i = 0;
        while (current != null) {
            values[i++] = current.val;
            current = current.next;
        }
        left--;
        right--;
        if (isTest) {
            System.out.println("values: " + Arrays.toString(values) + "\nleft: " + left + "\nright: " + right);
            System.out.println("---------------------------------------------------------------------------------------");
        }

        while (left < right) {
            int temp = values[left];
            values[left++] = values[right];
            values[right--] = temp;
        }
        if (isTest) {
            System.out.println("values: " + Arrays.toString(values));
        }

        current = head;
        i = 0;
        while (current != null) {
            current.val = values[i++];
            current = current.next;
        }

        return head;
    }
}