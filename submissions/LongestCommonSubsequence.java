// Question: https://leetcode.com/problems/longest-common-subsequence/description/

class LongestCommonSubsequence {
    public int longestCommonSubsequence(String text1, String text2) {
        boolean isTest = false;
        char[] first = text1.toCharArray();
        char[] second = text2.toCharArray();
        int m = first.length;
        int n = second.length;
        int[][] dp = new int[m + 1][n + 1];

        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                dp[i][j] = first[i] == second[j]
                        ? 1 + dp[i + 1][j + 1]
                        : Math.max(dp[i + 1][j], dp[i][j + 1]);
            }
        }
        if (isTest) {
            System.out.println("first: " + Arrays.toString(first) + "\nsecond: " + Arrays.toString(second) + "\n\ndp:");
            for (int[] row: dp) {
                System.out.println(Arrays.toString(row));
            }
        }

        return dp[0][0];
    }
}
