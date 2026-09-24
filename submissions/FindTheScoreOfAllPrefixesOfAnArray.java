// Question: https://leetcode.com/problems/find-the-score-of-all-prefixes-of-an-array/description/

class FindTheScoreOfAllPrefixesOfAnArray {
    public long[] findPrefixScore(int[] nums) {
        boolean isTest = false;
        int index = 0;
        int n = nums.length;
        long[] result = new long[n];
        long maximum = 0;
        long runningSum = 0;

        for (long e: nums) {
            if (e > maximum) {
                maximum = e;
            }
            result[index] = runningSum + e + maximum;
            runningSum = result[index++];
        }
        if (isTest) {
            System.out.println("nums: " + Arrays.toString(nums) + "\nresult: " + Arrays.toString(result));
        }

        return result;
    }
}
