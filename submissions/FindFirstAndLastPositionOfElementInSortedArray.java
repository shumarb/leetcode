// Question: https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/description/

class FindFirstAndLastPositionOfElementInSortedArray {
    public int[] searchRange(int[] nums, int target) {
        int end = findIndex(nums, target, "end");
        int start = findIndex(nums, target, "start");

        return new int[] {start, end};
    }

    private int findIndex(int[] arr, int key, String type) {
        int index = -1;
        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] < key) {
                left = mid + 1;

            } else if (arr[mid] > key) {
                right = mid - 1;

            } else {
                index = mid;

                /**
                 1.  First instance of key may be before current element,
                     so check all elements in index range [left, mid - 1].
                 */
                if (type.equals("start")) {
                    right = mid - 1;

                } else {
                    /**
                     2.  Last instance of key may be after current element,
                         so check all elements in index range [mid + 1, right].
                     */
                    left = mid + 1;
                }
            }
        }

        return index;
    }
}