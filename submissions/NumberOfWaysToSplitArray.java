// Question: https://leetcode.com/problems/number-of-ways-to-split-array/description/

class NumberOfWaysToSplitArray {
    public int waysToSplitArray(int[] nums) {
        boolean isTest = false;
        int n = nums.length;
        int result = 0;
        long sum = 0;
        long[] prefix = new long[n];
        long[] suffix = new long[n];

        for (int e: nums) {
            sum += e;
        }
        prefix[0] = nums[0];
        for (int i = 1; i < n; i++) {
            prefix[i] = nums[i] + prefix[i - 1];
        }
        for (int i = 0; i < n; i++) {
            suffix[i] = sum - prefix[i];
        }
        if (isTest) {
            System.out.println("prefix: " + Arrays.toString(prefix) + "\nnums:   " + Arrays.toString(nums) + "\nsuffix: " + Arrays.toString(suffix));
            System.out.println("--------------------------------");
        }
        for (int i = 0; i < n - 1; i++) {
            if (prefix[i] >= suffix[i]) {
                if (isTest) {
                    System.out.println(" * split @ index " + i);
                }
                result++;
            }
        }
        if (isTest) {
            System.out.println("--------------------------------\nresult: " + result);
        }

        return result;
    }
}
