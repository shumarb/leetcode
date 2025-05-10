// Question: https://leetcode.com/problems/merge-nodes-in-between-zeros/description/

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
class MergeNodesInBetweenZeros {
    public ListNode mergeNodes(ListNode head) {
        ListNode newHead = new ListNode(-1);
        ListNode current = head;
        boolean isTest = false;
        int count = 0;

        while (current != null) {
            count++;
            current = current.next;
        }
        ListNode[] nodes = new ListNode[count];
        int i = 0;
        current = head;
        while (current != null) {
            nodes[i++] = current;
            current = current.next;
        }
        if (isTest) {
            display("nodes: ", head);
        }

        int len = nodes.length;
        List<Integer> list = new ArrayList<>();
        for (i = 0; i < len; i++) {
            if (nodes[i].val != 0) {
                continue;
            } else {
                int j = i + 1;
                int sum = 0;
                while (j < len && nodes[j].val != 0) {
                    sum += nodes[j++].val;
                }
                if (sum != 0) {
                    list.add(sum);
                }
            }
        }
        if (isTest) {
            System.out.println("list: " + list);
        }

        current = newHead;
        for (int value: list) {
            ListNode incoming = new ListNode(value);
            current.next = incoming;
            current = current.next;
        }
        if (isTest) {
            display("new list: ", newHead.next);
        }

        return newHead.next;
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
        System.out.println("--------------------------------------------------------------");
    }
}