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
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        boolean isTest = false;

        int countA = countNodes(headA);
        int countB = countNodes(headB);

        if (isTest) {
            System.out.println("countA: " + countA + "\ncountB: " + countB);
            displayList("A: ", headA);
            displayList("B: ", headB);
        }

        if (countA != countB) {
            if (countA > countB) {
                headA = adjustHead(headA, countA - countB);
            } else {
                headB = adjustHead(headB, countB - countA);
            }
            if (isTest) {
                System.out.println("headA: " + headA.val + "\nheadB: " + headB.val);
            }
        }

        return findIntersection(headA, headB);
    }

    private ListNode adjustHead(ListNode head, int count) {
        ListNode current = head;
        while (count-- != 0) {
            current = current.next;
        }
        return current;
    }

    private ListNode findIntersection(ListNode headA, ListNode headB) {
        ListNode currentA = headA;
        ListNode currentB = headB;
        while (currentA != null && currentB != null) {
            if (currentA == currentB) {
                return currentA;
            }
            currentA = currentA.next;
            currentB = currentB.next;
        }

        return null;
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

    private void displayList(String sentence, ListNode head) {
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