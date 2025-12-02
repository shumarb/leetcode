// Question: https://leetcode.com/problems/sliding-subarray-beauty/description/

class SlidingSubarrayBeauty class Solution {
    public int[] getSubarrayBeauty(int[] nums, int k, int x) {
        boolean isTest = false;
        int j = 0;
        int n = nums.length;
        int[] count = new int[101];
        int[] result = new int[n - k + 1];

        for (int i = 0; i < k; i++) {
            count[nums[i] + 50]++;
        }
        result[j++] = compute(count, x);
        for (int i = k; i < n; i++) {
            count[nums[i - k] + 50]--;
            count[nums[i] + 50]++;
            result[j++] = compute(count, x);
        }
        if (isTest) {
            System.out.println("--------------------------------------------------------\nresult: " + Arrays.toString(result));
        }

        return result;
    }

    private int compute(int[] count, int x) {
        int k = 0;

        for (int i = 0; i < 50; i++) {
            if (count[i] > 0) {
                k += count[i];
                if (k >= x) {
                    return i - 50;
                }
            }
        }

        return 0;
    }
}