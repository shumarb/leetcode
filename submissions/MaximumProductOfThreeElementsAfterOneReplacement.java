// Question: https://leetcode.com/problems/maximum-product-of-three-elements-after-one-replacement/description/

class MaximumProductOfThreeElementsAfterOneReplacement {
    public long maxProduct(int[] nums) {
        boolean isTest = false;
        int limit = 100000;
        int n = nums.length;
        long result = 0l;
        long[] arr = new long[n];
        nums = sort(nums);

        for (int i = 0; i < n; i++) {
            arr[i] = (long) nums[i];
        }
        /**
         1. For all positive, compute product of largest 2 elements with limit.
         */
        result = arr[n - 1] * arr[n - 2] * limit;

        /**
         2. For all negative, compute product of smallest 2 elements with limit.
         */
        result = Math.max(result, arr[0] * arr[1] * limit);

        /**
         3. If combination of positive and negative elements of largest, smallest, and negative limit.
         */
        result = Math.max(result, arr[0] * arr[n - 1] * -limit);

        if (isTest) {
            System.out.println("nums: " + Arrays.toString(nums) + "\nresult: " + result);
        }

        return result;
    }

    private int[] sort(int[] arr) {
        int[] count = new int[200001];
        int j = 0;

        for (int e: arr) {
            count[e + 100000]++;
        }
        for (int i = 0; i < count.length; i++) {
            while (count[i]-- > 0) {
                arr[j++] = i - 100000;
            }
        }

        return arr;
    }
}
