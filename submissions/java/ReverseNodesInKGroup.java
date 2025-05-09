// Question: https://leetcode.com/problems/reverse-nodes-in-k-group/description/

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
class ReverseNodesInKGroup {
    private boolean isTest = false;

    public ListNode reverseKGroup(ListNode head, int k) {
        List<Integer> list = new ArrayList<>();
        ListNode current = head;

        while (current != null) {
            list.add(current.val);
            current = current.next;
        }
        if (isTest) {
            System.out.println("before, list: " + list + "\nk: " + k);
        }

        int len = list.size();
        for (int i = 0; i < len; i += k) {
            int start = i;
            int end = i + k - 1;
            if (isTest) {
                System.out.println(" * start: " + start + ", end: " + end);
            }
            if (start < len && end < len) {
                list = update(list, start, end);
            }
        }
        if (isTest) {
            System.out.println("after, list: " + list);
        }

        current = head;
        int i = 0;
        while (current != null) {
            current.val = list.get(i++);
            current = current.next;
        }

        return head;
    }

    private List<Integer> update(List<Integer> list, int start, int end) {
        List<Integer> result = new ArrayList<>();
        for (int number: list) {
            result.add(number);
        }
        int left = start;
        int right = end;
        while (left < right) {
            int temp = result.get(left);
            result.set(left, result.get(right));
            result.set(right, temp);
            left++;
            right--;
        }
        return result;
    }
}