// Question: https://leetcode.com/problems/remove-duplicates-from-sorted-list-ii/description/

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
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return head;
        }
        Map<Integer, Integer> map = new HashMap<>();
        List<ListNode> list = new ArrayList<>();
        ListNode newHead = new ListNode(-1);
        ListNode current = head;
        boolean isTest = false;

        while (current != null) {
            map.put(current.val, 1 + map.getOrDefault(current.val, 0));
            current = current.next;
        }
        if (isTest) {
            System.out.println("map: " + map);
        }

        current = head;
        while (current != null) {
            if (map.get(current.val) == 1) {
                list.add(current);
            }
            current = current.next;
        }
        if (isTest) {
            System.out.println("list: " + list);
        }

        if (list.isEmpty()) {
            return newHead.next;
        }

        if (!list.isEmpty()) {
            newHead.next = list.get(0);
            list.get(list.size() - 1).next = null;
            for (int i = 0; i < list.size() - 1; i++) {
                list.get(i).next = list.get(i + 1);
            }
        }
        return newHead.next;
    }
}