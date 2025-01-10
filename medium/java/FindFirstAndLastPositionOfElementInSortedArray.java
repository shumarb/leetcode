// Question: https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/description/

class FindFirstAndLastPositionOfElementInSortedArray {
    public int[] searchRange(int[] nums, int target) {
        int[] ans = new int[2];
        ans[0] = findIndex(nums, target, "start");
        ans[1] = findIndex(nums, target, "end");
        return ans;
    }

    private int findIndex(int[] n, int t, String s) {
        int index = -1;
        int low = 0;
        int high = n.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (n[mid] < t) {
                low = mid + 1;
            } else if (n[mid] > t) {
                high = mid - 1;
            } else {
                if (s.equals("start")) {
                    /**
                     current element == target
                     hence take note of it's index,
                     but this may not be left-most
                     hence reduce search range to [1, mid - 1]
                     */
                    index = mid;
                    high = mid - 1;
                } else {
                    /**
                     current element == target
                     hence take note of it's index,
                     but this may not be right-most
                     hence reduce search range to [mid + 1, nums.length - 1]
                     */
                    index = mid;
                    low = mid + 1;
                }
            }
        }
        return index;
    }
}