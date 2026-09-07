// Question: https://leetcode.com/problems/longest-arithmetic-subsequence-of-given-difference/description/

class LongestArithmeticSubsequenceOfGivenDifference {
    public int longestSubsequence(int[] arr, int difference) {
        Map<Integer, Integer> map = new HashMap<>();
        boolean isTest = false;
        int n = arr.length;
        int result = 0;
        int[] dp = new int[n];

        for (int i = 0; i < n; i++) {
            int element = arr[i];
            int complement = arr[i] - difference;

            if (map.containsKey(complement)) {
                dp[i] = 1 + map.get(complement);
            } else {
                dp[i] = 1;
            }

            map.put(element, dp[i]);
            result = Math.max(dp[i], result);
        }
        if (isTest) {
            System.out.println("difference: " + difference + "\nmap: " + map + "\n\narr: " + Arrays.toString(arr) + "\ndp:  " + Arrays.toString(dp) + "\n\nresult: " + result);
        }

        return result;
    }
}
