// Question: https://leetcode.com/problems/add-two-numbers/description/
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
class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        boolean isTest = false;

        String l1String = formsString(l1);
        String l2String = formsString(l2);
        String sum = computeSum(l1String, l2String);
        if (isTest) {
            System.out.println("l1String: " + l1String);
            System.out.println("l2String: " + l2String);
            System.out.println("sum: " + sum);
        }

        ListNode head = new ListNode(Character.getNumericValue(sum.charAt(0)));
        ListNode curr = head;
        for (int i = 1; i < sum.length(); i++) {
            ListNode newNode = new ListNode(Character.getNumericValue(sum.charAt(i)));
            curr.next = newNode;
            curr = curr.next;
        }

        return head;
    }

    private String computeSum(String firstString, String secondString) {
        StringBuilder result = new StringBuilder();
        int firstPointer = firstString.length() - 1;
        int secondPointer = secondString.length() - 1;
        int carryOver = 0;

        while (firstPointer >= 0 || secondPointer >= 0) {
            int firstStringDigit = firstPointer >= 0 ? Character.getNumericValue(firstString.charAt(firstPointer)) : 0;
            int secondStringDigit = secondPointer >= 0 ? Character.getNumericValue(secondString.charAt(secondPointer)) : 0;
            int sum = carryOver + firstStringDigit + secondStringDigit;
            if (sum < 9) {
                result.append(sum);
                carryOver = 0;
            } else {
                result.append(sum % 10);
                carryOver = sum / 10;
            }
            firstPointer--;
            secondPointer--;
        }

        if (carryOver != 0) {
            result.append(carryOver);
        }
        return result.toString();
    }

    private String formsString(ListNode list) {
        StringBuilder number = new StringBuilder();
        ListNode curr = list;
        while (curr != null) {
            number.append(curr.val);
            curr = curr.next;
        }
        return number.reverse().toString();
    }
}