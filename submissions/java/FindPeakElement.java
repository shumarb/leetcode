// Question: https://leetcode.com/problems/find-peak-element/description/

class FindPeakElement {
    public int findPeakElement(int[] nums) {
        int boundaryIndex = nums.length - 1;
        int low = 0;
        int high = nums.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (mid + 1 >= nums.length) {
                boundaryIndex = mid;
                high = mid - 1;
            } else {
                if (nums[mid] > nums[mid + 1]) {
                    boundaryIndex = mid;
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }

        }

        return boundaryIndex;
    }
}