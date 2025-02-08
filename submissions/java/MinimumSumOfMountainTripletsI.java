// Question: https://leetcode.com/problems/minimum-sum-of-mountain-triplets-i/description/

class MinimumSumOfMountainTripletsI {
    public int minimumSum(int[] nums) {
        int len = nums.length;
        int minimumSum = Integer.MAX_VALUE;
        int[] prefix = new int[len];
        int[] suffix = new int[len];
        boolean isTest = false;

        /**
         prefix      [-1  8   6   1   1]
         nums:       [8   6   1   5   3]
         suffix:     [1   1   3   3  -1]
         */
        prefix[0] = suffix[len - 1] = -1;
        prefix[1] = nums[0];
        suffix[len - 2] = nums[len - 1];

        for (int i = 2; i < len; i++) {
            prefix[i] = Math.min(prefix[i - 1], nums[i - 1]);
        }
        for (int i = len - 3; i >= 0; i--) {
            suffix[i] = Math.min(suffix[i + 1], nums[i + 1]);
        }
        if (isTest) {
            System.out.println("prefix: " + Arrays.toString(prefix));
            System.out.println("nums:   " + Arrays.toString(nums));
            System.out.println("suffix: " + Arrays.toString(suffix));
        }

        for (int i = 0; i < len; i++) {
            if (prefix[i] != -1 && suffix[i] != -1 && prefix[i] < nums[i] && suffix[i] < nums[i]) {
                int currentSum = prefix[i] + nums[i] + suffix[i];
                minimumSum = Math.min(minimumSum, currentSum);
            }
        }

        return minimumSum == Integer.MAX_VALUE ? -1 : minimumSum;
    }
}