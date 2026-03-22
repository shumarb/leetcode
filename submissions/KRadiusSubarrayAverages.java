// Question: https://leetcode.com/problems/k-radius-subarray-averages/description/

class KRadiusSubarrayAverages {
    public int[] getAverages(int[] nums, int k) {
        int left = 0;
        int n = nums.length;
        int right = 2 * k + 1;
        int windowSize = 2 * k + 1;
        int[] result = new int[n];
        long sum = 0;

        Arrays.fill(result, -1);
        if (windowSize > n) {
            return result;
        }

        for (int i = 0; i < windowSize; i++) {
            sum += nums[i];
        }
        result[k] = (int) (sum / windowSize);

        for (int centerIndex = k + 1; centerIndex < n - k; centerIndex++) {
            sum -= nums[centerIndex - k - 1];
            sum += nums[centerIndex + k];
            result[centerIndex] = (int) (sum / windowSize);
        }

        return result;
    }
}
