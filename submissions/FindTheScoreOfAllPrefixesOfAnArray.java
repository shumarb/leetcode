// Question: https://leetcode.com/problems/find-the-score-of-all-prefixes-of-an-array/description/

class FindTheScoreOfAllPrefixesOfAnArray {
    public long[] findPrefixScore(int[] nums) {
        boolean isTest = false;
        int index = 0;
        int n = nums.length;
        long[] prefix = new long[n];
        long[] result = new long[n];
        long maximum = 0;

        for (long e: nums) {
            if (e > maximum) {
                maximum = e;
            }
            prefix[index++] = e + maximum;
        }
        result[0] = prefix[0];
        for (int i = 1; i < n; i++) {
            result[i] = prefix[i] + result[i - 1];
        }
        if (isTest) {
            System.out.println("nums: " + Arrays.toString(nums) + "\nprefix: " + Arrays.toString(prefix) + "\nresult: " + Arrays.toString(result));
        }

        return result;
    }
}
