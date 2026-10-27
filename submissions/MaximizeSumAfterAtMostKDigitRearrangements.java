// Question: https://leetcode.com/problems/maximize-sum-after-at-most-k-digit-rearrangements/description/

class MaximizeSumAfterAtMostKDigitRearrangements {
    public long maximizeSum(int[] nums, int k) {
        boolean isTest = false;
        int n = nums.length;
        long[] gain = new long[n];
        long result = 0;

        for (int i = 0; i < n; i++) {
            int[] count = new int[10];
            int complement = 0;
            int e = nums[i];

            result += e;
            while (e > 0) {
                count[e % 10]++;
                e /= 10;
            }
            for (int j = 9; j >= 0; j--) {
                while (count[j]-- > 0) {
                    complement = complement * 10 + j;
                }
            }
            gain[i] = complement - nums[i];
        }

        Arrays.sort(gain);
        if (isTest) {
            System.out.println("k: " + k + "\nnums: " + Arrays.toString(nums) + "\nsorted gain: " + Arrays.toString(gain) + "\nbefore, result: " + result);
            System.out.println("-----------------------------------");
        }

        for (int i = n - 1; i >= n - k; i--) {
            long toAdd = gain[i];

            if (isTest) {
                System.out.println(" * add gain: " + toAdd);
            }

            result += toAdd;
        }
        if (isTest) {
            System.out.println("-----------------------------------\nafter, result: " + result);
        }

        return result;
    }
}
