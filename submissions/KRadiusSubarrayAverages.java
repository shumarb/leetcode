// Question: https://leetcode.com/problems/k-radius-subarray-averages/description/

class KRadiusSubarrayAverages {
    public int[] getAverages(int[] nums, int k) {
        boolean isTest = false;
        int n = nums.length;
        int windowSize = 2 * k + 1;
        int[] result = new int[n];
        long runningSum = 0;

        Arrays.fill(result, -1);
        if (2 * k + 1 > n) {
            return result;
        }

        for (int i = 0; i < windowSize; i++) {
            runningSum += nums[i];
        }
        result[k] = (int) (runningSum / windowSize);

        for (int i = k + 1; i < n - k; i++) {
            int remove = nums[i - k - 1];
            int incoming = nums[i + k];
            if (isTest) {
                System.out.println("i: " + i + "\n * before, runningSum: " + runningSum + "\n * remove: " + remove + " @ index: " + (i - k));
                System.out.println(" * incoming: " + incoming + " @ index: " + (i + k));
            }
            runningSum -= remove;
            runningSum += incoming;
            result[i] = (int) (runningSum / windowSize);
            if (isTest) {
                System.out.println("* after, runningSum: " + runningSum);
                System.out.println("----------------------------------------------------------------");
            }
        }
        if (isTest) {
            System.out.println("runningSum: " + runningSum + "\nresult: " + Arrays.toString(result));
        }

        return result;
    }
}
