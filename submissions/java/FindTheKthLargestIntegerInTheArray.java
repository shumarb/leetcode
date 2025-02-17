// Question: https://leetcode.com/problems/find-the-kth-largest-integer-in-the-array/description/

import java.math.BigInteger;

class FindTheKthLargestIntegerInTheArray {
    public String kthLargestNumber(String[] nums, int k) {
        PriorityQueue<BigInteger> minHeap = new PriorityQueue<>();
        boolean isTest = false;

        for (int i = 0; i < k; i++) {
            minHeap.offer(new BigInteger(nums[i]));
        }
        for (int i = k; i < nums.length; i++) {
            BigInteger currentElement = new BigInteger(nums[i]);
            if (currentElement.compareTo(minHeap.peek()) > 0) {
                minHeap.poll();
                minHeap.offer(currentElement);
            }
        }
        if (isTest) {
            System.out.println("minHeap: " + minHeap + " | k: " + k + " | kth largest: " + String.valueOf(minHeap.peek()));
        }

        return minHeap.peek().toString();
    }
}