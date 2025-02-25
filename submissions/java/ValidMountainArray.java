// Question: https://leetcode.com/problems/valid-mountain-array/description/

class ValidMountainArray {
    public boolean validMountainArray(int[] arr) {
        // 1. Array has < 3 elements, so it is not mountain array
        if (arr.length < 3) {
            return false;
        }

        int peakIndex = findPeakIndex(arr);
        boolean isTest = false;
        if (isTest) {
            System.out.println("arr: " + Arrays.toString(arr) + ", peakIndex: " + peakIndex);
        }

        // 2. No boundary index, so return false;
        if (peakIndex == -1) {
            return false;
        }

        return isStrictlyAscending(peakIndex, arr) && isStrictlyDescending(peakIndex, arr);
    }

    private boolean isStrictlyAscending(int indexLimit, int[] arr) {
        for (int i = 1; i <= indexLimit; i++) {
            if (arr[i] <= arr[i - 1]) {
                return false;
            }
        }
        return true;
    }

    private boolean isStrictlyDescending(int index, int[] arr) {
        for (int i = index; i < arr.length - 1; i++) {
            if (arr[i] <= arr[i + 1]) {
                return false;
            }
        }
        return true;
    }

    private int findPeakIndex(int[] arr) {
        int peakIndex = -1;
        /**
         3. Set low and high bounds to be second and second-last elements respectively
         as first and last elements are never the peak element.
         */
        int low = 1;
        int high = arr.length - 2;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            /**
             4.  Current element > its next element.
             It could be peak index, so take note of it,
             and repeat check in range [low, mid - 1].
             */
            if (arr[mid] > arr[mid + 1]) {
                peakIndex = mid;
                high = mid - 1;
            } else {
                /**
                 5.  Current element < its next element,
                 so it is not peak element.
                 Hence, check elements from range [mid + 1, high].
                 */
                low = mid + 1;
            }
        }

        return peakIndex;
    }
}