// Question: https://leetcode.com/problems/sum-of-absolute-differences-in-a-sorted-array/description/

class SumOfAbsoluteDifferencesInASortedArray {
    public int[] getSumAbsoluteDifferences(int[] nums) {
        boolean isTest = false;
        int n = nums.length;
        int[] prefix = new int[n];
        int[] result = new int[n];
        int[] suffix = new int[n];

        for (int i = 1; i < n; i++) {
            prefix[i] = nums[i - 1] + prefix[i - 1];
        }
        for (int i = n - 2; i >= 0; i--) {
            suffix[i] = nums[i + 1] + suffix[i + 1];
        }
        for (int i = 0; i < n; i++) {
            int left = nums[i] * i - prefix[i];
            int right = suffix[i] - nums[i] * (n - i - 1);
            result[i] = left + right;
        }
        if (isTest) {
            System.out.println("prefix: " + Arrays.toString(prefix) + "\nnums:   " + Arrays.toString(nums));
            System.out.println("suffix: " + Arrays.toString(suffix));
            System.out.println("----------------------------------------------\nresult: " + Arrays.toString(result));
        }

        return result;
    }
}