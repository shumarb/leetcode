// Question: https://leetcode.com/problems/maximum-difference-between-increasing-elements/description/

class MaximumDifferenceBetweenIncreasingElements {
    public int maximumDifference(int[] nums) {
        long maximumDifference = 0;
        long minimum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            long current = nums[i];
            if (minimum < current) {
                maximumDifference = Math.max(maximumDifference, current - minimum);
            }
            if (current < minimum) {
                minimum = current;
            }
        }
        return maximumDifference == 0 ? -1 : (int) maximumDifference;
    }
}