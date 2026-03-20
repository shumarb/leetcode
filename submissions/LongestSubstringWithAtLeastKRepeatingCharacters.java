// Question: https://leetcode.com/problems/longest-substring-with-at-least-k-repeating-characters/description/

class LongestSubstringWithAtLeastKRepeatingCharacters {
    public int longestSubstring(String s, int k) {
        boolean isTest = false;
        int n = s.length();
        int result = 0;

        for (int i = 0; i < n; i++) {
            int[] window = new int[26];
            for (int j = i; j < n; j++) {
                window[s.charAt(j) - 'a']++;

                int len = j - i + 1;
                if (len >= k && len > result && isValid(window, k)) {
                    if (isTest) {
                        System.out.println(" * valid: " + s.substring(i, j + 1));
                    }
                    result = len;
                }
            }
        }

        return result;
    }

    private boolean isValid(int[] window, int k) {
        for (int i = 0; i < window.length; i++) {
            if (window[i] == 0) {
                continue;
            }
            if (window[i] < k) {
                return false;
            }
        }

        return true;
    }
}
