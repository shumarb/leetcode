// Question: https://leetcode.com/problems/search-in-rotated-sorted-array/description/

class SearchInRotatedSortedArray {
    public int search(int[] nums, int target) {
        boolean t = false;

        /**
            1. find index of minimum element
        */
        int index = findMinimum(nums);
        if (t) {
            System.out.println("index: " + index + ", minimum element: " + nums[index]);
        }

        /**
             2. check which partitition to search:
             [0, index - 1]
             [index, nums.length - 1]
         */
        int targetIndex = -1;
        if (target >= nums[index] && target <= nums[nums.length - 1]) {
            targetIndex = findTargetIndex(nums, index, nums.length - 1, target);
        } else {
            targetIndex = findTargetIndex(nums, 0, index - 1, target);
        }

        return targetIndex;
    }

    private int findTargetIndex(int[] arr, int start, int end, int target) {
        int low = start;
        int high = end;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] == target) {
                return mid;
            } else if (target < arr[mid]) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return -1;
    }

    private int findMinimum(int[] nums) {
        int low = 0;
        int high = nums.length - 1;
        while (low < high) {
            int mid = low + (high - low) / 2;

            /**
                 1. All elements from indices [mid, high]are sorted,
                 so discard all elements from [mid + 1, high]
                 because nums[mid] could be minimum
             */
            if (nums[mid] <= nums[high]) {
                high = mid;

            /**
                 2. All elements from indices [low, mid] are sorted,
                 so discard all elements from [low, mid] and check [mid + 1, high]
                 given we have regarded mid in earlier check as potential index
                 of minumum element
             */
            } else {
                low = mid + 1;
            }
        }
        return low;
    }
}