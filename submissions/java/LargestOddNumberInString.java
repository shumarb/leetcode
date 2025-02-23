// Question: https://leetcode.com/problems/largest-odd-number-in-string/description/

class LargestOddNumberInString {
    public String largestOddNumber(String num) {
        /**
         1.  Starting from last digit,
         traverse until odd digit encountered,
         so the answer is from first digit to this odd digit.
         */
        int indexOfLastOddDigit = 0;
        for (int i = num.length() - 1; i >= 0; i--) {
            char digit = num.charAt(i);
            if (isOddDigit(digit)) {
                return num.substring(0, i + 1);
            }
        }

        // 2. All digits in num are even.
        return "";
    }

    private boolean isOddDigit(char digit) {
        return digit == '1' || digit == '3' || digit == '5' || digit == '7' || digit == '9';
    }
}