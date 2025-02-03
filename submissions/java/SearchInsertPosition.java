// Question: https://leetcode.com/problems/search-insert-position/description/

class SearchInsertPosition {
    public int searchInsert(int[] nums, int target) {
        int l = 0;
        int h = nums.length - 1;
        while (l <= h) {
            int m = (l + h) / 2;
            if (nums[m] == target) {
                return m;
            } else if (nums[m] < target) {
                l++;
            } else {
                h--;
            }
        }
        if (target > nums[nums.length - 1]) {
            return nums.length;
        }
        return l;
    }
}