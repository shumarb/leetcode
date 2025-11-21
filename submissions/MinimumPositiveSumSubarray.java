// Question: https://leetcode.com/problems/minimum-positive-sum-subarray/description/

class MinimumPositiveSumSubarray {
    public int minimumSumSubarray(List<Integer> nums, int l, int r) {
        int result = Integer.MAX_VALUE;

        for (int windowSize = l; windowSize <= r; windowSize++) {
            int sum = 0;

            for (int i = 0; i < windowSize; i++) {
                sum += nums.get(i);
            }
            if (sum > 0) {
                result = Math.min(result, sum);
            }

            for (int i = windowSize; i < nums.size(); i++) {
                sum -= nums.get(i - windowSize);
                sum += nums.get(i);
                if (sum > 0) {
                    result = Math.min(result, sum);
                }
            }
        }

        return result == Integer.MAX_VALUE ? -1 : result;
    }
}