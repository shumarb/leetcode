// Question: https://leetcode.com/problems/longest-arithmetic-subsequence-of-given-difference/description/

class LongestArithmeticSubsequenceOfGivenDifference {
    public int longestSubsequence(int[] arr, int difference) {
        boolean isTest = false;
        int largest = 0;
        int n = arr.length;
        int result = 0;
        int[] dp = new int[20001];

        if (isTest) {
            System.out.println("absolute difference: " + difference + "\n-----------------------------------------------");
        }
        for (int i = 0; i < n; i++) {
            int element = arr[i];
            int previous = arr[i] - difference;
            largest = Math.max(element, largest);

            if (previous >= -10000 && previous <= 10000) {
                dp[element + 10000] = 1 + dp[previous + 10000];
            } else {
                dp[element + 10000] = 1;
            }

            result = Math.max(dp[element + 10000], result);
        }
        if (isTest) {
            System.out.println("arr: " + Arrays.toString(arr) + "\ndp:  " + Arrays.toString(Arrays.copyOfRange(dp, 0, largest + 1)) + "\n\nresult: " + result);
        }

        return result;
    }
}
