// Question: https://leetcode.com/problems/maximum-sum-of-distinct-subarrays-with-length-k/description/

class MaximumSumOfDistinctSubarraysWithLengthK {
    private boolean isTest = false;

    public long maximumSubarraySum(int[] nums, int k) {
        long maximumSum = 0;
        long runningSum = 0;
        Map<Integer, Integer> map = new HashMap<>();

        if (isTest) {
            System.out.println("nums: " + Arrays.toString(nums) + ", k: " + k);
            System.out.println("--------------------------");
        }

        for (int i = 0; i < k; i++) {
            int number = nums[i];
            runningSum += number;
            map.put(number, 1 + map.getOrDefault(number, 0));
        }
        if (map.size() == k) {
            maximumSum = runningSum;
        }
        if (isTest) {
            System.out.println("maximumSum so far: " + maximumSum);
            System.out.println("--------------------------");
        }

        for (int i = k; i < nums.length; i++) {
            int toRemove = nums[i - k];
            runningSum -= toRemove;
            map.put(toRemove, map.get(toRemove) - 1);
            if (map.get(toRemove) == 0) {
                map.remove(toRemove);
            }

            int toAdd = nums[i];
            runningSum += toAdd;
            map.put(toAdd, 1 + map.getOrDefault(toAdd, 0));

            if (map.size() == k) {
                maximumSum = Math.max(maximumSum, runningSum);
            }

            if (isTest) {
                System.out.println("maximumSum so far: " + maximumSum);
                System.out.println("--------------------------");
            }
        }

        if (isTest) {
            System.out.println("maximumSum: " + maximumSum);
        }
        return maximumSum;
    }
}