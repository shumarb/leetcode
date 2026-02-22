// Question: https://leetcode.com/problems/find-the-longest-semi-repetitive-substring/description/

class FindTheLongestSemiRepetitiveSubstring {
    public int longestSemiRepetitiveSubstring(String s) {
        boolean isTest = false;
        int n = s.length();
        int result = 0;

        for (int i = 0; i < n; i++) {
            if (isTest) {
                System.out.println("-----------------------------\ni: " + i);
            }
            for (int j = i; j < n; j++) {
                String sub = s.substring(i, j + 1);
                if (sub.length() > result && isSemiRepetitiveSubstring(sub)) {
                    if (isTest) {
                        System.out.println(" * valid: " + sub);
                    }
                    result = Math.max(sub.length(), result);
                }
            }
        }

        return result;
    }

    private boolean isSemiRepetitiveSubstring(String s) {
        int countAdjacentPairsWithSameDigit = 0;

        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == s.charAt(i - 1)) {
                if (++countAdjacentPairsWithSameDigit > 1) {
                    return false;
                }
            }
        }

        return true;
    }
}