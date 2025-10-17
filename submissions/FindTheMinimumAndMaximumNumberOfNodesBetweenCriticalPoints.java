// Question: https://leetcode.com/problems/find-the-minimum-and-maximum-number-of-nodes-between-critical-points/description/

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
class FindTheMinimumAndMaximumNumberOfNodesBetweenCriticalPoints {
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        List<Integer> list = new ArrayList<>();
        List<Integer> indices = new ArrayList<>();
        ListNode current = head;
        boolean isTest = false;
        int[] result = new int[2];

        result[0] = Integer.MAX_VALUE;
        result[1] = Integer.MIN_VALUE;
        while (current != null) {
            list.add(current.val);
            current = current.next;
        }
        if (isTest) {
            System.out.println("list: " + list);
        }

        if (list.size() < 3) {
            return new int[] {-1, -1};
        }
        for (int i = 1; i < list.size() - 1; i++) {
            int previous = list.get(i - 1);
            int present = list.get(i);
            int next = list.get(i + 1);
            if (present > previous && present > next) {
                indices.add(i);
            }
            if (present < previous && present < next) {
                indices.add(i);
            }
        }

        if (indices.isEmpty()) {
            return new int[] {-1, -1};
        }
        Collections.sort(indices);
        result[1] = indices.get(indices.size() - 1) - indices.get(0);
        for (int i = 1; i < indices.size(); i++) {
            result[0] = Math.min(result[0], indices.get(i) - indices.get(i - 1));
        }
        if (isTest) {
            System.out.println("indices: " + indices + "\nresult: " + Arrays.toString(result));
        }

        return result[0] == Integer.MAX_VALUE || result[1] == Integer.MIN_VALUE ? new int[] {-1, -1} : result;
    }
}