// Question: https://leetcode.com/problems/intersection-of-two-linked-lists/description/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class IntersectionOfTwoLinkedLists {
    private ListNode intersectionNode = null;
    private boolean isIntersectionFound = false;

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        boolean isTest = false;

        if (isTest) {
            display("A: ", headA);
            display("B: ", headB);
        }

        ListNode current = headA;
        while (current != null) {
            check(current, headB);
            if (isIntersectionFound) {
                break;
            }
            current = current.next;
        }

        return intersectionNode;
    }

    private void check(ListNode check, ListNode head) {
        ListNode current = head;
        while (current != null) {
            if (check == current) {
                intersectionNode = current;
                isIntersectionFound = true;
                break;
            }
            current = current.next;
        }
    }

    private void display(String sentence, ListNode head) {
        System.out.print(sentence);
        ListNode current = head;
        while (current != null) {
            if (current.next == null) {
                System.out.println(current.val);
            } else {
                System.out.print(current.val + " --> ");
            }
            current = current.next;
        }
    }
}