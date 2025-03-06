// Question: https://leetcode.com/problems/strictly-palindromic-number/description/

class StrictlyPalindromicNumber {
    public boolean isStrictlyPalindromic(int n) {
        for (int base = 2; base <= (n - 2); base++) {
            if (!isStrictlyPalindromicNumber(Integer.toString(n, base))) {
                return false;
            }
        }
        return true;
    }

    private boolean isStrictlyPalindromicNumber(String baseRepresentation) {
        int left = 0;
        int right = baseRepresentation.length() - 1;
        while (left < right) {
            if (baseRepresentation.charAt(left++) != baseRepresentation.charAt(right--)) {
                return false;
            }
        }
        return true;
    }
}