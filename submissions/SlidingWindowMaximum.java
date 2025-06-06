// Question: https://leetcode.com/problems/sliding-window-maximum/description/

class SlidingWindowMaximum {
    public int[] maxSlidingWindow(int[] nums, int k) {
        boolean isTest = false;
        int n = nums.length;
        int[] prefix = new int[n];
        int[] suffix = new int[n];
        int[] result = new int[n - k + 1];

        for (int i = 0; i < n; i++) {
            if (i % k == 0) {
                prefix[i] = nums[i];
            } else {
                prefix[i] = Math.max(prefix[i - 1], nums[i]);
            }
        }
        for (int i = n - 1; i >= 0; i--) {
            // 1. For last elements and elements that are the start of each k-sized window.
            if (i == n - 1 || (i + 1) % k == 0) {
                suffix[i] = nums[i];
            } else {
                suffix[i] = Math.max(suffix[i + 1], nums[i]);
            }
        }

        for (int i = 0; i <= n - k; i++) {
            result[i] = Math.max(suffix[i], prefix[i + k - 1]);
        }
        if (isTest) {
            System.out.println("k: " + k + "\nnums:   " + Arrays.toString(nums));
            System.out.println("prefix: " + Arrays.toString(prefix) + "\nsuffix: " + Arrays.toString(suffix));
        }

        if (isTest) {
            System.out.println("result: " + Arrays.toString(result));
        }

        return result;
    }
}
