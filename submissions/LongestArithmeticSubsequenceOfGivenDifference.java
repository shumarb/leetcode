// Question: https://leetcode.com/problems/longest-arithmetic-subsequence-of-given-difference/description/

class LongestArithmeticSubsequenceOfGivenDifference {
    public int longestSubsequence(int[] arr, int difference) {
        boolean isTest = false;
        int[] dp = new int[20001];
        int offset = 10000;
        int result = 0;

        for (int e: arr) {
            int previous = e - difference;
            dp[e + offset] = previous >= -offset && previous <= offset ? 1 + dp[previous + offset] : 1;
            result = Math.max(dp[e + offset], result);
        }
        if (isTest) {
            System.out.println("difference: " + difference + "\narr: " + Arrays.toString(arr) + "\n\ndp:");
            for (int e: arr) {
                System.out.println(" * " + e + ": " + dp[e + offset]);
            }
            System.out.println("\nresult: " + result);
        }

        return result;
    }
}