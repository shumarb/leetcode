// Question: https://leetcode.com/problems/find-the-smallest-balanced-index/description/

class FindTheSmallestBalancedIndex {
    public int smallestBalancedIndex(int[] nums) {
        boolean isTest = false;
        int n = nums.length;
        long[] suffixProduct = new long[n];
        long prefixSum = 0;
        long sum = 0;

        for (long e: nums) {
            sum += e;
        }
        suffixProduct[n - 1] = 1;
        for (int i = n - 2; i >= 0; i--) {
            if (suffixProduct[i + 1] > (sum / nums[i + 1])) {
                suffixProduct[i] = sum + 1;
            } else {
                suffixProduct[i] = nums[i + 1] * suffixProduct[i + 1];
            }
        }
        if (isTest) {
            System.out.println("suffixProduct: " + Arrays.toString(suffixProduct));
        }

        for (int i = 0; i < n; i++) {
            if (prefixSum == suffixProduct[i]) {
                return i;
            }
            prefixSum += (long) nums[i];
        }

        return -1;
    }
}