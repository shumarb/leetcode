// Question: https://leetcode.com/problems/minimum-distance-to-the-target-element/description/

class MinimumDistanceToTheTargetElement {
    public int getMinDistance(int[] nums, int target, int start) {
        int len = nums.length;
        int minimumDistance = Integer.MAX_VALUE;
        for (int i = 0; i < len; i++) {
            if (nums[i] == target) {
                minimumDistance = Math.min(minimumDistance, Math.abs(i - start));
            }
        }
        return minimumDistance;
    }
}