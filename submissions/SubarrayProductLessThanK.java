// Question: https://leetcode.com/problems/subarray-product-less-than-k/description/

class SubarrayProductLessThanK {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        boolean isTest = false;
        int left = 0;
        int n = nums.length;
        int result = 0;
        long product = 1;

        // 1. Edge case: 0 positive product <= 1.
        if (k <= 1) {
            return 0;

        } else if (n == 1) {
            return nums[0] < k ? 1 : 0;
        }

        if (isTest) {
            System.out.println("k: " + k + "\nnums: " + Arrays.toString(nums));
            System.out.println("-------------------------------");
        }
        for (int right = 0; right < n; right++) {
            product *= nums[right];

            while (product >= k) {
                product /= nums[left++];
            }
            if (isTest) {
                System.out.println(" * index range: [" + left + ", " + right + "]"
                        + " | subarray: " + Arrays.toString(Arrays.copyOfRange(nums, left, right + 1))
                        + " | total subarrays: " + (right - left + 1));
            }

            result += (right - left + 1);
        }
        if (isTest) {
            System.out.println("-------------------------------\nresult: " + result);
        }

        return result;
    }
}
