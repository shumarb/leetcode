// Question: https://leetcode.com/problems/maximum-product-pair-with-target-sum/description/

class MaximumProductPairWithTargetSum {
    public int[] maxProductPair(int[] nums, int target) {
        int[] result = new int[] {-1, -1};
        int n = nums.length;
        long maximumProduct = Long.MIN_VALUE;

        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                long first = nums[i];
                long second = nums[j];

                if (first != second && first + second == (long) target) {
                    long product = first * second;

                    if (product > maximumProduct) {
                        maximumProduct = product;
                        if (first > second) {
                            result[0] = i;
                            result[1] = j;
                        } else {
                            result[0] = j;
                            result[1] = i;
                        }
                    }
                }
            }
        }

        return result;
    }
}
