// Question: https://leetcode.com/problems/compare-sums-of-bitonic-parts/description/

class CompareSumsOfBitonicParts {
    public int compareBitonicSums(int[] nums) {
        boolean isTest = false;
        int left = 0;
        int n = nums.length;
        int peakIndex = -1;
        int right = n - 1;
        long sumAscending = 0;
        long sumDescending = 0;

        while (left < right) {
            int mid = left + (right - left) / 2;

            // 1. Peak is after mid-th element [mid + 1, right]
            if (nums[mid] < nums[mid + 1]) {
                peakIndex = mid + 1;
                left = mid + 1;

                // 2. Peak is before mid-th element [mid, right];
            } else if (nums[mid] > nums[mid + 1]) {
                peakIndex = mid;
                right = mid;
            }
        }
        for (int i = 0; i <= peakIndex; i++) {
            sumAscending += nums[i];
        }
        for (int i = peakIndex; i < n; i++) {
            sumDescending += nums[i];
        }
        if (isTest) {
            System.out.println("peakIndex: " + peakIndex + "\nsumAscending: " + sumAscending + "\nsumDescending: " + sumDescending);
        }

        if (sumAscending == sumDescending) {
            return -1;
        }

        return sumAscending > sumDescending ? 0 : 1;
    }
}
