// Question: https://leetcode.com/problems/find-minimum-in-rotated-sorted-array-ii/description/

class FindMinimumInRotatedSortedArrayTw {
    public int findMin(int[] nums) {
        // 1. Edge case: nums contains 1 element.
        if (nums.length == 1) {
            return nums[0];
        }

        int left = 0;
        int right = nums.length - 1;

        // 4 5 6 0 1 2 3
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > nums[right]) {
                left = mid + 1;
            } else if (nums[mid] < nums[right]) {
                right = mid;
            } else {
                /**
                 1.  All elements from [right + 1, nums.length - 1] are the same,
                     so exclude all elements after right + 1 by setting mid as right.
                 */
                right--;
            }
        }

        return nums[left];
    }
}