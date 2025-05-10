// Question: https://leetcode.com/problems/remove-nodes-from-linked-list/description/

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
class RemoveNodesFromLinkedList {
    public ListNode removeNodes(ListNode head) {
        ListNode result = new ListNode(-1);
        ListNode current = head;
        boolean isTest = false;
        int count = 0;

        while (current != null) {
            count++;
            current = current.next;
        }

        int[] arr = new int[count];
        int[] suffix = new int[count];
        int i = 0;
        current = head;
        while (current != null) {
            arr[i++] = current.val;
            current = current.next;
        }
        suffix[count - 1] = arr[count - 1];
        for (i = count - 2; i >= 0; i--) {
            suffix[i] = Math.max(arr[i], suffix[i + 1]);
        }
        if (isTest) {
            display("list: ", head);
            System.out.println("arr:    " + Arrays.toString(arr));
            System.out.println("suffix: " + Arrays.toString(suffix));
            System.out.println("---------------------------------------------------------------------");
        }

        current = result;
        for (i = 0; i < count; i++) {
            if (arr[i] == suffix[i]) {
                ListNode incoming = new ListNode(arr[i]);
                current.next = incoming;
                current = current.next;
            }
        }
        if (isTest) {
            display("result: ", result.next);
        }

        return result.next;
    }

    private void display(String sentence, ListNode head) {
        System.out.print(sentence);
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val + " --> ");
            if (current.next == null) {
                System.out.println("null");
            }
            current = current.next;
        }
        System.out.println("---------------------------------------------------------------------");
    }
}