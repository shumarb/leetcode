// Question: https://leetcode.com/problems/find-the-power-of-k-size-subarrays-i/description/

class FindThePowerOfKSizeSubarraysOne {
    private boolean isTest = false;

    public int[] resultsArray(int[] nums, int k) {
        int a = 0;
        int len = nums.length;
        int[] result = new int[len - k + 1];
        int[] window = new int[k];

        for (int i = 0; i <= len - k; i++) {
            int m = 0;
            window[m] = nums[i];
            for (int j = i; j < (i + k); j++) {
                window[m++] = nums[j];
            }
            if (isValidWindow(window)) {
                result[a++] = window[k - 1];
            } else {
                result[a++] = -1;
            }
        }

        if (isTest) {
            System.out.println("result: " + Arrays.toString(result));
        }

        return result;
    }

    private boolean isValidWindow(int[] window) {
        if (isTest) {
            System.out.println(" * window: " + Arrays.toString(window));
        }
        int previous = window[0];
        for (int i = 1; i < window.length; i++) {
            int current = window[i];
            if (current - previous != 1) {
                return false;
            }
            previous = current;
        }
        return true;
    }
}