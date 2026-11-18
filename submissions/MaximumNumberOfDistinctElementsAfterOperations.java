// Question: https://leetcode.com/problems/maximum-number-of-distinct-elements-after-operations/description/

class MaximumNumberOfDistinctElementsAfterOperations {
    public int maxDistinctElements(int[] nums, int k) {
        int n = nums.length;
        int previous = Integer.MIN_VALUE;
        int result = 0;

        if (n == 1) {
            return 1;
        }

        Arrays.sort(nums);
        for (int i = 0; i < n; i++) {
            int e = nums[i];
            int value = Math.max(e - k, previous + 1);

            if (value <= e + k) {
                result++;
                previous = value;
            }
        }

        return result;
    }
}
