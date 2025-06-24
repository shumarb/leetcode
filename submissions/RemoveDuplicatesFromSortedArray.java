// Question: https://leetcode.com/problems/remove-duplicates-from-sorted-array/description/

class RemoveDuplicatesFromSortedArray {
    public int removeDuplicates(int[] nums) {
        // 1. Edge case: array has 1 element.
        if (nums.length == 1) {
            return 1;
        }

        boolean isTest = false;
        int k = 1;

        if (isTest) {
            System.out.println("before, nums: " + Arrays.toString(nums));
        }
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i - 1]) {
                nums[k++] = nums[i];
            }
        }
        if (isTest) {
            System.out.println("after, nums: " + Arrays.toString(nums) + "\nk: " + k);
        }

        return k;
    }
}