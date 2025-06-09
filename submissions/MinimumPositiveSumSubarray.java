// Question: https://leetcode.com/problems/minimum-positive-sum-subarray/description/

class MinimumPositiveSumSubarray {
    public int minimumSumSubarray(List<Integer> nums, int l, int r) {
        int minimumSumSubarray = Integer.MAX_VALUE;
        int len = nums.size();

        for (int i = 0; i < len; i++) {
            int currentSubarraySum = nums.get(i);
            int size = 1;
            if (currentSubarraySum > 0 && size >= l && size <= r) {
                minimumSumSubarray = Math.min(minimumSumSubarray, currentSubarraySum);
            }

            for (int j = i + 1; j < len; j++) {
                currentSubarraySum += nums.get(j);
                size++;
                if (currentSubarraySum > 0 && size >= l && size <= r) {
                    minimumSumSubarray = Math.min(minimumSumSubarray, currentSubarraySum);
                }
            }
        }

        return minimumSumSubarray == Integer.MAX_VALUE ? -1 : minimumSumSubarray;
    }
}