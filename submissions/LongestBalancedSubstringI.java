// Question: https://leetcode.com/problems/longest-balanced-substring-i/description/

class LongestBalancedSubstringI {
    public int longestBalanced(String s) {
        boolean isTest = false;
        char[] letters = s.toCharArray();
        int n = s.length();
        int result = 0;

        for (int i = 0; i < n; i++) {
            int[] count = new int[26];
            int countDistinctLetters = 0;
            int maximumCount = 0;

            for (int j = i; j < n; j++) {
                char c = letters[j];
                if (++count[c - 'a'] == 1) {
                    ++countDistinctLetters;
                }

                maximumCount = Math.max(count[c - 'a'], maximumCount);

                int len = j - i + 1;
                if (countDistinctLetters * maximumCount == len) {
                    if (isTest) {
                        System.out.println(" * valid: " + s.substring(i, j + 1));
                    }
                    result = Math.max(len, result);
                }
            }
        }

        return result;
    }
}
