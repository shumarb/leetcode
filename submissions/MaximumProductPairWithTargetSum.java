// Question: https://leetcode.com/problems/maximum-product-pair-with-target-sum/description/

class MaximumProductAfterKIncrements {
    public int[] maxProductPair(int[] nums, int target) {
        int[] map = new int[201];
        int[] result = new int[] {-1, -1};
        int maximumProduct = Integer.MIN_VALUE;
        int offset = 100;

        Arrays.fill(map, -1);
        for (int i = 0; i < nums.length; i++) {
            int e = nums[i];
            int complement = target - e;

            if (e != complement && complement >= -100 && complement <= 100 && map[complement + 100] != -1) {
                int jIndex = map[complement + 100];
                int product = e * complement;

                if (product > maximumProduct) {
                    maximumProduct = product;

                    if (nums[jIndex] > nums[i]) {
                        result[0] = jIndex;
                        result[1] = i;

                    } else {
                        result[1] = jIndex;
                        result[0] = i;
                    }
                }
            }

            map[e + offset] = i;
        }

        return result;
    }
}
