// Question: https://leetcode.com/problems/find-minimum-in-rotated-sorted-array-ii/description/

class FindMinimumInRotatedSortedArrayTwo {
    public int findMin(int[] nums) {
        // 1. Edge case: nums contains 1 element.
        if (nums.length == 1) {
            return nums[0];
        }

        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            // 1. Minimum is in range [mid + 1, right].
            if (nums[mid] > nums[right]) {
                left = mid + 1;
            // 2. Minimum is in range [left, mid].
            } else if (nums[mid] < nums[left]) {
                right = mid;

           /**
                3.  Duplicate detected.
                    Unsure on which range contains minimium,
                    so reduce right by 1 to reduce search range.
            */
            } else {
                right--;
            }
        }

        return nums[left];
    }
}