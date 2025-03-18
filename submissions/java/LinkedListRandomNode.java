// Question: https://leetcode.com/problems/linked-list-random-node/description/

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
class LinkedListRandomNode {
    private ListNode[] nodes;
    private Random random;
    private boolean isTest = false;

    public LinkedListRandomNode(ListNode head) {
        random = new Random();
        nodes = populate(head);
    }

    private ListNode[] populate(ListNode head) {
        ListNode[] nodes;
        ListNode current = head;
        int index = -1;

        while (current != null) {
            index++;
            current = current.next;
        }

        nodes = new ListNode[index + 1];
        index = 0;
        current = head;
        while (current != null) {
            nodes[index++] = current;
            current = current.next;
        }

        if (isTest) {
            display(nodes);
        }

        return nodes;
    }

    private void display(ListNode[] nodes) {
        System.out.println("nodes:");
        for (int i = 0; i < nodes.length - 1; i++) {
            System.out.print(nodes[i].val + " --> ");
        }
        System.out.println(nodes[nodes.length - 1].val);
    }

    public int getRandom() {
        // 1. List has 1 node, so return this node's value
        if (nodes.length == 1) {
            return nodes[0].val;
        }

        int index = random.nextInt(0, nodes.length);
        return nodes[index].val;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(head);
 * int param_1 = obj.getRandom();
 */