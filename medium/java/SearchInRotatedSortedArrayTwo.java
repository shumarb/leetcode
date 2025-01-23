// Question: https://leetcode.com/problems/search-in-rotated-sorted-array-ii/description/

class SearchInRotatedSortedArrayTwo {
    public boolean search(int[] nums, int target) {
        int minIndex = findMinIndex(nums);
        boolean t = false;
        if (t) {
            System.out.println("nums: " + Arrays.toString(nums));
            System.out.println("minIndex: " + minIndex + " | element: " + nums[minIndex]);
        }

        if (isTargetPresent(0, minIndex - 1, nums, target)) {
            return true;
        }
        return isTargetPresent(minIndex, nums.length - 1, nums, target);
    }

    private boolean isTargetPresent(int low, int high, int[] n, int target) {
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (n[mid] == target) {
                return true;
            }

            // 1. Ensure both low and high pointers
            // point to elements of different values
            if (n[low] == n[mid]) {
                low++;
            } else if (n[mid] == n[high]) {
                high--;

            // 2. Left half is sorted, so check if target is in it
            } else if (n[low] <= n[mid]) {
                // 2.1. target is between elements at indices [low, mid - 1]
                if (n[low] <= target && target < n[mid]) {
                    high = mid - 1;

                // 2.2. target is between elements at indices [mid + 1, high]
                } else {
                    low = mid + 1;
                }

            // 3. Right half sorted, so check if target is in it
            } else {
                // 3.1. target is between elements at indices [mid + 1, high]
                if (n[mid] <= target && target < n[high]) {
                    low = mid + 1;

                // 3.2. target is between elements at indices [low, mid - 1]
                } else {
                    high = mid - 1;
                }
            }
        }

        return false;
    }

    private int findMinIndex(int[] n) {
        int low = 0;
        int high = n.length - 1;

        while (low < high) {
            int mid = low + (high - low) / 2;
            if (n[low] <= n[high]) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }

        return low;
    }
}