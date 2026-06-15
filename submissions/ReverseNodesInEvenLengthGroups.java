// Question: https://leetcode.com/problems/reverse-nodes-in-even-length-groups/description/

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
class ReverseNodesInEvenLengthGroups {
    public ListNode reverseEvenLengthGroups(ListNode head) {
        if (head.next == null) {
            return head;
        }

        ListNode[] list = new ListNode[100001];
        ListNode current = head;
        boolean isTest = false;
        int groupSize = 1;
        int startIndex = 0;
        int totalNodes = 0;

        while (current != null) {
            list[totalNodes++] = current;
            current = current.next;
        }
        if (isTest) {
            printList("before: ", list, totalNodes);
        }

        while (startIndex < totalNodes) {
            int endIndex = Math.min(startIndex + groupSize - 1, totalNodes - 1);
            int length = endIndex - startIndex + 1;

            if (isTest) {
                System.out.println(" * group " + groupSize + ": [" + startIndex + ", " + endIndex + "], length: " + length);
            }
            if (length % 2 == 0) {
                swap(list, startIndex, endIndex);
            }

            startIndex += groupSize++;
        }
        if (isTest) {
            printList("----------------------------------------\nafter:  ", list, totalNodes);
        }

        return head;
    }

    private void printList(String s, ListNode[] list, int totalNodes) {
        System.out.print(s);
        for (int i = 0; i < totalNodes; i++) {
            System.out.print(list[i].val + " ");
        }
        System.out.println("\n----------------------------------------");
    }

    private void swap(ListNode[] list, int left, int right) {
        while (left < right) {
            int temp = list[left].val;
            list[left++].val = list[right].val;
            list[right--].val = temp;
        }
    }
}
