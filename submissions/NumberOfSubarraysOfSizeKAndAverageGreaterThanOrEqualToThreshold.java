// Question: https://leetcode.com/problems/number-of-sub-arrays-of-size-k-and-average-greater-than-or-equal-to-threshold/description/

class NumberOfSubarraysOfSizeKAndAverageGreaterThanOrEqualToThreshold {
    public int numOfSubarrays(int[] arr, int k, int threshold) {
        double runningSum = 0;
        int count = 0;

        for (int i = 0; i < k; i++) {
            runningSum += (double) arr[i];
        }
        if ((runningSum / (double) k) >= (double) threshold) {
            count++;
        }

        for (int i = k; i < arr.length; i++) {
            double remove = (double) arr[i - k];
            runningSum -= remove;
            double incoming = (double) arr[i];
            runningSum += incoming;
            if ((runningSum / (double) k) >= (double) threshold) {
                count++;
            }
        }

        return count;
    }
}