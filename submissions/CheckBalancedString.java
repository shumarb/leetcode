// Question: https://leetcode.com/problems/check-balanced-string/description/

class CheckedBalancedString {
    public boolean isBalanced(String num) {
        int sumEven = 0;
        int sum = 0;

        for (int i = 0; i < num.length(); i++) {
            int digit = num.charAt(i) - '0';
            if (i % 2 == 0) {
                sumEven += digit;
            }
            sum += digit;
        }

        return sumEven == sum - sumEven;
    }
}