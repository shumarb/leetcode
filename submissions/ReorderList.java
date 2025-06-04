// Question: https://leetcode.com/problems/reorder-list/description/

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
class ReorderList {
    public void reorderList(ListNode head) {
        // 1. Edge case: Linked list has 1 node.
        if (head.next != null) {
            ListNode current = head;
            Stack<ListNode> stack = new Stack<>();
            Queue<ListNode> queue = new LinkedList<>();
            boolean isTest = false;
            int count = 0;

            if (isTest) {
                display("before, list: ", head);
            }

            while (current != null) {
                count++;
                queue.offer(current);
                stack.push(current);
                current = current.next;
            }
            if (isTest) {
                System.out.println("count: " + count);
                System.out.print("stack: ");
                for (ListNode entry: stack) {
                    System.out.print(entry.val + " -> ");
                }
                System.out.println("null");
                System.out.print("queue: ");
                for (ListNode entry: queue) {
                    System.out.print(entry.val + " -> ");
                }
                System.out.println("null\n-----------------------------------------------------------");
            }

            ListNode[] nodes = new ListNode[count];
            for (int i = 0; i < count; i++) {
                if (i % 2 == 0) {
                    nodes[i] = queue.poll();
                } else {
                    nodes[i] = stack.pop();
                }
            }
            for (int i = 0; i < count - 1; i++) {
                nodes[i].next = nodes[i + 1];
            }
            head = nodes[0];
            nodes[count - 1].next = null;
            if (isTest) {
                display("after, list: ", head);
            }
        }
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
        System.out.println("-----------------------------------------------------------");
    }
}