// Question: https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/description/

class FindMinimumInRotatedSortedArray {
    public int findMin(int[] nums) {
        int low = 0;
        int high = nums.length - 1;

        while (low < high) {
            int mid = low + (high - low) / 2;

            /**
                 1.  All elements from indices [mid, high] are sorted in ascended order,
                 but element at index mid could be the minimum,
                 so discard all element from indices [mid + 1, high]
                 and check all element from indices [low, mid]
             */
            if (nums[mid] <= nums[high]) {
                high = mid;

            /**
                 2.  All numbers from indices [low, mid] sorted in ascending order,
                 so the minimum is not in indices [low, mid],
                 so discard all elements from [low, mid]
                 and check all element from indices [mid + 1, high]
             */
            } else {
                low = mid + 1;
            }
        }

        return nums[low];
    }
}