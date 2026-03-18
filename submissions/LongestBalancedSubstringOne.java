// Question: https://leetcode.com/problems/longest-balanced-substring-i/description/

class LongestBalancedSubstringOne {
    public int longestBalanced(String s) {
        boolean isTest = false;
        int n = s.length();
        int result = 0;

        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                String sub = s.substring(i, j + 1);
                if (sub.length() > result && isBalanced(sub)) {
                    if (isTest) {
                        System.out.println(" * valid: " + sub);
                    }
                    result = sub.length();
                }
            }
        }

        return result;
    }

    private boolean isBalanced(String s) {
        int[] count = new int[26];
        int value = 0;

        for (char c: s.toCharArray()) {
            count[c - 'a']++;
        }

        for (int i = 0; i < count.length; i++) {
            if (count[i] > 0) {
                value = count[i];
                break;
            }
        }
        for (int i = 0; i < count.length; i++) {
            if (count[i] > 0 && count[i] != value) {
                return false;
            }
        }

        return true;
    }
}
