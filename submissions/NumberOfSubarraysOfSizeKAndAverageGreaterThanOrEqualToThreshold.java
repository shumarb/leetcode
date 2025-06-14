// Question: https://leetcode.com/problems/number-of-sub-arrays-of-size-k-and-average-greater-than-or-equal-to-threshold/description/

class NumberOfSubarraysOfSizeKAndAverageGreaterThanOrEqualToThreshold {
    public int numOfSubarrays(int[] arr, int k, int threshold) {
        int count = 0;
        int runningSum = 0;

        for (int i = 0; i < k; i++) {
            runningSum += arr[i];
        }
        if (runningSum >= k * threshold) {
            count++;
        }
        for (int i = k; i < arr.length; i++) {
            runningSum += (arr[i] - arr[i - k]);
            if (runningSum >= k * threshold) {
                count++;
            }
        }

        return count;
    }
}