// Question: https://leetcode.com/problems/search-insert-position/description/

class SearchInsertPosition {
    public int searchInsert(int[] nums, int target) {
        // 1. If target > last element, it's insert position is at index nums.length
        if (target > nums[nums.length - 1]) {
            return nums.length;
        }

        int low = 0;
        int high = nums.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return low;
    }
}