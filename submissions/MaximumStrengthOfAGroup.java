// Question: https://leetcode.com/problems/maximum-strength-of-a-group/description/

class MaximumStrengthOfAGroup {
    public long maxStrength(int[] nums) {
        // 1. Edge case: single element.
        if (nums.length == 1) {
            return nums[0];
        }

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        boolean isTest = false;
        int countPositives = 0;
        long result = 1;

        Arrays.sort(nums);
        for (int e: nums) {
            if (e > 0) {
                countPositives++;
                result *= ((long) e);
            } else if (e < 0) {
                minHeap.offer(e);
            }
        }
        if (isTest) {
            System.out.println("sorted nums: " + Arrays.toString(nums));
            System.out.println("countPositives: " + countPositives + "\nminHeap: " + minHeap);
        }

        // 2. Edge case: 0 positive numbers and <= 1 negative numbers, so answer is 0.
        if (countPositives == 0 && minHeap.size() <= 1) {
            return 0;
        }
        while (minHeap.size() > 1) {
            result *= minHeap.poll();
            result *= minHeap.poll();
        }
        if (isTest) {
            System.out.println("---------------------------\nresult: " + result);
        }

        return result;
    }
}