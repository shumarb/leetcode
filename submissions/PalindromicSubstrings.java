// Question: https://leetcode.com/problems/palindromic-substrings/description/

class PalindromicSubstrings {
    public int countSubstrings(String s) {
        boolean isTest = false;
        int countTotalSubstrings = 0;

        for (int i = 0; i < s.length(); i++) {
            StringBuilder current = new StringBuilder();
            current.append(s.charAt(i));
            if (isTest) {
                System.out.println(" ** palindrome: " + current.toString());
            }
            countTotalSubstrings++;
            for (int j = i + 1; j < s.length(); j++) {
                current.append(s.charAt(j));
                if (isPalindrome(current.toString())) {
                    if (isTest) {
                        System.out.println(" ** palindrome: " + current.toString());
                    }
                    countTotalSubstrings++;
                }
            }
        }

        return countTotalSubstrings;
    }

    private boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left++) != s.charAt(right--)) {
                return false;
            }
        }
        return true;
    }
}