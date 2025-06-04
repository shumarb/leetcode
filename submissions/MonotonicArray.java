// Question: https://leetcode.com/problems/monotonic-array/description/

class MonotonicArray {
    public boolean isMonotonic(int[] nums) {
        if (nums.length == 1) {
            return true;
        }
        return isIncreasing(nums) || isDecreasing(nums);
    }

    private boolean isIncreasing(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] > nums[i + 1]) {
                return false;
            }
        }
        return true;
    }

    private boolean isDecreasing(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] < nums[i + 1]) {
                return false;
            }
        }
        return true;
    }
}