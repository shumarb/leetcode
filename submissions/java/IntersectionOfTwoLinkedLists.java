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

        int countA = countNodes(headA);
        int countB = countNodes(headB);

        if (isTest) {
            System.out.println("countA: " + countA + "\ncountB: " + countB);
            display("A: ", headA);
            display("B: ", headB);
        }

        if (countA == countB) {
            findIntersection(headA, headB);
        } else {
            if (countA > countB) {
                headA = adjustHead(headA, countA - countB);
            } else {
                headB = adjustHead(headB, countB - countA);
            }
            if (isTest) {
                System.out.println("headA: " + headA.val + "\nheadB: " + headB.val);
            }
            findIntersection(headA, headB);
        }

        return intersectionNode;
    }

    private ListNode adjustHead(ListNode head, int count) {
        ListNode current = head;
        for (int i = 0; i < count; i++) {
            current = current.next;
        }
        return current;
    }

    private void findIntersection(ListNode headA, ListNode headB) {
        ListNode currentA = headA;
        ListNode currentB = headB;
        while (currentA != null && currentB != null) {
            if (currentA == currentB) {
                intersectionNode = currentA;
                isIntersectionFound = true;
                break;
            }
            currentA = currentA.next;
            currentB = currentB.next;
        }
    }

    private int countNodes(ListNode head) {
        int count = 0;
        ListNode current = head;
        while (current != null) {
            count++;
            current = current.next;
        }
        return count;
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