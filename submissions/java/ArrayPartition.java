// Question: https://leetcode.com/problems/array-partition/description/

class ArrayPartition {
    public int arrayPairSum(int[] nums) {
        // 1. Edge case: array with 1 element
        if (nums.length == 1) {
            return nums[0];
        }
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        boolean isTest = false;
        int maximisedSum = 0;

        for (int element: nums) {
            minHeap.offer(element);
        }
        if (isTest) {
            System.out.println("nums: " + Arrays.toString(nums) + "\nminHeap: " + minHeap);
        }

        while (!minHeap.isEmpty()) {
            maximisedSum += minHeap.poll();
            minHeap.poll();
        }
        return maximisedSum;
    }
}