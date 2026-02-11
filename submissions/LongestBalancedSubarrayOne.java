// Question: https://leetcode.com/problems/longest-balanced-subarray-i/description/

class LongestBalancedSubarrayOne {
    public int longestBalanced(int[] nums) {
        boolean isTest = false;
        int n = nums.length;
        int result = 0;

        // 1. Edge case: nums has 1 element.
        if (n == 1) {
            return 0;
        }

        for (int i = 0; i < n; i++) {
            if (isTest) {
                System.out.println("------------------------------------------\ni: " + i);
            }
            boolean[] isCounted = new boolean[100001];
            int countDistinctEven = 0;
            int countDistinctOdd = 0;

            for (int j = i; j < n; j++) {
                int e = nums[j];
                if (!isCounted[e]) {
                    if (e % 2 == 0) {
                        countDistinctEven++;
                    } else {
                        countDistinctOdd++;
                    }
                    isCounted[e] = true;
                }

                if (countDistinctEven == countDistinctOdd) {
                    if (isTest) {
                        System.out.println(" * valid: " + Arrays.toString(Arrays.copyOfRange(nums, i, j + 1)));
                    }
                    result = Math.max(result, j - i + 1);
                }
            }
        }

        return result;
    }
}