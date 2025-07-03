// Question: https://leetcode.com/problems/maximum-difference-between-adjacent-elements-in-a-circular-array/description/

class MaximumDifferenceBetweenAdjacentElementsInACircularArray {
    public int maxAdjacentDistance(int[] nums) {
        int len = nums.length;
        int maxAdjacentDistance = Math.abs(nums[len - 1] - nums[0]);

        for (int i = 0; i < len - 1; i++) {
            maxAdjacentDistance = Math.max(maxAdjacentDistance, Math.abs(nums[i] - nums[i + 1]));
        }

        return maxAdjacentDistance;
    }
}