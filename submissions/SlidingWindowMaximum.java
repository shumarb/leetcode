// Question: https://leetcode.com/problems/sliding-window-maximum/description/

class SlidingWindowMaximum {
    public int[] maxSlidingWindow(int[] nums, int k) {
        boolean isTest = false;
        int len = nums.length;
        int[] prefix = new int[len];
        int[] suffix = new int[len];
        int[] result = new int[len - k + 1];

        for (int i = 0; i < len; i++) {
            if (i % k == 0) {
                prefix[i] = nums[i];
            } else {
                prefix[i] = Math.max(prefix[i - 1], nums[i]);
            }
        }
        suffix[len - 1] = nums[len - 1];
        for (int i = len - 2; i >= 0; i--) {
            if ((i + 1) % k == 0) {
                suffix[i] = nums[i];
            } else {
                suffix[i] = Math.max(suffix[i + 1], nums[i]);
            }
        }

        for (int i = 0; i <= len - k; i++) {
            result[i] = Math.max(suffix[i], prefix[i + k - 1]);
        }
        if (isTest) {
            System.out.println("k: " + k + "\nnums:   " + Arrays.toString(nums));
            System.out.println("prefix: " + Arrays.toString(prefix) + "\nsuffix: " + Arrays.toString(suffix));
            System.out.println("result: " + Arrays.toString(result));
        }

        return result;
    }
}