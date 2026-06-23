// Question: https://leetcode.com/problems/smallest-stable-index-i/description/

class SmallestStableIndexI {
    public int firstStableIndex(int[] nums, int k) {
        boolean isTest = false;
        int n = nums.length;
        int i = 1;
        int j = n - 2;
        int[] prefix = new int[n];
        int[] suffix = new int[n];

        prefix[0] = nums[0];
        suffix[n - 1] = nums[n - 1];
        while (i < n && j >= 0) {
            prefix[i] = Math.max(nums[i], prefix[i++ - 1]);
            suffix[j] = Math.min(nums[j], suffix[j-- + 1]);
        }
        if (isTest) {
            System.out.println("prefix: " + Arrays.toString(prefix) + "\nnums:   " + Arrays.toString(nums) + "\nsuffix: " + Arrays.toString(suffix));
        }

        for (i = 0; i < n; i++) {
            if (prefix[i] - suffix[i] <= k) {
                if (isTest) {
                    System.out.println(" * result: " + i);
                }

                return i;
            }
        }

        return -1;
    }
}
