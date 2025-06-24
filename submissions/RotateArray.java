// Question: https://leetcode.com/problems/rotate-array/description/

class RotateArray {
    public void rotate(int[] nums, int k) {
        boolean isTest = false;
        int left = 0;
        int len = nums.length;
        int right = len - 1;

        if (isTest) {
            System.out.println("k: " + k + "\nbefore, nums: " + Arrays.toString(nums));
        }

        // 1. Eliminate redundant rotations.
        k %= len;
        reverse(0, len - 1, nums);
        reverse(0, k - 1, nums);
        reverse(k, len - 1, nums);
        if (isTest) {
            System.out.println("after, nums:  " + Arrays.toString(nums));
        }
    }

    private void reverse(int start, int end, int[] nums) {
        int left = start;
        int right = end;
        while (left < right) {
            int temp = nums[left];
            nums[left++] = nums[right];
            nums[right--] = temp;
        }
    }
}