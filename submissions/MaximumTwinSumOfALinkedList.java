// Question: https://leetcode.com/problems/maximum-twin-sum-of-a-linked-list/description/

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
class MaximumTwinSumOfALinkedList {
    public int pairSum(ListNode head) {
        List<ListNode> list = new ArrayList<>();
        ListNode current = head;
        boolean isTest = false;
        int result = 0;
        int i = 0;
        int j;

        while (current != null) {
            list.add(current);
            current = current.next;
        }
        if (isTest) {
            System.out.print("list: ");
            for (ListNode e: list) {
                System.out.print(e.val + " ");
            }
            System.out.println("\n---------------------------");
        }

        j = list.size() - 1;
        while (i < j) {
            int left = list.get(i).val;
            int right = list.get(j).val;
            if (isTest) {
                System.out.println(" * i: " + i + " -> left: " + left);
                System.out.println(" * j: " + j + " -> right: " + right);
                System.out.println(" compare | sum: " + (left + right) + ", result: " + result);
                System.out.println("---------------------------");
            }
            result = Math.max(result, left + right);
            i++;
            j--;
        }
        if (isTest) {
            System.out.println("result: " + result);
        }

        return result;
    }
}