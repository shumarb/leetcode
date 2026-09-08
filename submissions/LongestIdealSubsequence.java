// Question: https://leetcode.com/problems/longest-ideal-subsequence/description/

class LongestIdealSubsequence {
    public int longestIdealString(String s, int k) {
        boolean isTest = false;
        char[] letters = s.toCharArray();
        int[] dp = new int[26];
        int largestLetterIndex = 0;
        int result = 0;

        if (isTest) {
            System.out.println("s: " + s + "\nk: " + k + "\n----------------------------------------------");
        }
        for (int i = 0; i < letters.length; i++) {
            char letter = letters[i];
            int letterIndex = letter - 'a';
            int idealSubsequenceLength = 0;
            int minimumIndex = Math.max(0, letterIndex - k);
            int maximumIndex = Math.min(25, letterIndex + k);

            if (letterIndex > largestLetterIndex) {
                largestLetterIndex = letterIndex;
            }
            for (int j = minimumIndex; j <= maximumIndex; j++) {
                idealSubsequenceLength = Math.max(idealSubsequenceLength, dp[j] + 1);
            }

            dp[letterIndex] = Math.max(dp[letterIndex], idealSubsequenceLength);
            if (isTest) {
                System.out.println(" * idealSubsequenceLength ending @ index " + i + ": " + dp[letterIndex]);
            }

            result = Math.max(dp[letterIndex], result);
        }
        if (isTest) {
            System.out.println("----------------------------------------------\ndp: " + Arrays.toString(Arrays.copyOfRange(dp, 0, largestLetterIndex + 1)) + "\nresult: " + result);
        }

        return result;
    }
}
