// Question: https://leetcode.com/problems/strictly-palindromic-number/description/

class StrictlyPalindromicNumber {
    public boolean isStrictlyPalindromic(int n) {
        for (int base = 2; base <= (n - 2); base++) {
            if (!isStrictlyPalindromicNumber(n, base)) {
                return false;
            }
        }
        return true;
    }

    private boolean isStrictlyPalindromicNumber(int number, int base) {
        boolean isTest = false;
        StringBuilder result = new StringBuilder();
        while (number != 0) {
            result.append(number % base);
            number /= base;
        }
        if (isTest) {
            System.out.println("base: " + base + ", result: " + result);
        }
        int left = 0;
        int right = result.length() - 1;
        String str = result.toString();
        while (left < right) {
            if (str.charAt(left++) != str.charAt(right--)) {
                return false;
            }
        }
        return true;
    }
}