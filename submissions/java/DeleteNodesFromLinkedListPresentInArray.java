// Question: https://leetcode.com/problems/delete-nodes-from-linked-list-present-in-array/description/

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
class DeleteNodesFromLinkedListPresentInArray {
    public ListNode modifiedList(int[] nums, ListNode head) {
        boolean isTest = false;

        int maximum = findMaximum(nums, head);
        boolean[] isNumberToBeRemoved = new boolean[maximum + 1];
        for (int number: nums) {
            isNumberToBeRemoved[number] = true;
        }
        if (isTest) {
            System.out.println("isNumberToBeRemoved: " + Arrays.toString(isNumberToBeRemoved));
            display("before: ", head);
            System.out.println("---------------------------------------------------------");
        }

        ListNode current = head;
        while (isNumberToBeRemoved[current.val]) {
            current = current.next;
        }
        head = current;

        current = head;
        while (current != null) {
            while (current.next != null && isNumberToBeRemoved[current.next.val]) {
                if (isTest) {
                    System.out.println("current: " + current.val + ", to be removed (next): " + current.next.val);
                    display(" * before removal: ", head);
                }
                current.next = current.next.next;
                if (isTest) {
                    display(" * after removal: ", head);
                    System.out.println("---------------------------------------------------------");
                }
            }
            current = current.next;
        }
        if (isTest) {
            display("after: ", head);
            System.out.println("---------------------------------------------------------");
        }

        return head;
    }

    private int findMaximum(int[] nums, ListNode head) {
        int maximum = 0;
        for (int number: nums) {
            maximum = Math.max(number, maximum);
        }
        ListNode current = head;
        while (current != null) {
            maximum = Math.max(maximum, current.val);
            current = current.next;
        }
        return maximum;
    }

    private void display(String sentence, ListNode head) {
        System.out.print(sentence);
        ListNode current = head;
        while (current != null) {
            if (current.next != null) {
                System.out.print(current.val + " --> ");
            } else {
                System.out.println(current.val);
            }
            current = current.next;
        }
    }
}