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
    private ListNode head;
    private Random random;
    private int count;

    public LinkedListRandomNode(ListNode head) {
        random = new Random();
        this.head = head;
        countNodes(head);
    }

    private void countNodes(ListNode head) {
        ListNode current = head;
        while (current != null) {
            count++;
            current = current.next;
        }
    }

    public int getRandom() {
        ListNode current = head;
        int randomNumber = random.nextInt(count);
        for (int i = 0; i < randomNumber; i++) {
            current = current.next;
        }
        return current.val;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(head);
 * int param_1 = obj.getRandom();
 */