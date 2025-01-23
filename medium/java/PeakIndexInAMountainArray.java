// Question:

class Solution {
    public int PeakIndexInAMountainArray(int[] arr) {

        /**
         goal: get left-most element greater than it's next element
         eg: [0 2 1 0] => ==  [f t t f], boolean values for arr[i] > arr[i + 1]
         ans: 1 (index of left-most element greater than its next)
         */

        int index = -1;
        int low = 1;
        int high = arr.length - 2;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] > arr[mid + 1]) {
                index = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return index;
    }
}