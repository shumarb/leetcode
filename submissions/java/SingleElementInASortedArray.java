// Question: https://leetcode.com/problems/single-element-in-a-sorted-array/description/

class SingleElementInASortedArray {
    public int singleNonDuplicate(int[] nums) {
        // 1. Edge case: single element
        if (nums.length == 1) {
            return nums[0];
        }

        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;

            // 2. Ensure mid is the start index of a pair.
            if (mid % 2 == 1) {
                mid--;
            }

            /**
             3.  A pair of elements with same value found,
             so proceed to start of next pair.
             */
            if (nums[mid] == nums[mid + 1]) {
                left = mid + 2;
            } else {
                // 4. Single element is in indices [left, mid]
                right = mid;
            }
        }

        return nums[left];
    }
}