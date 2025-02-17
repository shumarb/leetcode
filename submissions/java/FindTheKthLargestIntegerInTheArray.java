// Question: https://leetcode.com/problems/find-the-kth-largest-integer-in-the-array/description/

import java.math.BigInteger;

class Solution {
    public String kthLargestNumber(String[] nums, int k) {
        PriorityQueue<BigInteger> minHeap = new PriorityQueue<>();
        boolean isTest = false;

        for (int i = 0; i < nums.length; i++) {
            minHeap.offer(new BigInteger(nums[i]));
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }
        if (isTest) {
            System.out.println("minHeap: " + minHeap + " | k: " + k + " | kth largest: " + String.valueOf(minHeap.peek()));
        }

        return minHeap.peek().toString();
    }
}