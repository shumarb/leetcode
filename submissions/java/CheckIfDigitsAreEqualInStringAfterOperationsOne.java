// Question: https://leetcode.com/problems/check-if-digits-are-equal-in-string-after-operations-i/description/

class CheckIfDigitsAreEqualInStringAfterOperationsOne {
    public boolean hasSameDigits(String s) {
        StringBuilder result = new StringBuilder();
        for (char digit: s.toCharArray()) {
            result.append(digit);
        }

        while (result.length() != 2) {
            StringBuilder newString = new StringBuilder();
            for (int i = 0; i < result.length() - 1; i++) {
                int first = result.charAt(i) - '0';
                int second = result.charAt(i + 1) - '0';
                newString.append((first + second) % 10);
            }
            result = newString;
        }

        return result.charAt(0) == result.charAt(1);
    }
}