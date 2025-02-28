// Question: https://leetcode.com/problems/check-if-number-has-equal-digit-count-and-digit-value/description/

class CheckIfNumberHasEqualDigitCountAndEqualDigitValue {
    public boolean digitCount(String num) {
        int[] digitFrequency = new int[10];

        for (char digit: num.toCharArray()) {
            /**
             1.  Convert character to its integer value,
             and increase number of times it occurs in num by 1.
             */
            digitFrequency[digit - '0']++;
        }

        for (int i = 0; i < num.length(); i++) {
            /**
             2.  Return false if digit count != digit value.
             */
            int digit = num.charAt(i) - '0';
            if (digit != digitFrequency[i]) {
                return false;
            }
        }
        return true;
    }
}