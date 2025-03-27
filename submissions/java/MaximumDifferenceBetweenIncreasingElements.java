// Question: https://leetcode.com/problems/maximum-difference-between-increasing-elements/description/

class MaximumDifferenceBetweenIncreasingElements {
    public int maximumDifference(int[] nums) {
        long maximumDifference = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                maximumDifference = Math.max(maximumDifference, (long) nums[j] - (long) nums[i]);
            }
        }
        return maximumDifference == 0 ? -1 : (int) maximumDifference;
    }
}