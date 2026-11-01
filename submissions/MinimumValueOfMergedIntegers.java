// Question: https://leetcode.com/problems/minimum-value-of-merged-integers/description/

class MinimumValueToGetPositiveStepByStepSum {
    public int minMergedInteger(int[] nums) {
        boolean isTest = false;
        int result = Integer.MAX_VALUE;

        if (isTest) {
            System.out.print("nums: " + Arrays.toString(nums) + "\n---------------------------------");
        }
        for (int i = 0; i < nums.length - 1; i += 2) {
            char[] nextDigits = Integer.toString(nums[i + 1]).toCharArray();
            int e = nums[i];
            int merged = e;
            int next = nums[i + 1];

            for (int j = 0; j < nextDigits.length; j++) {
                merged = 10 * merged + (int) (nextDigits[j] - '0');
            }
            if (isTest) {
                System.out.println("\ni: " + i + "\n * e: " + e + "\n * nextDigits: " + Arrays.toString(nextDigits) + "\n * merged: " + merged);
            }

            result = Math.min(merged, result);
        }
        if (isTest) {
            System.out.print("---------------------------------\nresult: " + result);
        }

        return result;
    }
}
