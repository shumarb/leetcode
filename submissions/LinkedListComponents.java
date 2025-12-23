// Question: https://leetcode.com/problems/linked-list-components/description/

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
class LinkedListComponents {
    public int numComponents(ListNode head, int[] nums) {
        ListNode current = head;
        boolean[] isPresentInNums;
        boolean isTest = false;
        int largest = 0;
        int result = 0;

        for (int e: nums) {
            largest = Math.max(e, largest);
        }
        isPresentInNums = new boolean[largest + 1];
        for (int e: nums) {
            isPresentInNums[e] = true;
        }
        if (isTest) {
            System.out.println("isPresentInNums: " + Arrays.toString(isPresentInNums));
        }

        current = head;

        // 1. Edge case: list has 1 element.
        if (current.next == null) {
            return isPresentInNums[current.val] ? 1 : 0;
        }

        while (current != null) {
            if (isTest) {
                System.out.println("------------------------------------------------------\ncurrent: " + current.val);
            }

            if (current.val <= largest && isPresentInNums[current.val]) {
                while (current != null && current.val <= largest && isPresentInNums[current.val]) {
                    current = current.next;
                }
                result++;

            } else {
                current = current.next;
            }
        }
        if (isTest) {
            System.out.println("------------------------------------------------------\nresult: " + result);
        }

        return result;
    }
}