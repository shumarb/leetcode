// Question: https://leetcode.com/problems/compare-sums-of-bitonic-parts/description/

class CompareSumsOfBitonicParts {
    public int compareBitonicSums(int[] nums) {
        boolean isTest = false;
        int n = nums.length;
        int peak = nums[0];
        int peakIndex = 0;
        long sumAscending = 0;
        long sumDescending = 0;

        for (int i = 1; i < n; i++) {
            int element = nums[i];
            if (element > peak) {
                peak = element;
                peakIndex = i;
            }
        }
        for (int i = 0; i <= peakIndex; i++) {
            sumAscending += nums[i];
        }
        for (int i = peakIndex; i < n; i++) {
            sumDescending += nums[i];
        }
        if (isTest) {
            System.out.println("nums: " + Arrays.toString(nums) + "\npeakIndex: " + peakIndex + ": -> e: " + peak);
            System.out.println("sumAscending: " + sumAscending + "\nsumDescending: " + sumDescending);
        }

        if (sumAscending == sumDescending) {
            return -1;
        }

        return sumAscending > sumDescending ? 0 : 1;
    }
}
